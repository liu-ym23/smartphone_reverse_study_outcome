package com.bytedance.android.shopping.skubuy.platform.helper;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/shopping/skubuy/platform/helper/AppInfos;", "", "", "appName", "Ljava/lang/String;", "getAppName", "()Ljava/lang/String;", "", "bType", "I", "getBType", "()I", "aid", "getAid", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "NewsLite", "NewsArticle", "VideoArticle", "LiveStream", "Aweme", "Automobile", "Wechat", ExifInterface.TAG_FLASH, "Super", "Merchant", "AwemeLite", "Pangle", "Changting", "ZhuXiaoBang", "Unknown", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AppInfos extends Enum<AppInfos> {
    public static final AppInfos Automobile = null;
    public static final AppInfos Aweme = null;
    public static final AppInfos AwemeLite = null;
    public static final AppInfos Changting = null;
    public static final a Companion = null;
    public static final AppInfos Flash = null;
    public static final AppInfos LiveStream = null;
    public static final AppInfos Merchant = null;
    public static final AppInfos NewsArticle = null;
    public static final AppInfos NewsLite = null;
    public static final AppInfos Pangle = null;
    public static final AppInfos Super = null;
    public static final AppInfos Unknown = null;
    public static final AppInfos VideoArticle = null;
    public static final AppInfos Wechat = null;
    public static final AppInfos ZhuXiaoBang = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppInfos[] f183160a = null;
    private final int aid;
    private final String appName;
    private final int bType;

    public static final class a {
        public a() {
        }
    }

    public static AppInfos valueOf(String r100) {
        return (AppInfos) r27.a.a(AppInfos.class, r100);
    }

    public static AppInfos[] values() {
        return (AppInfos[]) f183160a.clone();
    }

    static {
        AppInfos r100 = new AppInfos("NewsLite", 0, "NewsLite", 7, 35);
        NewsLite = r100;
        AppInfos r101 = new AppInfos("NewsArticle", 1, "NewsArticle", 3, 13);
        NewsArticle = r101;
        AppInfos r102 = new AppInfos("VideoArticle", 2, "VideoArticle", 4, 32);
        VideoArticle = r102;
        AppInfos r103 = new AppInfos("LiveStream", 3, "LiveStream", 1, 1112);
        LiveStream = r103;
        AppInfos r104 = new AppInfos("Aweme", 4, "Aweme", 2, 1128);
        Aweme = r104;
        AppInfos r105 = new AppInfos("Automobile", 5, "automobile", 8, 36);
        Automobile = r105;
        AppInfos r106 = new AppInfos("Wechat", 6, "wechat", 5, 0);
        Wechat = r106;
        AppInfos r107 = new AppInfos(ExifInterface.TAG_FLASH, 7, "flash", 6, 0);
        Flash = r107;
        AppInfos r108 = new AppInfos("Super", 8, "super", 9, 1319);
        Super = r108;
        AppInfos r109 = new AppInfos("Merchant", 9, "merchant", 0, 3102);
        Merchant = r109;
        AppInfos r110 = new AppInfos("AwemeLite", 10, "aweme_lite", 11, 2329);
        AwemeLite = r110;
        AppInfos r111 = new AppInfos("Pangle", 11, "pangle", 29, 1371);
        Pangle = r111;
        AppInfos r112 = new AppInfos("Changting", 12, "changting", 29, 3040);
        Changting = r112;
        AppInfos r113 = new AppInfos("ZhuXiaoBang", 13, "zhuxiaobang", 29, 1398);
        ZhuXiaoBang = r113;
        AppInfos r114 = new AppInfos("Unknown", 14, "UNKNOWN", 0, 0);
        Unknown = r114;
        f183160a = new AppInfos[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114};
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

    public AppInfos(String r100, int r101, String r102, int r103, int r104) {
        super(r100, r101);
        this.appName = r102;
        this.bType = r103;
        this.aid = r104;
    }
}
