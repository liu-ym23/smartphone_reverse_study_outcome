package ab;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends k {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final C0001a f75j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f76f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecyclerView f77g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f78h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public OrientationHelper f79i;

    /* JADX INFO: renamed from: ab.a$a, reason: collision with other inner class name */
    public static final class C0001a {
        public /* synthetic */ C0001a(DefaultConstructorMarker r10) {
            this();
        }

        public C0001a() {
        }
    }

    static {
        f75j = new C0001a(null);
    }

    public a(int r10) {
        this.f76f = r10;
        this.f78h = 8388611;
    }

    private final OrientationHelper o(RecyclerView.LayoutManager r10) {
        OrientationHelper r11 = this.f79i;
        if (r11 == null) goto L5;
        return r11;
    L5:
        if (r10.canScrollVertically() == false) goto L7;
        OrientationHelper r12 = OrientationHelper.c(r10);
        this.f79i = r12;
        q.d(r12);
        return r12;
    L7:
        OrientationHelper r13 = OrientationHelper.a(r10);
        this.f79i = r13;
        q.d(r13);
        return r13;
    }

    private final boolean q(RecyclerView.LayoutManager r10, int r11, int r12) {
        if (r10.canScrollHorizontally() == false) goto L6;
        if (r11 > 0) goto L9;
        return false;
    L9:
        return true;
    L6:
        if (r12 > 0) goto L9;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean r(RecyclerView.LayoutManager r10) {
        int r11 = r10.getItemCount();
        if ((r10 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == false) goto L12;
        PointF r12 = ((RecyclerView.SmoothScroller.ScrollVectorProvider) r10).computeScrollVectorForPosition(r11 - 1);
        if (r12 != null) goto L7;
        return false;
    L7:
        if (r12.x < 0.0f) goto L11;
        if (r12.y < 0.0f) goto L11;
        return false;
    L11:
        return true;
    L12:
        return false;
    }

    private final View s(RecyclerView.LayoutManager r10) {
        View r11 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        int r12 = r10.getChildCount();
        if (r12 != 0) goto L8;
        return null;
    L8:
        OrientationHelper r13 = o(r10);
        if ((r10 instanceof LinearLayoutManager) == false) goto L33;
        LinearLayoutManager r14 = (LinearLayoutManager) r10;
        if (u(r14) == false) goto L14;
        return null;
    L14:
        if (r14.getClipToPadding() == false) goto L16;
        int r15 = r13.n() + (r13.o() / 2);
    L17:
        int r16 = Channel.UNLIMITED;
        int r17 = 0;
    L18:
        if (r17 >= r12) goto L33;
        View r18 = r14.getChildAt(r17);
        int r19 = this.f78h;
        if (r19 != 48) goto L22;
    L29:
        int r20 = Math.abs(r13.g(r18));
    L30:
        if (r20 >= r16) goto L32;
        r11 = r18;
        r16 = r20;
    L32:
        r17 = r17 + 1;
        goto L18
    L22:
        if (r19 != 80) goto L24;
    L28:
        r20 = Math.abs(r13.d(r18) - r13.h());
        goto L30
    L24:
        if (r19 == 8388611) goto L29;
        if (r19 == 8388613) goto L28;
        r20 = Math.abs((r13.g(r18) + (r13.e(r18) / 2)) - r15);
        goto L30
    L16:
        r15 = r13.h() / 2;
    L33:
        return r11;
    }

    private final int t(View r10, RecyclerView.LayoutManager r11) {
        OrientationHelper r12 = o(r11);
        int r13 = this.f78h;
        if (r13 != 17) goto L7;
        return (r12.g(r10) + (r12.e(r10) / 2)) - (r12.n() + (r12.o() / 2));
    L7:
        if (r13 != 8388611) goto L9;
    L16:
        int r14 = r12.g(r10);
        if (r14 < (r12.n() / 2)) goto L20;
        int r15 = r12.n();
    L19:
        return r14 - r15;
    L20:
        return r14;
    L9:
        if (r13 == 48) goto L16;
        r14 = r12.d(r10);
        if (r14 < (r12.h() - ((r12.h() - r12.i()) / 2))) goto L15;
        r14 = r12.d(r10);
        r15 = r12.h();
        goto L19
    L15:
        r15 = r12.i();
        goto L19
    }

    private final boolean u(LinearLayoutManager r10) {
        if (r10.getReverseLayout() == false) goto L5;
    L7:
        boolean r11 = false;
    L9:
        if (r10.getReverseLayout() == false) goto L11;
    L13:
        boolean r12 = false;
    L14:
        boolean r13 = r11 | r12;
        if (r10.getReverseLayout() == true) goto L17;
    L19:
        boolean r14 = false;
    L20:
        boolean r15 = r13 | r14;
        if (r10.getReverseLayout() == true) goto L23;
    L25:
        boolean r16 = false;
    L27:
        if ((r15 | r16) == false) goto L33;
        if (r10.findLastCompletelyVisibleItemPosition() == (r10.getItemCount() - 1)) goto L31;
        return false;
    L31:
        return true;
    L33:
        if (this.f78h != 17) goto L41;
        if (r10.findFirstCompletelyVisibleItemPosition() == 0) goto L39;
        if (r10.findLastCompletelyVisibleItemPosition() == (r10.getItemCount() - 1)) goto L39;
        return false;
    L39:
        return true;
    L41:
        if (r10.findFirstCompletelyVisibleItemPosition() == 0) goto L43;
        return false;
    L43:
        return true;
    L23:
        if (this.f78h != 8388613) goto L25;
        r16 = true;
        goto L27
    L17:
        if (this.f78h != 80) goto L19;
        r14 = true;
        goto L20
    L11:
        if (this.f78h != 48) goto L13;
        r12 = true;
        goto L14
    L5:
        if (this.f78h != 8388611) goto L7;
        r11 = true;
        goto L9
    }

    @Override // androidx.recyclerview.widget.n
    public void b(RecyclerView r10) {
        if (r10 == null) goto L5;
        r10.setOnFlingListener(null);
    L5:
        this.f77g = r10;
        super.b(r10);
    }

    @Override // androidx.recyclerview.widget.k, androidx.recyclerview.widget.n
    public int[] c(RecyclerView.LayoutManager r10, View r11) {
        q.g(r10, "layoutManager");
        q.g(r11, "targetView");
        if (this.f78h == 17) goto L5;
        int[] r12 = new int[2];
        if ((r10 instanceof LinearLayoutManager) == true) goto L9;
    L14:
        return r12;
    L9:
        if (r10.canScrollHorizontally() == false) goto L12;
        r12[0] = t(r11, r10);
        goto L14
    L12:
        if (r10.canScrollVertically() == false) goto L14;
        r12[1] = t(r11, r10);
        goto L14
    L5:
        return super.c(r10, r11);
    }

    @Override // androidx.recyclerview.widget.k, androidx.recyclerview.widget.n
    public View g(RecyclerView.LayoutManager r10) {
        q.g(r10, "layoutManager");
        return s(r10);
    }

    @Override // androidx.recyclerview.widget.k, androidx.recyclerview.widget.n
    public int h(RecyclerView.LayoutManager r13, int r14, int r15) {
        if (r13 != null) goto L5;
        return -1;
    L5:
        int r10 = r13.getItemCount();
        if (r10 != 0) goto L8;
        return -1;
    L8:
        o(r13);
        int r11 = 1;
        int r12 = this.f76f - 1;
        if ((r13 instanceof GridLayoutManager) == false) goto L11;
        r12 = r12 * ((GridLayoutManager) r13).I();
    L11:
        int r16 = r13.getChildCount();
        View r17 = null;
        int r18 = 0;
        int r19 = Integer.MAX_VALUE;
        int r20 = Integer.MIN_VALUE;
        View r21 = null;
    L12:
        if (r18 >= r16) goto L24;
        View r110 = r13.getChildAt(r18);
        if (r110 == null) goto L23;
        int r111 = t(r110, r13);
        if (r111 > 0) goto L20;
        if (r111 <= r20) goto L20;
        r21 = r110;
        r20 = r111;
    L20:
        if (r111 < 0) goto L23;
        if (r111 >= r19) goto L23;
        r17 = r110;
        r19 = r111;
    L23:
        r18 = r18 + 1;
        goto L12
    L24:
        boolean r112 = q(r13, r14, r15);
        if (r112 == false) goto L33;
        if (r17 == null) goto L33;
        if (r14 <= 4000) goto L32;
        return r13.getPosition(r17) + r12;
    L32:
        return r13.getPosition(r17);
    L33:
        if (r112 == true) goto L41;
        if (r21 == null) goto L41;
        if (r14 >= (-4000)) goto L40;
        return r13.getPosition(r21) - r12;
    L40:
        return r13.getPosition(r21);
    L41:
        if (r112 == false) goto L43;
        r17 = r21;
    L43:
        if (r17 != null) goto L45;
        return -1;
    L45:
        int r113 = r13.getPosition(r17);
        if (r(r13) != r112) goto L48;
        r11 = -1;
    L48:
        int r114 = r113 + r11;
        if (r114 < 0) goto L59;
        if (r114 < r10) goto L53;
        return -1;
    L53:
        return r114;
    L59:
        return -1;
    }
}
