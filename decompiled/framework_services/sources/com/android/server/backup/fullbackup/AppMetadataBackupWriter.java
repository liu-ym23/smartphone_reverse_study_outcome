package com.android.server.backup.fullbackup;

import android.app.backup.FullBackup;
import android.app.backup.FullBackupDataOutput;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.os.Environment;
import android.util.StringBuilderPrinter;
import com.android.internal.util.Preconditions;
import com.android.server.backup.UserBackupManagerService;
import com.android.server.wm.ActivityTaskManagerService;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class AppMetadataBackupWriter {
    private final FullBackupDataOutput mOutput;
    private final PackageManager mPackageManager;

    public AppMetadataBackupWriter(FullBackupDataOutput output, PackageManager packageManager) {
        this.mOutput = output;
        this.mPackageManager = packageManager;
    }

    public void backupManifest(PackageInfo packageInfo, File manifestFile, File filesDir, boolean withApk) throws IOException {
        backupManifest(packageInfo, manifestFile, filesDir, null, null, withApk);
    }

    public void backupManifest(PackageInfo packageInfo, File manifestFile, File filesDir, String domain, String linkDomain, boolean withApk) throws IOException {
        byte[] manifestBytes = getManifestBytes(packageInfo, withApk);
        FileOutputStream outputStream = new FileOutputStream(manifestFile);
        outputStream.write(manifestBytes);
        outputStream.close();
        manifestFile.setLastModified(0);
        FullBackup.backupToTar(packageInfo.packageName, domain, linkDomain, filesDir.getAbsolutePath(), manifestFile.getAbsolutePath(), this.mOutput);
    }

    private byte[] getManifestBytes(PackageInfo packageInfo, boolean withApk) {
        String packageName = packageInfo.packageName;
        StringBuilder builder = new StringBuilder(4096);
        StringBuilderPrinter printer = new StringBuilderPrinter(builder);
        printer.println(Integer.toString(1));
        printer.println(packageName);
        printer.println(Long.toString(packageInfo.getLongVersionCode()));
        printer.println(Integer.toString(Build.VERSION.SDK_INT));
        String installerName = this.mPackageManager.getInstallerPackageName(packageName);
        if (installerName == null) goto L5;
        String r4 = installerName;
    L6:
        printer.println(r4);
        if (withApk == false) goto L9;
        String r5 = "1";
    L10:
        printer.println(r5);
        SigningInfo signingInfo = packageInfo.signingInfo;
        if (signingInfo != null) goto L13;
        printer.println("0");
    L18:
        return builder.toString().getBytes();
    L13:
        Signature[] signatures = signingInfo.getApkContentsSigners();
        printer.println(Integer.toString(signatures.length));
        int r6 = signatures.length;
        int r7 = 0;
    L15:
        if (r7 >= r6) goto L18;
        Signature sig = signatures[r7];
        printer.println(sig.toCharsString());
        r7 = r7 + 1;
        goto L15
    L9:
        r5 = "0";
        goto L10
    L5:
        r4 = "";
        goto L6
    }

    public void backupWidget(PackageInfo packageInfo, File metadataFile, File filesDir, byte[] widgetData) throws IOException {
        if (widgetData.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "Can't backup widget with no data.");
        String packageName = packageInfo.packageName;
        FileOutputStream fileOutputStream = new FileOutputStream(metadataFile);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream);
        byte[] metadata = getMetadataBytes(packageName);
        bufferedOutputStream.write(metadata);
        writeWidgetData(dataOutputStream, widgetData);
        bufferedOutputStream.flush();
        dataOutputStream.close();
        metadataFile.setLastModified(0);
        FullBackup.backupToTar(packageName, null, null, filesDir.getAbsolutePath(), metadataFile.getAbsolutePath(), this.mOutput);
        return;
    L5:
        r0 = false;
        goto L6
    }

    private byte[] getMetadataBytes(String packageName) {
        StringBuilder builder = new StringBuilder(512);
        StringBuilderPrinter printer = new StringBuilderPrinter(builder);
        printer.println(Integer.toString(1));
        printer.println(packageName);
        return builder.toString().getBytes();
    }

    private void writeWidgetData(DataOutputStream out, byte[] widgetData) throws IOException {
        out.writeInt(UserBackupManagerService.BACKUP_WIDGET_METADATA_TOKEN);
        out.writeInt(widgetData.length);
        out.write(widgetData);
    }

    public void backupApk(PackageInfo packageInfo) {
        String appSourceDir = packageInfo.applicationInfo.getBaseCodePath();
        String apkDir = new File(appSourceDir).getParent();
        FullBackup.backupToTar(packageInfo.packageName, ActivityTaskManagerService.DUMP_ACTIVITIES_SHORT_CMD, null, apkDir, appSourceDir, this.mOutput);
    }

    public void backupObb(int userId, PackageInfo packageInfo) {
        Environment.UserEnvironment userEnv = new Environment.UserEnvironment(userId);
        int r2 = 0;
        File obbDir = userEnv.buildExternalStorageAppObbDirs(packageInfo.packageName)[0];
        if (obbDir == null) goto L10;
        File[] obbFiles = obbDir.listFiles();
        if (obbFiles == null) goto L12;
        String obbDirName = obbDir.getAbsolutePath();
        int r10 = obbFiles.length;
    L8:
        if (r2 >= r10) goto L13;
        File obb = obbFiles[r2];
        FullBackup.backupToTar(packageInfo.packageName, "obb", null, obbDirName, obb.getAbsolutePath(), this.mOutput);
        r2 = r2 + 1;
        goto L8
    L13:
        return;
    L12:
        return;
    }
}
