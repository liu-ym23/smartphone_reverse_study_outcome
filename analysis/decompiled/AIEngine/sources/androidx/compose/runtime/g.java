package androidx.compose.runtime;

import android.content.Context;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.Process;
import android.util.Log;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.widget.y0;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import b.p;
import com.stepos.ability.IAgentServiceManager;
import com.stepos.ability.bean.OriginalTaskConfig;
import com.stepos.ability.bean.TaskConfig;
import com.stepos.aiengine.AIEngineApplication;
import com.stepos.core.ability.config.cloud.AbilityConfigDiff;
import com.stepos.core.ability.dump.AbilityDumpProvider;
import com.stepos.core.common.cloud.RealFileStorageUploadGateway;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogEntry;
import com.stepos.core.common.log.LogLevel;
import com.stepos.core.common.log.LogRingBuffer;
import com.stepos.core.common.telemetry.ModelCallSessionTracker;
import com.stepos.core.ota.OtaContainer;
import com.stepos.core.ota.confirmui.ModelConfirmFlow;
import com.stepos.core.ota.confirmui.OtaAlertDialog;
import com.stepos.core.ota.confirmui.OtaConfirmTrampolineActivity;
import com.stepos.core.ota.crypto.attest.DeviceKeyProbe;
import com.stepos.core.ota.deepbinder.OtaDeepBinderServiceImplKt;
import com.stepos.core.ota.domain.model.ModelManifest;
import com.stepos.core.ota.download.control.ThermalConditionSource;
import com.stepos.deepbinder.core.log.IPCLog;
import gc.q;
import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.collections.EmptyList;
import m7.a;
import n9.b;
import org.json.JSONArray;
import tc.o0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements zb.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f981a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f982b;

    public /* synthetic */ g(AIEngineApplication aIEngineApplication, DropBoxManager dropBoxManager) {
        this.f981a = 4;
        this.f982b = dropBoxManager;
    }

    @Override // zb.l
    public final Object invoke(Object it) {
        OriginalTaskConfig originalTaskConfig;
        Object objA;
        boolean z = false;
        p pVar = null;
        switch (this.f981a) {
            case 0:
                return h.component2$lambda$4((h) this.f982b, ((Double) it).doubleValue());
            case 1:
                return k.component2$lambda$4((k) this.f982b, ((Integer) it).intValue());
            case 2:
                return m.component2$lambda$6((m) this.f982b, it);
            case 3:
                OnBackPressedDispatcher onBackPressedDispatcher = (OnBackPressedDispatcher) this.f982b;
                b.a backEvent = (b.a) it;
                kotlin.jvm.internal.g.f(backEvent, "backEvent");
                if (onBackPressedDispatcher.f202c == null) {
                    mb.k<p> kVar = onBackPressedDispatcher.f201b;
                    ListIterator<p> listIterator = kVar.listIterator(kVar.a());
                    while (true) {
                        if (listIterator.hasPrevious()) {
                            p pVarPrevious = listIterator.previous();
                            if (pVarPrevious.f3026a) {
                                pVar = pVarPrevious;
                            }
                        }
                    }
                }
                return lb.n.f10413a;
            case 4:
                DropBoxManager dropBoxManager = (DropBoxManager) this.f982b;
                a.C0108a report = (a.C0108a) it;
                int i10 = AIEngineApplication.f5748d;
                kotlin.jvm.internal.g.f(report, "report");
                StringBuilder sb2 = new StringBuilder("schema=aiengine.watchdog.v1 thread=");
                sb2.append(report.f10506a);
                sb2.append(" lastFeedMs=");
                sb2.append(report.f10507b);
                sb2.append(" nowMs=");
                sb2.append(report.f10508c);
                String str = report.f10509d;
                if (str.length() > 0) {
                    sb2.append('\n');
                    sb2.append(str);
                }
                String string = sb2.toString();
                if (dropBoxManager != null) {
                    try {
                        dropBoxManager.addText("aiengine_watchdog_kill", string);
                        lb.n nVar = lb.n.f10413a;
                    } catch (Throwable th) {
                        kotlin.c.a(th);
                    }
                }
                Process.killProcess(Process.myPid());
                return lb.n.f10413a;
            case 5:
                return DeviceKeyProbe.probeRsa$lambda$5((byte[]) this.f982b, ((Boolean) it).booleanValue());
            case 6:
                com.stepos.ability.sdk.client.f fVar = (com.stepos.ability.sdk.client.f) this.f982b;
                ((Boolean) it).getClass();
                v5.a aVar = v5.b.f13381a;
                if (com.stepos.ability.sdk.client.d.f5572c != null) {
                    try {
                        if (kotlin.jvm.internal.g.b(fVar.f5589a, "add_task") || kotlin.jvm.internal.g.b(fVar.f5589a, "update_task")) {
                            String str2 = fVar.f5591c;
                            if (str2 != null) {
                                u5.a.f13163a.getClass();
                                try {
                                    objA = q.t0(str2) ? null : (OriginalTaskConfig) u5.a.f13164b.b(OriginalTaskConfig.class, str2);
                                } catch (Throwable th2) {
                                    objA = kotlin.c.a(th2);
                                }
                                if (objA instanceof Result.Failure) {
                                    objA = null;
                                }
                                originalTaskConfig = (OriginalTaskConfig) objA;
                            } else {
                                originalTaskConfig = null;
                            }
                            v5.b.a("submitToolTask OriginalTaskConfig: " + originalTaskConfig);
                            if (originalTaskConfig == null) {
                                aVar.a(6, "Ability_".concat("Ability_AgentServiceClient"), "submitToolTask failed: originalTaskConfig is null", null);
                                return lb.n.f10413a;
                            }
                            v5.b.b("originalTaskConfig.toolName:" + originalTaskConfig.getToolName());
                            String toolName = originalTaskConfig.getToolName();
                            if (toolName == null || toolName.length() == 0 || kotlin.jvm.internal.g.b(originalTaskConfig.getToolName(), "null")) {
                                IAgentServiceManager iAgentServiceManager = com.stepos.ability.sdk.client.d.f5572c;
                                if (iAgentServiceManager != null) {
                                    iAgentServiceManager.toolUpdateTask(jd.b.N(originalTaskConfig));
                                    lb.n nVar2 = lb.n.f10413a;
                                }
                            } else {
                                Bundle bundle = fVar.f5592d.f5588d;
                                if (bundle == null) {
                                    bundle = new Bundle();
                                }
                                String string2 = bundle.getString("session_id");
                                if (string2 == null || string2.length() == 0) {
                                    Log.w("Ability_AgentServiceClient", "SDK Client sessionId is NULL! conversionId=null");
                                } else {
                                    Log.i("Ability_AgentServiceClient", "SDK Client sessionId found: ".concat(string2));
                                }
                                Context context = com.stepos.ability.sdk.client.d.f5571b;
                                if (context == null) {
                                    kotlin.jvm.internal.g.l("context");
                                    throw null;
                                }
                                lb.n nVar3 = lb.n.f10413a;
                                TaskConfig taskConfigO = jd.b.O(originalTaskConfig, context, bundle);
                                v5.b.a("branch1 normal tool call " + taskConfigO);
                                com.stepos.ability.sdk.client.d.f5570a.getClass();
                                com.stepos.ability.sdk.client.d.f(taskConfigO);
                            }
                        } else {
                            aVar.a(3, "Ability_".concat("Ability_AgentServiceClient"), "branch2 normal tool", null);
                            com.stepos.ability.sdk.client.d dVar = com.stepos.ability.sdk.client.d.f5570a;
                            Context context2 = com.stepos.ability.sdk.client.d.f5571b;
                            if (context2 == null) {
                                kotlin.jvm.internal.g.l("context");
                                throw null;
                            }
                            String str3 = fVar.f5590b;
                            com.stepos.ability.sdk.client.e eVar = fVar.f5592d;
                            String str4 = eVar.f5585a;
                            TaskConfig taskConfig = new TaskConfig(str4 == null ? str3 : str4, str3, null, 0, eVar.f5587c, null, null, fVar.f5589a, eVar.f5586b, null, fVar.f5591c, eVar.f5588d, context2.getPackageName(), 0, 8708, null);
                            dVar.getClass();
                            com.stepos.ability.sdk.client.d.f(taskConfig);
                            lb.n nVar4 = lb.n.f10413a;
                        }
                    } catch (Exception e10) {
                        aVar.a(6, "Ability_".concat("Ability_AgentServiceClient"), "submitTask failed", e10);
                        lb.n nVar5 = lb.n.f10413a;
                    }
                } else {
                    aVar.a(6, "Ability_".concat("Ability_AgentServiceClient"), "submitTask failed: service not connected", null);
                }
                return lb.n.f10413a;
            case 7:
                return RealFileStorageUploadGateway.fetchDownloadUrl$lambda$3((zb.l) this.f982b, (o8.d) it);
            case 8:
                return Boolean.valueOf(AIEngineLogger.dumpModuleLogs$lambda$15$lambda$14((LogLevel) this.f982b, (LogEntry) it));
            case 9:
                return Boolean.valueOf(LogRingBuffer.filterLogs$lambda$8$lambda$7((List) this.f982b, (LogEntry) it));
            case 10:
                return Boolean.valueOf(ModelCallSessionTracker.bind$lambda$0((ModelCallSessionTracker.BindContext) this.f982b, (String) it));
            case 11:
                return OtaContainer.init$lambda$9((Context) this.f982b, (ModelManifest) it);
            case 12:
                return ModelConfirmFlow.startResume$lambda$13((ModelConfirmFlow) this.f982b, (Throwable) it);
            case 13:
                return OtaConfirmTrampolineActivity.onCreate$lambda$0((OtaConfirmTrampolineActivity) this.f982b, (OtaAlertDialog) it);
            case 14:
                return Boolean.valueOf(OtaDeepBinderServiceImplKt.totalBytes$lambda$1((Set) this.f982b, (File) it));
            case 15:
                return ThermalConditionSource.observe$lambda$1((zb.a) this.f982b, ((Float) it).floatValue());
            case 16:
                com.stepos.cpuset.b bVar = (com.stepos.cpuset.b) this.f982b;
                kotlin.jvm.internal.g.f(it, "it");
                return bVar.invoke();
            case 17:
                m7.a aVar2 = (m7.a) this.f982b;
                if (((Boolean) it).booleanValue()) {
                    synchronized (m7.c.f10517a) {
                        if (m7.c.f10519c == null) {
                            ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new a6.d(6));
                            ScheduledFuture<?> scheduledFutureScheduleAtFixedRate = scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleAtFixedRate(new y0(aVar2, 13), 1000L, 1000L, TimeUnit.MILLISECONDS);
                            m7.c.f10518b = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
                            m7.c.f10519c = scheduledFutureScheduleAtFixedRate;
                            kotlin.jvm.internal.g.c(scheduledFutureScheduleAtFixedRate);
                        }
                    }
                } else {
                    synchronized (m7.c.f10517a) {
                        try {
                            ScheduledFuture<?> scheduledFuture = m7.c.f10519c;
                            if (scheduledFuture != null) {
                                scheduledFuture.cancel(false);
                            }
                            m7.c.f10519c = null;
                            ScheduledExecutorService scheduledExecutorService = m7.c.f10518b;
                            if (scheduledExecutorService != null) {
                                scheduledExecutorService.shutdown();
                            }
                            m7.c.f10518b = null;
                        } finally {
                        }
                    }
                }
                return lb.n.f10413a;
            case 18:
                mb.d dVar2 = (mb.d) this.f982b;
                Map.Entry it2 = (Map.Entry) it;
                kotlin.jvm.internal.g.f(it2, "it");
                StringBuilder sb3 = new StringBuilder();
                Object key = it2.getKey();
                sb3.append(key == dVar2 ? "(this Map)" : String.valueOf(key));
                sb3.append('=');
                Object value = it2.getValue();
                sb3.append(value != dVar2 ? String.valueOf(value) : "(this Map)");
                return sb3.toString();
            case 19:
                Object obj = this.f982b;
                Map.Entry entry = (Map.Entry) it;
                kotlin.jvm.internal.g.f(entry, "entry");
                if (((b.a) entry.getValue()).a() == obj) {
                    IPCLog.INSTANCE.d("CallbackCache", "[initiative][removeCallback]", "key", entry.getKey());
                    z = true;
                }
                return Boolean.valueOf(z);
            case 20:
                return AbilityConfigDiff.canonical$lambda$8((JSONArray) this.f982b, ((Integer) it).intValue());
            case 21:
                return AbilityDumpProvider.dumpContent$lambda$4$lambda$3$lambda$2((b7.b) this.f982b, (String) it);
            case 22:
                o0 o0Var = (o0) this.f982b;
                rc.a buildSerialDescriptor = (rc.a) it;
                kotlin.jvm.internal.g.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
                EmptyList emptyList = o0Var.f13024b;
                kotlin.jvm.internal.g.f(emptyList, "<set-?>");
                buildSerialDescriptor.f11770b = emptyList;
                return lb.n.f10413a;
            default:
                return Boolean.valueOf(SnapshotStateList.retainAll$lambda$10((Collection) this.f982b, (List) it));
        }
    }

    public /* synthetic */ g(Object obj, int i10) {
        this.f981a = i10;
        this.f982b = obj;
    }
}
