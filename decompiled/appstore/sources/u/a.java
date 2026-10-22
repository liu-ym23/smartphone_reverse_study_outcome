package u;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseIntArray f24811a = null;

    /* JADX INFO: renamed from: u.a$a, reason: collision with other inner class name */
    public static class C0384a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashMap f24812a = null;

        static {
            f24812a = new HashMap(0);
        }
    }

    static {
        f24811a = new SparseIntArray(0);
    }

    public a() {
    }

    @Override // androidx.databinding.d
    public ViewDataBinding getDataBinder(DataBindingComponent r10, View r11, int r12) {
        if (f24811a.get(r12) > 0) goto L5;
        return null;
    L5:
        if (r11.getTag() == null) goto L8;
        return null;
    L8:
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.d
    public int getLayoutId(String r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        Integer r11 = (Integer) C0384a.f24812a.get(r10);
        if (r11 != null) goto L9;
        return 0;
    L9:
        return r11.intValue();
    }
}
