package androidx.room;

import android.view.AbstractC1404w;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R$\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Landroidx/room/g;", "", "Landroidx/room/RoomDatabase;", "database", "<init>", "(Landroidx/room/RoomDatabase;)V", Const.INTENT_KEY_APIKEY, "Landroidx/room/RoomDatabase;", "", "Landroidx/lifecycle/w;", Const.INTENT_KEY_PKGNAME, "Ljava/util/Set;", "getLiveDataSet$room_runtime", "()Ljava/util/Set;", "liveDataSet", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final RoomDatabase database;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Set<AbstractC1404w<?>> liveDataSet;

    public g(RoomDatabase database) {
        kotlin.jvm.internal.p.i(database, "database");
        this.database = database;
        Set<AbstractC1404w<?>> setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        kotlin.jvm.internal.p.h(setNewSetFromMap, "newSetFromMap(...)");
        this.liveDataSet = setNewSetFromMap;
    }
}
