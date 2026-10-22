package com.stepos.policy.sdk.util;

import android.content.Context;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.policy.sdk.bean.PolicyFileDataResultBean;
import com.stepos.policy.sdk.bean.PolicyNewestPathResultBean;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import hc.h;
import hc.o;
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
import yb.f;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicySdkFileUtils {
    public static final Companion Companion = new Companion(null);

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x0114  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final java.lang.String copyAssetsFile(android.content.Context r10, java.lang.String r11, java.lang.String r12, java.lang.String r13) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 280
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.util.PolicySdkFileUtils.Companion.copyAssetsFile(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
        }

        public final String copyPolicyFile(String str, String str2) throws IOException {
            str.getClass();
            str2.getClass();
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
                                    int i = fileInputStream.read();
                                    if (i == -1) {
                                        break;
                                    }
                                    fileOutputStream2.write(i);
                                } catch (Throwable unused) {
                                    str2 = "";
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
                        str2 = "";
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return str2;
                } catch (Throwable unused3) {
                    str2 = "";
                }
            } catch (Exception e12) {
                e = e12;
            }
        }

        public final void deleteFile(String str) {
            str.getClass();
            new File(str).delete();
        }

        public final String getFileMD5(Context context, String str) {
            context.getClass();
            str.getClass();
            InputStream inputStreamOpen = context.getAssets().open(str);
            inputStreamOpen.getClass();
            return getFileMD5ByInputStream(inputStreamOpen);
        }

        public final String getFileMD5ByInputStream(InputStream inputStream) throws NoSuchAlgorithmException, IOException {
            int i;
            inputStream.getClass();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                byte[] bArr = new byte[1024];
                int i3 = inputStream.read(bArr);
                while (true) {
                    if (i3 == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, i3);
                    i3 = inputStream.read(bArr);
                }
                inputStream.close();
                byte[] bArrDigest = messageDigest.digest();
                StringBuilder sb2 = new StringBuilder();
                bArrDigest.getClass();
                for (byte b10 : bArrDigest) {
                    sb2.append(String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(b10 & 255)}, 1)));
                }
                return sb2.toString();
            } catch (Exception e10) {
                e10.printStackTrace();
                PolicySdkLogUtils.Companion.d("getFileMD5", "Exception " + e10.getMessage());
                return "";
            }
        }

        public final String getFileMD5FromFile(String str) {
            str.getClass();
            return getFileMD5ByInputStream(new FileInputStream(new File(str)));
        }

        public final String getFileNameFromPolicyData(String str, int i, String str2) {
            str.getClass();
            str2.getClass();
            if (str2.equals("")) {
                return str + '_' + i + ".html";
            }
            return str + '_' + i + '_' + str2 + ".html";
        }

        public final String getMD5NewFileName(String str, String str2) {
            int iE0;
            str.getClass();
            if (!k.a(str2, "") && (iE0 = h.e0(str, ".html", 0, false, 6)) >= 0) {
                str = str.substring(0, iE0) + '_' + str2 + str.substring(iE0);
            }
            PolicySdkLogUtils.Companion.d("getMD5NewFileName", "newSourceFileName ".concat(str));
            return str;
        }

        public final PolicyFileDataResultBean getPolicyDataFromFileName(String str) {
            str.getClass();
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            companion.d("FileUtils", "getPolicyDataFromFileName start fileName" + str + ' ');
            PolicyFileDataResultBean policyFileDataResultBean = new PolicyFileDataResultBean();
            try {
                if (h.X(str, "_", false) && h.X(str, ".html", false)) {
                    String strS = o.S(str, ".html", "");
                    List listO0 = h.o0(strS, new String[]{"_"});
                    companion.d("FileUtils", "getPolicyDataFromFileName last mFileName =" + strS + ' ');
                    if (!listO0.isEmpty() && listO0.size() > 1) {
                        policyFileDataResultBean.setCategory((String) listO0.get(0));
                        policyFileDataResultBean.setVersion(Long.parseLong((String) listO0.get(1)));
                        if (listO0.size() > 2) {
                            policyFileDataResultBean.setMd5((String) listO0.get(listO0.size() - 1));
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
            context.getClass();
            return context.getDir(PolicySdkConstants.policyFileDir, 0).getPath() + JsonPointer.SEPARATOR;
        }

        public final String getPolicyFolderCachePath(Context context, String str) {
            context.getClass();
            str.getClass();
            File dir = context.getDir(PolicySdkConstants.policyFileDir, 0);
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            StringBuilder sb2 = new StringBuilder("getPolicyFolderCachePath = ");
            sb2.append(dir != null ? Boolean.valueOf(dir.exists()) : null);
            companion.d("FileUtils", sb2.toString());
            StringBuilder sb3 = new StringBuilder("getPolicyFolderCachePath = ");
            sb3.append(dir != null ? dir.getPath() : null);
            companion.d("FileUtils", sb3.toString());
            return dir.getPath() + JsonPointer.SEPARATOR + str;
        }

        public final String getPolicyVersion(Context context, String str) {
            PolicyFileDataResultBean policyDataFromFileName;
            context.getClass();
            str.getClass();
            PolicyNewestPathResultBean policyNewestPathResultBeanIsNewestPolicyFileIsExists = isNewestPolicyFileIsExists(context, str);
            return (!policyNewestPathResultBeanIsNewestPolicyFileIsExists.isExists() || (policyDataFromFileName = getPolicyDataFromFileName(policyNewestPathResultBeanIsNewestPolicyFileIsExists.getNewestPolicyName())) == null) ? "" : k0.a.m("", Long.valueOf(policyDataFromFileName.getVersion()).longValue());
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.stepos.policy.sdk.bean.PolicyNewestPathResultBean isNewestPolicyFileIsExists(android.content.Context r3, java.lang.String r4) {
            /*
                r2 = this;
                r3.getClass()
                r4.getClass()
                java.lang.String r2 = r2.getPolicyFolderCachePath(r3, r4)
                java.io.File r3 = new java.io.File
                r3.<init>(r2)
                java.io.File[] r2 = r3.listFiles()
                com.stepos.policy.sdk.bean.PolicyNewestPathResultBean r3 = new com.stepos.policy.sdk.bean.PolicyNewestPathResultBean
                r3.<init>()
                r4 = 0
                if (r2 == 0) goto L25
                int r0 = r2.length
                r1 = 1
                if (r0 != 0) goto L21
                r0 = r1
                goto L22
            L21:
                r0 = r4
            L22:
                if (r0 != 0) goto L25
                goto L26
            L25:
                r1 = r4
            L26:
                r3.setExists(r1)
                boolean r0 = r3.isExists()
                if (r0 == 0) goto L47
                r0 = r2[r4]
                java.lang.String r0 = r0.getPath()
                r0.getClass()
                r3.setNewestPolicyPath(r0)
                r2 = r2[r4]
                java.lang.String r2 = r2.getName()
                r2.getClass()
                r3.setNewestPolicyName(r2)
            L47:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.util.PolicySdkFileUtils.Companion.isNewestPolicyFileIsExists(android.content.Context, java.lang.String):com.stepos.policy.sdk.bean.PolicyNewestPathResultBean");
        }

        public final void newFile(File file) throws IOException {
            file.getClass();
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

        public final String renameFile(File file, File file2) {
            file.getClass();
            if (file.exists()) {
                boolean zRenameTo = file.renameTo(file2);
                PolicySdkLogUtils.Companion.d("FileUtils", "renameFile = " + zRenameTo);
                if (zRenameTo) {
                    String path = file2 != null ? file2.getPath() : null;
                    return path == null ? "" : path;
                }
            }
            return "";
        }

        public final String renameFileNameByMd5(String str) {
            str.getClass();
            try {
                String fileMD5FromFile = getFileMD5FromFile(str);
                if (h.X(str, fileMD5FromFile, false)) {
                    PolicySdkLogUtils.Companion.d("renameFileNameByMd5", "sourceFilePath contains md5 ".concat(str));
                    return str;
                }
                String mD5NewFileName = getMD5NewFileName(str, fileMD5FromFile);
                PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
                companion.d("renameFileNameByMd5", "1.getMd5FromFile finished newFileName " + mD5NewFileName);
                String strRenameFile = renameFile(new File(str), new File(mD5NewFileName));
                companion.d("renameFileNameByMd5", "2.rename finished newPath " + strRenameFile);
                return strRenameFile;
            } catch (Exception e10) {
                e10.printStackTrace();
                return "";
            }
        }

        public final boolean savePolicyByUrl(Context context, String str, String str2, String str3) throws IOException {
            context.getClass();
            str.getClass();
            str2.getClass();
            str3.getClass();
            boolean z10 = false;
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    PolicySdkLogUtils.Companion.d("FileUtils", "savePolicyByUrl: url = " + str2 + " | name = " + str3 + "  ");
                    File file = new File(getPolicyFolderCachePath(context, str), str3);
                    File file2 = new File(file.getParent());
                    if (!file.exists() || !file2.exists()) {
                        file2.mkdirs();
                        try {
                            file.createNewFile();
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                    }
                    PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
                    companion.d("FileUtils", "savePolicyByUrl: create file  path = " + file.getPath());
                    companion.d("FileUtils", "savePolicyByUrl: create file exists = " + file.exists());
                    InputStream inputStreamOpenStream = new URL(str2).openStream();
                    inputStreamOpenStream.getClass();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file.getPath());
                    while (true) {
                        try {
                            int i = inputStreamOpenStream.read();
                            if (i == -1) {
                                z10 = true;
                                inputStreamOpenStream.close();
                                PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.Companion;
                                companion2.d("FileUtils", "savePolicyByUrl: isFinished");
                                fileOutputStream2.close();
                                companion2.d("FileUtils", "isFinished = true");
                                return true;
                            }
                            fileOutputStream2.write(i);
                        } catch (Exception e11) {
                            e = e11;
                            fileOutputStream = fileOutputStream2;
                            e.printStackTrace();
                            PolicySdkLogUtils.Companion companion3 = PolicySdkLogUtils.Companion;
                            companion3.e("FileUtils", "Exception = " + e.getMessage());
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            companion3.d("FileUtils", "isFinished = " + z10);
                            return z10;
                        } catch (Throwable unused) {
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            PolicySdkLogUtils.Companion.d("FileUtils", "isFinished = " + z10);
                            return z10;
                        }
                    }
                } catch (Throwable unused2) {
                }
            } catch (Exception e12) {
                e = e12;
            }
        }

        public final String syncLocalFile(Context context, String str, String str2, String str3) {
            context.getClass();
            str.getClass();
            str2.getClass();
            str3.getClass();
            return copyAssetsFile(context, str, getPolicyFolderCachePath(context, str2), str3);
        }

        private Companion() {
        }
    }
}
