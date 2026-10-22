package com.bytedance.android.live.cloudgrouplive.rtc;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/cloudgrouplive/rtc/GroupLiveStreamStatus;", "", "", "des", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", "STARTED", "STOPPED", "multilink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum GroupLiveStreamStatus extends Enum<GroupLiveStreamStatus> {
    public static final GroupLiveStreamStatus STARTED = null;
    public static final GroupLiveStreamStatus STOPPED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GroupLiveStreamStatus[] f64477a = null;
    private final String des;

    static {
        GroupLiveStreamStatus r100 = new GroupLiveStreamStatus("STARTED", 0, "started");
        STARTED = r100;
        GroupLiveStreamStatus r101 = new GroupLiveStreamStatus("STOPPED", 1, "stopped");
        STOPPED = r101;
        f64477a = new GroupLiveStreamStatus[]{r100, r101};
    }

    public static GroupLiveStreamStatus valueOf(String r100) {
        return (GroupLiveStreamStatus) r27.a.a(GroupLiveStreamStatus.class, r100);
    }

    public static GroupLiveStreamStatus[] values() {
        return (GroupLiveStreamStatus[]) f64477a.clone();
    }

    public final String getDes() {
        return this.des;
    }

    public GroupLiveStreamStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.des = r102;
    }
}
