package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a2\u0010 \u001a\u00020!*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\b\u001a2\u0010'\u001a\u00020!*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\b\u001a2\u0010(\u001a\u00020!*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\b\u001a2\u0010)\u001a\u00020!*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\b\u001a2\u0010*\u001a\u00020+*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\b\u001a\u0014\u0010,\u001a\u00020-*\u00020\u00022\b\b\u0002\u0010.\u001a\u00020/\u001a%\u00100\u001a\u000201*\u00020\u00022\u0006\u00102\u001a\u0002032\u000e\b\u0004\u0010\"\u001a\b\u0012\u0004\u0012\u00020!04H\u0086\b\u001a \u00105\u001a\u000201*\u00020\u00022\u0006\u00102\u001a\u0002032\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!04\u001a\u0017\u00106\u001a\u00020!*\u00020\u00022\b\b\u0001\u00107\u001a\u00020\u0013H\u0086\b\u001a7\u00108\u001a\u00020!\"\n\b\u0000\u00109\u0018\u0001*\u00020:*\u00020\u00022\u0017\u0010;\u001a\u0013\u0012\u0004\u0012\u0002H9\u0012\u0004\u0012\u00020!0#¢\u0006\u0002\b<H\u0087\b¢\u0006\u0002\b=\u001a&\u00108\u001a\u00020!*\u00020\u00022\u0017\u0010;\u001a\u0013\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020!0#¢\u0006\u0002\b<H\u0086\b\u001a5\u0010>\u001a\u00020!*\u00020\u00022\b\b\u0003\u0010?\u001a\u00020\u00132\b\b\u0003\u0010@\u001a\u00020\u00132\b\b\u0003\u0010A\u001a\u00020\u00132\b\b\u0003\u0010B\u001a\u00020\u0013H\u0086\b\u001a5\u0010C\u001a\u00020!*\u00020\u00022\b\b\u0003\u0010D\u001a\u00020\u00132\b\b\u0003\u0010@\u001a\u00020\u00132\b\b\u0003\u0010E\u001a\u00020\u00132\b\b\u0003\u0010B\u001a\u00020\u0013H\u0086\b\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004\"*\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\b\u001a\u00020\t8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\"*\u0010\u000e\u001a\u00020\t*\u00020\u00022\u0006\u0010\b\u001a\u00020\t8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\r\"*\u0010\u0010\u001a\u00020\t*\u00020\u00022\u0006\u0010\b\u001a\u00020\t8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\r\"\u0016\u0010\u0012\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0016\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015\"\u0016\u0010\u0018\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015\"\u0016\u0010\u001a\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015\"\u0016\u0010\u001c\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015\"\u0016\u0010\u001e\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015¨\u0006F"}, d2 = {"allViews", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "getAllViews", "(Landroid/view/View;)Lkotlin/sequences/Sequence;", "ancestors", "Landroid/view/ViewParent;", "getAncestors", "value", "", "isGone", "(Landroid/view/View;)Z", "setGone", "(Landroid/view/View;Z)V", "isInvisible", "setInvisible", "isVisible", "setVisible", "marginBottom", "", "getMarginBottom", "(Landroid/view/View;)I", "marginEnd", "getMarginEnd", "marginLeft", "getMarginLeft", "marginRight", "getMarginRight", "marginStart", "getMarginStart", "marginTop", "getMarginTop", "doOnAttach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "doOnDetach", "doOnLayout", "doOnNextLayout", "doOnPreDraw", "Landroidx/core/view/OneShotPreDrawListener;", "drawToBitmap", "Landroid/graphics/Bitmap;", "config", "Landroid/graphics/Bitmap$Config;", "postDelayed", "Ljava/lang/Runnable;", "delayInMillis", "", "Lkotlin/Function0;", "postOnAnimationDelayed", "setPadding", "size", "updateLayoutParams", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/ViewGroup$LayoutParams;", "block", "Lkotlin/ExtensionFunctionType;", "updateLayoutParamsTyped", "updatePadding", "left", "top", "right", "bottom", "updatePaddingRelative", "start", "end", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ViewKt {
    public static /* synthetic */ void a(Function0 r100) {
        postOnAnimationDelayed$lambda$1(r100);
    }

    public static final Sequence<View> getAllViews(View r100) {
        return SequencesKt.sequence(new ViewKt$allViews$1(r100, null));
    }

    public static final Sequence<ViewParent> getAncestors(View r100) {
        return SequencesKt.generateSequence(r100.getParent(), ViewKt$ancestors$1.INSTANCE);
    }

    public static final int getMarginBottom(View r100) {
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
    L6:
        if (r102 != null) goto L10;
        return 0;
    L10:
        return r102.bottomMargin;
    L5:
        r102 = null;
        goto L6
    }

    public static final int getMarginEnd(View r100) {
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        return 0;
    L7:
        return ((ViewGroup.MarginLayoutParams) r101).getMarginEnd();
    }

    public static final int getMarginLeft(View r100) {
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
    L6:
        if (r102 != null) goto L10;
        return 0;
    L10:
        return r102.leftMargin;
    L5:
        r102 = null;
        goto L6
    }

    public static final int getMarginRight(View r100) {
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
    L6:
        if (r102 != null) goto L10;
        return 0;
    L10:
        return r102.rightMargin;
    L5:
        r102 = null;
        goto L6
    }

    public static final int getMarginStart(View r100) {
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        return 0;
    L7:
        return ((ViewGroup.MarginLayoutParams) r101).getMarginStart();
    }

    public static final int getMarginTop(View r100) {
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
    L6:
        if (r102 != null) goto L10;
        return 0;
    L10:
        return r102.topMargin;
    L5:
        r102 = null;
        goto L6
    }

    public static final boolean isGone(View r100) {
        if (r100.getVisibility() != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isInvisible(View r100) {
        if (r100.getVisibility() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isVisible(View r100) {
        if (r100.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static final void postOnAnimationDelayed$lambda$1(Function0 r100) {
        r100.invoke();
    }

    public static final void doOnAttach(final View r100, final Function1<? super View, Unit> r101) {
        if (r100.isAttachedToWindow() == false) goto L5;
        r101.invoke(r100);
        return;
    L5:
        r100.addOnAttachStateChangeListener(new AnonymousClass1(r100, r101));
    }

    public static final void doOnDetach(final View r100, final Function1<? super View, Unit> r101) {
        if (r100.isAttachedToWindow() == true) goto L5;
        r101.invoke(r100);
        return;
    L5:
        r100.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC87821(r100, r101));
    }

    public static final void doOnLayout(View r100, final Function1<? super View, Unit> r101) {
        if (r100.isLaidOut() == true) goto L5;
    L7:
        r100.addOnLayoutChangeListener(new ViewKt$doOnLayout$$inlined$doOnNextLayout$1(r101));
        return;
    L5:
        if (r100.isLayoutRequested() == true) goto L7;
        r101.invoke(r100);
    }

    public static final void doOnNextLayout(View r100, final Function1<? super View, Unit> r101) {
        r100.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC87831(r101));
    }

    public static final OneShotPreDrawListener doOnPreDraw(final View r100, final Function1<? super View, Unit> r101) {
        return OneShotPreDrawListener.add(r100, new RunnableC87841(r101, r100));
    }

    public static final Bitmap drawToBitmap(View r100, Bitmap.Config r101) {
        if (r100.isLaidOut() == false) goto L7;
        Bitmap r102 = Bitmap.createBitmap(r100.getWidth(), r100.getHeight(), r101);
        Canvas r103 = new Canvas(r102);
        r103.translate(-r100.getScrollX(), -r100.getScrollY());
        r100.draw(r103);
        return r102;
    L7:
        throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
    }

    public static final void setGone(View r100, boolean r101) {
        if (r101 == false) goto L4;
        int r102 = 8;
    L5:
        r100.setVisibility(r102);
        return;
    L4:
        r102 = 0;
        goto L5
    }

    public static final void setInvisible(View r100, boolean r101) {
        if (r101 == false) goto L4;
        int r102 = 4;
    L5:
        r100.setVisibility(r102);
        return;
    L4:
        r102 = 0;
        goto L5
    }

    public static final void setPadding(View r100, int r101) {
        r100.setPadding(r101, r101, r101, r101);
    }

    public static final void setVisible(View r100, boolean r101) {
        if (r101 == false) goto L4;
        int r102 = 0;
    L5:
        r100.setVisibility(r102);
        return;
    L4:
        r102 = 8;
        goto L5
    }

    public static final void updateLayoutParams(View r100, Function1<? super ViewGroup.LayoutParams, Unit> r101) {
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L7;
        r101.invoke(r102);
        r100.setLayoutParams(r102);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public static final /* synthetic */ <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(View r100, Function1<? super T, Unit> r101) {
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        r101.invoke(r102);
        r100.setLayoutParams(r102);
    }

    public static final Runnable postDelayed(View r100, long r101, final Function0<Unit> r102) {
        Runnable r103 = new ViewKt$postDelayed$runnable$1(r102);
        r100.postDelayed(r103, r101);
        return r103;
    }

    public static final Runnable postOnAnimationDelayed(View r100, long r101, final Function0<Unit> r102) {
        Runnable r103 = new n(r102);
        r100.postOnAnimationDelayed(r103, r101);
        return r103;
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View r100, Bitmap.Config r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = Bitmap.Config.ARGB_8888;
    L6:
        return drawToBitmap(r100, r101);
    }

    public static final void updatePadding(View r100, int r101, int r102, int r103, int r104) {
        r100.setPadding(r101, r102, r103, r104);
    }

    public static final void updatePaddingRelative(View r100, int r101, int r102, int r103, int r104) {
        r100.setPaddingRelative(r101, r102, r103, r104);
    }

    public static /* synthetic */ void updatePadding$default(View r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.getPaddingLeft();
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.getPaddingTop();
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.getPaddingRight();
    L12:
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.getPaddingBottom();
    L14:
        r100.setPadding(r101, r102, r103, r104);
    }

    public static /* synthetic */ void updatePaddingRelative$default(View r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.getPaddingStart();
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.getPaddingTop();
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.getPaddingEnd();
    L12:
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.getPaddingBottom();
    L14:
        r100.setPaddingRelative(r101, r102, r103, r104);
    }
}
