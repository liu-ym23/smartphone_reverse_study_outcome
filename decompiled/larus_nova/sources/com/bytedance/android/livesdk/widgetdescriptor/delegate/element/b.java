package com.bytedance.android.livesdk.widgetdescriptor.delegate.element;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.utils.e6;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.livesdk.widgetdescriptor.y0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import ds0.e;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import j70.f;
import j70.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b extends l70.a<e0> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f162368g;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f162369a;

        public a(b r100) {
            this.f162369a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            sh6.b r101 = (sh6.b) r100;
            VideoViewParams r102 = ((e) this.f162369a.f162368g.getValue()).getParams().getValue();
            if (r102 == null) goto L6;
            e6.a("ShadowPlayerElementDelegate: receive padOrientation change");
            this.f162369a.e(r102);
        L6:
            if (((e) this.f162369a.f162368g.getValue()).getParams().getValue() != null) goto L9;
            b r103 = this.f162369a;
            y0.a r104 = y0.f162522c;
            e0 r105 = r103.b();
            r104.getClass();
            r103.a(y0.a.a(r105));
            return;
        }
    }

    @Override // l70.a
    public final void d() {
    }

    @Override // l70.a
    public final void c() {
        e6.a("ShadowPlayerElementDelegate: onElementAdded");
        MutableLiveData<VideoViewParams> r100 = ((e) this.f162368g.getValue()).getParams();
        LifecycleOwner r101 = this.f507764c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
    L5:
        r100.observe(r101, new c(this));
        VideoViewParams r102 = r100.getValue();
        if (r102 == null) goto L9;
        e(r102);
    L9:
        if (PadConfigUtils.c() == false) goto L18;
        RoomContext r103 = b().b();
        if (r103 == null) goto L19;
        n<PadOrientation> r104 = r103.getPadOrientation();
        if (r104 == null) goto L20;
        Observable<sh6.b<PadOrientation>> r105 = r104.a();
        if (r105 == null) goto L21;
        r105.subscribe(new a(this));
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    public b(g r100) {
        Intrinsics.checkNotNullParameter(r100, "elementType");
        super(r100);
        this.f162368g = LazyKt.lazy(new ShadowPlayerElementDelegate$renderViewParams$2(this));
    }

    public final void e(VideoViewParams r100) {
        int r101 = e6.f158941a;
        e6.a("ShadowPlayerElementDelegate: updateVirtualPlayerWidget,using param:" + r100);
        DataCenter r102 = b().f467480h;
        if (r102 == null) goto L5;
        Boolean r103 = (Boolean) r102.get("cmd_player_view_measure_ready", Boolean.FALSE);
    L7:
        if (Intrinsics.areEqual(r103, Boolean.FALSE) == false) goto L12;
        DataCenter r104 = b().f467480h;
        if (r104 == null) goto L12;
        r104.put("cmd_player_view_measure_ready", Boolean.TRUE);
    L12:
        if (com.bytedance.android.livesdk.utils.landscape.e.b(jr1.b.a(b()), d90.c.q(b())) == true) goto L14;
    L18:
        ElementConstraint r105 = new ElementConstraint(r100.f112569a, r100.f112570b);
    L19:
        ElementConstraint.Side r106 = ElementConstraint.Side.TOP;
        r105.e(r106, r106, r100.f112571c);
        ElementConstraint.Side r107 = ElementConstraint.Side.LEFT;
        r105.d(r107, r107, 0.0f);
        ElementConstraint.Side r108 = ElementConstraint.Side.RIGHT;
        r105.d(r108, r108, 0.0f);
        r105.f65831i = 0;
        if (PadConfigUtils.c() == true) goto L22;
    L27:
        a(r105);
        return;
    L22:
        if (jr1.b.c(b()) == false) goto L27;
        if (e5.n() == true) goto L26;
        ElementConstraint.Side r109 = ElementConstraint.Side.BOTTOM;
        r105.b(r109, f.f497557e, r109, 0.0f);
        goto L27
    L26:
        ElementConstraint.Side r110 = ElementConstraint.Side.BOTTOM;
        r105.d(r110, r110, 0.0f);
        goto L27
    L14:
        if (d90.c.f(b()) == false) goto L18;
        if (com.bytedance.android.livesdk.utils.landscape.e.a(d90.c.q(b())) == false) goto L18;
        r105 = new ElementConstraint(r100.f112569a, s1.w());
        goto L19
    L5:
        r103 = null;
        goto L7
    }
}
