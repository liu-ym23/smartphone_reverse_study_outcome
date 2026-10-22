package com.stepos.ailauncher.task.detail;

import android.net.Uri;
import android.widget.Toast;
import com.stepos.ailauncher.task.R$string;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.io.IOException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.detail.TaskDetailActivity$runDownload$2", f = "TaskDetailActivity.kt", l = {1686, 1693}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskDetailActivity$runDownload$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ Uri $destUri;
    final /* synthetic */ p9.p<Uri, Boolean, Y8.t> $onDone;
    final /* synthetic */ InterfaceC5074l<Uri, Y8.t> $write;
    Object L$0;
    int label;
    final /* synthetic */ TaskDetailActivity this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.task.detail.TaskDetailActivity$runDownload$2$1", f = "TaskDetailActivity.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.task.detail.TaskDetailActivity$runDownload$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;
        final /* synthetic */ TaskDetailActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(TaskDetailActivity taskDetailActivity, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = taskDetailActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.this$0, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            this.this$0.N3(false);
            Toast.makeText(this.this$0, R$string.task_detail_download_complete, 0).show();
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.task.detail.TaskDetailActivity$runDownload$2$2", f = "TaskDetailActivity.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.task.detail.TaskDetailActivity$runDownload$2$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ Exception $e;
        int label;
        final /* synthetic */ TaskDetailActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(TaskDetailActivity taskDetailActivity, Exception exc, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = taskDetailActivity;
            this.$e = exc;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(this.this$0, this.$e, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String message;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            this.this$0.N3(false);
            Exception exc = this.$e;
            String string = ((exc instanceof IOException) && (message = exc.getMessage()) != null && La.H.g0(message, "ENOSPC", false, 2, null)) ? this.this$0.getString(R$string.task_detail_storage_insufficient) : this.this$0.getString(R$string.task_detail_download_failed);
            kotlin.jvm.internal.p.f(string);
            Toast.makeText(this.this$0, string, 0).show();
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TaskDetailActivity$runDownload$2(InterfaceC5074l<? super Uri, Y8.t> interfaceC5074l, Uri uri, p9.p<? super Uri, ? super Boolean, Y8.t> pVar, TaskDetailActivity taskDetailActivity, InterfaceC4014c<? super TaskDetailActivity$runDownload$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$write = interfaceC5074l;
        this.$destUri = uri;
        this.$onDone = pVar;
        this.this$0 = taskDetailActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaskDetailActivity$runDownload$2(this.$write, this.$destUri, this.$onDone, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((TaskDetailActivity$runDownload$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004b, code lost:
    
        if (r7 == r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0088, code lost:
    
        if (Ua.C1056g.j(r1, r4, r7) != r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x008a, code lost:
    
        return r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r7.label
            r2 = 2
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L25
            if (r1 == r4) goto L1f
            if (r1 != r2) goto L17
            java.lang.Object r7 = r7.L$0
            java.lang.Exception r7 = (java.lang.Exception) r7
            kotlin.C4849c.b(r8)
            goto L8b
        L17:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1f:
            kotlin.C4849c.b(r8)     // Catch: java.lang.Exception -> L23
            goto L8b
        L23:
            r8 = move-exception
            goto L4e
        L25:
            kotlin.C4849c.b(r8)
            p9.l<android.net.Uri, Y8.t> r8 = r7.$write     // Catch: java.lang.Exception -> L23
            android.net.Uri r1 = r7.$destUri     // Catch: java.lang.Exception -> L23
            r8.invoke(r1)     // Catch: java.lang.Exception -> L23
            p9.p<android.net.Uri, java.lang.Boolean, Y8.t> r8 = r7.$onDone     // Catch: java.lang.Exception -> L23
            android.net.Uri r1 = r7.$destUri     // Catch: java.lang.Exception -> L23
            java.lang.Boolean r5 = g9.C4109a.a(r4)     // Catch: java.lang.Exception -> L23
            r8.invoke(r1, r5)     // Catch: java.lang.Exception -> L23
            Ua.A0 r8 = Ua.Y.c()     // Catch: java.lang.Exception -> L23
            com.stepos.ailauncher.task.detail.TaskDetailActivity$runDownload$2$1 r1 = new com.stepos.ailauncher.task.detail.TaskDetailActivity$runDownload$2$1     // Catch: java.lang.Exception -> L23
            com.stepos.ailauncher.task.detail.TaskDetailActivity r5 = r7.this$0     // Catch: java.lang.Exception -> L23
            r1.<init>(r5, r3)     // Catch: java.lang.Exception -> L23
            r7.label = r4     // Catch: java.lang.Exception -> L23
            java.lang.Object r7 = Ua.C1056g.j(r8, r1, r7)     // Catch: java.lang.Exception -> L23
            if (r7 != r0) goto L8b
            goto L8a
        L4e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "download failed e="
            r1.append(r4)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            r4 = 4
            java.lang.String r5 = "TaskDetailActivity"
            r6 = 0
            h8.C4148a.u(r5, r1, r6, r4, r3)
            p9.p<android.net.Uri, java.lang.Boolean, Y8.t> r1 = r7.$onDone
            android.net.Uri r4 = r7.$destUri
            java.lang.Boolean r5 = g9.C4109a.a(r6)
            r1.invoke(r4, r5)
            Ua.A0 r1 = Ua.Y.c()
            com.stepos.ailauncher.task.detail.TaskDetailActivity$runDownload$2$2 r4 = new com.stepos.ailauncher.task.detail.TaskDetailActivity$runDownload$2$2
            com.stepos.ailauncher.task.detail.TaskDetailActivity r5 = r7.this$0
            r4.<init>(r5, r8, r3)
            java.lang.Object r8 = g9.h.a(r8)
            r7.L$0 = r8
            r7.label = r2
            java.lang.Object r7 = Ua.C1056g.j(r1, r4, r7)
            if (r7 != r0) goto L8b
        L8a:
            return r0
        L8b:
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.detail.TaskDetailActivity$runDownload$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
