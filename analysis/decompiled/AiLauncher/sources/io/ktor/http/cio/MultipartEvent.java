package io.ktor.http.cio;

import Ua.Q;
import Y8.t;
import fb.v;
import io.ktor.http.cio.MultipartEvent;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0003\u0082\u0001\u0003\t\n\u000b¨\u0006\f"}, d2 = {"Lio/ktor/http/cio/MultipartEvent;", "", "<init>", "()V", "LY8/t;", "release", "Preamble", "MultipartPart", "Epilogue", "Lio/ktor/http/cio/MultipartEvent$Epilogue;", "Lio/ktor/http/cio/MultipartEvent$MultipartPart;", "Lio/ktor/http/cio/MultipartEvent$Preamble;", "ktor-http-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class MultipartEvent {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/http/cio/MultipartEvent$Epilogue;", "Lio/ktor/http/cio/MultipartEvent;", "Lfb/v;", "body", "<init>", "(Lfb/v;)V", "LY8/t;", "release", "()V", "Lfb/v;", "getBody", "()Lfb/v;", "ktor-http-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Epilogue extends MultipartEvent {
        private final v body;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Epilogue(v body) {
            super(null);
            p.i(body, "body");
            this.body = body;
        }

        public final v getBody() {
            return this.body;
        }

        @Override // io.ktor.http.cio.MultipartEvent
        public void release() {
            this.body.close();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/http/cio/MultipartEvent$MultipartPart;", "Lio/ktor/http/cio/MultipartEvent;", "LUa/Q;", "Lio/ktor/http/cio/HttpHeadersMap;", "headers", "Lio/ktor/utils/io/ByteReadChannel;", "body", "<init>", "(LUa/Q;Lio/ktor/utils/io/ByteReadChannel;)V", "LY8/t;", "release", "()V", "LUa/Q;", "getHeaders", "()LUa/Q;", "Lio/ktor/utils/io/ByteReadChannel;", "getBody", "()Lio/ktor/utils/io/ByteReadChannel;", "ktor-http-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class MultipartPart extends MultipartEvent {
        private final ByteReadChannel body;
        private final Q<HttpHeadersMap> headers;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MultipartPart(Q<HttpHeadersMap> headers, ByteReadChannel body) {
            super(null);
            p.i(headers, "headers");
            p.i(body, "body");
            this.headers = headers;
            this.body = body;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final t release$lambda$0(MultipartPart multipartPart, Throwable th) {
            if (th != null) {
                multipartPart.headers.m().release();
            }
            return t.f7040a;
        }

        public final ByteReadChannel getBody() {
            return this.body;
        }

        public final Q<HttpHeadersMap> getHeaders() {
            return this.headers;
        }

        @Override // io.ktor.http.cio.MultipartEvent
        public void release() throws InterruptedException {
            this.headers.J(new InterfaceC5074l() { // from class: io.ktor.http.cio.m
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return MultipartEvent.MultipartPart.release$lambda$0(this.f33300a, (Throwable) obj);
                }
            });
            MultipartJvmAndPosixKt.discardBlocking(this.body);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/http/cio/MultipartEvent$Preamble;", "Lio/ktor/http/cio/MultipartEvent;", "Lfb/v;", "body", "<init>", "(Lfb/v;)V", "LY8/t;", "release", "()V", "Lfb/v;", "getBody", "()Lfb/v;", "ktor-http-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Preamble extends MultipartEvent {
        private final v body;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Preamble(v body) {
            super(null);
            p.i(body, "body");
            this.body = body;
        }

        public final v getBody() {
            return this.body;
        }

        @Override // io.ktor.http.cio.MultipartEvent
        public void release() {
            this.body.close();
        }
    }

    public /* synthetic */ MultipartEvent(kotlin.jvm.internal.i iVar) {
        this();
    }

    public abstract void release();

    private MultipartEvent() {
    }
}
