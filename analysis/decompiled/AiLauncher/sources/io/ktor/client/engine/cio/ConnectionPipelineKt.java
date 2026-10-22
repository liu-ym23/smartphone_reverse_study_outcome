package io.ktor.client.engine.cio;

import Ua.C1060i;
import Ua.M;
import Y8.t;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardView;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"LUa/M;", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/ByteWriteChannel;", "output", "Lkotlinx/coroutines/g;", "skipCancels", "(LUa/M;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;)Lkotlinx/coroutines/g;", "ktor-client-cio"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConnectionPipelineKt {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.client.engine.cio.ConnectionPipelineKt$skipCancels$1", f = "ConnectionPipeline.kt", l = {164, 169, DidiCardView.FINISHED_TITLE_TRAILING_WIDTH_DP, 180, 180}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.engine.cio.ConnectionPipelineKt$skipCancels$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ ByteReadChannel $input;
        final /* synthetic */ ByteWriteChannel $output;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ByteWriteChannel byteWriteChannel, ByteReadChannel byteReadChannel, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$output = byteWriteChannel;
            this.$input = byteReadChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$output, this.$input, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:56:0x0174, code lost:
        
            if (r0.flushAndClose(r20) == r6) goto L69;
         */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00e1  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00e3  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00f1 A[Catch: all -> 0x0059, TRY_LEAVE, TryCatch #5 {all -> 0x0059, blocks: (B:14:0x004a, B:29:0x00c6, B:33:0x00e9, B:35:0x00f1, B:53:0x015d, B:24:0x00a8, B:28:0x00c1), top: B:81:0x000e }] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x014b  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x015d A[Catch: all -> 0x0059, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x0059, blocks: (B:14:0x004a, B:29:0x00c6, B:33:0x00e9, B:35:0x00f1, B:53:0x015d, B:24:0x00a8, B:28:0x00c1), top: B:81:0x000e }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x010e -> B:40:0x0114). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x014b -> B:40:0x0114). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 415
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.cio.ConnectionPipelineKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlinx.coroutines.g skipCancels(M m10, ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel) {
        return C1060i.d(m10, null, null, new AnonymousClass1(byteWriteChannel, byteReadChannel, null), 3, null);
    }
}
