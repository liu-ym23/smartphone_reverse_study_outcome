package com.obric.autoaction.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.obric.autoaction.common.base.BaseActivity;
import com.obric.autoaction.vdplayer.VDPlayerActivity;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: VDPlayerRouterActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class VDPlayerRouterActivity extends BaseActivity {
    public static final a Companion = null;
    private static final String TAG = "VDPlayerRouterActivity";

    /* JADX INFO: compiled from: VDPlayerRouterActivity.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public VDPlayerRouterActivity() {
    }

    @Override // com.obric.autoaction.common.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r5) {
        super.onCreate(r5);
        if (com.obric.autogui.common.a.d.f28974a.g() == false) goto L5;
        Class<?> r6 = VDPlayerActivity.class;
    L6:
        Loog.INSTANCE.d(TAG, "onCreate current ui mode: " + ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getConfiguration().uiMode);
        Intent r1 = new Intent(getIntent());
        r1.setClass((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), r6);
        if (o.a(r6, VDPlayerActivity.class) == false) goto L9;
        r1.putExtra("source_from", "virtual_screen");
    L9:
        ZeusTransformUtils.startActivity(this, r1, "com.obric.aiagent.plugin");
        finish();
        overridePendingTransition(0, 0);
        return;
    L5:
        r6 = SurfaceCardActivity.class;
        goto L6
    }
}
