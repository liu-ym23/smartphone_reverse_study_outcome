package com.stepos.familyguard.ui.limit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes.dex */
public class MinorPackageLimitActivity extends PackageLimitActivity {
    public static Intent X(Context context, int i5, String str, String str2, long j5) {
        Intent intent = new Intent();
        intent.setClass(context, MinorPackageLimitActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("packageName", str);
        bundle.putString("app_label", str2);
        bundle.putInt("proxy", i5);
        bundle.putLong("operator_id", j5);
        intent.putExtras(bundle);
        return intent;
    }

    public static void Z(Context context, int i5, String str, String str2, long j5) {
        context.startActivity(X(context, i5, str, str2, j5));
    }
}
