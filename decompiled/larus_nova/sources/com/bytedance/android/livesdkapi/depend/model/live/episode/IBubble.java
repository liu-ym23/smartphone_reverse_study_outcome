package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\nR\u001a\u0010\u0012\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\nR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IBubble;", "Lvh7/c;", "", "getSwitch", "()I", "getSwitch$annotations", "()V", "switch", "", "getBubbleId", "()J", "getBubbleId$annotations", "bubbleId", "getDuration", "getDuration$annotations", "duration", "getDelay", "getDelay$annotations", "delay", "", "getBubbleText", "()Ljava/lang/String;", "getBubbleText$annotations", "bubbleText", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IBubble extends c<IBubble> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "bubble_id")
        public static /* synthetic */ void getBubbleId$annotations() {
        }

        @FieldName(name = "bubble_text")
        public static /* synthetic */ void getBubbleText$annotations() {
        }

        @FieldName(name = "delay")
        public static /* synthetic */ void getDelay$annotations() {
        }

        @FieldName(name = "duration")
        public static /* synthetic */ void getDuration$annotations() {
        }

        @FieldName(name = "switch")
        public static /* synthetic */ void getSwitch$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "bubble_id")
    long getBubbleId();

    @FieldName(name = "bubble_text")
    String getBubbleText();

    @FieldName(name = "delay")
    long getDelay();

    @FieldName(name = "duration")
    long getDuration();

    @FieldName(name = "switch")
    int getSwitch();
}
