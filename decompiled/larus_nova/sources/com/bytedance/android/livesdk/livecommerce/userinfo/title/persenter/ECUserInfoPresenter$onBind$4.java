package com.bytedance.android.livesdk.livecommerce.userinfo.title.persenter;

import com.bytedance.android.livesdk.livecommerce.userinfo.title.state.ECUserInfoState;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECUserInfoPresenter$onBind$4 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new ECUserInfoPresenter$onBind$4();
    }

    public ECUserInfoPresenter$onBind$4() {
        super(ECUserInfoState.class, "background", "getBackground()Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/state/ECUserInfoState$BackgroundState;", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
    public Object get(Object r100) {
        return ((ECUserInfoState) r100).f152998c;
    }
}
