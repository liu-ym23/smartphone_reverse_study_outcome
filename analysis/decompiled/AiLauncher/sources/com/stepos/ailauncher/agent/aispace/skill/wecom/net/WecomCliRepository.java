package com.stepos.ailauncher.agent.aispace.skill.wecom.net;

import La.H;
import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Xa.t;
import Xa.u;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.network.RetrofitProvider;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import tb.AbstractC5531D;
import yc.v;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\t2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0019\u0010\u0013J\u0019\u0010\u001a\u001a\u00020\t2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001a\u0010\u0013J%\u0010\u001b\u001a\u00020\t2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\t2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001d\u0010\u0013J\u0019\u0010\u001e\u001a\u00020\t2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001e\u0010\u0013J%\u0010\u001f\u001a\u00020\t2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001f\u0010\u001cR\u0014\u0010 \u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001b\u0010*\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010!R\u001c\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001f\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040/8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001c\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001040,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010.R\u001f\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001040/8\u0006¢\u0006\f\n\u0004\b6\u00101\u001a\u0004\b7\u00103R\u001c\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010.R\u001f\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040/8\u0006¢\u0006\f\n\u0004\b9\u00101\u001a\u0004\b:\u00103R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020;0,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010.R\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020;0/8\u0006¢\u0006\f\n\u0004\b=\u00101\u001a\u0004\b>\u00103R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020;0,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010.R\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020;0/8\u0006¢\u0006\f\n\u0004\b@\u00101\u001a\u0004\bA\u00103R\u001c\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010.R\u001f\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040/8\u0006¢\u0006\f\n\u0004\bC\u00101\u001a\u0004\bD\u00103R\u001b\u0010I\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010'\u001a\u0004\bG\u0010H¨\u0006J"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/wecom/net/WecomCliRepository;", "", "<init>", "()V", "", "action", "taskId", "envId", "reason", "LY8/t;", "o", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lyc/v;", "Ltb/D;", "resp", "n", "(Lyc/v;)V", "raw", "p", "(Ljava/lang/String;)V", "C", "(Lyc/v;)Ljava/lang/String;", M5.b.CREDENTIAL_TOKEN, "k", "(Ljava/lang/String;)Ljava/lang/String;", "F", "D", "l", "(Ljava/lang/String;Ljava/lang/String;)V", "s", "q", "H", "TAG", "Ljava/lang/String;", "LUa/M;", "scope", "LUa/M;", "Lcom/google/gson/Gson;", "gson$delegate", "LY8/h;", "v", "()Lcom/google/gson/Gson;", "gson", "currentTaskId", "LXa/k;", "_qrUrl", "LXa/k;", "LXa/t;", "qrUrl", "LXa/t;", "x", "()LXa/t;", "", "_qrExpireElapsedMs", "qrExpireElapsedMs", "w", "_status", "status", "y", "", "_isCancelling", "isCancelling", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "_isToggling", "isToggling", "B", "_traceId", DidiCardProvider.KEY_TRACE_ID, "getTraceId", "Lcom/stepos/ailauncher/agent/aispace/skill/wecom/net/b;", "api$delegate", "u", "()Lcom/stepos/ailauncher/agent/aispace/skill/wecom/net/b;", "api", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WecomCliRepository {
    private static final String TAG = "AILauncher-WecomRepo";
    private static final Xa.k<Boolean> _isCancelling;
    private static final Xa.k<Boolean> _isToggling;
    private static final Xa.k<Long> _qrExpireElapsedMs;
    private static final Xa.k<String> _qrUrl;
    private static final Xa.k<String> _status;
    private static final Xa.k<String> _traceId;

    /* renamed from: api$delegate, reason: from kotlin metadata */
    private static final Y8.h api;
    private static final t<Boolean> isCancelling;
    private static final t<Boolean> isToggling;
    private static final t<Long> qrExpireElapsedMs;
    private static final t<String> qrUrl;
    private static final t<String> status;
    private static final t<String> traceId;
    public static final WecomCliRepository INSTANCE = new WecomCliRepository();
    private static final M scope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.b()));

    /* renamed from: gson$delegate, reason: from kotlin metadata */
    private static final Y8.h gson = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.net.e
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return WecomCliRepository.z();
        }
    });
    private static volatile String currentTaskId = "";

    static {
        Xa.k<String> kVarA = u.a(null);
        _qrUrl = kVarA;
        qrUrl = Xa.d.c(kVarA);
        Xa.k<Long> kVarA2 = u.a(null);
        _qrExpireElapsedMs = kVarA2;
        qrExpireElapsedMs = Xa.d.c(kVarA2);
        Xa.k<String> kVarA3 = u.a(null);
        _status = kVarA3;
        status = Xa.d.c(kVarA3);
        Boolean bool = Boolean.FALSE;
        Xa.k<Boolean> kVarA4 = u.a(bool);
        _isCancelling = kVarA4;
        isCancelling = Xa.d.c(kVarA4);
        Xa.k<Boolean> kVarA5 = u.a(bool);
        _isToggling = kVarA5;
        isToggling = Xa.d.c(kVarA5);
        Xa.k<String> kVarA6 = u.a(null);
        _traceId = kVarA6;
        traceId = Xa.d.c(kVarA6);
        api = C4848b.a(LazyThreadSafetyMode.SYNCHRONIZED, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.net.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WecomCliRepository.j();
            }
        });
    }

    public static /* synthetic */ void E(WecomCliRepository wecomCliRepository, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        wecomCliRepository.D(str);
    }

    public static /* synthetic */ void G(WecomCliRepository wecomCliRepository, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        wecomCliRepository.F(str);
    }

    public static /* synthetic */ void I(WecomCliRepository wecomCliRepository, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        wecomCliRepository.H(str, str2);
    }

    public static final b j() {
        return (b) RetrofitProvider.newRetrofit$default(H5.a.INSTANCE.a(C3197a.INSTANCE.a()).n(), null, false, false, false, 30, null).c(b.class);
    }

    public static /* synthetic */ void m(WecomCliRepository wecomCliRepository, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = "user_cancel";
        }
        wecomCliRepository.l(str, str2);
    }

    public static /* synthetic */ void r(WecomCliRepository wecomCliRepository, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        wecomCliRepository.q(str);
    }

    public static /* synthetic */ void t(WecomCliRepository wecomCliRepository, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        wecomCliRepository.s(str);
    }

    public static final Gson z() {
        return new Gson();
    }

    public final t<Boolean> A() {
        return isCancelling;
    }

    public final t<Boolean> B() {
        return isToggling;
    }

    public final String C(v<AbstractC5531D> resp) {
        Object objB;
        AbstractC5531D abstractC5531DD;
        String strA;
        try {
            Result.Companion companion = Result.INSTANCE;
            if (resp.f()) {
                abstractC5531DD = resp.a();
                strA = abstractC5531DD != null ? abstractC5531DD.A() : null;
            } else {
                abstractC5531DD = resp.d();
                if (abstractC5531DD != null) {
                }
            }
            objB = Result.b(strA);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        String str = (String) (Result.g(objB) ? null : objB);
        return str == null ? "" : str;
    }

    public final void D(String taskId) {
        if (taskId == null) {
            taskId = "";
        }
        if (H.x0(taskId)) {
            taskId = currentTaskId;
        }
        if (H.x0(taskId)) {
            i.b(i.INSTANCE, "retry skipped: no taskId (start 没返回 / 还没调过)", null, 2, null);
        } else {
            o("retry", taskId, null, null);
        }
    }

    public final void F(String envId) {
        currentTaskId = "";
        _status.setValue(null);
        _qrUrl.setValue(null);
        _qrExpireElapsedMs.setValue(null);
        Xa.k<Boolean> kVar = _isCancelling;
        Boolean bool = Boolean.FALSE;
        kVar.setValue(bool);
        _isToggling.setValue(bool);
        _traceId.setValue(null);
        o("start", null, envId, null);
    }

    public final void H(String taskId, String envId) {
        if (taskId == null) {
            taskId = "";
        }
        if (H.x0(taskId)) {
            taskId = currentTaskId;
        }
        C1060i.d(scope, null, null, new WecomCliRepository$status$1(taskId, envId, null), 3, null);
    }

    public final String k(String token) {
        return "Bearer " + H.D1(H.R0(token, "Bearer ")).toString();
    }

    public final void l(String taskId, String reason) {
        if (taskId == null) {
            taskId = "";
        }
        if (H.x0(taskId)) {
            taskId = currentTaskId;
        }
        if (H.x0(taskId)) {
            i.b(i.INSTANCE, "cancel skipped: no taskId", null, 2, null);
        } else {
            _isCancelling.setValue(Boolean.TRUE);
            o("cancel", taskId, null, reason);
        }
    }

    public final void n(v<AbstractC5531D> resp) {
        String strB;
        Xa.k<String> kVar = _traceId;
        String value = kVar.getValue();
        if ((value == null || H.x0(value)) && (strB = resp.e().b("Trace-Id")) != null) {
            if (H.x0(strB)) {
                strB = null;
            }
            if (strB == null) {
                return;
            }
            kVar.setValue(strB);
            i.b(i.INSTANCE, "trace_id captured from header: " + strB, null, 2, null);
        }
    }

    public final void o(String action, String taskId, String envId, String reason) {
        C1060i.d(scope, null, null, new WecomCliRepository$connect$1(action, taskId, envId, reason, null), 3, null);
    }

    public final void p(String raw) {
        String status2;
        if (raw == null || H.x0(raw)) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Object objFromJson = v().fromJson(raw, new TypeToken<WecomApiResponse<WecomConnectTaskSnapshot>>() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.net.WecomCliRepository$consumeSnapshot$1$type$1
            }.getType());
            p.h(objFromJson, "fromJson(...)");
            WecomApiResponse wecomApiResponse = (WecomApiResponse) objFromJson;
            if (wecomApiResponse.b() && (wecomApiResponse.a() == null || (status2 = ((WecomConnectTaskSnapshot) wecomApiResponse.a()).getStatus()) == null || H.x0(status2))) {
                Xa.k<String> kVar = _status;
                if (!p.d(kVar.getValue(), "idle")) {
                    kVar.setValue("idle");
                    i.b(i.INSTANCE, "status=idle (no snapshot in success response)", null, 2, null);
                }
                Xa.k<Boolean> kVar2 = _isCancelling;
                if (kVar2.getValue().booleanValue()) {
                    kVar2.setValue(Boolean.FALSE);
                    i.b(i.INSTANCE, "cancelling cleared by empty-snapshot success", null, 2, null);
                }
                Xa.k<Boolean> kVar3 = _isToggling;
                if (kVar3.getValue().booleanValue()) {
                    kVar3.setValue(Boolean.FALSE);
                    i.b(i.INSTANCE, "toggling cleared by empty-snapshot success", null, 2, null);
                }
            } else {
                WecomConnectTaskSnapshot wecomConnectTaskSnapshot = (WecomConnectTaskSnapshot) wecomApiResponse.a();
                if (wecomConnectTaskSnapshot != null) {
                    String taskId = wecomConnectTaskSnapshot.getTaskId();
                    if (taskId == null) {
                        taskId = "";
                    }
                    if (!H.x0(taskId) && !p.d(taskId, currentTaskId)) {
                        currentTaskId = taskId;
                        i.b(i.INSTANCE, "cached task_id=" + taskId, null, 2, null);
                    }
                    String status3 = wecomConnectTaskSnapshot.getStatus();
                    if (status3 != null && !H.x0(status3)) {
                        Xa.k<String> kVar4 = _status;
                        if (!p.d(kVar4.getValue(), status3)) {
                            kVar4.setValue(status3);
                            i.b(i.INSTANCE, "status=" + status3, null, 2, null);
                        }
                    }
                    Xa.k<Boolean> kVar5 = _isCancelling;
                    if (kVar5.getValue().booleanValue() && (p.d(status3, "disconnected") || p.d(status3, "idle"))) {
                        kVar5.setValue(Boolean.FALSE);
                        i.b(i.INSTANCE, "cancelling cleared by status=" + status3, null, 2, null);
                    }
                    Xa.k<Boolean> kVar6 = _isToggling;
                    if (kVar6.getValue().booleanValue() && status3 != null && !H.x0(status3)) {
                        kVar6.setValue(Boolean.FALSE);
                        i.b(i.INSTANCE, "toggling cleared by status=" + status3, null, 2, null);
                    }
                    WecomNextAction nextAction = wecomConnectTaskSnapshot.getNextAction();
                    String url = nextAction != null ? nextAction.getUrl() : null;
                    WecomNextAction nextAction2 = wecomConnectTaskSnapshot.getNextAction();
                    if (!p.d(nextAction2 != null ? nextAction2.getType() : null, com.stepos.ailauncher.agent.aispace.skill.feishu.net.j.ACTION_TYPE_OPEN_URL) || url == null || H.x0(url)) {
                        Xa.k<Long> kVar7 = _qrExpireElapsedMs;
                        if (kVar7.getValue() != null) {
                            kVar7.setValue(null);
                        }
                    } else {
                        Xa.k<String> kVar8 = _qrUrl;
                        if (!p.d(kVar8.getValue(), url)) {
                            kVar8.setValue(url);
                            i.b(i.INSTANCE, "qr_url updated", null, 2, null);
                        }
                        Long expireAt = wecomConnectTaskSnapshot.getExpireAt();
                        Long serverTime = wecomConnectTaskSnapshot.getServerTime();
                        if (expireAt != null && serverTime != null && expireAt.longValue() > serverTime.longValue()) {
                            long jLongValue = (expireAt.longValue() - serverTime.longValue()) * 1000;
                            _qrExpireElapsedMs.setValue(Long.valueOf(SystemClock.elapsedRealtime() + jLongValue));
                            i.b(i.INSTANCE, "qr_expire updated remaining_ms=" + jLongValue, null, 2, null);
                        }
                    }
                }
            }
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    public final void q(String taskId) {
        if (taskId == null) {
            taskId = "";
        }
        if (H.x0(taskId)) {
            taskId = currentTaskId;
        }
        if (H.x0(taskId)) {
            i.b(i.INSTANCE, "disable skipped: no taskId", null, 2, null);
        } else {
            _isToggling.setValue(Boolean.TRUE);
            o("disable", taskId, null, null);
        }
    }

    public final void s(String taskId) {
        if (taskId == null) {
            taskId = "";
        }
        if (H.x0(taskId)) {
            taskId = currentTaskId;
        }
        if (H.x0(taskId)) {
            i.b(i.INSTANCE, "enable skipped: no taskId", null, 2, null);
        } else {
            _isToggling.setValue(Boolean.TRUE);
            o("enable", taskId, null, null);
        }
    }

    public final b u() {
        Object value = api.getValue();
        p.h(value, "getValue(...)");
        return (b) value;
    }

    public final Gson v() {
        return (Gson) gson.getValue();
    }

    public final t<Long> w() {
        return qrExpireElapsedMs;
    }

    public final t<String> x() {
        return qrUrl;
    }

    public final t<String> y() {
        return status;
    }
}
