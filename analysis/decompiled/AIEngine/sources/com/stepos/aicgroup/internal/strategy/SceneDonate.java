package com.stepos.aicgroup.internal.strategy;

import android.os.IBinder;
import android.os.ServiceManager;
import android.util.Log;
import com.stepos.scene.ISceneManager;
import com.stepos.scene.entity.SceneState;
import com.stepos.scene.entity.SceneStatus;
import h0.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SceneDonate {
    public static final SceneDonate INSTANCE = new SceneDonate();
    public static final int SCENE_AI_BG = 51004;
    public static final int SCENE_AI_NORMAL = 51003;
    public static final int SCENE_AI_REAL_IMPORTANT = 51002;
    public static final int SCENE_AI_REAL_TIME = 51001;

    public final void donateSceneById(int i10, String statusEnumName) {
        SceneStatus sceneStatus;
        g.f(statusEnumName, "statusEnumName");
        Log.d("SceneDonate", "donateSceneById: sceneId=" + i10 + ", status=" + statusEnumName);
        if (statusEnumName.equals("TRIGGERED")) {
            sceneStatus = SceneStatus.TRIGGERED;
        } else {
            if (!statusEnumName.equals("EXITED")) {
                a0.a.u("donate[sceneId=", i10, "] unknown SceneStatus name: ", statusEnumName, "SceneDonate");
                return;
            }
            sceneStatus = SceneStatus.EXITED;
        }
        try {
            IBinder service = ServiceManager.getService("stepscene");
            if (service == null) {
                Log.w("SceneDonate", "donate[sceneId=" + i10 + "] stepscene service not registered on this device");
                return;
            }
            try {
                ISceneManager iSceneManagerAsInterface = ISceneManager.Stub.asInterface(service);
                if (iSceneManagerAsInterface == null) {
                    Log.w("SceneDonate", "donate[sceneId=" + i10 + "] asInterface returned null");
                    return;
                }
                try {
                    boolean zRegisterSceneState = iSceneManagerAsInterface.registerSceneState(i10, new SceneState(i10, sceneStatus, System.currentTimeMillis()));
                    StringBuilder sbE = e.e("donate[sceneId=", i10, ",status=", statusEnumName, "] succeeded, result=");
                    sbE.append(zRegisterSceneState);
                    Log.i("SceneDonate", sbE.toString());
                } catch (Throwable th) {
                    Log.w("SceneDonate", "donate[sceneId=" + i10 + "] registerSceneState invoke threw", th);
                }
            } catch (Throwable th2) {
                Log.w("SceneDonate", "donate[sceneId=" + i10 + "] ISceneManager.Stub.asInterface failed", th2);
            }
        } catch (Throwable th3) {
            Log.w("SceneDonate", "donate[sceneId=" + i10 + "] ServiceManager.getService(stepscene) failed", th3);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void donateSceneByProcessGroupState(String state, String statusEnumName) {
        int i10;
        g.f(state, "state");
        g.f(statusEnumName, "statusEnumName");
        switch (state.hashCode()) {
            case -1986416409:
                if (state.equals("NORMAL")) {
                    i10 = SCENE_AI_NORMAL;
                    break;
                }
                ai.onnxruntime.a.x("Unknown state: ", state, ", skip donate", "SceneDonate");
                return;
            case -1716897790:
                if (state.equals("IMPORTANT")) {
                    i10 = SCENE_AI_REAL_IMPORTANT;
                    break;
                }
                ai.onnxruntime.a.x("Unknown state: ", state, ", skip donate", "SceneDonate");
                return;
            case -847101650:
                if (state.equals("BACKGROUND")) {
                    i10 = SCENE_AI_BG;
                    break;
                }
                ai.onnxruntime.a.x("Unknown state: ", state, ", skip donate", "SceneDonate");
                return;
            case -76571285:
                if (state.equals("REALTIME")) {
                    i10 = SCENE_AI_REAL_TIME;
                    break;
                }
                ai.onnxruntime.a.x("Unknown state: ", state, ", skip donate", "SceneDonate");
                return;
            default:
                ai.onnxruntime.a.x("Unknown state: ", state, ", skip donate", "SceneDonate");
                return;
        }
        donateSceneById(i10, statusEnumName);
    }
}
