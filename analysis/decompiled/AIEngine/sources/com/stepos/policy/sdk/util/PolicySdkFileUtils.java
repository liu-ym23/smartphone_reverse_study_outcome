package com.stepos.policy.sdk.util;

import android.content.Context;
import com.stepos.policy.sdk.bean.PolicyFileDataResultBean;
import com.stepos.policy.sdk.bean.PolicyNewestPathResultBean;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import gc.o;
import gc.q;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicySdkFileUtils {
    public static final Companion Companion = new Companion(null);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x0118  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final java.lang.String copyAssetsFile(android.content.Context r10, java.lang.String r11, java.lang.String r12, java.lang.String r13) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 284
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.util.PolicySdkFileUtils.Companion.copyAssetsFile(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
        }

        public final String copyPolicyFile(String sourcePath, String toPath) throws IOException {
            kotlin.jvm.internal.g.f(sourcePath, "sourcePath");
            kotlin.jvm.internal.g.f(toPath, "toPath");
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    File file = new File(sourcePath);
                    if (file.exists()) {
                        File file2 = new File(toPath);
                        File file3 = new File(file2.getParent());
                        if (!file2.exists() || !file3.exists()) {
                            file3.mkdirs();
                            try {
                                file2.createNewFile();
                            } catch (Exception e10) {
                                e10.printStackTrace();
                            }
                        }
                        FileInputStream fileInputStream = new FileInputStream(file);
                        PolicySdkLogUtils.Companion.d("copyPolicyFile", "open assets success ");
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file2.getPath());
                        while (true) {
                            try {
                                try {
                                    int i10 = fileInputStream.read();
                                    if (i10 == -1) {
                                        break;
                                    }
                                    fileOutputStream2.write(i10);
                                } catch (Throwable unused) {
                                    toPath = "";
                                }
                            } catch (Exception e11) {
                                e = e11;
                                fileOutputStream = fileOutputStream2;
                                PolicySdkLogUtils.Companion.d("copyPolicyFile", "Exception " + e.getMessage());
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                return "";
                            }
                        }
                        fileInputStream.close();
                        try {
                            PolicySdkLogUtils.Companion.d("copyPolicyFile", "copy finished" + toPath);
                            fileOutputStream = fileOutputStream2;
                        } catch (Throwable unused2) {
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            return toPath;
                        }
                    } else {
                        toPath = "";
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return toPath;
                } catch (Throwable unused3) {
                    toPath = "";
                }
            } catch (Exception e12) {
                e = e12;
            }
        }

        public final void deleteFile(String oldPolicyPath) {
            kotlin.jvm.internal.g.f(oldPolicyPath, "oldPolicyPath");
            new File(oldPolicyPath).delete();
        }

        public final String getFileMD5(Context context, String fileName) {
            kotlin.jvm.internal.g.f(context, "context");
            kotlin.jvm.internal.g.f(fileName, "fileName");
            InputStream inputStreamOpen = context.getAssets().open(fileName);
            kotlin.jvm.internal.g.e(inputStreamOpen, "context.assets.open(fileName)");
            return getFileMD5ByInputStream(inputStreamOpen);
        }

        public final String getFileMD5ByInputStream(InputStream inputStream) throws NoSuchAlgorithmException, IOException {
            int i10;
            kotlin.jvm.internal.g.f(inputStream, "inputStream");
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                byte[] bArr = new byte[1024];
                int i11 = inputStream.read(bArr);
                while (true) {
                    if (i11 == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, i11);
                    i11 = inputStream.read(bArr);
                }
                inputStream.close();
                byte[] digest = messageDigest.digest();
                StringBuilder sb2 = new StringBuilder();
                kotlin.jvm.internal.g.e(digest, "digest");
                for (byte b10 : digest) {
                    sb2.append(String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(b10 & 255)}, 1)));
                }
                String string = sb2.toString();
                kotlin.jvm.internal.g.e(string, "sb.toString()");
                return string;
            } catch (Exception e10) {
                e10.printStackTrace();
                PolicySdkLogUtils.Companion.d("getFileMD5", "Exception " + e10.getMessage());
                return "";
            }
        }

        public final String getFileMD5FromFile(String fileName) {
            kotlin.jvm.internal.g.f(fileName, "fileName");
            return getFileMD5ByInputStream(new FileInputStream(new File(fileName)));
        }

        public final String getFileNameFromPolicyData(String category, int i10, String policyMd5) {
            kotlin.jvm.internal.g.f(category, "category");
            kotlin.jvm.internal.g.f(policyMd5, "policyMd5");
            if (policyMd5.equals("")) {
                return category + '_' + i10 + ".html";
            }
            return category + '_' + i10 + '_' + policyMd5 + ".html";
        }

        public final String getMD5NewFileName(String sourceFileName, String str) {
            int iR0;
            kotlin.jvm.internal.g.f(sourceFileName, "sourceFileName");
            if (!kotlin.jvm.internal.g.b(str, "") && (iR0 = q.r0(sourceFileName, ".html", 0, false, 6)) >= 0) {
                StringBuilder sb2 = new StringBuilder();
                String strSubstring = sourceFileName.substring(0, iR0);
                kotlin.jvm.internal.g.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                sb2.append(strSubstring);
                sb2.append('_');
                sb2.append(str);
                String strSubstring2 = sourceFileName.substring(iR0);
                kotlin.jvm.internal.g.e(strSubstring2, "this as java.lang.String).substring(startIndex)");
                sb2.append(strSubstring2);
                sourceFileName = sb2.toString();
            }
            PolicySdkLogUtils.Companion.d("getMD5NewFileName", "newSourceFileName " + sourceFileName);
            return sourceFileName;
        }

        public final PolicyFileDataResultBean getPolicyDataFromFileName(String fileName) {
            kotlin.jvm.internal.g.f(fileName, "fileName");
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            companion.d("FileUtils", "getPolicyDataFromFileName start fileName" + fileName + ' ');
            PolicyFileDataResultBean policyFileDataResultBean = new PolicyFileDataResultBean();
            try {
                if (q.l0(fileName, "_", false) && q.l0(fileName, ".html", false)) {
                    String strI0 = o.i0(fileName, ".html", "");
                    List listD0 = q.D0(strI0, new String[]{"_"}, 6);
                    companion.d("FileUtils", "getPolicyDataFromFileName last mFileName =" + strI0 + ' ');
                    if (!listD0.isEmpty() && listD0.size() > 1) {
                        policyFileDataResultBean.setCategory((String) listD0.get(0));
                        policyFileDataResultBean.setVersion(Long.parseLong((String) listD0.get(1)));
                        if (listD0.size() > 2) {
                            policyFileDataResultBean.setMd5((String) listD0.get(listD0.size() - 1));
                        } else {
                            policyFileDataResultBean.setMd5("");
                        }
                    }
                }
            } catch (Exception e10) {
                PolicySdkLogUtils.Companion.e("FileUtils", "Exception" + e10.getMessage() + ' ');
            }
            PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.Companion;
            companion2.d("FileUtils", "policyFileDataResultBean  " + policyFileDataResultBean + ' ');
            companion2.d("FileUtils", "ResultBean version  " + policyFileDataResultBean.getVersion() + ' ');
            return policyFileDataResultBean;
        }

        public final String getPolicyFolder(Context context) {
            kotlin.jvm.internal.g.f(context, "context");
            return context.getDir(PolicySdkConstants.policyFileDir, 0).getPath() + '/';
        }

        public final String getPolicyFolderCachePath(Context context, String category) {
            kotlin.jvm.internal.g.f(context, "context");
            kotlin.jvm.internal.g.f(category, "category");
            File dir = context.getDir(PolicySdkConstants.policyFileDir, 0);
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            StringBuilder sb2 = new StringBuilder("getPolicyFolderCachePath = ");
            sb2.append(dir != null ? Boolean.valueOf(dir.exists()) : null);
            companion.d("FileUtils", sb2.toString());
            StringBuilder sb3 = new StringBuilder("getPolicyFolderCachePath = ");
            sb3.append(dir != null ? dir.getPath() : null);
            companion.d("FileUtils", sb3.toString());
            return dir.getPath() + '/' + category;
        }

        public final String getPolicyVersion(Context context, String category) {
            PolicyFileDataResultBean policyDataFromFileName;
            kotlin.jvm.internal.g.f(context, "context");
            kotlin.jvm.internal.g.f(category, "category");
            PolicyNewestPathResultBean policyNewestPathResultBeanIsNewestPolicyFileIsExists = isNewestPolicyFileIsExists(context, category);
            return (!policyNewestPathResultBeanIsNewestPolicyFileIsExists.isExists() || (policyDataFromFileName = getPolicyDataFromFileName(policyNewestPathResultBeanIsNewestPolicyFileIsExists.getNewestPolicyName())) == null) ? "" : com.stepos.core.ota.d.f(Long.valueOf(policyDataFromFileName.getVersion()).longValue(), "");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.stepos.policy.sdk.bean.PolicyNewestPathResultBean isNewestPolicyFileIsExists(android.content.Context r3, java.lang.String r4) {
            /*
                r2 = this;
                java.lang.String r0 = "context"
                kotlin.jvm.internal.g.f(r3, r0)
                java.lang.String r0 = "category"
                kotlin.jvm.internal.g.f(r4, r0)
                java.lang.String r2 = r2.getPolicyFolderCachePath(r3, r4)
                java.io.File r3 = new java.io.File
                r3.<init>(r2)
                java.io.File[] r2 = r3.listFiles()
                com.stepos.policy.sdk.bean.PolicyNewestPathResultBean r3 = new com.stepos.policy.sdk.bean.PolicyNewestPathResultBean
                r3.<init>()
                r4 = 0
                if (r2 == 0) goto L29
                int r0 = r2.length
                r1 = 1
                if (r0 != 0) goto L25
                r0 = r1
                goto L26
            L25:
                r0 = r4
            L26:
                if (r0 != 0) goto L29
                goto L2a
            L29:
                r1 = r4
            L2a:
                r3.setExists(r1)
                boolean r0 = r3.isExists()
                if (r0 == 0) goto L4f
                r0 = r2[r4]
                java.lang.String r0 = r0.getPath()
                java.lang.String r1 = "fileList[0].path"
                kotlin.jvm.internal.g.e(r0, r1)
                r3.setNewestPolicyPath(r0)
                r2 = r2[r4]
                java.lang.String r2 = r2.getName()
                java.lang.String r4 = "fileList[0].name"
                kotlin.jvm.internal.g.e(r2, r4)
                r3.setNewestPolicyName(r2)
            L4f:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.util.PolicySdkFileUtils.Companion.isNewestPolicyFileIsExists(android.content.Context, java.lang.String):com.stepos.policy.sdk.bean.PolicyNewestPathResultBean");
        }

        public final void newFile(File file) throws IOException {
            kotlin.jvm.internal.g.f(file, "file");
            File file2 = new File(file.getParent());
            if (file.exists() && file2.exists()) {
                return;
            }
            file2.mkdirs();
            try {
                file.createNewFile();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }

        public final String renameFile(File oldFile, File file) {
            kotlin.jvm.internal.g.f(oldFile, "oldFile");
            if (oldFile.exists()) {
                boolean zRenameTo = oldFile.renameTo(file);
                PolicySdkLogUtils.Companion.d("FileUtils", "renameFile = " + zRenameTo);
                if (zRenameTo) {
                    String path = file != null ? file.getPath() : null;
                    return path == null ? "" : path;
                }
            }
            return "";
        }

        public final String renameFileNameByMd5(String sourceFilePath) {
            kotlin.jvm.internal.g.f(sourceFilePath, "sourceFilePath");
            try {
                String fileMD5FromFile = getFileMD5FromFile(sourceFilePath);
                if (q.l0(sourceFilePath, fileMD5FromFile, false)) {
                    PolicySdkLogUtils.Companion.d("renameFileNameByMd5", "sourceFilePath contains md5 ".concat(sourceFilePath));
                    return sourceFilePath;
                }
                String mD5NewFileName = getMD5NewFileName(sourceFilePath, fileMD5FromFile);
                PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
                companion.d("renameFileNameByMd5", "1.getMd5FromFile finished newFileName " + mD5NewFileName);
                String strRenameFile = renameFile(new File(sourceFilePath), new File(mD5NewFileName));
                companion.d("renameFileNameByMd5", "2.rename finished newPath " + strRenameFile);
                return strRenameFile;
            } catch (Exception e10) {
                e10.printStackTrace();
                return "";
            }
        }

        public final boolean savePolicyByUrl(Context context, String category, String url, String name) throws IOException {
            kotlin.jvm.internal.g.f(context, "context");
            kotlin.jvm.internal.g.f(category, "category");
            kotlin.jvm.internal.g.f(url, "url");
            kotlin.jvm.internal.g.f(name, "name");
            boolean z = false;
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    if (PolicySdkNetworkGate.shouldBlock()) {
                        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
                        companion.d("FileUtils", "savePolicyByUrl blocked before agree");
                        companion.d("FileUtils", "isFinished = false");
                        return false;
                    }
                    PolicySdkLogUtils.Companion.d("FileUtils", "savePolicyByUrl: url = " + url + " | name = " + name + "  ");
                    File file = new File(getPolicyFolderCachePath(context, category), name);
                    File file2 = new File(file.getParent());
                    if (!file.exists() || !file2.exists()) {
                        file2.mkdirs();
                        try {
                            file.createNewFile();
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                    }
                    PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.Companion;
                    companion2.d("FileUtils", "savePolicyByUrl: create file  path = " + file.getPath());
                    companion2.d("FileUtils", "savePolicyByUrl: create file exists = " + file.exists());
                    InputStream inputStreamOpenStream = new URL(url).openStream();
                    kotlin.jvm.internal.g.e(inputStreamOpenStream, "URL(url).openStream()");
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file.getPath());
                    while (true) {
                        try {
                            int i10 = inputStreamOpenStream.read();
                            if (i10 == -1) {
                                z = true;
                                inputStreamOpenStream.close();
                                PolicySdkLogUtils.Companion companion3 = PolicySdkLogUtils.Companion;
                                companion3.d("FileUtils", "savePolicyByUrl: isFinished");
                                fileOutputStream2.close();
                                companion3.d("FileUtils", "isFinished = true");
                                return true;
                            }
                            fileOutputStream2.write(i10);
                        } catch (Exception e11) {
                            e = e11;
                            fileOutputStream = fileOutputStream2;
                            e.printStackTrace();
                            PolicySdkLogUtils.Companion companion4 = PolicySdkLogUtils.Companion;
                            companion4.e("FileUtils", "Exception = " + e.getMessage());
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            companion4.d("FileUtils", "isFinished = " + z);
                            return z;
                        } catch (Throwable unused) {
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            PolicySdkLogUtils.Companion.d("FileUtils", "isFinished = " + z);
                            return z;
                        }
                    }
                } catch (Throwable unused2) {
                }
            } catch (Exception e12) {
                e = e12;
            }
        }

        public final String syncLocalFile(Context context, String localPath, String category, String localMd5) {
            kotlin.jvm.internal.g.f(context, "context");
            kotlin.jvm.internal.g.f(localPath, "localPath");
            kotlin.jvm.internal.g.f(category, "category");
            kotlin.jvm.internal.g.f(localMd5, "localMd5");
            return copyAssetsFile(context, localPath, getPolicyFolderCachePath(context, category), localMd5);
        }

        private Companion() {
        }
    }
}
