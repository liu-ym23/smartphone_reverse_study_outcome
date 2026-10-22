package com.stepos.agentframework.chatui.folder;

import La.H;
import Ua.C1060i;
import Y8.t;
import Z8.C1165m;
import Z8.C1173v;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.R$drawable;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$layout;
import com.stepos.agentframework.R$style;
import com.stepos.agentframework.chatui.AgentFileSyncBridge;
import com.stepos.agentframework.chatui.Q1;
import com.stepos.agentframework.chatui.folder.FolderTreeSheet;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.FolderNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.p;
import p9.r;
import u4.m;
import v9.C5685n;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001'B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001cR \u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u001e0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010%\u001a\u00060$R\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/stepos/agentframework/chatui/folder/FolderTreeSheet;", "Landroid/app/Dialog;", "Landroid/content/Context;", "context", "Lu4/m$d;", "folder", "<init>", "(Landroid/content/Context;Lu4/m$d;)V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "onBackPressed", "()V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "k", "ctx", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/content/Context;)Z", "LK6/t;", "node", "", "f", "(LK6/t;)I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(LK6/t;)V", "Lu4/m$d;", "LZ8/m;", "", "stack", "LZ8/m;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/stepos/agentframework/chatui/folder/FolderTreeSheet$a;", "adapter", "Lcom/stepos/agentframework/chatui/folder/FolderTreeSheet$a;", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FolderTreeSheet extends Dialog {
    private final a adapter;
    private final m.FolderMessage folder;
    private RecyclerView recyclerView;
    private final C1165m<List<FolderNode>> stack;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0010\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0016\u001a\u00020\t2\u000e\u0010\u0014\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0018j\b\u0012\u0004\u0012\u00020\u0007`\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/stepos/agentframework/chatui/folder/FolderTreeSheet$a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/agentframework/chatui/folder/FolderTreeSheet$a$a;", "Lcom/stepos/agentframework/chatui/folder/FolderTreeSheet;", "<init>", "(Lcom/stepos/agentframework/chatui/folder/FolderTreeSheet;)V", "", "LK6/t;", "nodes", "LY8/t;", "e", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", Const.INTENT_KEY_UMID, "(Landroid/view/ViewGroup;I)Lcom/stepos/agentframework/chatui/folder/FolderTreeSheet$a$a;", "getItemCount", "()I", "holder", "position", "c", "(Lcom/stepos/agentframework/chatui/folder/FolderTreeSheet$a$a;I)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", DidiCardProvider.KEY_ITEMS, "Ljava/util/ArrayList;", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class a extends RecyclerView.Adapter<C0252a> {
        private final ArrayList<FolderNode> items = new ArrayList<>();

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/agentframework/chatui/folder/FolderTreeSheet$a$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/stepos/agentframework/chatui/folder/FolderTreeSheet$a;Landroid/view/View;)V", "LK6/t;", "node", "", "isLast", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(LK6/t;Z)V", "Landroid/widget/ImageView;", "icon", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "name", "Landroid/widget/TextView;", "chevron", "divider", "Landroid/view/View;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.agentframework.chatui.folder.FolderTreeSheet$a$a, reason: collision with other inner class name */
        public final class C0252a extends RecyclerView.ViewHolder {
            private final ImageView chevron;
            private final View divider;
            private final ImageView icon;
            private final TextView name;
            final /* synthetic */ a this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0252a(a aVar, View itemView) {
                super(itemView);
                p.i(itemView, "itemView");
                this.this$0 = aVar;
                View viewFindViewById = itemView.findViewById(R$id.iv_node_icon);
                p.h(viewFindViewById, "findViewById(...)");
                this.icon = (ImageView) viewFindViewById;
                View viewFindViewById2 = itemView.findViewById(R$id.tv_node_name);
                p.h(viewFindViewById2, "findViewById(...)");
                this.name = (TextView) viewFindViewById2;
                View viewFindViewById3 = itemView.findViewById(R$id.iv_node_chevron);
                p.h(viewFindViewById3, "findViewById(...)");
                this.chevron = (ImageView) viewFindViewById3;
                View viewFindViewById4 = itemView.findViewById(R$id.v_node_divider);
                p.h(viewFindViewById4, "findViewById(...)");
                this.divider = viewFindViewById4;
            }

            public static final void c(FolderTreeSheet folderTreeSheet, FolderNode folderNode, View view) {
                folderTreeSheet.j(folderNode);
            }

            public final void b(final FolderNode node, boolean isLast) {
                p.i(node, "node");
                this.icon.setImageResource(FolderTreeSheet.this.f(node));
                TextView textView = this.name;
                String name = node.getName();
                if (H.x0(name) && (name = node.getFileName()) == null) {
                    name = "";
                }
                textView.setText(name);
                this.chevron.setVisibility(0);
                this.divider.setVisibility(isLast ? 8 : 0);
                View view = this.itemView;
                final FolderTreeSheet folderTreeSheet = FolderTreeSheet.this;
                view.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.folder.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        FolderTreeSheet.a.C0252a.c(folderTreeSheet, node, view2);
                    }
                });
            }
        }

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(C0252a holder, int position) {
            p.i(holder, "holder");
            FolderNode folderNode = this.items.get(position);
            p.h(folderNode, "get(...)");
            holder.b(folderNode, position == this.items.size() - 1);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public C0252a onCreateViewHolder(ViewGroup parent, int viewType) {
            p.i(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_folder_tree_node, parent, false);
            p.f(viewInflate);
            return new C0252a(this, viewInflate);
        }

        public final void e(List<FolderNode> nodes) {
            p.i(nodes, "nodes");
            this.items.clear();
            this.items.addAll(nodes);
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.items.size();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FolderTreeSheet(Context context, m.FolderMessage folder) {
        super(context, R$style.Theme_FolderSheet);
        p.i(context, "context");
        p.i(folder, "folder");
        this.folder = folder;
        this.stack = new C1165m<>();
        this.adapter = new a();
    }

    public static final void i(FolderTreeSheet folderTreeSheet, View view) {
        folderTreeSheet.dismiss();
    }

    public static final boolean l(Ref$FloatRef ref$FloatRef, Ref$BooleanRef ref$BooleanRef, int i10, View view, final FolderTreeSheet folderTreeSheet, View view2, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            ref$FloatRef.f34817a = motionEvent.getRawY();
            ref$BooleanRef.f34815a = false;
            return true;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                float rawY = motionEvent.getRawY() - ref$FloatRef.f34817a;
                if (!ref$BooleanRef.f34815a && rawY > i10) {
                    ref$BooleanRef.f34815a = true;
                }
                if (ref$BooleanRef.f34815a) {
                    view.setTranslationY(C5685n.e(rawY, 0.0f));
                }
                return true;
            }
            if (actionMasked != 3) {
                return false;
            }
        }
        if (view.getTranslationY() > view.getHeight() * 0.2f) {
            view.animate().translationY(view.getHeight()).setDuration(180L).withEndAction(new Runnable() { // from class: com.stepos.agentframework.chatui.folder.c
                @Override // java.lang.Runnable
                public final void run() {
                    FolderTreeSheet.m(this.f22960a);
                }
            }).start();
        } else {
            view.animate().translationY(0.0f).setDuration(180L).start();
        }
        ref$BooleanRef.f34815a = false;
        return true;
    }

    public static final void m(FolderTreeSheet folderTreeSheet) {
        folderTreeSheet.dismiss();
    }

    public final int f(FolderNode node) {
        if (node.g()) {
            return R$drawable.ic_folder_line_folder;
        }
        Q1 q12 = Q1.INSTANCE;
        String fileName = node.getFileName();
        if (fileName == null) {
            fileName = node.getName();
        }
        return q12.a(fileName);
    }

    public final boolean g(Context ctx) {
        while (ctx instanceof ContextWrapper) {
            if (ctx instanceof Activity) {
                return true;
            }
            ctx = ((ContextWrapper) ctx).getBaseContext();
        }
        return false;
    }

    public final void h() {
        if (this.stack.size() <= 1) {
            dismiss();
        } else {
            this.stack.removeLast();
            this.adapter.e(this.stack.last());
        }
    }

    public final void j(FolderNode node) {
        r<Context, AgentFileSyncBridge.Result, String, String, t> rVarC;
        if (!node.g()) {
            String fileId = node.getFileId();
            if (fileId == null || H.x0(fileId) || (rVarC = AgentFileSyncBridge.c()) == null) {
                return;
            }
            C1060i.d(kotlinx.coroutines.d.b(), null, null, new FolderTreeSheet$onNodeClick$1(fileId, this, rVarC, null), 3, null);
            return;
        }
        C1165m<List<FolderNode>> c1165m = this.stack;
        List<FolderNode> listC = node.c();
        if (listC == null) {
            listC = C1173v.m();
        }
        c1165m.addLast(listC);
        a aVar = this.adapter;
        List<FolderNode> listC2 = node.c();
        if (listC2 == null) {
            listC2 = C1173v.m();
        }
        aVar.e(listC2);
    }

    public final void k() {
        final View viewFindViewById = findViewById(R$id.folder_sheet_panel);
        View viewFindViewById2 = findViewById(R$id.folder_drag_zone);
        final int scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        viewFindViewById2.setOnTouchListener(new View.OnTouchListener() { // from class: com.stepos.agentframework.chatui.folder.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return FolderTreeSheet.l(ref$FloatRef, ref$BooleanRef, scaledTouchSlop, viewFindViewById, this, view, motionEvent);
            }
        });
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        h();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R$layout.dialog_folder_tree);
        Window window = getWindow();
        if (window != null) {
            Context context = window.getContext();
            p.h(context, "getContext(...)");
            if (!g(context)) {
                window.setType(2038);
            }
            window.setLayout(-1, -1);
        }
        View viewFindViewById = findViewById(R$id.rv_folder_nodes);
        p.h(viewFindViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById;
        this.recyclerView = recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            p.A("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            p.A("recyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        recyclerView2.setAdapter(this.adapter);
        findViewById(R$id.folder_sheet_scrim).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.folder.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FolderTreeSheet.i(this.f22954a, view);
            }
        });
        k();
        this.stack.addLast(this.folder.n());
        this.adapter.e(this.folder.n());
    }
}
