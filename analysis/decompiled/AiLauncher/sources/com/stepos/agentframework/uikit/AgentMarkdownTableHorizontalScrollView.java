package com.stepos.agentframework.uikit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 62\u00020\u0001:\u00037\u0017\u001aB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\"\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001cH\u0002¢\u0006\u0004\b\"\u0010#R*\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u000e\"\u0004\b(\u0010\u0018R*\u0010)\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u000b\"\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010/R\u0014\u00101\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010*R\u0016\u00102\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010&R\u0016\u00103\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010&¨\u00068"}, d2 = {"Lcom/stepos/agentframework/uikit/AgentMarkdownTableHorizontalScrollView;", "Landroid/widget/HorizontalScrollView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "computeHorizontalScrollRange", "()I", "", Const.INTENT_KEY_APIKEY, "()Z", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "onTouchEvent", "onInterceptTouchEvent", "disallow", "LY8/t;", "c", "(Z)V", "Landroidx/recyclerview/widget/RecyclerView;", Const.INTENT_KEY_PKGNAME, "()Landroidx/recyclerview/widget/RecyclerView;", "", "dx", "e", "(F)Z", "dy", "Lcom/stepos/agentframework/uikit/AgentMarkdownTableHorizontalScrollView$GestureAxis;", Const.INTENT_KEY_UMID, "(FF)Lcom/stepos/agentframework/uikit/AgentMarkdownTableHorizontalScrollView$GestureAxis;", UxipConstants.f30680s, "horizontalScrollEnabled", "Z", "getHorizontalScrollEnabled", "setHorizontalScrollEnabled", "trailingNonContentPaddingPx", "I", "getTrailingNonContentPaddingPx", "setTrailingNonContentPaddingPx", "(I)V", "downX", "F", "downY", "touchSlop", "disallowInterceptInGesture", "gestureAxis", "Lcom/stepos/agentframework/uikit/AgentMarkdownTableHorizontalScrollView$GestureAxis;", "handedOffToPager", "Companion", "GestureAxis", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentMarkdownTableHorizontalScrollView extends HorizontalScrollView {
    private static final float TABLE_CORNER_RADIUS_DP = 12.0f;
    private static final float VERTICAL_DOMINANCE = 2.0f;
    private boolean disallowInterceptInGesture;
    private float downX;
    private float downY;
    private GestureAxis gestureAxis;
    private boolean handedOffToPager;
    private boolean horizontalScrollEnabled;
    private final int touchSlop;
    private int trailingNonContentPaddingPx;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/uikit/AgentMarkdownTableHorizontalScrollView$GestureAxis;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "HORIZONTAL", "VERTICAL", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class GestureAxis {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ GestureAxis[] $VALUES;
        public static final GestureAxis UNKNOWN = new GestureAxis("UNKNOWN", 0);
        public static final GestureAxis HORIZONTAL = new GestureAxis("HORIZONTAL", 1);
        public static final GestureAxis VERTICAL = new GestureAxis("VERTICAL", 2);

        private static final /* synthetic */ GestureAxis[] $values() {
            return new GestureAxis[]{UNKNOWN, HORIZONTAL, VERTICAL};
        }

        static {
            GestureAxis[] gestureAxisArr$values = $values();
            $VALUES = gestureAxisArr$values;
            $ENTRIES = kotlin.enums.a.a(gestureAxisArr$values);
        }

        private GestureAxis(String str, int i10) {
        }

        public static InterfaceC4149a<GestureAxis> getEntries() {
            return $ENTRIES;
        }

        public static GestureAxis valueOf(String str) {
            return (GestureAxis) Enum.valueOf(GestureAxis.class, str);
        }

        public static GestureAxis[] values() {
            return (GestureAxis[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/agentframework/uikit/AgentMarkdownTableHorizontalScrollView$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), AgentMarkdownTableHorizontalScrollView.this.getResources().getDisplayMetrics().density * 12.0f);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/uikit/AgentMarkdownTableHorizontalScrollView$c;", "Landroid/graphics/drawable/DrawableWrapper;", "Landroid/graphics/drawable/Drawable;", "drawable", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "Landroid/graphics/Canvas;", "canvas", "LY8/t;", "draw", "(Landroid/graphics/Canvas;)V", "Landroid/graphics/Path;", "clipPath", "Landroid/graphics/Path;", "Landroid/graphics/RectF;", "clipBounds", "Landroid/graphics/RectF;", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends DrawableWrapper {
        private final RectF clipBounds;
        private final Path clipPath;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Drawable drawable) {
            super(drawable);
            kotlin.jvm.internal.p.i(drawable, "drawable");
            this.clipPath = new Path();
            this.clipBounds = new RectF();
        }

        @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            kotlin.jvm.internal.p.i(canvas, "canvas");
            this.clipBounds.set(getBounds());
            float fHeight = this.clipBounds.height() / 2.0f;
            this.clipPath.rewind();
            this.clipPath.addRoundRect(this.clipBounds, fHeight, fHeight, Path.Direction.CW);
            int iSave = canvas.save();
            canvas.clipPath(this.clipPath);
            super.draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class d {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GestureAxis.values().length];
            try {
                iArr[GestureAxis.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GestureAxis.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GestureAxis.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AgentMarkdownTableHorizontalScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public final boolean a() {
        return b() != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x000d, code lost:
    
        r4 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.recyclerview.widget.RecyclerView b() {
        /*
            r4 = this;
            android.view.ViewParent r4 = r4.getParent()
            boolean r0 = r4 instanceof android.view.View
            r1 = 0
            if (r0 == 0) goto Lc
            android.view.View r4 = (android.view.View) r4
            goto Ld
        Lc:
            r4 = r1
        Ld:
            if (r4 == 0) goto L2f
            boolean r0 = r4 instanceof androidx.recyclerview.widget.RecyclerView
            if (r0 == 0) goto L24
            r0 = r4
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = r0.getLayoutManager()
            if (r2 == 0) goto L24
            boolean r2 = r2.canScrollHorizontally()
            r3 = 1
            if (r2 != r3) goto L24
            return r0
        L24:
            android.view.ViewParent r4 = r4.getParent()
            boolean r0 = r4 instanceof android.view.View
            if (r0 == 0) goto Lc
            android.view.View r4 = (android.view.View) r4
            goto Ld
        L2f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.uikit.AgentMarkdownTableHorizontalScrollView.b():androidx.recyclerview.widget.RecyclerView");
    }

    public final void c(boolean disallow) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(disallow);
        }
        RecyclerView recyclerViewB = b();
        if (recyclerViewB != null) {
            recyclerViewB.requestDisallowInterceptTouchEvent(disallow);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public int computeHorizontalScrollRange() {
        return C5685n.f(super.computeHorizontalScrollRange() - this.trailingNonContentPaddingPx, computeHorizontalScrollExtent());
    }

    public final GestureAxis d(float dx, float dy) {
        float fAbs = Math.abs(dx);
        float fAbs2 = Math.abs(dy);
        int i10 = this.touchSlop;
        return (fAbs <= ((float) i10) || fAbs < fAbs2) ? (fAbs2 <= ((float) i10) || fAbs2 <= fAbs * 2.0f) ? GestureAxis.UNKNOWN : GestureAxis.VERTICAL : GestureAxis.HORIZONTAL;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00e4  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r9) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.uikit.AgentMarkdownTableHorizontalScrollView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public final boolean e(float dx) {
        RecyclerView recyclerViewB;
        int i10 = dx > 0.0f ? -1 : 1;
        return (canScrollHorizontally(i10) || (recyclerViewB = b()) == null || !recyclerViewB.canScrollHorizontally(i10)) ? false : true;
    }

    public final boolean getHorizontalScrollEnabled() {
        return this.horizontalScrollEnabled;
    }

    public final int getTrailingNonContentPaddingPx() {
        return this.trailingNonContentPaddingPx;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        kotlin.jvm.internal.p.i(ev, "ev");
        if (this.horizontalScrollEnabled) {
            return super.onInterceptTouchEvent(ev);
        }
        return true;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        kotlin.jvm.internal.p.i(ev, "ev");
        if (!this.horizontalScrollEnabled) {
            return true;
        }
        int actionMasked = ev.getActionMasked();
        if (actionMasked == 0) {
            this.downX = ev.getX();
            this.downY = ev.getY();
        } else if (actionMasked == 2) {
            if (this.handedOffToPager) {
                return true;
            }
            if (d(ev.getX() - this.downX, ev.getY() - this.downY) == GestureAxis.HORIZONTAL) {
                c(true);
            }
        }
        return super.onTouchEvent(ev);
    }

    public final void setHorizontalScrollEnabled(boolean z10) {
        ViewParent parent;
        this.horizontalScrollEnabled = z10;
        setHorizontalScrollBarEnabled(z10);
        if (z10 || (parent = getParent()) == null) {
            return;
        }
        parent.requestDisallowInterceptTouchEvent(false);
    }

    public final void setTrailingNonContentPaddingPx(int i10) {
        this.trailingNonContentPaddingPx = C5685n.f(i10, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentMarkdownTableHorizontalScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        setOutlineProvider(new a());
        setClipToOutline(true);
        Drawable horizontalScrollbarThumbDrawable = getHorizontalScrollbarThumbDrawable();
        if (horizontalScrollbarThumbDrawable != null) {
            setHorizontalScrollbarThumbDrawable(new c(horizontalScrollbarThumbDrawable));
        }
        this.horizontalScrollEnabled = true;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.gestureAxis = GestureAxis.UNKNOWN;
    }

    public /* synthetic */ AgentMarkdownTableHorizontalScrollView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
