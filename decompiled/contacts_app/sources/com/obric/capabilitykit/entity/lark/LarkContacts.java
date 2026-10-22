package com.obric.capabilitykit.entity.lark;

import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.contactsdk.loader.ContractKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/capabilitykit/entity/lark/LarkContacts;", "", ContractKt.PARAM_ACTION_DOMAIN_CONTACTS, "", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "(Ljava/util/List;)V", "getContacts", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LarkContacts {
    private final List<ContactEntity> contacts;

    public LarkContacts(List<ContactEntity> r1) {
        this.contacts = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LarkContacts copy$default(LarkContacts r0, List r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.contacts;
    L6:
        return r0.copy(r1);
    }

    public final List<ContactEntity> component1() {
        return this.contacts;
    }

    public final LarkContacts copy(List<ContactEntity> r1) {
        return new LarkContacts(r1);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof LarkContacts) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.contacts, ((LarkContacts) r4).contacts) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final List<ContactEntity> getContacts() {
        return this.contacts;
    }

    public int hashCode() {
        List<ContactEntity> r0 = this.contacts;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "LarkContacts(contacts=" + this.contacts + ')';
    }
}
