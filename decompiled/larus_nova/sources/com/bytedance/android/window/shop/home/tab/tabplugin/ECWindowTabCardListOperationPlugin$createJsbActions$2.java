package com.bytedance.android.window.shop.home.tab.tabplugin;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lorg/json/JSONObject;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECWindowTabCardListOperationPlugin$createJsbActions$2 extends FunctionReferenceImpl implements Function1<JSONObject, Unit> {
    public ECWindowTabCardListOperationPlugin$createJsbActions$2(ECWindowTabCardListOperationPlugin r100) {
        super(1, r100, ECWindowTabCardListOperationPlugin.class, "onReceiveWindowCardRemoveEvent", "onReceiveWindowCardRemoveEvent(Lorg/json/JSONObject;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ECWindowTabCardListOperationPlugin r101 = (ECWindowTabCardListOperationPlugin) this.receiver;
        int r102 = ECWindowTabCardListOperationPlugin.f188913f;
        if (r101.h(r100) == false) goto L20;
        gp3.a.C6047a r103 = gp3.a.f481993c;
        String r104 = r100.toString();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "json");
        gp3.a.b r105 = (gp3.a.b) u0.b(r104, gp3.a.b.class);
        if (r105 != null) goto L8;
        gp3.a r106 = null;
    L16:
        if (r106 == null) goto L21;
        r101.f188917e.invoke(r106);
        return;
    L21:
        return;
    L8:
        String r107 = r105.b();
        if (r107 != null) goto L11;
        r107 = "";
    L11:
        Integer r108 = r105.a();
        if (r108 == null) goto L14;
        int r109 = r108.intValue();
    L15:
        r106 = new gp3.a(r107, r109);
        goto L16
    L14:
        r109 = -1;
        goto L15
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(JSONObject r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
