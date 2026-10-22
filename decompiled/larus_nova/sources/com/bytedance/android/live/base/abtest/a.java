package com.bytedance.android.live.base.abtest;

/* JADX INFO: loaded from: classes45.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ClientABTestKey<String> f58806a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ClientABTestKey<Boolean> f58807b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ClientABTestKey<Integer> f58808c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ClientABTestKey<Boolean> f58809d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ClientABTestKey<Integer> f58810e = null;

    static {
        f58806a = new ClientABTestKey("live_certification_setting_face_identify", String.class, "ali_cloud", 0);
        Boolean r100 = Boolean.FALSE;
        f58807b = new ClientABTestKey("live_schema_enter_live_opt", Boolean.class, r100, 1);
        f58808c = new ClientABTestKey("live_search_enter_live_opt", Integer.class, 0, 1);
        f58809d = new ClientABTestKey("ttlive_rev_link_enter_opt", Boolean.class, r100, 1);
        f58810e = new ClientABTestKey("live_real_name_opt", Integer.class, 0, 1);
    }
}
