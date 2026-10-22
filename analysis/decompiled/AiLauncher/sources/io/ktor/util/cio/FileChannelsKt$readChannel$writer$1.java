package io.ktor.util.cio;

import Y8.h;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.utils.io.WriterScope;
import java.io.Closeable;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/utils/io/WriterScope;", "LY8/t;", "<anonymous>", "(Lio/ktor/utils/io/WriterScope;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.util.cio.FileChannelsKt$readChannel$writer$1", f = "FileChannels.kt", l = {42}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class FileChannelsKt$readChannel$writer$1 extends SuspendLambda implements p<WriterScope, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ long $endInclusive;
    final /* synthetic */ long $fileLength;
    final /* synthetic */ h<RandomAccessFile> $randomAccessFile$delegate;
    final /* synthetic */ long $start;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FileChannelsKt$readChannel$writer$1(long j10, long j11, long j12, h<? extends RandomAccessFile> hVar, InterfaceC4014c<? super FileChannelsKt$readChannel$writer$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$start = j10;
        this.$endInclusive = j11;
        this.$fileLength = j12;
        this.$randomAccessFile$delegate = hVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        FileChannelsKt$readChannel$writer$1 fileChannelsKt$readChannel$writer$1 = new FileChannelsKt$readChannel$writer$1(this.$start, this.$endInclusive, this.$fileLength, this.$randomAccessFile$delegate, interfaceC4014c);
        fileChannelsKt$readChannel$writer$1.L$0 = obj;
        return fileChannelsKt$readChannel$writer$1;
    }

    @Override // p9.p
    public final Object invoke(WriterScope writerScope, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((FileChannelsKt$readChannel$writer$1) create(writerScope, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
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
            RandomAccessFile channel$lambda$1 = FileChannelsKt.readChannel$lambda$1(this.$randomAccessFile$delegate);
            long j13 = this.$start;
            long j14 = this.$endInclusive;
            try {
                FileChannel channel = channel$lambda$1.getChannel();
                kotlin.jvm.internal.p.h(channel, "getChannel(...)");
                this.L$0 = g9.h.a(writerScope);
                this.L$1 = channel$lambda$1;
                this.L$2 = g9.h.a(channel$lambda$1);
                this.L$3 = g9.h.a(channel);
                this.I$0 = 0;
                this.label = 1;
                if (FileChannelsKt.writeToScope(channel, writerScope, j13, j14, this) == objG) {
                    return objG;
                }
                closeable = channel$lambda$1;
            } catch (Throwable th2) {
                th = th2;
                closeable = channel$lambda$1;
                throw th;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
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
        t tVar = t.f7040a;
        l9.b.a(closeable, null);
        return t.f7040a;
    }
}
