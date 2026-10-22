package z3;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class v0 extends w0 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6518b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6519c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0(h4.c response, String cachedResponseText, int i8) {
        super(response, cachedResponseText);
        this.f6518b = i8;
        switch (i8) {
            case 1:
                kotlin.jvm.internal.p.e(response, "response");
                kotlin.jvm.internal.p.e(cachedResponseText, "cachedResponseText");
                super(response, cachedResponseText);
                this.f6519c = "Server error(" + response.c().d().C().f3640a + ' ' + response.c().d().u() + ": " + response.g() + ". Text: \"" + cachedResponseText + AbstractJsonLexerKt.STRING;
                break;
            default:
                kotlin.jvm.internal.p.e(response, "response");
                kotlin.jvm.internal.p.e(cachedResponseText, "cachedResponseText");
                this.f6519c = "Unhandled redirect: " + response.c().d().C().f3640a + ' ' + response.c().d().u() + ". Status: " + response.g() + ". Text: \"" + cachedResponseText + AbstractJsonLexerKt.STRING;
                break;
        }
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        switch (this.f6518b) {
        }
        return this.f6519c;
    }
}
