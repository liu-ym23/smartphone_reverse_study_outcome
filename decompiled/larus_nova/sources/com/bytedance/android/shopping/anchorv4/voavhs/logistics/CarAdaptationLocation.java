package com.bytedance.android.shopping.anchorv4.voavhs.logistics;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/CarAdaptationLocation;", "", "", "moduleLocation", "Ljava/lang/String;", "getModuleLocation", "()Ljava/lang/String;", "Logistics", "SKU", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CarAdaptationLocation extends Enum<CarAdaptationLocation> {
    public static final CarAdaptationLocation Logistics = null;
    public static final CarAdaptationLocation SKU = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CarAdaptationLocation[] f169976a = null;
    private final String moduleLocation;

    static {
        CarAdaptationLocation r100 = new CarAdaptationLocation("Logistics", 0, "1");
        Logistics = r100;
        CarAdaptationLocation r101 = new CarAdaptationLocation("SKU", 1, "2");
        SKU = r101;
        f169976a = new CarAdaptationLocation[]{r100, r101};
    }

    public static CarAdaptationLocation valueOf(String r100) {
        return (CarAdaptationLocation) r27.a.a(CarAdaptationLocation.class, r100);
    }

    public static CarAdaptationLocation[] values() {
        return (CarAdaptationLocation[]) f169976a.clone();
    }

    public final String getModuleLocation() {
        return this.moduleLocation;
    }

    public CarAdaptationLocation(String r100, int r101, String r102) {
        super(r100, r101);
        this.moduleLocation = r102;
    }
}
