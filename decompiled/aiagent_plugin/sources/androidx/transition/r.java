package androidx.transition;

import android.view.ViewGroup;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Scene.java */
/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewGroup f2852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Runnable f2853b;

    public void a() {
        if (a(this.f2852a) != this) goto L8;
        Runnable r1 = this.f2853b;
        if (r1 == null) goto L9;
        r1.run();
        return;
    L9:
        return;
    }

    static void a(ViewGroup r3, r r4) {
        r3.setTag(ZeusTransformUtils.mapRes(R.id.transition_current_scene, DbHelper.COL_ID, "transition_current_scene"), r4);
    }

    public static r a(ViewGroup r3) {
        return (r) ZeusTransformUtils.preCheckCast(r3.getTag(ZeusTransformUtils.mapRes(R.id.transition_current_scene, DbHelper.COL_ID, "transition_current_scene")), r.class, "com.obric.aiagent.plugin");
    }
}
