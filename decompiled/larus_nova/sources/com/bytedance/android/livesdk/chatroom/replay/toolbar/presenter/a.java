package com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.n0;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.k4;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSToolbarConfigData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.larus.nova.R;
import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x3 f110147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f110148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<ToolbarButton, View> f110149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<ExtendedToolbarButton, View> f110150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f110151e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final NextLiveData<Integer> f110152f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LifecycleOwner f110153g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DataCenter f110154h;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter.a$a, reason: collision with other inner class name */
    public static final class C1660a {
    }

    static {
    }

    public void d(ToolbarButton r100) {
        Intrinsics.checkNotNullParameter(r100, "button");
    }

    public abstract boolean f();

    public void g() {
    }

    public final x3 b() {
        x3 r100 = this.f110147a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mUnfoldedToolbarManager");
    L5:
        return r100;
    }

    public final Map<ExtendedToolbarButton, View> c() {
        Map<ExtendedToolbarButton, View> r100 = this.f110150d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewMap");
    L5:
        return r100;
    }

    public void i() {
        List<? extends VSToolbarConfigData> r100 = hm1.a.f485714a;
        hm1.a.f485714a = null;
        hm1.a.f485715b = null;
        this.f110148b.clear();
    }

    public void h(Object[] r100) {
        this.f110152f.setValue(0);
        c0 r101 = y3.m(this.f110154h);
        if (r101 == null) goto L14;
        x3 r102 = (x3) r101;
        this.f110147a = r102;
        this.f110150d = r102.f116829c;
        DataCenter r103 = this.f110154h;
        if (r103 == null) goto L10;
        Episode r104 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.g(r103);
        if (r104 == null) goto L10;
        List<? extends VSToolbarConfigData> r105 = hm1.a.f485714a;
        hm1.a.f485715b = r104.getRoomAuthStatus();
        hm1.a.f485714a = r104.toolbarList;
        return;
    L10:
        if (v.a() == false) goto L16;
        ALogger.i("VS_TOOLBAR", "null activity data");
        return;
    L16:
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarManager");
    }

    public a(LifecycleOwner r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        this.f110153g = r100;
        this.f110154h = r101;
        this.f110148b = new CompositeDisposable();
        this.f110149c = new EnumMap(ToolbarButton.class);
        this.f110151e = true;
        NextLiveData<Integer> r102 = new NextLiveData();
        r102.setValue(0);
        Unit r103 = Unit.INSTANCE;
        this.f110152f = r102;
    }

    public final void a(ToolbarButton r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "button");
        x3 r102 = this.f110147a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mUnfoldedToolbarManager");
    L5:
        c0.b r103 = r102.t(r100);
        NextLiveData<Integer> r104 = this.f110152f;
        Integer r105 = r104.getValue();
        Integer r106 = null;
        if (r105 == null) goto L8;
        Integer r107 = Integer.valueOf(r105.intValue() + 1);
    L9:
        r104.setValue(r107);
        if ((r103 instanceof c0.a) == false) goto L16;
        c0.a r108 = (c0.a) r103;
        this.f110148b.add(r108.getTitle().observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r101)));
        Maybe<Drawable> r109 = r108.getIcon();
        if (r101 == null) goto L14;
        r101.setVisibility(0);
    L14:
        this.f110148b.add(r109.observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r101, r100), new d(this, r101)));
        return;
    L16:
        if ((r103 instanceof n0) == false) goto L18;
        ALogger.d("VS_TOOLBAR", "add IVSDynamicIconBehavior observe for " + r100.name());
        ((n0) r103).q().observe(this.f110153g, new e(this), true);
        return;
    L18:
        NextLiveData<Integer> r110 = this.f110152f;
        Integer r111 = r110.getValue();
        if (r111 == null) goto L21;
        r106 = Integer.valueOf(r111.intValue() - 1);
    L21:
        r110.setValue(r106);
        return;
    L8:
        r107 = null;
        goto L9
    }

    public static void e(ToolbarButton r100, View r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "button");
        k4 r103 = r100.getVsToolbarExtendProperty();
        if (r103 != null) goto L5;
        return;
    L5:
        View r104 = r101.findViewById(R.id.icon);
        if (r102 == false) goto L12;
        Integer r105 = r103.f116370c;
        if (r105 == null) goto L17;
        int r106 = r105.intValue();
        if (r104 == null) goto L17;
        r104.setBackgroundResource(r106);
    L17:
        TextView r107 = (TextView) r101.findViewById(R.id.tv_content);
        Integer r108 = r103.f116369b;
        if (r108 == null) goto L22;
        int r109 = r108.intValue();
        if (r107 == null) goto L22;
        r107.setText(r109);
    L22:
        if (r102 == false) goto L29;
        RelativeLayout r110 = (RelativeLayout) r101.findViewById(R.id.toolbar_icon_root);
        Integer r111 = r103.f116371d;
        if (r111 == null) goto L30;
        int r112 = r111.intValue();
        if (r110 == null) goto L31;
        r110.setBackgroundResource(r112);
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L12:
        Integer r113 = r103.f116368a;
        if (r113 == null) goto L17;
        int r114 = r113.intValue();
        if (r104 == null) goto L17;
        r104.setBackgroundResource(r114);
        goto L17
    }
}
