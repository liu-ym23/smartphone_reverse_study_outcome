package com.bytedance.android.live.liveinteract.plantform.permission.model;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/permission/model/OperateType;", "", "", "opTypeStr", "Ljava/lang/String;", "getOpTypeStr", "()Ljava/lang/String;", "APPLY", "REPLY", "PRE_APPLY", "RESUME", "JOIN", "PRE_REPLY", "MIDI", "UniversalAnimForSaas", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum OperateType extends Enum<OperateType> {
    public static final OperateType APPLY = null;
    public static final OperateType JOIN = null;
    public static final OperateType MIDI = null;
    public static final OperateType PRE_APPLY = null;
    public static final OperateType PRE_REPLY = null;
    public static final OperateType REPLY = null;
    public static final OperateType RESUME = null;
    public static final OperateType UniversalAnimForSaas = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OperateType[] f77418a = null;
    private final String opTypeStr;

    public static OperateType valueOf(String r100) {
        return (OperateType) a.a(OperateType.class, r100);
    }

    public static OperateType[] values() {
        return (OperateType[]) f77418a.clone();
    }

    static {
        OperateType r100 = new OperateType("APPLY", 0, e1.REPLY_ACTION_APPLY);
        APPLY = r100;
        OperateType r101 = new OperateType("REPLY", 1, "replay");
        REPLY = r101;
        OperateType r102 = new OperateType("PRE_APPLY", 2, "pre_apply");
        PRE_APPLY = r102;
        OperateType r103 = new OperateType("RESUME", 3, "resume");
        RESUME = r103;
        OperateType r104 = new OperateType("JOIN", 4, "join");
        JOIN = r104;
        OperateType r105 = new OperateType("PRE_REPLY", 5, "pre_reply");
        PRE_REPLY = r105;
        OperateType r106 = new OperateType("MIDI", 6, KtvSubElement.MIDI);
        MIDI = r106;
        OperateType r107 = new OperateType("UniversalAnimForSaas", 7, "universal_anim_for_saas");
        UniversalAnimForSaas = r107;
        f77418a = new OperateType[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public final String getOpTypeStr() {
        return this.opTypeStr;
    }

    public OperateType(String r100, int r101, String r102) {
        super(r100, r101);
        this.opTypeStr = r102;
    }
}
