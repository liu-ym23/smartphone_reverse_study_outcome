package androidx.datastore.preferences;

import android.content.Context;
import androidx.datastore.preferences.core.PreferenceDataStore;
import ec.f;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CoroutineScope;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final l<Context, List<d1.b<g1.a>>> f1702a;

    /* renamed from: b, reason: collision with root package name */
    public final CoroutineScope f1703b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f1704c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public volatile PreferenceDataStore f1705d;

    public b(l lVar, CoroutineScope coroutineScope) {
        this.f1702a = lVar;
        this.f1703b = coroutineScope;
    }

    public final PreferenceDataStore a(Context thisRef, f property) {
        PreferenceDataStore preferenceDataStore;
        g.f(thisRef, "thisRef");
        g.f(property, "property");
        PreferenceDataStore preferenceDataStore2 = this.f1705d;
        if (preferenceDataStore2 != null) {
            return preferenceDataStore2;
        }
        synchronized (this.f1704c) {
            try {
                if (this.f1705d == null) {
                    final Context applicationContext = thisRef.getApplicationContext();
                    l<Context, List<d1.b<g1.a>>> lVar = this.f1702a;
                    g.e(applicationContext, "applicationContext");
                    this.f1705d = androidx.datastore.preferences.core.a.a(lVar.invoke(applicationContext), this.f1703b, new zb.a<File>(applicationContext, this) { // from class: androidx.datastore.preferences.PreferenceDataStoreSingletonDelegate$getValue$1$1

                        /* renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ Context f1693a;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // zb.a
                        public final File invoke() {
                            String fileName = g.k(".preferences_pb", "policy_sdk_data");
                            g.f(fileName, "fileName");
                            return new File(this.f1693a.getApplicationContext().getFilesDir(), g.k(fileName, "datastore/"));
                        }
                    });
                }
                preferenceDataStore = this.f1705d;
                g.c(preferenceDataStore);
            } catch (Throwable th) {
                throw th;
            }
        }
        return preferenceDataStore;
    }
}
