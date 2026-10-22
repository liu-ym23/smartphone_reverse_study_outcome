package io.ktor.sse;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.ktor.utils.io.InternalAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000e\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0013JR\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u000e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0013J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!R\u001c\u0010\u0003\u001a\u0004\u0018\u00018\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b%\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b&\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b(\u0010\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010$\u001a\u0004\b)\u0010\u0013¨\u0006*"}, d2 = {"Lio/ktor/sse/TypedServerSentEvent;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/sse/ServerSentEventMetadata;", "data", "", "event", "id", "", "retry", "comments", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "Lkotlin/Function1;", "serializer", "toString", "(Lp9/l;)Ljava/lang/String;", "component1", "()Ljava/lang/Object;", "component2", "()Ljava/lang/String;", "component3", "component4", "()Ljava/lang/Long;", "component5", ChatTracker.CLICK_COPY, "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lio/ktor/sse/TypedServerSentEvent;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getData", "Ljava/lang/String;", "getEvent", "getId", "Ljava/lang/Long;", "getRetry", "getComments", "ktor-sse"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TypedServerSentEvent<T> implements ServerSentEventMetadata<T> {
    private final String comments;
    private final T data;
    private final String event;
    private final String id;
    private final Long retry;

    public TypedServerSentEvent() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TypedServerSentEvent copy$default(TypedServerSentEvent typedServerSentEvent, Object obj, String str, String str2, Long l10, String str3, int i10, Object obj2) {
        T t10 = obj;
        if ((i10 & 1) != 0) {
            t10 = typedServerSentEvent.data;
        }
        if ((i10 & 2) != 0) {
            str = typedServerSentEvent.event;
        }
        if ((i10 & 4) != 0) {
            str2 = typedServerSentEvent.id;
        }
        if ((i10 & 8) != 0) {
            l10 = typedServerSentEvent.retry;
        }
        if ((i10 & 16) != 0) {
            str3 = typedServerSentEvent.comments;
        }
        String str4 = str3;
        String str5 = str2;
        return typedServerSentEvent.copy(t10, str, str5, l10, str4);
    }

    public final T component1() {
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

    public final TypedServerSentEvent<T> copy(T data, String event, String id, Long retry, String comments) {
        return new TypedServerSentEvent<>(data, event, id, retry, comments);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TypedServerSentEvent)) {
            return false;
        }
        TypedServerSentEvent typedServerSentEvent = (TypedServerSentEvent) other;
        return p.d(this.data, typedServerSentEvent.data) && p.d(this.event, typedServerSentEvent.event) && p.d(this.id, typedServerSentEvent.id) && p.d(this.retry, typedServerSentEvent.retry) && p.d(this.comments, typedServerSentEvent.comments);
    }

    @Override // io.ktor.sse.ServerSentEventMetadata
    public String getComments() {
        return this.comments;
    }

    @Override // io.ktor.sse.ServerSentEventMetadata
    public T getData() {
        return this.data;
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
        T t10 = this.data;
        int iHashCode = (t10 == null ? 0 : t10.hashCode()) * 31;
        String str = this.event;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.id;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l10 = this.retry;
        int iHashCode4 = (iHashCode3 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str3 = this.comments;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "TypedServerSentEvent(data=" + this.data + ", event=" + this.event + ", id=" + this.id + ", retry=" + this.retry + ", comments=" + this.comments + ')';
    }

    public TypedServerSentEvent(T t10, String str, String str2, Long l10, String str3) {
        this.data = t10;
        this.event = str;
        this.id = str2;
        this.retry = l10;
        this.comments = str3;
    }

    @InternalAPI
    public final String toString(InterfaceC5074l<? super T, String> serializer) {
        p.i(serializer, "serializer");
        T data = getData();
        return ServerSentEventKt.eventToString(data != null ? serializer.invoke(data) : null, getEvent(), getId(), getRetry(), getComments());
    }

    public /* synthetic */ TypedServerSentEvent(Object obj, String str, String str2, Long l10, String str3, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : obj, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : l10, (i10 & 16) != 0 ? null : str3);
    }
}
