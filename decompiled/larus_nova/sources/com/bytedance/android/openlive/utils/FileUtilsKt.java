package com.bytedance.android.openlive.utils;

import android.content.res.AssetManager;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonAssertResManager;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u001a\u0016\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"copyAssetFile", "", ChameleonAssertResManager.ASSET_FOLDER, "Landroid/content/res/AssetManager;", "name", "", "targetPath", "copyToFileOrThrow", "inputStream", "Ljava/io/InputStream;", "destFile", "Ljava/io/File;", "live-host-integration-default_release"}, k = 2, mv = {1, 4, 3})
public final class FileUtilsKt {
    public static final void copyToFileOrThrow(InputStream r100, File r101) {
        Intrinsics.checkNotNullParameter(r100, "inputStream");
        Intrinsics.checkNotNullParameter(r101, "destFile");
        if (r101.exists() == false) goto L5;
        return;
    L5:
        File r102 = r101.getParentFile();
        if (r102 != null) goto L8;
    L10:
        PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r101);
        byte[] r104 = new byte[4096];     // Catch: Throwable -> L20
    L12:
        int r105 = r100.read(r104);     // Catch: Throwable -> L20
        if (r105 < 0) goto L16;
        r103.write(r104, 0, r105);     // Catch: Throwable -> L20
        goto L12
    L16:
        r103.flush();
        r103.getFD().sync();     // Catch: IOException -> L25
    L18:
        r103.close();
        return;
    L20:
        th = move-exception;
        r103.flush();
        r103.getFD().sync();     // Catch: IOException -> L26
    L23:
        r103.close();
        throw th;
    L8:
        if (r102.exists() == true) goto L10;
        r102.mkdirs();
        goto L10
    }

    public static final void copyAssetFile(AssetManager r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, ChameleonAssertResManager.ASSET_FOLDER);
        Intrinsics.checkNotNullParameter(r101, "name");
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102);
        if (r103.exists() == false) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L17;
        InputStream r105 = r100.open(r101);
        if (r105 == null) goto L15;
        copyToFileOrThrow(r105, new PolarisFileWrapper(r102, r101));
        return;
    L15:
        throw new IllegalStateException("Invalid asset file " + r101);
    L17:
        throw new IllegalStateException(("mkdir failed: " + r102).toString());
    L5:
        if (r103.mkdirs() == true) goto L8;
        r104 = false;
        goto L9
    }
}
