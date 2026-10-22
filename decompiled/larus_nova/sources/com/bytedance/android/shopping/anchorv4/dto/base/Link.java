package com.bytedance.android.shopping.anchorv4.dto.base;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;", "Ljava/io/Serializable;", "action", "", "linkUrl", "", "actionEventId", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getActionEventId", "()Ljava/lang/String;", "getLinkUrl", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;", "equals", "", "other", "", "hashCode", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Link implements Serializable {

    @SerializedName("action")
    private final Integer action;

    @SerializedName("action_event_id")
    private final String actionEventId;

    @SerializedName("link_url")
    private final String linkUrl;

    public Link() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ Link copy$default(Link r100, Integer r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.action;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.linkUrl;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.actionEventId;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Integer component1() {
        return this.action;
    }

    public final String component2() {
        return this.linkUrl;
    }

    public final String component3() {
        return this.actionEventId;
    }

    public final Link copy(Integer r100, String r101, String r102) {
        return new Link(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Link) == false) goto L12;
        Link r101 = (Link) r100;
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.linkUrl, r101.linkUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.actionEventId, r101.actionEventId) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        Integer r100 = this.action;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.linkUrl;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.actionEventId;
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
        return "Link(action=" + this.action + ", linkUrl=" + this.linkUrl + ", actionEventId=" + this.actionEventId + ")";
    }

    public final Integer getAction() {
        return this.action;
    }

    public final String getActionEventId() {
        return this.actionEventId;
    }

    public final String getLinkUrl() {
        return this.linkUrl;
    }

    public Link(Integer r100, String r101, String r102) {
        this.action = r100;
        this.linkUrl = r101;
        this.actionEventId = r102;
    }

    public /* synthetic */ Link(Integer r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
