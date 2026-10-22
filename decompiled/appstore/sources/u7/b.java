package u7;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedanceos.appstore.buss.utilities.f;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f24889a;

    public b(int r10) {
        this.f24889a = r10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect r10, View r11, RecyclerView r12, RecyclerView.State r13) {
        q.g(r10, "outRect");
        q.g(r11, "view");
        q.g(r12, "parent");
        q.g(r13, WsConstants.KEY_CONNECTION_STATE);
        super.getItemOffsets(r10, r11, r12, r13);
        r10.left = this.f24889a;
    }

    public /* synthetic */ b(int r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = f.f8838a.b();
    L5:
        this(r10);
    }
}
