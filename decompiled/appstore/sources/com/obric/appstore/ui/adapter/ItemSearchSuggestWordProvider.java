package com.obric.appstore.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.obric.appstore.base.BaseListItemProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;
import sa.v;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B2\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u001e\u001a\u0004\b\u001f\u0010 R/\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010!R\u0014\u0010$\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/obric/appstore/ui/adapter/ItemSearchSuggestWordProvider;", "Lcom/obric/appstore/base/BaseListItemProvider;", "Lsa/v;", "Lza/b;", "", "pageSource", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "kwd", "", "onClickListener", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Landroid/view/ViewGroup;", "parent", "d", "(Landroid/view/ViewGroup;)Lsa/v;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "item", "c", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lza/b;)V", "Landroid/view/View;", "view", "data", "", "position", "e", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Landroid/view/View;Lza/b;I)V", "Ljava/lang/String;", "getPageSource", "()Ljava/lang/String;", "Lkotlin/jvm/functions/Function1;", "getItemViewType", "()I", "itemViewType", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ItemSearchSuggestWordProvider extends BaseListItemProvider<v, za.b> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1 f11027d;

    public ItemSearchSuggestWordProvider(String r10, Function1 r11) {
        q.g(r10, "pageSource");
        q.g(r11, "onClickListener");
        this.f11026c = r10;
        this.f11027d = r11;
    }

    @Override // com.obric.appstore.base.BaseListItemProvider
    public /* bridge */ /* synthetic */ ViewBinding a(ViewGroup r10) {
        return d(r10);
    }

    public void c(BaseViewHolder r10, za.b r11) {
        q.g(r10, "helper");
        q.g(r11, "item");
        if ((r11 instanceof za.b.C0421b) == false) goto L5;
        za.b.C0421b r12 = (za.b.C0421b) r11;
    L6:
        if (r12 != null) goto L8;
        return;
    L8:
        ((v) b(r10)).f24688e.setText(r12.a());
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, Object r11) {
        c(r10, (za.b) r11);
    }

    public v d(ViewGroup r10) {
        q.g(r10, "parent");
        v r11 = v.c(LayoutInflater.from(r10.getContext()), r10, false);
        q.f(r11, "inflate(...)");
        return r11;
    }

    public void e(BaseViewHolder r10, View r11, za.b r12, int r13) {
        q.g(r10, "helper");
        q.g(r11, "view");
        q.g(r12, "data");
        if ((r12 instanceof za.b.C0421b) == false) goto L5;
        za.b.C0421b r14 = (za.b.C0421b) r12;
    L6:
        if (r14 != null) goto L8;
        return;
    L8:
        this.f11027d.invoke(((za.b.C0421b) r12).a());
        return;
    L5:
        r14 = null;
        goto L6
    }

    @Override // com.obric.appstore.base.BaseListItemProvider, com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return ItemType.SUGGEST_WORD.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void onClick(BaseViewHolder r10, View r11, Object r12, int r13) {
        e(r10, r11, (za.b) r12, r13);
    }
}
