package androidx.datastore.preferences;

import android.content.Context;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {
    public static b a() {
        CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        PreferenceDataStoreDelegateKt$preferencesDataStore$1 produceMigrations = new l<Context, List<? extends d1.b<g1.a>>>() { // from class: androidx.datastore.preferences.PreferenceDataStoreDelegateKt$preferencesDataStore$1
            @Override // zb.l
            public final List<? extends d1.b<g1.a>> invoke(Context context) {
                Context it = context;
                g.f(it, "it");
                return EmptyList.f10001a;
            }
        };
        g.f(produceMigrations, "produceMigrations");
        g.f(scope, "scope");
        return new b(produceMigrations, scope);
    }
}
