package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vz1.e;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ShowGroupViewEnterAnim;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftPanelEffect;", "Lvz1/e;", "iconModel", "Lvz1/e;", "getIconModel", "()Lvz1/e;", "<init>", "(Lvz1/e;)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShowGroupViewEnterAnim implements GiftPanelEffect {
    private final e iconModel;

    public final e getIconModel() {
        return this.iconModel;
    }

    public ShowGroupViewEnterAnim(e r100) {
        Intrinsics.checkNotNullParameter(r100, "iconModel");
        this.iconModel = r100;
    }
}
