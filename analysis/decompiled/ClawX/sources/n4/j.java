package n4;

import java.nio.charset.Charset;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j extends c {

    /* renamed from: a, reason: collision with root package name */
    public final String f3983a;

    /* renamed from: b, reason: collision with root package name */
    public final k4.g f3984b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f3985c;

    public j(String text, k4.g contentType) {
        p.e(text, "text");
        p.e(contentType, "contentType");
        this.f3983a = text;
        this.f3984b = contentType;
        Charset charsetF = a.a.f(contentType);
        this.f3985c = x.e.x0(text, charsetF == null ? x5.a.f6276a : charsetF);
    }

    @Override // n4.e
    public final Long a() {
        return Long.valueOf(this.f3985c.length);
    }

    @Override // n4.e
    public final k4.g b() {
        return this.f3984b;
    }

    @Override // n4.c
    public final byte[] d() {
        return this.f3985c;
    }

    public final String toString() {
        return "TextContent[" + this.f3984b + "] \"" + n.Q1(30, this.f3983a) + AbstractJsonLexerKt.STRING;
    }
}
