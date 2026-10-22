package com.stepos.familyguard.ui.usage;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.ActivityC0516k;
import com.stepos.familyguard.ui.limit.CategoryLimitActivity;
import com.stepos.familyguard.ui.limit.MinorCategoryLimitActivity;
import com.stepos.familyguard.ui.usage.z;
import com.stepos.minor.ui.MinorLimitSearchActivity;
import java.util.List;

/* loaded from: classes.dex */
public class CategoryLimitManagerSearchFragment extends BaseLimitManagerSearchFragment<z.a> {
    @Override // com.stepos.familyguard.ui.usage.BaseLimitManagerSearchFragment
    public AbstractC0599h<z.a> X1(Context context) {
        return new C0608q(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.stepos.familyguard.ui.usage.BaseLimitManagerSearchFragment
    /* renamed from: d2, reason: merged with bridge method [inline-methods] */
    public void b2(int i5, z.a aVar) {
        ActivityC0516k activityC0516kY1 = y1();
        if (activityC0516kY1 instanceof MinorLimitSearchActivity) {
            MinorCategoryLimitActivity.Z(activityC0516kY1, V1(), aVar.f15171b, aVar.f15172c, U1());
        } else {
            CategoryLimitActivity.Z(activityC0516kY1, V1(), aVar.f15171b, aVar.f15172c, U1());
        }
    }

    @Override // com.stepos.familyguard.ui.usage.BaseLimitManagerSearchFragment, com.stepos.familyguard.ui.usage.ProxyFragment, androidx.fragment.app.ComponentCallbacksC0511f
    public void v0(Bundle bundle) {
        super.v0(bundle);
        this.f14868i0.g0().g(this, new androidx.lifecycle.C() { // from class: w2.s
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f23661a.a2((List) obj);
            }
        });
    }
}
