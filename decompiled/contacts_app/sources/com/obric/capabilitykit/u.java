package com.obric.capabilitykit;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Process;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.logger.Logger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/obric/capabilitykit/execution/fileaccess/receiver/UriFileOpener;", "", "uriToOpen", "Landroid/net/Uri;", "forReceiver", "Lcom/obric/capabilitykit/common/execution/fileaccess/IUriFileReceiver;", "receiverPackage", "", "(Landroid/net/Uri;Lcom/obric/capabilitykit/common/execution/fileaccess/IUriFileReceiver;Ljava/lang/String;)V", "getForReceiver", "()Lcom/obric/capabilitykit/common/execution/fileaccess/IUriFileReceiver;", "getReceiverPackage", "()Ljava/lang/String;", "getUriToOpen", "()Landroid/net/Uri;", "open", "", "receiverPid", "", "Companion", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class u {
    public static final a d = null;
    private static final String e = "UriFileOpener";
    private final Uri a;
    private final IUriFileReceiver b;
    private final String c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/capabilitykit/execution/fileaccess/receiver/UriFileOpener$Companion;", "", "()V", "TAG", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.receiver.UriFileOpener$open$1", f = "UriFileOpener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ u b;

        public b(u r1, Continuation<? super b> r2) {
            this.b = r1;
            super(2, r2);
        }

        public final Object a(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((b) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new b(this.b, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return a(r1, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) goto L15;
            ResultKt.throwOnFailure(r10);
            Logger.INSTANCE.e(u.e, "return failure to the receiver: " + this.b.b() + " ---> URI " + this.b.c());
            u r9 = this.b;
            r9.a().onSessionReady(new UriFileAccessSession(4, "分享方未能开启 URI = " + r9.c(), null, 4, null));     // Catch: Throwable -> L7
            Object r11 = Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
        L9:
            Throwable r12 = Result.m806exceptionOrNullimpl(r11);
            if (r12 == null) goto L13;
            Logger.INSTANCE.e(u.e, "cannot notify failure to the receiver; e=" + r12, r12);
        L13:
            return Unit.INSTANCE;
        L7:
            th = move-exception;
            r11 = Result.m803constructorimpl(ResultKt.createFailure(th));
            goto L9
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.receiver.UriFileOpener$open$2", f = "UriFileOpener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ AssetFileDescriptor b;
        public final /* synthetic */ u c;
        public final /* synthetic */ int d;

        public c(AssetFileDescriptor r1, u r2, int r3, Continuation<? super c> r4) {
            this.b = r1;
            this.c = r2;
            this.d = r3;
            super(2, r4);
        }

        public final Object a(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((c) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new c(this.b, this.c, this.d, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return a(r1, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) goto L27;
            ResultKt.throwOnFailure(r8);
            Logger.INSTANCE.i(u.e, "returning & closing opened fd/" + this.b.hashCode() + " to the receiver: " + this.c.b() + " ---> URI " + this.c.c());
            this.c.a().onSessionReady(new UriFileAccessSession(0, "成功", this.b));     // Catch: Throwable -> L7
            Object r9 = Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
        L9:
            Throwable r10 = Result.m806exceptionOrNullimpl(r9);
            if (r10 == null) goto L12;
            Logger.INSTANCE.e(u.e, "cannot notify opened fd to the receiver; e=" + r10, r10);
        L12:
            int r11 = this.d;
            AssetFileDescriptor r2 = this.b;
            u r4 = this.c;
            int r5 = Process.myPid();     // Catch: Throwable -> L19
            if (r11 != r5) goto L16;
            Logger r0 = Logger.INSTANCE;     // Catch: Throwable -> L19
            String r12 = "not closing fd because the sharer/receiver are with the same PID (" + r11 + ").";     // Catch: Throwable -> L19
        L17:
            r0.d(u.e, r12);     // Catch: Throwable -> L19
            Object r13 = Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
        L21:
            AssetFileDescriptor r7 = this.b;
            Throwable r14 = Result.m806exceptionOrNullimpl(r13);
            if (r14 == null) goto L25;
            Logger.INSTANCE.e(u.e, "cannot close opened fd/" + r7.hashCode() + "; e=" + r14, r14);
        L25:
            return Unit.INSTANCE;
        L16:
            r2.close();     // Catch: Throwable -> L19
            Logger r1 = Logger.INSTANCE;     // Catch: Throwable -> L19
            r12 = "sharer closed the shared fd/" + r2.hashCode() + " for URI: " + r4.c() + "; rcvPid=" + r11 + "; myPid=" + r5 + '.';     // Catch: Throwable -> L19
            r0 = r1;
        L19:
            th = move-exception;
            r13 = Result.m803constructorimpl(ResultKt.createFailure(th));
        L7:
            th = move-exception;
            r9 = Result.m803constructorimpl(ResultKt.createFailure(th));
            goto L9
        L27:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        d = new a(null);
    }

    public u(Uri r2, IUriFileReceiver r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "uriToOpen");
        Intrinsics.checkNotNullParameter(r3, "forReceiver");
        Intrinsics.checkNotNullParameter(r4, "receiverPackage");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public final IUriFileReceiver a() {
        return this.b;
    }

    public final void a(int r10) {
        AssetFileDescriptor r1 = AppHost.Companion.getApplication().getContentResolver().openAssetFileDescriptor(this.a, "r");     // Catch: Exception -> L5
    L7:
        if (r1 != null) goto L9;
        Logger.INSTANCE.w(e, "openFd = null; UriFileOpener: " + this.c + " ---> URI " + this.a);
        CoroutineScope r3 = ActionDispatcher.INSTANCE.getScope();
        Function2 r6 = new b(this, null);
    L10:
        BuildersKt.launch$default(r3, null, null, r6, 3, null);
        return;
    L9:
        r3 = ActionDispatcher.INSTANCE.getScope();
        r6 = new c(r1, this, r10, null);
    L5:
        e = move-exception;
        Logger.INSTANCE.e(e, "failed to open URI " + this.a + " (for " + this.c + "); e=" + e, e);
        r1 = null;
        goto L7
    }

    public final String b() {
        return this.c;
    }

    public final Uri c() {
        return this.a;
    }
}
