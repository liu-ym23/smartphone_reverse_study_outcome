package com.obric.appstore.network.entity;

import com.google.gson.annotations.SerializedName;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B?\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ&\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/appstore/network/entity/CategoryListResp;", "Lcom/obric/appstore/network/entity/PageResp;", "Lcom/obric/appstore/network/entity/CommonAppEntity;", "apps", "", "firstCategory", "Lcom/obric/appstore/network/entity/CategoryResp;", "secondCategory", "defaultSecondCategory", "(Ljava/util/List;Lcom/obric/appstore/network/entity/CategoryResp;Ljava/util/List;Lcom/obric/appstore/network/entity/CategoryResp;)V", "getApps", "()Ljava/util/List;", "data", "getData", "getDefaultSecondCategory", "()Lcom/obric/appstore/network/entity/CategoryResp;", "getFirstCategory", "getSecondCategory", "copy", Card.KEY_HAS_MORE, "", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CategoryListResp extends PageResp<CommonAppEntity> {

    @SerializedName("apps")
    @Nullable
    private final List<CommonAppEntity> apps;

    @SerializedName("default_second_category")
    @Nullable
    private final CategoryResp defaultSecondCategory;

    @SerializedName("first_category")
    @Nullable
    private final CategoryResp firstCategory;

    @SerializedName("second_category")
    @Nullable
    private final List<CategoryResp> secondCategory;

    public /* synthetic */ CategoryListResp(List r10, CategoryResp r11, List r12, CategoryResp r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = null;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = null;
    L11:
        this(r10, r11, r12, r13);
    }

    @Override // com.obric.appstore.network.entity.PageResp
    @NotNull
    public PageResp<CommonAppEntity> copy(@Nullable List<? extends CommonAppEntity> r10, boolean r11) {
        return new CategoryListResp(r10, this.firstCategory, this.secondCategory, this.defaultSecondCategory);
    }

    @Nullable
    public final List<CommonAppEntity> getApps() {
        return this.apps;
    }

    @Override // com.obric.appstore.network.entity.PageResp
    @Nullable
    public List<CommonAppEntity> getData() {
        return this.apps;
    }

    @Nullable
    public final CategoryResp getDefaultSecondCategory() {
        return this.defaultSecondCategory;
    }

    @Nullable
    public final CategoryResp getFirstCategory() {
        return this.firstCategory;
    }

    @Nullable
    public final List<CategoryResp> getSecondCategory() {
        return this.secondCategory;
    }

    public CategoryListResp(@Nullable List<CommonAppEntity> r10, @Nullable CategoryResp r11, @Nullable List<CategoryResp> r12, @Nullable CategoryResp r13) {
        super(false, 1, null);
        this.apps = r10;
        this.firstCategory = r11;
        this.secondCategory = r12;
        this.defaultSecondCategory = r13;
    }
}
