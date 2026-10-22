package io.ktor.util.cio;

import Ua.C1073o0;
import Ua.CoroutineName;
import Ua.M;
import Ua.Y;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteReadChannelOperations_jvmKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.ReaderScope;
import io.ktor.utils.io.WriterJob;
import io.ktor.utils.io.WriterScope;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a,\u0010\r\u001a\u00020\f*\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0080@¢\u0006\u0004\b\r\u0010\u000e\u001a\u001b\u0010\u0010\u001a\u00020\u000f*\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014²\u0006\f\u0010\u0013\u001a\u00020\u00128\nX\u008a\u0084\u0002"}, d2 = {"Ljava/io/File;", "", "start", "endInclusive", "Lkotlin/coroutines/d;", "coroutineContext", "Lio/ktor/utils/io/ByteReadChannel;", "readChannel", "(Ljava/io/File;JJLkotlin/coroutines/d;)Lio/ktor/utils/io/ByteReadChannel;", "Ljava/nio/channels/SeekableByteChannel;", "Lio/ktor/utils/io/WriterScope;", "writerScope", "LY8/t;", "writeToScope", "(Ljava/nio/channels/SeekableByteChannel;Lio/ktor/utils/io/WriterScope;JJLe9/c;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteWriteChannel;", "writeChannel", "(Ljava/io/File;Lkotlin/coroutines/d;)Lio/ktor/utils/io/ByteWriteChannel;", "Ljava/io/RandomAccessFile;", "randomAccessFile", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FileChannelsKt {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/utils/io/ReaderScope;", "LY8/t;", "<anonymous>", "(Lio/ktor/utils/io/ReaderScope;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.util.cio.FileChannelsKt$writeChannel$1", f = "FileChannels.kt", l = {106}, m = "invokeSuspend")
    /* renamed from: io.ktor.util.cio.FileChannelsKt$writeChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<ReaderScope, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ File $this_writeChannel;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(File file, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$this_writeChannel = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_writeChannel, interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        public final Object invoke(ReaderScope readerScope, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(readerScope, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Throwable th;
            Closeable closeable;
            RandomAccessFile randomAccessFile;
            ReaderScope readerScope = (ReaderScope) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(this.$this_writeChannel, "rw");
                try {
                    ByteReadChannel channel = readerScope.getChannel();
                    FileChannel channel2 = randomAccessFile2.getChannel();
                    kotlin.jvm.internal.p.h(channel2, "getChannel(...)");
                    this.L$0 = h.a(readerScope);
                    this.L$1 = randomAccessFile2;
                    this.L$2 = randomAccessFile2;
                    this.I$0 = 0;
                    this.label = 1;
                    Object objCopyTo$default = ByteReadChannelOperations_jvmKt.copyTo$default(channel, channel2, 0L, this, 2, null);
                    if (objCopyTo$default == objG) {
                        return objG;
                    }
                    randomAccessFile = randomAccessFile2;
                    obj = objCopyTo$default;
                    closeable = randomAccessFile;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = randomAccessFile2;
                    throw th;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                randomAccessFile = (RandomAccessFile) this.L$2;
                closeable = (Closeable) this.L$1;
                try {
                    C4849c.b(obj);
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        l9.b.a(closeable, th);
                        throw th4;
                    }
                }
            }
            randomAccessFile.setLength(((Number) obj).longValue());
            t tVar = t.f7040a;
            l9.b.a(closeable, null);
            return t.f7040a;
        }
    }

    @InterfaceC4112d(c = "io.ktor.util.cio.FileChannelsKt", f = "FileChannels.kt", l = {144, 180}, m = "writeToScope")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.util.cio.FileChannelsKt$writeToScope$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44171 extends ContinuationImpl {
        int I$0;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C44171(InterfaceC4014c<? super C44171> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileChannelsKt.writeToScope(null, null, 0L, 0L, this);
        }
    }

    public static final ByteReadChannel readChannel(final File file, long j10, long j11, d coroutineContext) {
        kotlin.jvm.internal.p.i(file, "<this>");
        kotlin.jvm.internal.p.i(coroutineContext, "coroutineContext");
        long length = file.length();
        final Y8.h hVarB = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.util.cio.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FileChannelsKt.readChannel$lambda$0(file);
            }
        });
        WriterJob writerJobWriter = ByteWriteChannelOperationsKt.writer(kotlinx.coroutines.d.a(coroutineContext), new CoroutineName("file-reader").plus(coroutineContext), false, (p<? super WriterScope, ? super InterfaceC4014c<? super t>, ? extends Object>) new FileChannelsKt$readChannel$writer$1(j10, j11, length, hVarB, null));
        ByteWriteChannelOperationsKt.invokeOnCompletion(writerJobWriter, (InterfaceC5074l<? super Throwable, t>) new InterfaceC5074l() { // from class: io.ktor.util.cio.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return FileChannelsKt.readChannel$lambda$2(hVarB, (Throwable) obj);
            }
        });
        return writerJobWriter.getChannel();
    }

    public static /* synthetic */ ByteReadChannel readChannel$default(File file, long j10, long j11, d dVar, int i10, Object obj) {
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
        return readChannel(file, j12, j13, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RandomAccessFile readChannel$lambda$0(File file) {
        return new RandomAccessFile(file, "r");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RandomAccessFile readChannel$lambda$1(Y8.h<? extends RandomAccessFile> hVar) {
        return hVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t readChannel$lambda$2(Y8.h hVar, Throwable th) throws IOException {
        readChannel$lambda$1(hVar).close();
        return t.f7040a;
    }

    public static final ByteWriteChannel writeChannel(File file, d coroutineContext) {
        kotlin.jvm.internal.p.i(file, "<this>");
        kotlin.jvm.internal.p.i(coroutineContext, "coroutineContext");
        return ByteReadChannelOperationsKt.reader((M) C1073o0.f6391a, new CoroutineName("file-writer").plus(coroutineContext), true, (p<? super ReaderScope, ? super InterfaceC4014c<? super t>, ? extends Object>) new AnonymousClass1(file, null)).getChannel();
    }

    public static /* synthetic */ ByteWriteChannel writeChannel$default(File file, d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            dVar = Y.b();
        }
        return writeChannel(file, dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02c8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x015c -> B:45:0x015e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x0289 -> B:81:0x0295). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object writeToScope(java.nio.channels.SeekableByteChannel r25, io.ktor.utils.io.WriterScope r26, long r27, long r29, e9.InterfaceC4014c<? super Y8.t> r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 715
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.cio.FileChannelsKt.writeToScope(java.nio.channels.SeekableByteChannel, io.ktor.utils.io.WriterScope, long, long, e9.c):java.lang.Object");
    }
}
