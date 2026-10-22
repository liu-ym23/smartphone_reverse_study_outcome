package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.spec.McpTransportException;
import java.lang.invoke.VarHandle;
import java.net.http.HttpResponse;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.FluxSink;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
class ResponseSubscribers {
    private static final rd.b logger = rd.d.b(ResponseSubscribers.class);

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class AggregateResponseEvent extends androidx.activity.b implements ResponseEvent {
        private final String data;
        private final HttpResponse.ResponseInfo responseInfo;

        public AggregateResponseEvent(HttpResponse.ResponseInfo responseInfo, String str) {
            this.responseInfo = responseInfo;
            this.data = str;
        }

        public String data() {
            return this.data;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof AggregateResponseEvent)) {
                return false;
            }
            AggregateResponseEvent aggregateResponseEvent = (AggregateResponseEvent) obj;
            return Objects.equals(this.responseInfo, aggregateResponseEvent.responseInfo) && Objects.equals(this.data, aggregateResponseEvent.data);
        }

        public final int hashCode() {
            HttpResponse.ResponseInfo responseInfo = this.responseInfo;
            String str = this.data;
            return Objects.hashCode(str) + (Objects.hashCode(responseInfo) * 31);
        }

        @Override // io.modelcontextprotocol.client.transport.ResponseSubscribers.ResponseEvent
        public HttpResponse.ResponseInfo responseInfo() {
            return this.responseInfo;
        }

        public final String toString() {
            Object[] objArr = {this.responseInfo, this.data};
            String[] strArrSplit = "responseInfo;data".length() == 0 ? new String[0] : "responseInfo;data".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, AggregateResponseEvent.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class AggregateSubscriber extends BaseSubscriber<String> {
        private HttpResponse.ResponseInfo responseInfo;
        private final FluxSink<ResponseEvent> sink;
        volatile boolean hasRequestedDemand = false;
        private final StringBuilder eventBuilder = new StringBuilder();

        public AggregateSubscriber(HttpResponse.ResponseInfo responseInfo, FluxSink<ResponseEvent> fluxSink) {
            this.sink = fluxSink;
            this.responseInfo = responseInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$hookOnSubscribe$0(qd.e eVar, long j10) {
            if (!this.hasRequestedDemand) {
                eVar.request(Long.MAX_VALUE);
            }
            this.hasRequestedDemand = true;
        }

        @Override // reactor.core.publisher.BaseSubscriber
        public void hookOnComplete() {
            if (this.hasRequestedDemand) {
                this.sink.next(new AggregateResponseEvent(this.responseInfo, this.eventBuilder.toString()));
            }
            this.sink.complete();
        }

        @Override // reactor.core.publisher.BaseSubscriber
        public void hookOnError(Throwable th) {
            this.sink.error(th);
        }

        @Override // reactor.core.publisher.BaseSubscriber
        public void hookOnNext(String str) {
            StringBuilder sb2 = this.eventBuilder;
            sb2.append(str);
            sb2.append("\n");
        }

        @Override // reactor.core.publisher.BaseSubscriber
        public void hookOnSubscribe(qd.e eVar) {
            FluxSink<ResponseEvent> fluxSink = this.sink;
            b0 b0Var = new b0(0);
            b0Var.f6160c = this;
            b0Var.f6159b = eVar;
            VarHandle.storeStoreFence();
            fluxSink.onRequest(b0Var);
            FluxSink<ResponseEvent> fluxSink2 = this.sink;
            Objects.requireNonNull(eVar);
            c0 c0Var = new c0(2);
            c0Var.f6165f = eVar;
            VarHandle.storeStoreFence();
            fluxSink2.onDispose(c0Var);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class BodilessResponseLineSubscriber extends BaseSubscriber<String> {
        volatile boolean hasRequestedDemand = false;
        private final HttpResponse.ResponseInfo responseInfo;
        private final FluxSink<ResponseEvent> sink;

        public BodilessResponseLineSubscriber(HttpResponse.ResponseInfo responseInfo, FluxSink<ResponseEvent> fluxSink) {
            this.sink = fluxSink;
            this.responseInfo = responseInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$hookOnSubscribe$0(qd.e eVar, long j10) {
            if (!this.hasRequestedDemand) {
                eVar.request(Long.MAX_VALUE);
            }
            this.hasRequestedDemand = true;
        }

        @Override // reactor.core.publisher.BaseSubscriber
        public void hookOnComplete() {
            if (this.hasRequestedDemand) {
                this.sink.next(new DummyEvent(this.responseInfo));
            }
            this.sink.complete();
        }

        @Override // reactor.core.publisher.BaseSubscriber
        public void hookOnError(Throwable th) {
            this.sink.error(th);
        }

        @Override // reactor.core.publisher.BaseSubscriber
        public void hookOnSubscribe(qd.e eVar) {
            FluxSink<ResponseEvent> fluxSink = this.sink;
            b0 b0Var = new b0(1);
            b0Var.f6160c = this;
            b0Var.f6159b = eVar;
            VarHandle.storeStoreFence();
            fluxSink.onRequest(b0Var);
            FluxSink<ResponseEvent> fluxSink2 = this.sink;
            c0 c0Var = new c0(0);
            c0Var.f6165f = eVar;
            VarHandle.storeStoreFence();
            fluxSink2.onDispose(c0Var);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class DummyEvent extends androidx.activity.b implements ResponseEvent {
        private final HttpResponse.ResponseInfo responseInfo;

        public DummyEvent(HttpResponse.ResponseInfo responseInfo) {
            this.responseInfo = responseInfo;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof DummyEvent) && Objects.equals(this.responseInfo, ((DummyEvent) obj).responseInfo);
        }

        public final int hashCode() {
            return Objects.hashCode(this.responseInfo);
        }

        @Override // io.modelcontextprotocol.client.transport.ResponseSubscribers.ResponseEvent
        public HttpResponse.ResponseInfo responseInfo() {
            return this.responseInfo;
        }

        public final String toString() {
            Object[] objArr = {this.responseInfo};
            String[] strArrSplit = "responseInfo".length() == 0 ? new String[0] : "responseInfo".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, DummyEvent.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface ResponseEvent {
        HttpResponse.ResponseInfo responseInfo();
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class SseEvent extends androidx.activity.b {
        private final String data;
        private final String event;

        /* renamed from: id, reason: collision with root package name */
        private final String f6148id;

        public SseEvent(String str, String str2, String str3) {
            this.f6148id = str;
            this.event = str2;
            this.data = str3;
        }

        public String data() {
            return this.data;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof SseEvent)) {
                return false;
            }
            SseEvent sseEvent = (SseEvent) obj;
            return Objects.equals(this.f6148id, sseEvent.f6148id) && Objects.equals(this.event, sseEvent.event) && Objects.equals(this.data, sseEvent.data);
        }

        public String event() {
            return this.event;
        }

        public final int hashCode() {
            String str = this.f6148id;
            String str2 = this.event;
            String str3 = this.data;
            return Objects.hashCode(str3) + androidx.activity.b.w(Objects.hashCode(str) * 31, 31, str2);
        }

        public String id() {
            return this.f6148id;
        }

        public final String toString() {
            Object[] objArr = {this.f6148id, this.event, this.data};
            String[] strArrSplit = "id;event;data".length() == 0 ? new String[0] : "id;event;data".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, SseEvent.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class SseLineSubscriber extends BaseSubscriber<String> {
        private static final Pattern EVENT_DATA_PATTERN = Pattern.compile("^data:(.+)$", 8);
        private static final Pattern EVENT_ID_PATTERN = Pattern.compile("^id:(.+)$", 8);
        private static final Pattern EVENT_TYPE_PATTERN = Pattern.compile("^event:(.+)$", 8);
        private HttpResponse.ResponseInfo responseInfo;
        private final FluxSink<ResponseEvent> sink;
        private final StringBuilder eventBuilder = new StringBuilder();
        private final AtomicReference<String> currentEventId = new AtomicReference<>();
        private final AtomicReference<String> currentEventType = new AtomicReference<>();

        public SseLineSubscriber(HttpResponse.ResponseInfo responseInfo, FluxSink<ResponseEvent> fluxSink) {
            this.sink = fluxSink;
            this.responseInfo = responseInfo;
        }

        @Override // reactor.core.publisher.BaseSubscriber
        public void hookOnComplete() {
            if (this.eventBuilder.length() > 0) {
                this.sink.next(new SseResponseEvent(this.responseInfo, new SseEvent(this.currentEventId.get(), this.currentEventType.get(), this.eventBuilder.toString().trim())));
            }
            this.sink.complete();
        }

        @Override // reactor.core.publisher.BaseSubscriber
        public void hookOnError(Throwable th) {
            this.sink.error(th);
        }

        @Override // reactor.core.publisher.BaseSubscriber
        public void hookOnNext(String str) {
            if (str.isEmpty()) {
                if (this.eventBuilder.length() > 0) {
                    this.sink.next(new SseResponseEvent(this.responseInfo, new SseEvent(this.currentEventId.get(), this.currentEventType.get(), this.eventBuilder.toString().trim())));
                    this.eventBuilder.setLength(0);
                    return;
                }
                return;
            }
            if (str.startsWith("data:")) {
                Matcher matcher = EVENT_DATA_PATTERN.matcher(str);
                if (matcher.find()) {
                    StringBuilder sb2 = this.eventBuilder;
                    sb2.append(matcher.group(1).trim());
                    sb2.append("\n");
                }
                upstream().request(1L);
                return;
            }
            if (str.startsWith("id:")) {
                Matcher matcher2 = EVENT_ID_PATTERN.matcher(str);
                if (matcher2.find()) {
                    this.currentEventId.set(matcher2.group(1).trim());
                }
                upstream().request(1L);
                return;
            }
            if (str.startsWith("event:")) {
                Matcher matcher3 = EVENT_TYPE_PATTERN.matcher(str);
                if (matcher3.find()) {
                    this.currentEventType.set(matcher3.group(1).trim());
                }
                upstream().request(1L);
                return;
            }
            if (str.startsWith(":")) {
                ResponseSubscribers.logger.h(str, "Ignoring comment line: {}");
                upstream().request(1L);
                return;
            }
            this.sink.error(new McpTransportException("Invalid SSE response. Status code: " + this.responseInfo.statusCode() + " Line: " + str));
        }

        @Override // reactor.core.publisher.BaseSubscriber
        public void hookOnSubscribe(qd.e eVar) {
            FluxSink<ResponseEvent> fluxSink = this.sink;
            d0 d0Var = new d0();
            d0Var.f6168a = eVar;
            VarHandle.storeStoreFence();
            fluxSink.onRequest(d0Var);
            FluxSink<ResponseEvent> fluxSink2 = this.sink;
            c0 c0Var = new c0(1);
            c0Var.f6165f = eVar;
            VarHandle.storeStoreFence();
            fluxSink2.onDispose(c0Var);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class SseResponseEvent extends androidx.activity.b implements ResponseEvent {
        private final HttpResponse.ResponseInfo responseInfo;
        private final SseEvent sseEvent;

        public SseResponseEvent(HttpResponse.ResponseInfo responseInfo, SseEvent sseEvent) {
            this.responseInfo = responseInfo;
            this.sseEvent = sseEvent;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof SseResponseEvent)) {
                return false;
            }
            SseResponseEvent sseResponseEvent = (SseResponseEvent) obj;
            return Objects.equals(this.responseInfo, sseResponseEvent.responseInfo) && Objects.equals(this.sseEvent, sseResponseEvent.sseEvent);
        }

        public final int hashCode() {
            HttpResponse.ResponseInfo responseInfo = this.responseInfo;
            SseEvent sseEvent = this.sseEvent;
            return Objects.hashCode(sseEvent) + (Objects.hashCode(responseInfo) * 31);
        }

        @Override // io.modelcontextprotocol.client.transport.ResponseSubscribers.ResponseEvent
        public HttpResponse.ResponseInfo responseInfo() {
            return this.responseInfo;
        }

        public SseEvent sseEvent() {
            return this.sseEvent;
        }

        public final String toString() {
            Object[] objArr = {this.responseInfo, this.sseEvent};
            String[] strArrSplit = "responseInfo;sseEvent".length() == 0 ? new String[0] : "responseInfo;sseEvent".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, SseResponseEvent.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    public static HttpResponse.BodySubscriber<Void> aggregateBodySubscriber(HttpResponse.ResponseInfo responseInfo, FluxSink<ResponseEvent> fluxSink) {
        return HttpResponse.BodySubscribers.fromLineSubscriber(com.stepos.statsrpk.h.G(new AggregateSubscriber(responseInfo, fluxSink)));
    }

    public static HttpResponse.BodySubscriber<Void> bodilessBodySubscriber(HttpResponse.ResponseInfo responseInfo, FluxSink<ResponseEvent> fluxSink) {
        return HttpResponse.BodySubscribers.fromLineSubscriber(com.stepos.statsrpk.h.G(new BodilessResponseLineSubscriber(responseInfo, fluxSink)));
    }

    public static HttpResponse.BodySubscriber<Void> sseToBodySubscriber(HttpResponse.ResponseInfo responseInfo, FluxSink<ResponseEvent> fluxSink) {
        return HttpResponse.BodySubscribers.fromLineSubscriber(com.stepos.statsrpk.h.G(new SseLineSubscriber(responseInfo, fluxSink)));
    }
}
