package androidx.recyclerview.widget;

import com.bytedance.ee.bear.bitable.uikit.drag.DragTreeCallback;
import hv4.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/recyclerview/widget/TreeItemTouchHelper;", "Landroidx/recyclerview/widget/ItemTouchHelper;", "callback", "Lcom/bytedance/ee/bear/bitable/uikit/drag/DragTreeCallback;", "<init>", "(Lcom/bytedance/ee/bear/bitable/uikit/drag/DragTreeCallback;)V", "select", "", "selected", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "actionState", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TreeItemTouchHelper extends ItemTouchHelper {
    private final DragTreeCallback callback;

    public TreeItemTouchHelper(DragTreeCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        super(r100);
        this.callback = r100;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper
    public void select(RecyclerView.ViewHolder r100, int r101) {
        a r102 = this.callback.f216123f;
        r102.getClass();
        int r103 = r102.f487297a;
        int r104 = r102.f487298b;
        int r105 = r102.f487300d;
        int r106 = r102.f487303g;
        boolean r107 = r102.f487305i;
        if (r100 != null) goto L20;
        if (r101 != 0) goto L20;
        boolean r108 = false;
        if (r107 == true) goto L8;
    L18:
        if (r108 == false) goto L20;
        tt5.a.h("TreeAdapter", "TreeItemTouchHelper select, set mSelected = null");
        this.mSelected = null;
        goto L20
    L8:
        if (r105 < r103) goto L10;
        if (r105 == r103) goto L14;
    L13:
        boolean r109 = true;
    L15:
        if (r109 == true) goto L18;
        if (r104 == r106) goto L18;
        r108 = true;
    L14:
        r109 = false;
        goto L15
    L10:
        if ((r103 - r105) <= 1) goto L14;
    L20:
        super.select(r100, r101);
    }
}
