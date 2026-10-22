package com.bytedance.android.live.base.model.user;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R2\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR2\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/base/model/user/l0;", "Lvh7/c;", "", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getOwning", "()Ljava/util/List;", "setOwning", "(Ljava/util/List;)V", "getOwning$annotations", "()V", "owning", "getWearing", "setWearing", "getWearing$annotations", "wearing", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface l0 extends vh7.c<l0> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "dress_own_ids")
    List<String> getOwning();

    @FieldName(name = "dress_wear_ids")
    List<String> getWearing();

    @FieldName(name = "dress_own_ids#setter")
    void setOwning(List<String> r100);

    @FieldName(name = "dress_wear_ids#setter")
    void setWearing(List<String> r100);
}
