package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR>\u0010\u0013\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rj\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u0001`\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveStatusInfo;", "Lvh7/c;", "", "getLiveStatus", "()I", "getLiveStatus$annotations", "()V", "liveStatus", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getLiveUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getLiveUser$annotations", "liveUser", "", "Lpy/k;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getLiveNotifyLight", "()Ljava/util/Map;", "getLiveNotifyLight$annotations", "liveNotifyLight", "", "getPreviewText", "()Ljava/lang/String;", "getPreviewText$annotations", "previewText", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface ILiveStatusInfo extends c<ILiveStatusInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "live_notify_light")
        public static /* synthetic */ void getLiveNotifyLight$annotations() {
        }

        @FieldName(name = "live_status")
        public static /* synthetic */ void getLiveStatus$annotations() {
        }

        @FieldName(name = "live_user")
        public static /* synthetic */ void getLiveUser$annotations() {
        }

        @FieldName(name = "preview_text")
        public static /* synthetic */ void getPreviewText$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "live_notify_light")
    Map<Integer, k> getLiveNotifyLight();

    @FieldName(name = "live_status")
    int getLiveStatus();

    @FieldName(name = "live_user")
    IBaseUser getLiveUser();

    @FieldName(name = "preview_text")
    String getPreviewText();
}
