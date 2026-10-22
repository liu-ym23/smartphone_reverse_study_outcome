package cn.com.chinatelecom.account;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.NamedPipe;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Symlink;
import kotlin.io.encoding.Base64;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes28.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static char[] f24365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static byte[] f24366b;

    static {
        f24365a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, 'M', 'N', 'O', 'P', 'Q', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'S', OthersPermission.STICKY, Matrix.MATRIX_TYPE_RANDOM_UT, 'V', 'W', 'X', 'Y', Matrix.MATRIX_TYPE_ZERO, 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f', 'g', 'h', 'i', 'j', 'k', Symlink.UNIX_ID, 'm', 'n', 'o', NamedPipe.UNIX_ID, 'q', Permission.READ, 's', OthersPermission.STICKY_E, 'u', 'v', Permission.WRITE, Permission.EXECUTE, 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        f24366b = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, Base64.padSymbol, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, HTTP.CR, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};
    }

    public static byte[] a(String r100) {
        return b(r100);
    L4:
        e = move-exception;
        e.printStackTrace();
        return new byte[0];
    }

    private static byte[] b(String r100) {
        StringBuffer r101 = new StringBuffer();
        byte[] r102 = r100.getBytes("US-ASCII");
        int r103 = r102.length;
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L23;
    L5:
        int r105 = r104 + 1;
        byte r106 = f24366b[r102[r104]];
        if (r105 >= r103) goto L10;
        if (r106 != (-1)) goto L10;
        r104 = r105;
    L10:
        if (r106 == (-1)) goto L23;
    L12:
        int r107 = r105 + 1;
        byte r108 = f24366b[r102[r105]];
        if (r107 >= r103) goto L17;
        if (r108 != (-1)) goto L17;
        r105 = r107;
    L17:
        if (r108 == (-1)) goto L23;
        r101.append((char) ((r106 << 2) | ((r108 & 48) >>> 4)));
    L20:
        int r109 = r107 + 1;
        byte r110 = r102[r107];
        if (r110 == 61) goto L23;
        byte r111 = f24366b[r110];
        if (r109 >= r103) goto L29;
        if (r111 != (-1)) goto L29;
        r107 = r109;
    L29:
        if (r111 == (-1)) goto L23;
        r101.append((char) (((r108 & 15) << 4) | ((r111 & 60) >>> 2)));
    L32:
        int r112 = r109 + 1;
        byte r113 = r102[r109];
        if (r113 == 61) goto L23;
        byte r114 = f24366b[r113];
        if (r112 >= r103) goto L40;
        if (r114 != (-1)) goto L40;
        r109 = r112;
    L40:
        if (r114 == (-1)) goto L23;
        r101.append((char) (r114 | ((r111 & 3) << 6)));
        r104 = r112;
    L23:
        return r101.toString().getBytes("iso8859-1");
    }
}
