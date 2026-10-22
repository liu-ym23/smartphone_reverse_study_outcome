package com.bytedance.safetyguard.lxc.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: ActionEgressModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActionEgressResult {
    private final List<SensitiveCategoryInfo> approvedCategories;
    private final List<AttemptedOutboundTarget> attemptedTargets;
    private final boolean attemptedTargetsTruncated;
    private final List<SensitiveCategoryInfo> deniedCategories;
    private final ActionEgressStatus status;
    private final List<SensitiveCategoryInfo> unapprovedCategories;
    private final long unreportedAttemptCount;

    public static /* synthetic */ ActionEgressResult copy$default(ActionEgressResult r9, ActionEgressStatus r10, List r11, List r12, List r13, List r14, boolean r15, long r16, int r18, Object r19) {
        List<SensitiveCategoryInfo> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        List<SensitiveCategoryInfo> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        List<SensitiveCategoryInfo> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        List<AttemptedOutboundTarget> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
        if ((r18 & 1) == 0) goto L5;
        ActionEgressStatus r5 = r9.status;
    L7:
        if ((r18 & 2) == 0) goto L10;
        r1 = r9.unapprovedCategories;
    L10:
        if ((r18 & 4) == 0) goto L13;
        r3 = r9.deniedCategories;
    L13:
        if ((r18 & 8) == 0) goto L16;
        r4 = r9.approvedCategories;
    L16:
        if ((r18 & 16) == 0) goto L19;
        r2 = r9.attemptedTargets;
    L19:
        if ((r18 & 32) == 0) goto L21;
        boolean r6 = r9.attemptedTargetsTruncated;
    L23:
        if ((r18 & 64) == 0) goto L25;
        long r7 = r9.unreportedAttemptCount;
    L27:
        return r9.copy(r5, r1, r3, r4, r2, r6, r7);
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L5:
        r5 = r10;
        goto L7
    }

    public final ActionEgressStatus component1() {
        return this.status;
    }

    public final List<SensitiveCategoryInfo> component2() {
        return this.unapprovedCategories;
    }

    public final List<SensitiveCategoryInfo> component3() {
        return this.deniedCategories;
    }

    public final List<SensitiveCategoryInfo> component4() {
        return this.approvedCategories;
    }

    public final List<AttemptedOutboundTarget> component5() {
        return this.attemptedTargets;
    }

    public final boolean component6() {
        return this.attemptedTargetsTruncated;
    }

    public final long component7() {
        return this.unreportedAttemptCount;
    }

    public final ActionEgressResult copy(ActionEgressStatus r12, List<SensitiveCategoryInfo> r13, List<SensitiveCategoryInfo> r14, List<SensitiveCategoryInfo> r15, List<AttemptedOutboundTarget> r16, boolean r17, long r18) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
        o.e(r12, "status");
        o.e(r4, "unapprovedCategories");
        o.e(r5, "deniedCategories");
        o.e(r6, "approvedCategories");
        o.e(r7, "attemptedTargets");
        return new ActionEgressResult(r12, r4, r5, r6, r7, r17, r18);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, ActionEgressResult.class) == true) goto L8;
        return false;
    L8:
        ActionEgressResult r8 = (ActionEgressResult) ZeusTransformUtils.preCheckCast(r7, ActionEgressResult.class, "com.obric.aiagent.plugin");
        if (this.status == r8.status) goto L12;
        return false;
    L12:
        if (o.a(this.unapprovedCategories, r8.unapprovedCategories) == true) goto L15;
        return false;
    L15:
        if (o.a(this.deniedCategories, r8.deniedCategories) == true) goto L18;
        return false;
    L18:
        if (o.a(this.approvedCategories, r8.approvedCategories) == true) goto L21;
        return false;
    L21:
        if (o.a(this.attemptedTargets, r8.attemptedTargets) == true) goto L24;
        return false;
    L24:
        if (this.attemptedTargetsTruncated == r8.attemptedTargetsTruncated) goto L27;
        return false;
    L27:
        if (this.unreportedAttemptCount == r8.unreportedAttemptCount) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        return (((((((((((this.status.hashCode() * 31) + this.unapprovedCategories.hashCode()) * 31) + this.deniedCategories.hashCode()) * 31) + this.approvedCategories.hashCode()) * 31) + this.attemptedTargets.hashCode()) * 31) + Boolean.hashCode(this.attemptedTargetsTruncated)) * 31) + Long.hashCode(this.unreportedAttemptCount);
    }

    public String toString() {
        return "ActionEgressResult(status=" + this.status + ", unapprovedCategories=" + this.unapprovedCategories + ", deniedCategories=" + this.deniedCategories + ", approvedCategories=" + this.approvedCategories + ", attemptedTargets=" + this.attemptedTargets + ", attemptedTargetsTruncated=" + this.attemptedTargetsTruncated + ", unreportedAttemptCount=" + this.unreportedAttemptCount + ')';
    }

    public ActionEgressResult(ActionEgressStatus r3, List<SensitiveCategoryInfo> r4, List<SensitiveCategoryInfo> r5, List<SensitiveCategoryInfo> r6, List<AttemptedOutboundTarget> r7, boolean r8, long r9) {
        List<SensitiveCategoryInfo> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List<SensitiveCategoryInfo> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        List<SensitiveCategoryInfo> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        List<AttemptedOutboundTarget> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "status");
        o.e(r10, "unapprovedCategories");
        o.e(r11, "deniedCategories");
        o.e(r12, "approvedCategories");
        o.e(r13, "attemptedTargets");
        this.status = r3;
        this.unapprovedCategories = r10;
        this.deniedCategories = r11;
        this.approvedCategories = r12;
        this.attemptedTargets = r13;
        this.attemptedTargetsTruncated = r8;
        this.unreportedAttemptCount = r9;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r16 = r14.iterator();
    L4:
        if (r16.hasNext() == false) goto L6;
        r15.add(((SensitiveCategoryInfo) ZeusTransformUtils.preCheckCast(r16.next(), SensitiveCategoryInfo.class, "com.obric.aiagent.plugin")).getSensitiveCategory());
        goto L4
    L6:
        LinkedHashSet r17 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(r15, LinkedHashSet.class, "com.obric.aiagent.plugin");
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(this.deniedCategories, Iterable.class, "com.obric.aiagent.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r20 = r18.iterator();
    L8:
        if (r20.hasNext() == false) goto L10;
        r19.add(((SensitiveCategoryInfo) ZeusTransformUtils.preCheckCast(r20.next(), SensitiveCategoryInfo.class, "com.obric.aiagent.plugin")).getSensitiveCategory());
        goto L8
    L10:
        LinkedHashSet r21 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(r19, LinkedHashSet.class, "com.obric.aiagent.plugin");
        Iterable r22 = (Iterable) ZeusTransformUtils.preCheckCast(this.approvedCategories, Iterable.class, "com.obric.aiagent.plugin");
        Collection r23 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r24 = r22.iterator();
    L12:
        if (r24.hasNext() == false) goto L14;
        r23.add(((SensitiveCategoryInfo) ZeusTransformUtils.preCheckCast(r24.next(), SensitiveCategoryInfo.class, "com.obric.aiagent.plugin")).getSensitiveCategory());
        goto L12
    L14:
        LinkedHashSet r25 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(r23, LinkedHashSet.class, "com.obric.aiagent.plugin");
        boolean r26 = true;
        if (r17.size() != this.unapprovedCategories.size()) goto L17;
        boolean r27 = true;
    L18:
        if (r27 == false) goto L78;
        if (r21.size() != this.deniedCategories.size()) goto L22;
        boolean r28 = true;
    L23:
        if (r28 == false) goto L76;
        if (r25.size() != this.approvedCategories.size()) goto L27;
        boolean r29 = true;
    L28:
        if (r29 == false) goto L74;
        if (p.a((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r21, Iterable.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L72;
        if (p.a((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L70;
        if (p.a((Iterable) ZeusTransformUtils.preCheckCast(r21, Iterable.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L68;
        if (this.status != ActionEgressStatus.Companion.fromCategories((Set) ZeusTransformUtils.preCheckCast(r17, Set.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.preCheckCast(r21, Set.class, "com.obric.aiagent.plugin"))) goto L38;
        boolean r30 = true;
    L39:
        if (r30 == false) goto L66;
        if (this.attemptedTargets.size() > 512) goto L43;
        boolean r31 = true;
    L44:
        if (r31 == false) goto L64;
        long r32 = this.unreportedAttemptCount;
        if (r32 < 0) goto L48;
        boolean r33 = true;
    L49:
        if (r33 == false) goto L62;
        boolean r2 = this.attemptedTargetsTruncated;
        if (r32 <= 0) goto L53;
        boolean r34 = true;
    L54:
        if (r2 == r34) goto L57;
        r26 = false;
    L57:
        if (r26 == false) goto L60;
        return;
    L60:
        throw new IllegalArgumentException("Attempt truncation metadata is inconsistent".toString());
    L53:
        r34 = false;
        goto L54
    L62:
        throw new IllegalArgumentException("Unreported attempt count must not be negative".toString());
    L48:
        r33 = false;
        goto L49
    L64:
        throw new IllegalArgumentException("Too many attempted targets".toString());
    L43:
        r31 = false;
        goto L44
    L66:
        throw new IllegalArgumentException("Sensitive status does not match category sets".toString());
    L38:
        r30 = false;
        goto L39
    L68:
        throw new IllegalArgumentException("Sensitive category sets overlap".toString());
    L70:
        throw new IllegalArgumentException("Sensitive category sets overlap".toString());
    L72:
        throw new IllegalArgumentException("Sensitive category sets overlap".toString());
    L74:
        throw new IllegalArgumentException("Duplicate approved category".toString());
    L27:
        r29 = false;
        goto L28
    L76:
        throw new IllegalArgumentException("Duplicate denied category".toString());
    L22:
        r28 = false;
        goto L23
    L78:
        throw new IllegalArgumentException("Duplicate unapproved category".toString());
    L17:
        r27 = false;
        goto L18
    }

    public /* synthetic */ ActionEgressResult(ActionEgressStatus r8, List r9, List r10, List r11, List r12, boolean r13, long r14, int r16, h r17) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        if ((r16 & 32) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r16 & 64) == 0) goto L9;
        long r5 = 0;
    L10:
        this(r8, r0, r2, r3, r1, r4, r5);
        return;
    L9:
        r5 = r14;
        goto L10
    L5:
        r4 = r13;
        goto L7
    }

    public final ActionEgressStatus getStatus() {
        return this.status;
    }

    public final List<SensitiveCategoryInfo> getUnapprovedCategories() {
        return this.unapprovedCategories;
    }

    public final List<SensitiveCategoryInfo> getDeniedCategories() {
        return this.deniedCategories;
    }

    public final List<SensitiveCategoryInfo> getApprovedCategories() {
        return this.approvedCategories;
    }

    public final List<AttemptedOutboundTarget> getAttemptedTargets() {
        return this.attemptedTargets;
    }

    public final boolean getAttemptedTargetsTruncated() {
        return this.attemptedTargetsTruncated;
    }

    public final long getUnreportedAttemptCount() {
        return this.unreportedAttemptCount;
    }

    public final boolean getHasBlockedEgress() {
        if (this.status != ActionEgressStatus.ALLOWED) goto L5;
    L9:
        return false;
    L5:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.attemptedTargets, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L7;
        return true;
    L7:
        if (this.unreportedAttemptCount <= 0) goto L9;
        return true;
    }

    public final boolean getCanClarify() {
        if (this.status != ActionEgressStatus.CLARIFICATION_REQUIRED) goto L5;
        return true;
    L5:
        return false;
    }
}
