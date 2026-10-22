package com.android.server;

import android.app.AppOpsManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.Slog;
import com.android.internal.telephony.IMms;
import com.android.internal.telephony.TelephonyPermissions;
import com.android.internal.telephony.util.TelephonyUtils;
import com.android.server.autofill.HintsHelper;
import com.android.server.uri.NeededUriGrants;
import com.android.server.uri.UriGrantsManagerInternal;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MmsServiceBroker extends SystemService {
    private static final Uri FAKE_MMS_DRAFT_URI = null;
    private static final Uri FAKE_MMS_SENT_URI = null;
    private static final Uri FAKE_SMS_DRAFT_URI = null;
    private static final Uri FAKE_SMS_SENT_URI = null;
    private static final ComponentName MMS_SERVICE_COMPONENT = null;
    private static final int MSG_TRY_CONNECTING = 1;
    private static final long RETRY_DELAY_ON_DISCONNECTION_MS = 3000;
    private static final long SERVICE_CONNECTION_WAIT_TIME_MS = 4000;
    private static final String TAG = "MmsServiceBroker";
    private volatile AppOpsManager mAppOpsManager;
    private ServiceConnection mConnection;
    private final Handler mConnectionHandler;
    private Context mContext;
    private volatile PackageManager mPackageManager;
    private volatile IMms mService;
    private final IMms mServiceStubForFailure;
    private volatile TelephonyManager mTelephonyManager;

    private final class BinderService extends IMms.Stub {
        private static final String PHONE_PACKAGE_NAME = "com.android.phone";
        final /* synthetic */ MmsServiceBroker this$0;

        /* synthetic */ BinderService(MmsServiceBroker r1, MmsServiceBrokerIA r2) {
            this(r1);
        }

        private BinderService(MmsServiceBroker r1) {
            this.this$0 = r1;
        }

        public void sendMessage(int subId, int callingUser, String callingPkg, Uri contentUri, String locationUrl, Bundle configOverrides, PendingIntent sentIntent, long messageId, String attributionTag) throws RemoteException {
            Slog.d(MmsServiceBroker.TAG, "sendMessage() by " + callingPkg);
            MmsServiceBroker.m267$$Nest$fgetmContext(this.this$0).enforceCallingPermission("android.permission.SEND_SMS", "Send MMS message");
            if (TelephonyPermissions.checkSubscriptionAssociatedWithUser(MmsServiceBroker.m267$$Nest$fgetmContext(this.this$0), subId, Binder.getCallingUserHandle()) == true) goto L9;
            if (MmsServiceBroker.m273$$Nest$misActiveSubId(this.this$0, subId) == false) goto L9;
            TelephonyUtils.showSwitchToManagedProfileDialogIfAppropriate(MmsServiceBroker.m267$$Nest$fgetmContext(this.this$0), subId, Binder.getCallingUid(), callingPkg);
            return;
        L9:
            if (MmsServiceBroker.m269$$Nest$mgetAppOpsManager(this.this$0).noteOp(20, Binder.getCallingUid(), callingPkg, attributionTag, null) == 0) goto L12;
            Slog.e(MmsServiceBroker.TAG, callingPkg + " is not allowed to call sendMessage()");
            return;
        L12:
            MmsServiceBroker.m272$$Nest$mgetServiceGuarded(this.this$0).sendMessage(subId, MmsServiceBroker.m270$$Nest$mgetCallingUserId(this.this$0), callingPkg, adjustUriForUserAndGrantPermission(contentUri, "android.service.carrier.CarrierMessagingService", 1, subId), locationUrl, configOverrides, sentIntent, messageId, attributionTag);
        }

        public void downloadMessage(int subId, int callingUser, String callingPkg, String locationUrl, Uri contentUri, Bundle configOverrides, PendingIntent downloadedIntent, long messageId, String attributionTag) throws RemoteException {
            Slog.d(MmsServiceBroker.TAG, "downloadMessage() by " + callingPkg);
            MmsServiceBroker.m267$$Nest$fgetmContext(this.this$0).enforceCallingPermission("android.permission.RECEIVE_MMS", "Download MMS message");
            if (MmsServiceBroker.m269$$Nest$mgetAppOpsManager(this.this$0).noteOp(18, Binder.getCallingUid(), callingPkg, attributionTag, null) == 0) goto L6;
            Slog.e(MmsServiceBroker.TAG, callingPkg + " is not allowed to call downloadMessage()");
            return;
        L6:
            MmsServiceBroker.m272$$Nest$mgetServiceGuarded(this.this$0).downloadMessage(subId, MmsServiceBroker.m270$$Nest$mgetCallingUserId(this.this$0), callingPkg, locationUrl, adjustUriForUserAndGrantPermission(contentUri, "android.service.carrier.CarrierMessagingService", 3, subId), configOverrides, downloadedIntent, messageId, attributionTag);
        }

        public Uri importTextMessage(String callingPkg, String address, int type, String text, long timestampMillis, boolean seen, boolean read) throws RemoteException {
            if (MmsServiceBroker.m269$$Nest$mgetAppOpsManager(this.this$0).noteOp(15, Binder.getCallingUid(), callingPkg, null, null) == 0) goto L7;
            return MmsServiceBroker.m278$$Nest$sfgetFAKE_SMS_SENT_URI();
        L7:
            return MmsServiceBroker.m272$$Nest$mgetServiceGuarded(this.this$0).importTextMessage(callingPkg, address, type, text, timestampMillis, seen, read);
        }

        public Uri importMultimediaMessage(int callingUser, String callingPkg, Uri contentUri, String messageId, long timestampSecs, boolean seen, boolean read) throws RemoteException {
            if (MmsServiceBroker.m269$$Nest$mgetAppOpsManager(this.this$0).noteOp(15, Binder.getCallingUid(), callingPkg, null, null) == 0) goto L7;
            return MmsServiceBroker.m276$$Nest$sfgetFAKE_MMS_SENT_URI();
        L7:
            return MmsServiceBroker.m272$$Nest$mgetServiceGuarded(this.this$0).importMultimediaMessage(MmsServiceBroker.m270$$Nest$mgetCallingUserId(this.this$0), callingPkg, contentUri, messageId, timestampSecs, seen, read);
        }

        public boolean deleteStoredMessage(String callingPkg, Uri messageUri) throws RemoteException {
            if (MmsServiceBroker.m269$$Nest$mgetAppOpsManager(this.this$0).noteOp(15, Binder.getCallingUid(), callingPkg, null, null) == 0) goto L7;
            return false;
        L7:
            return MmsServiceBroker.m272$$Nest$mgetServiceGuarded(this.this$0).deleteStoredMessage(callingPkg, messageUri);
        }

        public boolean deleteStoredConversation(String callingPkg, long conversationId) throws RemoteException {
            if (MmsServiceBroker.m269$$Nest$mgetAppOpsManager(this.this$0).noteOp(15, Binder.getCallingUid(), callingPkg, null, null) == 0) goto L7;
            return false;
        L7:
            return MmsServiceBroker.m272$$Nest$mgetServiceGuarded(this.this$0).deleteStoredConversation(callingPkg, conversationId);
        }

        public boolean updateStoredMessageStatus(String callingPkg, Uri messageUri, ContentValues statusValues) throws RemoteException {
            if (MmsServiceBroker.m269$$Nest$mgetAppOpsManager(this.this$0).noteOp(15, Binder.getCallingUid(), callingPkg, null, null) == 0) goto L7;
            return false;
        L7:
            return MmsServiceBroker.m272$$Nest$mgetServiceGuarded(this.this$0).updateStoredMessageStatus(callingPkg, messageUri, statusValues);
        }

        public boolean archiveStoredConversation(String callingPkg, long conversationId, boolean archived) throws RemoteException {
            if (MmsServiceBroker.m269$$Nest$mgetAppOpsManager(this.this$0).noteOp(15, Binder.getCallingUid(), callingPkg, null, null) == 0) goto L7;
            return false;
        L7:
            return MmsServiceBroker.m272$$Nest$mgetServiceGuarded(this.this$0).archiveStoredConversation(callingPkg, conversationId, archived);
        }

        public Uri addTextMessageDraft(String callingPkg, String address, String text) throws RemoteException {
            if (MmsServiceBroker.m269$$Nest$mgetAppOpsManager(this.this$0).noteOp(15, Binder.getCallingUid(), callingPkg, null, null) == 0) goto L7;
            return MmsServiceBroker.m277$$Nest$sfgetFAKE_SMS_DRAFT_URI();
        L7:
            return MmsServiceBroker.m272$$Nest$mgetServiceGuarded(this.this$0).addTextMessageDraft(callingPkg, address, text);
        }

        public Uri addMultimediaMessageDraft(int callingUser, String callingPkg, Uri contentUri) throws RemoteException {
            if (MmsServiceBroker.m269$$Nest$mgetAppOpsManager(this.this$0).noteOp(15, Binder.getCallingUid(), callingPkg, null, null) == 0) goto L7;
            return MmsServiceBroker.m275$$Nest$sfgetFAKE_MMS_DRAFT_URI();
        L7:
            return MmsServiceBroker.m272$$Nest$mgetServiceGuarded(this.this$0).addMultimediaMessageDraft(MmsServiceBroker.m270$$Nest$mgetCallingUserId(this.this$0), callingPkg, contentUri);
        }

        public void sendStoredMessage(int subId, String callingPkg, Uri messageUri, Bundle configOverrides, PendingIntent sentIntent) throws RemoteException {
            if (MmsServiceBroker.m269$$Nest$mgetAppOpsManager(this.this$0).noteOp(20, Binder.getCallingUid(), callingPkg, null, null) == 0) goto L5;
            return;
        L5:
            MmsServiceBroker.m272$$Nest$mgetServiceGuarded(this.this$0).sendStoredMessage(subId, callingPkg, messageUri, configOverrides, sentIntent);
        }

        public void setAutoPersisting(String callingPkg, boolean enabled) throws RemoteException {
            if (MmsServiceBroker.m269$$Nest$mgetAppOpsManager(this.this$0).noteOp(15, Binder.getCallingUid(), callingPkg, null, null) == 0) goto L5;
            return;
        L5:
            MmsServiceBroker.m272$$Nest$mgetServiceGuarded(this.this$0).setAutoPersisting(callingPkg, enabled);
        }

        public boolean getAutoPersisting() throws RemoteException {
            return MmsServiceBroker.m272$$Nest$mgetServiceGuarded(this.this$0).getAutoPersisting();
        }

        private Uri adjustUriForUserAndGrantPermission(Uri contentUri, String action, int permission, int subId) {
            Intent grantIntent = new Intent();
            grantIntent.setData(contentUri);
            grantIntent.setFlags(permission);
            int callingUid = Binder.getCallingUid();
            int callingUserId = UserHandle.getCallingUserId();
            if (callingUserId == 0) goto L5;
            Uri contentUri2 = ContentProvider.maybeAddUserId(contentUri, callingUserId);
        L6:
            long token = Binder.clearCallingIdentity();
            UriGrantsManagerInternal ugm = (UriGrantsManagerInternal) LocalServices.getService(UriGrantsManagerInternal.class);     // Catch: Throwable -> L23
            NeededUriGrants needed = ugm.checkGrantUriPermissionFromIntent(grantIntent, callingUid, PHONE_PACKAGE_NAME, 0);     // Catch: Throwable -> L23
            ugm.grantUriPermissionUncheckedFromIntent(needed, null);     // Catch: Throwable -> L23
            Intent intent = new Intent(action);     // Catch: Throwable -> L21
            TelephonyManager telephonyManager = (TelephonyManager) MmsServiceBroker.m267$$Nest$fgetmContext(this.this$0).getSystemService(HintsHelper.AUTOFILL_HINT_PHONE);     // Catch: Throwable -> L21
            List<String> carrierPackages = telephonyManager.getCarrierPackageNamesForIntentAndPhone(intent, MmsServiceBroker.m271$$Nest$mgetPhoneIdFromSubId(this.this$0, subId));     // Catch: Throwable -> L17
            if (carrierPackages != null) goto L14;
        L19:
            Binder.restoreCallingIdentity(token);
            return contentUri2;
        L14:
            if (carrierPackages.size() != 1) goto L19;
            NeededUriGrants carrierNeeded = ugm.checkGrantUriPermissionFromIntent(grantIntent, callingUid, carrierPackages.get(0), 0);     // Catch: Throwable -> L17
            ugm.grantUriPermissionUncheckedFromIntent(carrierNeeded, null);     // Catch: Throwable -> L17
        L17:
            th = th;
        L25:
            Binder.restoreCallingIdentity(token);
            throw th;
        L21:
            th = th;
        L23:
            th = th;
            goto L25
        L5:
            contentUri2 = contentUri;
            goto L6
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConnectionHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m266$$Nest$fgetmConnectionHandler(MmsServiceBroker r0) {
        return r0.mConnectionHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m267$$Nest$fgetmContext(MmsServiceBroker r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m268$$Nest$fputmService(MmsServiceBroker r0, IMms r1) {
        r0.mService = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetAppOpsManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ AppOpsManager m269$$Nest$mgetAppOpsManager(MmsServiceBroker r0) {
        return r0.getAppOpsManager();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetCallingUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m270$$Nest$mgetCallingUserId(MmsServiceBroker r0) {
        return r0.getCallingUserId();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetPhoneIdFromSubId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m271$$Nest$mgetPhoneIdFromSubId(MmsServiceBroker r0, int r1) {
        return r0.getPhoneIdFromSubId(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetServiceGuarded, reason: not valid java name */
    static /* bridge */ /* synthetic */ IMms m272$$Nest$mgetServiceGuarded(MmsServiceBroker r0) {
        return r0.getServiceGuarded();
    }

    /* JADX INFO: renamed from: -$$Nest$misActiveSubId, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m273$$Nest$misActiveSubId(MmsServiceBroker r0, int r1) {
        return r0.isActiveSubId(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mtryConnecting, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m274$$Nest$mtryConnecting(MmsServiceBroker r0) {
        r0.tryConnecting();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetFAKE_MMS_DRAFT_URI, reason: not valid java name */
    static /* bridge */ /* synthetic */ Uri m275$$Nest$sfgetFAKE_MMS_DRAFT_URI() {
        return FAKE_MMS_DRAFT_URI;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetFAKE_MMS_SENT_URI, reason: not valid java name */
    static /* bridge */ /* synthetic */ Uri m276$$Nest$sfgetFAKE_MMS_SENT_URI() {
        return FAKE_MMS_SENT_URI;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetFAKE_SMS_DRAFT_URI, reason: not valid java name */
    static /* bridge */ /* synthetic */ Uri m277$$Nest$sfgetFAKE_SMS_DRAFT_URI() {
        return FAKE_SMS_DRAFT_URI;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetFAKE_SMS_SENT_URI, reason: not valid java name */
    static /* bridge */ /* synthetic */ Uri m278$$Nest$sfgetFAKE_SMS_SENT_URI() {
        return FAKE_SMS_SENT_URI;
    }

    static {
        MMS_SERVICE_COMPONENT = new ComponentName("com.android.mms.service", "com.android.mms.service.MmsService");
        FAKE_SMS_SENT_URI = Uri.parse("content://sms/sent/0");
        FAKE_MMS_SENT_URI = Uri.parse("content://mms/sent/0");
        FAKE_SMS_DRAFT_URI = Uri.parse("content://sms/draft/0");
        FAKE_MMS_DRAFT_URI = Uri.parse("content://mms/draft/0");
    }

    public MmsServiceBroker(Context context) {
        super(context);
        this.mAppOpsManager = null;
        this.mPackageManager = null;
        this.mTelephonyManager = null;
        this.mConnectionHandler = new AnonymousClass1(this);
        this.mConnection = new AnonymousClass2(this);
        this.mServiceStubForFailure = new AnonymousClass3(this);
        this.mContext = context;
        this.mService = null;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("imms", new BinderService(this, null));
    }

    public void systemRunning() {
        Slog.i(TAG, "Delay connecting to MmsService until an API is called");
    }

    private void tryConnecting() {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            java.lang.String r0 = "MmsServiceBroker"
            java.lang.String r1 = "Connecting to MmsService"
            android.util.Slog.i(r0, r1)
            monitor-enter(r4)
            com.android.internal.telephony.IMms r0 = r4.mService     // Catch: java.lang.Throwable -> L15
            if (r0 == 0) goto L17
            java.lang.String r0 = "MmsServiceBroker"
            java.lang.String r1 = "Already connected"
            android.util.Slog.d(r0, r1)     // Catch: java.lang.Throwable -> L15
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L15
            return
        L15:
            r0 = move-exception
            goto L41
        L17:
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Throwable -> L15
            r0.<init>()     // Catch: java.lang.Throwable -> L15
            android.content.ComponentName r1 = com.android.server.MmsServiceBroker.MMS_SERVICE_COMPONENT     // Catch: java.lang.Throwable -> L15
            r0.setComponent(r1)     // Catch: java.lang.Throwable -> L15
            android.content.Context r1 = r4.mContext     // Catch: java.lang.Throwable -> L15 java.lang.SecurityException -> L34
            android.content.ServiceConnection r2 = r4.mConnection     // Catch: java.lang.Throwable -> L15 java.lang.SecurityException -> L34
            r3 = 1
            boolean r1 = r1.bindService(r0, r2, r3)     // Catch: java.lang.Throwable -> L15 java.lang.SecurityException -> L34
            if (r1 != 0) goto L36
            java.lang.String r1 = "MmsServiceBroker"
            java.lang.String r2 = "Failed to bind to MmsService"
            android.util.Slog.e(r1, r2)     // Catch: java.lang.Throwable -> L15 java.lang.SecurityException -> L34
            goto L36
        L34:
            r1 = move-exception
            goto L37
        L36:
            goto L3f
        L37:
            java.lang.String r2 = "MmsServiceBroker"
            java.lang.String r3 = "Forbidden to bind to MmsService"
            android.util.Slog.e(r2, r3, r1)     // Catch: java.lang.Throwable -> L15
        L3f:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L15
            return
        L41:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L15
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.server.MmsServiceBroker.tryConnecting():void");
    }

    private IMms getOrConnectService() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mService == null) goto L10;
        IMms r0 = this.mService;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return r0;
    L10:
        Slog.w(TAG, "MmsService not connected. Try connecting...");     // Catch: Throwable -> L8
        this.mConnectionHandler.sendMessage(this.mConnectionHandler.obtainMessage(1));     // Catch: Throwable -> L8
        long shouldEnd = SystemClock.elapsedRealtime() + SERVICE_CONNECTION_WAIT_TIME_MS;
        long waitTime = SERVICE_CONNECTION_WAIT_TIME_MS;
    L13:
        if (waitTime <= 0) goto L24;
        wait(waitTime);     // Catch: Throwable -> L8 InterruptedException -> L16
    L19:
        if (this.mService != null) goto L20;
        waitTime = shouldEnd - SystemClock.elapsedRealtime();     // Catch: Throwable -> L8
        goto L13
    L20:
        IMms r4 = this.mService;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return r4;
    L16:
        e = move-exception;
        Slog.w(TAG, "Connection wait interrupted", e);     // Catch: Throwable -> L8
        goto L19
    L24:
        Slog.e(TAG, "Can not connect to MmsService (timed out)");     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return null;
    }

    private IMms getServiceGuarded() {
        IMms service = getOrConnectService();
        if (service == null) goto L6;
        return service;
    L6:
        return this.mServiceStubForFailure;
    }

    private AppOpsManager getAppOpsManager() {
        if (this.mAppOpsManager != null) goto L6;
        this.mAppOpsManager = (AppOpsManager) this.mContext.getSystemService("appops");
    L6:
        return this.mAppOpsManager;
    }

    private PackageManager getPackageManager() {
        if (this.mPackageManager != null) goto L6;
        this.mPackageManager = this.mContext.getPackageManager();
    L6:
        return this.mPackageManager;
    }

    private TelephonyManager getTelephonyManager() {
        if (this.mTelephonyManager != null) goto L6;
        this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService(HintsHelper.AUTOFILL_HINT_PHONE);
    L6:
        return this.mTelephonyManager;
    }

    private String getCallingPackageName() {
        String[] packages = getPackageManager().getPackagesForUid(Binder.getCallingUid());
        if (packages != null) goto L5;
        return "unknown";
    L5:
        if (packages.length > 0) goto L7;
        return "unknown";
    L7:
        return packages[0];
    }

    private boolean isActiveSubId(int subId) {
        long token = Binder.clearCallingIdentity();
        SubscriptionManager subManager = (SubscriptionManager) this.mContext.getSystemService(SubscriptionManager.class);     // Catch: Throwable -> L8
        if (subManager == null) goto L10;
        if (subManager.isActiveSubscriptionId(subId) == false) goto L10;
        boolean r3 = true;
    L11:
        Binder.restoreCallingIdentity(token);
        return r3;
    L10:
        r3 = false;
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private int getPhoneIdFromSubId(int subId) {
        SubscriptionManager subManager = (SubscriptionManager) this.mContext.getSystemService("telephony_subscription_service");
        if (subManager != null) goto L5;
        return -1;
    L5:
        SubscriptionInfo info = subManager.getActiveSubscriptionInfo(subId);
        if (info != null) goto L9;
        return -1;
    L9:
        return info.getSimSlotIndex();
    }

    private int getCallingUserId() {
        return Binder.getCallingUserHandle().getIdentifier();
    }
}
