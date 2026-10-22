package androidx.savedstate;

import android.view.View;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ViewTreeSavedStateRegistryOwner.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final void a(View r3, c r4) {
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.aiagent.plugin");
        o.e(r3, "<this>");
        r3.setTag(ZeusTransformUtils.mapRes(R.id.view_tree_saved_state_registry_owner, DbHelper.COL_ID, "view_tree_saved_state_registry_owner"), r5);
    }
}
