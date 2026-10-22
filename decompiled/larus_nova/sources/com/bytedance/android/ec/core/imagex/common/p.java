package com.bytedance.android.ec.core.imagex.common;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ec.core.imagex.common.z;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u000b\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003R0\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/common/p;", "Lcom/bytedance/android/ec/core/imagex/common/z;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "", "", "sceneConfig", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "commonLowConfig", "Ljava/util/List;", "b", "()Ljava/util/List;", "commonHighConfig", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p<T extends z> {

    @SerializedName("common_high_config")
    private final List<T> commonHighConfig;

    @SerializedName("common_low_config")
    private final List<T> commonLowConfig;

    @SerializedName("scene_config")
    private final Map<String, List<T>> sceneConfig;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L12;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.sceneConfig, r101.sceneConfig) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.commonLowConfig, r101.commonLowConfig) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.commonHighConfig, r101.commonHighConfig) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Map<String, List<T>> r100 = this.sceneConfig;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<T> r104 = this.commonLowConfig;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<T> r107 = this.commonHighConfig;
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
        return "MultiMapConfig(sceneConfig=" + this.sceneConfig + ", commonLowConfig=" + this.commonLowConfig + ", commonHighConfig=" + this.commonHighConfig + ")";
    }

    public final List<T> a() {
        return this.commonHighConfig;
    }

    public final List<T> b() {
        return this.commonLowConfig;
    }

    public final Map<String, List<T>> c() {
        return this.sceneConfig;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p(Map<String, ? extends List<? extends T>> r100, List<? extends T> r101, List<? extends T> r102) {
        this.sceneConfig = r100;
        this.commonLowConfig = r101;
        this.commonHighConfig = r102;
    }
}
