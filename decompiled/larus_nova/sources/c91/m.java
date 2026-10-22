package c91;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.q0;
import com.bytedance.android.livesdk.message.model.j4;

/* JADX INFO: loaded from: classes47.dex */
public final class m extends q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f22845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j4 f22846b;

    @Override // com.bytedance.android.live.core.utils.q0
    public final void h(py.k r100, int r101, int r102) {
    }

    @Override // com.bytedance.android.live.core.utils.q0
    public final void g(py.k r100) {
        this.f22845a.f22829g.setVisibility(0);
    }

    public m(a r100, j4 r101) {
        this.f22845a = r100;
        this.f22846b = r101;
    }

    @Override // com.bytedance.android.live.core.utils.q0
    public final void f(py.k r100, Exception r101) {
        this.f22845a.f22829g.setVisibility(8);
        ALogger.e("gift_exhibition", "load light animation gift model failed,msg id = " + this.f22846b.getMessageId());
    }
}
