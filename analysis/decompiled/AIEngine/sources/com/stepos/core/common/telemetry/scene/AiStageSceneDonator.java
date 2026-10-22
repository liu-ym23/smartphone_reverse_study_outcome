package com.stepos.core.common.telemetry.scene;

import android.app.Application;
import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import android.os.collector.scene.StepOSPerfSceneData;
import android.util.Log;
import com.stepos.aicgroup.d;
import com.stepos.aicgroup.e;
import com.stepos.scene.SceneManager;
import com.stepos.scene.entity.SceneState;
import com.stepos.scene.entity.SceneStatus;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.n;
import zb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AiStageSceneDonator {
    private static final long EXIT_RETRY_DELAY_MS = 1000;
    private static final int SCENE_DECRYPT_BG = 51201;
    private static final int SCENE_DECRYPT_FG = 51101;
    private static final int SCENE_LOAD_BG = 51201;
    private static final int SCENE_LOAD_FG = 51101;
    private static final String SERVICE = "stepscene";
    private static final String TAG = "SceneDonator";
    private static volatile p<? super Integer, ? super Boolean, n> submissionObserverForTest;
    public static final AiStageSceneDonator INSTANCE = new AiStageSceneDonator();
    private static final AtomicReference<Context> appCtx = new AtomicReference<>(null);
    private static final IBinder token = new Binder();
    private static final AtomicBoolean donorOpened = new AtomicBoolean(false);
    private static final ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor(new d(5));

    private AiStageSceneDonator() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean deliver(int i10, boolean z, String str, l<? super StepOSPerfSceneData, n> lVar) {
        Object objA;
        SceneManager sceneManagerResolveManager = resolveManager();
        if (sceneManagerResolveManager == null) {
            Log.w(TAG, "stepscene service unavailable sceneId=" + i10);
            return false;
        }
        if (!donorOpened.get()) {
            try {
                objA = Boolean.valueOf(sceneManagerResolveManager.openSceneDonor(token));
            } catch (Throwable th) {
                objA = c.a(th);
            }
            Object obj = Boolean.FALSE;
            if (objA instanceof Result.Failure) {
                objA = obj;
            }
            boolean zBooleanValue = ((Boolean) objA).booleanValue();
            donorOpened.set(zBooleanValue);
            if (!zBooleanValue) {
                Log.w(TAG, "openSceneDonor retry failed; drop sceneId=" + i10);
                return false;
            }
        }
        StepOSPerfSceneData stepOSPerfSceneData = new StepOSPerfSceneData(i10);
        stepOSPerfSceneData.mData.putString("donationKey", str);
        lVar.invoke(stepOSPerfSceneData);
        SceneStatus sceneStatus = z ? SceneStatus.TRIGGERED : SceneStatus.EXITED;
        boolean zDonateScene = sceneManagerResolveManager.donateScene(token, i10, new SceneState(i10, sceneStatus, System.currentTimeMillis(), stepOSPerfSceneData));
        if (!zDonateScene) {
            Log.w(TAG, "donateScene returned false sceneId=" + i10 + " status=" + sceneStatus + " key=" + str);
        }
        return zDonateScene;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$2() {
        try {
            SceneManager sceneManagerResolveManager = INSTANCE.resolveManager();
            if (sceneManagerResolveManager == null) {
                Log.w(TAG, "init: SceneManager unavailable (getSystemService returned null)");
                return;
            }
            boolean zOpenSceneDonor = sceneManagerResolveManager.openSceneDonor(token);
            donorOpened.set(zOpenSceneDonor);
            if (zOpenSceneDonor) {
                Log.i(TAG, "init: openSceneDonor OK, ready to donate scenes");
            } else {
                Log.w(TAG, "openSceneDonor returned false; scene donation will be rejected");
            }
        } catch (Throwable th) {
            a0.a.A("openSceneDonor failed: ", th.getMessage(), TAG);
        }
    }

    private final SceneManager resolveManager() {
        Context context = appCtx.get();
        if (context == null) {
            return null;
        }
        try {
            Object systemService = context.getSystemService(SERVICE);
            if (systemService instanceof SceneManager) {
                return (SceneManager) systemService;
            }
            return null;
        } catch (Throwable th) {
            a0.a.A("getSystemService(stepscene) failed: ", th.getMessage(), TAG);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleExitRetry(int i10, String str) {
        try {
            worker.schedule(new a(i10, str), 1000L, TimeUnit.MILLISECONDS);
            Log.w(TAG, "EXITED delivery failed, retry scheduled sceneId=" + i10 + " key=" + str);
        } catch (Throwable th) {
            a0.a.u("EXITED retry schedule rejected sceneId=", i10, ": ", th.getMessage(), TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleExitRetry$lambda$11(int i10, String str) {
        boolean zDeliver = false;
        try {
            zDeliver = INSTANCE.deliver(i10, false, str, new com.stepos.core.common.telemetry.b(3));
        } catch (Throwable th) {
            a0.a.u("EXITED retry threw sceneId=", i10, ": ", th.getMessage(), TAG);
        }
        if (zDeliver) {
            return;
        }
        a0.a.u("EXITED retry failed, giving up sceneId=", i10, " key=", str, TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n scheduleExitRetry$lambda$11$lambda$10(StepOSPerfSceneData it) {
        g.f(it, "it");
        return n.f10413a;
    }

    private final void submit(final int i10, final boolean z, final String str, final l<? super StepOSPerfSceneData, n> lVar) {
        try {
            p<? super Integer, ? super Boolean, n> pVar = submissionObserverForTest;
            if (pVar != null) {
                pVar.invoke(Integer.valueOf(i10), Boolean.valueOf(z));
            } else {
                if (appCtx.get() == null) {
                    return;
                }
                worker.execute(new Runnable() { // from class: com.stepos.core.common.telemetry.scene.AiStageSceneDonator.submit.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        boolean zDeliver;
                        try {
                            AiStageSceneDonator aiStageSceneDonator = AiStageSceneDonator.INSTANCE;
                            int i11 = i10;
                            boolean z3 = z;
                            String str2 = str;
                            final l<StepOSPerfSceneData, n> lVar2 = lVar;
                            zDeliver = aiStageSceneDonator.deliver(i11, z3, str2, new l<StepOSPerfSceneData, n>() { // from class: com.stepos.core.common.telemetry.scene.AiStageSceneDonator$submit$2$delivered$1
                                @Override // zb.l
                                public /* bridge */ /* synthetic */ n invoke(StepOSPerfSceneData stepOSPerfSceneData) {
                                    invoke2(stepOSPerfSceneData);
                                    return n.f10413a;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(StepOSPerfSceneData it) {
                                    g.f(it, "it");
                                    lVar2.invoke(it);
                                }
                            });
                        } catch (Throwable th) {
                            Log.w(AiStageSceneDonator.TAG, "donate failed sceneId=" + i10 + " triggered=" + z + ": " + th.getMessage());
                            zDeliver = false;
                        }
                        if (zDeliver || z) {
                            return;
                        }
                        AiStageSceneDonator.INSTANCE.scheduleExitRetry(i10, str);
                    }
                });
            }
        } catch (Throwable th) {
            a0.a.u("submit rejected sceneId=", i10, ": ", th.getMessage(), TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread worker$lambda$1(Runnable runnable) {
        return com.stepos.core.ota.d.n(runnable, TAG, true);
    }

    public final p<Integer, Boolean, n> getSubmissionObserverForTest$common_release() {
        return submissionObserverForTest;
    }

    public final void init(Application app) {
        g.f(app, "app");
        AtomicReference<Context> atomicReference = appCtx;
        Context applicationContext = app.getApplicationContext();
        while (!atomicReference.compareAndSet(null, applicationContext)) {
            if (atomicReference.get() != null) {
                return;
            }
        }
        Log.i(TAG, "init: appCtx set, submitting openSceneDonor handshake");
        worker.execute(new e(1));
    }

    public final void onDecrypt(boolean z, final boolean z3, final String modelName) {
        g.f(modelName, "modelName");
        final int i10 = z ? 51101 : 51201;
        try {
            p<? super Integer, ? super Boolean, n> pVar = submissionObserverForTest;
            if (pVar != null) {
                pVar.invoke(Integer.valueOf(i10), Boolean.valueOf(z3));
            } else if (appCtx.get() != null) {
                worker.execute(new Runnable() { // from class: com.stepos.core.common.telemetry.scene.AiStageSceneDonator$onDecrypt$$inlined$submit$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        boolean zDeliver;
                        try {
                            zDeliver = AiStageSceneDonator.INSTANCE.deliver(i10, z3, modelName, new l<StepOSPerfSceneData, n>() { // from class: com.stepos.core.common.telemetry.scene.AiStageSceneDonator$onDecrypt$$inlined$submit$1.1
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(StepOSPerfSceneData it) {
                                    g.f(it, "it");
                                }

                                @Override // zb.l
                                public /* bridge */ /* synthetic */ n invoke(StepOSPerfSceneData stepOSPerfSceneData) {
                                    invoke2(stepOSPerfSceneData);
                                    return n.f10413a;
                                }
                            });
                        } catch (Throwable th) {
                            Log.w("SceneDonator", "donate failed sceneId=" + i10 + " triggered=" + z3 + ": " + th.getMessage());
                            zDeliver = false;
                        }
                        if (zDeliver || z3) {
                            return;
                        }
                        AiStageSceneDonator.INSTANCE.scheduleExitRetry(i10, modelName);
                    }
                });
            }
        } catch (Throwable th) {
            a0.a.u("submit rejected sceneId=", i10, ": ", th.getMessage(), TAG);
        }
    }

    public final void onLoading(boolean z, final boolean z3, final String modelName, final int i10) {
        g.f(modelName, "modelName");
        final int i11 = z ? 51101 : 51201;
        try {
            p<? super Integer, ? super Boolean, n> pVar = submissionObserverForTest;
            if (pVar != null) {
                pVar.invoke(Integer.valueOf(i11), Boolean.valueOf(z3));
            } else if (appCtx.get() != null) {
                worker.execute(new Runnable() { // from class: com.stepos.core.common.telemetry.scene.AiStageSceneDonator$onLoading$$inlined$submit$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        boolean zDeliver;
                        try {
                            AiStageSceneDonator aiStageSceneDonator = AiStageSceneDonator.INSTANCE;
                            int i12 = i11;
                            boolean z10 = z3;
                            String str = modelName;
                            final boolean z11 = z3;
                            final int i13 = i10;
                            zDeliver = aiStageSceneDonator.deliver(i12, z10, str, new l<StepOSPerfSceneData, n>() { // from class: com.stepos.core.common.telemetry.scene.AiStageSceneDonator$onLoading$$inlined$submit$1.1
                                @Override // zb.l
                                public /* bridge */ /* synthetic */ n invoke(StepOSPerfSceneData stepOSPerfSceneData) {
                                    invoke2(stepOSPerfSceneData);
                                    return n.f10413a;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(StepOSPerfSceneData it) {
                                    g.f(it, "it");
                                    if (z11) {
                                        it.mData.putInt("uid", Process.myUid());
                                        int i14 = i13;
                                        if (i14 >= 0) {
                                            it.mData.putInt("reclaim_memory_mb", i14);
                                        }
                                    }
                                }
                            });
                        } catch (Throwable th) {
                            Log.w("SceneDonator", "donate failed sceneId=" + i11 + " triggered=" + z3 + ": " + th.getMessage());
                            zDeliver = false;
                        }
                        if (zDeliver || z3) {
                            return;
                        }
                        AiStageSceneDonator.INSTANCE.scheduleExitRetry(i11, modelName);
                    }
                });
            }
        } catch (Throwable th) {
            a0.a.u("submit rejected sceneId=", i11, ": ", th.getMessage(), TAG);
        }
    }

    public final void onStage(int i10, boolean z, final String modelName) {
        g.f(modelName, "modelName");
        Pair<Integer, Boolean> pairStageMap$common_release = stageMap$common_release(i10);
        if (pairStageMap$common_release == null) {
            return;
        }
        final int iIntValue = pairStageMap$common_release.f9985a.intValue();
        Boolean bool = pairStageMap$common_release.f9986b;
        final boolean zBooleanValue = bool.booleanValue();
        if (!z) {
            iIntValue += 100;
        }
        try {
            p<? super Integer, ? super Boolean, n> pVar = submissionObserverForTest;
            if (pVar != null) {
                pVar.invoke(Integer.valueOf(iIntValue), bool);
            } else if (appCtx.get() != null) {
                worker.execute(new Runnable() { // from class: com.stepos.core.common.telemetry.scene.AiStageSceneDonator$onStage$$inlined$submit$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        boolean zDeliver;
                        try {
                            zDeliver = AiStageSceneDonator.INSTANCE.deliver(iIntValue, zBooleanValue, modelName, new l<StepOSPerfSceneData, n>() { // from class: com.stepos.core.common.telemetry.scene.AiStageSceneDonator$onStage$$inlined$submit$1.1
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(StepOSPerfSceneData it) {
                                    g.f(it, "it");
                                }

                                @Override // zb.l
                                public /* bridge */ /* synthetic */ n invoke(StepOSPerfSceneData stepOSPerfSceneData) {
                                    invoke2(stepOSPerfSceneData);
                                    return n.f10413a;
                                }
                            });
                        } catch (Throwable th) {
                            Log.w("SceneDonator", "donate failed sceneId=" + iIntValue + " triggered=" + zBooleanValue + ": " + th.getMessage());
                            zDeliver = false;
                        }
                        if (zDeliver || zBooleanValue) {
                            return;
                        }
                        AiStageSceneDonator.INSTANCE.scheduleExitRetry(iIntValue, modelName);
                    }
                });
            }
        } catch (Throwable th) {
            a0.a.u("submit rejected sceneId=", iIntValue, ": ", th.getMessage(), TAG);
        }
    }

    public final void onStageAbort(final int i10, boolean z, final String modelName) {
        g.f(modelName, "modelName");
        if (!z) {
            i10 += 100;
        }
        a0.a.u("onStageAbort: compensating EXITED sceneId=", i10, " key=", modelName, TAG);
        try {
            p<? super Integer, ? super Boolean, n> pVar = submissionObserverForTest;
            if (pVar != null) {
                pVar.invoke(Integer.valueOf(i10), Boolean.FALSE);
            } else if (appCtx.get() != null) {
                final boolean z3 = false;
                worker.execute(new Runnable() { // from class: com.stepos.core.common.telemetry.scene.AiStageSceneDonator$onStageAbort$$inlined$submit$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        boolean zDeliver;
                        try {
                            zDeliver = AiStageSceneDonator.INSTANCE.deliver(i10, z3, modelName, new l<StepOSPerfSceneData, n>() { // from class: com.stepos.core.common.telemetry.scene.AiStageSceneDonator$onStageAbort$$inlined$submit$1.1
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(StepOSPerfSceneData it) {
                                    g.f(it, "it");
                                }

                                @Override // zb.l
                                public /* bridge */ /* synthetic */ n invoke(StepOSPerfSceneData stepOSPerfSceneData) {
                                    invoke2(stepOSPerfSceneData);
                                    return n.f10413a;
                                }
                            });
                        } catch (Throwable th) {
                            Log.w("SceneDonator", "donate failed sceneId=" + i10 + " triggered=" + z3 + ": " + th.getMessage());
                            zDeliver = false;
                        }
                        if (zDeliver || z3) {
                            return;
                        }
                        AiStageSceneDonator.INSTANCE.scheduleExitRetry(i10, modelName);
                    }
                });
            }
        } catch (Throwable th) {
            a0.a.u("submit rejected sceneId=", i10, ": ", th.getMessage(), TAG);
        }
    }

    public final void setSubmissionObserverForTest$common_release(p<? super Integer, ? super Boolean, n> pVar) {
        submissionObserverForTest = pVar;
    }

    public final Pair<Integer, Boolean> stageMap$common_release(int i10) {
        if (i10 == 2000) {
            return new Pair<>(51111, Boolean.TRUE);
        }
        if (i10 == 2100) {
            return new Pair<>(51118, Boolean.TRUE);
        }
        if (i10 == 2102) {
            return new Pair<>(51118, Boolean.FALSE);
        }
        if (i10 == 3000) {
            return new Pair<>(51113, Boolean.TRUE);
        }
        if (i10 == 3005) {
            return new Pair<>(51114, Boolean.FALSE);
        }
        if (i10 == 4000) {
            return new Pair<>(51115, Boolean.TRUE);
        }
        if (i10 == 4002) {
            return new Pair<>(51115, Boolean.FALSE);
        }
        if (i10 == 3002) {
            return new Pair<>(51113, Boolean.FALSE);
        }
        if (i10 == 3003) {
            return new Pair<>(51114, Boolean.TRUE);
        }
        if (i10 == 5000) {
            return new Pair<>(51116, Boolean.TRUE);
        }
        if (i10 == 5001) {
            return new Pair<>(51116, Boolean.FALSE);
        }
        if (i10 == 6000) {
            return new Pair<>(51117, Boolean.TRUE);
        }
        if (i10 == 6001) {
            return new Pair<>(51117, Boolean.FALSE);
        }
        switch (i10) {
            case 2002:
                return new Pair<>(51111, Boolean.FALSE);
            case 2003:
                return new Pair<>(51112, Boolean.TRUE);
            case 2004:
                return new Pair<>(51112, Boolean.FALSE);
            default:
                return null;
        }
    }
}
