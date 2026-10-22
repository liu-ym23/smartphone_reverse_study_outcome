package com.stepos.ailauncher.taskstore.livenotification;

import android.content.Context;
import android.content.SharedPreferences;
import com.autonavi.aps.amapapi.config.Const;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/y;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "", "sessionId", "label", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)V", "", "c", "()Ljava/util/Map;", "PREFS_NAME", "Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/content/SharedPreferences;", "prefs", "Landroid/content/SharedPreferences;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class y {
    private static final String PREFS_NAME = "taskstore_session_summary";
    private static volatile SharedPreferences prefs;
    public static final y INSTANCE = new y();
    private static final ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();

    public final void a(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        if (prefs != null) {
            return;
        }
        synchronized (this) {
            try {
                if (prefs != null) {
                    return;
                }
                SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
                prefs = sharedPreferences;
                Map<String, ?> all = sharedPreferences.getAll();
                kotlin.jvm.internal.p.h(all, "getAll(...)");
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    String str = value instanceof String ? (String) value : null;
                    if (key != null && !La.H.x0(key) && str != null && !La.H.x0(str)) {
                        cache.putIfAbsent(key, str);
                    }
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(String sessionId, String label) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutString;
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(label, "label");
        if (La.H.x0(sessionId) || La.H.x0(label)) {
            return;
        }
        cache.put(sessionId, label);
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null || (editorPutString = editorEdit.putString(sessionId, label)) == null) {
            return;
        }
        editorPutString.apply();
    }

    public final Map<String, String> c() {
        return new HashMap(cache);
    }
}
