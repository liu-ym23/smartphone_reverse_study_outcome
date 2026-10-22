package com.stepos.agentframework.chatui.viewholder;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.os.Trace;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.S1;
import com.stepos.agentframework.chatui.U1;
import com.stepos.agentframework.chatui.view.MessageContentContainer;
import com.stepos.agentframework.uikit.AgentMarkdownTableHorizontalScrollView;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import w4.RobotInfo;
import z4.C6360f;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001,B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010$\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcom/stepos/agentframework/chatui/viewholder/r;", "Lcom/stepos/agentframework/chatui/viewholder/k;", "Landroid/view/ViewGroup;", "parent", "Lcom/stepos/agentframework/chatui/U1;", "chatView", "<init>", "(Landroid/view/ViewGroup;Lcom/stepos/agentframework/chatui/U1;)V", "Lcom/stepos/agentframework/chatui/S1;", "item", "", "position", "LY8/t;", "e", "(Lcom/stepos/agentframework/chatui/S1;I)V", "Lcom/stepos/agentframework/chatui/longtext/ChatRenderRow;", "row", "Lz4/h;", VoiceWakeupReceiver.EXTRA_STATE, "r", "(Lcom/stepos/agentframework/chatui/longtext/ChatRenderRow;Lz4/h;)V", UxipConstants.f30680s, "s", "(I)I", "Lcom/stepos/agentframework/chatui/viewholder/r$b;", Parameters.ROOT, "Lcom/stepos/agentframework/chatui/viewholder/r$b;", "Lcom/stepos/agentframework/uikit/AgentMarkdownTableHorizontalScrollView;", "scroll", "Lcom/stepos/agentframework/uikit/AgentMarkdownTableHorizontalScrollView;", "Landroid/widget/LinearLayout;", "cells", "Landroid/widget/LinearLayout;", "Lcom/stepos/agentframework/chatui/view/MessageContentContainer;", SystemDeleteBroadcastReceiver.EXTRA_SOURCES, "Lcom/stepos/agentframework/chatui/view/MessageContentContainer;", "scrollState", "Lz4/h;", "", "restoringScroll", "Z", "Lkotlin/Function1;", "syncScroll", "Lp9/l;", Const.INTENT_KEY_PKGNAME, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class r extends AbstractC2106k {
    private final LinearLayout cells;
    private boolean restoringScroll;
    private final b root;
    private final AgentMarkdownTableHorizontalScrollView scroll;
    private z4.h scrollState;
    private final MessageContentContainer sources;
    private final InterfaceC5074l<Integer, Y8.t> syncScroll;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/agentframework/chatui/viewholder/r$a", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            z4.h hVar = r.this.scrollState;
            if (hVar != null) {
                hVar.a(r.this.syncScroll);
            }
            InterfaceC5074l interfaceC5074l = r.this.syncScroll;
            z4.h hVar2 = r.this.scrollState;
            interfaceC5074l.invoke(Integer.valueOf(hVar2 != null ? hVar2.getOffset() : 0));
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            z4.h hVar = r.this.scrollState;
            if (hVar != null) {
                hVar.b(r.this.syncScroll);
            }
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/stepos/agentframework/chatui/viewholder/r$b;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "widthMeasureSpec", "heightMeasureSpec", "LY8/t;", "onMeasure", "(II)V", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "", "phase", "", RobotInfo.STATUS_STARTED, "", AMapLocationStaticsEntity.FIRST_LOCATE, Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;JZ)V", com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30860s, "Ljava/lang/String;", "getIdentity", "()Ljava/lang/String;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)V", "firstMeasure", "Z", "getFirstMeasure", "()Z", "c", "(Z)V", "Lz4/f;", "limiter", "Lz4/f;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends LinearLayout {
        private boolean firstMeasure;
        private String identity;
        private final C6360f limiter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
            super(context);
            kotlin.jvm.internal.p.i(context, "context");
            this.identity = "";
            this.limiter = new C6360f(16, 0L, 2, null);
        }

        public static /* synthetic */ void b(b bVar, String str, long j10, boolean z10, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                z10 = false;
            }
            bVar.a(str, j10, z10);
        }

        public final void a(String phase, long started, boolean first) {
            long jElapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() - started) / 1000000;
            if (first || jElapsedRealtimeNanos >= 8) {
                C6360f.Sample sampleA = this.limiter.a(phase + "/slow=" + (jElapsedRealtimeNanos >= 8), this.identity, SystemClock.elapsedRealtime());
                if (sampleA == null) {
                    return;
                }
                C4148a.d("LongTextTableRowViewHolder", "long text table row " + this.identity + " phase=" + phase + " elapsedMs=" + jElapsedRealtimeNanos + " width=" + getMeasuredWidth() + " height=" + getMeasuredHeight() + " count=" + sampleA.getCount() + " suppressed=" + sampleA.getSuppressed(), false, 4, null);
            }
        }

        public final void c(boolean z10) {
            this.firstMeasure = z10;
        }

        public final void d(String str) {
            kotlin.jvm.internal.p.i(str, "<set-?>");
            this.identity = str;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas canvas) {
            kotlin.jvm.internal.p.i(canvas, "canvas");
            long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            Trace.beginSection("Chat.longText.drawTableRow");
            try {
                super.dispatchDraw(canvas);
                Trace.endSection();
                b(this, "draw", jElapsedRealtimeNanos, false, 4, null);
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            Trace.beginSection("Chat.longText.measureTableRow");
            try {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                Trace.endSection();
                a("measure", jElapsedRealtimeNanos, this.firstMeasure);
                this.firstMeasure = false;
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public r(ViewGroup parent, U1 chatView) {
        kotlin.jvm.internal.p.i(parent, "parent");
        kotlin.jvm.internal.p.i(chatView, "chatView");
        Context context = parent.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        super(new b(context), chatView);
        View view = this.itemView;
        kotlin.jvm.internal.p.g(view, "null cannot be cast to non-null type com.stepos.agentframework.chatui.viewholder.LongTextTableRowViewHolder.TableRowLayout");
        b bVar = (b) view;
        this.root = bVar;
        Context context2 = parent.getContext();
        kotlin.jvm.internal.p.h(context2, "getContext(...)");
        AgentMarkdownTableHorizontalScrollView agentMarkdownTableHorizontalScrollView = new AgentMarkdownTableHorizontalScrollView(context2, null, 0, 6, null);
        this.scroll = agentMarkdownTableHorizontalScrollView;
        LinearLayout linearLayout = new LinearLayout(parent.getContext());
        this.cells = linearLayout;
        Context context3 = parent.getContext();
        kotlin.jvm.internal.p.h(context3, "getContext(...)");
        MessageContentContainer messageContentContainer = new MessageContentContainer(context3, null);
        this.sources = messageContentContainer;
        this.syncScroll = new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.viewholder.o
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return r.t(this.f23199a, ((Integer) obj).intValue());
            }
        };
        bVar.setOrientation(1);
        bVar.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        bVar.addView(agentMarkdownTableHorizontalScrollView, new LinearLayout.LayoutParams(-1, -2));
        bVar.addView(messageContentContainer, new LinearLayout.LayoutParams(-1, -2));
        agentMarkdownTableHorizontalScrollView.setClipToOutline(false);
        agentMarkdownTableHorizontalScrollView.setSaveEnabled(false);
        agentMarkdownTableHorizontalScrollView.setHorizontalScrollBarEnabled(false);
        agentMarkdownTableHorizontalScrollView.addView(linearLayout, new ViewGroup.LayoutParams(-2, -2));
        agentMarkdownTableHorizontalScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.stepos.agentframework.chatui.viewholder.p
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view2, int i10, int i11, int i12, int i13) {
                r.n(this.f23200a, view2, i10, i11, i12, i13);
            }
        });
        agentMarkdownTableHorizontalScrollView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.stepos.agentframework.chatui.viewholder.q
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                r.o(this.f23201a, view2, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        });
        bVar.addOnAttachStateChangeListener(new a());
    }

    public static final void n(r rVar, View view, int i10, int i11, int i12, int i13) {
        z4.h hVar;
        if (rVar.restoringScroll || !rVar.scroll.isAttachedToWindow() || rVar.scroll.isLayoutRequested() || (hVar = rVar.scrollState) == null) {
            return;
        }
        hVar.d(i10);
    }

    public static final void o(r rVar, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        InterfaceC5074l<Integer, Y8.t> interfaceC5074l = rVar.syncScroll;
        z4.h hVar = rVar.scrollState;
        interfaceC5074l.invoke(Integer.valueOf(hVar != null ? hVar.getOffset() : 0));
    }

    public static final Y8.t t(r rVar, int i10) {
        rVar.restoringScroll = true;
        try {
            rVar.scroll.scrollTo(i10, 0);
            rVar.restoringScroll = false;
            return Y8.t.f7040a;
        } catch (Throwable th) {
            rVar.restoringScroll = false;
            throw th;
        }
    }

    @Override // com.stepos.agentframework.chatui.viewholder.AbstractC2106k
    public void e(S1 item, int position) {
        kotlin.jvm.internal.p.i(item, "item");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0293  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(com.stepos.agentframework.chatui.longtext.ChatRenderRow r36, z4.h r37) {
        /*
            Method dump skipped, instructions count: 1123
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.viewholder.r.r(com.stepos.agentframework.chatui.longtext.ChatRenderRow, z4.h):void");
    }

    public final int s(int value) {
        return (int) (value * this.root.getResources().getDisplayMetrics().density);
    }
}
