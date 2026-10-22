package com.obric.capabilitykit.common.execution.fileaccess;

import android.content.res.AssetFileDescriptor;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedanceos.common.model.AppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u001fB%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession;", "Landroid/os/Parcelable;", "status", "", "message", "", SlardarSettingsConsts.PERF_KEY_FD, "Landroid/content/res/AssetFileDescriptor;", "(ILjava/lang/String;Landroid/content/res/AssetFileDescriptor;)V", "getFd", "()Landroid/content/res/AssetFileDescriptor;", "getMessage", "()Ljava/lang/String;", "getStatus", "()I", "component1", "component2", "component3", "copy", "describeContents", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ErrorCode", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UriFileAccessSession implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<UriFileAccessSession> CREATOR = null;

    /* JADX INFO: renamed from: fd, reason: collision with root package name */
    @Nullable
    private final AssetFileDescriptor f11274fd;

    @NotNull
    private final String message;
    private final int status;

    @Keep
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession$ErrorCode;", "", "()V", "ERROR_ACCESSING_INPUT_STREAM", "", "ERROR_ACCESSING_SHARER", "ERROR_INVALID_SHARER", "ERROR_NOT_SHARED_BY_THIS_ENTITY", "ERROR_OPENING_INPUT_STREAM", "ERROR_OPENING_URI", "ERROR_REQUESTING_URI", "ERROR_TIMEOUT", "ERROR_UNKNOWN_ERROR", "NO_ERROR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ErrorCode {
        public static final int ERROR_ACCESSING_INPUT_STREAM = 6;
        public static final int ERROR_ACCESSING_SHARER = 8;
        public static final int ERROR_INVALID_SHARER = 3;
        public static final int ERROR_NOT_SHARED_BY_THIS_ENTITY = 2;
        public static final int ERROR_OPENING_INPUT_STREAM = 5;
        public static final int ERROR_OPENING_URI = 4;
        public static final int ERROR_REQUESTING_URI = 7;
        public static final int ERROR_TIMEOUT = 9;
        public static final int ERROR_UNKNOWN_ERROR = 1;

        @NotNull
        public static final ErrorCode INSTANCE = null;
        public static final int NO_ERROR = 0;

        static {
            INSTANCE = new ErrorCode();
        }

        private ErrorCode() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<UriFileAccessSession> {
        public a() {
        }

        @NotNull
        public final UriFileAccessSession a(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            return new UriFileAccessSession(r10.readInt(), r10.readString(), (AssetFileDescriptor) r10.readParcelable(UriFileAccessSession.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ UriFileAccessSession createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ UriFileAccessSession[] newArray(int r10) {
            return a(r10);
        }

        @NotNull
        public final UriFileAccessSession[] a(int r10) {
            return new UriFileAccessSession[r10];
        }
    }

    static {
        CREATOR = new a();
    }

    public UriFileAccessSession() {
        int r10 = 0;
        String r11 = null;
        AssetFileDescriptor r12 = null;
        this(r10, r11, r12, 7, null);
    }

    public static /* synthetic */ UriFileAccessSession copy$default(UriFileAccessSession r10, int r11, String r12, AssetFileDescriptor r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.status;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.message;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.f11274fd;
    L12:
        return r10.copy(r11, r12, r13);
    }

    public final int component1() {
        return this.status;
    }

    @NotNull
    public final String component2() {
        return this.message;
    }

    @Nullable
    public final AssetFileDescriptor component3() {
        return this.f11274fd;
    }

    @NotNull
    public final UriFileAccessSession copy(int r10, @NotNull String r11, @Nullable AssetFileDescriptor r12) {
        q.g(r11, "message");
        return new UriFileAccessSession(r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof UriFileAccessSession) == true) goto L8;
        return false;
    L8:
        UriFileAccessSession r11 = (UriFileAccessSession) r10;
        if (this.status == r11.status) goto L12;
        return false;
    L12:
        if (q.b(this.message, r11.message) == true) goto L15;
        return false;
    L15:
        if (q.b(this.f11274fd, r11.f11274fd) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Nullable
    public final AssetFileDescriptor getFd() {
        return this.f11274fd;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        int r10 = ((Integer.hashCode(this.status) * 31) + this.message.hashCode()) * 31;
        AssetFileDescriptor r11 = this.f11274fd;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return r10 + r12;
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    @NotNull
    public String toString() {
        return "UriFileAccessSession(status=" + this.status + ", message=" + this.message + ", fd=" + this.f11274fd + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "out");
        r10.writeInt(this.status);
        r10.writeString(this.message);
        r10.writeParcelable(this.f11274fd, r11);
    }

    public UriFileAccessSession(int r10, @NotNull String r11, @Nullable AssetFileDescriptor r12) {
        q.g(r11, "message");
        this.status = r10;
        this.message = r11;
        this.f11274fd = r12;
    }

    public /* synthetic */ UriFileAccessSession(int r10, String r11, AssetFileDescriptor r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = "";
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = null;
    L11:
        this(r10, r11, r12);
    }
}
