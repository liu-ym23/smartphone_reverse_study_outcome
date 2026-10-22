package com.bytedance.android.live.browser.jsbridge;

import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.browser.jsbridge.newmethods.d2;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeMethodFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class l implements IJsBridgeMethodFactory {
    public l() {
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.IJsBridgeMethodFactory
    public final com.bytedance.ies.web.jsbridge2.g<?, ?> provideCloseMethod(DialogFragment r100) {
        Intrinsics.checkNotNullParameter(r100, "dialogFragment");
        return new d2(r100);
    }
}
