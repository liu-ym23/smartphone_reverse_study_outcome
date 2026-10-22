package com.bytedance.android.ec.model.response;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/model/response/ActionType;", "", UserProfileEvent.POSITION_NONE, "Biz", "DynamicRegion", "Dialog", "Jump", "DeferRequest", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum ActionType extends Enum<ActionType> {

    @SerializedName("1")
    public static final ActionType Biz = null;

    @SerializedName("7")
    public static final ActionType DeferRequest = null;

    @SerializedName("3")
    public static final ActionType Dialog = null;

    @SerializedName("2")
    public static final ActionType DynamicRegion = null;

    @SerializedName("4")
    public static final ActionType Jump = null;

    @SerializedName("0")
    public static final ActionType NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActionType[] f47896a = null;

    static {
        ActionType r100 = new ActionType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        ActionType r101 = new ActionType("Biz", 1);
        Biz = r101;
        ActionType r102 = new ActionType("DynamicRegion", 2);
        DynamicRegion = r102;
        ActionType r103 = new ActionType("Dialog", 3);
        Dialog = r103;
        ActionType r104 = new ActionType("Jump", 4);
        Jump = r104;
        ActionType r105 = new ActionType("DeferRequest", 5);
        DeferRequest = r105;
        f47896a = new ActionType[]{r100, r101, r102, r103, r104, r105};
    }

    public static ActionType valueOf(String r100) {
        return (ActionType) r27.a.a(ActionType.class, r100);
    }

    public static ActionType[] values() {
        return (ActionType[]) f47896a.clone();
    }

    public ActionType(String r100, int r101) {
        super(r100, r101);
    }
}
