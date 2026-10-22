package com.bytedance.android.livesdk.interactivity.barrage.setting.vs;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xs2.b;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/setting/vs/AbsBarrageSettingWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsBarrageSettingWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BarrageSetting f133928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f133929b;

    public interface a {
        void X50(BarrageSetting r100);
    }

    public void yq(boolean r100) {
    }

    public final void wq() {
        b.a().post(new q22.b(this.f133928a));
    }

    public void xq(BarrageSetting r100) {
        Intrinsics.checkNotNullParameter(r100, "barrageSetting");
        this.f133928a = r100;
    }

    public AbsBarrageSettingWidget(BarrageSetting r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "mBarrageSetting");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f133928a = r100;
        this.f133929b = r101;
    }
}
