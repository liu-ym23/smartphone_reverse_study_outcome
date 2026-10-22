package com.bytedance.android.window.shop.home.tab.tabplugin;

import com.bytedance.android.window.shop.eventcard.windowability.WindowAnchorAbility;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class ECWindowTabCardListOperationPlugin extends ECWindowJsbPlugin {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f188913f = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECWindowViewModel f188914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f188915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<WindowAnchorAbility, Unit> f188916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<gp3.a, Unit> f188917e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin
    public final List<c> c() {
        return CollectionsKt.listOf(new c[]{new c("ecom.window.tab.mix_card_insert", new ECWindowTabCardListOperationPlugin$createJsbActions$1(this)), new c("ecom.window.tab.mix_card_remove", new ECWindowTabCardListOperationPlugin$createJsbActions$2(this))});
    }

    public final boolean h(JSONObject r100) {
        if (ECWindowJsbPlugin.d(r100, "sec_author_id", this.f188914b.getShopParam().getSecAuthorId(), false) == true) goto L5;
        return false;
    L5:
        if (ECWindowJsbPlugin.d(r100, "category_id", this.f188915c, false) == false) goto L9;
        return true;
    L9:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECWindowTabCardListOperationPlugin(ECWindowViewModel r100, String r101, Function1<? super WindowAnchorAbility, Unit> r102, Function1<? super gp3.a, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "categoryId");
        Intrinsics.checkNotNullParameter(r102, "insertPerformer");
        Intrinsics.checkNotNullParameter(r103, "removePerformer");
        this.f188914b = r100;
        this.f188915c = r101;
        this.f188916d = r102;
        this.f188917e = r103;
    }
}
