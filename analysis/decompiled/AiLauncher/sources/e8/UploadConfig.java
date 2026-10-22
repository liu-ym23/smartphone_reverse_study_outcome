package e8;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.weather.WeatherCardProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\"\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0011R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0018\u001a\u0004\b\u001b\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u0011R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010\u0011R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0013R\u0017\u0010\r\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b+\u0010)\u001a\u0004\b,\u0010\u0013¨\u0006-"}, d2 = {"Le8/b;", "", "", "endPoint", "stsEndPoint", WeatherCardProvider.KEY_REGION, "accessKey", "secretKey", "", "enableHttps", "defaultBucket", "", "maxRetry", "concurrency", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;II)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getEndPoint", Const.INTENT_KEY_PKGNAME, "getStsEndPoint", "c", "getRegion", Const.INTENT_KEY_UMID, "getAccessKey", "e", "getSecretKey", "f", "Z", "getEnableHttps", "()Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "getDefaultBucket", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "I", "getMaxRetry", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "getConcurrency", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: e8.b, reason: case insensitive filesystem and from toString */
/* loaded from: classes4.dex */
public final /* data */ class UploadConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String endPoint;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String stsEndPoint;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String region;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String accessKey;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final String secretKey;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean enableHttps;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final String defaultBucket;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    public final int maxRetry;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    public final int concurrency;

    public UploadConfig() {
        this(null, null, null, null, null, false, null, 0, 0, 511, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadConfig)) {
            return false;
        }
        UploadConfig uploadConfig = (UploadConfig) other;
        return p.d(this.endPoint, uploadConfig.endPoint) && p.d(this.stsEndPoint, uploadConfig.stsEndPoint) && p.d(this.region, uploadConfig.region) && p.d(this.accessKey, uploadConfig.accessKey) && p.d(this.secretKey, uploadConfig.secretKey) && this.enableHttps == uploadConfig.enableHttps && p.d(this.defaultBucket, uploadConfig.defaultBucket) && this.maxRetry == uploadConfig.maxRetry && this.concurrency == uploadConfig.concurrency;
    }

    public int hashCode() {
        return (((((((((((((((this.endPoint.hashCode() * 31) + this.stsEndPoint.hashCode()) * 31) + this.region.hashCode()) * 31) + this.accessKey.hashCode()) * 31) + this.secretKey.hashCode()) * 31) + Boolean.hashCode(this.enableHttps)) * 31) + this.defaultBucket.hashCode()) * 31) + Integer.hashCode(this.maxRetry)) * 31) + Integer.hashCode(this.concurrency);
    }

    public String toString() {
        return "UploadConfig(endPoint=" + this.endPoint + ", stsEndPoint=" + this.stsEndPoint + ", region=" + this.region + ", accessKey=" + this.accessKey + ", secretKey=" + this.secretKey + ", enableHttps=" + this.enableHttps + ", defaultBucket=" + this.defaultBucket + ", maxRetry=" + this.maxRetry + ", concurrency=" + this.concurrency + ")";
    }

    public UploadConfig(String endPoint, String stsEndPoint, String region, String accessKey, String secretKey, boolean z10, String defaultBucket, int i10, int i11) {
        p.i(endPoint, "endPoint");
        p.i(stsEndPoint, "stsEndPoint");
        p.i(region, "region");
        p.i(accessKey, "accessKey");
        p.i(secretKey, "secretKey");
        p.i(defaultBucket, "defaultBucket");
        this.endPoint = endPoint;
        this.stsEndPoint = stsEndPoint;
        this.region = region;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.enableHttps = z10;
        this.defaultBucket = defaultBucket;
        this.maxRetry = i10;
        this.concurrency = i11;
    }

    public /* synthetic */ UploadConfig(String str, String str2, String str3, String str4, String str5, boolean z10, String str6, int i10, int i11, int i12, i iVar) {
        this((i12 & 1) != 0 ? "tos-s3-cn-shanghai.volces.com" : str, (i12 & 2) != 0 ? "tos-cn-shanghai.volces.com" : str2, (i12 & 4) != 0 ? "cn-shanghai" : str3, (i12 & 8) != 0 ? "AKLTZjM1ODQyYjYwYjZiNDQwN2E5YTJkZWJjYTM5NTY2Yjc" : str4, (i12 & 16) != 0 ? "WXpBelltRXlPR1JtTkRRME5HRTBPV0ZpTkdFMk56TXhNVE14TlRReVlXRQ==" : str5, (i12 & 32) != 0 ? true : z10, (i12 & 64) != 0 ? "test-bucket-allservice" : str6, (i12 & 128) != 0 ? 3 : i10, (i12 & 256) != 0 ? 5 : i11);
    }
}
