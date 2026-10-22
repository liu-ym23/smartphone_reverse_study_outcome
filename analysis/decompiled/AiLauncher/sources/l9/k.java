package l9;

import La.H;
import Y8.t;
import Z8.F;
import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000b\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\b\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\n\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\f*\b\u0012\u0004\u0012\u00020\u00000\fH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\u0019\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0019\u0010\u0012\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013\"\u0015\u0010\u0016\u001a\u00020\u0007*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Ljava/io/File;", "", "v", "(Ljava/io/File;)Z", "other", "B", "(Ljava/io/File;Ljava/io/File;)Z", "", "C", "(Ljava/io/File;Ljava/lang/String;)Z", "x", "(Ljava/io/File;)Ljava/io/File;", "", "y", "(Ljava/util/List;)Ljava/util/List;", "relative", "z", "(Ljava/io/File;Ljava/io/File;)Ljava/io/File;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;", "w", "(Ljava/io/File;)Ljava/lang/String;", "extension", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/io/FilesKt")
/* loaded from: classes4.dex */
public class k extends j {
    public static File A(File file, String relative) {
        p.i(file, "<this>");
        p.i(relative, "relative");
        return z(file, new File(relative));
    }

    public static final boolean B(File file, File other) {
        p.i(file, "<this>");
        p.i(other, "other");
        FilePathComponents filePathComponentsC = g.c(file);
        FilePathComponents filePathComponentsC2 = g.c(other);
        if (p.d(filePathComponentsC.getRoot(), filePathComponentsC2.getRoot()) && filePathComponentsC.c() >= filePathComponentsC2.c()) {
            return filePathComponentsC.b().subList(0, filePathComponentsC2.c()).equals(filePathComponentsC2.b());
        }
        return false;
    }

    public static boolean C(File file, String other) {
        p.i(file, "<this>");
        p.i(other, "other");
        return B(file, new File(other));
    }

    public static boolean v(File file) {
        p.i(file, "<this>");
        while (true) {
            boolean z10 = true;
            for (File file2 : j.t(file)) {
                if (!file2.delete() && file2.exists()) {
                    z10 = false;
                } else {
                    if (z10) {
                        break;
                    }
                    z10 = false;
                }
            }
            return z10;
        }
    }

    public static String w(File file) {
        p.i(file, "<this>");
        String name = file.getName();
        p.h(name, "getName(...)");
        return H.q1(name, '.', "");
    }

    public static File x(File file) {
        p.i(file, "<this>");
        FilePathComponents filePathComponentsC = g.c(file);
        File root = filePathComponentsC.getRoot();
        List<File> listY = y(filePathComponentsC.b());
        String separator = File.separator;
        p.h(separator, "separator");
        return A(root, F.A0(listY, separator, null, null, 0, null, null, 62, null));
    }

    public static final List<File> y(List<? extends File> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (File file : list) {
            String name = file.getName();
            if (p.d(name, ".")) {
                t tVar = t.f7040a;
            } else if (!p.d(name, "..")) {
                arrayList.add(file);
            } else if (arrayList.isEmpty() || p.d(((File) F.C0(arrayList)).getName(), "..")) {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    public static File z(File file, File relative) {
        p.i(file, "<this>");
        p.i(relative, "relative");
        if (g.b(relative)) {
            return relative;
        }
        String string = file.toString();
        p.h(string, "toString(...)");
        if (string.length() != 0) {
            char c10 = File.separatorChar;
            if (!H.j0(string, c10, false, 2, null)) {
                return new File(string + c10 + relative);
            }
        }
        return new File(string + relative);
    }
}
