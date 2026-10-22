package bb;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.appstore.R;
import com.obric.appstore.common.core.ui.view.ObricAppItemView;
import com.obric.appstore.ui.adapter.ItemType;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f5960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5961e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f5962f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f5963g;

    public d(int r10, int r11, int r12, boolean r13, int r14, int r15) {
        this.f5957a = r10;
        this.f5958b = r11;
        this.f5959c = r12;
        this.f5960d = r13;
        this.f5961e = r14;
        this.f5962f = r15;
        Paint r16 = new Paint();
        r16.setColor(pa.a.f23414a.a().getColor(R.color.oui_line_2));
        r16.setStyle(Paint.Style.FILL);
        r16.setStrokeWidth(xa.a.f25849e.b());
        this.f5963g = r16;
    }

    public final boolean a(int r10, RecyclerView r11) {
        int r12 = r11.getChildAdapterPosition(r11.getChildAt(r10));
        boolean r13 = true;
        if (r12 != (-1)) goto L5;
        return true;
    L5:
        int r14 = r12 + 1;
        RecyclerView.Adapter r15 = r11.getAdapter();
        if (r15 != null) goto L8;
        return false;
    L8:
        if (r15.getItemViewType(r12) == ItemType.APP.ordinal()) goto L12;
        r13 = false;
    L12:
        if (r14 >= r15.getItemCount()) goto L16;
        if (r15.getItemViewType(r14) == ItemType.TITLE.ordinal()) goto L16;
        return false;
    L16:
        return r13;
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
        r10.top = this.f5957a;
    L10:
        if (r14 != (r16 - 1)) goto L12;
        r10.bottom = this.f5959c;
        return;
    L12:
        r10.bottom = this.f5962f;
        return;
    L8:
        r10.top = this.f5961e;
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
        if (this.f5960d == true) goto L5;
        return;
    L5:
        super.onDrawOver(r10, r11, r12);
        RecyclerView.Adapter r13 = r11.getAdapter();
        if (r13 == null) goto L16;
        int r14 = r13.getItemCount();
        int r15 = r11.getChildCount();
        int r16 = 0;
    L8:
        if (r16 >= r15) goto L22;
        View r17 = r11.getChildAt(r16);
        int r18 = r17.getBottom() + this.f5962f;
        int r19 = r11.getChildAdapterPosition(r17) + 1;
        boolean r20 = a(r16, r11);
        if (r19 == r14) goto L15;
        if ((r17 instanceof ObricAppItemView) == false) goto L15;
        if (r20 == true) goto L15;
        ObricAppItemView r21 = (ObricAppItemView) r17;
        float r22 = r21.getLeft();
        xa.a.C0406a r23 = xa.a.f25849e;
        float r24 = r18;
        r10.drawLine(r22 + r23.c(), r24, r21.getRight() - r23.a(), r24, this.f5963g);
    L15:
        r16 = r16 + 1;
        goto L8
    L22:
        return;
    }
}
