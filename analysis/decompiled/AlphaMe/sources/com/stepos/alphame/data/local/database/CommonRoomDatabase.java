package com.stepos.alphame.data.local.database;

import android.content.Context;
import androidx.room.A;
import androidx.room.Database;
import androidx.room.TypeConverters;
import androidx.room.w;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.common.CommonContractKt;
import com.stepos.alphame.data.local.database.dailyusage.DailyUsageConverter;
import com.stepos.alphame.data.local.database.dailyusage.DailyUsageDao;
import com.stepos.alphame.data.model.dailyusage.DailyUsageEntity;
import f1.AbstractC0557a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@TypeConverters({DailyUsageConverter.class})
@Database(entities = {DailyUsageEntity.class}, exportSchema = true, version = 2)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/stepos/alphame/data/local/database/CommonRoomDatabase;", "Landroidx/room/A;", "Lcom/stepos/alphame/data/local/database/dailyusage/DailyUsageDao;", "getDailyUsageDao", "()Lcom/stepos/alphame/data/local/database/dailyusage/DailyUsageDao;", "<init>", "()V", "Companion", "data_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public abstract class CommonRoomDatabase extends A {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static volatile CommonRoomDatabase INSTANCE = null;

    @NotNull
    private static final String TAG = "CommonRoomDatabase";

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stepos/alphame/data/local/database/CommonRoomDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/stepos/alphame/data/local/database/CommonRoomDatabase;", "TAG", "", CommonContractKt.METHOD_NAME_GET_INSTANCE, CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CommonRoomDatabase getInstance(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            CommonRoomDatabase commonRoomDatabase = CommonRoomDatabase.INSTANCE;
            if (commonRoomDatabase == null) {
                synchronized (this) {
                    Context applicationContext = context.getApplicationContext();
                    Intrinsics.checkNotNull(applicationContext);
                    w wVarQ = AbstractC0557a.q(applicationContext, CommonRoomDatabase.class, "common_database");
                    wVarQ.a(new Migration1To2(applicationContext));
                    commonRoomDatabase = (CommonRoomDatabase) wVarQ.b();
                    CommonRoomDatabase.INSTANCE = commonRoomDatabase;
                }
            }
            return commonRoomDatabase;
        }
    }

    @NotNull
    public abstract DailyUsageDao getDailyUsageDao();
}
