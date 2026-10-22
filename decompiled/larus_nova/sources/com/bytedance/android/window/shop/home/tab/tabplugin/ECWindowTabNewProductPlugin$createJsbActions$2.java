package com.bytedance.android.window.shop.home.tab.tabplugin;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lorg/json/JSONObject;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECWindowTabNewProductPlugin$createJsbActions$2 extends FunctionReferenceImpl implements Function1<JSONObject, Unit> {
    public ECWindowTabNewProductPlugin$createJsbActions$2(ECWindowTabNewProductPlugin r100) {
        super(1, r100, ECWindowTabNewProductPlugin.class, "onReceiveCategoryAnchorEvent", "onReceiveCategoryAnchorEvent(Lorg/json/JSONObject;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ECWindowTabNewProductPlugin r101 = (ECWindowTabNewProductPlugin) this.receiver;
        int r102 = ECWindowTabNewProductPlugin.f188918e;
        r101.h(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(JSONObject r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
