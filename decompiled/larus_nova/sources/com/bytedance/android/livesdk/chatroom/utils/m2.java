package com.bytedance.android.livesdk.chatroom.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import bytedance.io.BdMediaFileSystem;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import java.io.OutputStream;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class m2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f114558a = null;

    static {
        f114558a = Environment.getExternalStorageDirectory().getPath() + '/' + Environment.DIRECTORY_DCIM + "/Camera/";
    }

    @JvmStatic
    public static final String a(Context r100, Bitmap r101, String r102) {
        if (r101 != null) goto L5;
        return "";
    L5:
        if (r100 != null) goto L12;
        return "";
    L12:
        String r103 = r102 + '_' + System.currentTimeMillis() + RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT;     // Catch: Exception -> L9
        OutputStream r104 = ContentResolverWrapper.openOutputStream(r100.getContentResolver(), BdMediaFileSystem.createImageUri(r100, r103, "image/png"));     // Catch: Exception -> L9
        Bitmap.CompressFormat r105 = Bitmap.CompressFormat.PNG;     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r104);     // Catch: Exception -> L9
        r101.compress(r105, 70, r104);     // Catch: Exception -> L9
        return f114558a + r103;
    L9:
        e = move-exception;
        ALogger.d("ttlive_poster", "save bitmap failure: " + e.getMessage());
        return "";
    }
}
