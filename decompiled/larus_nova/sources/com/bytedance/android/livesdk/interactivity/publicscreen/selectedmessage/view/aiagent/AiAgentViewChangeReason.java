package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/view/aiagent/AiAgentViewChangeReason;", "", "", SocialConstants.PARAM_APP_DESC, ErrorCode.INIT, "CONTAINER_SHOW", "CONTAINER_HIDE", "MESSAGE_INSERT", "MESSAGE_REMOVE", "ZOOM_OUT", "ZOOM_IN", "MODE_CHANGE", "TIMEOUT", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AiAgentViewChangeReason extends Enum<AiAgentViewChangeReason> {
    public static final AiAgentViewChangeReason CONTAINER_HIDE = null;
    public static final AiAgentViewChangeReason CONTAINER_SHOW = null;
    public static final AiAgentViewChangeReason INIT = null;
    public static final AiAgentViewChangeReason MESSAGE_INSERT = null;
    public static final AiAgentViewChangeReason MESSAGE_REMOVE = null;
    public static final AiAgentViewChangeReason MODE_CHANGE = null;
    public static final AiAgentViewChangeReason TIMEOUT = null;
    public static final AiAgentViewChangeReason ZOOM_IN = null;
    public static final AiAgentViewChangeReason ZOOM_OUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AiAgentViewChangeReason[] f139500a = null;

    static {
        AiAgentViewChangeReason r100 = new AiAgentViewChangeReason(ErrorCode.INIT, 0);
        INIT = r100;
        AiAgentViewChangeReason r101 = new AiAgentViewChangeReason("CONTAINER_SHOW", 1);
        CONTAINER_SHOW = r101;
        AiAgentViewChangeReason r102 = new AiAgentViewChangeReason("CONTAINER_HIDE", 2);
        CONTAINER_HIDE = r102;
        AiAgentViewChangeReason r103 = new AiAgentViewChangeReason("MESSAGE_INSERT", 3);
        MESSAGE_INSERT = r103;
        AiAgentViewChangeReason r104 = new AiAgentViewChangeReason("MESSAGE_REMOVE", 4);
        MESSAGE_REMOVE = r104;
        AiAgentViewChangeReason r105 = new AiAgentViewChangeReason("ZOOM_OUT", 5);
        ZOOM_OUT = r105;
        AiAgentViewChangeReason r106 = new AiAgentViewChangeReason("ZOOM_IN", 6);
        ZOOM_IN = r106;
        AiAgentViewChangeReason r107 = new AiAgentViewChangeReason("MODE_CHANGE", 7);
        MODE_CHANGE = r107;
        AiAgentViewChangeReason r108 = new AiAgentViewChangeReason("TIMEOUT", 8);
        TIMEOUT = r108;
        f139500a = new AiAgentViewChangeReason[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public static AiAgentViewChangeReason valueOf(String r100) {
        return (AiAgentViewChangeReason) r27.a.a(AiAgentViewChangeReason.class, r100);
    }

    public static AiAgentViewChangeReason[] values() {
        return (AiAgentViewChangeReason[]) f139500a.clone();
    }

    public final String desc() {
        switch(i.f139523a[ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            case 9: goto L6;
            default: goto L5;
        };
    L6:
        return "TIMEOUT";
    L7:
        return "MODE_CHANGE";
    L8:
        return "ZOOM_IN";
    L9:
        return "ZOOM_OUT";
    L10:
        return "MESSAGE_REMOVE";
    L11:
        return "MESSAGE_INSERT";
    L12:
        return "CONTAINER_HIDE";
    L13:
        return "CONTAINER_SHOW";
    L14:
        return ErrorCode.INIT;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public AiAgentViewChangeReason(String r100, int r101) {
        super(r100, r101);
    }
}
