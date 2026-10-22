package G7;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001bR&\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u001d0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0018¨\u0006 "}, d2 = {"LG7/b;", "", "<init>", "()V", "", "capacity", "LY8/t;", Const.INTENT_KEY_APIKEY, "(I)V", "", "c", "()Z", "LG7/b$a;", "record", "e", "(LG7/b$a;)V", "", Const.INTENT_KEY_UMID, "()J", Const.INTENT_KEY_PKGNAME, "Z", x5.d.EXTRA_ENABLED, "I", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "ringBuffer", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "nextId", "Lkotlin/Function1;", "f", "listeners", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static volatile boolean enabled;

    /* renamed from: a, reason: collision with root package name */
    public static final b f2814a = new b();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static volatile int capacity = 200;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final ConcurrentLinkedDeque<Record> ringBuffer = new ConcurrentLinkedDeque<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final AtomicInteger nextId = new AtomicInteger(1);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final ConcurrentLinkedDeque<InterfaceC5074l<Record, t>> listeners = new ConcurrentLinkedDeque<>();

    public static final void a(int capacity2) {
        if (1 > capacity2 || capacity2 >= 10001) {
            throw new IllegalArgumentException("capacity must be in 1..10000");
        }
        capacity = capacity2;
        enabled = true;
    }

    public static /* synthetic */ void b(int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 200;
        }
        a(i10);
    }

    public static final boolean c() {
        return enabled;
    }

    public final long d() {
        return nextId.getAndIncrement();
    }

    public final void e(Record record) {
        p.i(record, "record");
        if (enabled) {
            ringBuffer.addLast(record);
            while (true) {
                ConcurrentLinkedDeque<Record> concurrentLinkedDeque = ringBuffer;
                if (concurrentLinkedDeque.size() <= capacity) {
                    break;
                } else {
                    concurrentLinkedDeque.pollFirst();
                }
            }
            Iterator<T> it = listeners.iterator();
            while (it.hasNext()) {
                InterfaceC5074l interfaceC5074l = (InterfaceC5074l) it.next();
                try {
                    Result.Companion companion = Result.INSTANCE;
                    interfaceC5074l.invoke(record);
                    Result.b(t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.b(C4849c.a(th));
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b \u0010\u001e\u001a\u0004\b!\u0010\u0012R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b&\u0010\u001a\u001a\u0004\b'\u0010\u001cR\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b,\u0010)\u001a\u0004\b-\u0010+R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b.\u0010\u001e\u001a\u0004\b/\u0010\u0012R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b0\u0010\u001e\u001a\u0004\b1\u0010\u0012R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b2\u0010\u001a\u001a\u0004\b3\u0010\u001c¨\u00064"}, d2 = {"LG7/b$a;", "", "", "id", "", "method", "url", "", "statusCode", "durationMs", "requestSize", "responseSize", "error", DidiCardProvider.KEY_TRACE_ID, "timestamp", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;J)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "J", "getId", "()J", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "getMethod", "c", "getUrl", Const.INTENT_KEY_UMID, "Ljava/lang/Integer;", "getStatusCode", "()Ljava/lang/Integer;", "e", "getDurationMs", "f", "Ljava/lang/Long;", "getRequestSize", "()Ljava/lang/Long;", Const.INTENT_KEY_BACKGROUND_COMMAND, "getResponseSize", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "getError", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "getTraceId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "getTimestamp", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: G7.b$a, reason: from toString */
    public static final /* data */ class Record {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final long id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String method;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final String url;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final Integer statusCode;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final long durationMs;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        public final Long requestSize;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        public final Long responseSize;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        public final String error;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        public final String traceId;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
        public final long timestamp;

        public Record(long j10, String method, String url, Integer num, long j11, Long l10, Long l11, String str, String str2, long j12) {
            p.i(method, "method");
            p.i(url, "url");
            this.id = j10;
            this.method = method;
            this.url = url;
            this.statusCode = num;
            this.durationMs = j11;
            this.requestSize = l10;
            this.responseSize = l11;
            this.error = str;
            this.traceId = str2;
            this.timestamp = j12;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Record)) {
                return false;
            }
            Record record = (Record) other;
            return this.id == record.id && p.d(this.method, record.method) && p.d(this.url, record.url) && p.d(this.statusCode, record.statusCode) && this.durationMs == record.durationMs && p.d(this.requestSize, record.requestSize) && p.d(this.responseSize, record.responseSize) && p.d(this.error, record.error) && p.d(this.traceId, record.traceId) && this.timestamp == record.timestamp;
        }

        public int hashCode() {
            int iHashCode = ((((Long.hashCode(this.id) * 31) + this.method.hashCode()) * 31) + this.url.hashCode()) * 31;
            Integer num = this.statusCode;
            int iHashCode2 = (((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + Long.hashCode(this.durationMs)) * 31;
            Long l10 = this.requestSize;
            int iHashCode3 = (iHashCode2 + (l10 == null ? 0 : l10.hashCode())) * 31;
            Long l11 = this.responseSize;
            int iHashCode4 = (iHashCode3 + (l11 == null ? 0 : l11.hashCode())) * 31;
            String str = this.error;
            int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.traceId;
            return ((iHashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31) + Long.hashCode(this.timestamp);
        }

        public String toString() {
            return "Record(id=" + this.id + ", method=" + this.method + ", url=" + this.url + ", statusCode=" + this.statusCode + ", durationMs=" + this.durationMs + ", requestSize=" + this.requestSize + ", responseSize=" + this.responseSize + ", error=" + this.error + ", traceId=" + this.traceId + ", timestamp=" + this.timestamp + ")";
        }

        public /* synthetic */ Record(long j10, String str, String str2, Integer num, long j11, Long l10, Long l11, String str3, String str4, long j12, int i10, i iVar) {
            this(j10, str, str2, (i10 & 8) != 0 ? null : num, (i10 & 16) != 0 ? 0L : j11, (i10 & 32) != 0 ? null : l10, (i10 & 64) != 0 ? null : l11, (i10 & 128) != 0 ? null : str3, (i10 & 256) != 0 ? null : str4, (i10 & 512) != 0 ? System.currentTimeMillis() : j12);
        }
    }
}
