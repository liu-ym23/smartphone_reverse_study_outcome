package com.bytedance.safetyguard.lxc.internal.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ProxyIpcModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActionEgressResultParcel implements Parcelable {
    public static final Parcelable.Creator<ActionEgressResultParcel> CREATOR = null;
    private final List<SensitiveCategoryInfoParcel> approvedCategories;
    private final List<AttemptedOutboundTargetParcel> attemptedTargets;
    private final boolean attemptedTargetsTruncated;
    private final List<SensitiveCategoryInfoParcel> deniedCategories;
    private final int protocolVersion;
    private final int status;
    private final List<SensitiveCategoryInfoParcel> unapprovedCategories;
    private final long unreportedAttemptCount;

    /* JADX INFO: compiled from: ProxyIpcModels.kt */
    public static final class Creator implements Parcelable.Creator<ActionEgressResultParcel> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ActionEgressResultParcel createFromParcel(Parcel r12) {
            o.e(r12, "parcel");
            int r1 = r12.readInt();
            int r2 = r12.readInt();
            int r11 = r12.readInt();
            ArrayList r0 = new ArrayList(r11);
            int r4 = 0;
        L3:
            if (r4 == r11) goto L5;
            r0.add(SensitiveCategoryInfoParcel.CREATOR.createFromParcel(r12));
            r4 = r4 + 1;
            goto L3
        L5:
            List r13 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
            int r3 = r12.readInt();
            ArrayList r5 = new ArrayList(r3);
            int r6 = 0;
        L6:
            if (r6 == r3) goto L8;
            r5.add(SensitiveCategoryInfoParcel.CREATOR.createFromParcel(r12));
            r6 = r6 + 1;
            goto L6
        L8:
            List r7 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin");
            int r8 = r12.readInt();
            ArrayList r9 = new ArrayList(r8);
            int r10 = 0;
        L9:
            if (r10 == r8) goto L11;
            r9.add(SensitiveCategoryInfoParcel.CREATOR.createFromParcel(r12));
            r10 = r10 + 1;
            goto L9
        L11:
            List r14 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin");
            int r15 = r12.readInt();
            ArrayList r16 = new ArrayList(r15);
            int r17 = 0;
        L12:
            if (r17 == r15) goto L14;
            r16.add(AttemptedOutboundTargetParcel.CREATOR.createFromParcel(r12));
            r17 = r17 + 1;
            goto L12
        L14:
            List r18 = (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.aiagent.plugin");
            if (r12.readInt() == 0) goto L17;
            boolean r19 = true;
        L19:
            return new ActionEgressResultParcel(r1, r2, r13, r7, r14, r18, r19, r12.readLong());
        L17:
            r19 = false;
            goto L19
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ActionEgressResultParcel createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ActionEgressResultParcel[] newArray(int r1) {
            return new ActionEgressResultParcel[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ActionEgressResultParcel[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ ActionEgressResultParcel copy$default(ActionEgressResultParcel r11, int r12, int r13, List r14, List r15, List r16, List r17, boolean r18, long r19, int r21, Object r22) {
        List<SensitiveCategoryInfoParcel> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
        List<SensitiveCategoryInfoParcel> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        List<SensitiveCategoryInfoParcel> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
        List<AttemptedOutboundTargetParcel> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
        if ((r21 & 1) == 0) goto L5;
        int r6 = r11.protocolVersion;
    L7:
        if ((r21 & 2) == 0) goto L9;
        int r7 = r11.status;
    L11:
        if ((r21 & 4) == 0) goto L14;
        r2 = r11.unapprovedCategories;
    L14:
        if ((r21 & 8) == 0) goto L17;
        r4 = r11.deniedCategories;
    L17:
        if ((r21 & 16) == 0) goto L20;
        r5 = r11.approvedCategories;
    L20:
        if ((r21 & 32) == 0) goto L23;
        r3 = r11.attemptedTargets;
    L23:
        if ((r21 & 64) == 0) goto L25;
        boolean r8 = r11.attemptedTargetsTruncated;
    L27:
        if ((r21 & 128) == 0) goto L29;
        long r9 = r11.unreportedAttemptCount;
    L31:
        return r11.copy(r6, r7, r2, r4, r5, r3, r8, r9);
    L29:
        r9 = r19;
        goto L31
    L25:
        r8 = r18;
        goto L27
    L9:
        r7 = r13;
        goto L11
    L5:
        r6 = r12;
        goto L7
    }

    public final int component1() {
        return this.protocolVersion;
    }

    public final int component2() {
        return this.status;
    }

    public final List<SensitiveCategoryInfoParcel> component3() {
        return this.unapprovedCategories;
    }

    public final List<SensitiveCategoryInfoParcel> component4() {
        return this.deniedCategories;
    }

    public final List<SensitiveCategoryInfoParcel> component5() {
        return this.approvedCategories;
    }

    public final List<AttemptedOutboundTargetParcel> component6() {
        return this.attemptedTargets;
    }

    public final boolean component7() {
        return this.attemptedTargetsTruncated;
    }

    public final long component8() {
        return this.unreportedAttemptCount;
    }

    public final ActionEgressResultParcel copy(int r13, int r14, List<SensitiveCategoryInfoParcel> r15, List<SensitiveCategoryInfoParcel> r16, List<SensitiveCategoryInfoParcel> r17, List<AttemptedOutboundTargetParcel> r18, boolean r19, long r20) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        o.e(r5, "unapprovedCategories");
        o.e(r6, "deniedCategories");
        o.e(r7, "approvedCategories");
        o.e(r8, "attemptedTargets");
        return new ActionEgressResultParcel(r13, r14, r5, r6, r7, r8, r19, r20);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, ActionEgressResultParcel.class) == true) goto L8;
        return false;
    L8:
        ActionEgressResultParcel r8 = (ActionEgressResultParcel) ZeusTransformUtils.preCheckCast(r7, ActionEgressResultParcel.class, "com.obric.aiagent.plugin");
        if (this.protocolVersion == r8.protocolVersion) goto L12;
        return false;
    L12:
        if (this.status == r8.status) goto L15;
        return false;
    L15:
        if (o.a(this.unapprovedCategories, r8.unapprovedCategories) == true) goto L18;
        return false;
    L18:
        if (o.a(this.deniedCategories, r8.deniedCategories) == true) goto L21;
        return false;
    L21:
        if (o.a(this.approvedCategories, r8.approvedCategories) == true) goto L24;
        return false;
    L24:
        if (o.a(this.attemptedTargets, r8.attemptedTargets) == true) goto L27;
        return false;
    L27:
        if (this.attemptedTargetsTruncated == r8.attemptedTargetsTruncated) goto L30;
        return false;
    L30:
        if (this.unreportedAttemptCount == r8.unreportedAttemptCount) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(this.protocolVersion) * 31) + Integer.hashCode(this.status)) * 31) + this.unapprovedCategories.hashCode()) * 31) + this.deniedCategories.hashCode()) * 31) + this.approvedCategories.hashCode()) * 31) + this.attemptedTargets.hashCode()) * 31) + Boolean.hashCode(this.attemptedTargetsTruncated)) * 31) + Long.hashCode(this.unreportedAttemptCount);
    }

    public String toString() {
        return "ActionEgressResultParcel(protocolVersion=" + this.protocolVersion + ", status=" + this.status + ", unapprovedCategories=" + this.unapprovedCategories + ", deniedCategories=" + this.deniedCategories + ", approvedCategories=" + this.approvedCategories + ", attemptedTargets=" + this.attemptedTargets + ", attemptedTargetsTruncated=" + this.attemptedTargetsTruncated + ", unreportedAttemptCount=" + this.unreportedAttemptCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        o.e(r5, "out");
        r5.writeInt(this.protocolVersion);
        r5.writeInt(this.status);
        List<SensitiveCategoryInfoParcel> r0 = this.unapprovedCategories;
        r5.writeInt(r0.size());
        Iterator<SensitiveCategoryInfoParcel> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((SensitiveCategoryInfoParcel) ZeusTransformUtils.preCheckCast(r1.next(), SensitiveCategoryInfoParcel.class, "com.obric.aiagent.plugin")).writeToParcel(r5, r6);
        goto L4
    L6:
        List<SensitiveCategoryInfoParcel> r2 = this.deniedCategories;
        r5.writeInt(r2.size());
        Iterator<SensitiveCategoryInfoParcel> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        ((SensitiveCategoryInfoParcel) ZeusTransformUtils.preCheckCast(r3.next(), SensitiveCategoryInfoParcel.class, "com.obric.aiagent.plugin")).writeToParcel(r5, r6);
        goto L8
    L10:
        List<SensitiveCategoryInfoParcel> r4 = this.approvedCategories;
        r5.writeInt(r4.size());
        Iterator<SensitiveCategoryInfoParcel> r7 = r4.iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        ((SensitiveCategoryInfoParcel) ZeusTransformUtils.preCheckCast(r7.next(), SensitiveCategoryInfoParcel.class, "com.obric.aiagent.plugin")).writeToParcel(r5, r6);
        goto L12
    L14:
        List<AttemptedOutboundTargetParcel> r8 = this.attemptedTargets;
        r5.writeInt(r8.size());
        Iterator<AttemptedOutboundTargetParcel> r9 = r8.iterator();
    L16:
        if (r9.hasNext() == false) goto L18;
        ((AttemptedOutboundTargetParcel) ZeusTransformUtils.preCheckCast(r9.next(), AttemptedOutboundTargetParcel.class, "com.obric.aiagent.plugin")).writeToParcel(r5, r6);
        goto L16
    L18:
        r5.writeInt(this.attemptedTargetsTruncated ? 1 : 0);
        r5.writeLong(this.unreportedAttemptCount);
    }

    public ActionEgressResultParcel(int r3, int r4, List<SensitiveCategoryInfoParcel> r5, List<SensitiveCategoryInfoParcel> r6, List<SensitiveCategoryInfoParcel> r7, List<AttemptedOutboundTargetParcel> r8, boolean r9, long r10) {
        List<SensitiveCategoryInfoParcel> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        List<SensitiveCategoryInfoParcel> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        List<SensitiveCategoryInfoParcel> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        List<AttemptedOutboundTargetParcel> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        o.e(r11, "unapprovedCategories");
        o.e(r12, "deniedCategories");
        o.e(r13, "approvedCategories");
        o.e(r14, "attemptedTargets");
        this.protocolVersion = r3;
        this.status = r4;
        this.unapprovedCategories = r11;
        this.deniedCategories = r12;
        this.approvedCategories = r13;
        this.attemptedTargets = r14;
        this.attemptedTargetsTruncated = r9;
        this.unreportedAttemptCount = r10;
    }

    public /* synthetic */ ActionEgressResultParcel(int r13, int r14, List r15, List r16, List r17, List r18, boolean r19, long r20, int r22, h r23) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        if ((r22 & 1) == 0) goto L5;
        int r3 = 3;
    L6:
        this(r3, r14, r5, r6, r7, r8, r19, r20);
        return;
    L5:
        r3 = r13;
        goto L6
    }

    public final int getProtocolVersion() {
        return this.protocolVersion;
    }

    public final int getStatus() {
        return this.status;
    }

    public final List<SensitiveCategoryInfoParcel> getUnapprovedCategories() {
        return this.unapprovedCategories;
    }

    public final List<SensitiveCategoryInfoParcel> getDeniedCategories() {
        return this.deniedCategories;
    }

    public final List<SensitiveCategoryInfoParcel> getApprovedCategories() {
        return this.approvedCategories;
    }

    public final List<AttemptedOutboundTargetParcel> getAttemptedTargets() {
        return this.attemptedTargets;
    }

    public final boolean getAttemptedTargetsTruncated() {
        return this.attemptedTargetsTruncated;
    }

    public final long getUnreportedAttemptCount() {
        return this.unreportedAttemptCount;
    }
}
