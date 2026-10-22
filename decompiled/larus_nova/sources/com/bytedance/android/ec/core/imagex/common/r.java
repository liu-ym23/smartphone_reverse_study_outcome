package com.bytedance.android.ec.core.imagex.common;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ec.core.imagex.common.z;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR(\u0010\u0006\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\tR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/common/r;", "Lcom/bytedance/android/ec/core/imagex/common/z;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "Lcom/bytedance/android/ec/core/imagex/common/y;", "sceneConfig", "Ljava/util/List;", "c", "()Ljava/util/List;", "commonLowConfig", "b", "commonHighConfig", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r<T extends z> {

    @SerializedName("common_high_config")
    private final List<T> commonHighConfig;

    @SerializedName("common_low_config")
    private final List<T> commonLowConfig;

    @SerializedName("scene_config")
    private final List<y<T>> sceneConfig;

    public r() {
    }

    public final List<T> a() {
        return this.commonHighConfig;
    }

    public final List<T> b() {
        return this.commonLowConfig;
    }

    public final List<y<T>> c() {
        return this.sceneConfig;
    }
}
