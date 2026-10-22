package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IPreviewComponentConfig;", "Lvh7/c;", "", "getRandomTime", "()Ljava/lang/Long;", "getRandomTime$annotations", "()V", "randomTime", "getPollDuration", "getPollDuration$annotations", "pollDuration", "getShowDuration", "getShowDuration$annotations", "showDuration", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IPreviewComponentConfig extends c<IPreviewComponentConfig> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "poll_duration")
        public static /* synthetic */ void getPollDuration$annotations() {
        }

        @FieldName(name = "random_time")
        public static /* synthetic */ void getRandomTime$annotations() {
        }

        @FieldName(name = "show_duration")
        public static /* synthetic */ void getShowDuration$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "poll_duration")
    Long getPollDuration();

    @FieldName(name = "random_time")
    Long getRandomTime();

    @FieldName(name = "show_duration")
    Long getShowDuration();
}
