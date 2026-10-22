package com.bytedance.android.shopping.slice.elements.scrollx;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.bytedance.android.ecom.arch.slice.render.elements.list.SlcListElementView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends SlcListElementView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f183325e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f183326f;

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 6, 0);
        this.f183326f = new b(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        b r101 = this.f183326f;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r101.f183331e == false) goto L33;
        int r102 = r100.getActionMasked();
        if (r102 == 0) goto L29;
        boolean r103 = false;
        if (r102 != 1) goto L10;
    L25:
        ViewParent r104 = r101.f183332f.getParent();
        if (r104 == null) goto L28;
        r104.requestDisallowInterceptTouchEvent(false);
    L28:
        r101.f183330d = null;
        goto L33
    L10:
        if (r102 == 2) goto L15;
        if (r102 == 3) goto L25;
    L15:
        if (r101.f183330d != null) goto L22;
        float r105 = Math.abs(r100.getX() - r101.f183328b);
        float r106 = Math.abs(r100.getY() - r101.f183329c);
        float r107 = (r105 * r105) + (r106 * r106);
        float r108 = r101.f183327a;
        if (r107 <= (r108 * r108)) goto L22;
        if (r106 > (r105 * 1.28f)) goto L21;
        r103 = true;
    L21:
        r101.f183330d = Boolean.valueOf(r103);
    L22:
        ViewParent r109 = r101.f183332f.getParent();
        if (r109 == null) goto L33;
        r109.requestDisallowInterceptTouchEvent(!Intrinsics.areEqual(r101.f183330d, Boolean.FALSE));
        goto L33
    L29:
        r101.f183328b = r100.getX();
        r101.f183329c = r100.getY();
        r101.f183330d = null;
        ViewParent r110 = r101.f183332f.getParent();
        if (r110 == null) goto L33;
        r110.requestDisallowInterceptTouchEvent(true);
    L33:
        return super.dispatchTouchEvent(r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.list.SlcListElementView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f183325e == false) goto L5;
        if (r100 == null) goto L8;
        Integer r101 = Integer.valueOf(r100.getActionMasked());
    L9:
        if (r101 == null) goto L15;
        if (r101.intValue() != 2) goto L15;
        return false;
    L15:
        return super.onInterceptTouchEvent(r100);
    L8:
        r101 = null;
        goto L9
    L5:
        return super.onInterceptTouchEvent(r100);
    }
}
