package rb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonFactory;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0010\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0003\u001a\u00020\u00028\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0018¨\u0006 "}, d2 = {"Lrb/L;", "Lrb/a;", "", "source", "<init>", "(Ljava/lang/String;)V", "", "position", "H", "(I)I", "", "k", "()B", "", "f", "()Z", "J", "()I", "", "expected", "LY8/t;", "m", "(C)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Ljava/lang/String;", "keyToMatch", "isLenient", ExifInterface.LONGITUDE_EAST, "(Ljava/lang/String;Z)Ljava/lang/String;", "e", "Ljava/lang/String;", "R", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public class L extends JsonReader {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final String source;

    public L(String source) {
        kotlin.jvm.internal.p.i(source, "source");
        this.source = source;
    }

    @Override // rb.JsonReader
    public String E(String keyToMatch, boolean isLenient) {
        kotlin.jvm.internal.p.i(keyToMatch, "keyToMatch");
        int i10 = this.currentPosition;
        try {
            if (k() == 6 && kotlin.jvm.internal.p.d(G(isLenient), keyToMatch)) {
                v();
                if (k() == 5) {
                    return G(isLenient);
                }
            }
            return null;
        } finally {
            this.currentPosition = i10;
            v();
        }
    }

    @Override // rb.JsonReader
    public int H(int position) {
        if (position < C().length()) {
            return position;
        }
        return -1;
    }

    @Override // rb.JsonReader
    public int J() {
        char cCharAt;
        int i10 = this.currentPosition;
        if (i10 == -1) {
            return i10;
        }
        String strC = C();
        while (i10 < strC.length() && ((cCharAt = strC.charAt(i10)) == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t')) {
            i10++;
        }
        this.currentPosition = i10;
        return i10;
    }

    @Override // rb.JsonReader
    /* renamed from: R, reason: from getter and merged with bridge method [inline-methods] */
    public String C() {
        return this.source;
    }

    @Override // rb.JsonReader
    public boolean f() {
        int i10 = this.currentPosition;
        if (i10 == -1) {
            return false;
        }
        String strC = C();
        while (i10 < strC.length()) {
            char cCharAt = strC.charAt(i10);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.currentPosition = i10;
                return D(cCharAt);
            }
            i10++;
        }
        this.currentPosition = i10;
        return false;
    }

    @Override // rb.JsonReader
    public String j() {
        m(JsonFactory.DEFAULT_QUOTE_CHAR);
        int i10 = this.currentPosition;
        int iT0 = La.H.t0(C(), JsonFactory.DEFAULT_QUOTE_CHAR, i10, false, 4, null);
        if (iT0 != -1) {
            for (int i11 = i10; i11 < iT0; i11++) {
                if (C().charAt(i11) == '\\') {
                    return r(C(), this.currentPosition, i11);
                }
            }
            this.currentPosition = iT0 + 1;
            String strSubstring = C().substring(i10, iT0);
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            return strSubstring;
        }
        s();
        String strC = C5252b.c((byte) 1);
        int i12 = this.currentPosition;
        JsonReader.z(this, "Expected " + strC + ", but had '" + ((i12 == C().length() || i12 < 0) ? "EOF" : String.valueOf(C().charAt(i12))) + "' instead", i12, null, 4, null);
        throw new KotlinNothingValueException();
    }

    @Override // rb.JsonReader
    public byte k() {
        String strC = C();
        int i10 = this.currentPosition;
        while (i10 != -1 && i10 < strC.length()) {
            int i11 = i10 + 1;
            char cCharAt = strC.charAt(i10);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.currentPosition = i11;
                return C5252b.a(cCharAt);
            }
            i10 = i11;
        }
        this.currentPosition = strC.length();
        return (byte) 10;
    }

    @Override // rb.JsonReader
    public void m(char expected) {
        if (this.currentPosition == -1) {
            P(expected);
        }
        String strC = C();
        int i10 = this.currentPosition;
        while (i10 < strC.length()) {
            int i11 = i10 + 1;
            char cCharAt = strC.charAt(i10);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.currentPosition = i11;
                if (cCharAt == expected) {
                    return;
                } else {
                    P(expected);
                }
            }
            i10 = i11;
        }
        this.currentPosition = -1;
        P(expected);
    }
}
