package com.bytedanceos.appstore.buss.adapter.app.item.adapter;

import com.bytedanceos.appstore.buss.adapter.app.item.provider.ItemHorizontalProvider;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.item.ItemType;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B_\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012@\b\u0002\u0010\u000e\u001a:\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006j\u0004\u0018\u0001`\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0017\u001a\u00020\u00152\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018R`\u0010\u001f\u001a@\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010)\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\"\u0010+\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010!\u001a\u0004\b \u0010#\"\u0004\b*\u0010%¨\u0006,"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/app/item/adapter/ItemHorizontalAdapter;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "", "showPosition", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "entity", "", "Lcom/bytedanceos/appstore/buss/utilities/AppOnLongClickListener;", "appOnLongClickListener", "", "pageSource", "<init>", "(ZLkotlin/jvm/functions/Function2;Ljava/lang/String;)V", "", "data", "", "position", "getItemType", "(Ljava/util/List;I)I", "Lcom/bytedanceos/appstore/buss/utilities/AppOnClickListener;", "a", "Lkotlin/jvm/functions/Function2;", "()Lkotlin/jvm/functions/Function2;", "setEditAppOnClickListener", "(Lkotlin/jvm/functions/Function2;)V", "editAppOnClickListener", "b", "Z", "d", "()Z", "setShowNoBrief", "(Z)V", "showNoBrief", "c", "setItemCanClick", "itemCanClick", "setEditState", "editState", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ItemHorizontalAdapter extends BaseProviderMultiAdapter<CommonAppEntity> implements LoadMoreModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function2 f8341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8344d;

    public ItemHorizontalAdapter() {
        boolean r10 = false;
        Function2 r11 = null;
        String r12 = null;
        this(r10, r11, r12, 7, null);
    }

    public final Function2 a() {
        return this.f8341a;
    }

    public final boolean b() {
        return this.f8344d;
    }

    public final boolean c() {
        return this.f8343c;
    }

    public final boolean d() {
        return this.f8342b;
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int getItemType(List<? extends CommonAppEntity> r10, int r11) {
        q.g(r10, "data");
        return ItemType.HORIZONTAL.ordinal();
    }

    public /* synthetic */ ItemHorizontalAdapter(boolean r10, Function2 r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = false;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = "";
    L11:
        this(r10, r11, r12);
    }

    public ItemHorizontalAdapter(boolean r10, Function2 r11, String r12) {
        super(null, 1, null);
        this.f8343c = true;
        ItemHorizontalProvider r13 = new ItemHorizontalProvider();
        r13.d(r11);
        r13.e(this.f8341a);
        r13.i(this.f8342b);
        r13.g(this.f8343c);
        r13.f(this.f8344d);
        r13.j(r10);
        r13.h(r12);
        addItemProvider(r13);
    }
}
