package stepos.support.v7.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import com.stepos.aiengine.R;
import java.util.WeakHashMap;
import v0.h0;
import v0.i0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class a0 extends androidx.appcompat.widget.p implements i0 {

    /* renamed from: j, reason: collision with root package name */
    public static final PathInterpolator f12699j = new PathInterpolator(0.18f, 0.367f, 0.0f, 1.0f);

    /* renamed from: d, reason: collision with root package name */
    public boolean f12700d;

    /* renamed from: e, reason: collision with root package name */
    public k.g f12701e;
    public Matrix h;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a0.this.getClass();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface b {
    }

    public a0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.steposTabContainerCollapseButtonStyle);
    }

    @Override // v0.i0
    public final void d(View view) {
        if (this.f12700d) {
            WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
            setRotation(0.0f);
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        super.onLayout(z, i10, i11, i12, i13);
        setPivotX(getMeasuredWidth() / 2);
        setPivotY(getMeasuredHeight() / 2);
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        return true;
    }

    public void setCollapsed(boolean z) {
        h0 h0VarA;
        if (this.f12700d != z) {
            this.f12700d = z;
            k.g gVar = this.f12701e;
            if (gVar != null) {
                gVar.a();
            }
            k.g gVar2 = new k.g();
            if (z) {
                WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
                setRotation(180.0f);
                h0VarA = v0.e0.a(this);
                View view = h0VarA.f13288a.get();
                if (view != null) {
                    view.animate().rotation(360.0f);
                }
            } else {
                WeakHashMap<View, h0> weakHashMap2 = v0.e0.f13274a;
                setRotation(0.0f);
                h0VarA = v0.e0.a(this);
                View view2 = h0VarA.f13288a.get();
                if (view2 != null) {
                    view2.animate().rotation(180.0f);
                }
            }
            h0VarA.d(f12699j);
            h0VarA.c(350L);
            gVar2.b(h0VarA);
            gVar2.e(this);
            this.f12701e = gVar2;
            gVar2.f();
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        if (getScaleType() == ImageView.ScaleType.MATRIX && this.h == null) {
            this.h = new Matrix();
        }
    }

    public a0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12700d = true;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        setOnClickListener(new a());
        setBackgroundDrawable(null);
    }

    @Override // v0.i0
    public final void c() {
    }

    @Override // v0.i0
    public final void e(View view) {
    }

    public void setOnTabCollapseButtonClickListener(b bVar) {
    }
}
