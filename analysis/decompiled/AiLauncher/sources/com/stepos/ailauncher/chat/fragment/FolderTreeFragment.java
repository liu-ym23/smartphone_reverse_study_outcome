package com.stepos.ailauncher.chat.fragment;

import Ua.C1060i;
import Z8.C1165m;
import Z8.C1173v;
import android.content.Context;
import android.os.Bundle;
import android.view.C1398p;
import android.view.LayoutInflater;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.AgentFileSyncBridge;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.fragment.FolderTreeFragment;
import com.stepos.ailauncher.chat.view.C2773b6;
import com.stepos.ailauncher.chat.view.GlassAttachment;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import h8.C4148a;
import java.util.ArrayList;
import java.util.List;
import kotlin.FolderNode;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import u4.m;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 /2\u00020\u0001:\u000201B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR \u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001e0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010%\u001a\u00060$R\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0012R\u0014\u0010*\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0012R\u0014\u0010,\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0012R\u0014\u0010.\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0012¨\u00062"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/FolderTreeFragment;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lkotlin/Function0;", "proceed", "", "l", "(Lp9/a;)Z", "onDestroyView", "G", "()Z", "LK6/t;", "node", "I", "(LK6/t;)V", "", "H", "(LK6/t;)I", "Lu4/m$d;", "folder", "Lu4/m$d;", "LZ8/m;", "", "stack", "LZ8/m;", "Lcom/stepos/ailauncher/chat/view/GlassAttachment;", "rootGlass", "Lcom/stepos/ailauncher/chat/view/GlassAttachment;", "Lcom/stepos/ailauncher/chat/fragment/FolderTreeFragment$b;", "adapter", "Lcom/stepos/ailauncher/chat/fragment/FolderTreeFragment$b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "showsSheetDragHandle", "c", "supportsSheetHalfSettle", "e", "extendsContentToBottomEdge", "m", "hidesResidentInput", "Companion", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FolderTreeFragment extends com.stepos.ailauncher.sheet.nav.a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float ROOT_GLASS_CORNER_DP = 28.0f;
    private static final String TAG = "FolderTreeFragment";
    private static m.FolderMessage pending;
    private final b adapter;
    private m.FolderMessage folder;
    private GlassAttachment rootGlass;
    private final C1165m<List<FolderNode>> stack;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/FolderTreeFragment$a;", "", "<init>", "()V", "Lu4/m$d;", "folder", "Lcom/stepos/ailauncher/chat/fragment/FolderTreeFragment;", Const.INTENT_KEY_APIKEY, "(Lu4/m$d;)Lcom/stepos/ailauncher/chat/fragment/FolderTreeFragment;", "", "TAG", "Ljava/lang/String;", "", "ROOT_GLASS_CORNER_DP", "F", AuthSessionDto.STATUS_PENDING, "Lu4/m$d;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.fragment.FolderTreeFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final FolderTreeFragment a(m.FolderMessage folder) {
            kotlin.jvm.internal.p.i(folder, "folder");
            FolderTreeFragment.pending = folder;
            return new FolderTreeFragment();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0012\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0016\u001a\u00020\t2\u000e\u0010\u0014\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0015\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0018j\b\u0012\u0004\u0012\u00020\u0007`\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/FolderTreeFragment$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/ailauncher/chat/fragment/FolderTreeFragment$b$a;", "Lcom/stepos/ailauncher/chat/fragment/FolderTreeFragment;", "<init>", "(Lcom/stepos/ailauncher/chat/fragment/FolderTreeFragment;)V", "", "LK6/t;", "nodes", "LY8/t;", "e", "(Ljava/util/List;)V", "", "getItemCount", "()I", "Landroid/view/ViewGroup;", "parent", "viewType", Const.INTENT_KEY_UMID, "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/chat/fragment/FolderTreeFragment$b$a;", "holder", "position", "c", "(Lcom/stepos/ailauncher/chat/fragment/FolderTreeFragment$b$a;I)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", DidiCardProvider.KEY_ITEMS, "Ljava/util/ArrayList;", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class b extends RecyclerView.Adapter<a> {
        private final ArrayList<FolderNode> items = new ArrayList<>();

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/FolderTreeFragment$b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/stepos/ailauncher/chat/fragment/FolderTreeFragment$b;Landroid/view/View;)V", "LK6/t;", "node", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(LK6/t;)V", "Landroid/widget/ImageView;", "icon", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "name", "Landroid/widget/TextView;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public final class a extends RecyclerView.ViewHolder {
            private final ImageView icon;
            private final TextView name;
            final /* synthetic */ b this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, View itemView) {
                super(itemView);
                kotlin.jvm.internal.p.i(itemView, "itemView");
                this.this$0 = bVar;
                View viewFindViewById = itemView.findViewById(R$id.iv_node_icon);
                kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
                this.icon = (ImageView) viewFindViewById;
                View viewFindViewById2 = itemView.findViewById(R$id.tv_node_name);
                kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
                this.name = (TextView) viewFindViewById2;
            }

            public static final void c(FolderTreeFragment folderTreeFragment, FolderNode folderNode, View view) {
                folderTreeFragment.I(folderNode);
            }

            public final void b(final FolderNode node) {
                kotlin.jvm.internal.p.i(node, "node");
                this.icon.setImageResource(FolderTreeFragment.this.H(node));
                TextView textView = this.name;
                String name = node.getName();
                if (La.H.x0(name) && (name = node.getFileName()) == null) {
                    name = "";
                }
                textView.setText(name);
                View view = this.itemView;
                final FolderTreeFragment folderTreeFragment = FolderTreeFragment.this;
                view.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.Z1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        FolderTreeFragment.b.a.c(folderTreeFragment, node, view2);
                    }
                });
            }
        }

        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a holder, int position) {
            kotlin.jvm.internal.p.i(holder, "holder");
            FolderNode folderNode = this.items.get(position);
            kotlin.jvm.internal.p.h(folderNode, "get(...)");
            holder.b(folderNode);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public a onCreateViewHolder(ViewGroup parent, int viewType) {
            kotlin.jvm.internal.p.i(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_folder_node, parent, false);
            kotlin.jvm.internal.p.h(viewInflate, "inflate(...)");
            return new a(this, viewInflate);
        }

        public final void e(List<FolderNode> nodes) {
            kotlin.jvm.internal.p.i(nodes, "nodes");
            this.items.clear();
            this.items.addAll(nodes);
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.items.size();
        }
    }

    public FolderTreeFragment() {
        super(R$layout.fragment_folder_tree);
        this.stack = new C1165m<>();
        this.adapter = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float J(View it) {
        kotlin.jvm.internal.p.i(it, "it");
        return 28.0f;
    }

    public static final void K(FolderTreeFragment folderTreeFragment, View view) {
        if (folderTreeFragment.G()) {
            return;
        }
        folderTreeFragment.x();
    }

    public static final void L(FolderTreeFragment folderTreeFragment, View view) {
        folderTreeFragment.x();
    }

    public final boolean G() {
        if (this.stack.size() <= 1) {
            return false;
        }
        this.stack.removeLast();
        this.adapter.e(this.stack.last());
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x015e, code lost:
    
        if (r1.equals("hpp") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0168, code lost:
    
        if (r1.equals(com.stepos.ailauncher.chat.trace.ChatTracker.CONTENT_DOC) == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x016e, code lost:
    
        return com.stepos.agentframework.R$drawable.ic_folder_line_doc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0175, code lost:
    
        if (r1.equals("csv") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x017f, code lost:
    
        if (r1.equals("css") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0189, code lost:
    
        if (r1.equals("cpp") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0194, code lost:
    
        if (r1.equals("ts") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x019f, code lost:
    
        if (r1.equals("sh") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x01aa, code lost:
    
        if (r1.equals("rs") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x01b5, code lost:
    
        if (r1.equals("rb") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x01bf, code lost:
    
        if (r1.equals("py") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x01c8, code lost:
    
        if (r1.equals("md") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x01d1, code lost:
    
        if (r1.equals("kt") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x01da, code lost:
    
        if (r1.equals("js") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
    
        if (r1.equals("markdown") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x01e3, code lost:
    
        if (r1.equals("gz") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x01ec, code lost:
    
        if (r1.equals("go") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x01f5, code lost:
    
        if (r1.equals("cc") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x01fe, code lost:
    
        if (r1.equals("7z") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0203, code lost:
    
        return com.stepos.agentframework.R$drawable.ic_folder_line_zip;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x020a, code lost:
    
        if (r1.equals(com.autonavi.aps.amapapi.config.Const.INTENT_KEY_BACKGROUND_NOTIFICATION) == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0213, code lost:
    
        if (r1.equals("c") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x021a, code lost:
    
        return com.stepos.agentframework.R$drawable.ic_folder_line_code;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
    
        if (r1.equals("swift") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
    
        if (r1.equals("yaml") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0057, code lost:
    
        if (r1.equals("xlsx") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0062, code lost:
    
        if (r1.equals("toml") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006d, code lost:
    
        if (r1.equals("pptx") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0077, code lost:
    
        if (r1.equals("json") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0081, code lost:
    
        if (r1.equals("java") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008b, code lost:
    
        if (r1.equals("html") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0095, code lost:
    
        if (r1.equals("docx") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x009f, code lost:
    
        if (r1.equals("bash") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00aa, code lost:
    
        if (r1.equals("zip") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b5, code lost:
    
        if (r1.equals("yml") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c0, code lost:
    
        if (r1.equals("xml") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00cb, code lost:
    
        if (r1.equals("xls") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d1, code lost:
    
        return com.stepos.agentframework.R$drawable.ic_folder_line_xls;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d9, code lost:
    
        if (r1.equals("txt") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00e4, code lost:
    
        if (r1.equals("tsx") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ef, code lost:
    
        if (r1.equals("tar") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00fa, code lost:
    
        if (r1.equals("sql") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0105, code lost:
    
        if (r1.equals("rar") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0110, code lost:
    
        if (r1.equals(com.stepos.ailauncher.chat.trace.ChatTracker.CONTENT_PPT) == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x011b, code lost:
    
        if (r1.equals("php") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0133, code lost:
    
        if (r1.equals("mjs") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x013d, code lost:
    
        if (r1.equals("key") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0143, code lost:
    
        return com.stepos.agentframework.R$drawable.ic_folder_line_ppt;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x014a, code lost:
    
        if (r1.equals("jsx") == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0154, code lost:
    
        if (r1.equals("htm") == false) goto L159;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int H(kotlin.FolderNode r2) {
        /*
            Method dump skipped, instructions count: 726
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.fragment.FolderTreeFragment.H(K6.t):int");
    }

    public final void I(FolderNode node) {
        p9.r<Context, AgentFileSyncBridge.Result, String, String, Y8.t> rVarC;
        if (node.g()) {
            List<FolderNode> listC = node.c();
            if (listC == null) {
                listC = C1173v.m();
            }
            this.stack.addLast(listC);
            this.adapter.e(listC);
            return;
        }
        String fileId = node.getFileId();
        if (fileId != null) {
            if (La.H.x0(fileId)) {
                fileId = null;
            }
            if (fileId == null || (rVarC = AgentFileSyncBridge.c()) == null) {
                return;
            }
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new FolderTreeFragment$onNodeClick$1(fileId, this, rVarC, null), 3, null);
        }
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean c() {
        return false;
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean e() {
        return true;
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean j() {
        return false;
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean l(InterfaceC5063a<Y8.t> proceed) {
        kotlin.jvm.internal.p.i(proceed, "proceed");
        return G();
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean m() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        GlassAttachment glassAttachment = this.rootGlass;
        if (glassAttachment != null) {
            glassAttachment.n();
        }
        this.rootGlass = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        m.FolderMessage folderMessage = this.folder;
        if (folderMessage == null) {
            folderMessage = pending;
            pending = null;
        }
        this.folder = folderMessage;
        if (folderMessage == null) {
            C4148a.u(TAG, "no folder payload (process restored?), pop", false, 4, null);
            x();
            return;
        }
        this.rootGlass = new GlassAttachment(view, true, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.W1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Float.valueOf(FolderTreeFragment.J((View) obj));
            }
        }, null, null, null, 56, null).t();
        View viewFindViewById = view.findViewById(R$id.iv_folder_back);
        View viewFindViewById2 = view.findViewById(R$id.iv_folder_close);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C2773b6 c2773b6 = new C2773b6(viewLifecycleOwner, false, 2, null);
        kotlin.jvm.internal.p.f(viewFindViewById);
        kotlin.jvm.internal.p.f(viewFindViewById2);
        C2773b6.p(c2773b6, new View[]{viewFindViewById, viewFindViewById2}, null, false, 6, null);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.X1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FolderTreeFragment.K(this.f25227a, view2);
            }
        });
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.Y1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FolderTreeFragment.L(this.f25230a, view2);
            }
        });
        ((TextView) view.findViewById(R$id.tv_folder_title)).setText(R$string.chat_artifacts_title);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.rv_folder_nodes);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(this.adapter);
        this.stack.addLast(folderMessage.n());
        this.adapter.e(folderMessage.n());
    }
}
