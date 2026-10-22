package bd5;

import android.content.Context;
import android.util.SparseArray;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f18658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<a> f18659b;

    public final a b() {
        a r100 = this.f18659b.get(1);
        if (r100 != null) goto L6;
        a r101 = new a();
        FrameLayout r102 = a(R.drawable.ud_icon_addnew_outlined);
        r102.setId(R.id.list_main_menu_add);
        r101.f18656a = r102;
        this.f18659b.put(1, r101);
        return r101;
    L6:
        return r100;
    }

    public final a c() {
        a r100 = this.f18659b.get(2);
        if (r100 != null) goto L6;
        a r101 = new a();
        r101.f18656a = a(R.drawable.ud_icon_more_outlined);
        this.f18659b.put(2, r101);
        return r101;
    L6:
        return r100;
    }

    public final a d() {
        a r100 = this.f18659b.get(0);
        if (r100 != null) goto L6;
        a r101 = new a();
        r101.f18656a = a(R.drawable.ud_icon_search_outlined);
        this.f18659b.put(0, r101);
        return r101;
    L6:
        return r100;
    }

    public b(Context r100) {
        this.f18659b = new SparseArray();
        this.f18658a = r100;
    }

    public final FrameLayout a(int r100) {
        FrameLayout r101 = new FrameLayout(this.f18658a);
        ImageView r102 = new ImageView(this.f18658a);
        r102.setId(R.id.list_function_button_image);
        r102.setImageDrawable(this.f18658a.getResources().getDrawable(r100));
        r101.addView(r102, -2, -2);
        return r101;
    }
}
