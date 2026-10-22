package com.stepos.agentframework.chatui.view;

import Ua.C1060i;
import Ua.L0;
import Z8.C1172u;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.AgentFileSyncBridge;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import u4.m;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentframework/chatui/view/AssistantImageCardView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lu4/m$c;", Const.STR_FILE, "LY8/t;", "e", "(Lu4/m$c;)V", "onDetachedFromWindow", "()V", "LUa/M;", "f", "()LUa/M;", "Lcom/stepos/agentframework/chatui/view/g;", "imageView", "Lcom/stepos/agentframework/chatui/view/g;", "", "resolvedUrl", "Ljava/lang/String;", "scope", "LUa/M;", "Companion", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AssistantImageCardView extends FrameLayout {
    private static final a Companion = new a(null);

    @Deprecated
    public static final int MAX_HEIGHT_DP = 320;

    @Deprecated
    public static final int MAX_WIDTH_DP = 280;
    private final C2074g imageView;
    private String resolvedUrl;
    private Ua.M scope;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/stepos/agentframework/chatui/view/AssistantImageCardView$a;", "", "<init>", "()V", "", "MAX_WIDTH_DP", "I", "MAX_HEIGHT_DP", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssistantImageCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.p.i(context, "context");
        C2074g c2074g = new C2074g(context, null, 0, 6, null);
        c2074g.g(MAX_WIDTH_DP, 320);
        this.imageView = c2074g;
        addView(c2074g, new FrameLayout.LayoutParams(-2, -2));
        c2074g.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.view.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AssistantImageCardView.b(this.f23118a, view);
            }
        });
    }

    public static final void b(AssistantImageCardView assistantImageCardView, View view) {
        String str = assistantImageCardView.resolvedUrl;
        if (str == null) {
            return;
        }
        com.stepos.agentframework.util.u.INSTANCE.i(assistantImageCardView, C1172u.e(str), 0, true);
    }

    public final void e(m.FileMessage file) {
        p9.p<String, InterfaceC4014c<? super String>, Object> pVarD;
        kotlin.jvm.internal.p.i(file, "file");
        this.resolvedUrl = null;
        C2076h.b(this.imageView, null, MAX_WIDTH_DP, 320, 0.0f, 8, null);
        String fileId = file.getFileId();
        if (fileId == null || (pVarD = AgentFileSyncBridge.d()) == null) {
            return;
        }
        C1060i.d(f(), null, null, new AssistantImageCardView$bind$1(pVarD, fileId, this, null), 3, null);
    }

    public final Ua.M f() {
        Ua.M m10 = this.scope;
        if (m10 != null) {
            return m10;
        }
        Ua.M mA = kotlinx.coroutines.d.a(Ua.Y.c().plus(L0.b(null, 1, null)));
        this.scope = mA;
        return mA;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Ua.M m10 = this.scope;
        if (m10 != null) {
            kotlinx.coroutines.d.e(m10, null, 1, null);
        }
        this.scope = null;
    }

    public /* synthetic */ AssistantImageCardView(Context context, AttributeSet attributeSet, int i10, kotlin.jvm.internal.i iVar) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }
}
