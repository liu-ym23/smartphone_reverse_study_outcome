package l9;

import La.C0953c;
import Y8.t;
import Z8.C1168p;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.auth.HttpAuthHeader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001b\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\f\u001a#\u0010\r\u001a\u00020\n*\u00020\u00002\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\f\u001a#\u0010\u000f\u001a\u00020\n*\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001b\u0010\u0013\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011*\u00020\u0004H\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a/\u0010\u001d\u001a\u00020\n*\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u001b¢\u0006\u0004\b\u001d\u0010\u001e\u001a!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u001f*\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Ljava/io/File;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/io/File;)[B", "Ljava/nio/charset/Charset;", HttpAuthHeader.Parameters.Charset, "", "n", "(Ljava/io/File;Ljava/nio/charset/Charset;)Ljava/lang/String;", "text", "LY8/t;", "p", "(Ljava/io/File;Ljava/lang/String;Ljava/nio/charset/Charset;)V", "e", "Ljava/io/OutputStream;", "r", "(Ljava/io/OutputStream;Ljava/lang/String;Ljava/nio/charset/Charset;)V", "Ljava/nio/charset/CharsetEncoder;", "kotlin.jvm.PlatformType", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/nio/charset/Charset;)Ljava/nio/charset/CharsetEncoder;", "", "chunkSize", "encoder", "Ljava/nio/ByteBuffer;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(ILjava/nio/charset/CharsetEncoder;)Ljava/nio/ByteBuffer;", "Lkotlin/Function1;", "action", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/io/File;Ljava/nio/charset/Charset;Lp9/l;)V", "", "k", "(Ljava/io/File;Ljava/nio/charset/Charset;)Ljava/util/List;", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/io/FilesKt")
/* loaded from: classes4.dex */
public class i extends g {
    public static final void e(File file, String text, Charset charset) throws IOException {
        p.i(file, "<this>");
        p.i(text, "text");
        p.i(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        try {
            r(fileOutputStream, text, charset);
            t tVar = t.f7040a;
            b.a(fileOutputStream, null);
        } finally {
        }
    }

    public static /* synthetic */ void f(File file, String str, Charset charset, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            charset = C0953c.UTF_8;
        }
        e(file, str, charset);
    }

    public static final ByteBuffer g(int i10, CharsetEncoder encoder) {
        p.i(encoder, "encoder");
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i10 * ((int) Math.ceil(encoder.maxBytesPerChar())));
        p.h(byteBufferAllocate, "allocate(...)");
        return byteBufferAllocate;
    }

    public static final void h(File file, Charset charset, InterfaceC5074l<? super String, t> action) {
        p.i(file, "<this>");
        p.i(charset, "charset");
        p.i(action, "action");
        m.c(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)), action);
    }

    public static final CharsetEncoder i(Charset charset) {
        p.i(charset, "<this>");
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        return charsetEncoderNewEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
    }

    public static byte[] j(File file) throws IOException {
        p.i(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i10 = (int) length;
            byte[] bArrE = new byte[i10];
            int i11 = i10;
            int i12 = 0;
            while (i11 > 0) {
                int i13 = fileInputStream.read(bArrE, i12, i11);
                if (i13 < 0) {
                    break;
                }
                i11 -= i13;
                i12 += i13;
            }
            if (i11 > 0) {
                bArrE = Arrays.copyOf(bArrE, i12);
                p.h(bArrE, "copyOf(...)");
            } else {
                int i14 = fileInputStream.read();
                if (i14 != -1) {
                    d dVar = new d(8193);
                    dVar.write(i14);
                    C4877a.b(fileInputStream, dVar, 0, 2, null);
                    int size = dVar.size() + i10;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] bArrB = dVar.b();
                    byte[] bArrCopyOf = Arrays.copyOf(bArrE, size);
                    p.h(bArrCopyOf, "copyOf(...)");
                    bArrE = C1168p.e(bArrB, bArrCopyOf, i10, 0, dVar.size());
                }
            }
            b.a(fileInputStream, null);
            return bArrE;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                b.a(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static final List<String> k(File file, Charset charset) {
        p.i(file, "<this>");
        p.i(charset, "charset");
        final ArrayList arrayList = new ArrayList();
        h(file, charset, new InterfaceC5074l() { // from class: l9.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return i.m(arrayList, (String) obj);
            }
        });
        return arrayList;
    }

    public static /* synthetic */ List l(File file, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = C0953c.UTF_8;
        }
        return k(file, charset);
    }

    public static final t m(ArrayList arrayList, String it) {
        p.i(it, "it");
        arrayList.add(it);
        return t.f7040a;
    }

    public static String n(File file, Charset charset) throws IOException {
        p.i(file, "<this>");
        p.i(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String strE = m.e(inputStreamReader);
            b.a(inputStreamReader, null);
            return strE;
        } finally {
        }
    }

    public static /* synthetic */ String o(File file, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = C0953c.UTF_8;
        }
        return n(file, charset);
    }

    public static final void p(File file, String text, Charset charset) throws IOException {
        p.i(file, "<this>");
        p.i(text, "text");
        p.i(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            r(fileOutputStream, text, charset);
            t tVar = t.f7040a;
            b.a(fileOutputStream, null);
        } finally {
        }
    }

    public static /* synthetic */ void q(File file, String str, Charset charset, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            charset = C0953c.UTF_8;
        }
        p(file, str, charset);
    }

    public static final void r(OutputStream outputStream, String text, Charset charset) throws IOException {
        p.i(outputStream, "<this>");
        p.i(text, "text");
        p.i(charset, "charset");
        if (text.length() < 16384) {
            byte[] bytes = text.getBytes(charset);
            p.h(bytes, "getBytes(...)");
            outputStream.write(bytes);
            return;
        }
        CharsetEncoder charsetEncoderI = i(charset);
        CharBuffer charBufferAllocate = CharBuffer.allocate(com.stepos.agentframework.chatui.longtext.b.THRESHOLD);
        p.f(charsetEncoderI);
        ByteBuffer byteBufferG = g(com.stepos.agentframework.chatui.longtext.b.THRESHOLD, charsetEncoderI);
        int i10 = 0;
        int i11 = 0;
        while (i10 < text.length()) {
            int iMin = Math.min(8192 - i11, text.length() - i10);
            int i12 = i10 + iMin;
            char[] cArrArray = charBufferAllocate.array();
            p.h(cArrArray, "array(...)");
            text.getChars(i10, i12, cArrArray, i11);
            charBufferAllocate.limit(iMin + i11);
            i11 = 1;
            if (!charsetEncoderI.encode(charBufferAllocate, byteBufferG, i12 == text.length()).isUnderflow()) {
                throw new IllegalStateException("Check failed.");
            }
            outputStream.write(byteBufferG.array(), 0, byteBufferG.position());
            if (charBufferAllocate.position() != charBufferAllocate.limit()) {
                charBufferAllocate.put(0, charBufferAllocate.get());
            } else {
                i11 = 0;
            }
            charBufferAllocate.clear();
            byteBufferG.clear();
            i10 = i12;
        }
    }
}
