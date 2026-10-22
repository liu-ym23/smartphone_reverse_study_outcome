package androidx.datastore;

import S7.a;
import S7.k;
import V7.b;
import Z7.t;
import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.Serializer;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0002BW\b\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t\u0012\u001e\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\f0\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0013\u001a\u00020\u00032\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0018R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0019R\u001c\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001aR,\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001bR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Landroidx/datastore/DataStoreSingletonDelegate;", ExifInterface.GPS_DIRECTION_TRUE, "LV7/b;", "Landroid/content/Context;", "Landroidx/datastore/core/DataStore;", "", "fileName", "Landroidx/datastore/core/Serializer;", "serializer", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "corruptionHandler", "Lkotlin/Function1;", "", "Landroidx/datastore/core/DataMigration;", "produceMigrations", "Lm9/z;", "scope", AppAgent.CONSTRUCT, "(Ljava/lang/String;Landroidx/datastore/core/Serializer;Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;LS7/k;Lm9/z;)V", "thisRef", "LZ7/t;", "property", "getValue", "(Landroid/content/Context;LZ7/t;)Landroidx/datastore/core/DataStore;", "Ljava/lang/String;", "Landroidx/datastore/core/Serializer;", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "LS7/k;", "Lm9/z;", "", "lock", "Ljava/lang/Object;", "INSTANCE", "Landroidx/datastore/core/DataStore;", "datastore_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class DataStoreSingletonDelegate<T> implements b {

    @GuardedBy("lock")
    private volatile DataStore<T> INSTANCE;
    private final ReplaceFileCorruptionHandler<T> corruptionHandler;
    private final String fileName;
    private final Object lock;
    private final k produceMigrations;
    private final InterfaceC1733z scope;
    private final Serializer<T> serializer;

    public DataStoreSingletonDelegate(String fileName, Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, k produceMigrations, InterfaceC1733z scope) {
        kotlin.jvm.internal.k.f(fileName, "fileName");
        kotlin.jvm.internal.k.f(serializer, "serializer");
        kotlin.jvm.internal.k.f(produceMigrations, "produceMigrations");
        kotlin.jvm.internal.k.f(scope, "scope");
        this.fileName = fileName;
        this.serializer = serializer;
        this.corruptionHandler = replaceFileCorruptionHandler;
        this.produceMigrations = produceMigrations;
        this.scope = scope;
        this.lock = new Object();
    }

    @Override // V7.b
    public DataStore<T> getValue(Context thisRef, t property) {
        DataStore<T> dataStore;
        kotlin.jvm.internal.k.f(thisRef, "thisRef");
        kotlin.jvm.internal.k.f(property, "property");
        DataStore<T> dataStore2 = this.INSTANCE;
        if (dataStore2 != null) {
            return dataStore2;
        }
        synchronized (this.lock) {
            try {
                if (this.INSTANCE == null) {
                    final Context applicationContext = thisRef.getApplicationContext();
                    Serializer<T> serializer = this.serializer;
                    ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler = this.corruptionHandler;
                    k kVar = this.produceMigrations;
                    kotlin.jvm.internal.k.e(applicationContext, "applicationContext");
                    this.INSTANCE = DataStoreFactory.INSTANCE.create(serializer, replaceFileCorruptionHandler, (List) kVar.invoke(applicationContext), this.scope, new a() { // from class: androidx.datastore.DataStoreSingletonDelegate$getValue$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // S7.a
                        public final File invoke() {
                            Context applicationContext2 = applicationContext;
                            kotlin.jvm.internal.k.e(applicationContext2, "applicationContext");
                            return DataStoreFile.dataStoreFile(applicationContext2, ((DataStoreSingletonDelegate) this).fileName);
                        }
                    });
                }
                dataStore = this.INSTANCE;
                kotlin.jvm.internal.k.c(dataStore);
            } catch (Throwable th) {
                throw th;
            }
        }
        return dataStore;
    }
}
