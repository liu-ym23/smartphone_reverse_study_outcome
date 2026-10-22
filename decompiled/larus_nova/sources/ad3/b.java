package ad3;

import android.content.Context;
import android.view.ViewTreeObserver;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.SlcAsyncImageElementView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b extends SlcAsyncImageElementView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f3007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3010e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SlcTemplateContext f3012g;

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.SlcAsyncImageElementView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewTreeObserver r100 = getViewTreeObserver();
        if (r100.isAlive() == true) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L9;
        r100.addOnPreDrawListener(this.f3007b);
        return;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.SlcAsyncImageElementView, android.view.View
    public final void onDetachedFromWindow() {
        ViewTreeObserver r100 = getViewTreeObserver();
        if (r100.isAlive() == true) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L8;
        r100.removeOnPreDrawListener(this.f3007b);
    L8:
        super.onDetachedFromWindow();
    }

    public final int getCurrentTopMargin() {
        return this.f3008c;
    }

    public final int getCurrentTopMax() {
        return this.f3009d;
    }

    public final void c(int r100) {
        int r101 = this.f3008c;
        if (r101 != r100) goto L6;
        return;
    L6:
        if (r101 == this.f3009d) goto L8;
    L10:
        this.f3008c = r100;
        setTranslationY(r100);
        return;
    L8:
        if (this.f3011f != 2) goto L10;
    }

    public final void setMaxMargin(double r100) {
        this.f3009d = com.bytedance.android.shopping.extensions.b.b(Double.valueOf(r100));
    }

    public final void setStartMargin(double r100) {
        this.f3010e = com.bytedance.android.shopping.extensions.b.b(Double.valueOf(r100));
    }

    public b(SlcTemplateContext r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "templateCtx");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r101, null, 0);
        this.f3012g = r100;
        this.f3007b = new a(this);
        this.f3011f = 1;
    }
}
