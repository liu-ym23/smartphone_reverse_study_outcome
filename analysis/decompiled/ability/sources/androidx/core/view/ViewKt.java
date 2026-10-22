package androidx.core.view;

import D7.t;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a*\u0010\u0004\u001a\u00020\u0002*\u00020\u00002\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a*\u0010\u0006\u001a\u00020\u0002*\u00020\u00002\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0006\u0010\u0005\u001a*\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0086\b¢\u0006\u0004\b\b\u0010\t\u001a*\u0010\n\u001a\u00020\u0002*\u00020\u00002\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0086\b¢\u0006\u0004\b\n\u0010\u0005\u001a*\u0010\u000b\u001a\u00020\u0002*\u00020\u00002\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0086\b¢\u0006\u0004\b\u000b\u0010\u0005\u001a<\u0010\u0011\u001a\u00020\u0002*\u00020\u00002\b\b\u0003\u0010\r\u001a\u00020\f2\b\b\u0003\u0010\u000e\u001a\u00020\f2\b\b\u0003\u0010\u000f\u001a\u00020\f2\b\b\u0003\u0010\u0010\u001a\u00020\fH\u0086\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a<\u0010\u0015\u001a\u00020\u0002*\u00020\u00002\b\b\u0003\u0010\u0013\u001a\u00020\f2\b\b\u0003\u0010\u000e\u001a\u00020\f2\b\b\u0003\u0010\u0014\u001a\u00020\f2\b\b\u0003\u0010\u0010\u001a\u00020\fH\u0086\b¢\u0006\u0004\b\u0015\u0010\u0012\u001a\u001e\u0010\u0017\u001a\u00020\u0002*\u00020\u00002\b\b\u0001\u0010\u0016\u001a\u00020\fH\u0086\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a,\u0010\u001d\u001a\u00020\u001c*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00192\u000e\b\u0004\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH\u0086\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a'\u0010\u001f\u001a\u00020\u001c*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b¢\u0006\u0004\b\u001f\u0010\u001e\u001a\u001b\u0010#\u001a\u00020\"*\u00020\u00002\b\b\u0002\u0010!\u001a\u00020 ¢\u0006\u0004\b#\u0010$\u001a(\u0010'\u001a\u00020\u0002*\u00020\u00002\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00020\u0001H\u0086\b¢\u0006\u0004\b'\u0010\u0005\u001a4\u0010'\u001a\u00020\u0002\"\n\b\u0000\u0010(\u0018\u0001*\u00020%*\u00020\u00002\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0087\b¢\u0006\u0004\b)\u0010\u0005\"*\u0010,\u001a\u00020**\u00020\u00002\u0006\u0010+\u001a\u00020*8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/\"*\u00100\u001a\u00020**\u00020\u00002\u0006\u0010+\u001a\u00020*8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b0\u0010-\"\u0004\b1\u0010/\"*\u00102\u001a\u00020**\u00020\u00002\u0006\u0010+\u001a\u00020*8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b2\u0010-\"\u0004\b3\u0010/\"\u0016\u00106\u001a\u00020\f*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b4\u00105\"\u0016\u00108\u001a\u00020\f*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b7\u00105\"\u0016\u0010:\u001a\u00020\f*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b9\u00105\"\u0016\u0010<\u001a\u00020\f*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b;\u00105\"\u0016\u0010>\u001a\u00020\f*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b=\u00105\"\u0016\u0010@\u001a\u00020\f*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b?\u00105\"\u001b\u0010E\u001a\b\u0012\u0004\u0012\u00020B0A*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bC\u0010D\"\u001b\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00000A*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bF\u0010D¨\u0006H"}, d2 = {"Landroid/view/View;", "Lkotlin/Function1;", "LC7/r;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "doOnNextLayout", "(Landroid/view/View;LS7/k;)V", "doOnLayout", "Landroidx/core/view/OneShotPreDrawListener;", "doOnPreDraw", "(Landroid/view/View;LS7/k;)Landroidx/core/view/OneShotPreDrawListener;", "doOnAttach", "doOnDetach", "", "start", "top", "end", "bottom", "updatePaddingRelative", "(Landroid/view/View;IIII)V", "left", "right", "updatePadding", "size", "setPadding", "(Landroid/view/View;I)V", "", "delayInMillis", "Lkotlin/Function0;", "Ljava/lang/Runnable;", "postDelayed", "(Landroid/view/View;JLS7/a;)Ljava/lang/Runnable;", "postOnAnimationDelayed", "Landroid/graphics/Bitmap$Config;", "config", "Landroid/graphics/Bitmap;", "drawToBitmap", "(Landroid/view/View;Landroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;", "Landroid/view/ViewGroup$LayoutParams;", "block", "updateLayoutParams", ExifInterface.GPS_DIRECTION_TRUE, "updateLayoutParamsTyped", "", "value", "isVisible", "(Landroid/view/View;)Z", "setVisible", "(Landroid/view/View;Z)V", "isInvisible", "setInvisible", "isGone", "setGone", "getMarginLeft", "(Landroid/view/View;)I", "marginLeft", "getMarginTop", "marginTop", "getMarginRight", "marginRight", "getMarginBottom", "marginBottom", "getMarginStart", "marginStart", "getMarginEnd", "marginEnd", "Li9/i;", "Landroid/view/ViewParent;", "getAncestors", "(Landroid/view/View;)Li9/i;", "ancestors", "getAllViews", "allViews", "core-ktx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ViewKt {
    public static final void doOnAttach(final View view, final S7.k kVar) {
        if (view.isAttachedToWindow()) {
            kVar.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.core.view.ViewKt.doOnAttach.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                    view.removeOnAttachStateChangeListener(this);
                    kVar.invoke(view2);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                }
            });
        }
    }

    public static final void doOnDetach(final View view, final S7.k kVar) {
        if (view.isAttachedToWindow()) {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.core.view.ViewKt.doOnDetach.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                    view.removeOnAttachStateChangeListener(this);
                    kVar.invoke(view2);
                }
            });
        } else {
            kVar.invoke(view);
        }
    }

    public static final void doOnLayout(View view, final S7.k kVar) {
        if (!view.isLaidOut() || view.isLayoutRequested()) {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt$doOnLayout$$inlined$doOnNextLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    view2.removeOnLayoutChangeListener(this);
                    kVar.invoke(view2);
                }
            });
        } else {
            kVar.invoke(view);
        }
    }

    public static final void doOnNextLayout(View view, final S7.k kVar) {
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt.doOnNextLayout.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view2, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                view2.removeOnLayoutChangeListener(this);
                kVar.invoke(view2);
            }
        });
    }

    public static final OneShotPreDrawListener doOnPreDraw(final View view, final S7.k kVar) {
        return OneShotPreDrawListener.add(view, new Runnable() { // from class: androidx.core.view.ViewKt.doOnPreDraw.1
            @Override // java.lang.Runnable
            public final void run() {
                kVar.invoke(view);
            }
        });
    }

    public static final Bitmap drawToBitmap(View view, Bitmap.Config config) {
        if (!view.isLaidOut()) {
            throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), config);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.translate(-view.getScrollX(), -view.getScrollY());
        view.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View view, Bitmap.Config config, int i, Object obj) {
        if ((i & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return drawToBitmap(view, config);
    }

    public static final i9.i getAllViews(View view) {
        return new t(new ViewKt$allViews$1(view, null));
    }

    public static final i9.i getAncestors(View view) {
        return kotlin.sequences.a.k0(ViewKt$ancestors$1.INSTANCE, view.getParent());
    }

    public static final int getMarginBottom(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.bottomMargin;
        }
        return 0;
    }

    public static final int getMarginEnd(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).getMarginEnd();
        }
        return 0;
    }

    public static final int getMarginLeft(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.leftMargin;
        }
        return 0;
    }

    public static final int getMarginRight(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.rightMargin;
        }
        return 0;
    }

    public static final int getMarginStart(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).getMarginStart();
        }
        return 0;
    }

    public static final int getMarginTop(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.topMargin;
        }
        return 0;
    }

    public static final boolean isGone(View view) {
        return view.getVisibility() == 8;
    }

    public static final boolean isInvisible(View view) {
        return view.getVisibility() == 4;
    }

    public static final boolean isVisible(View view) {
        return view.getVisibility() == 0;
    }

    public static final Runnable postDelayed(View view, long j5, final S7.a aVar) {
        Runnable runnable = new Runnable() { // from class: androidx.core.view.ViewKt$postDelayed$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                aVar.invoke();
            }
        };
        view.postDelayed(runnable, j5);
        return runnable;
    }

    public static final Runnable postOnAnimationDelayed(View view, long j5, S7.a aVar) {
        g gVar = new g(aVar, 1);
        view.postOnAnimationDelayed(gVar, j5);
        return gVar;
    }

    public static final void setGone(View view, boolean z10) {
        view.setVisibility(z10 ? 8 : 0);
    }

    public static final void setInvisible(View view, boolean z10) {
        view.setVisibility(z10 ? 4 : 0);
    }

    public static final void setPadding(View view, @Px int i) {
        view.setPadding(i, i, i, i);
    }

    public static final void setVisible(View view, boolean z10) {
        view.setVisibility(z10 ? 0 : 8);
    }

    public static final void updateLayoutParams(View view, S7.k kVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        kVar.invoke(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    public static final <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(View view, S7.k kVar) {
        view.getLayoutParams();
        kotlin.jvm.internal.k.m();
        throw null;
    }

    public static final void updatePadding(View view, @Px int i, @Px int i6, @Px int i10, @Px int i11) {
        view.setPadding(i, i6, i10, i11);
    }

    public static /* synthetic */ void updatePadding$default(View view, int i, int i6, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i = view.getPaddingLeft();
        }
        if ((i12 & 2) != 0) {
            i6 = view.getPaddingTop();
        }
        if ((i12 & 4) != 0) {
            i10 = view.getPaddingRight();
        }
        if ((i12 & 8) != 0) {
            i11 = view.getPaddingBottom();
        }
        view.setPadding(i, i6, i10, i11);
    }

    public static final void updatePaddingRelative(View view, @Px int i, @Px int i6, @Px int i10, @Px int i11) {
        view.setPaddingRelative(i, i6, i10, i11);
    }

    public static /* synthetic */ void updatePaddingRelative$default(View view, int i, int i6, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i = view.getPaddingStart();
        }
        if ((i12 & 2) != 0) {
            i6 = view.getPaddingTop();
        }
        if ((i12 & 4) != 0) {
            i10 = view.getPaddingEnd();
        }
        if ((i12 & 8) != 0) {
            i11 = view.getPaddingBottom();
        }
        view.setPaddingRelative(i, i6, i10, i11);
    }
}
