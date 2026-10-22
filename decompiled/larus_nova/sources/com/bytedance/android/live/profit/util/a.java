package com.bytedance.android.live.profit.util;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAssetsManager f89081a;

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.util.a$a, reason: collision with other inner class name */
    public static final class C1366a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f89082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f89083b;

        public C1366a(a r100, b r101) {
            this.f89082a = r100;
            this.f89083b = r101;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f89082a.f89081a.l0(this.f89083b);
        }
    }

    public static final class b implements IAssetsManager.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f89084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SingleEmitter f89085b;

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
        public final void a() {
            this.f89084a.f89081a.l0(this);
            this.f89085b.onError(new Error("failed to sync assets"));
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
        public final void b(List<? extends com.bytedance.android.live.core.resources.e> r100) {
            Intrinsics.checkNotNullParameter(r100, "assetsModels");
            this.f89084a.f89081a.l0(this);
            this.f89085b.onSuccess(Unit.INSTANCE);
        }

        public b(a r100, SingleEmitter r101) {
            this.f89084a = r100;
            this.f89085b = r101;
        }
    }

    public a(IAssetsManager r100) {
        this.f89081a = r100;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        b r101 = new b(this, r100);
        r100.setDisposable(Disposables.fromAction(new C1366a(this, r101)));
        this.f89081a.T(r101);
    }
}
