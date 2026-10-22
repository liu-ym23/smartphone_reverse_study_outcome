package F2;

import android.database.Cursor;
import androidx.lifecycle.AbstractC0545z;
import com.stepos.minor.WhitelistApp;
import java.util.List;

/* loaded from: classes.dex */
public abstract class A {
    public abstract int a(long j5);

    protected abstract int b(long j5, String str);

    public abstract WhitelistApp c(long j5, String str);

    public abstract Cursor d(long j5);

    public abstract List<WhitelistApp> e(long j5);

    public abstract x3.f<List<WhitelistApp>> f(long j5);

    public abstract AbstractC0545z<List<WhitelistApp>> g(long j5);

    public abstract void h(WhitelistApp whitelistApp);

    public int i(long j5, String str) {
        WhitelistApp whitelistAppC = c(j5, str);
        if (whitelistAppC == null || !whitelistAppC.isRemovable()) {
            return 0;
        }
        return b(j5, str);
    }
}
