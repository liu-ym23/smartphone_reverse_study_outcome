package com.stepos.zeroclaw.ipc;

import a1.a;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import q7.f;
import q7.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0011J\u0010\u0010\u0015\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/stepos/zeroclaw/ipc/Reply;", "Landroid/os/Parcelable;", "", "frameJson", "<init>", "(Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "Lc7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "copy", "(Ljava/lang/String;)Lcom/stepos/zeroclaw/ipc/Reply;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFrameJson", "CREATOR", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class Reply implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String frameJson;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/zeroclaw/ipc/Reply$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/stepos/zeroclaw/ipc/Reply;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/stepos/zeroclaw/ipc/Reply;", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.zeroclaw.ipc.Reply$CREATOR, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<Reply> {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Reply createFromParcel(Parcel parcel) {
            k.e(parcel, "parcel");
            return new Reply(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Reply[] newArray(int size) {
            return new Reply[size];
        }
    }

    public Reply(String str) {
        k.e(str, "frameJson");
        this.frameJson = str;
    }

    public static /* synthetic */ Reply copy$default(Reply reply, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = reply.frameJson;
        }
        return reply.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFrameJson() {
        return this.frameJson;
    }

    public final Reply copy(String frameJson) {
        k.e(frameJson, "frameJson");
        return new Reply(frameJson);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Reply) && k.a(this.frameJson, ((Reply) other).frameJson);
    }

    public final String getFrameJson() {
        return this.frameJson;
    }

    public int hashCode() {
        return this.frameJson.hashCode();
    }

    public String toString() {
        return a.j("Reply(frameJson=", this.frameJson, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.e(parcel, "parcel");
        parcel.writeString(this.frameJson);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Reply(Parcel parcel) {
        k.e(parcel, "parcel");
        String string = parcel.readString();
        this(string == null ? "" : string);
    }
}
