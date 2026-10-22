package bx2;

import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ml.process.bl.MLConfigModel;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class q extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f21342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f21343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f21344d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f21345e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f21346f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f21347g;

    @Override // bx2.a
    public final String h() {
        return MLConfigModel.MODEL_TYPE_TF;
    }

    public q() {
        this.f21344d = 1.0f;
        this.f21345e = 1.0f;
    }

    @Override // bx2.a
    public final void b(ax2.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r100.a().scale(this.f21344d, this.f21345e);
        r100.a().skew(this.f21342b, this.f21343c);
        r100.a().translate(this.f21346f, this.f21347g);
    }

    @Override // bx2.a
    public final void g(Map<String, ? extends Object> r100, ax2.c r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "dataManager");
        this.f21342b = a.c(r100, "kx");
        this.f21343c = a.c(r100, "ky");
        this.f21344d = a.c(r100, "sx");
        this.f21345e = a.c(r100, "sy");
        this.f21346f = a.c(r100, "dx");
        this.f21347g = a.c(r100, "dy");
    }
}
