package com.obric.appstore.buss.detail;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedanceos.common.model.Category;
import com.bytedanceos.ui.OUIChip;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "view", "Lcom/bytedanceos/ui/OUIChip;", "category", "Lcom/bytedanceos/common/model/Category;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AppDetailFragment$onCreateContentView$1$1$6 extends Lambda implements Function2<OUIChip, Category, Unit> {
    final /* synthetic */ List<Category> $categoryList;
    final /* synthetic */ AppDetailFragment this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public AppDetailFragment$onCreateContentView$1$1$6(AppDetailFragment r10, List<? extends Category> r11) {
        this.this$0 = r10;
        this.$categoryList = r11;
        super(2);
    }

    public static /* synthetic */ void a(Category r10, AppDetailFragment r11, List r12, View r13) {
        invoke$lambda$1(r10, r11, r12, r13);
    }

    private static final void invoke$lambda$1(Category r10, AppDetailFragment r11, List r12, View r13) {
        q.g(r10, "$category");
        q.g(r11, "this$0");
        q.g(r12, "$categoryList");
        String r14 = "";
        if (TextUtils.isEmpty(r10.getParent_id()) == false) goto L8;
        com.obric.appstore.util.n r15 = com.obric.appstore.util.n.f11086a;
        FragmentActivity r16 = r11.getActivity();
        String r17 = r10.getName();
        if (r17 != null) goto L7;
        r17 = "";
    L7:
        String r18 = r10.getId();
        q.f(r18, "getId(...)");
        r15.f(r16, r17, r18, "");
        return;
    L8:
        Iterator r19 = r12.iterator();
    L9:
        String r20 = null;
        if (r19.hasNext() == false) goto L14;
        Object r21 = r19.next();
        if (q.b(((Category) r21).getId(), r10.getParent_id()) == false) goto L9;
    L15:
        Category r22 = (Category) r21;
        if (r22 == null) goto L18;
        r20 = r22.getName();
    L18:
        if (r20 == null) goto L21;
        r14 = r20;
    L21:
        com.obric.appstore.util.n r23 = com.obric.appstore.util.n.f11086a;
        FragmentActivity r24 = r11.getActivity();
        String r25 = r10.getParent_id();
        q.f(r25, "getParent_id(...)");
        String r26 = r10.getId();
        q.f(r26, "getId(...)");
        r23.f(r24, r14, r25, r26);
        return;
    L14:
        r21 = null;
        goto L15
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Unit mo0invoke(OUIChip r10, Category r11) {
        invoke2(r10, r11);
        return Unit.f21064a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull OUIChip r10, @NotNull final Category r11) {
        q.g(r10, "view");
        q.g(r11, "category");
        r10.setText(r11.getName());
        final AppDetailFragment r12 = this.this$0;
        final List<Category> r13 = this.$categoryList;
        r10.setOnClickListener(new m(r11, r12, r13));
    }
}
