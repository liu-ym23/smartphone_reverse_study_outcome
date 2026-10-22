package com.bytedance.android.shopping.anchorv4.log;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;

/* JADX INFO: loaded from: classes12.dex */
public interface b {
    CommonMeta a();

    LifecycleOwner getLifecycleOwner();

    String getSessionId();
}
