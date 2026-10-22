package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0018\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IPublicScreenSpeedConfig;", "Lvh7/c;", "", "getInterval", "()J", "setInterval", "(J)V", "getInterval$annotations", "()V", VideoThumbInfo.KEY_INTERVAL, "", "getUpdateScrollSize", "()I", "setUpdateScrollSize", "(I)V", "getUpdateScrollSize$annotations", "updateScrollSize", "getUpdateFoldSize", "setUpdateFoldSize", "getUpdateFoldSize$annotations", "updateFoldSize", "getScrollSpeed", "setScrollSpeed", "getScrollSpeed$annotations", "scrollSpeed", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IPublicScreenSpeedConfig extends c<IPublicScreenSpeedConfig> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "update_interval")
        public static /* synthetic */ void getInterval$annotations() {
        }

        @FieldName(name = "scroll_speed")
        public static /* synthetic */ void getScrollSpeed$annotations() {
        }

        @FieldName(name = "fold_size")
        public static /* synthetic */ void getUpdateFoldSize$annotations() {
        }

        @FieldName(name = "scroll_size")
        public static /* synthetic */ void getUpdateScrollSize$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "update_interval")
    long getInterval();

    @FieldName(name = "scroll_speed")
    int getScrollSpeed();

    @FieldName(name = "fold_size")
    int getUpdateFoldSize();

    @FieldName(name = "scroll_size")
    int getUpdateScrollSize();

    @FieldName(name = "update_interval#setter")
    void setInterval(long r100);

    @FieldName(name = "scroll_speed#setter")
    void setScrollSpeed(int r100);

    @FieldName(name = "fold_size#setter")
    void setUpdateFoldSize(int r100);

    @FieldName(name = "scroll_size#setter")
    void setUpdateScrollSize(int r100);
}
