package com.stepos.ailauncher.chat.input.upload;

import Y8.t;
import Z8.C1172u;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.audit.k;
import com.stepos.agentframework.chatcore.file.FileInfo;
import com.stepos.agentframework.chatcore.session.AgentError;
import com.stepos.agentframework.chatcore.session.ChatCoreSdk;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.adapter.C2517x;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import t4.InterfaceC5507a;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 12\u00020\u0001:\u00012B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0013J+\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0014\u0010\u0016\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\n0\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010!R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010&\u001a\u0004\b/\u0010(\"\u0004\b0\u0010*¨\u00063"}, d2 = {"Lcom/stepos/ailauncher/chat/input/upload/c;", "", "Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/chat/adapter/x;", "adapter", "<init>", "(Landroid/content/Context;Lcom/stepos/ailauncher/chat/adapter/x;)V", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "handler", "LY8/t;", "l", "(Lcom/stepos/agentframework/chatcore/SessionHandler;)V", "newAdapter", "k", "(Lcom/stepos/ailauncher/chat/adapter/x;)V", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", Const.STR_FILE, "m", "(Lcom/stepos/agentframework/chatcore/file/FileInfo;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lkotlin/Function1;", "onResult", "o", "(Lcom/stepos/agentframework/chatcore/file/FileInfo;Lp9/l;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/agentframework/chatcore/SessionHandler;Lcom/stepos/agentframework/chatcore/file/FileInfo;)V", "fileInfo", "", "status", "failReason", "f", "(Lcom/stepos/agentframework/chatcore/file/FileInfo;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/Context;", "Lcom/stepos/ailauncher/chat/adapter/x;", "sessionHandler", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "auditUserId", "Ljava/lang/String;", "getAuditUserId", "()Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)V", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "uploadType", "getUploadType", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c {
    private static final String TAG = "FileUploadController";
    private C2517x adapter;
    private String auditUserId;
    private final Context context;
    private final Handler mainHandler;
    private SessionHandler sessionHandler;
    private String uploadType;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/stepos/ailauncher/chat/input/upload/c$b", "Lt4/a;", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "fileInfo", "", "progress", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/file/FileInfo;I)V", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatcore/file/FileInfo;)V", "Lcom/stepos/agentframework/chatcore/session/AgentError;", "e", "c", "(Lcom/stepos/agentframework/chatcore/file/FileInfo;Lcom/stepos/agentframework/chatcore/session/AgentError;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements InterfaceC5507a {

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class a implements Runnable {
            final /* synthetic */ FileInfo $fileInfo$inlined;
            final /* synthetic */ c this$0;

            public a(c cVar, FileInfo fileInfo) {
                this.this$0 = cVar;
                this.$fileInfo$inlined = fileInfo;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.this$0.adapter.v(this.$fileInfo$inlined.getFileId());
                Toast.makeText(this.this$0.context, k.INSTANCE.h(), 0).show();
            }
        }

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.chat.input.upload.c$b$b, reason: collision with other inner class name */
        public static final class RunnableC0284b implements Runnable {
            final /* synthetic */ AgentError $e$inlined;
            final /* synthetic */ FileInfo $fileInfo$inlined;
            final /* synthetic */ c this$0;

            public RunnableC0284b(c cVar, FileInfo fileInfo, AgentError agentError) {
                this.this$0 = cVar;
                this.$fileInfo$inlined = fileInfo;
                this.$e$inlined = agentError;
            }

            @Override // java.lang.Runnable
            public final void run() {
                C2517x c2517x = this.this$0.adapter;
                FileInfo fileInfo = this.$fileInfo$inlined;
                fileInfo.setUploadState(FileInfo.UploadState.FAILED);
                fileInfo.setError(this.$e$inlined.getMessage());
                c2517x.z(fileInfo);
            }
        }

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.chat.input.upload.c$b$c, reason: collision with other inner class name */
        public static final class RunnableC0285c implements Runnable {
            final /* synthetic */ FileInfo $fileInfo$inlined;
            final /* synthetic */ int $progress$inlined;
            final /* synthetic */ c this$0;

            public RunnableC0285c(c cVar, FileInfo fileInfo, int i10) {
                this.this$0 = cVar;
                this.$fileInfo$inlined = fileInfo;
                this.$progress$inlined = i10;
            }

            @Override // java.lang.Runnable
            public final void run() {
                C2517x c2517x = this.this$0.adapter;
                FileInfo fileInfo = this.$fileInfo$inlined;
                fileInfo.setUploadState(FileInfo.UploadState.UPLOADING);
                fileInfo.setProgress(this.$progress$inlined);
                c2517x.z(fileInfo);
            }
        }

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class d implements Runnable {
            final /* synthetic */ FileInfo $fileInfo$inlined;
            final /* synthetic */ c this$0;

            public d(c cVar, FileInfo fileInfo) {
                this.this$0 = cVar;
                this.$fileInfo$inlined = fileInfo;
            }

            @Override // java.lang.Runnable
            public final void run() {
                C2517x c2517x = this.this$0.adapter;
                FileInfo fileInfo = this.$fileInfo$inlined;
                fileInfo.setUploadState(FileInfo.UploadState.SUCCESS);
                fileInfo.setProgress(100);
                c2517x.z(fileInfo);
            }
        }

        public b() {
        }

        @Override // t4.InterfaceC5507a
        public void a(FileInfo fileInfo, int progress) {
            p.i(fileInfo, "fileInfo");
            com.stepos.ailauncher.chat.input.upload.d.c("upload progress: " + progress, c.TAG);
            c cVar = c.this;
            if (!p.d(Looper.myLooper(), Looper.getMainLooper())) {
                cVar.mainHandler.post(new RunnableC0285c(cVar, fileInfo, progress));
                return;
            }
            C2517x c2517x = cVar.adapter;
            fileInfo.setUploadState(FileInfo.UploadState.UPLOADING);
            fileInfo.setProgress(progress);
            c2517x.z(fileInfo);
        }

        @Override // t4.InterfaceC5507a
        public void b(FileInfo fileInfo) {
            p.i(fileInfo, "fileInfo");
            c cVar = c.this;
            if (p.d(Looper.myLooper(), Looper.getMainLooper())) {
                C2517x c2517x = cVar.adapter;
                fileInfo.setUploadState(FileInfo.UploadState.SUCCESS);
                fileInfo.setProgress(100);
                c2517x.z(fileInfo);
            } else {
                cVar.mainHandler.post(new d(cVar, fileInfo));
            }
            c.this.f(fileInfo, "success", null);
        }

        @Override // t4.InterfaceC5507a
        public void c(FileInfo fileInfo, AgentError e10) {
            p.i(fileInfo, "fileInfo");
            p.i(e10, "e");
            if (e10.getCode() == 10105) {
                com.stepos.ailauncher.chat.input.upload.d.d("upload audit blocked fileId=" + fileInfo.getFileId() + " msg=" + e10.getMessage(), c.TAG);
                c cVar = c.this;
                if (p.d(Looper.myLooper(), Looper.getMainLooper())) {
                    cVar.adapter.v(fileInfo.getFileId());
                    Toast.makeText(cVar.context, k.INSTANCE.h(), 0).show();
                } else {
                    cVar.mainHandler.post(new a(cVar, fileInfo));
                }
            } else {
                com.stepos.ailauncher.chat.input.upload.d.d("upload failed fileId=" + fileInfo.getFileId() + " code=" + e10.getCode() + " msg=" + e10.getMessage(), c.TAG);
                c cVar2 = c.this;
                if (p.d(Looper.myLooper(), Looper.getMainLooper())) {
                    C2517x c2517x = cVar2.adapter;
                    fileInfo.setUploadState(FileInfo.UploadState.FAILED);
                    fileInfo.setError(e10.getMessage());
                    c2517x.z(fileInfo);
                } else {
                    cVar2.mainHandler.post(new RunnableC0284b(cVar2, fileInfo, e10));
                }
            }
            c.this.f(fileInfo, "fail", e10.getMessage());
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.input.upload.c$c, reason: collision with other inner class name */
    public static final class RunnableC0286c implements Runnable {
        final /* synthetic */ FileInfo $file$inlined;

        public RunnableC0286c(FileInfo fileInfo) {
            this.$file$inlined = fileInfo;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.this.adapter.v(this.$file$inlined.getFileId());
            Toast.makeText(c.this.context, R$string.upload_privacy_blocked, 0).show();
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/stepos/ailauncher/chat/input/upload/c$d", "Lt4/a;", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "fileInfo", "", "progress", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/file/FileInfo;I)V", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatcore/file/FileInfo;)V", "Lcom/stepos/agentframework/chatcore/session/AgentError;", "e", "c", "(Lcom/stepos/agentframework/chatcore/file/FileInfo;Lcom/stepos/agentframework/chatcore/session/AgentError;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements InterfaceC5507a {
        final /* synthetic */ InterfaceC5074l<FileInfo, t> $onResult;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class a implements Runnable {
            final /* synthetic */ InterfaceC5074l $onResult$inlined;

            public a(InterfaceC5074l interfaceC5074l) {
                this.$onResult$inlined = interfaceC5074l;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.$onResult$inlined.invoke(null);
            }
        }

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class b implements Runnable {
            final /* synthetic */ FileInfo $fileInfo$inlined;
            final /* synthetic */ InterfaceC5074l $onResult$inlined;

            public b(InterfaceC5074l interfaceC5074l, FileInfo fileInfo) {
                this.$onResult$inlined = interfaceC5074l;
                this.$fileInfo$inlined = fileInfo;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.$onResult$inlined.invoke(this.$fileInfo$inlined);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d(InterfaceC5074l<? super FileInfo, t> interfaceC5074l) {
            this.$onResult = interfaceC5074l;
        }

        @Override // t4.InterfaceC5507a
        public void a(FileInfo fileInfo, int progress) {
            p.i(fileInfo, "fileInfo");
        }

        @Override // t4.InterfaceC5507a
        public void b(FileInfo fileInfo) {
            p.i(fileInfo, "fileInfo");
            fileInfo.setUploadState(FileInfo.UploadState.SUCCESS);
            fileInfo.setProgress(100);
            c cVar = c.this;
            InterfaceC5074l<FileInfo, t> interfaceC5074l = this.$onResult;
            if (p.d(Looper.myLooper(), Looper.getMainLooper())) {
                interfaceC5074l.invoke(fileInfo);
            } else {
                cVar.mainHandler.post(new b(interfaceC5074l, fileInfo));
            }
        }

        @Override // t4.InterfaceC5507a
        public void c(FileInfo fileInfo, AgentError e10) {
            p.i(fileInfo, "fileInfo");
            p.i(e10, "e");
            com.stepos.ailauncher.chat.input.upload.d.d("silent upload failed: " + e10.getMessage(), c.TAG);
            c cVar = c.this;
            InterfaceC5074l<FileInfo, t> interfaceC5074l = this.$onResult;
            if (p.d(Looper.myLooper(), Looper.getMainLooper())) {
                interfaceC5074l.invoke(null);
            } else {
                cVar.mainHandler.post(new a(interfaceC5074l));
            }
        }
    }

    public c(Context context, C2517x adapter) {
        p.i(context, "context");
        p.i(adapter, "adapter");
        this.context = context;
        this.adapter = adapter;
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    public static final t n(c cVar, SessionHandler sessionHandler, FileInfo fileInfo, boolean z10) {
        if (z10) {
            cVar.j(sessionHandler, fileInfo);
        } else {
            com.stepos.ailauncher.chat.input.upload.d.d("upload privacy blocked fileId=" + fileInfo.getFileId(), TAG);
            if (p.d(Looper.myLooper(), Looper.getMainLooper())) {
                cVar.adapter.v(fileInfo.getFileId());
                Toast.makeText(cVar.context, R$string.upload_privacy_blocked, 0).show();
            } else {
                cVar.mainHandler.post(cVar.new RunnableC0286c(fileInfo));
            }
        }
        return t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(com.stepos.agentframework.chatcore.file.FileInfo r13, java.lang.String r14, java.lang.String r15) {
        /*
            r12 = this;
            com.stepos.agentframework.chatcore.SessionHandler r0 = r12.sessionHandler
            r1 = 0
            if (r0 == 0) goto L19
            com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation r0 = r0.R1()
            if (r0 == 0) goto L19
            java.lang.String r0 = r0.B()
            if (r0 == 0) goto L19
            int r2 = r0.length()
            if (r2 <= 0) goto L19
            r4 = r0
            goto L1a
        L19:
            r4 = r1
        L1a:
            int r0 = r13.getFileType()
            r2 = 1
            if (r0 == r2) goto L2f
            r2 = 2
            if (r0 == r2) goto L2b
            r2 = 6
            if (r0 == r2) goto L2f
            java.lang.String r0 = "document"
        L29:
            r8 = r0
            goto L32
        L2b:
            java.lang.String r0 = "video"
            goto L29
        L2f:
            java.lang.String r0 = "image"
            goto L29
        L32:
            java.lang.String r13 = r13.getFileSize()
            if (r13 == 0) goto L4a
            java.lang.Long r13 = La.C.y(r13)
            if (r13 == 0) goto L4a
            long r0 = r13.longValue()
            r13 = 1024(0x400, float:1.435E-42)
            long r2 = (long) r13
            long r0 = r0 / r2
            java.lang.Long r1 = java.lang.Long.valueOf(r0)
        L4a:
            r9 = r1
            com.stepos.ailauncher.chat.trace.ChatTracker r3 = com.stepos.ailauncher.chat.trace.ChatTracker.INSTANCE
            r6 = 0
            java.lang.String r7 = r12.uploadType
            r5 = r4
            r10 = r14
            r11 = r15
            r3.v(r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.input.upload.c.f(com.stepos.agentframework.chatcore.file.FileInfo, java.lang.String, java.lang.String):void");
    }

    public final void g(FileInfo file) {
        p.i(file, "file");
        file.setUploadState(FileInfo.UploadState.PENDING);
        file.setProgress(0);
        file.setError(null);
        this.adapter.z(file);
        m(file);
    }

    public final void h(String str) {
        this.auditUserId = str;
    }

    public final void i(String str) {
        this.uploadType = str;
    }

    public final void j(SessionHandler handler, FileInfo file) {
        handler.k4(C1172u.e(file), new b());
    }

    public final void k(C2517x newAdapter) {
        p.i(newAdapter, "newAdapter");
        this.adapter = newAdapter;
    }

    public final void l(SessionHandler handler) {
        this.sessionHandler = handler;
    }

    public final void m(final FileInfo file) {
        p.i(file, "file");
        final SessionHandler sessionHandler = this.sessionHandler;
        if (sessionHandler == null) {
            Log.w(TAG, "upload skipped: SessionHandler is null");
            return;
        }
        if (ChatCoreSdk.INSTANCE.g()) {
            if (file.getFileType() == 1) {
                SessionHandler.S0(sessionHandler, file, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.input.upload.b
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return c.n(this.f25485a, sessionHandler, file, ((Boolean) obj).booleanValue());
                    }
                }, 2, null);
                return;
            } else {
                j(sessionHandler, file);
                return;
            }
        }
        com.stepos.ailauncher.chat.input.upload.d.d("upload: ChatCoreSdk not initialized, fail via uploadFile fileId=" + file.getFileId(), TAG);
        j(sessionHandler, file);
    }

    public final void o(FileInfo file, InterfaceC5074l<? super FileInfo, t> onResult) {
        p.i(file, "file");
        p.i(onResult, "onResult");
        SessionHandler sessionHandler = this.sessionHandler;
        if (sessionHandler != null) {
            sessionHandler.k4(C1172u.e(file), new d(onResult));
        } else {
            Log.w(TAG, "uploadSilently skipped: SessionHandler is null");
            onResult.invoke(null);
        }
    }
}
