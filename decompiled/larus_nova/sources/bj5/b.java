package bj5;

import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends c0c.b implements BenefitManagerAPI {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BenefitManagerAPI f19243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f19244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<BenefitManagerAPI> f19245d;

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final BenefitStore R7(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        return this.f19243b.R7(r100, r101);
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final Object d8(String r100, int r101, String r102, BenefitManagerAPI.CacheType r110, Continuation<? super BenefitStore> r111) {
        return this.f19243b.d8(r100, r101, r102, r110, r111);
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final void destroy() {
        this.f19243b.destroy();
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final BenefitStore g7(String r100, int r101, BenefitManagerAPI.CacheType r102) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r102, "cacheType");
        return this.f19243b.g7(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final BenefitStore n1() {
        return this.f19243b.n1();
    }

    @Override // c0c.b
    public final void lf(f0c.b r100) {
        Intrinsics.checkNotNullParameter(r100, "toState");
        Intrinsics.checkNotNullParameter(r100, "toState");
        this.f19245d.c().destroy();
    }

    public b(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<BenefitManagerAPI> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), BenefitManagerAPI.class), BenefitManagerAPI.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f19243b = r103.b();
        this.f19244c = r101;
        this.f19245d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        v r102 = this.f19244c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        BenefitManagerAPI r104 = (BenefitManagerAPI) k.b(r102.c(r103), BenefitManagerAPI.class);
        this.f19245d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
