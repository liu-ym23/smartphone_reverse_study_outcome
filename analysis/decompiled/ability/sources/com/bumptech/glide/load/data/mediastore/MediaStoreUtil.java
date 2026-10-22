package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.RequiresExtension;
import java.io.FileNotFoundException;

/* loaded from: classes2.dex */
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

    @ChecksSdkIntAtLeast(api = 17, extension = 30)
    public static boolean isMediaStoreOpenFileApisAvailable() {
        return SdkExtensions.getExtensionVersion(30) >= 17;
    }

    public static boolean isMediaStoreUri(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static boolean isMediaStoreVideoUri(Uri uri) {
        return isMediaStoreUri(uri) && isVideoUri(uri);
    }

    public static boolean isThumbnailSize(int i, int i6) {
        return i != Integer.MIN_VALUE && i6 != Integer.MIN_VALUE && i <= 512 && i6 <= MINI_THUMB_HEIGHT;
    }

    private static boolean isVideoUri(Uri uri) {
        return uri.getPathSegments().contains("video");
    }

    @RequiresExtension(extension = 30, version = 17)
    public static AssetFileDescriptor openAssetFileDescriptor(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        return MediaStore.openAssetFileDescriptor(contentResolver, uri, "r", null);
    }
}
