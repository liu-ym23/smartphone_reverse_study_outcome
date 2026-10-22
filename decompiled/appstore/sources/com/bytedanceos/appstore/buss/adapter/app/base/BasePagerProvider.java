package com.bytedanceos.appstore.buss.adapter.app.base;

import android.view.View;
import com.bytedanceos.appstore.buss.widget.app.base.BasePagerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/app/base/BasePagerProvider;", "W", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "<init>", "()V", "Lcom/bytedanceos/appstore/buss/adapter/app/base/BasePagerAdapter;", "a", "()Lcom/bytedanceos/appstore/buss/adapter/app/base/BasePagerAdapter;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "item", "", "convert", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;)V", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class BasePagerProvider<W> extends BaseItemProvider<W> {
    public BasePagerProvider() {
    }

    public final BasePagerAdapter a() {
        BaseProviderMultiAdapter r10 = super.getAdapter();
        if ((r10 instanceof BasePagerAdapter) == false) goto L7;
        return (BasePagerAdapter) r10;
    L7:
        throw new IllegalArgumentException("You should set a TvBasePagerAdapter into your recyclerview!");
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void convert(BaseViewHolder r10, Object r11) {
        q.g(r10, "helper");
        View r12 = r10.itemView;     // Catch: ClassCastException -> L5
        q.e(r12, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.widget.app.base.BasePagerView<W of com.bytedanceos.appstore.buss.adapter.app.base.BasePagerProvider, *>");     // Catch: ClassCastException -> L5
        ((BasePagerView) r12).setNewData(r11);     // Catch: ClassCastException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }
}
