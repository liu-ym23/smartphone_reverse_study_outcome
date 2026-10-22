package com.zyql.ai.selector.config;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.stepos.ame.sdk.SkillStoreKt;
import com.zyql.ai.selector.R;
import java.io.File;

/* loaded from: classes4.dex */
public final class PictureMimeType {
    public static final String AVI_Q = "video/avi";
    public static final String CAMERA = "Camera";
    public static final String DCIM = "DCIM/Camera";
    public static final String JPEG = ".jpeg";
    public static final String JPEG_Q = "image/jpeg";
    public static final String JPG = ".jpg";
    private static final String MIME_TYPE_3GP = "video/3gp";
    public static final String MIME_TYPE_AUDIO = "audio/mpeg";
    public static final String MIME_TYPE_AUDIO_AMR = "audio/amr";
    private static final String MIME_TYPE_AVI = "video/avi";
    private static final String MIME_TYPE_BMP = "image/bmp";
    private static final String MIME_TYPE_GIF = "image/gif";
    public static final String MIME_TYPE_IMAGE = "image/jpeg";
    public static final String MIME_TYPE_JPEG = "image/jpeg";
    private static final String MIME_TYPE_JPG = "image/jpg";
    private static final String MIME_TYPE_MP4 = "video/mp4";
    private static final String MIME_TYPE_MPEG = "video/mpeg";
    private static final String MIME_TYPE_PNG = "image/png";
    public static final String MIME_TYPE_PREFIX_AUDIO = "audio";
    public static final String MIME_TYPE_PREFIX_IMAGE = "image";
    public static final String MIME_TYPE_PREFIX_VIDEO = "video";
    public static final String MIME_TYPE_VIDEO = "video/mp4";
    private static final String MIME_TYPE_WEBP = "image/webp";
    public static final String MP4 = ".mp4";
    public static final String MP4_Q = "video/mp4";
    public static final String PNG = ".png";
    public static final String PNG_Q = "image/png";
    public static final String WEBP = ".webp";

    public static String getImageMimeType(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "image/jpeg";
            }
            String name = new File(str).getName();
            int iLastIndexOf = name.lastIndexOf(".");
            return "image/" + (iLastIndexOf == -1 ? "jpeg" : name.substring(iLastIndexOf + 1));
        } catch (Exception e10) {
            e10.printStackTrace();
            return "image/jpeg";
        }
    }

    public static String getLastImgSuffix(String str) {
        try {
            int iLastIndexOf = str.lastIndexOf("/") + 1;
            if (iLastIndexOf <= 0) {
                return PNG;
            }
            return "." + str.substring(iLastIndexOf);
        } catch (Exception e10) {
            e10.printStackTrace();
            return PNG;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getLastImgType(java.lang.String r2) {
        /*
            java.lang.String r0 = ".png"
            java.lang.String r1 = "."
            int r1 = r2.lastIndexOf(r1)     // Catch: java.lang.Exception -> L23
            if (r1 <= 0) goto L90
            java.lang.String r2 = r2.substring(r1)     // Catch: java.lang.Exception -> L23
            int r1 = r2.hashCode()     // Catch: java.lang.Exception -> L23
            switch(r1) {
                case 1436279: goto L80;
                case 1440950: goto L75;
                case 1449755: goto L6b;
                case 1468055: goto L61;
                case 1472726: goto L56;
                case 1475827: goto L4c;
                case 1481531: goto L44;
                case 44765590: goto L3a;
                case 45142218: goto L30;
                case 45750678: goto L26;
                case 46127306: goto L17;
                default: goto L15;
            }     // Catch: java.lang.Exception -> L23
        L15:
            goto L8a
        L17:
            java.lang.String r1 = ".webp"
            boolean r1 = r2.equals(r1)     // Catch: java.lang.Exception -> L23
            if (r1 == 0) goto L8a
            r1 = 8
            goto L8b
        L23:
            r2 = move-exception
            goto L91
        L26:
            java.lang.String r1 = ".jpeg"
            boolean r1 = r2.equals(r1)     // Catch: java.lang.Exception -> L23
            if (r1 == 0) goto L8a
            r1 = 3
            goto L8b
        L30:
            java.lang.String r1 = ".WEBP"
            boolean r1 = r2.equals(r1)     // Catch: java.lang.Exception -> L23
            if (r1 == 0) goto L8a
            r1 = 5
            goto L8b
        L3a:
            java.lang.String r1 = ".JPEG"
            boolean r1 = r2.equals(r1)     // Catch: java.lang.Exception -> L23
            if (r1 == 0) goto L8a
            r1 = 4
            goto L8b
        L44:
            boolean r1 = r2.equals(r0)     // Catch: java.lang.Exception -> L23
            if (r1 == 0) goto L8a
            r1 = 0
            goto L8b
        L4c:
            java.lang.String r1 = ".jpg"
            boolean r1 = r2.equals(r1)     // Catch: java.lang.Exception -> L23
            if (r1 == 0) goto L8a
            r1 = 2
            goto L8b
        L56:
            java.lang.String r1 = ".gif"
            boolean r1 = r2.equals(r1)     // Catch: java.lang.Exception -> L23
            if (r1 == 0) goto L8a
            r1 = 9
            goto L8b
        L61:
            java.lang.String r1 = ".bmp"
            boolean r1 = r2.equals(r1)     // Catch: java.lang.Exception -> L23
            if (r1 == 0) goto L8a
            r1 = 6
            goto L8b
        L6b:
            java.lang.String r1 = ".PNG"
            boolean r1 = r2.equals(r1)     // Catch: java.lang.Exception -> L23
            if (r1 == 0) goto L8a
            r1 = 1
            goto L8b
        L75:
            java.lang.String r1 = ".GIF"
            boolean r1 = r2.equals(r1)     // Catch: java.lang.Exception -> L23
            if (r1 == 0) goto L8a
            r1 = 10
            goto L8b
        L80:
            java.lang.String r1 = ".BMP"
            boolean r1 = r2.equals(r1)     // Catch: java.lang.Exception -> L23
            if (r1 == 0) goto L8a
            r1 = 7
            goto L8b
        L8a:
            r1 = -1
        L8b:
            switch(r1) {
                case 0: goto L8f;
                case 1: goto L8f;
                case 2: goto L8f;
                case 3: goto L8f;
                case 4: goto L8f;
                case 5: goto L8f;
                case 6: goto L8f;
                case 7: goto L8f;
                case 8: goto L8f;
                case 9: goto L8f;
                case 10: goto L8f;
                default: goto L8e;
            }
        L8e:
            return r0
        L8f:
            return r2
        L90:
            return r0
        L91:
            r2.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zyql.ai.selector.config.PictureMimeType.getLastImgType(java.lang.String):java.lang.String");
    }

    public static String getMimeType(int i10) {
        return i10 != 2 ? i10 != 3 ? "image/jpeg" : MIME_TYPE_AUDIO_AMR : "video/mp4";
    }

    public static String getMimeTypeFromMediaContentUri(Context context, Uri uri) {
        String type = uri.getScheme().equals(SkillStoreKt.SKILL_DOC_TYPE_CONTENT) ? context.getContentResolver().getType(uri) : MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(uri.toString()).toLowerCase());
        return TextUtils.isEmpty(type) ? "image/jpeg" : type;
    }

    public static boolean isContent(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("content://");
    }

    public static boolean isGif(String str) {
        if (str != null) {
            return str.equals(MIME_TYPE_GIF) || str.equals("image/GIF");
        }
        return false;
    }

    public static boolean isGifForSuffix(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(".gif") || str.startsWith(".GIF");
    }

    public static boolean isHasAudio(String str) {
        return str != null && str.startsWith("audio");
    }

    public static boolean isHasHttp(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("http") || str.startsWith("https") || str.startsWith("/http") || str.startsWith("/https");
    }

    public static boolean isHasImage(String str) {
        return str != null && str.startsWith("image");
    }

    public static boolean isHasVideo(String str) {
        return str != null && str.startsWith("video");
    }

    public static boolean isJPEG(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("image/jpeg") || str.startsWith("image/jpg");
    }

    public static boolean isJPG(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("image/jpg");
    }

    public static boolean isMimeTypeSame(String str, String str2) {
        return getMimeType(str) == getMimeType(str2);
    }

    public static boolean isSuffixOfImage(String str) {
        return (!TextUtils.isEmpty(str) && str.endsWith(".PNG")) || str.endsWith(PNG) || str.endsWith(".jpeg") || str.endsWith(".gif") || str.endsWith(".GIF") || str.endsWith(JPG) || str.endsWith(WEBP) || str.endsWith(".WEBP") || str.endsWith(".JPEG") || str.endsWith(".bmp");
    }

    public static boolean isUrlHasVideo(String str) {
        return str.endsWith(".mp4");
    }

    public static String of3GP() {
        return MIME_TYPE_3GP;
    }

    public static String ofAVI() {
        return "video/avi";
    }

    public static int ofAll() {
        return 0;
    }

    @Deprecated
    public static int ofAudio() {
        return 3;
    }

    public static String ofBMP() {
        return MIME_TYPE_BMP;
    }

    public static String ofGIF() {
        return MIME_TYPE_GIF;
    }

    public static int ofImage() {
        return 1;
    }

    public static String ofJPEG() {
        return "image/jpeg";
    }

    public static String ofMP4() {
        return "video/mp4";
    }

    public static String ofMPEG() {
        return MIME_TYPE_MPEG;
    }

    public static String ofPNG() {
        return "image/png";
    }

    public static int ofVideo() {
        return 2;
    }

    public static String ofWEBP() {
        return MIME_TYPE_WEBP;
    }

    public static String s(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        return isHasVideo(str) ? applicationContext.getString(R.string.picture_video_error) : isHasAudio(str) ? applicationContext.getString(R.string.picture_audio_error) : applicationContext.getString(R.string.picture_error);
    }

    public static int getMimeType(String str) {
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        if (str.startsWith("video")) {
            return 2;
        }
        return str.startsWith("audio") ? 3 : 1;
    }
}
