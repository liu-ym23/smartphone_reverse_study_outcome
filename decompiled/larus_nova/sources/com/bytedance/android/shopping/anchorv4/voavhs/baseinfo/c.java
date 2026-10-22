package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.google.gson.JsonObject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c extends VOIdentifier {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f167952f = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnchorV4BaseInfoDisplay f167953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnchorV4BaseInfoMeta f167954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ComponentDTO f167955d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f167956e;

    public static final class a {
        public static c a(ComponentDTO r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "componentDTO");
            Object r102 = null;
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
            c r104 = new c(0);     // Catch: Throwable -> L13
            VO r105 = r100.getVo();     // Catch: Throwable -> L13
            if (r105 == null) goto L6;
            JsonObject r106 = r105.getDisplay();     // Catch: Throwable -> L13
        L7:
            r104.f167953b = (AnchorV4BaseInfoDisplay) u0.a(r106, AnchorV4BaseInfoDisplay.class);     // Catch: Throwable -> L13
            r104.f167956e = r101;     // Catch: Throwable -> L13
            VO r107 = r100.getVo();     // Catch: Throwable -> L13
            if (r107 == null) goto L10;
            JsonObject r108 = r107.getMeta();     // Catch: Throwable -> L13
        L11:
            r104.f167954c = (AnchorV4BaseInfoMeta) u0.a(r108, AnchorV4BaseInfoMeta.class);     // Catch: Throwable -> L13
            r104.f167955d = r100;     // Catch: Throwable -> L13
            Object r109 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L13
        L16:
            if (Result.m9455isFailureimpl(r109) == true) goto L20;
            r102 = r109;
        L20:
            return (c) r102;
        L10:
            r108 = null;
            goto L11
        L6:
            r106 = null;
        L13:
            th = move-exception;
            Result.Companion r110 = Result.Companion;
            r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L16
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
        if (Intrinsics.areEqual(this.f167953b, r101.f167953b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f167954c, r101.f167954c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f167955d, r101.f167955d) == true) goto L12;
        return false;
    L12:
        if (this.f167956e == r101.f167956e) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        AnchorV4BaseInfoDisplay r100 = this.f167953b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        AnchorV4BaseInfoMeta r104 = this.f167954c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ComponentDTO r107 = this.f167955d;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        boolean r109 = this.f167956e;
        ?? r110 = r109;
        if (r109 == false) goto L17;
        r110 = 1;
    L17:
        return r108 + r110;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorV4BaseInfoVO(display=" + this.f167953b + ", meta=" + this.f167954c + ", component=" + this.f167955d + ", collapseDetail=" + this.f167956e + ")";
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier
    public final String identifier() {
        ComponentDTO r100 = this.f167955d;
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

    public c(int r100) {
        this.f167953b = null;
        this.f167954c = null;
        this.f167955d = null;
        this.f167956e = false;
    }
}
