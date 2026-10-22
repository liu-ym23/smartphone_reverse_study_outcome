package f4;

import j4.k;
import java.io.File;
import org.libpag.BuildConfig;
import r4.C1031n;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: f4.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0726f extends C0725e {
    public static String b(File file) {
        k.g(file, "<this>");
        String name = file.getName();
        k.f(name, "getName(...)");
        return C1031n.e0(name, '.', BuildConfig.FLAVOR);
    }
}
