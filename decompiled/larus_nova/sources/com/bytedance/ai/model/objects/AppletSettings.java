package com.bytedance.ai.model.objects;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/model/objects/AppletSettings;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "urlCheck", "", "getUrlCheck", "()Ljava/lang/Boolean;", "setUrlCheck", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "writeToParcel", "", "flags", "", "describeContents", "CREATOR", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletSettings implements Parcelable {
    public static final a CREATOR = null;
    private Boolean urlCheck;

    public static final class a implements Parcelable.Creator<AppletSettings> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AppletSettings createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new AppletSettings(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final AppletSettings[] newArray(int r100) {
            return new AppletSettings[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public AppletSettings() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Boolean getUrlCheck() {
        return this.urlCheck;
    }

    public AppletSettings(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        int r101 = r100.readInt();
        if (r101 != 0) goto L5;
        Boolean r102 = Boolean.FALSE;
    L9:
        this.urlCheck = r102;
        return;
    L5:
        if (r101 == 1) goto L7;
        r102 = null;
        goto L9
    L7:
        r102 = Boolean.TRUE;
        goto L9
    }

    public final void setUrlCheck(Boolean r100) {
        this.urlCheck = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        Boolean r102 = this.urlCheck;
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L6;
        int r103 = 1;
    L10:
        r100.writeInt(r103);
        return;
    L6:
        if (Intrinsics.areEqual(r102, Boolean.FALSE) == false) goto L8;
        r103 = 0;
        goto L10
    L8:
        if (r102 != null) goto L13;
        r103 = -1;
        goto L10
    L13:
        throw new NoWhenBranchMatchedException();
    }
}
