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
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/ContactEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class t implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final t f11305a = null;

    static {
        f11305a = new t();
    }

    private t() {
    }

    @Override // com.obric.capabilitykit.common.b0
    public int a(@NotNull AppEntity r10) {
        kotlin.jvm.internal.q.g(r10, "instance");
        if ((r10 instanceof ContactEntity) == false) goto L54;
        ContactEntity r11 = (ContactEntity) r10;
        int r12 = r11.getName().hashCode();
        List<MetaTelephone> r13 = r11.getTelephones();
        if (r13 == null) goto L7;
        r12 = (r12 * 31) + r13.hashCode();
    L7:
        FileEntity r14 = r11.getAvatar();
        if (r14 == null) goto L10;
        r12 = (r12 * 31) + r14.hashCode();
    L10:
        String r15 = r11.getNote();
        if (r15 == null) goto L13;
        r12 = (r12 * 31) + r15.hashCode();
    L13:
        GenderEnum r16 = r11.getGender();
        if (r16 == null) goto L16;
        r12 = (r12 * 31) + r16.name().hashCode();
    L16:
        List<MetaCredentialNumber> r17 = r11.getCredentialNumbers();
        if (r17 == null) goto L19;
        r12 = (r12 * 31) + r17.hashCode();
    L19:
        List<MetaEmailAddress> r18 = r11.getEmails();
        if (r18 == null) goto L22;
        r12 = (r12 * 31) + r18.hashCode();
    L22:
        List<MetaAddress> r19 = r11.getAddresses();
        if (r19 == null) goto L25;
        r12 = (r12 * 31) + r19.hashCode();
    L25:
        String r20 = r11.getCompany();
        if (r20 == null) goto L28;
        r12 = (r12 * 31) + r20.hashCode();
    L28:
        List<MetaInstantMessaging> r21 = r11.getInstantMessagings();
        if (r21 == null) goto L31;
        r12 = (r12 * 31) + r21.hashCode();
    L31:
        List<MetaAnniversary> r22 = r11.getAnniversaries();
        if (r22 == null) goto L34;
        r12 = (r12 * 31) + r22.hashCode();
    L34:
        String r23 = r11.getVoip();
        if (r23 == null) goto L37;
        r12 = (r12 * 31) + r23.hashCode();
    L37:
        List<MetaRelationship> r24 = r11.getRelationShips();
        if (r24 == null) goto L40;
        r12 = (r12 * 31) + r24.hashCode();
    L40:
        String r25 = r11.getJobTitle();
        if (r25 == null) goto L43;
        r12 = (r12 * 31) + r25.hashCode();
    L43:
        String r26 = r11.getDepartment();
        if (r26 == null) goto L46;
        r12 = (r12 * 31) + r26.hashCode();
    L46:
        String r27 = r11.getSubNote();
        if (r27 == null) goto L49;
        r12 = (r12 * 31) + r27.hashCode();
    L49:
        List<String> r28 = r11.getWebsites();
        if (r28 != null) goto L52;
        return r12;
    L52:
        return (r12 * 31) + r28.hashCode();
    L54:
        throw new IllegalStateException("Check failed.");
    }
}
