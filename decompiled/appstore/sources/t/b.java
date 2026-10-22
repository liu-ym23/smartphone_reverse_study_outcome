package t;

import androidx.customview.poolingcontainer.PoolingContainerListener;
import java.util.ArrayList;
import kotlin.collections.t;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f24699a;

    public b() {
        this.f24699a = new ArrayList();
    }

    public final void a() {
        int r10 = t.k(this.f24699a);
    L4:
        if ((-1) >= r10) goto L6;
        ((PoolingContainerListener) this.f24699a.get(r10)).onRelease();
        r10 = r10 - 1;
        goto L4
    }
}
