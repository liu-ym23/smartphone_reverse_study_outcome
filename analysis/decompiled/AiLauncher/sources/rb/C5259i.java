package rb;

import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonPointer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\b\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0018¨\u0006\u001a"}, d2 = {"Lrb/i;", "", "<init>", "()V", "LY8/t;", "f", "e", "", "c", "", "esc", Const.INTENT_KEY_PKGNAME, "(IC)V", Const.INTENT_KEY_APIKEY, "(CC)V", "", Const.SP_KEY_CONTINUE_LOCATION, Const.INTENT_KEY_UMID, "(IB)V", "(CB)V", "", "[C", "ESCAPE_2_CHAR", "", "[B", "CHAR_TO_TOKEN", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: rb.i, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5259i {

    /* renamed from: a, reason: collision with root package name */
    public static final C5259i f38986a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final char[] ESCAPE_2_CHAR;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final byte[] CHAR_TO_TOKEN;

    static {
        C5259i c5259i = new C5259i();
        f38986a = c5259i;
        ESCAPE_2_CHAR = new char[117];
        CHAR_TO_TOKEN = new byte[126];
        c5259i.f();
        c5259i.e();
    }

    public final void a(char c10, char esc) {
        b(c10, esc);
    }

    public final void b(int c10, char esc) {
        if (esc != 'u') {
            ESCAPE_2_CHAR[esc] = (char) c10;
        }
    }

    public final void c(char c10, byte cl) {
        d(c10, cl);
    }

    public final void d(int c10, byte cl) {
        CHAR_TO_TOKEN[c10] = cl;
    }

    public final void e() {
        for (int i10 = 0; i10 < 33; i10++) {
            d(i10, (byte) 127);
        }
        d(9, (byte) 3);
        d(10, (byte) 3);
        d(13, (byte) 3);
        d(32, (byte) 3);
        c(',', (byte) 4);
        c(':', (byte) 5);
        c('{', (byte) 6);
        c('}', (byte) 7);
        c('[', (byte) 8);
        c(']', (byte) 9);
        c(JsonFactory.DEFAULT_QUOTE_CHAR, (byte) 1);
        c('\\', (byte) 2);
    }

    public final void f() {
        for (int i10 = 0; i10 < 32; i10++) {
            b(i10, 'u');
        }
        b(8, 'b');
        b(9, 't');
        b(10, 'n');
        b(12, 'f');
        b(13, 'r');
        a(JsonPointer.SEPARATOR, JsonPointer.SEPARATOR);
        a(JsonFactory.DEFAULT_QUOTE_CHAR, JsonFactory.DEFAULT_QUOTE_CHAR);
        a('\\', '\\');
    }
}
