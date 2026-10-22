package com.android.server.audio;

import android.app.ActivityManager;
import android.app.IUidObserver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.os.Binder;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MusicFxHelper {
    static final int MSG_EFFECT_CLIENT_GONE = 1101;
    private static final String TAG = "AS.MusicFxHelper";
    private final AudioService.AudioHandler mAudioHandler;
    private final Object mClientUidMapLock;
    private MySparseArray mClientUidSessionMap;
    private final Context mContext;
    private final IUidObserver mEffectUidObserver;
    private boolean mIsBound;
    private ServiceConnection mMusicFxBindConnection;
    private final String mMusicFxPackageName;
    private final String mPackageName;
    private IBinder mUidObserverToken;

    private class MySparseArray extends SparseArray<PackageSessions> {
        final /* synthetic */ MusicFxHelper this$0;

        /* synthetic */ MySparseArray(MusicFxHelper r1, MusicFxHelperIA r2) {
            this(r1);
        }

        private MySparseArray(MusicFxHelper r1) {
            this.this$0 = r1;
        }

        @Override // android.util.SparseArray
        public /* bridge */ /* synthetic */ void put(int r1, PackageSessions r2) {
            put2(r1, r2);
        }

        /* JADX INFO: renamed from: put, reason: avoid collision after fix types in other method */
        public void put2(int uid, PackageSessions pkgSessions) {
            if (size() != 0) goto L27;
            int procState = 20;
            procState = ActivityManager.getService().getPackageProcessState("com.android.musicfx", MusicFxHelper.m2165$$Nest$fgetmPackageName(this.this$0));     // Catch: RemoteException -> L7
        L10:
            if (procState <= 6) goto L12;
            Intent bindIntent = new Intent().setClassName("com.android.musicfx", "com.android.musicfx.KeepAliveService");
            MusicFxHelper.m2167$$Nest$fputmIsBound(this.this$0, true);
            MusicFxHelper.m2161$$Nest$fgetmContext(this.this$0).bindServiceAsUser(bindIntent, MusicFxHelper.m2164$$Nest$fgetmMusicFxBindConnection(this.this$0), 1, UserHandle.of(MusicFxHelper.m2169$$Nest$mgetCurrentUserId(this.this$0)));
            Log.i(MusicFxHelper.TAG, "bindService to com.android.musicfx");
        L12:
            Log.i(MusicFxHelper.TAG, "com.android.musicfx procState " + procState);
        L7:
            e = move-exception;
            Log.e(MusicFxHelper.TAG, "RemoteException with getPackageProcessState: " + e);
        L27:
        L16:
            e = move-exception;
            Log.e(MusicFxHelper.TAG, "RemoteException with UID observer add/register: " + e);
        L23:
            super.put(uid, pkgSessions);
            return;
        L14:
            if (MusicFxHelper.m2166$$Nest$fgetmUidObserverToken(this.this$0) != null) goto L19;
            MusicFxHelper.m2168$$Nest$fputmUidObserverToken(this.this$0, ActivityManager.getService().registerUidObserverForUids(MusicFxHelper.m2162$$Nest$fgetmEffectUidObserver(this.this$0), 2, -1, MusicFxHelper.m2165$$Nest$fgetmPackageName(this.this$0), new int[]{uid}));     // Catch: RemoteException -> L16
            Log.i(MusicFxHelper.TAG, "registered to observer with UID " + uid);     // Catch: RemoteException -> L16
            goto L23
        L19:
            if (get(uid) != null) goto L23;
            ActivityManager.getService().addUidToObserver(MusicFxHelper.m2166$$Nest$fgetmUidObserverToken(this.this$0), MusicFxHelper.m2165$$Nest$fgetmPackageName(this.this$0), uid);     // Catch: RemoteException -> L16
            Log.i(MusicFxHelper.TAG, " UID " + uid + " add to observer");     // Catch: RemoteException -> L16
            goto L23
        }

        @Override // android.util.SparseArray
        public void remove(int uid) {
            if (get(uid) != null) goto L18;
        L8:
            super.remove(uid);
            if (size() != 0) goto L22;
            ActivityManager.getService().unregisterUidObserver(MusicFxHelper.m2162$$Nest$fgetmEffectUidObserver(this.this$0));     // Catch: RemoteException -> L12
        L14:
            MusicFxHelper.m2168$$Nest$fputmUidObserverToken(this.this$0, null);
            if (MusicFxHelper.m2163$$Nest$fgetmIsBound(this.this$0) == false) goto L23;
            MusicFxHelper.m2161$$Nest$fgetmContext(this.this$0).unbindService(MusicFxHelper.m2164$$Nest$fgetmMusicFxBindConnection(this.this$0));
            MusicFxHelper.m2167$$Nest$fputmIsBound(this.this$0, false);
            Log.i(MusicFxHelper.TAG, "last session closed, unregister UID observer, and unbind com.android.musicfx");
            return;
        L23:
            return;
        L12:
            e = move-exception;
            Log.e(MusicFxHelper.TAG, "RemoteException with unregisterUidObserver: " + e);
            goto L14
        L22:
            return;
        L18:
            ActivityManager.getService().removeUidFromObserver(MusicFxHelper.m2166$$Nest$fgetmUidObserverToken(this.this$0), MusicFxHelper.m2165$$Nest$fgetmPackageName(this.this$0), uid);     // Catch: RemoteException -> L6
        L6:
            e = move-exception;
            Log.e(MusicFxHelper.TAG, "RemoteException with removeUidFromObserver: " + e);
            goto L8
        }
    }

    private static class PackageSessions {
        String mPackageName;
        List<Integer> mSessions;

        /* synthetic */ PackageSessions(MusicFxHelperIA r1) {
            this();
        }

        private PackageSessions() {
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAudioHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ AudioService.AudioHandler m2160$$Nest$fgetmAudioHandler(MusicFxHelper r0) {
        return r0.mAudioHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m2161$$Nest$fgetmContext(MusicFxHelper r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEffectUidObserver, reason: not valid java name */
    static /* bridge */ /* synthetic */ IUidObserver m2162$$Nest$fgetmEffectUidObserver(MusicFxHelper r0) {
        return r0.mEffectUidObserver;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsBound, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2163$$Nest$fgetmIsBound(MusicFxHelper r0) {
        return r0.mIsBound;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMusicFxBindConnection, reason: not valid java name */
    static /* bridge */ /* synthetic */ ServiceConnection m2164$$Nest$fgetmMusicFxBindConnection(MusicFxHelper r0) {
        return r0.mMusicFxBindConnection;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageName, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m2165$$Nest$fgetmPackageName(MusicFxHelper r0) {
        return r0.mPackageName;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUidObserverToken, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBinder m2166$$Nest$fgetmUidObserverToken(MusicFxHelper r0) {
        return r0.mUidObserverToken;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsBound, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2167$$Nest$fputmIsBound(MusicFxHelper r0, boolean r1) {
        r0.mIsBound = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmUidObserverToken, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2168$$Nest$fputmUidObserverToken(MusicFxHelper r0, IBinder r1) {
        r0.mUidObserverToken = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetCurrentUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2169$$Nest$mgetCurrentUserId(MusicFxHelper r0) {
        return r0.getCurrentUserId();
    }

    MusicFxHelper(Context context, AudioService.AudioHandler audioHandler) {
        this.mClientUidMapLock = new Object();
        this.mPackageName = getClass().getPackage().getName();
        this.mMusicFxPackageName = "com.android.musicfx";
        this.mUidObserverToken = null;
        this.mClientUidSessionMap = new MySparseArray(this, null);
        this.mEffectUidObserver = new AnonymousClass1(this);
        this.mMusicFxBindConnection = new AnonymousClass2(this);
        this.mContext = context;
        this.mAudioHandler = audioHandler;
    }

    public void handleAudioEffectBroadcast(Context context, Intent intent) {
        String target = intent.getPackage();
        if (target == null) goto L6;
        Log.w(TAG, "effect broadcast already targeted to " + target);
        return;
    L6:
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> ril = pm.queryBroadcastReceivers(intent, 0);
        if (ril != null) goto L9;
    L28:
        Log.w(TAG, "couldn't find receiver package for effect intent");
        return;
    L9:
        if (ril.size() == 0) goto L28;
        ResolveInfo ri = ril.get(0);
        String senderPackageName = intent.getStringExtra("android.media.extra.PACKAGE_NAME");
        if (senderPackageName != null) goto L14;
        Log.w(TAG, "Intent package name must not be null");
        return;
    L14:
        if (ri == null) goto L28;
    L23:
        e = move-exception;
        Log.e(TAG, "Not able to find UID from package: " + senderPackageName + " error: " + e);
        goto L28
    L16:
        if (ri.activityInfo == null) goto L28;
        if (ri.activityInfo.packageName == null) goto L28;
        int senderUid = pm.getPackageUidAsUser(senderPackageName, PackageManager.PackageInfoFlags.of(4194304), getCurrentUserId());     // Catch: PackageManager.NameNotFoundException -> L23
        intent.addFlags(32);     // Catch: PackageManager.NameNotFoundException -> L23
        intent.setPackage(ri.activityInfo.packageName);     // Catch: PackageManager.NameNotFoundException -> L23
        if (setMusicFxServiceWithObserver(intent, senderUid, senderPackageName) == false) goto L25;
        context.sendBroadcastAsUser(intent, UserHandle.ALL);     // Catch: PackageManager.NameNotFoundException -> L23
        return;
    }

    private boolean handleAudioEffectSessionOpen(int senderUid, String senderPackageName, int sessionId) {
        Log.d(TAG, senderPackageName + " UID " + senderUid + " open MusicFx session " + sessionId);
        PackageSessions pkgSessions = this.mClientUidSessionMap.get(Integer.valueOf(senderUid).intValue());
        if (pkgSessions != null) goto L5;
    L14:
        pkgSessions = new PackageSessions(null);
        pkgSessions.mSessions = new ArrayList();
        pkgSessions.mPackageName = senderPackageName;
    L15:
        pkgSessions.mSessions.add(Integer.valueOf(sessionId));
        this.mClientUidSessionMap.put2(Integer.valueOf(senderUid).intValue(), pkgSessions);
        return true;
    L5:
        if (pkgSessions.mSessions == null) goto L14;
        if (pkgSessions.mSessions.contains(Integer.valueOf(sessionId)) == false) goto L11;
        Log.e(TAG, "Audio session " + sessionId + " already open for UID: " + senderUid + ", package: " + senderPackageName + ", abort");
        return false;
    L11:
        if (pkgSessions.mPackageName.equals(senderPackageName) == true) goto L15;
        Log.w(TAG, "Inconsistency package names for UID open: " + senderUid + " prev: " + pkgSessions.mPackageName + ", now: " + senderPackageName);
        return false;
    }

    private boolean handleAudioEffectSessionClose(int senderUid, String senderPackageName, int sessionId) {
        Log.d(TAG, senderPackageName + " UID " + senderUid + " close MusicFx session " + sessionId);
        PackageSessions pkgSessions = this.mClientUidSessionMap.get(Integer.valueOf(senderUid).intValue());
        if (pkgSessions != null) goto L7;
        Log.e(TAG, senderPackageName + " UID " + senderUid + " does not exist in map, abort");
        return false;
    L7:
        if (pkgSessions.mPackageName.equals(senderPackageName) == true) goto L11;
        Log.w(TAG, "Inconsistency package names for UID " + senderUid + " close, prev: " + pkgSessions.mPackageName + ", now: " + senderPackageName);
        return false;
    L11:
        if (pkgSessions.mSessions == null) goto L20;
        if (pkgSessions.mSessions.size() == 0) goto L20;
        if (pkgSessions.mSessions.contains(Integer.valueOf(sessionId)) == true) goto L18;
        Log.e(TAG, senderPackageName + " UID " + senderUid + " session " + sessionId + " does not exist in map, abort");
        return false;
    L18:
        pkgSessions.mSessions.remove(Integer.valueOf(sessionId));
    L20:
        if (pkgSessions.mSessions != null) goto L22;
    L25:
        this.mClientUidSessionMap.remove(Integer.valueOf(senderUid).intValue());
        return true;
    L22:
        if (pkgSessions.mSessions.size() == 0) goto L25;
        this.mClientUidSessionMap.put2(Integer.valueOf(senderUid).intValue(), pkgSessions);
        return true;
    }

    private boolean setMusicFxServiceWithObserver(Intent intent, int senderUid, String packageName) {
        int session = intent.getIntExtra("android.media.extra.AUDIO_SESSION", 0);
        if (session != 0) goto L6;
        Log.e(TAG, packageName + " intent have no invalid audio session");
        return false;
    L6:
        Object r1 = this.mClientUidMapLock;
        monitor-enter(r1);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (intent.getAction().equals("android.media.action.OPEN_AUDIO_EFFECT_CONTROL_SESSION") == false) goto L15;
        boolean r2 = handleAudioEffectSessionOpen(senderUid, packageName, session);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return r2;
    L15:
        boolean r3 = handleAudioEffectSessionClose(senderUid, packageName, session);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return r3;
    }

    private int getCurrentUserId() {
        long ident = Binder.clearCallingIdentity();
        UserInfo currentUser = ActivityManager.getService().getCurrentUser();     // Catch: Throwable -> L6 RemoteException -> L8
        int r3 = currentUser.id;     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(ident);
        return r3;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L12:
        Binder.restoreCallingIdentity(ident);
        return 0;
    }

    private void handleEffectClientUidGone(int uid) {
        Object r0 = this.mClientUidMapLock;
        monitor-enter(r0);
        Log.d(TAG, "handle MSG_EFFECT_CLIENT_GONE uid: " + uid + " mapSize: " + this.mClientUidSessionMap.size());     // Catch: Throwable -> L10
        PackageSessions pkgSessions = this.mClientUidSessionMap.get(Integer.valueOf(uid).intValue());     // Catch: Throwable -> L10
        if (pkgSessions == null) goto L13;
        Log.i(TAG, "UID " + uid + " gone, closing all sessions");     // Catch: Throwable -> L10
        Iterator<Integer> r2 = pkgSessions.mSessions.iterator();     // Catch: Throwable -> L10
    L8:
        if (r2.hasNext() == false) goto L12;
        Integer sessionId = r2.next();     // Catch: Throwable -> L10
        Intent closeIntent = new Intent("android.media.action.CLOSE_AUDIO_EFFECT_CONTROL_SESSION");     // Catch: Throwable -> L10
        closeIntent.putExtra("android.media.extra.PACKAGE_NAME", pkgSessions.mPackageName);     // Catch: Throwable -> L10
        closeIntent.putExtra("android.media.extra.AUDIO_SESSION", sessionId);     // Catch: Throwable -> L10
        closeIntent.addFlags(32);     // Catch: Throwable -> L10
        closeIntent.setPackage("com.android.musicfx");     // Catch: Throwable -> L10
        this.mContext.sendBroadcastAsUser(closeIntent, UserHandle.ALL);     // Catch: Throwable -> L10
        goto L8
    L12:
        this.mClientUidSessionMap.remove(Integer.valueOf(uid).intValue());     // Catch: Throwable -> L10
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void handleMessage(Message msg) {
        switch(msg.what) {
            case 1101: goto L5;
            default: goto L4;
        };
    L4:
        Log.e(TAG, "Unexpected msg to handle in MusicFxHelper: " + msg.what);
        return;
    L5:
        Log.w(TAG, " handle MSG_EFFECT_CLIENT_GONE");
        handleEffectClientUidGone(msg.arg1);
    }
}
