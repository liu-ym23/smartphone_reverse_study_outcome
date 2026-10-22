package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0015\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/h1;", "", "", "groupId", "", "variantIndex", "totalCount", "<init>", "(Ljava/lang/String;II)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "I", "c", Const.INTENT_KEY_PKGNAME, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.h1, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class VariantGroupTag {
    private final String groupId;
    private final int totalCount;
    private final int variantIndex;

    public VariantGroupTag(String groupId, int i10, int i11) {
        kotlin.jvm.internal.p.i(groupId, "groupId");
        this.groupId = groupId;
        this.variantIndex = i10;
        this.totalCount = i11;
    }

    /* renamed from: a, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: b, reason: from getter */
    public final int getTotalCount() {
        return this.totalCount;
    }

    /* renamed from: c, reason: from getter */
    public final int getVariantIndex() {
        return this.variantIndex;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VariantGroupTag)) {
            return false;
        }
        VariantGroupTag variantGroupTag = (VariantGroupTag) other;
        return kotlin.jvm.internal.p.d(this.groupId, variantGroupTag.groupId) && this.variantIndex == variantGroupTag.variantIndex && this.totalCount == variantGroupTag.totalCount;
    }

    public int hashCode() {
        return (((this.groupId.hashCode() * 31) + Integer.hashCode(this.variantIndex)) * 31) + Integer.hashCode(this.totalCount);
    }

    public String toString() {
        return "VariantGroupTag(groupId=" + this.groupId + ", variantIndex=" + this.variantIndex + ", totalCount=" + this.totalCount + ")";
    }
}
