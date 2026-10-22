package com.bytedance.android.window.shop.home.presenter.plugin;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lorg/json/JSONObject;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECWindowFollowFromCouponPlugin$createJsbActions$1 extends FunctionReferenceImpl implements Function1<JSONObject, Unit> {
    public ECWindowFollowFromCouponPlugin$createJsbActions$1(ECWindowFollowFromCouponPlugin r100) {
        super(1, r100, ECWindowFollowFromCouponPlugin.class, "onFollowStatusChanged", "onFollowStatusChanged(Lorg/json/JSONObject;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ECWindowFollowFromCouponPlugin r101 = (ECWindowFollowFromCouponPlugin) this.receiver;
        int r102 = ECWindowFollowFromCouponPlugin.f188593d;
        r101.getClass();
        int r103 = r100.optInt("follow_status", -1);
        if (r103 == (-1)) goto L15;
        String r104 = r100.optString("sec_author_id");
        if (StringsKt.isBlank(r104) == false) goto L8;
        return;
    L8:
        if ((!Intrinsics.areEqual(r104, r101.f188594b.invoke())) == true) goto L16;
        if (r103 != 1) goto L17;
        r101.f188595c.invoke();
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(JSONObject r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
