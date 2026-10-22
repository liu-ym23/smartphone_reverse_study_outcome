package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/InterruptReason;", "", "TheSameTypeCompWannaShow", "OtherHighPriorityCompShow", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InterruptReason extends Enum<InterruptReason> {
    public static final InterruptReason OtherHighPriorityCompShow = null;
    public static final InterruptReason TheSameTypeCompWannaShow = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InterruptReason[] f133409a = null;

    static {
        InterruptReason r100 = new InterruptReason("TheSameTypeCompWannaShow", 0);
        TheSameTypeCompWannaShow = r100;
        InterruptReason r101 = new InterruptReason("OtherHighPriorityCompShow", 1);
        OtherHighPriorityCompShow = r101;
        f133409a = new InterruptReason[]{r100, r101};
    }

    public static InterruptReason valueOf(String r100) {
        return (InterruptReason) r27.a.a(InterruptReason.class, r100);
    }

    public static InterruptReason[] values() {
        return (InterruptReason[]) f133409a.clone();
    }

    public InterruptReason(String r100, int r101) {
        super(r100, r101);
    }
}
