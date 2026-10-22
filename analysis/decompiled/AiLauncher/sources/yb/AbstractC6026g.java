package yb;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.core.download.ModelFlowMeta;
import java.io.IOException;
import kotlin.Metadata;
import tb.C5532E;
import tb.InterfaceC5538e;
import tb.InterfaceC5543j;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b \u0018\u0000 \u001a2\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\r\u001a\u00060\u000bj\u0002`\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0019\u0010\u0015¨\u0006\u001b"}, d2 = {"Lyb/g;", "", "<init>", "()V", "Ltb/E;", M5.a.CARD_TYPE_ROUTE, "Ltb/e;", "call", "LY8/t;", Const.INTENT_KEY_UMID, "(Ltb/E;Ltb/e;)V", "Ljava/io/IOException;", "Lokio/IOException;", "failure", "c", "(Ltb/E;Ltb/e;Ljava/io/IOException;)V", "Ltb/j;", "connection", Const.INTENT_KEY_PKGNAME, "(Ltb/j;Ltb/E;Ltb/e;)V", "f", "(Ltb/j;)V", "e", "(Ltb/j;Ltb/e;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_APIKEY, "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: yb.g, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC6026g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    public static final AbstractC6026g f44176b = new a();

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"yb/g$a", "Lyb/g;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: yb.g$a */
    public static final class a extends AbstractC6026g {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lyb/g$b;", "", "<init>", "()V", "Lyb/g;", ModelFlowMeta.PLAN_NONE, "Lyb/g;", Const.INTENT_KEY_APIKEY, "()Lyb/g;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: yb.g$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final AbstractC6026g a() {
            return AbstractC6026g.f44176b;
        }

        public Companion() {
        }
    }

    public void b(InterfaceC5543j connection, C5532E route, InterfaceC5538e call) {
        kotlin.jvm.internal.p.i(connection, "connection");
        kotlin.jvm.internal.p.i(route, "route");
        kotlin.jvm.internal.p.i(call, "call");
    }

    public void c(C5532E route, InterfaceC5538e call, IOException failure) {
        kotlin.jvm.internal.p.i(route, "route");
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(failure, "failure");
    }

    public void d(C5532E route, InterfaceC5538e call) {
        kotlin.jvm.internal.p.i(route, "route");
        kotlin.jvm.internal.p.i(call, "call");
    }

    public void e(InterfaceC5543j connection, InterfaceC5538e call) {
        kotlin.jvm.internal.p.i(connection, "connection");
        kotlin.jvm.internal.p.i(call, "call");
    }

    public void f(InterfaceC5543j connection) {
        kotlin.jvm.internal.p.i(connection, "connection");
    }

    public void g(InterfaceC5543j connection, InterfaceC5538e call) {
        kotlin.jvm.internal.p.i(connection, "connection");
        kotlin.jvm.internal.p.i(call, "call");
    }

    public void h(InterfaceC5543j connection) {
        kotlin.jvm.internal.p.i(connection, "connection");
    }
}
