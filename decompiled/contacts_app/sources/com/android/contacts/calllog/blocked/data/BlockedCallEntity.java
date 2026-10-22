package com.android.contacts.calllog.blocked.data;

import com.obric.utils.ICallData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlockedCallEntity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003JQ\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\b\u0010#\u001a\u00020\u0003H\u0016J\b\u0010$\u001a\u00020\u0003H\u0016J\b\u0010%\u001a\u00020\bH\u0016J\n\u0010&\u001a\u0004\u0018\u00010\u0005H\u0016J\t\u0010'\u001a\u00020\bHÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011¨\u0006)"}, d2 = {"Lcom/android/contacts/calllog/blocked/data/BlockedCallEntity;", "Lcom/obric/utils/ICallData;", "id", "", "number", "", "date", "interceptType", "", "type", "showSimIcon", "simId", "(JLjava/lang/String;JIIII)V", "getDate", "()J", "getId", "getInterceptType", "()I", "getNumber", "()Ljava/lang/String;", "getShowSimIcon", "getSimId", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "getCallDate", "getCallId", "getCallType", "getPhoneNumber", "hashCode", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BlockedCallEntity implements ICallData {
    private final long date;
    private final long id;
    private final int interceptType;
    private final String number;
    private final int showSimIcon;
    private final int simId;
    private final int type;

    public static /* synthetic */ BlockedCallEntity copy$default(BlockedCallEntity r10, long r11, String r13, long r14, int r16, int r17, int r18, int r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        long r1 = r10.id;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = r10.number;
    L11:
        if ((r20 & 4) == 0) goto L13;
        long r4 = r10.date;
    L15:
        if ((r20 & 8) == 0) goto L17;
        int r6 = r10.interceptType;
    L19:
        if ((r20 & 16) == 0) goto L21;
        int r7 = r10.type;
    L23:
        if ((r20 & 32) == 0) goto L25;
        int r8 = r10.showSimIcon;
    L27:
        if ((r20 & 64) == 0) goto L29;
        int r9 = r10.simId;
    L31:
        return r10.copy(r1, r3, r4, r6, r7, r8, r9);
    L29:
        r9 = r19;
        goto L31
    L25:
        r8 = r18;
        goto L27
    L21:
        r7 = r17;
        goto L23
    L17:
        r6 = r16;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.number;
    }

    public final long component3() {
        return this.date;
    }

    public final int component4() {
        return this.interceptType;
    }

    public final int component5() {
        return this.type;
    }

    public final int component6() {
        return this.showSimIcon;
    }

    public final int component7() {
        return this.simId;
    }

    public final BlockedCallEntity copy(long r12, String r14, long r15, int r17, int r18, int r19, int r20) {
        return new BlockedCallEntity(r12, r14, r15, r17, r18, r19, r20);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof BlockedCallEntity) == true) goto L8;
        return false;
    L8:
        BlockedCallEntity r9 = (BlockedCallEntity) r8;
        if (this.id == r9.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.number, r9.number) == true) goto L15;
        return false;
    L15:
        if (this.date == r9.date) goto L18;
        return false;
    L18:
        if (this.interceptType == r9.interceptType) goto L21;
        return false;
    L21:
        if (this.type == r9.type) goto L24;
        return false;
    L24:
        if (this.showSimIcon == r9.showSimIcon) goto L27;
        return false;
    L27:
        if (this.simId == r9.simId) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = Long.hashCode(this.id) * 31;
        String r1 = this.number;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((((((r0 + r2) * 31) + Long.hashCode(this.date)) * 31) + Integer.hashCode(this.interceptType)) * 31) + Integer.hashCode(this.type)) * 31) + Integer.hashCode(this.showSimIcon)) * 31) + Integer.hashCode(this.simId);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "BlockedCallEntity(id=" + this.id + ", number=" + this.number + ", date=" + this.date + ", interceptType=" + this.interceptType + ", type=" + this.type + ", showSimIcon=" + this.showSimIcon + ", simId=" + this.simId + ')';
    }

    public BlockedCallEntity(long r1, String r3, long r4, int r6, int r7, int r8, int r9) {
        this.id = r1;
        this.number = r3;
        this.date = r4;
        this.interceptType = r6;
        this.type = r7;
        this.showSimIcon = r8;
        this.simId = r9;
    }

    public final long getId() {
        return this.id;
    }

    public final String getNumber() {
        return this.number;
    }

    public final long getDate() {
        return this.date;
    }

    public final int getInterceptType() {
        return this.interceptType;
    }

    public final int getType() {
        return this.type;
    }

    public final int getShowSimIcon() {
        return this.showSimIcon;
    }

    public final int getSimId() {
        return this.simId;
    }

    @Override // com.obric.utils.ICallData
    public String getPhoneNumber() {
        return this.number;
    }

    @Override // com.obric.utils.ICallData
    public int getCallType() {
        return this.type;
    }

    @Override // com.obric.utils.ICallData
    public long getCallDate() {
        return this.date;
    }

    @Override // com.obric.utils.ICallData
    public long getCallId() {
        return this.id;
    }
}
