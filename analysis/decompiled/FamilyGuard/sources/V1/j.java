package V1;

import android.content.Context;
import android.widget.RemoteViews;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.usage.U;
import f2.C0702g;
import f2.C0711p;
import java.util.List;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class j extends h<List<U.a>> {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // V1.h
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public String a(Context context, List<U.a> list, int i5) {
        U.a aVar;
        return (list == null || list.size() <= i5 || (aVar = list.get(i5)) == null || context == null) ? BuildConfig.FLAVOR : context.getString(W1.c.m(aVar.f15161a));
    }

    protected long n(Context context, List<U.a> list, int i5) {
        U.a aVar;
        if (list == null || list.size() <= i5 || (aVar = list.get(i5)) == null) {
            return 0L;
        }
        return aVar.f14930e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // V1.h
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public String c(Context context, List<U.a> list, int i5) {
        return context == null ? BuildConfig.FLAVOR : C0711p.o(context, n(context, list, i5), false, false);
    }

    public void p(Context context, RemoteViews remoteViews, List<U.a> list) {
        super.f(context, remoteViews, list);
        int iB = b();
        for (int i5 = 0; i5 < iB; i5++) {
            if (n(context, list, i5) == 0) {
                remoteViews.setViewVisibility(d(2, i5), 4);
                remoteViews.setViewVisibility(d(1, i5), 4);
                remoteViews.setViewVisibility(d(0, i5), 4);
            } else {
                remoteViews.setViewVisibility(d(2, i5), 0);
                remoteViews.setViewVisibility(d(1, i5), 0);
                remoteViews.setViewVisibility(d(0, i5), 0);
            }
        }
        super.f(context, remoteViews, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // V1.h
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void h(Context context, RemoteViews remoteViews, List<U.a> list) {
    }
}
