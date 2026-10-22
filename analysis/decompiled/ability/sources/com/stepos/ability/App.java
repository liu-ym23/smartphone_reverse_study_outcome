package com.stepos.ability;

import C7.r;
import D7.q;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.util.Log;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.api.application.IApp;
import com.stepos.policy.sdk.PolicySdk;
import com.uxsense.ApexSDK;
import dagger.hilt.android.HiltAndroidApp;
import g1.AbstractC1451a;
import j9.AbstractC1607a;
import j9.m;
import java.security.MessageDigest;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.inject.Inject;
import k2.C1621a;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0003J\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ability/App;", "Landroid/app/Application;", AppAgent.CONSTRUCT, "()V", "LC7/r;", "initPolicySdk", "Landroid/content/Context;", "context", "Landroid/content/pm/PackageInfo;", "getPackageInfo", "(Landroid/content/Context;)Landroid/content/pm/PackageInfo;", AppAgent.ON_CREATE, "", "getAppVersionName", "(Landroid/content/Context;)Ljava/lang/String;", "Lcom/stepos/ability/api/application/IApp;", "app", "Lcom/stepos/ability/api/application/IApp;", "getApp", "()Lcom/stepos/ability/api/application/IApp;", "setApp", "(Lcom/stepos/ability/api/application/IApp;)V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@HiltAndroidApp
/* loaded from: classes3.dex */
public final class App extends k {

    @Inject
    public IApp app;

    private final PackageInfo getPackageInfo(Context context) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        kotlin.jvm.internal.k.e(packageInfo, "getPackageInfo(...)");
        return packageInfo;
    }

    private final void initPolicySdk() {
        String str;
        Cipher cipher;
        SigningInfo signingInfo;
        Signature[] apkContentsSigners;
        Signature signature;
        HashMap map = new HashMap();
        map.put("vrs", "file:////android_asset/vrs_2.html");
        String appVersionName = getAppVersionName(this);
        try {
            cipher = Cipher.getInstance("AES/GCM/NoPadding");
            signingInfo = getPackageManager().getPackageInfo(getPackageName(), 134217728).signingInfo;
        } catch (Throwable th) {
            Log.e("PolicyParams", "decrypt appSecret failed (repack or wrong signature?): " + th.getMessage());
            str = "";
        }
        if (signingInfo == null || (apkContentsSigners = signingInfo.getApkContentsSigners()) == null || (signature = (Signature) q.n0(apkContentsSigners)) == null) {
            throw new IllegalStateException("no signing certificate available");
        }
        byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(signature.toByteArray());
        kotlin.jvm.internal.k.e(bArrDigest, "digest(...)");
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArrDigest, "AES");
        byte[] bArr = l.f3100a;
        cipher.init(2, secretKeySpec, new GCMParameterSpec(128, bArr, 0, 12));
        byte[] bArrDoFinal = cipher.doFinal(bArr, 12, 48);
        kotlin.jvm.internal.k.e(bArrDoFinal, "doFinal(...)");
        str = new String(bArrDoFinal, AbstractC1607a.f4778a);
        PolicySdk.initSDK(this, "26637234349593957900", str, appVersionName, map);
    }

    public final IApp getApp() {
        IApp iApp = this.app;
        if (iApp != null) {
            return iApp;
        }
        kotlin.jvm.internal.k.n("app");
        throw null;
    }

    public final String getAppVersionName(Context context) {
        kotlin.jvm.internal.k.f(context, "context");
        try {
            String str = getPackageInfo(context).versionName;
            String str2 = null;
            String string = str != null ? m.R0(str).toString() : null;
            if (string != null) {
                if (string.length() > 0) {
                    str2 = string;
                }
            }
            return str2 == null ? ApexSDK.VERSION : str2;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return ApexSDK.VERSION;
        }
    }

    @Override // com.stepos.ability.k, android.app.Application
    public void onCreate() {
        Object objA;
        Object objA2;
        super.onCreate();
        initPolicySdk();
        try {
            AbstractC1451a.f4471s = new B5.a(this, 5);
            C1621a.s(this);
            try {
                G4.a aVar = new G4.a(3);
                C5.f fVarC = C5.f.c();
                synchronized (fVarC) {
                    fVarC.h = aVar;
                }
                objA2 = r.f317a;
            } catch (Throwable th) {
                objA2 = kotlin.b.a(th);
            }
            Throwable thA = Result.a(objA2);
            if (thA != null) {
                Log.w("Analytics", "setOAIDChangeListener failed", thA);
            }
            objA = Integer.valueOf(Log.d("Analytics", "UsageStatsProxy3 init done, channel=StepOS"));
        } catch (Throwable th2) {
            objA = kotlin.b.a(th2);
        }
        Throwable thA2 = Result.a(objA);
        if (thA2 != null) {
            Log.w("Analytics", "analytics init failed", thA2);
        }
        getApp().init();
    }

    public final void setApp(IApp iApp) {
        kotlin.jvm.internal.k.f(iApp, "<set-?>");
        this.app = iApp;
    }
}
