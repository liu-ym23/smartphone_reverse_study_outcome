package io.ktor.http.content;

import io.ktor.http.content.OutgoingContent;
import io.ktor.util.ContentEncoder;
import io.ktor.utils.io.ByteChannelCtorKt;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0005\u001a\u0004\u0018\u00010\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/http/content/OutgoingContent;", "Lio/ktor/util/ContentEncoder;", "contentEncoder", "Lkotlin/coroutines/d;", "coroutineContext", "compressed", "(Lio/ktor/http/content/OutgoingContent;Lio/ktor/util/ContentEncoder;Lkotlin/coroutines/d;)Lio/ktor/http/content/OutgoingContent;", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CompressedContentKt {
    public static final OutgoingContent compressed(final OutgoingContent outgoingContent, ContentEncoder contentEncoder, kotlin.coroutines.d coroutineContext) {
        p.i(outgoingContent, "<this>");
        p.i(contentEncoder, "contentEncoder");
        p.i(coroutineContext, "coroutineContext");
        if (outgoingContent instanceof OutgoingContent.ReadChannelContent) {
            return new CompressedReadChannelResponse(outgoingContent, new InterfaceC5063a() { // from class: io.ktor.http.content.b
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return CompressedContentKt.compressed$lambda$0(outgoingContent);
                }
            }, contentEncoder, coroutineContext);
        }
        if (outgoingContent instanceof OutgoingContent.WriteChannelContent) {
            return new CompressedWriteChannelResponse((OutgoingContent.WriteChannelContent) outgoingContent, contentEncoder, coroutineContext);
        }
        if (outgoingContent instanceof OutgoingContent.ByteArrayContent) {
            return new CompressedReadChannelResponse(outgoingContent, new InterfaceC5063a() { // from class: io.ktor.http.content.c
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return CompressedContentKt.compressed$lambda$1(outgoingContent);
                }
            }, contentEncoder, coroutineContext);
        }
        if ((outgoingContent instanceof OutgoingContent.NoContent) || (outgoingContent instanceof OutgoingContent.ProtocolUpgrade)) {
            return null;
        }
        if (outgoingContent instanceof OutgoingContent.ContentWrapper) {
            return compressed(((OutgoingContent.ContentWrapper) outgoingContent).getDelegate(), contentEncoder, coroutineContext);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ OutgoingContent compressed$default(OutgoingContent outgoingContent, ContentEncoder contentEncoder, kotlin.coroutines.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            dVar = EmptyCoroutineContext.f34779a;
        }
        return compressed(outgoingContent, contentEncoder, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel compressed$lambda$0(OutgoingContent outgoingContent) {
        return ((OutgoingContent.ReadChannelContent) outgoingContent).readFrom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel compressed$lambda$1(OutgoingContent outgoingContent) {
        return ByteChannelCtorKt.ByteReadChannel$default(((OutgoingContent.ByteArrayContent) outgoingContent).getContent(), 0, 0, 6, null);
    }
}
