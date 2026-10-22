package com.bytedance.android.livesdk.performance.hprof.data;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/performance/hprof/data/LiveUploadInfoRes;", "", "domain", "", "accessKey", "secretKey", "spaceName", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessKey", "()Ljava/lang/String;", "getDomain", "getSecretKey", "getSession", "getSpaceName", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveUploadInfoRes {

    @SerializedName(TTVideoEngineInterface.AUTH_AK)
    private final String accessKey;

    @SerializedName("DomainName")
    private final String domain;

    @SerializedName(TTVideoEngineInterface.AUTH_SK)
    private final String secretKey;

    @SerializedName(TTVideoEngineInterface.AUTH_SESSIONTOKEN)
    private final String session;

    @SerializedName("SpaceName")
    private final String spaceName;

    public LiveUploadInfoRes() {
        this(null, null, null, null, null, 31, null);
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getSecretKey() {
        return this.secretKey;
    }

    public final String getSession() {
        return this.session;
    }

    public final String getSpaceName() {
        return this.spaceName;
    }

    public LiveUploadInfoRes(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "domain");
        Intrinsics.checkNotNullParameter(r101, "accessKey");
        Intrinsics.checkNotNullParameter(r102, "secretKey");
        Intrinsics.checkNotNullParameter(r103, "spaceName");
        Intrinsics.checkNotNullParameter(r104, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        this.domain = r100;
        this.accessKey = r101;
        this.secretKey = r102;
        this.spaceName = r103;
        this.session = r104;
    }

    public /* synthetic */ LiveUploadInfoRes(String r100, String r101, String r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = "";
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = "";
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = "";
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = "";
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = "";
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
