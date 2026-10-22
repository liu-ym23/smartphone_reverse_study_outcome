package com.bytedance.android.livesdk.vscore_api.paid;

import com.obric.miniapp.alarm.AccountType;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\bj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_api/paid/PaidSceneEnum;", "", "", "isReplay", "", "priority", "I", "getPriority", "()I", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "paidLiveTypeInt", "getPaidLiveTypeInt", AccountType.ALL, "PAID_ROOM", "SUBSCRIBE_ROOM", "PAID_CAMERA", "PAID_PRIVILEGE_CAMERA", "PAID_PRIVILEGE_CLARITY", "PAID_PRIVILEGE_MSG_BOARD", "PAID_ANCHOR_ROOM", "PAID_REPLAY_ROOM", "SUBSCRIBE_REPLAY_ROOM", "PAID_REPLAY_CAMERA", "PAID_REPLAY_PRIVILEGE_CAMERA", "PAID_REPLAY_PRIVILEGE_CLARITY", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PaidSceneEnum extends Enum<PaidSceneEnum> {
    public static final PaidSceneEnum ALL = null;
    public static final PaidSceneEnum PAID_ANCHOR_ROOM = null;
    public static final PaidSceneEnum PAID_CAMERA = null;
    public static final PaidSceneEnum PAID_PRIVILEGE_CAMERA = null;
    public static final PaidSceneEnum PAID_PRIVILEGE_CLARITY = null;
    public static final PaidSceneEnum PAID_PRIVILEGE_MSG_BOARD = null;
    public static final PaidSceneEnum PAID_REPLAY_CAMERA = null;
    public static final PaidSceneEnum PAID_REPLAY_PRIVILEGE_CAMERA = null;
    public static final PaidSceneEnum PAID_REPLAY_PRIVILEGE_CLARITY = null;
    public static final PaidSceneEnum PAID_REPLAY_ROOM = null;
    public static final PaidSceneEnum PAID_ROOM = null;
    public static final PaidSceneEnum SUBSCRIBE_REPLAY_ROOM = null;
    public static final PaidSceneEnum SUBSCRIBE_ROOM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PaidSceneEnum[] f159401a = null;
    private final String desc;
    private final int paidLiveTypeInt;
    private final int priority;

    public static PaidSceneEnum valueOf(String r100) {
        return (PaidSceneEnum) a.a(PaidSceneEnum.class, r100);
    }

    public static PaidSceneEnum[] values() {
        return (PaidSceneEnum[]) f159401a.clone();
    }

    public final boolean isReplay() {
        return ArraysKt.contains(new PaidSceneEnum[]{PAID_REPLAY_ROOM, PAID_REPLAY_CAMERA, PAID_REPLAY_PRIVILEGE_CAMERA, PAID_REPLAY_PRIVILEGE_CLARITY}, this);
    }

    static {
        PaidSceneEnum r100 = new PaidSceneEnum(AccountType.ALL, 0, 0, "兜底场景", 0);
        ALL = r100;
        PaidSceneEnum r101 = new PaidSceneEnum("PAID_ROOM", 1, 998, "付费直播", 1);
        PAID_ROOM = r101;
        PaidSceneEnum r102 = new PaidSceneEnum("SUBSCRIBE_ROOM", 2, 11, "会员直播", 101);
        SUBSCRIBE_ROOM = r102;
        PaidSceneEnum r103 = new PaidSceneEnum("PAID_CAMERA", 3, 12, "多机位单独付费", 3);
        PAID_CAMERA = r103;
        PaidSceneEnum r104 = new PaidSceneEnum("PAID_PRIVILEGE_CAMERA", 4, 100, "权益多机位付费", 6);
        PAID_PRIVILEGE_CAMERA = r104;
        PaidSceneEnum r105 = new PaidSceneEnum("PAID_PRIVILEGE_CLARITY", 5, 101, "权益清晰度付费", 4);
        PAID_PRIVILEGE_CLARITY = r105;
        PaidSceneEnum r106 = new PaidSceneEnum("PAID_PRIVILEGE_MSG_BOARD", 6, 102, "权益留言墙", 5);
        PAID_PRIVILEGE_MSG_BOARD = r106;
        PaidSceneEnum r107 = new PaidSceneEnum("PAID_ANCHOR_ROOM", 7, 999, "付费直播-主播房间", 99999);
        PAID_ANCHOR_ROOM = r107;
        PaidSceneEnum r108 = new PaidSceneEnum("PAID_REPLAY_ROOM", 8, 998, "付费直播回放", 1);
        PAID_REPLAY_ROOM = r108;
        PaidSceneEnum r109 = new PaidSceneEnum("SUBSCRIBE_REPLAY_ROOM", 9, 11, "会员直播回放", 101);
        SUBSCRIBE_REPLAY_ROOM = r109;
        PaidSceneEnum r110 = new PaidSceneEnum("PAID_REPLAY_CAMERA", 10, 12, "付费多机位回放", 3);
        PAID_REPLAY_CAMERA = r110;
        PaidSceneEnum r111 = new PaidSceneEnum("PAID_REPLAY_PRIVILEGE_CAMERA", 11, 100, "权益多机位回放", 6);
        PAID_REPLAY_PRIVILEGE_CAMERA = r111;
        PaidSceneEnum r112 = new PaidSceneEnum("PAID_REPLAY_PRIVILEGE_CLARITY", 12, 101, "权益清晰度回放", 4);
        PAID_REPLAY_PRIVILEGE_CLARITY = r112;
        f159401a = new PaidSceneEnum[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112};
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getPaidLiveTypeInt() {
        return this.paidLiveTypeInt;
    }

    public final int getPriority() {
        return this.priority;
    }

    public PaidSceneEnum(String r100, int r101, int r102, String r103, int r104) {
        super(r100, r101);
        this.priority = r102;
        this.desc = r103;
        this.paidLiveTypeInt = r104;
    }
}
