package com.bytedance.android.ec.hybrid.service;

import android.app.Activity;
import android.graphics.Bitmap;
import android.widget.ImageView;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/hybrid/service/IMallDeepFeedAnimationService;", "", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMallDeepFeedAnimationService {
    boolean a(Activity r100);

    ImageView b(Activity r100, Bitmap r101, boolean r102);

    void c(Activity r100);

    void clear();
}
