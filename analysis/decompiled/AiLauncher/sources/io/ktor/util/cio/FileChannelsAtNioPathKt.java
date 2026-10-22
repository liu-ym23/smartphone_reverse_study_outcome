package io.ktor.util.cio;

import Ua.CoroutineName;
import Ua.Y;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.WriterScope;
import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ljava/nio/file/Path;", "", "start", "endInclusive", "Lkotlin/coroutines/d;", "coroutineContext", "Lio/ktor/utils/io/ByteReadChannel;", "readChannel", "(Ljava/nio/file/Path;JJLkotlin/coroutines/d;)Lio/ktor/utils/io/ByteReadChannel;", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FileChannelsAtNioPathKt {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/utils/io/WriterScope;", "LY8/t;", "<anonymous>", "(Lio/ktor/utils/io/WriterScope;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.util.cio.FileChannelsAtNioPathKt$readChannel$1", f = "FileChannelsAtNioPath.kt", l = {36}, m = "invokeSuspend")
    /* renamed from: io.ktor.util.cio.FileChannelsAtNioPathKt$readChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<WriterScope, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ long $endInclusive;
        final /* synthetic */ long $fileLength;
        final /* synthetic */ long $start;
        final /* synthetic */ Path $this_readChannel;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j10, long j11, long j12, Path path, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$start = j10;
            this.$endInclusive = j11;
            this.$fileLength = j12;
            this.$this_readChannel = path;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$start, this.$endInclusive, this.$fileLength, this.$this_readChannel, interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        public final Object invoke(WriterScope writerScope, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(writerScope, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            SeekableByteChannel seekableByteChannel;
            Throwable th;
            Closeable closeable;
            WriterScope writerScope = (WriterScope) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                long j10 = this.$start;
                if (!(j10 >= 0)) {
                    throw new IllegalArgumentException(("start position shouldn't be negative but it is " + j10).toString());
                }
                long j11 = this.$endInclusive;
                long j12 = this.$fileLength;
                if (!(j11 <= j12 - 1)) {
                    throw new IllegalArgumentException(("endInclusive points to the position out of the file: file size = " + j12 + ", endInclusive = " + j11).toString());
                }
                SeekableByteChannel seekableByteChannelNewByteChannel = Files.newByteChannel(this.$this_readChannel, new OpenOption[0]);
                long j13 = this.$start;
                long j14 = this.$endInclusive;
                try {
                    kotlin.jvm.internal.p.f(seekableByteChannelNewByteChannel);
                    this.L$0 = h.a(writerScope);
                    this.L$1 = seekableByteChannelNewByteChannel;
                    this.L$2 = h.a(seekableByteChannelNewByteChannel);
                    this.I$0 = 0;
                    this.label = 1;
                    seekableByteChannel = seekableByteChannelNewByteChannel;
                    try {
                        if (FileChannelsKt.writeToScope(seekableByteChannel, writerScope, j13, j14, this) == objG) {
                            return objG;
                        }
                        closeable = seekableByteChannel;
                    } catch (Throwable th2) {
                        th = th2;
                        th = th;
                        closeable = seekableByteChannel;
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    seekableByteChannel = seekableByteChannelNewByteChannel;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                closeable = (Closeable) this.L$1;
                try {
                    C4849c.b(obj);
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        throw th;
                    } catch (Throwable th5) {
                        l9.b.a(closeable, th);
                        throw th5;
                    }
                }
            }
            t tVar = t.f7040a;
            l9.b.a(closeable, null);
            return t.f7040a;
        }
    }

    public static final ByteReadChannel readChannel(Path path, long j10, long j11, d coroutineContext) throws IOException {
        kotlin.jvm.internal.p.i(path, "<this>");
        kotlin.jvm.internal.p.i(coroutineContext, "coroutineContext");
        return ByteWriteChannelOperationsKt.writer(kotlinx.coroutines.d.a(coroutineContext), new CoroutineName("file-reader").plus(coroutineContext), false, (p<? super WriterScope, ? super InterfaceC4014c<? super t>, ? extends Object>) new AnonymousClass1(j10, j11, Files.size(path), path, null)).getChannel();
    }

    public static /* synthetic */ ByteReadChannel readChannel$default(Path path, long j10, long j11, d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 0;
        }
        long j12 = j10;
        if ((i10 & 2) != 0) {
            j11 = -1;
        }
        long j13 = j11;
        if ((i10 & 4) != 0) {
            dVar = Y.b();
        }
        return readChannel(path, j12, j13, dVar);
    }
}
