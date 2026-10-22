package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class g3<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ToolbarGroupPurchaseWidgetBehavior f117198a;

    public g3(ToolbarGroupPurchaseWidgetBehavior r100) {
        this.f117198a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ToolbarGroupPurchaseWidgetBehavior r101 = this.f117198a;
        Map<String, Object> r102 = ((SubscriberJsEvent) r100).getParams();
        Object r103 = null;
        if (r102 == null) goto L5;
        Object r104 = r102.get("is_explanation");
    L7:
        if ((r104 instanceof Boolean) == false) goto L10;
        r103 = r104;
    L10:
        Boolean r105 = (Boolean) r103;
        if (r105 == null) goto L13;
        boolean r106 = r105.booleanValue();
    L14:
        r101.f116993h = r106;
        return;
    L13:
        r106 = false;
        goto L14
    L5:
        r104 = null;
        goto L7
    }
}
