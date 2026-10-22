package com.stepos.ailauncher.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.sheet.widget.DraggableSheetLayout;
import kotlin.Metadata;
import v5.C5659a;
import v9.C5685n;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 92\u00020\u0001:\u0001:B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\fH\u0014¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\fH\u0002¢\u0006\u0004\b#\u0010\"J\u0017\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020\nH\u0002¢\u0006\u0004\b%\u0010\u000eJ\u000f\u0010&\u001a\u00020\fH\u0002¢\u0006\u0004\b&\u0010\"J\u0011\u0010(\u001a\u0004\u0018\u00010'H\u0002¢\u0006\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010+R\u0016\u0010-\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010+R\u0016\u0010.\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010/R\u0014\u00101\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00103\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010/R\u0018\u00106\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010/¨\u0006;"}, d2 = {"Lcom/stepos/ailauncher/chat/view/m;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "disallow", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Z)V", "c", "()Landroidx/recyclerview/widget/RecyclerView;", "", "getTopFadingEdgeStrength", "()F", "getBottomFadingEdgeStrength", "dx", "dy", "onScrolled", "(II)V", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "velocityX", "velocityY", "fling", "(II)Z", "onDetachedFromWindow", "()V", "e", "block", Const.INTENT_KEY_PKGNAME, "f", "Lcom/stepos/ailauncher/sheet/widget/DraggableSheetLayout;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Lcom/stepos/ailauncher/sheet/widget/DraggableSheetLayout;", "lastY", "F", "downX", "downY", "dragAxisDecided", "Z", "grabbing", "axisSlop", "I", "outerRv", "Landroidx/recyclerview/widget/RecyclerView;", "ancestorBlocked", "sheetHost", "Lcom/stepos/ailauncher/sheet/widget/DraggableSheetLayout;", "sheetHostResolved", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.m, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2887m extends RecyclerView {
    private static final a Companion = new a(null);

    @Deprecated
    public static final int FADE_LENGTH_DP = 32;

    @Deprecated
    public static final float HORIZONTAL_DOMINANCE = 2.0f;
    private boolean ancestorBlocked;
    private final int axisSlop;
    private float downX;
    private float downY;
    private boolean dragAxisDecided;
    private boolean grabbing;
    private float lastY;
    private RecyclerView outerRv;
    private DraggableSheetLayout sheetHost;
    private boolean sheetHostResolved;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/chat/view/m$a;", "", "<init>", "()V", "", "FADE_LENGTH_DP", "I", "", "HORIZONTAL_DOMINANCE", "F", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.m$a */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2887m(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.axisSlop = C5685n.f(ViewConfiguration.get(context).getScaledTouchSlop() / 2, 1);
        setNestedScrollingEnabled(false);
        setOverScrollMode(2);
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(C5659a.INSTANCE.a(context, 32));
    }

    private final RecyclerView c() {
        RecyclerView recyclerView = this.outerRv;
        if (recyclerView != null) {
            return recyclerView;
        }
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof RecyclerView) {
                RecyclerView recyclerView2 = (RecyclerView) parent;
                this.outerRv = recyclerView2;
                return recyclerView2;
            }
        }
        return null;
    }

    private final void g(boolean disallow) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(disallow);
        }
    }

    public final void b(boolean block) {
        RecyclerView recyclerViewC;
        ViewParent parent;
        if (block == this.ancestorBlocked || (recyclerViewC = c()) == null || (parent = recyclerViewC.getParent()) == null) {
            return;
        }
        this.ancestorBlocked = block;
        parent.requestDisallowInterceptTouchEvent(block);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        kotlin.jvm.internal.p.i(ev, "ev");
        int actionMasked = ev.getActionMasked();
        if (actionMasked == 0) {
            this.downX = ev.getX();
            this.downY = ev.getY();
            this.lastY = ev.getY();
            this.dragAxisDecided = false;
            this.grabbing = false;
            this.ancestorBlocked = false;
            g(true);
        } else if (actionMasked == 1) {
            f();
            e();
        } else if (actionMasked == 2) {
            float fAbs = Math.abs(ev.getX() - this.downX);
            float fAbs2 = Math.abs(ev.getY() - this.downY);
            if (!this.dragAxisDecided) {
                int i10 = this.axisSlop;
                if (fAbs > i10 || fAbs2 > i10) {
                    this.dragAxisDecided = true;
                    this.grabbing = fAbs <= fAbs2 * 2.0f;
                }
            }
            if (this.grabbing) {
                if (ev.getY() - this.lastY > 0.0f ? canScrollVertically(-1) : canScrollVertically(1)) {
                    b(false);
                    g(true);
                } else {
                    g(false);
                    b(true);
                }
            } else if (this.dragAxisDecided) {
                g(false);
                b(false);
            }
            this.lastY = ev.getY();
        } else if (actionMasked == 3) {
            g(false);
        }
        return super.dispatchTouchEvent(ev);
    }

    public final void e() {
        RecyclerView recyclerViewC = c();
        if (recyclerViewC != null) {
            recyclerViewC.stopNestedScroll(0);
        }
    }

    public final void f() {
        g(false);
        b(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int velocityX, int velocityY) {
        if (velocityY > 0 ? canScrollVertically(1) : canScrollVertically(-1)) {
            return super.fling(velocityX, velocityY);
        }
        RecyclerView recyclerViewC = c();
        return recyclerViewC != null && recyclerViewC.fling(0, velocityY);
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        int verticalFadingEdgeLength;
        int iComputeVerticalScrollRange = (computeVerticalScrollRange() - computeVerticalScrollOffset()) - computeVerticalScrollExtent();
        if (iComputeVerticalScrollRange > 0 && (verticalFadingEdgeLength = getVerticalFadingEdgeLength()) > 0) {
            return C5685n.i(iComputeVerticalScrollRange / verticalFadingEdgeLength, 1.0f);
        }
        return 0.0f;
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        int verticalFadingEdgeLength;
        int iComputeVerticalScrollOffset = computeVerticalScrollOffset();
        if (iComputeVerticalScrollOffset > 0 && (verticalFadingEdgeLength = getVerticalFadingEdgeLength()) > 0) {
            return C5685n.i(iComputeVerticalScrollOffset / verticalFadingEdgeLength, 1.0f);
        }
        return 0.0f;
    }

    public final DraggableSheetLayout h() {
        if (this.sheetHostResolved) {
            return this.sheetHost;
        }
        this.sheetHostResolved = true;
        ViewParent parent = getParent();
        while (true) {
            if (parent == null) {
                break;
            }
            if (parent instanceof DraggableSheetLayout) {
                this.sheetHost = (DraggableSheetLayout) parent;
                break;
            }
            parent = parent.getParent();
        }
        return this.sheetHost;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.outerRv = null;
        this.ancestorBlocked = false;
        this.sheetHost = null;
        this.sheetHostResolved = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrolled(int dx, int dy) {
        DraggableSheetLayout draggableSheetLayoutH;
        super.onScrolled(dx, dy);
        if (dy == 0 || getScrollState() != 1 || (draggableSheetLayoutH = h()) == null) {
            return;
        }
        draggableSheetLayoutH.B0();
    }

    public /* synthetic */ C2887m(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
