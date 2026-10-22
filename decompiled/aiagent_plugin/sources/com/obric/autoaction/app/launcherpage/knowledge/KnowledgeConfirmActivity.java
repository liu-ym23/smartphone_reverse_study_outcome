package com.obric.autoaction.app.launcherpage.knowledge;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.view.ai;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.common.base.BaseActivity;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: KnowledgeConfirmActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KnowledgeConfirmActivity extends BaseActivity {
    private static final int CLARIFY_COUNT = 2;
    public static final a Companion = null;
    private static final String TAG = "KnowledgeConfirm";
    private static final long TIMEOUT_MS = 20000;
    private final Handler handler;
    private final Runnable timeoutRunnable;

    /* JADX INFO: compiled from: KnowledgeConfirmActivity.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ x lambda$2I5pXzUvQY1y_HVVvxHSkVCz9WM(KnowledgeConfirmActivity r0, DialogInterface r1, int r2) {
        return onResume$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$CB4vME27VRdTPWyHdFRu3n9vCps(KnowledgeConfirmActivity r0) {
        timeoutRunnable$lambda$0(r0);
    }

    public static /* synthetic */ x lambda$jsZEj_iGvA1Tc6LAP823eDDWgNE(KnowledgeConfirmActivity r0, DialogInterface r1, int r2) {
        return onResume$lambda$2(r0, r1, r2);
    }

    public KnowledgeConfirmActivity() {
        this.handler = new Handler(Looper.getMainLooper());
        this.timeoutRunnable = new $$Lambda$KnowledgeConfirmActivity$CB4vME27VRdTPWyHdFRu3n9vCps(this);
    }

    private static final void timeoutRunnable$lambda$0(KnowledgeConfirmActivity r3) {
        KnowledgeConfirmActivity r4 = (KnowledgeConfirmActivity) ZeusTransformUtils.wrapperContextForParams(r3, KnowledgeConfirmActivity.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d(TAG, "User interaction timed out, auto-dismissing.");
        r4.finish();
    }

    @Override // com.obric.autoaction.common.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        ai.a(getWindow(), false);
        getWindow().setStatusBarColor(0);
    }

    @Override // com.obric.autoaction.common.base.BaseActivity, androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        this.handler.removeCallbacks(this.timeoutRunnable);
        this.handler.postDelayed(this.timeoutRunnable, TIMEOUT_MS);
        com.obric.oui.dialog.v2.alert.a r0 = com.obric.oui.dialog.v2.alert.a.a(new com.obric.oui.dialog.v2.alert.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin")).b(false), (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.knowledge_confirm_dialog_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "knowledge_confirm_dialog_title")), CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null).a((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.knowledge_confirm_dialog_content, WsChannelMultiProcessSharedProvider.STRING_TYPE, "knowledge_confirm_dialog_content"), new Object[]{getIntent().getStringExtra("knowledge")}), CharSequence.class, "com.obric.aiagent.plugin"));
        String r1 = getString(ZeusTransformUtils.mapRes(R.string.knowledge_confirm_positivty_btn, WsChannelMultiProcessSharedProvider.STRING_TYPE, "knowledge_confirm_positivty_btn"));
        o.c(r1, "getString(...)");
        com.obric.oui.dialog.v2.alert.a r2 = r0.a((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), new $$Lambda$KnowledgeConfirmActivity$2I5pXzUvQY1y_HVVvxHSkVCz9WM(this));
        String r3 = getString(ZeusTransformUtils.mapRes(R.string.knowledge_confirm_negative_btn, WsChannelMultiProcessSharedProvider.STRING_TYPE, "knowledge_confirm_negative_btn"));
        o.c(r3, "getString(...)");
        r2.b((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"), new $$Lambda$KnowledgeConfirmActivity$jsZEj_iGvA1Tc6LAP823eDDWgNE(this)).h();
    }

    private static final x onResume$lambda$1(KnowledgeConfirmActivity r1, DialogInterface r2, int r3) {
        KnowledgeConfirmActivity r4 = (KnowledgeConfirmActivity) ZeusTransformUtils.wrapperContextForParams(r1, KnowledgeConfirmActivity.class, "com.obric.aiagent.plugin");
        o.e((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.aiagent.plugin"), "dialog");
        r4.handler.removeCallbacks(r4.timeoutRunnable);
        r4.setResult(true);
        r4.finish();
        return x.f38692a;
    }

    private static final x onResume$lambda$2(KnowledgeConfirmActivity r1, DialogInterface r2, int r3) {
        KnowledgeConfirmActivity r4 = (KnowledgeConfirmActivity) ZeusTransformUtils.wrapperContextForParams(r1, KnowledgeConfirmActivity.class, "com.obric.aiagent.plugin");
        o.e((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.aiagent.plugin"), "dialog");
        r4.handler.removeCallbacks(r4.timeoutRunnable);
        r4.setResult(false);
        r4.finish();
        return x.f38692a;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStop() {
        super.onStop();
        setResult(false);
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacks(this.timeoutRunnable);
    }

    private final void setResult(Boolean r3) {
        defpackage.a r0 = defpackage.a.f0a;
        String r2 = getIntent().getStringExtra("result_key");
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r0.a(r2, r3);
    }
}
