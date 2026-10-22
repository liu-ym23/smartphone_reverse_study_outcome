package com.bytedance.android.live.effect.composer;

import com.bytedance.android.livesdk.widget.u2;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.effect.api.k f67932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f67933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IFetchEffectListener f67934c;

    public static final class a implements IFetchEffectListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f67935a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f67936b;

        @Override // com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener
        public final void onStart(Effect r100) {
            IFetchEffectListener r101 = this.f67935a.f67934c;
            if (r101 == null) goto L6;
            r101.onStart(r100);
            return;
        }

        @Override // com.ss.android.ugc.effectmanager.common.task.IEffectPlatformBaseListener
        public final void onSuccess(Effect r100) {
            Effect r101 = r100;
            if (r101 != null) goto L7;
            Exception r102 = new Exception("effect is null");
            this.f67936b.onError(r102);
            IFetchEffectListener r103 = this.f67935a.f67934c;
            if (r103 == null) goto L9;
            r103.onFail(r101, new ExceptionResult(r102));
            return;
        L9:
            return;
        L7:
            this.f67936b.onNext(r101);
            this.f67936b.onComplete();
        }

        public a(c r100, ObservableEmitter r101) {
            this.f67935a = r100;
            this.f67936b = r101;
        }

        @Override // com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener
        public final void onFail(Effect r100, ExceptionResult r101) {
            Intrinsics.checkNotNullParameter(r101, "e");
            this.f67936b.onError(r101.getException());
            IFetchEffectListener r102 = this.f67935a.f67934c;
            if (r102 == null) goto L6;
            r102.onFail(r100, r101);
            return;
        }
    }

    public c(com.bytedance.android.live.effect.api.k r100, String r101, u2.a r102) {
        this.f67932a = r100;
        this.f67933b = r101;
        this.f67934c = r102;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Effect> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        this.f67932a.d(this.f67933b, new a(this, r100));
    }
}
