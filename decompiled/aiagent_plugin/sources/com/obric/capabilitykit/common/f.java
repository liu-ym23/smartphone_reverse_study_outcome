package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.GroupChatEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.enums.MessageStatusTypeEnum;
import com.obric.capabilitykit.entity.enums.MessageTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f32054a = null;

    static {
        f32054a = new f();
    }

    private f() {
    }

    @Override // com.obric.capabilitykit.common.d
    public int a(AppEntity r2) {
        d.h.b.o.e(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, MessageEntity.class) == false) goto L21;
        MessageEntity r1 = (MessageEntity) ZeusTransformUtils.preCheckCast(r2, MessageEntity.class, "com.obric.aiagent.plugin");
        int r3 = ((r1.getTelephones().hashCode() + 0) * 31) + r1.getText().hashCode();
        List<ContactEntity> r0 = r1.getContacts();
        if (r0 == null) goto L7;
        r3 = (r3 * 31) + r0.hashCode();
    L7:
        MessageTypeEnum r4 = r1.getMessageType();
        if (r4 == null) goto L10;
        r3 = (r3 * 31) + r4.name().hashCode();
    L10:
        List<FileEntity> r5 = r1.getFiles();
        if (r5 == null) goto L13;
        r3 = (r3 * 31) + r5.hashCode();
    L13:
        MessageStatusTypeEnum r6 = r1.getMessageStatusType();
        if (r6 == null) goto L16;
        r3 = (r3 * 31) + r6.name().hashCode();
    L16:
        GroupChatEntity r7 = r1.getGroupChat();
        if (r7 != null) goto L19;
        return r3;
    L19:
        return (r3 * 31) + r7.hashCode();
    L21:
        throw new IllegalStateException("Check failed.".toString());
    }
}
