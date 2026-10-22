package com.bytedance.android.livesdk.message.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/KtvTypetv;", "", "KTVMVType_Unknown", "KTVMVType_OFFICIAl", "KTVMVType_PERSONAL", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum KtvTypetv extends Enum<KtvTypetv> {
    public static final KtvTypetv KTVMVType_OFFICIAl = null;
    public static final KtvTypetv KTVMVType_PERSONAL = null;
    public static final KtvTypetv KTVMVType_Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KtvTypetv[] f153564a = null;

    static {
        KtvTypetv r100 = new KtvTypetv("KTVMVType_Unknown", 0);
        KTVMVType_Unknown = r100;
        KtvTypetv r101 = new KtvTypetv("KTVMVType_OFFICIAl", 1);
        KTVMVType_OFFICIAl = r101;
        KtvTypetv r102 = new KtvTypetv("KTVMVType_PERSONAL", 2);
        KTVMVType_PERSONAL = r102;
        f153564a = new KtvTypetv[]{r100, r101, r102};
    }

    public static KtvTypetv valueOf(String r100) {
        return (KtvTypetv) r27.a.a(KtvTypetv.class, r100);
    }

    public static KtvTypetv[] values() {
        return (KtvTypetv[]) f153564a.clone();
    }

    public KtvTypetv(String r100, int r101) {
        super(r100, r101);
    }
}
