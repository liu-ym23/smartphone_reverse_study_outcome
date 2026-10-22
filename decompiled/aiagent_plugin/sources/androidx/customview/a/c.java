package androidx.customview.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PoolingContainer.kt */
/* JADX INFO: loaded from: classes.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<b> f1549a;

    public c() {
        this.f1549a = new ArrayList();
    }

    public final void a() {
        int r0 = p.b((List) ZeusTransformUtils.preCheckCast(this.f1549a, List.class, "com.obric.aiagent.plugin"));
    L4:
        if ((-1) >= r0) goto L6;
        ((b) ZeusTransformUtils.preCheckCast(this.f1549a.get(r0), b.class, "com.obric.aiagent.plugin")).a();
        r0 = r0 - 1;
        goto L4
    }
}
