package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/model/response/TrackEventType;", "", "InvalidProduct", "UnRecProduct", "Product", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum TrackEventType extends Enum<TrackEventType> {

    @SerializedName("1")
    public static final TrackEventType InvalidProduct = null;

    @SerializedName("3")
    public static final TrackEventType Product = null;

    @SerializedName("2")
    public static final TrackEventType UnRecProduct = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TrackEventType[] f47924a = null;

    static {
        TrackEventType r100 = new TrackEventType("InvalidProduct", 0);
        InvalidProduct = r100;
        TrackEventType r101 = new TrackEventType("UnRecProduct", 1);
        UnRecProduct = r101;
        TrackEventType r102 = new TrackEventType("Product", 2);
        Product = r102;
        f47924a = new TrackEventType[]{r100, r101, r102};
    }

    public static TrackEventType valueOf(String r100) {
        return (TrackEventType) r27.a.a(TrackEventType.class, r100);
    }

    public static TrackEventType[] values() {
        return (TrackEventType[]) f47924a.clone();
    }

    public TrackEventType(String r100, int r101) {
        super(r100, r101);
    }
}
