package com.bytedance.android.livesdk.chatroom.model.interact;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/SwitchStatus;", "", "", "value", "I", "getValue", "()I", "SWITCH_UNSET", "SWITCH_ON", "SWITCH_OFF", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SwitchStatus extends Enum<SwitchStatus> {
    public static final SwitchStatus SWITCH_OFF = null;
    public static final SwitchStatus SWITCH_ON = null;
    public static final SwitchStatus SWITCH_UNSET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SwitchStatus[] f106941a = null;
    private final int value;

    static {
        SwitchStatus r100 = new SwitchStatus("SWITCH_UNSET", 0, 0);
        SWITCH_UNSET = r100;
        SwitchStatus r101 = new SwitchStatus("SWITCH_ON", 1, 1);
        SWITCH_ON = r101;
        SwitchStatus r102 = new SwitchStatus("SWITCH_OFF", 2, 2);
        SWITCH_OFF = r102;
        f106941a = new SwitchStatus[]{r100, r101, r102};
    }

    public static SwitchStatus valueOf(String r100) {
        return (SwitchStatus) r27.a.a(SwitchStatus.class, r100);
    }

    public static SwitchStatus[] values() {
        return (SwitchStatus[]) f106941a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public SwitchStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
