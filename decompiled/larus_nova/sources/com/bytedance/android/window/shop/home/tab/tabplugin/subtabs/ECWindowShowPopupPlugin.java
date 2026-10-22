package com.bytedance.android.window.shop.home.tab.tabplugin.subtabs;

import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin;
import com.bytedance.android.window.shop.home.tab.tabplugin.c;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ECWindowShowPopupPlugin extends ECWindowJsbPlugin {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f188954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f188955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f188956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LifecycleOwner f188957e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin
    public final List<c> c() {
        return CollectionsKt.listOf(new c("ecom.window.popup", new ECWindowShowPopupPlugin$createJsbActions$1(this)));
    }

    public ECWindowShowPopupPlugin(String r100, ViewGroup r101, LifecycleOwner r102) {
        Intrinsics.checkNotNullParameter(r100, "secAuthorId");
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Intrinsics.checkNotNullParameter(r102, "lifecycleOwner");
        this.f188955c = r100;
        this.f188956d = r101;
        this.f188957e = r102;
        ViewParent r103 = r101.getParent();
    L4:
        if ((r103 instanceof ViewGroup) == false) goto L12;
        r101 = (ViewGroup) r103;
        ViewParent r104 = r101.getParent();
        if ((r104 instanceof ViewGroup) == true) goto L8;
        r104 = null;
    L8:
        r103 = (ViewGroup) r104;
        if (r103 == null) goto L12;
        if ((!Intrinsics.areEqual(r103, r101)) == true) goto L4;
    L12:
        this.f188954b = r101;
    }
}
