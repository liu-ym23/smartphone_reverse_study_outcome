package com.bytedanceos.appstore.buss.adapter.app.item.adapter;

import com.bytedanceos.appstore.buss.adapter.app.item.provider.ItemHorizontalLargeProvider;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.item.ItemType;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\n\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000bRZ\u0010\u0019\u001a:\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fj\u0004\u0018\u0001`\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R`\u0010\u001d\u001a@\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010(\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\"\u0010+\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010 \u001a\u0004\b\u001f\u0010\"\"\u0004\b*\u0010$R\"\u0010.\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010 \u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$R$\u00104\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u00100\u001a\u0004\b)\u00101\"\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/app/item/adapter/ItemHorizontalLargeAdapter;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "<init>", "()V", "", "data", "", "position", "getItemType", "(Ljava/util/List;I)I", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "entity", "", "Lcom/bytedanceos/appstore/buss/utilities/AppOnLongClickListener;", "a", "Lkotlin/jvm/functions/Function2;", "()Lkotlin/jvm/functions/Function2;", "setAppOnLongClickListener", "(Lkotlin/jvm/functions/Function2;)V", "appOnLongClickListener", "Lcom/bytedanceos/appstore/buss/utilities/AppOnClickListener;", "b", "setEditAppOnClickListener", "editAppOnClickListener", "", "c", "Z", "f", "()Z", "setShowNoBrief", "(Z)V", "showNoBrief", "d", "setItemCanClick", "itemCanClick", "e", "setEditState", "editState", "g", "setShowPosition", "showPosition", "", "Ljava/lang/String;", "()Ljava/lang/String;", "setPageSource", "(Ljava/lang/String;)V", "pageSource", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ItemHorizontalLargeAdapter extends BaseProviderMultiAdapter<CommonAppEntity> implements LoadMoreModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function2 f8345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2 f8346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8349e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8350f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f8351g;

    public ItemHorizontalLargeAdapter() {
        super(null, 1, null);
        this.f8348d = true;
        this.f8351g = "";
        ItemHorizontalLargeProvider r10 = new ItemHorizontalLargeProvider();
        r10.d(this.f8345a);
        r10.e(this.f8346b);
        r10.i(this.f8347c);
        r10.g(this.f8348d);
        r10.f(this.f8349e);
        r10.j(this.f8350f);
        r10.h(this.f8351g);
        addItemProvider(r10);
    }

    public final Function2 a() {
        return this.f8345a;
    }

    public final Function2 b() {
        return this.f8346b;
    }

    public final boolean c() {
        return this.f8349e;
    }

    public final boolean d() {
        return this.f8348d;
    }

    public final String e() {
        return this.f8351g;
    }

    public final boolean f() {
        return this.f8347c;
    }

    public final boolean g() {
        return this.f8350f;
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int getItemType(List<? extends CommonAppEntity> r10, int r11) {
        q.g(r10, "data");
        return ItemType.HORIZONTAL_LARGE.ordinal();
    }
}
