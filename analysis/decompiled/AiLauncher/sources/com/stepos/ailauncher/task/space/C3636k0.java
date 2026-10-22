package com.stepos.ailauncher.task.space;

import com.autonavi.aps.amapapi.config.Const;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00140\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/task/space/k0;", "", "<init>", "()V", "", "uid", "Lcom/stepos/ailauncher/task/space/k0$a;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lcom/stepos/ailauncher/task/space/k0$a;", "ticket", "currentUid", "Lkotlin/Function0;", "LY8/t;", "write", "", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/task/space/k0$a;Ljava/lang/String;Lp9/a;)Z", "clear", "c", "(Ljava/lang/String;Lp9/a;)V", "", "version", "J", "", "latest", "Ljava/util/Map;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.space.k0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3636k0 {
    private final Map<String, Long> latest = new LinkedHashMap();
    private long version;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/task/space/k0$a;", "", "", "uid", "", "version", "<init>", "(Ljava/lang/String;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "J", Const.INTENT_KEY_PKGNAME, "()J", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.space.k0$a, reason: from toString */
    public static final /* data */ class Ticket {
        private final String uid;
        private final long version;

        public Ticket(String uid, long j10) {
            kotlin.jvm.internal.p.i(uid, "uid");
            this.uid = uid;
            this.version = j10;
        }

        /* renamed from: a, reason: from getter */
        public final String getUid() {
            return this.uid;
        }

        /* renamed from: b, reason: from getter */
        public final long getVersion() {
            return this.version;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Ticket)) {
                return false;
            }
            Ticket ticket = (Ticket) other;
            return kotlin.jvm.internal.p.d(this.uid, ticket.uid) && this.version == ticket.version;
        }

        public int hashCode() {
            return (this.uid.hashCode() * 31) + Long.hashCode(this.version);
        }

        public String toString() {
            return "Ticket(uid=" + this.uid + ", version=" + this.version + ")";
        }
    }

    public final synchronized Ticket a(String uid) {
        Ticket ticket;
        kotlin.jvm.internal.p.i(uid, "uid");
        long j10 = this.version + 1;
        this.version = j10;
        ticket = new Ticket(uid, j10);
        this.latest.put(uid, Long.valueOf(ticket.getVersion()));
        return ticket;
    }

    public final synchronized boolean b(Ticket ticket, String currentUid, InterfaceC5063a<Y8.t> write) {
        kotlin.jvm.internal.p.i(ticket, "ticket");
        kotlin.jvm.internal.p.i(write, "write");
        if (kotlin.jvm.internal.p.d(ticket.getUid(), currentUid)) {
            Long l10 = this.latest.get(ticket.getUid());
            long version = ticket.getVersion();
            if (l10 != null && l10.longValue() == version) {
                write.invoke();
                return true;
            }
        }
        return false;
    }

    public final synchronized void c(String uid, InterfaceC5063a<Y8.t> clear) {
        kotlin.jvm.internal.p.i(uid, "uid");
        kotlin.jvm.internal.p.i(clear, "clear");
        Map<String, Long> map = this.latest;
        long j10 = this.version + 1;
        this.version = j10;
        map.put(uid, Long.valueOf(j10));
        clear.invoke();
    }
}
