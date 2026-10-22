package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements IAssetsManager.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f134269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l62.a f134270b;

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
    public final void a() {
        this.f134269a.f134266d.l0(this);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
    public final void b(List<? extends com.bytedance.android.live.core.resources.e> r100) {
        Intrinsics.checkNotNullParameter(r100, "assetsModels");
        a r101 = this.f134269a;
        r101.f134266d.j4(this.f134270b.f507658a, r101.f134264b, 4);
        this.f134269a.f134266d.l0(this);
    }

    public b(a r100, l62.a r101) {
        this.f134269a = r100;
        this.f134270b = r101;
    }
}
