package com.baidu.mapsdkplatform.comapi.commonutils;

import B0.g;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public class AssetsLoadUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f7904a = true;

    private static String a(String str, String str2, Context context) throws Throwable {
        ZipFile zipFile;
        File file;
        File file2;
        ZipEntry entry;
        StringBuilder sb = new StringBuilder(context.getFilesDir().getAbsolutePath());
        ZipFile zipFile2 = null;
        try {
            try {
                try {
                    zipFile = new ZipFile(f7904a ? context.getPackageCodePath() : "");
                } catch (Exception e4) {
                    e = e4;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException unused) {
        }
        try {
            int iLastIndexOf = str2.lastIndexOf("/");
            if (iLastIndexOf > 0) {
                file = new File(context.getFilesDir().getAbsolutePath());
                String strSubstring = str2.substring(0, iLastIndexOf);
                file2 = new File(file.getAbsolutePath() + "/" + strSubstring, str2.substring(iLastIndexOf + 1, str2.length()));
            } else {
                file = new File(context.getFilesDir(), "assets");
                file2 = new File(file.getAbsolutePath(), str2);
            }
            file.mkdirs();
            entry = zipFile.getEntry(str);
        } catch (Exception e5) {
            e = e5;
            zipFile2 = zipFile;
            Log.e("AssetsLoadUtil", "copyAssetsError", e);
            if (zipFile2 != null) {
                zipFile2.close();
            }
            return sb.toString();
        } catch (Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
        if (entry == null) {
            try {
                zipFile.close();
            } catch (IOException unused3) {
            }
            return null;
        }
        a(zipFile.getInputStream(entry), new FileOutputStream(file2));
        sb.append("/");
        sb.append(str);
        zipFile.close();
        return sb.toString();
    }

    public static void copyFileFromAsset(String str, String str2, Context context) throws Throwable {
        InputStream inputStreamOpen;
        byte[] bArr;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                inputStreamOpen = context.getAssets().open(str);
                if (inputStreamOpen != null) {
                    try {
                        bArr = new byte[inputStreamOpen.available()];
                        inputStreamOpen.read(bArr);
                        File file = new File(context.getFilesDir().getAbsolutePath() + "/" + str2);
                        if (file.exists()) {
                            file.delete();
                        }
                        file.createNewFile();
                        fileOutputStream = new FileOutputStream(file);
                    } catch (Exception unused) {
                    }
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.close();
                        fileOutputStream2 = fileOutputStream;
                    } catch (Exception unused2) {
                        fileOutputStream2 = fileOutputStream;
                        a("assets/" + str, str2, context);
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                                return;
                            }
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream2 = fileOutputStream;
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                                throw th;
                            }
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        throw th;
                    }
                }
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                        return;
                    }
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused3) {
            inputStreamOpen = null;
        } catch (Throwable th3) {
            th = th3;
            inputStreamOpen = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0075 A[Catch: IOException -> 0x0071, TRY_LEAVE, TryCatch #4 {IOException -> 0x0071, blocks: (B:31:0x006d, B:35:0x0075), top: B:53:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getAssetsFilePath(android.content.Context r6, java.lang.String r7) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "/"
            r1 = 0
            android.content.res.AssetManager r2 = r6.getAssets()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L63
            java.io.InputStream r2 = r2.open(r7)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L63
            int r3 = r2.available()     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L5d
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L5d
            r2.read(r3)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L5d
            java.io.File r6 = r6.getFilesDir()     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L5d
            java.lang.String r6 = r6.getAbsolutePath()     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L5d
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            r5.<init>()     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            r5.append(r6)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            r5.append(r0)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            r5.append(r7)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            boolean r5 = r4.exists()     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            if (r5 == 0) goto L41
            r4.delete()     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            goto L41
        L3d:
            r6 = move-exception
            goto L81
        L3f:
            r3 = move-exception
            goto L66
        L41:
            r4.createNewFile()     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            r5.write(r3)     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5b
            r2.close()     // Catch: java.io.IOException -> L53
            r5.close()     // Catch: java.io.IOException -> L53
            goto L7c
        L53:
            r1 = move-exception
            r1.printStackTrace()
            goto L7c
        L58:
            r6 = move-exception
            r1 = r5
            goto L81
        L5b:
            r1 = move-exception
            goto L68
        L5d:
            r3 = move-exception
            r6 = r1
            goto L66
        L60:
            r6 = move-exception
            r2 = r1
            goto L81
        L63:
            r3 = move-exception
            r6 = r1
            r2 = r6
        L66:
            r5 = r1
            r1 = r3
        L68:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L58
            if (r2 == 0) goto L73
            r2.close()     // Catch: java.io.IOException -> L71
            goto L73
        L71:
            r1 = move-exception
            goto L79
        L73:
            if (r5 == 0) goto L7c
            r5.close()     // Catch: java.io.IOException -> L71
            goto L7c
        L79:
            r1.printStackTrace()
        L7c:
            java.lang.String r6 = androidx.room.AbstractC0351g.q(r6, r0, r7)
            return r6
        L81:
            if (r2 == 0) goto L89
            r2.close()     // Catch: java.io.IOException -> L87
            goto L89
        L87:
            r7 = move-exception
            goto L8f
        L89:
            if (r1 == 0) goto L92
            r1.close()     // Catch: java.io.IOException -> L87
            goto L92
        L8f:
            r7.printStackTrace()
        L92:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.commonutils.AssetsLoadUtil.getAssetsFilePath(android.content.Context, java.lang.String):java.lang.String");
    }

    public static Bitmap loadAssetsFile(String str, Context context) throws IOException {
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            if (inputStreamOpen != null) {
                return BitmapFactory.decodeStream(inputStreamOpen);
            }
            return null;
        } catch (Exception unused) {
            return BitmapFactory.decodeFile(a(g.m("assets/", str), str, context));
        }
    }

    private static void a(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int i4 = inputStream.read(bArr);
                if (i4 == -1) {
                    break;
                } else {
                    fileOutputStream.write(bArr, 0, i4);
                }
            } finally {
            }
        }
        fileOutputStream.flush();
        try {
            inputStream.close();
        } catch (IOException unused) {
        }
        try {
            fileOutputStream.close();
        } catch (IOException unused2) {
        }
    }
}
