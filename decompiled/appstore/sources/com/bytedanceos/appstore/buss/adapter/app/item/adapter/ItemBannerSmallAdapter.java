package com.bytedanceos.appstore.buss.adapter.app.item.adapter;

import com.bytedanceos.appstore.buss.adapter.app.item.provider.ItemBannerSmallProvider;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.item.ItemType;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\n\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0012\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0014\u001a\u0004\b\f\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/app/item/adapter/ItemBannerSmallAdapter;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "<init>", "()V", "", "data", "", "position", "getItemType", "(Ljava/util/List;I)I", "a", "I", "b", "()I", "d", "(I)V", "row", "", "Ljava/lang/String;", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "pageName", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ItemBannerSmallAdapter extends BaseProviderMultiAdapter<CommonAppEntity> implements LoadMoreModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f8340b;

    public ItemBannerSmallAdapter() {
        super(null, 1, null);
        this.f8340b = "";
        addItemProvider(new ItemBannerSmallProvider());
    }

    public final String a() {
        return this.f8340b;
    }

    public final int b() {
        return this.f8339a;
    }

    public final void c(String r10) {
        this.f8340b = r10;
    }

    public final void d(int r10) {
        this.f8339a = r10;
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int getItemType(List<? extends CommonAppEntity> r10, int r11) {
        q.g(r10, "data");
        return ItemType.BANNER_SMALL.ordinal();
    }
}
