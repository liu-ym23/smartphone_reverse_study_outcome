package com.stepos.ailauncher.chat.view;

import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.view.input.InputBarMotionSpec;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 L2\u00020\u0001:\u0001MB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u001f\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ7\u0010%\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!H\u0002¢\u0006\u0004\b%\u0010&J\u0011\u0010'\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R*\u0010/\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u001a8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00105\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010*\u001a\u0004\b6\u00107\"\u0004\b8\u00109R*\u0010:\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00118\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010*\u001a\u0004\b;\u00107\"\u0004\b<\u00109R*\u0010=\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00118\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010*\u001a\u0004\b>\u00107\"\u0004\b?\u00109R*\u0010@\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00118\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010*\u001a\u0004\bA\u00107\"\u0004\bB\u00109R\u0014\u0010D\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010G\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010I\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010K\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010J¨\u0006N"}, d2 = {"Lcom/stepos/ailauncher/chat/view/LineCappedScrollView;", "Landroid/widget/ScrollView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/graphics/Canvas;", "canvas", "LY8/t;", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "Landroid/view/View;", "child", "Landroid/graphics/Rect;", "rectangle", "", "immediate", "requestChildRectangleOnScreen", "(Landroid/view/View;Landroid/graphics/Rect;Z)Z", "Landroid/view/MotionEvent;", "ev", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "onTouchEvent", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Landroid/graphics/LinearGradient;", "gradient", "", "left", "top", "length", "c", "(Landroid/graphics/Canvas;Landroid/graphics/LinearGradient;FFF)V", "e", "()Ljava/lang/Integer;", "blockCursorFollow", "Z", "Ljava/lang/Runnable;", "releaseCursorFollowBlock", "Ljava/lang/Runnable;", UxipConstants.f30680s, "maxVisibleLines", "I", "getMaxVisibleLines", "()I", "setMaxVisibleLines", "(I)V", "suppressScrollForGrowth", "getSuppressScrollForGrowth", "()Z", "setSuppressScrollForGrowth", "(Z)V", "hideOverflowLine", "getHideOverflowLine", "setHideOverflowLine", "topTextFadeEnabled", "getTopTextFadeEnabled", "setTopTextFadeEnabled", "bottomTextFadeEnabled", "getBottomTextFadeEnabled", "setBottomTextFadeEnabled", "Landroid/graphics/Paint;", "fadePaint", "Landroid/graphics/Paint;", "Landroid/graphics/Matrix;", "fadeMatrix", "Landroid/graphics/Matrix;", "topFade", "Landroid/graphics/LinearGradient;", "bottomFade", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LineCappedScrollView extends ScrollView {

    @Deprecated
    public static final long CURSOR_FOLLOW_RELEASE_DELAY_MS = 80;
    private static final a Companion = new a(null);

    @Deprecated
    public static final int DEFAULT_MAX_VISIBLE_LINES = 8;
    private boolean blockCursorFollow;
    private final LinearGradient bottomFade;
    private boolean bottomTextFadeEnabled;
    private final Matrix fadeMatrix;
    private final Paint fadePaint;
    private boolean hideOverflowLine;
    private int maxVisibleLines;
    private final Runnable releaseCursorFollowBlock;
    private boolean suppressScrollForGrowth;
    private final LinearGradient topFade;
    private boolean topTextFadeEnabled;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/chat/view/LineCappedScrollView$a;", "", "<init>", "()V", "", "DEFAULT_MAX_VISIBLE_LINES", "I", "", "CURSOR_FOLLOW_RELEASE_DELAY_MS", "J", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LineCappedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.p.i(context, "context");
        this.releaseCursorFollowBlock = new Runnable() { // from class: com.stepos.ailauncher.chat.view.Z6
            @Override // java.lang.Runnable
            public final void run() {
                LineCappedScrollView.d(this.f26053a);
            }
        };
        this.maxVisibleLines = 8;
        Paint paint = new Paint();
        paint.setBlendMode(BlendMode.DST_IN);
        this.fadePaint = paint;
        this.fadeMatrix = new Matrix();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.topFade = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, 0, -16777216, tileMode);
        this.bottomFade = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, -16777216, 0, tileMode);
    }

    public static final void d(LineCappedScrollView lineCappedScrollView) {
        lineCappedScrollView.blockCursorFollow = false;
    }

    public static final int f(int i10, Layout layout, int i11) {
        return i10 + layout.getLineBottom(i11);
    }

    public final void c(Canvas canvas, LinearGradient gradient, float left, float top, float length) {
        if (length <= 0.0f) {
            return;
        }
        this.fadeMatrix.setScale(1.0f, length);
        this.fadeMatrix.postTranslate(left, top);
        gradient.setLocalMatrix(this.fadeMatrix);
        this.fadePaint.setShader(gradient);
        canvas.drawRect(left, top, left + getWidth(), top + length, this.fadePaint);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Canvas canvas2;
        LineCappedScrollView lineCappedScrollView;
        kotlin.jvm.internal.p.i(canvas, "canvas");
        Integer numValueOf = null;
        Integer numE = this.hideOverflowLine ? e() : null;
        if (numE == null && !this.topTextFadeEnabled && !this.bottomTextFadeEnabled) {
            super.dispatchDraw(canvas);
            return;
        }
        int iSave = canvas.save();
        if (numE != null) {
            canvas.clipRect(0, 0, getWidth(), numE.intValue());
        }
        float scrollX = getScrollX();
        float scrollY = getScrollY();
        if (this.topTextFadeEnabled || this.bottomTextFadeEnabled) {
            int iSaveLayer = canvas.saveLayer(scrollX, scrollY, getWidth() + scrollX, scrollY + getHeight(), null);
            scrollX = scrollX;
            canvas2 = canvas;
            numValueOf = Integer.valueOf(iSaveLayer);
        } else {
            canvas2 = canvas;
        }
        super.dispatchDraw(canvas2);
        if (this.topTextFadeEnabled) {
            lineCappedScrollView = this;
            lineCappedScrollView.c(canvas2, this.topFade, scrollX, scrollY, C5685n.i(getResources().getDisplayMetrics().density * 28.0f, getHeight()));
            scrollY = scrollY;
        } else {
            lineCappedScrollView = this;
        }
        if (lineCappedScrollView.bottomTextFadeEnabled) {
            float fI = C5685n.i(lineCappedScrollView.getResources().getDisplayMetrics().density * 14.0f, lineCappedScrollView.getHeight());
            lineCappedScrollView.c(canvas2, lineCappedScrollView.bottomFade, scrollX, (lineCappedScrollView.getHeight() + scrollY) - fI, fI);
        }
        if (numValueOf != null) {
            canvas2.restoreToCount(numValueOf.intValue());
        }
        canvas2.restoreToCount(iSave);
    }

    public final Integer e() {
        final Layout layout;
        View childAt = getChildAt(0);
        TextView textView = childAt instanceof TextView ? (TextView) childAt : null;
        if (textView == null || (layout = textView.getLayout()) == null) {
            return null;
        }
        final int top = (textView.getTop() - getScrollY()) + textView.getCompoundPaddingTop();
        return InputBarMotionSpec.INSTANCE.n(getHeight(), layout.getLineCount(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.Y6
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(LineCappedScrollView.f(top, layout, ((Integer) obj).intValue()));
            }
        });
    }

    public final boolean getBottomTextFadeEnabled() {
        return this.bottomTextFadeEnabled;
    }

    public final boolean getHideOverflowLine() {
        return this.hideOverflowLine;
    }

    public final int getMaxVisibleLines() {
        return this.maxVisibleLines;
    }

    public final boolean getSuppressScrollForGrowth() {
        return this.suppressScrollForGrowth;
    }

    public final boolean getTopTextFadeEnabled() {
        return this.topTextFadeEnabled;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        kotlin.jvm.internal.p.i(ev, "ev");
        if (ev.getActionMasked() == 0) {
            this.blockCursorFollow = canScrollVertically(2) || canScrollVertically(-2);
            removeCallbacks(this.releaseCursorFollowBlock);
        }
        boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(ev);
        if ((ev.getActionMasked() == 1 || ev.getActionMasked() == 3) && this.blockCursorFollow) {
            postDelayed(this.releaseCursorFollowBlock, 80L);
        }
        return zOnInterceptTouchEvent;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Layout layout;
        int iA;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        View childAt = getChildAt(0);
        TextView textView = childAt instanceof TextView ? (TextView) childAt : null;
        if (textView == null || (layout = textView.getLayout()) == null) {
            return;
        }
        InputBarMotionSpec inputBarMotionSpec = InputBarMotionSpec.INSTANCE;
        boolean zE = inputBarMotionSpec.e(layout.getLineCount(), this.maxVisibleLines);
        setVerticalScrollBarEnabled(zE);
        if (zE && getMeasuredHeight() > (iA = inputBarMotionSpec.a(layout.getLineBottom(this.maxVisibleLines - 1), textView.getCompoundPaddingTop(), textView.getCompoundPaddingBottom(), getPaddingTop(), getPaddingBottom()))) {
            setMeasuredDimension(getMeasuredWidth(), iA);
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        kotlin.jvm.internal.p.i(ev, "ev");
        boolean zOnTouchEvent = super.onTouchEvent(ev);
        if ((ev.getActionMasked() == 1 || ev.getActionMasked() == 3) && this.blockCursorFollow) {
            removeCallbacks(this.releaseCursorFollowBlock);
            postDelayed(this.releaseCursorFollowBlock, 80L);
        }
        return zOnTouchEvent;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
        kotlin.jvm.internal.p.i(child, "child");
        kotlin.jvm.internal.p.i(rectangle, "rectangle");
        if (this.suppressScrollForGrowth || this.blockCursorFollow) {
            return false;
        }
        return super.requestChildRectangleOnScreen(child, rectangle, immediate);
    }

    public final void setBottomTextFadeEnabled(boolean z10) {
        if (this.bottomTextFadeEnabled == z10) {
            return;
        }
        this.bottomTextFadeEnabled = z10;
        invalidate();
    }

    public final void setHideOverflowLine(boolean z10) {
        if (this.hideOverflowLine == z10) {
            return;
        }
        this.hideOverflowLine = z10;
        invalidate();
    }

    public final void setMaxVisibleLines(int i10) {
        if (this.maxVisibleLines == i10) {
            return;
        }
        this.maxVisibleLines = i10;
        requestLayout();
    }

    public final void setSuppressScrollForGrowth(boolean z10) {
        this.suppressScrollForGrowth = z10;
    }

    public final void setTopTextFadeEnabled(boolean z10) {
        if (this.topTextFadeEnabled == z10) {
            return;
        }
        this.topTextFadeEnabled = z10;
        invalidate();
    }
}
