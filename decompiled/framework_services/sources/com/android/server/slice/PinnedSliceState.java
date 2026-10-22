package com.android.server.slice;

import android.app.slice.SliceSpec;
import android.content.ContentProviderClient;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class PinnedSliceState {
    private static final long SLICE_TIMEOUT = 5000;
    private static final String TAG = "PinnedSliceState";
    private final IBinder.DeathRecipient mDeathRecipient;
    private final ArrayMap<IBinder, ListenerInfo> mListeners;
    private final Object mLock;
    private final ArraySet<String> mPinnedPkgs;
    private final String mPkg;
    private final SliceManagerService mService;
    private boolean mSlicePinned;
    private SliceSpec[] mSupportedSpecs;
    private final Uri mUri;

    private class ListenerInfo {
        private int callingPid;
        private int callingUid;
        private boolean hasPermission;
        private String pkg;
        private IBinder token;

        /* JADX INFO: renamed from: -$$Nest$fgettoken, reason: not valid java name */
        static /* bridge */ /* synthetic */ IBinder m8145$$Nest$fgettoken(ListenerInfo r0) {
            return r0.token;
        }

        public ListenerInfo(PinnedSliceState r1, IBinder token, String pkg, boolean hasPermission, int callingUid, int callingPid) {
            this.token = token;
            this.pkg = pkg;
            this.hasPermission = hasPermission;
            this.callingUid = callingUid;
            this.callingPid = callingPid;
        }
    }

    public static /* synthetic */ void $r8$lambda$DCA5H6Sv4bXmNR_juJNjjXmRWn8(PinnedSliceState r0) {
        r0.handleRecheckListeners();
    }

    public static /* synthetic */ SliceSpec $r8$lambda$DfieqkDYMgl2K1NU0O7aQymumKU(PinnedSliceState r0, SliceSpec[] r1, SliceSpec r2) {
        return r0.lambda$mergeSpecs$0(r1, r2);
    }

    public static /* synthetic */ SliceSpec[] $r8$lambda$OWFXaUyRhsQPG6ZaknlFzAmmzYU(int r0) {
        return lambda$mergeSpecs$2(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$SjNBGKUrKkjvaXyBLLc7tky4A8I(SliceSpec r0) {
        return lambda$mergeSpecs$1(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$ePeQdEA-arYAbBwmeHdRvMxc5JQ, reason: not valid java name */
    public static /* synthetic */ void m8143$r8$lambda$ePeQdEAarYAbBwmeHdRvMxc5JQ(PinnedSliceState r0) {
        r0.handleSendPinned();
    }

    /* JADX INFO: renamed from: $r8$lambda$nI6MArRsehab2ZA0W-CAv-OcakU, reason: not valid java name */
    public static /* synthetic */ void m8144$r8$lambda$nI6MArRsehab2ZA0WCAvOcakU(PinnedSliceState r0) {
        r0.handleSendUnpinned();
    }

    public PinnedSliceState(SliceManagerService service, Uri uri, String pkg) {
        this.mPinnedPkgs = new ArraySet();
        this.mListeners = new ArrayMap();
        this.mSupportedSpecs = null;
        this.mDeathRecipient = new PinnedSliceState$$ExternalSyntheticLambda0(this);
        this.mService = service;
        this.mUri = uri;
        this.mPkg = pkg;
        this.mLock = this.mService.getLock();
    }

    public String getPkg() {
        return this.mPkg;
    }

    public SliceSpec[] getSpecs() {
        return this.mSupportedSpecs;
    }

    public void mergeSpecs(final SliceSpec[] supportedSpecs) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mSupportedSpecs != null) goto L9;
        this.mSupportedSpecs = supportedSpecs;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        List<SliceSpec> specs = Arrays.asList(this.mSupportedSpecs);     // Catch: Throwable -> L7
        this.mSupportedSpecs = (SliceSpec[]) specs.stream().map(new PinnedSliceState$$ExternalSyntheticLambda3(this, supportedSpecs)).filter(new PinnedSliceState$$ExternalSyntheticLambda4()).toArray(new PinnedSliceState$$ExternalSyntheticLambda5());     // Catch: Throwable -> L7
        goto L10
    }

    private /* synthetic */ SliceSpec lambda$mergeSpecs$0(SliceSpec[] supportedSpecs, SliceSpec s) {
        SliceSpec other = findSpec(supportedSpecs, s.getType());
        if (other != null) goto L7;
        return null;
    L7:
        if (other.getRevision() >= s.getRevision()) goto L9;
        return other;
    L9:
        return s;
    }

    private static /* synthetic */ boolean lambda$mergeSpecs$1(SliceSpec s) {
        if (s == null) goto L4;
        return true;
    L4:
        return false;
    }

    private static /* synthetic */ SliceSpec[] lambda$mergeSpecs$2(int x$0) {
        return new SliceSpec[x$0];
    }

    private SliceSpec findSpec(SliceSpec[] specs, String type) {
        int r0 = specs.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        SliceSpec spec = specs[r1];
        if (Objects.equals(spec.getType(), type) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return spec;
    L8:
        return null;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public void destroy() {
        setSlicePinned(false);
    }

    private void setSlicePinned(boolean pinned) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mSlicePinned != pinned) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mSlicePinned = pinned;     // Catch: Throwable -> L8
        if (pinned == false) goto L13;
        this.mService.getHandler().post(new PinnedSliceState$$ExternalSyntheticLambda1(this));     // Catch: Throwable -> L8
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L13:
        this.mService.getHandler().post(new PinnedSliceState$$ExternalSyntheticLambda2(this));     // Catch: Throwable -> L8
        goto L14
    }

    public void pin(String pkg, SliceSpec[] specs, IBinder token) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        ArrayMap<IBinder, ListenerInfo> r0 = this.mListeners;     // Catch: Throwable -> L15
        r0.put(token, new ListenerInfo(this, token, pkg, true, Binder.getCallingUid(), Binder.getCallingPid()));     // Catch: Throwable -> L9
        token.linkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L9 RemoteException -> L11
    L12:
        mergeSpecs(specs);     // Catch: Throwable -> L9
        setSlicePinned(true);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r10 = th;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r10;
    L15:
        th = move-exception;
        r10 = th;
        goto L17
    }

    public boolean unpin(String pkg, IBinder token) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        token.unlinkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L8
        this.mListeners.remove(token);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return !hasPinOrListener();
    L8:
        th = move-exception;
        throw th;
    }

    public boolean isListening() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mListeners.isEmpty() == true) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public boolean hasPinOrListener() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mPinnedPkgs.isEmpty() == false) goto L12;
        if (this.mListeners.isEmpty() == false) goto L12;
        boolean r1 = false;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L12:
        r1 = true;
        goto L13
    }

    ContentProviderClient getClient() {
        ContentProviderClient client = this.mService.getContext().getContentResolver().acquireUnstableContentProviderClient(this.mUri);
        if (client != null) goto L6;
        return null;
    L6:
        client.setDetectNotResponding(SLICE_TIMEOUT);
        return client;
    }

    private void checkSelfRemove() {
        if (hasPinOrListener() == true) goto L6;
        this.mService.removePinnedSlice(this.mUri);
        return;
    }

    private void handleRecheckListeners() {
        if (hasPinOrListener() == true) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = this.mListeners.size() - 1;     // Catch: Throwable -> L12
    L8:
        if (i < 0) goto L15;
        ListenerInfo l = this.mListeners.valueAt(i);     // Catch: Throwable -> L12
        if (ListenerInfo.m8145$$Nest$fgettoken(l).isBinderAlive() == true) goto L14;
        this.mListeners.removeAt(i);     // Catch: Throwable -> L12
    L14:
        i = i - 1;     // Catch: Throwable -> L12
        goto L8
    L15:
        checkSelfRemove();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void handleSendPinned() {
        ContentProviderClient client = getClient();
        if (client != null) goto L21;
        if (client == null) goto L26;
        client.close();
        return;
    L26:
        return;
    L21:
        Bundle b = new Bundle();     // Catch: Throwable -> L10
        b.putParcelable("slice_uri", this.mUri);     // Catch: Throwable -> L10
        client.call("pin", null, b);     // Catch: Throwable -> L10 Exception -> L12
    L14:
        client.close();
        return;
    L12:
        e = move-exception;
        Log.w(TAG, "Unable to contact " + this.mUri, e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        client.close();     // Catch: Throwable -> L18
    L20:
        throw th;
    L18:
        th = move-exception;
        th.addSuppressed(th);
        goto L20
    }

    private void handleSendUnpinned() {
        ContentProviderClient client = getClient();
        if (client != null) goto L21;
        if (client == null) goto L26;
        client.close();
        return;
    L26:
        return;
    L21:
        Bundle b = new Bundle();     // Catch: Throwable -> L10
        b.putParcelable("slice_uri", this.mUri);     // Catch: Throwable -> L10
        client.call("unpin", null, b);     // Catch: Throwable -> L10 Exception -> L12
    L14:
        client.close();
        return;
    L12:
        e = move-exception;
        Log.w(TAG, "Unable to contact " + this.mUri, e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        client.close();     // Catch: Throwable -> L18
    L20:
        throw th;
    L18:
        th = move-exception;
        th.addSuppressed(th);
        goto L20
    }
}
