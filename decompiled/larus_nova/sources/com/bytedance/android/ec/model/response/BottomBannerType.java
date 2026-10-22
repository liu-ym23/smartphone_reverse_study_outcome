package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/model/response/BottomBannerType;", "", "Commentary", "TryOn", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum BottomBannerType extends Enum<BottomBannerType> {

    @SerializedName("1")
    public static final BottomBannerType Commentary = null;

    @SerializedName("2")
    public static final BottomBannerType TryOn = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BottomBannerType[] f47898a = null;

    static {
        BottomBannerType r100 = new BottomBannerType("Commentary", 0);
        Commentary = r100;
        BottomBannerType r101 = new BottomBannerType("TryOn", 1);
        TryOn = r101;
        f47898a = new BottomBannerType[]{r100, r101};
    }

    public static BottomBannerType valueOf(String r100) {
        return (BottomBannerType) r27.a.a(BottomBannerType.class, r100);
    }

    public static BottomBannerType[] values() {
        return (BottomBannerType[]) f47898a.clone();
    }

    public BottomBannerType(String r100, int r101) {
        super(r100, r101);
    }
}
