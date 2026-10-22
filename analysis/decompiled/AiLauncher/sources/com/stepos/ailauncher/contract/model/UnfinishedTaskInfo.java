package com.stepos.ailauncher.contract.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\nJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0012J0\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0012J\u0010\u0010\u0018\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0018\u0010\nJ\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\nR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\"\u0010\u0012¨\u0006#"}, d2 = {"Lcom/stepos/ailauncher/contract/model/UnfinishedTaskInfo;", "Landroid/os/Parcelable;", "", "taskId", "", "status", "requestedSessionKey", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Ljava/lang/String;", "component2", "component3", ChatTracker.CLICK_COPY, "(Ljava/lang/String;ILjava/lang/String;)Lcom/stepos/ailauncher/contract/model/UnfinishedTaskInfo;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTaskId", "I", "getStatus", "getRequestedSessionKey", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UnfinishedTaskInfo implements Parcelable {
    public static final Parcelable.Creator<UnfinishedTaskInfo> CREATOR = new Creator();
    private final String requestedSessionKey;
    private final int status;
    private final String taskId;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UnfinishedTaskInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UnfinishedTaskInfo createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new UnfinishedTaskInfo(parcel.readString(), parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UnfinishedTaskInfo[] newArray(int i10) {
            return new UnfinishedTaskInfo[i10];
        }
    }

    public UnfinishedTaskInfo(String taskId, int i10, String str) {
        p.i(taskId, "taskId");
        this.taskId = taskId;
        this.status = i10;
        this.requestedSessionKey = str;
    }

    public static /* synthetic */ UnfinishedTaskInfo copy$default(UnfinishedTaskInfo unfinishedTaskInfo, String str, int i10, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = unfinishedTaskInfo.taskId;
        }
        if ((i11 & 2) != 0) {
            i10 = unfinishedTaskInfo.status;
        }
        if ((i11 & 4) != 0) {
            str2 = unfinishedTaskInfo.requestedSessionKey;
        }
        return unfinishedTaskInfo.copy(str, i10, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: component3, reason: from getter */
    public final String getRequestedSessionKey() {
        return this.requestedSessionKey;
    }

    public final UnfinishedTaskInfo copy(String taskId, int status, String requestedSessionKey) {
        p.i(taskId, "taskId");
        return new UnfinishedTaskInfo(taskId, status, requestedSessionKey);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnfinishedTaskInfo)) {
            return false;
        }
        UnfinishedTaskInfo unfinishedTaskInfo = (UnfinishedTaskInfo) other;
        return p.d(this.taskId, unfinishedTaskInfo.taskId) && this.status == unfinishedTaskInfo.status && p.d(this.requestedSessionKey, unfinishedTaskInfo.requestedSessionKey);
    }

    public final String getRequestedSessionKey() {
        return this.requestedSessionKey;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public int hashCode() {
        int iHashCode = ((this.taskId.hashCode() * 31) + Integer.hashCode(this.status)) * 31;
        String str = this.requestedSessionKey;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "UnfinishedTaskInfo(taskId=" + this.taskId + ", status=" + this.status + ", requestedSessionKey=" + this.requestedSessionKey + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeString(this.taskId);
        dest.writeInt(this.status);
        dest.writeString(this.requestedSessionKey);
    }
}
