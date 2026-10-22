package com.bytedance.android.ecom.arch.slice.render.widget.animation;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/render/widget/animation/f;", "", "", "percent", FaceService.girlLabel, "b", "()F", "", "", "style", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "", "dynamic", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "slice-render_release"}, k = 1, mv = {1, 4, 0})
public final class f {

    @SerializedName("dynamic")
    private final boolean dynamic;

    @SerializedName("percent")
    private final float percent;

    @SerializedName("style")
    private final Map<String, Object> style;

    public f() {
        this(0.0f, null, false);
    }

    public final boolean a() {
        return this.dynamic;
    }

    public final float b() {
        return this.percent;
    }

    public final Map<String, Object> c() {
        return this.style;
    }

    public f(float r100, Map<String, ? extends Object> r101, boolean r102) {
        this.percent = r100;
        this.style = r101;
        this.dynamic = r102;
    }
}
