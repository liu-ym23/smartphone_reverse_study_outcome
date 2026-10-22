package com.stepos.ailauncher.foundation.appui.card.provider.amap;

import N5.CardAction;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/C;", "", "", "imageUrl", "imageBase64", "", "aspectRatio", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/K;", "spec", "LN5/f;", "action", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/K;LN5/f;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getImageUrl", "getImageBase64", "Ljava/lang/Float;", "getAspectRatio", "()Ljava/lang/Float;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/K;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/K;", "LN5/f;", "getAction", "()LN5/f;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.C, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class MapPreview {

    @SerializedName("action")
    private final CardAction action;

    @SerializedName("aspectRatio")
    private final Float aspectRatio;

    @SerializedName("imageBase64")
    private final String imageBase64;

    @SerializedName("imageUrl")
    private final String imageUrl;

    @SerializedName("spec")
    private final MapSpec spec;

    public MapPreview() {
        this(null, null, null, null, null, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final MapSpec getSpec() {
        return this.spec;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MapPreview)) {
            return false;
        }
        MapPreview mapPreview = (MapPreview) other;
        return kotlin.jvm.internal.p.d(this.imageUrl, mapPreview.imageUrl) && kotlin.jvm.internal.p.d(this.imageBase64, mapPreview.imageBase64) && kotlin.jvm.internal.p.d(this.aspectRatio, mapPreview.aspectRatio) && kotlin.jvm.internal.p.d(this.spec, mapPreview.spec) && kotlin.jvm.internal.p.d(this.action, mapPreview.action);
    }

    public int hashCode() {
        String str = this.imageUrl;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.imageBase64;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Float f10 = this.aspectRatio;
        int iHashCode3 = (iHashCode2 + (f10 == null ? 0 : f10.hashCode())) * 31;
        MapSpec mapSpec = this.spec;
        int iHashCode4 = (iHashCode3 + (mapSpec == null ? 0 : mapSpec.hashCode())) * 31;
        CardAction cardAction = this.action;
        return iHashCode4 + (cardAction != null ? cardAction.hashCode() : 0);
    }

    public String toString() {
        return "MapPreview(imageUrl=" + this.imageUrl + ", imageBase64=" + this.imageBase64 + ", aspectRatio=" + this.aspectRatio + ", spec=" + this.spec + ", action=" + this.action + ")";
    }

    public MapPreview(String str, String str2, Float f10, MapSpec mapSpec, CardAction cardAction) {
        this.imageUrl = str;
        this.imageBase64 = str2;
        this.aspectRatio = f10;
        this.spec = mapSpec;
        this.action = cardAction;
    }

    public /* synthetic */ MapPreview(String str, String str2, Float f10, MapSpec mapSpec, CardAction cardAction, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : f10, (i10 & 8) != 0 ? null : mapSpec, (i10 & 16) != 0 ? null : cardAction);
    }
}
