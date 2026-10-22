package V1;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.stepos.familyguard.R;

/* loaded from: classes.dex */
public abstract class h<T> {
    protected abstract String a(Context context, T t5, int i5);

    protected abstract int b();

    protected abstract String c(Context context, T t5, int i5);

    protected abstract int d(int i5, int i6);

    protected void e(Context context, RemoteViews remoteViews, Bitmap bitmap, int i5) {
        if (remoteViews == null || bitmap == null) {
            return;
        }
        remoteViews.setImageViewBitmap(i5, bitmap);
    }

    public void f(Context context, RemoteViews remoteViews, T t5) {
        l(context, remoteViews, t5);
        h(context, remoteViews, t5);
        j(context, remoteViews, t5);
    }

    protected void g(Context context, RemoteViews remoteViews, int i5, int i6) {
        if (remoteViews == null) {
            return;
        }
        if (i5 <= 0) {
            remoteViews.setImageViewBitmap(i6, null);
        } else {
            remoteViews.setImageViewResource(i6, i5);
        }
    }

    protected abstract void h(Context context, RemoteViews remoteViews, T t5);

    protected void i(Context context, RemoteViews remoteViews, String str, int i5) {
        if (remoteViews == null) {
            return;
        }
        remoteViews.setInt(i5, "setBackgroundResource", R.color.transparent);
        remoteViews.setTextViewText(i5, str);
    }

    protected void j(Context context, RemoteViews remoteViews, T t5) {
        int iB = b();
        for (int i5 = 0; i5 < iB; i5++) {
            i(context, remoteViews, a(context, t5, i5), d(1, i5));
        }
    }

    protected void k(Context context, RemoteViews remoteViews, String str, int i5) {
        if (remoteViews == null) {
            return;
        }
        remoteViews.setInt(i5, "setBackgroundResource", R.color.transparent);
        remoteViews.setTextViewText(i5, str);
    }

    protected void l(Context context, RemoteViews remoteViews, T t5) {
        int iB = b();
        for (int i5 = 0; i5 < iB; i5++) {
            k(context, remoteViews, c(context, t5, i5), d(2, i5));
        }
    }
}
