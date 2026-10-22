package rb;

import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonFactory;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.util.Arrays;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0019\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0015H\u0002¢\u0006\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010#R\u0016\u0010&\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010%¨\u0006'"}, d2 = {"Lrb/A;", "Lrb/q;", "<init>", "()V", "", UxipConstants.f30680s, "LY8/t;", "writeLong", "(J)V", "", "char", Const.INTENT_KEY_APIKEY, "(C)V", "", "text", "c", "(Ljava/lang/String;)V", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_COMMAND, "toString", "()Ljava/lang/String;", "", "firstEscapedChar", "currentSize", "string", Const.INTENT_KEY_UMID, "(IILjava/lang/String;)V", "expected", "e", "(I)V", "oldSize", "additional", "f", "(II)I", "", "[C", "array", "I", ContentDisposition.Parameters.Size, "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: rb.A, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5246A implements InterfaceC5267q {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public char[] array = C5257g.f38983c.d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int size;

    @Override // rb.InterfaceC5267q
    public void a(char c10) {
        e(1);
        char[] cArr = this.array;
        int i10 = this.size;
        this.size = i10 + 1;
        cArr[i10] = c10;
    }

    @Override // rb.InterfaceC5267q
    public void b(String text) {
        kotlin.jvm.internal.p.i(text, "text");
        e(text.length() + 2);
        char[] cArr = this.array;
        int i10 = this.size;
        int i11 = i10 + 1;
        cArr[i10] = JsonFactory.DEFAULT_QUOTE_CHAR;
        int length = text.length();
        text.getChars(0, length, cArr, i11);
        int i12 = length + i11;
        for (int i13 = i11; i13 < i12; i13++) {
            char c10 = cArr[i13];
            if (c10 < O.a().length && O.a()[c10] != 0) {
                d(i13 - i11, i13, text);
                return;
            }
        }
        cArr[i12] = JsonFactory.DEFAULT_QUOTE_CHAR;
        this.size = i12 + 1;
    }

    @Override // rb.InterfaceC5267q
    public void c(String text) {
        kotlin.jvm.internal.p.i(text, "text");
        int length = text.length();
        if (length == 0) {
            return;
        }
        e(length);
        text.getChars(0, text.length(), this.array, this.size);
        this.size += length;
    }

    public final void d(int firstEscapedChar, int currentSize, String string) {
        byte b10;
        int length = string.length();
        while (firstEscapedChar < length) {
            int iF = f(currentSize, 2);
            char cCharAt = string.charAt(firstEscapedChar);
            if (cCharAt >= O.a().length || (b10 = O.a()[cCharAt]) == 0) {
                int i10 = iF + 1;
                this.array[iF] = cCharAt;
                currentSize = i10;
                firstEscapedChar++;
            } else {
                if (b10 == 1) {
                    String str = O.b()[cCharAt];
                    kotlin.jvm.internal.p.f(str);
                    int iF2 = f(iF, str.length());
                    str.getChars(0, str.length(), this.array, iF2);
                    currentSize = iF2 + str.length();
                    this.size = currentSize;
                } else {
                    char[] cArr = this.array;
                    cArr[iF] = '\\';
                    cArr[iF + 1] = (char) b10;
                    currentSize = iF + 2;
                    this.size = currentSize;
                }
                firstEscapedChar++;
            }
        }
        int iF3 = f(currentSize, 1);
        this.array[iF3] = JsonFactory.DEFAULT_QUOTE_CHAR;
        this.size = iF3 + 1;
    }

    public final void e(int expected) {
        f(this.size, expected);
    }

    public final int f(int oldSize, int additional) {
        int i10 = additional + oldSize;
        char[] cArr = this.array;
        if (cArr.length <= i10) {
            char[] cArrCopyOf = Arrays.copyOf(cArr, C5685n.f(i10, oldSize * 2));
            kotlin.jvm.internal.p.h(cArrCopyOf, "copyOf(...)");
            this.array = cArrCopyOf;
        }
        return oldSize;
    }

    public void g() {
        C5257g.f38983c.c(this.array);
    }

    public String toString() {
        return new String(this.array, 0, this.size);
    }

    @Override // rb.InterfaceC5267q
    public void writeLong(long value) {
        c(String.valueOf(value));
    }
}
