package androidx.lifecycle;

import android.view.View;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ViewTreeViewModelStoreOwner.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ar {
    public static final void a(View r3, ap r4) {
        ap r5 = (ap) ZeusTransformUtils.wrapperContextForParams(r4, ap.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        r3.setTag(ZeusTransformUtils.mapRes(R.id.view_tree_view_model_store_owner, DbHelper.COL_ID, "view_tree_view_model_store_owner"), r5);
    }
}
