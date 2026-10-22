package com.bytedance.android.live.browser.jsbridge.base;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/BattleLaunchType;", "", "", "type", "I", "getType", "()I", "Invite", "Reply", "Open", "SwitchAndOpen", "BizInvite", "BizEnd", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum BattleLaunchType extends Enum<BattleLaunchType> {
    public static final BattleLaunchType BizEnd = null;
    public static final BattleLaunchType BizInvite = null;
    public static final BattleLaunchType Invite = null;
    public static final BattleLaunchType Open = null;
    public static final BattleLaunchType Reply = null;
    public static final BattleLaunchType SwitchAndOpen = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BattleLaunchType[] f62962a = null;
    private final int type;

    static {
        BattleLaunchType r100 = new BattleLaunchType("Invite", 0, 1);
        Invite = r100;
        BattleLaunchType r101 = new BattleLaunchType("Reply", 1, 2);
        Reply = r101;
        BattleLaunchType r102 = new BattleLaunchType("Open", 2, 3);
        Open = r102;
        BattleLaunchType r103 = new BattleLaunchType("SwitchAndOpen", 3, 4);
        SwitchAndOpen = r103;
        BattleLaunchType r104 = new BattleLaunchType("BizInvite", 4, 5);
        BizInvite = r104;
        BattleLaunchType r105 = new BattleLaunchType("BizEnd", 5, 6);
        BizEnd = r105;
        f62962a = new BattleLaunchType[]{r100, r101, r102, r103, r104, r105};
    }

    public static BattleLaunchType valueOf(String r100) {
        return (BattleLaunchType) a.a(BattleLaunchType.class, r100);
    }

    public static BattleLaunchType[] values() {
        return (BattleLaunchType[]) f62962a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public BattleLaunchType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
