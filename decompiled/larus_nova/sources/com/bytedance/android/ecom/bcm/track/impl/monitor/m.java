package com.bytedance.android.ecom.bcm.track.impl.monitor;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements com.bytedance.android.btm.api.model.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<String> f51126a;

    public m() {
        this.f51126a = CollectionsKt.arrayListOf(new String[]{com.bytedance.android.ec.core.event.a.KEY_ENTER_PRODUCT_DETAL, "commodity_duration", "click_wish_button", "pd_no_action"});
    }

    @Override // com.bytedance.android.btm.api.model.i
    public final com.bytedance.android.btm.api.model.g a(com.bytedance.android.btm.api.model.h r100) {
        return e.a(r100);
    }

    @Override // com.bytedance.android.btm.api.model.i
    public final boolean b(com.bytedance.android.btm.api.model.h r100) {
        return this.f51126a.contains(r100.f42055a);
    }
}
