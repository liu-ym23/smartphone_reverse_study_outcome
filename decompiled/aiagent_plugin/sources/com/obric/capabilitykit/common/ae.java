package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.enums.GenderEnum;
import com.obric.capabilitykit.entity.meta.MetaAddress;
import com.obric.capabilitykit.entity.meta.MetaAnniversary;
import com.obric.capabilitykit.entity.meta.MetaCredentialNumber;
import com.obric.capabilitykit.entity.meta.MetaEmailAddress;
import com.obric.capabilitykit.entity.meta.MetaInstantMessaging;
import com.obric.capabilitykit.entity.meta.MetaRelationship;
import com.obric.capabilitykit.entity.meta.MetaTelephone;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ae implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ae f32036a = null;

    static {
        f32036a = new ae();
    }

    private ae() {
    }

    @Override // com.obric.capabilitykit.common.d
    public int a(AppEntity r2) {
        d.h.b.o.e(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, ContactEntity.class) == false) goto L54;
        ContactEntity r1 = (ContactEntity) ZeusTransformUtils.preCheckCast(r2, ContactEntity.class, "com.obric.aiagent.plugin");
        int r3 = r1.getName().hashCode() + 0;
        List<MetaTelephone> r0 = r1.getTelephones();
        if (r0 == null) goto L7;
        r3 = (r3 * 31) + r0.hashCode();
    L7:
        FileEntity r4 = r1.getAvatar();
        if (r4 == null) goto L10;
        r3 = (r3 * 31) + r4.hashCode();
    L10:
        String r5 = r1.getNote();
        if (r5 == null) goto L13;
        r3 = (r3 * 31) + r5.hashCode();
    L13:
        GenderEnum r6 = r1.getGender();
        if (r6 == null) goto L16;
        r3 = (r3 * 31) + r6.name().hashCode();
    L16:
        List<MetaCredentialNumber> r7 = r1.getCredentialNumbers();
        if (r7 == null) goto L19;
        r3 = (r3 * 31) + r7.hashCode();
    L19:
        List<MetaEmailAddress> r8 = r1.getEmails();
        if (r8 == null) goto L22;
        r3 = (r3 * 31) + r8.hashCode();
    L22:
        List<MetaAddress> r9 = r1.getAddresses();
        if (r9 == null) goto L25;
        r3 = (r3 * 31) + r9.hashCode();
    L25:
        String r10 = r1.getCompany();
        if (r10 == null) goto L28;
        r3 = (r3 * 31) + r10.hashCode();
    L28:
        List<MetaInstantMessaging> r11 = r1.getInstantMessagings();
        if (r11 == null) goto L31;
        r3 = (r3 * 31) + r11.hashCode();
    L31:
        List<MetaAnniversary> r12 = r1.getAnniversaries();
        if (r12 == null) goto L34;
        r3 = (r3 * 31) + r12.hashCode();
    L34:
        String r13 = r1.getVoip();
        if (r13 == null) goto L37;
        r3 = (r3 * 31) + r13.hashCode();
    L37:
        List<MetaRelationship> r14 = r1.getRelationShips();
        if (r14 == null) goto L40;
        r3 = (r3 * 31) + r14.hashCode();
    L40:
        String r15 = r1.getJobTitle();
        if (r15 == null) goto L43;
        r3 = (r3 * 31) + r15.hashCode();
    L43:
        String r16 = r1.getDepartment();
        if (r16 == null) goto L46;
        r3 = (r3 * 31) + r16.hashCode();
    L46:
        String r17 = r1.getSubNote();
        if (r17 == null) goto L49;
        r3 = (r3 * 31) + r17.hashCode();
    L49:
        List<String> r18 = r1.getWebsites();
        if (r18 != null) goto L52;
        return r3;
    L52:
        return (r3 * 31) + r18.hashCode();
    L54:
        throw new IllegalStateException("Check failed.".toString());
    }
}
