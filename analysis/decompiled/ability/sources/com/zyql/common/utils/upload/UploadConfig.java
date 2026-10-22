package com.zyql.common.utils.upload;

import androidx.compose.foundation.b;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.llmapi.stepfun.trace.TraceParams;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\fHÆ\u0003J\t\u0010$\u001a\u00020\fHÆ\u0003Jc\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fHÆ\u0001J\u0013\u0010&\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\fHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001a¨\u0006*"}, d2 = {"Lcom/zyql/common/utils/upload/UploadConfig;", "", "endPoint", "", "stsEndPoint", "region", "accessKey", "secretKey", "enableHttps", "", "defaultBucket", "maxRetry", "", "concurrency", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;II)V", "getEndPoint", "()Ljava/lang/String;", "getStsEndPoint", "getRegion", "getAccessKey", "getSecretKey", "getEnableHttps", "()Z", "getDefaultBucket", "getMaxRetry", "()I", "getConcurrency", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UploadConfig {
    private final String accessKey;
    private final int concurrency;
    private final String defaultBucket;
    private final boolean enableHttps;
    private final String endPoint;
    private final int maxRetry;
    private final String region;
    private final String secretKey;
    private final String stsEndPoint;

    public UploadConfig() {
        this(null, null, null, null, null, false, null, 0, 0, 511, null);
    }

    public static /* synthetic */ UploadConfig copy$default(UploadConfig uploadConfig, String str, String str2, String str3, String str4, String str5, boolean z10, String str6, int i, int i6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = uploadConfig.endPoint;
        }
        if ((i10 & 2) != 0) {
            str2 = uploadConfig.stsEndPoint;
        }
        if ((i10 & 4) != 0) {
            str3 = uploadConfig.region;
        }
        if ((i10 & 8) != 0) {
            str4 = uploadConfig.accessKey;
        }
        if ((i10 & 16) != 0) {
            str5 = uploadConfig.secretKey;
        }
        if ((i10 & 32) != 0) {
            z10 = uploadConfig.enableHttps;
        }
        if ((i10 & 64) != 0) {
            str6 = uploadConfig.defaultBucket;
        }
        if ((i10 & 128) != 0) {
            i = uploadConfig.maxRetry;
        }
        if ((i10 & 256) != 0) {
            i6 = uploadConfig.concurrency;
        }
        int i11 = i;
        int i12 = i6;
        boolean z11 = z10;
        String str7 = str6;
        String str8 = str5;
        String str9 = str3;
        return uploadConfig.copy(str, str2, str9, str4, str8, z11, str7, i11, i12);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEndPoint() {
        return this.endPoint;
    }

    /* renamed from: component2, reason: from getter */
    public final String getStsEndPoint() {
        return this.stsEndPoint;
    }

    /* renamed from: component3, reason: from getter */
    public final String getRegion() {
        return this.region;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAccessKey() {
        return this.accessKey;
    }

    /* renamed from: component5, reason: from getter */
    public final String getSecretKey() {
        return this.secretKey;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getEnableHttps() {
        return this.enableHttps;
    }

    /* renamed from: component7, reason: from getter */
    public final String getDefaultBucket() {
        return this.defaultBucket;
    }

    /* renamed from: component8, reason: from getter */
    public final int getMaxRetry() {
        return this.maxRetry;
    }

    /* renamed from: component9, reason: from getter */
    public final int getConcurrency() {
        return this.concurrency;
    }

    public final UploadConfig copy(String endPoint, String stsEndPoint, String region, String accessKey, String secretKey, boolean enableHttps, String defaultBucket, int maxRetry, int concurrency) {
        k.f(endPoint, "endPoint");
        k.f(stsEndPoint, "stsEndPoint");
        k.f(region, "region");
        k.f(accessKey, "accessKey");
        k.f(secretKey, "secretKey");
        k.f(defaultBucket, "defaultBucket");
        return new UploadConfig(endPoint, stsEndPoint, region, accessKey, secretKey, enableHttps, defaultBucket, maxRetry, concurrency);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadConfig)) {
            return false;
        }
        UploadConfig uploadConfig = (UploadConfig) other;
        return k.b(this.endPoint, uploadConfig.endPoint) && k.b(this.stsEndPoint, uploadConfig.stsEndPoint) && k.b(this.region, uploadConfig.region) && k.b(this.accessKey, uploadConfig.accessKey) && k.b(this.secretKey, uploadConfig.secretKey) && this.enableHttps == uploadConfig.enableHttps && k.b(this.defaultBucket, uploadConfig.defaultBucket) && this.maxRetry == uploadConfig.maxRetry && this.concurrency == uploadConfig.concurrency;
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final int getConcurrency() {
        return this.concurrency;
    }

    public final String getDefaultBucket() {
        return this.defaultBucket;
    }

    public final boolean getEnableHttps() {
        return this.enableHttps;
    }

    public final String getEndPoint() {
        return this.endPoint;
    }

    public final int getMaxRetry() {
        return this.maxRetry;
    }

    public final String getRegion() {
        return this.region;
    }

    public final String getSecretKey() {
        return this.secretKey;
    }

    public final String getStsEndPoint() {
        return this.stsEndPoint;
    }

    public int hashCode() {
        return Integer.hashCode(this.concurrency) + a.a(this.maxRetry, B7.a.c(androidx.appfunctions.metadata.a.d(B7.a.c(B7.a.c(B7.a.c(B7.a.c(this.endPoint.hashCode() * 31, 31, this.stsEndPoint), 31, this.region), 31, this.accessKey), 31, this.secretKey), 31, this.enableHttps), 31, this.defaultBucket), 31);
    }

    public String toString() {
        String str = this.endPoint;
        String str2 = this.stsEndPoint;
        String str3 = this.region;
        String str4 = this.accessKey;
        String str5 = this.secretKey;
        boolean z10 = this.enableHttps;
        String str6 = this.defaultBucket;
        int i = this.maxRetry;
        int i6 = this.concurrency;
        StringBuilder sbW = B7.a.w("UploadConfig(endPoint=", str, ", stsEndPoint=", str2, ", region=");
        a.A(sbW, str3, ", accessKey=", str4, ", secretKey=");
        sbW.append(str5);
        sbW.append(", enableHttps=");
        sbW.append(z10);
        sbW.append(", defaultBucket=");
        b.B(sbW, str6, ", maxRetry=", i, ", concurrency=");
        return androidx.appfunctions.metadata.a.o(sbW, ")", i6);
    }

    public UploadConfig(String endPoint, String stsEndPoint, String region, String accessKey, String secretKey, boolean z10, String defaultBucket, int i, int i6) {
        k.f(endPoint, "endPoint");
        k.f(stsEndPoint, "stsEndPoint");
        k.f(region, "region");
        k.f(accessKey, "accessKey");
        k.f(secretKey, "secretKey");
        k.f(defaultBucket, "defaultBucket");
        this.endPoint = endPoint;
        this.stsEndPoint = stsEndPoint;
        this.region = region;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.enableHttps = z10;
        this.defaultBucket = defaultBucket;
        this.maxRetry = i;
        this.concurrency = i6;
    }

    public /* synthetic */ UploadConfig(String str, String str2, String str3, String str4, String str5, boolean z10, String str6, int i, int i6, int i10, e eVar) {
        this((i10 & 1) != 0 ? "tos-s3-cn-shanghai.volces.com" : str, (i10 & 2) != 0 ? TraceParams.END_POINT : str2, (i10 & 4) != 0 ? TraceParams.REGION : str3, (i10 & 8) != 0 ? "AKLTZjM1ODQyYjYwYjZiNDQwN2E5YTJkZWJjYTM5NTY2Yjc" : str4, (i10 & 16) != 0 ? "WXpBelltRXlPR1JtTkRRME5HRTBPV0ZpTkdFMk56TXhNVE14TlRReVlXRQ==" : str5, (i10 & 32) != 0 ? true : z10, (i10 & 64) != 0 ? "test-bucket-allservice" : str6, (i10 & 128) != 0 ? 3 : i, (i10 & 256) != 0 ? 5 : i6);
    }
}
