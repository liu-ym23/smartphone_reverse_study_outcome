package com.bytedance.android.livesdk.interactivity.publicscreen.adapter;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.sdk.m.p.e;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.MessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.TextMessageTracer;
import com.bytedance.android.livesdk.interactivity.publicscreen.utils.j;
import com.bytedance.android.livesdk.interactivity.publicscreen.utils.u;
import com.bytedance.android.livesdk.interactivity.publicscreen.viewholder.ActionMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.publicscreen.viewholder.RoomIntroViewHolder;
import com.bytedance.android.livesdk.interactivity.publicscreen.viewholder.RoomNoticeViewHolder;
import com.bytedance.android.livesdk.interactivity.textmessage.model.z;
import com.bytedance.android.livesdk.interactivity.textmessage.viewholder.AudioTextMessageViewHolderV2;
import com.bytedance.android.livesdk.interactivity.textmessage.viewholder.TextMessageRenderViewHolder;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.larus.nova.R;
import da2.b;
import g52.c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import u42.g;

/* JADX INFO: loaded from: classes9.dex */
public class MessageListAdapter extends RecyclerView.Adapter<MessageViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LayoutInflater f138888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<f<?>> f138889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v92.a f138890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f138891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public q92.a f138892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f138893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f138894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f138895h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DataCenter f138896i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f138897j;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if ((r100.getTag() instanceof com.bytedance.android.livesdk.interactivity.api.entity.a) == true) goto L5;
            return;
        L5:
            com.bytedance.android.livesdk.interactivity.api.entity.a r101 = (com.bytedance.android.livesdk.interactivity.api.entity.a) r100.getTag();
            r100.getContext();
            r101.K();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<f<?>> r100 = this.f138889b;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.size();
    }

    public final k<f<?>> z2() {
        q92.a r100 = this.f138892e;
        if (r100 == null) goto L7;
        k<f<?>> r101 = r100.f532089s;
        if (r101 == null) goto L7;
        return r101;
    L7:
        int r102 = da2.a.f467668a;
        return new b(new da2.c(this.f138893f, this.f138894g, null));
    }

    public MessageListAdapter(c r100) {
        this.f138895h = true;
        this.f138897j = new a();
        this.f138891d = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r100) {
        return ((f) ListProtector.get(this.f138889b, r100)).getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        super.onAttachedToRecyclerView(r100);
        new WeakReference(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        ((MessageViewHolder) r100).T3();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        ((MessageViewHolder) r100).V3();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver r100) {
        boolean r101 = TextMessageTracer.f133629a;
        TextMessageTracer.A("on unregister adapter data observer for adapter");
        super.unregisterAdapterDataObserver(r100);     // Catch: IllegalStateException -> L5
        return;
    L5:
        e = move-exception;
        boolean r102 = TextMessageTracer.f133629a;
        TextMessageTracer.A("on error!  observer not resgisted " + e.getMessage());
        if (v.a() == true) goto L10;
        SafetyGuard.a(null, e, null);
        return;
    L10:
        throw e;
    }

    public MessageViewHolder A2(ViewGroup r100, int r101) {
        if (r101 != 0) goto L4;
        TextMessageRenderViewHolder.f r102 = j.a(r100.getContext());
        TextMessageRenderViewHolder r103 = new TextMessageRenderViewHolder(r102, z2(), true, this.f138892e, this.f138891d);
        g52.a r104 = r102.f141283d;
        if (r104 == null) goto L36;
        r104.setDispatchCallback(r103);
    L36:
        return r103;
    L4:
        if (r101 == 1) goto L32;
        if (r101 != 6) goto L8;
        k<f<?>> r105 = z2();
        View r106 = this.f138888a.inflate(R.layout.ttlive_item_chat_room_audio_message_v2, r100, false);
        if (r106.getLayoutParams() != null) goto L30;
        r106.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    L30:
        return new AudioTextMessageViewHolderV2(r106, r105, this.f138892e);
    L8:
        if (r101 != 7) goto L10;
        View r107 = this.f138888a.inflate(R.layout.ttlive_room_message_room_intro, r100, false);
        RelativeLayout r108 = new RelativeLayout(r100.getContext());
        r108.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r108.addView(r107);
        r108.setFocusable(true);
        r108.setFocusableInTouchMode(true);
        if (r108.getLayoutParams() != null) goto L25;
        r108.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    L25:
        return new RoomIntroViewHolder(r108, this.f138894g, this.f138892e, this.f138896i);
    L10:
        if (r101 == 8) goto L19;
        u.f140376b.b(r101);
        if (v.a() == true) goto L18;
        TextMessageRenderViewHolder.f r109 = j.a(r100.getContext());
        TextMessageRenderViewHolder r110 = new TextMessageRenderViewHolder(r109, z2(), true, this.f138892e, this.f138891d);
        g52.a r111 = r109.f141283d;
        if (r111 == null) goto L16;
        r111.setDispatchCallback(r110);
    L16:
        return r110;
    L18:
        throw new RuntimeException("MessageListAdapter, unknown type: " + r101);
    L19:
        int r112 = RoomNoticeViewHolder.f140427d;
        return new RoomNoticeViewHolder(this.f138888a.inflate(R.layout.ttlive_room_message_room_notice, r100, false), this.f138894g, this.f138892e);
    L32:
        return new ActionMessageViewHolder(this.f138888a.inflate(R.layout.ttlive_room_rich_chat_message_v2, r100, false), this.f138897j, this.f138892e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        MessageViewHolder r102 = (MessageViewHolder) r100;
        v92.a r103 = this.f138890c;
        if (r103 != null) goto L5;
    L7:
        f<?> r104 = (f) ListProtector.get(this.f138889b, r101);
        u r105 = u.f140376b;
        r105.m(r104);
        r102.getClass();
        y2(r102, r104, r101);
        View r106 = r102.itemView;
        int r107 = com.bytedance.android.livesdk.interactivity.publicscreen.pin.b.f138999a;
        Intrinsics.checkNotNullParameter(r106, "itemView");
        Intrinsics.checkNotNullParameter(r104, "message");
        u42.b r108 = null;
        if ((r104 instanceof z) == false) goto L10;
        u42.b r109 = ((z) r104).H.f133473d;
    L13:
        if (r109 != null) goto L15;
    L18:
        int r110 = g.f548686a;
        Intrinsics.checkNotNullParameter(r106, "view");
        r106.setTag(R.id.ttlive_public_screen_pin_handler, r108);
        r105.g(r104);
        if (this.f138895h == false) goto L22;
        this.f138895h = false;
        HashMap r111 = new HashMap();
        r111.put(ReportCardMonitorPlugin.EVENT_NAME, "ON_FIRST_MSG_SHOW");
        r111.put("msg_id", Long.valueOf(r104.f133141b.getMessageId()));
        r111.put(e.f25671s, r104.f133141b.getMessageMethod());
        b0.o().b("ttlive_msg", r111);
        return;
    L22:
        return;
    L15:
        if (r109.getShowTimestamp() != null) goto L17;
        r109.g(Long.valueOf(SystemClock.elapsedRealtime()));
    L17:
        r108 = r109;
        goto L18
    L10:
        if (r104 == null) goto L12;
        r109 = r104.C;
        goto L13
    L12:
        r109 = null;
        goto L13
    L5:
        if (r101 != 4) goto L7;
        r103.preload();
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return A2(r100, r101);
    }

    public void y2(MessageViewHolder r100, f r101, int r102) {
        g52.e r103 = this.f138892e.f532083m;
        r100.f133577a = r101;
        r100.U3(r101, r102, r103);
    }
}
