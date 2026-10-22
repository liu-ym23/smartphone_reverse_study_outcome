package F2;

import android.database.Cursor;
import androidx.lifecycle.AbstractC0545z;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import com.stepos.minor.Minor;
import com.stepos.minor.WhitelistApp;
import com.stepos.minor.state.MinorStateEntity;
import d0.C0646a;
import d0.InterfaceC0650e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public abstract class e {
    public static z b(MinorStateEntity minorStateEntity) {
        if (minorStateEntity == null) {
            return z.INIT;
        }
        int length = z.values().length;
        int i5 = minorStateEntity.state;
        return (i5 < 0 || i5 >= length) ? z.INIT : z.values()[minorStateEntity.state];
    }

    public static MinorStateEntity c(z zVar) {
        return new MinorStateEntity(zVar.ordinal());
    }

    public abstract int A(Minor minor);

    public abstract int a(long j5);

    public abstract Minor d(long j5);

    public abstract Cursor e(long j5);

    public abstract AbstractC0545z<Minor> f(long j5);

    public abstract Minor g();

    public abstract Cursor h();

    public abstract AbstractC0545z<Minor> i();

    public Cursor j(String str, String[] strArr, String str2) {
        return k(null, str, strArr, str2);
    }

    public Cursor k(String[] strArr, String str, String[] strArr2, String str2) {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        if (strArr == null || strArr.length <= 0) {
            sb.append("SELECT * FROM ");
            sb.append(Minor.TABLE_NAME);
        } else {
            sb.append("SELECT ");
            for (int i5 = 0; i5 < strArr.length; i5++) {
                sb.append(strArr[i5]);
                if (i5 < strArr.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" FROM ");
            sb.append(Minor.TABLE_NAME);
        }
        if (str != null && !str.isEmpty()) {
            sb.append(" WHERE ");
            sb.append(str);
            if (strArr2 != null) {
                arrayList.addAll(Arrays.asList(strArr2));
            }
        }
        if (str2 != null && !str2.isEmpty()) {
            sb.append(" ORDER BY ");
            sb.append(str2);
        }
        return u(new C0646a(sb.toString(), arrayList.toArray(new Object[0])));
    }

    public abstract AbstractC0545z<List<Minor>> l();

    public abstract Minor m();

    public z n() {
        return b(o());
    }

    public abstract MinorStateEntity o();

    public x3.f<z> p() {
        return x3.f.x(new Callable() { // from class: F2.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f1649a.n();
            }
        });
    }

    public long q(Minor minor) {
        if (minor.isActivated() || minor.isSelected()) {
            y();
        }
        long jS = s(minor);
        for (String str : PackageUtils.f14710i) {
            WhitelistApp whitelistApp = new WhitelistApp(jS, str, false);
            ArrayList arrayList = new ArrayList();
            arrayList.add(whitelistApp);
            t(arrayList);
        }
        return jS;
    }

    public abstract void r(MinorStateEntity minorStateEntity);

    public abstract long s(Minor minor);

    public abstract void t(List<WhitelistApp> list);

    public abstract Cursor u(InterfaceC0650e interfaceC0650e);

    public abstract void v(long j5, int i5);

    public void w(z zVar) {
        r(c(zVar));
    }

    public abstract int x(boolean z5);

    public abstract void y();

    public int z(Minor minor) {
        if (minor.isSelected() || minor.isActivated()) {
            y();
        }
        return A(minor);
    }
}
