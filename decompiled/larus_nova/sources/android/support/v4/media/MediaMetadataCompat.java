package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.bytedance.mt.protector.impl.UriProtector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR = null;
    static final ArrayMap<String, Integer> METADATA_KEYS_TYPE = null;
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
    public @interface BitmapKey {
    }

    public static final class Builder {
        private final Bundle mBundle;

        public MediaMetadataCompat build() {
            return new MediaMetadataCompat(this.mBundle);
        }

        public Builder() {
            this.mBundle = new Bundle();
        }

        public Builder(MediaMetadataCompat r100) {
            Bundle r101 = new Bundle(r100.mBundle);
            this.mBundle = r101;
            MediaSessionCompat.ensureClassLoader(r101);
        }

        public Builder(MediaMetadataCompat r100, int r101) {
            this(r100);
            Iterator<String> r102 = this.mBundle.keySet().iterator();
        L4:
            if (r102.hasNext() == false) goto L12;
            String r103 = r102.next();
            Object r104 = this.mBundle.get(r103);
            if ((r104 instanceof Bitmap) == false) goto L4;
            Bitmap r105 = (Bitmap) r104;
            if (r105.getHeight() > r101) goto L11;
            if (r105.getWidth() <= r101) goto L4;
        L11:
            putBitmap(r103, scaleBitmap(r105, r101));
            goto L4
        }

        private Bitmap scaleBitmap(Bitmap r100, int r101) {
            float r102 = r101;
            float r103 = Math.min(r102 / r100.getWidth(), r102 / r100.getHeight());
            return Bitmap.createScaledBitmap(r100, (int) (r100.getWidth() * r103), (int) (r100.getHeight() * r103), true);
        }

        public Builder putBitmap(String r100, Bitmap r101) {
            ArrayMap<String, Integer> r102 = MediaMetadataCompat.METADATA_KEYS_TYPE;
            if (r102.containsKey(r100) == true) goto L5;
        L9:
            this.mBundle.putParcelable(r100, r101);
            return this;
        L5:
            if (r102.get(r100).intValue() == 2) goto L9;
            throw new IllegalArgumentException("The " + r100 + " key cannot be used to put a Bitmap");
        }

        public Builder putLong(String r100, long r101) {
            ArrayMap<String, Integer> r102 = MediaMetadataCompat.METADATA_KEYS_TYPE;
            if (r102.containsKey(r100) == true) goto L5;
        L9:
            this.mBundle.putLong(r100, r101);
            return this;
        L5:
            if (r102.get(r100).intValue() == 0) goto L9;
            throw new IllegalArgumentException("The " + r100 + " key cannot be used to put a long");
        }

        public Builder putRating(String r100, RatingCompat r101) {
            ArrayMap<String, Integer> r102 = MediaMetadataCompat.METADATA_KEYS_TYPE;
            if (r102.containsKey(r100) == true) goto L5;
        L9:
            this.mBundle.putParcelable(r100, (Parcelable) r101.getRating());
            return this;
        L5:
            if (r102.get(r100).intValue() == 3) goto L9;
            throw new IllegalArgumentException("The " + r100 + " key cannot be used to put a Rating");
        }

        public Builder putString(String r100, String r101) {
            ArrayMap<String, Integer> r102 = MediaMetadataCompat.METADATA_KEYS_TYPE;
            if (r102.containsKey(r100) == true) goto L5;
        L9:
            this.mBundle.putCharSequence(r100, r101);
            return this;
        L5:
            if (r102.get(r100).intValue() == 1) goto L9;
            throw new IllegalArgumentException("The " + r100 + " key cannot be used to put a String");
        }

        public Builder putText(String r100, CharSequence r101) {
            ArrayMap<String, Integer> r102 = MediaMetadataCompat.METADATA_KEYS_TYPE;
            if (r102.containsKey(r100) == true) goto L5;
        L9:
            this.mBundle.putCharSequence(r100, r101);
            return this;
        L5:
            if (r102.get(r100).intValue() == 1) goto L9;
            throw new IllegalArgumentException("The " + r100 + " key cannot be used to put a CharSequence");
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LongKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RatingKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TextKey {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        ArrayMap<String, Integer> r100 = new ArrayMap();
        METADATA_KEYS_TYPE = r100;
        r100.put(METADATA_KEY_TITLE, 1);
        r100.put(METADATA_KEY_ARTIST, 1);
        r100.put(METADATA_KEY_DURATION, 0);
        r100.put(METADATA_KEY_ALBUM, 1);
        r100.put(METADATA_KEY_AUTHOR, 1);
        r100.put(METADATA_KEY_WRITER, 1);
        r100.put(METADATA_KEY_COMPOSER, 1);
        r100.put(METADATA_KEY_COMPILATION, 1);
        r100.put(METADATA_KEY_DATE, 1);
        r100.put(METADATA_KEY_YEAR, 0);
        r100.put(METADATA_KEY_GENRE, 1);
        r100.put(METADATA_KEY_TRACK_NUMBER, 0);
        r100.put(METADATA_KEY_NUM_TRACKS, 0);
        r100.put(METADATA_KEY_DISC_NUMBER, 0);
        r100.put(METADATA_KEY_ALBUM_ARTIST, 1);
        r100.put(METADATA_KEY_ART, 2);
        r100.put(METADATA_KEY_ART_URI, 1);
        r100.put(METADATA_KEY_ALBUM_ART, 2);
        r100.put(METADATA_KEY_ALBUM_ART_URI, 1);
        r100.put(METADATA_KEY_USER_RATING, 3);
        r100.put(METADATA_KEY_RATING, 3);
        r100.put(METADATA_KEY_DISPLAY_TITLE, 1);
        r100.put(METADATA_KEY_DISPLAY_SUBTITLE, 1);
        r100.put(METADATA_KEY_DISPLAY_DESCRIPTION, 1);
        r100.put(METADATA_KEY_DISPLAY_ICON, 2);
        r100.put(METADATA_KEY_DISPLAY_ICON_URI, 1);
        r100.put(METADATA_KEY_MEDIA_ID, 1);
        r100.put(METADATA_KEY_BT_FOLDER_TYPE, 0);
        r100.put(METADATA_KEY_MEDIA_URI, 1);
        r100.put(METADATA_KEY_ADVERTISEMENT, 0);
        r100.put(METADATA_KEY_DOWNLOAD_STATUS, 0);
        PREFERRED_DESCRIPTION_ORDER = new String[]{METADATA_KEY_TITLE, METADATA_KEY_ARTIST, METADATA_KEY_ALBUM, METADATA_KEY_ALBUM_ARTIST, METADATA_KEY_WRITER, METADATA_KEY_AUTHOR, METADATA_KEY_COMPOSER};
        PREFERRED_BITMAP_ORDER = new String[]{METADATA_KEY_DISPLAY_ICON, METADATA_KEY_ART, METADATA_KEY_ALBUM_ART};
        PREFERRED_URI_ORDER = new String[]{METADATA_KEY_DISPLAY_ICON_URI, METADATA_KEY_ART_URI, METADATA_KEY_ALBUM_ART_URI};
        CREATOR = new AnonymousClass1();
    }

    public Bundle getBundle() {
        return new Bundle(this.mBundle);
    }

    public MediaDescriptionCompat getDescription() {
        MediaDescriptionCompat r100 = this.mDescription;
        if (r100 == null) goto L5;
        return r100;
    L5:
        String r101 = getString(METADATA_KEY_MEDIA_ID);
        CharSequence[] r102 = new CharSequence[3];
        CharSequence r103 = getText(METADATA_KEY_DISPLAY_TITLE);
        if (TextUtils.isEmpty(r103) == true) goto L8;
        r102[0] = r103;
        r102[1] = getText(METADATA_KEY_DISPLAY_SUBTITLE);
        r102[2] = getText(METADATA_KEY_DISPLAY_DESCRIPTION);
    L16:
        int r104 = 0;
    L17:
        String[] r105 = PREFERRED_BITMAP_ORDER;
        Uri r106 = null;
        if (r104 >= r105.length) goto L23;
        Bitmap r107 = getBitmap(r105[r104]);
        if (r107 != null) goto L24;
        r104 = r104 + 1;
    L24:
        int r108 = 0;
    L25:
        String[] r109 = PREFERRED_URI_ORDER;
        if (r108 >= r109.length) goto L31;
        String r110 = getString(r109[r108]);
        if (TextUtils.isEmpty(r110) == false) goto L29;
        r108 = r108 + 1;
        goto L25
    L29:
        Uri r111 = UriProtector.parse(r110);
    L32:
        String r112 = getString(METADATA_KEY_MEDIA_URI);
        if (TextUtils.isEmpty(r112) == true) goto L35;
        r106 = UriProtector.parse(r112);
    L35:
        MediaDescriptionCompat.Builder r113 = new MediaDescriptionCompat.Builder();
        r113.setMediaId(r101);
        r113.setTitle(r102[0]);
        r113.setSubtitle(r102[1]);
        r113.setDescription(r102[2]);
        r113.setIconBitmap(r107);
        r113.setIconUri(r111);
        r113.setMediaUri(r106);
        Bundle r114 = new Bundle();
        if (this.mBundle.containsKey(METADATA_KEY_BT_FOLDER_TYPE) == false) goto L39;
        r114.putLong(MediaDescriptionCompat.EXTRA_BT_FOLDER_TYPE, getLong(METADATA_KEY_BT_FOLDER_TYPE));
    L39:
        if (this.mBundle.containsKey(METADATA_KEY_DOWNLOAD_STATUS) == false) goto L42;
        r114.putLong(MediaDescriptionCompat.EXTRA_DOWNLOAD_STATUS, getLong(METADATA_KEY_DOWNLOAD_STATUS));
    L42:
        if (r114.isEmpty() == true) goto L44;
        r113.setExtras(r114);
    L44:
        MediaDescriptionCompat r115 = r113.build();
        this.mDescription = r115;
        return r115;
    L31:
        r111 = null;
        goto L32
    L23:
        r107 = null;
        goto L24
    L8:
        int r116 = 0;
        int r117 = 0;
    L9:
        if (r116 >= 3) goto L16;
        String[] r118 = PREFERRED_DESCRIPTION_ORDER;
        if (r117 >= r118.length) goto L16;
        int r119 = r117 + 1;
        CharSequence r120 = getText(r118[r117]);
        if (TextUtils.isEmpty(r120) == true) goto L15;
        r102[r116] = r120;
        r116 = r116 + 1;
    L15:
        r117 = r119;
        goto L9
    }

    public Object getMediaMetadata() {
        if (this.mMetadataObj != null) goto L6;
        Parcel r100 = Parcel.obtain();
        writeToParcel(r100, 0);
        r100.setDataPosition(0);
        this.mMetadataObj = MediaMetadataCompatApi21.createFromParcel(r100);
        r100.recycle();
    L6:
        return this.mMetadataObj;
    }

    public Set<String> keySet() {
        return this.mBundle.keySet();
    }

    public int size() {
        return this.mBundle.size();
    }

    public MediaMetadataCompat(Parcel r100) {
        this.mBundle = r100.readBundle(MediaSessionCompat.class.getClassLoader());
    }

    public static MediaMetadataCompat fromMediaMetadata(Object r100) {
        if (r100 == null) goto L5;
        Parcel r101 = Parcel.obtain();
        MediaMetadataCompatApi21.writeToParcel(r100, r101, 0);
        r101.setDataPosition(0);
        MediaMetadataCompat r102 = CREATOR.createFromParcel(r101);
        r101.recycle();
        r102.mMetadataObj = r100;
        return r102;
    L5:
        return null;
    }

    public boolean containsKey(String r100) {
        return this.mBundle.containsKey(r100);
    }

    public Bitmap getBitmap(String r100) {
        return (Bitmap) this.mBundle.getParcelable(r100);
    L4:
        return null;
    }

    public long getLong(String r100) {
        return this.mBundle.getLong(r100, 0);
    }

    public RatingCompat getRating(String r100) {
        return RatingCompat.fromRating(this.mBundle.getParcelable(r100));
    L4:
        return null;
    }

    public String getString(String r100) {
        CharSequence r101 = this.mBundle.getCharSequence(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.toString();
    }

    public CharSequence getText(String r100) {
        return this.mBundle.getCharSequence(r100);
    }

    public MediaMetadataCompat(Bundle r100) {
        Bundle r101 = new Bundle(r100);
        this.mBundle = r101;
        MediaSessionCompat.ensureClassLoader(r101);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeBundle(this.mBundle);
    }
}
