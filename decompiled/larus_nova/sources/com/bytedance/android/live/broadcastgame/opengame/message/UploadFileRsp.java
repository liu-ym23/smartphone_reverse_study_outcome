package com.bytedance.android.live.broadcastgame.opengame.message;

import com.baidu.mshield.x6.EngineImpl;
import com.google.gson.annotations.SerializedName;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/message/UploadFileRsp;", "", "md5", "", EngineImpl.KEY_OAID, "uri", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMd5", "()Ljava/lang/String;", "getOid", "getUri", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UploadFileRsp {

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    @SerializedName(URLDispatch.KEY_ETAG)
    private final String f60186md5;
    private final String oid;
    private final String uri;

    public static /* synthetic */ UploadFileRsp copy$default(UploadFileRsp r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.f60186md5;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.oid;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.uri;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.f60186md5;
    }

    public final String component2() {
        return this.oid;
    }

    public final String component3() {
        return this.uri;
    }

    public final UploadFileRsp copy(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "md5");
        Intrinsics.checkNotNullParameter(r101, EngineImpl.KEY_OAID);
        Intrinsics.checkNotNullParameter(r102, "uri");
        return new UploadFileRsp(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof UploadFileRsp) == false) goto L12;
        UploadFileRsp r101 = (UploadFileRsp) r100;
        if (Intrinsics.areEqual(this.f60186md5, r101.f60186md5) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.oid, r101.oid) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.f60186md5;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.oid;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.uri;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "UploadFileRsp(md5=" + this.f60186md5 + ", oid=" + this.oid + ", uri=" + this.uri + ")";
    }

    public final String getMd5() {
        return this.f60186md5;
    }

    public final String getOid() {
        return this.oid;
    }

    public final String getUri() {
        return this.uri;
    }

    public UploadFileRsp(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "md5");
        Intrinsics.checkNotNullParameter(r101, EngineImpl.KEY_OAID);
        Intrinsics.checkNotNullParameter(r102, "uri");
        this.f60186md5 = r100;
        this.oid = r101;
        this.uri = r102;
    }
}
