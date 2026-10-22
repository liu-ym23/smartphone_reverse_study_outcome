package com.stepos.familyguard.ui.limit;

import android.os.Bundle;
import com.stepos.familyguard.R;
import com.stepos.policy.sdk.util.PolicySdkStatusbarColorUtils;
import java.lang.reflect.InvocationTargetException;
import r2.c;

/* loaded from: classes.dex */
public class EditPeriodPopupLiteActivity extends c {
    @Override // r2.c, stepos.support.v7.app.n, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R.layout.us_edit_period_activity);
        PolicySdkStatusbarColorUtils.setStatusBarDarkIcon(this, !((getResources().getConfiguration().uiMode & 32) == 32));
    }
}
