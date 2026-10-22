package com.monitor.cloudmessage.upload;

import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.logging.Logger;
import com.bytedance.librarian.LibrarianImpl;
import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.upload.entity.FileUploadInfo;
import com.monitor.cloudmessage.upload.entity.UploadInfo;
import com.monitor.cloudmessage.upload.net.CloudMessageUploadService;
import com.monitor.cloudmessage.utils.FileUtils;
import com.monitor.cloudmessage.utils.NetworkUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class CloudMessageUploadManager {
    private static ArrayList<FileUploadInfo> fileInfos;

    public CloudMessageUploadManager() {
    }

    static {
        fileInfos = new ArrayList();
    }

    public static void upload(FileUploadInfo r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.getCallback() != null) goto L6;
        return;
    L6:
        if (r2.getCallback().getUploadFileList().size() != 0) goto L9;
        return;
    L9:
        if (checkStateForUpload(r2) == true) goto L12;
        return;
    L12:
        if (r2.isCompress() == true) goto L14;
        r2.setUploadFileAbsluteNames(r2.getCallback().getUploadFileList());
    L15:
        boolean r0 = CloudMessageUploadService.uploadFile(r2);
        if (r2.isDelSourceFile() == false) goto L31;
        if (r0 == false) goto L32;
        Iterator<String> r3 = r2.getCallback().getUploadFileList().iterator();
    L20:
        if (r3.hasNext() == false) goto L34;
        File r1 = new File(r3.next());
        if (r1.exists() == false) goto L20;
        r1.delete();
        goto L20
    L34:
        return;
    L32:
        return;
    L31:
        return;
    L14:
        zipUploadFile(r2);
        goto L15
    }

    public static void upload(UploadInfo r3) {
        if (ApmContext.isDebugMode() == false) goto L5;
        Logger.d("cloudmessage", new String[]{"uploadInfo=" + r3});
    L5:
        if (r3 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r3.getCommandId()) == true) goto L12;
        CloudMessageUploadService.uploadData(r3);
        return;
    }

    private static boolean checkStateForUpload(FileUploadInfo r6) {
        if (r6.isUploading() == false) goto L6;
        return false;
    L6:
        if (r6.isSkipUploadInternal() == true) goto L11;
        if ((System.currentTimeMillis() - r6.getLastUploadTime()) >= 0) goto L11;
        return false;
    L11:
        if (NetworkUtils.isNetworkAvailable(CloudMessageManager.getInstance().getContext()) == true) goto L13;
        return false;
    L13:
        return true;
    }

    private static void zipUploadFile(FileUploadInfo r8) {
        if (r8.getCallback().getUploadFileList().size() != 1) goto L5;
    L15:
        File r0 = new File(r8.getCallback().getUploadFileList().get(0));
        File r1 = new File(r0.getParent(), getZipFileName(r0.getName()));
        if (r1.exists() == false) goto L18;
        r1.delete();
    L18:
        FileUtils.compress(r1.getAbsolutePath(), (String[]) r8.getCallback().getUploadFileList().toArray(new String[r8.getCallback().getUploadFileList().size()]));
        ArrayList r2 = new ArrayList(1);
        r2.add(r1.getAbsolutePath());
        r8.setUploadFileAbsluteNames(r2);
        return;
    L5:
        if (r8.isMultiFileInOneZip() == true) goto L15;
        ArrayList r3 = new ArrayList();
        Iterator<String> r4 = r8.getCallback().getUploadFileList().iterator();
    L9:
        if (r4.hasNext() == false) goto L14;
        String r5 = r4.next();
        File r6 = new File(r5);
        File r7 = new File(r6.getParent(), getZipFileName(r6.getName()));
        if (r7.exists() == false) goto L13;
        r7.delete();
    L13:
        FileUtils.compress(r7.getAbsolutePath(), new String[]{r5});
        r3.add(r7.getAbsolutePath());
        goto L9
    L14:
        r8.setUploadFileAbsluteNames(r3);
    }

    private static String getZipFileName(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return "";
    L6:
        int r0 = r4.lastIndexOf(LibrarianImpl.Constants.DOT);
        if (r0 != (-1)) goto L11;
        return r4 + "-cloudMsg.zip";
    L11:
        return r4.substring(0, r0) + "-cloudMsg.zip";
    }
}
