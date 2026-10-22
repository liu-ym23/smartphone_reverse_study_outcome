package okhttp3;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

/* JADX INFO: compiled from: EventListener.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class r {
    public static final a Companion = null;
    public static final r NONE = null;

    /* JADX INFO: compiled from: EventListener.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: EventListener.kt */
    public static final class b extends r {
        b() {
        }
    }

    /* JADX INFO: compiled from: EventListener.kt */
    public interface c {
        r create(e r1);
    }

    public void cacheConditionalHit(e r2, ad r3) {
        d.h.b.o.e((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin"), "call");
        d.h.b.o.e(r3, "cachedResponse");
    }

    public void cacheHit(e r2, ad r3) {
        d.h.b.o.e((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin"), "call");
        d.h.b.o.e(r3, "response");
    }

    public void cacheMiss(e r2) {
        d.h.b.o.e((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin"), "call");
    }

    public void callEnd(e r2) {
        d.h.b.o.e((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin"), "call");
    }

    public void callFailed(e r2, IOException r3) {
        d.h.b.o.e((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin"), "call");
        d.h.b.o.e(r3, "ioe");
    }

    public void callStart(e r2) {
        d.h.b.o.e((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin"), "call");
    }

    public void canceled(e r2) {
        d.h.b.o.e((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin"), "call");
    }

    public void connectEnd(e r1, InetSocketAddress r2, Proxy r3, aa r4) {
        d.h.b.o.e((e) ZeusTransformUtils.wrapperContextForParams(r1, e.class, "com.obric.aiagent.plugin"), "call");
        d.h.b.o.e(r2, "inetSocketAddress");
        d.h.b.o.e(r3, "proxy");
    }

    public void connectFailed(e r1, InetSocketAddress r2, Proxy r3, aa r4, IOException r5) {
        d.h.b.o.e((e) ZeusTransformUtils.wrapperContextForParams(r1, e.class, "com.obric.aiagent.plugin"), "call");
        d.h.b.o.e(r2, "inetSocketAddress");
        d.h.b.o.e(r3, "proxy");
        d.h.b.o.e(r5, "ioe");
    }

    public void connectStart(e r2, InetSocketAddress r3, Proxy r4) {
        d.h.b.o.e((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin"), "call");
        d.h.b.o.e(r3, "inetSocketAddress");
        d.h.b.o.e(r4, "proxy");
    }

    public void connectionAcquired(e r2, j r3) {
        e r1 = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin");
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "call");
        d.h.b.o.e(r4, WsConstants.KEY_CONNECTION);
    }

    public void connectionReleased(e r2, j r3) {
        e r1 = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin");
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "call");
        d.h.b.o.e(r4, WsConstants.KEY_CONNECTION);
    }

    public void dnsEnd(e r2, String r3, List<InetAddress> r4) {
        e r1 = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "call");
        d.h.b.o.e(r3, "domainName");
        d.h.b.o.e(r5, "inetAddressList");
    }

    public void dnsStart(e r2, String r3) {
        d.h.b.o.e((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin"), "call");
        d.h.b.o.e(r3, "domainName");
    }

    public void proxySelectEnd(e r2, v r3, List<Proxy> r4) {
        e r1 = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "call");
        d.h.b.o.e(r3, "url");
        d.h.b.o.e(r5, "proxies");
    }

    public void proxySelectStart(e r2, v r3) {
        d.h.b.o.e((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin"), "call");
        d.h.b.o.e(r3, "url");
    }

    public void requestBodyEnd(e r1, long r2) {
        d.h.b.o.e((e) ZeusTransformUtils.wrapperContextForParams(r1, e.class, "com.obric.aiagent.plugin"), "call");
    }

    public void requestBodyStart(e r2) {
        d.h.b.o.e((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin"), "call");
    }

    public void requestFailed(e r2, IOException r3) {
        d.h.b.o.e((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin"), "call");
        d.h.b.o.e(r3, "ioe");
    }

    public void requestHeadersEnd(e r2, ab r3) {
        d.h.b.o.e((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin"), "call");
        d.h.b.o.e(r3, Ext.KEY_REQUEST);
    }

    public void requestHeadersStart(e r2) {
        d.h.b.o.e((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin"), "call");
    }

    public void responseBodyEnd(e r1, long r2) {
        d.h.b.o.e((e) ZeusTransformUtils.wrapperContextForParams(r1, e.class, "com.obric.aiagent.plugin"), "call");
    }

    public void responseBodyStart(e r2) {
        d.h.b.o.e((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin"), "call");
    }

    public void responseFailed(e r2, IOException r3) {
        d.h.b.o.e((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin"), "call");
        d.h.b.o.e(r3, "ioe");
    }

    public void responseHeadersEnd(e r2, ad r3) {
        d.h.b.o.e((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin"), "call");
        d.h.b.o.e(r3, "response");
    }

    public void responseHeadersStart(e r2) {
        d.h.b.o.e((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin"), "call");
    }

    public void satisfactionFailure(e r2, ad r3) {
        d.h.b.o.e((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin"), "call");
        d.h.b.o.e(r3, "response");
    }

    public void secureConnectEnd(e r1, t r2) {
        d.h.b.o.e((e) ZeusTransformUtils.wrapperContextForParams(r1, e.class, "com.obric.aiagent.plugin"), "call");
    }

    public void secureConnectStart(e r2) {
        d.h.b.o.e((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin"), "call");
    }

    public r() {
    }

    static {
        Companion = new a(null);
        NONE = (r) ZeusTransformUtils.preCheckCast(new b(), r.class, "com.obric.aiagent.plugin");
    }
}
