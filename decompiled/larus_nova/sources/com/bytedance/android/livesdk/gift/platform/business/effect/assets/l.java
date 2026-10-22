package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f129109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f129110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f129111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AssetDownloadPriority f129112d;

    public static final class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f129113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f129114b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f129115c;

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void onProgress(int r100) {
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void a(long r110) {
            ObservableEmitter r100 = this.f129115c;
            com.bytedance.android.live.core.resources.e r101 = this.f129114b.f129109a.G1(r110);
            if (r101 == null) goto L5;
            int r102 = r101.getResourceType();
        L6:
            r100.onNext(new k.a(r110, null, -1, r102, false, 18));
            this.f129115c.onComplete();
            return;
        L5:
            r102 = 0;
            goto L6
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void b(boolean r100) {
            this.f129113a = r100;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void onFailed(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "t");
            this.f129115c.onError(r100);
        }

        public a(l r100, ObservableEmitter r101) {
            this.f129114b = r100;
            this.f129115c = r101;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void c(long r110, String r111) {
            Intrinsics.checkNotNullParameter(r111, "path");
            ObservableEmitter r100 = this.f129115c;
            com.bytedance.android.live.core.resources.e r101 = this.f129114b.f129109a.G1(r110);
            if (r101 == null) goto L5;
            int r102 = r101.getResourceType();
        L6:
            r100.onNext(new k.a(r110, r111, 0, r102, this.f129113a, 4));
            this.f129115c.onComplete();
            return;
        L5:
            r102 = 0;
            goto L6
        }
    }

    public l(IAssetsManager r100, long r101, int r102, AssetDownloadPriority r103) {
        this.f129109a = r100;
        this.f129110b = r101;
        this.f129111c = r102;
        this.f129112d = r103;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<k.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.f129109a.r0(this.f129110b, new a(this, r100), this.f129111c, this.f129112d);
    }
}
