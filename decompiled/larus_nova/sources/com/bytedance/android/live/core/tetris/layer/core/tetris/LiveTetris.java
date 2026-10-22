package com.bytedance.android.live.core.tetris.layer.core.tetris;

import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.ServiceWidgetElement;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.ies.sdk.widgets.Widget;
import h70.b;
import io.reactivex.android.schedulers.AndroidSchedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import t70.f;
import t70.i;
import t70.j;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Lh70/b;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/Tetris;", "<init>", "()V", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class LiveTetris<T extends b> extends Tetris<T> {
    public LiveTetris() {
    }

    public final void S(Element<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        H(r100);
        if ((r100 instanceof WidgetElement) == false) goto L6;
        ((WidgetElement) r100).l();
        return;
    L6:
        if ((r100 instanceof ServiceWidgetElement) == false) goto L10;
        ((ServiceWidgetElement) r100).m();
        return;
    }

    public final <T> void T(Class<T> r100, Function1<? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventClass");
        Intrinsics.checkNotNullParameter(r101, "func");
        ((ObservableSubscribeProxy) xs2.b.a().b(r100).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new f(r101));
    }

    public static WidgetElement R(LiveTetris r100, Widget r101, ViewGroup r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "widget");
        Intrinsics.checkNotNullParameter(r102, "elementView");
        return (WidgetElement) r100.F(new j(false, false, r101), r102);
    }

    public final WidgetElement P(Class<? extends Widget> r100, ViewGroup r101, boolean r102, Object[] r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "widgetClass");
        Intrinsics.checkNotNullParameter(r101, "elementView");
        i r105 = new i(r102, r104, r100);
        if (r103 == null) goto L6;
        r105.d(r103);
    L6:
        return (WidgetElement) F(r105, r101);
    }

    public static /* synthetic */ WidgetElement Q(LiveTetris r100, Class r101, ViewGroup r102, boolean r103, Object[] r110, int r111) {
        if ((r111 & 4) == 0) goto L5;
        boolean r104 = true;
    L7:
        if ((r111 & 8) == 0) goto L10;
        r110 = null;
    L10:
        return r100.P(r101, r102, r104, r110, false);
    L5:
        r104 = r103;
        goto L7
    }
}
