package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MediaDescriptionCompatApi21.java */
/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: android.support.v4.media.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MediaDescriptionCompatApi21.java */
    static class C0000a {
        public static Object a() {
            return new MediaDescription.Builder();
        }

        public static void a(Object r2, String r3) {
            ((MediaDescription.Builder) ZeusTransformUtils.preCheckCast(r2, MediaDescription.Builder.class, "com.obric.aiagent.plugin")).setMediaId(r3);
        }

        public static void a(Object r2, CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            ((MediaDescription.Builder) ZeusTransformUtils.preCheckCast(r2, MediaDescription.Builder.class, "com.obric.aiagent.plugin")).setTitle(r4);
        }

        public static void b(Object r2, CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            ((MediaDescription.Builder) ZeusTransformUtils.preCheckCast(r2, MediaDescription.Builder.class, "com.obric.aiagent.plugin")).setSubtitle(r4);
        }

        public static void c(Object r2, CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            ((MediaDescription.Builder) ZeusTransformUtils.preCheckCast(r2, MediaDescription.Builder.class, "com.obric.aiagent.plugin")).setDescription(r4);
        }

        public static void a(Object r2, Bitmap r3) {
            ((MediaDescription.Builder) ZeusTransformUtils.preCheckCast(r2, MediaDescription.Builder.class, "com.obric.aiagent.plugin")).setIconBitmap(r3);
        }

        public static void a(Object r2, Uri r3) {
            ((MediaDescription.Builder) ZeusTransformUtils.preCheckCast(r2, MediaDescription.Builder.class, "com.obric.aiagent.plugin")).setIconUri(r3);
        }

        public static void a(Object r2, Bundle r3) {
            ((MediaDescription.Builder) ZeusTransformUtils.preCheckCast(r2, MediaDescription.Builder.class, "com.obric.aiagent.plugin")).setExtras(r3);
        }

        public static Object a(Object r2) {
            return ((MediaDescription.Builder) ZeusTransformUtils.preCheckCast(r2, MediaDescription.Builder.class, "com.obric.aiagent.plugin")).build();
        }
    }

    public static String a(Object r2) {
        return ((MediaDescription) ZeusTransformUtils.preCheckCast(r2, MediaDescription.class, "com.obric.aiagent.plugin")).getMediaId();
    }

    public static CharSequence b(Object r2) {
        return ((MediaDescription) ZeusTransformUtils.preCheckCast(r2, MediaDescription.class, "com.obric.aiagent.plugin")).getTitle();
    }

    public static CharSequence c(Object r2) {
        return ((MediaDescription) ZeusTransformUtils.preCheckCast(r2, MediaDescription.class, "com.obric.aiagent.plugin")).getSubtitle();
    }

    public static CharSequence d(Object r2) {
        return ((MediaDescription) ZeusTransformUtils.preCheckCast(r2, MediaDescription.class, "com.obric.aiagent.plugin")).getDescription();
    }

    public static Bitmap e(Object r2) {
        return ((MediaDescription) ZeusTransformUtils.preCheckCast(r2, MediaDescription.class, "com.obric.aiagent.plugin")).getIconBitmap();
    }

    public static Uri f(Object r2) {
        return ((MediaDescription) ZeusTransformUtils.preCheckCast(r2, MediaDescription.class, "com.obric.aiagent.plugin")).getIconUri();
    }

    public static Bundle g(Object r2) {
        return ((MediaDescription) ZeusTransformUtils.preCheckCast(r2, MediaDescription.class, "com.obric.aiagent.plugin")).getExtras();
    }

    public static void a(Object r2, Parcel r3, int r4) {
        ((MediaDescription) ZeusTransformUtils.preCheckCast(r2, MediaDescription.class, "com.obric.aiagent.plugin")).writeToParcel(r3, r4);
    }

    public static Object a(Parcel r1) {
        return MediaDescription.CREATOR.createFromParcel(r1);
    }
}
