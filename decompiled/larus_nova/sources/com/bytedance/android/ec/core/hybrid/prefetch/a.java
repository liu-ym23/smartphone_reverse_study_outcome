package com.bytedance.android.ec.core.hybrid.prefetch;

import com.google.gson.annotations.SerializedName;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/prefetch/a;", "", "", "keyPath", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "bizTag", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "sceneTag", "c", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("biz_tag")
    private final String bizTag;

    @SerializedName("preload_imgs_key_path")
    private final String keyPath;

    @SerializedName(FrescoMonitorConst.SCENE_TAG)
    private final String sceneTag;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.keyPath, r101.keyPath) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bizTag, r101.bizTag) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.sceneTag, r101.sceneTag) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.keyPath;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.bizTag;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.sceneTag;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ApiPreloadConfig(keyPath=" + this.keyPath + ", bizTag=" + this.bizTag + ", sceneTag=" + this.sceneTag + ")";
    }

    public a() {
        this.keyPath = null;
        this.bizTag = null;
        this.sceneTag = null;
    }

    public final String a() {
        return this.bizTag;
    }

    public final String b() {
        return this.keyPath;
    }

    public final String c() {
        return this.sceneTag;
    }
}
