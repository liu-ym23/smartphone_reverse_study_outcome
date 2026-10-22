package com.bytedance.ai.model.objects;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR.\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ai/model/objects/MainInitData;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "app", "", "getApp", "()Z", "setApp", "(Z)V", "service", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getService", "()Ljava/util/ArrayList;", "setService", "(Ljava/util/ArrayList;)V", "writeToParcel", "", "flags", "", "describeContents", "CREATOR", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MainInitData implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: app, reason: collision with root package name */
    private boolean f36926app;
    private ArrayList<String> service;

    public static final class a implements Parcelable.Creator<MainInitData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MainInitData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new MainInitData(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final MainInitData[] newArray(int r100) {
            return new MainInitData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MainInitData() {
        this.service = new ArrayList();
    }

    public final boolean getApp() {
        return this.f36926app;
    }

    public final ArrayList<String> getService() {
        return this.service;
    }

    public MainInitData(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.f36926app = r101;
        this.service = r100.createStringArrayList();
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setApp(boolean r100) {
        this.f36926app = r100;
    }

    public final void setService(ArrayList<String> r100) {
        this.service = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeByte(this.f36926app ? 1 : 0);
        r100.writeStringList(this.service);
    }
}
