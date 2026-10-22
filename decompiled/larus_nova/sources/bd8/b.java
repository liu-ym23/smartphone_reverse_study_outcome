package bd8;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.layout.item.g;
import com.larus.bmhome.chat.layout.item.i;
import com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell;
import com.larus.im.bean.message.Message;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f18689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Fragment f18691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i f18692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public q0 f18693e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BaseCompositeTextCell<?> f18694f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Context f18695g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.larus.bmhome.chat.list.cell.text.cells.base.c f18696h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f18697i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f18698j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<? extends View> f18699k;

    public void A() {
    }

    public void B() {
    }

    public void C() {
    }

    public void D() {
    }

    public void E() {
    }

    public void F(boolean r100) {
    }

    public boolean G(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        return true;
    }

    public boolean H(xc8.b r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        return true;
    }

    public void v(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
    }

    public void w(Message r100, int r101, ec8.b r102) {
        Intrinsics.checkNotNullParameter(r100, "message");
    }

    public void z() {
    }

    public final View I() {
        BaseCompositeTextCell<?> r100 = this.f18694f;
        if (r100 == null) goto L7;
        g r101 = r100.f305997g;
        if (r101 == null) goto L7;
        ViewParent r102 = r101.getParent();
    L9:
        if ((r102 instanceof View) == true) goto L11;
        return null;
    L11:
        return (View) r102;
    L7:
        r102 = null;
        goto L9
    }

    public Map<String, Object> u() {
        return new LinkedHashMap();
    }

    public final Context getContext() {
        return this.f18695g;
    }

    public final void y(int r100) {
        Context r101 = this.f18695g;
        if (r101 != null) goto L6;
        CollectionsKt.emptyList();
        return;
    L6:
        this.f18699k = x(r100, r101, this.f18694f, this.f18692d, this.f18693e, this.f18691c);
        this.f18698j = true;
    }

    public b(boolean r100, int r101) {
        this.f18689a = r100;
        this.f18690b = r101;
        new LinkedHashMap();
        this.f18697i = LazyKt.lazy(new a(this));
        this.f18699k = CollectionsKt.emptyList();
    }

    public List<View> x(int r100, Context r101, BaseMessageListCell<?> r102, i r103, q0 r104, Fragment r105) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return CollectionsKt.emptyList();
    }
}
