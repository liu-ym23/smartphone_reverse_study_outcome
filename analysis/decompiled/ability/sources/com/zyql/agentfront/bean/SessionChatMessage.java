package com.zyql.agentfront.bean;

import B7.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import k7.l;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001*B3\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0015J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0015J\u0010\u0010\u0018\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J<\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0015J\u0010\u0010\u001d\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0013J\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u0015R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b%\u0010\u0015R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b&\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010'\u001a\u0004\b(\u0010\u0019¨\u0006+"}, d2 = {"Lcom/zyql/agentfront/bean/SessionChatMessage;", "Landroid/os/Parcelable;", "", "id", "role", "content", "", "time", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "()J", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Lcom/zyql/agentfront/bean/SessionChatMessage;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getRole", "getContent", "J", "getTime", "CREATOR", "k7/l", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SessionChatMessage implements Parcelable {
    public static final l CREATOR = new l();
    private final String content;
    private final String id;
    private final String role;
    private final long time;

    public SessionChatMessage() {
        this(null, null, null, 0L, 15, null);
    }

    public static /* synthetic */ SessionChatMessage copy$default(SessionChatMessage sessionChatMessage, String str, String str2, String str3, long j5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sessionChatMessage.id;
        }
        if ((i & 2) != 0) {
            str2 = sessionChatMessage.role;
        }
        if ((i & 4) != 0) {
            str3 = sessionChatMessage.content;
        }
        if ((i & 8) != 0) {
            j5 = sessionChatMessage.time;
        }
        String str4 = str3;
        return sessionChatMessage.copy(str, str2, str4, j5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    /* renamed from: component3, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component4, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    public final SessionChatMessage copy(String id, String role, String content, long time) {
        k.f(id, "id");
        return new SessionChatMessage(id, role, content, time);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionChatMessage)) {
            return false;
        }
        SessionChatMessage sessionChatMessage = (SessionChatMessage) other;
        return k.b(this.id, sessionChatMessage.id) && k.b(this.role, sessionChatMessage.role) && k.b(this.content, sessionChatMessage.content) && this.time == sessionChatMessage.time;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getId() {
        return this.id;
    }

    public final String getRole() {
        return this.role;
    }

    public final long getTime() {
        return this.time;
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.role;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.content;
        return Long.hashCode(this.time) + ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public String toString() {
        String str = this.id;
        String str2 = this.role;
        String str3 = this.content;
        long j5 = this.time;
        StringBuilder sbW = a.w("SessionChatMessage(id=", str, ", role=", str2, ", content=");
        a.y(j5, str3, ", time=", sbW);
        sbW.append(")");
        return sbW.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.role);
        parcel.writeString(this.content);
        parcel.writeLong(this.time);
    }

    public SessionChatMessage(String id, String str, String str2, long j5) {
        k.f(id, "id");
        this.id = id;
        this.role = str;
        this.content = str2;
        this.time = j5;
    }

    public /* synthetic */ SessionChatMessage(String str, String str2, String str3, long j5, int i, e eVar) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? 0L : j5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SessionChatMessage(Parcel parcel) {
        k.f(parcel, "parcel");
        String string = parcel.readString();
        this(string == null ? "" : string, parcel.readString(), parcel.readString(), parcel.readLong());
    }
}
