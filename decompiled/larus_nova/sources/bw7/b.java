package bw7;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.h6ah4i.android.widget.advrecyclerview.animator.SwipeDismissItemAnimator;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemWrapperAdapter;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractSwipeableItemViewHolder;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.feed.shared.page.FeedRecyclerView;
import com.ss.android.lark.feed.shared.page.adapter.LarkFeedInBoxListAdapter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes23.dex */
public final class b {
    public h A;
    public c B;
    public HandlerC0369b C;
    public final int D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f21170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f21171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView f21172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f21173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f21174e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f21175f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f21176g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f21177h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f21178i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f21179j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f21180k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f21181l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f21182m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f21183n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f21184o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public bw7.a f21185p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public SwipeableItemWrapperAdapter<RecyclerView.ViewHolder> f21186q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public RecyclerView.ViewHolder f21187r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f21188s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f21189t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f21190u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f21191v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f21192w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f21193x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f21194y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public VelocityTracker f21195z;

    public class a implements RecyclerView.OnItemTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f21196a;

        public a(b r100) {
            this.f21196a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public final void onRequestDisallowInterceptTouchEvent(boolean r100) {
            b r101 = this.f21196a;
            if (r100 == false) goto L5;
            r101.d(true);
            return;
        L5:
            r101.getClass();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public final boolean onInterceptTouchEvent(RecyclerView r110, MotionEvent r111) {
            b r100 = this.f21196a;
            r100.getClass();
            int r101 = r111.getActionMasked();
            long r102 = -1;
            if (r101 == 0) goto L61;
            if (r101 == 1) goto L58;
            if (r101 == 2) goto L11;
            if (r101 == 3) goto L58;
            return false;
        L11:
            if (r100.k() == false) goto L14;
            r100.h(r111);
        L59:
            return true;
        L14:
            if (r100.f21183n == (-1)) goto L54;
            int r103 = ((int) (r111.getX() + 0.5f)) - r100.f21181l;
            int r112 = ((int) (r111.getY() + 0.5f)) - r100.f21182m;
            if (r100.f21184o == false) goto L20;
            r112 = r103;
            r103 = r112;
        L20:
            if (Math.abs(r103) <= r100.f21177h) goto L23;
            r100.f21183n = -1;
            goto L54
        L23:
            if (Math.abs(r112) <= r100.f21177h) goto L54;
            if (Math.abs(r103) <= Math.abs(r112 * 2)) goto L29;
            r100.f21183n = -1;
            goto L54
        L29:
            if (r100.f21184o == false) goto L37;
            if (r112 >= 0) goto L35;
            if ((r100.f21194y & 8) != 0) goto L43;
        L44:
            boolean r104 = false;
        L45:
            if (r104 == false) goto L47;
            r100.f21183n = -1;
            goto L54
        L47:
            RecyclerView.ViewHolder r105 = dw7.a.a(r110, r111.getX(), r111.getY());
            if (r105 != null) goto L50;
        L53:
            r100.f21183n = -1;
            goto L54
        L50:
            if (r105.getItemId() != r100.f21183n) goto L53;
            boolean r106 = r100.e(r111, r105);
        L55:
            if (r106 == true) goto L59;
            return false;
        L43:
            r104 = true;
            goto L45
        L35:
            if ((r100.f21194y & 32768) == 0) goto L44;
        L37:
            if (r112 >= 0) goto L42;
            if ((r100.f21194y & 512) == 0) goto L44;
        L42:
            if ((r100.f21194y & 2097152) == 0) goto L44;
        L54:
            r106 = false;
        L58:
            if (r100.i(r111, true) == true) goto L59;
            return false;
        L61:
            if (r100.k() == true) goto L98;
            RecyclerView.ViewHolder r107 = dw7.a.a(r110, r111.getX(), r111.getY());
            if ((r107 instanceof f) == false) goto L102;
            SwipeableItemWrapperAdapter<RecyclerView.ViewHolder> r108 = r100.f21186q;
            if (r108 == null) goto L68;
            r108.f276049f = (f) r107;
        L68:
            RecyclerView.Adapter r109 = r100.f21172c.getAdapter();
            int r113 = r107.getLayoutPosition();
            if (r113 == r107.getAdapterPosition()) goto L72;
            r113 = -1;
        L72:
            int r114 = dw7.c.b(r109, r100.f21186q, r113);
            if (r114 >= 0) goto L75;
            return false;
        L75:
            if (r114 >= r100.f21186q.getItemCount()) goto L103;
            long r115 = r100.f21186q.getItemId(r114);
            if (r115 != (-1)) goto L80;
            long r116 = -1;
        L81:
            long r117 = r107.getItemId();
            if (r117 == (-1)) goto L86;
            r102 = (r117 << 8) >> 8;
        L86:
            if (r102 != r116) goto L104;
            int r118 = (int) (r111.getX() + 0.5f);
            int r119 = (int) (r111.getY() + 0.5f);
            View r120 = r107.itemView;
            int r121 = (int) (r120.getTranslationX() + 0.5f);
            int r122 = (int) (r120.getTranslationY() + 0.5f);
            int r123 = r100.f21186q.f276046c.Q1(r107, r114, r118 - (r120.getLeft() + r121), r119 - (r120.getTop() + r122));
            if (r123 == 0) goto L105;
            r100.f21181l = r118;
            r100.f21182m = r119;
            r100.f21183n = r107.getItemId();
            r100.f21194y = r123;
            if ((16777216 & r123) == 0) goto L100;
            HandlerC0369b r124 = r100.C;
            int r125 = r100.D;
            r124.a();
            r124.f21198b = MotionEvent.obtain(r111);
            r124.sendEmptyMessageAtTime(1, r111.getDownTime() + ((long) r125));
            return false;
        L100:
            return false;
        L105:
            return false;
        L104:
            return false;
        L80:
            r116 = (r115 << 8) >> 8;
            goto L81
        L103:
            return false;
        L102:
            return false;
        L98:
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public final void onTouchEvent(RecyclerView r100, MotionEvent r101) {
            b r102 = this.f21196a;
            r102.getClass();
            int r103 = r101.getActionMasked();
            if (r102.k() == true) goto L6;
            return;
        L6:
            if (r103 != 1) goto L8;
        L13:
            r102.i(r101, true);
            return;
        L8:
            if (r103 != 2) goto L10;
            r102.h(r101);
            return;
        L10:
            if (r103 == 3) goto L13;
        }
    }

    /* JADX INFO: renamed from: bw7.b$b, reason: collision with other inner class name */
    public static class HandlerC0369b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f21197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MotionEvent f21198b;

        public final void a() {
            removeMessages(1);
            MotionEvent r100 = this.f21198b;
            if (r100 == null) goto L6;
            r100.recycle();
            this.f21198b = null;
            return;
        }

        public HandlerC0369b(b r100) {
            this.f21197a = r100;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            int r101 = r100.what;
            if (r101 != 1) goto L5;
            b r102 = this.f21197a;
            MotionEvent r103 = this.f21198b;
            RecyclerView.ViewHolder r104 = r102.f21172c.findViewHolderForItemId(r102.f21183n);
            if (r104 == null) goto L13;
            r102.e(r103, r104);
            return;
        L13:
            return;
        L5:
            if (r101 != 2) goto L14;
            this.f21197a.d(true);
            return;
        }
    }

    public interface c {
        void a();

        void b(int r100);
    }

    public static boolean j(float r100) {
        if (r100 != (-65536.0f)) goto L5;
    L12:
        return true;
    L5:
        if (r100 == 65536.0f) goto L12;
        if (r100 == (-65537.0f)) goto L12;
        if (r100 == 65537.0f) goto L12;
        return false;
    }

    public final void l() {
        d(true);
        HandlerC0369b r100 = this.C;
        if (r100 == null) goto L5;
        r100.removeCallbacksAndMessages(null);
        r100.f21197a = null;
        this.C = null;
    L5:
        RecyclerView r101 = this.f21172c;
        if (r101 == null) goto L10;
        a r102 = this.f21171b;
        if (r102 == null) goto L10;
        r101.removeOnItemTouchListener(r102);
    L10:
        this.f21171b = null;
        VelocityTracker r103 = this.f21195z;
        if (r103 == null) goto L13;
        r103.recycle();
        this.f21195z = null;
    L13:
        bw7.a r104 = this.f21185p;
        if (r104 == null) goto L20;
        int r105 = ((ArrayList) r104.f21153e).size();
    L16:
        r105 = r105 - 1;
        if (r105 < 0) goto L19;
        r104.c((RecyclerView.ViewHolder) ListProtector.get(r104.f21153e, r105));
        goto L16
    L19:
        this.f21185p = null;
    L20:
        this.f21186q = null;
        this.f21172c = null;
    }

    public final boolean k() {
        if (this.f21187r != null) goto L5;
    L7:
        return false;
    L5:
        if (this.C.hasMessages(2) == true) goto L7;
        return true;
    }

    public b() {
        this.f21170a = new Rect();
        this.f21173d = 300;
        this.f21174e = 200;
        this.f21175f = 200;
        this.f21176g = 300;
        this.f21183n = -1;
        this.f21188s = -1;
        this.f21189t = -1;
        this.f21171b = new a(this);
        this.f21195z = VelocityTracker.obtain();
        this.D = ViewConfiguration.getLongPressTimeout();
    }

    public final void c(FeedRecyclerView r100) {
        boolean r101 = false;
        if (this.f21171b != null) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L30;
        if (this.f21172c != null) goto L28;
        RecyclerView.LayoutManager r103 = r100.getLayoutManager();
        if ((r103 instanceof GridLayoutManager) == false) goto L13;
        int r104 = ((GridLayoutManager) r103).getOrientation();
    L19:
        if (r104 == (-1)) goto L26;
        this.f21172c = r100;
        r100.addOnItemTouchListener(this.f21171b);
        ViewConfiguration r105 = ViewConfiguration.get(r100.getContext());
        this.f21177h = r105.getScaledTouchSlop();
        this.f21178i = r105.getScaledMinimumFlingVelocity();
        this.f21179j = r105.getScaledMaximumFlingVelocity();
        this.f21180k = this.f21177h * 5;
        this.f21185p = new bw7.a(this.f21186q);
        Resources r106 = r100.getResources();
        float r107 = WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()).density;
        if (r104 != 1) goto L23;
        r101 = true;
    L23:
        this.f21184o = r101;
        this.C = new HandlerC0369b(this);
        return;
    L26:
        throw new IllegalStateException("failed to determine layout orientation");
    L13:
        if ((r103 instanceof LinearLayoutManager) == false) goto L16;
        r104 = ((LinearLayoutManager) r103).getOrientation();
        goto L19
    L16:
        if ((r103 instanceof StaggeredGridLayoutManager) == false) goto L18;
        r104 = ((StaggeredGridLayoutManager) r103).getOrientation();
        goto L19
    L18:
        r104 = -1;
        goto L19
    L28:
        throw new IllegalStateException("RecyclerView instance has already been set");
    L30:
        throw new IllegalStateException("Accessing released object");
    L5:
        r102 = false;
        goto L6
    }

    public final void d(boolean r100) {
        i(null, false);
        if (r100 == false) goto L6;
        g(1);
        return;
    L6:
        if (k() == false) goto L13;
        HandlerC0369b r101 = this.C;
        if (r101.hasMessages(2) == true) goto L14;
        r101.sendEmptyMessage(2);
        return;
    L14:
        return;
    }

    public final SwipeableItemWrapperAdapter f(LarkFeedInBoxListAdapter r100) {
        if (r100.hasStableIds() == false) goto L11;
        if (this.f21186q != null) goto L9;
        SwipeableItemWrapperAdapter<RecyclerView.ViewHolder> r101 = new SwipeableItemWrapperAdapter(this, r100);
        this.f21186q = r101;
        return r101;
    L9:
        throw new IllegalStateException("already have a wrapped adapter");
    L11:
        throw new IllegalArgumentException("The passed adapter does not support stable IDs");
    }

    public final void g(int r210) {
        RecyclerView.ViewHolder r100 = this.f21187r;
        if (r100 != null) goto L5;
        return;
    L5:
        this.C.removeMessages(2);
        this.C.a();
        RecyclerView r101 = this.f21172c;
        boolean r110 = false;
        if (r101 != null) goto L8;
    L10:
        int r102 = this.f21188s;
        this.f21195z.clear();
        cw7.a r103 = null;
        this.f21187r = null;
        this.f21188s = -1;
        this.f21189t = -1;
        this.f21192w = 0;
        this.f21193x = 0;
        this.f21181l = 0;
        this.f21190u = 0;
        this.f21191v = 0;
        this.f21183n = -1;
        this.f21194y = 0;
        h r104 = this.A;
        if (r104 == null) goto L14;
        r104.f21217c = null;
        r104.f21218d = null;
        r104.f21227m = 0;
        r104.f21228n = 0;
        r104.f21224j = 0;
        r104.f21225k = 0.0f;
        r104.f21226l = 0.0f;
        r104.f21220f = 0;
        r104.f21221g = 0;
        r104.f21222h = 0;
        r104.f21223i = 0;
        r104.f21229o = 0.0f;
        r104.f21230p = 0;
        r104.f21231q = 0;
        r104.f21219e = null;
        this.A = null;
    L14:
        if (r210 == 3) goto L20;
        if (r210 == 4) goto L19;
        if (r210 == 5) goto L18;
        int r111 = 0;
    L21:
        SwipeableItemWrapperAdapter<RecyclerView.ViewHolder> r112 = this.f21186q;
        if (r112 == null) goto L24;
        r112.f276048e = -1;
        r103 = r112.f276046c.q2(r100, r102, r210);
    L24:
        if (r103 != null) goto L26;
        r103 = new cw7.b();
    L26:
        cw7.a r105 = r103;
        int r106 = r105.f465622a;
        if (r106 == 2) goto L29;
        if (r106 == 1) goto L29;
    L36:
        if (r106 == 0) goto L66;
        if (r106 == 1) goto L58;
        if (r106 == 2) goto L56;
        if (r106 == 3) goto L55;
        if (r106 == 4) goto L49;
        if (r106 != 5) goto L48;
        bw7.a r113 = this.f21185p;
        boolean r107 = this.f21184o;
        long r114 = this.f21176g;
        r113.b(r100);
        if ((r100 instanceof AbstractSwipeableItemViewHolder) == false) goto L45;
        float r108 = ((AbstractSwipeableItemViewHolder) r100).f276062i;
    L46:
        r110 = r113.f(r100, r108, true, r107, true, r113.f21150b, r114, new bw7.a.c(r105));
        goto L55
    L45:
        r108 = 0.0f;
        goto L46
    L48:
        throw new IllegalStateException("Unknown after reaction type: " + r106);
    L49:
        bw7.a r115 = this.f21185p;
        boolean r116 = this.f21184o;
        long r109 = this.f21176g;
        r115.b(r100);
        if ((r100 instanceof AbstractSwipeableItemViewHolder) == false) goto L52;
        float r117 = ((AbstractSwipeableItemViewHolder) r100).f276060g;
    L53:
        r110 = r115.f(r100, r117, true, r116, true, r115.f21150b, r109, new bw7.a.c(r105));
        goto L55
    L52:
        r117 = 0.0f;
    L55:
        cw7.a r211 = r105;
        Object r118 = r100;
        int r119 = 3;
        int r120 = r106;
    L67:
        SwipeableItemWrapperAdapter<RecyclerView.ViewHolder> r121 = this.f21186q;
        if (r121 == null) goto L95;
        f r122 = (f) r118;
        r122.j3(r210);
        r122.o3(r120);
        if (r120 != r119) goto L72;
    L94:
        r211.b();
        r121.notifyDataSetChanged();
        goto L95
    L72:
        if (r120 == 1) goto L79;
        int r123 = 2;
        int r124 = 4;
        if (r120 == 2) goto L80;
        if (r120 != 4) goto L85;
        if (r210 != 2) goto L85;
    L89:
        float r125 = -65536.0f;
    L91:
        if (r121.f276047d.f21184o == false) goto L93;
        r122.z0(r125);
        goto L94
    L93:
        r122.r3(r125);
    L85:
        r125 = 0.0f;
    L80:
        if (r210 == r123) goto L89;
        if (r210 == r119) goto L88;
        if (r210 != r124) goto L84;
        r125 = 65536.0f;
        goto L91
    L84:
        if (r210 != 5) goto L85;
        r125 = 65537.0f;
        goto L91
    L88:
        r125 = -65537.0f;
        goto L91
    L79:
        r123 = 2;
        r124 = 4;
    L95:
        c r126 = this.B;
        if (r126 == null) goto L98;
        r126.b(r120);
    L98:
        if (r110 == true) goto L101;
        r211.c();
        r211.a();
        return;
    L101:
        return;
    L56:
        bw7.a r127 = this.f21185p;
        long r128 = this.f21175f;
        r127.b(r100);
        r110 = r127.e(r100, r111, true, r128, new bw7.a.c(r105));
        r118 = r100;
        r211 = r105;
        r120 = r106;
    L57:
        r119 = 3;
        goto L67
    L58:
        RecyclerView.ItemAnimator r129 = this.f21172c.getItemAnimator();
        if (r129 == null) goto L61;
        long r130 = r129.getRemoveDuration();
    L62:
        if (r129 == null) goto L64;
        long r131 = r129.getMoveDuration();
    L65:
        bw7.c r132 = new bw7.c(this.f21172c, r100, r210, r130, r131);
        r132.f21209k = SwipeDismissItemAnimator.f276020e;
        ViewCompat.animate(g.a(r132.f21205g)).cancel();
        r132.f21204f.addItemDecoration(r132);
        r132.f21208j = System.currentTimeMillis();
        r132.f21207i = (int) (r132.f21205g.itemView.getTranslationY() + 0.5f);
        r132.f21210l = r132.f21205g.itemView.getBackground();
        ViewCompat.postInvalidateOnAnimation(r132.f21204f);
        r132.h(0, r132.f21201c);
        bw7.a r133 = this.f21185p;
        r133.b(r100);
        r110 = r133.e(r100, r111, true, r130, new bw7.a.c(r105));
        r211 = r105;
        r120 = r106;
        r118 = r100;
        goto L57
    L64:
        r131 = 0;
        goto L65
    L61:
        r130 = 0;
        goto L62
    L66:
        bw7.a r134 = this.f21185p;
        boolean r135 = this.f21184o;
        long r136 = this.f21173d;
        r134.b(r100);
        Interpolator r137 = r134.f21150b;
        bw7.a.c r138 = new bw7.a.c(r105);
        r211 = r105;
        r120 = r106;
        r118 = r100;
        r119 = 3;
        r110 = r134.f(r100, 0.0f, false, r135, true, r137, r136, r138);
    L29:
        if (r210 == 2) goto L36;
        if (r210 == 3) goto L36;
        if (r210 == 4) goto L36;
        if (r210 == 5) goto L36;
        throw new IllegalStateException("Unexpected after reaction has been requested: result = " + r210 + ", afterReaction = " + r106);
    L18:
        r111 = 3;
        goto L21
    L19:
        r111 = 2;
        goto L21
    L20:
        r111 = 1;
        goto L21
    L8:
        if (r101.getParent() == null) goto L10;
        this.f21172c.getParent().requestDisallowInterceptTouchEvent(false);
        goto L10
    }

    public final void h(MotionEvent r100) {
        this.f21192w = (int) (r100.getX() + 0.5f);
        this.f21193x = (int) (r100.getY() + 0.5f);
        this.f21195z.addMovement(r100);
        int r101 = this.f21192w - this.f21190u;
        int r102 = this.f21193x - this.f21191v;
        int r103 = this.f21188s;
        this.A.update(r103, r101, r102);
    }

    public final int m(int r100) {
        SwipeableItemWrapperAdapter<RecyclerView.ViewHolder> r101 = this.f21186q;
        long r102 = this.f21189t;
        if (r101 != null) goto L5;
    L4:
        r100 = -1;
    L17:
        this.f21188s = r100;
        return r100;
    L5:
        int r103 = r101.getItemCount();
        if (r100 < 0) goto L11;
        if (r100 >= r103) goto L11;
        if (r101.getItemId(r100) == r102) goto L17;
    L11:
        r100 = 0;
    L12:
        if (r100 >= r103) goto L4;
        if (r101.getItemId(r100) == r102) goto L17;
        r100 = r100 + 1;
        goto L12
    }

    public final boolean e(MotionEvent r100, RecyclerView.ViewHolder r110) {
        RecyclerView.Adapter r101 = this.f21172c.getAdapter();
        int r102 = r110.getLayoutPosition();
        if (r102 == r110.getAdapterPosition()) goto L6;
        r102 = -1;
    L6:
        int r103 = dw7.c.b(r101, this.f21186q, r102);
        if (r103 != (-1)) goto L9;
        return false;
    L9:
        this.C.a();
        this.f21187r = r110;
        this.f21188s = r103;
        this.f21189t = this.f21186q.getItemId(r103);
        this.f21192w = (int) (r100.getX() + 0.5f);
        int r104 = (int) (r100.getY() + 0.5f);
        this.f21193x = r104;
        this.f21190u = this.f21192w;
        this.f21191v = r104;
        this.f21183n = -1;
        View r105 = r110.itemView;
        Rect r106 = this.f21170a;
        ViewGroup.LayoutParams r107 = r105.getLayoutParams();
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r107;
        r106.left = r108.leftMargin;
        r106.right = r108.rightMargin;
        r106.top = r108.topMargin;
        r106.bottom = r108.bottomMargin;
    L13:
        h r109 = new h(this, this.f21187r, this.f21194y, this.f21184o);
        this.A = r109;
        Resources r111 = r109.f21218d.itemView.getResources();
        float r112 = WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics()).density;
        int r113 = (int) (r112 * 48.0f);
        int r114 = Math.max(0, r109.f21224j - r113);
        int r115 = Math.max(0, r109.f21215a - r113);
        b r116 = r109.f21217c;
        RecyclerView.ViewHolder r117 = r109.f21218d;
        r116.f21185p.getClass();
        r109.f21230p = Math.min(Math.max((int) (g.a(r117).getTranslationX() + 0.5f), -r114), r114);
        b r118 = r109.f21217c;
        RecyclerView.ViewHolder r119 = r109.f21218d;
        r118.f21185p.getClass();
        r109.f21231q = Math.min(Math.max((int) (g.a(r119).getTranslationY() + 0.5f), -r115), r115);
        this.f21195z.clear();
        this.f21195z.addMovement(r100);
        this.f21172c.getParent().requestDisallowInterceptTouchEvent(true);
        c r120 = this.B;
        if (r120 == null) goto L16;
        r120.a();
    L16:
        SwipeableItemWrapperAdapter<RecyclerView.ViewHolder> r121 = this.f21186q;
        r121.f276048e = this.f21189t;
        r121.f276050g = true;
        r121.f276046c.H(r110, r103);
        r121.f276050g = false;
        return true;
    L12:
        r106.bottom = 0;
        r106.top = 0;
        r106.right = 0;
        r106.left = 0;
        goto L13
    }

    public final boolean i(MotionEvent r110, boolean r111) {
        int r100 = 3;
        if (r110 == null) goto L5;
        int r101 = r110.getActionMasked();
        this.f21192w = (int) (r110.getX() + 0.5f);
        this.f21193x = (int) (r110.getY() + 0.5f);
    L6:
        boolean r102 = false;
        if (k() == true) goto L9;
        HandlerC0369b r112 = this.C;
        if (r112 == null) goto L89;
        r112.a();
    L89:
        this.f21183n = -1;
        this.f21194y = 0;
        return false;
    L9:
        if (r111 == false) goto L85;
        if (r101 != 1) goto L83;
        float r113 = this.f21178i;
        boolean r103 = this.f21184o;
        f r104 = (f) this.f21187r;
        View r105 = g.b(r104);
        if (r103 == false) goto L14;
        int r106 = r105.getWidth();
    L15:
        if (r103 == false) goto L17;
        int r107 = this.f21192w;
        int r108 = this.f21181l;
    L18:
        float r109 = r107 - r108;
        float r114 = Math.abs(r109);
        if (r103 == false) goto L24;
        if (((this.f21194y >>> 0) & 3) == 2) goto L25;
    L26:
        boolean r115 = false;
    L27:
        if (r103 == false) goto L32;
        if (((this.f21194y >>> 12) & 3) == 2) goto L33;
    L34:
        boolean r116 = false;
    L35:
        boolean r117 = r104.G0();
        if (r103 == false) goto L38;
        float r118 = r104.h0();
    L39:
        if (r103 == false) goto L41;
        float r119 = r104.G2();
    L42:
        float r120 = a(r104, r103, r118, r117, false);
        float r121 = a(r104, r103, r119, r117, false);
        if (j(r120) == false) goto L46;
        r120 = -r106;
    L46:
        if (j(r121) == false) goto L48;
        r121 = r106;
    L48:
        this.f21195z.computeCurrentVelocity(1000, this.f21179j);
        VelocityTracker r122 = this.f21195z;
        if (r103 == false) goto L51;
        float r123 = r122.getXVelocity();
    L52:
        float r124 = Math.abs(r123);
        if (r114 > this.f21180k) goto L55;
    L72:
        boolean r125 = false;
    L73:
        if (r102 == false) goto L83;
        if (r125 == true) goto L78;
        if (r115 == false) goto L78;
        if (r103 == false) goto L84;
        r100 = 2;
    L84:
        g(r100);
    L78:
        if (r125 == false) goto L83;
        if (r116 == false) goto L83;
        if (r103 == false) goto L82;
        r100 = 4;
        goto L84
    L82:
        r100 = 5;
        goto L84
    L55:
        if (r124 < r113) goto L62;
        if ((r109 * r123) < 0.0f) goto L72;
        if (r123 > 0.0f) goto L70;
    L71:
        r125 = r102;
        r102 = true;
    L70:
        r102 = true;
        goto L71
    L62:
        if (r109 >= 0.0f) goto L67;
        if (r109 <= (r120 * 0.216f)) goto L71;
    L67:
        if (r109 <= 0.0f) goto L72;
        if (r109 < (r121 * 0.216f)) goto L72;
    L51:
        r123 = r122.getYVelocity();
        goto L52
    L41:
        r119 = r104.j2();
        goto L42
    L38:
        r118 = r104.I1();
    L33:
        r116 = true;
        goto L35
    L32:
        if (((this.f21194y >>> 18) & 3) != 2) goto L34;
    L25:
        r115 = true;
        goto L27
    L24:
        if (((this.f21194y >>> 6) & 3) != 2) goto L26;
    L17:
        r107 = this.f21193x;
        r108 = this.f21182m;
        goto L18
    L14:
        r106 = r105.getHeight();
    L83:
        r100 = 1;
    L85:
        return true;
    L5:
        r101 = 3;
        goto L6
    }

    public static float a(f r100, boolean r101, float r102, boolean r103, boolean r104) {
        if ((r103 ^ r104) == false) goto L20;
        float r105 = 0.0f;
        if (r102 != 0.0f) goto L7;
        return r102;
    L7:
        if (j(r102) == true) goto L22;
        View r106 = g.b(r100);
        if (r101 == false) goto L11;
        int r107 = r106.getWidth();
    L12:
        float r108 = r107;
        if (r104 == false) goto L19;
        if (r108 == 0.0f) goto L17;
        r105 = 1.0f / r108;
    L17:
        r108 = r105;
    L19:
        return r102 * r108;
    L11:
        r107 = r106.getHeight();
        goto L12
    L22:
        return r102;
    L20:
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(RecyclerView.ViewHolder r110, int r111, float r112, float r113, boolean r114, boolean r115, boolean r210) {
        float r100 = r113;
        f r101 = (f) r110;
        if (g.b(r101) != null) goto L5;
        return;
    L5:
        int r102 = 1;
        int r103 = 2;
        if (r100 == 0.0f) goto L8;
        if (r115 == false) goto L25;
        if (r100 < 0.0f) goto L27;
    L14:
        r102 = 3;
    L27:
        int r116 = r102;
    L28:
        if (r100 == 0.0f) goto L37;
        boolean r104 = r101.G0();
        if (r115 == false) goto L32;
        float r105 = r101.h0();
    L33:
        if (r115 == false) goto L35;
        float r106 = r101.G2();
    L36:
        float r107 = a(r101, r115, r105, r104, r114);
        float r108 = a(r101, r115, r106, r104, r114);
        r100 = Math.min(Math.max(r100, r107), r108);
        goto L37
    L35:
        r106 = r101.j2();
        goto L36
    L32:
        r105 = r101.I1();
    L37:
        float r109 = r100;
        if (r109 != (-65536.0f)) goto L41;
        this.f21185p.d(r110, 0, r210, this.f21175f);
    L53:
        this.f21186q.f276046c.b0(r110, r111, r116);
        return;
    L41:
        if (r109 != (-65537.0f)) goto L44;
        this.f21185p.d(r110, 1, r210, this.f21175f);
        goto L53
    L44:
        if (r109 != 65536.0f) goto L47;
        this.f21185p.d(r110, 2, r210, this.f21175f);
        goto L53
    L47:
        if (r109 != 65537.0f) goto L50;
        this.f21185p.d(r110, 3, r210, this.f21175f);
        goto L53
    L50:
        if (r109 != 0.0f) goto L52;
        bw7.a r117 = this.f21185p;
        long r118 = this.f21173d;
        r117.b(r110);
        r117.f(r110, 0.0f, false, r115, r210, r117.f21150b, r118, null);
        goto L53
    L52:
        bw7.a r119 = this.f21185p;
        long r120 = this.f21174e;
        r119.b(r110);
        r119.f(r110, r109, r114, r115, r210, r119.f21151c, r120, null);
        goto L53
    L25:
        if (r100 < 0.0f) goto L19;
    L18:
        r103 = 4;
    L19:
        r102 = r103;
        goto L27
    L8:
        if (r112 != 0.0f) goto L10;
        r116 = 0;
        goto L28
    L10:
        if (r115 == false) goto L16;
        if (r112 >= 0.0f) goto L14;
    L16:
        if (r112 >= 0.0f) goto L18;
        goto L18
    }
}
