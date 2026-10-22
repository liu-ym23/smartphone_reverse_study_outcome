package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Set;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR = null;
    static final androidx.b.a<String, Integer> METADATA_KEYS_TYPE = null;
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

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Bundle f67a;

        public a() {
            this.f67a = new Bundle();
        }

        public a(MediaMetadataCompat r2) {
            Bundle r0 = new Bundle(r2.mBundle);
            this.f67a = r0;
            MediaSessionCompat.a(r0);
        }

        public a(MediaMetadataCompat r5, int r6) {
            this(r5);
            Iterator<String> r7 = this.f67a.keySet().iterator();
        L4:
            if (r7.hasNext() == false) goto L12;
            String r0 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin");
            Object r1 = this.f67a.get(r0);
            if (ZeusTransformUtils.instanceOf(r1, Bitmap.class) == false) goto L4;
            Bitmap r2 = (Bitmap) ZeusTransformUtils.preCheckCast(r1, Bitmap.class, "com.obric.aiagent.plugin");
            if (r2.getHeight() > r6) goto L11;
            if (r2.getWidth() <= r6) goto L4;
        L11:
            a(r0, a(r2, r6));
            goto L4
        }

        public a a(String r4, Bitmap r5) {
            if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(r4) == true) goto L5;
        L9:
            this.f67a.putParcelable(r4, r5);
            return this;
        L5:
            if (((Integer) ZeusTransformUtils.preCheckCast(MediaMetadataCompat.METADATA_KEYS_TYPE.get(r4), Integer.class, "com.obric.aiagent.plugin")).intValue() == 2) goto L9;
            throw new IllegalArgumentException("The " + r4 + " key cannot be used to put a Bitmap");
        }

        public MediaMetadataCompat a() {
            return new MediaMetadataCompat(this.f67a);
        }

        private Bitmap a(Bitmap r2, int r3) {
            float r1 = r3;
            float r4 = Math.min(r1 / r2.getWidth(), r1 / r2.getHeight());
            return Bitmap.createScaledBitmap(r2, (int) (r2.getWidth() * r4), (int) (r2.getHeight() * r4), true);
        }
    }

    public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
        return Log.w(r0, r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        androidx.b.a<String, Integer> r0 = new androidx.b.a();
        METADATA_KEYS_TYPE = r0;
        r0.put(METADATA_KEY_TITLE, 1);
        r0.put(METADATA_KEY_ARTIST, 1);
        r0.put(METADATA_KEY_DURATION, 0);
        r0.put(METADATA_KEY_ALBUM, 1);
        r0.put(METADATA_KEY_AUTHOR, 1);
        r0.put(METADATA_KEY_WRITER, 1);
        r0.put(METADATA_KEY_COMPOSER, 1);
        r0.put(METADATA_KEY_COMPILATION, 1);
        r0.put(METADATA_KEY_DATE, 1);
        r0.put(METADATA_KEY_YEAR, 0);
        r0.put(METADATA_KEY_GENRE, 1);
        r0.put(METADATA_KEY_TRACK_NUMBER, 0);
        r0.put(METADATA_KEY_NUM_TRACKS, 0);
        r0.put(METADATA_KEY_DISC_NUMBER, 0);
        r0.put(METADATA_KEY_ALBUM_ARTIST, 1);
        r0.put(METADATA_KEY_ART, 2);
        r0.put(METADATA_KEY_ART_URI, 1);
        r0.put(METADATA_KEY_ALBUM_ART, 2);
        r0.put(METADATA_KEY_ALBUM_ART_URI, 1);
        r0.put(METADATA_KEY_USER_RATING, 3);
        r0.put(METADATA_KEY_RATING, 3);
        r0.put(METADATA_KEY_DISPLAY_TITLE, 1);
        r0.put(METADATA_KEY_DISPLAY_SUBTITLE, 1);
        r0.put(METADATA_KEY_DISPLAY_DESCRIPTION, 1);
        r0.put(METADATA_KEY_DISPLAY_ICON, 2);
        r0.put(METADATA_KEY_DISPLAY_ICON_URI, 1);
        r0.put(METADATA_KEY_MEDIA_ID, 1);
        r0.put(METADATA_KEY_BT_FOLDER_TYPE, 0);
        r0.put(METADATA_KEY_MEDIA_URI, 1);
        r0.put(METADATA_KEY_ADVERTISEMENT, 0);
        r0.put(METADATA_KEY_DOWNLOAD_STATUS, 0);
        PREFERRED_DESCRIPTION_ORDER = new String[]{METADATA_KEY_TITLE, METADATA_KEY_ARTIST, METADATA_KEY_ALBUM, METADATA_KEY_ALBUM_ARTIST, METADATA_KEY_WRITER, METADATA_KEY_AUTHOR, METADATA_KEY_COMPOSER};
        PREFERRED_BITMAP_ORDER = new String[]{METADATA_KEY_DISPLAY_ICON, METADATA_KEY_ART, METADATA_KEY_ALBUM_ART};
        PREFERRED_URI_ORDER = new String[]{METADATA_KEY_DISPLAY_ICON_URI, METADATA_KEY_ART_URI, METADATA_KEY_ALBUM_ART_URI};
        CREATOR = new AnonymousClass1();
    }

    MediaMetadataCompat(Bundle r2) {
        Bundle r0 = new Bundle(r2);
        this.mBundle = r0;
        MediaSessionCompat.a(r0);
    }

    MediaMetadataCompat(Parcel r2) {
        this.mBundle = r2.readBundle(MediaSessionCompat.class.getClassLoader());
    }

    public boolean containsKey(String r1) {
        return this.mBundle.containsKey(r1);
    }

    public CharSequence getText(String r1) {
        return this.mBundle.getCharSequence(r1);
    }

    public String getString(String r1) {
        CharSequence r0 = this.mBundle.getCharSequence(r1);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.toString();
    }

    public long getLong(String r3) {
        return this.mBundle.getLong(r3, 0);
    }

    public RatingCompat getRating(String r3) {
    L7:
        e = move-exception;
        INVOKESTATIC_android_support_v4_media_MediaMetadataCompat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Failed to retrieve a key as Rating.", e);
        return null;
    L3:
        if (Build.VERSION.SDK_INT < 19) goto L5;
        RatingCompat r2 = RatingCompat.fromRating(this.mBundle.getParcelable(r3));     // Catch: Exception -> L7
    L10:
        return r2;
    L5:
        r2 = (RatingCompat) ZeusTransformUtils.preCheckCast(this.mBundle.getParcelable(r3), RatingCompat.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7
        goto L10
    }

    public Bitmap getBitmap(String r2) {
        return (Bitmap) ZeusTransformUtils.preCheckCast(this.mBundle.getParcelable(r2), Bitmap.class, "com.obric.aiagent.plugin");
    L4:
        e = move-exception;
        INVOKESTATIC_android_support_v4_media_MediaMetadataCompat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Failed to retrieve a key as Bitmap.", e);
        return null;
    }

    public MediaDescriptionCompat getDescription() {
        MediaDescriptionCompat r0 = this.mDescription;
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r1 = getString(METADATA_KEY_MEDIA_ID);
        CharSequence[] r2 = new CharSequence[3];
        CharSequence r3 = getText(METADATA_KEY_DISPLAY_TITLE);
        if (TextUtils.isEmpty(r3) == true) goto L8;
        r2[0] = r3;
        r2[1] = getText(METADATA_KEY_DISPLAY_SUBTITLE);
        r2[2] = getText(METADATA_KEY_DISPLAY_DESCRIPTION);
    L16:
        int r4 = 0;
    L17:
        String[] r5 = PREFERRED_BITMAP_ORDER;
        Uri r8 = null;
        if (r4 >= r5.length) goto L23;
        Bitmap r6 = getBitmap(r5[r4]);
        if (r6 != null) goto L24;
        r4 = r4 + 1;
    L24:
        int r7 = 0;
    L25:
        String[] r9 = PREFERRED_URI_ORDER;
        if (r7 >= r9.length) goto L31;
        String r10 = getString(r9[r7]);
        if (TextUtils.isEmpty(r10) == false) goto L29;
        r7 = r7 + 1;
        goto L25
    L29:
        Uri r11 = Uri.parse(r10);
    L32:
        String r12 = getString(METADATA_KEY_MEDIA_URI);
        if (TextUtils.isEmpty(r12) == true) goto L35;
        r8 = Uri.parse(r12);
    L35:
        MediaDescriptionCompat.a r13 = new MediaDescriptionCompat.a();
        r13.a(r1);
        r13.a(r2[0]);
        r13.b(r2[1]);
        r13.c(r2[2]);
        r13.a(r6);
        r13.a(r11);
        r13.b(r8);
        Bundle r14 = new Bundle();
        if (this.mBundle.containsKey(METADATA_KEY_BT_FOLDER_TYPE) == false) goto L39;
        r14.putLong(MediaDescriptionCompat.EXTRA_BT_FOLDER_TYPE, getLong(METADATA_KEY_BT_FOLDER_TYPE));
    L39:
        if (this.mBundle.containsKey(METADATA_KEY_DOWNLOAD_STATUS) == false) goto L42;
        r14.putLong(MediaDescriptionCompat.EXTRA_DOWNLOAD_STATUS, getLong(METADATA_KEY_DOWNLOAD_STATUS));
    L42:
        if (r14.isEmpty() == true) goto L44;
        r13.a(r14);
    L44:
        MediaDescriptionCompat r15 = r13.a();
        this.mDescription = r15;
        return r15;
    L31:
        r11 = null;
        goto L32
    L23:
        r6 = null;
        goto L24
    L8:
        int r16 = 0;
        int r17 = 0;
    L9:
        if (r16 >= 3) goto L16;
        String[] r18 = PREFERRED_DESCRIPTION_ORDER;
        if (r17 >= r18.length) goto L16;
        int r19 = r17 + 1;
        CharSequence r20 = getText(r18[r17]);
        if (TextUtils.isEmpty(r20) == true) goto L15;
        r2[r16] = r20;
        r16 = r16 + 1;
    L15:
        r17 = r19;
        goto L9
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeBundle(this.mBundle);
    }

    public int size() {
        return this.mBundle.size();
    }

    public Set<String> keySet() {
        return this.mBundle.keySet();
    }

    public Bundle getBundle() {
        return new Bundle(this.mBundle);
    }

    public static MediaMetadataCompat fromMediaMetadata(Object r4) {
        if (r4 != null) goto L4;
        return null;
    L4:
        if (Build.VERSION.SDK_INT < 21) goto L9;
        Parcel r0 = Parcel.obtain();
        c.a(r4, r0, 0);
        r0.setDataPosition(0);
        MediaMetadataCompat r1 = (MediaMetadataCompat) ZeusTransformUtils.preCheckCast(CREATOR.createFromParcel(r0), MediaMetadataCompat.class, "com.obric.aiagent.plugin");
        r0.recycle();
        r1.mMetadataObj = r4;
        return r1;
    L9:
        return null;
    }

    public Object getMediaMetadata() {
        if (this.mMetadataObj != null) goto L8;
        if (Build.VERSION.SDK_INT < 21) goto L8;
        Parcel r0 = Parcel.obtain();
        writeToParcel(r0, 0);
        r0.setDataPosition(0);
        this.mMetadataObj = c.a(r0);
        r0.recycle();
    L8:
        return this.mMetadataObj;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_android_support_v4_media_MediaMetadataCompat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
