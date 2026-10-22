package com.bytedance.android.livesdkapi.depend.message;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014RB\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u0013\u001a\u0004\u0018\u00010\r8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/AudioChatCycleUIInfo;", "Lvh7/c;", "", "", "Lcom/bytedance/android/livesdkapi/depend/message/AudioChatCycleUIInfo$Info;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getUiInfo", "()Ljava/util/Map;", "setUiInfo", "(Ljava/util/Map;)V", "getUiInfo$annotations", "()V", "uiInfo", "", "getUpTimeMs", "()Ljava/lang/String;", "setUpTimeMs", "(Ljava/lang/String;)V", "getUpTimeMs$annotations", "upTimeMs", "Info", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface AudioChatCycleUIInfo extends c<AudioChatCycleUIInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "ui_info")
        public static /* synthetic */ void getUiInfo$annotations() {
        }

        @FieldName(name = "up_time_ms")
        public static /* synthetic */ void getUpTimeMs$annotations() {
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/AudioChatCycleUIInfo$Info;", "Lvh7/c;", "", "getTrack", "()J", "setTrack", "(J)V", "getTrack$annotations", "()V", GXTemplateKey.GAIAX_TRACK, "", "getHeaderRatio", "()F", "setHeaderRatio", "(F)V", "getHeaderRatio$annotations", "headerRatio", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface Info extends c<Info> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class DefaultImpls {
            @FieldName(name = "header_ratio")
            public static /* synthetic */ void getHeaderRatio$annotations() {
            }

            @FieldName(name = GXTemplateKey.GAIAX_TRACK)
            public static /* synthetic */ void getTrack$annotations() {
            }
        }

        @Override // vh7.c
        /* synthetic */ e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ e castToOrNull(Class r100);

        @FieldName(name = "header_ratio")
        float getHeaderRatio();

        @FieldName(name = GXTemplateKey.GAIAX_TRACK)
        long getTrack();

        @FieldName(name = "header_ratio#setter")
        void setHeaderRatio(float r100);

        @FieldName(name = "track#setter")
        void setTrack(long r100);
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "ui_info")
    Map<Long, Info> getUiInfo();

    @FieldName(name = "up_time_ms")
    String getUpTimeMs();

    @FieldName(name = "ui_info#setter")
    void setUiInfo(Map<Long, ? extends Info> r100);

    @FieldName(name = "up_time_ms#setter")
    void setUpTimeMs(String r100);
}
