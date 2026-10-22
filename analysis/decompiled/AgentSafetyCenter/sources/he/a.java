package he;

import g5.f;
import java.lang.invoke.VarHandle;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final CharsetDecoder f5590a = StandardCharsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT);

    /* renamed from: b, reason: collision with root package name */
    public static final ae.a f5591b;

    static {
        ae.a aVar = new ae.a();
        if ("-_.!~*'()@:$&,;=[]/".matches(".*[0-9A-Za-z].*")) {
            f.s("Alphanumeric characters are always 'safe' and should not be explicitly specified");
            return;
        }
        char[] charArray = "-_.!~*'()@:$&,;=[]/".toCharArray();
        int iMax = 122;
        for (char c9 : charArray) {
            iMax = Math.max((int) c9, iMax);
        }
        boolean[] zArr = new boolean[iMax + 1];
        for (int i = 48; i <= 57; i++) {
            zArr[i] = true;
        }
        for (int i3 = 65; i3 <= 90; i3++) {
            zArr[i3] = true;
        }
        for (int i10 = 97; i10 <= 122; i10++) {
            zArr[i10] = true;
        }
        for (char c10 : charArray) {
            zArr[c10] = true;
        }
        aVar.f644b = zArr;
        VarHandle.storeStoreFence();
        f5591b = aVar;
    }
}
