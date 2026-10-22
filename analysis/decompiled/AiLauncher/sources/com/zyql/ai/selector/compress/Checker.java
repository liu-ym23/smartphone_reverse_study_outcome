package com.zyql.ai.selector.compress;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* loaded from: classes4.dex */
enum Checker {
    SINGLE;

    private static final String JPG = ".jpg";
    public static final String MIME_TYPE_HEIC = "image/heic";
    public static final String MIME_TYPE_JPEG = "image/jpeg";
    public static final String MIME_TYPE_JPG = "image/jpg";
    private static final String TAG = "Luban";
    private final byte[] JPEG_SIGNATURE = {-1, -40, -1};

    Checker() {
    }

    private int pack(byte[] bArr, int i10, int i11, boolean z10) {
        int i12;
        if (z10) {
            i10 += i11 - 1;
            i12 = -1;
        } else {
            i12 = 1;
        }
        int i13 = 0;
        while (true) {
            int i14 = i11 - 1;
            if (i11 <= 0) {
                return i13;
            }
            i13 = (bArr[i10] & 255) | (i13 << 8);
            i10 += i12;
            i11 = i14;
        }
    }

    private byte[] toByteArray(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                try {
                    int i10 = inputStream.read(bArr, 0, 4096);
                    if (i10 != -1) {
                        byteArrayOutputStream.write(bArr, 0, i10);
                    } else {
                        try {
                            break;
                        } catch (IOException unused) {
                        }
                    }
                } finally {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException unused2) {
                    }
                }
            } catch (Exception unused3) {
                byte[] bArr2 = new byte[0];
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused4) {
                }
                return bArr2;
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String extSuffix(String str) {
        if (TextUtils.isEmpty(str)) {
            return ".jpg";
        }
        try {
            return str.replace(str.startsWith("video") ? "video/" : "image/", ".");
        } catch (Exception unused) {
            return ".jpg";
        }
    }

    public int getOrientation(InputStream inputStream) {
        return getOrientation(toByteArray(inputStream));
    }

    public boolean isJPG(InputStream inputStream) {
        return isJPG(toByteArray(inputStream));
    }

    public boolean needCompress(int i10, String str) {
        if (i10 <= 0) {
            return true;
        }
        File file = new File(str);
        return file.exists() && file.length() > ((long) (i10 << 10));
    }

    public boolean needCompressToLocalMedia(int i10, String str) {
        if (i10 <= 0 || TextUtils.isEmpty(str)) {
            return true;
        }
        File file = new File(str);
        return file.exists() && file.length() > ((long) (i10 << 10));
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x005c, code lost:
    
        android.util.Log.e(com.zyql.ai.selector.compress.Checker.TAG, "Invalid length");
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0061, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0062, code lost:
    
        r9 = 0;
        r1 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int getOrientation(byte[] r12) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zyql.ai.selector.compress.Checker.getOrientation(byte[]):int");
    }

    public boolean isJPG(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(MIME_TYPE_HEIC) || str.startsWith("image/jpeg") || str.startsWith(MIME_TYPE_JPG);
    }

    private boolean isJPG(byte[] bArr) {
        if (bArr == null || bArr.length < 3) {
            return false;
        }
        return Arrays.equals(this.JPEG_SIGNATURE, new byte[]{bArr[0], bArr[1], bArr[2]});
    }
}
