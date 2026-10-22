package com.stepos.agentframework.chatui.appui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/agentframework/chatui/appui/k;", "Lcom/stepos/agentframework/chatui/appui/BaseAppUIHostView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/stepos/agentframework/chatui/appui/taskrobot/b;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lcom/stepos/agentframework/chatui/appui/taskrobot/b;", "", "flag", "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "appUIData", "LY8/t;", "e", "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;)V", "Landroid/view/View;", "view", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/view/View;)V", "TAG", "Ljava/lang/String;", "surfaceView", "Lcom/stepos/agentframework/chatui/appui/taskrobot/b;", "getSurfaceView", "setSurfaceView", "(Lcom/stepos/agentframework/chatui/appui/taskrobot/b;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class k extends BaseAppUIHostView {
    private final String TAG;
    private com.stepos.agentframework.chatui.appui.taskrobot.b surfaceView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.i(context, "context");
        this.TAG = "SurfaceAppUIHostView";
    }

    @Override // com.stepos.agentframework.chatui.appui.BaseAppUIHostView
    public void e(String flag, AppUIData appUIData) {
        p.i(flag, "flag");
        p.i(appUIData, "appUIData");
        setFlag(flag);
        setAppUIData(appUIData);
    }

    public final com.stepos.agentframework.chatui.appui.taskrobot.b g() {
        Context context = getContext();
        p.h(context, "getContext(...)");
        com.stepos.agentframework.chatui.appui.taskrobot.b bVar = new com.stepos.agentframework.chatui.appui.taskrobot.b(context, null, 0, 6, null);
        this.surfaceView = bVar;
        p.f(bVar);
        return bVar;
    }

    public final com.stepos.agentframework.chatui.appui.taskrobot.b getSurfaceView() {
        return this.surfaceView;
    }

    public final void h(View view) {
        p.i(view, "view");
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
    }

    public final void setSurfaceView(com.stepos.agentframework.chatui.appui.taskrobot.b bVar) {
        this.surfaceView = bVar;
    }
}
