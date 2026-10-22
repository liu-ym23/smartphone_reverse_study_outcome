package com.obric.common.upgrade;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import com.bytedance.ies.common.cpp_shared.BuildConfig;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.device.AODeviceInfo;
import com.obric.autogui.tools.api.IAutoActionAppUpgradeApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AppUpgradeImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AppUpgradeImpl implements IAutoActionAppUpgradeApi {
    public static final a Companion = null;
    private static final String TAG = "AutoUpgradeImpl";
    private boolean isUpgradeInited;
    private d mAppUpgradeHelper;

    /* JADX INFO: compiled from: AppUpgradeImpl.kt */
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

    @Override // com.obric.autogui.tools.api.IAutoActionAppUpgradeApi
    public void initAppUpgrade() {
    }

    public AppUpgradeImpl() {
    }

    @Override // com.obric.autogui.tools.api.IAutoActionAppUpgradeApi
    public void onActivityResumed() {
        d r0 = this.mAppUpgradeHelper;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    @Override // com.obric.autogui.tools.api.IAutoActionAppUpgradeApi
    public void bindActivity(Activity r3, p r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        p r6 = (p) ZeusTransformUtils.wrapperContextForParams(r4, p.class, "com.obric.aiagent.plugin");
        o.e(r6, "lcOwner");
        if (r5 != null) goto L6;
        this.mAppUpgradeHelper = null;
        return;
    L6:
        d r0 = new d(r5, q.a(r6));
        this.mAppUpgradeHelper = r0;
        if (r0 == null) goto L10;
        r0.a();
        return;
    }

    public final void initAppUpgrade(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r10, "context");
        if (this.isUpgradeInited == false) goto L5;
        return;
    L5:
        String r0 = getDid();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L8;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L13;
        Loog.INSTANCE.e(TAG, "initAppUpgrade with empty / null DID = " + r0);
        return;
    L13:
        String r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName();
        Loog.INSTANCE.i(TAG, "initAppUpgrade with DID=" + r0 + "; isBoe=" + IAppContext.Companion.isDebug() + "; packageName=" + r1);
        i.a r3 = new i.a().f(r0).e("auto_action");
        String r4 = com.obric.common.upgrade.util.a.f32648a.a();
        if (r4 != null) goto L16;
        r4 = SensitiveType.UNKNOWN;
    L16:
        i.a r5 = r3.g(r4).d(String.valueOf(com.obric.common.upgrade.util.a.f32648a.b())).a(com.obric.common.upgrade.util.a.f32648a.a(r10));
        String r6 = com.obric.common.upgrade.util.a.f32648a.b(r10);
        if (r6 != null) goto L19;
        r6 = BuildConfig.VERSION_NAME;
    L19:
        i.a r7 = r5.a(r6);
        o.a(r1);
        e.f32625a.a(r10, r7.h(r1).a(IAppContext.Companion.isDebug()).b(getAccessKey()).c(getSecretKey()).b(0).a(0).a());
        this.isUpgradeInited = true;
        return;
    L8:
        r2 = false;
        goto L10
    }

    private final String getDid() {
        return AODeviceInfo.INSTANCE.getDid();
    }

    private final String getAccessKey() {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        return "1aa52fa0697da9776db7412392e30626";
    L5:
        return "c2f6a43059868bdffcff7f9af9a3a5ad";
    }

    private final String getSecretKey() {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        return "84d6c374d43b6917c3db300bc10a1d0c";
    L5:
        return "57c2ee43eef8859eafe44431cca6bd38";
    }
}
