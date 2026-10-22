package com.bytedance.android.window.shop.home.presenter.plugin;

import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.window.shop.home.tab.tabplugin.a;
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
public final /* synthetic */ class ECWindowUpdateAllTabPlugin$createJsbActions$1 extends FunctionReferenceImpl implements Function1<JSONObject, Unit> {
    public ECWindowUpdateAllTabPlugin$createJsbActions$1(ECWindowUpdateAllTabPlugin r100) {
        super(1, r100, ECWindowUpdateAllTabPlugin.class, "onReceiveRefresh", "onReceiveRefresh(Lorg/json/JSONObject;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ECWindowUpdateAllTabPlugin r101 = (ECWindowUpdateAllTabPlugin) this.receiver;
        int r102 = ECWindowUpdateAllTabPlugin.f188610c;
        r101.getClass();
        String r103 = r100.optString("sec_author_id");
        if (StringsKt.isBlank(r103) == false) goto L5;
        return;
    L5:
        if ((!Intrinsics.areEqual(r103, r101.f188611b.invoke())) == true) goto L10;
        s0.a(new a(r103, null, null, null));
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(JSONObject r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
