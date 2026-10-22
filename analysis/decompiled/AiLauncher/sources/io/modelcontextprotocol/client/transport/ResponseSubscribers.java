package io.modelcontextprotocol.client.transport;

import io.ktor.sse.ServerSentEventKt;
import io.modelcontextprotocol.client.b1;
import io.modelcontextprotocol.spec.McpTransportException;
import java.net.http.HttpResponse;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.LongConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import reactor.core.Disposable;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.FluxSink;

/* loaded from: classes4.dex */
class ResponseSubscribers {
    private static final vc.c logger = vc.e.l(ResponseSubscribers.class);

    public static final class AggregateResponseEvent extends W8.a implements ResponseEvent {
        private final String data;
        private final HttpResponse.ResponseInfo responseInfo;

        public AggregateResponseEvent(HttpResponse.ResponseInfo responseInfo, String str) {
            this.responseInfo = responseInfo;
            this.data = str;
        }

        private /* synthetic */ boolean a(Object obj) {
            if (!(obj instanceof AggregateResponseEvent)) {
                return false;
            }
            AggregateResponseEvent aggregateResponseEvent = (AggregateResponseEvent) obj;
            return Objects.equals(this.responseInfo, aggregateResponseEvent.responseInfo) && Objects.equals(this.data, aggregateResponseEvent.data);
        }

        private /* synthetic */ Object[] b() {
            return new Object[]{this.responseInfo, this.data};
        }

        public String data() {
            return this.data;
        }

        public final boolean equals(Object obj) {
            return a(obj);
        }

        public final int hashCode() {
            return C4515e0.a(this.responseInfo, this.data);
        }

        @Override // io.modelcontextprotocol.client.transport.ResponseSubscribers.ResponseEvent
        public HttpResponse.ResponseInfo responseInfo() {
            return this.responseInfo;
        }

        public final String toString() {
            return b1.a(b(), AggregateResponseEvent.class, "responseInfo;data");
        }
    }

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
        public /* synthetic */ void lambda$hookOnSubscribe$0(qc.d dVar, long j10) {
            if (!this.hasRequestedDemand) {
                dVar.request(Long.MAX_VALUE);
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
        public void hookOnSubscribe(final qc.d dVar) {
            this.sink.onRequest(new LongConsumer() { // from class: io.modelcontextprotocol.client.transport.f0
                @Override // java.util.function.LongConsumer
                public final void accept(long j10) {
                    this.f33678a.lambda$hookOnSubscribe$0(dVar, j10);
                }
            });
            FluxSink<ResponseEvent> fluxSink = this.sink;
            Objects.requireNonNull(dVar);
            fluxSink.onDispose(new Disposable() { // from class: io.modelcontextprotocol.client.transport.g0
                @Override // reactor.core.Disposable
                public final void dispose() {
                    dVar.cancel();
                }
            });
        }

        @Override // reactor.core.publisher.BaseSubscriber
        public void hookOnNext(String str) {
            StringBuilder sb2 = this.eventBuilder;
            sb2.append(str);
            sb2.append("\n");
        }
    }

    public static class BodilessResponseLineSubscriber extends BaseSubscriber<String> {
        volatile boolean hasRequestedDemand = false;
        private final HttpResponse.ResponseInfo responseInfo;
        private final FluxSink<ResponseEvent> sink;

        public BodilessResponseLineSubscriber(HttpResponse.ResponseInfo responseInfo, FluxSink<ResponseEvent> fluxSink) {
            this.sink = fluxSink;
            this.responseInfo = responseInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$hookOnSubscribe$0(qc.d dVar, long j10) {
            if (!this.hasRequestedDemand) {
                dVar.request(Long.MAX_VALUE);
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
        public void hookOnSubscribe(final qc.d dVar) {
            this.sink.onRequest(new LongConsumer() { // from class: io.modelcontextprotocol.client.transport.h0
                @Override // java.util.function.LongConsumer
                public final void accept(long j10) {
                    this.f33682a.lambda$hookOnSubscribe$0(dVar, j10);
                }
            });
            this.sink.onDispose(new Disposable() { // from class: io.modelcontextprotocol.client.transport.i0
                @Override // reactor.core.Disposable
                public final void dispose() {
                    dVar.cancel();
                }
            });
        }
    }

    public static final class DummyEvent extends W8.a implements ResponseEvent {
        private final HttpResponse.ResponseInfo responseInfo;

        public DummyEvent(HttpResponse.ResponseInfo responseInfo) {
            this.responseInfo = responseInfo;
        }

        private /* synthetic */ boolean a(Object obj) {
            return (obj instanceof DummyEvent) && Objects.equals(this.responseInfo, ((DummyEvent) obj).responseInfo);
        }

        private /* synthetic */ Object[] b() {
            return new Object[]{this.responseInfo};
        }

        public final boolean equals(Object obj) {
            return a(obj);
        }

        public final int hashCode() {
            return Objects.hashCode(this.responseInfo);
        }

        @Override // io.modelcontextprotocol.client.transport.ResponseSubscribers.ResponseEvent
        public HttpResponse.ResponseInfo responseInfo() {
            return this.responseInfo;
        }

        public final String toString() {
            return b1.a(b(), DummyEvent.class, "responseInfo");
        }
    }

    public interface ResponseEvent {
        HttpResponse.ResponseInfo responseInfo();
    }

    public static final class SseEvent extends W8.a {
        private final String data;
        private final String event;
        private final String id;

        public SseEvent(String str, String str2, String str3) {
            this.id = str;
            this.event = str2;
            this.data = str3;
        }

        private /* synthetic */ boolean a(Object obj) {
            if (!(obj instanceof SseEvent)) {
                return false;
            }
            SseEvent sseEvent = (SseEvent) obj;
            return Objects.equals(this.id, sseEvent.id) && Objects.equals(this.event, sseEvent.event) && Objects.equals(this.data, sseEvent.data);
        }

        private /* synthetic */ Object[] b() {
            return new Object[]{this.id, this.event, this.data};
        }

        public String data() {
            return this.data;
        }

        public final boolean equals(Object obj) {
            return a(obj);
        }

        public String event() {
            return this.event;
        }

        public final int hashCode() {
            return k0.a(this.id, this.event, this.data);
        }

        public String id() {
            return this.id;
        }

        public final String toString() {
            return b1.a(b(), SseEvent.class, "id;event;data");
        }
    }

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
        public void hookOnSubscribe(final qc.d dVar) {
            this.sink.onRequest(new LongConsumer() { // from class: io.modelcontextprotocol.client.transport.l0
                @Override // java.util.function.LongConsumer
                public final void accept(long j10) {
                    dVar.request(j10);
                }
            });
            this.sink.onDispose(new Disposable() { // from class: io.modelcontextprotocol.client.transport.m0
                @Override // reactor.core.Disposable
                public final void dispose() {
                    dVar.cancel();
                }
            });
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
            if (str.startsWith(ServerSentEventKt.COLON)) {
                ResponseSubscribers.logger.t("Ignoring comment line: {}", str);
                upstream().request(1L);
                return;
            }
            this.sink.error(new McpTransportException("Invalid SSE response. Status code: " + this.responseInfo.statusCode() + " Line: " + str));
        }
    }

    public static final class SseResponseEvent extends W8.a implements ResponseEvent {
        private final HttpResponse.ResponseInfo responseInfo;
        private final SseEvent sseEvent;

        public SseResponseEvent(HttpResponse.ResponseInfo responseInfo, SseEvent sseEvent) {
            this.responseInfo = responseInfo;
            this.sseEvent = sseEvent;
        }

        private /* synthetic */ boolean a(Object obj) {
            if (!(obj instanceof SseResponseEvent)) {
                return false;
            }
            SseResponseEvent sseResponseEvent = (SseResponseEvent) obj;
            return Objects.equals(this.responseInfo, sseResponseEvent.responseInfo) && Objects.equals(this.sseEvent, sseResponseEvent.sseEvent);
        }

        private /* synthetic */ Object[] b() {
            return new Object[]{this.responseInfo, this.sseEvent};
        }

        public final boolean equals(Object obj) {
            return a(obj);
        }

        public final int hashCode() {
            return C4515e0.a(this.responseInfo, this.sseEvent);
        }

        @Override // io.modelcontextprotocol.client.transport.ResponseSubscribers.ResponseEvent
        public HttpResponse.ResponseInfo responseInfo() {
            return this.responseInfo;
        }

        public SseEvent sseEvent() {
            return this.sseEvent;
        }

        public final String toString() {
            return b1.a(b(), SseResponseEvent.class, "responseInfo;sseEvent");
        }
    }

    public static HttpResponse.BodySubscriber<Void> aggregateBodySubscriber(HttpResponse.ResponseInfo responseInfo, FluxSink<ResponseEvent> fluxSink) {
        return HttpResponse.BodySubscribers.fromLineSubscriber(qc.a.a(new AggregateSubscriber(responseInfo, fluxSink)));
    }

    public static HttpResponse.BodySubscriber<Void> bodilessBodySubscriber(HttpResponse.ResponseInfo responseInfo, FluxSink<ResponseEvent> fluxSink) {
        return HttpResponse.BodySubscribers.fromLineSubscriber(qc.a.a(new BodilessResponseLineSubscriber(responseInfo, fluxSink)));
    }

    public static HttpResponse.BodySubscriber<Void> sseToBodySubscriber(HttpResponse.ResponseInfo responseInfo, FluxSink<ResponseEvent> fluxSink) {
        return HttpResponse.BodySubscribers.fromLineSubscriber(qc.a.a(new SseLineSubscriber(responseInfo, fluxSink)));
    }
}
