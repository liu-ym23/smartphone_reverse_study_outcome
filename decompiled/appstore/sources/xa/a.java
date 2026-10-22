package xa;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.appstore.R;
import defpackage.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0406a f25849e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float f25850f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final float f25851g = 0.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final float f25852h = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f25853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f25854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f25855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f25856d;

    /* JADX INFO: renamed from: xa.a$a, reason: collision with other inner class name */
    public static final class C0406a {
        public /* synthetic */ C0406a(DefaultConstructorMarker r10) {
            this();
        }

        public final float a() {
            return a.a();
        }

        public final float b() {
            return a.b();
        }

        public final float c() {
            return a.c();
        }

        public C0406a() {
        }
    }

    static {
        f25849e = new C0406a(null);
        f25850f = TypedValue.applyDimension(1, 68, Resources.getSystem().getDisplayMetrics());
        f25851g = TypedValue.applyDimension(1, 14, Resources.getSystem().getDisplayMetrics());
        f25852h = TypedValue.applyDimension(1, (float) 0.5d, Resources.getSystem().getDisplayMetrics());
    }

    public /* synthetic */ a(int r10, int r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = 1;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = b.f5914a.b();
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = b.f5914a.a();
    L11:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ float a() {
        return f25851g;
    }

    public static final /* synthetic */ float b() {
        return f25852h;
    }

    public static final /* synthetic */ float c() {
        return f25850f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect r10, View r11, RecyclerView r12, RecyclerView.State r13) {
        q.g(r10, "outRect");
        q.g(r11, "view");
        q.g(r12, "parent");
        q.g(r13, WsConstants.KEY_CONNECTION_STATE);
        RecyclerView.Adapter r14 = r12.getAdapter();
        if (r14 == null) goto L21;
        int r15 = r14.getItemCount();
        int r16 = r15 % this.f25853a;
        int r17 = r12.getChildAdapterPosition(r11) + 1;
        if (r16 != 0) goto L11;
        if (((r15 - this.f25853a) + 1) > r17) goto L14;
        if (r17 > r15) goto L14;
        r10.right = this.f25854b;
    L14:
        int r18 = r17 % this.f25853a;
        int r19 = this.f25855c / 2;
        if (r18 == 0) goto L19;
        if (r18 == 1) goto L18;
        r10.bottom = r19;
        r10.top = r19;
        return;
    L18:
        r10.bottom = r19;
        return;
    L19:
        r10.top = r19;
        return;
    L11:
        if (((r15 - r16) + 1) > r17) goto L14;
        if (r17 > r15) goto L14;
        r10.right = this.f25854b;
        goto L14
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas r11, RecyclerView r12, RecyclerView.State r13) {
        q.g(r11, "c");
        q.g(r12, "parent");
        q.g(r13, WsConstants.KEY_CONNECTION_STATE);
        super.onDrawOver(r11, r12, r13);
        int r14 = r12.getChildCount();
        int r10 = 0;
    L3:
        if (r10 >= r14) goto L8;
        View r15 = r12.getChildAt(r10);
        float r16 = r15.getBottom() + (this.f25855c / 2.0f);
        if (((r12.getChildAdapterPosition(r15) + 1) % this.f25853a) == 0) goto L7;
        r11.drawLine(r15.getLeft() + f25850f, r16, r15.getRight() - f25851g, r16, this.f25856d);
    L7:
        r10 = r10 + 1;
        goto L3
    }

    public a(int r10, int r11, int r12) {
        this.f25853a = r10;
        this.f25854b = r11;
        this.f25855c = r12;
        Paint r13 = new Paint();
        r13.setColor(pa.a.f23414a.a().getColor(R.color.oui_line_2));
        r13.setStyle(Paint.Style.FILL);
        r13.setStrokeWidth(f25852h);
        this.f25856d = r13;
    }
}
