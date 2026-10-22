package com.bytedance.android.window.shop.home.tab.tabplugin.subtabs;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin;
import com.bytedance.android.window.shop.home.tab.tabplugin.c;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ECWindowReceiveExitJsbPlugin extends ECWindowJsbPlugin {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f188952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Activity f188953c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin
    public final List<c> c() {
        return CollectionsKt.listOf(new c("ecom.window.close_window", new ECWindowReceiveExitJsbPlugin$createJsbActions$1(this)));
    }

    public ECWindowReceiveExitJsbPlugin(String r100, FragmentActivity r101) {
        Intrinsics.checkNotNullParameter(r100, "secAuthorId");
        Intrinsics.checkNotNullParameter(r101, "activity");
        this.f188952b = r100;
        this.f188953c = r101;
    }
}
