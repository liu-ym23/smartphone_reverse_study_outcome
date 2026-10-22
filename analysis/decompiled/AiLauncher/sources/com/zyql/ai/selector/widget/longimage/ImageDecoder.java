package com.zyql.ai.selector.widget.longimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

/* loaded from: classes4.dex */
public interface ImageDecoder {
    Bitmap decode(Context context, Uri uri) throws Exception;
}
