package bxc;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes41.dex */
public abstract class e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f21384a;

    public abstract void a(int r100, String... r101);

    public abstract boolean e(String r100);

    public abstract void f(String r100, String r101, String r102, int r103, int r104, String... r105);

    public abstract Context getContext();

    public e(T r100) {
        this.f21384a = r100;
    }

    public static e<? extends Activity> b(Activity r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        return new d(r100);
    L7:
        if ((r100 instanceof AppCompatActivity) == false) goto L11;
        return new b((AppCompatActivity) r100);
    L11:
        return new a(r100);
    }

    public static e<Fragment> c(Fragment r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        return new d(r100);
    L7:
        return new f(r100);
    }

    public final boolean d(String... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        if (e(r100[r102]) == true) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public void requestPermissions(String r100, String r101, String r102, int r103, int r104, String... r105) {
        if (d(r105) == false) goto L5;
        f(r100, r101, r102, r103, r104, r105);
        return;
    L5:
        a(r104, r105);
    }
}
