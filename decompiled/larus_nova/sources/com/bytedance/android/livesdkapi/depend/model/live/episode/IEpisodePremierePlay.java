package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\"\u0010\n\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u0011\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\t\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001c\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\t\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodePremierePlay;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodePremierePlayEx;", "", "getPlayType", "()I", "setPlayType", "(I)V", "getPlayType$annotations", "()V", "playType", "", "getStartTime", "()J", "setStartTime", "(J)V", "getStartTime$annotations", DyPayConstant.KEY_START_TIME, "", "getPlayText", "()Ljava/lang/String;", "setPlayText", "(Ljava/lang/String;)V", "getPlayText$annotations", "playText", "getTextDuration", "setTextDuration", "getTextDuration$annotations", "textDuration", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IEpisodePremierePlay extends c<IEpisodePremierePlay>, IEpisodePremierePlayEx {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "play_text")
        public static /* synthetic */ void getPlayText$annotations() {
        }

        @FieldName(name = "play_type")
        public static /* synthetic */ void getPlayType$annotations() {
        }

        @FieldName(name = ILoadStallMonitor.START_TIME)
        public static /* synthetic */ void getStartTime$annotations() {
        }

        @FieldName(name = "text_duration")
        public static /* synthetic */ void getTextDuration$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "play_text")
    String getPlayText();

    @FieldName(name = "play_type")
    int getPlayType();

    @FieldName(name = ILoadStallMonitor.START_TIME)
    long getStartTime();

    @FieldName(name = "text_duration")
    long getTextDuration();

    @FieldName(name = "play_text#setter")
    void setPlayText(String r100);

    @FieldName(name = "play_type#setter")
    void setPlayType(int r100);

    @FieldName(name = "start_time#setter")
    void setStartTime(long r100);

    @FieldName(name = "text_duration#setter")
    void setTextDuration(long r100);
}
