package com.bytedance.applog.monitor;

import com.ss.android.common.applog.EventVerify;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import com.xiaomi.mipush.sdk.MiPushClient;
import r27.a;

/* JADX INFO: loaded from: classes6.dex */
public final enum MonitorKey extends Enum<MonitorKey> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MonitorKey[] f192490a = null;
    public static final MonitorKey ab_config = null;
    public static final MonitorKey active = null;
    public static final MonitorKey config = null;
    public static final MonitorKey database = null;
    public static final MonitorKey engine = null;
    public static final MonitorKey event = null;
    public static final MonitorKey event_v3 = null;
    public static final MonitorKey f_cache_event = null;
    public static final MonitorKey f_db_insert_event = null;
    public static final MonitorKey f_expire_event = null;
    public static final MonitorKey f_oom_event = null;
    public static final MonitorKey f_to_bytes_encrypt_event = null;
    public static final MonitorKey f_to_bytes_event = null;
    public static final MonitorKey f_to_pack_event = null;
    public static final MonitorKey filtered_event = null;
    public static final MonitorKey item_impression = null;
    public static final MonitorKey large_event = null;
    public static final MonitorKey launch = null;
    public static final MonitorKey log_data = null;
    public static final MonitorKey log_send = null;
    public static final MonitorKey migrate_old = null;
    public static final MonitorKey monitor_default = null;
    public static final MonitorKey pack = null;
    public static final MonitorKey real_event = null;
    public static final MonitorKey register = null;
    public static final MonitorKey sampling_event = null;
    public static final MonitorKey terminate = null;

    static {
        MonitorKey r100 = new MonitorKey("monitor_default", 0);
        monitor_default = r100;
        MonitorKey r101 = new MonitorKey("event", 1);
        event = r101;
        MonitorKey r102 = new MonitorKey("event_v3", 2);
        event_v3 = r102;
        MonitorKey r103 = new MonitorKey("log_data", 3);
        log_data = r103;
        MonitorKey r104 = new MonitorKey(EventVerify.TYPE_ITEM_IMPRESSION, 4);
        item_impression = r104;
        MonitorKey r105 = new MonitorKey(EventVerify.TYPE_LAUNCH, 5);
        launch = r105;
        MonitorKey r110 = new MonitorKey(EventVerify.TYPE_TERMINATE, 6);
        terminate = r110;
        MonitorKey r111 = new MonitorKey("real_event", 7);
        real_event = r111;
        MonitorKey r112 = new MonitorKey("pack", 8);
        pack = r112;
        MonitorKey r113 = new MonitorKey("database", 9);
        database = r113;
        MonitorKey r114 = new MonitorKey(MiPushClient.COMMAND_REGISTER, 10);
        register = r114;
        MonitorKey r115 = new MonitorKey("active", 11);
        active = r115;
        MonitorKey r106 = new MonitorKey("config", 12);
        config = r106;
        MonitorKey r107 = new MonitorKey(ICEffectKeys.KEY_IS_IC_EFFECT_AB_CONFIG, 13);
        ab_config = r107;
        MonitorKey r108 = new MonitorKey("engine", 14);
        engine = r108;
        MonitorKey r109 = new MonitorKey("log_send", 15);
        log_send = r109;
        MonitorKey r116 = new MonitorKey("migrate_old", 16);
        migrate_old = r116;
        MonitorKey r117 = new MonitorKey("f_cache_event", 17);
        f_cache_event = r117;
        MonitorKey r118 = new MonitorKey("filtered_event", 18);
        filtered_event = r118;
        MonitorKey r119 = new MonitorKey("f_db_insert_event", 19);
        f_db_insert_event = r119;
        MonitorKey r120 = new MonitorKey("f_to_pack_event", 20);
        f_to_pack_event = r120;
        MonitorKey r121 = new MonitorKey("sampling_event", 21);
        sampling_event = r121;
        MonitorKey r122 = new MonitorKey("f_to_bytes_event", 22);
        f_to_bytes_event = r122;
        MonitorKey r123 = new MonitorKey("f_to_bytes_encrypt_event", 23);
        f_to_bytes_encrypt_event = r123;
        MonitorKey r124 = new MonitorKey("large_event", 24);
        large_event = r124;
        MonitorKey r125 = new MonitorKey("f_expire_event", 25);
        f_expire_event = r125;
        MonitorKey r126 = new MonitorKey("f_oom_event", 26);
        f_oom_event = r126;
        f192490a = new MonitorKey[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126};
    }

    public static MonitorKey[] values() {
        return (MonitorKey[]) f192490a.clone();
    }

    public static MonitorKey valueOf(String r100) {
        return (MonitorKey) a.a(MonitorKey.class, r100);
    }

    public MonitorKey(String r100, int r101) {
        super(r100, r101);
    }
}
