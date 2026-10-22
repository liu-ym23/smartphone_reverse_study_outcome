package com.bytedance.ai.applet.granting;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/applet/granting/GrantStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "PENDING", "GRANTED", "DENIED", "REVOKED", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GrantStatus extends Enum<GrantStatus> {
    public static final a Companion = null;
    public static final GrantStatus DENIED = null;
    public static final GrantStatus GRANTED = null;
    public static final GrantStatus PENDING = null;
    public static final GrantStatus REVOKED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GrantStatus[] f34630a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f34631b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static GrantStatus a(Integer r100) {
            if (r100 != null) goto L5;
        L7:
            if (r100 != null) goto L10;
        L12:
            if (r100 != null) goto L15;
        L17:
            if (r100 == null) goto L23;
            if (r100.intValue() != 3) goto L23;
            return GrantStatus.REVOKED;
        L23:
            return GrantStatus.PENDING;
        L15:
            if (r100.intValue() != 2) goto L17;
            return GrantStatus.DENIED;
        L10:
            if (r100.intValue() != 1) goto L12;
            return GrantStatus.GRANTED;
        L5:
            if (r100.intValue() != 0) goto L7;
            return GrantStatus.PENDING;
        }
    }

    public static EnumEntries<GrantStatus> getEntries() {
        return f34631b;
    }

    static {
        GrantStatus r100 = new GrantStatus("PENDING", 0, 0);
        PENDING = r100;
        GrantStatus r101 = new GrantStatus("GRANTED", 1, 1);
        GRANTED = r101;
        GrantStatus r102 = new GrantStatus("DENIED", 2, 2);
        DENIED = r102;
        GrantStatus r103 = new GrantStatus("REVOKED", 3, 3);
        REVOKED = r103;
        GrantStatus[] r104 = {r100, r101, r102, r103};
        f34630a = r104;
        f34631b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static GrantStatus[] values() {
        return (GrantStatus[]) f34630a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static GrantStatus valueOf(String r100) {
        return (GrantStatus) r27.a.a(GrantStatus.class, r100);
    }

    public GrantStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
