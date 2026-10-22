package com.bytedanceos.appstore.buss.fragment;

import androidx.lifecycle.Observer;
import com.bytedanceos.appstore.buss.adapter.BinderAdapter;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.appstore.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/Observer;", "", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AppIgnoreUpdateFragment$observer$2 extends Lambda implements Function0<Observer<List<? extends CommonAppEntity>>> {
    final /* synthetic */ AppIgnoreUpdateFragment this$0;

    public AppIgnoreUpdateFragment$observer$2(AppIgnoreUpdateFragment r10) {
        this.this$0 = r10;
        super(0);
    }

    public static /* synthetic */ void a(AppIgnoreUpdateFragment r10, List r11) {
        invoke$lambda$0(r10, r11);
    }

    private static final void invoke$lambda$0(AppIgnoreUpdateFragment r10, List r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, ServerElements.LIST);
        ArrayList r12 = new ArrayList();
        if (r11.isEmpty() == false) goto L5;
        String r13 = r10.getString(R.string.myapp_empty, new Object[]{r10.getString(R.string.update_footer_text)});
        kotlin.jvm.internal.q.f(r13, "getString(...)");
        h7.c.A(r10, r13, null, 0, 6, null);
    L6:
        BinderAdapter r14 = AppIgnoreUpdateFragment.G(r10);
        if (r14 == null) goto L10;
        r14.setList(r12);
        return;
    L10:
        return;
    L5:
        r12.addAll(r11);
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Observer<List<? extends CommonAppEntity>> invoke2() {
        return invoke();
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Observer<List<? extends CommonAppEntity>> invoke() {
        final AppIgnoreUpdateFragment r10 = this.this$0;
        return new s(r10);
    }
}
