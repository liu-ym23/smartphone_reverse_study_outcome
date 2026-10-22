package com.bytedance.android.livesdk.wrds.syncdata.openplatform;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.ShelfCardAtmosphereSyncData")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/wrds/syncdata/openplatform/b;", "", "", "roomId", "J", "getRoomId", "()J", "cardId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "Lcom/bytedance/android/live/base/model/ImageModel;", "image", "Ljava/util/List;", "getImage", "()Ljava/util/List;", "saleNum", "d", "", "duration", "I", "b", "()I", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements h {

    @SerializedName("card_id")
    protected long cardId;

    @SerializedName("duration")
    protected int duration;

    @SerializedName("img")
    protected List<ImageModel> image;

    @SerializedName("room_id")
    protected long roomId;

    @SerializedName("sale_num")
    protected long saleNum;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L16;
        b r101 = (b) r100;
        if (this.roomId == r101.roomId) goto L8;
        return false;
    L8:
        if (this.cardId == r101.cardId) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L12;
        return false;
    L12:
        if (this.saleNum == r101.saleNum) goto L14;
        return false;
    L14:
        if (this.duration == r101.duration) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        long r100 = this.roomId;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.cardId;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        List<ImageModel> r104 = this.image;
        if (r104 == null) goto L5;
        int r105 = r104.hashCode();
    L6:
        long r106 = this.saleNum;
        return ((((r103 + r105) * 31) + ((int) (r106 ^ (r106 >>> 32)))) * 31) + this.duration;
    L5:
        r105 = 0;
        goto L6
    }

    public final String toString() {
        return "ShelfCardAtmosphereSyncData(roomId=" + this.roomId + ", cardId=" + this.cardId + ", image=" + this.image + ", saleNum=" + this.saleNum + ", duration=" + this.duration + ")";
    }

    public final String c() {
        List<ImageModel> r100 = this.image;
        if (r100 == null) goto L9;
        ImageModel r101 = (ImageModel) CollectionsKt.firstOrNull(r100);
        if (r101 == null) goto L9;
        List<String> r102 = r101.getUrls();
        if (r102 == null) goto L9;
        return (String) CollectionsKt.firstOrNull(r102);
    L9:
        return null;
    }

    public b() {
        this.roomId = 0;
        this.cardId = 0;
        this.image = null;
        this.saleNum = 0;
        this.duration = 0;
    }

    public final long a() {
        return this.cardId;
    }

    public final int b() {
        return this.duration;
    }

    public final long d() {
        return this.saleNum;
    }

    public b(g r100) {
        this.image = new ArrayList();
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        if (r103 != 1) goto L8;
        this.roomId = r100.j();
        r102 = r102 | 1;
        goto L3
    L8:
        if (r103 != 2) goto L10;
        this.cardId = r100.j();
        r102 = r102 | 2;
        goto L3
    L10:
        if (r103 != 3) goto L12;
        this.image.add(x.a(r100));
        goto L3
    L12:
        if (r103 != 4) goto L14;
        this.saleNum = r100.j();
        r102 = r102 | 4;
        goto L3
    L14:
        if (r103 != 5) goto L15;
        this.duration = r100.i();
        r102 = r102 | 8;
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L25;
        this.roomId = 0;
    L25:
        if ((r102 & 2) != 0) goto L28;
        this.cardId = 0;
    L28:
        if (this.image.isEmpty() == false) goto L31;
        this.image = null;
    L31:
        if ((r102 & 4) != 0) goto L34;
        this.saleNum = 0;
    L34:
        if ((r102 & 8) != 0) goto L55;
        this.duration = 0;
        return;
    }
}
