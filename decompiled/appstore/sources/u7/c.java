package u7;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedanceos.appstore.buss.utilities.f;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f24890a;

    public c(int r10) {
        this.f24890a = r10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect r10, View r11, RecyclerView r12, RecyclerView.State r13) {
        q.g(r10, "outRect");
        q.g(r11, "view");
        q.g(r12, "parent");
        q.g(r13, WsConstants.KEY_CONNECTION_STATE);
        RecyclerView.Adapter r14 = r12.getAdapter();
        if (r14 == null) goto L15;
        int r15 = r14.getItemCount();
        int r16 = r15 % this.f24890a;
        int r17 = r12.getChildAdapterPosition(r11) + 1;
        if (r16 != 0) goto L11;
        if (((r15 - this.f24890a) + 1) > r17) goto L16;
        if (r17 > r15) goto L17;
        r10.right = f.f8838a.b();
        return;
    L17:
        return;
    L16:
        return;
    L11:
        if (((r15 - r16) + 1) > r17) goto L19;
        if (r17 > r15) goto L20;
        r10.right = f.f8838a.b();
        return;
    L20:
        return;
    L19:
        return;
    }
}
