package com.obric.capabilitykit;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.logger.Logger;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f11433a = null;

    public static final class a extends IUriFileReceiver.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f11434a;

        /* JADX INFO: renamed from: com.obric.capabilitykit.w$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper$UriReceiver$1$onSessionReady$1", f = "UriShareInternalHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0179a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f11435a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ UriFileAccessSession f11436b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Function1<UriFileAccessSession, Unit> f11437c;

            /* JADX WARN: Multi-variable type inference failed */
            public C0179a(UriFileAccessSession r10, Function1<? super UriFileAccessSession, Unit> r11, Continuation<? super C0179a> r12) {
                this.f11436b = r10;
                this.f11437c = r11;
                super(2, r12);
            }

            @Nullable
            public final Object a(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
                return ((C0179a) create(r10, r11)).invokeSuspend(Unit.f21064a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
                return new C0179a(this.f11436b, this.f11437c, r11);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
                return a(r10, r11);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object r10) {
                kotlin.coroutines.intrinsics.a.d();
                if (this.f11435a != 0) goto L10;
                kotlin.c.b(r10);
                UriFileAccessSession r11 = this.f11436b;
                if (r11 == null) goto L8;
                this.f11437c.invoke(r11);
            L8:
                return Unit.f21064a;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public a(Function1 r10) {
            this.f11434a = r10;
        }

        @Override // com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver
        public void onSessionReady(UriFileAccessSession r10) {
            kotlinx.coroutines.h.d(d0.a(l0.b()), null, null, new C0179a(r10, this.f11434a, null), 3, null);
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper", f = "UriShareInternalHelper.kt", i = {0, 0, 2, 2, 3}, l = {75, 80, 89, 97}, m = "handleReturnedFd", n = {SlardarSettingsConsts.PERF_KEY_FD, "iStreamHandler", SlardarSettingsConsts.PERF_KEY_FD, "iStream", "errorCode"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f11438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f11439b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f11440c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public /* synthetic */ Object f11441d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ w f11442e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f11443f;

        public b(w r10, Continuation<? super b> r11) {
            this.f11442e = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            this.f11441d = r10;
            this.f11443f |= Integer.MIN_VALUE;
            return w.f(this.f11442e, null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper$handleReturnedFd$2", f = "UriShareInternalHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f11445b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InputStream f11446c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AssetFileDescriptor f11447d;

        public c(InputStream r10, AssetFileDescriptor r11, Continuation<? super c> r12) {
            this.f11446c = r10;
            this.f11447d = r11;
            super(2, r12);
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope r10, @Nullable Continuation<? super Result<Unit>> r11) {
            return ((c) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            c r12 = new c(this.f11446c, this.f11447d, r11);
            r12.f11445b = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Result<? extends Unit>> r11) {
            return a(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            kotlin.coroutines.intrinsics.a.d();
            if (this.f11444a != 0) goto L23;
            kotlin.c.b(r10);
            CoroutineScope r11 = (CoroutineScope) this.f11445b;
            this.f11446c.close();     // Catch: Throwable -> L7
            Object r12 = Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L7
        L9:
            Throwable r13 = Result.m38exceptionOrNullimpl(r12);
            if (r13 == null) goto L12;
            Logger.INSTANCE.e("UriShareHelper", "closing input stream raised error: " + r13, r13);
        L12:
            AssetFileDescriptor r14 = this.f11447d;
            r14.close();     // Catch: Throwable -> L15
            Logger.INSTANCE.d("UriShareHelper", "receiver closed the shared fd/" + r14.hashCode() + '.');     // Catch: Throwable -> L15
            Object r15 = Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L15
        L17:
            Throwable r16 = Result.m38exceptionOrNullimpl(r15);
            if (r16 == null) goto L21;
            Logger.INSTANCE.e("UriShareHelper", "closing fd raised error: " + r16, r16);
        L21:
            return Result.m34boximpl(r15);
        L15:
            th = move-exception;
            r15 = Result.m35constructorimpl(kotlin.c.a(th));
        L7:
            th = move-exception;
            r12 = Result.m35constructorimpl(kotlin.c.a(th));
            goto L9
        L23:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Ljava/io/FileInputStream;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper$handleReturnedFd$iStream$1", f = "UriShareInternalHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FileInputStream>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11448a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AssetFileDescriptor f11449b;

        public d(AssetFileDescriptor r10, Continuation<? super d> r11) {
            this.f11449b = r10;
            super(2, r11);
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope r10, @Nullable Continuation<? super FileInputStream> r11) {
            return ((d) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new d(this.f11449b, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super FileInputStream> r11) {
            return a(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            kotlin.coroutines.intrinsics.a.d();
            if (this.f11448a != 0) goto L7;
            kotlin.c.b(r10);
            return this.f11449b.createInputStream();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper$handleReturnedFd$iStream$2", f = "UriShareInternalHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AssetFileDescriptor f11451b;

        public e(AssetFileDescriptor r10, Continuation<? super e> r11) {
            this.f11451b = r10;
            super(2, r11);
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((e) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new e(this.f11451b, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
            return a(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            kotlin.coroutines.intrinsics.a.d();
            if (this.f11450a != 0) goto L7;
            kotlin.c.b(r10);
            this.f11451b.close();
            return Unit.f21064a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper", f = "UriShareInternalHelper.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {47, 60}, m = "openInputStreamByPackage", n = {"this", "uriPackageName", "uri", "onGranted", "this", "uriPackageName", "uri"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
    public static final class f extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f11452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f11453b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f11454c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f11455d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public /* synthetic */ Object f11456e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ w f11457f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f11458g;

        public f(w r10, Continuation<? super f> r11) {
            this.f11457f = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            this.f11456e = r10;
            this.f11458g |= Integer.MIN_VALUE;
            return this.f11457f.i(null, null, null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper", f = "UriShareInternalHelper.kt", i = {}, l = {129}, m = "startUriSession$capabilitykit_release", n = {}, s = {})
    public static final class g extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f11459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ w f11460b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f11461c;

        public g(w r10, Continuation<? super g> r11) {
            this.f11460b = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            this.f11459a = r10;
            this.f11461c |= Integer.MIN_VALUE;
            return this.f11460b.h(null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper$startUriSession$session$1", f = "UriShareInternalHelper.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
    public static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UriFileAccessSession>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f11463b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Uri f11464c;

        public h(String r10, Uri r11, Continuation<? super h> r12) {
            this.f11463b = r10;
            this.f11464c = r11;
            super(2, r12);
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope r10, @Nullable Continuation<? super UriFileAccessSession> r11) {
            return ((h) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new h(this.f11463b, this.f11464c, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super UriFileAccessSession> r11) {
            return a(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            Object r11 = kotlin.coroutines.intrinsics.a.d();
            int r12 = this.f11462a;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            kotlin.c.b(r10);
        L11:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            kotlin.c.b(r10);
            w r13 = w.f11433a;
            String r14 = this.f11463b;
            Uri r15 = this.f11464c;
            this.f11462a = 1;
            r10 = w.g(r13, r14, r15, this);
            if (r10 != r11) goto L11;
            return r11;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "session", "Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class i extends Lambda implements Function1<UriFileAccessSession, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CancellableContinuation<UriFileAccessSession> f11465a;

        /* JADX WARN: Multi-variable type inference failed */
        public i(CancellableContinuation<? super UriFileAccessSession> r10) {
            this.f11465a = r10;
            super(1);
        }

        public final void a(@NotNull UriFileAccessSession r10) {
            kotlin.jvm.internal.q.g(r10, "session");
            CancellableContinuation<UriFileAccessSession> r11 = this.f11465a;
            r11.resumeWith(Result.m35constructorimpl(r10));     // Catch: Throwable -> L5
            Object r12 = Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L5
        L8:
            if (Result.m38exceptionOrNullimpl(r12) == null) goto L15;
            AssetFileDescriptor r13 = r10.getFd();
            if (r13 == null) goto L16;
            r13.close();
            return;
        L16:
            return;
        L15:
            return;
        L5:
            th = move-exception;
            r12 = Result.m35constructorimpl(kotlin.c.a(th));
            goto L8
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(UriFileAccessSession r10) {
            a(r10);
            return Unit.f21064a;
        }
    }

    static {
        f11433a = new w();
    }

    public w() {
    }

    public static final /* synthetic */ a b(w r10, Function1 r11) {
        return r10.c(r11);
    }

    public static final /* synthetic */ Object f(w r10, AssetFileDescriptor r11, Function2 r12, Continuation r13) {
        return r10.d(r11, r12, r13);
    }

    public static final /* synthetic */ Object g(w r10, String r11, Uri r12, Continuation r13) {
        return r10.j(r11, r12, r13);
    }

    public final int a(String r10, Uri r11) {
        AtomicCapabilitySdk.INSTANCE.stopUriFileAccess$capabilitykit_release(r11, r10);     // Catch: Exception -> L4
        return 0;
    L4:
        e = move-exception;
        Logger.INSTANCE.e("UriShareHelper", "requestUriFileAccess; exception=" + e, e);
        return 1;
    }

    public final a c(Function1 r10) {
        return new a(r10);
    }

    public final Object d(AssetFileDescriptor r10, Function2 r11, Continuation r12) {
        if ((r12 instanceof b) == false) goto L7;
        b r13 = (b) r12;
        int r14 = r13.f11443f;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.f11443f = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.f11441d;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.f11443f;
        if (r17 == 0) goto L28;
        if (r17 == 1) goto L23;
        if (r17 == 2) goto L22;
        if (r17 == 3) goto L17;
        if (r17 != 4) goto L16;
        int r18 = r13.f11440c;
        kotlin.c.b(r15);
    L46:
        return tf.a.c(r18);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        InputStream r19 = (InputStream) r13.f11439b;
        AssetFileDescriptor r110 = (AssetFileDescriptor) r13.f11438a;
        kotlin.c.b(r15);     // Catch: Exception -> L20
    L37:
        int r20 = 0;
    L38:
        InputStream r21 = r19;
        r18 = r20;
        CoroutineDispatcher r22 = l0.b();
        c r23 = new c(r21, r110, null);
        r13.f11438a = null;
        r13.f11439b = null;
        r13.f11440c = r18;
        r13.f11443f = 4;
        if (kotlinx.coroutines.h.g(r22, r23, r13) != r16) goto L46;
        return r16;
    L20:
        Exception e10 = e;
    L41:
        Logger.INSTANCE.e("UriShareHelper", "handle input stream raised error: " + e10, e10);
        r20 = 6;
        goto L38
    L22:
        kotlin.c.b(r15);
    L51:
        return tf.a.c(5);
    L23:
        r11 = (Function2) r13.f11439b;
        r10 = (AssetFileDescriptor) r13.f11438a;
        kotlin.c.b(r15);     // Catch: Exception -> L26
    L32:
        kotlin.jvm.internal.q.f(r15, "fd: AssetFileDescriptor,…)\n            }\n        }");     // Catch: Exception -> L26
        InputStream r24 = (InputStream) r15;     // Catch: Exception -> L26
        Logger.INSTANCE.i("UriShareHelper", "the client is handling the returned InputStream...");     // Catch: Exception -> L39
        r13.f11438a = r10;     // Catch: Exception -> L39
        r13.f11439b = r24;     // Catch: Exception -> L39
        r13.f11443f = 3;     // Catch: Exception -> L39
        if (r11.mo0invoke(r24, r13) != r16) goto L36;
        return r16;
    L36:
        r110 = r10;
        r19 = r24;
    L39:
        e = move-exception;
        AssetFileDescriptor r25 = r10;
        r19 = r24;
        e10 = e;
        r110 = r25;
        goto L41
    L28:
        kotlin.c.b(r15);
        CoroutineDispatcher r26 = l0.b();     // Catch: Exception -> L26
        d r27 = new d(r10, null);     // Catch: Exception -> L26
        r13.f11438a = r10;     // Catch: Exception -> L26
        r13.f11439b = r11;     // Catch: Exception -> L26
        r13.f11443f = 1;     // Catch: Exception -> L26
        r15 = kotlinx.coroutines.h.g(r26, r27, r13);     // Catch: Exception -> L26
        if (r15 != r16) goto L32;
        return r16;
    L26:
        e = move-exception;
        Logger.INSTANCE.e("UriShareHelper", "cannot open input stream; error: " + e, e);
        CoroutineDispatcher r28 = l0.b();
        e r111 = new e(r10, null);
        r13.f11438a = null;
        r13.f11439b = null;
        r13.f11443f = 2;
        if (kotlinx.coroutines.h.g(r28, r111, r13) != r16) goto L51;
        return r16;
    L7:
        r13 = new b(this, r12);
        goto L8
    }

    public final Object e(AppEntity r10, Uri r11, Function2 r12, Continuation r13) {
        String r14 = r10.getPackageName();
        if (r14.length() != 0) goto L7;
        Logger.INSTANCE.e("UriShareHelper", "no sharer package found in entity.");
        return tf.a.c(3);
    L7:
        return i(r14, r11, r12, r13);
    }

    public final Object h(String r10, Uri r11, Continuation r12) {
        if ((r12 instanceof g) == false) goto L7;
        g r13 = (g) r12;
        int r14 = r13.f11461c;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.f11461c = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.f11459a;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.f11461c;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        kotlin.c.b(r15);
    L17:
        UriFileAccessSession r18 = (UriFileAccessSession) r15;
        if (r18 != null) goto L21;
        Logger.INSTANCE.e("UriShareHelper", "startUriSession: withTimeoutOrNull exceeds timeout: 3000ms ");
        return new UriFileAccessSession(9, "访问文件超时", null, 4, null);
    L21:
        return r18;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r15);
        h r19 = new h(r10, r11, null);
        r13.f11461c = 1;
        r15 = TimeoutKt.d(WsConstants.EXIT_DELAY_TIME, r19, r13);
        if (r15 != r16) goto L17;
        return r16;
    L7:
        r13 = new g(this, r12);
        goto L8
    }

    public final Object i(String r10, Uri r11, Function2 r12, Continuation r13) {
        if ((r13 instanceof f) == false) goto L7;
        f r14 = (f) r13;
        int r15 = r14.f11458g;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.f11458g = r15 - Integer.MIN_VALUE;
    L8:
        Object r16 = r14.f11456e;
        Object r17 = kotlin.coroutines.intrinsics.a.d();
        int r18 = r14.f11458g;
        if (r18 == 0) goto L16;
        if (r18 == 1) goto L15;
        if (r18 != 2) goto L14;
        Uri r19 = (Uri) r14.f11454c;
        r10 = (String) r14.f11453b;
        w r20 = (w) r14.f11452a;
        kotlin.c.b(r16);
    L30:
        int r110 = ((Number) r16).intValue();
        if (r110 == 0) goto L33;
        r20.a(r10, r19);
        return tf.a.c(r110);
    L33:
        return tf.a.c(r20.a(r10, r19));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r12 = (Function2) r14.f11455d;
        r11 = (Uri) r14.f11454c;
        r10 = (String) r14.f11453b;
        w this = (w) r14.f11452a;
        kotlin.c.b(r16);
    L19:
        UriFileAccessSession r111 = (UriFileAccessSession) r16;
        AssetFileDescriptor r21 = r111.getFd();
        if (r111.getStatus() != 0) goto L22;
        if (r21 == null) goto L25;
        r14.f11452a = this;
        r14.f11453b = r10;
        r14.f11454c = r11;
        r14.f11455d = null;
        r14.f11458g = 2;
        r16 = this.d(r21, r12, r14);
        if (r16 != r17) goto L29;
        return r17;
    L29:
        Uri r22 = r11;
        r20 = this;
        r19 = r22;
        goto L30
    L25:
        return tf.a.c(1);
    L22:
        return tf.a.c(r111.getStatus());
    L16:
        kotlin.c.b(r16);
        r14.f11452a = this;
        r14.f11453b = r10;
        r14.f11454c = r11;
        r14.f11455d = r12;
        r14.f11458g = 1;
        r16 = h(r10, r11, r14);
        if (r16 != r17) goto L19;
        return r17;
    L7:
        r14 = new f(this, r13);
        goto L8
    }

    public final Object j(String r10, Uri r11, Continuation r12) {
        n r13 = new n(IntrinsicsKt__IntrinsicsJvmKt.c(r12), 1);
        r13.initCancellability();
        AtomicCapabilitySdk.INSTANCE.requestUriFileAccess$capabilitykit_release(r11, r10, b(f11433a, new i(r13)));     // Catch: Exception -> L5
    L11:
        Object r14 = r13.q();
        if (r14 != kotlin.coroutines.intrinsics.a.d()) goto L14;
        tf.d.c(r12);
    L14:
        return r14;
    L5:
        e = move-exception;
        Logger.INSTANCE.e("UriShareHelper", "requestUriFileAccess; exception=" + e, e);
        r13.resumeWith(Result.m35constructorimpl(new UriFileAccessSession(7, null, null, 6, null)));     // Catch: Throwable -> L9
        Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.m35constructorimpl(kotlin.c.a(th));
        goto L11
    }
}
