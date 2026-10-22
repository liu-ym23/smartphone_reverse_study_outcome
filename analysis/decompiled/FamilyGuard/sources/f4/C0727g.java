package f4;

import j4.k;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

/* renamed from: f4.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0727g {
    public static final long a(Reader reader, Writer writer, int i5) throws IOException {
        k.g(reader, "<this>");
        k.g(writer, "out");
        char[] cArr = new char[i5];
        int i6 = reader.read(cArr);
        long j5 = 0;
        while (i6 >= 0) {
            writer.write(cArr, 0, i6);
            j5 += i6;
            i6 = reader.read(cArr);
        }
        return j5;
    }

    public static /* synthetic */ long b(Reader reader, Writer writer, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = 8192;
        }
        return a(reader, writer, i5);
    }

    public static final String c(Reader reader) {
        k.g(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        b(reader, stringWriter, 0, 2, null);
        String string = stringWriter.toString();
        k.f(string, "toString(...)");
        return string;
    }
}
