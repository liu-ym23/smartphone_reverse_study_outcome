package rb;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lrb/N;", "Lrb/L;", "", "source", "<init>", "(Ljava/lang/String;)V", "", "k", "()B", "", "f", "()Z", "", "expected", "LY8/t;", "m", "(C)V", "F", "", "J", "()I", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class N extends L {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(String source) {
        super(source);
        kotlin.jvm.internal.p.i(source, "source");
    }

    @Override // rb.JsonReader
    public byte F() {
        String strC = C();
        int iJ = J();
        if (iJ >= strC.length() || iJ == -1) {
            return (byte) 10;
        }
        this.currentPosition = iJ;
        return C5252b.a(strC.charAt(iJ));
    }

    @Override // rb.L, rb.JsonReader
    public int J() {
        int i10;
        int iT0 = this.currentPosition;
        if (iT0 == -1) {
            return iT0;
        }
        String strC = C();
        while (iT0 < strC.length()) {
            char cCharAt = strC.charAt(iT0);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                if (cCharAt != '/' || (i10 = iT0 + 1) >= strC.length()) {
                    break;
                }
                char cCharAt2 = strC.charAt(i10);
                if (cCharAt2 == '*') {
                    int iU0 = La.H.u0(strC, "*/", iT0 + 2, false, 4, null);
                    if (iU0 == -1) {
                        this.currentPosition = strC.length();
                        JsonReader.z(this, "Expected end of the block comment: \"*/\", but had EOF instead", 0, null, 6, null);
                        throw new KotlinNothingValueException();
                    }
                    iT0 = iU0 + 2;
                } else {
                    if (cCharAt2 != '/') {
                        break;
                    }
                    iT0 = La.H.t0(strC, '\n', iT0 + 2, false, 4, null);
                    if (iT0 == -1) {
                        iT0 = strC.length();
                    }
                }
            }
            iT0++;
        }
        this.currentPosition = iT0;
        return iT0;
    }

    @Override // rb.L, rb.JsonReader
    public boolean f() {
        int iJ = J();
        if (iJ >= C().length() || iJ == -1) {
            return false;
        }
        return D(C().charAt(iJ));
    }

    @Override // rb.L, rb.JsonReader
    public byte k() {
        String strC = C();
        int iJ = J();
        if (iJ >= strC.length() || iJ == -1) {
            return (byte) 10;
        }
        this.currentPosition = iJ + 1;
        return C5252b.a(strC.charAt(iJ));
    }

    @Override // rb.L, rb.JsonReader
    public void m(char expected) {
        String strC = C();
        int iJ = J();
        if (iJ >= strC.length() || iJ == -1) {
            this.currentPosition = -1;
            P(expected);
        }
        char cCharAt = strC.charAt(iJ);
        this.currentPosition = iJ + 1;
        if (cCharAt == expected) {
            return;
        }
        P(expected);
    }
}
