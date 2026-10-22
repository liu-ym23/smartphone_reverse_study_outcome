package com.bytedance.android.live.liveinteract.floatwindow.onlinewindow;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.floatwindow.common.listener.LinkmicOnlineListDiffCallback;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.utils.l3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HSImageView f73402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HSImageView f73403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView f73404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f73405d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f73406e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f73407f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f73408g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewGroup f73409h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f73410i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f73411j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f73412k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f73413l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public IRoom f73414m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<ILinkPlayerInfoBridge> f73415n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LinkmicOnlineFloatViewAvatarAdapter f73416o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ye0.c f73417p;

    public static final class a {
    }

    static {
    }

    public final void a(boolean r100) {
        Iterator<T> r101 = this.f73415n.iterator();
    L3:
        RecyclerView.ViewHolder r102 = null;
        if (r101.hasNext() == false) goto L8;
        Object r103 = r101.next();
        if (je0.d.C((ILinkPlayerInfoBridge) r103) == false) goto L3;
    L10:
        if (((ILinkPlayerInfoBridge) r103) != null) goto L12;
        return;
    L12:
        if (this.f73415n.size() < 4) goto L16;
        RecyclerView r104 = this.f73404c;
        if (r104 == null) goto L20;
        r102 = r104.findViewHolderForAdapterPosition(3);
    L20:
        if ((r102 instanceof LinkmicOnlineFloatViewAvatarViewHolder) == false) goto L27;
        ((LinkmicOnlineFloatViewAvatarViewHolder) r102).T3(r100);
        return;
    L27:
        return;
    L16:
        RecyclerView r105 = this.f73404c;
        if (r105 == null) goto L20;
        r102 = r105.findViewHolderForAdapterPosition(this.f73415n.size() - 1);
        goto L20
    L8:
        r103 = null;
        goto L10
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        String r101 = LinkmicOnlineFloatWindowManager.Y;
        LinkmicOnlineFloatWindowManager.c.a().getClass();
        LinkmicOnlineFloatWindowManager.d();
    }

    public final void setGuestListWithDiffUpdate(List<ILinkPlayerInfoBridge> r110) {
        Intrinsics.checkNotNullParameter(r110, "newList");
        this.f73415n = r110;
        LinkmicOnlineFloatViewAvatarAdapter r100 = this.f73416o;
        if (r100 == null) goto L60;
        Intrinsics.checkNotNullParameter(r110, "newList");
        Iterator<ILinkPlayerInfoBridge> r101 = r110.iterator();
        int r102 = 0;
    L6:
        if (r101.hasNext() == false) goto L11;
        if (je0.d.C(r101.next()) == true) goto L13;
        r102 = r102 + 1;
    L13:
        if (r110.size() <= 4) goto L15;
        boolean r103 = true;
    L17:
        if (r103 == r100.f73343a) goto L21;
        r100.f73343a = r103;
        if (r110.size() <= 2) goto L21;
        r100.notifyItemChanged(2);
    L21:
        if (r102 == (-1)) goto L36;
        List r111 = CollectionsKt.toMutableList(r110);
        ILinkPlayerInfoBridge r104 = (ILinkPlayerInfoBridge) ListProtector.remove(r111, r102);
        ArrayList r105 = new ArrayList();
        Iterator r112 = r111.iterator();
        int r106 = 0;
    L24:
        if (r112.hasNext() == false) goto L35;
        Object r107 = r112.next();
        int r108 = r106 + 1;
        if (r106 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        ILinkPlayerInfoBridge r109 = (ILinkPlayerInfoBridge) r107;
        if (r106 >= 3) goto L31;
        boolean r113 = true;
    L32:
        if (r113 == false) goto L34;
        r105.add(r107);
    L34:
        r106 = r108;
        goto L24
    L31:
        r113 = false;
        goto L32
    L35:
        List<? extends ILinkPlayerInfoBridge> r114 = CollectionsKt.toMutableList(r105);
        r114.add(r104);
    L50:
        DiffUtil.calculateDiff(new LinkmicOnlineListDiffCallback(r100.f73345c, r114), true).dispatchUpdatesTo(r100);
        r100.f73345c = r114;
        return;
    L36:
        ArrayList r115 = new ArrayList();
        Iterator<T> r116 = r110.iterator();
        int r117 = 0;
    L38:
        if (r116.hasNext() == false) goto L49;
        Object r118 = r116.next();
        int r119 = r117 + 1;
        if (r117 >= 0) goto L42;
        CollectionsKt.throwIndexOverflow();
    L42:
        ILinkPlayerInfoBridge r120 = (ILinkPlayerInfoBridge) r118;
        if (r117 >= 4) goto L45;
        boolean r121 = true;
    L46:
        if (r121 == false) goto L48;
        r115.add(r118);
    L48:
        r117 = r119;
        goto L38
    L45:
        r121 = false;
        goto L46
    L49:
        r114 = CollectionsKt.toMutableList(r115);
        goto L50
    L15:
        r103 = false;
        goto L17
    L11:
        r102 = -1;
        goto L13
    }

    public final void setInitState(IRoom r100) {
        this.f73414m = r100;
        RecyclerView r101 = this.f73404c;
        if (r101 == null) goto L5;
        r101.setVisibility(0);
    L5:
        TextView r102 = this.f73413l;
        if (r102 == null) goto L8;
        r102.setVisibility(0);
    L8:
        ViewGroup r103 = this.f73408g;
        if (r103 == null) goto L11;
        r103.setVisibility(8);
    L11:
        ViewGroup r104 = this.f73409h;
        if (r104 == null) goto L14;
        r104.setVisibility(8);
    L14:
        ViewGroup r105 = this.f73405d;
        if (r105 == null) goto L17;
        r105.setVisibility(8);
    L17:
        float r106 = s1.y() / s1.w();
        if (r100 == null) goto L22;
        py.k r107 = r100.getCover();
        if (r107 == null) goto L22;
        ImageLoader.bindImage(this.f73402a, r107, new l3(5, r106, null));
    L22:
        if (r100 != null) goto L24;
        return;
    L24:
        if (r100.getVisibilityRange() != 15) goto L30;
        HSImageView r108 = this.f73403b;
        if (r108 == null) goto L31;
        r108.setVisibility(0);
        return;
    L31:
        return;
    }

    public b(Context r100, LinkmicOnlineFloatWindowManager r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "listener");
        super(r100);
        this.f73417p = r101;
        this.f73415n = new ArrayList();
        View r102 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_linkmic_online_float_view, this);
        this.f73402a = (HSImageView) r102.findViewById(R.id.float_view_bg);
        this.f73403b = (HSImageView) r102.findViewById(R.id.float_view_close);
        this.f73404c = (RecyclerView) r102.findViewById(R.id.float_view_rv);
        this.f73405d = (ViewGroup) r102.findViewById(R.id.float_view_room_close_container);
        this.f73406e = (TextView) r102.findViewById(R.id.float_view_room_close_tips);
        this.f73407f = (TextView) r102.findViewById(R.id.float_view_auto_close_time);
        this.f73408g = (ViewGroup) r102.findViewById(R.id.float_view_disconnect_container);
        this.f73409h = (ViewGroup) r102.findViewById(R.id.float_view_auto_enter_container);
        this.f73410i = (TextView) r102.findViewById(R.id.float_view_enter_room_hint);
        this.f73411j = (TextView) r102.findViewById(R.id.float_view_enter_room_time);
        this.f73413l = (TextView) r102.findViewById(R.id.float_view_state);
        this.f73412k = r102.findViewById(R.id.ttlive_paid_time_count_down_bar);
        this.f73416o = new LinkmicOnlineFloatViewAvatarAdapter(getContext(), this.f73415n);
        RecyclerView r103 = this.f73404c;
        if (r103 == null) goto L5;
        LinearLayoutManager r104 = new LinearLayoutManager(getContext());
        r104.setOrientation(0);
        Unit r105 = Unit.INSTANCE;
        r103.setLayoutManager(r104);
    L5:
        RecyclerView r106 = this.f73404c;
        if (r106 == null) goto L8;
        r106.addItemDecoration(new LinkmicOnlineFloatView$initView$2());
    L8:
        RecyclerView r107 = this.f73404c;
        if (r107 == null) goto L11;
        r107.setAdapter(this.f73416o);
    L11:
        r102.setOnClickListener(new c(this));
        HSImageView r108 = this.f73403b;
        if (r108 == null) goto L15;
        r108.setOnClickListener(new d(this));
    L15:
        if (((Boolean) vm2.d.f555874j7.getValue(null, vm2.d.f555776a[422(0x1a6, float:5.91E-43)])).booleanValue() == false) goto L19;
        HSImageView r109 = this.f73403b;
        if (r109 == null) goto L23;
        r109.setVisibility(8);
        return;
    L23:
        return;
    L19:
        HSImageView r110 = this.f73403b;
        if (r110 == null) goto L25;
        r110.setVisibility(0);
        return;
    }
}
