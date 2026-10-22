package m5;

import O6.l;
import Z8.C1172u;
import Z8.C1173v;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.agentframework.chatcore.session.ChatHintType;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.agentframework.chatui.AgentChatLayout;
import com.stepos.ailauncher.common.utils.C3202f;
import com.stepos.core.ability.converter.BundleContentBridge;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import h8.C4148a;
import io.ktor.http.LinkHeader;
import java.util.List;
import java.util.Locale;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import u4.AgentMessage;
import u4.m;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J1\u0010 \u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\"\u0010\u0003R\u0014\u0010#\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010$R\u0014\u0010(\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010$¨\u0006)"}, d2 = {"Lm5/a;", "", "<init>", "()V", "", "raw", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "", "f", "(Ljava/lang/String;Landroid/view/View;)Z", "Lcom/stepos/agentframework/chatui/AgentChatLayout;", "e", "(Landroid/view/View;)Lcom/stepos/agentframework/chatui/AgentChatLayout;", "Landroid/view/ViewGroup;", Parameters.ROOT, Const.INTENT_KEY_APIKEY, "(Landroid/view/ViewGroup;)Lcom/stepos/agentframework/chatui/AgentChatLayout;", "layout", "envelope", "echo", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatui/AgentChatLayout;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/stepos/agentframework/chatcore/session/AgentRole;", BundleContentBridge.KEY_ROLE, "", "time", "text", "Lcom/stepos/agentframework/chatcore/intent/e;", "tool", "Lw4/c;", "c", "(Lcom/stepos/agentframework/chatcore/session/AgentRole;JLjava/lang/String;Lcom/stepos/agentframework/chatcore/intent/e;)Lw4/c;", Const.INTENT_KEY_UMID, "TAG", "Ljava/lang/String;", "ENABLED", "Z", "PREFIX_EN", "PREFIX_CN", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: m5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C4899a {
    private static final boolean ENABLED = true;
    public static final C4899a INSTANCE = new C4899a();
    private static final String PREFIX_CN = "##";
    private static final String PREFIX_EN = "#auth";
    private static final String TAG = "AppAutherDebug";

    public final AgentChatLayout a(ViewGroup root) {
        AgentChatLayout agentChatLayoutA;
        if (root instanceof AgentChatLayout) {
            return (AgentChatLayout) root;
        }
        int childCount = root.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = root.getChildAt(i10);
            if (childAt instanceof AgentChatLayout) {
                return (AgentChatLayout) childAt;
            }
            if ((childAt instanceof ViewGroup) && (agentChatLayoutA = a((ViewGroup) childAt)) != null) {
                return agentChatLayoutA;
            }
        }
        return null;
    }

    public final void b(AgentChatLayout layout, String envelope, String echo) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        layout.r(c(AgentRole.USER, jCurrentTimeMillis, echo, null));
        layout.r(c(AgentRole.ASSISTANT, jCurrentTimeMillis + 1, "", new AgentTool("debug-auther-" + System.nanoTime(), null, "debug_auth_required", null, null, null, null, true, null, envelope, null, null, null, 0, false, null, 0, 0L, false, 523642, null)));
    }

    public final ChatMessage c(AgentRole role, long time, String text, AgentTool tool) {
        String lowerCase = role.name().toLowerCase(Locale.ROOT);
        p.h(lowerCase, "toLowerCase(...)");
        ChatMessage chatMessage = new ChatMessage("debug-auther-" + lowerCase + l.DATE_SEPARATOR + System.nanoTime(), "", "", time, role, "", 0, 0, "", null, null, EReplyStatus.COMPLETED, 0, null, null, ChatHintType.NONE, false, null, null, null, 0, null, 4158976, null);
        List<AgentMessage> listS = C1173v.s(new AgentMessage(AgentMessageType.TEXT, null, new m.TextMessage(text, null, 2, null), null, false, false, 58, null));
        if (tool != null) {
            listS.add(new AgentMessage(AgentMessageType.TOOL, null, new m.TextMessage(text, null, 2, null), C1172u.e(tool), false, true, 18, null));
        }
        chatMessage.L(listS);
        return chatMessage;
    }

    public final void d() {
        C4148a.k(TAG, "授权卡调试指令（在 chatview 输入框敲，然后发送）：\n  #auth oauth  [应用名]   → OAuth 卡（oauth_flow，oauth 表）\n  #auth vendor [应用名]   → OAuth 卡（vendor_callback_flow，auth 表）\n  #auth key    [应用名]   → 凭证卡 方式二「去获取」→「完成授权」\n  #auth guide  [应用名]   → 凭证卡 方式三 仅「完成授权」\n  #auth poll              → 起一轮裸轮询（不出卡），在 logcat 观察轮询节奏\n中文简写：##授权 / ##厂商 / ##密匙 / ##引导 / ##轮询\n例：#auth key 百度网盘\n注意：卡片渲染可离线验；点按钮走真实 HTTP，没有 credential-service 环境时\n会 toast「网络异常」并把按钮变成「重新授权」——那是预期表现。", false, 4, null);
    }

    public final AgentChatLayout e(View anchor) {
        Object objB;
        Window window;
        AgentChatLayout agentChatLayoutA;
        Window window2;
        AgentChatLayout agentChatLayoutA2;
        View rootView = anchor != null ? anchor.getRootView() : null;
        ViewGroup viewGroup = rootView instanceof ViewGroup ? (ViewGroup) rootView : null;
        if (viewGroup != null && (agentChatLayoutA2 = INSTANCE.a(viewGroup)) != null) {
            return agentChatLayoutA2;
        }
        Context context = anchor != null ? anchor.getContext() : null;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        View decorView = (activity == null || (window2 = activity.getWindow()) == null) ? null : window2.getDecorView();
        ViewGroup viewGroup2 = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
        if (viewGroup2 != null && (agentChatLayoutA = INSTANCE.a(viewGroup2)) != null) {
            return agentChatLayoutA;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(C3202f.INSTANCE.c());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        Activity activity2 = (Activity) objB;
        View decorView2 = (activity2 == null || (window = activity2.getWindow()) == null) ? null : window.getDecorView();
        ViewGroup viewGroup3 = decorView2 instanceof ViewGroup ? (ViewGroup) decorView2 : null;
        if (viewGroup3 != null) {
            return INSTANCE.a(viewGroup3);
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0177, code lost:
    
        if (r3.equals("vendor") == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0195, code lost:
    
        r4 = com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherDebugEnvelope.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0197, code lost:
    
        if (r1 != null) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0199, code lost:
    
        r5 = "东方财富";
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x019d, code lost:
    
        r5 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x019e, code lost:
    
        r4 = r4.g(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01a2, code lost:
    
        if (r1 != null) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01a4, code lost:
    
        r1 = "(默认)";
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01a6, code lost:
    
        h8.C4148a.k(m5.C4899a.TAG, "注入调试卡片 cmd=" + r3 + " name=" + r1 + " envelopeLen=" + r4.length(), false, 4, null);
        b(r13, r4, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01d2, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01d3, code lost:
    
        d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01d6, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009f, code lost:
    
        if (r3.equals("poll") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a8, code lost:
    
        if (r3.equals("help") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b2, code lost:
    
        if (r3.equals("轮询") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b5, code lost:
    
        com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherDebugEnvelope.f(com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherDebugEnvelope.INSTANCE, 0, 1, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00bc, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c4, code lost:
    
        if (r3.equals("帮助") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00cb, code lost:
    
        if (r3.equals("") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ec, code lost:
    
        if (r3.equals("oauth") == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00f6, code lost:
    
        if (r3.equals("guide") == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0101, code lost:
    
        if (r3.equals("授权") == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0105, code lost:
    
        r4 = com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherDebugEnvelope.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0107, code lost:
    
        if (r1 != null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x010a, code lost:
    
        r5 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x010b, code lost:
    
        r4 = r4.d(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0118, code lost:
    
        if (r3.equals("引导") == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x011b, code lost:
    
        r4 = com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherDebugEnvelope.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x011d, code lost:
    
        if (r1 != null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x011f, code lost:
    
        r5 = "微博";
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0123, code lost:
    
        r5 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0124, code lost:
    
        r4 = r4.c(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0131, code lost:
    
        if (r3.equals("密钥") == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x013b, code lost:
    
        if (r3.equals("密匙") == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0145, code lost:
    
        if (r3.equals("凭证") == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x014f, code lost:
    
        if (r3.equals("厂商") == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0159, code lost:
    
        if (r3.equals("东财") == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0162, code lost:
    
        if (r3.equals("key") == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0165, code lost:
    
        r4 = com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherDebugEnvelope.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0167, code lost:
    
        if (r1 != null) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x016a, code lost:
    
        r5 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x016b, code lost:
    
        r4 = r4.a(r5);
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(java.lang.String r12, android.view.View r13) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 518
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m5.C4899a.f(java.lang.String, android.view.View):boolean");
    }
}
