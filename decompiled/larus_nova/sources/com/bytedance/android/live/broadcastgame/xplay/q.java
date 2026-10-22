package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.livesdk.utils.r2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f62336c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final XplayErrorCode f62337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ErrorCodeException f62338b;

    public static final class a {
        public a() {
        }

        public static q d(a r100, Integer r101, String r102) {
            r100.getClass();
            return a(XplayErrorCode.XPLAY_INTERNAL_ERROR, r101, r102, null);
        }

        public static q a(XplayErrorCode r100, Integer r101, String r102, Throwable r103) {
            Intrinsics.checkNotNullParameter(r100, "xplayErrorCode");
            if (r101 != null) goto L10;
            if (r103 != null) goto L10;
            if (r102 != null) goto L10;
            throw new IllegalArgumentException("confirm arguments");
        L10:
            return new q(r100, new ErrorCodeException(r101, r102, r103));
        }

        public static q c(a r100, Integer r101, Throwable r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r101 = null;
        L6:
            if ((r103 & 4) == 0) goto L8;
            r102 = null;
        L8:
            r100.getClass();
            return a(XplayErrorCode.UNKNOWN, r101, null, r102);
        }

        public static /* synthetic */ q b(a r100, XplayErrorCode r101, Integer r102, String r103, Throwable r104, int r105) {
            if ((r105 & 2) == 0) goto L6;
            r102 = null;
        L6:
            if ((r105 & 4) == 0) goto L9;
            r103 = null;
        L9:
            if ((r105 & 8) == 0) goto L11;
            r104 = null;
        L11:
            r100.getClass();
            return a(r101, r102, r103, r104);
        }
    }

    static {
        f62336c = new a();
    }

    public final int a() {
        XplayErrorCode r100 = this.f62337a;
        if (r100 != XplayErrorCode.XPLAY_INTERNAL_ERROR) goto L8;
        ErrorCodeException r101 = this.f62338b;
        if (r101 == null) goto L8;
        return r101.getCode();
    L8:
        return r100.getCode();
    }

    public final String b() {
        ErrorCodeException r100 = this.f62338b;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getMsg();
    L7:
        if (r2.a(r102) == false) goto L13;
        StringBuilder r103 = new StringBuilder();
        r103.append(this.f62337a.getErrorMsg());
        r103.append(": ");
        ErrorCodeException r104 = this.f62338b;
        if (r104 == null) goto L11;
        r101 = r104.getMsg();
    L11:
        r103.append(r101);
        return r103.toString();
    L13:
        return this.f62337a.getErrorMsg();
    L5:
        r102 = null;
        goto L7
    }

    public q(XplayErrorCode r100, ErrorCodeException r101) {
        this.f62337a = r100;
        this.f62338b = r101;
    }
}
