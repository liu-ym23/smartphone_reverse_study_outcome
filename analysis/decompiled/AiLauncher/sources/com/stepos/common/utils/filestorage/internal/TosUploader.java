package com.stepos.common.utils.filestorage.internal;

import P6.TosCallbackBody;
import Ua.C1056g;
import Ua.InterfaceC1066l;
import Ua.Y;
import Y8.t;
import android.content.Context;
import android.net.Uri;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.common.utils.filestorage.internal.TosUploader;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import tb.AbstractC5531D;
import tb.AbstractC5550q;
import tb.C5530C;
import tb.InterfaceC5538e;
import tb.InterfaceC5539f;
import tb.z;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005JR\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0086@¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0019H\u0082@¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001d¨\u0006 "}, d2 = {"Lcom/stepos/common/utils/filestorage/internal/TosUploader;", "", "Ltb/z;", "okHttp", "<init>", "(Ltb/z;)V", "Landroid/content/Context;", "context", "", "uploadUrl", "Landroid/net/Uri;", "uri", "contentType", "", "contentLength", "Lkotlin/Function1;", "LY8/t;", "onBytesWritten", "LP6/j;", "f", "(Landroid/content/Context;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/Long;Lp9/l;Le9/c;)Ljava/lang/Object;", "Ltb/C;", UxipConstants.f30685x, "e", "(Ltb/C;)LP6/j;", "Ltb/e;", "call", Const.INTENT_KEY_UMID, "(Ltb/e;Le9/c;)Ljava/lang/Object;", "Ltb/z;", "Companion", Const.INTENT_KEY_APIKEY, "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TosUploader {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "FileStorage.Tos";
    private final z okHttp;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/common/utils/filestorage/internal/TosUploader$a;", "", "<init>", "()V", "", "tosPutTimeoutMs", "Ltb/z;", Const.INTENT_KEY_PKGNAME, "(J)Ltb/z;", "", "TAG", "Ljava/lang/String;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.common.utils.filestorage.internal.TosUploader$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static final AbstractC5550q c(InterfaceC5538e it) {
            p.i(it, "it");
            return new d();
        }

        public final z b(long tosPutTimeoutMs) {
            z.a aVarG = new z.a().g(30L, TimeUnit.SECONDS);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            return aVarG.T(tosPutTimeoutMs, timeUnit).W(tosPutTimeoutMs, timeUnit).U(true).l(new AbstractC5550q.c() { // from class: com.stepos.common.utils.filestorage.internal.g
                @Override // tb.AbstractC5550q.c
                public final AbstractC5550q a(InterfaceC5538e interfaceC5538e) {
                    return TosUploader.Companion.c(interfaceC5538e);
                }
            }).d();
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b implements InterfaceC5074l<Throwable, t> {
        final /* synthetic */ InterfaceC5538e $call;

        public b(InterfaceC5538e interfaceC5538e) {
            this.$call = interfaceC5538e;
        }

        public final void a(Throwable th) {
            InterfaceC5538e interfaceC5538e = this.$call;
            try {
                Result.Companion companion = Result.INSTANCE;
                interfaceC5538e.cancel();
                Result.b(t.f7040a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th2));
            }
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ t invoke(Throwable th) {
            a(th);
            return t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/stepos/common/utils/filestorage/internal/TosUploader$c", "Ltb/f;", "Ltb/e;", "call", "Ltb/C;", UxipConstants.f30685x, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ltb/e;Ltb/C;)V", "Ljava/io/IOException;", "e", Const.INTENT_KEY_UMID, "(Ltb/e;Ljava/io/IOException;)V", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements InterfaceC5539f {
        final /* synthetic */ InterfaceC1066l<C5530C> $cont;

        /* JADX WARN: Multi-variable type inference failed */
        public c(InterfaceC1066l<? super C5530C> interfaceC1066l) {
            this.$cont = interfaceC1066l;
        }

        @Override // tb.InterfaceC5539f
        public void a(InterfaceC5538e call, C5530C response) {
            p.i(call, "call");
            p.i(response, "response");
            this.$cont.resumeWith(Result.b(response));
        }

        @Override // tb.InterfaceC5539f
        public void d(InterfaceC5538e call, IOException e10) {
            p.i(call, "call");
            p.i(e10, "e");
            InterfaceC1066l<C5530C> interfaceC1066l = this.$cont;
            Result.Companion companion = Result.INSTANCE;
            interfaceC1066l.resumeWith(Result.b(C4849c.a(e10)));
        }
    }

    public TosUploader(z okHttp) {
        p.i(okHttp, "okHttp");
        this.okHttp = okHttp;
    }

    public final Object d(InterfaceC5538e interfaceC5538e, InterfaceC4014c<? super C5530C> interfaceC4014c) {
        kotlinx.coroutines.c cVar = new kotlinx.coroutines.c(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c), 1);
        cVar.I();
        cVar.q(new b(interfaceC5538e));
        interfaceC5538e.J(new c(cVar));
        Object objC = cVar.C();
        if (objC == C4063a.g()) {
            g9.f.c(interfaceC4014c);
        }
        return objC;
    }

    public final TosCallbackBody e(C5530C response) {
        int code = response.getCode();
        AbstractC5531D body = response.getBody();
        String strA = body != null ? body.A() : null;
        if (strA == null) {
            strA = "";
        }
        return h.a(code, strA);
    }

    public final Object f(Context context, String str, Uri uri, String str2, Long l10, InterfaceC5074l<? super Long, t> interfaceC5074l, InterfaceC4014c<? super TosCallbackBody> interfaceC4014c) {
        return C1056g.j(Y.b(), new TosUploader$put$2(str2, context, uri, l10, interfaceC5074l, str, this, null), interfaceC4014c);
    }
}
