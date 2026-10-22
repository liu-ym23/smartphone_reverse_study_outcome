package xb;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b&\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0016R$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u000fR\"\u0010\u001f\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001c\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lxb/a;", "", "", "name", "", "cancelable", "<init>", "(Ljava/lang/String;Z)V", "", "f", "()J", "Lxb/c;", "queue", "LY8/t;", "e", "(Lxb/c;)V", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Z", "()Z", "c", "Lxb/c;", Const.INTENT_KEY_UMID, "()Lxb/c;", "setQueue$okhttp", "J", Const.INTENT_KEY_BACKGROUND_COMMAND, "(J)V", "nextExecuteNanoTime", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: xb.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5870a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean cancelable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public C5872c queue;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public long nextExecuteNanoTime;

    public AbstractC5870a(String name, boolean z10) {
        p.i(name, "name");
        this.name = name;
        this.cancelable = z10;
        this.nextExecuteNanoTime = -1L;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getCancelable() {
        return this.cancelable;
    }

    /* renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: c, reason: from getter */
    public final long getNextExecuteNanoTime() {
        return this.nextExecuteNanoTime;
    }

    /* renamed from: d, reason: from getter */
    public final C5872c getQueue() {
        return this.queue;
    }

    public final void e(C5872c queue) {
        p.i(queue, "queue");
        C5872c c5872c = this.queue;
        if (c5872c == queue) {
            return;
        }
        if (c5872c != null) {
            throw new IllegalStateException("task is in multiple queues");
        }
        this.queue = queue;
    }

    public abstract long f();

    public final void g(long j10) {
        this.nextExecuteNanoTime = j10;
    }

    public String toString() {
        return this.name;
    }

    public /* synthetic */ AbstractC5870a(String str, boolean z10, int i10, i iVar) {
        this(str, (i10 & 2) != 0 ? true : z10);
    }
}
