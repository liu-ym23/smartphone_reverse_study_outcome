package a2;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

/* renamed from: a2.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1223k extends AppCompatImageView {
    private ViewOnTouchListenerC1224l attacher;
    private ImageView.ScaleType pendingScaleType;

    public C1223k(Context context) {
        this(context, null);
    }

    private void init() {
        this.attacher = new ViewOnTouchListenerC1224l(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.pendingScaleType;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.pendingScaleType = null;
        }
    }

    public ViewOnTouchListenerC1224l getAttacher() {
        return this.attacher;
    }

    public RectF getDisplayRect() {
        return this.attacher.B();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.attacher.E();
    }

    public float getMaximumScale() {
        return this.attacher.H();
    }

    public float getMediumScale() {
        return this.attacher.I();
    }

    public float getMinimumScale() {
        return this.attacher.J();
    }

    public float getScale() {
        return this.attacher.K();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.attacher.L();
    }

    public void setAllowParentInterceptOnEdge(boolean z10) {
        this.attacher.O(z10);
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i10, int i11, int i12, int i13) {
        boolean frame = super.setFrame(i10, i11, i12, i13);
        if (frame) {
            this.attacher.l0();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        ViewOnTouchListenerC1224l viewOnTouchListenerC1224l = this.attacher;
        if (viewOnTouchListenerC1224l != null) {
            viewOnTouchListenerC1224l.l0();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i10) {
        super.setImageResource(i10);
        ViewOnTouchListenerC1224l viewOnTouchListenerC1224l = this.attacher;
        if (viewOnTouchListenerC1224l != null) {
            viewOnTouchListenerC1224l.l0();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        ViewOnTouchListenerC1224l viewOnTouchListenerC1224l = this.attacher;
        if (viewOnTouchListenerC1224l != null) {
            viewOnTouchListenerC1224l.l0();
        }
    }

    public void setMaximumScale(float f10) {
        this.attacher.Q(f10);
    }

    public void setMediumScale(float f10) {
        this.attacher.R(f10);
    }

    public void setMinimumScale(float f10) {
        this.attacher.S(f10);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.attacher.T(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.attacher.U(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.attacher.V(onLongClickListener);
    }

    public void setOnMatrixChangeListener(InterfaceC1216d interfaceC1216d) {
        this.attacher.W(interfaceC1216d);
    }

    public void setOnOutsidePhotoTapListener(InterfaceC1217e interfaceC1217e) {
        this.attacher.X(interfaceC1217e);
    }

    public void setOnPhotoTapListener(InterfaceC1218f interfaceC1218f) {
        this.attacher.Y(interfaceC1218f);
    }

    public void setOnScaleChangeListener(InterfaceC1219g interfaceC1219g) {
        this.attacher.Z(interfaceC1219g);
    }

    public void setOnSingleFlingListener(InterfaceC1220h interfaceC1220h) {
        this.attacher.a0(interfaceC1220h);
    }

    public void setOnViewDragListener(InterfaceC1221i interfaceC1221i) {
        this.attacher.b0(interfaceC1221i);
    }

    public void setOnViewTapListener(InterfaceC1222j interfaceC1222j) {
        this.attacher.c0(interfaceC1222j);
    }

    public void setRotationBy(float f10) {
        this.attacher.d0(f10);
    }

    public void setRotationTo(float f10) {
        this.attacher.e0(f10);
    }

    public void setScale(float f10) {
        this.attacher.f0(f10);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        ViewOnTouchListenerC1224l viewOnTouchListenerC1224l = this.attacher;
        if (viewOnTouchListenerC1224l == null) {
            this.pendingScaleType = scaleType;
        } else {
            viewOnTouchListenerC1224l.i0(scaleType);
        }
    }

    public void setZoomTransitionDuration(int i10) {
        this.attacher.j0(i10);
    }

    public void setZoomable(boolean z10) {
        this.attacher.k0(z10);
    }

    public C1223k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C1223k(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        init();
    }
}
