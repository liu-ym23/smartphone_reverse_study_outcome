package com.stepos.alphame.database;

import android.content.Context;
import android.util.Log;
import androidx.room.A;
import androidx.room.TypeConverters;
import androidx.room.w;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.location.FrequentLocation;
import com.stepos.alphame.location.repo.FrequentLocationDao;
import com.stepos.alphame.location.repo.LocationConverters;
import com.stepos.alphame.persona.address.data.AddressEntity;
import com.stepos.alphame.persona.address.data.HistoryAddressDao;
import f1.AbstractC0557a;
import h0.AbstractC0587a;
import k0.InterfaceC0674b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t0.s;

@TypeConverters({LocationConverters.class})
@androidx.room.Database(entities = {FrequentLocation.class, AddressEntity.class}, exportSchema = false, version = 2)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/stepos/alphame/database/EngineRoomDatabase;", "Landroidx/room/A;", "Lcom/stepos/alphame/location/repo/FrequentLocationDao;", "getFrequentLocationDao", "()Lcom/stepos/alphame/location/repo/FrequentLocationDao;", "Lcom/stepos/alphame/persona/address/data/HistoryAddressDao;", "getHistoryAddressDao", "()Lcom/stepos/alphame/persona/address/data/HistoryAddressDao;", "<init>", "()V", "Companion", "app_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public abstract class EngineRoomDatabase extends A {

    @Nullable
    private static volatile EngineRoomDatabase INSTANCE = null;

    @NotNull
    public static final String TAG = "FrequentLocationDatabase";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final AbstractC0587a MIGRATION_1_2 = new s(new Function1<InterfaceC0674b, Unit>() { // from class: com.stepos.alphame.database.EngineRoomDatabase$Companion$MIGRATION_1_2$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull InterfaceC0674b it) {
            Intrinsics.checkNotNullParameter(it, "it");
            it.execSQL("CREATE TABLE IF NOT EXISTS 'history_address' (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 'address_name' TEXT NOT NULL, 'district' TEXT NOT NULL, 'longitude' REAL NOT NULL, 'latitude' REAL NOT NULL, 'update_time' INTEGER NOT NULL)");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InterfaceC0674b interfaceC0674b) {
            invoke2(interfaceC0674b);
            return Unit.INSTANCE;
        }
    });

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/stepos/alphame/database/EngineRoomDatabase$Companion;", "", "Landroid/content/Context;", CoreConstants.CONTEXT_SCOPE_VALUE, "Lcom/stepos/alphame/database/EngineRoomDatabase;", "getDatabase", "(Landroid/content/Context;)Lcom/stepos/alphame/database/EngineRoomDatabase;", "INSTANCE", "Lcom/stepos/alphame/database/EngineRoomDatabase;", "Lh0/a;", "MIGRATION_1_2", "Lh0/a;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "app_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final EngineRoomDatabase getDatabase(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            EngineRoomDatabase engineRoomDatabase = EngineRoomDatabase.INSTANCE;
            if (engineRoomDatabase == null) {
                synchronized (this) {
                    Log.i(EngineRoomDatabase.TAG, "engine db created");
                    Context applicationContext = context.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                    w wVarQ = AbstractC0557a.q(applicationContext, EngineRoomDatabase.class, "engine");
                    wVarQ.a(EngineRoomDatabase.MIGRATION_1_2);
                    engineRoomDatabase = (EngineRoomDatabase) wVarQ.b();
                    EngineRoomDatabase.INSTANCE = engineRoomDatabase;
                }
            }
            return engineRoomDatabase;
        }
    }

    @NotNull
    public abstract FrequentLocationDao getFrequentLocationDao();

    @NotNull
    public abstract HistoryAddressDao getHistoryAddressDao();
}
