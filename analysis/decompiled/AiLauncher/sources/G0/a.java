package G0;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.Q;
import androidx.core.view.ViewKt;
import androidx.customview.poolingcontainer.R$id;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\"\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\b\"\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\b\"(\u0010\r\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\"\u0018\u0010\u0014\u001a\u00020\u0011*\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Landroid/view/View;", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;)V", "Landroid/view/ViewGroup;", Const.INTENT_KEY_PKGNAME, "(Landroid/view/ViewGroup;)V", "", "I", "PoolingContainerListenerHolderTag", "IsPoolingContainerTag", "", UxipConstants.f30680s, "isPoolingContainer", "(Landroid/view/View;)Z", Const.INTENT_KEY_UMID, "(Landroid/view/View;Z)V", "LG0/c;", "c", "(Landroid/view/View;)LG0/c;", "poolingContainerListenerHolder", "customview-poolingcontainer_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int f2769a = R$id.pooling_container_listener_holder_tag;

    /* renamed from: b, reason: collision with root package name */
    public static final int f2770b = R$id.is_pooling_container_tag;

    public static final void a(View view) {
        p.i(view, "<this>");
        Iterator<View> it = ViewKt.a(view).iterator();
        while (it.hasNext()) {
            c(it.next()).a();
        }
    }

    public static final void b(ViewGroup viewGroup) {
        p.i(viewGroup, "<this>");
        Iterator<View> it = Q.a(viewGroup).iterator();
        while (it.hasNext()) {
            c(it.next()).a();
        }
    }

    public static final c c(View view) {
        int i10 = f2769a;
        c cVar = (c) view.getTag(i10);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        view.setTag(i10, cVar2);
        return cVar2;
    }

    public static final void d(View view, boolean z10) {
        p.i(view, "<this>");
        view.setTag(f2770b, Boolean.valueOf(z10));
    }
}
