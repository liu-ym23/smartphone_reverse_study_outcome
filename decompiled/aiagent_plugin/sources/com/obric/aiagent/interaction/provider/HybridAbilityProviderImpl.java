package com.obric.aiagent.interaction.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.h;
import d.h.b.o;
import d.n;
import d.s;
import java.util.Map;

/* JADX INFO: compiled from: HybridAbilityProviderImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class HybridAbilityProviderImpl extends PluginContentProvider {
    public static final a Companion = null;
    private static final String TAG = "HybridAbilityProviderImpl";
    private final Map<String, com.obric.aiagent.interaction.provider.a.a> abilities;

    /* JADX INFO: compiled from: HybridAbilityProviderImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public int delete(Uri r1, String r2, String[] r3) {
        o.e(r1, "uri");
        return 0;
    }

    public String getType(Uri r1) {
        o.e(r1, "uri");
        return null;
    }

    public Uri insert(Uri r1, ContentValues r2) {
        o.e(r1, "uri");
        return null;
    }

    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        o.e(r1, "uri");
        return null;
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        o.e(r1, "uri");
        return 0;
    }

    public HybridAbilityProviderImpl() {
        this.abilities = ao.a(s.a("show_screen_shot_effect", new com.obric.aiagent.interaction.provider.a.a()));
    }

    public boolean onCreate() {
        ILogDepend.Companion.i(TAG, "onCreate: HybridAbilityProviderImpl");
        return true;
    }

    public Bundle call(String r6, String r7, Bundle r8) {
        o.e(r6, "method");
        ILogDepend.Companion.i(TAG, "call: method = " + r6);
        com.obric.aiagent.interaction.provider.a.a r1 = (com.obric.aiagent.interaction.provider.a.a) ZeusTransformUtils.preCheckCast(this.abilities.get(r6), com.obric.aiagent.interaction.provider.a.a.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L18;
        HybridAbilityProviderImpl r0 = (HybridAbilityProviderImpl) ZeusTransformUtils.preCheckCast(this, HybridAbilityProviderImpl.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "not support " + r6);
        return super.call(r6, r7, r8);
    L18:
        n.a r2 = n.f38560a;     // Catch: Throwable -> L6
        HybridAbilityProviderImpl r5 = (HybridAbilityProviderImpl) ZeusTransformUtils.preCheckCast(this, HybridAbilityProviderImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        Object r9 = n.f(r1.call(r7, r8));     // Catch: Throwable -> L6
    L8:
        Throwable r10 = n.c(r9);
        if (r10 == null) goto L12;
        ILogDepend.Companion.w(TAG, "failed: " + r6 + ", error = " + r10.getMessage(), r10);
    L12:
        if (n.b(r9) == false) goto L15;
        r9 = null;
    L15:
        return (Bundle) ZeusTransformUtils.preCheckCast(r9, Bundle.class, "com.obric.aiagent.plugin");
    L6:
        th = move-exception;
        n.a r11 = n.f38560a;
        r9 = n.f(d.o.a(th));
        goto L8
    }
}
