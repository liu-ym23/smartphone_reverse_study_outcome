package com.stepos.agentframework.chatui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$layout;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import u4.m;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0013R0\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/agentframework/chatui/view/c;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lu4/m$c;", Const.STR_FILE, "LY8/t;", "c", "(Lu4/m$c;)V", "Landroid/widget/ImageView;", "iconView", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "nameView", "Landroid/widget/TextView;", "Lu4/m$c;", "Lkotlin/Function1;", "onPreview", "Lp9/l;", "getOnPreview", "()Lp9/l;", "setOnPreview", "(Lp9/l;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatui.view.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2066c extends FrameLayout {
    private m.FileMessage file;
    private final ImageView iconView;
    private final TextView nameView;
    private InterfaceC5074l<? super m.FileMessage, Y8.t> onPreview;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2066c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.p.i(context, "context");
        LayoutInflater.from(context).inflate(R$layout.item_receive_file_card, (ViewGroup) this, true);
        View viewFindViewById = findViewById(R$id.iv_file_icon);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        this.iconView = (ImageView) viewFindViewById;
        View viewFindViewById2 = findViewById(R$id.tv_file_name);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        this.nameView = (TextView) viewFindViewById2;
        findViewById(R$id.file_card_root).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.view.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2066c.b(this.f23108a, view);
            }
        });
    }

    public static final void b(C2066c c2066c, View view) {
        InterfaceC5074l<? super m.FileMessage, Y8.t> interfaceC5074l;
        m.FileMessage fileMessage = c2066c.file;
        if (fileMessage == null || (interfaceC5074l = c2066c.onPreview) == null) {
            return;
        }
        interfaceC5074l.invoke(fileMessage);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(u4.m.FileMessage r3) {
        /*
            r2 = this;
            java.lang.String r0 = "file"
            kotlin.jvm.internal.p.i(r3, r0)
            r2.file = r3
            java.lang.String r3 = r3.getFileName()
            if (r3 == 0) goto L17
            boolean r0 = La.H.x0(r3)
            if (r0 != 0) goto L14
            goto L15
        L14:
            r3 = 0
        L15:
            if (r3 != 0) goto L19
        L17:
            java.lang.String r3 = "文件"
        L19:
            android.widget.TextView r0 = r2.nameView
            r0.setText(r3)
            android.widget.ImageView r2 = r2.iconView
            com.stepos.agentframework.chatui.Q1 r0 = com.stepos.agentframework.chatui.Q1.INSTANCE
            com.stepos.agentframework.chatcore.utils.g r1 = com.stepos.agentframework.chatcore.utils.g.INSTANCE
            int r3 = r1.f(r3)
            int r3 = r0.b(r3)
            r2.setImageResource(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.view.C2066c.c(u4.m$c):void");
    }

    public final InterfaceC5074l<m.FileMessage, Y8.t> getOnPreview() {
        return this.onPreview;
    }

    public final void setOnPreview(InterfaceC5074l<? super m.FileMessage, Y8.t> interfaceC5074l) {
        this.onPreview = interfaceC5074l;
    }

    public /* synthetic */ C2066c(Context context, AttributeSet attributeSet, int i10, kotlin.jvm.internal.i iVar) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }
}
