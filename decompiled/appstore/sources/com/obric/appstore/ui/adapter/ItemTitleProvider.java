package com.obric.appstore.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.obric.appstore.base.BaseListItemProvider;
import com.obric.appstore.ui.adapter.ITitle;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import sa.i;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/obric/appstore/ui/adapter/ItemTitleProvider;", "Lcom/obric/appstore/ui/adapter/ITitle;", "T", "Lcom/obric/appstore/base/BaseListItemProvider;", "Lsa/i;", "<init>", "()V", "Landroid/view/ViewGroup;", "parent", "d", "(Landroid/view/ViewGroup;)Lsa/i;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "item", "", "c", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/obric/appstore/ui/adapter/ITitle;)V", "", "getItemViewType", "()I", "itemViewType", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nItemTitleProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ItemTitleProvider.kt\ncom/obric/appstore/ui/adapter/ItemTitleProvider\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,36:1\n304#2,2:37\n*S KotlinDebug\n*F\n+ 1 ItemTitleProvider.kt\ncom/obric/appstore/ui/adapter/ItemTitleProvider\n*L\n24#1:37,2\n*E\n"})
public final class ItemTitleProvider<T extends ITitle> extends BaseListItemProvider<i, T> {
    public ItemTitleProvider() {
    }

    @Override // com.obric.appstore.base.BaseListItemProvider
    public /* bridge */ /* synthetic */ ViewBinding a(ViewGroup r10) {
        return d(r10);
    }

    public void c(BaseViewHolder r10, ITitle r11) {
        q.g(r10, "helper");
        q.g(r11, "item");
        i r12 = (i) b(r10);
        View r13 = r12.f24593b;
        q.f(r13, "divider");
        if (r11.getShowTopDivider() == true) goto L5;
        int r14 = 8;
    L6:
        r13.setVisibility(r14);
        r12.f24594c.setTitle(r11.getTitle());
        return;
    L5:
        r14 = 0;
        goto L6
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, Object r11) {
        c(r10, (ITitle) r11);
    }

    public i d(ViewGroup r10) {
        q.g(r10, "parent");
        i r11 = i.c(LayoutInflater.from(r10.getContext()), r10, false);
        q.f(r11, "inflate(...)");
        return r11;
    }

    @Override // com.obric.appstore.base.BaseListItemProvider, com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return ItemType.TITLE.ordinal();
    }
}
