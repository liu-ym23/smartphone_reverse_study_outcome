package com.bytedance.android.gamecp.common.utils.rx.autodispose;

import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import wwc.c;

/* JADX INFO: loaded from: classes44.dex */
final enum AutoSubscriptionHelper extends Enum<AutoSubscriptionHelper> implements c {
    public static final AutoSubscriptionHelper CANCELLED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AutoSubscriptionHelper[] f57282a = null;

    @Override // wwc.c
    public void cancel() {
    }

    @Override // wwc.c
    public void request(long r100) {
    }

    static {
        AutoSubscriptionHelper r100 = new AutoSubscriptionHelper();
        CANCELLED = r100;
        f57282a = new AutoSubscriptionHelper[]{r100};
    }

    public AutoSubscriptionHelper() {
        super("CANCELLED", 0);
    }

    public static void reportSubscriptionSet() {
        RxJavaPlugins.onError(new IllegalStateException("Subscription already set!"));
    }

    public static AutoSubscriptionHelper[] values() {
        return (AutoSubscriptionHelper[]) f57282a.clone();
    }

    public static boolean cancel(AtomicReference<c> r100) {
        c r101 = r100.get();
        AutoSubscriptionHelper r102 = CANCELLED;
        if (r101 == r102) goto L10;
        c r103 = r100.getAndSet(r102);
        if (r103 == r102) goto L13;
        if (r103 == null) goto L12;
        r103.cancel();
        return true;
    L12:
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public static boolean validate(long r100) {
        if (r100 > 0) goto L6;
        RxJavaPlugins.onError(new IllegalArgumentException("n > 0 required but it was " + r100));
        return false;
    L6:
        return true;
    }

    public static AutoSubscriptionHelper valueOf(String r100) {
        return (AutoSubscriptionHelper) r27.a.a(AutoSubscriptionHelper.class, r100);
    }

    public static boolean setOnce(AtomicReference<c> r100, c r101) {
        if (r101 == null) goto L16;
    L4:
        if (r100.compareAndSet(null, r101) == true) goto L5;
        if (r100.get() == null) goto L4;
        boolean r102 = false;
    L9:
        if (r102 == true) goto L14;
        r101.cancel();
        if (r100.get() == CANCELLED) goto L13;
        reportSubscriptionSet();
    L13:
        return false;
    L14:
        return true;
    L5:
        r102 = true;
        goto L9
    L16:
        throw new NullPointerException("s is null");
    }

    public static void deferredRequest(AtomicReference<c> r100, AtomicLong r110, long r111) {
        c r101 = r100.get();
        if (r101 == null) goto L6;
        r101.request(r111);
        return;
    L6:
        if (validate(r111) == false) goto L26;
    L7:
        long r102 = r110.get();
        long r103 = Long.MAX_VALUE;
        if (r102 == Long.MAX_VALUE) goto L16;
        long r104 = r102 + r111;
        if (r104 < 0) goto L15;
        r103 = r104;
    L15:
        if (r110.compareAndSet(r102, r103) == false) goto L7;
    L16:
        c r105 = r100.get();
        if (r105 == null) goto L27;
        long r112 = r110.getAndSet(0);
        if (r112 == 0) goto L28;
        r105.request(r112);
        return;
    L28:
        return;
    L27:
        return;
    }

    public static boolean deferredSetOnce(AtomicReference<c> r100, AtomicLong r101, c r102) {
        if (setOnce(r100, r102) == false) goto L9;
        long r103 = r101.getAndSet(0);
        if (r103 == 0) goto L11;
        r102.request(r103);
        return true;
    L11:
        return true;
    L9:
        return false;
    }
}
