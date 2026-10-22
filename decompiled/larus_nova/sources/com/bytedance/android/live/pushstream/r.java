package com.bytedance.android.live.pushstream;

import com.bytedance.android.live.base.BaseServices;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livehostapi.platform.IHostMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class r<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f89423a = null;

    static {
        f89423a = new r();
    }

    public r() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ALogger.e("AudioSamiDiagnosisImpl", "createLiveStream: e: " + r101.getMessage());
        String r102 = "AudioSamiDiagnosisImpl " + r101.getMessage();
        SettingKey<Boolean> r103 = LiveTracingMonitor.f64909a;
        IHostMonitor r104 = (IHostMonitor) BaseServices.as(IHostMonitor.class);
        if (r104 == null) goto L6;
        r104.ensureNotReachHere(r101, r102);
        return;
    }
}
