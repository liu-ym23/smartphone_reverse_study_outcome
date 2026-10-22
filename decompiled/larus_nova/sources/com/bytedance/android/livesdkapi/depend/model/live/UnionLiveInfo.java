package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.UnionLiveInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\r\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u000bH\u0016J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0006R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/UnionLiveInfo;", "", "()V", "avatarDescription", "", "fixSort", "", "guestAnchors", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/GuestAnchor;", "type", "", "equals", "other", "hasRealGuestAnchor", "()Ljava/lang/Boolean;", "hashCode", "isGuestAnchor", "id", "isOgcUnion", "Companion", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UnionLiveInfo implements h {
    public static final Companion Companion = null;
    public static final int UNION_TYPE_OGC_NORMAL_LIVE = 2;
    public static final int UNION_TYPE_PUGC_LIVE = 3;
    public static final int UNION_TYPE_VS_LIVE = 1;

    @SerializedName("avatar_description")
    public String avatarDescription;

    @SerializedName("fixed_sort")
    public boolean fixSort;

    @SerializedName("guest_anchors")
    public List<GuestAnchor> guestAnchors;

    @SerializedName("type")
    public int type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/UnionLiveInfo$Companion;", "", "()V", "UNION_TYPE_OGC_NORMAL_LIVE", "", "UNION_TYPE_PUGC_LIVE", "UNION_TYPE_VS_LIVE", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public UnionLiveInfo() {
    }

    public final Boolean hasRealGuestAnchor() {
        List<GuestAnchor> r100 = this.guestAnchors;
        if (r100 == null) goto L21;
        List<GuestAnchor> r101 = r100;
        boolean r102 = false;
        if ((r101 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r103 = r101.iterator();
    L11:
        if (r103.hasNext() == false) goto L28;
        GuestAnchor r104 = (GuestAnchor) r103.next();
        if (r104 != null) goto L15;
    L17:
        boolean r105 = false;
    L18:
        if (r105 == false) goto L11;
        r102 = true;
        goto L28
    L15:
        if (r104.isUnionStarted() != true) goto L17;
        r105 = true;
    L28:
        return Boolean.valueOf(r102);
    L7:
        if (r101.isEmpty() == false) goto L9;
    L21:
        return null;
    }

    public int hashCode() {
        List<GuestAnchor> r100 = this.guestAnchors;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.avatarDescription;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        if (this.fixSort == false) goto L12;
        int r106 = 1231;
    L14:
        return ((r105 + r106) * 31) + this.type;
    L12:
        r106 = 1237;
        goto L14
    L5:
        r102 = 0;
        goto L6
    }

    public final boolean isOgcUnion() {
        int r100 = this.type;
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public UnionLiveInfo(g r100) {
        this.guestAnchors = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.guestAnchors.add(new GuestAnchor(r100));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.avatarDescription = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.fixSort = am3.h.a(r100);
        goto L3
    L12:
        if (r102 != 5) goto L13;
        this.type = r100.i();
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(UnionLiveInfo.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L27;
        UnionLiveInfo r102 = (UnionLiveInfo) r100;
        if ((!Intrinsics.areEqual(this.guestAnchors, r102.guestAnchors)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.avatarDescription, r102.avatarDescription)) == false) goto L20;
        return false;
    L20:
        if (this.fixSort == r102.fixSort) goto L23;
        return false;
    L23:
        if (this.type == r102.type) goto L25;
        return false;
    L25:
        return true;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.UnionLiveInfo");
    L8:
        r101 = null;
        goto L10
    }

    public final boolean isGuestAnchor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        List<GuestAnchor> r101 = this.guestAnchors;
        Object r102 = null;
        if (r101 == null) goto L17;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L16;
        Object r104 = r103.next();
        GuestAnchor r105 = (GuestAnchor) r104;
        if (r105 == null) goto L12;
        User r106 = r105.user;
        if (r106 == null) goto L12;
        String r107 = r106.getIdString();
    L14:
        if (Intrinsics.areEqual(r107, r100) == false) goto L6;
        r102 = r104;
    L12:
        r107 = null;
    L16:
        r102 = (GuestAnchor) r102;
    L17:
        if (r102 == null) goto L19;
        return true;
    L19:
        return false;
    }
}
