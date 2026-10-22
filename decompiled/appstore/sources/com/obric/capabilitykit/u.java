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
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f11423d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f11424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IUriFileReceiver f11425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11426c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.receiver.UriFileOpener$open$1", f = "UriFileOpener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ u f11428b;

        public b(u r10, Continuation<? super b> r11) {
            this.f11428b = r10;
            super(2, r11);
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((b) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new b(this.f11428b, r11);
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
            if (this.f11427a != 0) goto L15;
            kotlin.c.b(r10);
            Logger.INSTANCE.e("UriFileOpener", "return failure to the receiver: " + this.f11428b.c() + " ---> URI " + this.f11428b.d());
            u r11 = this.f11428b;
            r11.a().onSessionReady(new UriFileAccessSession(4, "分享方未能开启 URI = " + r11.d(), null, 4, null));     // Catch: Throwable -> L7
            Object r12 = Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L7
        L9:
            Throwable r13 = Result.m38exceptionOrNullimpl(r12);
            if (r13 == null) goto L13;
            Logger.INSTANCE.e("UriFileOpener", "cannot notify failure to the receiver; e=" + r13, r13);
        L13:
            return Unit.f21064a;
        L7:
            th = move-exception;
            r12 = Result.m35constructorimpl(kotlin.c.a(th));
            goto L9
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.receiver.UriFileOpener$open$2", f = "UriFileOpener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AssetFileDescriptor f11430b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u f11431c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f11432d;

        public c(AssetFileDescriptor r10, u r11, int r12, Continuation<? super c> r13) {
            this.f11430b = r10;
            this.f11431c = r11;
            this.f11432d = r12;
            super(2, r13);
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((c) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new c(this.f11430b, this.f11431c, this.f11432d, r11);
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
            if (this.f11429a != 0) goto L28;
            kotlin.c.b(r10);
            Logger.INSTANCE.i("UriFileOpener", "returning & closing opened fd/" + this.f11430b.hashCode() + " to the receiver: " + this.f11431c.c() + " ---> URI " + this.f11431c.d());
            this.f11431c.a().onSessionReady(new UriFileAccessSession(0, "成功", this.f11430b));     // Catch: Throwable -> L7
            Object r11 = Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L7
        L9:
            Throwable r12 = Result.m38exceptionOrNullimpl(r11);
            if (r12 == null) goto L12;
            Logger.INSTANCE.e("UriFileOpener", "cannot notify opened fd to the receiver; e=" + r12, r12);
        L12:
            int r13 = this.f11432d;
            AssetFileDescriptor r14 = this.f11430b;
            u r15 = this.f11431c;
            int r16 = Process.myPid();     // Catch: Throwable -> L16
            if (r13 != r16) goto L18;
            Logger r17 = Logger.INSTANCE;     // Catch: Throwable -> L16
            String r18 = "not closing fd because the sharer/receiver are with the same PID (" + r13 + ").";     // Catch: Throwable -> L16
        L19:
            r17.d("UriFileOpener", r18);     // Catch: Throwable -> L16
            Object r19 = Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L16
        L22:
            AssetFileDescriptor r20 = this.f11430b;
            Throwable r21 = Result.m38exceptionOrNullimpl(r19);
            if (r21 == null) goto L26;
            Logger.INSTANCE.e("UriFileOpener", "cannot close opened fd/" + r20.hashCode() + "; e=" + r21, r21);
        L26:
            return Unit.f21064a;
        L18:
            r14.close();     // Catch: Throwable -> L16
            Logger r22 = Logger.INSTANCE;     // Catch: Throwable -> L16
            r18 = "sharer closed the shared fd/" + r14.hashCode() + " for URI: " + r15.d() + "; rcvPid=" + r13 + "; myPid=" + r16 + '.';     // Catch: Throwable -> L16
            r17 = r22;
        L16:
            th = move-exception;
            r19 = Result.m35constructorimpl(kotlin.c.a(th));
        L7:
            th = move-exception;
            r11 = Result.m35constructorimpl(kotlin.c.a(th));
            goto L9
        L28:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f11423d = new a(null);
    }

    public u(Uri r10, IUriFileReceiver r11, String r12) {
        kotlin.jvm.internal.q.g(r10, "uriToOpen");
        kotlin.jvm.internal.q.g(r11, "forReceiver");
        kotlin.jvm.internal.q.g(r12, "receiverPackage");
        this.f11424a = r10;
        this.f11425b = r11;
        this.f11426c = r12;
    }

    public final IUriFileReceiver a() {
        return this.f11425b;
    }

    public final void b(int r10) {
        AssetFileDescriptor r11 = AppHost.Companion.getApplication().getContentResolver().openAssetFileDescriptor(this.f11424a, "r");     // Catch: Exception -> L5
    L7:
        if (r11 != null) goto L10;
        Logger.INSTANCE.w("UriFileOpener", "openFd = null; UriFileOpener: " + this.f11426c + " ---> URI " + this.f11424a);
        CoroutineScope r12 = ActionDispatcher.INSTANCE.getScope();
        Function2 r13 = new b(this, null);
    L9:
        h.d(r12, null, null, r13, 3, null);
        return;
    L10:
        r12 = ActionDispatcher.INSTANCE.getScope();
        r13 = new c(r11, this, r10, null);
    L5:
        e = move-exception;
        Logger.INSTANCE.e("UriFileOpener", "failed to open URI " + this.f11424a + " (for " + this.f11426c + "); e=" + e, e);
        r11 = null;
        goto L7
    }

    public final String c() {
        return this.f11426c;
    }

    public final Uri d() {
        return this.f11424a;
    }
}
