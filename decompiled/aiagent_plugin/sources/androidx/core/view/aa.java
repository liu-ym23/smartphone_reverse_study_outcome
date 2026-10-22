package androidx.core.view;

import android.os.Build;
import android.view.ViewGroup;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ViewGroupCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class aa {

    /* JADX INFO: compiled from: ViewGroupCompat.java */
    static class a {
        static void a(ViewGroup r0, boolean r1) {
            r0.setTransitionGroup(r1);
        }

        static boolean a(ViewGroup r0) {
            return r0.isTransitionGroup();
        }

        static int b(ViewGroup r0) {
            return r0.getNestedScrollAxes();
        }
    }

    public static boolean a(ViewGroup r3) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        Boolean r0 = (Boolean) ZeusTransformUtils.preCheckCast(r3.getTag(ZeusTransformUtils.mapRes(R.id.tag_transition_group, DbHelper.COL_ID, "tag_transition_group")), Boolean.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L11;
        if (r0.booleanValue() == false) goto L11;
    L16:
        return true;
    L11:
        if (r3.getBackground() != null) goto L16;
        if (ViewCompat.s(r3) != null) goto L16;
        return false;
    L5:
        return a.a(r3);
    }
}
