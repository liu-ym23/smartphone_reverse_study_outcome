package c1;

import androidx.room.coroutines.ConnectionPool;
import androidx.room.coroutines.ConnectionPoolImpl;
import com.autonavi.aps.amapapi.config.Const;
import i1.InterfaceC4161c;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a9\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Li1/c;", "driver", "", "fileName", "", "preparedStatementCacheSize", "Landroidx/room/coroutines/ConnectionPool;", Const.INTENT_KEY_PKGNAME, "(Li1/c;Ljava/lang/String;I)Landroidx/room/coroutines/ConnectionPool;", "maxNumOfReaders", "maxNumOfWriters", Const.INTENT_KEY_APIKEY, "(Li1/c;Ljava/lang/String;III)Landroidx/room/coroutines/ConnectionPool;", "room-runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class g {
    public static final ConnectionPool a(InterfaceC4161c driver, String fileName, int i10, int i11, int i12) {
        p.i(driver, "driver");
        p.i(fileName, "fileName");
        return new ConnectionPoolImpl(driver, fileName, i10, i11, i12);
    }

    public static final ConnectionPool b(InterfaceC4161c driver, String fileName, int i10) {
        p.i(driver, "driver");
        p.i(fileName, "fileName");
        return new ConnectionPoolImpl(driver, fileName, i10);
    }
}
