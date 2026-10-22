package com.bytedance.android.shopping.store.home.entity;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ShopCartStatus;", "", "", "status", "I", "getStatus", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ICON", "BOTTOM", "SLIDE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShopCartStatus extends Enum<ShopCartStatus> {
    public static final ShopCartStatus BOTTOM = null;
    public static final a Companion = null;
    public static final ShopCartStatus ICON = null;
    public static final ShopCartStatus SLIDE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShopCartStatus[] f183641a = null;
    private final int status;

    public static final class a {
        public a() {
        }

        public static String a(Integer r100) {
            if (r100 != null) goto L5;
        L7:
            if (r100 != null) goto L10;
        L12:
            if (r100 != null) goto L15;
        L17:
            return "";
        L15:
            if (r100.intValue() != 3) goto L17;
            return "slide";
        L10:
            if (r100.intValue() != 2) goto L12;
            return "bottom";
        L5:
            if (r100.intValue() != 1) goto L7;
            return "icon";
        }
    }

    static {
        ShopCartStatus r100 = new ShopCartStatus("ICON", 0, 1);
        ICON = r100;
        ShopCartStatus r101 = new ShopCartStatus("BOTTOM", 1, 2);
        BOTTOM = r101;
        ShopCartStatus r102 = new ShopCartStatus("SLIDE", 2, 3);
        SLIDE = r102;
        f183641a = new ShopCartStatus[]{r100, r101, r102};
        Companion = new a();
    }

    public static ShopCartStatus valueOf(String r100) {
        return (ShopCartStatus) r27.a.a(ShopCartStatus.class, r100);
    }

    public static ShopCartStatus[] values() {
        return (ShopCartStatus[]) f183641a.clone();
    }

    public final int getStatus() {
        return this.status;
    }

    public ShopCartStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.status = r102;
    }
}
