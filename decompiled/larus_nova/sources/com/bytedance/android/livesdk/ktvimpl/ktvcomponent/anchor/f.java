package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f144006a = null;

    static {
        f144006a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        final com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        ALogger.i("KtvComponentAnchorLogicWidget", "big event updateRealTimeChorusSwitch success");
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r102 = KtvComponentContext.Companion.a();
        if (r102 == null) goto L6;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r102, new KtvComponentAnchorLogicWidget$onChanged$1$1(r101));
        return;
    }
}
