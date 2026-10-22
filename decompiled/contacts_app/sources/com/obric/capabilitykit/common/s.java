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
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/ContactEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class s implements a0 {
    public static final s a = null;

    static {
        a = new s();
    }

    private s() {
    }

    @Override // com.obric.capabilitykit.common.a0
    public int a(AppEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        if ((r2 instanceof ContactEntity) == false) goto L54;
        ContactEntity r3 = (ContactEntity) r2;
        int r1 = r3.getName().hashCode() + 0;
        List<MetaTelephone> r0 = r3.getTelephones();
        if (r0 == null) goto L7;
        r1 = (r1 * 31) + r0.hashCode();
    L7:
        FileEntity r4 = r3.getAvatar();
        if (r4 == null) goto L10;
        r1 = (r1 * 31) + r4.hashCode();
    L10:
        String r5 = r3.getNote();
        if (r5 == null) goto L13;
        r1 = (r1 * 31) + r5.hashCode();
    L13:
        GenderEnum r6 = r3.getGender();
        if (r6 == null) goto L16;
        r1 = (r1 * 31) + r6.name().hashCode();
    L16:
        List<MetaCredentialNumber> r7 = r3.getCredentialNumbers();
        if (r7 == null) goto L19;
        r1 = (r1 * 31) + r7.hashCode();
    L19:
        List<MetaEmailAddress> r8 = r3.getEmails();
        if (r8 == null) goto L22;
        r1 = (r1 * 31) + r8.hashCode();
    L22:
        List<MetaAddress> r9 = r3.getAddresses();
        if (r9 == null) goto L25;
        r1 = (r1 * 31) + r9.hashCode();
    L25:
        String r10 = r3.getCompany();
        if (r10 == null) goto L28;
        r1 = (r1 * 31) + r10.hashCode();
    L28:
        List<MetaInstantMessaging> r11 = r3.getInstantMessagings();
        if (r11 == null) goto L31;
        r1 = (r1 * 31) + r11.hashCode();
    L31:
        List<MetaAnniversary> r12 = r3.getAnniversaries();
        if (r12 == null) goto L34;
        r1 = (r1 * 31) + r12.hashCode();
    L34:
        String r13 = r3.getVoip();
        if (r13 == null) goto L37;
        r1 = (r1 * 31) + r13.hashCode();
    L37:
        List<MetaRelationship> r14 = r3.getRelationShips();
        if (r14 == null) goto L40;
        r1 = (r1 * 31) + r14.hashCode();
    L40:
        String r15 = r3.getJobTitle();
        if (r15 == null) goto L43;
        r1 = (r1 * 31) + r15.hashCode();
    L43:
        String r16 = r3.getDepartment();
        if (r16 == null) goto L46;
        r1 = (r1 * 31) + r16.hashCode();
    L46:
        String r17 = r3.getSubNote();
        if (r17 == null) goto L49;
        r1 = (r1 * 31) + r17.hashCode();
    L49:
        List<String> r18 = r3.getWebsites();
        if (r18 != null) goto L52;
        return r1;
    L52:
        return (r1 * 31) + r18.hashCode();
    L54:
        throw new IllegalStateException("Check failed.".toString());
    }
}
