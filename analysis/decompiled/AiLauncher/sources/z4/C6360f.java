package z4;

import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0016\rB\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R0\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u0011j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0012`\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lz4/f;", "", "", "capacity", "", "intervalMs", "<init>", "(IJ)V", "", "key", "signature", "nowMs", "Lz4/f$b;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;J)Lz4/f$b;", "I", "J", "Ljava/util/LinkedHashMap;", "Lz4/f$a;", "Lkotlin/collections/LinkedHashMap;", "entries", "Ljava/util/LinkedHashMap;", Const.INTENT_KEY_PKGNAME, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: z4.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6360f {
    private final int capacity;
    private final LinkedHashMap<String, Entry> entries;
    private final long intervalMs;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u001fR\"\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u001c\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\u001f¨\u0006\""}, d2 = {"Lz4/f$a;", "", "", "signature", "", "time", "", "count", "suppressed", "<init>", "(Ljava/lang/String;JII)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "f", "(Ljava/lang/String;)V", "J", Const.INTENT_KEY_UMID, "()J", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(J)V", "I", Const.INTENT_KEY_APIKEY, "e", "(I)V", "c", Const.INTENT_KEY_BACKGROUND_COMMAND, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: z4.f$a, reason: from toString */
    public static final /* data */ class Entry {
        private int count;
        private String signature;
        private int suppressed;
        private long time;

        public Entry(String signature, long j10, int i10, int i11) {
            p.i(signature, "signature");
            this.signature = signature;
            this.time = j10;
            this.count = i10;
            this.suppressed = i11;
        }

        /* renamed from: a, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        /* renamed from: b, reason: from getter */
        public final String getSignature() {
            return this.signature;
        }

        /* renamed from: c, reason: from getter */
        public final int getSuppressed() {
            return this.suppressed;
        }

        /* renamed from: d, reason: from getter */
        public final long getTime() {
            return this.time;
        }

        public final void e(int i10) {
            this.count = i10;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) other;
            return p.d(this.signature, entry.signature) && this.time == entry.time && this.count == entry.count && this.suppressed == entry.suppressed;
        }

        public final void f(String str) {
            p.i(str, "<set-?>");
            this.signature = str;
        }

        public final void g(int i10) {
            this.suppressed = i10;
        }

        public final void h(long j10) {
            this.time = j10;
        }

        public int hashCode() {
            return (((((this.signature.hashCode() * 31) + Long.hashCode(this.time)) * 31) + Integer.hashCode(this.count)) * 31) + Integer.hashCode(this.suppressed);
        }

        public String toString() {
            return "Entry(signature=" + this.signature + ", time=" + this.time + ", count=" + this.count + ", suppressed=" + this.suppressed + ")";
        }

        public /* synthetic */ Entry(String str, long j10, int i10, int i11, int i12, kotlin.jvm.internal.i iVar) {
            this(str, j10, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0013"}, d2 = {"Lz4/f$b;", "", "", "count", "suppressed", "<init>", "(II)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: z4.f$b, reason: from toString */
    public static final /* data */ class Sample {
        private final int count;
        private final int suppressed;

        public Sample(int i10, int i11) {
            this.count = i10;
            this.suppressed = i11;
        }

        /* renamed from: a, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        /* renamed from: b, reason: from getter */
        public final int getSuppressed() {
            return this.suppressed;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Sample)) {
                return false;
            }
            Sample sample = (Sample) other;
            return this.count == sample.count && this.suppressed == sample.suppressed;
        }

        public int hashCode() {
            return (Integer.hashCode(this.count) * 31) + Integer.hashCode(this.suppressed);
        }

        public String toString() {
            return "Sample(count=" + this.count + ", suppressed=" + this.suppressed + ")";
        }
    }

    public C6360f(int i10, long j10) {
        this.capacity = i10;
        this.intervalMs = j10;
        this.entries = new LinkedHashMap<>(i10, 0.75f, true);
    }

    public final Sample a(String key, String signature, long nowMs) {
        String str;
        long j10;
        Entry entry;
        p.i(key, "key");
        p.i(signature, "signature");
        Entry entry2 = this.entries.get(key);
        if (entry2 == null) {
            str = signature;
            j10 = nowMs;
            entry = new Entry(str, j10, 0, 0, 12, null);
            this.entries.put(key, entry);
            if (this.entries.size() > this.capacity) {
                LinkedHashMap<String, Entry> linkedHashMap = this.entries;
                Set<String> setKeySet = linkedHashMap.keySet();
                p.h(setKeySet, "<get-keys>(...)");
                linkedHashMap.remove(F.p0(setKeySet));
            }
        } else {
            str = signature;
            j10 = nowMs;
            entry = entry2;
        }
        entry.e(entry.getCount() + 1);
        if (entry2 != null && p.d(str, entry.getSignature())) {
            long j11 = this.intervalMs;
            long time = j10 - entry.getTime();
            if (0 <= time && time < j11) {
                entry.g(entry.getSuppressed() + 1);
                return null;
            }
        }
        Sample sample = new Sample(entry.getCount(), entry.getSuppressed());
        entry.f(str);
        entry.h(j10);
        entry.g(0);
        return sample;
    }

    public /* synthetic */ C6360f(int i10, long j10, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? 128 : i10, (i11 & 2) != 0 ? 2000L : j10);
    }
}
