package com.bytedance.android.livesdkapi.jsb;

import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import n56.c;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00040\u0002H\u0016J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0002H\u0016J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0002H\u0016R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/jsb/ExternalJsBridgeMethodFactory;", "", "", "", "Lcom/bytedance/ies/web/jsbridge2/g;", "provideStatelessMethods", "Lcom/bytedance/ies/web/jsbridge2/f$b;", "provideStatefulMethods", "Ln56/c;", "provideLegacyMethods", "", "preventNamespace", "Z", "getPreventNamespace", "()Z", "setPreventNamespace", "(Z)V", "<init>", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ExternalJsBridgeMethodFactory {
    private boolean preventNamespace;

    public ExternalJsBridgeMethodFactory() {
    }

    public Map<String, c> provideLegacyMethods() {
        return MapsKt.emptyMap();
    }

    public Map<String, f.b> provideStatefulMethods() {
        return MapsKt.emptyMap();
    }

    public Map<String, g<?, ?>> provideStatelessMethods() {
        return MapsKt.emptyMap();
    }

    public final boolean getPreventNamespace() {
        return this.preventNamespace;
    }

    public final void setPreventNamespace(boolean r100) {
        this.preventNamespace = r100;
    }
}
