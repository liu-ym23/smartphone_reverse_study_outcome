package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\tR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLeaveContentBridge;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLeaveContentBridgeDef;", "", "getUserIdStr", "()Ljava/lang/String;", "userIdStr", "getUserId", "userId", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkerLeaveContentBridge extends c<ILinkerLeaveContentBridge>, ILinkerLeaveContentBridgeDef {
    public static final int AnchorLeaveSourceOrganizerKickOut = 1;
    public static final int AnchorLeaveSourceUnknown = 0;
    public static final Companion Companion = null;
    public static final int LeaveSource_AnchorFinishRoom = 5;
    public static final int LeaveSource_AnchorLeaveLinkMic = 3;
    public static final int LeaveSource_AnchorRTCUnlink = 4;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLeaveContentBridge$Companion;", "", "()V", "AnchorLeaveSourceOrganizerKickOut", "", "AnchorLeaveSourceUnknown", "LeaveSource_AnchorFinishRoom", "LeaveSource_AnchorLeaveLinkMic", "LeaveSource_AnchorRTCUnlink", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
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

    static {
        Companion = Companion.$$INSTANCE;
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    String getUserId();

    String getUserIdStr();
}
