package androidx.datastore.preferences;

import S7.k;
import V7.b;
import android.content.Context;
import androidx.autofill.HintConstants;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.core.Preferences;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import u9.c;
import u9.d;

@Metadata(d1 = {"\u00004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ae\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\r0\f2\u0006\u0010\u0001\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022 \b\u0002\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u00070\u00052\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"", HintConstants.AUTOFILL_HINT_NAME, "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "Landroidx/datastore/preferences/core/Preferences;", "corruptionHandler", "Lkotlin/Function1;", "Landroid/content/Context;", "", "Landroidx/datastore/core/DataMigration;", "produceMigrations", "Lm9/z;", "scope", "LV7/b;", "Landroidx/datastore/core/DataStore;", "preferencesDataStore", "(Ljava/lang/String;Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;LS7/k;Lm9/z;)LV7/b;", "datastore-preferences_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class PreferenceDataStoreDelegateKt {
    public static final b preferencesDataStore(String name, ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, k produceMigrations, InterfaceC1733z scope) {
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(produceMigrations, "produceMigrations");
        kotlin.jvm.internal.k.f(scope, "scope");
        return new PreferenceDataStoreSingletonDelegate(name, replaceFileCorruptionHandler, produceMigrations, scope);
    }

    public static b preferencesDataStore$default(String str, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, k kVar, InterfaceC1733z interfaceC1733z, int i, Object obj) {
        if ((i & 2) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i & 4) != 0) {
            kVar = new k() { // from class: androidx.datastore.preferences.PreferenceDataStoreDelegateKt.preferencesDataStore.1
                @Override // S7.k
                public final List<DataMigration<Preferences>> invoke(Context it) {
                    kotlin.jvm.internal.k.f(it, "it");
                    return EmptyList.f4893a;
                }
            };
        }
        if ((i & 8) != 0) {
            d dVar = AbstractC1691I.f5315a;
            interfaceC1733z = AbstractC1683A.b(c.f6743a.plus(AbstractC1683A.c()));
        }
        return preferencesDataStore(str, replaceFileCorruptionHandler, kVar, interfaceC1733z);
    }
}
