package ay2;

import am3.g;
import am3.h;
import com.bytedance.android.live.recharge.platform.business.model.diamond.e;
import com.bytedance.android.live.wallet.model.queryorder.c;
import com.bytedance.android.livesdkapi.depend.model.IChargeDeal;
import java.lang.reflect.Type;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends com.bytedance.tools.kcp.modelx.runtime.internal.decode.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16738a = null;

    static {
        f16738a = new a();
    }

    public a() {
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.decode.a
    public final Pair<Integer, Type> b(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "name");
        if (r100 == 0) goto L24;
        if (r100 == 1) goto L17;
        if (r100 == 2) goto L10;
        return TuplesKt.to(-1, Object.class);
    L10:
        if (r101.hashCode() != (-163755499)) goto L33;
        if (r101.equals("icon_image") == false) goto L33;
        return TuplesKt.to(13, k.class);
    L33:
        return com.bytedance.tools.kcp.modelx.runtime.internal.decode.a.C3795a.c(IChargeDeal.class, r101);
    L17:
        if (r101.hashCode() != (-163755499)) goto L35;
        if (r101.equals("icon_image") == false) goto L35;
        return TuplesKt.to(8, k.class);
    L35:
        return com.bytedance.tools.kcp.modelx.runtime.internal.decode.a.C3795a.c(e.class, r101);
    L24:
        if (r101.hashCode() != 1261103851) goto L30;
        if (r101.equals("success_toast") == false) goto L30;
        return TuplesKt.to(10, String.class);
    L30:
        return com.bytedance.tools.kcp.modelx.runtime.internal.decode.a.C3795a.c(c.class, r101);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.decode.a
    public final Object a(int r100, int r101, g r102) {
        Intrinsics.checkNotNullParameter(r102, "reader");
        if (r100 == 0) goto L21;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L11;
        h.e(r102);
        return null;
    L11:
        if (r101 == 13) goto L14;
        return null;
    L14:
        return (k) com.bytedance.tools.kcp.modelx.runtime.internal.decode.a.C3795a.a(k.class, r102);
    L16:
        if (r101 == 8) goto L19;
        return null;
    L19:
        return (k) com.bytedance.tools.kcp.modelx.runtime.internal.decode.a.C3795a.a(k.class, r102);
    L21:
        if (r101 == 10) goto L24;
        return null;
    L24:
        return h.c(r102);
    }
}
