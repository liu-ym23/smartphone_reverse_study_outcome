package com.bytedance.android.live.profile.event;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;

/* JADX INFO: loaded from: classes47.dex */
public final class EventHub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PropertyOwner<com.bytedance.android.live.profile.event.a> f86019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PropertyOwner<com.bytedance.android.live.profile.event.a> f86020b;

    public static final class a {
    }

    static {
    }

    public EventHub() {
        SpreadStateType r100 = SpreadStateType.Close;
        this.f86019a = new PropertyOwner(new com.bytedance.android.live.profile.event.a(r100), EventHub$infoSpreadState$1.INSTANCE);
        this.f86020b = new PropertyOwner(new com.bytedance.android.live.profile.event.a(r100), EventHub$bottomSpreadState$1.INSTANCE);
    }
}
