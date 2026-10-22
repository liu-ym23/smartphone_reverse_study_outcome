package com.bytedance.android.livesdk.player.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/player/model/g;", "", "", "contentType", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", TextureRenderKeys.KEY_IS_FOV, "c", "scopicType", "d", "dof", "b", "<init>", "()V", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("ContentType")
    private final int contentType;

    @SerializedName("DOF")
    private final int dof;

    @SerializedName("FOV")
    private final int fov;

    @SerializedName("ScopicType")
    private final int scopicType;

    public static final class a {
    }

    static {
    }

    public g() {
        this.fov = -1;
        this.dof = -1;
    }

    public final int a() {
        return this.contentType;
    }

    public final int b() {
        return this.dof;
    }

    public final int c() {
        return this.fov;
    }

    public final int d() {
        return this.scopicType;
    }
}
