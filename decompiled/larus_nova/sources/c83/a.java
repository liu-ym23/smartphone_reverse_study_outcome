package c83;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.bytedance.android.shopping.anchorv4.voavhs.deletedproducttip.AnchorV4DeletedProductTipDisplay;
import com.google.gson.JsonObject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends VOIdentifier {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f22709d = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnchorV4DeletedProductTipDisplay f22710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ComponentDTO f22711c;

    /* JADX INFO: renamed from: c83.a$a, reason: collision with other inner class name */
    public static final class C0414a {
        public static a a(ComponentDTO r100) {
            Intrinsics.checkNotNullParameter(r100, "componentDTO");
            Object r101 = null;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
            a r103 = new a(0);     // Catch: Throwable -> L9
            VO r104 = r100.getVo();     // Catch: Throwable -> L9
            if (r104 == null) goto L6;
            JsonObject r105 = r104.getDisplay();     // Catch: Throwable -> L9
        L7:
            r103.f22710b = (AnchorV4DeletedProductTipDisplay) u0.a(r105, AnchorV4DeletedProductTipDisplay.class);     // Catch: Throwable -> L9
            r103.f22711c = r100;     // Catch: Throwable -> L9
            Object r106 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
        L12:
            if (Result.m9455isFailureimpl(r106) == true) goto L16;
            r101 = r106;
        L16:
            return (a) r101;
        L6:
            r105 = null;
        L9:
            th = move-exception;
            Result.Companion r107 = Result.Companion;
            r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L12
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
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f22710b, r101.f22710b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f22711c, r101.f22711c) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        AnchorV4DeletedProductTipDisplay r100 = this.f22710b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ComponentDTO r104 = this.f22711c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorV4DeletedProductTipVO(display=" + this.f22710b + ", component=" + this.f22711c + ")";
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier
    public final String identifier() {
        ComponentDTO r100 = this.f22711c;
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
        this.f22710b = null;
        this.f22711c = null;
    }
}
