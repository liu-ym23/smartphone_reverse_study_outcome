package com.bytedance.ai.model.objects;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ai/model/objects/Icons;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "1x", "", "get1x", "()Ljava/lang/String;", "set1x", "(Ljava/lang/String;)V", "2x", "get2x", "set2x", "3x", "get3x", "set3x", "writeToParcel", "", "flags", "", "describeContents", "CREATOR", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Icons implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: 1x, reason: not valid java name */
    private String f541x;

    /* JADX INFO: renamed from: 2x, reason: not valid java name */
    private String f552x;

    /* JADX INFO: renamed from: 3x, reason: not valid java name */
    private String f563x;

    public static final class a implements Parcelable.Creator<Icons> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Icons createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new Icons(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final Icons[] newArray(int r100) {
            return new Icons[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Icons() {
        this.f541x = "";
        this.f552x = "";
        this.f563x = "";
    }

    public final String get1x() {
        return this.f541x;
    }

    public final String get2x() {
        return this.f552x;
    }

    public final String get3x() {
        return this.f563x;
    }

    public Icons(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        this.f541x = r100.readString();
        this.f552x = r100.readString();
        this.f563x = r100.readString();
    }

    public final void set1x(String r100) {
        this.f541x = r100;
    }

    public final void set2x(String r100) {
        this.f552x = r100;
    }

    public final void set3x(String r100) {
        this.f563x = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f541x);
        r100.writeString(this.f552x);
        r100.writeString(this.f563x);
    }
}
