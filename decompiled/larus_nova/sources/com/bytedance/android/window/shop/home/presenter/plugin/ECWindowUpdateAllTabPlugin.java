package com.bytedance.android.window.shop.home.presenter.plugin;

import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin;
import com.bytedance.android.window.shop.home.tab.tabplugin.c;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ECWindowUpdateAllTabPlugin extends ECWindowJsbPlugin {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f188610c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<String> f188611b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin
    public final List<c> c() {
        return CollectionsKt.listOf(new c("ecom.window.refresh_all_tab", new ECWindowUpdateAllTabPlugin$createJsbActions$1(this)));
    }

    public ECWindowUpdateAllTabPlugin(Function0<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "getSecAuthorId");
        this.f188611b = r100;
    }
}
