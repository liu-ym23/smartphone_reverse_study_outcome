package com.stepos.agentframework.chatui.appui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$layout;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\t\b&\u0018\u00002\u00020\u0001:\u0002:\u000fB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH&¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0010J\r\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0010R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0014\u001a\u0004\b-\u0010\u0016\"\u0004\b.\u0010\u0018R\"\u0010/\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0014\u001a\u0004\b0\u0010\u0016\"\u0004\b1\u0010\u0018R*\u00104\u001a\u0002022\u0006\u00103\u001a\u0002028\u0006@DX\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006;"}, d2 = {"Lcom/stepos/agentframework/chatui/appui/BaseAppUIHostView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "flag", "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "appUIData", "LY8/t;", "e", "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;)V", Const.INTENT_KEY_APIKEY, "()V", "f", "c", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "getFlag", "()Ljava/lang/String;", "setFlag", "(Ljava/lang/String;)V", "Landroidx/constraintlayout/widget/ConstraintLayout;", "appUIContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getAppUIContainer", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setAppUIContainer", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "getAppUIData", "()Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "setAppUIData", "(Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;)V", "Lcom/stepos/agentframework/chatui/appui/BaseAppUIHostView$a;", "appUIHost", "Lcom/stepos/agentframework/chatui/appui/BaseAppUIHostView$a;", "getAppUIHost", "()Lcom/stepos/agentframework/chatui/appui/BaseAppUIHostView$a;", "setAppUIHost", "(Lcom/stepos/agentframework/chatui/appui/BaseAppUIHostView$a;)V", "chatSessionId", "getChatSessionId", "setChatSessionId", "requestSessionId", "getRequestSessionId", "setRequestSessionId", "", UxipConstants.f30680s, "isHostDestroyed", "Z", Const.INTENT_KEY_UMID, "()Z", "setHostDestroyed", "(Z)V", "TerminateReason", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BaseAppUIHostView extends FrameLayout {
    private ConstraintLayout appUIContainer;
    private AppUIData appUIData;
    private a appUIHost;
    private String chatSessionId;
    private String flag;
    private boolean isHostDestroyed;
    private String requestSessionId;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/agentframework/chatui/appui/BaseAppUIHostView$TerminateReason;", "", "<init>", "(Ljava/lang/String;I)V", "USER_CANCELED", "TIMEOUT", "ERROR", "SESSION_SWITCHED", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class TerminateReason {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ TerminateReason[] $VALUES;
        public static final TerminateReason USER_CANCELED = new TerminateReason("USER_CANCELED", 0);
        public static final TerminateReason TIMEOUT = new TerminateReason("TIMEOUT", 1);
        public static final TerminateReason ERROR = new TerminateReason("ERROR", 2);
        public static final TerminateReason SESSION_SWITCHED = new TerminateReason("SESSION_SWITCHED", 3);

        private static final /* synthetic */ TerminateReason[] $values() {
            return new TerminateReason[]{USER_CANCELED, TIMEOUT, ERROR, SESSION_SWITCHED};
        }

        static {
            TerminateReason[] terminateReasonArr$values = $values();
            $VALUES = terminateReasonArr$values;
            $ENTRIES = kotlin.enums.a.a(terminateReasonArr$values);
        }

        private TerminateReason(String str, int i10) {
        }

        public static InterfaceC4149a<TerminateReason> getEntries() {
            return $ENTRIES;
        }

        public static TerminateReason valueOf(String str) {
            return (TerminateReason) Enum.valueOf(TerminateReason.class, str);
        }

        public static TerminateReason[] values() {
            return (TerminateReason[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/agentframework/chatui/appui/BaseAppUIHostView$a;", "Lcom/stepos/agentframework/chatui/appui/i;", "<init>", "()V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements i {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseAppUIHostView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.i(context, "context");
        this.appUIHost = new a();
        this.chatSessionId = "";
        this.requestSessionId = "";
        View.inflate(context, R$layout.view_app_ui_host, this);
        View viewFindViewById = findViewById(R$id.app_ui_container);
        p.h(viewFindViewById, "findViewById(...)");
        this.appUIContainer = (ConstraintLayout) viewFindViewById;
    }

    public abstract void a();

    public final void b() {
        a();
        this.isHostDestroyed = true;
        c();
    }

    public final void c() {
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsHostDestroyed() {
        return this.isHostDestroyed;
    }

    public abstract void e(String flag, AppUIData appUIData);

    public final void f() {
        this.isHostDestroyed = false;
    }

    public final ConstraintLayout getAppUIContainer() {
        return this.appUIContainer;
    }

    public final AppUIData getAppUIData() {
        return this.appUIData;
    }

    public final a getAppUIHost() {
        return this.appUIHost;
    }

    public final String getChatSessionId() {
        return this.chatSessionId;
    }

    public final String getFlag() {
        return this.flag;
    }

    public final String getRequestSessionId() {
        return this.requestSessionId;
    }

    public final void setAppUIContainer(ConstraintLayout constraintLayout) {
        p.i(constraintLayout, "<set-?>");
        this.appUIContainer = constraintLayout;
    }

    public final void setAppUIData(AppUIData appUIData) {
        this.appUIData = appUIData;
    }

    public final void setAppUIHost(a aVar) {
        p.i(aVar, "<set-?>");
        this.appUIHost = aVar;
    }

    public final void setChatSessionId(String str) {
        p.i(str, "<set-?>");
        this.chatSessionId = str;
    }

    public final void setFlag(String str) {
        this.flag = str;
    }

    public final void setHostDestroyed(boolean z10) {
        this.isHostDestroyed = z10;
    }

    public final void setRequestSessionId(String str) {
        p.i(str, "<set-?>");
        this.requestSessionId = str;
    }
}
