package com.stepos.agentframework.chatui.view;

import Z8.C1173v;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$layout;
import com.stepos.agentframework.R$string;
import com.stepos.agentframework.chatui.AgentFileSyncBridge;
import com.stepos.agentframework.chatui.folder.FolderTreeSheet;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.List;
import kotlin.C4849c;
import kotlin.FolderNode;
import kotlin.Metadata;
import kotlin.Result;
import u4.m;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0015\u001a\u00020\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentframework/chatui/view/e;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lu4/m$d;", "folder", "LY8/t;", "c", "(Lu4/m$d;)V", "", Parameters.ROOT, "e", "(Ljava/lang/String;)Ljava/lang/String;", "", "LK6/t;", "nodes", "", Const.INTENT_KEY_UMID, "(Ljava/util/List;)I", "Landroid/widget/TextView;", "nameView", "Landroid/widget/TextView;", "countView", "Lu4/m$d;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatui.view.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2070e extends FrameLayout {
    private final TextView countView;
    private m.FolderMessage folder;
    private final TextView nameView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2070e(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.p.i(context, "context");
        LayoutInflater.from(context).inflate(R$layout.item_receive_folder_card, (ViewGroup) this, true);
        View viewFindViewById = findViewById(R$id.tv_folder_name);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        this.nameView = (TextView) viewFindViewById;
        View viewFindViewById2 = findViewById(R$id.tv_folder_count);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        this.countView = (TextView) viewFindViewById2;
        findViewById(R$id.folder_card_root).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.view.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2070e.b(this.f23114a, context, view);
            }
        });
    }

    public static final void b(C2070e c2070e, Context context, View view) {
        m.FolderMessage folderMessage = c2070e.folder;
        if (folderMessage != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                p9.p<Context, m.FolderMessage, Boolean> pVarB = AgentFileSyncBridge.b();
                if (pVarB == null || !pVarB.invoke(context, folderMessage).booleanValue()) {
                    new FolderTreeSheet(context, folderMessage).show();
                }
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    public final void c(m.FolderMessage folder) {
        kotlin.jvm.internal.p.i(folder, "folder");
        this.folder = folder;
        this.nameView.setText(e(folder.getRoot()));
        this.countView.setText(getContext().getString(R$string.chat_folder_file_count, Integer.valueOf(d(folder.n()))));
    }

    public final int d(List<FolderNode> nodes) {
        int iD;
        int i10 = 0;
        for (FolderNode folderNode : nodes) {
            if (folderNode.g()) {
                List<FolderNode> listC = folderNode.c();
                if (listC == null) {
                    listC = C1173v.m();
                }
                iD = d(listC);
            } else {
                iD = 1;
            }
            i10 += iD;
        }
        return i10;
    }

    public final String e(String root) {
        String strG1;
        String strS1 = null;
        if (root != null && (strG1 = La.H.G1(root, JsonPointer.SEPARATOR)) != null) {
            strS1 = La.H.s1(strG1, JsonPointer.SEPARATOR, null, 2, null);
        }
        if (strS1 == null) {
            strS1 = "";
        }
        if (!La.H.x0(strS1)) {
            return strS1;
        }
        String string = getContext().getString(R$string.chat_folder_default_title);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        return string;
    }

    public /* synthetic */ C2070e(Context context, AttributeSet attributeSet, int i10, kotlin.jvm.internal.i iVar) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }
}
