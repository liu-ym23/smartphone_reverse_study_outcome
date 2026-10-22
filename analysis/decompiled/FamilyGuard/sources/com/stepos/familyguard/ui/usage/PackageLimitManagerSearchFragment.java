package com.stepos.familyguard.ui.usage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.fragment.app.ActivityC0516k;
import com.stepos.familyguard.ui.limit.MinorPackageLimitActivity;
import com.stepos.familyguard.ui.limit.PackageLimitActivity;
import com.stepos.familyguard.ui.usage.z;
import com.stepos.minor.ui.MinorLimitSearchActivity;
import java.util.List;

/* loaded from: classes.dex */
public class PackageLimitManagerSearchFragment extends BaseLimitManagerSearchFragment<z.c> {

    /* renamed from: l0, reason: collision with root package name */
    private D2.r<String, Drawable> f14923l0;

    @Override // com.stepos.familyguard.ui.usage.BaseLimitManagerSearchFragment, androidx.fragment.app.ComponentCallbacksC0511f
    public void A0() {
        super.A0();
        this.f14923l0.a();
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void L0() {
        super.L0();
        this.f14923l0.c();
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void Q0() {
        super.Q0();
        this.f14923l0.b();
    }

    @Override // com.stepos.familyguard.ui.usage.BaseLimitManagerSearchFragment
    public AbstractC0599h<z.c> X1(Context context) {
        int iV1 = V1();
        long jU1 = U1();
        if (iV1 == 0) {
            this.f14923l0 = new D2.b(D2.j.a().b());
        } else {
            this.f14923l0 = new D2.n(D2.j.a().c(), jU1);
        }
        return new E(context, this.f14923l0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.stepos.familyguard.ui.usage.BaseLimitManagerSearchFragment
    /* renamed from: d2, reason: merged with bridge method [inline-methods] */
    public void b2(int i5, z.c cVar) {
        ActivityC0516k activityC0516kY1 = y1();
        if (activityC0516kY1 instanceof MinorLimitSearchActivity) {
            MinorPackageLimitActivity.Z(activityC0516kY1, V1(), cVar.f15174b, cVar.f15175c, U1());
        } else {
            PackageLimitActivity.Z(activityC0516kY1, V1(), cVar.f15174b, cVar.f15175c, U1());
        }
    }

    @Override // com.stepos.familyguard.ui.usage.BaseLimitManagerSearchFragment, com.stepos.familyguard.ui.usage.ProxyFragment, androidx.fragment.app.ComponentCallbacksC0511f
    public void v0(Bundle bundle) {
        super.v0(bundle);
        this.f14868i0.h0().g(this, new androidx.lifecycle.C() { // from class: w2.C0
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f23536a.a2((List) obj);
            }
        });
    }
}
