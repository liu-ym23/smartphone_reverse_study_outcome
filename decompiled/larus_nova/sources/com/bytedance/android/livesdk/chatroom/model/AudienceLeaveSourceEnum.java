package com.bytedance.android.livesdk.chatroom.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/AudienceLeaveSourceEnum;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "AudienceLeave_Unknown", "AudienceLeave_Leave", "AudienceLeave_Kick_Out", "AudienceLeave_Sys_Kick_Out", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AudienceLeaveSourceEnum extends Enum<AudienceLeaveSourceEnum> {
    public static final AudienceLeaveSourceEnum AudienceLeave_Kick_Out = null;
    public static final AudienceLeaveSourceEnum AudienceLeave_Leave = null;
    public static final AudienceLeaveSourceEnum AudienceLeave_Sys_Kick_Out = null;
    public static final AudienceLeaveSourceEnum AudienceLeave_Unknown = null;
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudienceLeaveSourceEnum[] f106889a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.chatroom.model.AudienceLeaveSourceEnum$a] */
    static {
        AudienceLeaveSourceEnum r100 = new AudienceLeaveSourceEnum("AudienceLeave_Unknown", 0, 0);
        AudienceLeave_Unknown = r100;
        AudienceLeaveSourceEnum r101 = new AudienceLeaveSourceEnum("AudienceLeave_Leave", 1, 1);
        AudienceLeave_Leave = r101;
        AudienceLeaveSourceEnum r102 = new AudienceLeaveSourceEnum("AudienceLeave_Kick_Out", 2, 2);
        AudienceLeave_Kick_Out = r102;
        AudienceLeaveSourceEnum r103 = new AudienceLeaveSourceEnum("AudienceLeave_Sys_Kick_Out", 3, 3);
        AudienceLeave_Sys_Kick_Out = r103;
        f106889a = new AudienceLeaveSourceEnum[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static AudienceLeaveSourceEnum valueOf(String r100) {
        return (AudienceLeaveSourceEnum) r27.a.a(AudienceLeaveSourceEnum.class, r100);
    }

    public static AudienceLeaveSourceEnum[] values() {
        return (AudienceLeaveSourceEnum[]) f106889a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public AudienceLeaveSourceEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
