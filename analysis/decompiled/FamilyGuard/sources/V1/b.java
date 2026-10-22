package V1;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.RemoteViews;
import com.stepos.digitalwellbeing.server.data.PackageUsingTimeStats;
import com.stepos.familyguard.R;
import f2.C0702g;
import f2.C0711p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.libpag.BuildConfig;
import w2.C1216d;

/* loaded from: classes.dex */
public class b extends h<List<C1216d>> {

    /* renamed from: a, reason: collision with root package name */
    private final List<WeakReference<Bitmap>> f5480a = new ArrayList();

    @Override // V1.h
    protected int b() {
        return 4;
    }

    @Override // V1.h
    protected int d(int i5, int i6) {
        if (i5 == 2) {
            if (i6 == 0) {
                return R.id.app_1_usage;
            }
            if (i6 == 1) {
                return R.id.app_2_usage;
            }
            if (i6 == 2) {
                return R.id.app_3_usage;
            }
            if (i6 == 3) {
                return R.id.app_4_usage;
            }
            C0702g.O("AppUpdater", "not found return default 0");
            return R.id.app_1_usage;
        }
        if (i5 == 0) {
            if (i6 == 0) {
                return R.id.app_1_icon;
            }
            if (i6 == 1) {
                return R.id.app_2_icon;
            }
            if (i6 == 2) {
                return R.id.app_3_icon;
            }
            if (i6 == 3) {
                return R.id.app_4_icon;
            }
            C0702g.O("AppUpdater", "not found return default 0");
            return R.id.app_1_icon;
        }
        if (i5 != 1) {
            return 0;
        }
        if (i6 == 0) {
            return R.id.app_1_name;
        }
        if (i6 == 1) {
            return R.id.app_2_name;
        }
        if (i6 == 2) {
            return R.id.app_3_name;
        }
        if (i6 == 3) {
            return R.id.app_4_name;
        }
        C0702g.O("AppUpdater", "not found return default 0");
        return R.id.app_1_name;
    }

    protected Bitmap m(Context context, List<C1216d> list, int i5) throws Resources.NotFoundException, PackageManager.NameNotFoundException {
        C1216d c1216d;
        WeakReference<Bitmap> weakReference;
        Bitmap bitmap;
        if (i5 < this.f5480a.size() && (weakReference = this.f5480a.get(i5)) != null && (bitmap = weakReference.get()) != null) {
            bitmap.recycle();
        }
        Drawable applicationIcon = null;
        if (list == null || list.size() <= i5 || (c1216d = list.get(i5)) == null || context == null) {
            return null;
        }
        try {
            applicationIcon = context.getPackageManager().getApplicationIcon(c1216d.f());
        } catch (PackageManager.NameNotFoundException e6) {
            C0702g.b("AppUpdater", Log.getStackTraceString(e6));
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.us_4x2_widget_app_icon_size);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.us_4x2_widget_app_icon_size);
        Bitmap bitmapD = C2.h.d(applicationIcon);
        if (bitmapD != null && bitmapD.getAllocationByteCount() > 130000) {
            C0702g.O("AppUpdater", "packageName = " + c1216d.f() + " bitmap size = " + bitmapD.getAllocationByteCount());
        }
        if (bitmapD == null) {
            bitmapD = C2.h.d(androidx.core.content.res.h.f(context.getResources(), R.drawable.us_app_icon_default_icon, context.getTheme()));
        }
        Bitmap bitmapG = C2.h.g(bitmapD, dimensionPixelSize, dimensionPixelSize2);
        Bitmap bitmapA = C2.h.a(context, bitmapG, T1.h.a(context, R.attr.colorOutlineVariant), (int) context.getResources().getDimension(R.dimen.us_outline_stroke_width));
        if (bitmapD != null) {
            bitmapD.recycle();
        }
        bitmapG.recycle();
        this.f5480a.add(i5, new WeakReference<>(bitmapA));
        return bitmapA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // V1.h
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public String a(Context context, List<C1216d> list, int i5) {
        C1216d c1216d;
        return (list == null || list.size() <= i5 || (c1216d = list.get(i5)) == null || context == null) ? BuildConfig.FLAVOR : c1216d.a();
    }

    protected long o(Context context, List<C1216d> list, int i5) {
        C1216d c1216d;
        PackageUsingTimeStats packageUsingTimeStatsA;
        if (list == null || list.size() <= i5 || (c1216d = list.get(i5)) == null || (packageUsingTimeStatsA = c1216d.A()) == null) {
            return 0L;
        }
        return packageUsingTimeStatsA.getUsingTime();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // V1.h
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public String c(Context context, List<C1216d> list, int i5) {
        return C0711p.o(context, o(context, list, i5), false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // V1.h
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void h(Context context, RemoteViews remoteViews, List<C1216d> list) {
        int iB = b();
        for (int i5 = 0; i5 < iB; i5++) {
            e(context, remoteViews, m(context, list, i5), d(0, i5));
        }
    }
}
