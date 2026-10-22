package com.stepos.agentframework.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J1\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R'\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/stepos/agentframework/util/E;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "prefsName", "", "mode", "Landroid/content/SharedPreferences;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/content/Context;Ljava/lang/String;I)Landroid/content/SharedPreferences;", "key", "", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/content/Context;Ljava/lang/String;ZLjava/lang/String;)V", "defValue", Const.INTENT_KEY_UMID, "(Landroid/content/Context;Ljava/lang/String;ZLjava/lang/String;)Z", "DEFAULT_PREF_NAME", "Ljava/lang/String;", "", "prefsCache$delegate", "LY8/h;", "f", "()Ljava/util/Map;", "prefsCache", "Companion", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class E {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile E instance;
    private final String DEFAULT_PREF_NAME;

    /* renamed from: prefsCache$delegate, reason: from kotlin metadata */
    private final Y8.h prefsCache;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/agentframework/util/E$a;", "", "<init>", "()V", "Lcom/stepos/agentframework/util/E;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/util/E;", "instance", "Lcom/stepos/agentframework/util/E;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.util.E$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final E a() {
            E e10;
            E e11 = E.instance;
            if (e11 != null) {
                return e11;
            }
            synchronized (this) {
                e10 = E.instance;
                if (e10 == null) {
                    e10 = new E(null);
                    E.instance = e10;
                }
            }
            return e10;
        }

        public Companion() {
        }
    }

    public /* synthetic */ E(kotlin.jvm.internal.i iVar) {
        this();
    }

    public static /* synthetic */ boolean e(E e10, Context context, String str, boolean z10, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        if ((i10 & 8) != 0) {
            str2 = e10.DEFAULT_PREF_NAME;
        }
        return e10.d(context, str, z10, str2);
    }

    public static /* synthetic */ SharedPreferences h(E e10, Context context, String str, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = e10.DEFAULT_PREF_NAME;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return e10.g(context, str, i10);
    }

    public static final Map i() {
        return new LinkedHashMap();
    }

    public static /* synthetic */ void k(E e10, Context context, String str, boolean z10, String str2, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str2 = e10.DEFAULT_PREF_NAME;
        }
        e10.j(context, str, z10, str2);
    }

    public final boolean d(Context context, String key, boolean defValue, String prefsName) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(prefsName, "prefsName");
        return h(this, context, prefsName, 0, 4, null).getBoolean(key, defValue);
    }

    public final Map<String, SharedPreferences> f() {
        return (Map) this.prefsCache.getValue();
    }

    public final SharedPreferences g(Context context, String prefsName, int mode) {
        String str = prefsName + "|" + mode;
        Map<String, SharedPreferences> mapF = f();
        SharedPreferences sharedPreferences = mapF.get(str);
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(prefsName, mode);
            kotlin.jvm.internal.p.h(sharedPreferences, "getSharedPreferences(...)");
            mapF.put(str, sharedPreferences);
        }
        return sharedPreferences;
    }

    public final void j(Context context, String key, boolean value, String prefsName) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(prefsName, "prefsName");
        SharedPreferences.Editor editorEdit = h(this, context, prefsName, 0, 4, null).edit();
        kotlin.jvm.internal.p.f(editorEdit);
        editorEdit.putBoolean(key, value);
        editorEdit.apply();
    }

    public E() {
        this.DEFAULT_PREF_NAME = "default_pref_name";
        this.prefsCache = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.util.D
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return E.i();
            }
        });
    }
}
