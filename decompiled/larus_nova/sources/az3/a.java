package az3;

import com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class a<V extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wy3.a f16804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public V f16805b;

    public void A(V r100) {
        Intrinsics.checkNotNullParameter(r100, "viewProvider");
    }

    public void C() {
    }

    public void D() {
    }

    public a(wy3.a r100) {
        Intrinsics.checkNotNullParameter(r100, "cmtContext");
        this.f16804a = r100;
    }
}
