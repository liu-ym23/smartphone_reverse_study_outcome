package com.stepos.core.common.telemetry.scene;

import android.content.Context;
import android.os.Bundle;
import android.os.collector.scene.StepOSPerfSceneData;
import android.util.Log;
import com.stepos.scene.SceneManager;
import com.stepos.scene.entity.SceneState;
import com.stepos.scene.entity.SceneStatus;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.n;
import mb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CameraSceneSubscriber {
    public static final CameraSceneSubscriber INSTANCE = new CameraSceneSubscriber();
    private static final String SERVICE = "stepscene";
    private static final String TAG = "CameraSceneSub";

    private CameraSceneSubscriber() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void subscribe$lambda$0(p pVar, SceneState sceneState) {
        Bundle bundle;
        if (sceneState == null) {
            return;
        }
        try {
            if (sceneState.getStatus() != SceneStatus.TRIGGERED) {
                return;
            }
            StepOSPerfSceneData sceneEntity = sceneState.getSceneEntity();
            StepOSPerfSceneData stepOSPerfSceneData = sceneEntity instanceof StepOSPerfSceneData ? sceneEntity : null;
            int i10 = -1;
            if (stepOSPerfSceneData != null && (bundle = stepOSPerfSceneData.mData) != null) {
                i10 = bundle.getInt("uid", -1);
            }
            pVar.invoke(Integer.valueOf(sceneState.getSceneId()), Integer.valueOf(i10));
        } catch (Throwable th) {
            a0.a.A("scene callback failed: ", th.getMessage(), TAG);
        }
    }

    public final boolean subscribe(Context context, int[] sceneIds, final p<? super Integer, ? super Integer, n> onTriggered) {
        Object objA;
        g.f(context, "context");
        g.f(sceneIds, "sceneIds");
        g.f(onTriggered, "onTriggered");
        try {
            Object systemService = context.getSystemService(SERVICE);
            SceneManager sceneManager = systemService instanceof SceneManager ? (SceneManager) systemService : null;
            if (sceneManager == null) {
                Log.w(TAG, "stepscene service unavailable, scene subscribe skipped");
                return false;
            }
            SceneManager.SceneCallback sceneCallback = new SceneManager.SceneCallback() { // from class: com.stepos.core.common.telemetry.scene.b
                public final void onSceneStateUpdate(SceneState sceneState) {
                    CameraSceneSubscriber.subscribe$lambda$0(onTriggered, sceneState);
                }
            };
            boolean z = true;
            for (int i10 : sceneIds) {
                try {
                    objA = Boolean.valueOf(sceneManager.registerSceneListener(i10, sceneCallback));
                } catch (Throwable th) {
                    objA = c.a(th);
                }
                Object obj = Boolean.FALSE;
                if (objA instanceof Result.Failure) {
                    objA = obj;
                }
                if (!((Boolean) objA).booleanValue()) {
                    Log.w(TAG, "registerSceneListener(" + i10 + ") failed");
                    z = false;
                }
            }
            if (z) {
                Log.i(TAG, "subscribed scenes=" + l.p0(sceneIds));
            }
            return z;
        } catch (Throwable th2) {
            a0.a.A("subscribe failed: ", th2.getMessage(), TAG);
            return false;
        }
    }
}
