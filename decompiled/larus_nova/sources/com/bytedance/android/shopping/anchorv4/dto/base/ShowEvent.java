package com.bytedance.android.shopping.anchorv4.dto.base;

import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u001e\b\u0002\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006j\u0004\u0018\u0001`\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006j\u0004\u0018\u0001`\bHÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JM\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u001e\b\u0002\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006j\u0004\u0018\u0001`\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR,\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006j\u0004\u0018\u0001`\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/base/ShowEvent;", "Ljava/io/Serializable;", "id", "", "eventName", "meta", "Lcom/google/gson/internal/LinkedTreeMap;", "", "Lcom/bytedance/android/shopping/anchorv4/dto/meta/TrackMeta;", "btmId", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/internal/LinkedTreeMap;Ljava/lang/String;)V", "getBtmId", "()Ljava/lang/String;", "getEventName", "getId", "getMeta", "()Lcom/google/gson/internal/LinkedTreeMap;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShowEvent implements Serializable {

    @SerializedName("btm_id")
    private final String btmId;

    @SerializedName(ReportCardMonitorPlugin.EVENT_NAME)
    private final String eventName;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f166516id;

    @SerializedName("meta")
    private final LinkedTreeMap<String, Object> meta;

    public ShowEvent() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShowEvent copy$default(ShowEvent r100, String r101, String r102, LinkedTreeMap r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f166516id;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.eventName;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.meta;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.btmId;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.f166516id;
    }

    public final String component2() {
        return this.eventName;
    }

    public final LinkedTreeMap<String, Object> component3() {
        return this.meta;
    }

    public final String component4() {
        return this.btmId;
    }

    public final ShowEvent copy(String r100, String r101, LinkedTreeMap<String, Object> r102, String r103) {
        return new ShowEvent(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ShowEvent) == false) goto L14;
        ShowEvent r101 = (ShowEvent) r100;
        if (Intrinsics.areEqual(this.f166516id, r101.f166516id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.eventName, r101.eventName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.meta, r101.meta) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.btmId, r101.btmId) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.f166516id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.eventName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        LinkedTreeMap<String, Object> r107 = this.meta;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.btmId;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ShowEvent(id=" + this.f166516id + ", eventName=" + this.eventName + ", meta=" + this.meta + ", btmId=" + this.btmId + ")";
    }

    public final String getBtmId() {
        return this.btmId;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final String getId() {
        return this.f166516id;
    }

    public final LinkedTreeMap<String, Object> getMeta() {
        return this.meta;
    }

    public ShowEvent(String r100, String r101, LinkedTreeMap<String, Object> r102, String r103) {
        this.f166516id = r100;
        this.eventName = r101;
        this.meta = r102;
        this.btmId = r103;
    }

    public /* synthetic */ ShowEvent(String r100, String r101, LinkedTreeMap r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
