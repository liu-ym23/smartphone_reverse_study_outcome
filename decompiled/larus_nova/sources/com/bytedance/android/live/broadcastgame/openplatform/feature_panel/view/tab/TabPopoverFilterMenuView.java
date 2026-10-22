package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.bytedance.dux.popover.menu.DuxPopoverMenuView;
import com.bytedance.dux.radio.DuxRadio;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/tab/TabPopoverFilterMenuView;", "Lcom/bytedance/dux/popover/menu/DuxPopoverMenuView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabPopoverFilterMenuView extends DuxPopoverMenuView {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList<b> f61598j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<Integer, DuxRadio> f61599k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<ViewGroup> f61600l;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList<b> f61601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f61602b;

        public final Context getContext() {
            return this.f61602b;
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f61602b = r100;
            this.f61601a = new ArrayList();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f61603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f61604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function1<? super Integer, Unit> f61605c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Typeface f61606d;

        public b(CharSequence r100, boolean r101, Function1<? super Integer, Unit> r102, Typeface r103) {
            this.f61603a = r100;
            this.f61604b = r101;
            this.f61605c = r102;
            this.f61606d = r103;
        }
    }

    public TabPopoverFilterMenuView(Context r100) {
        this(r100, null, 0, 14);
    }

    public TabPopoverFilterMenuView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 12);
    }

    public TabPopoverFilterMenuView(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 8);
    }

    public TabPopoverFilterMenuView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, null);
        this.f61598j = new ArrayList();
        this.f61599k = new LinkedHashMap();
        this.f61600l = new ArrayList();
    }

    @Override // com.bytedance.dux.popover.menu.DuxPopoverMenuView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        Iterator<T> r104 = this.f61600l.iterator();
    L4:
        if (r104.hasNext() == false) goto L24;
        ViewGroup r105 = (ViewGroup) r104.next();
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 == null) goto L23;
        ViewGroup.LayoutParams r107 = r105.getLayoutParams();
        ViewGroup.LayoutParams r108 = null;
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == true) goto L10;
        r107 = null;
    L10:
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r107;
        int r110 = 0;
        if (r109 == null) goto L13;
        int r111 = r109.leftMargin;
    L14:
        int r112 = r100 - r111;
        ViewGroup.LayoutParams r113 = r105.getLayoutParams();
        if ((r113 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        r108 = r113;
    L18:
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r108;
        if (r114 == null) goto L21;
        r110 = r114.rightMargin;
    L21:
        r106.width = r112 - r110;
        r105.setLayoutParams(r106);
        goto L4
    L13:
        r111 = 0;
        goto L14
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
