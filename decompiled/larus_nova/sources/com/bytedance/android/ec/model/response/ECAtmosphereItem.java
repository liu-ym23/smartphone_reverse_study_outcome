package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002BK\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t\u0012\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b&\u0010'J\t\u0010\u0004\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\t\u0010\n\u001a\u00020\tHÆ\u0003J\u0017\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003JQ\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\b\u0002\u0010\u0011\u001a\u00020\t2\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0001J\t\u0010\u0014\u001a\u00020\fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÖ\u0003R\u001a\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0011\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b!\u0010\"R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/bytedance/android/ec/model/response/ECAtmosphereItem;", "Ljava/io/Serializable;", "", "", "component1", "component2", "", "Lcom/bytedance/android/ec/model/live/b;", "component3", "", "component4", "", "", "component5", "type", "displayType", "content", "showDuration", "eventParam", "copy", "toString", "hashCode", "other", "", "equals", "I", "getType", "()I", "getDisplayType", "Ljava/util/List;", "getContent", "()Ljava/util/List;", "J", "getShowDuration", "()J", "Ljava/util/Map;", "getEventParam", "()Ljava/util/Map;", "<init>", "(IILjava/util/List;JLjava/util/Map;)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECAtmosphereItem implements Serializable {

    @SerializedName("content")
    private final List<com.bytedance.android.ec.model.live.b> content;

    @SerializedName("display_type")
    private final int displayType;

    @SerializedName("event_param")
    private final Map<String, String> eventParam;

    @SerializedName("show_duration")
    private final long showDuration;

    @SerializedName("type")
    private final int type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECAtmosphereItem copy$default(ECAtmosphereItem r100, int r101, int r102, List r103, long r104, Map r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.displayType;
    L8:
        int r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.content;
    L11:
        List r105 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.showDuration;
    L14:
        long r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.eventParam;
    L17:
        int r107 = r101;
        return r100.copy(r107, r113, r105, r106, r110);
    }

    public final int component1() {
        return this.type;
    }

    public final int component2() {
        return this.displayType;
    }

    public final List<com.bytedance.android.ec.model.live.b> component3() {
        return this.content;
    }

    public final long component4() {
        return this.showDuration;
    }

    public final Map<String, String> component5() {
        return this.eventParam;
    }

    public final ECAtmosphereItem copy(int r100, int r110, List<com.bytedance.android.ec.model.live.b> r111, long r112, Map<String, String> r113) {
        return new ECAtmosphereItem(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECAtmosphereItem) == false) goto L16;
        ECAtmosphereItem r101 = (ECAtmosphereItem) r100;
        if (this.type == r101.type) goto L8;
        return false;
    L8:
        if (this.displayType == r101.displayType) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L12;
        return false;
    L12:
        if (this.showDuration == r101.showDuration) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.eventParam, r101.eventParam) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r100 = ((this.type * 31) + this.displayType) * 31;
        List<com.bytedance.android.ec.model.live.b> r101 = this.content;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        long r104 = this.showDuration;
        int r105 = (((r100 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        Map<String, String> r106 = this.eventParam;
        if (r106 == null) goto L10;
        r102 = r106.hashCode();
    L10:
        return r105 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "ECAtmosphereItem(type=" + this.type + ", displayType=" + this.displayType + ", content=" + this.content + ", showDuration=" + this.showDuration + ", eventParam=" + this.eventParam + ")";
    }

    public final List<com.bytedance.android.ec.model.live.b> getContent() {
        return this.content;
    }

    public final int getDisplayType() {
        return this.displayType;
    }

    public final Map<String, String> getEventParam() {
        return this.eventParam;
    }

    public final long getShowDuration() {
        return this.showDuration;
    }

    public final int getType() {
        return this.type;
    }

    public ECAtmosphereItem(int r100, int r101, List<com.bytedance.android.ec.model.live.b> r102, long r103, Map<String, String> r104) {
        this.type = r100;
        this.displayType = r101;
        this.content = r102;
        this.showDuration = r103;
        this.eventParam = r104;
    }

    public /* synthetic */ ECAtmosphereItem(int r110, int r111, List r112, long r113, Map r114, int r115, DefaultConstructorMarker r116) {
        if ((r115 & 4) == 0) goto L5;
        List r100 = null;
    L7:
        if ((r115 & 8) == 0) goto L9;
        long r101 = -1;
    L11:
        if ((r115 & 16) == 0) goto L13;
        Map r102 = null;
    L14:
        this(r110, r111, r100, r101, r102);
        return;
    L13:
        r102 = r114;
        goto L14
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
