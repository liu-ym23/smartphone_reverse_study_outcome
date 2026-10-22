package V1;

import android.content.Context;
import android.widget.RemoteViews;
import com.stepos.familyguard.R;
import f2.C0702g;
import f2.C0711p;
import java.util.List;
import org.libpag.BuildConfig;
import w2.C1257w;

/* loaded from: classes.dex */
public class k extends h<List<C1257w>> {
    @Override // V1.h
    protected int b() {
        return 3;
    }

    @Override // V1.h
    protected int d(int i5, int i6) {
        if (i5 == 2) {
            if (i6 == 0) {
                return R.id.category_1_usage_time;
            }
            if (i6 == 1) {
                return R.id.category_2_usage_time;
            }
            if (i6 == 2) {
                return R.id.category_3_usage_time;
            }
            C0702g.O("CategoryUpdater", "not found return default 0");
            return R.id.category_1_usage_time;
        }
        if (i5 == 0) {
            if (i6 == 0) {
                return R.id.category_1_icon;
            }
            if (i6 == 1) {
                return R.id.category_2_icon;
            }
            if (i6 == 2) {
                return R.id.category_3_icon;
            }
            C0702g.O("CategoryUpdater", "not found return default 0");
            return R.id.category_1_usage_time;
        }
        if (i5 != 1) {
            return 0;
        }
        if (i6 == 0) {
            return R.id.category_1_name;
        }
        if (i6 == 1) {
            return R.id.category_2_name;
        }
        if (i6 == 2) {
            return R.id.category_3_name;
        }
        C0702g.O("CategoryUpdater", "not found return default 0");
        return R.id.category_1_name;
    }

    protected int m(Context context, List<C1257w> list, int i5) {
        C1257w c1257w;
        if (list == null || list.size() <= i5 || (c1257w = list.get(i5)) == null || context == null) {
            return -1;
        }
        return W1.c.l(c1257w.a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // V1.h
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public String a(Context context, List<C1257w> list, int i5) {
        C1257w c1257w;
        return (list == null || list.size() <= i5 || (c1257w = list.get(i5)) == null || context == null) ? BuildConfig.FLAVOR : context.getString(W1.c.m(c1257w.a()));
    }

    protected long o(Context context, List<C1257w> list, int i5) {
        C1257w c1257w;
        if (list == null || list.size() <= i5 || (c1257w = list.get(i5)) == null || context == null) {
            return 0L;
        }
        return c1257w.f().getUsingTime();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // V1.h
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public String c(Context context, List<C1257w> list, int i5) {
        return C0711p.o(context, o(context, list, i5), false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // V1.h
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void h(Context context, RemoteViews remoteViews, List<C1257w> list) {
        int iB = b();
        for (int i5 = 0; i5 < iB; i5++) {
            g(context, remoteViews, m(context, list, i5), d(0, i5));
        }
    }
}
