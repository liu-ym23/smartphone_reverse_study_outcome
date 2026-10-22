package c97;

import com.bytedance.reparo.core.exception.SoInfoParseException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, List<a>> f22903a = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f22904a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f22905b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, String> f22906c;

        public a() {
            this.f22906c = new HashMap();
        }
    }

    static {
        f22903a = new HashMap();
    }

    public static List<a> a(File r110) {
        PolarisFileInputStreamWrapper r100 = null;
        BufferedReader r101 = null;
        BufferedReader r102 = null;
        r100 = null;
        if (w87.b.g(r110) == true) goto L5;
        return null;
    L5:
        List<a> r103 = (List) ((HashMap) f22903a).get(r110.getAbsolutePath());
        if (r103 == null) goto L8;
        return r103;
    L8:
        ArrayList r104 = new ArrayList();
        PolarisFileInputStreamWrapper r105 = new PolarisFileInputStreamWrapper(r110);     // Catch: Throwable -> L40 IOException -> L42
    L72:
        BufferedReader r106 = new BufferedReader(new InputStreamReader(r105, Charset.forName("UTF-8")));     // Catch: Throwable -> L36 IOException -> L38
    L68:
        String r107 = r106.readLine();     // Catch: Throwable -> L32 IOException -> L34
        if (r107 == null) goto L60;
        String[] r108 = r107.split(" ");     // Catch: Throwable -> L32 IOException -> L34
        a r109 = new a();     // Catch: Throwable -> L32 IOException -> L34
        r109.f22904a = r108[0];     // Catch: Throwable -> L32 IOException -> L34
        r109.f22905b = Boolean.parseBoolean(r108[1]);     // Catch: Throwable -> L32 IOException -> L34
        int r111 = 2;
    L15:
        if (r111 >= r108.length) goto L17;
        String[] r112 = r108[r111].split(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Throwable -> L32 IOException -> L34
        ((HashMap) r109.f22906c).put(r112[0], r112[1]);     // Catch: Throwable -> L32 IOException -> L34
        r111 = r111 + 1;     // Catch: Throwable -> L32 IOException -> L34
        goto L15
    L17:
        r104.add(r109);     // Catch: Throwable -> L32 IOException -> L34
        goto L68
    L60:
        r105.close();     // Catch: IOException -> L21
    L66:
        r106.close();     // Catch: IOException -> L25
    L28:
        if (r104.size() != 0) goto L30;
        return null;
    L30:
        ((HashMap) f22903a).put(r110.getAbsolutePath(), r104);
        return r104;
    L25:
        e = move-exception;
        e.printStackTrace();
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L66
    L34:
        e = e;
        r101 = r106;
    L39:
        BufferedReader r113 = r101;
        r100 = r105;
    L62:
    L46:
        th = th;
    L47:
        if (r100 != null) goto L58;
    L52:
        if (r113 == null) goto L75;
        r113.close();     // Catch: IOException -> L55
        throw th;
    L55:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L75:
        throw th;
    L58:
        r100.close();     // Catch: IOException -> L50
    L50:
        e = move-exception;
        e.printStackTrace();
        goto L52
    L45:
        throw new SoInfoParseException(String.format("read %s failed. ", new Object[]{r110.getAbsolutePath()}), e, 0);     // Catch: Throwable -> L46
    L32:
        th = th;
        r102 = r106;
    L37:
        r113 = r102;
        r100 = r105;
        goto L47
    L38:
        e = e;
    L36:
        th = th;
    L42:
        e = e;
        r113 = null;
    L40:
        th = th;
        r113 = null;
        goto L47
    }
}
