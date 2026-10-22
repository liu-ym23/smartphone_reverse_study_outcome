package w2;

import android.content.Context;
import androidx.lifecycle.AbstractC0545z;
import com.stepos.digitalwellbeing.server.data.Category;
import com.stepos.digitalwellbeing.server.data.CategoryLimitInfo;
import com.stepos.digitalwellbeing.server.data.CategoryUsingTimeStats;
import com.stepos.digitalwellbeing.server.data.DataToken;
import com.stepos.digitalwellbeing.server.data.NotificationTimesStats;
import com.stepos.digitalwellbeing.server.data.PackageLimitInfo;
import com.stepos.digitalwellbeing.server.data.PackageNotificationTimesStats;
import com.stepos.digitalwellbeing.server.data.PackageUsingTimeStats;
import com.stepos.digitalwellbeing.server.data.PickupTimesStats;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.digitalwellbeing.server.data.UsingTimeStats;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import java.util.List;
import v2.AbstractC1182a;

/* loaded from: classes.dex */
public abstract class q1 extends AbstractC1182a implements U0 {

    /* renamed from: b, reason: collision with root package name */
    protected androidx.lifecycle.B<DataToken> f23642b;

    /* renamed from: c, reason: collision with root package name */
    protected androidx.lifecycle.B<UsingTimeStats[]> f23643c;

    /* renamed from: d, reason: collision with root package name */
    protected androidx.lifecycle.B<NotificationTimesStats[]> f23644d;

    /* renamed from: e, reason: collision with root package name */
    protected androidx.lifecycle.B<PickupTimesStats[]> f23645e;

    /* renamed from: f, reason: collision with root package name */
    protected androidx.lifecycle.B<PackageUsingTimeStats[]> f23646f;

    /* renamed from: g, reason: collision with root package name */
    protected androidx.lifecycle.B<PackageNotificationTimesStats[]> f23647g;

    /* renamed from: h, reason: collision with root package name */
    protected androidx.lifecycle.B<CategoryUsingTimeStats[]> f23648h;

    /* renamed from: i, reason: collision with root package name */
    protected androidx.lifecycle.B<StatsDataSet[]> f23649i;

    /* renamed from: j, reason: collision with root package name */
    protected androidx.lifecycle.B<PackageLimitInfo[]> f23650j;

    /* renamed from: k, reason: collision with root package name */
    protected androidx.lifecycle.B<CategoryLimitInfo[]> f23651k;

    /* renamed from: l, reason: collision with root package name */
    protected androidx.lifecycle.B<List<PackageUtils.AppInfo>> f23652l;

    /* renamed from: m, reason: collision with root package name */
    protected androidx.lifecycle.B<List<Category>> f23653m;

    /* renamed from: n, reason: collision with root package name */
    protected androidx.lifecycle.B<List<C1216d>> f23654n;

    /* renamed from: o, reason: collision with root package name */
    protected androidx.lifecycle.B<List<C1257w>> f23655o;

    public q1(v2.e eVar) {
        super(eVar);
        this.f23642b = new androidx.lifecycle.B<>();
        this.f23643c = new androidx.lifecycle.B<>();
        this.f23644d = new androidx.lifecycle.B<>();
        this.f23645e = new androidx.lifecycle.B<>();
        this.f23646f = new androidx.lifecycle.B<>();
        this.f23647g = new androidx.lifecycle.B<>();
        this.f23648h = new androidx.lifecycle.B<>();
        this.f23649i = new androidx.lifecycle.B<>();
        this.f23650j = new androidx.lifecycle.B<>();
        this.f23651k = new androidx.lifecycle.B<>();
        this.f23652l = new androidx.lifecycle.B<>();
        this.f23653m = new androidx.lifecycle.B<>();
        this.f23654n = new androidx.lifecycle.B<>();
        this.f23655o = new androidx.lifecycle.B<>();
    }

    public AbstractC0545z<List<C1216d>> J(Context context) {
        return this.f23654n;
    }

    public AbstractC0545z<List<C1257w>> K(Context context) {
        return this.f23655o;
    }

    public AbstractC0545z<NotificationTimesStats[]> L() {
        return this.f23644d;
    }

    public AbstractC0545z<PackageNotificationTimesStats[]> M() {
        return this.f23647g;
    }

    public AbstractC0545z<PickupTimesStats[]> N() {
        return this.f23645e;
    }

    public AbstractC0545z<DataToken> O() {
        return this.f23642b;
    }

    public AbstractC0545z<UsingTimeStats[]> P() {
        return this.f23643c;
    }
}
