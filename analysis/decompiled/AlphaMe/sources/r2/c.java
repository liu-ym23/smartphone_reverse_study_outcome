package r2;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RenderEffect;
import android.graphics.RenderNode;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.app.C0186l;
import androidx.fragment.app.A;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import com.stepos.renderfilter.RenderFilter;
import com.stepos.renderfilter.functor.Functor;
import com.stepos.renderfilter.functor.FunctorApi31Impl;
import java.util.LinkedList;
import s2.C0855a;

/* loaded from: classes.dex */
public abstract class c extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final d f14077a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f14078b;

    /* renamed from: c, reason: collision with root package name */
    public int f14079c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final C0186l f14080d = new C0186l(toString());

    public c(C0829a c0829a) {
        RenderFilter.b().a();
        Paint paint = new Paint();
        this.f14078b = paint;
        paint.setAntiAlias(true);
        paint.setColor(0);
        this.f14077a = c0829a;
        c0829a.f14082b = this;
        LinkedList linkedList = new LinkedList();
        C0855a c0855a = new C0855a();
        linkedList.add(c0829a.f14076h);
        s2.b bVar = new s2.b();
        c0829a.f14084d = bVar;
        c0829a.f14083c = new A2.a(c0855a, linkedList, bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v9, types: [B2.a, java.lang.Runnable] */
    @Override // android.graphics.drawable.Drawable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void draw(Canvas canvas) {
        boolean z4 = RenderFilter.f12295f;
        C0186l c0186l = this.f14080d;
        if (z4 || !(!RenderFilter.isFunctorAvailable())) {
            boolean z5 = RenderFilter.f12295f;
            d dVar = this.f14077a;
            if (z5) {
                dVar.getClass();
            } else {
                FunctorApi31Impl functorApi31Impl = dVar.f14081a;
                if (functorApi31Impl != null) {
                    if (Functor.f12304e == null) {
                        try {
                            Functor.f12304e = functorApi31Impl.e();
                        } catch (Exception e4) {
                            throw new A("createCallDrawFunctorMethod failed", 6, e4);
                        }
                    }
                    if (functorApi31Impl.d()) {
                        try {
                            functorApi31Impl.f(Functor.f12304e, canvas);
                            Object obj = c0186l.f2661c;
                            if (((RenderNode) obj) != null) {
                                try {
                                    canvas.drawRenderNode((RenderNode) obj);
                                    return;
                                } catch (Exception unused) {
                                    return;
                                }
                            }
                            return;
                        } catch (Exception e5) {
                            Log.e("RenderFilter", "invokeCallDrawFunctor failed", e5);
                        }
                    }
                }
            }
            float fWidth = getBounds().width();
            float fHeight = getBounds().height();
            float f4 = this.f14079c;
            canvas.drawRoundRect(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, fWidth, fHeight, f4, f4, this.f14078b);
            return;
        }
        C0830b c0830b = (C0830b) this;
        final float f5 = ((C0829a) c0830b.f14077a).f14073e;
        final int i4 = c0830b.f14079c;
        Drawable.Callback callback = c0830b.getCallback();
        final View view = callback instanceof View ? (View) callback : 0;
        if (view != 0) {
            B2.c cVar = (B2.c) view.getTag(R.id.renderfilter_platform_blur_token);
            if (cVar == null) {
                cVar = new B2.c();
                cVar.f212a = Float.NaN;
                cVar.f213b = Integer.MIN_VALUE;
                view.setTag(R.id.renderfilter_platform_blur_token, cVar);
            }
            float f6 = cVar.f212a;
            if (((!Float.isNaN(f6) || !Float.isNaN(f5)) && Math.abs(f6 - f5) >= 0.25f) || cVar.f213b != i4) {
                cVar.f212a = f5;
                cVar.f213b = i4;
                B2.a aVar = cVar.f214c;
                if (aVar != null) {
                    view.removeCallbacks(aVar);
                }
                ?? r4 = new Runnable() { // from class: B2.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        float fMin = Math.min(Math.max(Property.DEFAULT_FLOAT_VALUE, f5), 150.0f);
                        RenderEffect renderEffectCreateBlurEffect = fMin > Property.DEFAULT_FLOAT_VALUE ? RenderEffect.createBlurEffect(fMin, fMin, Shader.TileMode.MIRROR) : null;
                        View view2 = view;
                        view2.setRenderEffect(renderEffectCreateBlurEffect);
                        int i5 = i4;
                        if (i5 > 0) {
                            view2.setOutlineProvider(new b(i5));
                            view2.setClipToOutline(true);
                        } else {
                            view2.setClipToOutline(false);
                            view2.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
                        }
                    }
                };
                cVar.f214c = r4;
                view.post(r4);
            }
        }
        int iWidth = c0830b.getBounds().width();
        int iHeight = c0830b.getBounds().height();
        float f7 = c0830b.f14079c;
        canvas.drawRoundRect(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, iWidth, iHeight, f7, f7, c0830b.f14078b);
        Object obj2 = c0186l.f2661c;
        if (((RenderNode) obj2) != null) {
            try {
                canvas.drawRenderNode((RenderNode) obj2);
            } catch (Exception unused2) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final int getOpacity() {
        return getAlpha() == 255 ? -1 : -3;
    }

    @Override // android.graphics.drawable.Drawable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final void setAlpha(int i4) {
        this.f14077a.f14084d.f14235k = i4;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final void setBounds(int i4, int i5, int i6, int i7) {
        super.setBounds(i4, i5, i6, i7);
        RenderNode renderNode = (RenderNode) this.f14080d.f2661c;
        if (renderNode != null) {
            renderNode.setPosition(i4, i5, i6, i7);
        }
    }

    @Override // android.graphics.drawable.Drawable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f14078b.setColorFilter(colorFilter);
    }
}
