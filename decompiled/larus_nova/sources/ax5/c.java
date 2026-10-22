package ax5;

import com.bytedance.flow_audio.api.business.asr.error.FlowAsrErrorType;
import com.bytedance.flow_audio.api.business.asr.session.FlowAsrCancelReason;
import com.bytedance.flow_audio.api.business.asr.session.FlowAsrSessionState;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import iw5.f;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import lw5.h;
import rw5.d;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements jw5.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final jw5.a f16637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f16638d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f16639e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function2<String, jw5.a, Unit> f16640f;

    @Override // jw5.b
    public final void C0(jw5.a r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
    }

    @Override // jw5.b
    public final void E2(jw5.a r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
    }

    @Override // jw5.b
    public final void Y1(jw5.a r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
    }

    @Override // jw5.b
    public final void d2(jw5.a r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
    }

    @Override // jw5.b
    public final void f0(jw5.a r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        this.f16639e.n(false);
    }

    @Override // jw5.b
    public final void g0(jw5.a r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
    }

    @Override // jw5.b
    public final void A0(jw5.a r100, FlowAsrCancelReason r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "reason");
        this.f16639e.c1(new hw5.a(FlowAsrErrorType.CLIENT_ERROR, "Voice input retry canceled: " + r101, 502, "id=" + this.f16636b + ",sessionTaskId=" + r100.getTaskId() + ",reason=" + r101));
        this.f16637c.h();
        this.f16640f.invoke(this.f16636b, this.f16637c);
    }

    @Override // jw5.b
    public final void K1(jw5.a r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "data");
    }

    @Override // jw5.b
    public final void P1(jw5.a r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "sentence");
    }

    @Override // jw5.b
    public final void R2(jw5.a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
    }

    @Override // jw5.b
    public final void S(jw5.a r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
    }

    @Override // jw5.b
    public final void T(jw5.a r100, iw5.c r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        this.f16639e.T2(new lw5.c(this.f16638d, r101));
        this.f16637c.h();
        this.f16640f.invoke(this.f16636b, this.f16637c);
    }

    @Override // jw5.b
    public final void b0(jw5.a r100, FlowAsrSessionState r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "state");
    }

    @Override // jw5.b
    public final void e0(jw5.a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
    }

    @Override // jw5.b
    public final void f1(jw5.a r100, hw5.a r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "error");
        this.f16639e.c1(r101);
        this.f16637c.h();
        this.f16640f.invoke(this.f16636b, this.f16637c);
    }

    @Override // jw5.b
    public final void j(jw5.a r100, iw5.c r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "result");
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "result");
        if (r101.f496224a.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        this.f16639e.n(true);
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // jw5.b
    public final void q1(jw5.a r100, iw5.c r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "result");
    }

    public c(String r100, jw5.a r101, String r102, h r103, a r104) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r102, "audioFilePath");
        Intrinsics.checkNotNullParameter(r103, "completion");
        Intrinsics.checkNotNullParameter(r104, "onTerminal");
        this.f16636b = r100;
        this.f16637c = r101;
        this.f16638d = r102;
        this.f16639e = r103;
        this.f16640f = r104;
    }
}
