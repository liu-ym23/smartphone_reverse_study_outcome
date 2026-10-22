package com.stepos.ailauncher.chat.view;

import Z8.C1173v;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.model.ActionBar;
import com.stepos.ailauncher.chat.model.ActionBarConfig;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import y4.InterfaceC5940b;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u000201B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0010\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\fR\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R0\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R6\u0010-\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\n\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010(\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,¨\u00062"}, d2 = {"Lcom/stepos/ailauncher/chat/view/ActionView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LY8/t;", "c", "()V", "", "Lcom/stepos/ailauncher/chat/model/ActionBar;", "actions", "f", "(Ljava/util/List;)V", "Lcom/stepos/ailauncher/chat/model/ActionBarConfig;", "config", "e", "(Lcom/stepos/ailauncher/chat/model/ActionBarConfig;)V", Const.INTENT_KEY_UMID, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "listItemLayoutId", "I", "getListItemLayoutId", "()I", "setListItemLayoutId", "(I)V", "Lcom/stepos/ailauncher/chat/view/ActionView$a;", "adapter", "Lcom/stepos/ailauncher/chat/view/ActionView$a;", "Ly4/b;", "boundInputComponent", "Ly4/b;", "Lkotlin/Function1;", "onActionClickListener", "Lp9/l;", "getOnActionClickListener", "()Lp9/l;", "setOnActionClickListener", "(Lp9/l;)V", "onDataFilledCallback", "getOnDataFilledCallback", "setOnDataFilledCallback", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ActionView extends FrameLayout {
    private final a adapter;
    private InterfaceC5940b boundInputComponent;
    private int listItemLayoutId;
    private InterfaceC5074l<? super ActionBar, Y8.t> onActionClickListener;
    private InterfaceC5074l<? super List<ActionBar>, Y8.t> onDataFilledCallback;
    private final RecyclerView recyclerView;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0016B#\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/chat/view/ActionView$a;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/stepos/ailauncher/chat/model/ActionBar;", "Lcom/stepos/ailauncher/chat/view/ActionView$b;", "", "listItemLayoutId", "Lkotlin/Function1;", "LY8/t;", "onItemClick", "<init>", "(ILp9/l;)V", "Landroid/view/ViewGroup;", "parent", "viewType", Const.INTENT_KEY_UMID, "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/chat/view/ActionView$b;", "holder", "position", "c", "(Lcom/stepos/ailauncher/chat/view/ActionView$b;I)V", "I", "Lp9/l;", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends ListAdapter<ActionBar, b> {
        private final int listItemLayoutId;
        private final InterfaceC5074l<ActionBar, Y8.t> onItemClick;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/chat/view/ActionView$a$a;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/stepos/ailauncher/chat/model/ActionBar;", "<init>", "()V", "oldItem", "newItem", "", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/chat/model/ActionBar;Lcom/stepos/ailauncher/chat/model/ActionBar;)Z", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.chat.view.ActionView$a$a, reason: collision with other inner class name */
        public static final class C0295a extends DiffUtil.ItemCallback<ActionBar> {
            public static final C0295a INSTANCE = new C0295a();

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean areContentsTheSame(ActionBar oldItem, ActionBar newItem) {
                kotlin.jvm.internal.p.i(oldItem, "oldItem");
                kotlin.jvm.internal.p.i(newItem, "newItem");
                return kotlin.jvm.internal.p.d(oldItem, newItem);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public boolean areItemsTheSame(ActionBar oldItem, ActionBar newItem) {
                kotlin.jvm.internal.p.i(oldItem, "oldItem");
                kotlin.jvm.internal.p.i(newItem, "newItem");
                String name = oldItem.getName();
                if (name == null) {
                    name = "";
                }
                String label = oldItem.getLabel();
                if (label == null) {
                    label = "";
                }
                String str = name + Const.STR_MART_WELL + label;
                String name2 = newItem.getName();
                if (name2 == null) {
                    name2 = "";
                }
                String label2 = newItem.getLabel();
                return kotlin.jvm.internal.p.d(str, name2 + Const.STR_MART_WELL + (label2 != null ? label2 : ""));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(int i10, InterfaceC5074l<? super ActionBar, Y8.t> onItemClick) {
            super(C0295a.INSTANCE);
            kotlin.jvm.internal.p.i(onItemClick, "onItemClick");
            this.listItemLayoutId = i10;
            this.onItemClick = onItemClick;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(b holder, int position) {
            kotlin.jvm.internal.p.i(holder, "holder");
            ActionBar item = getItem(position);
            kotlin.jvm.internal.p.h(item, "getItem(...)");
            holder.b(item);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(ViewGroup parent, int viewType) {
            kotlin.jvm.internal.p.i(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(this.listItemLayoutId, parent, false);
            kotlin.jvm.internal.p.f(viewInflate);
            return new b(viewInflate, this.onItemClick);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fR \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/chat/view/ActionView$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/chat/model/ActionBar;", "LY8/t;", "onItemClick", "<init>", "(Landroid/view/View;Lp9/l;)V", "action", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/chat/model/ActionBar;)V", "Lp9/l;", "Landroid/widget/ImageView;", "ivIcon", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "tvTitle", "Landroid/widget/TextView;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends RecyclerView.ViewHolder {
        private final ImageView ivIcon;
        private final InterfaceC5074l<ActionBar, Y8.t> onItemClick;
        private final TextView tvTitle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(View itemView, InterfaceC5074l<? super ActionBar, Y8.t> onItemClick) {
            super(itemView);
            kotlin.jvm.internal.p.i(itemView, "itemView");
            kotlin.jvm.internal.p.i(onItemClick, "onItemClick");
            this.onItemClick = onItemClick;
            View viewFindViewById = itemView.findViewById(R$id.iv_action_icon);
            kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
            this.ivIcon = (ImageView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R$id.tv_action_title);
            kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
            this.tvTitle = (TextView) viewFindViewById2;
        }

        public static final void c(b bVar, ActionBar actionBar, View view) {
            bVar.onItemClick.invoke(actionBar);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void b(final com.stepos.ailauncher.chat.model.ActionBar r26) {
            /*
                r25 = this;
                r0 = r25
                r1 = r26
                java.lang.String r2 = "action"
                kotlin.jvm.internal.p.i(r1, r2)
                android.widget.TextView r2 = r0.tvTitle
                java.lang.String r3 = r1.getName()
                if (r3 == 0) goto L1c
                boolean r4 = La.H.x0(r3)
                if (r4 != 0) goto L18
                goto L19
            L18:
                r3 = 0
            L19:
                if (r3 == 0) goto L1c
                goto L1e
            L1c:
                java.lang.String r3 = ""
            L1e:
                r2.setText(r3)
                java.lang.String r5 = r1.getIcon()
                if (r5 == 0) goto L61
                int r2 = r5.length()
                if (r2 != 0) goto L2e
                goto L61
            L2e:
                com.stepos.ailauncher.common.imageloader.g r2 = com.stepos.ailauncher.common.imageloader.g.INSTANCE
                android.widget.ImageView r3 = r0.ivIcon
                com.stepos.ailauncher.common.imageloader.i r4 = new com.stepos.ailauncher.common.imageloader.i
                int r6 = com.stepos.ailauncher.chat.R$drawable.ic_new_chat
                com.stepos.ailauncher.common.imageloader.DiskCache r20 = com.stepos.ailauncher.common.imageloader.DiskCache.ALL
                r23 = 229368(0x37ff8, float:3.21413E-40)
                r24 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r15 = 0
                r16 = 0
                r17 = 0
                r18 = 0
                r19 = 0
                r21 = 0
                r22 = 0
                r7 = r6
                r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
                r12 = 28
                r13 = 0
                r10 = 0
                r11 = 0
                r6 = r2
                r7 = r3
                r8 = r4
                com.stepos.ailauncher.common.imageloader.g.s(r6, r7, r8, r9, r10, r11, r12, r13)
                goto L68
            L61:
                android.widget.ImageView r2 = r0.ivIcon
                int r3 = com.stepos.ailauncher.chat.R$drawable.ic_new_chat
                r2.setImageResource(r3)
            L68:
                android.view.View r2 = r0.itemView
                com.stepos.ailauncher.chat.view.b r3 = new com.stepos.ailauncher.chat.view.b
                r3.<init>()
                r2.setOnClickListener(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.ActionView.b.b(com.stepos.ailauncher.chat.model.ActionBar):void");
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"com/stepos/ailauncher/chat/view/ActionView$c", "Landroidx/recyclerview/widget/RecyclerView$SimpleOnItemTouchListener;", "Landroidx/recyclerview/widget/RecyclerView;", "rv", "Landroid/view/MotionEvent;", "e", "", "onInterceptTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)Z", "", "startX", "F", "startY", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends RecyclerView.SimpleOnItemTouchListener {
        private float startX;
        private float startY;

        /* JADX WARN: Removed duplicated region for block: B:21:0x005b  */
        @Override // androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onInterceptTouchEvent(androidx.recyclerview.widget.RecyclerView r5, android.view.MotionEvent r6) {
            /*
                r4 = this;
                java.lang.String r0 = "rv"
                kotlin.jvm.internal.p.i(r5, r0)
                java.lang.String r0 = "e"
                kotlin.jvm.internal.p.i(r6, r0)
                int r0 = r6.getActionMasked()
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L63
                if (r0 == r1) goto L5b
                r3 = 2
                if (r0 == r3) goto L1c
                r4 = 3
                if (r0 == r4) goto L5b
                goto L76
            L1c:
                float r0 = r6.getX()
                float r3 = r4.startX
                float r0 = r0 - r3
                float r6 = r6.getY()
                float r4 = r4.startY
                float r6 = r6 - r4
                float r4 = java.lang.Math.abs(r0)
                float r6 = java.lang.Math.abs(r6)
                int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r4 <= 0) goto L53
                r4 = 0
                int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r6 <= 0) goto L41
                r4 = -1
                boolean r4 = r5.canScrollHorizontally(r4)
                goto L4b
            L41:
                int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r4 >= 0) goto L4a
                boolean r4 = r5.canScrollHorizontally(r1)
                goto L4b
            L4a:
                r4 = r2
            L4b:
                android.view.ViewParent r5 = r5.getParent()
                r5.requestDisallowInterceptTouchEvent(r4)
                goto L76
            L53:
                android.view.ViewParent r4 = r5.getParent()
                r4.requestDisallowInterceptTouchEvent(r2)
                goto L76
            L5b:
                android.view.ViewParent r4 = r5.getParent()
                r4.requestDisallowInterceptTouchEvent(r2)
                goto L76
            L63:
                float r0 = r6.getX()
                r4.startX = r0
                float r6 = r6.getY()
                r4.startY = r6
                android.view.ViewParent r4 = r5.getParent()
                r4.requestDisallowInterceptTouchEvent(r1)
            L76:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.ActionView.c.onInterceptTouchEvent(androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent):boolean");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public static final Y8.t b(ActionView actionView, ActionBar actionBar) {
        kotlin.jvm.internal.p.i(actionBar, "actionBar");
        InterfaceC5074l<? super ActionBar, Y8.t> interfaceC5074l = actionView.onActionClickListener;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(actionBar);
        }
        return Y8.t.f7040a;
    }

    public final void c() {
        this.adapter.notifyDataSetChanged();
    }

    public final void d() {
        this.recyclerView.addOnItemTouchListener(new c());
    }

    public final void e(ActionBarConfig config) {
        List<ActionBar> bars = config != null ? config.getBars() : null;
        if (bars == null) {
            bars = C1173v.m();
        }
        f(bars);
    }

    public final void f(List<ActionBar> actions) {
        kotlin.jvm.internal.p.i(actions, "actions");
        this.adapter.submitList(actions);
        setVisibility(actions.isEmpty() ? 8 : 0);
        Log.d("ActionView", "submitActions: " + actions.size());
        InterfaceC5074l<? super List<ActionBar>, Y8.t> interfaceC5074l = this.onDataFilledCallback;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(actions);
        }
    }

    public final int getListItemLayoutId() {
        return this.listItemLayoutId;
    }

    public final InterfaceC5074l<ActionBar, Y8.t> getOnActionClickListener() {
        return this.onActionClickListener;
    }

    public final InterfaceC5074l<List<ActionBar>, Y8.t> getOnDataFilledCallback() {
        return this.onDataFilledCallback;
    }

    public final void setListItemLayoutId(int i10) {
        this.listItemLayoutId = i10;
    }

    public final void setOnActionClickListener(InterfaceC5074l<? super ActionBar, Y8.t> interfaceC5074l) {
        this.onActionClickListener = interfaceC5074l;
    }

    public final void setOnDataFilledCallback(InterfaceC5074l<? super List<ActionBar>, Y8.t> interfaceC5074l) {
        this.onDataFilledCallback = interfaceC5074l;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        int i11 = R$layout.item_chat_action;
        this.listItemLayoutId = i11;
        a aVar = new a(i11, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ActionView.b(this.f26055a, (ActionBar) obj);
            }
        });
        this.adapter = aVar;
        LayoutInflater.from(context).inflate(R$layout.view_action_list, (ViewGroup) this, true);
        View viewFindViewById = findViewById(R$id.rv_actions);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById;
        this.recyclerView = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        recyclerView.setAdapter(aVar);
        setVisibility(8);
        d();
    }

    public /* synthetic */ ActionView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
