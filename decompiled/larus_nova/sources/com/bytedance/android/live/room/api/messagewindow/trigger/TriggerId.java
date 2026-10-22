package com.bytedance.android.live.room.api.messagewindow.trigger;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/trigger/TriggerId;", "", "", "value", "I", "getValue", "()I", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "NO_LIMIT_TRIGGER", "ENTER_ROOM_TIME_LIMIT", "CYCLE_DISPLAY_WITH_LIMITED_TIMES_TRIGGER", "EXIT_MIC_TIME_LIMIT", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TriggerId extends Enum<TriggerId> {
    public static final TriggerId CYCLE_DISPLAY_WITH_LIMITED_TIMES_TRIGGER = null;
    public static final TriggerId ENTER_ROOM_TIME_LIMIT = null;
    public static final TriggerId EXIT_MIC_TIME_LIMIT = null;
    public static final TriggerId NO_LIMIT_TRIGGER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TriggerId[] f99039a = null;
    private final String desc;
    private final int value;

    static {
        TriggerId r100 = new TriggerId("NO_LIMIT_TRIGGER", 0, -1, "无需被动触发");
        NO_LIMIT_TRIGGER = r100;
        TriggerId r101 = new TriggerId("ENTER_ROOM_TIME_LIMIT", 1, 1, "进房Ns后触发");
        ENTER_ROOM_TIME_LIMIT = r101;
        TriggerId r102 = new TriggerId("CYCLE_DISPLAY_WITH_LIMITED_TIMES_TRIGGER", 2, 2, "循环展示");
        CYCLE_DISPLAY_WITH_LIMITED_TIMES_TRIGGER = r102;
        TriggerId r103 = new TriggerId("EXIT_MIC_TIME_LIMIT", 3, 1001, "上麦主播下麦前Ns");
        EXIT_MIC_TIME_LIMIT = r103;
        f99039a = new TriggerId[]{r100, r101, r102, r103};
    }

    public static TriggerId valueOf(String r100) {
        return (TriggerId) a.a(TriggerId.class, r100);
    }

    public static TriggerId[] values() {
        return (TriggerId[]) f99039a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getValue() {
        return this.value;
    }

    public TriggerId(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.value = r102;
        this.desc = r103;
    }
}
