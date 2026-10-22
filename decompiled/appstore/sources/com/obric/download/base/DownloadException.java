package com.obric.download.base;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 \u00182\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001\u0019B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/obric/download/base/DownloadException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Landroid/os/Parcelable;", "", "errorMsg", "", "errorCode", "<init>", "(Ljava/lang/String;I)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Ljava/lang/String;", "getErrorMsg", "()Ljava/lang/String;", "I", "getErrorCode", "CREATOR", "a", "base_release"}, k = 1, mv = {1, 4, 3})
public final class DownloadException extends Exception implements Parcelable {

    @NotNull
    public static final a CREATOR = null;
    private final int errorCode;

    @NotNull
    private final String errorMsg;

    public static final class a implements Parcelable.Creator {
        public a() {
        }

        public DownloadException a(Parcel r10) {
            q.g(r10, "parcel");
            return new DownloadException(r10);
        }

        public DownloadException[] b(int r10) {
            return new DownloadException[r10];
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

    public DownloadException(@NotNull String r10, int r11) {
        q.g(r10, "errorMsg");
        super(r10);
        this.errorMsg = r10;
        this.errorCode = r11;
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

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        r10.writeString(this.errorMsg);
        r10.writeInt(this.errorCode);
    }

    public DownloadException(@NotNull Parcel r10) {
        q.g(r10, "parcel");
        String r11 = r10.readString();
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        q.f(r11, "parcel.readString() ?: \"\"");
        this(r11, r10.readInt());
    }
}
