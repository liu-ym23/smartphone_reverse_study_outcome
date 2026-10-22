package bb;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.appstore.R;
import com.obric.appstore.common.core.ui.view.ObricAppItemView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f5967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f5969f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f5970g;

    public /* synthetic */ e(int r10, int r11, int r12, boolean r13, int r14, int r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 8) == 0) goto L5;
        r13 = true;
    L5:
        boolean r18 = r13;
        if ((r16 & 16) == 0) goto L8;
        int r19 = r11;
    L10:
        if ((r16 & 32) == 0) goto L12;
        int r20 = r11;
    L13:
        this(r10, r11, r12, r18, r19, r20);
        return;
    L12:
        r20 = r15;
        goto L13
    L8:
        r19 = r14;
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect r10, View r11, RecyclerView r12, RecyclerView.State r13) {
        q.g(r10, "outRect");
        q.g(r11, "view");
        q.g(r12, "parent");
        q.g(r13, WsConstants.KEY_CONNECTION_STATE);
        int r14 = r12.getChildAdapterPosition(r11);
        RecyclerView.Adapter r15 = r12.getAdapter();
        if (r15 == null) goto L5;
        int r16 = r15.getItemCount();
    L6:
        if (r14 != 0) goto L8;
        r10.top = this.f5964a;
    L10:
        if (r14 != (r16 - 1)) goto L12;
        r10.bottom = this.f5966c;
        return;
    L12:
        r10.bottom = this.f5969f;
        return;
    L8:
        r10.top = this.f5968e;
        goto L10
    L5:
        r16 = 0;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas r10, RecyclerView r11, RecyclerView.State r12) {
        q.g(r10, "c");
        q.g(r11, "parent");
        q.g(r12, WsConstants.KEY_CONNECTION_STATE);
        if (this.f5967d == true) goto L5;
        return;
    L5:
        super.onDrawOver(r10, r11, r12);
        RecyclerView.Adapter r13 = r11.getAdapter();
        if (r13 == null) goto L15;
        int r14 = r13.getItemCount();
        int r15 = r11.getChildCount();
        int r16 = 0;
    L8:
        if (r16 >= r15) goto L20;
        View r17 = r11.getChildAt(r16);
        int r18 = r17.getBottom() + this.f5969f;
        if ((r11.getChildAdapterPosition(r17) + 1) == r14) goto L14;
        if ((r17 instanceof ObricAppItemView) == false) goto L14;
        ObricAppItemView r19 = (ObricAppItemView) r17;
        float r20 = r19.getLeft();
        xa.a.C0406a r21 = xa.a.f25849e;
        float r22 = r18;
        r10.drawLine(r20 + r21.c(), r22, r19.getRight() - r21.a(), r22, this.f5970g);
    L14:
        r16 = r16 + 1;
        goto L8
    L20:
        return;
    }

    public e(int r10, int r11, int r12, boolean r13, int r14, int r15) {
        this.f5964a = r10;
        this.f5965b = r11;
        this.f5966c = r12;
        this.f5967d = r13;
        this.f5968e = r14;
        this.f5969f = r15;
        Paint r16 = new Paint();
        r16.setColor(pa.a.f23414a.a().getColor(R.color.oui_line_2));
        r16.setStyle(Paint.Style.FILL);
        r16.setStrokeWidth(xa.a.f25849e.b());
        this.f5970g = r16;
    }
}
