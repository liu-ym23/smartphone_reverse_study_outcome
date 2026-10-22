package com.bytedance.android.live.broadcast.api.interacttools;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/interacttools/InteractToolStatus;", "", GXAnimation.STATE_START, GXAnimation.STATE_END, "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InteractToolStatus extends Enum<InteractToolStatus> {
    public static final InteractToolStatus END = null;
    public static final InteractToolStatus START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InteractToolStatus[] f59008a = null;

    static {
        InteractToolStatus r100 = new InteractToolStatus(GXAnimation.STATE_START, 0);
        START = r100;
        InteractToolStatus r101 = new InteractToolStatus(GXAnimation.STATE_END, 1);
        END = r101;
        f59008a = new InteractToolStatus[]{r100, r101};
    }

    public static InteractToolStatus valueOf(String r100) {
        return (InteractToolStatus) a.a(InteractToolStatus.class, r100);
    }

    public static InteractToolStatus[] values() {
        return (InteractToolStatus[]) f59008a.clone();
    }

    public InteractToolStatus(String r100, int r101) {
        super(r100, r101);
    }
}
