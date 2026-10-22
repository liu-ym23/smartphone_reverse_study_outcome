package com.stepos.ailauncher.task.common;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import tb.AbstractC5531D;
import tb.C5528A;
import tb.C5530C;
import tb.InterfaceC5538e;
import tb.InterfaceC5539f;
import tb.z;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u000b\u0010\fJY\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00070\u00062\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/task/common/l;", "", "<init>", "()V", "", "fileId", "Lkotlin/Function1;", "LY8/t;", "onText", "", "onError", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Lp9/l;Lp9/l;)V", "url", "Lkotlin/Function0;", "onFailRetry", "e", "(Ljava/lang/String;Ljava/lang/String;Lp9/l;Lp9/l;Lp9/a;)V", "TAG", "Ljava/lang/String;", "", "MAX_TEXT_BYTES", "J", "Ltb/z;", "client$delegate", "LY8/h;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ltb/z;", "client", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class l {
    private static final long MAX_TEXT_BYTES = 524288;
    private static final String TAG = "ArtifactTextFetcher";
    public static final l INSTANCE = new l();

    /* renamed from: client$delegate, reason: from kotlin metadata */
    private static final Y8.h client = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.common.k
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return l.d();
        }
    });

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/stepos/ailauncher/task/common/l$a", "Ltb/f;", "Ltb/e;", "call", "Ljava/io/IOException;", "e", "LY8/t;", Const.INTENT_KEY_UMID, "(Ltb/e;Ljava/io/IOException;)V", "Ltb/C;", UxipConstants.f30685x, Const.INTENT_KEY_APIKEY, "(Ltb/e;Ltb/C;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements InterfaceC5539f {
        final /* synthetic */ InterfaceC5074l<Throwable, t> $failed;
        final /* synthetic */ String $fileId;
        final /* synthetic */ InterfaceC5074l<Throwable, t> $onError;
        final /* synthetic */ InterfaceC5074l<String, t> $onText;

        /* JADX WARN: Multi-variable type inference failed */
        public a(String str, InterfaceC5074l<? super Throwable, t> interfaceC5074l, InterfaceC5074l<? super Throwable, t> interfaceC5074l2, InterfaceC5074l<? super String, t> interfaceC5074l3) {
            this.$fileId = str;
            this.$failed = interfaceC5074l;
            this.$onError = interfaceC5074l2;
            this.$onText = interfaceC5074l3;
        }

        @Override // tb.InterfaceC5539f
        public void a(InterfaceC5538e call, C5530C response) throws IOException {
            Object objB;
            p.i(call, "call");
            p.i(response, "response");
            String str = this.$fileId;
            InterfaceC5074l<Throwable, t> interfaceC5074l = this.$failed;
            InterfaceC5074l<Throwable, t> interfaceC5074l2 = this.$onError;
            InterfaceC5074l<String, t> interfaceC5074l3 = this.$onText;
            try {
                if (!response.getIsSuccessful()) {
                    C4148a.u(l.TAG, "fetch text http " + response.getCode() + " fileId=" + str, false, 4, null);
                    interfaceC5074l.invoke(null);
                    l9.b.a(response, null);
                    return;
                }
                AbstractC5531D body = response.getBody();
                long contentLength = body != null ? body.getContentLength() : -1L;
                if (contentLength > l.MAX_TEXT_BYTES) {
                    C4148a.k(l.TAG, "text too large (" + contentLength + " B), skip inline preview fileId=" + str, false, 4, null);
                    interfaceC5074l2.invoke(null);
                    l9.b.a(response, null);
                    return;
                }
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objB = Result.b(body != null ? body.A() : null);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    C4148a.t(l.TAG, "read text body failed fileId=" + str, thE, false, 8, null);
                }
                if (Result.g(objB)) {
                    objB = null;
                }
                String str2 = (String) objB;
                if (str2 == null || str2.length() == 0) {
                    C4148a.u(l.TAG, "fetch text empty body fileId=" + str, false, 4, null);
                    interfaceC5074l.invoke(null);
                } else {
                    interfaceC5074l3.invoke(str2);
                }
                t tVar = t.f7040a;
                l9.b.a(response, null);
            } finally {
            }
        }

        @Override // tb.InterfaceC5539f
        public void d(InterfaceC5538e call, IOException e10) {
            p.i(call, "call");
            p.i(e10, "e");
            C4148a.t(l.TAG, "fetch text failed fileId=" + this.$fileId, e10, false, 8, null);
            this.$failed.invoke(e10);
        }
    }

    public static final z d() {
        z.a aVar = new z.a();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return aVar.g(15L, timeUnit).T(15L, timeUnit).d();
    }

    public static final t f(InterfaceC5063a interfaceC5063a, InterfaceC5074l interfaceC5074l, Throwable th) {
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        } else {
            interfaceC5074l.invoke(th);
        }
        return t.f7040a;
    }

    public static final t h(String str, InterfaceC5074l interfaceC5074l, InterfaceC5074l interfaceC5074l2, String url, InterfaceC5063a interfaceC5063a) {
        p.i(url, "url");
        INSTANCE.e(url, str, interfaceC5074l, interfaceC5074l2, interfaceC5063a);
        return t.f7040a;
    }

    public final void e(String url, String fileId, InterfaceC5074l<? super String, t> onText, final InterfaceC5074l<? super Throwable, t> onError, final InterfaceC5063a<t> onFailRetry) {
        i().a(new C5528A.a().t(url).b()).J(new a(fileId, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.common.j
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return l.f(onFailRetry, onError, (Throwable) obj);
            }
        }, onError, onText));
    }

    public final void g(final String fileId, final InterfaceC5074l<? super String, t> onText, final InterfaceC5074l<? super Throwable, t> onError) {
        p.i(fileId, "fileId");
        p.i(onText, "onText");
        p.i(onError, "onError");
        u6.i.h(u6.i.INSTANCE, fileId, false, new p9.p() { // from class: com.stepos.ailauncher.task.common.i
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return l.h(fileId, onText, onError, (String) obj, (InterfaceC5063a) obj2);
            }
        }, onError, 2, null);
    }

    public final z i() {
        return (z) client.getValue();
    }
}
