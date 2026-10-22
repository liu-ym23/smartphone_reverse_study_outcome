package androidx.customview.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ab;
import androidx.core.view.ac;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Iterator;

/* JADX INFO: compiled from: PoolingContainer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f1547a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f1548b = 0;

    public static final void a(View r1, boolean r2) {
        o.e(r1, "<this>");
        r1.setTag(f1548b, Boolean.valueOf(r2));
    }

    public static final void a(View r3) {
        o.e(r3, "<this>");
        Iterator<View> r4 = ac.a(r3).a();
    L4:
        if (r4.hasNext() == false) goto L6;
        b((View) ZeusTransformUtils.preCheckCast(r4.next(), View.class, "com.obric.aiagent.plugin")).a();
        goto L4
    }

    public static final void a(ViewGroup r3) {
        o.e(r3, "<this>");
        Iterator<View> r4 = ab.b(r3).a();
    L4:
        if (r4.hasNext() == false) goto L6;
        b((View) ZeusTransformUtils.preCheckCast(r4.next(), View.class, "com.obric.aiagent.plugin")).a();
        goto L4
    }

    static {
        f1547a = ZeusTransformUtils.mapRes(R.id.pooling_container_listener_holder_tag, DbHelper.COL_ID, "pooling_container_listener_holder_tag");
        f1548b = ZeusTransformUtils.mapRes(R.id.is_pooling_container_tag, DbHelper.COL_ID, "is_pooling_container_tag");
    }

    private static final c b(View r4) {
        int r0 = f1547a;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r4.getTag(r0), c.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        c r2 = new c();
        r4.setTag(r0, r2);
        return r2;
    L6:
        return r1;
    }
}
