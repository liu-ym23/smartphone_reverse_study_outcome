package android.support.v4.media;

import android.media.Rating;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = null;
    public static final int RATING_3_STARS = 3;
    public static final int RATING_4_STARS = 4;
    public static final int RATING_5_STARS = 5;
    public static final int RATING_HEART = 1;
    public static final int RATING_NONE = 0;
    private static final float RATING_NOT_RATED = -1.0f;
    public static final int RATING_PERCENTAGE = 6;
    public static final int RATING_THUMB_UP_DOWN = 2;
    private static final String TAG = "Rating";
    private Object mRatingObj;
    private final int mRatingStyle;
    private final float mRatingValue;

    @Retention(RetentionPolicy.SOURCE)
    public @interface StarStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Style {
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public float getPercentRating() {
        if (this.mRatingStyle == 6) goto L5;
        return -1.0f;
    L5:
        if (isRated() == true) goto L8;
        return -1.0f;
    L8:
        return this.mRatingValue;
    }

    public Object getRating() {
        if (this.mRatingObj != null) goto L16;
        if (isRated() == false) goto L14;
        int r100 = this.mRatingStyle;
        switch(r100) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L11;
            case 5: goto L11;
            case 6: goto L10;
            default: goto L8;
        };
    L8:
        return null;
    L10:
        this.mRatingObj = Rating.newPercentageRating(getPercentRating());
        goto L16
    L11:
        this.mRatingObj = Rating.newStarRating(r100, getStarRating());
        goto L16
    L12:
        this.mRatingObj = Rating.newThumbRating(isThumbUp());
        goto L16
    L13:
        this.mRatingObj = Rating.newHeartRating(hasHeart());
        goto L16
    L14:
        this.mRatingObj = Rating.newUnratedRating(this.mRatingStyle);
    L16:
        return this.mRatingObj;
    }

    public float getStarRating() {
        int r100 = this.mRatingStyle;
        if (r100 == 3) goto L10;
        if (r100 == 4) goto L10;
        if (r100 == 5) goto L10;
        return -1.0f;
    L10:
        if (isRated() == true) goto L12;
        return -1.0f;
    L12:
        return this.mRatingValue;
    }

    public boolean hasHeart() {
        if (this.mRatingStyle == 1) goto L6;
        return false;
    L6:
        if (this.mRatingValue != 1.0f) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isRated() {
        if (this.mRatingValue < 0.0f) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isThumbUp() {
        if (this.mRatingStyle == 2) goto L6;
        return false;
    L6:
        if (this.mRatingValue != 1.0f) goto L9;
        return true;
    L9:
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("Rating:style=");
        r100.append(this.mRatingStyle);
        r100.append(" rating=");
        float r101 = this.mRatingValue;
        if (r101 >= 0.0f) goto L5;
        String r102 = "unrated";
    L6:
        r100.append(r102);
        return r100.toString();
    L5:
        r102 = String.valueOf(r101);
        goto L6
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.mRatingStyle;
    }

    public int getRatingStyle() {
        return this.mRatingStyle;
    }

    public static RatingCompat fromRating(Object r100) {
        RatingCompat r101 = null;
        if (r100 == null) goto L14;
        Rating r102 = (Rating) r100;
        int r103 = r102.getRatingStyle();
        if (r102.isRated() == false) goto L12;
        switch(r103) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L7:
        return null;
    L8:
        r101 = newPercentageRating(r102.getPercentRating());
    L13:
        r101.mRatingObj = r100;
        goto L14
    L9:
        r101 = newStarRating(r103, r102.getStarRating());
        goto L13
    L10:
        r101 = newThumbRating(r102.isThumbUp());
        goto L13
    L11:
        r101 = newHeartRating(r102.hasHeart());
        goto L13
    L12:
        r101 = newUnratedRating(r103);
    L14:
        return r101;
    }

    public static RatingCompat newHeartRating(boolean r100) {
        if (r100 == false) goto L5;
        float r101 = 1.0f;
    L7:
        return new RatingCompat(1, r101);
    L5:
        r101 = 0.0f;
        goto L7
    }

    public static RatingCompat newPercentageRating(float r100) {
        if (r100 >= 0.0f) goto L5;
        return null;
    L5:
        if (r100 <= 100.0f) goto L8;
        return null;
    L8:
        return new RatingCompat(6, r100);
    }

    public static RatingCompat newThumbRating(boolean r100) {
        if (r100 == false) goto L5;
        float r101 = 1.0f;
    L7:
        return new RatingCompat(2, r101);
    L5:
        r101 = 0.0f;
        goto L7
    }

    public static RatingCompat newUnratedRating(int r100) {
        switch(r100) {
            case 1: goto L6;
            case 2: goto L6;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return new RatingCompat(r100, -1.0f);
    }

    public RatingCompat(int r100, float r101) {
        this.mRatingStyle = r100;
        this.mRatingValue = r101;
    }

    public static RatingCompat newStarRating(int r100, float r101) {
        if (r100 != 3) goto L5;
        float r102 = 3.0f;
    L14:
        if (r101 >= 0.0f) goto L16;
    L20:
        return null;
    L16:
        if (r101 > r102) goto L20;
        return new RatingCompat(r100, r101);
    L5:
        if (r100 != 4) goto L7;
        r102 = 4.0f;
        goto L14
    L7:
        if (r100 != 5) goto L9;
        r102 = 5.0f;
        goto L14
    L9:
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.mRatingStyle);
        r100.writeFloat(this.mRatingValue);
    }
}
