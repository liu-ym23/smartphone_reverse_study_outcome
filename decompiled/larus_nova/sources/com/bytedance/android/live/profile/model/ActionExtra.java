package com.bytedance.android.live.profile.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/profile/model/ActionExtra;", "", "inviteText", "", "sweepCount", "", "(Ljava/lang/String;I)V", "getInviteText", "()Ljava/lang/String;", "getSweepCount", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ActionExtra {

    @SerializedName("invite_text")
    private final String inviteText;

    @SerializedName("effect_show_count")
    private final int sweepCount;

    /* JADX WARN: Multi-variable type inference failed */
    public ActionExtra() {
        String r100 = null;
        this(r100, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ActionExtra copy$default(ActionExtra r100, String r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.inviteText;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.sweepCount;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.inviteText;
    }

    public final int component2() {
        return this.sweepCount;
    }

    public final ActionExtra copy(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "inviteText");
        return new ActionExtra(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ActionExtra) == false) goto L10;
        ActionExtra r101 = (ActionExtra) r100;
        if (Intrinsics.areEqual(this.inviteText, r101.inviteText) == true) goto L8;
        return false;
    L8:
        if (this.sweepCount == r101.sweepCount) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.inviteText;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.sweepCount;
    L5:
        r101 = 0;
        goto L7
    }

    public String toString() {
        return "ActionExtra(inviteText=" + this.inviteText + ", sweepCount=" + this.sweepCount + ")";
    }

    public final String getInviteText() {
        return this.inviteText;
    }

    public final int getSweepCount() {
        return this.sweepCount;
    }

    public ActionExtra(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "inviteText");
        this.inviteText = r100;
        this.sweepCount = r101;
    }

    public /* synthetic */ ActionExtra(String r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
