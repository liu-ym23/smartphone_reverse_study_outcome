package com.bytedance.android.livesdk.interactivity.publicscreen.pin;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.livesdk.interactivity.publicscreen.adapter.MessageListAdapter;
import com.bytedance.android.livesdk.interactivity.publicscreen.ui.TextMessageLayoutManager;
import com.bytedance.android.livesdk.interactivity.textmessage.model.z;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import u42.f;
import u42.h;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements u42.c, WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u42.b f139000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f139001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u42.b f139002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DataCenter f139003d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f139004e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final aa2.a f139005f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MessageListAdapter f139006g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinearLayoutManager f139007h;

    public static final class a {
    }

    public static final class b implements u42.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f139008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ViewGroup f139009b;

        @Override // u42.a
        public Context getContext() {
            return this.f139008a;
        }

        public b(ViewGroup r100) {
            Intrinsics.checkNotNullParameter(r100, "pinContainer");
            this.f139009b = r100;
            this.f139008a = r100.getContext();
        }

        public final View a(int r100) {
            LayoutInflater.from(getContext()).inflate(r100, this.f139009b, true);
            return this.f139009b.getChildAt(0);
        }
    }

    static {
    }

    public final WeakHandler b() {
        return (WeakHandler) this.f139001b.getValue();
    }

    @Override // u42.c
    public final boolean a(u42.b r110) {
        if (r110 != null) goto L7;
        this.f139002c = null;
        return false;
    L7:
        if (Intrinsics.areEqual(r110, this.f139002c) == false) goto L9;
        return false;
    L9:
        this.f139002c = r110;
        long r100 = r110.h();
        if (r110.a() == false) goto L12;
        return false;
    L12:
        if (r100 <= 0) goto L36;
        f.a("tryPin type=" + r110.getType() + " priority=" + r110.getPriority());
        u42.b r101 = this.f139000a;
        if (r101 != null) goto L16;
        boolean r102 = false;
    L20:
        this.f139004e.setVisibility(0);
        if (this.f139004e.getChildCount() <= 0) goto L23;
        this.f139004e.removeAllViews();
    L23:
        View r103 = r110.i(new b(this.f139004e));
        if (r103.getParent() != null) goto L26;
        this.f139004e.addView(r103);
    L26:
        r110.c(new u42.e(r100, r103, this.f139003d, this.f139006g.f138892e.f532083m));
        com.bytedance.android.livesdk.interactivity.api.entity.f<?> r104 = r110.getMessage();
        if (r102 == false) goto L30;
        b().post(new e(this, r104));
    L33:
        b().sendEmptyMessageDelayed(1, r100);
        r110.b();
        this.f139000a = r110;
        return true;
    L30:
        if ((r104 instanceof z) == false) goto L32;
        this.f139005f.w(new d(r104));
        goto L33
    L32:
        this.f139005f.Q(r104.f133141b);
        goto L33
    L16:
        if (r101.getPriority() < r110.getPriority()) goto L18;
        f.a("pin failed. cur: type=" + r101.getType() + " priority=" + r101.getPriority());
        return false;
    L18:
        r102 = c(true, null);
        goto L20
    L36:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.handler.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.what != 1) goto L8;
        c(false, null);
        return;
    }

    public final boolean c(boolean r100, Boolean r101) {
        u42.b r102 = this.f139000a;
        if (r102 == null) goto L15;
        f.a("unpin. evict=" + r100 + " type=" + r102.getType());
        r102.f(new h(r100, this.f139003d));
        this.f139004e.setVisibility(8);
        this.f139004e.removeAllViews();
        if (r101 == null) goto L7;
        boolean r103 = r101.booleanValue();
    L8:
        if (r103 == false) goto L10;
        int r104 = RangesKt.coerceAtLeast(this.f139007h.findFirstVisibleItemPosition(), 0);
        f.a("insert to message list. pos=" + r104);
        this.f139005f.D(r104, r102.getMessage());
        this.f139006g.notifyDataSetChanged();
    L10:
        this.f139000a = null;
        if (r100 == false) goto L14;
        b().removeMessages(1);
    L14:
        return r103;
    L7:
        r103 = r102.e();
        goto L8
    L15:
        return false;
    }

    public c(DataCenter r100, ViewGroup r101, aa2.a r102, MessageListAdapter r103, TextMessageLayoutManager r104) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "pinContainer");
        Intrinsics.checkNotNullParameter(r102, "presenter");
        Intrinsics.checkNotNullParameter(r103, "adapter");
        Intrinsics.checkNotNullParameter(r104, "layoutManager");
        this.f139003d = r100;
        this.f139004e = r101;
        this.f139005f = r102;
        this.f139006g = r103;
        this.f139007h = r104;
        this.f139001b = LazyKt.lazy(new PinManager$handler$2(this));
    }
}
