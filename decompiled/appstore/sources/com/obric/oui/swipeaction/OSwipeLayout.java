package com.obric.oui.swipeaction;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import androidx.core.view.ViewCompat;
import com.obric.common.oui.R$styleable;
import com.obric.oui.layout.OUIFrameLayout;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes4.dex */
public class OSwipeLayout extends OUIFrameLayout {
    public static final DragEdge L = null;
    public int A;
    public List B;
    public boolean C;
    public boolean D;
    public float E;
    public float F;
    public boolean G;
    public View.OnClickListener H;
    public View.OnLongClickListener I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public Rect f17055J;
    public GestureDetector K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DragEdge f17057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.customview.widget.b f17058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f17059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f17060e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinkedHashMap f17061f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ShowMode f17062g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float[] f17063h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List f17064i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f17065j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map f17066k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Map f17067l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Map f17068m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public DoubleClickListener f17069n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f17070o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean[] f17071p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f17072q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f17073r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f17074s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f17075t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public QuickDeleteListener f17076u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f17077v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f17078w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f17079x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f17080y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public androidx.customview.widget.b.c f17081z;

    public interface DoubleClickListener {
        void onDoubleClick(OSwipeLayout r10, boolean r11);
    }

    public static final enum DragEdge extends Enum<DragEdge> {
        private static final /* synthetic */ DragEdge[] $VALUES = null;
        public static final DragEdge Bottom = null;
        public static final DragEdge Left = null;
        public static final DragEdge Right = null;
        public static final DragEdge Top = null;

        static {
            DragEdge r10 = new DragEdge("Left", 0);
            Left = r10;
            DragEdge r11 = new DragEdge("Top", 1);
            Top = r11;
            DragEdge r12 = new DragEdge("Right", 2);
            Right = r12;
            DragEdge r13 = new DragEdge("Bottom", 3);
            Bottom = r13;
            $VALUES = new DragEdge[]{r10, r11, r12, r13};
        }

        private DragEdge(String r10, int r11) {
            super(r10, r11);
        }

        public static DragEdge valueOf(String r10) {
            return (DragEdge) Enum.valueOf(DragEdge.class, r10);
        }

        public static DragEdge[] values() {
            return (DragEdge[]) $VALUES.clone();
        }
    }

    public interface OnLayout {
        void onLayout(OSwipeLayout r10);
    }

    public interface OnRevealListener {
        void onReveal(View r10, DragEdge r11, float r12, int r13);
    }

    public interface QuickDeleteListener {
        void onQuickDeleteAction();

        void onQuickDeleteStateChanged(boolean r10);
    }

    public static final enum ShowMode extends Enum<ShowMode> {
        private static final /* synthetic */ ShowMode[] $VALUES = null;
        public static final ShowMode LayDown = null;
        public static final ShowMode PullOut = null;

        static {
            ShowMode r10 = new ShowMode("LayDown", 0);
            LayDown = r10;
            ShowMode r11 = new ShowMode("PullOut", 1);
            PullOut = r11;
            $VALUES = new ShowMode[]{r10, r11};
        }

        private ShowMode(String r10, int r11) {
            super(r10, r11);
        }

        public static ShowMode valueOf(String r10) {
            return (ShowMode) Enum.valueOf(ShowMode.class, r10);
        }

        public static ShowMode[] values() {
            return (ShowMode[]) $VALUES.clone();
        }
    }

    public static final enum Status extends Enum<Status> {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status Close = null;
        public static final Status Middle = null;
        public static final Status Open = null;

        static {
            Status r10 = new Status("Middle", 0);
            Middle = r10;
            Status r11 = new Status("Open", 1);
            Open = r11;
            Status r12 = new Status(HTTP.CONN_CLOSE, 2);
            Close = r12;
            $VALUES = new Status[]{r10, r11, r12};
        }

        private Status(String r10, int r11) {
            super(r10, r11);
        }

        public static Status valueOf(String r10) {
            return (Status) Enum.valueOf(Status.class, r10);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }
    }

    public interface SwipeDenier {
        boolean shouldDenySwipe(MotionEvent r10);
    }

    public interface SwipeListener {
        void onClose(OSwipeLayout r10);

        void onHandRelease(OSwipeLayout r10, float r11, float r12);

        void onOpen(OSwipeLayout r10);

        void onStartClose(OSwipeLayout r10);

        void onStartOpen(OSwipeLayout r10);

        void onUpdate(OSwipeLayout r10, int r11, int r12);
    }

    public class a extends androidx.customview.widget.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f17082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OSwipeLayout f17083b;

        public a(OSwipeLayout r10) {
            this.f17083b = r10;
            this.f17082a = true;
        }

        @Override // androidx.customview.widget.b.c
        public int clampViewPositionHorizontal(View r10, int r11, int r12) {
            if (r10 != this.f17083b.getSurfaceView()) goto L45;
            int r13 = d.f17086a[OSwipeLayout.a(this.f17083b).ordinal()];
            if (r13 == 1) goto L43;
            if (r13 == 2) goto L43;
            if (r13 == 3) goto L35;
            if (r13 == 4) goto L11;
        L66:
            return r11;
        L11:
            if (r11 > this.f17083b.getPaddingLeft()) goto L13;
            OSwipeLayout r14 = this.f17083b;
            int r15 = r14.f17079x;
            if (r15 > 0) goto L18;
            r15 = OSwipeLayout.b(r14);
        L18:
            int r16 = this.f17083b.getPaddingLeft() - r15;
            if (OSwipeLayout.i(this.f17083b) == false) goto L32;
            int r17 = this.f17083b.getPaddingLeft();
            float r18 = r15;
            OSwipeLayout r19 = this.f17083b;
            int r20 = r17 - ((int) (r19.f17077v * r18));
            int r21 = r19.getPaddingLeft();
            OSwipeLayout r22 = this.f17083b;
            int r23 = r21 - ((int) (r18 * r22.f17078w));
            if (OSwipeLayout.j(r22).C() != 1) goto L28;
            OSwipeLayout.m(this.f17083b, r12);
            float r24 = r20;
            if (OSwipeLayout.k(this.f17083b) >= r24) goto L27;
            return (int) md.a.f22269a.a(r24, r23, r10.getLeft(), OSwipeLayout.k(this.f17083b));
        L27:
            return (int) OSwipeLayout.k(this.f17083b);
        L28:
            if (r11 < r20) goto L30;
            return r11;
        L30:
            return (int) md.a.f22269a.a(r20, r23, r10.getLeft(), r11);
        L32:
            if (r11 >= r16) goto L66;
            return r16;
        L13:
            return this.f17083b.getPaddingLeft();
        L35:
            if (r11 >= this.f17083b.getPaddingLeft()) goto L39;
            return this.f17083b.getPaddingLeft();
        L39:
            if (r11 <= (this.f17083b.getPaddingLeft() + OSwipeLayout.b(this.f17083b))) goto L66;
            return this.f17083b.getPaddingLeft() + OSwipeLayout.b(this.f17083b);
        L43:
            return this.f17083b.getPaddingLeft();
        L45:
            if (this.f17083b.getCurrentBottomView() != r10) goto L66;
            int r25 = d.f17086a[OSwipeLayout.a(this.f17083b).ordinal()];
            if (r25 == 1) goto L65;
            if (r25 == 2) goto L65;
            if (r25 == 3) goto L59;
            if (r25 != 4) goto L66;
            if (OSwipeLayout.n(this.f17083b) != ShowMode.PullOut) goto L66;
            if (r11 >= (this.f17083b.getMeasuredWidth() - OSwipeLayout.b(this.f17083b))) goto L66;
            return this.f17083b.getMeasuredWidth() - OSwipeLayout.b(this.f17083b);
        L59:
            if (OSwipeLayout.n(this.f17083b) != ShowMode.PullOut) goto L66;
            if (r11 <= this.f17083b.getPaddingLeft()) goto L66;
            return this.f17083b.getPaddingLeft();
        L65:
            return this.f17083b.getPaddingLeft();
        }

        @Override // androidx.customview.widget.b.c
        public int clampViewPositionVertical(View r10, int r11, int r12) {
            if (r10 != this.f17083b.getSurfaceView()) goto L28;
            int r13 = d.f17086a[OSwipeLayout.a(this.f17083b).ordinal()];
            if (r13 == 1) goto L21;
            if (r13 == 2) goto L13;
            if (r13 == 3) goto L11;
            if (r13 == 4) goto L11;
        L68:
            return r11;
        L11:
            return this.f17083b.getPaddingTop();
        L13:
            if (r11 >= (this.f17083b.getPaddingTop() - OSwipeLayout.b(this.f17083b))) goto L17;
            return this.f17083b.getPaddingTop() - OSwipeLayout.b(this.f17083b);
        L17:
            if (r11 <= this.f17083b.getPaddingTop()) goto L68;
            return this.f17083b.getPaddingTop();
        L21:
            if (r11 >= this.f17083b.getPaddingTop()) goto L25;
            return this.f17083b.getPaddingTop();
        L25:
            if (r11 <= (this.f17083b.getPaddingTop() + OSwipeLayout.b(this.f17083b))) goto L68;
            return this.f17083b.getPaddingTop() + OSwipeLayout.b(this.f17083b);
        L28:
            View r14 = this.f17083b.getSurfaceView();
            if (r14 != null) goto L31;
            int r15 = 0;
        L32:
            int r16 = d.f17086a[OSwipeLayout.a(this.f17083b).ordinal()];
            if (r16 == 1) goto L55;
            if (r16 == 2) goto L41;
            if (r16 == 3) goto L39;
            if (r16 != 4) goto L68;
        L39:
            return this.f17083b.getPaddingTop();
        L41:
            if (OSwipeLayout.n(this.f17083b) == ShowMode.PullOut) goto L43;
            int r17 = r15 + r12;
            if (r17 < this.f17083b.getPaddingTop()) goto L51;
            return this.f17083b.getPaddingTop();
        L51:
            if (r17 > (this.f17083b.getPaddingTop() - OSwipeLayout.b(this.f17083b))) goto L68;
            return this.f17083b.getPaddingTop() - OSwipeLayout.b(this.f17083b);
        L43:
            if (r11 >= (this.f17083b.getMeasuredHeight() - OSwipeLayout.b(this.f17083b))) goto L68;
            return this.f17083b.getMeasuredHeight() - OSwipeLayout.b(this.f17083b);
        L55:
            if (OSwipeLayout.n(this.f17083b) == ShowMode.PullOut) goto L57;
            int r18 = r15 + r12;
            if (r18 >= this.f17083b.getPaddingTop()) goto L65;
            return this.f17083b.getPaddingTop();
        L65:
            if (r18 <= (this.f17083b.getPaddingTop() + OSwipeLayout.b(this.f17083b))) goto L68;
            return this.f17083b.getPaddingTop() + OSwipeLayout.b(this.f17083b);
        L57:
            if (r11 <= this.f17083b.getPaddingTop()) goto L68;
            return this.f17083b.getPaddingTop();
        L31:
            r15 = r14.getTop();
            goto L32
        }

        @Override // androidx.customview.widget.b.c
        public int getViewHorizontalDragRange(View r10) {
            OSwipeLayout r11 = this.f17083b;
            int r12 = r11.f17079x;
            if (r12 <= 0) goto L7;
            return (int) ((r12 * r11.f17078w) * 2.0f);
        L7:
            return OSwipeLayout.b(r11);
        }

        @Override // androidx.customview.widget.b.c
        public int getViewVerticalDragRange(View r10) {
            return OSwipeLayout.b(this.f17083b);
        }

        @Override // androidx.customview.widget.b.c
        public void onViewPositionChanged(View r10, int r11, int r12, int r13, int r14) {
            View r15 = this.f17083b.getSurfaceView();
            if (r15 != null) goto L5;
            return;
        L5:
            View r16 = this.f17083b.getCurrentBottomView();
            int r17 = r15.getLeft();
            int r18 = r15.getRight();
            int r19 = r15.getTop();
            int r20 = r15.getBottom();
            if (r10 != r15) goto L18;
            if (OSwipeLayout.n(this.f17083b) != ShowMode.PullOut) goto L46;
            if (r16 == null) goto L46;
            if (OSwipeLayout.a(this.f17083b) != DragEdge.Left) goto L13;
        L16:
            r16.offsetLeftAndRight(r13);
            goto L46
        L13:
            if (OSwipeLayout.a(this.f17083b) == DragEdge.Right) goto L16;
            r16.offsetTopAndBottom(r14);
        L46:
            this.f17083b.C(r17, r19, r18, r20);
            this.f17083b.D(r17, r19, r13, r14);
            if (OSwipeLayout.i(this.f17083b) == true) goto L49;
        L61:
            this.f17083b.invalidate();
            OSwipeLayout.c(this.f17083b);
            return;
        L49:
            if (OSwipeLayout.a(this.f17083b) != DragEdge.Right) goto L61;
            OSwipeLayout r21 = this.f17083b;
            int r22 = r21.f17079x;
            if (r22 > 0) goto L54;
            r22 = OSwipeLayout.b(r21);
        L54:
            int r23 = this.f17083b.getPaddingLeft();
            OSwipeLayout r110 = this.f17083b;
            if (r17 >= (r23 - ((int) (r22 * r110.f17077v)))) goto L57;
            boolean r24 = true;
        L59:
            if (OSwipeLayout.o(r110) == null) goto L61;
            OSwipeLayout.o(this.f17083b).onQuickDeleteStateChanged(r24);
            goto L61
        L57:
            r24 = false;
            goto L59
        L18:
            if (this.f17083b.getBottomViews().contains(r10) == false) goto L46;
            if (OSwipeLayout.n(this.f17083b) != ShowMode.PullOut) goto L22;
            r15.offsetLeftAndRight(r13);
            r15.offsetTopAndBottom(r14);
            goto L46
        L22:
            OSwipeLayout r25 = this.f17083b;
            Rect r26 = OSwipeLayout.r(r25, OSwipeLayout.a(r25));
            if (r16 == null) goto L25;
            r16.layout(r26.left, r26.top, r26.right, r26.bottom);
        L25:
            int r27 = r15.getLeft() + r13;
            int r111 = r15.getTop() + r14;
            if (OSwipeLayout.a(this.f17083b) != DragEdge.Left) goto L31;
            if (r27 >= this.f17083b.getPaddingLeft()) goto L31;
            r27 = this.f17083b.getPaddingLeft();
        L45:
            r15.layout(r27, r111, this.f17083b.getMeasuredWidth() + r27, this.f17083b.getMeasuredHeight() + r111);
        L31:
            if (OSwipeLayout.a(this.f17083b) != DragEdge.Right) goto L36;
            if (r27 <= this.f17083b.getPaddingLeft()) goto L36;
            r27 = this.f17083b.getPaddingLeft();
        L36:
            if (OSwipeLayout.a(this.f17083b) != DragEdge.Top) goto L41;
            if (r111 >= this.f17083b.getPaddingTop()) goto L41;
            r111 = this.f17083b.getPaddingTop();
        L41:
            if (OSwipeLayout.a(this.f17083b) != DragEdge.Bottom) goto L45;
            if (r111 <= this.f17083b.getPaddingTop()) goto L45;
            r111 = this.f17083b.getPaddingTop();
            goto L45
        }

        @Override // androidx.customview.widget.b.c
        public void onViewReleased(View r10, float r11, float r12) {
            super.onViewReleased(r10, r11, r12);
            if (OSwipeLayout.i(this.f17083b) == true) goto L5;
        L17:
            this.f17083b.Z(r11, r12, this.f17082a);
            Iterator r13 = OSwipeLayout.q(this.f17083b).iterator();
        L19:
            if (r13.hasNext() == false) goto L21;
            ((SwipeListener) r13.next()).onHandRelease(this.f17083b, r11, r12);
            goto L19
        L21:
            this.f17083b.invalidate();
            return;
        L5:
            if (OSwipeLayout.a(this.f17083b) != DragEdge.Right) goto L17;
            OSwipeLayout r14 = this.f17083b;
            int r15 = r14.f17079x;
            if (r15 > 0) goto L10;
            r15 = OSwipeLayout.b(r14);
        L10:
            int r16 = this.f17083b.getPaddingLeft();
            OSwipeLayout r17 = this.f17083b;
            int r18 = r16 - ((int) (r15 * r17.f17077v));
            View r19 = r17.getSurfaceView();
            if (r19 == null) goto L17;
            if (r19.getLeft() >= r18) goto L17;
            if (OSwipeLayout.o(this.f17083b) == null) goto L17;
            OSwipeLayout.p(this.f17083b, true);
            OSwipeLayout.o(this.f17083b).onQuickDeleteAction();
            goto L17
        }

        @Override // androidx.customview.widget.b.c
        public boolean tryCaptureView(View r10, int r11) {
            boolean r12 = true;
            if (r10 != this.f17083b.getSurfaceView()) goto L5;
        L8:
            boolean r13 = true;
        L9:
            if (r13 == true) goto L11;
        L15:
            return r13;
        L11:
            if (this.f17083b.getOpenStatus() == Status.Close) goto L14;
            r12 = false;
        L14:
            this.f17082a = r12;
            OSwipeLayout.l(this.f17083b, r10.getLeft());
            goto L15
        L5:
            if (this.f17083b.getBottomViews().contains(r10) == true) goto L8;
            r13 = false;
            goto L9
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OSwipeLayout f17084a;

        public b(OSwipeLayout r10) {
            this.f17084a = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            OSwipeLayout.d(this.f17084a);
        }
    }

    public class c implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OSwipeLayout f17085a;

        public c(OSwipeLayout r10) {
            this.f17085a = r10;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View r10) {
            OSwipeLayout.e(this.f17085a);
            return true;
        }
    }

    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17086a = null;

        static {
            int[] r10 = new int[DragEdge.values().length];
            f17086a = r10;
            r10[DragEdge.Top.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f17086a[DragEdge.Bottom.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f17086a[DragEdge.Left.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f17086a[DragEdge.Right.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public class e extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OSwipeLayout f17087a;

        public e(OSwipeLayout r10) {
            this.f17087a = r10;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent r10) {
            if (OSwipeLayout.h(this.f17087a) == null) goto L21;
            View r11 = this.f17087a.getCurrentBottomView();
            View r12 = this.f17087a.getSurfaceView();
            if (r11 != null) goto L7;
        L15:
            r11 = r12;
        L16:
            DoubleClickListener r13 = OSwipeLayout.h(this.f17087a);
            OSwipeLayout r14 = this.f17087a;
            if (r11 != r12) goto L19;
            boolean r15 = true;
        L20:
            r13.onDoubleClick(r14, r15);
            goto L21
        L19:
            r15 = false;
            goto L20
        L7:
            if (r10.getX() <= r11.getLeft()) goto L15;
            if (r10.getX() >= r11.getRight()) goto L15;
            if (r10.getY() <= r11.getTop()) goto L15;
            if (r10.getY() >= r11.getBottom()) goto L15;
        L21:
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent r10) {
            if (OSwipeLayout.f(this.f17087a) == false) goto L8;
            if (OSwipeLayout.g(this.f17087a, r10) == false) goto L8;
            this.f17087a.v();
        L8:
            return super.onSingleTapUp(r10);
        }
    }

    static {
        L = DragEdge.Right;
    }

    public OSwipeLayout(Context r10) {
        this(r10, null);
    }

    private int F(float r10) {
        return (int) ((r10 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static /* synthetic */ DragEdge a(OSwipeLayout r10) {
        return r10.f17057b;
    }

    public static /* synthetic */ int b(OSwipeLayout r10) {
        return r10.f17060e;
    }

    public static /* synthetic */ void c(OSwipeLayout r10) {
        r10.t();
    }

    private void checkCanDrag(MotionEvent r13) {
        if (this.D == true) goto L5;
    L7:
        Status r10 = getOpenStatus();
        Status r11 = Status.Middle;
        if (r10 != r11) goto L11;
        this.D = true;
        return;
    L11:
        Status r12 = getOpenStatus();
        float r14 = r13.getRawX() - this.E;
        float r15 = r13.getRawY() - this.F;
        float r16 = (float) Math.toDegrees(Math.atan(Math.abs(r15 / r14)));
        Status r17 = getOpenStatus();
        Status r18 = Status.Close;
        if (r17 == r18) goto L14;
    L38:
        DragEdge r19 = this.f17057b;
        boolean r20 = false;
        if (r19 != DragEdge.Right) goto L64;
        Status r21 = Status.Open;
        if (r12 == r21) goto L43;
    L44:
        if (r12 == r18) goto L46;
    L48:
        boolean r110 = false;
    L50:
        if (this.f17075t == false) goto L55;
        if (r12 != r21) goto L55;
        if (r14 >= (-this.f17056a)) goto L55;
        r110 = true;
    L55:
        if (r110 == true) goto L59;
        if (r12 == r11) goto L59;
        boolean r22 = false;
    L61:
        if (r16 > 30.0f) goto L63;
        if (r22 == true) goto L64;
    L63:
        boolean r23 = true;
    L66:
        if (r19 != DragEdge.Left) goto L86;
        if (r12 == Status.Open) goto L70;
    L71:
        if (r12 == r18) goto L73;
    L75:
        boolean r24 = false;
    L76:
        if (r24 == true) goto L80;
        if (r12 == r11) goto L80;
        boolean r25 = false;
    L82:
        if (r16 > 30.0f) goto L84;
        if (r25 == true) goto L86;
    L84:
        r23 = true;
    L80:
        r25 = true;
        goto L82
    L73:
        if (r14 <= this.f17056a) goto L75;
    L74:
        r24 = true;
        goto L76
    L70:
        if (r14 < (-this.f17056a)) goto L74;
    L86:
        if (r19 != DragEdge.Top) goto L106;
        if (r12 == Status.Open) goto L90;
    L91:
        if (r12 == r18) goto L93;
    L95:
        boolean r26 = false;
    L96:
        if (r26 == true) goto L100;
        if (r12 == r11) goto L100;
        boolean r27 = false;
    L102:
        if (r16 < 60.0f) goto L104;
        if (r27 == true) goto L106;
    L104:
        r23 = true;
    L100:
        r27 = true;
        goto L102
    L93:
        if (r15 <= this.f17056a) goto L95;
    L94:
        r26 = true;
        goto L96
    L90:
        if (r15 < (-this.f17056a)) goto L94;
    L106:
        if (r19 == DragEdge.Bottom) goto L108;
    L123:
        this.D = !r23;
        return;
    L108:
        if (r12 == Status.Open) goto L110;
    L111:
        if (r12 == r18) goto L113;
    L115:
        boolean r111 = false;
    L116:
        if (r111 == true) goto L118;
        if (r12 == r11) goto L118;
    L120:
        if (r16 < 60.0f) goto L122;
        if (r20 == true) goto L123;
    L122:
        r23 = true;
    L118:
        r20 = true;
        goto L120
    L113:
        if (r15 >= (-this.f17056a)) goto L115;
    L114:
        r111 = true;
        goto L116
    L110:
        if (r15 > this.f17056a) goto L114;
    L59:
        r22 = true;
        goto L61
    L46:
        if (r14 >= (-this.f17056a)) goto L48;
    L47:
        r110 = true;
        goto L50
    L43:
        if (r14 > this.f17056a) goto L47;
    L64:
        r23 = false;
        goto L66
    L14:
        if (r16 >= 45.0f) goto L27;
        if (r14 <= 0.0f) goto L21;
        if (M() == false) goto L21;
        DragEdge r28 = DragEdge.Left;
    L36:
        setCurrentDragEdge(r28);
    L21:
        if (r14 < 0.0f) goto L23;
        return;
    L23:
        if (N() == false) goto L125;
        r28 = DragEdge.Right;
        goto L36
    L125:
        return;
    L27:
        if (r15 <= 0.0f) goto L32;
        if (P() == false) goto L32;
        r28 = DragEdge.Top;
    L32:
        if (r15 < 0.0f) goto L34;
        return;
    L34:
        if (K() == false) goto L126;
        r28 = DragEdge.Bottom;
        goto L36
    L126:
        return;
    L5:
        if (this.C == true) goto L7;
    }

    public static /* synthetic */ void d(OSwipeLayout r10) {
        r10.X();
    }

    public static /* synthetic */ boolean e(OSwipeLayout r10) {
        return r10.Y();
    }

    public static /* synthetic */ boolean f(OSwipeLayout r10) {
        return r10.f17072q;
    }

    public static /* synthetic */ boolean g(OSwipeLayout r10, MotionEvent r11) {
        return r10.Q(r11);
    }

    private AdapterView getAdapterView() {
        ViewParent r10 = getParent();
        if (G() == false) goto L9;
    L4:
        if (r10 == null) goto L9;
        if ((r10 instanceof AdapterView) == true) goto L9;
        r10 = r10.getParent();
    L9:
        if ((r10 instanceof AdapterView) == true) goto L11;
        return null;
    L11:
        return (AdapterView) r10;
    }

    private float getCurrentOffset() {
        DragEdge r10 = this.f17057b;
        if (r10 != null) goto L7;
        return 0.0f;
    L7:
        return this.f17063h[r10.ordinal()];
    }

    public static /* synthetic */ DoubleClickListener h(OSwipeLayout r10) {
        return r10.f17069n;
    }

    public static /* synthetic */ boolean i(OSwipeLayout r10) {
        return r10.f17075t;
    }

    public static /* synthetic */ androidx.customview.widget.b j(OSwipeLayout r10) {
        return r10.f17058c;
    }

    public static /* synthetic */ float k(OSwipeLayout r10) {
        return r10.f17059d;
    }

    public static /* synthetic */ float l(OSwipeLayout r10, float r11) {
        r10.f17059d = r11;
        return r11;
    }

    public static /* synthetic */ float m(OSwipeLayout r10, float r11) {
        float r12 = r10.f17059d + r11;
        r10.f17059d = r12;
        return r12;
    }

    public static /* synthetic */ ShowMode n(OSwipeLayout r10) {
        return r10.f17062g;
    }

    public static /* synthetic */ QuickDeleteListener o(OSwipeLayout r10) {
        return r10.f17076u;
    }

    public static /* synthetic */ boolean p(OSwipeLayout r10, boolean r11) {
        r10.f17080y = r11;
        return r11;
    }

    public static /* synthetic */ List q(OSwipeLayout r10) {
        return r10.f17064i;
    }

    public static /* synthetic */ Rect r(OSwipeLayout r10, DragEdge r11) {
        return r10.y(r11);
    }

    private void setCurrentDragEdge(DragEdge r10) {
        this.f17057b = r10;
        b0();
    }

    public final Rect A(boolean r10) {
        int r11 = getPaddingLeft();
        int r12 = getPaddingTop();
        if (r10 == false) goto L15;
        DragEdge r13 = this.f17057b;
        if (r13 != DragEdge.Left) goto L8;
        int r14 = getPaddingLeft();
        r11 = this.f17060e + r14;
        goto L15
    L8:
        if (r13 != DragEdge.Right) goto L11;
        r11 = getPaddingLeft() - this.f17060e;
        goto L15
    L11:
        if (r13 != DragEdge.Top) goto L13;
        int r15 = getPaddingTop();
        r12 = this.f17060e + r15;
        goto L15
    L13:
        r12 = getPaddingTop() - this.f17060e;
    L15:
        return new Rect(r11, r12, getMeasuredWidth() + r11, getMeasuredHeight() + r12);
    }

    public final boolean B(ViewGroup r10, View r11) {
        int r12 = r10.getChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L13;
        View r14 = r10.getChildAt(r13);
        if (r14 == r11) goto L6;
        if ((r14 instanceof ViewGroup) == false) goto L12;
        if (B((ViewGroup) r14, r11) == false) goto L12;
        return true;
    L12:
        r13 = r13 + 1;
        goto L3
    L6:
        return true;
    L13:
        return false;
    }

    public void C(int r15, int r16, int r17, int r18) {
        if (this.f17066k.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r10 = this.f17066k.entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L53;
        Map.Entry r11 = (Map.Entry) r10.next();
        View r12 = (View) r11.getKey();
        Rect r13 = I(r12);
        if (R(r12, r13, this.f17057b, r15, r16, r17, r18) == false) goto L42;
        this.f17067l.put(r12, Boolean.FALSE);
        int r14 = 0;
        float r19 = 0.0f;
        if (getShowMode() != ShowMode.LayDown) goto L23;
        int r20 = d.f17086a[this.f17057b.ordinal()];
        if (r20 == 1) goto L21;
        if (r20 == 2) goto L20;
        if (r20 == 3) goto L19;
        if (r20 != 4) goto L35;
        r14 = r13.right - r17;
        float r21 = r14;
        int r22 = r12.getWidth();
    L31:
        r19 = r21 / r22;
    L35:
        Iterator r23 = ((ArrayList) r11.getValue()).iterator();
    L37:
        if (r23.hasNext() == false) goto L42;
        ((OnRevealListener) r23.next()).onReveal(r12, this.f17057b, Math.abs(r19), r14);
        if (Math.abs(r19) != 1.0f) goto L37;
        this.f17067l.put(r12, Boolean.TRUE);
        goto L37
    L19:
        r14 = r13.left - r15;
        r21 = r14;
        r22 = r12.getWidth();
        goto L31
    L20:
        r14 = r13.bottom - r18;
        r21 = r14;
        r22 = r12.getHeight();
        goto L31
    L21:
        r14 = r13.top - r16;
        r21 = r14;
        r22 = r12.getHeight();
        goto L31
    L23:
        if (getShowMode() != ShowMode.PullOut) goto L35;
        int r24 = d.f17086a[this.f17057b.ordinal()];
        if (r24 == 1) goto L34;
        if (r24 == 2) goto L33;
        if (r24 == 3) goto L32;
        if (r24 != 4) goto L35;
        r14 = r13.left - getWidth();
        r21 = r14;
        r22 = r12.getWidth();
        goto L31
    L32:
        r14 = r13.right - getPaddingLeft();
        r21 = r14;
        r22 = r12.getWidth();
        goto L31
    L33:
        r14 = r13.top - getHeight();
        r21 = r14;
        r22 = r12.getHeight();
        goto L31
    L34:
        r14 = r13.bottom - getPaddingTop();
        r21 = r14;
        r22 = r12.getHeight();
    L42:
        if (S(r12, r13, this.f17057b, r15, r16, r17, r18) == false) goto L7;
        this.f17067l.put(r12, Boolean.TRUE);
        Iterator r25 = ((ArrayList) r11.getValue()).iterator();
    L45:
        if (r25.hasNext() == false) goto L7;
        OnRevealListener r26 = (OnRevealListener) r25.next();
        DragEdge r27 = this.f17057b;
        if (r27 == DragEdge.Left) goto L52;
        if (r27 == DragEdge.Right) goto L52;
        r26.onReveal(r12, r27, 1.0f, r12.getHeight());
    L52:
        r26.onReveal(r12, r27, 1.0f, r12.getWidth());
        goto L45
    }

    public void D(int r10, int r11, int r12, int r13) {
        DragEdge r14 = getDragEdge();
        boolean r15 = false;
        if (r14 != DragEdge.Left) goto L7;
        if (r12 < 0) goto L19;
    L18:
        r15 = true;
    L19:
        E(r10, r11, r15);
        return;
    L7:
        if (r14 != DragEdge.Right) goto L11;
        if (r12 <= 0) goto L18;
    L11:
        if (r14 != DragEdge.Top) goto L15;
        if (r13 >= 0) goto L18;
    L15:
        if (r14 != DragEdge.Bottom) goto L18;
        if (r13 <= 0) goto L18;
        goto L18
    }

    public void E(int r10, int r11, boolean r12) {
        a0();
        Status r13 = getOpenStatus();
        if (this.f17064i.isEmpty() == true) goto L37;
        this.A++;
        Iterator r14 = this.f17064i.iterator();
    L6:
        if (r14.hasNext() == false) goto L14;
        SwipeListener r15 = (SwipeListener) r14.next();
        if (this.A != 1) goto L12;
        if (r12 == false) goto L11;
        r15.onStartOpen(this);
        goto L12
    L11:
        r15.onStartClose(this);
    L12:
        r15.onUpdate(this, r10 - getPaddingLeft(), r11 - getPaddingTop());
        goto L6
    L14:
        if (r13 != Status.Close) goto L21;
        Iterator r16 = this.f17064i.iterator();
    L17:
        if (r16.hasNext() == false) goto L19;
        ((SwipeListener) r16.next()).onClose(this);
        goto L17
    L19:
        this.A = 0;
    L21:
        if (r13 != Status.Open) goto L38;
        View r17 = getCurrentBottomView();
        if (r17 == null) goto L25;
        r17.setEnabled(true);
    L25:
        Iterator r18 = this.f17064i.iterator();
    L27:
        if (r18.hasNext() == false) goto L29;
        ((SwipeListener) r18.next()).onOpen(this);
        goto L27
    L29:
        this.A = 0;
        return;
    L38:
        return;
    }

    public boolean G() {
        return this.G;
    }

    public final int H(ViewGroup r10, View r11) {
        int r12 = r10.getChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L13;
        View r14 = r10.getChildAt(r13);
        if (r14 == r11) goto L6;
        if ((r14 instanceof ViewGroup) == false) goto L12;
        if (B((ViewGroup) r14, r11) == false) goto L12;
        return r13;
    L12:
        r13 = r13 + 1;
        goto L3
    L6:
        return r13;
    L13:
        return -1;
    }

    public Rect I(View r10) {
        Rect r11 = new Rect(r10.getLeft(), r10.getTop(), 0, 0);
        View r12 = r10;
    L4:
        if (r12.getParent() == null) goto L11;
        if (r12 == getRootView()) goto L11;
        r12 = (View) r12.getParent();
        if (r12 == this) goto L11;
        r11.left += r12.getLeft();
        r11.top += r12.getTop();
    L11:
        r11.right = r11.left + r10.getMeasuredWidth();
        r11.bottom = r11.top + r10.getMeasuredHeight();
        return r11;
    }

    public final boolean J() {
        if (getAdapterView() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean K() {
        LinkedHashMap r10 = this.f17061f;
        DragEdge r11 = DragEdge.Bottom;
        View r12 = (View) r10.get(r11);
        if (r12 != null) goto L5;
    L11:
        return false;
    L5:
        if (r12.getParent() != this) goto L11;
        if (r12 == getSurfaceView()) goto L11;
        if (this.f17071p[r11.ordinal()] == false) goto L11;
        return true;
    }

    public final boolean L(MotionEvent r10) {
        View r11 = getSurfaceView();
        if (r11 != null) goto L5;
        return false;
    L5:
        int r12 = (int) r10.getX();
        int r13 = (int) r10.getY();
        if (r12 >= r11.getLeft()) goto L8;
        return false;
    L8:
        if (r12 <= r11.getRight()) goto L10;
        return false;
    L10:
        if (r13 >= r11.getTop()) goto L12;
        return false;
    L12:
        if (r13 > r11.getBottom()) goto L18;
        return true;
    L18:
        return false;
    }

    public boolean M() {
        LinkedHashMap r10 = this.f17061f;
        DragEdge r11 = DragEdge.Left;
        View r12 = (View) r10.get(r11);
        if (r12 != null) goto L5;
    L11:
        return false;
    L5:
        if (r12.getParent() != this) goto L11;
        if (r12 == getSurfaceView()) goto L11;
        if (this.f17071p[r11.ordinal()] == false) goto L11;
        return true;
    }

    public boolean N() {
        LinkedHashMap r10 = this.f17061f;
        DragEdge r11 = DragEdge.Right;
        View r12 = (View) r10.get(r11);
        if (r12 != null) goto L5;
    L11:
        return false;
    L5:
        if (r12.getParent() != this) goto L11;
        if (r12 == getSurfaceView()) goto L11;
        if (this.f17071p[r11.ordinal()] == false) goto L11;
        return true;
    }

    public boolean O() {
        return this.f17070o;
    }

    public boolean P() {
        LinkedHashMap r10 = this.f17061f;
        DragEdge r11 = DragEdge.Top;
        View r12 = (View) r10.get(r11);
        if (r12 != null) goto L5;
    L11:
        return false;
    L5:
        if (r12.getParent() != this) goto L11;
        if (r12 == getSurfaceView()) goto L11;
        if (this.f17071p[r11.ordinal()] == false) goto L11;
        return true;
    }

    public final boolean Q(MotionEvent r10) {
        View r11 = getSurfaceView();
        if (r11 != null) goto L7;
        return false;
    L7:
        if (this.f17055J != null) goto L9;
        this.f17055J = new Rect();
    L9:
        r11.getHitRect(this.f17055J);
        return this.f17055J.contains((int) r10.getX(), (int) r10.getY());
    }

    public boolean R(View r10, Rect r11, DragEdge r12, int r13, int r14, int r15, int r16) {
        int r17 = r11.left;
        int r18 = r11.right;
        int r19 = r11.top;
        int r110 = r11.bottom;
        if (getShowMode() != ShowMode.LayDown) goto L23;
        int r20 = d.f17086a[r12.ordinal()];
        if (r20 == 1) goto L19;
        if (r20 == 2) goto L16;
        if (r20 == 3) goto L13;
        if (r20 != 4) goto L68;
        if (r15 <= r17) goto L50;
        if (r15 > r18) goto L52;
        return true;
    L52:
        return false;
    L50:
        return false;
    L68:
        return false;
    L13:
        if (r13 >= r18) goto L53;
        if (r13 < r17) goto L54;
        return true;
    L54:
        return false;
    L53:
        return false;
    L16:
        if (r16 <= r19) goto L55;
        if (r16 > r110) goto L56;
        return true;
    L56:
        return false;
    L55:
        return false;
    L19:
        if (r14 < r19) goto L57;
        if (r14 >= r110) goto L58;
        return true;
    L58:
        return false;
    L57:
        return false;
    L23:
        if (getShowMode() != ShowMode.PullOut) goto L59;
        int r111 = d.f17086a[r12.ordinal()];
        if (r111 == 1) goto L46;
        if (r111 == 2) goto L41;
        if (r111 == 3) goto L36;
        if (r111 == 4) goto L31;
        return false;
    L31:
        if (r17 <= getWidth()) goto L33;
        return false;
    L33:
        if (r18 <= getWidth()) goto L61;
        return true;
    L61:
        return false;
    L36:
        if (r18 >= getPaddingLeft()) goto L38;
        return false;
    L38:
        if (r17 >= getPaddingLeft()) goto L63;
        return true;
    L63:
        return false;
    L41:
        if (r19 < getHeight()) goto L43;
        return false;
    L43:
        if (r19 < getPaddingTop()) goto L65;
        return true;
    L65:
        return false;
    L46:
        if (r19 < getPaddingTop()) goto L48;
        return false;
    L48:
        if (r110 < getPaddingTop()) goto L67;
        return true;
    L67:
        return false;
    L59:
        return false;
    }

    public boolean S(View r10, Rect r11, DragEdge r12, int r13, int r14, int r15, int r16) {
        if (((Boolean) this.f17067l.get(r10)).booleanValue() == false) goto L5;
        return false;
    L5:
        int r17 = r11.left;
        int r18 = r11.right;
        int r19 = r11.top;
        int r20 = r11.bottom;
        if (getShowMode() != ShowMode.LayDown) goto L21;
        if (r12 != DragEdge.Right) goto L11;
        if (r15 > r17) goto L11;
    L41:
        return true;
    L11:
        if (r12 != DragEdge.Left) goto L14;
        if (r13 >= r18) goto L41;
    L14:
        if (r12 != DragEdge.Top) goto L17;
        if (r14 >= r20) goto L41;
    L17:
        if (r12 != DragEdge.Bottom) goto L39;
        if (r16 <= r19) goto L41;
        return false;
    L39:
        return false;
    L21:
        if (getShowMode() == ShowMode.PullOut) goto L23;
        return false;
    L23:
        if (r12 != DragEdge.Right) goto L27;
        if (r18 <= getWidth()) goto L41;
    L27:
        if (r12 != DragEdge.Left) goto L31;
        if (r17 >= getPaddingLeft()) goto L41;
    L31:
        if (r12 != DragEdge.Top) goto L35;
        if (r19 >= getPaddingTop()) goto L41;
    L35:
        if (r12 == DragEdge.Bottom) goto L37;
        return false;
    L37:
        if (r20 <= getHeight()) goto L41;
        return false;
    }

    public void T() {
        View r10 = getSurfaceView();
        Rect r11 = (Rect) this.f17068m.get(r10);
        if (r11 != null) goto L5;
        r11 = A(false);
    L5:
        if (r10 == null) goto L7;
        r10.layout(r11.left, r11.top, r11.right, r11.bottom);
        bringChildToFront(r10);
    L7:
        View r12 = getCurrentBottomView();
        Rect r13 = (Rect) this.f17068m.get(r12);
        if (r13 != null) goto L10;
        r13 = z(ShowMode.LayDown, r11);
    L10:
        if (r12 == null) goto L13;
        r12.layout(r13.left, r13.top, r13.right, r13.bottom);
        return;
    }

    public void U() {
        View r10 = getSurfaceView();
        Rect r11 = (Rect) this.f17068m.get(r10);
        if (r11 == null) goto L5;
    L9:
        if (r10 == null) goto L11;
        r10.layout(r11.left, r11.top, r11.right, r11.bottom);
        bringChildToFront(r10);
    L11:
        View r12 = getCurrentBottomView();
        Rect r13 = (Rect) this.f17068m.get(r12);
        if (r13 != null) goto L14;
        r13 = z(ShowMode.PullOut, r11);
    L14:
        if (r12 == null) goto L17;
        r12.layout(r13.left, r13.top, r13.right, r13.bottom);
        return;
    L17:
        return;
    L5:
        if (getOpenStatus() == Status.Close) goto L7;
        boolean r14 = true;
    L8:
        r11 = A(r14);
        goto L9
    L7:
        r14 = false;
        goto L8
    }

    public void V() {
        W(true, true);
    }

    public void W(boolean r10, boolean r11) {
        View r12 = getSurfaceView();
        View r13 = getCurrentBottomView();
        if (r12 != null) goto L5;
        return;
    L5:
        androidx.customview.widget.b r14 = this.f17058c;
        if (r14 == null) goto L8;
        r14.a();
    L8:
        Rect r15 = A(true);
        if (r10 == false) goto L11;
        this.f17058c.Q(r12, r15.left, r15.top);
    L30:
        invalidate();
        return;
    L11:
        int r16 = r15.left - r12.getLeft();
        int r17 = r15.top - r12.getTop();
        r12.layout(r15.left, r15.top, r15.right, r15.bottom);
        Rect r18 = (Rect) this.f17068m.get(r12);
        if (r18 != null) goto L14;
        r18 = new Rect();
        this.f17068m.put(r12, r18);
    L14:
        r18.set(r15);
        ShowMode r19 = getShowMode();
        ShowMode r20 = ShowMode.PullOut;
        if (r19 != r20) goto L19;
        Rect r21 = z(r20, r15);
        if (r13 == null) goto L27;
        r13.layout(r21.left, r21.top, r21.right, r21.bottom);
    L27:
        if (r11 == false) goto L29;
        C(r15.left, r15.top, r15.right, r15.bottom);
        D(r15.left, r15.top, r16, r17);
        goto L30
    L29:
        a0();
        goto L30
    L19:
        ShowMode r22 = getShowMode();
        ShowMode r23 = ShowMode.LayDown;
        if (r22 != r23) goto L27;
        Rect r24 = z(r23, r15);
        if (r13 == null) goto L27;
        Rect r25 = (Rect) this.f17068m.get(r13);
        if (r25 != null) goto L26;
        r25 = new Rect();
        this.f17068m.put(r13, r25);
    L26:
        r25.set(r24);
        r13.layout(r24.left, r24.top, r24.right, r24.bottom);
        goto L27
    }

    public final void X() {
        if (getOpenStatus() == Status.Close) goto L5;
        return;
    L5:
        AdapterView r10 = getAdapterView();
        if (r10 == null) goto L15;
        int r11 = r10.getPositionForView(this);
        if (r11 == (-1)) goto L10;
    L12:
        if (r11 == (-1)) goto L16;
        r10.performItemClick(r10.getChildAt(r11 - r10.getFirstVisiblePosition()), r11, r10.getAdapter().getItemId(r11));
        return;
    L16:
        return;
    L10:
        if (G() == false) goto L12;
        r11 = H(r10, this);
        goto L12
    }

    public final boolean Y() {
        if (getOpenStatus() == Status.Close) goto L5;
        return false;
    L5:
        AdapterView<?> r10 = getAdapterView();
        if (r10 == null) goto L26;
        int r11 = r10.getPositionForView(this);
        if (r11 == (-1)) goto L10;
    L12:
        int r12 = r11;
        if (r12 != (-1)) goto L15;
        return false;
    L15:
        long r13 = r10.getItemIdAtPosition(r12);
        Method r14 = AbsListView.class.getDeclaredMethod("performLongPress", new Class[]{View.class, Integer.TYPE, Long.TYPE});     // Catch: Exception -> L18
        r14.setAccessible(true);     // Catch: Exception -> L18
        return ((Boolean) r14.invoke(r10, new Object[]{this, Integer.valueOf(r12), Long.valueOf(r13)})).booleanValue();
    L18:
        e = move-exception;
        e.printStackTrace();
        if (r10.getOnItemLongClickListener() == null) goto L22;
        boolean r15 = r10.getOnItemLongClickListener().onItemLongClick(r10, this, r12, r13);
    L23:
        if (r15 == false) goto L29;
        r10.performHapticFeedback(0);
        return r15;
    L29:
        return r15;
    L22:
        r15 = false;
        goto L23
    L10:
        if (G() == false) goto L12;
        r11 = H(r10, this);
        goto L12
    L26:
        return false;
    }

    public void Z(float r10, float r11, boolean r12) {
        float r13 = this.f17058c.A();
        View r14 = getSurfaceView();
        DragEdge r15 = this.f17057b;
        if (r15 == null) goto L63;
        if (r14 != null) goto L7;
        return;
    L7:
        if (this.f17075t == true) goto L9;
    L11:
        if (r12 == false) goto L13;
        float r16 = this.f17074s;
    L15:
        if (r15 != DragEdge.Left) goto L27;
        if (r10 <= r13) goto L20;
        V();
        return;
    L20:
        if (r10 >= (-r13)) goto L23;
        v();
        return;
    L23:
        if (((getSurfaceView().getLeft() * 1.0f) / this.f17060e) <= r16) goto L25;
        V();
        return;
    L25:
        v();
        return;
    L27:
        if (r15 != DragEdge.Right) goto L39;
        if (r10 <= r13) goto L32;
        v();
        return;
    L32:
        if (r10 >= (-r13)) goto L35;
        V();
        return;
    L35:
        if ((((-getSurfaceView().getLeft()) * 1.0f) / this.f17060e) <= r16) goto L37;
        V();
        return;
    L37:
        v();
        return;
    L39:
        if (r15 != DragEdge.Top) goto L51;
        if (r11 <= r13) goto L44;
        V();
        return;
    L44:
        if (r11 >= (-r13)) goto L47;
        v();
        return;
    L47:
        if (((getSurfaceView().getTop() * 1.0f) / this.f17060e) <= r16) goto L49;
        V();
        return;
    L49:
        v();
        return;
    L51:
        if (r15 == DragEdge.Bottom) goto L53;
        return;
    L53:
        if (r11 <= r13) goto L56;
        v();
        return;
    L56:
        if (r11 >= (-r13)) goto L59;
        V();
        return;
    L59:
        if ((((-getSurfaceView().getTop()) * 1.0f) / this.f17060e) <= r16) goto L61;
        V();
        return;
    L61:
        v();
        return;
    L13:
        r16 = this.f17073r;
        goto L15
    L9:
        if (this.f17080y == false) goto L11;
        return;
    }

    public final void a0() {
        Status r10 = getOpenStatus();
        List<View> r11 = getBottomViews();
        if (r10 != Status.Close) goto L12;
        Iterator<View> r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L27;
        View r13 = r12.next();
        if (r13 == null) goto L6;
        if (r13.getVisibility() == 4) goto L6;
        r13.setVisibility(4);
        goto L6
    L27:
        return;
    L12:
        View r14 = getCurrentBottomView();
        if (r14 != null) goto L15;
        return;
    L15:
        if (r14.getVisibility() == 0) goto L26;
        r14.setVisibility(0);
        return;
    }

    @Override // android.view.ViewGroup
    public void addView(View r10, int r11, ViewGroup.LayoutParams r12) {
        if (r10 != null) goto L32;
        return;
    L32:
        int r13 = ((Integer) r12.getClass().getField("gravity").get(r12)).intValue();     // Catch: Exception -> L6
    L8:
        if (r13 <= 0) goto L21;
        int r14 = androidx.core.view.c.b(r13, ViewCompat.A(this));
        if ((r14 & 3) != 3) goto L13;
        this.f17061f.put(DragEdge.Left, r10);
    L13:
        if ((r14 & 5) != 5) goto L16;
        this.f17061f.put(DragEdge.Right, r10);
    L16:
        if ((r14 & 48) != 48) goto L19;
        this.f17061f.put(DragEdge.Top, r10);
    L19:
        if ((r14 & 80) != 80) goto L28;
        this.f17061f.put(DragEdge.Bottom, r10);
    L28:
        if (r10.getParent() != this) goto L30;
        return;
    L30:
        super.addView(r10, r11, r12);
        return;
    L21:
        Iterator r15 = this.f17061f.entrySet().iterator();
    L23:
        if (r15.hasNext() == false) goto L28;
        Map.Entry r16 = (Map.Entry) r15.next();
        if (r16.getValue() != null) goto L23;
        this.f17061f.put((DragEdge) r16.getKey(), r10);
    L6:
        e = move-exception;
        e.printStackTrace();
        r13 = 0;
        goto L8
    }

    public final void b0() {
        View r10 = getCurrentBottomView();
        if (r10 == null) goto L11;
        DragEdge r11 = this.f17057b;
        if (r11 != DragEdge.Left) goto L7;
    L10:
        this.f17060e = r10.getMeasuredWidth() - F(getCurrentOffset());
        goto L11
    L7:
        if (r11 == DragEdge.Right) goto L10;
        this.f17060e = r10.getMeasuredHeight() - F(getCurrentOffset());
    L11:
        ShowMode r12 = this.f17062g;
        if (r12 != ShowMode.PullOut) goto L15;
        U();
    L17:
        a0();
        return;
    L15:
        if (r12 != ShowMode.LayDown) goto L17;
        T();
        goto L17
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.f17058c.n(true) == false) goto L6;
        ViewCompat.g0(this);
        return;
    }

    public List<View> getBottomViews() {
        ArrayList r10 = new ArrayList();
        DragEdge[] r11 = DragEdge.values();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        DragEdge r14 = r11[r13];
        r10.add((View) this.f17061f.get(r14));
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    public View getCurrentBottomView() {
        List<View> r10 = getBottomViews();
        if (this.f17057b.ordinal() < r10.size()) goto L5;
        return null;
    L5:
        return r10.get(this.f17057b.ordinal());
    }

    public int getDragDistance() {
        return this.f17060e;
    }

    public DragEdge getDragEdge() {
        return this.f17057b;
    }

    public Map<DragEdge, View> getDragEdgeMap() {
        return this.f17061f;
    }

    @Deprecated
    public List<DragEdge> getDragEdges() {
        return new ArrayList(this.f17061f.keySet());
    }

    public boolean getIsBeingDragged() {
        return this.D;
    }

    public Status getOpenStatus() {
        View r10 = getSurfaceView();
        if (r10 == null) goto L5;
        int r11 = r10.getLeft();
        int r12 = r10.getTop();
        if (r11 != getPaddingLeft()) goto L13;
        if (r12 != getPaddingTop()) goto L13;
        return Status.Close;
    L13:
        if (r11 == (getPaddingLeft() - this.f17060e)) goto L24;
        if (r11 == (getPaddingLeft() + this.f17060e)) goto L24;
        if (r12 == (getPaddingTop() - this.f17060e)) goto L24;
        if (r12 == (getPaddingTop() + this.f17060e)) goto L24;
        return Status.Middle;
    L24:
        return Status.Open;
    L5:
        return Status.Close;
    }

    public ShowMode getShowMode() {
        return this.f17062g;
    }

    public View getSurfaceView() {
        if (getChildCount() != 0) goto L7;
        return null;
    L7:
        return getChildAt(getChildCount() - 1);
    }

    public float getWillOpenPercentAfterClose() {
        return this.f17074s;
    }

    public float getWillOpenPercentAfterOpen() {
        return this.f17073r;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (J() == true) goto L5;
        return;
    L5:
        if (this.H != null) goto L8;
        setOnClickListener(new b(this));
    L8:
        if (this.I != null) goto L12;
        setOnLongClickListener(new c(this));
        return;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        androidx.customview.widget.b r10 = this.f17058c;
        if (r10 == null) goto L6;
        r10.a();
    L6:
        if (getOpenStatus() == Status.Close) goto L9;
        w(false);
        return;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        if (O() == true) goto L6;
        return false;
    L6:
        if (this.f17072q == true) goto L8;
    L12:
        Iterator r11 = this.f17065j.iterator();
    L14:
        if (r11.hasNext() == false) goto L20;
        SwipeDenier r12 = (SwipeDenier) r11.next();
        if (r12 == null) goto L14;
        if (r12.shouldDenySwipe(r10) == false) goto L14;
        return false;
    L20:
        int r13 = r10.getAction();
        if (r13 == 0) goto L40;
        if (r13 != 1) goto L24;
    L39:
        this.C = false;
        this.D = false;
        this.f17058c.processTouchEvent(r10);
    L49:
        return this.D;
    L24:
        if (r13 != 2) goto L26;
        boolean r14 = this.D;
        checkCanDrag(r10);
        if (this.D == true) goto L31;
    L35:
        if (r14 == true) goto L49;
        if (this.D == false) goto L49;
        return false;
    L31:
        if (this.C == true) goto L35;
        ViewParent r15 = getParent();
        if (r15 == null) goto L35;
        r15.requestDisallowInterceptTouchEvent(true);
        goto L35
    L26:
        if (r13 == 3) goto L39;
        this.f17058c.processTouchEvent(r10);
        goto L49
    L40:
        this.f17058c.processTouchEvent(r10);
        this.C = false;
        this.D = false;
        this.E = r10.getRawX();
        this.F = r10.getRawY();
        if (getOpenStatus() != Status.Middle) goto L44;
        this.D = true;
    L44:
        if (this.f17075t == false) goto L49;
        if (L(r10) == true) goto L49;
        this.C = true;
        goto L49
    L8:
        if (getOpenStatus() != Status.Open) goto L12;
        if (Q(r10) == false) goto L12;
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        b0();
        if (this.B == null) goto L8;
        int r15 = 0;
    L6:
        if (r15 >= this.B.size()) goto L10;
        ((OnLayout) this.B.get(r15)).onLayout(this);
        r15 = r15 + 1;
        goto L6
    L10:
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (O() == false) goto L5;
        int r11 = r10.getActionMasked();
        this.K.onTouchEvent(r10);
        if (r11 == 0) goto L20;
        if (r11 != 1) goto L10;
    L19:
        this.D = false;
        this.f17058c.processTouchEvent(r10);
    L22:
        if (super.onTouchEvent(r10) == true) goto L27;
        if (this.D == true) goto L27;
        if (r11 == 0) goto L27;
        return false;
    L27:
        return true;
    L10:
        if (r11 != 2) goto L12;
        checkCanDrag(r10);
        if (this.D == false) goto L22;
        if (this.C == true) goto L22;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.f17058c.processTouchEvent(r10);
        goto L22
    L12:
        if (r11 == 3) goto L19;
        this.f17058c.processTouchEvent(r10);
        goto L22
    L20:
        this.f17058c.processTouchEvent(r10);
        this.E = r10.getRawX();
        this.F = r10.getRawY();
        goto L22
    L5:
        return super.onTouchEvent(r10);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r10) {
        Iterator r11 = new HashMap(this.f17061f).entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Map.Entry r12 = (Map.Entry) r11.next();
        if (r12.getValue() != r10) goto L4;
        this.f17061f.remove(r12.getKey());
        goto L4
    }

    public void s(SwipeListener r10) {
        this.f17064i.add(r10);
    }

    public void setBottomSwipeEnabled(boolean r10) {
        this.f17071p[DragEdge.Bottom.ordinal()] = r10;
    }

    public void setClickToClose(boolean r10) {
        this.f17072q = r10;
    }

    public void setDragDistance(int r10) {
        if (r10 >= 0) goto L4;
        r10 = 0;
    L4:
        this.f17060e = F(r10);
        requestLayout();
    }

    @Deprecated
    public void setDragEdge(DragEdge r10) {
        u();
        if (getChildCount() < 2) goto L5;
        this.f17061f.put(r10, getChildAt(getChildCount() - 2));
    L5:
        setCurrentDragEdge(r10);
    }

    @Deprecated
    public void setDragEdges(List<DragEdge> r10) {
        u();
        int r11 = Math.min(r10.size(), getChildCount() - 1);
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        this.f17061f.put(r10.get(r12), getChildAt(r12));
        r12 = r12 + 1;
        goto L3
    L6:
        if (r10.size() != 0) goto L8;
    L11:
        setCurrentDragEdge(L);
        return;
    L8:
        if (r10.contains(L) == true) goto L11;
        setCurrentDragEdge(r10.get(0));
    }

    public void setLeftSwipeEnabled(boolean r10) {
        this.f17071p[DragEdge.Left.ordinal()] = r10;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r10) {
        super.setOnClickListener(r10);
        this.H = r10;
    }

    public void setOnDoubleClickListener(DoubleClickListener r10) {
        this.f17069n = r10;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r10) {
        super.setOnLongClickListener(r10);
        this.I = r10;
    }

    public void setOverrideDragDistance(int r10) {
        this.f17079x = r10;
    }

    public void setQuickDeleteEnabled(boolean r10) {
        this.f17075t = r10;
    }

    public void setQuickDeleteListener(QuickDeleteListener r10) {
        this.f17076u = r10;
    }

    public void setQuickDeleteMax(float r10) {
        this.f17078w = r10;
    }

    public void setQuickDeleteThreshold(float r10) {
        this.f17077v = r10;
    }

    public void setRightSwipeEnabled(boolean r10) {
        this.f17071p[DragEdge.Right.ordinal()] = r10;
    }

    public void setShowMode(ShowMode r10) {
        this.f17062g = r10;
        requestLayout();
    }

    public void setSwipeEnabled(boolean r10) {
        this.f17070o = r10;
    }

    public void setTopSwipeEnabled(boolean r10) {
        this.f17071p[DragEdge.Top.ordinal()] = r10;
    }

    public void setWillOpenPercentAfterClose(float r10) {
        this.f17074s = r10;
    }

    public void setWillOpenPercentAfterOpen(float r10) {
        this.f17073r = r10;
    }

    public final void t() {
        View r10 = getCurrentBottomView();
        View r11 = getSurfaceView();
        if (getOpenStatus() != Status.Close) goto L6;
        this.f17068m.remove(r10);
        this.f17068m.remove(r11);
        return;
    L6:
        View[] r12 = {r11, r10};
        int r13 = 0;
    L8:
        if (r13 >= 2) goto L13;
        View r14 = r12[r13];
        Rect r15 = (Rect) this.f17068m.get(r14);
        if (r15 != null) goto L12;
        r15 = new Rect();
        this.f17068m.put(r14, r15);
    L12:
        r15.left = r14.getLeft();
        r15.top = r14.getTop();
        r15.right = r14.getRight();
        r15.bottom = r14.getBottom();
        r13 = r13 + 1;
        goto L8
    }

    public void u() {
        this.f17061f.clear();
    }

    public void v() {
        x(true, true);
    }

    public void w(boolean r10) {
        x(r10, true);
    }

    public void x(boolean r10, boolean r11) {
        View r12 = getSurfaceView();
        if (r12 != null) goto L5;
        return;
    L5:
        androidx.customview.widget.b r13 = this.f17058c;
        if (r13 == null) goto L8;
        r13.a();
    L8:
        if (r10 == false) goto L10;
        this.f17058c.Q(getSurfaceView(), getPaddingLeft(), getPaddingTop());
    L17:
        invalidate();
        return;
    L10:
        Rect r14 = A(false);
        this.f17068m.remove(r12);
        if (((Rect) this.f17068m.get(getCurrentBottomView())) == null) goto L13;
        this.f17068m.remove(getCurrentBottomView());
    L13:
        int r15 = r14.left - r12.getLeft();
        int r16 = r14.top - r12.getTop();
        r12.layout(r14.left, r14.top, r14.right, r14.bottom);
        if (r11 == false) goto L16;
        C(r14.left, r14.top, r14.right, r14.bottom);
        D(r14.left, r14.top, r15, r16);
        goto L17
    L16:
        a0();
        goto L17
    }

    public final Rect y(DragEdge r10) {
        int r11 = getPaddingLeft();
        int r12 = getPaddingTop();
        DragEdge r13 = DragEdge.Right;
        if (r10 != r13) goto L6;
        r11 = getMeasuredWidth() - this.f17060e;
    L9:
        if (r10 == DragEdge.Left) goto L14;
        if (r10 == r13) goto L14;
        int r14 = getMeasuredWidth() + r11;
        int r15 = this.f17060e;
    L16:
        return new Rect(r11, r12, r14, r15 + r12);
    L14:
        r14 = this.f17060e + r11;
        r15 = getMeasuredHeight();
        goto L16
    L6:
        if (r10 != DragEdge.Bottom) goto L9;
        r12 = getMeasuredHeight() - this.f17060e;
        goto L9
    }

    public final Rect z(ShowMode r10, Rect r11) {
        View r12 = getCurrentBottomView();
        int r13 = r11.left;
        int r14 = r11.top;
        int r15 = r11.right;
        int r16 = r11.bottom;
        if (r10 != ShowMode.PullOut) goto L28;
        DragEdge r17 = this.f17057b;
        DragEdge r18 = DragEdge.Left;
        if (r17 != r18) goto L8;
        r13 = r13 - this.f17060e;
    L14:
        int r19 = 0;
        if (r17 != r18) goto L17;
    L23:
        if (r12 == null) goto L26;
        r19 = r12.getMeasuredWidth();
    L26:
        r15 = r13 + r19;
    L40:
        return new Rect(r13, r14, r15, r16);
    L17:
        if (r17 == DragEdge.Right) goto L23;
        if (r12 == null) goto L22;
        r19 = r12.getMeasuredHeight();
    L22:
        r16 = r14 + r19;
        r15 = r11.right;
        goto L40
    L8:
        if (r17 != DragEdge.Right) goto L11;
        r13 = r15;
        goto L14
    L11:
        if (r17 != DragEdge.Top) goto L13;
        r14 = r14 - this.f17060e;
        goto L14
    L13:
        r14 = r16;
        goto L14
    L28:
        if (r10 != ShowMode.LayDown) goto L40;
        DragEdge r20 = this.f17057b;
        if (r20 != DragEdge.Left) goto L33;
        r19 = this.f17060e;
        goto L26
    L33:
        if (r20 != DragEdge.Right) goto L36;
        r13 = r15 - this.f17060e;
        goto L40
    L36:
        if (r20 != DragEdge.Top) goto L38;
        r16 = r14 + this.f17060e;
        goto L40
    L38:
        r14 = r16 - this.f17060e;
        goto L40
    }

    public OSwipeLayout(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public OSwipeLayout(Context r11, AttributeSet r12, int r13) {
        super(r11, r12, r13);
        this.f17057b = L;
        this.f17060e = 0;
        this.f17061f = new LinkedHashMap();
        this.f17063h = new float[4];
        this.f17064i = new ArrayList();
        this.f17065j = new ArrayList();
        this.f17066k = new HashMap();
        this.f17067l = new HashMap();
        this.f17068m = new HashMap();
        this.f17070o = true;
        this.f17071p = new boolean[]{true, true, true, true};
        this.f17072q = false;
        this.f17073r = 0.75f;
        this.f17074s = 0.25f;
        this.f17075t = false;
        this.f17077v = 1.5f;
        this.f17078w = 2.0f;
        this.f17079x = -1;
        this.f17080y = false;
        this.f17081z = new a(this);
        this.A = 0;
        this.E = -1.0f;
        this.F = -1.0f;
        this.G = false;
        this.K = new GestureDetector(getContext(), new e(this));
        this.f17058c = androidx.customview.widget.b.p(this, this.f17081z);
        this.f17056a = ViewConfiguration.get(r11).getScaledTouchSlop();
        TypedArray r14 = r11.obtainStyledAttributes(r12, R$styleable.OSwipeLayout);
        int r15 = r14.getInt(R$styleable.OSwipeLayout_oui_drag_edge, 2);
        float[] r10 = this.f17063h;
        DragEdge r16 = DragEdge.Left;
        r10[r16.ordinal()] = r14.getDimension(R$styleable.OSwipeLayout_oui_leftEdgeSwipeOffset, 0.0f);
        float[] r17 = this.f17063h;
        DragEdge r18 = DragEdge.Right;
        r17[r18.ordinal()] = r14.getDimension(R$styleable.OSwipeLayout_oui_rightEdgeSwipeOffset, 0.0f);
        float[] r19 = this.f17063h;
        DragEdge r20 = DragEdge.Top;
        r19[r20.ordinal()] = r14.getDimension(R$styleable.OSwipeLayout_oui_topEdgeSwipeOffset, 0.0f);
        float[] r21 = this.f17063h;
        DragEdge r22 = DragEdge.Bottom;
        r21[r22.ordinal()] = r14.getDimension(R$styleable.OSwipeLayout_oui_bottomEdgeSwipeOffset, 0.0f);
        setClickToClose(r14.getBoolean(R$styleable.OSwipeLayout_oui_clickToClose, this.f17072q));
        if ((r15 & 1) != 1) goto L6;
        this.f17061f.put(r16, null);
    L6:
        if ((r15 & 4) != 4) goto L9;
        this.f17061f.put(r20, null);
    L9:
        if ((r15 & 2) != 2) goto L12;
        this.f17061f.put(r18, null);
    L12:
        if ((r15 & 8) != 8) goto L14;
        this.f17061f.put(r22, null);
    L14:
        int r110 = r14.getInt(R$styleable.OSwipeLayout_oui_show_mode, ShowMode.PullOut.ordinal());
        this.f17062g = ShowMode.values()[r110];
        r14.recycle();
    }

    @Deprecated
    public void setDragEdges(DragEdge... r10) {
        u();
        setDragEdges(Arrays.asList(r10));
    }
}
