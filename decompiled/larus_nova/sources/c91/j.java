package c91;

import android.animation.ValueAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f22842a;

    public j(a r100) {
        this.f22842a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        ImageView r101 = this.f22842a.f22825c;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L23;
        r101.setAlpha(((Float) r102).floatValue());
        HSImageView r103 = this.f22842a.f22829g;
        Object r104 = r100.getAnimatedValue();
        if (r104 == null) goto L21;
        r103.setAlpha(((Float) r104).floatValue());
        TextView r105 = this.f22842a.f22827e;
        Object r106 = r100.getAnimatedValue();
        if (r106 == null) goto L19;
        r105.setAlpha(((Float) r106).floatValue() * 0.9f);
        TextView r107 = this.f22842a.f22828f;
        Object r108 = r100.getAnimatedValue();
        if (r108 == null) goto L17;
        r107.setAlpha(((Float) r108).floatValue() * 0.7f);
        ImageView r109 = this.f22842a.f22831i;
        Object r110 = r100.getAnimatedValue();
        if (r110 == null) goto L15;
        r109.setAlpha(((Float) r110).floatValue());
        this.f22842a.f22825c.requestLayout();
        this.f22842a.f22829g.requestLayout();
        this.f22842a.f22827e.requestLayout();
        this.f22842a.f22828f.requestLayout();
        this.f22842a.f22831i.requestLayout();
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L21:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L23:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
