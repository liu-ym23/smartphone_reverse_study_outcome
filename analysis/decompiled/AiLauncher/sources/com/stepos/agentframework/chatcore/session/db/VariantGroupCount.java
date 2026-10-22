package com.stepos.agentframework.chatcore.session.db;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/I1;", "", "", "groupId", "", "count", "<init>", "(Ljava/lang/String;I)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "I", Const.INTENT_KEY_APIKEY, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.db.I1, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class VariantGroupCount {
    private final int count;
    private final String groupId;

    public VariantGroupCount(String groupId, int i10) {
        kotlin.jvm.internal.p.i(groupId, "groupId");
        this.groupId = groupId;
        this.count = i10;
    }

    /* renamed from: a, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* renamed from: b, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VariantGroupCount)) {
            return false;
        }
        VariantGroupCount variantGroupCount = (VariantGroupCount) other;
        return kotlin.jvm.internal.p.d(this.groupId, variantGroupCount.groupId) && this.count == variantGroupCount.count;
    }

    public int hashCode() {
        return (this.groupId.hashCode() * 31) + Integer.hashCode(this.count);
    }

    public String toString() {
        return "VariantGroupCount(groupId=" + this.groupId + ", count=" + this.count + ")";
    }
}
