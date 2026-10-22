package z1;

import F1.j;
import Mb.InterfaceC0967e;
import Mb.InterfaceC0968f;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.IOException;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import tb.C5530C;
import tb.C5537d;
import tb.u;
import tb.x;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010!\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001dR\u0017\u0010&\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010+\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lz1/c;", "", "LMb/f;", "source", "<init>", "(LMb/f;)V", "Ltb/C;", UxipConstants.f30685x, "(Ltb/C;)V", "LMb/e;", "sink", "LY8/t;", "k", "(LMb/e;)V", "Ltb/d;", Const.INTENT_KEY_APIKEY, "LY8/h;", "e", "()Ltb/d;", "cacheControl", "Ltb/x;", Const.INTENT_KEY_PKGNAME, "f", "()Ltb/x;", "contentType", "", "c", "J", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()J", "sentRequestAtMillis", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_COMMAND, "receivedResponseAtMillis", "", "Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Z", "isTls", "Ltb/u;", "Ltb/u;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ltb/u;", "responseHeaders", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: z1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6053c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Y8.h cacheControl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Y8.h contentType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final long sentRequestAtMillis;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final long receivedResponseAtMillis;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final boolean isTls;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final u responseHeaders;

    public C6053c(InterfaceC0968f interfaceC0968f) throws NumberFormatException {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.cacheControl = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: z1.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C6053c.c(this.f44563a);
            }
        });
        this.contentType = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: z1.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C6053c.d(this.f44564a);
            }
        });
        this.sentRequestAtMillis = Long.parseLong(interfaceC0968f.h0());
        this.receivedResponseAtMillis = Long.parseLong(interfaceC0968f.h0());
        this.isTls = Integer.parseInt(interfaceC0968f.h0()) > 0;
        int i10 = Integer.parseInt(interfaceC0968f.h0());
        u.a aVar = new u.a();
        for (int i11 = 0; i11 < i10; i11++) {
            j.b(aVar, interfaceC0968f.h0());
        }
        this.responseHeaders = aVar.f();
    }

    public static final C5537d c(C6053c c6053c) {
        return C5537d.INSTANCE.a(c6053c.responseHeaders);
    }

    public static final x d(C6053c c6053c) {
        String strB = c6053c.responseHeaders.b("Content-Type");
        if (strB != null) {
            return x.INSTANCE.b(strB);
        }
        return null;
    }

    public final C5537d e() {
        return (C5537d) this.cacheControl.getValue();
    }

    public final x f() {
        return (x) this.contentType.getValue();
    }

    /* renamed from: g, reason: from getter */
    public final long getReceivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    /* renamed from: h, reason: from getter */
    public final u getResponseHeaders() {
        return this.responseHeaders;
    }

    /* renamed from: i, reason: from getter */
    public final long getSentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsTls() {
        return this.isTls;
    }

    public final void k(InterfaceC0967e sink) throws IOException {
        sink.s0(this.sentRequestAtMillis).writeByte(10);
        sink.s0(this.receivedResponseAtMillis).writeByte(10);
        sink.s0(this.isTls ? 1L : 0L).writeByte(10);
        sink.s0(this.responseHeaders.size()).writeByte(10);
        int size = this.responseHeaders.size();
        for (int i10 = 0; i10 < size; i10++) {
            sink.L(this.responseHeaders.f(i10)).L(": ").L(this.responseHeaders.k(i10)).writeByte(10);
        }
    }

    public C6053c(C5530C c5530c) {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.cacheControl = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: z1.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C6053c.c(this.f44563a);
            }
        });
        this.contentType = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: z1.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C6053c.d(this.f44564a);
            }
        });
        this.sentRequestAtMillis = c5530c.getSentRequestAtMillis();
        this.receivedResponseAtMillis = c5530c.getReceivedResponseAtMillis();
        this.isTls = c5530c.getHandshake() != null;
        this.responseHeaders = c5530c.getHeaders();
    }
}
