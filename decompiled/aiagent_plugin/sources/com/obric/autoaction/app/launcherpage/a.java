package com.obric.autoaction.app.launcherpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: LauncherPageNavigator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "LauncherPageActivity";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22698a = null;

    static {
        f22698a = new a();
    }

    private a() {
    }

    public final void a(Activity r4, String r5, Bundle r6) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");
        o.e(r3, "activity");
        o.e(r5, "tabTag");
        o.e(r6, "args");
        Intent r7 = new Intent((Context) ZeusTransformUtils.preCheckCast(r3, Context.class, "com.obric.aiagent.plugin"), LauncherPageActivity.class);
        r7.putExtra("tab_tag", r5);
        r7.putExtra("tab_args", r6);
        ZeusTransformUtils.startActivity(r3, r7, "com.obric.aiagent.plugin");
    }
}
