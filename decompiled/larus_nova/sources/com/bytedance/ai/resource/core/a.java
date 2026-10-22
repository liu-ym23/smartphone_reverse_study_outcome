package com.bytedance.ai.resource.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f37325a;

    static {
        f37325a = "";
    }

    public static String a(AIPackageDeployment.AIPackageDeploymentItem r100) {
        Intrinsics.checkNotNullParameter(r100, "deploymentInfo");
        return f37325a + '/' + r100.getPackageName() + "/base_" + r100.getVersionCode();
    }

    public static String b(AIPackageDeployment.AIPackageDeploymentItem r100) {
        Intrinsics.checkNotNullParameter(r100, "deploymentInfo");
        return f37325a + '/' + r100.getPackageName() + "/base_" + r100.getVersionCode() + ".zip";
    }

    public static String c(AIPackageDeployment.AIPackageDeploymentItem r100) {
        Intrinsics.checkNotNullParameter(r100, "deploymentInfo");
        return f37325a + '/' + r100.getPackageName() + "/base_" + r100.getVersionCode() + "/base/bundle.keystore";
    }

    public static String d(AIPackageDeployment.AIPackageDeploymentItem r100) {
        Intrinsics.checkNotNullParameter(r100, "deploymentInfo");
        return f37325a + '/' + r100.getPackageName() + "/base_" + r100.getVersionCode() + "/base/manifest.json";
    }

    public static String e(AIPackageDeployment.AIPackageDeploymentItem r100) {
        Intrinsics.checkNotNullParameter(r100, "deploymentInfo");
        String r101 = r100.getPackageName();
        String r102 = r100.getAppId();
        String r103 = r100.getDigest();
        Intrinsics.checkNotNullParameter(r101, "packageName");
        Intrinsics.checkNotNullParameter(r102, "appId");
        Intrinsics.checkNotNullParameter(r103, "digest");
        return f37325a + '/' + r101 + '/' + r102 + '_' + r103;
    }

    public static String f(AIPackageDeployment.AIPackageDeploymentItem r100) {
        Intrinsics.checkNotNullParameter(r100, "deploymentInfo");
        String r101 = r100.getPackageName();
        String r102 = r100.getAppId();
        String r103 = r100.getDigest();
        Intrinsics.checkNotNullParameter(r101, "packageName");
        Intrinsics.checkNotNullParameter(r102, "appId");
        Intrinsics.checkNotNullParameter(r103, "digest");
        return f37325a + '/' + r101 + '/' + r102 + '_' + r103 + ".zip";
    }
}
