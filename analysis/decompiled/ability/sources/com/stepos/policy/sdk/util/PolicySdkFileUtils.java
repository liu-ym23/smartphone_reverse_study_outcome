package com.stepos.policy.sdk.util;

import android.content.Context;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.policy.sdk.bean.PolicyFileDataResultBean;
import com.stepos.policy.sdk.bean.PolicyNewestPathResultBean;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import j9.m;
import j9.t;
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
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicySdkFileUtils;", "", "()V", "Companion", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PolicySdkFileUtils {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u000bJ\u001f\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0016\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u001bJ\u001d\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u001d\u0010%\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b%\u0010&J\u0015\u0010'\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b'\u0010(J\u001d\u0010)\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b)\u0010\u001eJ\u0015\u0010+\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u0006¢\u0006\u0004\b+\u0010,J\u001d\u0010.\u001a\u00020-2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u0004\u0018\u0001002\u0006\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b1\u00102J\u001d\u00103\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b3\u0010\u001eJ%\u00107\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u00020\u0006¢\u0006\u0004\b7\u00108J\u001f\u0010;\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u00062\b\u0010:\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b;\u0010&J\u0015\u0010=\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u0006¢\u0006\u0004\b=\u0010 ¨\u0006>"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicySdkFileUtils$Companion;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "", "sourcePath", "toPath", "localMd5", "copyAssetsFile", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", QueryAlgorithmBundle.KEY_CATEGORY, BffConstant.Type.Url, HintConstants.AUTOFILL_HINT_NAME, "", "savePolicyByUrl", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "localPath", "syncLocalFile", "Ljava/io/File;", "oldFile", "newFile", "renameFile", "(Ljava/io/File;Ljava/io/File;)Ljava/lang/String;", BffConstant.Type.File, "LC7/r;", "(Ljava/io/File;)V", "fileName", "getFileMD5", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "getFileMD5FromFile", "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/io/InputStream;", "inputStream", "getFileMD5ByInputStream", "(Ljava/io/InputStream;)Ljava/lang/String;", "copyPolicyFile", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "getPolicyFolder", "(Landroid/content/Context;)Ljava/lang/String;", "getPolicyFolderCachePath", "oldPolicyPath", "deleteFile", "(Ljava/lang/String;)V", "Lcom/stepos/policy/sdk/bean/PolicyNewestPathResultBean;", "isNewestPolicyFileIsExists", "(Landroid/content/Context;Ljava/lang/String;)Lcom/stepos/policy/sdk/bean/PolicyNewestPathResultBean;", "Lcom/stepos/policy/sdk/bean/PolicyFileDataResultBean;", "getPolicyDataFromFileName", "(Ljava/lang/String;)Lcom/stepos/policy/sdk/bean/PolicyFileDataResultBean;", "getPolicyVersion", "", "version", "policyMd5", "getFileNameFromPolicyData", "(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;", "sourceFileName", "md5", "getMD5NewFileName", "sourceFilePath", "renameFileNameByMd5", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
            k.f(sourcePath, "sourcePath");
            k.f(toPath, "toPath");
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
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        FileInputStream fileInputStream = new FileInputStream(file);
                        PolicySdkLogUtils.INSTANCE.d("copyPolicyFile", "open assets success ");
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
                                    toPath = "";
                                }
                            } catch (Exception e6) {
                                e = e6;
                                fileOutputStream = fileOutputStream2;
                                PolicySdkLogUtils.INSTANCE.d("copyPolicyFile", "Exception " + e.getMessage());
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                return "";
                            }
                        }
                        fileInputStream.close();
                        try {
                            PolicySdkLogUtils.INSTANCE.d("copyPolicyFile", "copy finished" + toPath);
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
            } catch (Exception e9) {
                e = e9;
            }
        }

        public final void deleteFile(String oldPolicyPath) {
            k.f(oldPolicyPath, "oldPolicyPath");
            new File(oldPolicyPath).delete();
        }

        public final String getFileMD5(Context context, String fileName) {
            k.f(context, "context");
            k.f(fileName, "fileName");
            InputStream inputStreamOpen = context.getAssets().open(fileName);
            k.e(inputStreamOpen, "context.assets.open(fileName)");
            return getFileMD5ByInputStream(inputStreamOpen);
        }

        public final String getFileMD5ByInputStream(InputStream inputStream) throws NoSuchAlgorithmException, IOException {
            int i;
            k.f(inputStream, "inputStream");
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
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder();
                k.e(digest, "digest");
                for (byte b : digest) {
                    sb.append(String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(b & 255)}, 1)));
                }
                String string = sb.toString();
                k.e(string, "sb.toString()");
                return string;
            } catch (Exception e) {
                e.printStackTrace();
                PolicySdkLogUtils.INSTANCE.d("getFileMD5", "Exception " + e.getMessage());
                return "";
            }
        }

        public final String getFileMD5FromFile(String fileName) {
            k.f(fileName, "fileName");
            return getFileMD5ByInputStream(new FileInputStream(new File(fileName)));
        }

        public final String getFileNameFromPolicyData(String category, int version, String policyMd5) {
            k.f(category, "category");
            k.f(policyMd5, "policyMd5");
            if (policyMd5.equals("")) {
                return category + '_' + version + ".html";
            }
            return category + '_' + version + '_' + policyMd5 + ".html";
        }

        public final String getMD5NewFileName(String sourceFileName, String md5) {
            int iQ0;
            k.f(sourceFileName, "sourceFileName");
            if (!k.b(md5, "") && (iQ0 = m.q0(sourceFileName, ".html", 0, false, 6)) >= 0) {
                StringBuilder sb = new StringBuilder();
                String strSubstring = sourceFileName.substring(0, iQ0);
                k.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                sb.append(strSubstring);
                sb.append('_');
                sb.append(md5);
                String strSubstring2 = sourceFileName.substring(iQ0);
                k.e(strSubstring2, "this as java.lang.String).substring(startIndex)");
                sb.append(strSubstring2);
                sourceFileName = sb.toString();
            }
            PolicySdkLogUtils.INSTANCE.d("getMD5NewFileName", "newSourceFileName " + sourceFileName);
            return sourceFileName;
        }

        public final PolicyFileDataResultBean getPolicyDataFromFileName(String fileName) {
            k.f(fileName, "fileName");
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
            companion.d("FileUtils", "getPolicyDataFromFileName start fileName" + fileName + ' ');
            PolicyFileDataResultBean policyFileDataResultBean = new PolicyFileDataResultBean();
            try {
                if (m.h0(fileName, "_", false) && m.h0(fileName, ".html", false)) {
                    String strC0 = t.c0(fileName, ".html", "");
                    List listD0 = m.D0(strC0, new String[]{"_"}, 6);
                    companion.d("FileUtils", "getPolicyDataFromFileName last mFileName =" + strC0 + ' ');
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
            } catch (Exception e) {
                PolicySdkLogUtils.INSTANCE.e("FileUtils", "Exception" + e.getMessage() + ' ');
            }
            PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.INSTANCE;
            companion2.d("FileUtils", "policyFileDataResultBean  " + policyFileDataResultBean + ' ');
            companion2.d("FileUtils", "ResultBean version  " + policyFileDataResultBean.getVersion() + ' ');
            return policyFileDataResultBean;
        }

        public final String getPolicyFolder(Context context) {
            k.f(context, "context");
            return context.getDir(PolicySdkConstants.policyFileDir, 0).getPath() + JsonPointer.SEPARATOR;
        }

        public final String getPolicyFolderCachePath(Context context, String category) {
            k.f(context, "context");
            k.f(category, "category");
            File dir = context.getDir(PolicySdkConstants.policyFileDir, 0);
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
            StringBuilder sb = new StringBuilder("getPolicyFolderCachePath = ");
            sb.append(dir != null ? Boolean.valueOf(dir.exists()) : null);
            companion.d("FileUtils", sb.toString());
            StringBuilder sb2 = new StringBuilder("getPolicyFolderCachePath = ");
            sb2.append(dir != null ? dir.getPath() : null);
            companion.d("FileUtils", sb2.toString());
            return dir.getPath() + JsonPointer.SEPARATOR + category;
        }

        public final String getPolicyVersion(Context context, String category) {
            PolicyFileDataResultBean policyDataFromFileName;
            k.f(context, "context");
            k.f(category, "category");
            PolicyNewestPathResultBean policyNewestPathResultBeanIsNewestPolicyFileIsExists = isNewestPolicyFileIsExists(context, category);
            return (!policyNewestPathResultBeanIsNewestPolicyFileIsExists.getIsExists() || (policyDataFromFileName = getPolicyDataFromFileName(policyNewestPathResultBeanIsNewestPolicyFileIsExists.getNewestPolicyName())) == null) ? "" : androidx.compose.foundation.b.p(Long.valueOf(policyDataFromFileName.getVersion()).longValue(), "");
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
                kotlin.jvm.internal.k.f(r3, r0)
                java.lang.String r0 = "category"
                kotlin.jvm.internal.k.f(r4, r0)
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
                boolean r0 = r3.getIsExists()
                if (r0 == 0) goto L4f
                r0 = r2[r4]
                java.lang.String r0 = r0.getPath()
                java.lang.String r1 = "fileList[0].path"
                kotlin.jvm.internal.k.e(r0, r1)
                r3.setNewestPolicyPath(r0)
                r2 = r2[r4]
                java.lang.String r2 = r2.getName()
                java.lang.String r4 = "fileList[0].name"
                kotlin.jvm.internal.k.e(r2, r4)
                r3.setNewestPolicyName(r2)
            L4f:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.util.PolicySdkFileUtils.Companion.isNewestPolicyFileIsExists(android.content.Context, java.lang.String):com.stepos.policy.sdk.bean.PolicyNewestPathResultBean");
        }

        public final void newFile(File file) throws IOException {
            k.f(file, "file");
            File file2 = new File(file.getParent());
            if (file.exists() && file2.exists()) {
                return;
            }
            file2.mkdirs();
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public final String renameFile(File oldFile, File newFile) {
            k.f(oldFile, "oldFile");
            if (oldFile.exists()) {
                boolean zRenameTo = oldFile.renameTo(newFile);
                PolicySdkLogUtils.INSTANCE.d("FileUtils", "renameFile = " + zRenameTo);
                if (zRenameTo) {
                    String path = newFile != null ? newFile.getPath() : null;
                    return path == null ? "" : path;
                }
            }
            return "";
        }

        public final String renameFileNameByMd5(String sourceFilePath) {
            k.f(sourceFilePath, "sourceFilePath");
            try {
                String fileMD5FromFile = getFileMD5FromFile(sourceFilePath);
                if (m.h0(sourceFilePath, fileMD5FromFile, false)) {
                    PolicySdkLogUtils.INSTANCE.d("renameFileNameByMd5", "sourceFilePath contains md5 ".concat(sourceFilePath));
                    return sourceFilePath;
                }
                String mD5NewFileName = getMD5NewFileName(sourceFilePath, fileMD5FromFile);
                PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
                companion.d("renameFileNameByMd5", "1.getMd5FromFile finished newFileName " + mD5NewFileName);
                String strRenameFile = renameFile(new File(sourceFilePath), new File(mD5NewFileName));
                companion.d("renameFileNameByMd5", "2.rename finished newPath " + strRenameFile);
                return strRenameFile;
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }

        public final boolean savePolicyByUrl(Context context, String category, String url, String name) throws IOException {
            k.f(context, "context");
            k.f(category, "category");
            k.f(url, "url");
            k.f(name, "name");
            boolean z10 = false;
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    if (PolicySdkNetworkGate.shouldBlock()) {
                        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
                        companion.d("FileUtils", "savePolicyByUrl blocked before agree");
                        companion.d("FileUtils", "isFinished = false");
                        return false;
                    }
                    PolicySdkLogUtils.INSTANCE.d("FileUtils", "savePolicyByUrl: url = " + url + " | name = " + name + "  ");
                    File file = new File(getPolicyFolderCachePath(context, category), name);
                    File file2 = new File(file.getParent());
                    if (!file.exists() || !file2.exists()) {
                        file2.mkdirs();
                        try {
                            file.createNewFile();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.INSTANCE;
                    companion2.d("FileUtils", "savePolicyByUrl: create file  path = " + file.getPath());
                    companion2.d("FileUtils", "savePolicyByUrl: create file exists = " + file.exists());
                    InputStream inputStreamOpenStream = new URL(url).openStream();
                    k.e(inputStreamOpenStream, "URL(url).openStream()");
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file.getPath());
                    while (true) {
                        try {
                            int i = inputStreamOpenStream.read();
                            if (i == -1) {
                                z10 = true;
                                inputStreamOpenStream.close();
                                PolicySdkLogUtils.Companion companion3 = PolicySdkLogUtils.INSTANCE;
                                companion3.d("FileUtils", "savePolicyByUrl: isFinished");
                                fileOutputStream2.close();
                                companion3.d("FileUtils", "isFinished = true");
                                return true;
                            }
                            fileOutputStream2.write(i);
                        } catch (Exception e6) {
                            e = e6;
                            fileOutputStream = fileOutputStream2;
                            e.printStackTrace();
                            PolicySdkLogUtils.Companion companion4 = PolicySdkLogUtils.INSTANCE;
                            companion4.e("FileUtils", "Exception = " + e.getMessage());
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            companion4.d("FileUtils", "isFinished = " + z10);
                            return z10;
                        } catch (Throwable unused) {
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            PolicySdkLogUtils.INSTANCE.d("FileUtils", "isFinished = " + z10);
                            return z10;
                        }
                    }
                } catch (Throwable unused2) {
                }
            } catch (Exception e9) {
                e = e9;
            }
        }

        public final String syncLocalFile(Context context, String localPath, String category, String localMd5) {
            k.f(context, "context");
            k.f(localPath, "localPath");
            k.f(category, "category");
            k.f(localMd5, "localMd5");
            return copyAssetsFile(context, localPath, getPolicyFolderCachePath(context, category), localMd5);
        }

        private Companion() {
        }
    }
}
