package com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.UI;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.google.gson.JsonObject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c extends VOIdentifier {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f170051f = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnchorV4ReceivingNoticeDisplay f170052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnchorV4ReceivingNoticeMeta f170053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ComponentDTO f170054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.dto.business.a f170055e;

    public static final class a {
        public static c a(ComponentDTO r100) {
            Intrinsics.checkNotNullParameter(r100, "componentDTO");
            Object r101 = null;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L17
            c r103 = new c(0);     // Catch: Throwable -> L17
            VO r104 = r100.getVo();     // Catch: Throwable -> L17
            if (r104 == null) goto L6;
            JsonObject r105 = r104.getDisplay();     // Catch: Throwable -> L17
        L7:
            r103.f170052b = (AnchorV4ReceivingNoticeDisplay) u0.a(r105, AnchorV4ReceivingNoticeDisplay.class);     // Catch: Throwable -> L17
            VO r106 = r100.getVo();     // Catch: Throwable -> L17
            if (r106 == null) goto L10;
            JsonObject r107 = r106.getMeta();     // Catch: Throwable -> L17
        L11:
            r103.f170053c = (AnchorV4ReceivingNoticeMeta) u0.a(r107, AnchorV4ReceivingNoticeMeta.class);     // Catch: Throwable -> L17
            r103.f170054d = r100;     // Catch: Throwable -> L17
            UI r108 = r100.getUi();     // Catch: Throwable -> L17
            if (r108 == null) goto L14;
            com.bytedance.android.shopping.anchorv4.dto.business.a r109 = r108.getStyle();     // Catch: Throwable -> L17
        L15:
            r103.f170055e = r109;     // Catch: Throwable -> L17
            Object r110 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L17
        L20:
            if (Result.m9455isFailureimpl(r110) == true) goto L24;
            r101 = r110;
        L24:
            return (c) r101;
        L14:
            r109 = null;
            goto L15
        L10:
            r107 = null;
            goto L11
        L6:
            r105 = null;
        L17:
            th = move-exception;
            Result.Companion r111 = Result.Companion;
            r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L20
        }
    }

    static {
    }

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L14;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f170052b, r101.f170052b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f170053c, r101.f170053c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f170054d, r101.f170054d) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f170055e, r101.f170055e) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        AnchorV4ReceivingNoticeDisplay r100 = this.f170052b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        AnchorV4ReceivingNoticeMeta r104 = this.f170053c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ComponentDTO r107 = this.f170054d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        com.bytedance.android.shopping.anchorv4.dto.business.a r110 = this.f170055e;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorV4ReceivingNoticeVO(display=" + this.f170052b + ", meta=" + this.f170053c + ", component=" + this.f170054d + ", style=" + this.f170055e + ")";
    }

    public c(int r100) {
        this.f170052b = null;
        this.f170053c = null;
        this.f170054d = null;
        this.f170055e = null;
    }
}
