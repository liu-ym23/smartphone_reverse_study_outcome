package com.zyql.ai.selector;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.tools.PictureFileUtils;
import com.zyql.ai.selector.tools.SdkVersionUtils;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class PictureSelectorExternalUtils {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v2 */
    public static ExifInterface getExifInterface(Context context, String str) throws Throwable {
        InputStream contentResolverOpenInputStream;
        ?? r02 = 0;
        ExifInterface exifInterface = null;
        try {
            try {
                if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent(str)) {
                    contentResolverOpenInputStream = PictureContentResolver.getContentResolverOpenInputStream(context, Uri.parse(str));
                    if (contentResolverOpenInputStream != null) {
                        try {
                            exifInterface = new ExifInterface(contentResolverOpenInputStream);
                        } catch (Exception e10) {
                            e = e10;
                            e.printStackTrace();
                            PictureFileUtils.close(contentResolverOpenInputStream);
                            return null;
                        }
                    }
                } else {
                    exifInterface = new ExifInterface(str);
                    contentResolverOpenInputStream = null;
                }
                PictureFileUtils.close(contentResolverOpenInputStream);
                return exifInterface;
            } catch (Throwable th) {
                th = th;
                r02 = context;
                PictureFileUtils.close(r02);
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            contentResolverOpenInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            PictureFileUtils.close(r02);
            throw th;
        }
    }
}
