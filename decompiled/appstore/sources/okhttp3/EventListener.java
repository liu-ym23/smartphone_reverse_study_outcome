package okhttp3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class EventListener {
    public static final EventListener NONE = null;

    public interface Factory {
        EventListener create(Call r10);
    }

    public static class a extends EventListener {
        public a() {
        }
    }

    public static class b implements Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EventListener f22692a;

        public b(EventListener r10) {
            this.f22692a = r10;
        }

        @Override // okhttp3.EventListener.Factory
        public EventListener create(Call r10) {
            return this.f22692a;
        }
    }

    static {
        NONE = new a();
    }

    public EventListener() {
    }

    public static Factory factory(EventListener r10) {
        return new b(r10);
    }

    public void callEnd(Call r10) {
    }

    public void callFailed(Call r10, IOException r11) {
    }

    public void callStart(Call r10) {
    }

    public void connectEnd(Call r10, InetSocketAddress r11, Proxy r12, Protocol r13) {
    }

    public void connectFailed(Call r10, InetSocketAddress r11, Proxy r12, Protocol r13, IOException r14) {
    }

    public void connectStart(Call r10, InetSocketAddress r11, Proxy r12) {
    }

    public void connectionAcquired(Call r10, Connection r11) {
    }

    public void connectionReleased(Call r10, Connection r11) {
    }

    public void dnsEnd(Call r10, String r11, List r12) {
    }

    public void dnsStart(Call r10, String r11) {
    }

    public void requestBodyEnd(Call r10, long r11) {
    }

    public void requestBodyStart(Call r10) {
    }

    public void requestHeadersEnd(Call r10, Request r11) {
    }

    public void requestHeadersStart(Call r10) {
    }

    public void responseBodyEnd(Call r10, long r11) {
    }

    public void responseBodyStart(Call r10) {
    }

    public void responseHeadersEnd(Call r10, Response r11) {
    }

    public void responseHeadersStart(Call r10) {
    }

    public void secureConnectEnd(Call r10, Handshake r11) {
    }

    public void secureConnectStart(Call r10) {
    }
}
