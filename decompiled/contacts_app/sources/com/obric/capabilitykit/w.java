package com.obric.capabilitykit;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.logger.Logger;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002¢\u0006\u0002\u0010\rJ=\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\"\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016JE\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\"\u0010\u001c\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJE\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\"\u0010\u001c\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010 J#\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0080@ø\u0001\u0000¢\u0006\u0004\b#\u0010$J!\u0010%\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0018\u0010&\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lcom/obric/capabilitykit/execution/fileaccess/sharer/UriShareInternalHelper;", "", "()V", "TAG", "", "URI_OPEN_WAIT_TIME_MILLIS", "", "UriReceiver", "com/obric/capabilitykit/execution/fileaccess/sharer/UriShareInternalHelper$UriReceiver$1", "onSession", "Lkotlin/Function1;", "Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession;", "", "(Lkotlin/jvm/functions/Function1;)Lcom/obric/capabilitykit/execution/fileaccess/sharer/UriShareInternalHelper$UriReceiver$1;", "handleReturnedFd", "", SlardarSettingsConsts.PERF_KEY_FD, "Landroid/content/res/AssetFileDescriptor;", "iStreamHandler", "Lkotlin/Function2;", "Ljava/io/InputStream;", "Lkotlin/coroutines/Continuation;", "(Landroid/content/res/AssetFileDescriptor;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openInputStreamByEntity", "entity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "uri", "Landroid/net/Uri;", "onGranted", "(Lcom/obric/capabilitykit/entity/app/AppEntity;Landroid/net/Uri;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openInputStreamByPackage", "uriPackageName", "(Ljava/lang/String;Landroid/net/Uri;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startUriSession", "packageName", "startUriSession$capabilitykit_release", "(Ljava/lang/String;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startUriSessionInternal", "stopUriSession", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class w {
    public static final w a = null;
    private static final String b = "UriShareHelper";
    private static final long c = 3000;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/capabilitykit/execution/fileaccess/sharer/UriShareInternalHelper$UriReceiver$1", "Lcom/obric/capabilitykit/common/execution/fileaccess/IUriFileReceiver$Stub;", "onSessionReady", "", "fileAccess", "Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends IUriFileReceiver.Stub {
        public final /* synthetic */ Function1<UriFileAccessSession, Unit> a;

        /* JADX INFO: renamed from: com.obric.capabilitykit.w$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper$UriReceiver$1$onSessionReady$1", f = "UriShareInternalHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0080a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int a;
            public final /* synthetic */ UriFileAccessSession b;
            public final /* synthetic */ Function1<UriFileAccessSession, Unit> c;

            /* JADX WARN: Multi-variable type inference failed */
            public C0080a(UriFileAccessSession r1, Function1<? super UriFileAccessSession, Unit> r2, Continuation<? super C0080a> r3) {
                this.b = r1;
                this.c = r2;
                super(2, r3);
            }

            public final Object a(CoroutineScope r1, Continuation<? super Unit> r2) {
                return ((C0080a) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C0080a(this.b, this.c, r3);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return a(r1, r2);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.a != 0) goto L10;
                ResultKt.throwOnFailure(r2);
                UriFileAccessSession r3 = this.b;
                if (r3 == null) goto L8;
                this.c.invoke(r3);
            L8:
                return Unit.INSTANCE;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super UriFileAccessSession, Unit> r1) {
            this.a = r1;
        }

        @Override // com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver
        public void onSessionReady(UriFileAccessSession r8) {
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C0080a(r8, this.a, null), 3, null);
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper", f = "UriShareInternalHelper.kt", i = {0, 0, 2, 2, 3}, l = {75, 80, 89, 97}, m = "handleReturnedFd", n = {SlardarSettingsConsts.PERF_KEY_FD, "iStreamHandler", SlardarSettingsConsts.PERF_KEY_FD, "iStream", AccountConst.KEY_ERROR_CODE}, s = {"L$0", "L$1", "L$0", "L$1", "I$0"})
    public static final class b extends ContinuationImpl {
        public Object a;
        public Object b;
        public int c;
        public /* synthetic */ Object d;
        public final /* synthetic */ w e;
        public int f;

        public b(w r1, Continuation<? super b> r2) {
            this.e = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.d = r2;
            this.f |= Integer.MIN_VALUE;
            return w.a(this.e, null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper$handleReturnedFd$2", f = "UriShareInternalHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
        public int a;
        private /* synthetic */ Object b;
        public final /* synthetic */ InputStream c;
        public final /* synthetic */ AssetFileDescriptor d;

        public c(InputStream r1, AssetFileDescriptor r2, Continuation<? super c> r3) {
            this.c = r1;
            this.d = r2;
            super(2, r3);
        }

        public final Object a(CoroutineScope r1, Continuation<? super Result<Unit>> r2) {
            return ((c) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            c r0 = new c(this.c, this.d, r4);
            r0.b = r3;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Result<? extends Unit>> r2) {
            return a(r1, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) goto L23;
            ResultKt.throwOnFailure(r6);
            CoroutineScope r7 = (CoroutineScope) this.b;
            this.c.close();     // Catch: Throwable -> L7
            Object r8 = Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
        L9:
            Throwable r9 = Result.m806exceptionOrNullimpl(r8);
            if (r9 == null) goto L12;
            Logger.INSTANCE.e(w.b, "closing input stream raised error: " + r9, r9);
        L12:
            AssetFileDescriptor r5 = this.d;
            r5.close();     // Catch: Throwable -> L15
            Logger.INSTANCE.d(w.b, "receiver closed the shared fd/" + r5.hashCode() + '.');     // Catch: Throwable -> L15
            Object r10 = Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
        L17:
            Throwable r11 = Result.m806exceptionOrNullimpl(r10);
            if (r11 == null) goto L21;
            Logger.INSTANCE.e(w.b, "closing fd raised error: " + r11, r11);
        L21:
            return Result.m802boximpl(r10);
        L15:
            th = move-exception;
            r10 = Result.m803constructorimpl(ResultKt.createFailure(th));
        L7:
            th = move-exception;
            r8 = Result.m803constructorimpl(ResultKt.createFailure(th));
            goto L9
        L23:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Ljava/io/FileInputStream;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper$handleReturnedFd$iStream$1", f = "UriShareInternalHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FileInputStream>, Object> {
        public int a;
        public final /* synthetic */ AssetFileDescriptor b;

        public d(AssetFileDescriptor r1, Continuation<? super d> r2) {
            this.b = r1;
            super(2, r2);
        }

        public final Object a(CoroutineScope r1, Continuation<? super FileInputStream> r2) {
            return ((d) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new d(this.b, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super FileInputStream> r2) {
            return a(r1, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return this.b.createInputStream();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper$handleReturnedFd$iStream$2", f = "UriShareInternalHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ AssetFileDescriptor b;

        public e(AssetFileDescriptor r1, Continuation<? super e> r2) {
            this.b = r1;
            super(2, r2);
        }

        public final Object a(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((e) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new e(this.b, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return a(r1, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.b.close();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper", f = "UriShareInternalHelper.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {47, 60}, m = "openInputStreamByPackage", n = {"this", "uriPackageName", "uri", "onGranted", "this", "uriPackageName", "uri"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
    public static final class f extends ContinuationImpl {
        public Object a;
        public Object b;
        public Object c;
        public Object d;
        public /* synthetic */ Object e;
        public final /* synthetic */ w f;
        public int g;

        public f(w r1, Continuation<? super f> r2) {
            this.f = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.e = r2;
            this.g |= Integer.MIN_VALUE;
            return this.f.a(null, null, null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper", f = "UriShareInternalHelper.kt", i = {}, l = {129}, m = "startUriSession$capabilitykit_release", n = {}, s = {})
    public static final class g extends ContinuationImpl {
        public /* synthetic */ Object a;
        public final /* synthetic */ w b;
        public int c;

        public g(w r1, Continuation<? super g> r2) {
            this.b = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.a = r2;
            this.c |= Integer.MIN_VALUE;
            return this.b.a(null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper$startUriSession$session$1", f = "UriShareInternalHelper.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
    public static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UriFileAccessSession>, Object> {
        public int a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Uri c;

        public h(String r1, Uri r2, Continuation<? super h> r3) {
            this.b = r1;
            this.c = r2;
            super(2, r3);
        }

        public final Object a(CoroutineScope r1, Continuation<? super UriFileAccessSession> r2) {
            return ((h) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new h(this.b, this.c, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super UriFileAccessSession> r2) {
            return a(r1, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            w r6 = w.a;
            String r2 = this.b;
            Uri r3 = this.c;
            this.a = 1;
            r5 = w.a(r6, r2, r3, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "session", "Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class i extends Lambda implements Function1<UriFileAccessSession, Unit> {
        public final /* synthetic */ CancellableContinuation<UriFileAccessSession> a;

        /* JADX WARN: Multi-variable type inference failed */
        public i(CancellableContinuation<? super UriFileAccessSession> r1) {
            this.a = r1;
            super(1);
        }

        public final void a(UriFileAccessSession r2) {
            Intrinsics.checkNotNullParameter(r2, "session");
            CancellableContinuation<UriFileAccessSession> r1 = this.a;
            r1.resumeWith(Result.m803constructorimpl(r2));     // Catch: Throwable -> L5
            Object r3 = Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        L8:
            if (Result.m806exceptionOrNullimpl(r3) == null) goto L15;
            AssetFileDescriptor r4 = r2.getFd();
            if (r4 == null) goto L16;
            r4.close();
            return;
        L16:
            return;
        L15:
            return;
        L5:
            th = move-exception;
            r3 = Result.m803constructorimpl(ResultKt.createFailure(th));
            goto L8
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(UriFileAccessSession r1) {
            a(r1);
            return Unit.INSTANCE;
        }
    }

    static {
        a = new w();
    }

    private w() {
    }

    private final int a(String r2, Uri r3) {
        AtomicCapabilitySdk.INSTANCE.stopUriFileAccess$capabilitykit_release(r3, r2);     // Catch: Exception -> L4
        return 0;
    L4:
        e = move-exception;
        Logger.INSTANCE.e(b, "requestUriFileAccess; exception=" + e, e);
        return 1;
    }

    public static final /* synthetic */ a a(w r0, Function1 r1) {
        return r0.a(r1);
    }

    private final a a(Function1<? super UriFileAccessSession, Unit> r1) {
        return new a(r1);
    }

    private final Object a(AssetFileDescriptor r10, Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r11, Continuation<? super Integer> r12) {
        if ((r12 instanceof b) == false) goto L7;
        b r0 = (b) r12;
        int r1 = r0.f;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.f = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.d;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.f;
        if (r2 == 0) goto L26;
        if (r2 == 1) goto L23;
        if (r2 == 2) goto L22;
        if (r2 == 3) goto L17;
        if (r2 != 4) goto L16;
        int r14 = r0.c;
        ResultKt.throwOnFailure(r9);
    L44:
        return Boxing.boxInt(r14);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        InputStream r15 = (InputStream) r0.b;
        AssetFileDescriptor r16 = (AssetFileDescriptor) r0.a;
        ResultKt.throwOnFailure(r9);     // Catch: Exception -> L20
    L35:
        int r17 = 0;
    L36:
        InputStream r8 = r15;
        r14 = r17;
        CoroutineDispatcher r3 = Dispatchers.getIO();
        c r4 = new c(r8, r16, null);
        r0.a = null;
        r0.b = null;
        r0.c = r14;
        r0.f = 4;
        if (BuildersKt.withContext(r3, r4, r0) != r13) goto L44;
        return r13;
    L20:
        Exception e2 = e;
    L39:
        Logger.INSTANCE.e(b, "handle input stream raised error: " + e2, e2);
        r17 = 6;
        goto L36
    L22:
        ResultKt.throwOnFailure(r9);
    L50:
        return Boxing.boxInt(5);
    L23:
        r11 = (Function2) r0.b;
        r10 = (AssetFileDescriptor) r0.a;
        ResultKt.throwOnFailure(r9);     // Catch: Exception -> L45
    L30:
        Intrinsics.checkNotNullExpressionValue(r9, "fd: AssetFileDescriptor,…)\n            }\n        }");     // Catch: Exception -> L45
        InputStream r18 = (InputStream) r9;     // Catch: Exception -> L45
        Logger.INSTANCE.i(b, "the client is handling the returned InputStream...");     // Catch: Exception -> L37
        r0.a = r10;     // Catch: Exception -> L37
        r0.b = r18;     // Catch: Exception -> L37
        r0.f = 3;     // Catch: Exception -> L37
        if (r11.invoke(r18, r0) != r13) goto L34;
        return r13;
    L34:
        r16 = r10;
        r15 = r18;
    L37:
        e = move-exception;
        AssetFileDescriptor r19 = r10;
        r15 = r18;
        e2 = e;
        r16 = r19;
        goto L39
    L26:
        ResultKt.throwOnFailure(r9);
        CoroutineDispatcher r20 = Dispatchers.getIO();     // Catch: Exception -> L45
        d r5 = new d(r10, null);     // Catch: Exception -> L45
        r0.a = r10;     // Catch: Exception -> L45
        r0.b = r11;     // Catch: Exception -> L45
        r0.f = 1;     // Catch: Exception -> L45
        r9 = BuildersKt.withContext(r20, r5, r0);     // Catch: Exception -> L45
        if (r9 != r13) goto L30;
        return r13;
    L45:
        e = move-exception;
        Logger.INSTANCE.e(b, "cannot open input stream; error: " + e, e);
        CoroutineDispatcher r21 = Dispatchers.getIO();
        e r110 = new e(r10, null);
        r0.a = null;
        r0.b = null;
        r0.f = 2;
        if (BuildersKt.withContext(r21, r110, r0) != r13) goto L50;
        return r13;
    L7:
        r0 = new b(this, r12);
        goto L8
    }

    public static final /* synthetic */ Object a(w r0, AssetFileDescriptor r1, Function2 r2, Continuation r3) {
        return r0.a(r1, r2, r3);
    }

    public static final /* synthetic */ Object a(w r0, String r1, Uri r2, Continuation r3) {
        return r0.b(r1, r2, r3);
    }

    private final Object b(String r9, Uri r10, Continuation<? super UriFileAccessSession> r11) {
        CancellableContinuationImpl r8 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r11), 1);
        r8.initCancellability();
        AtomicCapabilitySdk.INSTANCE.requestUriFileAccess$capabilitykit_release(r10, r9, a(a, new i(r8)));     // Catch: Exception -> L5
    L11:
        Object r12 = r8.getResult();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L14:
        return r12;
    L5:
        e = move-exception;
        Logger.INSTANCE.e(b, "requestUriFileAccess; exception=" + e, e);
        r8.resumeWith(Result.m803constructorimpl(new UriFileAccessSession(7, null, null, 6, null)));     // Catch: Throwable -> L9
        Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final Object a(AppEntity r2, Uri r3, Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r4, Continuation<? super Integer> r5) {
        String r6 = r2.getPackageName();
        if (r6.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        Logger.INSTANCE.e(b, "no sharer package found in entity.");
        return Boxing.boxInt(3);
    L10:
        return a(r6, r3, r4, r5);
    L5:
        r0 = false;
        goto L6
    }

    public final Object a(String r7, Uri r8, Continuation<? super UriFileAccessSession> r9) {
        if ((r9 instanceof g) == false) goto L7;
        g r0 = (g) r9;
        int r1 = r0.c;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.c = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.a;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.c;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L17:
        UriFileAccessSession r11 = (UriFileAccessSession) r6;
        if (r11 != null) goto L21;
        Logger.INSTANCE.e(b, "startUriSession: withTimeoutOrNull exceeds timeout: 3000ms ");
        return new UriFileAccessSession(9, "访问文件超时", null, 4, null);
    L21:
        return r11;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        h r12 = new h(r7, r8, null);
        r0.c = 1;
        r6 = TimeoutKt.withTimeoutOrNull(3000, r12, r0);
        if (r6 != r10) goto L17;
        return r10;
    L7:
        r0 = new g(this, r9);
        goto L8
    }

    public final Object a(String r8, Uri r9, Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r10, Continuation<? super Integer> r11) {
        if ((r11 instanceof f) == false) goto L7;
        f r0 = (f) r11;
        int r1 = r0.g;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.g = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.e;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.g;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        Uri r7 = (Uri) r0.c;
        r8 = (String) r0.b;
        w r13 = (w) r0.a;
        ResultKt.throwOnFailure(r12);
    L30:
        int r14 = ((Number) r12).intValue();
        if (r14 == 0) goto L33;
        r13.a(r8, r7);
        return Boxing.boxInt(r14);
    L33:
        return Boxing.boxInt(r13.a(r8, r7));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r10 = (Function2) r0.d;
        r9 = (Uri) r0.c;
        r8 = (String) r0.b;
        w this = (w) r0.a;
        ResultKt.throwOnFailure(r12);
    L19:
        UriFileAccessSession r15 = (UriFileAccessSession) r12;
        AssetFileDescriptor r4 = r15.getFd();
        if (r15.getStatus() != 0) goto L22;
        if (r4 == null) goto L25;
        r0.a = this;
        r0.b = r8;
        r0.c = r9;
        r0.d = null;
        r0.g = 2;
        r12 = this.a(r4, r10, r0);
        if (r12 != r2) goto L29;
        return r2;
    L29:
        Uri r6 = r9;
        r13 = this;
        r7 = r6;
        goto L30
    L25:
        return Boxing.boxInt(1);
    L22:
        return Boxing.boxInt(r15.getStatus());
    L16:
        ResultKt.throwOnFailure(r12);
        r0.a = this;
        r0.b = r8;
        r0.c = r9;
        r0.d = r10;
        r0.g = 1;
        r12 = a(r8, r9, r0);
        if (r12 != r2) goto L19;
        return r2;
    L7:
        r0 = new f(this, r11);
        goto L8
    }
}
