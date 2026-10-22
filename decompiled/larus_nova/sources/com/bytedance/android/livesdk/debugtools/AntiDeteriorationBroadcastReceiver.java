package com.bytedance.android.livesdk.debugtools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.android.livesdk.utils.v5;
import com.ss.alog.middleware.ALogService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/debugtools/AntiDeteriorationBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AntiDeteriorationBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f121937b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f121938a;

    public static final class a {
    }

    static {
    }

    public AntiDeteriorationBroadcastReceiver() {
        this.f121938a = "AntiDeterioration";
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r101 != null) goto L4;
    L12:
        ALogService.eSafely(this.f121938a, "onReceive");
        return;
    L4:
        if ("android.intent.action.ANTI_DETERIORATION".equals(r101.getAction()) == false) goto L12;
        Bundle r102 = r101.getExtras();
        if (r102 == null) goto L8;
        Object r103 = r102.get("key");
    L10:
        if (Intrinsics.areEqual(r103, "enter_room") == false) goto L12;
        v5.a().putBoolean("live.enter.room.key", true).apply();
        FileUtils.a();
        ALogService.eSafely(this.f121938a, "enter_room 开关已经打开");
        goto L12
    L8:
        r103 = null;
        goto L10
    }
}
