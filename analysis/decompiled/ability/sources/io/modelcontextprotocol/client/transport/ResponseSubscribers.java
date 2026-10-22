package io.modelcontextprotocol.client.transport;

import aa.AbstractC0317d;
import aa.InterfaceC0315b;
import io.modelcontextprotocol.spec.McpTransportException;
import java.net.http.HttpResponse;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.LongConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.FluxSink;

/* loaded from: classes2.dex */
class ResponseSubscribers {
    private static final InterfaceC0315b logger = AbstractC0317d.b(ResponseSubscribers.class);

    public static final class AggregateResponseEvent extends B7.a implements ResponseEvent {
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
            StringBuilder sb = new StringBuilder();
            com.stepos.statsrpk.service.c.q(sb, AggregateResponseEvent.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb.append(strArrSplit[i]);
                sb.append("=");
                sb.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
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
        public /* synthetic */ void lambda$hookOnSubscribe$0(Z9.e eVar, long j5) {
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
        public void hookOnSubscribe(Z9.e eVar) {
            this.sink.onRequest(new B(this, eVar, 0));
            FluxSink<ResponseEvent> fluxSink = this.sink;
            Objects.requireNonNull(eVar);
            fluxSink.onDispose(new C(eVar, 2));
        }

        @Override // reactor.core.publisher.BaseSubscriber
        public void hookOnNext(String str) {
            StringBuilder sb = this.eventBuilder;
            sb.append(str);
            sb.append("\n");
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
        public /* synthetic */ void lambda$hookOnSubscribe$0(Z9.e eVar, long j5) {
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
        public void hookOnSubscribe(Z9.e eVar) {
            this.sink.onRequest(new B(this, eVar, 1));
            this.sink.onDispose(new C(eVar, 0));
        }
    }

    public static final class DummyEvent extends B7.a implements ResponseEvent {
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
            StringBuilder sb = new StringBuilder();
            com.stepos.statsrpk.service.c.q(sb, DummyEvent.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb.append(strArrSplit[i]);
                sb.append("=");
                sb.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public interface ResponseEvent {
        HttpResponse.ResponseInfo responseInfo();
    }

    public static final class SseEvent extends B7.a {
        private final String data;
        private final String event;
        private final String id;

        public SseEvent(String str, String str2, String str3) {
            this.id = str;
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
            return Objects.equals(this.id, sseEvent.id) && Objects.equals(this.event, sseEvent.event) && Objects.equals(this.data, sseEvent.data);
        }

        public String event() {
            return this.event;
        }

        public final int hashCode() {
            String str = this.id;
            String str2 = this.event;
            String str3 = this.data;
            return Objects.hashCode(str3) + com.stepos.statsrpk.service.c.a(Objects.hashCode(str) * 31, 31, str2);
        }

        public String id() {
            return this.id;
        }

        public final String toString() {
            Object[] objArr = {this.id, this.event, this.data};
            String[] strArrSplit = "id;event;data".length() == 0 ? new String[0] : "id;event;data".split(";");
            StringBuilder sb = new StringBuilder();
            com.stepos.statsrpk.service.c.q(sb, SseEvent.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb.append(strArrSplit[i]);
                sb.append("=");
                sb.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
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
        public void hookOnSubscribe(final Z9.e eVar) {
            this.sink.onRequest(new LongConsumer() { // from class: io.modelcontextprotocol.client.transport.D
                @Override // java.util.function.LongConsumer
                public final void accept(long j5) {
                    eVar.request(j5);
                }
            });
            this.sink.onDispose(new C(eVar, 1));
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
                    StringBuilder sb = this.eventBuilder;
                    sb.append(matcher.group(1).trim());
                    sb.append("\n");
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
            if (!str.startsWith(":")) {
                this.sink.error(new McpTransportException(androidx.constraintlayout.core.dsl.a.c(this.responseInfo.statusCode(), "Invalid SSE response. Status code: ", " Line: ", str)));
            } else {
                ResponseSubscribers.logger.j(str, "Ignoring comment line: {}");
                upstream().request(1L);
            }
        }
    }

    public static final class SseResponseEvent extends B7.a implements ResponseEvent {
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
            StringBuilder sb = new StringBuilder();
            com.stepos.statsrpk.service.c.q(sb, SseResponseEvent.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb.append(strArrSplit[i]);
                sb.append("=");
                sb.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static HttpResponse.BodySubscriber<Void> aggregateBodySubscriber(HttpResponse.ResponseInfo responseInfo, FluxSink<ResponseEvent> fluxSink) {
        return HttpResponse.BodySubscribers.fromLineSubscriber(M0.i.I(new AggregateSubscriber(responseInfo, fluxSink)));
    }

    public static HttpResponse.BodySubscriber<Void> bodilessBodySubscriber(HttpResponse.ResponseInfo responseInfo, FluxSink<ResponseEvent> fluxSink) {
        return HttpResponse.BodySubscribers.fromLineSubscriber(M0.i.I(new BodilessResponseLineSubscriber(responseInfo, fluxSink)));
    }

    public static HttpResponse.BodySubscriber<Void> sseToBodySubscriber(HttpResponse.ResponseInfo responseInfo, FluxSink<ResponseEvent> fluxSink) {
        return HttpResponse.BodySubscribers.fromLineSubscriber(M0.i.I(new SseLineSubscriber(responseInfo, fluxSink)));
    }
}
