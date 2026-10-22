package com.stepos.ailauncher.chat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.adapter.S;
import com.stepos.ailauncher.chat.view.SidebarAgentItem;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;
import v5.C5659a;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001b\u001cB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/f0;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "Lcom/stepos/ailauncher/chat/adapter/f0$a;", "callbacks", "<init>", "(Landroid/view/View;Lcom/stepos/ailauncher/chat/adapter/f0$a;)V", "Lcom/stepos/ailauncher/chat/adapter/S$f$b;", "row", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/ailauncher/chat/adapter/S$f$b;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()V", "Lcom/stepos/ailauncher/chat/adapter/f0$a;", "Lcom/stepos/ailauncher/chat/view/s8;", "agent", "Lcom/stepos/ailauncher/chat/view/s8;", "", "interactive", "Z", "", "lastTouchRawX", "F", "lastTouchRawY", "Companion", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class f0 extends RecyclerView.ViewHolder {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int HORIZONTAL_INSET_DP = 16;
    private SidebarAgentItem agent;
    private final a callbacks;
    private boolean interactive;
    private float lastTouchRawX;
    private float lastTouchRawY;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/f0$a;", "", "Lcom/stepos/ailauncher/chat/view/s8;", "agent", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/chat/view/s8;)V", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "", "rawX", "rawY", "", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;Lcom/stepos/ailauncher/chat/view/s8;FF)Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
        boolean a(View anchor, SidebarAgentItem agent, float rawX, float rawY);

        void b(SidebarAgentItem agent);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/f0$b;", "", "<init>", "()V", "Landroid/view/ViewGroup;", "parent", "Lcom/stepos/ailauncher/chat/adapter/f0$a;", "callbacks", "", "horizontalInset", "Lcom/stepos/ailauncher/chat/adapter/f0;", Const.INTENT_KEY_APIKEY, "(Landroid/view/ViewGroup;Lcom/stepos/ailauncher/chat/adapter/f0$a;Z)Lcom/stepos/ailauncher/chat/adapter/f0;", "", "HORIZONTAL_INSET_DP", "I", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.adapter.f0$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final f0 a(ViewGroup parent, a callbacks, boolean horizontalInset) {
            kotlin.jvm.internal.p.i(parent, "parent");
            kotlin.jvm.internal.p.i(callbacks, "callbacks");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(b0.INSTANCE.b(), parent, false);
            kotlin.jvm.internal.i iVar = null;
            if (horizontalInset) {
                ViewGroup.LayoutParams layoutParams = viewInflate.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
                if (marginLayoutParams != null) {
                    C5659a c5659a = C5659a.INSTANCE;
                    Context context = viewInflate.getContext();
                    kotlin.jvm.internal.p.h(context, "getContext(...)");
                    int iA = c5659a.a(context, 16);
                    marginLayoutParams.setMarginStart(iA);
                    marginLayoutParams.setMarginEnd(iA);
                }
            }
            kotlin.jvm.internal.p.f(viewInflate);
            return new f0(viewInflate, callbacks, iVar);
        }

        public Companion() {
        }
    }

    public /* synthetic */ f0(View view, a aVar, kotlin.jvm.internal.i iVar) {
        this(view, aVar);
    }

    public static final void d(f0 f0Var, View view) {
        SidebarAgentItem sidebarAgentItem = f0Var.agent;
        if (sidebarAgentItem != null) {
            if (!f0Var.interactive) {
                sidebarAgentItem = null;
            }
            if (sidebarAgentItem == null) {
                return;
            }
            f0Var.callbacks.b(sidebarAgentItem);
        }
    }

    public static final boolean e(f0 f0Var, View view, MotionEvent motionEvent) {
        f0Var.lastTouchRawX = motionEvent.getRawX();
        f0Var.lastTouchRawY = motionEvent.getRawY();
        return false;
    }

    public static final boolean f(f0 f0Var, View view) {
        SidebarAgentItem sidebarAgentItem = f0Var.agent;
        if (sidebarAgentItem == null) {
            return false;
        }
        if (!f0Var.interactive || sidebarAgentItem.getIsPrimary()) {
            sidebarAgentItem = null;
        }
        if (sidebarAgentItem == null) {
            return false;
        }
        a aVar = f0Var.callbacks;
        kotlin.jvm.internal.p.f(view);
        return aVar.a(view, sidebarAgentItem, f0Var.lastTouchRawX, f0Var.lastTouchRawY);
    }

    public final void g(S.f.AgentRow row) {
        kotlin.jvm.internal.p.i(row, "row");
        this.agent = row.getAgent();
        boolean z10 = !row.getUninstalling();
        this.interactive = z10;
        this.itemView.setClickable(z10);
        this.itemView.setLongClickable(this.interactive && !row.getAgent().getIsPrimary());
        b0 b0Var = b0.INSTANCE;
        View itemView = this.itemView;
        kotlin.jvm.internal.p.h(itemView, "itemView");
        b0Var.a(itemView, row.getAgent(), row.getSelected(), row.getUninstalling());
    }

    public final void h() {
        this.agent = null;
        this.interactive = false;
    }

    public f0(View view, a aVar) {
        super(view);
        this.callbacks = aVar;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.adapter.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                f0.d(this.f24932a, view2);
            }
        });
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.stepos.ailauncher.chat.adapter.d0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return f0.e(this.f24935a, view2, motionEvent);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.stepos.ailauncher.chat.adapter.e0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                return f0.f(this.f24938a, view2);
            }
        });
    }
}
