package com.stepos.taskrobot.dictionary;

import C7.f;
import F9.E;
import F9.F;
import T9.b;
import android.content.Context;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stepos.taskrobot.dictionary.interceptor.BizInterceptor;
import f6.AbstractC1439d;
import java.util.ArrayList;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.a;
import kotlin.jvm.internal.k;
import okhttp3.logging.HttpLoggingInterceptor$Level;
import qa.N;
import ra.C1884a;
import u1.d;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/taskrobot/dictionary/DictionaryHttpClient;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "LC7/r;", "init", "(Landroid/content/Context;)V", "", "baseUrl", "Lqa/N;", "newRetrofit", "(Ljava/lang/String;)Lqa/N;", "Lcom/google/gson/Gson;", "gson$delegate", "LC7/f;", "getGson", "()Lcom/google/gson/Gson;", "gson", "_context", "Landroid/content/Context;", "dictionary_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DictionaryHttpClient {
    private static Context _context;
    public static final DictionaryHttpClient INSTANCE = new DictionaryHttpClient();

    /* renamed from: gson$delegate, reason: from kotlin metadata */
    private static final f gson = a.b(LazyThreadSafetyMode.f4885a, new com.stepos.ability.voicewakeup.service.f(10));

    private DictionaryHttpClient() {
    }

    private final Gson getGson() {
        Object f4884a = gson.getF4884a();
        k.e(f4884a, "getValue(...)");
        return (Gson) f4884a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Gson gson_delegate$lambda$0() {
        return new GsonBuilder().serializeNulls().create();
    }

    public final void init(Context context) {
        k.f(context, "context");
        _context = context.getApplicationContext();
    }

    public final N newRetrofit(String baseUrl) {
        k.f(baseUrl, "baseUrl");
        Context context = _context;
        if (context == null) {
            throw new IllegalStateException("DictionaryManager.init(context) must be called before making API requests");
        }
        E eA = ((F) AbstractC1439d.f4442a.getF4884a()).a();
        eA.a(new BizInterceptor(context));
        b bVar = new b();
        bVar.b = HttpLoggingInterceptor$Level.c;
        eA.a(bVar);
        F f = new F(eA);
        d dVar = new d(20);
        dVar.I(baseUrl);
        dVar.b = f;
        ((ArrayList) dVar.d).add(C1884a.c(getGson()));
        return dVar.J();
    }
}
