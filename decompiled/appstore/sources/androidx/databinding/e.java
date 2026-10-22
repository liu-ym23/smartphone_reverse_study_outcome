package androidx.databinding;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d f2911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static DataBindingComponent f2912b;

    static {
        f2911a = new DataBinderMapperImpl();
        f2912b = null;
    }

    public static ViewDataBinding a(View r10) {
        return b(r10, f2912b);
    }

    public static ViewDataBinding b(View r10, DataBindingComponent r11) {
        ViewDataBinding r12 = c(r10);
        if (r12 == null) goto L5;
        return r12;
    L5:
        Object r13 = r10.getTag();
        if ((r13 instanceof String) == false) goto L14;
        int r14 = f2911a.getLayoutId((String) r13);
        if (r14 == 0) goto L12;
        return f2911a.getDataBinder(r11, r10, r14);
    L12:
        throw new IllegalArgumentException("View is not a binding layout. Tag: " + r13);
    L14:
        throw new IllegalArgumentException("View is not a binding layout");
    }

    public static ViewDataBinding c(View r10) {
        return ViewDataBinding.d(r10);
    }
}
