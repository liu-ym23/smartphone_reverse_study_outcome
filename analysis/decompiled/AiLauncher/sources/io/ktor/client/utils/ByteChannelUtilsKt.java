package io.ktor.client.utils;

import Ua.C1073o0;
import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.client.content.ProgressListener;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "Lkotlin/coroutines/d;", "context", "", "contentLength", "Lio/ktor/client/content/ProgressListener;", "listener", "observable", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/d;Ljava/lang/Long;Lio/ktor/client/content/ProgressListener;)Lio/ktor/utils/io/ByteReadChannel;", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ByteChannelUtilsKt {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/utils/io/WriterScope;", "LY8/t;", "<anonymous>", "(Lio/ktor/utils/io/WriterScope;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.client.utils.ByteChannelUtilsKt$observable$1", f = "ByteChannelUtils.kt", l = {22, 24, 26, 31}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.utils.ByteChannelUtilsKt$observable$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<WriterScope, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ Long $contentLength;
        final /* synthetic */ ProgressListener $listener;
        final /* synthetic */ ByteReadChannel $this_observable;
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ByteReadChannel byteReadChannel, ProgressListener progressListener, Long l10, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$this_observable = byteReadChannel;
            this.$listener = progressListener;
            this.$contentLength = l10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_observable, this.$listener, this.$contentLength, interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        public final Object invoke(WriterScope writerScope, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(writerScope, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:60:0x01e1, code lost:
        
            if (r13.onProgress(r21, r15, r26) == r7) goto L61;
         */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00fd A[Catch: all -> 0x019f, TRY_LEAVE, TryCatch #5 {all -> 0x019f, blocks: (B:34:0x00f7, B:36:0x00fd, B:55:0x01a6, B:59:0x01b9), top: B:80:0x00f7 }] */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0135 A[Catch: all -> 0x009d, TryCatch #1 {all -> 0x009d, blocks: (B:40:0x012d, B:42:0x0135, B:46:0x0167, B:21:0x0092), top: B:72:0x0092 }] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x018a  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0199  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x01a3  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x018a -> B:50:0x0195). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0199 -> B:80:0x00f7). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r27) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 500
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.utils.ByteChannelUtilsKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final ByteReadChannel observable(ByteReadChannel byteReadChannel, d context, Long l10, ProgressListener listener) {
        kotlin.jvm.internal.p.i(byteReadChannel, "<this>");
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(listener, "listener");
        return ByteWriteChannelOperationsKt.writer((M) C1073o0.f6391a, context, true, (p<? super WriterScope, ? super InterfaceC4014c<? super t>, ? extends Object>) new AnonymousClass1(byteReadChannel, listener, l10, null)).getChannel();
    }
}
