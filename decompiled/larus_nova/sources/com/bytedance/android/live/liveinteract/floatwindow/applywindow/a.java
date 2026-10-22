package com.bytedance.android.live.liveinteract.floatwindow.applywindow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.chatroom.model.interact.x;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HSImageView f73287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HSImageView f73288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView f73289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f73290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f73291e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f73292f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f73293g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f73294h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewGroup f73295i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f73296j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public IRoom f73297k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<ILinkPlayerInfoBridge> f73298l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public x f73299m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LinkmicApplyFloatViewAvatarAdapter f73300n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ye0.c f73301o;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.floatwindow.applywindow.a$a, reason: collision with other inner class name */
    public static final class C1166a {
    }

    static {
    }

    public final void b(List<? extends ILinkPlayerInfoBridge> r100) {
        Intrinsics.checkNotNullParameter(r100, "newOnlineUserList");
        ArrayList r101 = (ArrayList) r100;
        if (r101.size() != ((ArrayList) this.f73298l).size()) goto L22;
        List r102 = CollectionsKt.zip(r101, this.f73298l);
        if ((r102 instanceof Collection) == true) goto L8;
    L10:
        Iterator r103 = r102.iterator();
    L12:
        if (r103.hasNext() == false) goto L23;
        Pair r104 = (Pair) r103.next();
        ILinkPlayerInfoBridge r105 = (ILinkPlayerInfoBridge) r104.component1();
        ILinkPlayerInfoBridge r106 = (ILinkPlayerInfoBridge) r104.component2();
        IBaseUser r107 = r105.getUser();
        String r108 = null;
        if (r107 == null) goto L16;
        String r109 = r107.getIdString();
    L17:
        IBaseUser r110 = r106.getUser();
        if (r110 == null) goto L21;
        r108 = r110.getIdString();
    L21:
        if (Intrinsics.areEqual(r109, r108) == true) goto L12;
    L16:
        r109 = null;
    L23:
        boolean r111 = true;
    L24:
        if (r111 == false) goto L26;
        return;
    L26:
        ArrayList r112 = (ArrayList) this.f73298l;
        r112.clear();
        r112.addAll(r101);
        LinkmicApplyFloatViewAvatarAdapter r113 = this.f73300n;
        if (r113 == null) goto L33;
        r113.notifyDataSetChanged();
        return;
    L33:
        return;
    L8:
        if (r102.isEmpty() == false) goto L10;
    L22:
        r111 = false;
        goto L24
    }

    public final void c(x r100) {
        Intrinsics.checkNotNullParameter(r100, "waitingRankResult");
        this.f73299m = r100;
        if (r100.getRank() <= 99) goto L7;
        TextView r101 = this.f73294h;
        if (r101 == null) goto L11;
        r101.setText(s1.C(R.string.ttlive_interact_linkmic_wait_count, new Object[]{"99+"}));
        return;
    L11:
        return;
    L7:
        TextView r102 = this.f73294h;
        if (r102 == null) goto L13;
        r102.setText(s1.C(R.string.ttlive_interact_linkmic_wait_count, new Object[]{Long.valueOf(r100.getRank())}));
        return;
    }

    public a(Context r100, LinkmicApplyFloatWindowManager r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "listener");
        super(r100);
        this.f73301o = r101;
        ArrayList r102 = new ArrayList();
        this.f73298l = r102;
        View r103 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_linkmic_apply_float_view, this);
        this.f73287a = (HSImageView) r103.findViewById(R.id.float_view_bg);
        this.f73288b = (HSImageView) r103.findViewById(R.id.float_view_close);
        this.f73289c = (RecyclerView) r103.findViewById(R.id.float_view_rv);
        this.f73290d = (ViewGroup) r103.findViewById(R.id.float_view_room_close_container);
        this.f73291e = (TextView) r103.findViewById(R.id.float_view_room_close_tips);
        this.f73292f = (TextView) r103.findViewById(R.id.float_view_auto_close_time);
        this.f73293g = (ViewGroup) r103.findViewById(R.id.float_view_apply_waiting_container);
        this.f73294h = (TextView) r103.findViewById(R.id.float_view_wait_count);
        this.f73295i = (ViewGroup) r103.findViewById(R.id.float_view_apply_permit_container);
        this.f73296j = (TextView) r103.findViewById(R.id.float_view_enter_room_time);
        r103.setOnClickListener(new b(this));
        HSImageView r104 = this.f73288b;
        if (r104 == null) goto L5;
        r104.setOnClickListener(new c(this));
    L5:
        this.f73300n = new LinkmicApplyFloatViewAvatarAdapter(getContext(), r102);
        RecyclerView r105 = this.f73289c;
        if (r105 == null) goto L8;
        LinearLayoutManager r106 = new LinearLayoutManager(getContext());
        r106.setOrientation(0);
        Unit r107 = Unit.INSTANCE;
        r105.setLayoutManager(r106);
    L8:
        RecyclerView r108 = this.f73289c;
        if (r108 == null) goto L12;
        r108.setAdapter(this.f73300n);
        return;
    }

    public final void a(int r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "tips");
        if (r100 != 5) goto L16;
        this.f73301o.b();
        ViewGroup r103 = this.f73290d;
        if (r103 == null) goto L7;
        r103.setVisibility(0);
    L7:
        RecyclerView r104 = this.f73289c;
        if (r104 == null) goto L10;
        r104.setVisibility(8);
    L10:
        ViewGroup r105 = this.f73293g;
        if (r105 == null) goto L13;
        r105.setVisibility(8);
    L13:
        ViewGroup r106 = this.f73295i;
        if (r106 == null) goto L16;
        r106.setVisibility(8);
    L16:
        TextView r107 = this.f73291e;
        if (r107 == null) goto L19;
        r107.setText(r101);
    L19:
        TextView r108 = this.f73291e;
        if (r108 == null) goto L22;
        r108.setTextSize(r102);
    L22:
        TextView r109 = this.f73292f;
        if (r109 == null) goto L26;
        r109.setText(s1.C(R.string.ttlive_interact_close_float_window_after_five_seconds, new Object[]{Integer.valueOf(r100)}));
        return;
    }
}
