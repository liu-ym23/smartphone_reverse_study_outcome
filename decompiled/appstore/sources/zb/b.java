package zb;

import android.text.TextUtils;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.security.MessageDigest;
import kotlin.jvm.internal.q;
import kotlin.text.c;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f26342a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final char[] f26343a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f26344b = null;

        static {
            f26344b = new a();
            f26343a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        }

        public a() {
        }

        public static final String a(byte[] r10) {
            if (r10 == null) goto L6;
            return b(r10, 0, r10.length);
        L6:
            throw new IllegalArgumentException("bytes is null");
        }

        public static final String b(byte[] r10, int r11, int r12) {
            q.g(r10, DownloadInfoColumns.COLUMN_BYTES);
            if (r11 < 0) goto L12;
            if ((r11 + r12) > r10.length) goto L12;
            char[] r13 = new char[r12 * 2];
            int r14 = 0;
        L7:
            if (r14 >= r12) goto L10;
            byte r15 = r10[r11 + r14];
            int r16 = r15 & UnsignedBytes.MAX_VALUE;
            int r17 = r14 * 2;
            char[] r18 = f26343a;
            r13[r17] = r18[r16 >> 4];
            r13[r17 + 1] = r18[r15 & Ascii.SI];
            r14 = r14 + 1;
            goto L7
        L10:
            return new String(r13);
        L12:
            throw new IllegalArgumentException(("offset=" + r11 + ", length=" + r12 + ", bytes.length=" + r10.length).toString());
        }

        public static final String c(String r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            if (r10.length() == 0) goto L13;
            MessageDigest r11 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L9
            byte[] r12 = r10.getBytes(c.f21252b);     // Catch: Exception -> L9
            q.f(r12, "this as java.lang.String).getBytes(charset)");     // Catch: Exception -> L9
            return a(r11.digest(r12));
        L14:
            return null;
        L13:
            return null;
        }
    }

    static {
        f26342a = new b();
    }

    public b() {
    }

    public final int a(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return 0;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L15;
        String r12 = a.c(r11 + "_" + r10);
        if (TextUtils.isEmpty(r12) == true) goto L16;
        if (r12 != null) goto L12;
        return 0;
    L12:
        return r12.hashCode();
    L16:
        return 0;
    L15:
        return 0;
    }
}
