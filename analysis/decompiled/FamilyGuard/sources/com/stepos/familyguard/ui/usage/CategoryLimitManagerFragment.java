package com.stepos.familyguard.ui.usage;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.ActivityC0516k;
import com.stepos.familyguard.ui.limit.CategoryLimitActivity;
import com.stepos.familyguard.ui.limit.MinorCategoryLimitActivity;
import com.stepos.familyguard.ui.usage.z;
import com.stepos.minor.ui.MinorLimitManagerActivity;
import java.util.List;

/* loaded from: classes.dex */
public class CategoryLimitManagerFragment extends BaseLimitManagerFragment<z.a> {
    @Override // com.stepos.familyguard.ui.usage.BaseLimitManagerFragment
    public AbstractC0598g<z.a> W1(Context context) {
        return new C0607p(context);
    }

    @Override // com.stepos.familyguard.ui.usage.BaseLimitManagerFragment
    /* renamed from: Z1, reason: merged with bridge method [inline-methods] */
    public void Y1(int i5, z.a aVar) {
        ActivityC0516k activityC0516kY1 = y1();
        if (activityC0516kY1 instanceof MinorLimitManagerActivity) {
            MinorCategoryLimitActivity.Z(activityC0516kY1, V1(), aVar.f15171b, aVar.f15172c, U1());
        } else {
            CategoryLimitActivity.Z(activityC0516kY1, V1(), aVar.f15171b, aVar.f15172c, U1());
        }
    }

    @Override // com.stepos.familyguard.ui.usage.BaseLimitManagerFragment, com.stepos.familyguard.ui.usage.ProxyFragment, androidx.fragment.app.ComponentCallbacksC0511f
    public void v0(Bundle bundle) {
        super.v0(bundle);
        this.f14865i0.e0().g(this, new androidx.lifecycle.C() { // from class: w2.p
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f23639a.X1((List) obj);
            }
        });
    }
}
