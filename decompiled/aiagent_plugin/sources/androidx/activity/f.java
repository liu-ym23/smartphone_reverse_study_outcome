package androidx.activity;

import android.view.View;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ViewTreeOnBackPressedDispatcherOwner.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static final void a(View r3, d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        o.e(r3, "<this>");
        o.e(r5, "onBackPressedDispatcherOwner");
        r3.setTag(ZeusTransformUtils.mapRes(R.id.view_tree_on_back_pressed_dispatcher_owner, DbHelper.COL_ID, "view_tree_on_back_pressed_dispatcher_owner"), r5);
    }
}
