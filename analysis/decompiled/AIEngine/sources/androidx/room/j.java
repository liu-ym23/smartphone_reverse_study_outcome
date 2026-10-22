package androidx.room;

import android.content.Context;
import androidx.room.RoomDatabase;
import gc.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j {
    public static final <T extends RoomDatabase> RoomDatabase.a<T> a(Context context, Class<T> cls, String str) {
        kotlin.jvm.internal.g.f(context, "context");
        if (str == null || q.t0(str)) {
            throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }
        return new RoomDatabase.a<>(context, cls, str);
    }
}
