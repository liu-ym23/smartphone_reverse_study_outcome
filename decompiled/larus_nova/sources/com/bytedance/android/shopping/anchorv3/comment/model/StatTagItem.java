package com.bytedance.android.shopping.anchorv3.comment.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b&\b\u0086\b\u0018\u0000 /2\u00020\u0001:\u00010BW\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b-\u0010.J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bHÆ\u0003J\t\u0010\n\u001a\u00020\bHÆ\u0003J\t\u0010\f\u001a\u00020\u000bHÆ\u0003J\t\u0010\r\u001a\u00020\u000bHÆ\u0003J\t\u0010\u000e\u001a\u00020\bHÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÆ\u0003J\t\u0010\u0011\u001a\u00020\bHÆ\u0003JY\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\bHÆ\u0001J\t\u0010\u001b\u001a\u00020\u000bHÖ\u0001R\u0017\u0010\u0012\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0013\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u0017\u0010\u0014\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0015\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b#\u0010\"R\u0017\u0010\u0016\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u001c\u001a\u0004\b$\u0010\u001eR\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010%\u001a\u0004\b\u0017\u0010&\"\u0004\b'\u0010(R\u0017\u0010\u0018\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0018\u0010 \u001a\u0004\b)\u0010\"R\"\u0010\u0019\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001c\u001a\u0004\b*\u0010\u001e\"\u0004\b+\u0010,¨\u00061"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/comment/model/StatTagItem;", "Ljava/io/Serializable;", "", "other", "", "equals", "", "hashCode", "", "component1", "component2", "", "component3", "component4", "component5", "component6", "component7", "component8", "id", "count", "name", "tagName", "sentiment", "isStat", "originName", "tagVersion", "copy", "toString", "J", "getId", "()J", "getCount", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "getTagName", "getSentiment", "Z", "()Z", "setStat", "(Z)V", "getOriginName", "getTagVersion", "setTagVersion", "(J)V", "<init>", "(JJLjava/lang/String;Ljava/lang/String;JZLjava/lang/String;J)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StatTagItem implements Serializable {
    public static final a Companion = null;
    private final long count;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f164531id;
    private boolean isStat;
    private final String name;
    private final String originName;
    private final long sentiment;
    private final String tagName;
    private long tagVersion;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public StatTagItem() {
        this(0, 0, null, null, 0, false, null, 0, 255, null);
    }

    public static /* synthetic */ StatTagItem copy$default(StatTagItem r110, long r111, long r112, String r113, String r210, long r211, boolean r212, String r213, long r214, int r215, Object r216) {
        if ((r215 & 1) == 0) goto L5;
        long r100 = r110.f164531id;
    L7:
        if ((r215 & 2) == 0) goto L9;
        long r101 = r110.count;
    L11:
        if ((r215 & 4) == 0) goto L13;
        String r102 = r110.name;
    L15:
        if ((r215 & 8) == 0) goto L17;
        String r103 = r110.tagName;
    L19:
        if ((r215 & 16) == 0) goto L21;
        long r104 = r110.sentiment;
    L23:
        if ((r215 & 32) == 0) goto L25;
        boolean r114 = r110.isStat;
    L27:
        if ((r215 & 64) == 0) goto L29;
        String r115 = r110.originName;
    L31:
        if ((r215 & 128) == 0) goto L33;
        long r116 = r110.tagVersion;
    L35:
        return r110.copy(r100, r101, r102, r103, r104, r114, r115, r116);
    L33:
        r116 = r214;
        goto L35
    L29:
        r115 = r213;
        goto L31
    L25:
        r114 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final long component1() {
        return this.f164531id;
    }

    public final long component2() {
        return this.count;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.tagName;
    }

    public final long component5() {
        return this.sentiment;
    }

    public final boolean component6() {
        return this.isStat;
    }

    public final String component7() {
        return this.originName;
    }

    public final long component8() {
        return this.tagVersion;
    }

    public final StatTagItem copy(long r110, long r111, String r112, String r210, long r211, boolean r212, String r213, long r214) {
        Intrinsics.checkNotNullParameter(r112, "name");
        Intrinsics.checkNotNullParameter(r210, "tagName");
        Intrinsics.checkNotNullParameter(r213, "originName");
        return new StatTagItem(r110, r111, r112, r210, r211, r212, r213, r214);
    }

    public String toString() {
        return "StatTagItem(id=" + this.f164531id + ", count=" + this.count + ", name=" + this.name + ", tagName=" + this.tagName + ", sentiment=" + this.sentiment + ", isStat=" + this.isStat + ", originName=" + this.originName + ", tagVersion=" + this.tagVersion + ")";
    }

    public int hashCode() {
        long r100 = this.f164531id;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.count;
        int r103 = (((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.name.hashCode()) * 31) + this.tagName.hashCode()) * 31;
        long r104 = this.sentiment;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        if (this.isStat == false) goto L5;
        int r106 = 1231;
    L7:
        return ((r105 + r106) * 31) + this.originName.hashCode();
    L5:
        r106 = 1237;
        goto L7
    }

    public final long getCount() {
        return this.count;
    }

    public final long getId() {
        return this.f164531id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOriginName() {
        return this.originName;
    }

    public final long getSentiment() {
        return this.sentiment;
    }

    public final String getTagName() {
        return this.tagName;
    }

    public final long getTagVersion() {
        return this.tagVersion;
    }

    public final boolean isStat() {
        return this.isStat;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof StatTagItem) == true) goto L5;
        return false;
    L5:
        if (this == r100) goto L7;
        return false;
    L7:
        StatTagItem r101 = (StatTagItem) r100;
        if (this.f164531id == r101.f164531id) goto L10;
        return false;
    L10:
        if (this.count == r101.count) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.tagName, r101.tagName) == true) goto L16;
        return false;
    L16:
        if (this.sentiment == r101.sentiment) goto L18;
        return false;
    L18:
        if (this.isStat == r101.isStat) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.originName, r101.originName) == false) goto L29;
        return true;
    L29:
        return false;
    }

    public final void setStat(boolean r100) {
        this.isStat = r100;
    }

    public final void setTagVersion(long r100) {
        this.tagVersion = r100;
    }

    public StatTagItem(long r100, long r101, String r102, String r103, long r104, boolean r110, String r111, long r112) {
        Intrinsics.checkNotNullParameter(r102, "name");
        Intrinsics.checkNotNullParameter(r103, "tagName");
        Intrinsics.checkNotNullParameter(r111, "originName");
        this.f164531id = r100;
        this.count = r101;
        this.name = r102;
        this.tagName = r103;
        this.sentiment = r104;
        this.isStat = r110;
        this.originName = r111;
        this.tagVersion = r112;
    }

    public /* synthetic */ StatTagItem(long r110, long r111, String r112, String r113, long r210, boolean r211, String r212, long r213, int r214, DefaultConstructorMarker r215) {
        long r100 = -1;
        if ((r214 & 1) == 0) goto L5;
        long r101 = -1;
    L7:
        if ((r214 & 2) != 0) goto L10;
        r100 = r111;
    L10:
        String r102 = "";
        if ((r214 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r214 & 16) == 0) goto L21;
        long r105 = -2;
    L23:
        if ((r214 & 32) == 0) goto L25;
        boolean r114 = true;
    L27:
        if ((r214 & 64) != 0) goto L31;
        r102 = r212;
    L31:
        if ((r214 & 128) == 0) goto L33;
        long r115 = 0;
    L34:
        this(r101, r100, r103, r104, r105, r114, r102, r115);
        return;
    L33:
        r115 = r213;
        goto L34
    L25:
        r114 = r211;
        goto L27
    L21:
        r105 = r210;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L5:
        r101 = r110;
        goto L7
    }
}
