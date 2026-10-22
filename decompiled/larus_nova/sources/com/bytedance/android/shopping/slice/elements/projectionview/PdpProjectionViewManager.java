package com.bytedance.android.shopping.slice.elements.projectionview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.elements.flexbox.SlcFlexElementView;
import com.bytedance.android.ecom.arch.slice.render.elements.flexbox.b;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class PdpProjectionViewManager extends b {

    public final class a implements p {
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.flexbox.b, com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void H0(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.flexbox.b, com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final View A0(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        throw null;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.flexbox.b
    public final SlcFlexElementView J1(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        throw null;
    }

    public static final Bitmap K1(PdpProjectionViewManager r100, View r110, Function1 r111) {
        r100.getClass();
        int r101 = r110.getWidth();
        int r102 = r110.getHeight();
        int r103 = c.f47296a;
        c.d(80);
        if (r101 <= 0) goto L8;
        if (r102 <= 0) goto L8;
        Bitmap r104 = Bitmap.createBitmap(r101, r102, Bitmap.Config.RGB_565);     // Catch: Throwable -> L10
        Canvas r105 = new Canvas(r104);     // Catch: Throwable -> L10
        r111.invoke(Boolean.TRUE);     // Catch: Throwable -> L10
        r110.draw(r105);     // Catch: Throwable -> L10
        r111.invoke(Boolean.FALSE);     // Catch: Throwable -> L10
        Matrix r106 = new Matrix();     // Catch: Throwable -> L10
        r106.postScale(1.0f, -1.0f);     // Catch: Throwable -> L10
        r106.postTranslate(0.0f, r102);     // Catch: Throwable -> L10
        Bitmap r112 = Bitmap.createBitmap(r104, 0, 0, r101, r102, r106, true);     // Catch: Throwable -> L10
        r104.recycle();     // Catch: Throwable -> L10
        Bitmap r107 = Bitmap.createBitmap(r112, 0, 0, r101, c.d(80));     // Catch: Throwable -> L10
        r112.recycle();     // Catch: Throwable -> L10
        return r107;
    L8:
        return null;
    }
}
