package com.obric.appstore.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.obric.appstore.base.BaseListItemProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/obric/appstore/ui/adapter/ItemSpaceProvider;", "Lcom/obric/appstore/base/BaseListItemProvider;", "Lcom/obric/appstore/base/BaseListItemProvider$b;", "Lza/b;", "", "spacerHeight", "<init>", "(I)V", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "item", "", "c", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lza/b;)V", "Landroid/view/ViewGroup;", "parent", "d", "(Landroid/view/ViewGroup;)Lcom/obric/appstore/base/BaseListItemProvider$b;", "I", "getSpacerHeight", "()I", "getItemViewType", "itemViewType", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ItemSpaceProvider extends BaseListItemProvider<BaseListItemProvider.b, za.b> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11028c;

    public ItemSpaceProvider(int r10) {
        this.f11028c = r10;
    }

    @Override // com.obric.appstore.base.BaseListItemProvider
    public /* bridge */ /* synthetic */ ViewBinding a(ViewGroup r10) {
        return d(r10);
    }

    public void c(BaseViewHolder r10, za.b r11) {
        q.g(r10, "helper");
        q.g(r11, "item");
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, Object r11) {
        c(r10, (za.b) r11);
    }

    public BaseListItemProvider.b d(ViewGroup r10) {
        q.g(r10, "parent");
        View r11 = new View(getContext());
        r11.setLayoutParams(new ViewGroup.LayoutParams(-1, this.f11028c));
        return new BaseListItemProvider.b(r11);
    }

    @Override // com.obric.appstore.base.BaseListItemProvider, com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return ItemType.SPACE.ordinal();
    }
}
