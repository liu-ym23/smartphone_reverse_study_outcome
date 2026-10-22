package io.ktor.util;

import Ua.C1060i;
import Ua.C1073o0;
import Ua.M;
import Ua.Y;
import Y8.t;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a%\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a!\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000b\"\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "LUa/M;", "coroutineScope", "Lkotlin/Pair;", "split", "(Lio/ktor/utils/io/ByteReadChannel;LUa/M;)Lkotlin/Pair;", "Lio/ktor/utils/io/ByteWriteChannel;", AMapLocationStaticsEntity.FIRST_LOCATE, "second", "LY8/t;", "copyToBoth", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/utils/io/ByteWriteChannel;)V", "", "CHUNK_BUFFER_SIZE", "J", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ByteChannelsKt {
    private static final long CHUNK_BUFFER_SIZE = 4096;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.util.ByteChannelsKt$copyToBoth$1", f = "ByteChannels.kt", l = {64, 66, 67, 81, 82, 81, 82, 81, 82}, m = "invokeSuspend")
    /* renamed from: io.ktor.util.ByteChannelsKt$copyToBoth$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ ByteWriteChannel $first;
        final /* synthetic */ ByteWriteChannel $second;
        final /* synthetic */ ByteReadChannel $this_copyToBoth;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, ByteWriteChannel byteWriteChannel2, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$this_copyToBoth = byteReadChannel;
            this.$first = byteWriteChannel;
            this.$second = byteWriteChannel2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$this_copyToBoth, this.$first, this.$second, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:41:0x00f6, code lost:
        
            if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writePacket(r3, r6, r9) != r0) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x0138, code lost:
        
            if (r10.flushAndClose(r9) != r0) goto L68;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x0165, code lost:
        
            if (r10.flushAndClose(r9) == r0) goto L76;
         */
        /* JADX WARN: Removed duplicated region for block: B:28:0x008a A[Catch: all -> 0x007c, TryCatch #4 {all -> 0x007c, blocks: (B:45:0x0105, B:26:0x0082, B:28:0x008a, B:30:0x0092, B:32:0x009a, B:35:0x00b3, B:50:0x010d, B:51:0x0110, B:52:0x0111, B:60:0x013b, B:21:0x0078, B:44:0x0103, B:36:0x00bc, B:43:0x00fa, B:48:0x010b), top: B:87:0x0007, inners: #1, #3 }] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00d9  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00db A[Catch: all -> 0x004d, PHI: r1 r3 r4 r5 r7 r10
          0x00db: PHI (r1v14 io.ktor.utils.io.ByteReadChannel) = (r1v10 io.ktor.utils.io.ByteReadChannel), (r1v15 io.ktor.utils.io.ByteReadChannel) binds: [B:18:0x0069, B:38:0x00d7] A[DONT_GENERATE, DONT_INLINE]
          0x00db: PHI (r3v6 io.ktor.utils.io.ByteWriteChannel) = (r3v3 io.ktor.utils.io.ByteWriteChannel), (r3v7 io.ktor.utils.io.ByteWriteChannel) binds: [B:18:0x0069, B:38:0x00d7] A[DONT_GENERATE, DONT_INLINE]
          0x00db: PHI (r4v6 io.ktor.utils.io.ByteWriteChannel) = (r4v3 io.ktor.utils.io.ByteWriteChannel), (r4v7 io.ktor.utils.io.ByteWriteChannel) binds: [B:18:0x0069, B:38:0x00d7] A[DONT_GENERATE, DONT_INLINE]
          0x00db: PHI (r5v7 java.lang.AutoCloseable) = (r5v3 java.lang.AutoCloseable), (r5v9 java.lang.AutoCloseable) binds: [B:18:0x0069, B:38:0x00d7] A[DONT_GENERATE, DONT_INLINE]
          0x00db: PHI (r7v3 int) = (r7v2 int), (r7v4 int) binds: [B:18:0x0069, B:38:0x00d7] A[DONT_GENERATE, DONT_INLINE]
          0x00db: PHI (r10v12 fb.v) = (r10v8 fb.v), (r10v18 fb.v) binds: [B:18:0x0069, B:38:0x00d7] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #5 {all -> 0x004d, blocks: (B:12:0x0048, B:37:0x00bf, B:40:0x00db), top: B:88:0x0048 }] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0119  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x013b A[Catch: all -> 0x007c, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x007c, blocks: (B:45:0x0105, B:26:0x0082, B:28:0x008a, B:30:0x0092, B:32:0x009a, B:35:0x00b3, B:50:0x010d, B:51:0x0110, B:52:0x0111, B:60:0x013b, B:21:0x0078, B:44:0x0103, B:36:0x00bc, B:43:0x00fa, B:48:0x010b), top: B:87:0x0007, inners: #1, #3 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00f6 -> B:44:0x0103). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00fa -> B:44:0x0103). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 428
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.ByteChannelsKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.util.ByteChannelsKt$split$1", f = "ByteChannels.kt", l = {27, 32}, m = "invokeSuspend")
    /* renamed from: io.ktor.util.ByteChannelsKt$split$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44111 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ ByteChannel $first;
        final /* synthetic */ ByteChannel $second;
        final /* synthetic */ ByteReadChannel $this_split;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "io.ktor.util.ByteChannelsKt$split$1$1", f = "ByteChannels.kt", l = {30}, m = "invokeSuspend")
        /* renamed from: io.ktor.util.ByteChannelsKt$split$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C04151 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
            final /* synthetic */ byte[] $buffer;
            final /* synthetic */ ByteChannel $first;
            final /* synthetic */ int $read;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C04151(ByteChannel byteChannel, byte[] bArr, int i10, InterfaceC4014c<? super C04151> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.$first = byteChannel;
                this.$buffer = bArr;
                this.$read = i10;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                return new C04151(this.$first, this.$buffer, this.$read, interfaceC4014c);
            }

            @Override // p9.p
            public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
                return ((C04151) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objG = C4063a.g();
                int i10 = this.label;
                if (i10 == 0) {
                    C4849c.b(obj);
                    ByteChannel byteChannel = this.$first;
                    byte[] bArr = this.$buffer;
                    int i11 = this.$read;
                    this.label = 1;
                    if (ByteWriteChannelOperationsKt.writeFully(byteChannel, bArr, 0, i11, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4849c.b(obj);
                }
                return t.f7040a;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "io.ktor.util.ByteChannelsKt$split$1$2", f = "ByteChannels.kt", l = {31}, m = "invokeSuspend")
        /* renamed from: io.ktor.util.ByteChannelsKt$split$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
            final /* synthetic */ byte[] $buffer;
            final /* synthetic */ int $read;
            final /* synthetic */ ByteChannel $second;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(ByteChannel byteChannel, byte[] bArr, int i10, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.$second = byteChannel;
                this.$buffer = bArr;
                this.$read = i10;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                return new AnonymousClass2(this.$second, this.$buffer, this.$read, interfaceC4014c);
            }

            @Override // p9.p
            public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
                return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objG = C4063a.g();
                int i10 = this.label;
                if (i10 == 0) {
                    C4849c.b(obj);
                    ByteChannel byteChannel = this.$second;
                    byte[] bArr = this.$buffer;
                    int i11 = this.$read;
                    this.label = 1;
                    if (ByteWriteChannelOperationsKt.writeFully(byteChannel, bArr, 0, i11, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4849c.b(obj);
                }
                return t.f7040a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C44111(ByteReadChannel byteReadChannel, ByteChannel byteChannel, ByteChannel byteChannel2, InterfaceC4014c<? super C44111> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$this_split = byteReadChannel;
            this.$first = byteChannel;
            this.$second = byteChannel2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C44111 c44111 = new C44111(this.$this_split, this.$first, this.$second, interfaceC4014c);
            c44111.L$0 = obj;
            return c44111;
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C44111) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x00a0, code lost:
        
            if (kotlinx.coroutines.AwaitKt.a(r2, r13) == r8) goto L27;
         */
        /* JADX WARN: Removed duplicated region for block: B:20:0x004b A[Catch: all -> 0x001f, TRY_LEAVE, TryCatch #2 {all -> 0x001f, blocks: (B:7:0x0018, B:18:0x0043, B:20:0x004b, B:32:0x00a9, B:36:0x00c3, B:14:0x002f), top: B:48:0x000d }] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0067 A[Catch: all -> 0x00a6, TRY_LEAVE, TryCatch #0 {all -> 0x00a6, blocks: (B:23:0x005f, B:25:0x0067), top: B:44:0x005f }] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00a9 A[Catch: all -> 0x001f, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x001f, blocks: (B:7:0x0018, B:18:0x0043, B:20:0x004b, B:32:0x00a9, B:36:0x00c3, B:14:0x002f), top: B:48:0x000d }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0065 -> B:29:0x00a4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00a0 -> B:28:0x00a3). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 241
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.ByteChannelsKt.C44111.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final void copyToBoth(ByteReadChannel byteReadChannel, final ByteWriteChannel first, final ByteWriteChannel second) {
        kotlin.jvm.internal.p.i(byteReadChannel, "<this>");
        kotlin.jvm.internal.p.i(first, "first");
        kotlin.jvm.internal.p.i(second, "second");
        C1060i.d(C1073o0.f6391a, Y.a(), null, new AnonymousClass1(byteReadChannel, first, second, null), 2, null).J(new InterfaceC5074l() { // from class: io.ktor.util.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ByteChannelsKt.copyToBoth$lambda$1(first, second, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t copyToBoth$lambda$1(ByteWriteChannel byteWriteChannel, ByteWriteChannel byteWriteChannel2, Throwable th) {
        if (th == null) {
            return t.f7040a;
        }
        ByteWriteChannelOperationsKt.close(byteWriteChannel, th);
        ByteWriteChannelOperationsKt.close(byteWriteChannel2, th);
        return t.f7040a;
    }

    public static final Pair<ByteReadChannel, ByteReadChannel> split(ByteReadChannel byteReadChannel, M coroutineScope) {
        kotlin.jvm.internal.p.i(byteReadChannel, "<this>");
        kotlin.jvm.internal.p.i(coroutineScope, "coroutineScope");
        final ByteChannel byteChannel = new ByteChannel(true);
        final ByteChannel byteChannel2 = new ByteChannel(true);
        C1060i.d(coroutineScope, null, null, new C44111(byteReadChannel, byteChannel, byteChannel2, null), 3, null).J(new InterfaceC5074l() { // from class: io.ktor.util.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ByteChannelsKt.split$lambda$0(byteChannel, byteChannel2, (Throwable) obj);
            }
        });
        return Y8.j.a(byteChannel, byteChannel2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t split$lambda$0(ByteChannel byteChannel, ByteChannel byteChannel2, Throwable th) {
        if (th == null) {
            return t.f7040a;
        }
        byteChannel.cancel(th);
        byteChannel2.cancel(th);
        return t.f7040a;
    }
}
