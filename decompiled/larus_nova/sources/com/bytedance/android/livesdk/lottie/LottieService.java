package com.bytedance.android.livesdk.lottie;

import com.bytedance.android.live.lottie.ILottieService;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

/* JADX INFO: loaded from: classes10.dex */
public class LottieService implements ILottieService {

    public class a implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f153466a;

        public a(ObservableEmitter r100) {
            this.f153466a = r100;
        }
    }

    public static /* synthetic */ void b(LottieService r100, long r101, boolean r102, ObservableEmitter r103) {
        r100.lambda$tryStartLottieAnimation$0(r101, r102, r103);
    }

    public LottieService() {
        jc1.k.l(ILottieService.class, this);
    }

    @Override // com.bytedance.android.live.lottie.ILottieService
    public void finishLottieAnimation() {
        xs2.b.a().post(new i());
    }

    @Override // com.bytedance.android.live.lottie.ILottieService
    public Observable<Integer> tryStartLottieAnimation(final long r100, final boolean r101) {
        return Observable.create(new l(this, r100, r101));
    }

    private /* synthetic */ void lambda$tryStartLottieAnimation$0(long r100, boolean r101, ObservableEmitter r102) throws Exception {
        xs2.b.a().post(new k(r100, r101, new a(r102)));
    }
}
