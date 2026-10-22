package ae7;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import java.security.MessageDigest;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes22.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f3111a = null;

    static {
        f3111a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "string");
        byte[] r101 = r100.getBytes(Charsets.UTF_8);     // Catch: Exception -> L13
        MessageDigest r102 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L10
        r102.update(r101);     // Catch: Exception -> L10
        byte[] r103 = r102.digest();     // Catch: Exception -> L10
        char[] r104 = new char[32];     // Catch: Exception -> L10
        int r105 = 0;
        int r106 = 0;
    L6:
        if (r105 >= 16) goto L8;
        byte r107 = r103[r105];     // Catch: Exception -> L10
        int r108 = r106 + 1;     // Catch: Exception -> L10
        char[] r109 = f3111a;     // Catch: Exception -> L10
        r104[r106] = r109[(r107 >>> 4) & 15];     // Catch: Exception -> L10
        r106 = r108 + 1;     // Catch: Exception -> L10
        r104[r108] = r109[r107 & 15];     // Catch: Exception -> L10
        r105 = r105 + 1;     // Catch: Exception -> L10
        goto L6
    L8:
    L21:
        return r104.toString();
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L13
    L15:
        return null;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }
}
