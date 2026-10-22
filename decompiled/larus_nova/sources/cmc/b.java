package cmc;

import com.ss.ugc.live.sdk.msg.utils.g;
import com.ss.ugc.live.sdk.msg.utils.j;
import com.ss.ugc.live.sdk.msg.utils.k;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class b<T> implements com.ss.ugc.live.sdk.msg.utils.d, com.ss.ugc.live.sdk.msg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.ss.ugc.live.sdk.msg.c f24286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f24287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d<T> f24288c;

    @Override // com.ss.ugc.live.sdk.msg.b
    public void a(boolean r100) {
    }

    @Override // com.ss.ugc.live.sdk.msg.b
    public void onInit() {
    }

    @Override // com.ss.ugc.live.sdk.msg.b
    public void onRelease() {
    }

    @Override // com.ss.ugc.live.sdk.msg.b
    public void onResume() {
    }

    @Override // com.ss.ugc.live.sdk.msg.b
    public void onStart() {
    }

    public b(hm2.e r100) {
        Intrinsics.checkNotNullParameter(r100, "messageDecoder");
        this.f24288c = r100;
        this.f24287b = new j(this);
    }

    @Override // com.ss.ugc.live.sdk.msg.utils.d
    public final void b(k r100) {
        Intrinsics.checkNotNullParameter(r100, "whatResult");
        mmc.c r101 = r100.f458483a;
        if ((r101 instanceof fmc.b) == false) goto L17;
        g<?, Throwable> r102 = r100.f458484b;
        ((fmc.b) r101).getClass();
        Intrinsics.checkNotNullParameter(r102, "result");
        if ((r102 instanceof g.c) == false) goto L13;
        List<? extends tlc.d> r103 = (List) ((g.c) r102).f458479b;
        Intrinsics.checkNotNullParameter(r103, "messages");
        com.ss.ugc.live.sdk.msg.c r104 = this.f24286a;
        if (r104 == null) goto L18;
        com.ss.ugc.live.sdk.msg.dispatch.e r105 = r104.f458205b;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("messageConsumer");
    L11:
        r105.c(r103);
        return;
    L18:
        return;
    L13:
        if ((r102 instanceof g.b) == false) goto L16;
        ((g.b) r102).getClass();
        return;
    L16:
        throw new NoWhenBranchMatchedException();
    }
}
