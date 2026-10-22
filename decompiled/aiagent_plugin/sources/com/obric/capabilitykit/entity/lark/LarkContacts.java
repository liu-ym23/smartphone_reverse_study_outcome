package com.obric.capabilitykit.entity.lark;

import com.obric.capabilitykit.entity.app.ContactEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class LarkContacts {
    private final List<ContactEntity> contacts;

    public LarkContacts(List<ContactEntity> r3) {
        this.contacts = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ LarkContacts copy$default(LarkContacts r1, List r2, int r3, Object r4) {
        List<ContactEntity> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = r1.contacts;
    L6:
        return r1.copy(r5);
    }

    public final List<ContactEntity> component1() {
        return this.contacts;
    }

    public final LarkContacts copy(List<ContactEntity> r2) {
        return new LarkContacts((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, LarkContacts.class) == true) goto L8;
        return false;
    L8:
        LarkContacts r6 = (LarkContacts) ZeusTransformUtils.preCheckCast(r5, LarkContacts.class, "com.obric.aiagent.plugin");
        if (o.a(this.contacts, r6.contacts) == true) goto L11;
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
