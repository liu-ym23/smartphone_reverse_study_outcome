package com.bytedance.android.live.revlink.impl.control.launchcontext;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/control/launchcontext/PkAnchorLaunchType;", "", "RECEIVE_REPLY", "REPLY_SUCCESS", "REPLY_SUCCESS_ADVANCE", "SWITCH_FROM_LINK", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PkAnchorLaunchType extends Enum<PkAnchorLaunchType> {
    public static final PkAnchorLaunchType RECEIVE_REPLY = null;
    public static final PkAnchorLaunchType REPLY_SUCCESS = null;
    public static final PkAnchorLaunchType REPLY_SUCCESS_ADVANCE = null;
    public static final PkAnchorLaunchType SWITCH_FROM_LINK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PkAnchorLaunchType[] f92422a = null;

    static {
        PkAnchorLaunchType r100 = new PkAnchorLaunchType("RECEIVE_REPLY", 0);
        RECEIVE_REPLY = r100;
        PkAnchorLaunchType r101 = new PkAnchorLaunchType("REPLY_SUCCESS", 1);
        REPLY_SUCCESS = r101;
        PkAnchorLaunchType r102 = new PkAnchorLaunchType("REPLY_SUCCESS_ADVANCE", 2);
        REPLY_SUCCESS_ADVANCE = r102;
        PkAnchorLaunchType r103 = new PkAnchorLaunchType("SWITCH_FROM_LINK", 3);
        SWITCH_FROM_LINK = r103;
        f92422a = new PkAnchorLaunchType[]{r100, r101, r102, r103};
    }

    public static PkAnchorLaunchType valueOf(String r100) {
        return (PkAnchorLaunchType) r27.a.a(PkAnchorLaunchType.class, r100);
    }

    public static PkAnchorLaunchType[] values() {
        return (PkAnchorLaunchType[]) f92422a.clone();
    }

    public PkAnchorLaunchType(String r100, int r101) {
        super(r100, r101);
    }
}
