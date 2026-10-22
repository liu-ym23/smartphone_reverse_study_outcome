package com.obric.download.base;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/obric/download/base/TaskOperateResult;", "Landroid/os/Parcelable;", "", "id", "errorCode", "", "errorMsg", "<init>", "(IILjava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "I", "getId", "getErrorCode", "Ljava/lang/String;", "getErrorMsg", "CREATOR", "a", "base_release"}, k = 1, mv = {1, 4, 3})
public final class TaskOperateResult implements Parcelable {

    @NotNull
    public static final a CREATOR = null;
    private final int errorCode;

    @NotNull
    private final String errorMsg;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f11862id;

    public static final class a implements Parcelable.Creator {
        public a() {
        }

        public TaskOperateResult a(Parcel r10) {
            q.g(r10, "parcel");
            return new TaskOperateResult(r10);
        }

        public TaskOperateResult[] b(int r10) {
            return new TaskOperateResult[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
            return b(r10);
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        CREATOR = new a(null);
    }

    public TaskOperateResult(int r10, int r11, @NotNull String r12) {
        q.g(r12, "errorMsg");
        this.f11862id = r10;
        this.errorCode = r11;
        this.errorMsg = r12;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    @NotNull
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final int getId() {
        return this.f11862id;
    }

    @NotNull
    public String toString() {
        return "TaskOperateResult(id=" + this.f11862id + ", errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + "')";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        r10.writeInt(this.f11862id);
        r10.writeInt(this.errorCode);
        r10.writeString(this.errorMsg);
    }

    public /* synthetic */ TaskOperateResult(int r10, int r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = "";
    L8:
        this(r10, r11, r12);
    }

    public TaskOperateResult(@NotNull Parcel r10) {
        q.g(r10, "parcel");
        int r11 = r10.readInt();
        int r12 = r10.readInt();
        String r13 = r10.readString();
        if (r13 != null) goto L5;
        r13 = "";
    L5:
        q.f(r13, "parcel.readString() ?: \"\"");
        this(r11, r12, r13);
    }
}
