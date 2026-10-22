package com.bytedance.android.shopping.prepurchase.arch.standard.component.pref;

import android.os.MessageQueue;
import com.bytedance.android.ec.core.anchorv3.PdpMessageOpt;
import com.bytedance.android.ec.core.utils.UIUtils;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements MessageQueue.IdleHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskScheduler f181011a;

    public f(TaskScheduler r100) {
        this.f181011a = r100;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        Lazy r100 = UIUtils.f45548a;
        return UIUtils.c().postDelayed(this.f181011a.f180999d, PdpMessageOpt.f43752b.h());
    }
}
