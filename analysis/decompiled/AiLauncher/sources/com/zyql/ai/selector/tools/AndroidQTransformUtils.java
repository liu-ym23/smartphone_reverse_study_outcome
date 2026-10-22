package com.zyql.ai.selector.tools;

import Mb.InterfaceC0968f;
import Mb.u;
import android.content.Context;
import android.net.Uri;
import com.zyql.ai.selector.PictureContentResolver;
import java.io.File;
import java.io.InputStream;
import java.util.Objects;

/* loaded from: classes4.dex */
public class AndroidQTransformUtils {
    public static String copyPathToAndroidQ(Context context, long j10, String str, int i10, int i11, String str2, String str3) {
        String strCreateFilePath;
        File file;
        InterfaceC0968f interfaceC0968fC = null;
        try {
            try {
                strCreateFilePath = PictureFileUtils.createFilePath(context, StringUtils.getEncryptionValue(j10, i10, i11), str2, str3);
                file = new File(strCreateFilePath);
            } catch (Exception e10) {
                e10.printStackTrace();
                if (interfaceC0968fC == null || !interfaceC0968fC.isOpen()) {
                    return "";
                }
            }
            if (!file.exists()) {
                InputStream contentResolverOpenInputStream = PictureContentResolver.getContentResolverOpenInputStream(context, Uri.parse(str));
                Objects.requireNonNull(contentResolverOpenInputStream);
                interfaceC0968fC = u.c(u.l(contentResolverOpenInputStream));
                if (!PictureFileUtils.bufferCopy(interfaceC0968fC, file)) {
                    if (interfaceC0968fC == null || !interfaceC0968fC.isOpen()) {
                        return "";
                    }
                    PictureFileUtils.close(interfaceC0968fC);
                    return "";
                }
                if (interfaceC0968fC != null && interfaceC0968fC.isOpen()) {
                    PictureFileUtils.close(interfaceC0968fC);
                }
            }
            return strCreateFilePath;
        } catch (Throwable th) {
            if (interfaceC0968fC != null && interfaceC0968fC.isOpen()) {
                PictureFileUtils.close(interfaceC0968fC);
            }
            throw th;
        }
    }

    public static boolean copyPathToDCIM(Context context, File file, Uri uri) {
        try {
            return PictureFileUtils.bufferCopy(file, PictureContentResolver.getContentResolverOpenOutputStream(context, uri));
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }
}
