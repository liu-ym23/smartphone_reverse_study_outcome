package com.bytedance.android.window.shop.home.tab.tabplugin.subtabs;

import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lorg/json/JSONObject;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECWindowReceiveExitJsbPlugin$createJsbActions$1 extends FunctionReferenceImpl implements Function1<JSONObject, Unit> {
    public ECWindowReceiveExitJsbPlugin$createJsbActions$1(ECWindowReceiveExitJsbPlugin r100) {
        super(1, r100, ECWindowReceiveExitJsbPlugin.class, "onReceiveCloseEvent", "onReceiveCloseEvent(Lorg/json/JSONObject;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ECWindowReceiveExitJsbPlugin r101 = (ECWindowReceiveExitJsbPlugin) this.receiver;
        if (ECWindowJsbPlugin.g(r100, r101.f188952b) == false) goto L7;
        r101.f188953c.finish();
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(JSONObject r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
