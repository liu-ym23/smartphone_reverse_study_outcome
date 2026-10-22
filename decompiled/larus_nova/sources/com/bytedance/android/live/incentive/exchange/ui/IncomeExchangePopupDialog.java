package com.bytedance.android.live.incentive.exchange.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/incentive/exchange/ui/IncomeExchangePopupDialog;", "Landroidx/appcompat/app/AppCompatDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IncomeExchangePopupDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f69369a = 0;

    public static final class a {
    }

    public static final class b {
    }

    static {
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onStop() {
        super.onStop();
        throw null;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(R.layout.ttlive_incentive_income_exchange_popup_dialog);
        View r101 = findViewById(R.id.exchange_dialog_root);
        Intrinsics.checkNotNull(r101);
        ViewGroup r102 = (ViewGroup) r101;
        Intrinsics.checkNotNullParameter(r102, "rootView");
        r102.findViewById(R.id.close_btn);
        HSImageView r103 = (HSImageView) r102.findViewById(R.id.gift_icon);
        TextView r104 = (TextView) r102.findViewById(R.id.title);
        TextView r105 = (TextView) r102.findViewById(R.id.primary_description);
        TextView r106 = (TextView) r102.findViewById(R.id.secondary_description);
        Button r107 = (Button) r102.findViewById(R.id.exchange_btn);
    }
}
