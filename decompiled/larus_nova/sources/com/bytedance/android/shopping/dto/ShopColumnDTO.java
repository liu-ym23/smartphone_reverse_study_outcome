package com.bytedance.android.shopping.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/dto/ShopColumnDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Ljava/io/Serializable;", "()V", "canReverse", "", "getCanReverse", "()Z", "id", "", "getId", "()Ljava/lang/String;", "name", "getName", "sort", "", "getSort", "()I", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopColumnDTO extends CommerceBaseResponse {

    @SerializedName("can_reverse")
    private final boolean canReverse;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f174285id;

    @SerializedName("name")
    private final String name;

    @SerializedName("default_sort")
    private final int sort;

    public ShopColumnDTO() {
        this.f174285id = "";
        this.name = "";
    }

    public final boolean getCanReverse() {
        return this.canReverse;
    }

    public final String getId() {
        return this.f174285id;
    }

    public final String getName() {
        return this.name;
    }

    public final int getSort() {
        return this.sort;
    }
}
