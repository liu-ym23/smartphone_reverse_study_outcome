package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class uf extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final uf f121368a = null;

    static {
        f121368a = new uf();
    }

    public uf() {
        Boolean r100 = Boolean.TRUE;
        super("live_backend_change_room_id_observe", "换房场景下backend接口用原来的roomid监听", r100, r100);
    }
}
