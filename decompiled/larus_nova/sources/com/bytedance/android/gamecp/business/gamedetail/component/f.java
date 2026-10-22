package com.bytedance.android.gamecp.business.gamedetail.component;

import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ecom.arch.slice.render.SlcFlexDirection;
import com.bytedance.android.gamecp.base.gamedetail.GameDetailComponent;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.base.gamedetail.l0;
import com.bytedance.android.gamecp.business.gamedetail.base.model.h;
import com.bytedance.common.utility.reflect.JavaCalls;
import com.bytedance.ies.sve_core.PureWidget;
import com.bytedance.ies.sve_list.RecyclerViewItemWidget;
import com.bytedance.ies.sve_list.SVEAdapter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f54293g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, GameDetailComponent<? extends d0>> f54294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, GameDetailComponent<? extends d0>> f54295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, GameDetailComponent<? extends d0>> f54296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Class<? extends com.bytedance.android.gamecp.business.gamedetail.component.a<?>>> f54297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l0 f54298e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FragmentManager f54299f;

    public static final class a {
    }

    static {
    }

    public f() {
        this(null);
    }

    public f(FragmentManager r100) {
        this.f54299f = r100;
        this.f54294a = new LinkedHashMap();
        this.f54295b = new LinkedHashMap();
        this.f54296c = new LinkedHashMap();
        this.f54297d = new LinkedHashMap();
    }

    public final PureWidget<d0> a(int r100) {
        Map<Integer, GameDetailComponent<? extends d0>> r101 = this.f54294a;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        GameDetailComponent r103 = (GameDetailComponent) r102.get(Integer.valueOf(r100));
        PureWidget<d0> r104 = null;
        if (r103 == null) goto L5;
        r104 = GameDetailComponent.c(r103, this.f54298e, null, this.f54299f, 8);
    L5:
        if (r104 == null) goto L11;
        String r105 = Reflection.getOrCreateKotlinClass(r104.getClass()).getSimpleName();
        if (r105 == null) goto L9;
        Map<String, GameDetailComponent<? extends d0>> r106 = this.f54296c;
        Map<Integer, GameDetailComponent<? extends d0>> r107 = this.f54294a;
        LinkedHashMap r108 = (LinkedHashMap) r107;
        Object r109 = r108.get(Integer.valueOf(r100));
        Intrinsics.checkNotNull(r109);
        r106.put(r105, (GameDetailComponent<? extends d0>) r109);
    L9:
        return r104;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.sve_core.PureWidget<com.bytedance.android.gamecp.base.gamedetail.DetailPageViewItemProps>");
    }

    @Deprecated(message = "存在单例问题，使用createWidget(type)")
    public final PureWidget<d0> c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        GameDetailComponent r101 = (GameDetailComponent) ((LinkedHashMap) this.f54295b).get(r100);
        if (r101 == null) goto L5;
        PureWidget<d0> r102 = GameDetailComponent.c(r101, this.f54298e, null, this.f54299f, 10);
    L7:
        if ((r102 instanceof PureWidget) == true) goto L9;
        r102 = null;
    L9:
        if (r102 != null) goto L11;
        return null;
    L11:
        String r103 = Reflection.getOrCreateKotlinClass(r102.getClass()).getSimpleName();
        if (r103 == null) goto L14;
        Map<String, GameDetailComponent<? extends d0>> r104 = this.f54296c;
        Object r105 = ((LinkedHashMap) this.f54295b).get(r100);
        Intrinsics.checkNotNull(r105);
        r104.put(r103, (GameDetailComponent<? extends d0>) r105);
    L14:
        return r102;
    L5:
        r102 = null;
        goto L7
    }

    @Deprecated(message = "存在单例问题，使用createWidget(type)")
    public final GameDetailComponent<d0> e(String r100) {
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        Object r102 = ((LinkedHashMap) this.f54295b).get(r100);
        if ((r102 instanceof GameDetailComponent) == false) goto L10;
        r101 = r102;
    L10:
        return (GameDetailComponent) r101;
    }

    public final RecyclerViewItemWidget<? extends d0> d(int r100, SVEAdapter<d0, ?> r101) {
        Intrinsics.checkNotNullParameter(r101, "adapter");
        Map<Integer, GameDetailComponent<? extends d0>> r102 = this.f54294a;
        LinkedHashMap r103 = (LinkedHashMap) r102;
        GameDetailComponent r104 = (GameDetailComponent) r103.get(Integer.valueOf(r100));
        if (r104 == null) goto L5;
        PureWidget r105 = GameDetailComponent.c(r104, this.f54298e, r101, this.f54299f, 8);
    L6:
        if (r105 == null) goto L12;
        RecyclerViewItemWidget<? extends d0> r106 = (RecyclerViewItemWidget) r105;
        String r107 = Reflection.getOrCreateKotlinClass(r106.getClass()).getSimpleName();
        if (r107 == null) goto L10;
        Map<String, GameDetailComponent<? extends d0>> r108 = this.f54296c;
        Map<Integer, GameDetailComponent<? extends d0>> r109 = this.f54294a;
        LinkedHashMap r110 = (LinkedHashMap) r109;
        Object r111 = r110.get(Integer.valueOf(r100));
        Intrinsics.checkNotNull(r111);
        r108.put(r107, (GameDetailComponent<? extends d0>) r111);
    L10:
        return r106;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.sve_list.RecyclerViewItemWidget<out com.bytedance.android.gamecp.base.gamedetail.DetailPageViewItemProps>");
    L5:
        r105 = null;
        goto L6
    }

    public final void g(int r100, GameDetailComponent<? extends d0> r101) {
        if (this.f54294a.containsKey(Integer.valueOf(r100)) == true) goto L6;
        this.f54294a.put(Integer.valueOf(r100), r101);
    L6:
        if (this.f54295b.containsKey(r101.f51530j) == true) goto L9;
        this.f54295b.put(r101.f51530j, r101);
        return;
    }

    public final PureWidget<d0> b(int r100, l0 r101, Function1<? super PureWidget<?>, Unit> r102) {
        Map<Integer, GameDetailComponent<? extends d0>> r103 = this.f54294a;
        LinkedHashMap r104 = (LinkedHashMap) r103;
        GameDetailComponent r105 = (GameDetailComponent) r104.get(Integer.valueOf(r100));
        PureWidget<d0> r106 = null;
        if (r105 == null) goto L5;
        r106 = r105.b(r101, null, this.f54299f, r102);
    L5:
        if (r106 == null) goto L11;
        String r107 = Reflection.getOrCreateKotlinClass(r106.getClass()).getSimpleName();
        if (r107 == null) goto L9;
        Map<String, GameDetailComponent<? extends d0>> r108 = this.f54296c;
        Map<Integer, GameDetailComponent<? extends d0>> r109 = this.f54294a;
        LinkedHashMap r110 = (LinkedHashMap) r109;
        Object r111 = r110.get(Integer.valueOf(r100));
        Intrinsics.checkNotNull(r111);
        r108.put(r107, (GameDetailComponent<? extends d0>) r111);
    L9:
        return r106;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.sve_core.PureWidget<com.bytedance.android.gamecp.base.gamedetail.DetailPageViewItemProps>");
    }

    public final d0 f(String r110, JSONObject r111, dt.b r112, h r113, boolean r114, int r115) {
        Intrinsics.checkNotNullParameter(r110, "componentClass");
        int r100 = e.f54292a;
        Intrinsics.checkNotNullParameter(r110, "componentClass");
        if (Intrinsics.areEqual("lynx_card", r110) == false) goto L5;
    L12:
        boolean r101 = true;
    L14:
        if (r101 == false) goto L44;
        if (r111 == null) goto L17;
        String r102 = g.c(r111);
    L19:
        if (TextUtils.isEmpty(r102) == false) goto L23;
        GameDetailComponent r103 = (GameDetailComponent) ((LinkedHashMap) this.f54295b).get(r110);
        if (r103 != null) goto L51;
        return null;
    L51:
        return (d0) r103.e(r111, r112, r113, r114, r115);
    L23:
        if (r102 == null) goto L25;
        int r104 = r102.hashCode();
    L26:
        GameDetailComponent r105 = (GameDetailComponent) ((LinkedHashMap) this.f54294a).get(Integer.valueOf(r104));
        if (r105 != null) goto L52;
        Class r106 = (Class) ((LinkedHashMap) this.f54297d).get(r110);
        if (r106 != null) goto L48;
        GameDetailComponent r107 = (GameDetailComponent) ((LinkedHashMap) this.f54295b).get(r110);
        if (r107 != null) goto L54;
        return null;
    L54:
        return (d0) r107.e(r111, r112, r113, r114, r115);
    L48:
        GameDetailComponent<? extends d0> r108 = (GameDetailComponent) JavaCalls.newInstanceOrThrow(r106, new Object[]{this});     // Catch: Throwable -> L36
        g(r104, r108);     // Catch: Throwable -> L36
        return (d0) r108.e(r111, r112, r113, r114, r115);
    L36:
        th = move-exception;
        String r109 = th.getMessage();
        if (r109 != null) goto L40;
        r109 = "";
    L40:
        yr.c.b("ComponentFactory", r109);
        GameDetailComponent r116 = (GameDetailComponent) ((LinkedHashMap) this.f54295b).get(r110);
        if (r116 != null) goto L43;
        return null;
    L43:
        return (d0) r116.e(r111, r112, r113, r114, r115);
    L52:
        return (d0) r105.e(r111, r112, r113, r114, r115);
    L25:
        r104 = 0;
        goto L26
    L17:
        r102 = null;
        goto L19
    L44:
        GameDetailComponent r117 = (GameDetailComponent) ((LinkedHashMap) this.f54295b).get(r110);
        if (r117 != null) goto L47;
        return null;
    L47:
        return (d0) r117.e(r111, r112, r113, r114, r115);
    L5:
        if (Intrinsics.areEqual(SlcFlexDirection.FLEX_ROW, r110) == true) goto L12;
        if (Intrinsics.areEqual("col", r110) == true) goto L12;
        if (Intrinsics.areEqual("col_v5", r110) == true) goto L12;
        r101 = false;
        goto L14
    }
}
