package stepos.support.v7.widget;

import android.content.Context;
import com.stepos.alphame.R;

/* renamed from: stepos.support.v7.widget.o, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0895o extends L3.u {

    /* renamed from: t, reason: collision with root package name */
    public final /* synthetic */ C0897q f15105t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0895o(C0897q c0897q, Context context, L3.k kVar, C0894n c0894n) {
        super(context, kVar, c0894n, true, c0897q.f15115F ? R.attr.steposActionOverflowMenuSplitStyle : R.attr.actionOverflowMenuStyle);
        this.f15105t = c0897q;
        this.f1359s = c0897q.f15115F ? 4 : 3;
        this.f1357q = 8388613;
        this.f1352l = c0897q.f15114E;
    }

    @Override // L3.u, android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        super.onDismiss();
        C0897q c0897q = this.f15105t;
        L3.k kVar = c0897q.f15118c;
        if (kVar != null) {
            kVar.c(true);
        }
        c0897q.f15110A = null;
        c0897q.f15124i.setAlpha(1.0f);
    }
}
