package com.bytedance.android.livesdkapi.model.gamecp;

import am3.g;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.gamecp.api.IntroduceCardTag")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/gamecp/GameIntroduceCardTag;", "", "iconUrl", "", n.KEY_SUB_TEXT, "(Ljava/lang/String;Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameIntroduceCardTag implements h {

    @SerializedName("icon_url")
    public String iconUrl;

    @SerializedName("sub_text")
    public String subText;

    public GameIntroduceCardTag(String r100, String r101) {
        this.iconUrl = r100;
        this.subText = r101;
    }

    public static /* synthetic */ GameIntroduceCardTag copy$default(GameIntroduceCardTag r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.iconUrl;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.subText;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.iconUrl;
    }

    public final String component2() {
        return this.subText;
    }

    public final GameIntroduceCardTag copy(String r100, String r101) {
        return new GameIntroduceCardTag(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GameIntroduceCardTag) == false) goto L10;
        GameIntroduceCardTag r101 = (GameIntroduceCardTag) r100;
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.subText, r101.subText) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.iconUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.subText;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "GameIntroduceCardTag(iconUrl=" + this.iconUrl + ", subText=" + this.subText + ")";
    }

    public GameIntroduceCardTag() {
        this.iconUrl = null;
        this.subText = null;
    }

    public GameIntroduceCardTag(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.iconUrl = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.subText = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.iconUrl != null) goto L16;
        this.iconUrl = null;
    L16:
        if (this.subText != null) goto L28;
        this.subText = null;
        return;
    }

    public /* synthetic */ GameIntroduceCardTag(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
