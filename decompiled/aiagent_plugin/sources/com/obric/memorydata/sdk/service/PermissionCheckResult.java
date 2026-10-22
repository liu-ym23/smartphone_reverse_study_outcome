package com.obric.memorydata.sdk.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: PermissionCheckResult.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class PermissionCheckResult implements Parcelable {
    public static final CREATOR CREATOR = null;
    private final String feedbackText;
    private final List<String> missedPermissions;

    /* JADX INFO: compiled from: PermissionCheckResult.kt */
    public static final class CREATOR implements Parcelable.Creator<PermissionCheckResult> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PermissionCheckResult createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PermissionCheckResult[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PermissionCheckResult createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            Object r1 = com.obric.capabilitykit.common.a.a().fromJson(r2.readString(), PermissionCheckResult.class);
            o.c(r1, "fromJson(...)");
            return (PermissionCheckResult) ZeusTransformUtils.preCheckCast(r1, PermissionCheckResult.class, "com.obric.aiagent.plugin");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PermissionCheckResult[] newArray(int r1) {
            return new PermissionCheckResult[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public static /* synthetic */ PermissionCheckResult copy$default(PermissionCheckResult r1, List r2, String r3, int r4, Object r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = r1.missedPermissions;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r1.feedbackText;
    L9:
        return r1.copy(r6, r3);
    }

    public final List<String> component1() {
        return this.missedPermissions;
    }

    public final String component2() {
        return this.feedbackText;
    }

    public final PermissionCheckResult copy(List<String> r2, String r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        o.e(r1, "missedPermissions");
        o.e(r3, "feedbackText");
        return new PermissionCheckResult(r1, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PermissionCheckResult.class) == true) goto L8;
        return false;
    L8:
        PermissionCheckResult r6 = (PermissionCheckResult) ZeusTransformUtils.preCheckCast(r5, PermissionCheckResult.class, "com.obric.aiagent.plugin");
        if (o.a(this.missedPermissions, r6.missedPermissions) == true) goto L12;
        return false;
    L12:
        if (o.a(this.feedbackText, r6.feedbackText) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.missedPermissions.hashCode() * 31) + this.feedbackText.hashCode();
    }

    public String toString() {
        return "PermissionCheckResult(missedPermissions=" + this.missedPermissions + ", feedbackText=" + this.feedbackText + ')';
    }

    public PermissionCheckResult(List<String> r3, String r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r5, "missedPermissions");
        o.e(r4, "feedbackText");
        this.missedPermissions = r5;
        this.feedbackText = r4;
    }

    public final List<String> getMissedPermissions() {
        return this.missedPermissions;
    }

    public final String getFeedbackText() {
        return this.feedbackText;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(com.obric.capabilitykit.common.a.a().toJson(this));
    }
}
