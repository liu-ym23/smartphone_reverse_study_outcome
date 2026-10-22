package l9;

import La.H;
import Z8.C1173v;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\"\u0015\u0010\u000b\u001a\u00020\b*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)I", "Ljava/io/File;", "Ll9/e;", "c", "(Ljava/io/File;)Ll9/e;", "", Const.INTENT_KEY_PKGNAME, "(Ljava/io/File;)Z", "isRooted", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/io/FilesKt")
/* loaded from: classes4.dex */
public class g {
    public static final int a(String str) {
        int iT0;
        char c10 = File.separatorChar;
        int iT02 = H.t0(str, c10, 0, false, 4, null);
        if (iT02 == 0) {
            if (str.length() <= 1 || str.charAt(1) != c10 || (iT0 = H.t0(str, c10, 2, false, 4, null)) < 0) {
                return 1;
            }
            int iT03 = H.t0(str, c10, iT0 + 1, false, 4, null);
            return iT03 >= 0 ? iT03 + 1 : str.length();
        }
        if (iT02 > 0 && str.charAt(iT02 - 1) == ':') {
            return iT02 + 1;
        }
        if (iT02 == -1 && H.j0(str, ':', false, 2, null)) {
            return str.length();
        }
        return 0;
    }

    public static boolean b(File file) {
        p.i(file, "<this>");
        String path = file.getPath();
        p.h(path, "getPath(...)");
        return a(path) > 0;
    }

    public static final FilePathComponents c(File file) {
        List listM;
        p.i(file, "<this>");
        String path = file.getPath();
        p.f(path);
        int iA = a(path);
        String strSubstring = path.substring(0, iA);
        p.h(strSubstring, "substring(...)");
        String strSubstring2 = path.substring(iA);
        p.h(strSubstring2, "substring(...)");
        if (strSubstring2.length() == 0) {
            listM = C1173v.m();
        } else {
            List listA1 = H.a1(strSubstring2, new char[]{File.separatorChar}, false, 0, 6, null);
            ArrayList arrayList = new ArrayList(C1174w.x(listA1, 10));
            Iterator it = listA1.iterator();
            while (it.hasNext()) {
                arrayList.add(new File((String) it.next()));
            }
            listM = arrayList;
        }
        return new FilePathComponents(new File(strSubstring), listM);
    }
}
