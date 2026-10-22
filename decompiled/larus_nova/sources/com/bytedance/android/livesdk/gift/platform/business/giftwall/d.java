package com.bytedance.android.livesdk.gift.platform.business.giftwall;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.google.gson.JsonObject;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftWallPreRequestManager f129644a;

    public d(GiftWallPreRequestManager r100) {
        this.f129644a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        final JsonObject r102 = (JsonObject) r101.data;
        final GiftWallPreRequestManager r103 = this.f129644a;
        r103.getClass();
        f r104 = f.f129646a;
        Function0<Unit> r105 = new GiftWallPreRequestManager$convertHomeGiftImageUrl$1(r103, r102);
        r104.getClass();
        f.b(r105);
        return r102;
    }
}
