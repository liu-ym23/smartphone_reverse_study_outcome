package f4;

import j4.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: f4.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0724d extends C0723c {
    public static String a(File file, Charset charset) throws IOException {
        k.g(file, "<this>");
        k.g(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String strC = C0727g.c(inputStreamReader);
            C0721a.a(inputStreamReader, null);
            return strC;
        } finally {
        }
    }
}
