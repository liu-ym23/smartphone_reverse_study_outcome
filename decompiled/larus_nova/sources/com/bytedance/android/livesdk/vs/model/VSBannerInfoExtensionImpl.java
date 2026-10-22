package com.bytedance.android.livesdk.vs.model;

import com.bytedance.android.livesdkapi.depend.model.live.IBannerInfo;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.e;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ6\u0010\t\u001a\u00028\u0000\"\u0016\b\u0000\u0010\u0006*\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00020\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0096\u0001¢\u0006\u0004\b\t\u0010\nJ8\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\u0016\b\u0000\u0010\u0006*\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00020\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0096\u0001¢\u0006\u0004\b\u000b\u0010\nR(\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0018\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u00138V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u001b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/vs/model/VSBannerInfoExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBannerInfo;", "Lcom/bytedance/android/livesdk/vs/model/VSBannerInfo;", "Lvh7/e;", "kotlin.jvm.PlatformType", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "value", "getH5Url", "()Ljava/lang/String;", "setH5Url", "(Ljava/lang/String;)V", "h5Url", "", "getContainerType", "()J", "setContainerType", "(J)V", "containerType", "getLynxUrl", "setLynxUrl", "lynxUrl", "base", "<init>", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IBannerInfo;)V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public class VSBannerInfoExtensionImpl extends ModelExtensionBase<IBannerInfo, VSBannerInfo> implements VSBannerInfo, IBannerInfo {
    private final /* synthetic */ IBannerInfo $$delegate_0;

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends e<IBannerInfo>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castTo(r100);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends e<IBannerInfo>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castToOrNull(r100);
    }

    @Override // com.bytedance.android.livesdk.vs.model.VSBannerInfo
    public String getH5Url() {
        return (String) get(1, VSBannerInfo.class);
    }

    @Override // com.bytedance.android.livesdk.vs.model.VSBannerInfo
    public String getLynxUrl() {
        return (String) get(7, VSBannerInfo.class);
    }

    @Override // com.bytedance.android.livesdk.vs.model.VSBannerInfo
    public long getContainerType() {
        return ((Number) get(8, VSBannerInfo.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.vs.model.VSBannerInfo
    public boolean isLynxContainerEnabled() {
        if (getContainerType() != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public VSBannerInfoExtensionImpl(IBannerInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        super(r100);
        this.$$delegate_0 = r100;
    }

    @Override // com.bytedance.android.livesdk.vs.model.VSBannerInfo
    public void setContainerType(long r100) {
        set(8, ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, VSBannerInfo.class, Long.valueOf(r100));
    }

    @Override // com.bytedance.android.livesdk.vs.model.VSBannerInfo
    public void setH5Url(String r100) {
        set(1, "container_url", VSBannerInfo.class, r100);
    }

    @Override // com.bytedance.android.livesdk.vs.model.VSBannerInfo
    public void setLynxUrl(String r100) {
        set(7, "lynx_container_url", VSBannerInfo.class, r100);
    }
}
