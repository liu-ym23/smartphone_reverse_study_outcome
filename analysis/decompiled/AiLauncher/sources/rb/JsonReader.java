package rb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlinx.serialization.json.internal.JsonDecodingException;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b+\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010\u0003J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004H&¢\u0006\u0004\b$\u0010\u0014J\u000f\u0010%\u001a\u00020\u000fH&¢\u0006\u0004\b%\u0010\u0011J\u000f\u0010'\u001a\u00020&H&¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u000f¢\u0006\u0004\b)\u0010\u0011J\u0017\u0010+\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020*H\u0004¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\u001f¢\u0006\u0004\b-\u0010\u0003J\u0015\u0010/\u001a\u00020&2\u0006\u0010.\u001a\u00020&¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020*H&¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020*H\u0004¢\u0006\u0004\b3\u00102J\u000f\u00104\u001a\u00020&H\u0016¢\u0006\u0004\b4\u0010(J\u0017\u00106\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u000f¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0004H&¢\u0006\u0004\b8\u00109J!\u0010<\u001a\u0004\u0018\u00010\n2\u0006\u0010:\u001a\u00020\n2\u0006\u0010;\u001a\u00020\u000fH&¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\u0004\u0018\u00010\n2\u0006\u0010;\u001a\u00020\u000f¢\u0006\u0004\b>\u0010?J\r\u0010@\u001a\u00020\u001f¢\u0006\u0004\b@\u0010\u0003J\u001f\u0010B\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u0004H\u0016¢\u0006\u0004\bB\u0010\fJ\u000f\u0010C\u001a\u00020\nH&¢\u0006\u0004\bC\u0010\u000eJ\r\u0010D\u001a\u00020\n¢\u0006\u0004\bD\u0010\u000eJ'\u0010E\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0005¢\u0006\u0004\bE\u0010FJ\r\u0010G\u001a\u00020\n¢\u0006\u0004\bG\u0010\u000eJ\r\u0010H\u001a\u00020\n¢\u0006\u0004\bH\u0010\u000eJ\u001f\u0010K\u001a\u00020\u001f2\u0006\u0010I\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u0004H\u0014¢\u0006\u0004\bK\u0010LJ\u0015\u0010N\u001a\u00020\u001f2\u0006\u0010M\u001a\u00020\u000f¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020\nH\u0016¢\u0006\u0004\bP\u0010\u000eJ\u0015\u0010R\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020\n¢\u0006\u0004\bR\u0010SJ)\u0010W\u001a\u00020V2\u0006\u0010T\u001a\u00020\n2\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010U\u001a\u00020\n¢\u0006\u0004\bW\u0010XJ\r\u0010Z\u001a\u00020Y¢\u0006\u0004\bZ\u0010[J\r\u0010\\\u001a\u00020Y¢\u0006\u0004\b\\\u0010[J\r\u0010]\u001a\u00020\u000f¢\u0006\u0004\b]\u0010\u0011R\u0016\u0010\t\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b^\u0010NR\u0014\u0010a\u001a\u00020_8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010`R\u0018\u0010c\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010bR&\u0010k\u001a\u00060dj\u0002`e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u0014\u0010\u0016\u001a\u00020\u00158$X¤\u0004¢\u0006\u0006\u001a\u0004\bl\u0010m¨\u0006n"}, d2 = {"Lrb/a;", "", "<init>", "()V", "", "lastPosition", "current", "c", "(II)I", "currentPosition", "", "u", "(II)Ljava/lang/String;", "L", "()Ljava/lang/String;", "", "Q", "()Z", "startPosition", Const.INTENT_KEY_PKGNAME, "(I)I", "", "source", "startPos", Const.INTENT_KEY_UMID, "(Ljava/lang/CharSequence;I)I", "B", "start", Const.INTENT_KEY_BACKGROUND_COMMAND, "(I)Z", "literalSuffix", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;I)V", "w", "position", "H", "f", "", "k", "()B", "M", "", "D", "(C)Z", "x", "expected", "l", "(B)B", "m", "(C)V", "P", "F", "doConsume", "N", "(Z)Z", "J", "()I", "keyToMatch", "isLenient", ExifInterface.LONGITUDE_EAST, "(Ljava/lang/String;Z)Ljava/lang/String;", "G", "(Z)Ljava/lang/String;", "v", "endPos", "K", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "q", "r", "(Ljava/lang/CharSequence;II)Ljava/lang/String;", "t", "s", "fromIndex", "toIndex", "e", "(II)V", "allowLenientStrings", "I", "(Z)V", "toString", "key", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;)V", "message", "hint", "", "y", "(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/Void;", "", "n", "()J", "p", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_APIKEY, "Lrb/v;", "Lrb/v;", "path", "Ljava/lang/String;", "peekedString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Ljava/lang/StringBuilder;", "getEscapedString", "()Ljava/lang/StringBuilder;", "setEscapedString", "(Ljava/lang/StringBuilder;)V", "escapedString", "C", "()Ljava/lang/CharSequence;", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: rb.a, reason: case insensitive filesystem and from toString */
/* loaded from: classes5.dex */
public abstract class JsonReader {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public int currentPosition;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public String peekedString;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final v path = new v();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public StringBuilder escapedString = new StringBuilder();

    public static /* synthetic */ boolean O(JsonReader jsonReader, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryConsumeNull");
        }
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return jsonReader.N(z10);
    }

    public static final double o(long j10, boolean z10) {
        if (!z10) {
            return Math.pow(10.0d, -j10);
        }
        if (z10) {
            return Math.pow(10.0d, j10);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ Void z(JsonReader jsonReader, String str, int i10, String str2, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
        }
        if ((i11 & 2) != 0) {
            i10 = jsonReader.currentPosition;
        }
        if ((i11 & 4) != 0) {
            str2 = "";
        }
        return jsonReader.y(str, i10, str2);
    }

    public final void A(String key) {
        kotlin.jvm.internal.p.i(key, "key");
        int iB0 = La.H.B0(K(0, this.currentPosition), key, 0, false, 6, null);
        throw new JsonDecodingException("Encountered an unknown key '" + key + "' at offset " + iB0 + " at path: " + this.path.a() + "\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder or '@JsonIgnoreUnknownKeys' annotation to ignore unknown keys.\nJSON input: " + ((Object) C5268s.i(C(), iB0)));
    }

    public final int B(CharSequence source, int currentPosition) {
        char cCharAt = source.charAt(currentPosition);
        if ('0' <= cCharAt && cCharAt < ':') {
            return cCharAt - '0';
        }
        if ('a' <= cCharAt && cCharAt < 'g') {
            return cCharAt - 'W';
        }
        if ('A' <= cCharAt && cCharAt < 'G') {
            return cCharAt - '7';
        }
        z(this, "Invalid toHexChar char '" + cCharAt + "' in unicode escape", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public abstract CharSequence C();

    public final boolean D(char c10) {
        return (c10 == ',' || c10 == ':' || c10 == ']' || c10 == '}') ? false : true;
    }

    public abstract String E(String keyToMatch, boolean isLenient);

    public byte F() {
        CharSequence charSequenceC = C();
        int i10 = this.currentPosition;
        while (true) {
            int iH = H(i10);
            if (iH == -1) {
                this.currentPosition = iH;
                return (byte) 10;
            }
            char cCharAt = charSequenceC.charAt(iH);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != ' ') {
                this.currentPosition = iH;
                return C5252b.a(cCharAt);
            }
            i10 = iH + 1;
        }
    }

    public final String G(boolean isLenient) {
        String strQ;
        byte bF = F();
        if (isLenient) {
            if (bF != 1 && bF != 0) {
                return null;
            }
            strQ = s();
        } else {
            if (bF != 1) {
                return null;
            }
            strQ = q();
        }
        this.peekedString = strQ;
        return strQ;
    }

    public abstract int H(int position);

    public final void I(boolean allowLenientStrings) {
        JsonReader jsonReader;
        ArrayList arrayList = new ArrayList();
        byte bF = F();
        if (bF != 8 && bF != 6) {
            s();
            return;
        }
        while (true) {
            byte bF2 = this.F();
            if (bF2 != 1) {
                if (bF2 == 8 || bF2 == 6) {
                    jsonReader = this;
                    arrayList.add(Byte.valueOf(bF2));
                } else {
                    if (bF2 == 9) {
                        if (((Number) Z8.F.C0(arrayList)).byteValue() != 8) {
                            throw C5268s.f(this.currentPosition, "found ] instead of } at path: " + this.path, this.C());
                        }
                        Z8.A.N(arrayList);
                    } else if (bF2 == 7) {
                        if (((Number) Z8.F.C0(arrayList)).byteValue() != 6) {
                            throw C5268s.f(this.currentPosition, "found } instead of ] at path: " + this.path, this.C());
                        }
                        Z8.A.N(arrayList);
                    } else if (bF2 == 10) {
                        z(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6, null);
                        throw new KotlinNothingValueException();
                    }
                    jsonReader = this;
                }
                jsonReader.k();
                if (arrayList.size() == 0) {
                    return;
                } else {
                    this = jsonReader;
                }
            } else if (allowLenientStrings) {
                this.s();
            } else {
                this.j();
            }
        }
    }

    public abstract int J();

    public String K(int startPos, int endPos) {
        return C().subSequence(startPos, endPos).toString();
    }

    public final String L() {
        String str = this.peekedString;
        kotlin.jvm.internal.p.f(str);
        this.peekedString = null;
        return str;
    }

    public final boolean M() {
        int iJ = J();
        CharSequence charSequenceC = C();
        if (iJ >= charSequenceC.length() || iJ == -1 || charSequenceC.charAt(iJ) != ',') {
            return false;
        }
        this.currentPosition++;
        return true;
    }

    public final boolean N(boolean doConsume) {
        int iH = H(J());
        int length = C().length() - iH;
        if (length < 4 || iH == -1) {
            return false;
        }
        for (int i10 = 0; i10 < 4; i10++) {
            if ("null".charAt(i10) != C().charAt(iH + i10)) {
                return false;
            }
        }
        if (length > 4 && C5252b.a(C().charAt(iH + 4)) == 0) {
            return false;
        }
        if (!doConsume) {
            return true;
        }
        this.currentPosition = iH + 4;
        return true;
    }

    public final void P(char expected) {
        int i10 = this.currentPosition;
        if (i10 > 0 && expected == '\"') {
            try {
                this.currentPosition = i10 - 1;
                String strS = s();
                this.currentPosition = i10;
                if (kotlin.jvm.internal.p.d(strS, "null")) {
                    y("Expected string literal but 'null' literal was found", this.currentPosition - 1, "Use 'coerceInputValues = true' in 'Json {}' builder to coerce nulls if property has a default value.");
                    throw new KotlinNothingValueException();
                }
            } catch (Throwable th) {
                this.currentPosition = i10;
                throw th;
            }
        }
        String strC = C5252b.c(C5252b.a(expected));
        int i11 = this.currentPosition;
        int i12 = i11 - 1;
        z(this, "Expected " + strC + ", but had '" + ((i11 == C().length() || i12 < 0) ? "EOF" : String.valueOf(C().charAt(i12))) + "' instead", i12, null, 4, null);
        throw new KotlinNothingValueException();
    }

    public final boolean Q() {
        return C().charAt(this.currentPosition - 1) != '\"';
    }

    public final int b(int startPosition) {
        int iH = H(startPosition);
        if (iH == -1) {
            z(this, "Expected escape sequence to continue, got EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int i10 = iH + 1;
        char cCharAt = C().charAt(iH);
        if (cCharAt == 'u') {
            return d(C(), i10);
        }
        char cB = C5252b.b(cCharAt);
        if (cB != 0) {
            this.escapedString.append(cB);
            return i10;
        }
        z(this, "Invalid escaped char '" + cCharAt + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public final int c(int lastPosition, int current) {
        e(lastPosition, current);
        return b(current + 1);
    }

    public final int d(CharSequence source, int startPos) {
        int i10 = startPos + 4;
        if (i10 < source.length()) {
            this.escapedString.append((char) ((B(source, startPos) << 12) + (B(source, startPos + 1) << 8) + (B(source, startPos + 2) << 4) + B(source, startPos + 3)));
            return i10;
        }
        this.currentPosition = startPos;
        w();
        if (this.currentPosition + 4 < source.length()) {
            return d(source, this.currentPosition);
        }
        z(this, "Unexpected EOF during unicode escape", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public void e(int fromIndex, int toIndex) {
        this.escapedString.append(C(), fromIndex, toIndex);
    }

    public abstract boolean f();

    public final boolean g(int start) {
        int iH = H(start);
        if (iH >= C().length() || iH == -1) {
            z(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int i10 = iH + 1;
        int iCharAt = C().charAt(iH) | ' ';
        if (iCharAt == 102) {
            i("alse", i10);
            return false;
        }
        if (iCharAt == 116) {
            i("rue", i10);
            return true;
        }
        z(this, "Expected valid boolean literal prefix, but had '" + s() + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public final boolean h() {
        boolean z10;
        int iJ = J();
        if (iJ == C().length()) {
            z(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        if (C().charAt(iJ) == '\"') {
            iJ++;
            z10 = true;
        } else {
            z10 = false;
        }
        boolean zG = g(iJ);
        if (!z10) {
            return zG;
        }
        if (this.currentPosition == C().length()) {
            z(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        if (C().charAt(this.currentPosition) == '\"') {
            this.currentPosition++;
            return zG;
        }
        z(this, "Expected closing quotation mark", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public final void i(String literalSuffix, int current) {
        if (C().length() - current < literalSuffix.length()) {
            z(this, "Unexpected end of boolean literal", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int length = literalSuffix.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (literalSuffix.charAt(i10) != (C().charAt(current + i10) | ' ')) {
                z(this, "Expected valid boolean literal prefix, but had '" + s() + '\'', 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
        }
        this.currentPosition = current + literalSuffix.length();
    }

    public abstract String j();

    public abstract byte k();

    public final byte l(byte expected) {
        byte bK = k();
        if (bK == expected) {
            return bK;
        }
        String strC = C5252b.c(expected);
        int i10 = this.currentPosition;
        int i11 = i10 - 1;
        z(this, "Expected " + strC + ", but had '" + ((i10 == C().length() || i11 < 0) ? "EOF" : String.valueOf(C().charAt(i11))) + "' instead", i11, null, 4, null);
        throw new KotlinNothingValueException();
    }

    public abstract void m(char expected);

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01f1, code lost:
    
        z(r18, "Expected numeric literal", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0201, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x011a, code lost:
    
        z(r18, "Unexpected symbol '" + r15 + "' in numeric literal", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x013e, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x013f, code lost:
    
        if (r2 == r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0141, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0143, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0144, code lost:
    
        if (r1 == r2) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0146, code lost:
    
        if (r9 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x014a, code lost:
    
        if (r1 == (r2 - 1)) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x014c, code lost:
    
        if (r0 == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x014e, code lost:
    
        if (r4 == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0158, code lost:
    
        if (C().charAt(r2) != '\"') goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x015a, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x015f, code lost:
    
        z(r18, "Expected closing quotation mark", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x016f, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0170, code lost:
    
        z(r18, "EOF", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0180, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0181, code lost:
    
        r18.currentPosition = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0183, code lost:
    
        if (r8 == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0185, code lost:
    
        r1 = r10 * o(r12, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x018f, code lost:
    
        if (r1 > 9.223372036854776E18d) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0195, code lost:
    
        if (r1 < (-9.223372036854776E18d)) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x019d, code lost:
    
        if (java.lang.Math.floor(r1) != r1) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x019f, code lost:
    
        r10 = (long) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01a1, code lost:
    
        z(r18, "Can't convert " + r1 + " to Long", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01c3, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01c4, code lost:
    
        z(r18, "Numeric value overflow", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01d4, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01d5, code lost:
    
        if (r9 == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01d7, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01dc, code lost:
    
        if (r10 == Long.MIN_VALUE) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01df, code lost:
    
        return -r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01e0, code lost:
    
        z(r18, "Numeric value overflow", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01f0, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long n() {
        /*
            Method dump skipped, instructions count: 531
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: rb.JsonReader.n():long");
    }

    public final long p() {
        long jN = n();
        if (k() == 10) {
            return jN;
        }
        C5252b.c((byte) 10);
        int i10 = this.currentPosition;
        int i11 = i10 - 1;
        z(this, "Expected input to contain a single valid number, but got '" + ((i10 == C().length() || i11 < 0) ? "EOF" : String.valueOf(C().charAt(i11))) + "' after it", i11, null, 4, null);
        throw new KotlinNothingValueException();
    }

    public final String q() {
        return this.peekedString != null ? L() : j();
    }

    public final String r(CharSequence source, int startPosition, int current) {
        JsonReader jsonReader;
        kotlin.jvm.internal.p.i(source, "source");
        char cCharAt = source.charAt(current);
        boolean z10 = false;
        while (cCharAt != '\"') {
            if (cCharAt == '\\') {
                int iH = this.H(this.c(startPosition, current));
                if (iH == -1) {
                    z(this, "Unexpected EOF", iH, null, 4, null);
                    throw new KotlinNothingValueException();
                }
                jsonReader = this;
                z10 = true;
                startPosition = iH;
                current = startPosition;
            } else {
                jsonReader = this;
                current++;
                if (current >= source.length()) {
                    jsonReader.e(startPosition, current);
                    int iH2 = jsonReader.H(current);
                    if (iH2 == -1) {
                        z(jsonReader, "Unexpected EOF", iH2, null, 4, null);
                        throw new KotlinNothingValueException();
                    }
                    startPosition = iH2;
                    current = startPosition;
                    z10 = true;
                } else {
                    continue;
                }
            }
            JsonReader jsonReader2 = jsonReader;
            cCharAt = source.charAt(current);
            this = jsonReader2;
        }
        JsonReader jsonReader3 = this;
        String strK = !z10 ? jsonReader3.K(startPosition, current) : jsonReader3.u(startPosition, current);
        jsonReader3.currentPosition = current + 1;
        return strK;
    }

    public final String s() {
        if (this.peekedString != null) {
            return L();
        }
        int iJ = J();
        if (iJ >= C().length() || iJ == -1) {
            z(this, "EOF", iJ, null, 4, null);
            throw new KotlinNothingValueException();
        }
        byte bA = C5252b.a(C().charAt(iJ));
        if (bA == 1) {
            return q();
        }
        if (bA != 0) {
            z(this, "Expected beginning of the string, but got " + C().charAt(iJ), 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        boolean z10 = false;
        while (C5252b.a(C().charAt(iJ)) == 0) {
            iJ++;
            if (iJ >= C().length()) {
                e(this.currentPosition, iJ);
                int iH = H(iJ);
                if (iH == -1) {
                    this.currentPosition = iJ;
                    return u(0, 0);
                }
                iJ = iH;
                z10 = true;
            }
        }
        String strK = !z10 ? K(this.currentPosition, iJ) : u(this.currentPosition, iJ);
        this.currentPosition = iJ;
        return strK;
    }

    public final String t() {
        String strS = s();
        if (!kotlin.jvm.internal.p.d(strS, "null") || !Q()) {
            return strS;
        }
        z(this, "Unexpected 'null' value instead of string literal", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public String toString() {
        return "JsonReader(source='" + ((Object) C()) + "', currentPosition=" + this.currentPosition + ')';
    }

    public final String u(int lastPosition, int currentPosition) {
        e(lastPosition, currentPosition);
        String string = this.escapedString.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        this.escapedString.setLength(0);
        return string;
    }

    public final void v() {
        this.peekedString = null;
    }

    public void w() {
    }

    public final void x() {
        if (k() == 10) {
            return;
        }
        z(this, "Expected EOF after parsing, but had " + C().charAt(this.currentPosition - 1) + " instead", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public final Void y(String message, int position, String hint) {
        String str;
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(hint, "hint");
        if (hint.length() == 0) {
            str = "";
        } else {
            str = '\n' + hint;
        }
        throw C5268s.f(position, message + " at path: " + this.path.a() + str, C());
    }
}
