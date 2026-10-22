package b02;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.RoundWaveAnimationView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class s<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoundWaveAnimationView f16852a;

    public s(RoundWaveAnimationView r100) {
        this.f16852a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f16852a.a();
    }
}
