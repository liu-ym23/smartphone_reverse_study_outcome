package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import com.stepos.ame.sdk.SkillStoreKt;
import java.io.FileNotFoundException;

/* loaded from: classes.dex */
public final class MediaStoreUtil {
    private static final int MINI_THUMB_HEIGHT = 384;
    private static final int MINI_THUMB_WIDTH = 512;
    public static final int MIN_EXTENSION_VERSION_FOR_OPEN_FILE_APIS = 17;

    private MediaStoreUtil() {
    }

    public static boolean isAndroidPickerUri(Uri uri) {
        return isMediaStoreUri(uri) && uri.getPathSegments().contains("picker");
    }

    public static boolean isMediaStoreImageUri(Uri uri) {
        return isMediaStoreUri(uri) && !isVideoUri(uri);
    }

    public static boolean isMediaStoreOpenFileApisAvailable() {
        return SdkExtensions.getExtensionVersion(30) >= 17;
    }

    public static boolean isMediaStoreUri(Uri uri) {
        return uri != null && SkillStoreKt.SKILL_DOC_TYPE_CONTENT.equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static boolean isMediaStoreVideoUri(Uri uri) {
        return isMediaStoreUri(uri) && isVideoUri(uri);
    }

    public static boolean isThumbnailSize(int i10, int i11) {
        return i10 != Integer.MIN_VALUE && i11 != Integer.MIN_VALUE && i10 <= 512 && i11 <= 384;
    }

    private static boolean isVideoUri(Uri uri) {
        return uri.getPathSegments().contains("video");
    }

    public static AssetFileDescriptor openAssetFileDescriptor(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        return MediaStore.openAssetFileDescriptor(contentResolver, uri, "r", null);
    }
}
