package com.bytedance.android.shopping.buynow.data.remote;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/shopping/buynow/data/remote/BuyNowAppInfos;", "", "", "appName", "Ljava/lang/String;", "getAppName", "()Ljava/lang/String;", "", "bType", "I", "getBType", "()I", "aid", "getAid", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "NewsLite", "NewsArticle", "VideoArticle", "LiveStream", "Aweme", "Automobile", "Wechat", ExifInterface.TAG_FLASH, "Super", "Merchant", "AwemeLite", "Pangle", "Changting", "ZhuXiaoBang", "Unknown", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BuyNowAppInfos extends Enum<BuyNowAppInfos> {
    public static final BuyNowAppInfos Automobile = null;
    public static final BuyNowAppInfos Aweme = null;
    public static final BuyNowAppInfos AwemeLite = null;
    public static final BuyNowAppInfos Changting = null;
    public static final a Companion = null;
    public static final BuyNowAppInfos Flash = null;
    public static final BuyNowAppInfos LiveStream = null;
    public static final BuyNowAppInfos Merchant = null;
    public static final BuyNowAppInfos NewsArticle = null;
    public static final BuyNowAppInfos NewsLite = null;
    public static final BuyNowAppInfos Pangle = null;
    public static final BuyNowAppInfos Super = null;
    public static final BuyNowAppInfos Unknown = null;
    public static final BuyNowAppInfos VideoArticle = null;
    public static final BuyNowAppInfos Wechat = null;
    public static final BuyNowAppInfos ZhuXiaoBang = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BuyNowAppInfos[] f170904a = null;
    private final int aid;
    private final String appName;
    private final int bType;

    public static final class a {
        public a() {
        }
    }

    public static BuyNowAppInfos valueOf(String r100) {
        return (BuyNowAppInfos) r27.a.a(BuyNowAppInfos.class, r100);
    }

    public static BuyNowAppInfos[] values() {
        return (BuyNowAppInfos[]) f170904a.clone();
    }

    static {
        BuyNowAppInfos r100 = new BuyNowAppInfos("NewsLite", 0, "NewsLite", 7, 35);
        NewsLite = r100;
        BuyNowAppInfos r101 = new BuyNowAppInfos("NewsArticle", 1, "NewsArticle", 3, 13);
        NewsArticle = r101;
        BuyNowAppInfos r102 = new BuyNowAppInfos("VideoArticle", 2, "VideoArticle", 4, 32);
        VideoArticle = r102;
        BuyNowAppInfos r103 = new BuyNowAppInfos("LiveStream", 3, "LiveStream", 1, 1112);
        LiveStream = r103;
        BuyNowAppInfos r104 = new BuyNowAppInfos("Aweme", 4, "Aweme", 2, 1128);
        Aweme = r104;
        BuyNowAppInfos r105 = new BuyNowAppInfos("Automobile", 5, "automobile", 8, 36);
        Automobile = r105;
        BuyNowAppInfos r106 = new BuyNowAppInfos("Wechat", 6, "wechat", 5, 0);
        Wechat = r106;
        BuyNowAppInfos r107 = new BuyNowAppInfos(ExifInterface.TAG_FLASH, 7, "flash", 6, 0);
        Flash = r107;
        BuyNowAppInfos r108 = new BuyNowAppInfos("Super", 8, "super", 9, 1319);
        Super = r108;
        BuyNowAppInfos r109 = new BuyNowAppInfos("Merchant", 9, "merchant", 0, 3102);
        Merchant = r109;
        BuyNowAppInfos r110 = new BuyNowAppInfos("AwemeLite", 10, "aweme_lite", 11, 2329);
        AwemeLite = r110;
        BuyNowAppInfos r111 = new BuyNowAppInfos("Pangle", 11, "pangle", 29, 1371);
        Pangle = r111;
        BuyNowAppInfos r112 = new BuyNowAppInfos("Changting", 12, "changting", 29, 3040);
        Changting = r112;
        BuyNowAppInfos r113 = new BuyNowAppInfos("ZhuXiaoBang", 13, "zhuxiaobang", 29, 1398);
        ZhuXiaoBang = r113;
        BuyNowAppInfos r114 = new BuyNowAppInfos("Unknown", 14, "UNKNOWN", 0, 0);
        Unknown = r114;
        f170904a = new BuyNowAppInfos[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114};
        Companion = new a();
    }

    public final int getAid() {
        return this.aid;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final int getBType() {
        return this.bType;
    }

    public BuyNowAppInfos(String r100, int r101, String r102, int r103, int r104) {
        super(r100, r101);
        this.appName = r102;
        this.bType = r103;
        this.aid = r104;
    }
}
