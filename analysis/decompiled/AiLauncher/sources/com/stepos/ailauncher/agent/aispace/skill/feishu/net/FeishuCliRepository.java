package com.stepos.ailauncher.agent.aispace.skill.feishu.net;

import La.H;
import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.network.RetrofitProvider;
import h8.C4148a;
import java.util.Arrays;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.y;
import p9.InterfaceC5063a;
import tb.AbstractC5531D;
import yc.v;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\bJ%\u0010\r\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000f\u0010\bJ\u0019\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0010\u0010\bJ%\u0010\u0011\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u000eJ\u0015\u0010\u0012\u001a\u00020\u0004*\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u0004*\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0013J5\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ-\u0010\"\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002¢\u0006\u0004\b\"\u0010#J!\u0010%\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b%\u0010&J\u0019\u0010)\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010'H\u0002¢\u0006\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001b\u0010=\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u00105\u001a\u0004\b;\u0010<¨\u0006>"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/FeishuCliRepository;", "", "<init>", "()V", "", "envId", "LY8/t;", "D", "(Ljava/lang/String;)V", "taskId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "B", "reason", "k", "(Ljava/lang/String;Ljava/lang/String;)V", "p", "n", "F", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;)Ljava/lang/String;", "z", "action", "m", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "opName", "", "w", "(Ljava/lang/String;)Z", "v", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/l;", "requestBody", "Lyc/v;", "Ltb/D;", "resp", "u", "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/l;Lyc/v;)V", "status", "x", "(Ljava/lang/String;Ljava/lang/String;)Z", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/p;", "snapshot", "y", "(Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/p;)V", "TAG", "Ljava/lang/String;", "", "USER_ACTION_IDLE_BLOCK_WINDOW_MS", "J", "LUa/M;", "scope", "LUa/M;", "Lcom/google/gson/Gson;", "gson$delegate", "LY8/h;", "s", "()Lcom/google/gson/Gson;", "gson", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/d;", "api$delegate", "r", "()Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/d;", "api", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FeishuCliRepository {
    private static final String TAG = "AILauncher-FeishuRepo";
    private static final long USER_ACTION_IDLE_BLOCK_WINDOW_MS = 5000;
    public static final FeishuCliRepository INSTANCE = new FeishuCliRepository();
    private static final M scope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.b()));

    /* renamed from: gson$delegate, reason: from kotlin metadata */
    private static final Y8.h gson = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.net.h
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return FeishuCliRepository.t();
        }
    });

    /* renamed from: api$delegate, reason: from kotlin metadata */
    private static final Y8.h api = C4848b.a(LazyThreadSafetyMode.SYNCHRONIZED, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.net.i
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return FeishuCliRepository.j();
        }
    });

    public static /* synthetic */ void C(FeishuCliRepository feishuCliRepository, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        feishuCliRepository.B(str);
    }

    public static /* synthetic */ void E(FeishuCliRepository feishuCliRepository, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        feishuCliRepository.D(str);
    }

    public static /* synthetic */ void G(FeishuCliRepository feishuCliRepository, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        feishuCliRepository.F(str, str2);
    }

    public static /* synthetic */ void i(FeishuCliRepository feishuCliRepository, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        feishuCliRepository.h(str);
    }

    public static final d j() {
        return (d) RetrofitProvider.newRetrofit$default(H5.a.INSTANCE.a(C3197a.INSTANCE.a()).d(), null, false, false, false, 30, null).c(d.class);
    }

    public static /* synthetic */ void l(FeishuCliRepository feishuCliRepository, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = "user_cancel";
        }
        feishuCliRepository.k(str, str2);
    }

    public static /* synthetic */ void o(FeishuCliRepository feishuCliRepository, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        feishuCliRepository.n(str);
    }

    public static /* synthetic */ void q(FeishuCliRepository feishuCliRepository, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        feishuCliRepository.p(str);
    }

    public static final Gson t() {
        return new Gson();
    }

    public final String A(String str) {
        if (str != null && !H.x0(str)) {
            return str;
        }
        String value = j.INSTANCE.j().getValue();
        return value == null ? "" : value;
    }

    public final void B(String taskId) {
        String strA = A(taskId);
        if (H.x0(strA)) {
            C4148a.u(TAG, "retry skipped: no taskId", false, 4, null);
        } else {
            m("retry", strA, null, null);
        }
    }

    public final void D(String envId) {
        m("start", null, envId, null);
    }

    public final void F(String taskId, String envId) {
        FeishuRequestBody feishuRequestBody = new FeishuRequestBody(null, A(taskId), z(envId), null, 9, null);
        String value = j.INSTANCE.k().getValue();
        String str = (value == null || H.x0(value)) ? null : value;
        y yVar = y.f34840a;
        String str2 = String.format("status body=%s traceId='%s'", Arrays.copyOf(new Object[]{feishuRequestBody, str == null ? "" : str}, 2));
        kotlin.jvm.internal.p.h(str2, "format(...)");
        C4148a.d(TAG, str2, false, 4, null);
        C1060i.d(scope, null, null, new FeishuCliRepository$status$$inlined$launch$1("status", feishuRequestBody, null, str, feishuRequestBody), 3, null);
    }

    public final void h(String taskId) {
        String strA = A(taskId);
        if (H.x0(strA)) {
            C4148a.u(TAG, "advance skipped: no taskId", false, 4, null);
        } else {
            m("advance", strA, null, null);
        }
    }

    public final void k(String taskId, String reason) {
        String strA = A(taskId);
        if (H.x0(strA)) {
            C4148a.u(TAG, "cancel skipped: no taskId", false, 4, null);
        } else {
            j.INSTANCE.o(true);
            m("cancel", strA, null, reason);
        }
    }

    public final void m(String action, String taskId, String envId, String reason) {
        if (taskId == null) {
            taskId = "";
        }
        if (envId == null) {
            envId = "";
        }
        FeishuRequestBody feishuRequestBody = new FeishuRequestBody(action, taskId, envId, reason != null ? reason : "");
        String value = j.INSTANCE.k().getValue();
        C1060i.d(scope, null, null, new FeishuCliRepository$connect$$inlined$launch$1("connect[" + action + "]", feishuRequestBody, null, action, (value == null || H.x0(value)) ? null : value, feishuRequestBody), 3, null);
    }

    public final void n(String taskId) {
        String strA = A(taskId);
        if (H.x0(strA)) {
            C4148a.u(TAG, "disable skipped: no taskId", false, 4, null);
        } else {
            j.INSTANCE.p(true);
            m("disable", strA, null, null);
        }
    }

    public final void p(String taskId) {
        String strA = A(taskId);
        if (H.x0(strA)) {
            C4148a.u(TAG, "enable skipped: no taskId", false, 4, null);
        } else {
            j.INSTANCE.p(true);
            m("enable", strA, null, null);
        }
    }

    public final d r() {
        Object value = api.getValue();
        kotlin.jvm.internal.p.h(value, "getValue(...)");
        return (d) value;
    }

    public final Gson s() {
        return (Gson) gson.getValue();
    }

    public final void u(String opName, FeishuRequestBody requestBody, v<AbstractC5531D> resp) {
        Object objB;
        Object objB2;
        String traceId;
        String str;
        FeishuRequestBody feishuRequestBody;
        Object objB3;
        String strA;
        int iB = resp.b();
        try {
            Result.Companion companion = Result.INSTANCE;
            AbstractC5531D abstractC5531DA = resp.a();
            if (abstractC5531DA == null || (strA = abstractC5531DA.A()) == null) {
                AbstractC5531D abstractC5531DD = resp.d();
                strA = abstractC5531DD != null ? abstractC5531DD.A() : null;
            }
            objB = Result.b(strA);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str2 = (String) objB;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str2;
        if (!resp.f()) {
            try {
                objB3 = Result.b((FeishuApiErrorBody) s().fromJson(str3, FeishuApiErrorBody.class));
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                objB3 = Result.b(C4849c.a(th2));
            }
            if (Result.g(objB3)) {
                objB3 = null;
            }
            FeishuApiErrorBody feishuApiErrorBody = (FeishuApiErrorBody) objB3;
            y yVar = y.f34840a;
            String str4 = String.format("%s http=%d body=%s -> code=%s detailCode=%s error=%s msg=%s (raw=%s)", Arrays.copyOf(new Object[]{opName, Integer.valueOf(iB), requestBody, feishuApiErrorBody != null ? feishuApiErrorBody.getCode() : null, feishuApiErrorBody != null ? feishuApiErrorBody.getDetailCode() : null, feishuApiErrorBody != null ? feishuApiErrorBody.getError() : null, feishuApiErrorBody != null ? feishuApiErrorBody.getMsg() : null, str3}, 8));
            kotlin.jvm.internal.p.h(str4, "format(...)");
            C4148a.u(TAG, str4, false, 4, null);
            k.INSTANCE.a(opName + " http=" + iB, str3);
            if (w(opName)) {
                j.INSTANCE.p(false);
            }
            if (v(opName)) {
                j.INSTANCE.o(false);
                return;
            }
            return;
        }
        try {
            objB2 = Result.b((FeishuApiResponse) s().fromJson(str3, new TypeToken<FeishuApiResponse<NetConnectTaskSnapshot>>() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuCliRepository$handleResponse$parsed$1$type$1
            }.getType()));
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th3));
        }
        if (Result.g(objB2)) {
            objB2 = null;
        }
        FeishuApiResponse feishuApiResponse = (FeishuApiResponse) objB2;
        y yVar2 = y.f34840a;
        Integer code = feishuApiResponse != null ? feishuApiResponse.getCode() : null;
        String msg = feishuApiResponse != null ? feishuApiResponse.getMsg() : null;
        NetConnectTaskSnapshot netConnectTaskSnapshot = feishuApiResponse != null ? (NetConnectTaskSnapshot) feishuApiResponse.b() : null;
        if (feishuApiResponse != null) {
            traceId = feishuApiResponse.getTraceId();
            feishuRequestBody = requestBody;
            str = opName;
        } else {
            traceId = null;
            str = opName;
            feishuRequestBody = requestBody;
        }
        String str5 = String.format("%s ok body=%s -> code=%s msg=%s data=%s traceId=%s", Arrays.copyOf(new Object[]{str, feishuRequestBody, code, msg, netConnectTaskSnapshot, traceId}, 6));
        kotlin.jvm.internal.p.h(str5, "format(...)");
        C4148a.d(TAG, str5, false, 4, null);
        k kVar = k.INSTANCE;
        kVar.a(str + " http=200", str3);
        if (feishuApiResponse != null && feishuApiResponse.e()) {
            j jVar = j.INSTANCE;
            boolean zBooleanValue = jVar.m().getValue().booleanValue();
            if (kotlin.jvm.internal.p.d(str, "connect[cancel]")) {
                C4148a.k(TAG, "connect[cancel] ok, await server status=idle to clear", false, 4, null);
                k.b(kVar, "connect[cancel] ok, await server idle", null, 2, null);
                jVar.t(feishuApiResponse.getTraceId());
                G(this, null, null, 3, null);
            } else if (zBooleanValue) {
                NetConnectTaskSnapshot netConnectTaskSnapshot2 = (NetConnectTaskSnapshot) feishuApiResponse.b();
                String status = netConnectTaskSnapshot2 != null ? netConnectTaskSnapshot2.getStatus() : null;
                if (kotlin.jvm.internal.p.d(status, "idle")) {
                    C4148a.k(TAG, "cancel completed: server idle, clearing state", false, 4, null);
                    k.b(kVar, "cancel completed: server idle, clear", null, 2, null);
                    jVar.t(feishuApiResponse.getTraceId());
                    jVar.a();
                } else {
                    String str6 = String.format("%s during cancelling: hold loading, ignore status='%s'", Arrays.copyOf(new Object[]{str, status}, 2));
                    kotlin.jvm.internal.p.h(str6, "format(...)");
                    C4148a.u(TAG, str6, false, 4, null);
                    k.b(kVar, str + " during cancelling: hold loading (status='" + status + "')", null, 2, null);
                    jVar.t(feishuApiResponse.getTraceId());
                }
            } else {
                NetConnectTaskSnapshot netConnectTaskSnapshot3 = (NetConnectTaskSnapshot) feishuApiResponse.b();
                if (x(str, netConnectTaskSnapshot3 != null ? netConnectTaskSnapshot3.getStatus() : null)) {
                    NetConnectTaskSnapshot netConnectTaskSnapshot4 = (NetConnectTaskSnapshot) feishuApiResponse.b();
                    String str7 = String.format("%s blocked idle in user-action window: status='%s' lastUserActionAt=%d", Arrays.copyOf(new Object[]{str, netConnectTaskSnapshot4 != null ? netConnectTaskSnapshot4.getStatus() : null, Long.valueOf(jVar.d())}, 3));
                    kotlin.jvm.internal.p.h(str7, "format(...)");
                    C4148a.u(TAG, str7, false, 4, null);
                    NetConnectTaskSnapshot netConnectTaskSnapshot5 = (NetConnectTaskSnapshot) feishuApiResponse.b();
                    k.b(kVar, str + " blocked idle within 5000ms window (status='" + (netConnectTaskSnapshot5 != null ? netConnectTaskSnapshot5.getStatus() : null) + "')", null, 2, null);
                    jVar.t(feishuApiResponse.getTraceId());
                } else {
                    jVar.t(feishuApiResponse.getTraceId());
                    y((NetConnectTaskSnapshot) feishuApiResponse.b());
                }
            }
        }
        if (w(opName)) {
            j.INSTANCE.p(false);
        }
        if (v(opName)) {
            if (feishuApiResponse == null || !feishuApiResponse.e()) {
                j.INSTANCE.o(false);
            }
        }
    }

    public final boolean v(String opName) {
        return kotlin.jvm.internal.p.d(opName, "connect[cancel]");
    }

    public final boolean w(String opName) {
        return kotlin.jvm.internal.p.d(opName, "connect[enable]") || kotlin.jvm.internal.p.d(opName, "connect[disable]");
    }

    public final boolean x(String opName, String status) {
        if (status != null && !H.x0(status) && !kotlin.jvm.internal.p.d(status, "idle") && !kotlin.jvm.internal.p.d(status, "logout")) {
            return false;
        }
        long jD = j.INSTANCE.d();
        return jD != 0 && SystemClock.elapsedRealtime() - jD < 5000;
    }

    public final void y(NetConnectTaskSnapshot snapshot) {
        NetNextAction nextAction;
        NetNextAction nextAction2;
        String status = snapshot != null ? snapshot.getStatus() : null;
        String url = (snapshot == null || (nextAction2 = snapshot.getNextAction()) == null) ? null : nextAction2.getUrl();
        String type = (snapshot == null || (nextAction = snapshot.getNextAction()) == null) ? null : nextAction.getType();
        String taskId = snapshot != null ? snapshot.getTaskId() : null;
        String envId = snapshot != null ? snapshot.getEnvId() : null;
        String failReason = snapshot != null ? snapshot.getFailReason() : null;
        y yVar = y.f34840a;
        String str = String.format("onStatusSnapshotReceived status=%s nextActionType=%s nextActionUrl=%s taskId=%s envId=%s failReason=%s", Arrays.copyOf(new Object[]{status, type, url, taskId, envId, failReason}, 6));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        String str2 = failReason;
        String str3 = envId;
        j.INSTANCE.s(status, url, type, taskId, str3, str2);
    }

    public final String z(String str) {
        if (str != null && !H.x0(str)) {
            return str;
        }
        String value = j.INSTANCE.b().getValue();
        return value == null ? "" : value;
    }
}
