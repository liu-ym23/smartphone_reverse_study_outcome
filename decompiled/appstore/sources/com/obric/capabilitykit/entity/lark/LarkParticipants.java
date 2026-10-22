package com.obric.capabilitykit.entity.lark;

import androidx.annotation.Keep;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.GroupChatEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/obric/capabilitykit/entity/lark/LarkParticipants;", "", "contacts", "", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "groups", "Lcom/obric/capabilitykit/entity/app/GroupChatEntity;", "(Ljava/util/List;Ljava/util/List;)V", "getContacts", "()Ljava/util/List;", "getGroups", "component1", "component2", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LarkParticipants {

    @Nullable
    private final List<ContactEntity> contacts;

    @Nullable
    private final List<GroupChatEntity> groups;

    public LarkParticipants(@Nullable List<ContactEntity> r10, @Nullable List<GroupChatEntity> r11) {
        this.contacts = r10;
        this.groups = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LarkParticipants copy$default(LarkParticipants r10, List r11, List r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.contacts;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.groups;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final List<ContactEntity> component1() {
        return this.contacts;
    }

    @Nullable
    public final List<GroupChatEntity> component2() {
        return this.groups;
    }

    @NotNull
    public final LarkParticipants copy(@Nullable List<ContactEntity> r10, @Nullable List<GroupChatEntity> r11) {
        return new LarkParticipants(r10, r11);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof LarkParticipants) == true) goto L8;
        return false;
    L8:
        LarkParticipants r11 = (LarkParticipants) r10;
        if (q.b(this.contacts, r11.contacts) == true) goto L12;
        return false;
    L12:
        if (q.b(this.groups, r11.groups) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final List<ContactEntity> getContacts() {
        return this.contacts;
    }

    @Nullable
    public final List<GroupChatEntity> getGroups() {
        return this.groups;
    }

    public int hashCode() {
        List<ContactEntity> r10 = this.contacts;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        List<GroupChatEntity> r14 = this.groups;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return r13 + r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @NotNull
    public String toString() {
        return "LarkParticipants(contacts=" + this.contacts + ", groups=" + this.groups + ')';
    }
}
