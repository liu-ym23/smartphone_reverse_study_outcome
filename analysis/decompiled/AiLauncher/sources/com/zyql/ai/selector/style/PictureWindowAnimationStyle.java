package com.zyql.ai.selector.style;

import android.os.Parcel;
import android.os.Parcelable;
import com.zyql.ai.selector.R;

/* loaded from: classes4.dex */
public class PictureWindowAnimationStyle implements Parcelable {
    public static final Parcelable.Creator<PictureWindowAnimationStyle> CREATOR = new Parcelable.Creator<PictureWindowAnimationStyle>() { // from class: com.zyql.ai.selector.style.PictureWindowAnimationStyle.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PictureWindowAnimationStyle createFromParcel(Parcel parcel) {
            return new PictureWindowAnimationStyle(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PictureWindowAnimationStyle[] newArray(int i10) {
            return new PictureWindowAnimationStyle[i10];
        }
    };
    public int activityCropEnterAnimation;
    public int activityCropExitAnimation;
    public int activityEnterAnimation;
    public int activityExitAnimation;
    public int activityPreviewEnterAnimation;
    public int activityPreviewExitAnimation;

    public PictureWindowAnimationStyle() {
    }

    public static PictureWindowAnimationStyle ofCustomWindowAnimationStyle(int i10, int i11) {
        return new PictureWindowAnimationStyle(i10, i11);
    }

    public static PictureWindowAnimationStyle ofDefaultWindowAnimationStyle() {
        return new PictureWindowAnimationStyle(R.anim.picture_anim_enter, R.anim.picture_anim_exit);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void ofAllAnimation(int i10, int i11) {
        this.activityEnterAnimation = i10;
        this.activityExitAnimation = i11;
        this.activityPreviewEnterAnimation = i10;
        this.activityPreviewExitAnimation = i11;
        this.activityCropEnterAnimation = i10;
        this.activityCropExitAnimation = i11;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.activityEnterAnimation);
        parcel.writeInt(this.activityExitAnimation);
        parcel.writeInt(this.activityPreviewEnterAnimation);
        parcel.writeInt(this.activityPreviewExitAnimation);
        parcel.writeInt(this.activityCropEnterAnimation);
        parcel.writeInt(this.activityCropExitAnimation);
    }

    public PictureWindowAnimationStyle(int i10, int i11) {
        this.activityEnterAnimation = i10;
        this.activityExitAnimation = i11;
        this.activityPreviewEnterAnimation = i10;
        this.activityPreviewExitAnimation = i11;
        this.activityCropEnterAnimation = i10;
        this.activityCropExitAnimation = i11;
    }

    public PictureWindowAnimationStyle(int i10, int i11, int i12, int i13) {
        this.activityEnterAnimation = i10;
        this.activityExitAnimation = i11;
        this.activityPreviewEnterAnimation = i12;
        this.activityPreviewExitAnimation = i13;
    }

    public PictureWindowAnimationStyle(Parcel parcel) {
        this.activityEnterAnimation = parcel.readInt();
        this.activityExitAnimation = parcel.readInt();
        this.activityPreviewEnterAnimation = parcel.readInt();
        this.activityPreviewExitAnimation = parcel.readInt();
        this.activityCropEnterAnimation = parcel.readInt();
        this.activityCropExitAnimation = parcel.readInt();
    }
}
