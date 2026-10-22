package com.bytedance.android.livesdk.chatroom.viewmodule.shortterm;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.sti.framework.IShortTouchLifeCycle;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements IShortTouchLifeCycle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f115539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f115540b;

    @Override // com.bytedance.android.livesdkapi.sti.framework.IShortTouchLifeCycle
    public final void onPause() {
        IShortTouchLifeCycle.DefaultImpls.onPause(this);
        ALogger.d("CommonHybridComponent", "on pause");
        new JSONObject().put("visible", false);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IShortTouchLifeCycle
    public final void onResume() {
        IShortTouchLifeCycle.DefaultImpls.onResume(this);
        ALogger.d("CommonHybridComponent", "on resume");
        new JSONObject().put("visible", true);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public final Context getContext() {
        return this.f115539a;
    }

    public e(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f115539a = r100;
        this.f115540b = r101;
    }
}
