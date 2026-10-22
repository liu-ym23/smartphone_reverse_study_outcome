package com.obric.capabilitykit.entity.lark;

import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.GroupChatEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class LarkParticipants {
    private final List<ContactEntity> contacts;
    private final List<GroupChatEntity> groups;

    public LarkParticipants(List<ContactEntity> r3, List<GroupChatEntity> r4) {
        List<ContactEntity> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List<GroupChatEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        this.contacts = r5;
        this.groups = r6;
    }

    public static /* synthetic */ LarkParticipants copy$default(LarkParticipants r1, List r2, List r3, int r4, Object r5) {
        List<ContactEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        List<GroupChatEntity> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = r1.contacts;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r7 = r1.groups;
    L9:
        return r1.copy(r6, r7);
    }

    public final List<ContactEntity> component1() {
        return this.contacts;
    }

    public final List<GroupChatEntity> component2() {
        return this.groups;
    }

    public final LarkParticipants copy(List<ContactEntity> r2, List<GroupChatEntity> r3) {
        return new LarkParticipants((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, LarkParticipants.class) == true) goto L8;
        return false;
    L8:
        LarkParticipants r6 = (LarkParticipants) ZeusTransformUtils.preCheckCast(r5, LarkParticipants.class, "com.obric.aiagent.plugin");
        if (o.a(this.contacts, r6.contacts) == true) goto L12;
        return false;
    L12:
        if (o.a(this.groups, r6.groups) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final List<ContactEntity> getContacts() {
        return this.contacts;
    }

    public final List<GroupChatEntity> getGroups() {
        return this.groups;
    }

    public int hashCode() {
        List<ContactEntity> r0 = this.contacts;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<GroupChatEntity> r4 = this.groups;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "LarkParticipants(contacts=" + this.contacts + ", groups=" + this.groups + ')';
    }
}
