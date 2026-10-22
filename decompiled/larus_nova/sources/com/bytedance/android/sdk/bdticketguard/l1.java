package com.bytedance.android.sdk.bdticketguard;

/* JADX INFO: loaded from: classes3.dex */
public final class l1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f163946c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f163947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f163948b;

    public static final class a {
        public static l1 a() {
            return new l1(null);
        }
    }

    static {
    }

    public final boolean a() {
        if (this.f163947a != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("TimedResult(isSuccess=");
        r100.append(a());
        r100.append(", throwable=");
        int r101 = r0.f163979a;
        r100.append(r0.e(this.f163947a));
        r100.append(", timestamp=");
        r100.append(this.f163948b);
        r100.append(')');
        return r100.toString();
    }

    public l1(Throwable r100) {
        long r101 = System.currentTimeMillis();
        this.f163947a = r100;
        this.f163948b = r101;
    }
}
