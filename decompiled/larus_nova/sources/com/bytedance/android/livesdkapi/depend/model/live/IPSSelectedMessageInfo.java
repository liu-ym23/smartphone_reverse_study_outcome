package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R$\u0010\u0014\u001a\u0004\u0018\u00010\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IPSSelectedMessageInfo;", "Lvh7/c;", "", "getStatus", "()J", "setStatus", "(J)V", "getStatus$annotations", "()V", "status", "getMode", "setMode", "getMode$annotations", "mode", "Lcom/bytedance/android/livesdkapi/depend/model/live/IAIPublicScreenContainer;", "getAiPublicScreenContainer", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IAIPublicScreenContainer;", "setAiPublicScreenContainer", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IAIPublicScreenContainer;)V", "getAiPublicScreenContainer$annotations", "aiPublicScreenContainer", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IPSSelectedMessageInfo extends c<IPSSelectedMessageInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "ai_container")
        public static /* synthetic */ void getAiPublicScreenContainer$annotations() {
        }

        @FieldName(name = "mode")
        public static /* synthetic */ void getMode$annotations() {
        }

        @FieldName(name = "status")
        public static /* synthetic */ void getStatus$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "ai_container")
    IAIPublicScreenContainer getAiPublicScreenContainer();

    @FieldName(name = "mode")
    long getMode();

    @FieldName(name = "status")
    long getStatus();

    @FieldName(name = "ai_container#setter")
    void setAiPublicScreenContainer(IAIPublicScreenContainer r100);

    @FieldName(name = "mode#setter")
    void setMode(long r100);

    @FieldName(name = "status#setter")
    void setStatus(long r100);
}
