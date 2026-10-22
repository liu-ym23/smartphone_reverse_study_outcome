package Lb;

import Lb.b;
import Mb.J;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import tb.AbstractC5531D;
import tb.C5528A;
import tb.C5530C;
import tb.InterfaceC5538e;
import tb.InterfaceC5539f;
import tb.x;
import ub.i;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010 \u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u001cH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\f2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u0013\u0010(\u001a\u00020'*\u00020&H\u0002¢\u0006\u0004\b(\u0010)R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010*R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010+R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010,R\u0016\u0010.\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010-¨\u0006/"}, d2 = {"LLb/a;", "LKb/a;", "LLb/b$a;", "Ltb/f;", "Ltb/A;", "request", "LKb/b;", "listener", "<init>", "(Ltb/A;LKb/b;)V", "Ltb/e$a;", "callFactory", "LY8/t;", "e", "(Ltb/e$a;)V", "Ltb/e;", "call", "Ltb/C;", UxipConstants.f30685x, Const.INTENT_KEY_APIKEY, "(Ltb/e;Ltb/C;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ltb/C;)V", "Ljava/io/IOException;", Const.INTENT_KEY_UMID, "(Ltb/e;Ljava/io/IOException;)V", "cancel", "()V", "", "id", "type", "data", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "timeMs", Const.INTENT_KEY_PKGNAME, "(J)V", "Ltb/D;", "", "f", "(Ltb/D;)Z", "Ltb/A;", "LKb/b;", "Ltb/e;", "Z", "canceled", "okhttp-sse"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class a implements Kb.a, b.a, InterfaceC5539f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C5528A request;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Kb.b listener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public InterfaceC5538e call;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public volatile boolean canceled;

    public a(C5528A request, Kb.b listener) {
        p.i(request, "request");
        p.i(listener, "listener");
        this.request = request;
        this.listener = listener;
    }

    @Override // tb.InterfaceC5539f
    public void a(InterfaceC5538e call, C5530C response) throws IOException {
        p.i(call, "call");
        p.i(response, "response");
        g(response);
    }

    @Override // Lb.b.a
    public void b(long timeMs) {
    }

    @Override // Lb.b.a
    public void c(String id, String type, String data) {
        p.i(data, "data");
        this.listener.b(this, id, type, data);
    }

    @Override // Kb.a
    public void cancel() {
        this.canceled = true;
        InterfaceC5538e interfaceC5538e = this.call;
        if (interfaceC5538e != null) {
            interfaceC5538e.cancel();
        }
    }

    @Override // tb.InterfaceC5539f
    public void d(InterfaceC5538e call, IOException e10) {
        p.i(call, "call");
        p.i(e10, "e");
        this.listener.c(this, e10, null);
    }

    public final void e(InterfaceC5538e.a callFactory) {
        p.i(callFactory, "callFactory");
        InterfaceC5538e interfaceC5538eA = callFactory.a(this.request);
        interfaceC5538eA.J(this);
        this.call = interfaceC5538eA;
    }

    public final boolean f(AbstractC5531D abstractC5531D) {
        x mediaType = abstractC5531D.getMediaType();
        return mediaType != null && p.d(mediaType.getType(), "text") && p.d(mediaType.getSubtype(), "event-stream");
    }

    public final void g(C5530C response) throws IOException {
        J jC;
        p.i(response, "response");
        try {
            if (!response.getIsSuccessful()) {
                this.listener.c(this, null, response);
                l9.b.a(response, null);
                return;
            }
            AbstractC5531D body = response.getBody();
            if (!f(body)) {
                this.listener.c(this, new IllegalStateException("Invalid content-type: " + body.getMediaType()), response);
                l9.b.a(response, null);
                return;
            }
            InterfaceC5538e interfaceC5538e = this.call;
            if (interfaceC5538e != null && (jC = interfaceC5538e.c()) != null) {
                jC.a();
            }
            C5530C c5530cA = i.a(response);
            b bVar = new b(body.getSource(), this);
            try {
                if (!this.canceled) {
                    this.listener.d(this, c5530cA);
                    while (!this.canceled && bVar.d()) {
                    }
                }
                if (this.canceled) {
                    this.listener.c(this, new IOException("canceled"), c5530cA);
                } else {
                    this.listener.a(this);
                }
                t tVar = t.f7040a;
                l9.b.a(response, null);
            } catch (Exception e10) {
                e = e10;
                if (this.canceled) {
                    e = new IOException("canceled", e);
                }
                this.listener.c(this, e, c5530cA);
                l9.b.a(response, null);
            }
        } finally {
        }
    }
}
