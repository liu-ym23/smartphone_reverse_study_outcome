package com.obric.autogui.common.api;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.io.File;

/* JADX INFO: compiled from: AOFileUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AOFileUtil {
    public static final boolean CONFIG_USING_APP_DIR = true;
    public static final AOFileUtil INSTANCE = null;
    private static final String TAG = "FileMgrUtil";

    static {
        INSTANCE = new AOFileUtil();
    }

    private AOFileUtil() {
    }

    public final File getWritableAppDir() {
        return new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getFilesDir(), AOHostAppTools.INSTANCE.getFunctionName());
    }

    public final void openFileManager(Context r7, File r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r9, "context");
        o.e(r8, "zipFile");
        Intent r1 = new Intent("android.intent.action.VIEW");     // Catch: Exception -> L11
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Uri r10 = ZeusTransformUtils.getUriForFile(r9, r9.getPackageName() + ".fileprovider", r8, "com.obric.aiagent.plugin");     // Catch: Exception -> L11
    L7:
        r1.setDataAndType(r10, "application/zip");     // Catch: Exception -> L11
        r1.addFlags(1);     // Catch: Exception -> L11
        ComponentName r2 = r1.resolveActivity(r9.getPackageManager());     // Catch: Exception -> L11
        if (r2 == null) goto L22;
        Loog.INSTANCE.i(TAG, "will use `" + r2 + "` to open `" + r10 + '`');     // Catch: Exception -> L11
        startActivity(r9, r1);     // Catch: Exception -> L11
        return;
    L22:
        return;
    L6:
        r10 = Uri.fromFile(r8);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "打开文件管理器时发生错误: " + e.getMessage());
        e.printStackTrace();
        openDownloadsFolder(r9);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "无法打开下载文件夹: " + e.getMessage());
        e.printStackTrace();
    }

    private final void openFolder(Context r7, String r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        String r1 = Environment.getExternalStorageDirectory().getAbsolutePath();     // Catch: Exception -> L20
        o.c(r1, "getAbsolutePath(...)");     // Catch: Exception -> L20
        if (d.o.o.b(r8, r1, false, 2, null) == false) goto L18;
        File r2 = new File(r8);     // Catch: Exception -> L20
        Intent r10 = new Intent("android.intent.action.VIEW");     // Catch: Exception -> L20
        if (Build.VERSION.SDK_INT >= 24) goto L23;
        r10.setDataAndType(Uri.fromFile(r2), "resource/folder");     // Catch: Exception -> L20
    L15:
        if (r10.resolveActivity(r9.getPackageManager()) == null) goto L17;
        startActivity(r9, r10);     // Catch: Exception -> L20
        return;
    L17:
        openDownloadsFolder(r9);     // Catch: Exception -> L20
        return;
    L23:
        r10.setDataAndType(ZeusTransformUtils.getUriForFile(r9, r9.getPackageName() + ".fileprovider", r2, "com.obric.aiagent.plugin"), "resource/folder");     // Catch: Exception -> L10
        r10.addFlags(1);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "无法使用FileProvider获取URI: " + e.getMessage());     // Catch: Exception -> L20
        openDownloadsFolder(r9);     // Catch: Exception -> L20
        return;
    L18:
        openDownloadsFolder(r9);     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "打开文件夹时发生错误: " + e.getMessage());
        e.printStackTrace();
        openDownloadsFolder(r9);
    }

    public final void openDownloadsFolder(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r8, "context");
        Uri r2 = Uri.parse("content://com.android.externalstorage.documents/document/primary:Download");     // Catch: Exception -> L11
        Intent r4 = new Intent("android.intent.action.VIEW");     // Catch: Exception -> L11
        r4.setDataAndType(r2, "resource/folder");     // Catch: Exception -> L11
        r4.addFlags(1);     // Catch: Exception -> L11
        if (r4.resolveActivity(r8.getPackageManager()) == null) goto L6;
        startActivity(r8, r4);     // Catch: Exception -> L11
    L14:
        return;
    L6:
        Loog.INSTANCE.e(TAG, "无法打开下载文件夹，没有合适的应用处理此Intent");     // Catch: Exception -> L11
        Intent r3 = new Intent("android.intent.action.VIEW");     // Catch: Exception -> L11
        r3.setClassName("com.android.documentsui", "com.android.documentsui.files.FilesActivity");     // Catch: Exception -> L11
        if (r3.resolveActivity(r8.getPackageManager()) == null) goto L9;
        startActivity(r8, r3);     // Catch: Exception -> L11
        goto L14
    L9:
        Intent r5 = new Intent("android.intent.action.VIEW");     // Catch: Exception -> L11
        r5.setType("*/*");     // Catch: Exception -> L11
        Intent r1 = Intent.createChooser(r5, (CharSequence) ZeusTransformUtils.preCheckCast(r8.getString(ZeusTransformUtils.mapRes(R.string.obric_choose_app_to_open, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_choose_app_to_open")), CharSequence.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L11
        o.c(r1, "createChooser(...)");     // Catch: Exception -> L11
        startActivity(r8, r1);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "无法打开下载文件夹: " + e.getMessage());
        e.printStackTrace();
    }

    private final void startActivity(Context r2, Intent r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, Activity.class) == false) goto L6;
        ZeusTransformUtils.startActivity((Activity) ZeusTransformUtils.preCheckCast(r1, Activity.class, "com.obric.aiagent.plugin"), r3, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        r3.addFlags(268435456);     // Catch: Throwable -> L8
        ZeusTransformUtils.startActivity(r1, r3, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
    }

    public final Uri wrapToFileProviderUri(Context r3, File r4) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r2, "context");
        o.e(r4, "file");
        return ZeusTransformUtils.getUriForFile(r2, r2.getPackageName() + ".fileprovider", r4, "com.obric.aiagent.plugin");
    }

    public final AssetFileDescriptor wrapToClosableFd(Context r2, File r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r3, "file");
        return r1.getContentResolver().openAssetFileDescriptor(Uri.fromFile(r3), DownloadFileUtils.MODE_READ);
    }
}
