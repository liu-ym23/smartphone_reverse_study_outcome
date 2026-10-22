package com.bytedance.android.live.effect.sticker.presenter;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/presenter/BeautyModeInfo;", "", "", "modeKey", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setModeKey", "(Ljava/lang/String;)V", "modeName", "c", "setModeName", "", "minVersion", "I", "getMinVersion", "()I", "setMinVersion", "(I)V", "maxVersion", "getMaxVersion", "setMaxVersion", "", "Lcom/bytedance/android/live/effect/sticker/presenter/i;", "modeConfigList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "<init>", "()V", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BeautyModeInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f68216a;

    @SerializedName("maximum_host_version")
    private int maxVersion;

    @SerializedName("minimum_host_version")
    private int minVersion;

    @SerializedName("mode_config")
    private final List<i> modeConfigList;

    @SerializedName("mode_key")
    private String modeKey;

    @SerializedName("mode_name")
    private String modeName;

    public BeautyModeInfo() {
        this.modeKey = "";
        this.modeName = "";
        this.modeConfigList = new ArrayList();
        this.f68216a = LazyKt.lazy(new BeautyModeInfo$modeConfigMap$2(this));
    }

    public final List<i> a() {
        return this.modeConfigList;
    }

    public final String b() {
        return this.modeKey;
    }

    public final String c() {
        return this.modeName;
    }
}
