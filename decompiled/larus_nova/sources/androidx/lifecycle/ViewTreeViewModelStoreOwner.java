package androidx.lifecycle;

import android.view.View;
import androidx.core.viewtree.ViewTree;
import com.larus.nova.R;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\b\u0005\u001a\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004*\u00020\u0002H\u0007¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"setViewTreeViewModelStoreOwner", "", "Landroid/view/View;", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "set", "findViewTreeViewModelStoreOwner", MonitorConstants.CONNECT_TYPE_GET, "lifecycle-viewmodel"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ViewTreeViewModelStoreOwner {
    public static final ViewModelStoreOwner get(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
    L4:
        if (r100 == null) goto L15;
        Object r101 = r100.getTag(R.id.view_tree_view_model_store_owner);
        if ((r101 instanceof ViewModelStoreOwner) == false) goto L8;
        ViewModelStoreOwner r102 = (ViewModelStoreOwner) r101;
    L9:
        if (r102 != null) goto L10;
        Object r103 = ViewTree.getParentOrViewTreeDisjointParent(r100);
        if ((r103 instanceof View) == true) goto L13;
        r100 = null;
        goto L4
    L13:
        r100 = (View) r103;
        goto L4
    L10:
        return r102;
    L8:
        r102 = null;
        goto L9
    L15:
        return null;
    }

    public static final void set(View r100, ViewModelStoreOwner r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setTag(R.id.view_tree_view_model_store_owner, r101);
    }
}
