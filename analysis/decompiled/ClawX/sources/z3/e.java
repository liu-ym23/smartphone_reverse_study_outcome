package z3;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e extends w0 {

    /* renamed from: b, reason: collision with root package name */
    public final String f6435b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h4.c response, String cachedResponseText) {
        super(response, cachedResponseText);
        kotlin.jvm.internal.p.e(response, "response");
        kotlin.jvm.internal.p.e(cachedResponseText, "cachedResponseText");
        this.f6435b = "Client request(" + response.c().d().C().f3640a + ' ' + response.c().d().u() + ") invalid: " + response.g() + ". Text: \"" + cachedResponseText + AbstractJsonLexerKt.STRING;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.f6435b;
    }
}
