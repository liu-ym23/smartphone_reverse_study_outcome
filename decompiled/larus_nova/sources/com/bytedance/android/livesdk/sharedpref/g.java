package com.bytedance.android.livesdk.sharedpref;

import com.bytedance.android.live.base.model.ImageModel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public interface g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e<Long> f158362a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e<Long> f158363b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e<ImageModel> f158364c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e<List<Long>> f158365d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e<Long> f158366e = null;

    static {
        f158362a = new e("gift_cycle_release_id", -1L);
        f158363b = new e("gift_cycle_release_gift_id", -1L);
        f158364c = new e("gift_cycle_release_image", new ImageModel());
        f158365d = new e("gift_cycle_release_gift_ids", new ArrayList());
        f158366e = new e("gift_cycle_release_time", -1L);
    }
}
