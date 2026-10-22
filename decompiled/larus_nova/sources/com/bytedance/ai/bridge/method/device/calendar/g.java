package com.bytedance.ai.bridge.method.device.calendar;

import com.bytedance.timon.calendar.ResultCode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f35466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ResultCode f35467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f35468c;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35469a = null;

        static {
            int[] r100 = new int[ResultCode.values().length];
            r100[ResultCode.NoPermission.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[ResultCode.NoRequestPermissionInvoker.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[ResultCode.ArgumentError.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[ResultCode.NoAccount.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[ResultCode.NotFound.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[ResultCode.StoreError.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[ResultCode.Unknown.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[ResultCode.Success.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f35469a = r100;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f35466a == r101.f35466a) goto L12;
        return false;
    L12:
        if (this.f35467b == r101.f35467b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f35468c, r101.f35468c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f35466a == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + this.f35467b.hashCode()) * 31) + this.f35468c.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "CalendarWriteResult(succeed=" + this.f35466a + ", code=" + this.f35467b + ", message=" + this.f35468c + ')';
    }

    public g(boolean r100, ResultCode r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "code");
        Intrinsics.checkNotNullParameter(r102, "message");
        this.f35466a = r100;
        this.f35467b = r101;
        this.f35468c = r102;
    }
}
