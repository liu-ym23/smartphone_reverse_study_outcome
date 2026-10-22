package com.bytedance.android.livesdk.init;

import com.bytedance.android.live.core.launch.AbsTask;
import com.bytedance.android.live.core.launch.Task;
import com.bytedance.android.live.core.launch.WorkThreadTask;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes9.dex */
@WorkThreadTask
@Task(businessInfo = "WTO_I18nInitTask", value = 1)
public class I18nInitTask extends AbsTask {
    public static final int DELAY_TS_MS = 2000;

    @Override // com.bytedance.android.live.core.launch.AbsTask
    public List<Integer> preTasks() {
        return Arrays.asList(new Integer[]{4});
    }

    @Override // com.bytedance.android.live.core.launch.AbsTask
    public void run() {
        if (tb1.c.f545229a == true) goto L6;
        com.bytedance.android.live.core.i18n.a.b().c(Locale.CHINA);
        return;
    }

    public I18nInitTask() {
    }
}
