package com.obric.aivoice.core.data;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.obric.aivoice.core.AIVoiceManagerInner;
import com.obric.aivoice.sdk.AIVoiceConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BundleExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\u0006*\u00020\u0002\u001a\n\u0010\b\u001a\u00020\u0006*\u00020\u0002\u001a\n\u0010\t\u001a\u00020\u0006*\u00020\u0002\u001a'\u0010\n\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u000b*\u00020\u00022\u0006\u0010\f\u001a\u0002H\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000f\u001a\u001e\u0010\u0010\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0001\u001a\u0012\u0010\u0013\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0001\u001a\u001a\u0010\u0015\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001\u001a\u001a\u0010\u0017\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001¨\u0006\u0019"}, d2 = {"getModelName", "", "Landroid/os/Bundle;", "getTaskId", "", "isError", "", "isFinish", "isSuccess", "isTaskId", "setBasicTypeRes", ExifInterface.GPS_DIRECTION_TRUE, "data", "code", "", "(Landroid/os/Bundle;Ljava/lang/Object;I)Landroid/os/Bundle;", "setBizCall", "bizName", "fromPkgName", "setGlobalCall", "methodName", "setModelCall", "modelName", "setSceneCall", "sceneName", "voicesdk_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BundleExtKt {
    public static final Bundle setGlobalCall(Bundle r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "methodName");
        r3.putLong("_Time", SystemClock.elapsedRealtime());
        r3.putString("_CT", "_CallGlobal");
        r3.putString("_M", r4);
        AIVoiceConfig r5 = AIVoiceManagerInner.INSTANCE.getAiVoiceConfig();
        if (r5 == null) goto L5;
        r3.putLong(IdlKeys.Args_ProjectId, r5.getProjectId());
        r3.putLong("_AppId", r5.getAppId());
        r3.putString("_PackageName", r5.getPackageName());
    L5:
        return r3;
    }

    public static final Bundle setModelCall(Bundle r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "modelName");
        Intrinsics.checkNotNullParameter(r6, "methodName");
        r4.putLong("_Time", SystemClock.elapsedRealtime());
        r4.putString("_CT", "_CallModel");
        AIVoiceConfig r0 = AIVoiceManagerInner.INSTANCE.getAiVoiceConfig();
        if (r0 == null) goto L5;
        r4.putLong(IdlKeys.Args_ProjectId, r0.getProjectId());
        r4.putLong("_AppId", r0.getAppId());
        r4.putString("_PackageName", r0.getPackageName());
    L5:
        r4.putString("_ModelName", r5);
        r4.putString("_M", r6);
        return r4;
    }

    public static /* synthetic */ Bundle setBizCall$default(Bundle r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L9;
        AIVoiceConfig r5 = AIVoiceManagerInner.INSTANCE.getAiVoiceConfig();
        if (r5 == null) goto L7;
        r2 = r5.getPackageName();
        goto L9
    L7:
        r2 = null;
    L9:
        return setBizCall(r0, r1, r2);
    }

    public static final Bundle setBizCall(Bundle r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "bizName");
        r2.putString("_CT", "_CallBiz");
        r2.putString("_M", "_RunBiz");
        r2.putString("_BizName", r3);
        r2.putString("_PackageName", r4);
        return r2;
    }

    public static final Bundle setSceneCall(Bundle r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "sceneName");
        Intrinsics.checkNotNullParameter(r6, "methodName");
        r4.putString("_CT", "_CallScene");
        AIVoiceConfig r0 = AIVoiceManagerInner.INSTANCE.getAiVoiceConfig();
        if (r0 == null) goto L5;
        r4.putLong(IdlKeys.Args_ProjectId, r0.getProjectId());
        r4.putLong("_AppId", r0.getAppId());
        r4.putString("_PackageName", r0.getPackageName());
    L5:
        r4.putString("_ModelScene", r5);
        r4.putString("_M", r6);
        return r4;
    }

    public static /* synthetic */ Bundle setBasicTypeRes$default(Bundle r0, Object r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        return setBasicTypeRes(r0, r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Bundle setBasicTypeRes(Bundle r2, T r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.putInt("_EC", r4);
        r2.putString("_EI", null);
        boolean r0 = true;
        if (r4 != 1) goto L6;
        r0 = false;
    L6:
        r2.putBoolean("_IF", r0);
        if ((r3 instanceof Integer) == false) goto L10;
        r2.putInt("_R", ((Number) r3).intValue());
    L39:
        return r2;
    L10:
        if ((r3 instanceof int[]) == false) goto L13;
        r2.putIntArray("_R", (int[]) r3);
        goto L39
    L13:
        if ((r3 instanceof Float) == false) goto L16;
        r2.putFloat("_R", ((Number) r3).floatValue());
        goto L39
    L16:
        if ((r3 instanceof float[]) == false) goto L19;
        r2.putFloatArray("_R", (float[]) r3);
        goto L39
    L19:
        if ((r3 instanceof String) == false) goto L22;
        r2.putString("_R", (String) r3);
        goto L39
    L22:
        if ((r3 instanceof Byte) == false) goto L25;
        r2.putByte("_R", ((Number) r3).byteValue());
        goto L39
    L25:
        if ((r3 instanceof byte[]) == false) goto L28;
        r2.putByteArray("_R", (byte[]) r3);
        goto L39
    L28:
        if ((r3 instanceof Character) == false) goto L31;
        r2.putChar("_R", ((Character) r3).charValue());
        goto L39
    L31:
        if ((r3 instanceof char[]) == false) goto L34;
        r2.putCharArray("_R", (char[]) r3);
        goto L39
    L34:
        if ((r3 instanceof Boolean) == false) goto L37;
        r2.putBoolean("_R", ((Boolean) r3).booleanValue());
        goto L39
    L37:
        if ((r3 instanceof boolean[]) == false) goto L39;
        r2.putBooleanArray("_R", (boolean[]) r3);
        goto L39
    }

    public static final boolean isTaskId(Bundle r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.getBoolean("_IT");
    }

    public static final long getTaskId(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return r2.getLong("_R");
    }

    public static final String getModelName(Bundle r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.getString("_ModelName");
    }

    public static final boolean isSuccess(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r3 = r2.getInt("_EC", 0);
        if (r3 == 0) goto L6;
        if (r3 == 1) goto L6;
        return false;
    L6:
        return true;
    }

    public static final boolean isError(Bundle r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return !isSuccess(r1);
    }

    public static final boolean isFinish(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return r2.getBoolean("_IF", true);
    }
}
