package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u000fR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLeaveContent;", "Lvh7/e;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLeaveContentBridge;", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "getLinkUsers", "()Ljava/util/List;", "getLinkUsers$annotations", "()V", "linkUsers", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "getClientUiInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "getClientUiInfo$annotations", "clientUiInfo", "Companion", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkerLeaveContent extends e<ILinkerLeaveContentBridge>, ILinkerLeaveContentBridge {
    public static final int AnchorLeaveSourceOrganizerKickOut = 1;
    public static final int AnchorLeaveSourceUnknown = 0;
    public static final Companion Companion = null;
    public static final int LeaveSource_AnchorFinishRoom = 5;
    public static final int LeaveSource_AnchorLeaveLinkMic = 3;
    public static final int LeaveSource_AnchorRTCUnlink = 4;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLeaveContent$Companion;", "", "()V", "AnchorLeaveSourceOrganizerKickOut", "", "AnchorLeaveSourceUnknown", "LeaveSource_AnchorFinishRoom", "LeaveSource_AnchorLeaveLinkMic", "LeaveSource_AnchorRTCUnlink", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int AnchorLeaveSourceOrganizerKickOut = 1;
        public static final int AnchorLeaveSourceUnknown = 0;
        public static final int LeaveSource_AnchorFinishRoom = 5;
        public static final int LeaveSource_AnchorLeaveLinkMic = 3;
        public static final int LeaveSource_AnchorRTCUnlink = 4;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "client_ui_info")
        public static /* synthetic */ void getClientUiInfo$annotations() {
        }

        @FieldName(name = "linked_users")
        public static /* synthetic */ void getLinkUsers$annotations() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridge, vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridge, vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "client_ui_info")
    ClientUIInfo getClientUiInfo();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridgeDef
    @FieldName(name = "linked_users")
    List<k> getLinkUsers();
}
