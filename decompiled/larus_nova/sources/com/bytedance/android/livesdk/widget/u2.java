package com.bytedance.android.livesdk.widget;

import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class u2<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WishFinishGestureWidget f162156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f162157b;

    public static final class a implements IFetchEffectListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SingleEmitter f162158a;

        @Override // com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener
        public final void onStart(Effect r100) {
        }

        public a(SingleEmitter r100) {
            this.f162158a = r100;
        }

        @Override // com.ss.android.ugc.effectmanager.common.task.IEffectPlatformBaseListener
        public final void onSuccess(Effect r100) {
            this.f162158a.onSuccess(Unit.INSTANCE);
        }

        @Override // com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener
        public final void onFail(Effect r100, ExceptionResult r101) {
            Intrinsics.checkNotNullParameter(r101, "e");
            Objects.toString(r101);
            if (r101.getException() == null) goto L5;
            this.f162158a.onError(r101.getException());
            return;
        L5:
            this.f162158a.onError(new Throwable(r101.getMsg()));
        }
    }

    public u2(WishFinishGestureWidget r100, long r101) {
        this.f162156a = r100;
        this.f162157b = r101;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        ILiveEffectComposerManager r101 = this.f162156a.f161394c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("composerManager");
    L5:
        r100.setDisposable(r101.s(com.bytedance.android.live.effect.api.d0.f66752b, String.valueOf(this.f162157b), new a(r100)));
    }
}
