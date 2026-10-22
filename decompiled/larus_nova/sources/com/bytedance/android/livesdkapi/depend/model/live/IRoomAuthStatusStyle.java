package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u001c\bg\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001%R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\u0006R\"\u0010\u0018\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0006R$\u0010\u001c\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\b\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR$\u0010 \u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\b\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR$\u0010$\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\b\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000e¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatusStyle;", "Lvh7/c;", "", "getUnableStyle", "()I", "setUnableStyle", "(I)V", "getUnableStyle$annotations", "()V", "unableStyle", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getContent$annotations", "content", "getAnchorSwitch", "setAnchorSwitch", "getAnchorSwitch$annotations", "anchorSwitch", "getAnchorSwitchForPaidLive", "setAnchorSwitchForPaidLive", "getAnchorSwitchForPaidLive$annotations", "anchorSwitchForPaidLive", "getContentForPaidLive", "setContentForPaidLive", "getContentForPaidLive$annotations", "contentForPaidLive", "getSwitchStatusTipMsg", "setSwitchStatusTipMsg", "getSwitchStatusTipMsg$annotations", "switchStatusTipMsg", "getSwitchStatusAnchorTipMsg", "setSwitchStatusAnchorTipMsg", "getSwitchStatusAnchorTipMsg$annotations", "switchStatusAnchorTipMsg", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRoomAuthStatusStyle extends c<IRoomAuthStatusStyle> {
    public static final int ANCHOR_CHAT_CLOSE = 1;
    public static final int ANCHOR_CHAT_ONLY_ANCHOR_FOLLOWED = 3;
    public static final int ANCHOR_CHAT_ONLY_FOLLOWED_ANCHOR = 5;
    public static final int ANCHOR_CLOSE = 2;
    public static final int ANCHOR_NONE = 0;
    public static final int ANCHOR_OPEN = 1;
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatusStyle$Companion;", "", "()V", "ANCHOR_CHAT_CLOSE", "", "ANCHOR_CHAT_ONLY_ANCHOR_FOLLOWED", "ANCHOR_CHAT_ONLY_FOLLOWED_ANCHOR", "ANCHOR_CLOSE", "ANCHOR_NONE", "ANCHOR_OPEN", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int ANCHOR_CHAT_CLOSE = 1;
        public static final int ANCHOR_CHAT_ONLY_ANCHOR_FOLLOWED = 3;
        public static final int ANCHOR_CHAT_ONLY_FOLLOWED_ANCHOR = 5;
        public static final int ANCHOR_CLOSE = 2;
        public static final int ANCHOR_NONE = 0;
        public static final int ANCHOR_OPEN = 1;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "AnchorSwitch")
        public static /* synthetic */ void getAnchorSwitch$annotations() {
        }

        @FieldName(name = "AnchorSwitchForPaidLive")
        public static /* synthetic */ void getAnchorSwitchForPaidLive$annotations() {
        }

        @FieldName(name = "Content")
        public static /* synthetic */ void getContent$annotations() {
        }

        @FieldName(name = "ContentForPaidLive")
        public static /* synthetic */ void getContentForPaidLive$annotations() {
        }

        @FieldName(name = "SwitchStatusAnchorTipMsg")
        public static /* synthetic */ void getSwitchStatusAnchorTipMsg$annotations() {
        }

        @FieldName(name = "SwitchStatusTipMsg")
        public static /* synthetic */ void getSwitchStatusTipMsg$annotations() {
        }

        @FieldName(name = "UnableStyle")
        public static /* synthetic */ void getUnableStyle$annotations() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "AnchorSwitch")
    int getAnchorSwitch();

    @FieldName(name = "AnchorSwitchForPaidLive")
    int getAnchorSwitchForPaidLive();

    @FieldName(name = "Content")
    String getContent();

    @FieldName(name = "ContentForPaidLive")
    String getContentForPaidLive();

    @FieldName(name = "SwitchStatusAnchorTipMsg")
    String getSwitchStatusAnchorTipMsg();

    @FieldName(name = "SwitchStatusTipMsg")
    String getSwitchStatusTipMsg();

    @FieldName(name = "UnableStyle")
    int getUnableStyle();

    @FieldName(name = "AnchorSwitch#setter")
    void setAnchorSwitch(int r100);

    @FieldName(name = "AnchorSwitchForPaidLive#setter")
    void setAnchorSwitchForPaidLive(int r100);

    @FieldName(name = "Content#setter")
    void setContent(String r100);

    @FieldName(name = "ContentForPaidLive#setter")
    void setContentForPaidLive(String r100);

    @FieldName(name = "SwitchStatusAnchorTipMsg#setter")
    void setSwitchStatusAnchorTipMsg(String r100);

    @FieldName(name = "SwitchStatusTipMsg#setter")
    void setSwitchStatusTipMsg(String r100);

    @FieldName(name = "UnableStyle#setter")
    void setUnableStyle(int r100);
}
