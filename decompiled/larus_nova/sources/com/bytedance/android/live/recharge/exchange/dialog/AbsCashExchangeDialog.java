package com.bytedance.android.live.recharge.exchange.dialog;

import android.content.Context;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.live.recharge.model.ExchangeType;
import com.larus.nova.R;
import java.util.Map;
import kotlin.Metadata;
import py.k;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/recharge/exchange/dialog/AbsCashExchangeDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class AbsCashExchangeDialog extends AppCompatDialog {
    public abstract void I0(ExchangeType r100, k r101, long r102, String r103, boolean r104, Map<String, String> r105, zv0.e r106);

    public AbsCashExchangeDialog(Context r100) {
        super(r100, R.style.ttlive_live_dialog);
    }
}
