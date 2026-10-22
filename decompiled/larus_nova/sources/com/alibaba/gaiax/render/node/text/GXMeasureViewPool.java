package com.alibaba.gaiax.render.node.text;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import androidx.core.util.Pools;
import com.alibaba.gaiax.render.view.GXViewExtKt;
import com.alibaba.gaiax.render.view.GXViewFactory;
import com.alibaba.gaiax.render.view.basic.GXText;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/alibaba/gaiax/render/node/text/GXMeasureViewPool;", "", "()V", "CPU_COUNT", "", "MAXIMUM_POOL_SIZE", "cacheInit", "", "cacheLineSpacingExtra", "", "cacheLineSpacingMultiplier", "cacheTextSize", "cacheTypeFace", "Landroid/graphics/Typeface;", "pool", "Landroidx/core/util/Pools$SynchronizedPool;", "Ljava/lang/ref/WeakReference;", "Lcom/alibaba/gaiax/render/view/basic/GXText;", "createTv", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "obtain", "obtainInner", "release", "", "gxText", "resetTv", "view", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXMeasureViewPool {
    private static final int CPU_COUNT = 0;
    public static final GXMeasureViewPool INSTANCE = null;
    private static final int MAXIMUM_POOL_SIZE = 0;
    private static boolean cacheInit;
    private static float cacheLineSpacingExtra;
    private static float cacheLineSpacingMultiplier;
    private static float cacheTextSize;
    private static Typeface cacheTypeFace;
    private static final Pools.SynchronizedPool<WeakReference<GXText>> pool = null;

    private GXMeasureViewPool() {
    }

    static {
        INSTANCE = new GXMeasureViewPool();
        int r100 = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = r100;
        int r101 = (r100 * 2) + 1;
        MAXIMUM_POOL_SIZE = r101;
        pool = new Pools.SynchronizedPool(r101);
    }

    private final GXText createTv(Context r100) {
        GXText r101 = (GXText) GXViewFactory.createView$default(GXViewFactory.INSTANCE, r100, "text", null, 4, null);
        r101.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r101.setPreview(true);
        return r101;
    }

    private final GXText obtainInner(Context r100) {
        WeakReference<GXText> r101 = pool.acquire();
        if (r101 == null) goto L20;
        GXText r102 = r101.get();
        if (r102 == null) goto L18;
        if ((r102.getContext() instanceof Activity) == false) goto L18;
        if (Intrinsics.areEqual(r102.getContext(), r100) == false) goto L11;
        Context r103 = r102.getContext();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.app.Activity");
        if (((Activity) r103).isDestroyed() == true) goto L15;
        return r102;
    L15:
        return createTv(r100);
    L11:
        return createTv(r100);
    L18:
        return createTv(r100);
    L20:
        return createTv(r100);
    }

    private final void resetTv(GXText r100) {
        GXViewExtKt.setTextFontFamily(r100, cacheTypeFace);
        GXViewExtKt.setFontSize(r100, Float.valueOf(cacheTextSize));
        r100.setLineSpacing(cacheLineSpacingExtra, cacheLineSpacingMultiplier);
        r100.setSingleLine(false);
        r100.setMaxLines(Integer.MAX_VALUE);
        r100.setPadding(0, 0, 0, 0);
    }

    public final GXText obtain(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        GXText r101 = obtainInner(r100);
        if (cacheInit == true) goto L5;
        cacheInit = true;
        cacheTypeFace = r101.getTypeface();
        cacheTextSize = r101.getTextSize();
        cacheLineSpacingExtra = r101.getLineSpacingExtra();
        cacheLineSpacingMultiplier = r101.getLineSpacingMultiplier();
    L5:
        return r101;
    }

    public final void release(GXText r100) {
        Intrinsics.checkNotNullParameter(r100, "gxText");
        resetTv(r100);     // Catch: Exception -> L5
        pool.release(new WeakReference(r100));     // Catch: Exception -> L5
        return;
    }
}
