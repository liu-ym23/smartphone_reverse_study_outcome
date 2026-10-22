package com.obric.appstore.ui.adapter;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.ui.widget.oui.ViewExtKt;
import com.obric.appstore.R;
import com.obric.appstore.util.n;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "view", "Lcom/obric/appstore/network/f;", "item", "", SlideCard.KEY_INDEX, "", "invoke", "(Landroid/view/View;Lcom/obric/appstore/network/f;I)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
public final class HorGridCategoryItemProvider$convert$1$2 extends Lambda implements Function3<View, com.obric.appstore.network.f, Integer, Unit> {
    final /* synthetic */ int $gap;
    final /* synthetic */ sa.e $this_apply;
    final /* synthetic */ HorGridCategoryItemProvider this$0;

    public HorGridCategoryItemProvider$convert$1$2(int r10, HorGridCategoryItemProvider r11, sa.e r12) {
        this.$gap = r10;
        this.this$0 = r11;
        this.$this_apply = r12;
        super(3);
    }

    public static /* synthetic */ void a(HorGridCategoryItemProvider r10, com.obric.appstore.network.f r11, sa.e r12, View r13) {
        invoke$lambda$1(r10, r11, r12, r13);
    }

    private static final void invoke$lambda$1(HorGridCategoryItemProvider r10, com.obric.appstore.network.f r11, sa.e r12, View r13) {
        q.g(r10, "this$0");
        q.g(r11, "$item");
        q.g(r12, "$this_apply");
        Activity r14 = tc.b.a(r10.getContext());
        if (r14 != null) goto L5;
        return;
    L5:
        String r15 = r11.a();
        if (r15 != null) goto L9;
        j.n("click category with null id");
        return;
    L9:
        n r16 = n.f11086a;
        String r17 = r11.c();
        if (r17 != null) goto L12;
        r17 = "";
    L12:
        r16.f(r14, r17, r15, "");
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(View r10, com.obric.appstore.network.f r11, Integer r12) {
        invoke(r10, r11, r12.intValue());
        return Unit.f21064a;
    }

    public final void invoke(View r10, @NotNull final com.obric.appstore.network.f r11, int r12) {
        q.g(r11, "item");
        int r13 = 0;
        if ((r12 % 2) != 0) goto L5;
        int r14 = this.$gap / 2;
        int r15 = 0;
    L6:
        if (r12 >= 2) goto L8;
        int r16 = this.$gap / 2;
    L9:
        r10.setPadding(r15, r13, r14, r16);
        q.d(r10);
        NetworkImageView r17 = (NetworkImageView) ViewExtKt.findView(r10, R.id.category_icon);
        int r18 = com.obric.appstore.util.a.f11067a.a(r11.a());
        if (r18 == (-1)) goto L12;
        r17.setDefaultImageResId(r18);
    L13:
        ((TextView) ViewExtKt.findView(r10, R.id.category_name)).setText(r11.c());
        final HorGridCategoryItemProvider r19 = this.this$0;
        final sa.e r20 = this.$this_apply;
        r10.setOnClickListener(new c(r19, r11, r20));
        return;
    L12:
        r17.setImageUrl(r11.b());
        goto L13
    L8:
        int r21 = this.$gap;
        r13 = r21 / 2;
        r16 = r21 / 2;
        goto L9
    L5:
        r15 = this.$gap / 2;
        r14 = 0;
        goto L6
    }
}
