package io.ktor.sse;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\fJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\fJL\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001f\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b \u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b\"\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b#\u0010\f¨\u0006$"}, d2 = {"Lio/ktor/sse/ServerSentEvent;", "Lio/ktor/sse/ServerSentEventMetadata;", "", "data", "event", "id", "", "retry", "comments", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "()Ljava/lang/Long;", "component5", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lio/ktor/sse/ServerSentEvent;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "getData", "getEvent", "getId", "Ljava/lang/Long;", "getRetry", "getComments", "ktor-sse"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ServerSentEvent implements ServerSentEventMetadata<String> {
    private final String comments;
    private final String data;
    private final String event;
    private final String id;
    private final Long retry;

    public ServerSentEvent() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ServerSentEvent copy$default(ServerSentEvent serverSentEvent, String str, String str2, String str3, Long l10, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = serverSentEvent.data;
        }
        if ((i10 & 2) != 0) {
            str2 = serverSentEvent.event;
        }
        if ((i10 & 4) != 0) {
            str3 = serverSentEvent.id;
        }
        if ((i10 & 8) != 0) {
            l10 = serverSentEvent.retry;
        }
        if ((i10 & 16) != 0) {
            str4 = serverSentEvent.comments;
        }
        String str5 = str4;
        String str6 = str3;
        return serverSentEvent.copy(str, str2, str6, l10, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getData() {
        return this.data;
    }

    /* renamed from: component2, reason: from getter */
    public final String getEvent() {
        return this.event;
    }

    /* renamed from: component3, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getRetry() {
        return this.retry;
    }

    /* renamed from: component5, reason: from getter */
    public final String getComments() {
        return this.comments;
    }

    public final ServerSentEvent copy(String data, String event, String id, Long retry, String comments) {
        return new ServerSentEvent(data, event, id, retry, comments);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerSentEvent)) {
            return false;
        }
        ServerSentEvent serverSentEvent = (ServerSentEvent) other;
        return p.d(this.data, serverSentEvent.data) && p.d(this.event, serverSentEvent.event) && p.d(this.id, serverSentEvent.id) && p.d(this.retry, serverSentEvent.retry) && p.d(this.comments, serverSentEvent.comments);
    }

    @Override // io.ktor.sse.ServerSentEventMetadata
    public String getComments() {
        return this.comments;
    }

    @Override // io.ktor.sse.ServerSentEventMetadata
    public String getEvent() {
        return this.event;
    }

    @Override // io.ktor.sse.ServerSentEventMetadata
    public String getId() {
        return this.id;
    }

    @Override // io.ktor.sse.ServerSentEventMetadata
    public Long getRetry() {
        return this.retry;
    }

    public int hashCode() {
        String str = this.data;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.event;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.id;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l10 = this.retry;
        int iHashCode4 = (iHashCode3 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str4 = this.comments;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return ServerSentEventKt.eventToString(getData(), getEvent(), getId(), getRetry(), getComments());
    }

    public ServerSentEvent(String str, String str2, String str3, Long l10, String str4) {
        this.data = str;
        this.event = str2;
        this.id = str3;
        this.retry = l10;
        this.comments = str4;
    }

    @Override // io.ktor.sse.ServerSentEventMetadata
    public String getData() {
        return this.data;
    }

    public /* synthetic */ ServerSentEvent(String str, String str2, String str3, Long l10, String str4, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : l10, (i10 & 16) != 0 ? null : str4);
    }
}
