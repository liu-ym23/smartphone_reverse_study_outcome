package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR = null;
    static final ArrayMap METADATA_KEYS_TYPE = null;
    public static final String METADATA_KEY_ADVERTISEMENT = "android.media.metadata.ADVERTISEMENT";
    public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
    public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
    public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
    public static final String METADATA_KEY_ART = "android.media.metadata.ART";
    public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
    public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
    public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
    public static final String METADATA_KEY_BT_FOLDER_TYPE = "android.media.metadata.BT_FOLDER_TYPE";
    public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
    public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
    public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
    public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
    public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
    public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
    public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
    public static final String METADATA_KEY_DOWNLOAD_STATUS = "android.media.metadata.DOWNLOAD_STATUS";
    public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
    public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
    public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
    public static final String METADATA_KEY_MEDIA_URI = "android.media.metadata.MEDIA_URI";
    public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
    public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
    public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
    public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
    public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
    public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
    public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
    static final int METADATA_TYPE_BITMAP = 2;
    static final int METADATA_TYPE_LONG = 0;
    static final int METADATA_TYPE_RATING = 3;
    static final int METADATA_TYPE_TEXT = 1;
    private static final String[] PREFERRED_BITMAP_ORDER = null;
    private static final String[] PREFERRED_DESCRIPTION_ORDER = null;
    private static final String[] PREFERRED_URI_ORDER = null;
    private static final String TAG = "MediaMetadata";
    final Bundle mBundle;
    private MediaDescriptionCompat mDescription;
    private Object mMetadataObj;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface BitmapKey {
    }

    public static final class Builder {
        private final Bundle mBundle;

        public Builder() {
            this.mBundle = new Bundle();
        }

        private Bitmap scaleBitmap(Bitmap r10, int r11) {
            float r12 = r11;
            float r13 = Math.min(r12 / r10.getWidth(), r12 / r10.getHeight());
            return Bitmap.createScaledBitmap(r10, (int) (r10.getWidth() * r13), (int) (r10.getHeight() * r13), true);
        }

        public MediaMetadataCompat build() {
            return new MediaMetadataCompat(this.mBundle);
        }

        public Builder putBitmap(String r10, Bitmap r11) {
            ArrayMap r12 = MediaMetadataCompat.METADATA_KEYS_TYPE;
            if (r12.containsKey(r10) == true) goto L5;
        L9:
            this.mBundle.putParcelable(r10, r11);
            return this;
        L5:
            if (((Integer) r12.get(r10)).intValue() == 2) goto L9;
            throw new IllegalArgumentException("The " + r10 + " key cannot be used to put a Bitmap");
        }

        public Builder putLong(String r10, long r11) {
            ArrayMap r12 = MediaMetadataCompat.METADATA_KEYS_TYPE;
            if (r12.containsKey(r10) == true) goto L5;
        L9:
            this.mBundle.putLong(r10, r11);
            return this;
        L5:
            if (((Integer) r12.get(r10)).intValue() == 0) goto L9;
            throw new IllegalArgumentException("The " + r10 + " key cannot be used to put a long");
        }

        public Builder putRating(String r10, RatingCompat r11) {
            ArrayMap r12 = MediaMetadataCompat.METADATA_KEYS_TYPE;
            if (r12.containsKey(r10) == true) goto L5;
        L9:
            this.mBundle.putParcelable(r10, (Parcelable) r11.getRating());
            return this;
        L5:
            if (((Integer) r12.get(r10)).intValue() == 3) goto L9;
            throw new IllegalArgumentException("The " + r10 + " key cannot be used to put a Rating");
        }

        public Builder putString(String r10, String r11) {
            ArrayMap r12 = MediaMetadataCompat.METADATA_KEYS_TYPE;
            if (r12.containsKey(r10) == true) goto L5;
        L9:
            this.mBundle.putCharSequence(r10, r11);
            return this;
        L5:
            if (((Integer) r12.get(r10)).intValue() == 1) goto L9;
            throw new IllegalArgumentException("The " + r10 + " key cannot be used to put a String");
        }

        public Builder putText(String r10, CharSequence r11) {
            ArrayMap r12 = MediaMetadataCompat.METADATA_KEYS_TYPE;
            if (r12.containsKey(r10) == true) goto L5;
        L9:
            this.mBundle.putCharSequence(r10, r11);
            return this;
        L5:
            if (((Integer) r12.get(r10)).intValue() == 1) goto L9;
            throw new IllegalArgumentException("The " + r10 + " key cannot be used to put a CharSequence");
        }

        public Builder(MediaMetadataCompat r10) {
            Bundle r11 = new Bundle(r10.mBundle);
            this.mBundle = r11;
            MediaSessionCompat.ensureClassLoader(r11);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder(MediaMetadataCompat r10, int r11) {
            this(r10);
            Iterator<String> r12 = this.mBundle.keySet().iterator();
        L4:
            if (r12.hasNext() == false) goto L12;
            String r13 = r12.next();
            Object r14 = this.mBundle.get(r13);
            if ((r14 instanceof Bitmap) == false) goto L4;
            Bitmap r15 = (Bitmap) r14;
            if (r15.getHeight() > r11) goto L11;
            if (r15.getWidth() <= r11) goto L4;
        L11:
            putBitmap(r13, scaleBitmap(r15, r11));
            goto L4
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface LongKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface RatingKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TextKey {
    }

    static {
        ArrayMap r10 = new ArrayMap();
        METADATA_KEYS_TYPE = r10;
        r10.put(METADATA_KEY_TITLE, 1);
        r10.put(METADATA_KEY_ARTIST, 1);
        r10.put(METADATA_KEY_DURATION, 0);
        r10.put(METADATA_KEY_ALBUM, 1);
        r10.put(METADATA_KEY_AUTHOR, 1);
        r10.put(METADATA_KEY_WRITER, 1);
        r10.put(METADATA_KEY_COMPOSER, 1);
        r10.put(METADATA_KEY_COMPILATION, 1);
        r10.put(METADATA_KEY_DATE, 1);
        r10.put(METADATA_KEY_YEAR, 0);
        r10.put(METADATA_KEY_GENRE, 1);
        r10.put(METADATA_KEY_TRACK_NUMBER, 0);
        r10.put(METADATA_KEY_NUM_TRACKS, 0);
        r10.put(METADATA_KEY_DISC_NUMBER, 0);
        r10.put(METADATA_KEY_ALBUM_ARTIST, 1);
        r10.put(METADATA_KEY_ART, 2);
        r10.put(METADATA_KEY_ART_URI, 1);
        r10.put(METADATA_KEY_ALBUM_ART, 2);
        r10.put(METADATA_KEY_ALBUM_ART_URI, 1);
        r10.put(METADATA_KEY_USER_RATING, 3);
        r10.put(METADATA_KEY_RATING, 3);
        r10.put(METADATA_KEY_DISPLAY_TITLE, 1);
        r10.put(METADATA_KEY_DISPLAY_SUBTITLE, 1);
        r10.put(METADATA_KEY_DISPLAY_DESCRIPTION, 1);
        r10.put(METADATA_KEY_DISPLAY_ICON, 2);
        r10.put(METADATA_KEY_DISPLAY_ICON_URI, 1);
        r10.put(METADATA_KEY_MEDIA_ID, 1);
        r10.put(METADATA_KEY_BT_FOLDER_TYPE, 0);
        r10.put(METADATA_KEY_MEDIA_URI, 1);
        r10.put(METADATA_KEY_ADVERTISEMENT, 0);
        r10.put(METADATA_KEY_DOWNLOAD_STATUS, 0);
        PREFERRED_DESCRIPTION_ORDER = new String[]{METADATA_KEY_TITLE, METADATA_KEY_ARTIST, METADATA_KEY_ALBUM, METADATA_KEY_ALBUM_ARTIST, METADATA_KEY_WRITER, METADATA_KEY_AUTHOR, METADATA_KEY_COMPOSER};
        PREFERRED_BITMAP_ORDER = new String[]{METADATA_KEY_DISPLAY_ICON, METADATA_KEY_ART, METADATA_KEY_ALBUM_ART};
        PREFERRED_URI_ORDER = new String[]{METADATA_KEY_DISPLAY_ICON_URI, METADATA_KEY_ART_URI, METADATA_KEY_ALBUM_ART_URI};
        CREATOR = new AnonymousClass1();
    }

    public MediaMetadataCompat(Bundle r10) {
        Bundle r11 = new Bundle(r10);
        this.mBundle = r11;
        MediaSessionCompat.ensureClassLoader(r11);
    }

    public static MediaMetadataCompat fromMediaMetadata(Object r10) {
        if (r10 == null) goto L5;
        Parcel r11 = Parcel.obtain();
        MediaMetadataCompatApi21.writeToParcel(r10, r11, 0);
        r11.setDataPosition(0);
        MediaMetadataCompat r12 = CREATOR.createFromParcel(r11);
        r11.recycle();
        r12.mMetadataObj = r10;
        return r12;
    L5:
        return null;
    }

    public boolean containsKey(String r10) {
        return this.mBundle.containsKey(r10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bitmap getBitmap(String r10) {
        return (Bitmap) this.mBundle.getParcelable(r10);
    L4:
        e = move-exception;
        Log.w(TAG, "Failed to retrieve a key as Bitmap.", e);
        return null;
    }

    public Bundle getBundle() {
        return new Bundle(this.mBundle);
    }

    public MediaDescriptionCompat getDescription() {
        MediaDescriptionCompat r10 = this.mDescription;
        if (r10 == null) goto L5;
        return r10;
    L5:
        String r11 = getString(METADATA_KEY_MEDIA_ID);
        CharSequence[] r12 = new CharSequence[3];
        CharSequence r13 = getText(METADATA_KEY_DISPLAY_TITLE);
        if (TextUtils.isEmpty(r13) == true) goto L8;
        r12[0] = r13;
        r12[1] = getText(METADATA_KEY_DISPLAY_SUBTITLE);
        r12[2] = getText(METADATA_KEY_DISPLAY_DESCRIPTION);
    L16:
        int r14 = 0;
    L17:
        String[] r15 = PREFERRED_BITMAP_ORDER;
        Uri r16 = null;
        if (r14 >= r15.length) goto L23;
        Bitmap r17 = getBitmap(r15[r14]);
        if (r17 != null) goto L24;
        r14 = r14 + 1;
    L24:
        int r18 = 0;
    L25:
        String[] r19 = PREFERRED_URI_ORDER;
        if (r18 >= r19.length) goto L31;
        String r20 = getString(r19[r18]);
        if (TextUtils.isEmpty(r20) == false) goto L29;
        r18 = r18 + 1;
        goto L25
    L29:
        Uri r21 = Uri.parse(r20);
    L32:
        String r22 = getString(METADATA_KEY_MEDIA_URI);
        if (TextUtils.isEmpty(r22) == true) goto L35;
        r16 = Uri.parse(r22);
    L35:
        MediaDescriptionCompat.Builder r23 = new MediaDescriptionCompat.Builder();
        r23.setMediaId(r11);
        r23.setTitle(r12[0]);
        r23.setSubtitle(r12[1]);
        r23.setDescription(r12[2]);
        r23.setIconBitmap(r17);
        r23.setIconUri(r21);
        r23.setMediaUri(r16);
        Bundle r24 = new Bundle();
        if (this.mBundle.containsKey(METADATA_KEY_BT_FOLDER_TYPE) == false) goto L39;
        r24.putLong(MediaDescriptionCompat.EXTRA_BT_FOLDER_TYPE, getLong(METADATA_KEY_BT_FOLDER_TYPE));
    L39:
        if (this.mBundle.containsKey(METADATA_KEY_DOWNLOAD_STATUS) == false) goto L42;
        r24.putLong(MediaDescriptionCompat.EXTRA_DOWNLOAD_STATUS, getLong(METADATA_KEY_DOWNLOAD_STATUS));
    L42:
        if (r24.isEmpty() == true) goto L44;
        r23.setExtras(r24);
    L44:
        MediaDescriptionCompat r25 = r23.build();
        this.mDescription = r25;
        return r25;
    L31:
        r21 = null;
        goto L32
    L23:
        r17 = null;
        goto L24
    L8:
        int r26 = 0;
        int r27 = 0;
    L9:
        if (r26 >= 3) goto L16;
        String[] r28 = PREFERRED_DESCRIPTION_ORDER;
        if (r27 >= r28.length) goto L16;
        int r29 = r27 + 1;
        CharSequence r30 = getText(r28[r27]);
        if (TextUtils.isEmpty(r30) == true) goto L15;
        r12[r26] = r30;
        r26 = r26 + 1;
    L15:
        r27 = r29;
        goto L9
    }

    public long getLong(String r10) {
        return this.mBundle.getLong(r10, 0);
    }

    public Object getMediaMetadata() {
        if (this.mMetadataObj != null) goto L6;
        Parcel r10 = Parcel.obtain();
        writeToParcel(r10, 0);
        r10.setDataPosition(0);
        this.mMetadataObj = MediaMetadataCompatApi21.createFromParcel(r10);
        r10.recycle();
    L6:
        return this.mMetadataObj;
    }

    public RatingCompat getRating(String r10) {
        return RatingCompat.fromRating(this.mBundle.getParcelable(r10));
    L4:
        e = move-exception;
        Log.w(TAG, "Failed to retrieve a key as Rating.", e);
        return null;
    }

    public String getString(String r10) {
        CharSequence r11 = this.mBundle.getCharSequence(r10);
        if (r11 != null) goto L5;
        return null;
    L5:
        return r11.toString();
    }

    public CharSequence getText(String r10) {
        return this.mBundle.getCharSequence(r10);
    }

    public Set<String> keySet() {
        return this.mBundle.keySet();
    }

    public int size() {
        return this.mBundle.size();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeBundle(this.mBundle);
    }

    public MediaMetadataCompat(Parcel r10) {
        this.mBundle = r10.readBundle(MediaSessionCompat.class.getClassLoader());
    }
}
