package com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/topcontainer/DiscardReason;", "", "UNKNOW", "INVALID", "EXPIRED", "CONFLICT", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DiscardReason extends Enum<DiscardReason> {
    public static final DiscardReason CONFLICT = null;
    public static final DiscardReason EXPIRED = null;
    public static final DiscardReason INVALID = null;
    public static final DiscardReason UNKNOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DiscardReason[] f133548a = null;

    static {
        DiscardReason r100 = new DiscardReason("UNKNOW", 0);
        UNKNOW = r100;
        DiscardReason r101 = new DiscardReason("INVALID", 1);
        INVALID = r101;
        DiscardReason r102 = new DiscardReason("EXPIRED", 2);
        EXPIRED = r102;
        DiscardReason r103 = new DiscardReason("CONFLICT", 3);
        CONFLICT = r103;
        f133548a = new DiscardReason[]{r100, r101, r102, r103};
    }

    public static DiscardReason valueOf(String r100) {
        return (DiscardReason) a.a(DiscardReason.class, r100);
    }

    public static DiscardReason[] values() {
        return (DiscardReason[]) f133548a.clone();
    }

    public DiscardReason(String r100, int r101) {
        super(r100, r101);
    }
}
