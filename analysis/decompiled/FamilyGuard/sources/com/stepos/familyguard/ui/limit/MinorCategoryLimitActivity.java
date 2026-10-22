package com.stepos.familyguard.ui.limit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes.dex */
public class MinorCategoryLimitActivity extends CategoryLimitActivity {
    public static Intent X(Context context, int i5, int i6, String str, long j5) {
        Intent intent = new Intent();
        intent.setClass(context, MinorCategoryLimitActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("categoryId", i6);
        bundle.putString("category_label", str);
        bundle.putInt("proxy", i5);
        bundle.putLong("operator_id", j5);
        intent.putExtras(bundle);
        return intent;
    }

    public static void Z(Context context, int i5, int i6, String str, long j5) {
        context.startActivity(X(context, i5, i6, str, j5));
    }
}
