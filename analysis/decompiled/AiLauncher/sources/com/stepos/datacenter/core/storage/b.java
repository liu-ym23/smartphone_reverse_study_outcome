package com.stepos.datacenter.core.storage;

import Z8.r;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.datacenter.core.storage.b;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\t\n\u000b\u0006B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\u0082\u0001\u0004\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/datacenter/core/storage/b;", "", "", "message", "<init>", "(Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "()Ljava/lang/String;", "c", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "Lcom/stepos/datacenter/core/storage/b$a;", "Lcom/stepos/datacenter/core/storage/b$b;", "Lcom/stepos/datacenter/core/storage/b$c;", "Lcom/stepos/datacenter/core/storage/b$d;", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String message;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/stepos/datacenter/core/storage/b$a;", "Lcom/stepos/datacenter/core/storage/b;", "", "stored", "computed", "<init>", "(JJ)V", Const.INTENT_KEY_PKGNAME, "J", "getStored", "()J", "c", "getComputed", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends b {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final long stored;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final long computed;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(long j10, long j11) {
            String str = String.format("header CRC mismatch: stored=0x%08x computed=0x%08x", Arrays.copyOf(new Object[]{Long.valueOf(j10), Long.valueOf(j11)}, 2));
            p.h(str, "format(...)");
            super(str, null);
            this.stored = j10;
            this.computed = j11;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/stepos/datacenter/core/storage/b$b;", "Lcom/stepos/datacenter/core/storage/b;", "Lcom/stepos/datacenter/core/storage/FileMagic;", "expected", "actual", "<init>", "(Lcom/stepos/datacenter/core/storage/FileMagic;Lcom/stepos/datacenter/core/storage/FileMagic;)V", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/datacenter/core/storage/FileMagic;", "getExpected", "()Lcom/stepos/datacenter/core/storage/FileMagic;", "c", "getActual", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.datacenter.core.storage.b$b, reason: collision with other inner class name */
    public static final class C0356b extends b {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final FileMagic expected;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final FileMagic actual;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0356b(FileMagic expected, FileMagic actual) {
            super("magic mismatch: expected=" + expected + " actual=" + actual, null);
            p.i(expected, "expected");
            p.i(actual, "actual");
            this.expected = expected;
            this.actual = actual;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/stepos/datacenter/core/storage/b$c;", "Lcom/stepos/datacenter/core/storage/b;", "", "available", "required", "<init>", "(II)V", Const.INTENT_KEY_PKGNAME, "I", "getAvailable", "()I", "c", "getRequired", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends b {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final int available;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final int required;

        public c(int i10, int i11) {
            super("file too short: " + i10 + " < required " + i11, null);
            this.available = i10;
            this.required = i11;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/datacenter/core/storage/b$d;", "Lcom/stepos/datacenter/core/storage/b;", "", "actual", "<init>", "([B)V", Const.INTENT_KEY_PKGNAME, "[B", "getActual", "()[B", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends b {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final byte[] actual;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(byte[] actual) {
            super("unknown magic: " + r.v0(actual, " ", null, null, 0, null, new InterfaceC5074l() { // from class: Y6.c
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return b.d.c(((Byte) obj).byteValue());
                }
            }, 30, null), null);
            p.i(actual, "actual");
            this.actual = actual;
        }

        public static final CharSequence c(byte b10) {
            String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
            p.h(str, "format(...)");
            return str;
        }
    }

    public /* synthetic */ b(String str, i iVar) {
        this(str);
    }

    /* renamed from: a, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public b(String str) {
        this.message = str;
    }
}
