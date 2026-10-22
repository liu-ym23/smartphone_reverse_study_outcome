package com.bytedance.android.livesdk.announcement.time;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.widget.LiveNumberPicker;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements LiveNumberPicker.a {
    public e() {
    }

    @Override // com.bytedance.android.livesdk.widget.LiveNumberPicker.a
    public final void a() {
        f2.c("已选周期性时间，单场日期不可选", 0);
    }
}
