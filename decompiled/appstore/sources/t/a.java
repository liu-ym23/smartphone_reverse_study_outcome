package t;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.ViewKt;
import androidx.customview.poolingcontainer.R$id;
import java.util.Iterator;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f24697a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f24698b = 0;

    static {
        f24697a = R$id.pooling_container_listener_holder_tag;
        f24698b = R$id.is_pooling_container_tag;
    }

    public static final void a(View r10) {
        q.g(r10, "<this>");
        Iterator r11 = ViewKt.c(r10).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        c((View) r11.next()).a();
        goto L4
    }

    public static final void b(ViewGroup r10) {
        q.g(r10, "<this>");
        Iterator r11 = ViewGroupKt.a(r10).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        c((View) r11.next()).a();
        goto L4
    }

    public static final b c(View r10) {
        int r11 = f24697a;
        b r12 = (b) r10.getTag(r11);
        if (r12 != null) goto L6;
        b r13 = new b();
        r10.setTag(r11, r13);
        return r13;
    L6:
        return r12;
    }

    public static final void d(View r10, boolean r11) {
        q.g(r10, "<this>");
        r10.setTag(f24698b, Boolean.valueOf(r11));
    }
}
