package com.stepos.ailauncher.chat.adapter;

import android.R;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.history.DrawerTitleItem;
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.view.ShimmerTextView;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.contract.model.search.SessionActivityState;
import com.stepos.ailauncher.contract.model.search.SidebarSession;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import v5.C5659a;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0007\u0018\u0000 <2\u00020\u0001:\u0001=B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ1\u0010\u0014\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0016\u0010\rJ\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0017\u0010!\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u0004\u0018\u00010(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010\u001fR\u0014\u0010,\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010\"R\u0018\u0010-\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.RD\u00101\u001a$\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\t\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010\u001dR\u0016\u0010;\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010\u001d¨\u0006>"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/E;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "", "shimmerRunningText", "<init>", "(Landroid/view/View;Z)V", "active", "LY8/t;", "k", "(Z)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()V", "Lcom/stepos/agentframework/chatui/history/g;", "Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "item", "Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", "activityState", "isLast", Const.INTENT_KEY_UMID, "(Lcom/stepos/agentframework/chatui/history/g;Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;Z)V", "n", "Lcom/stepos/ailauncher/chat/adapter/SessionIndicatorState;", VoiceWakeupReceiver.EXTRA_STATE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/chat/adapter/SessionIndicatorState;)V", "shimmer", "m", "Z", "contentView", "Landroid/view/View;", "Landroid/widget/TextView;", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "Landroid/widget/ImageView;", "statusIcon", "Landroid/widget/ImageView;", "Lcom/stepos/ailauncher/chat/view/ShimmerTextView;", "runningShimmer", "Lcom/stepos/ailauncher/chat/view/ShimmerTextView;", "agentLabelDivider", "agentLabel", "data", "Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "Lkotlin/Function4;", "", "onLongClickListener", "Lp9/r;", "getOnLongClickListener", "()Lp9/r;", "l", "(Lp9/r;)V", "", "lastTouch", "[F", "shouldShimmer", "drawerActive", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class E extends RecyclerView.ViewHolder {
    private static final a Companion = new a(null);

    @Deprecated
    public static final int LAST_ITEM_GAP_DP = 16;
    private final TextView agentLabel;
    private final View agentLabelDivider;
    private final View contentView;
    private SidebarSession data;
    private boolean drawerActive;
    private final float[] lastTouch;
    private p9.r<? super View, ? super SidebarSession, ? super Float, ? super Float, Y8.t> onLongClickListener;
    private final ShimmerTextView runningShimmer;
    private final boolean shimmerRunningText;
    private boolean shouldShimmer;
    private final ImageView statusIcon;
    private final TextView textView;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/E$a;", "", "<init>", "()V", "", "LAST_ITEM_GAP_DP", "I", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SessionIndicatorState.values().length];
            try {
                iArr[SessionIndicatorState.SEND_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SessionIndicatorState.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SessionIndicatorState.WAITING_FOR_USER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SessionIndicatorState.COMPLETED_UNREAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SessionIndicatorState.RUNNING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SessionIndicatorState.NONE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E(View itemView, boolean z10) {
        super(itemView);
        kotlin.jvm.internal.p.i(itemView, "itemView");
        this.shimmerRunningText = z10;
        View viewFindViewById = itemView.findViewById(R$id.ll_drawer_item_content);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        this.contentView = viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.text1);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById2;
        this.textView = textView;
        View viewFindViewById3 = itemView.findViewById(R$id.iv_session_status);
        kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
        this.statusIcon = (ImageView) viewFindViewById3;
        ShimmerTextView shimmerTextView = null;
        if (z10 && (textView instanceof ShimmerTextView)) {
            shimmerTextView = (ShimmerTextView) textView;
        }
        this.runningShimmer = shimmerTextView;
        View viewFindViewById4 = itemView.findViewById(R$id.v_agent_label_divider);
        kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
        this.agentLabelDivider = viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R$id.tv_agent_label);
        kotlin.jvm.internal.p.h(viewFindViewById5, "findViewById(...)");
        this.agentLabel = (TextView) viewFindViewById5;
        this.lastTouch = new float[]{0.0f, 0.0f};
    }

    public static /* synthetic */ void e(E e10, DrawerTitleItem drawerTitleItem, SessionActivityState sessionActivityState, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            sessionActivityState = null;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        e10.d(drawerTitleItem, sessionActivityState, z10);
    }

    public static final boolean f(E e10, View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            e10.lastTouch[0] = motionEvent.getRawX();
            e10.lastTouch[1] = motionEvent.getRawY();
        }
        return false;
    }

    public static final void g(DrawerTitleItem drawerTitleItem, SidebarSession sidebarSession, View view) {
        p9.p pVarA = drawerTitleItem.a();
        if (pVarA != null) {
            pVarA.invoke("normal", sidebarSession);
        }
    }

    public static final boolean h(E e10, View view) {
        p9.r<? super View, ? super SidebarSession, ? super Float, ? super Float, Y8.t> rVar = e10.onLongClickListener;
        if (rVar != null) {
            View itemView = e10.itemView;
            kotlin.jvm.internal.p.h(itemView, "itemView");
            rVar.invoke(itemView, e10.data, Float.valueOf(e10.lastTouch[0]), Float.valueOf(e10.lastTouch[1]));
        }
        return true;
    }

    public final void d(final DrawerTitleItem<SidebarSession> item, SessionActivityState activityState, boolean isLast) {
        kotlin.jvm.internal.p.i(item, "item");
        final SidebarSession sidebarSessionB = item.b();
        if (sidebarSessionB == null) {
            return;
        }
        this.textView.setText(item.getTitle());
        this.itemView.setSelected(item.getIsSelected());
        int iA = 0;
        this.contentView.setBackgroundResource(item.getIsSelected() ? R$drawable.bg_drawer_item_selected : 0);
        SessionIndicatorState sessionIndicatorStateA = G.a(activityState, sidebarSessionB.getSendFailed(), !sidebarSessionB.isRead());
        m(sessionIndicatorStateA == SessionIndicatorState.RUNNING);
        i(sessionIndicatorStateA);
        this.data = sidebarSessionB;
        this.contentView.setOnTouchListener(new View.OnTouchListener() { // from class: com.stepos.ailauncher.chat.adapter.B
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return E.f(this.f24909a, view, motionEvent);
            }
        });
        this.contentView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.adapter.C
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                E.g(item, sidebarSessionB, view);
            }
        });
        this.contentView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.stepos.ailauncher.chat.adapter.D
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return E.h(this.f24912a, view);
            }
        });
        if (isLast) {
            C5659a c5659a = C5659a.INSTANCE;
            Context context = this.itemView.getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            iA = c5659a.a(context, 16);
        }
        ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null || marginLayoutParams.bottomMargin == iA) {
            return;
        }
        marginLayoutParams.bottomMargin = iA;
        this.itemView.setLayoutParams(marginLayoutParams);
    }

    public final void i(SessionIndicatorState state) {
        int i10;
        switch (b.$EnumSwitchMapping$0[state.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                i10 = R$drawable.dot_session_status_indicator;
                break;
            case 5:
            case 6:
                i10 = 0;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (i10 == 0) {
            this.statusIcon.setVisibility(8);
        } else {
            this.statusIcon.setImageResource(i10);
            this.statusIcon.setVisibility(0);
        }
    }

    public final void j() {
        this.shouldShimmer = false;
        ShimmerTextView shimmerTextView = this.runningShimmer;
        if (shimmerTextView != null) {
            ShimmerTextView.i(shimmerTextView, false, false, 2, null);
        }
    }

    public final void k(boolean active) {
        if (this.drawerActive == active) {
            return;
        }
        this.drawerActive = active;
        n();
    }

    public final void l(p9.r<? super View, ? super SidebarSession, ? super Float, ? super Float, Y8.t> rVar) {
        this.onLongClickListener = rVar;
    }

    public final void m(boolean shimmer) {
        if (this.runningShimmer == null) {
            return;
        }
        this.shouldShimmer = shimmer;
        n();
    }

    public final void n() {
        ShimmerTextView shimmerTextView = this.runningShimmer;
        if (shimmerTextView != null) {
            shimmerTextView.h(this.shouldShimmer, !this.drawerActive);
        }
    }

    public /* synthetic */ E(View view, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
        this(view, (i10 & 2) != 0 ? false : z10);
    }
}
