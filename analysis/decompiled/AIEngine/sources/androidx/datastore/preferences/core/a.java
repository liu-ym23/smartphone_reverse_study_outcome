package androidx.datastore.preferences.core;

import androidx.datastore.core.b;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CoroutineScope;
import wb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {
    public static PreferenceDataStore a(List migrations, CoroutineScope coroutineScope, final zb.a aVar) {
        g.f(migrations, "migrations");
        return new PreferenceDataStore(b.a(migrations, coroutineScope, new zb.a<File>() { // from class: androidx.datastore.preferences.core.PreferenceDataStoreFactory$create$delegate$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // zb.a
            public final File invoke() {
                File fileInvoke = aVar.invoke();
                if (d.U(fileInvoke).equals("preferences_pb")) {
                    return fileInvoke;
                }
                throw new IllegalStateException(("File extension for file: " + fileInvoke + " does not match required extension for Preferences file: preferences_pb").toString());
            }
        }));
    }
}
