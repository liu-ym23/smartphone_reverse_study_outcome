package androidx.lifecycle;

import android.view.View;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ViewTreeLifecycleOwner.kt */
/* JADX INFO: loaded from: classes.dex */
public final class aq {
    public static final void a(View r3, p r4) {
        p r5 = (p) ZeusTransformUtils.wrapperContextForParams(r4, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        r3.setTag(ZeusTransformUtils.mapRes(R.id.view_tree_lifecycle_owner, DbHelper.COL_ID, "view_tree_lifecycle_owner"), r5);
    }
}
