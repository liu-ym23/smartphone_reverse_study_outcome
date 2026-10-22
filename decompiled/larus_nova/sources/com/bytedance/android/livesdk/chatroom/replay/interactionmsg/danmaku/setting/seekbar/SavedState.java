package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.setting.seekbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* JADX INFO: loaded from: classes7.dex */
public class SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f109210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f109211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f109212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f109213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f109214e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f109215f;

    public class a implements Parcelable.Creator<SavedState> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SavedState createFromParcel(Parcel r100) {
            return new SavedState(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SavedState[] newArray(int r100) {
            return new SavedState[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public SavedState(Parcel r100) {
        super(r100);
        this.f109210a = r100.readFloat();
        this.f109211b = r100.readFloat();
        this.f109212c = r100.readFloat();
        this.f109213d = r100.readInt();
        this.f109214e = r100.readFloat();
        this.f109215f = r100.readFloat();
    }

    public SavedState(Parcelable r100) {
        super(r100);
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeFloat(this.f109210a);
        r100.writeFloat(this.f109211b);
        r100.writeFloat(this.f109212c);
        r100.writeInt(this.f109213d);
        r100.writeFloat(this.f109214e);
        r100.writeFloat(this.f109215f);
    }
}
