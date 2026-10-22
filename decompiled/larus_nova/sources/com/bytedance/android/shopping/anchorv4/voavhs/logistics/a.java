package com.bytedance.android.shopping.anchorv4.voavhs.logistics;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.google.gson.JsonObject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends VOIdentifier {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f169981e = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnchorV4LogisticsAndCouponDisplay f169982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnchorV4LogisticsAndCouponMeta f169983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ComponentDTO f169984d;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.voavhs.logistics.a$a, reason: collision with other inner class name */
    public static final class C2554a {
        public static a a(ComponentDTO r100) {
            Intrinsics.checkNotNullParameter(r100, "componentDTO");
            Object r101 = null;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
            a r103 = new a(0);     // Catch: Throwable -> L13
            VO r104 = r100.getVo();     // Catch: Throwable -> L13
            if (r104 == null) goto L6;
            JsonObject r105 = r104.getDisplay();     // Catch: Throwable -> L13
        L7:
            r103.f169982b = (AnchorV4LogisticsAndCouponDisplay) u0.a(r105, AnchorV4LogisticsAndCouponDisplay.class);     // Catch: Throwable -> L13
            VO r106 = r100.getVo();     // Catch: Throwable -> L13
            if (r106 == null) goto L10;
            JsonObject r107 = r106.getMeta();     // Catch: Throwable -> L13
        L11:
            r103.f169983c = (AnchorV4LogisticsAndCouponMeta) u0.a(r107, AnchorV4LogisticsAndCouponMeta.class);     // Catch: Throwable -> L13
            r103.f169984d = r100;     // Catch: Throwable -> L13
            Object r108 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L13
        L16:
            if (Result.m9455isFailureimpl(r108) == true) goto L20;
            r101 = r108;
        L20:
            return (a) r101;
        L10:
            r107 = null;
            goto L11
        L6:
            r105 = null;
        L13:
            th = move-exception;
            Result.Companion r109 = Result.Companion;
            r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L16
        }
    }

    static {
    }

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f169982b, r101.f169982b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f169983c, r101.f169983c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f169984d, r101.f169984d) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        AnchorV4LogisticsAndCouponDisplay r100 = this.f169982b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        AnchorV4LogisticsAndCouponMeta r104 = this.f169983c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ComponentDTO r107 = this.f169984d;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorV4LogisticsAndCouponVO(display=" + this.f169982b + ", meta=" + this.f169983c + ", component=" + this.f169984d + ")";
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier
    public final String identifier() {
        ComponentDTO r100 = this.f169984d;
        if (r100 == null) goto L5;
        String r101 = r100.getComponentId();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public a(int r100) {
        this.f169982b = null;
        this.f169983c = null;
        this.f169984d = null;
    }
}
