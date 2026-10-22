package com.stepos.policy.sdk.util;

import android.content.Context;
import androidx.room.AbstractC0351g;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.joran.action.Action;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.stepos.activeview.utils.Constants;
import com.stepos.policy.sdk.bean.PolicyFileDataResultBean;
import com.stepos.policy.sdk.bean.PolicyNewestPathResultBean;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
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
import kotlin.UByte;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicySdkFileUtils;", "", "()V", "Companion", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PolicySdkFileUtils {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J\u001e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0004J\u0016\u0010 \u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0004J\u0016\u0010!\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020%J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020%2\b\u0010#\u001a\u0004\u0018\u00010%J\u000e\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0004J&\u0010*\u001a\u00020+2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0004J&\u0010.\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¨\u00060"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicySdkFileUtils$Companion;", "", "()V", "copyAssetsFile", "", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "sourcePath", "toPath", "localMd5", "copyPolicyFile", "deleteFile", "", "oldPolicyPath", "getFileMD5", "fileName", "getFileMD5ByInputStream", "inputStream", "Ljava/io/InputStream;", "getFileMD5FromFile", "getFileNameFromPolicyData", "category", Constants.JSON_KEY_VERSION, "", "policyMd5", "getMD5NewFileName", "sourceFileName", "md5", "getPolicyDataFromFileName", "Lcom/stepos/policy/sdk/bean/PolicyFileDataResultBean;", "getPolicyFolder", "getPolicyFolderCachePath", "getPolicyVersion", "isNewestPolicyFileIsExists", "Lcom/stepos/policy/sdk/bean/PolicyNewestPathResultBean;", "newFile", Action.FILE_ATTRIBUTE, "Ljava/io/File;", "renameFile", "oldFile", "renameFileNameByMd5", "sourceFilePath", "savePolicyByUrl", "", MapBundleKey.MapObjKey.OBJ_URL, "name", "syncLocalFile", "localPath", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nPolicySdkFileUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PolicySdkFileUtils.kt\ncom/stepos/policy/sdk/util/PolicySdkFileUtils$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,463:1\n1#2:464\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x0126  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final java.lang.String copyAssetsFile(android.content.Context r10, java.lang.String r11, java.lang.String r12, java.lang.String r13) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 298
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.util.PolicySdkFileUtils.Companion.copyAssetsFile(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
        }

        @NotNull
        public final String copyPolicyFile(@NotNull String sourcePath, @NotNull String toPath) throws IOException {
            Intrinsics.checkNotNullParameter(sourcePath, "sourcePath");
            Intrinsics.checkNotNullParameter(toPath, "toPath");
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
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                        FileInputStream fileInputStream = new FileInputStream(file);
                        PolicySdkLogUtils.INSTANCE.d("copyPolicyFile", "open assets success ");
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file2.getPath());
                        while (true) {
                            try {
                                try {
                                    int i4 = fileInputStream.read();
                                    if (i4 == -1) {
                                        break;
                                    }
                                    fileOutputStream2.write(i4);
                                } catch (Throwable unused) {
                                    toPath = "";
                                }
                            } catch (Exception e5) {
                                e = e5;
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
                } catch (Exception e6) {
                    e = e6;
                }
            } catch (Throwable unused3) {
                toPath = "";
            }
        }

        public final void deleteFile(@NotNull String oldPolicyPath) {
            Intrinsics.checkNotNullParameter(oldPolicyPath, "oldPolicyPath");
            new File(oldPolicyPath).delete();
        }

        @NotNull
        public final String getFileMD5(@NotNull Context context, @NotNull String fileName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            InputStream inputStreamOpen = context.getAssets().open(fileName);
            Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "context.assets.open(fileName)");
            return getFileMD5ByInputStream(inputStreamOpen);
        }

        @NotNull
        public final String getFileMD5ByInputStream(@NotNull InputStream inputStream) throws NoSuchAlgorithmException, IOException {
            Intrinsics.checkNotNullParameter(inputStream, "inputStream");
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                byte[] bArr = new byte[1024];
                while (true) {
                    int i4 = inputStream.read(bArr);
                    if (i4 == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, i4);
                }
                inputStream.close();
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder();
                Intrinsics.checkNotNullExpressionValue(digest, "digest");
                for (byte b4 : digest) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String str = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(b4 & UByte.MAX_VALUE)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                    sb.append(str);
                }
                String string = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
                return string;
            } catch (Exception e4) {
                e4.printStackTrace();
                PolicySdkLogUtils.INSTANCE.d("getFileMD5", "Exception " + e4.getMessage());
                return "";
            }
        }

        @NotNull
        public final String getFileMD5FromFile(@NotNull String fileName) {
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            return getFileMD5ByInputStream(new FileInputStream(new File(fileName)));
        }

        @NotNull
        public final String getFileNameFromPolicyData(@NotNull String category, int version, @NotNull String policyMd5) {
            StringBuilder sb;
            Intrinsics.checkNotNullParameter(category, "category");
            Intrinsics.checkNotNullParameter(policyMd5, "policyMd5");
            if (Intrinsics.areEqual(policyMd5, "")) {
                sb = new StringBuilder();
                sb.append(category);
                sb.append('_');
                sb.append(version);
            } else {
                sb = new StringBuilder();
                sb.append(category);
                sb.append('_');
                sb.append(version);
                sb.append('_');
                sb.append(policyMd5);
            }
            sb.append(".html");
            return sb.toString();
        }

        @NotNull
        public final String getMD5NewFileName(@NotNull String sourceFileName, @Nullable String md5) {
            int iIndexOf$default;
            Intrinsics.checkNotNullParameter(sourceFileName, "sourceFileName");
            if (!Intrinsics.areEqual(md5, "") && (iIndexOf$default = StringsKt__StringsKt.indexOf$default(sourceFileName, ".html", 0, false, 6, (Object) null)) >= 0) {
                StringBuilder sb = new StringBuilder();
                String strSubstring = sourceFileName.substring(0, iIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                sb.append(strSubstring);
                sb.append('_');
                sb.append(md5);
                String strSubstring2 = sourceFileName.substring(iIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
                sb.append(strSubstring2);
                sourceFileName = sb.toString();
            }
            PolicySdkLogUtils.INSTANCE.d("getMD5NewFileName", "newSourceFileName " + sourceFileName);
            return sourceFileName;
        }

        @Nullable
        public final PolicyFileDataResultBean getPolicyDataFromFileName(@NotNull String fileName) {
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
            companion.d("FileUtils", "getPolicyDataFromFileName start fileName" + fileName + ' ');
            PolicyFileDataResultBean policyFileDataResultBean = new PolicyFileDataResultBean();
            try {
                if (StringsKt.c(fileName, "_") && StringsKt.c(fileName, ".html")) {
                    String strS = StringsKt.s(fileName, ".html", "");
                    List listSplit$default = StringsKt__StringsKt.split$default(strS, new String[]{"_"}, false, 0, 6, (Object) null);
                    companion.d("FileUtils", "getPolicyDataFromFileName last mFileName =" + strS + ' ');
                    if ((!listSplit$default.isEmpty()) && listSplit$default.size() > 1) {
                        policyFileDataResultBean.setCategory((String) listSplit$default.get(0));
                        policyFileDataResultBean.setVersion(Long.parseLong((String) listSplit$default.get(1)));
                        policyFileDataResultBean.setMd5(listSplit$default.size() > 2 ? (String) listSplit$default.get(listSplit$default.size() - 1) : "");
                    }
                }
            } catch (Exception e4) {
                PolicySdkLogUtils.INSTANCE.e("FileUtils", "Exception" + e4.getMessage() + ' ');
            }
            PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.INSTANCE;
            companion2.d("FileUtils", "policyFileDataResultBean  " + policyFileDataResultBean + ' ');
            companion2.d("FileUtils", "ResultBean version  " + policyFileDataResultBean.getVersion() + ' ');
            return policyFileDataResultBean;
        }

        @NotNull
        public final String getPolicyFolder(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.getDir(PolicySdkConstants.policyFileDir, 0).getPath() + '/';
        }

        @NotNull
        public final String getPolicyFolderCachePath(@NotNull Context context, @NotNull String category) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(category, "category");
            File dir = context.getDir(PolicySdkConstants.policyFileDir, 0);
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
            StringBuilder sb = new StringBuilder("getPolicyFolderCachePath = ");
            sb.append(dir != null ? Boolean.valueOf(dir.exists()) : null);
            companion.d("FileUtils", sb.toString());
            StringBuilder sb2 = new StringBuilder("getPolicyFolderCachePath = ");
            sb2.append(dir != null ? dir.getPath() : null);
            companion.d("FileUtils", sb2.toString());
            return dir.getPath() + '/' + category;
        }

        @NotNull
        public final String getPolicyVersion(@NotNull Context context, @NotNull String category) {
            PolicyFileDataResultBean policyDataFromFileName;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(category, "category");
            PolicyNewestPathResultBean policyNewestPathResultBeanIsNewestPolicyFileIsExists = isNewestPolicyFileIsExists(context, category);
            return (!policyNewestPathResultBeanIsNewestPolicyFileIsExists.getIsExists() || (policyDataFromFileName = getPolicyDataFromFileName(policyNewestPathResultBeanIsNewestPolicyFileIsExists.getNewestPolicyName())) == null) ? "" : AbstractC0351g.n("", policyDataFromFileName.getVersion());
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002a  */
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.stepos.policy.sdk.bean.PolicyNewestPathResultBean isNewestPolicyFileIsExists(@org.jetbrains.annotations.NotNull android.content.Context r3, @org.jetbrains.annotations.NotNull java.lang.String r4) {
            /*
                r2 = this;
                java.lang.String r0 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                java.lang.String r0 = "category"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                java.lang.String r2 = r2.getPolicyFolderCachePath(r3, r4)
                java.io.File r3 = new java.io.File
                r3.<init>(r2)
                java.io.File[] r2 = r3.listFiles()
                com.stepos.policy.sdk.bean.PolicyNewestPathResultBean r3 = new com.stepos.policy.sdk.bean.PolicyNewestPathResultBean
                r3.<init>()
                r4 = 0
                if (r2 == 0) goto L2a
                int r0 = r2.length
                r1 = 1
                if (r0 != 0) goto L25
                r0 = r1
                goto L26
            L25:
                r0 = r4
            L26:
                r0 = r0 ^ r1
                if (r0 == 0) goto L2a
                goto L2b
            L2a:
                r1 = r4
            L2b:
                r3.setExists(r1)
                boolean r0 = r3.getIsExists()
                if (r0 == 0) goto L50
                r0 = r2[r4]
                java.lang.String r0 = r0.getPath()
                java.lang.String r1 = "fileList[0].path"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                r3.setNewestPolicyPath(r0)
                r2 = r2[r4]
                java.lang.String r2 = r2.getName()
                java.lang.String r4 = "fileList[0].name"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
                r3.setNewestPolicyName(r2)
            L50:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.util.PolicySdkFileUtils.Companion.isNewestPolicyFileIsExists(android.content.Context, java.lang.String):com.stepos.policy.sdk.bean.PolicyNewestPathResultBean");
        }

        public final void newFile(@NotNull File file) throws IOException {
            Intrinsics.checkNotNullParameter(file, "file");
            File file2 = new File(file.getParent());
            if (file.exists() && file2.exists()) {
                return;
            }
            file2.mkdirs();
            try {
                file.createNewFile();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }

        @NotNull
        public final String renameFile(@NotNull File oldFile, @Nullable File newFile) {
            Intrinsics.checkNotNullParameter(oldFile, "oldFile");
            if (!oldFile.exists()) {
                return "";
            }
            boolean zRenameTo = oldFile.renameTo(newFile);
            PolicySdkLogUtils.INSTANCE.d("FileUtils", "renameFile = " + zRenameTo);
            if (!zRenameTo) {
                return "";
            }
            String path = newFile != null ? newFile.getPath() : null;
            return path == null ? "" : path;
        }

        @NotNull
        public final String renameFileNameByMd5(@NotNull String sourceFilePath) {
            Intrinsics.checkNotNullParameter(sourceFilePath, "sourceFilePath");
            try {
                String fileMD5FromFile = getFileMD5FromFile(sourceFilePath);
                if (StringsKt.c(sourceFilePath, fileMD5FromFile)) {
                    PolicySdkLogUtils.INSTANCE.d("renameFileNameByMd5", "sourceFilePath contains md5 " + sourceFilePath);
                    return sourceFilePath;
                }
                String mD5NewFileName = getMD5NewFileName(sourceFilePath, fileMD5FromFile);
                PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
                companion.d("renameFileNameByMd5", "1.getMd5FromFile finished newFileName " + mD5NewFileName);
                String strRenameFile = renameFile(new File(sourceFilePath), new File(mD5NewFileName));
                companion.d("renameFileNameByMd5", "2.rename finished newPath " + strRenameFile);
                return strRenameFile;
            } catch (Exception e4) {
                e4.printStackTrace();
                return "";
            }
        }

        public final boolean savePolicyByUrl(@NotNull Context context, @NotNull String category, @NotNull String url, @NotNull String name) throws IOException {
            FileOutputStream fileOutputStream;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(category, "category");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(name, "name");
            boolean z4 = false;
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    PolicySdkLogUtils.INSTANCE.d("FileUtils", "savePolicyByUrl: url = " + url + " | name = " + name + "  ");
                    File file = new File(getPolicyFolderCachePath(context, category), name);
                    File file2 = new File(file.getParent());
                    if (!file.exists() || !file2.exists()) {
                        file2.mkdirs();
                        try {
                            file.createNewFile();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
                    companion.d("FileUtils", "savePolicyByUrl: create file  path = " + file.getPath());
                    companion.d("FileUtils", "savePolicyByUrl: create file exists = " + file.exists());
                    InputStream inputStreamOpenStream = new URL(url).openStream();
                    Intrinsics.checkNotNullExpressionValue(inputStreamOpenStream, "URL(url).openStream()");
                    fileOutputStream = new FileOutputStream(file.getPath());
                    while (true) {
                        try {
                            int i4 = inputStreamOpenStream.read();
                            if (i4 == -1) {
                                z4 = true;
                                inputStreamOpenStream.close();
                                PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.INSTANCE;
                                companion2.d("FileUtils", "savePolicyByUrl: isFinished");
                                fileOutputStream.close();
                                companion2.d("FileUtils", "isFinished = true");
                                return true;
                            }
                            fileOutputStream.write(i4);
                        } catch (Exception e5) {
                            e = e5;
                            fileOutputStream2 = fileOutputStream;
                            e.printStackTrace();
                            PolicySdkLogUtils.Companion companion3 = PolicySdkLogUtils.INSTANCE;
                            companion3.e("FileUtils", "Exception = " + e.getMessage());
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                            companion3.d("FileUtils", "isFinished = " + z4);
                            return z4;
                        } catch (Throwable unused) {
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            PolicySdkLogUtils.INSTANCE.d("FileUtils", "isFinished = " + z4);
                            return z4;
                        }
                    }
                } catch (Exception e6) {
                    e = e6;
                }
            } catch (Throwable unused2) {
                fileOutputStream = fileOutputStream2;
            }
        }

        @NotNull
        public final String syncLocalFile(@NotNull Context context, @NotNull String localPath, @NotNull String category, @NotNull String localMd5) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(localPath, "localPath");
            Intrinsics.checkNotNullParameter(category, "category");
            Intrinsics.checkNotNullParameter(localMd5, "localMd5");
            return copyAssetsFile(context, localPath, getPolicyFolderCachePath(context, category), localMd5);
        }
    }
}
