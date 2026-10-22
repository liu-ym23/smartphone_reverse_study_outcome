package com.android.server.textservices;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.UserInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Slog;
import android.util.SparseArray;
import android.view.textservice.SpellCheckerInfo;
import android.view.textservice.SpellCheckerSubtype;
import com.android.internal.content.PackageMonitor;
import com.android.internal.inputmethod.SubtypeLocaleUtils;
import com.android.internal.textservice.ISpellCheckerService;
import com.android.internal.textservice.ISpellCheckerServiceCallback;
import com.android.internal.textservice.ISpellCheckerSession;
import com.android.internal.textservice.ISpellCheckerSessionListener;
import com.android.internal.textservice.ITextServicesManager;
import com.android.internal.textservice.ITextServicesSessionListener;
import com.android.internal.util.DumpUtils;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class TextServicesManagerService extends ITextServicesManager.Stub {
    private static final boolean DBG = false;
    private static final String TAG = null;
    private final Context mContext;
    private final Object mLock;
    private final TextServicesMonitor mMonitor;
    private final SparseArray<TextServicesData> mUserData;
    private final UserManager mUserManager;

    private static final class ISpellCheckerServiceCallbackBinder extends ISpellCheckerServiceCallback.Stub {
        private WeakReference<SpellCheckerBindGroup> mBindGroup;
        private final Object mCallbackLock;
        private WeakReference<SessionRequest> mRequest;

        ISpellCheckerServiceCallbackBinder(SpellCheckerBindGroup bindGroup, SessionRequest request) {
            this.mCallbackLock = new Object();
            Object r0 = this.mCallbackLock;
            monitor-enter(r0);
            this.mBindGroup = new WeakReference(bindGroup);     // Catch: Throwable -> L7
            this.mRequest = new WeakReference(request);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void onSessionCreated(ISpellCheckerSession newSession) {
            Object r0 = this.mCallbackLock;
            monitor-enter(r0);
        L15:
            th = move-exception;
            throw th;
        L5:
            if (this.mBindGroup == null) goto L17;
            if (this.mRequest == null) goto L17;
            SpellCheckerBindGroup group = this.mBindGroup.get();     // Catch: Throwable -> L15
            SessionRequest request = this.mRequest.get();     // Catch: Throwable -> L15
            this.mBindGroup = null;     // Catch: Throwable -> L15
            this.mRequest = null;     // Catch: Throwable -> L15
            monitor-exit(r0);     // Catch: Throwable -> L15
            if (group == null) goto L22;
            if (request == null) goto L23;
            group.onSessionCreated(newSession, request);
            return;
        L23:
            return;
        L22:
            return;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L15
        }
    }

    private static final class InternalDeathRecipients extends RemoteCallbackList<ISpellCheckerSessionListener> {
        private final SpellCheckerBindGroup mGroup;

        @Override // android.os.RemoteCallbackList
        public /* bridge */ /* synthetic */ void onCallbackDied(IInterface r1) {
            onCallbackDied((ISpellCheckerSessionListener) r1);
        }

        public InternalDeathRecipients(SpellCheckerBindGroup group) {
            this.mGroup = group;
        }

        public void onCallbackDied(ISpellCheckerSessionListener listener) {
            this.mGroup.removeListener(listener);
        }
    }

    private final class InternalServiceConnection implements ServiceConnection {
        private final String mSciId;
        private final HashMap<String, SpellCheckerBindGroup> mSpellCheckerBindGroups;
        final /* synthetic */ TextServicesManagerService this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmSciId, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m8507$$Nest$fgetmSciId(InternalServiceConnection r0) {
            return r0.mSciId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSpellCheckerBindGroups, reason: not valid java name */
        static /* bridge */ /* synthetic */ HashMap m8508$$Nest$fgetmSpellCheckerBindGroups(InternalServiceConnection r0) {
            return r0.mSpellCheckerBindGroups;
        }

        public InternalServiceConnection(TextServicesManagerService r1, String id, HashMap<String, SpellCheckerBindGroup> spellCheckerBindGroups) {
            this.this$0 = r1;
            this.mSciId = id;
            this.mSpellCheckerBindGroups = spellCheckerBindGroups;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            Object r0 = TextServicesManagerService.m8501$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            onServiceConnectedInnerLocked(name, service);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void onServiceConnectedInnerLocked(ComponentName name, IBinder service) {
            ISpellCheckerService spellChecker = ISpellCheckerService.Stub.asInterface(service);
            SpellCheckerBindGroup group = this.mSpellCheckerBindGroups.get(this.mSciId);
            if (group != null) goto L5;
            return;
        L5:
            if (this != SpellCheckerBindGroup.m8511$$Nest$fgetmInternalConnection(group)) goto L9;
            group.onServiceConnectedLocked(spellChecker);
            return;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            Object r0 = TextServicesManagerService.m8501$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            onServiceDisconnectedInnerLocked(name);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void onServiceDisconnectedInnerLocked(ComponentName name) {
            SpellCheckerBindGroup group = this.mSpellCheckerBindGroups.get(this.mSciId);
            if (group != null) goto L5;
            return;
        L5:
            if (this != SpellCheckerBindGroup.m8511$$Nest$fgetmInternalConnection(group)) goto L9;
            group.onServiceDisconnectedLocked();
            return;
        }
    }

    public static final class Lifecycle extends SystemService {
        private TextServicesManagerService mService;

        /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
        static /* bridge */ /* synthetic */ TextServicesManagerService m8509$$Nest$fgetmService(Lifecycle r0) {
            return r0.mService;
        }

        public Lifecycle(Context context) {
            super(context);
            this.mService = new TextServicesManagerService(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            LocalServices.addService(TextServicesManagerInternal.class, new AnonymousClass1(this));
            publishBinderService("textservices", this.mService);
        }

        @Override // com.android.server.SystemService
        public void onUserStopping(SystemService.TargetUser user) {
            this.mService.onStopUser(user.getUserIdentifier());
        }

        @Override // com.android.server.SystemService
        public void onUserUnlocking(SystemService.TargetUser user) {
            this.mService.onUnlockUser(user.getUserIdentifier());
        }
    }

    private static final class SessionRequest {
        public final Bundle mBundle;
        public final String mLocale;
        public final ISpellCheckerSessionListener mScListener;
        public final int mSupportedAttributes;
        public final ITextServicesSessionListener mTsListener;
        public final int mUid;

        SessionRequest(int uid, String locale, ITextServicesSessionListener tsListener, ISpellCheckerSessionListener scListener, Bundle bundle, int supportedAttributes) {
            this.mUid = uid;
            this.mLocale = locale;
            this.mTsListener = tsListener;
            this.mScListener = scListener;
            this.mBundle = bundle;
            this.mSupportedAttributes = supportedAttributes;
        }
    }

    private final class SpellCheckerBindGroup {
        private final String TAG;
        private boolean mConnected;
        private final InternalServiceConnection mInternalConnection;
        private final InternalDeathRecipients mListeners;
        private final ArrayList<SessionRequest> mOnGoingSessionRequests;
        private final ArrayList<SessionRequest> mPendingSessionRequests;
        private ISpellCheckerService mSpellChecker;
        HashMap<String, SpellCheckerBindGroup> mSpellCheckerBindGroups;
        private boolean mUnbindCalled;
        final /* synthetic */ TextServicesManagerService this$0;

        public static /* synthetic */ boolean $r8$lambda$dGLcFFyMY10tZN0gLxuO7brQUyE(IBinder r0, SessionRequest r1) {
            return lambda$removeListener$0(r0, r1);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmConnected, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8510$$Nest$fgetmConnected(SpellCheckerBindGroup r0) {
            return r0.mConnected;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmInternalConnection, reason: not valid java name */
        static /* bridge */ /* synthetic */ InternalServiceConnection m8511$$Nest$fgetmInternalConnection(SpellCheckerBindGroup r0) {
            return r0.mInternalConnection;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmListeners, reason: not valid java name */
        static /* bridge */ /* synthetic */ InternalDeathRecipients m8512$$Nest$fgetmListeners(SpellCheckerBindGroup r0) {
            return r0.mListeners;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOnGoingSessionRequests, reason: not valid java name */
        static /* bridge */ /* synthetic */ ArrayList m8513$$Nest$fgetmOnGoingSessionRequests(SpellCheckerBindGroup r0) {
            return r0.mOnGoingSessionRequests;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPendingSessionRequests, reason: not valid java name */
        static /* bridge */ /* synthetic */ ArrayList m8514$$Nest$fgetmPendingSessionRequests(SpellCheckerBindGroup r0) {
            return r0.mPendingSessionRequests;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSpellChecker, reason: not valid java name */
        static /* bridge */ /* synthetic */ ISpellCheckerService m8515$$Nest$fgetmSpellChecker(SpellCheckerBindGroup r0) {
            return r0.mSpellChecker;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUnbindCalled, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8516$$Nest$fgetmUnbindCalled(SpellCheckerBindGroup r0) {
            return r0.mUnbindCalled;
        }

        public SpellCheckerBindGroup(TextServicesManagerService r1, InternalServiceConnection connection) {
            this.this$0 = r1;
            this.TAG = SpellCheckerBindGroup.class.getSimpleName();
            this.mPendingSessionRequests = new ArrayList();
            this.mOnGoingSessionRequests = new ArrayList();
            this.mInternalConnection = connection;
            this.mListeners = new InternalDeathRecipients(this);
            this.mSpellCheckerBindGroups = InternalServiceConnection.m8508$$Nest$fgetmSpellCheckerBindGroups(connection);
        }

        public void onServiceConnectedLocked(ISpellCheckerService spellChecker) {
            if (this.mUnbindCalled == false) goto L5;
            return;
        L5:
            this.mSpellChecker = spellChecker;
            this.mConnected = true;
            int size = this.mPendingSessionRequests.size();     // Catch: RemoteException -> L9
            int i = 0;
        L7:
            if (i >= size) goto L11;
            SessionRequest request = this.mPendingSessionRequests.get(i);     // Catch: RemoteException -> L9
            this.mSpellChecker.getISpellCheckerSession(request.mLocale, request.mScListener, request.mBundle, request.mSupportedAttributes, new ISpellCheckerServiceCallbackBinder(this, request));     // Catch: RemoteException -> L9
            this.mOnGoingSessionRequests.add(request);     // Catch: RemoteException -> L9
            i = i + 1;     // Catch: RemoteException -> L9
            goto L7
        L11:
            this.mPendingSessionRequests.clear();     // Catch: RemoteException -> L9
        L14:
            cleanLocked();
            return;
        L13:
            removeAllLocked();
            goto L14
        }

        public void onServiceDisconnectedLocked() {
            this.mSpellChecker = null;
            this.mConnected = false;
        }

        public void removeListener(ISpellCheckerSessionListener listener) {
            Object r0 = TextServicesManagerService.m8501$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.mListeners.unregister(listener);     // Catch: Throwable -> L7
            final IBinder scListenerBinder = listener.asBinder();     // Catch: Throwable -> L7
            Predicate<SessionRequest> removeCondition = new TextServicesManagerService$SpellCheckerBindGroup$$ExternalSyntheticLambda0(scListenerBinder);     // Catch: Throwable -> L7
            this.mPendingSessionRequests.removeIf(removeCondition);     // Catch: Throwable -> L7
            this.mOnGoingSessionRequests.removeIf(removeCondition);     // Catch: Throwable -> L7
            cleanLocked();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ boolean lambda$removeListener$0(IBinder scListenerBinder, SessionRequest request) {
            if (request.mScListener.asBinder() != scListenerBinder) goto L5;
            return true;
        L5:
            return false;
        }

        private void cleanLocked() {
            if (this.mUnbindCalled == false) goto L6;
            return;
        L6:
            if (this.mListeners.getRegisteredCallbackCount() <= 0) goto L9;
            return;
        L9:
            if (this.mPendingSessionRequests.isEmpty() == true) goto L12;
            return;
        L12:
            if (this.mOnGoingSessionRequests.isEmpty() == true) goto L14;
            return;
        L14:
            String sciId = InternalServiceConnection.m8507$$Nest$fgetmSciId(this.mInternalConnection);
            SpellCheckerBindGroup cur = this.mSpellCheckerBindGroups.get(sciId);
            if (cur != this) goto L17;
            this.mSpellCheckerBindGroups.remove(sciId);
        L17:
            TextServicesManagerService.m8500$$Nest$fgetmContext(this.this$0).unbindService(this.mInternalConnection);
            this.mUnbindCalled = true;
        }

        public void removeAllLocked() {
            Slog.e(this.TAG, "Remove the spell checker bind unexpectedly.");
            int size = this.mListeners.getRegisteredCallbackCount();
            int i = size - 1;
        L3:
            if (i < 0) goto L5;
            this.mListeners.unregister(this.mListeners.getRegisteredCallbackItem(i));
            i = i - 1;
            goto L3
        L5:
            this.mPendingSessionRequests.clear();
            this.mOnGoingSessionRequests.clear();
            cleanLocked();
        }

        public void getISpellCheckerSessionOrQueueLocked(SessionRequest request) {
            if (this.mUnbindCalled == false) goto L5;
            return;
        L5:
            this.mListeners.register(request.mScListener);
            if (this.mConnected == true) goto L15;
            this.mPendingSessionRequests.add(request);
            return;
        L15:
            this.mSpellChecker.getISpellCheckerSession(request.mLocale, request.mScListener, request.mBundle, request.mSupportedAttributes, new ISpellCheckerServiceCallbackBinder(this, request));     // Catch: RemoteException -> L11
            this.mOnGoingSessionRequests.add(request);     // Catch: RemoteException -> L11
        L13:
            cleanLocked();
            return;
        L12:
            removeAllLocked();
            goto L13
        }

        void onSessionCreated(ISpellCheckerSession newSession, SessionRequest request) {
            Object r0 = TextServicesManagerService.m8501$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mUnbindCalled == false) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L11:
            if (this.mOnGoingSessionRequests.remove(request) == true) goto L20;
        L15:
            cleanLocked();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L20:
            request.mTsListener.onServiceConnected(newSession);     // Catch: Throwable -> L8 RemoteException -> L14
            goto L15
        }
    }

    private static class TextServicesData {
        private final Context mContext;
        private final ContentResolver mResolver;
        private final HashMap<String, SpellCheckerBindGroup> mSpellCheckerBindGroups;
        private final ArrayList<SpellCheckerInfo> mSpellCheckerList;
        private final HashMap<String, SpellCheckerInfo> mSpellCheckerMap;
        public int mUpdateCount;
        private final int mUserId;

        /* JADX INFO: renamed from: -$$Nest$fgetmSpellCheckerBindGroups, reason: not valid java name */
        static /* bridge */ /* synthetic */ HashMap m8517$$Nest$fgetmSpellCheckerBindGroups(TextServicesData r0) {
            return r0.mSpellCheckerBindGroups;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSpellCheckerList, reason: not valid java name */
        static /* bridge */ /* synthetic */ ArrayList m8518$$Nest$fgetmSpellCheckerList(TextServicesData r0) {
            return r0.mSpellCheckerList;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSpellCheckerMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ HashMap m8519$$Nest$fgetmSpellCheckerMap(TextServicesData r0) {
            return r0.mSpellCheckerMap;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUserId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8520$$Nest$fgetmUserId(TextServicesData r0) {
            return r0.mUserId;
        }

        /* JADX INFO: renamed from: -$$Nest$mdump, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8521$$Nest$mdump(TextServicesData r0, PrintWriter r1) {
            r0.dump(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$minitializeTextServicesData, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8522$$Nest$minitializeTextServicesData(TextServicesData r0) {
            r0.initializeTextServicesData();
        }

        public TextServicesData(int userId, Context context) {
            this.mUpdateCount = 0;
            this.mUserId = userId;
            this.mSpellCheckerMap = new HashMap();
            this.mSpellCheckerList = new ArrayList();
            this.mSpellCheckerBindGroups = new HashMap();
            this.mContext = context;
            this.mResolver = context.getContentResolver();
        }

        private void putString(String key, String str) {
            Settings.Secure.putStringForUser(this.mResolver, key, str, this.mUserId);
        }

        private String getString(String key, String defaultValue) {
            String result = Settings.Secure.getStringForUser(this.mResolver, key, this.mUserId);
            if (result == null) goto L6;
            return result;
        L6:
            return defaultValue;
        }

        private void putInt(String key, int value) {
            Settings.Secure.putIntForUser(this.mResolver, key, value, this.mUserId);
        }

        private int getInt(String key, int defaultValue) {
            return Settings.Secure.getIntForUser(this.mResolver, key, defaultValue, this.mUserId);
        }

        private boolean getBoolean(String r3, boolean r4) {
            if (getInt(r3, r4 ? 1 : 0) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        private void putSelectedSpellChecker(String sciId) {
            putString("selected_spell_checker", sciId);
        }

        private void putSelectedSpellCheckerSubtype(int hashCode) {
            putInt("selected_spell_checker_subtype", hashCode);
        }

        private String getSelectedSpellChecker() {
            return getString("selected_spell_checker", "");
        }

        public int getSelectedSpellCheckerSubtype(int defaultValue) {
            return getInt("selected_spell_checker_subtype", defaultValue);
        }

        public boolean isSpellCheckerEnabled() {
            return getBoolean("spell_checker_enabled", true);
        }

        public SpellCheckerInfo getCurrentSpellChecker() {
            String curSpellCheckerId = getSelectedSpellChecker();
            if (TextUtils.isEmpty(curSpellCheckerId) == false) goto L7;
            return null;
        L7:
            return this.mSpellCheckerMap.get(curSpellCheckerId);
        }

        public void setCurrentSpellChecker(SpellCheckerInfo sci) {
            if (sci == null) goto L4;
            putSelectedSpellChecker(sci.getId());
        L5:
            putSelectedSpellCheckerSubtype(0);
            return;
        L4:
            putSelectedSpellChecker("");
            goto L5
        }

        private void initializeTextServicesData() {
            this.mSpellCheckerList.clear();
            this.mSpellCheckerMap.clear();
            this.mUpdateCount++;
            PackageManager pm = this.mContext.getPackageManager();
            List<ResolveInfo> services = pm.queryIntentServicesAsUser(new Intent("android.service.textservice.SpellCheckerService"), 128, this.mUserId);
            int N = services.size();
            int i = 0;
        L3:
            if (i >= N) goto L20;
            ResolveInfo ri = services.get(i);
            ServiceInfo si = ri.serviceInfo;
            ComponentName compName = new ComponentName(si.packageName, si.name);
            if ("android.permission.BIND_TEXT_SERVICE".equals(si.permission) == true) goto L21;
            Slog.w(TextServicesManagerService.m8506$$Nest$sfgetTAG(), "Skipping text service " + compName + ": it does not require the permission android.permission.BIND_TEXT_SERVICE");
        L18:
            i = i + 1;
            goto L3
        L21:
            SpellCheckerInfo sci = new SpellCheckerInfo(this.mContext, ri);     // Catch: IOException -> L10 XmlPullParserException -> L12
            if (sci.getSubtypeCount() > 0) goto L14;
            Slog.w(TextServicesManagerService.m8506$$Nest$sfgetTAG(), "Skipping text service " + compName + ": it does not contain subtypes.");     // Catch: IOException -> L10 XmlPullParserException -> L12
            goto L18
        L14:
            this.mSpellCheckerList.add(sci);     // Catch: IOException -> L10 XmlPullParserException -> L12
            this.mSpellCheckerMap.put(sci.getId(), sci);     // Catch: IOException -> L10 XmlPullParserException -> L12
            goto L18
        L10:
            e = move-exception;
            Slog.w(TextServicesManagerService.m8506$$Nest$sfgetTAG(), "Unable to load the spell checker " + compName, e);
        L12:
            e = move-exception;
            Slog.w(TextServicesManagerService.m8506$$Nest$sfgetTAG(), "Unable to load the spell checker " + compName, e);
            goto L18
        }

        private void dump(PrintWriter pw) {
            int spellCheckerIndex = 0;
            pw.println("  User #" + this.mUserId);
            pw.println("  Spell Checkers:");
            pw.println("  Spell Checkers: mUpdateCount=" + this.mUpdateCount);
            Iterator<SpellCheckerInfo> r3 = this.mSpellCheckerMap.values().iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            SpellCheckerInfo info = r3.next();
            pw.println("  Spell Checker #" + spellCheckerIndex);
            info.dump(pw, "    ");
            spellCheckerIndex = spellCheckerIndex + 1;
            goto L4
        L6:
            pw.println("");
            pw.println("  Spell Checker Bind Groups:");
            HashMap<String, SpellCheckerBindGroup> spellCheckerBindGroups = this.mSpellCheckerBindGroups;
            Iterator<Map.Entry<String, SpellCheckerBindGroup>> r4 = spellCheckerBindGroups.entrySet().iterator();
        L8:
            if (r4.hasNext() == false) goto L20;
            Map.Entry<String, SpellCheckerBindGroup> ent = r4.next();
            SpellCheckerBindGroup grp = ent.getValue();
            pw.println("    " + ent.getKey() + " " + grp + ":");
            StringBuilder r8 = new StringBuilder();
            r8.append("      mInternalConnection=");
            r8.append(SpellCheckerBindGroup.m8511$$Nest$fgetmInternalConnection(grp));
            pw.println(r8.toString());
            pw.println("      mSpellChecker=" + SpellCheckerBindGroup.m8515$$Nest$fgetmSpellChecker(grp));
            pw.println("      mUnbindCalled=" + SpellCheckerBindGroup.m8516$$Nest$fgetmUnbindCalled(grp));
            pw.println("      mConnected=" + SpellCheckerBindGroup.m8510$$Nest$fgetmConnected(grp));
            int numPendingSessionRequests = SpellCheckerBindGroup.m8514$$Nest$fgetmPendingSessionRequests(grp).size();
            int j = 0;
        L11:
            if (j >= numPendingSessionRequests) goto L13;
            SessionRequest req = (SessionRequest) SpellCheckerBindGroup.m8514$$Nest$fgetmPendingSessionRequests(grp).get(j);
            StringBuilder r0 = new StringBuilder();
            r0.append("      Pending Request #");
            r0.append(j);
            r0.append(":");
            pw.println(r0.toString());
            pw.println("        mTsListener=" + req.mTsListener);
            pw.println("        mScListener=" + req.mScListener);
            pw.println("        mScLocale=" + req.mLocale + " mUid=" + req.mUid);
            j = j + 1;
            spellCheckerIndex = spellCheckerIndex;
            goto L11
        L13:
            int spellCheckerIndex2 = spellCheckerIndex;
            int numOnGoingSessionRequests = SpellCheckerBindGroup.m8513$$Nest$fgetmOnGoingSessionRequests(grp).size();
            int j2 = 0;
        L14:
            if (j2 >= numOnGoingSessionRequests) goto L16;
            SessionRequest req2 = (SessionRequest) SpellCheckerBindGroup.m8513$$Nest$fgetmOnGoingSessionRequests(grp).get(j2);
            StringBuilder r15 = new StringBuilder();
            r15.append("      On going Request #");
            r15.append(j2);
            r15.append(":");
            pw.println(r15.toString());
            pw.println("        mTsListener=" + req2.mTsListener);
            pw.println("        mScListener=" + req2.mScListener);
            pw.println("        mScLocale=" + req2.mLocale + " mUid=" + req2.mUid);
            j2 = j2 + 1;
            numOnGoingSessionRequests = numOnGoingSessionRequests;
            goto L14
        L16:
            int N = SpellCheckerBindGroup.m8512$$Nest$fgetmListeners(grp).getRegisteredCallbackCount();
            int j3 = 0;
        L17:
            if (j3 >= N) goto L19;
            ISpellCheckerSessionListener mScListener = SpellCheckerBindGroup.m8512$$Nest$fgetmListeners(grp).getRegisteredCallbackItem(j3);
            pw.println("      Listener #" + j3 + ":");
            StringBuilder r11 = new StringBuilder();
            r11.append("        mScListener=");
            r11.append(mScListener);
            pw.println(r11.toString());
            pw.println("        mGroup=" + grp);
            j3 = j3 + 1;
            goto L17
        L19:
            spellCheckerIndex = spellCheckerIndex2;
            goto L8
        }
    }

    private final class TextServicesMonitor extends PackageMonitor {
        final /* synthetic */ TextServicesManagerService this$0;

        /* synthetic */ TextServicesMonitor(TextServicesManagerService r1, TextServicesManagerServiceIA r2) {
            this(r1);
        }

        private TextServicesMonitor(TextServicesManagerService r1) {
            this.this$0 = r1;
        }

        public void onSomePackagesChanged() {
            int userId = getChangingUserId();
            Object r1 = TextServicesManagerService.m8501$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            TextServicesData tsd = (TextServicesData) TextServicesManagerService.m8502$$Nest$fgetmUserData(this.this$0).get(userId);     // Catch: Throwable -> L8
            if (tsd != null) goto L10;
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L10:
            SpellCheckerInfo sci = tsd.getCurrentSpellChecker();     // Catch: Throwable -> L8
            TextServicesData.m8522$$Nest$minitializeTextServicesData(tsd);     // Catch: Throwable -> L8
            if (tsd.isSpellCheckerEnabled() == true) goto L14;
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L14:
            if (sci != null) goto L16;
            SpellCheckerInfo sci2 = TextServicesManagerService.m8503$$Nest$mfindAvailSystemSpellCheckerLocked(this.this$0, null, tsd);     // Catch: Throwable -> L8
            TextServicesManagerService.m8505$$Nest$msetCurrentSpellCheckerLocked(this.this$0, sci2, tsd);     // Catch: Throwable -> L8
        L25:
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L16:
            String packageName = sci.getPackageName();     // Catch: Throwable -> L8
            int change = isPackageDisappearing(packageName);     // Catch: Throwable -> L8
            if (change != 3) goto L19;
        L20:
            SpellCheckerInfo availSci = TextServicesManagerService.m8503$$Nest$mfindAvailSystemSpellCheckerLocked(this.this$0, packageName, tsd);     // Catch: Throwable -> L8
            if (availSci != null) goto L23;
        L24:
            TextServicesManagerService.m8505$$Nest$msetCurrentSpellCheckerLocked(this.this$0, availSci, tsd);     // Catch: Throwable -> L8
            goto L25
        L23:
            if (availSci.getId().equals(sci.getId()) == true) goto L25;
        L19:
            if (change != 2) goto L25;
        L8:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m8500$$Nest$fgetmContext(TextServicesManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8501$$Nest$fgetmLock(TextServicesManagerService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserData, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m8502$$Nest$fgetmUserData(TextServicesManagerService r0) {
        return r0.mUserData;
    }

    /* JADX INFO: renamed from: -$$Nest$mfindAvailSystemSpellCheckerLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ SpellCheckerInfo m8503$$Nest$mfindAvailSystemSpellCheckerLocked(TextServicesManagerService r0, String r1, TextServicesData r2) {
        return r0.findAvailSystemSpellCheckerLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetCurrentSpellCheckerForUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ SpellCheckerInfo m8504$$Nest$mgetCurrentSpellCheckerForUser(TextServicesManagerService r0, int r1) {
        return r0.getCurrentSpellCheckerForUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetCurrentSpellCheckerLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8505$$Nest$msetCurrentSpellCheckerLocked(TextServicesManagerService r0, SpellCheckerInfo r1, TextServicesData r2) {
        r0.setCurrentSpellCheckerLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m8506$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = TextServicesManagerService.class.getSimpleName();
    }

    void onStopUser(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        TextServicesData tsd = this.mUserData.get(userId);     // Catch: Throwable -> L8
        if (tsd != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        unbindServiceLocked(tsd);     // Catch: Throwable -> L8
        this.mUserData.remove(userId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void onUnlockUser(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        initializeInternalStateLocked(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public TextServicesManagerService(Context context) {
        this.mUserData = new SparseArray();
        this.mLock = new Object();
        this.mContext = context;
        this.mUserManager = (UserManager) this.mContext.getSystemService(UserManager.class);
        this.mMonitor = new TextServicesMonitor(this, null);
        this.mMonitor.register(context, null, UserHandle.ALL, true);
    }

    private void initializeInternalStateLocked(int userId) {
        TextServicesData tsd = this.mUserData.get(userId);
        if (tsd != null) goto L5;
        tsd = new TextServicesData(userId, this.mContext);
        this.mUserData.put(userId, tsd);
    L5:
        TextServicesData.m8522$$Nest$minitializeTextServicesData(tsd);
        SpellCheckerInfo sci = tsd.getCurrentSpellChecker();
        if (sci != null) goto L9;
        SpellCheckerInfo sci2 = findAvailSystemSpellCheckerLocked(null, tsd);
        setCurrentSpellCheckerLocked(sci2, tsd);
        return;
    }

    private boolean bindCurrentSpellCheckerService(Intent service, ServiceConnection conn, int flags, int userId) {
        if (service == null) goto L7;
        if (conn == null) goto L7;
        return this.mContext.bindServiceAsUser(service, conn, flags, UserHandle.of(userId));
    L7:
        Slog.e(TAG, "--- bind failed: service = " + service + ", conn = " + conn + ", userId =" + userId);
        return false;
    }

    private void unbindServiceLocked(TextServicesData tsd) {
        HashMap<String, SpellCheckerBindGroup> spellCheckerBindGroups = TextServicesData.m8517$$Nest$fgetmSpellCheckerBindGroups(tsd);
        Iterator<SpellCheckerBindGroup> r1 = spellCheckerBindGroups.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        SpellCheckerBindGroup scbg = r1.next();
        scbg.removeAllLocked();
        goto L4
    L6:
        spellCheckerBindGroups.clear();
    }

    private SpellCheckerInfo findAvailSystemSpellCheckerLocked(String prefPackage, TextServicesData tsd) {
        ArrayList<SpellCheckerInfo> spellCheckerList = new ArrayList();
        Iterator r2 = TextServicesData.m8518$$Nest$fgetmSpellCheckerList(tsd).iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        SpellCheckerInfo sci = (SpellCheckerInfo) r2.next();
        if ((1 & sci.getServiceInfo().applicationInfo.flags) == 0) goto L4;
        spellCheckerList.add(sci);
        goto L4
    L9:
        int spellCheckersCount = spellCheckerList.size();
        if (spellCheckersCount != 0) goto L13;
        Slog.w(TAG, "no available spell checker services found");
        return null;
    L13:
        if (prefPackage == null) goto L20;
        int i = 0;
    L15:
        if (i >= spellCheckersCount) goto L20;
        SpellCheckerInfo sci2 = spellCheckerList.get(i);
        if (prefPackage.equals(sci2.getPackageName()) == true) goto L18;
        i = i + 1;
        goto L15
    L18:
        return sci2;
    L20:
        Locale systemLocal = this.mContext.getResources().getConfiguration().locale;
        ArrayList<Locale> suitableLocales = LocaleUtils.getSuitableLocalesForSpellChecker(systemLocal);
        int localeCount = suitableLocales.size();
        int localeIndex = 0;
    L21:
        if (localeIndex >= localeCount) goto L33;
        Locale locale = suitableLocales.get(localeIndex);
        int spellCheckersIndex = 0;
    L23:
        if (spellCheckersIndex >= spellCheckersCount) goto L31;
        SpellCheckerInfo info = spellCheckerList.get(spellCheckersIndex);
        int subtypeCount = info.getSubtypeCount();
        int subtypeIndex = 0;
    L25:
        if (subtypeIndex >= subtypeCount) goto L30;
        SpellCheckerSubtype subtype = info.getSubtypeAt(subtypeIndex);
        Locale subtypeLocale = SubtypeLocaleUtils.constructLocaleFromString(subtype.getLocale());
        if (locale.equals(subtypeLocale) == true) goto L28;
        subtypeIndex = subtypeIndex + 1;
        goto L25
    L28:
        return info;
    L30:
        spellCheckersIndex = spellCheckersIndex + 1;
        goto L23
    L31:
        localeIndex = localeIndex + 1;
        goto L21
    L33:
        if (spellCheckersCount <= 1) goto L36;
        Slog.w(TAG, "more than one spell checker service found, picking first");
    L36:
        return spellCheckerList.get(0);
    }

    private SpellCheckerInfo getCurrentSpellCheckerForUser(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        TextServicesData data = this.mUserData.get(userId);     // Catch: Throwable -> L7
        if (data == null) goto L9;
        SpellCheckerInfo r2 = data.getCurrentSpellChecker();     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L9:
        r2 = null;
    L7:
        th = move-exception;
        throw th;
    }

    public SpellCheckerInfo getCurrentSpellChecker(int userId, String locale) {
        verifyUser(userId);
        Object r0 = this.mLock;
        monitor-enter(r0);
        TextServicesData tsd = getDataFromCallingUserIdLocked(userId);     // Catch: Throwable -> L9
        if (tsd != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        SpellCheckerInfo r2 = tsd.getCurrentSpellChecker();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public SpellCheckerSubtype getCurrentSpellCheckerSubtype(int userId, boolean allowImplicitlySelectedSubtype) {
        verifyUser(userId);
        Object r0 = this.mLock;
        monitor-enter(r0);
        TextServicesData tsd = getDataFromCallingUserIdLocked(userId);     // Catch: Throwable -> L8
        if (tsd != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L10:
        int subtypeHashCode = tsd.getSelectedSpellCheckerSubtype(0);     // Catch: Throwable -> L8
        SpellCheckerInfo sci = tsd.getCurrentSpellChecker();     // Catch: Throwable -> L8
        Locale systemLocale = this.mContext.getResources().getConfiguration().locale;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        if (sci != null) goto L14;
    L45:
        return null;
    L14:
        if (sci.getSubtypeCount() == 0) goto L45;
        if (subtypeHashCode != 0) goto L19;
        if (allowImplicitlySelectedSubtype == true) goto L19;
        return null;
    L19:
        int numSubtypes = sci.getSubtypeCount();
        if (subtypeHashCode == 0) goto L29;
        int i = 0;
    L22:
        if (i >= numSubtypes) goto L28;
        SpellCheckerSubtype scs = sci.getSubtypeAt(i);
        if (scs.hashCode() == subtypeHashCode) goto L25;
        i = i + 1;
        goto L22
    L25:
        return scs;
    L28:
        return null;
    L29:
        if (systemLocale != null) goto L31;
        return null;
    L31:
        SpellCheckerSubtype firstLanguageMatchingSubtype = null;
        int i2 = 0;
    L33:
        if (i2 >= sci.getSubtypeCount()) goto L44;
        SpellCheckerSubtype scs2 = sci.getSubtypeAt(i2);
        Locale scsLocale = scs2.getLocaleObject();
        if (Objects.equals(scsLocale, systemLocale) == true) goto L36;
        if (firstLanguageMatchingSubtype != null) goto L42;
        if (scsLocale == null) goto L42;
        if (TextUtils.equals(systemLocale.getLanguage(), scsLocale.getLanguage()) == false) goto L42;
        firstLanguageMatchingSubtype = scs2;
    L42:
        i2 = i2 + 1;
        goto L33
    L36:
        return scs2;
    L44:
        return firstLanguageMatchingSubtype;
    L8:
        th = move-exception;
        throw th;
    }

    public void getSpellCheckerService(int userId, String sciId, String locale, ITextServicesSessionListener tsListener, ISpellCheckerSessionListener scListener, Bundle bundle, int supportedAttributes) {
        verifyUser(userId);
        if (TextUtils.isEmpty(sciId) == true) goto L47;
        if (tsListener == null) goto L47;
        if (scListener == null) goto L47;
        Object r3 = this.mLock;
        monitor-enter(r3);
        TextServicesData tsd = getDataFromCallingUserIdLocked(userId);     // Catch: Throwable -> L13
        if (tsd != null) goto L15;
        monitor-exit(r3);     // Catch: Throwable -> L13
        return;
    L15:
        HashMap<String, SpellCheckerInfo> spellCheckerMap = TextServicesData.m8519$$Nest$fgetmSpellCheckerMap(tsd);     // Catch: Throwable -> L13
        if (spellCheckerMap.containsKey(sciId) == true) goto L19;
        monitor-exit(r3);     // Catch: Throwable -> L13
        return;
    L19:
        SpellCheckerInfo sci = spellCheckerMap.get(sciId);     // Catch: Throwable -> L13
        int uid = Binder.getCallingUid();     // Catch: Throwable -> L13
        if (canCallerAccessSpellChecker(sci, uid, userId) == true) goto L27;
        monitor-exit(r3);     // Catch: Throwable -> L25
        return;
    L27:
        HashMap<String, SpellCheckerBindGroup> spellCheckerBindGroups = TextServicesData.m8517$$Nest$fgetmSpellCheckerBindGroups(tsd);     // Catch: Throwable -> L25
        SpellCheckerBindGroup bindGroup = spellCheckerBindGroups.get(sciId);     // Catch: Throwable -> L25
        if (bindGroup != null) goto L40;
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L25
        SpellCheckerBindGroup bindGroup2 = startSpellCheckerServiceInnerLocked(sci, tsd);     // Catch: Throwable -> L37
    L32:
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L25
        if (bindGroup2 != null) goto L36;
        monitor-exit(r3);     // Catch: Throwable -> L25
        return;
    L36:
        SpellCheckerBindGroup bindGroup3 = bindGroup2;
    L41:
        bindGroup3.getISpellCheckerSessionOrQueueLocked(new SessionRequest(uid, locale, tsListener, scListener, bundle, supportedAttributes));     // Catch: Throwable -> L25
        monitor-exit(r3);     // Catch: Throwable -> L25
        return;
    L37:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L40:
        bindGroup3 = bindGroup;
    L13:
        th = th;
    L44:
        monitor-exit(r3);     // Catch: Throwable -> L25
        throw th;
    L25:
        th = th;
    L47:
        Slog.e(TAG, "getSpellCheckerService: Invalid input.");
    }

    public boolean isSpellCheckerEnabled(int userId) {
        verifyUser(userId);
        Object r0 = this.mLock;
        monitor-enter(r0);
        TextServicesData tsd = getDataFromCallingUserIdLocked(userId);     // Catch: Throwable -> L9
        if (tsd != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        boolean r2 = tsd.isSpellCheckerEnabled();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    private SpellCheckerBindGroup startSpellCheckerServiceInnerLocked(SpellCheckerInfo info, TextServicesData tsd) {
        String sciId = info.getId();
        InternalServiceConnection connection = new InternalServiceConnection(this, sciId, TextServicesData.m8517$$Nest$fgetmSpellCheckerBindGroups(tsd));
        Intent serviceIntent = new Intent("android.service.textservice.SpellCheckerService");
        serviceIntent.setComponent(info.getComponent());
        if (bindCurrentSpellCheckerService(serviceIntent, connection, 8388609, TextServicesData.m8520$$Nest$fgetmUserId(tsd)) == true) goto L6;
        Slog.e(TAG, "Failed to get a spell checker service.");
        return null;
    L6:
        SpellCheckerBindGroup group = new SpellCheckerBindGroup(this, connection);
        TextServicesData.m8517$$Nest$fgetmSpellCheckerBindGroups(tsd).put(sciId, group);
        return group;
    }

    public SpellCheckerInfo[] getEnabledSpellCheckers(int userId) {
        verifyUser(userId);
        Object r0 = this.mLock;
        monitor-enter(r0);
        TextServicesData tsd = getDataFromCallingUserIdLocked(userId);     // Catch: Throwable -> L8
        if (tsd != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L10:
        ArrayList<SpellCheckerInfo> spellCheckerList = new ArrayList(TextServicesData.m8518$$Nest$fgetmSpellCheckerList(tsd));     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        int size = spellCheckerList.size();
        int callingUid = Binder.getCallingUid();
        int i = size - 1;
    L13:
        if (i < 0) goto L20;
        if (canCallerAccessSpellChecker(spellCheckerList.get(i), callingUid, userId) == true) goto L18;
        spellCheckerList.remove(i);
    L18:
        i = i - 1;
        goto L13
    L20:
        if (spellCheckerList.isEmpty() == false) goto L23;
        return null;
    L23:
        return (SpellCheckerInfo[]) spellCheckerList.toArray(new SpellCheckerInfo[spellCheckerList.size()]);
    L8:
        th = move-exception;
        throw th;
    }

    public void finishSpellCheckerService(int userId, ISpellCheckerSessionListener listener) {
        verifyUser(userId);
        Object r0 = this.mLock;
        monitor-enter(r0);
        TextServicesData tsd = getDataFromCallingUserIdLocked(userId);     // Catch: Throwable -> L8
        if (tsd != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        ArrayList<SpellCheckerBindGroup> removeList = new ArrayList();     // Catch: Throwable -> L8
        HashMap<String, SpellCheckerBindGroup> spellCheckerBindGroups = TextServicesData.m8517$$Nest$fgetmSpellCheckerBindGroups(tsd);     // Catch: Throwable -> L8
        Iterator<SpellCheckerBindGroup> r4 = spellCheckerBindGroups.values().iterator();     // Catch: Throwable -> L8
    L12:
        if (r4.hasNext() == false) goto L17;
        SpellCheckerBindGroup group = r4.next();     // Catch: Throwable -> L8
        if (group == null) goto L12;
        removeList.add(group);     // Catch: Throwable -> L8
        goto L12
    L17:
        int removeSize = removeList.size();     // Catch: Throwable -> L8
        int i = 0;
    L18:
        if (i >= removeSize) goto L21;
        removeList.get(i).removeListener(listener);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L18
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void verifyUser(int userId) {
        int callingUserId = UserHandle.getCallingUserId();
        if (userId == callingUserId) goto L6;
        this.mContext.enforceCallingPermission("android.permission.INTERACT_ACROSS_USERS_FULL", "Cross-user interaction requires INTERACT_ACROSS_USERS_FULL. userId=" + userId + " callingUserId=" + callingUserId);
        return;
    }

    private boolean canCallerAccessSpellChecker(SpellCheckerInfo sci, int callingUid, int userId) {
        SpellCheckerInfo currentSci = getCurrentSpellCheckerForUser(userId);
        if (currentSci != null) goto L5;
    L7:
        PackageManagerInternal pmInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        return true ^ pmInternal.filterAppAccess(sci.getPackageName(), callingUid, userId);
    L5:
        if (currentSci.getId().equals(sci.getId()) == false) goto L7;
        return true;
    }

    private void setCurrentSpellCheckerLocked(SpellCheckerInfo sci, TextServicesData tsd) {
        if (sci == null) goto L5;
        sci.getId();
    L5:
        long ident = Binder.clearCallingIdentity();
        tsd.setCurrentSpellChecker(sci);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(ident);
        return;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L6;
        return;
    L6:
        if (args.length != 0) goto L8;
    L35:
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println("Current Text Services Manager state:");     // Catch: Throwable -> L40
        pw.println("  Users:");     // Catch: Throwable -> L40
        int numOfUsers = this.mUserData.size();     // Catch: Throwable -> L40
        int i = 0;
    L38:
        if (i >= numOfUsers) goto L43;
        TextServicesData.m8521$$Nest$mdump(this.mUserData.valueAt(i), pw);     // Catch: Throwable -> L40
        i = i + 1;     // Catch: Throwable -> L40
        goto L38
    L43:
        monitor-exit(r0);     // Catch: Throwable -> L40
        return;
    L40:
        th = move-exception;
        throw th;
    L8:
        if (args.length != 1) goto L13;
        if (args[0].equals("-a") == true) goto L35;
    L13:
        if (args.length == 2) goto L15;
    L33:
        pw.println("Invalid arguments to text services.");
        return;
    L15:
        if (args[0].equals("--user") == false) goto L33;
        int userId = Integer.parseInt(args[1]);
        UserInfo userInfo = this.mUserManager.getUserInfo(userId);
        if (userInfo != null) goto L21;
        pw.println("Non-existent user.");
        return;
    L21:
        TextServicesData tsd = this.mUserData.get(userId);
        if (tsd != null) goto L25;
        pw.println("User needs to unlock first.");
        return;
    L25:
        Object r3 = this.mLock;
        monitor-enter(r3);
        pw.println("Current Text Services Manager state:");     // Catch: Throwable -> L30
        pw.println("  User " + userId + ":");     // Catch: Throwable -> L30
        TextServicesData.m8521$$Nest$mdump(tsd, pw);     // Catch: Throwable -> L30
        monitor-exit(r3);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        throw th;
    }

    private TextServicesData getDataFromCallingUserIdLocked(int callingUserId) {
        return this.mUserData.get(callingUserId);
    }
}
