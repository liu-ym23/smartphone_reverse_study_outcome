package com.bytedance.android.livesdk.test;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.IRoomService;
import jc1.k;

/* JADX INFO: loaded from: classes11.dex */
public class AutoTestUtils {
    public AutoTestUtils() {
    }

    public static void handleSchema(String r100) {
        ((IRoomService) k.f(IRoomService.class)).actionHandler().handle(s1.getContext(), r100);
    }
}
