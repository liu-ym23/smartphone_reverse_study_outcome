package J0;

import Ua.M;
import Z8.C1172u;
import androidx.datastore.core.DataMigrationInitializer;
import androidx.datastore.core.SingleProcessDataStore;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Ji\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00072\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\t2\b\b\u0002\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"LJ0/e;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "LJ0/i;", "serializer", "LK0/b;", "corruptionHandler", "", "LJ0/c;", "migrations", "LUa/M;", "scope", "Lkotlin/Function0;", "Ljava/io/File;", "produceFile", "LJ0/d;", Const.INTENT_KEY_APIKEY, "(LJ0/i;LK0/b;Ljava/util/List;LUa/M;Lp9/a;)LJ0/d;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f3690a = new e();

    public final <T> d<T> a(i<T> serializer, K0.b<T> corruptionHandler, List<? extends c<T>> migrations, M scope, InterfaceC5063a<? extends File> produceFile) {
        p.i(serializer, "serializer");
        p.i(migrations, "migrations");
        p.i(scope, "scope");
        p.i(produceFile, "produceFile");
        return new SingleProcessDataStore(produceFile, serializer, C1172u.e(DataMigrationInitializer.INSTANCE.b(migrations)), new K0.a(), scope);
    }
}
