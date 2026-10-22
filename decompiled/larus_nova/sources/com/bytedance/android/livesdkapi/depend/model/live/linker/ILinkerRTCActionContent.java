package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerRTCActionContent;", "Lvh7/c;", "", "getActionType", "()I", "setActionType", "(I)V", "getActionType$annotations", "()V", ReportConstant.COMMON_ACTION_TYPE, "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerRTCActionJoinRTCContent;", "getJoinRtcContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerRTCActionJoinRTCContent;", "setJoinRtcContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerRTCActionJoinRTCContent;)V", "getJoinRtcContent$annotations", "joinRtcContent", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkerRTCActionContent extends c<ILinkerRTCActionContent> {
    public static final int CONTENT_ACTION_TYPE_JOIN_RTC = 1;
    public static final int CONTENT_ACTION_TYPE_UNKNOWN = 0;
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerRTCActionContent$Companion;", "", "()V", "CONTENT_ACTION_TYPE_JOIN_RTC", "", "CONTENT_ACTION_TYPE_UNKNOWN", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int CONTENT_ACTION_TYPE_JOIN_RTC = 1;
        public static final int CONTENT_ACTION_TYPE_UNKNOWN = 0;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "type")
        public static /* synthetic */ void getActionType$annotations() {
        }

        @FieldName(name = "join_rtc_content")
        public static /* synthetic */ void getJoinRtcContent$annotations() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "type")
    int getActionType();

    @FieldName(name = "join_rtc_content")
    ILinkerRTCActionJoinRTCContent getJoinRtcContent();

    @FieldName(name = "type#setter")
    void setActionType(int r100);

    @FieldName(name = "join_rtc_content#setter")
    void setJoinRtcContent(ILinkerRTCActionJoinRTCContent r100);
}
