package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.GroupChatEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.enums.MessageStatusTypeEnum;
import com.obric.capabilitykit.entity.enums.MessageTypeEnum;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/MessageEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class d0 implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d0 f11272a = null;

    static {
        f11272a = new d0();
    }

    private d0() {
    }

    @Override // com.obric.capabilitykit.common.b0
    public int a(@NotNull AppEntity r10) {
        kotlin.jvm.internal.q.g(r10, "instance");
        if ((r10 instanceof MessageEntity) == false) goto L21;
        MessageEntity r11 = (MessageEntity) r10;
        int r12 = (r11.getTelephones().hashCode() * 31) + r11.getText().hashCode();
        List<ContactEntity> r13 = r11.getContacts();
        if (r13 == null) goto L7;
        r12 = (r12 * 31) + r13.hashCode();
    L7:
        MessageTypeEnum r14 = r11.getMessageType();
        if (r14 == null) goto L10;
        r12 = (r12 * 31) + r14.name().hashCode();
    L10:
        List<FileEntity> r15 = r11.getFiles();
        if (r15 == null) goto L13;
        r12 = (r12 * 31) + r15.hashCode();
    L13:
        MessageStatusTypeEnum r16 = r11.getMessageStatusType();
        if (r16 == null) goto L16;
        r12 = (r12 * 31) + r16.name().hashCode();
    L16:
        GroupChatEntity r17 = r11.getGroupChat();
        if (r17 != null) goto L19;
        return r12;
    L19:
        return (r12 * 31) + r17.hashCode();
    L21:
        throw new IllegalStateException("Check failed.");
    }
}
