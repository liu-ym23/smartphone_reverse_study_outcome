package com.bytedance.android.live.browser;

/* JADX INFO: loaded from: classes45.dex */
public interface c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Integer> f62589a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Integer> f62590b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f62591c = null;

    static {
        f62589a = new com.bytedance.android.livesdk.sharedpref.e("live_end_live_location_exposure_count", 0);
        f62590b = new com.bytedance.android.livesdk.sharedpref.e("live_preview_location_show_state", 0);
        f62591c = new com.bytedance.android.livesdk.sharedpref.e("live_preview_location_closed_actively", Boolean.FALSE);
    }
}
