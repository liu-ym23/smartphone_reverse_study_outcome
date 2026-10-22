package androidx.datastore.preferences.core;

import S7.a;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.m;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import u9.c;
import u9.d;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JU\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0014\b\u0002\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/datastore/preferences/core/PreferenceDataStoreFactory;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "Landroidx/datastore/preferences/core/Preferences;", "corruptionHandler", "", "Landroidx/datastore/core/DataMigration;", "migrations", "Lm9/z;", "scope", "Lkotlin/Function0;", "Ljava/io/File;", "produceFile", "Landroidx/datastore/core/DataStore;", "create", "(Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;Ljava/util/List;Lm9/z;LS7/a;)Landroidx/datastore/core/DataStore;", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class PreferenceDataStoreFactory {
    public static final PreferenceDataStoreFactory INSTANCE = new PreferenceDataStoreFactory();

    private PreferenceDataStoreFactory() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static DataStore create$default(PreferenceDataStoreFactory preferenceDataStoreFactory, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, InterfaceC1733z interfaceC1733z, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i & 2) != 0) {
            list = EmptyList.f4893a;
        }
        if ((i & 4) != 0) {
            d dVar = AbstractC1691I.f5315a;
            interfaceC1733z = AbstractC1683A.b(c.f6743a.plus(AbstractC1683A.c()));
        }
        return preferenceDataStoreFactory.create(replaceFileCorruptionHandler, list, interfaceC1733z, aVar);
    }

    public final DataStore<Preferences> create(a produceFile) {
        k.f(produceFile, "produceFile");
        return create$default(this, null, null, null, produceFile, 7, null);
    }

    public final DataStore<Preferences> create(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, a produceFile) {
        k.f(produceFile, "produceFile");
        return create$default(this, replaceFileCorruptionHandler, null, null, produceFile, 6, null);
    }

    public final DataStore<Preferences> create(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> migrations, a produceFile) {
        k.f(migrations, "migrations");
        k.f(produceFile, "produceFile");
        return create$default(this, replaceFileCorruptionHandler, migrations, null, produceFile, 4, null);
    }

    public final DataStore<Preferences> create(ReplaceFileCorruptionHandler<Preferences> corruptionHandler, List<? extends DataMigration<Preferences>> migrations, InterfaceC1733z scope, final a produceFile) {
        k.f(migrations, "migrations");
        k.f(scope, "scope");
        k.f(produceFile, "produceFile");
        return new PreferenceDataStore(DataStoreFactory.INSTANCE.create(PreferencesSerializer.INSTANCE, corruptionHandler, migrations, scope, new a() { // from class: androidx.datastore.preferences.core.PreferenceDataStoreFactory$create$delegate$1
            {
                super(0);
            }

            @Override // S7.a
            public final File invoke() {
                File file = (File) produceFile.invoke();
                k.f(file, "<this>");
                String name = file.getName();
                k.e(name, "getName(...)");
                String strI0 = m.I0('.', name, "");
                PreferencesSerializer preferencesSerializer = PreferencesSerializer.INSTANCE;
                if (strI0.equals(preferencesSerializer.getFileExtension())) {
                    return file;
                }
                throw new IllegalStateException(("File extension for file: " + file + " does not match required extension for Preferences file: " + preferencesSerializer.getFileExtension()).toString());
            }
        }));
    }
}
