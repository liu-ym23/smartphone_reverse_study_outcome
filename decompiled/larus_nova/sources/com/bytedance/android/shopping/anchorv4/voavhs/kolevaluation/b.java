package com.bytedance.android.shopping.anchorv4.voavhs.kolevaluation;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.google.gson.JsonObject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b extends VOIdentifier {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f169942e = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnchorV4KolEvaluationDisplay f169943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AnchorV4KolEvaluationMeta f169944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ComponentDTO f169945d;

    public static final class a {
        public static b a(ComponentDTO r100) {
            Intrinsics.checkNotNullParameter(r100, "componentDTO");
            Object r101 = null;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
            new b(null, null, null);     // Catch: Throwable -> L13
            VO r103 = r100.getVo();     // Catch: Throwable -> L13
            if (r103 == null) goto L6;
            JsonObject r104 = r103.getDisplay();     // Catch: Throwable -> L13
        L7:
            AnchorV4KolEvaluationDisplay r105 = (AnchorV4KolEvaluationDisplay) u0.a(r104, AnchorV4KolEvaluationDisplay.class);     // Catch: Throwable -> L13
            VO r106 = r100.getVo();     // Catch: Throwable -> L13
            if (r106 == null) goto L10;
            JsonObject r107 = r106.getMeta();     // Catch: Throwable -> L13
        L11:
            Object r108 = Result.m9449constructorimpl(new b(r105, (AnchorV4KolEvaluationMeta) u0.a(r107, AnchorV4KolEvaluationMeta.class), r100));     // Catch: Throwable -> L13
        L16:
            if (Result.m9455isFailureimpl(r108) == true) goto L20;
            r101 = r108;
        L20:
            return (b) r101;
        L10:
            r107 = null;
            goto L11
        L6:
            r104 = null;
        L13:
            th = move-exception;
            Result.Companion r109 = Result.Companion;
            r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L16
        }
    }

    static {
    }

    public b() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f169943b, r101.f169943b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f169944c, r101.f169944c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f169945d, r101.f169945d) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        AnchorV4KolEvaluationDisplay r100 = this.f169943b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        AnchorV4KolEvaluationMeta r104 = this.f169944c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ComponentDTO r107 = this.f169945d;
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
        return "AnchorV4KolEvaluationVO(display=" + this.f169943b + ", meta=" + this.f169944c + ", component=" + this.f169945d + ")";
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier
    public final String identifier() {
        ComponentDTO r100 = this.f169945d;
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

    public b(AnchorV4KolEvaluationDisplay r100, AnchorV4KolEvaluationMeta r101, ComponentDTO r102) {
        this.f169943b = r100;
        this.f169944c = r101;
        this.f169945d = r102;
    }
}
