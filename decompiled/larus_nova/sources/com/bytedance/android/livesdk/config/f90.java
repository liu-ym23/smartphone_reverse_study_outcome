package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class f90 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f90 f120183a = null;

    static {
        f120183a = new f90();
    }

    public f90() {
        Boolean r100 = Boolean.TRUE;
        super("live_mic_room_enable_link_guest_opt", "麦序房是否开启连线嘉宾重新进入过滤", r100, r100);
    }
}
