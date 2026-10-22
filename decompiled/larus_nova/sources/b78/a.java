package b78;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.TriggerType;
import com.larus.audio.call.record.AVInnerRecordAdapter$linkAudioRecorder$1;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.audio.call.util.p;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.internal.audio.ability.SessionReleaseReason;
import com.larus.im.service.audio.AvAecType;
import com.larus.im.service.audio.ModalType;
import com.larus.im.service.audio.cmd.TargetVideoSourceType;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.im.service.audio.l;
import com.larus.im.service.audio.n;
import com.larus.im.service.audio.o;
import com.larus.im.service.audio.q;
import com.larus.im.service.audio.v;
import com.larus.im.service.audio.x;
import com.larus.im.service.audio.x0;
import com.larus.im.service.audio.y;
import com.larus.im.service.audio.z;
import com.larus.im.service.audio.z0;
import com.tencent.open.SocialConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ouc.d0;
import ouc.g0;
import ouc.k;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements id9.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IRealtimeCallTracer f17961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RealtimeCallParam f17962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final id9.d f17963c;

    @Override // id9.d
    public final void A(o r100) {
        this.f17963c.A(r100);
    }

    @Override // id9.d
    public final void B(xe9.d r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this.f17963c.B(r100);
    }

    @Override // id9.e
    public final void C(SessionReleaseReason r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.f17963c.C(r100);
    }

    @Override // id9.e
    public final void D(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f17963c.D(r100);
    }

    @Override // id9.d
    public final y a() {
        return this.f17963c.a();
    }

    @Override // id9.e
    public final void b(v r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f17963c.b(r100);
    }

    @Override // id9.d
    public final n c(int r100, AvAecType r101, AVInnerRecordAdapter$linkAudioRecorder$1 r102) {
        Intrinsics.checkNotNullParameter(r101, "aecType");
        Intrinsics.checkNotNullParameter(r102, "preProcessor");
        return this.f17963c.c(r100, r101, r102);
    }

    @Override // id9.d
    public final void d(x r100) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_RECEIVER);
        this.f17963c.d(r100);
    }

    @Override // id9.e
    public final z e() {
        return this.f17963c.e();
    }

    @Override // id9.d
    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "paramsJson");
        this.f17963c.f(r100);
    }

    @Override // id9.d
    public final x0 getSessionConfig() {
        return this.f17963c.getSessionConfig();
    }

    @Override // id9.d
    public final void h(boolean r100) {
        this.f17963c.h(r100);
    }

    @Override // id9.d
    public final boolean k() {
        return this.f17963c.k();
    }

    @Override // id9.d
    public final void m(ModalType r100, TargetVideoSourceType r101) {
        Intrinsics.checkNotNullParameter(r100, "modalType");
        Intrinsics.checkNotNullParameter(r101, "videoSourceType");
        this.f17963c.m(r100, r101);
    }

    @Override // id9.e
    public final void n(z0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f17963c.n(r100);
    }

    @Override // id9.d
    public final void o() {
        this.f17963c.o();
    }

    @Override // id9.e
    public final void q(z0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f17963c.q(r100);
    }

    @Override // id9.d
    public final void r(Map<String, ? extends Object> r100) {
        this.f17963c.r(r100);
    }

    @Override // id9.e
    public final int s(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        return this.f17963c.s(r100);
    }

    @Override // id9.e
    public final void start() {
        this.f17963c.start();
    }

    @Override // id9.e
    public final jd9.c state() {
        return this.f17963c.state();
    }

    @Override // id9.d
    public final void t() {
        this.f17963c.t();
    }

    @Override // id9.d
    public final void u(l r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        this.f17963c.u(r100);
    }

    @Override // id9.d
    public final q v() {
        return this.f17963c.v();
    }

    @Override // id9.e
    public final void w(v r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f17963c.w(r100);
    }

    @Override // id9.d
    public final void x(x r100) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_RECEIVER);
        this.f17963c.x(r100);
    }

    @Override // id9.d
    public final void y(Map<String, String> r100) {
        this.f17963c.y(r100);
    }

    @Override // id9.d
    public final void p(TriggerMode r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "triggerType");
        String r102 = null;
        if (r101 == null) goto L5;
        d0 r103 = g.a(r101);
    L6:
        String r104 = this.f17962b.f288756p.f288861i;
        if (p.a(r104) == false) goto L9;
        LinkedHashMap r105 = new LinkedHashMap();
        g0 r106 = k.c(r104);
        Intrinsics.checkNotNullParameter("enter_method", "key");
        Intrinsics.checkNotNullParameter(r106, "element");
        ouc.i r107 = (ouc.i) r105.put("enter_method", r106);
        r103 = q68.d.a(new d0(r105), r103);
    L9:
        id9.d r108 = this.f17963c;
        if (r103 == null) goto L12;
        String r109 = r103.toString();
    L13:
        r108.p(r100, r109);
        if (r100 != TriggerMode.HELLO) goto L16;
    L17:
        this.f17961a.Q(IRealtimeCallTracer.HelloStatus.TRIGGER_HELLO, null);
    L18:
        Integer r110 = sf9.b.b(r100);
        if (r110 == null) goto L52;
        int r111 = r110.intValue();
        TriggerType.Companion.getClass();
        if (r111 != 1) goto L23;
        TriggerType r112 = TriggerType.TYPE_HELLO;
    L46:
        if (r112 == null) goto L48;
        r102 = r112.getLogName();
    L48:
        if (r102 != null) goto L50;
        r102 = "";
    L50:
        this.f17961a.y(r102, this.f17962b, new d0(new LinkedHashMap()));
        return;
    L23:
        if (r111 != 2) goto L25;
        r112 = TriggerType.TYPE_WAIT;
        goto L46
    L25:
        if (r111 != 4) goto L27;
        r112 = TriggerType.TYPE_HANG_UP;
        goto L46
    L27:
        if (r111 != 5) goto L29;
        r112 = TriggerType.TYPE_DENY_AUTH;
        goto L46
    L29:
        if (r111 != 6) goto L31;
        r112 = TriggerType.TYPE_AUTH_SUCCESS;
        goto L46
    L31:
        if (r111 == 8) goto L40;
        switch(r111) {
            case 12: goto L39;
            case 13: goto L38;
            case 14: goto L37;
            case 15: goto L36;
            case 16: goto L35;
            case 17: goto L34;
            default: goto L33;
        };
    L33:
        r112 = null;
        goto L46
    L34:
        r112 = TriggerType.TYPE_DORA_E_BOT_ACTIVE;
        goto L46
    L35:
        r112 = TriggerType.TYPE_CLIENT_SUMMON_NOTICE;
        goto L46
    L36:
        r112 = TriggerType.TYPE_QUERY_WHEN_SILENCE;
        goto L46
    L37:
        r112 = TriggerType.TYPE_IMAGE_QUERY;
        goto L46
    L38:
        r112 = TriggerType.TYPE_NOTIFICATION_SUMMARY;
        goto L46
    L39:
        r112 = TriggerType.TYPE_CONTINUE;
        goto L46
    L40:
        r112 = TriggerType.TYPE_ONBOARDING_START;
        goto L46
    L52:
        return;
    L16:
        if (r100 != TriggerMode.HELLO_NEW) goto L18;
    L12:
        r109 = null;
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    public a(IRealtimeCallTracer r100, RealtimeCallParam r101, id9.d r102) {
        Intrinsics.checkNotNullParameter(r100, "tracer");
        Intrinsics.checkNotNullParameter(r101, "param");
        Intrinsics.checkNotNullParameter(r102, "ability");
        this.f17961a = r100;
        this.f17962b = r101;
        this.f17963c = r102;
    }
}
