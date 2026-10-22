package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ValueKey;", "", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "SALES", "FANS", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ValueKey extends Enum<ValueKey> {
    public static final ValueKey FANS = null;
    public static final ValueKey SALES = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ValueKey[] f183673a = null;
    private final String desc;

    static {
        ValueKey r100 = new ValueKey("SALES", 0, SalesInfoStruct.SALES);
        SALES = r100;
        ValueKey r101 = new ValueKey("FANS", 1, "fans");
        FANS = r101;
        f183673a = new ValueKey[]{r100, r101};
    }

    public static ValueKey valueOf(String r100) {
        return (ValueKey) r27.a.a(ValueKey.class, r100);
    }

    public static ValueKey[] values() {
        return (ValueKey[]) f183673a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public ValueKey(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
