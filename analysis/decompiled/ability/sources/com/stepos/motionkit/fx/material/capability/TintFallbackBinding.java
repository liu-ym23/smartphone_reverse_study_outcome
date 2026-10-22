package com.stepos.motionkit.fx.material.capability;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.fx.material.MaterialBinding;
import com.stepos.motionkit.fx.material.MaterialParams;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00020\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/stepos/motionkit/fx/material/capability/TintFallbackBinding;", "Lcom/stepos/motionkit/fx/material/MaterialBinding;", "Landroid/view/View;", "view", AppAgent.CONSTRUCT, "(Landroid/view/View;)V", "Lcom/stepos/motionkit/fx/material/MaterialParams;", "params", "LC7/r;", "update", "(Lcom/stepos/motionkit/fx/material/MaterialParams;)V", "release", "()V", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "viewRef", "Ljava/lang/ref/WeakReference;", "Landroid/graphics/drawable/GradientDrawable;", "drawable", "Landroid/graphics/drawable/GradientDrawable;", "Landroid/graphics/drawable/Drawable;", "previousBackground", "Landroid/graphics/drawable/Drawable;", "Companion", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
final class TintFallbackBinding implements MaterialBinding {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int FILL_COLOR = -434431205;

    @Deprecated
    public static final int STROKE_COLOR = 620756991;

    @Deprecated
    public static final int STROKE_WIDTH_PX = 1;
    private final GradientDrawable drawable;
    private final Drawable previousBackground;
    private final WeakReference<View> viewRef;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stepos/motionkit/fx/material/capability/TintFallbackBinding$Companion;", "", AppAgent.CONSTRUCT, "()V", "STROKE_WIDTH_PX", "", "FILL_COLOR", "STROKE_COLOR", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public TintFallbackBinding(View view) {
        k.f(view, "view");
        this.viewRef = new WeakReference<>(view);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        this.drawable = gradientDrawable;
        this.previousBackground = view.getBackground();
        view.setBackground(gradientDrawable);
    }

    @Override // com.stepos.motionkit.fx.material.MaterialBinding
    public void onFrame(long j5, float f) {
        MaterialBinding.DefaultImpls.onFrame(this, j5, f);
    }

    @Override // com.stepos.motionkit.fx.material.MaterialBinding
    public void release() {
        View view = this.viewRef.get();
        if (view != null && view.getBackground() == this.drawable) {
            view.setBackground(this.previousBackground);
        }
    }

    @Override // com.stepos.motionkit.fx.material.MaterialBinding
    public void update(MaterialParams params) {
        View view;
        k.f(params, "params");
        BlurParams blurParams = params instanceof BlurParams ? (BlurParams) params : null;
        if (blurParams == null || (view = this.viewRef.get()) == null) {
            return;
        }
        this.drawable.setCornerRadius(blurParams.getCornerRadius());
        this.drawable.setColor(FILL_COLOR);
        this.drawable.setStroke(1, STROKE_COLOR);
        view.invalidate();
    }
}
