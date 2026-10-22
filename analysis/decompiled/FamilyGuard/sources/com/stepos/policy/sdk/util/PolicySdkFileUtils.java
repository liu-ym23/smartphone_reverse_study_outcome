package com.stepos.policy.sdk.util;

import android.content.Context;
import com.stepos.minor.Minor;
import com.stepos.policy.sdk.bean.PolicyFileDataResultBean;
import com.stepos.policy.sdk.bean.PolicyNewestPathResultBean;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import j4.k;
import j4.y;
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
import org.libpag.BuildConfig;
import r4.C1031n;

/* loaded from: classes.dex */
public final class PolicySdkFileUtils {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(j4.g gVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x013a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final java.lang.String copyAssetsFile(android.content.Context r11, java.lang.String r12, java.lang.String r13, java.lang.String r14) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 318
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.util.PolicySdkFileUtils.Companion.copyAssetsFile(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
        }

        public final String copyPolicyFile(String str, String str2) throws IOException {
            k.g(str, "sourcePath");
            k.g(str2, "toPath");
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    File file = new File(str);
                    if (file.exists()) {
                        File file2 = new File(str2);
                        File file3 = new File(file2.getParent());
                        if (!file2.exists() || !file3.exists()) {
                            file3.mkdirs();
                            try {
                                file2.createNewFile();
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                        }
                        FileInputStream fileInputStream = new FileInputStream(file);
                        PolicySdkLogUtils.Companion.d("copyPolicyFile", "open assets success ");
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file2.getPath());
                        while (true) {
                            try {
                                try {
                                    int i5 = fileInputStream.read();
                                    if (i5 == -1) {
                                        break;
                                    }
                                    fileOutputStream2.write(i5);
                                } catch (Throwable unused) {
                                    str2 = BuildConfig.FLAVOR;
                                }
                            } catch (Exception e7) {
                                e = e7;
                                fileOutputStream = fileOutputStream2;
                                PolicySdkLogUtils.Companion.d("copyPolicyFile", "Exception " + e.getMessage());
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                return BuildConfig.FLAVOR;
                            }
                        }
                        fileInputStream.close();
                        try {
                            PolicySdkLogUtils.Companion.d("copyPolicyFile", "copy finished" + str2);
                            fileOutputStream = fileOutputStream2;
                        } catch (Throwable unused2) {
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            return str2;
                        }
                    } else {
                        str2 = BuildConfig.FLAVOR;
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return str2;
                } catch (Throwable unused3) {
                    str2 = BuildConfig.FLAVOR;
                }
            } catch (Exception e8) {
                e = e8;
            }
        }

        public final void deleteFile(String str) {
            k.g(str, "oldPolicyPath");
            new File(str).delete();
        }

        public final String getFileMD5(Context context, String str) throws IOException {
            k.g(context, "context");
            k.g(str, "fileName");
            InputStream inputStreamOpen = context.getAssets().open(str);
            k.f(inputStreamOpen, "context.assets.open(fileName)");
            return getFileMD5ByInputStream(inputStreamOpen);
        }

        public final String getFileMD5ByInputStream(InputStream inputStream) throws NoSuchAlgorithmException, IOException {
            int i5;
            k.g(inputStream, "inputStream");
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                byte[] bArr = new byte[1024];
                int i6 = inputStream.read(bArr);
                while (true) {
                    if (i6 == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, i6);
                    i6 = inputStream.read(bArr);
                }
                inputStream.close();
                byte[] bArrDigest = messageDigest.digest();
                StringBuilder sb = new StringBuilder();
                k.f(bArrDigest, "digest");
                for (byte b6 : bArrDigest) {
                    y yVar = y.f17839a;
                    String str = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(b6 & 255)}, 1));
                    k.f(str, "format(format, *args)");
                    sb.append(str);
                }
                String string = sb.toString();
                k.f(string, "sb.toString()");
                return string;
            } catch (Exception e6) {
                e6.printStackTrace();
                PolicySdkLogUtils.Companion.d("getFileMD5", "Exception " + e6.getMessage());
                return BuildConfig.FLAVOR;
            }
        }

        public final String getFileMD5FromFile(String str) {
            k.g(str, "fileName");
            return getFileMD5ByInputStream(new FileInputStream(new File(str)));
        }

        public final String getFileNameFromPolicyData(String str, int i5, String str2) {
            k.g(str, "category");
            k.g(str2, "policyMd5");
            if (k.b(str2, BuildConfig.FLAVOR)) {
                return str + '_' + i5 + ".html";
            }
            return str + '_' + i5 + '_' + str2 + ".html";
        }

        public final String getMD5NewFileName(String str, String str2) {
            String str3;
            String string;
            k.g(str, "sourceFileName");
            if (!k.b(str2, BuildConfig.FLAVOR)) {
                str3 = str;
                int iC = C1031n.C(str3, ".html", 0, false, 6, null);
                if (iC >= 0) {
                    StringBuilder sb = new StringBuilder();
                    String strSubstring = str3.substring(0, iC);
                    k.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    sb.append(strSubstring);
                    sb.append('_');
                    sb.append(str2);
                    String strSubstring2 = str3.substring(iC);
                    k.f(strSubstring2, "this as java.lang.String).substring(startIndex)");
                    sb.append(strSubstring2);
                    string = sb.toString();
                }
                PolicySdkLogUtils.Companion.d("getMD5NewFileName", "newSourceFileName " + string);
                return string;
            }
            str3 = str;
            string = str3;
            PolicySdkLogUtils.Companion.d("getMD5NewFileName", "newSourceFileName " + string);
            return string;
        }

        public final PolicyFileDataResultBean getPolicyDataFromFileName(String str) {
            k.g(str, "fileName");
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            companion.d("FileUtils", "getPolicyDataFromFileName start fileName" + str + ' ');
            PolicyFileDataResultBean policyFileDataResultBean = new PolicyFileDataResultBean();
            try {
                if (C1031n.u(str, "_", false, 2, null) && C1031n.u(str, ".html", false, 2, null)) {
                    String strO = C1031n.o(str, ".html", BuildConfig.FLAVOR, false, 4, null);
                    List listY = C1031n.Y(strO, new String[]{"_"}, false, 0, 6, null);
                    companion.d("FileUtils", "getPolicyDataFromFileName last mFileName =" + strO + ' ');
                    if (!listY.isEmpty() && listY.size() > 1) {
                        policyFileDataResultBean.setCategory((String) listY.get(0));
                        policyFileDataResultBean.setVersion(Long.parseLong((String) listY.get(1)));
                        if (listY.size() > 2) {
                            policyFileDataResultBean.setMd5((String) listY.get(listY.size() - 1));
                        } else {
                            policyFileDataResultBean.setMd5(BuildConfig.FLAVOR);
                        }
                    }
                }
            } catch (Exception e6) {
                PolicySdkLogUtils.Companion.e("FileUtils", "Exception" + e6.getMessage() + ' ');
            }
            PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.Companion;
            companion2.d("FileUtils", "policyFileDataResultBean  " + policyFileDataResultBean + ' ');
            companion2.d("FileUtils", "ResultBean version  " + policyFileDataResultBean.getVersion() + ' ');
            return policyFileDataResultBean;
        }

        public final String getPolicyFolder(Context context) {
            k.g(context, "context");
            return context.getDir(PolicySdkConstants.policyFileDir, 0).getPath() + '/';
        }

        public final String getPolicyFolderCachePath(Context context, String str) {
            k.g(context, "context");
            k.g(str, "category");
            File dir = context.getDir(PolicySdkConstants.policyFileDir, 0);
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            StringBuilder sb = new StringBuilder();
            sb.append("getPolicyFolderCachePath = ");
            sb.append(dir != null ? Boolean.valueOf(dir.exists()) : null);
            companion.d("FileUtils", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getPolicyFolderCachePath = ");
            sb2.append(dir != null ? dir.getPath() : null);
            companion.d("FileUtils", sb2.toString());
            return dir.getPath() + '/' + str;
        }

        public final String getPolicyVersion(Context context, String str) {
            PolicyFileDataResultBean policyDataFromFileName;
            k.g(context, "context");
            k.g(str, "category");
            PolicyNewestPathResultBean policyNewestPathResultBeanIsNewestPolicyFileIsExists = isNewestPolicyFileIsExists(context, str);
            if (!policyNewestPathResultBeanIsNewestPolicyFileIsExists.isExists() || (policyDataFromFileName = getPolicyDataFromFileName(policyNewestPathResultBeanIsNewestPolicyFileIsExists.getNewestPolicyName())) == null) {
                return BuildConfig.FLAVOR;
            }
            return BuildConfig.FLAVOR + Long.valueOf(policyDataFromFileName.getVersion()).longValue();
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
                j4.k.g(r3, r0)
                java.lang.String r0 = "category"
                j4.k.g(r4, r0)
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
                j4.k.f(r0, r1)
                r3.setNewestPolicyPath(r0)
                r2 = r2[r4]
                java.lang.String r2 = r2.getName()
                java.lang.String r4 = "fileList[0].name"
                j4.k.f(r2, r4)
                r3.setNewestPolicyName(r2)
            L4f:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.util.PolicySdkFileUtils.Companion.isNewestPolicyFileIsExists(android.content.Context, java.lang.String):com.stepos.policy.sdk.bean.PolicyNewestPathResultBean");
        }

        public final void newFile(File file) throws IOException {
            k.g(file, "file");
            File file2 = new File(file.getParent());
            if (file.exists() && file2.exists()) {
                return;
            }
            file2.mkdirs();
            try {
                file.createNewFile();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }

        public final String renameFile(File file, File file2) {
            k.g(file, "oldFile");
            if (file.exists()) {
                boolean zRenameTo = file.renameTo(file2);
                PolicySdkLogUtils.Companion.d("FileUtils", "renameFile = " + zRenameTo);
                if (zRenameTo) {
                    String path = file2 != null ? file2.getPath() : null;
                    return path == null ? BuildConfig.FLAVOR : path;
                }
            }
            return BuildConfig.FLAVOR;
        }

        public final String renameFileNameByMd5(String str) {
            k.g(str, "sourceFilePath");
            try {
                String fileMD5FromFile = getFileMD5FromFile(str);
                if (C1031n.u(str, fileMD5FromFile, false, 2, null)) {
                    PolicySdkLogUtils.Companion.d("renameFileNameByMd5", "sourceFilePath contains md5 " + str);
                    return str;
                }
                String mD5NewFileName = getMD5NewFileName(str, fileMD5FromFile);
                PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
                companion.d("renameFileNameByMd5", "1.getMd5FromFile finished newFileName " + mD5NewFileName);
                String strRenameFile = renameFile(new File(str), new File(mD5NewFileName));
                companion.d("renameFileNameByMd5", "2.rename finished newPath " + strRenameFile);
                return strRenameFile;
            } catch (Exception e6) {
                e6.printStackTrace();
                return BuildConfig.FLAVOR;
            }
        }

        public final boolean savePolicyByUrl(Context context, String str, String str2, String str3) throws IOException {
            k.g(context, "context");
            k.g(str, "category");
            k.g(str2, "url");
            k.g(str3, Minor.COLUMN_NAME);
            boolean z5 = false;
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    if (PolicySdkNetworkGate.shouldBlock()) {
                        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
                        companion.d("FileUtils", "savePolicyByUrl blocked before agree");
                        companion.d("FileUtils", "isFinished = false");
                        return false;
                    }
                    PolicySdkLogUtils.Companion.d("FileUtils", "savePolicyByUrl: url = " + str2 + " | name = " + str3 + "  ");
                    File file = new File(getPolicyFolderCachePath(context, str), str3);
                    File file2 = new File(file.getParent());
                    if (!file.exists() || !file2.exists()) {
                        file2.mkdirs();
                        try {
                            file.createNewFile();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                    PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.Companion;
                    companion2.d("FileUtils", "savePolicyByUrl: create file  path = " + file.getPath());
                    companion2.d("FileUtils", "savePolicyByUrl: create file exists = " + file.exists());
                    InputStream inputStreamOpenStream = new URL(str2).openStream();
                    k.f(inputStreamOpenStream, "URL(url).openStream()");
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file.getPath());
                    while (true) {
                        try {
                            int i5 = inputStreamOpenStream.read();
                            if (i5 == -1) {
                                z5 = true;
                                inputStreamOpenStream.close();
                                PolicySdkLogUtils.Companion companion3 = PolicySdkLogUtils.Companion;
                                companion3.d("FileUtils", "savePolicyByUrl: isFinished");
                                fileOutputStream2.close();
                                companion3.d("FileUtils", "isFinished = true");
                                return true;
                            }
                            fileOutputStream2.write(i5);
                        } catch (Exception e7) {
                            e = e7;
                            fileOutputStream = fileOutputStream2;
                            e.printStackTrace();
                            PolicySdkLogUtils.Companion companion4 = PolicySdkLogUtils.Companion;
                            companion4.e("FileUtils", "Exception = " + e.getMessage());
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            companion4.d("FileUtils", "isFinished = " + z5);
                            return z5;
                        } catch (Throwable unused) {
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            PolicySdkLogUtils.Companion.d("FileUtils", "isFinished = " + z5);
                            return z5;
                        }
                    }
                } catch (Exception e8) {
                    e = e8;
                }
            } catch (Throwable unused2) {
            }
        }

        public final String syncLocalFile(Context context, String str, String str2, String str3) {
            k.g(context, "context");
            k.g(str, "localPath");
            k.g(str2, "category");
            k.g(str3, "localMd5");
            return copyAssetsFile(context, str, getPolicyFolderCachePath(context, str2), str3);
        }

        private Companion() {
        }
    }
}
