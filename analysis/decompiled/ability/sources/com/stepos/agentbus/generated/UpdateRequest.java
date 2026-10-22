package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentbus/generated/UpdateRequest;", "", "id", "", "blobRef", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getBlobRef", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UpdateRequest {
    private final String blobRef;
    private final String id;

    public UpdateRequest(String id, String blobRef) {
        k.f(id, "id");
        k.f(blobRef, "blobRef");
        this.id = id;
        this.blobRef = blobRef;
    }

    public static /* synthetic */ UpdateRequest copy$default(UpdateRequest updateRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = updateRequest.id;
        }
        if ((i & 2) != 0) {
            str2 = updateRequest.blobRef;
        }
        return updateRequest.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBlobRef() {
        return this.blobRef;
    }

    public final UpdateRequest copy(String id, String blobRef) {
        k.f(id, "id");
        k.f(blobRef, "blobRef");
        return new UpdateRequest(id, blobRef);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdateRequest)) {
            return false;
        }
        UpdateRequest updateRequest = (UpdateRequest) other;
        return k.b(this.id, updateRequest.id) && k.b(this.blobRef, updateRequest.blobRef);
    }

    public final String getBlobRef() {
        return this.blobRef;
    }

    public final String getId() {
        return this.id;
    }

    public int hashCode() {
        return this.blobRef.hashCode() + (this.id.hashCode() * 31);
    }

    public String toString() {
        return androidx.appfunctions.metadata.a.m("UpdateRequest(id=", this.id, ", blobRef=", this.blobRef, ")");
    }
}
