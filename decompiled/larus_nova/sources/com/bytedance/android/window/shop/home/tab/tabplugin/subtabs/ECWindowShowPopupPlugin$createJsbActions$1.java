package com.bytedance.android.window.shop.home.tab.tabplugin.subtabs;

import android.view.View;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin;
import com.bytedance.android.window.shop.widget.popup.WindowPopupWindowManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.tencent.open.SocialConstants;
import dr3.f;
import dr3.h;
import er3.c;
import er3.d;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lorg/json/JSONObject;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECWindowShowPopupPlugin$createJsbActions$1 extends FunctionReferenceImpl implements Function1<JSONObject, Unit> {
    public ECWindowShowPopupPlugin$createJsbActions$1(ECWindowShowPopupPlugin r100) {
        super(1, r100, ECWindowShowPopupPlugin.class, "onReceivePopupEvent", "onReceivePopupEvent(Lorg/json/JSONObject;)V", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.util.ArrayList] */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(JSONObject r110) {
        Intrinsics.checkNotNullParameter(r110, "p1");
        ECWindowShowPopupPlugin r100 = (ECWindowShowPopupPlugin) this.receiver;
        if (ECWindowJsbPlugin.g(r110, r100.f188955c) == false) goto L90;
        View r101 = r100.f188954b.findViewWithTag(r110.optString(PickerReporterConstants.KEY.TARGET));
        if (r101 != null) goto L8;
        r101 = r100.f188956d;
    L8:
        JSONObject r102 = r110.optJSONObject("popup");
        if (r102 == null) goto L91;
        WindowPopupWindowManager.PopupPosition.a r103 = WindowPopupWindowManager.PopupPosition.Companion;
        String r111 = r110.optString("position");
        r103.getClass();
        Intrinsics.checkNotNullParameter(r111, SocialConstants.PARAM_APP_DESC);
        WindowPopupWindowManager.PopupPosition r112 = (WindowPopupWindowManager.PopupPosition) WindowPopupWindowManager.PopupPosition.access$getMap$cp().get(r111);
        if (r112 == null) goto L92;
        er3.b r104 = (er3.b) u0.b(r102.toString(), er3.b.class);
        if (r104 == null) goto L93;
        int r105 = f.f469766e;
        Intrinsics.checkNotNullParameter(r104, "groupDto");
        c r106 = r104.b();
        f r107 = null;
        if (r106 == null) goto L20;
        fr3.a<?> r108 = r106.b();
    L22:
        if ((r108 instanceof fr3.a.c) == true) goto L24;
        r108 = null;
    L24:
        fr3.a.c r109 = (fr3.a.c) r108;
        if (r109 == null) goto L70;
        List<c> r113 = r104.a();
        if (r113 == null) goto L70;
        ArrayList r114 = new ArrayList();
        Iterator r115 = r113.iterator();
    L31:
        if (r115.hasNext() == false) goto L60;
        c r116 = (c) r115.next();
        int r117 = dr3.b.f469760a;
        List<er3.f> r118 = r116.a();
        if (r118 == null) goto L40;
        int r119 = d.f473578b;
        ?? r120 = new ArrayList();
        Iterator r121 = r118.iterator();
    L36:
        if (r121.hasNext() == false) goto L41;
        d r122 = d.b.a((er3.f) r121.next());
        if (r122 == null) goto L36;
        r120.add(r122);
    L41:
        fr3.a<?> r123 = r116.b();
        Intrinsics.checkNotNullParameter(r120, SlcCommonAction.KEY_ACTIONS);
        if (r123 != null) goto L45;
    L55:
        Disposable r124 = null;
    L56:
        if (r124 == null) goto L31;
        r114.add(r124);
        goto L31
    L45:
        if ((r123 instanceof fr3.a.b) == false) goto L48;
        r124 = new dr3.c((fr3.a.b) r123);
        goto L56
    L48:
        if ((r123 instanceof fr3.a.g) == false) goto L51;
        r124 = new h(r120, (fr3.a.g) r123);
        goto L56
    L51:
        if ((r123 instanceof fr3.a.e) == false) goto L54;
        r124 = new dr3.d(r120, (fr3.a.e) r123);
        goto L56
    L54:
        if ((r123 instanceof fr3.a.c) == true) goto L55;
        throw new NoWhenBranchMatchedException();
    L40:
        r120 = CollectionsKt.emptyList();
        goto L41
    L60:
        List<er3.f> r125 = r104.b().a();
        if (r125 == null) goto L68;
        int r126 = d.f473578b;
        ?? r127 = new ArrayList();
        Iterator r128 = r125.iterator();
    L64:
        if (r128.hasNext() == false) goto L69;
        d r129 = d.b.a((er3.f) r128.next());
        if (r129 == null) goto L64;
        r127.add(r129);
    L69:
        r107 = new f(r127, r109, r114);
        goto L70
    L68:
        r127 = CollectionsKt.emptyList();
    L70:
        if (r107 == null) goto L94;
        int r130 = WindowPopupWindowManager.f190064a;
        WindowPopupWindowManager.a(r101, r107, r100.f188957e, r112);
        return;
    L94:
        return;
    L20:
        r108 = null;
        goto L22
    L93:
        return;
    L92:
        return;
    L91:
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(JSONObject r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
