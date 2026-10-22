package com.stepos.familyguard.ui.usage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.fragment.app.ActivityC0516k;
import com.stepos.familyguard.ui.limit.MinorPackageLimitActivity;
import com.stepos.familyguard.ui.limit.PackageLimitActivity;
import com.stepos.familyguard.ui.usage.z;
import com.stepos.minor.ui.MinorLimitManagerActivity;
import java.util.List;

/* loaded from: classes.dex */
public class PackageLimitManagerFragment extends BaseLimitManagerFragment<z.c> {

    /* renamed from: k0, reason: collision with root package name */
    private D2.r<String, Drawable> f14922k0;

    @Override // com.stepos.familyguard.ui.usage.BaseLimitManagerFragment, androidx.fragment.app.ComponentCallbacksC0511f
    public void A0() {
        super.A0();
        this.f14922k0.a();
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void L0() {
        super.L0();
        this.f14922k0.c();
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void Q0() {
        super.Q0();
        this.f14922k0.b();
    }

    @Override // com.stepos.familyguard.ui.usage.BaseLimitManagerFragment
    public AbstractC0598g<z.c> W1(Context context) {
        int iV1 = V1();
        long jU1 = U1();
        if (iV1 == 0) {
            this.f14922k0 = new D2.b(D2.j.a().b());
        } else {
            this.f14922k0 = new D2.n(D2.j.a().c(), jU1);
        }
        return new D(context, this.f14922k0);
    }

    @Override // com.stepos.familyguard.ui.usage.BaseLimitManagerFragment
    /* renamed from: Z1, reason: merged with bridge method [inline-methods] */
    public void Y1(int i5, z.c cVar) {
        ActivityC0516k activityC0516kY1 = y1();
        if (activityC0516kY1 instanceof MinorLimitManagerActivity) {
            MinorPackageLimitActivity.Z(activityC0516kY1, V1(), cVar.f15174b, cVar.f15175c, U1());
        } else {
            PackageLimitActivity.Z(activityC0516kY1, V1(), cVar.f15174b, cVar.f15175c, U1());
        }
    }

    @Override // com.stepos.familyguard.ui.usage.BaseLimitManagerFragment, com.stepos.familyguard.ui.usage.ProxyFragment, androidx.fragment.app.ComponentCallbacksC0511f
    public void v0(Bundle bundle) {
        super.v0(bundle);
        this.f14865i0.d0().g(this, new androidx.lifecycle.C() { // from class: w2.z0
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f23688a.X1((List) obj);
            }
        });
    }
}
