package com.stepos.agentframework.chatui.view;

import Ua.C1060i;
import Ua.L0;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.R$color;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$layout;
import com.stepos.agentframework.chatui.AgentFileSyncBridge;
import com.stepos.agentframework.uikit.AIMDTextView;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import e9.InterfaceC4014c;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import u4.m;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 62\u00020\u0001:\u00017B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0018\u0010\u0012J\u0017\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001a\u0010\u0017J\u000f\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010 R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010 R\u0018\u0010)\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010+\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00101R\u0016\u00103\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010*R\u0018\u00104\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105¨\u00068"}, d2 = {"Lcom/stepos/agentframework/chatui/view/AssistantDocumentCardView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lu4/m$c;", Const.STR_FILE, "", "initiallyExpanded", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lu4/m$c;Z)V", "l", "()Z", "onDetachedFromWindow", "()V", "m", "", "md", "o", "(Ljava/lang/String;)V", "n", "text", "p", "LUa/M;", "k", "()LUa/M;", "Landroid/widget/TextView;", "titleView", "Landroid/widget/TextView;", "Landroid/widget/FrameLayout;", "bodyContainer", "Landroid/widget/FrameLayout;", "viewFullView", "Lcom/stepos/agentframework/uikit/AIMDTextView;", "mdBody", "Lcom/stepos/agentframework/uikit/AIMDTextView;", "statusText", "fileId", "Ljava/lang/String;", "sessionId", "markdown", "Lcom/stepos/agentframework/chatui/AgentFileSyncBridge$a;", "syncResult", "Lcom/stepos/agentframework/chatui/AgentFileSyncBridge$a;", ChatTracker.PREVIEW_LOADING, "Z", "isCode", "codeLang", "scope", "LUa/M;", "Companion", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AssistantDocumentCardView extends LinearLayout {
    private static final a Companion = new a(null);
    private static final float DOC_BODY_LINE_MULT = 1.3333334f;
    private static final float DOC_BODY_TEXT_SP = 12.0f;

    @Deprecated
    public static final int MAX_PREVIEW_HEIGHT_DP = 200;

    @Deprecated
    public static final int MAX_PREVIEW_LINES = 10;
    private final FrameLayout bodyContainer;
    private String codeLang;
    private String fileId;
    private boolean isCode;
    private boolean loading;
    private String markdown;
    private AIMDTextView mdBody;
    private Ua.M scope;
    private String sessionId;
    private TextView statusText;
    private AgentFileSyncBridge.Result syncResult;
    private final TextView titleView;
    private final TextView viewFullView;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/stepos/agentframework/chatui/view/AssistantDocumentCardView$a;", "", "<init>", "()V", "", "MAX_PREVIEW_LINES", "I", "MAX_PREVIEW_HEIGHT_DP", "", "DOC_BODY_TEXT_SP", "F", "DOC_BODY_LINE_MULT", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssistantDocumentCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.p.i(context, "context");
        this.codeLang = "";
        setOrientation(1);
        LayoutInflater.from(context).inflate(R$layout.item_receive_doc_card, (ViewGroup) this, true);
        View viewFindViewById = findViewById(R$id.tv_doc_title);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        this.titleView = (TextView) viewFindViewById;
        View viewFindViewById2 = findViewById(R$id.doc_card_body);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        this.bodyContainer = (FrameLayout) viewFindViewById2;
        View viewFindViewById3 = findViewById(R$id.tv_doc_view_full);
        kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById3;
        this.viewFullView = textView;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AssistantDocumentCardView.b(this.f23106a, view);
            }
        };
        findViewById(R$id.doc_card_header).setOnClickListener(onClickListener);
        textView.setOnClickListener(onClickListener);
    }

    public static final void b(AssistantDocumentCardView assistantDocumentCardView, View view) {
        assistantDocumentCardView.n();
    }

    public static /* synthetic */ void j(AssistantDocumentCardView assistantDocumentCardView, m.FileMessage fileMessage, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        assistantDocumentCardView.i(fileMessage, z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(u4.m.FileMessage r4, boolean r5) {
        /*
            r3 = this;
            java.lang.String r5 = "file"
            kotlin.jvm.internal.p.i(r4, r5)
            java.lang.String r5 = r4.getFileId()
            r3.fileId = r5
            r5 = 0
            r3.sessionId = r5
            r3.markdown = r5
            r3.syncResult = r5
            r0 = 0
            r3.loading = r0
            java.lang.String r4 = r4.getFileName()
            if (r4 == 0) goto L24
            boolean r1 = La.H.x0(r4)
            if (r1 != 0) goto L22
            r5 = r4
        L22:
            if (r5 != 0) goto L26
        L24:
            java.lang.String r5 = "文档"
        L26:
            android.widget.TextView r4 = r3.titleView
            r4.setText(r5)
            int r4 = com.stepos.agentframework.R$id.iv_doc_icon
            android.view.View r4 = r3.findViewById(r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            com.stepos.agentframework.chatui.Q1 r1 = com.stepos.agentframework.chatui.Q1.INSTANCE
            int r1 = r1.a(r5)
            r4.setImageResource(r1)
            com.stepos.agentframework.chatcore.utils.g r4 = com.stepos.agentframework.chatcore.utils.g.INSTANCE
            int r1 = r4.f(r5)
            r2 = 12
            if (r1 != r2) goto L47
            r0 = 1
        L47:
            r3.isCode = r0
            java.lang.String r4 = r4.a(r5)
            r3.codeLang = r4
            r3.m()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.view.AssistantDocumentCardView.i(u4.m$c, boolean):void");
    }

    public final Ua.M k() {
        Ua.M m10 = this.scope;
        if (m10 != null) {
            return m10;
        }
        Ua.M mA = kotlinx.coroutines.d.a(Ua.Y.c().plus(L0.b(null, 1, null)));
        this.scope = mA;
        return mA;
    }

    public final boolean l() {
        return false;
    }

    public final void m() {
        String str = this.markdown;
        if (str != null) {
            o(str);
            return;
        }
        String str2 = this.fileId;
        p9.p<String, InterfaceC4014c<? super AgentFileSyncBridge.Result>, Object> pVarA = AgentFileSyncBridge.a();
        if (str2 == null || La.H.x0(str2) || pVarA == null) {
            p("暂不支持预览");
        } else {
            if (this.loading) {
                return;
            }
            this.loading = true;
            C1060i.d(k(), null, null, new AssistantDocumentCardView$loadAndRender$2(this, pVarA, str2, null), 3, null);
        }
    }

    public final void n() {
        String str;
        p9.r<Context, AgentFileSyncBridge.Result, String, String, Y8.t> rVarC;
        AgentFileSyncBridge.Result result = this.syncResult;
        if (result == null || (str = this.fileId) == null || (rVarC = AgentFileSyncBridge.c()) == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Context context = getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            rVarC.invoke(context, result, str, this.sessionId);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    public final void o(String md) {
        this.statusText = null;
        AIMDTextView aIMDTextView = this.mdBody;
        if (aIMDTextView == null) {
            Context context = getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            AIMDTextView aIMDTextView2 = new AIMDTextView(context, null, 0, 6, null);
            aIMDTextView2.setTextColor(androidx.core.content.a.c(getContext(), R$color.agent_text_primary));
            aIMDTextView2.S0(2, 12.0f);
            aIMDTextView2.Q0(0.0f, DOC_BODY_LINE_MULT);
            this.mdBody = aIMDTextView2;
            aIMDTextView = aIMDTextView2;
        }
        if (this.bodyContainer.getChildAt(0) != aIMDTextView) {
            this.bodyContainer.removeView(aIMDTextView);
            this.bodyContainer.addView(aIMDTextView, 0);
        }
        String strG1 = La.H.G1(md, '\n');
        int i10 = 0;
        for (int i11 = 0; i11 < strG1.length(); i11++) {
            if (strG1.charAt(i11) == '\n') {
                i10++;
            }
        }
        boolean z10 = i10 + 1 > 10;
        int i12 = (int) (200 * getResources().getDisplayMetrics().density);
        ViewGroup.LayoutParams layoutParams = aIMDTextView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        }
        layoutParams2.width = -1;
        if (!z10) {
            i12 = -2;
        }
        layoutParams2.height = i12;
        aIMDTextView.setLayoutParams(layoutParams2);
        if (this.isCode) {
            md = "```" + this.codeLang + "\n" + La.H.G1(md, '\n') + "\n```";
        }
        aIMDTextView.setMarkdown(md);
        aIMDTextView.X0();
        this.viewFullView.setVisibility(z10 ? 0 : 8);
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

    public final void p(String text) {
        this.viewFullView.setVisibility(8);
        TextView textView = this.statusText;
        if (textView == null) {
            textView = new TextView(getContext());
            textView.setTextSize(14.0f);
            textView.setTextColor(androidx.core.content.a.c(getContext(), R$color.chat_file_subtitle));
            this.statusText = textView;
            this.mdBody = null;
        }
        if (this.bodyContainer.getChildAt(0) != textView) {
            this.bodyContainer.removeView(textView);
            this.bodyContainer.addView(textView, 0);
        }
        textView.setText(text);
    }

    public /* synthetic */ AssistantDocumentCardView(Context context, AttributeSet attributeSet, int i10, kotlin.jvm.internal.i iVar) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }
}
