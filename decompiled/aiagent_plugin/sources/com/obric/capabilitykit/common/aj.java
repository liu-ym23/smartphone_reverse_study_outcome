package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.GroupChatEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class aj implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final aj f32042a = null;

    static {
        f32042a = new aj();
    }

    private aj() {
    }

    @Override // com.obric.capabilitykit.common.d
    public int a(AppEntity r2) {
        d.h.b.o.e(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, GroupChatEntity.class) == false) goto L12;
        GroupChatEntity r1 = (GroupChatEntity) ZeusTransformUtils.preCheckCast(r2, GroupChatEntity.class, "com.obric.aiagent.plugin");
        int r3 = r1.getName().hashCode() + 0;
        List<ContactEntity> r0 = r1.getContacts();
        if (r0 == null) goto L7;
        r3 = (r3 * 31) + r0.hashCode();
    L7:
        FileEntity r4 = r1.getAvatar();
        if (r4 != null) goto L10;
        return r3;
    L10:
        return (r3 * 31) + r4.hashCode();
    L12:
        throw new IllegalStateException("Check failed.".toString());
    }
}
