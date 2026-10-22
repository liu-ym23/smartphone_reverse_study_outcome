package androidx.datastore;

import S7.k;
import V7.b;
import android.content.Context;
import androidx.datastore.core.Serializer;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import u9.c;
import u9.d;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ay\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000e\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00052 \b\u0002\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\t0\u00072\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "fileName", "Landroidx/datastore/core/Serializer;", "serializer", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "corruptionHandler", "Lkotlin/Function1;", "Landroid/content/Context;", "", "Landroidx/datastore/core/DataMigration;", "produceMigrations", "Lm9/z;", "scope", "LV7/b;", "Landroidx/datastore/core/DataStore;", "dataStore", "(Ljava/lang/String;Landroidx/datastore/core/Serializer;Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;LS7/k;Lm9/z;)LV7/b;", "datastore_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class DataStoreDelegateKt {
    public static final <T> b dataStore(String fileName, Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, k produceMigrations, InterfaceC1733z scope) {
        kotlin.jvm.internal.k.f(fileName, "fileName");
        kotlin.jvm.internal.k.f(serializer, "serializer");
        kotlin.jvm.internal.k.f(produceMigrations, "produceMigrations");
        kotlin.jvm.internal.k.f(scope, "scope");
        return new DataStoreSingletonDelegate(fileName, serializer, replaceFileCorruptionHandler, produceMigrations, scope);
    }

    public static b dataStore$default(String str, Serializer serializer, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, k kVar, InterfaceC1733z interfaceC1733z, int i, Object obj) {
        if ((i & 4) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i & 8) != 0) {
            kVar = new k() { // from class: androidx.datastore.DataStoreDelegateKt.dataStore.1
                @Override // S7.k
                public final List invoke(Context it) {
                    kotlin.jvm.internal.k.f(it, "it");
                    return EmptyList.f4893a;
                }
            };
        }
        if ((i & 16) != 0) {
            d dVar = AbstractC1691I.f5315a;
            interfaceC1733z = AbstractC1683A.b(c.f6743a.plus(AbstractC1683A.c()));
        }
        return dataStore(str, serializer, replaceFileCorruptionHandler, kVar, interfaceC1733z);
    }
}
