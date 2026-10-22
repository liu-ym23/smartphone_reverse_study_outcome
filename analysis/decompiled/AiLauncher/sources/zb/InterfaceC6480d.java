package zb;

import Mb.G;
import Mb.H;
import Mb.I;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.IOException;
import kotlin.Metadata;
import tb.C5528A;
import tb.C5530C;
import tb.C5532E;
import yb.C6032m;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0016J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010\rJ\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\tH&¢\u0006\u0004\b\u001b\u0010\rR\u0014\u0010\u001f\u001a\u00020\u001c8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u000f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006'À\u0006\u0001"}, d2 = {"Lzb/d;", "", "Ltb/A;", "request", "", "contentLength", "LMb/G;", Const.INTENT_KEY_PKGNAME, "(Ltb/A;J)LMb/G;", "LY8/t;", "e", "(Ltb/A;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()V", Const.INTENT_KEY_UMID, "", "expectContinue", "Ltb/C$a;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Z)Ltb/C$a;", "Ltb/C;", UxipConstants.f30685x, Const.INTENT_KEY_APIKEY, "(Ltb/C;)J", "LMb/I;", "c", "(Ltb/C;)LMb/I;", "cancel", "Lzb/d$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Lzb/d$a;", "carrier", "f", "()Z", "isResponseComplete", "LMb/H;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()LMb/H;", "socket", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: zb.d, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC6480d {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\nR\u0014\u0010\u000e\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Lzb/d$a;", "", "Lyb/m;", "call", "Ljava/io/IOException;", "e", "LY8/t;", Const.INTENT_KEY_UMID, "(Lyb/m;Ljava/io/IOException;)V", Const.INTENT_KEY_PKGNAME, "()V", "cancel", "Ltb/E;", "()Ltb/E;", M5.a.CARD_TYPE_ROUTE, "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: zb.d$a */
    public interface a {
        void b();

        void cancel();

        void d(C6032m call, IOException e10);

        /* renamed from: e */
        C5532E getM5.a.CARD_TYPE_ROUTE java.lang.String();
    }

    long a(C5530C response) throws IOException;

    G b(C5528A request, long contentLength) throws IOException;

    I c(C5530C response) throws IOException;

    void cancel();

    void d() throws IOException;

    void e(C5528A request) throws IOException;

    boolean f();

    C5530C.a g(boolean expectContinue) throws IOException;

    void h() throws IOException;

    H i();

    /* renamed from: j */
    a getCarrier();
}
