package com.obric.capabilitykit;

import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\bHÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/obric/capabilitykit/entity/EntityHistoryDao;", "", "indexId", "", "id", "", "data", "type", "", CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "Lcom/obric/capabilitykit/entity/ActionType;", "(JLjava/lang/String;Ljava/lang/String;ILcom/obric/capabilitykit/entity/ActionType;)V", "getAction", "()Lcom/obric/capabilitykit/entity/ActionType;", "getData", "()Ljava/lang/String;", "getId", "getIndexId", "()J", "setIndexId", "(J)V", "getType", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class o {
    private long a;
    private final String b;
    private final String c;
    private final int d;
    private final m e;

    public o(long r2, String r4, String r5, int r6, m r7) {
        Intrinsics.checkNotNullParameter(r4, "id");
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r7, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
    }

    public /* synthetic */ o(long r8, String r10, String r11, int r12, m r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        r8 = -1;
    L5:
        this(r8, r10, r11, r12, r13);
    }

    public static /* synthetic */ o a(o r7, long r8, String r10, String r11, int r12, m r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L5;
        r8 = r7.a;
    L5:
        long r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r10 = r7.b;
    L8:
        String r3 = r10;
        if ((r14 & 4) == 0) goto L11;
        r11 = r7.c;
    L11:
        String r4 = r11;
        if ((r14 & 8) == 0) goto L14;
        r12 = r7.d;
    L14:
        int r5 = r12;
        if ((r14 & 16) == 0) goto L18;
        r13 = r7.e;
    L18:
        return r7.a(r1, r3, r4, r5, r13);
    }

    public final long a() {
        return this.a;
    }

    public final o a(long r8, String r10, String r11, int r12, m r13) {
        Intrinsics.checkNotNullParameter(r10, "id");
        Intrinsics.checkNotNullParameter(r11, "data");
        Intrinsics.checkNotNullParameter(r13, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        return new o(r8, r10, r11, r12, r13);
    }

    public final void a(long r1) {
        this.a = r1;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final m e() {
        return this.e;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof o) == true) goto L8;
        return false;
    L8:
        o r9 = (o) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final m f() {
        return this.e;
    }

    public final String g() {
        return this.c;
    }

    public final String h() {
        return this.b;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode();
    }

    public final long i() {
        return this.a;
    }

    public final int j() {
        return this.d;
    }

    public String toString() {
        return "EntityHistoryDao(indexId=" + this.a + ", id=" + this.b + ", data=" + this.c + ", type=" + this.d + ", action=" + this.e + ')';
    }
}
