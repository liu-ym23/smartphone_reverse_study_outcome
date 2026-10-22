package com.stepos.ailauncher.express.net;

import Y8.h;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.net.HttpManager;
import e9.InterfaceC4014c;
import java.util.concurrent.TimeUnit;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import tb.z;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0007\u0010\bJD\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bH\u0082@¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u0013¨\u0006!"}, d2 = {"Lcom/stepos/ailauncher/express/net/AmooExpressRepository;", "", "<init>", "()V", "Lcom/stepos/ailauncher/express/net/e;", "req", "Lcom/stepos/ailauncher/express/net/f;", "f", "(Lcom/stepos/ailauncher/express/net/e;Le9/c;)Ljava/lang/Object;", "", "tag", "Lkotlin/Function1;", "Le9/c;", "Lcom/stepos/ailauncher/network/ApiResponse;", "Lcom/stepos/ailauncher/express/net/b;", "block", "e", "(Ljava/lang/String;Lcom/stepos/ailauncher/express/net/e;Lp9/l;Le9/c;)Ljava/lang/Object;", "BASE_URL_KEY", "Ljava/lang/String;", "", "REQUEST_TIMEOUT_MS", "J", "Lcom/stepos/ailauncher/express/net/a;", "api$delegate", "LY8/h;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lcom/stepos/ailauncher/express/net/a;", "api", "", "CODE_AUDIT_BLOCKED", "I", "TAG", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AmooExpressRepository {
    private static final String BASE_URL_KEY = "amooExpress";
    private static final int CODE_AUDIT_BLOCKED = 3;
    private static final long REQUEST_TIMEOUT_MS = 60000;
    private static final String TAG = "AmooExpressApi";
    public static final AmooExpressRepository INSTANCE = new AmooExpressRepository();

    /* renamed from: api$delegate, reason: from kotlin metadata */
    private static final h api = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.express.net.d
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return AmooExpressRepository.d();
        }
    });

    public static final a d() {
        HttpManager httpManager = HttpManager.INSTANCE;
        z.a aVarZ = httpManager.okHttpClient().z();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return (a) httpManager.getRetrofit(BASE_URL_KEY).e().f(aVarZ.T(60000L, timeUnit).e(60000L, timeUnit).d()).d().c(a.class);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(java.lang.String r8, com.stepos.ailauncher.express.net.AmooExpressRequest r9, p9.InterfaceC5074l<? super e9.InterfaceC4014c<? super com.stepos.ailauncher.network.ApiResponse<com.stepos.ailauncher.express.net.AmooExpressData>>, ? extends java.lang.Object> r10, e9.InterfaceC4014c<? super com.stepos.ailauncher.express.net.f> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 535
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.express.net.AmooExpressRepository.e(java.lang.String, com.stepos.ailauncher.express.net.e, p9.l, e9.c):java.lang.Object");
    }

    public final Object f(AmooExpressRequest amooExpressRequest, InterfaceC4014c<? super f> interfaceC4014c) {
        return e("editBatch", amooExpressRequest, new AmooExpressRepository$editBatch$2(amooExpressRequest, null), interfaceC4014c);
    }

    public final a g() {
        Object value = api.getValue();
        p.h(value, "getValue(...)");
        return (a) value;
    }
}
