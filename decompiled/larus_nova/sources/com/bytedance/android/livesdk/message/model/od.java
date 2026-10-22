package com.bytedance.android.livesdk.message.model;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.depend.message.MVUrlStruct;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/od;", "", "Lcom/bytedance/android/livesdk/message/model/ag;", "baseInfo", "Lcom/bytedance/android/livesdk/message/model/ag;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/message/model/ag;", "setBaseInfo", "(Lcom/bytedance/android/livesdk/message/model/ag;)V", "", "count", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "setCount", "(Ljava/lang/Integer;)V", "", "createTime", "J", "getCreateTime", "()J", "setCreateTime", "(J)V", "ktvMVType", "I", "e", "()I", RXScreenCaptureService.KEY_INDEX, "(I)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class od implements vh7.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f153676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f153677b;

    @SerializedName("mv_base_info")
    protected ag baseInfo;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f153678c;

    @SerializedName("count")
    protected Integer count;

    @SerializedName("create_time")
    protected long createTime;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f153679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f153680e;

    @SerializedName("ktv_mv_type")
    protected int ktvMVType;

    public final int hashCode() {
        ag r100 = this.baseInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.count;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        long r106 = this.createTime;
        return ((r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31) + this.ktvMVType;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "KtvMVInfo(baseInfo=" + this.baseInfo + ", count=" + this.count + ", createTime=" + this.createTime + ", ktvMVType=" + this.ktvMVType + ")";
    }

    public final String c() {
        ag r100 = this.baseInfo;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.coverUrl;
    }

    public final String d() {
        ag r100 = this.baseInfo;
        Object r101 = null;
        if (r100 == null) goto L19;
        MVUrlStruct r102 = r100.downloadAddr;
        if (r102 == null) goto L20;
        List<String> r103 = r102.getUrlList();
        if (r103 == null) goto L21;
        Iterator<T> r104 = r103.iterator();
    L10:
        if (r104.hasNext() == false) goto L15;
        Object r105 = r104.next();
        if ((!TextUtils.isEmpty((String) r105)) == false) goto L10;
        r101 = r105;
    L15:
        return (String) r101;
    L21:
        return null;
    L20:
        return null;
    L19:
        return null;
    }

    public final String f() {
        ag r100 = this.baseInfo;
        if (r100 == null) goto L6;
        String r101 = r100.videoId;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final boolean g() {
        if (this.ktvMVType != KtvTypetv.KTVMVType_OFFICIAl.ordinal()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void h() {
        Long r100 = this.f153676a;
        if (r100 != null) goto L6;
        this.f153676a = Long.valueOf(System.currentTimeMillis());
        return;
    L6:
        Long r101 = this.f153677b;
        if (r101 != null) goto L9;
        this.f153677b = Long.valueOf(System.currentTimeMillis() - r100.longValue());
        this.f153676a = Long.valueOf(System.currentTimeMillis());
        return;
    L9:
        if (r101 == null) goto L11;
        long r102 = r101.longValue();
    L12:
        this.f153677b = Long.valueOf(r102 + (System.currentTimeMillis() - r100.longValue()));
        this.f153676a = Long.valueOf(System.currentTimeMillis());
        return;
    L11:
        r102 = 0;
        goto L12
    }

    public od() {
        this.baseInfo = null;
        this.count = 0;
        this.createTime = 0;
        this.ktvMVType = KtvTypetv.KTVMVType_Unknown.ordinal();
    }

    public final ag a() {
        return this.baseInfo;
    }

    public final Integer b() {
        return this.count;
    }

    public final int e() {
        return this.ktvMVType;
    }

    public od(am3.g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L17;
        if (r103 != 1) goto L7;
        this.baseInfo = new ag(r100);
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.count = Integer.valueOf((int) r100.j());
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this.createTime = r100.j();
        r102 = r102 | 1;
        goto L3
    L11:
        if (r103 != 4) goto L12;
        this.ktvMVType = r100.i();
        r102 = r102 | 2;
        goto L3
    L12:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if (this.baseInfo != null) goto L21;
        this.baseInfo = null;
    L21:
        if (this.count != null) goto L24;
        this.count = 0;
    L24:
        if ((r102 & 1) != 0) goto L27;
        this.createTime = 0;
    L27:
        if ((r102 & 2) != 0) goto L45;
        this.ktvMVType = KtvTypetv.KTVMVType_Unknown.ordinal();
        return;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof od) == false) goto L13;
        ag r101 = this.baseInfo;
        String r102 = null;
        if (r101 == null) goto L7;
        String r103 = r101.videoId;
    L8:
        ag r104 = ((od) r100).baseInfo;
        if (r104 == null) goto L12;
        r102 = r104.videoId;
    L12:
        return Intrinsics.areEqual(r103, r102);
    L7:
        r103 = null;
        goto L8
    L13:
        return false;
    }

    public final void i(int r100) {
        this.ktvMVType = r100;
    }
}
