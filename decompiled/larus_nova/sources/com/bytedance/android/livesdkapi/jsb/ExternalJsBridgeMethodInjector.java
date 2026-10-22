package com.bytedance.android.livesdkapi.jsb;

import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import n56.c;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014R7\u0010\u0007\u001a\"\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00060\u00040\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR/\u0010\f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u00040\u00030\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR/\u0010\u000e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u00040\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\nR/\u0010\u0011\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u00040\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u0012\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/jsb/ExternalJsBridgeMethodInjector;", "", "", "Lkotlin/Function0;", "", "", "Lcom/bytedance/ies/web/jsbridge2/g;", "statelessMethodsProviders", "Ljava/util/Collection;", "getStatelessMethodsProviders", "()Ljava/util/Collection;", "Lcom/bytedance/ies/web/jsbridge2/f$b;", "statefulMethodsProviders", "getStatefulMethodsProviders", "statefulMethodsProvidersForFragmentScene", "getStatefulMethodsProvidersForFragmentScene", "Ln56/c;", "legacyMethodsProviders", "getLegacyMethodsProviders", "<init>", "()V", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExternalJsBridgeMethodInjector {
    public static final ExternalJsBridgeMethodInjector INSTANCE = null;
    private static final Collection<Function0<Map<String, c>>> legacyMethodsProviders = null;
    private static final Collection<Function0<Map<String, f.b>>> statefulMethodsProviders = null;
    private static final Collection<Function0<Map<String, f.b>>> statefulMethodsProvidersForFragmentScene = null;
    private static final Collection<Function0<Map<String, g<?, ?>>>> statelessMethodsProviders = null;

    private ExternalJsBridgeMethodInjector() {
    }

    static {
        INSTANCE = new ExternalJsBridgeMethodInjector();
        statelessMethodsProviders = new CopyOnWriteArrayList();
        statefulMethodsProviders = new CopyOnWriteArrayList();
        statefulMethodsProvidersForFragmentScene = new CopyOnWriteArrayList();
        legacyMethodsProviders = new CopyOnWriteArrayList();
    }

    public final Collection<Function0<Map<String, c>>> getLegacyMethodsProviders() {
        return legacyMethodsProviders;
    }

    public final Collection<Function0<Map<String, f.b>>> getStatefulMethodsProviders() {
        return statefulMethodsProviders;
    }

    public final Collection<Function0<Map<String, f.b>>> getStatefulMethodsProvidersForFragmentScene() {
        return statefulMethodsProvidersForFragmentScene;
    }

    public final Collection<Function0<Map<String, g<?, ?>>>> getStatelessMethodsProviders() {
        return statelessMethodsProviders;
    }
}
