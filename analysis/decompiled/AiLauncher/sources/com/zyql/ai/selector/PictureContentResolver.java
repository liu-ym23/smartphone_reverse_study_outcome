package com.zyql.ai.selector;

import android.content.Context;
import android.net.Uri;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public final class PictureContentResolver {
    public static synchronized InputStream getContentResolverOpenInputStream(Context context, Uri uri) {
        try {
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
        return context.getContentResolver().openInputStream(uri);
    }

    public static synchronized OutputStream getContentResolverOpenOutputStream(Context context, Uri uri) {
        try {
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
        return context.getContentResolver().openOutputStream(uri);
    }
}
