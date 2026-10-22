package com.stepos.ability.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\fJ\u0010\u0010\u0014\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J8\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0015J\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\fJ\u001a\u0010\u001f\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b$\u0010\u0015R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b%\u0010\u0015R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010&\u001a\u0004\b'\u0010\u0018¨\u0006("}, d2 = {"Lcom/stepos/ability/bean/TaskError;", "Landroid/os/Parcelable;", "", "code", "", "codeString", "errorMessage", "", "retryAble", "<init>", "(ILjava/lang/String;Ljava/lang/String;Z)V", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "component2", "()Ljava/lang/String;", "component3", "component4", "()Z", ChatTracker.CLICK_COPY, "(ILjava/lang/String;Ljava/lang/String;Z)Lcom/stepos/ability/bean/TaskError;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getCode", "Ljava/lang/String;", "getCodeString", "getErrorMessage", "Z", "getRetryAble", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class TaskError implements Parcelable {
    public static final Parcelable.Creator<TaskError> CREATOR = new a();
    private final int code;
    private final String codeString;
    private final String errorMessage;
    private final boolean retryAble;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<TaskError> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TaskError createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new TaskError(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final TaskError[] newArray(int i10) {
            return new TaskError[i10];
        }
    }

    public TaskError(int i10, String codeString, String errorMessage, boolean z10) {
        p.i(codeString, "codeString");
        p.i(errorMessage, "errorMessage");
        this.code = i10;
        this.codeString = codeString;
        this.errorMessage = errorMessage;
        this.retryAble = z10;
    }

    public static /* synthetic */ TaskError copy$default(TaskError taskError, int i10, String str, String str2, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = taskError.code;
        }
        if ((i11 & 2) != 0) {
            str = taskError.codeString;
        }
        if ((i11 & 4) != 0) {
            str2 = taskError.errorMessage;
        }
        if ((i11 & 8) != 0) {
            z10 = taskError.retryAble;
        }
        return taskError.copy(i10, str, str2, z10);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCodeString() {
        return this.codeString;
    }

    /* renamed from: component3, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getRetryAble() {
        return this.retryAble;
    }

    public final TaskError copy(int code, String codeString, String errorMessage, boolean retryAble) {
        p.i(codeString, "codeString");
        p.i(errorMessage, "errorMessage");
        return new TaskError(code, codeString, errorMessage, retryAble);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskError)) {
            return false;
        }
        TaskError taskError = (TaskError) other;
        return this.code == taskError.code && p.d(this.codeString, taskError.codeString) && p.d(this.errorMessage, taskError.errorMessage) && this.retryAble == taskError.retryAble;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getCodeString() {
        return this.codeString;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final boolean getRetryAble() {
        return this.retryAble;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.code) * 31) + this.codeString.hashCode()) * 31) + this.errorMessage.hashCode()) * 31) + Boolean.hashCode(this.retryAble);
    }

    public String toString() {
        return "TaskError(code=" + this.code + ", codeString=" + this.codeString + ", errorMessage=" + this.errorMessage + ", retryAble=" + this.retryAble + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeInt(this.code);
        dest.writeString(this.codeString);
        dest.writeString(this.errorMessage);
        dest.writeInt(this.retryAble ? 1 : 0);
    }

    public /* synthetic */ TaskError(int i10, String str, String str2, boolean z10, int i11, i iVar) {
        this((i11 & 1) != 0 ? 0 : i10, str, str2, (i11 & 8) != 0 ? true : z10);
    }
}
