package P1;

import com.google.android.gms.common.api.internal.p;
import com.stepos.alphame.utils.Consts;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public enum a {
    SIMPLIFIED(false),
    /* JADX INFO: Fake field, exist only in values array */
    TRADITIONAL(true);


    /* renamed from: a, reason: collision with root package name */
    public final char[] f1566a;

    /* renamed from: b, reason: collision with root package name */
    public final p f1567b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1568c;

    a(boolean z4) throws IOException {
        this.f1566a = null;
        this.f1567b = null;
        this.f1568c = 2;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(a.class.getResourceAsStream(z4 ? "/trad.txt" : "/simp.txt")), StandardCharsets.UTF_8));
            CharArrayWriter charArrayWriter = new CharArrayWriter();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                } else {
                    charArrayWriter.write(line);
                }
            }
            this.f1566a = charArrayWriter.toCharArray();
            bufferedReader.close();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        String str = z4 ? "/traditional.txt" : "/simplified.txt";
        this.f1567b = new p(14);
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new BufferedInputStream(a.class.getResourceAsStream(str)), StandardCharsets.UTF_8));
            while (true) {
                String line2 = bufferedReader2.readLine();
                if (line2 == null) {
                    bufferedReader2.close();
                    return;
                } else if (line2.length() != 0 && !line2.startsWith("#")) {
                    String[] strArrSplit = line2.split(Consts.SPLITTER_EQUAL);
                    if (strArrSplit.length >= 2) {
                        this.f1568c = this.f1568c < strArrSplit[0].length() ? strArrSplit[0].length() : this.f1568c;
                        this.f1567b.l(strArrSplit[1], strArrSplit[0]);
                    }
                }
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    public final void a(StringReader stringReader, StringWriter stringWriter) {
        PushbackReader pushbackReader = new PushbackReader(new BufferedReader(stringReader), this.f1568c);
        char[] cArr = new char[this.f1568c];
        while (true) {
            int i4 = pushbackReader.read(cArr);
            if (i4 == -1) {
                return;
            }
            b bVar = (b) this.f1567b.f9664b;
            b bVar2 = null;
            for (int i5 = 0; i5 < i4; i5++) {
                bVar = (b) bVar.f1571c.get(Character.valueOf(cArr[i5]));
                if (bVar == null) {
                    break;
                }
                if (bVar.f1572d) {
                    bVar2 = bVar;
                }
            }
            if (bVar2 != null) {
                int i6 = bVar2.f1569a;
                stringWriter.write((String) bVar2.f1573e);
                pushbackReader.unread(cArr, i6, i4 - i6);
            } else {
                pushbackReader.unread(cArr, 0, i4);
                char c4 = (char) pushbackReader.read();
                if (c4 >= 19968 && c4 <= 40869) {
                    c4 = this.f1566a[c4 - 19968];
                }
                stringWriter.write(c4);
            }
        }
    }
}
