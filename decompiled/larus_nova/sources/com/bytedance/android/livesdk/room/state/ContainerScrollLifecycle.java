package com.bytedance.android.livesdk.room.state;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/room/state/ContainerScrollLifecycle;", "", "ON_PAGE_SCROLL_STATE_CHANGED", "ON_PAGE_SELECTED", "room-flow_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ContainerScrollLifecycle extends Enum<ContainerScrollLifecycle> {
    public static final ContainerScrollLifecycle ON_PAGE_SCROLL_STATE_CHANGED = null;
    public static final ContainerScrollLifecycle ON_PAGE_SELECTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContainerScrollLifecycle[] f157816a = null;

    static {
        ContainerScrollLifecycle r100 = new ContainerScrollLifecycle("ON_PAGE_SCROLL_STATE_CHANGED", 0);
        ON_PAGE_SCROLL_STATE_CHANGED = r100;
        ContainerScrollLifecycle r101 = new ContainerScrollLifecycle("ON_PAGE_SELECTED", 1);
        ON_PAGE_SELECTED = r101;
        f157816a = new ContainerScrollLifecycle[]{r100, r101};
    }

    public static ContainerScrollLifecycle valueOf(String r100) {
        return (ContainerScrollLifecycle) a.a(ContainerScrollLifecycle.class, r100);
    }

    public static ContainerScrollLifecycle[] values() {
        return (ContainerScrollLifecycle[]) f157816a.clone();
    }

    public ContainerScrollLifecycle(String r100, int r101) {
        super(r100, r101);
    }
}
