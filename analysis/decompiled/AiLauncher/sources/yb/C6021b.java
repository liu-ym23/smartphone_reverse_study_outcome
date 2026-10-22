package yb;

import Mb.H;
import Mb.InterfaceC0967e;
import Mb.InterfaceC0968f;
import com.autonavi.aps.amapapi.config.Const;
import java.net.Socket;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Ljava/net/Socket;", "Lyb/a;", Const.INTENT_KEY_PKGNAME, "(Ljava/net/Socket;)Lyb/a;", "LMb/H;", Const.INTENT_KEY_APIKEY, "(LMb/H;)Lyb/a;", "okhttp"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* renamed from: yb.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6021b {

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0013\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0006\u0010\u0012¨\u0006\u0014"}, d2 = {"yb/b$a", "Lyb/a;", "LY8/t;", "cancel", "()V", "LMb/H;", Const.INTENT_KEY_APIKEY, "LMb/H;", "delegate", "LMb/f;", Const.INTENT_KEY_PKGNAME, "LMb/f;", "e", "()LMb/f;", "source", "LMb/e;", "c", "LMb/e;", "()LMb/e;", "sink", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: yb.b$a */
    public static final class a implements InterfaceC6020a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final H delegate;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC0968f source;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC0967e sink;

        public a(H h10) {
            this.delegate = h10;
            this.source = Mb.u.c(h10.getSource());
            this.sink = Mb.u.b(h10.getSink());
        }

        @Override // Mb.H
        public void cancel() {
            this.delegate.cancel();
        }

        @Override // Mb.H
        /* renamed from: a, reason: from getter */
        public InterfaceC0967e getSink() {
            return this.sink;
        }

        @Override // Mb.H
        /* renamed from: e, reason: from getter */
        public InterfaceC0968f getSource() {
            return this.source;
        }
    }

    public static final InterfaceC6020a a(H h10) {
        kotlin.jvm.internal.p.i(h10, "<this>");
        return new a(h10);
    }

    public static final InterfaceC6020a b(Socket socket) {
        kotlin.jvm.internal.p.i(socket, "<this>");
        return a(Mb.u.j(socket));
    }
}
