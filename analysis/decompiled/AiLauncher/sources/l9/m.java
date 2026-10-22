package l9;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a%\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b*\u00020\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u0011\u0010\u000b\u001a\u00020\u0002*\u00020\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a#\u0010\u0012\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Ljava/io/Reader;", "Lkotlin/Function1;", "", "LY8/t;", "action", "c", "(Ljava/io/Reader;Lp9/l;)V", "Ljava/io/BufferedReader;", "LKa/j;", Const.INTENT_KEY_UMID, "(Ljava/io/BufferedReader;)LKa/j;", "e", "(Ljava/io/Reader;)Ljava/lang/String;", "Ljava/io/Writer;", "out", "", "bufferSize", "", Const.INTENT_KEY_APIKEY, "(Ljava/io/Reader;Ljava/io/Writer;I)J", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class m {
    public static final long a(Reader reader, Writer out, int i10) throws IOException {
        p.i(reader, "<this>");
        p.i(out, "out");
        char[] cArr = new char[i10];
        int i11 = reader.read(cArr);
        long j10 = 0;
        while (i11 >= 0) {
            out.write(cArr, 0, i11);
            j10 += i11;
            i11 = reader.read(cArr);
        }
        return j10;
    }

    public static /* synthetic */ long b(Reader reader, Writer writer, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = com.stepos.agentframework.chatui.longtext.b.THRESHOLD;
        }
        return a(reader, writer, i10);
    }

    public static final void c(Reader reader, InterfaceC5074l<? super String, t> action) {
        p.i(reader, "<this>");
        p.i(action, "action");
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, com.stepos.agentframework.chatui.longtext.b.THRESHOLD);
        try {
            Iterator<String> it = d(bufferedReader).iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
            t tVar = t.f7040a;
            b.a(bufferedReader, null);
        } finally {
        }
    }

    public static final Ka.j<String> d(BufferedReader bufferedReader) {
        p.i(bufferedReader, "<this>");
        return Ka.t.i(new l(bufferedReader));
    }

    public static final String e(Reader reader) {
        p.i(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        b(reader, stringWriter, 0, 2, null);
        String string = stringWriter.toString();
        p.h(string, "toString(...)");
        return string;
    }
}
