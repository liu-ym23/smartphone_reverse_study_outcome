package z3;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class w0 extends IllegalStateException {

    /* renamed from: a, reason: collision with root package name */
    public final transient h4.c f6523a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w0(h4.c response, String cachedResponseText) {
        super("Bad response: " + response + ". Text: \"" + cachedResponseText + AbstractJsonLexerKt.STRING);
        kotlin.jvm.internal.p.e(response, "response");
        kotlin.jvm.internal.p.e(cachedResponseText, "cachedResponseText");
        this.f6523a = response;
    }
}
