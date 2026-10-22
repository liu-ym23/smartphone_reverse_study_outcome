package com.bytedance.android.shopping.store.home.entity;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ToolType;", "", "", "type", "I", "getType", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UNKNOWN", "CUSTOM_SERVICE", "SHARE", "CART", "ORDER", "COUPON_RED_PACK", "MEMBER", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ToolType extends Enum<ToolType> {
    public static final ToolType CART = null;
    public static final ToolType COUPON_RED_PACK = null;
    public static final ToolType CUSTOM_SERVICE = null;
    public static final a Companion = null;
    public static final ToolType MEMBER = null;
    public static final ToolType ORDER = null;
    public static final ToolType SHARE = null;
    public static final ToolType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ToolType[] f183672a = null;
    private final int type;

    public static final class a {
        public a() {
        }
    }

    static {
        ToolType r100 = new ToolType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        ToolType r101 = new ToolType("CUSTOM_SERVICE", 1, 1);
        CUSTOM_SERVICE = r101;
        ToolType r102 = new ToolType("SHARE", 2, 2);
        SHARE = r102;
        ToolType r103 = new ToolType("CART", 3, 3);
        CART = r103;
        ToolType r104 = new ToolType("ORDER", 4, 4);
        ORDER = r104;
        ToolType r105 = new ToolType("COUPON_RED_PACK", 5, 5);
        COUPON_RED_PACK = r105;
        ToolType r106 = new ToolType("MEMBER", 6, 6);
        MEMBER = r106;
        f183672a = new ToolType[]{r100, r101, r102, r103, r104, r105, r106};
        Companion = new a();
    }

    public static ToolType valueOf(String r100) {
        return (ToolType) r27.a.a(ToolType.class, r100);
    }

    public static ToolType[] values() {
        return (ToolType[]) f183672a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ToolType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
