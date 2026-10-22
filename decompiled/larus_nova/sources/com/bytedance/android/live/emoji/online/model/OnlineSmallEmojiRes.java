package com.bytedance.android.live.emoji.online.model;

import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001!B9\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0003JC\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001b\u0010\u001aR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u001d\u0010\u001a¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/emoji/online/model/OnlineSmallEmojiRes;", "Ljava/io/Serializable;", "", "component1", "", "component2", "component3", "component4", "component5", "id", "createTime", UserInfo.UPDATE_TIME, "resourceUrl", "md5", "copy", "toString", "hashCode", "", "other", "", "equals", "I", "getId", "()I", "Ljava/lang/String;", "getCreateTime", "()Ljava/lang/String;", "getUpdateTime", "getResourceUrl", "getMd5", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveemoji-impl_release"}, k = 1, mv = {1, 4, 3})
public final class OnlineSmallEmojiRes implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("create_time")
    private final String createTime;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final int f68939id;

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    @SerializedName("md5")
    private final String f68940md5;

    @SerializedName("resource_url")
    private final String resourceUrl;

    @SerializedName("update_time")
    private final String updateTime;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ OnlineSmallEmojiRes copy$default(OnlineSmallEmojiRes r100, int r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.f68939id;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.createTime;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.updateTime;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.resourceUrl;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.f68940md5;
    L17:
        int r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final int component1() {
        return this.f68939id;
    }

    public final String component2() {
        return this.createTime;
    }

    public final String component3() {
        return this.updateTime;
    }

    public final String component4() {
        return this.resourceUrl;
    }

    public final String component5() {
        return this.f68940md5;
    }

    public final OnlineSmallEmojiRes copy(int r100, String r101, String r110, String r111, String r112) {
        return new OnlineSmallEmojiRes(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof OnlineSmallEmojiRes) == false) goto L16;
        OnlineSmallEmojiRes r101 = (OnlineSmallEmojiRes) r100;
        if (this.f68939id == r101.f68939id) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.createTime, r101.createTime) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.updateTime, r101.updateTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.resourceUrl, r101.resourceUrl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f68940md5, r101.f68940md5) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r100 = this.f68939id * 31;
        String r101 = this.createTime;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.updateTime;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.resourceUrl;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f68940md5;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        return r110 + r102;
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "OnlineSmallEmojiRes(id=" + this.f68939id + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", resourceUrl=" + this.resourceUrl + ", md5=" + this.f68940md5 + ")";
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final int getId() {
        return this.f68939id;
    }

    public final String getMd5() {
        return this.f68940md5;
    }

    public final String getResourceUrl() {
        return this.resourceUrl;
    }

    public final String getUpdateTime() {
        return this.updateTime;
    }

    public OnlineSmallEmojiRes(int r100, String r101, String r102, String r103, String r104) {
        this.f68939id = r100;
        this.createTime = r101;
        this.updateTime = r102;
        this.resourceUrl = r103;
        this.f68940md5 = r104;
    }

    public /* synthetic */ OnlineSmallEmojiRes(int r100, String r101, String r102, String r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        int r103 = 0;
    L6:
        this(r103, r101, r102, r110, r111);
        return;
    L5:
        r103 = r100;
        goto L6
    }
}
