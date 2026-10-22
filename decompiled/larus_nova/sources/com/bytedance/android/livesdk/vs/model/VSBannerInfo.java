package com.bytedance.android.livesdk.vs.model;

import com.bytedance.android.livesdkapi.depend.model.live.IBannerInfo;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.e;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000b\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R$\u0010\f\u001a\u0004\u0018\u00010\u00058&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0013\u001a\u00020\r8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0017\u001a\u0004\u0018\u00010\u00058&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/vs/model/VSBannerInfo;", "Lvh7/e;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBannerInfo;", "", "isLynxContainerEnabled", "", "getH5Url", "()Ljava/lang/String;", "setH5Url", "(Ljava/lang/String;)V", "getH5Url$annotations", "()V", "h5Url", "", "getContainerType", "()J", "setContainerType", "(J)V", "getContainerType$annotations", "containerType", "getLynxUrl", "setLynxUrl", "getLynxUrl$annotations", "lynxUrl", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface VSBannerInfo extends e<IBannerInfo>, IBannerInfo {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBannerInfo, vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBannerInfo, vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE)
    long getContainerType();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "container_url")
    String getH5Url();

    @FieldName(name = "lynx_container_url")
    String getLynxUrl();

    boolean isLynxContainerEnabled();

    @FieldName(name = "container_type#setter")
    void setContainerType(long r100);

    @FieldName(name = "container_url#setter")
    void setH5Url(String r100);

    @FieldName(name = "lynx_container_url#setter")
    void setLynxUrl(String r100);
}
