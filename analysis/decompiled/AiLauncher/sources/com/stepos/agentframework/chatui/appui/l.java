package com.stepos.agentframework.chatui.appui;

import A4.b;
import android.appwidget.AppWidgetHostView;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.agentframework.chatcore.utils.ExtKt;
import com.stepos.agentframework.chatui.appui.BaseAppUIHostView;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\t¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0019\u0010\u0011J\u0017\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/agentframework/chatui/appui/l;", "Lcom/stepos/agentframework/chatui/appui/BaseAppUIHostView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "", "flag", "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "appUIData", "LY8/t;", "e", "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;)V", Const.INTENT_KEY_APIKEY, "()V", "Lcom/stepos/agentframework/chatui/appui/BaseAppUIHostView$TerminateReason;", "reason", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/agentframework/chatui/appui/BaseAppUIHostView$TerminateReason;)V", "messageId", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Landroid/content/Intent;", "intent", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/content/Intent;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class l extends BaseAppUIHostView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.i(context, "context");
    }

    @Override // com.stepos.agentframework.chatui.appui.BaseAppUIHostView
    public void a() {
        setHostDestroyed(true);
        String flag = getFlag();
        if (flag != null) {
            A4.b.INSTANCE.a().j(flag);
        }
        getAppUIContainer().removeAllViews();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.widget.TextView, com.stepos.agentframework.chatui.appui.h] */
    @Override // com.stepos.agentframework.chatui.appui.BaseAppUIHostView
    public void e(String flag, AppUIData appUIData) {
        p.i(flag, "flag");
        p.i(appUIData, "appUIData");
        f();
        setFlag(flag);
        setAppUIData(appUIData);
        getAppUIContainer().removeAllViews();
        b.Companion companion = A4.b.INSTANCE;
        AppWidgetHostView appWidgetHostViewE = companion.a().e(flag);
        if (appWidgetHostViewE == null) {
            AppWidgetHostView appWidgetHostViewH = companion.a().h(flag, appUIData.getPackageName(), appUIData.getWidgetCls(), -1);
            AppWidgetHostView appWidgetHostView = appWidgetHostViewH;
            if (appWidgetHostViewH == null) {
                Context context = getContext();
                p.h(context, "getContext(...)");
                ?? hVar = new h(context);
                hVar.setText("加载widget失败，需要系统签名");
                appWidgetHostView = hVar;
            }
            appWidgetHostViewE = appWidgetHostView;
            g(flag);
        }
        getAppUIContainer().addView(appWidgetHostViewE);
    }

    public final void g(String messageId) {
        p.i(messageId, "messageId");
        AppUIData appUIData = getAppUIData();
        if (appUIData != null) {
            if (!m.c(appUIData.getWidgetAction(), appUIData.getStructuredContent())) {
                C4148a.k(ExtKt.TAG, "skip widget init broadcast action=" + appUIData.getWidgetAction(), false, 4, null);
                return;
            }
            Integer num = A4.b.INSTANCE.a().f().get(messageId);
            Intent intent = new Intent(appUIData.getWidgetAction());
            intent.setPackage(appUIData.getPackageName());
            intent.setComponent(new ComponentName(appUIData.getPackageName(), appUIData.getWidgetCls()));
            intent.putExtra(AppUIGlobal.EXTRA_WIDGET_ID, num);
            intent.putExtra(AppUIGlobal.EXTRA_CUSTOM_DATA, com.stepos.agentframework.adapter.netcore.j.b(appUIData.getStructuredContent()));
            j(intent);
        }
    }

    public final void h() {
        AppUIData appUIData;
        C4148a.k(ExtKt.TAG, "notifyWidgetCanceled flag: " + getFlag(), false, 4, null);
        String flag = getFlag();
        if (flag == null || (appUIData = getAppUIData()) == null) {
            return;
        }
        Integer num = A4.b.INSTANCE.a().f().get(flag);
        C4148a.k(ExtKt.TAG, "notifyWidgetCanceled widgetId: " + num + " packageName:" + appUIData.getPackageName() + " widgetCls:" + appUIData.getWidgetCls(), false, 4, null);
        Intent intent = new Intent(appUIData.getWidgetAction());
        intent.setComponent(new ComponentName(appUIData.getPackageName(), appUIData.getWidgetCls()));
        intent.putExtra(AppUIGlobal.EXTRA_WIDGET_ID, num);
        intent.putExtra(AppUIGlobal.EXTRA_TASK_STATUS, "canceled");
        j(intent);
    }

    public void i(BaseAppUIHostView.TerminateReason reason) {
        p.i(reason, "reason");
        C4148a.k(ExtKt.TAG, "onConversationTerminated: " + reason, false, 4, null);
        if (reason == BaseAppUIHostView.TerminateReason.USER_CANCELED) {
            h();
        }
    }

    public final void j(Intent intent) {
        try {
            getContext().sendBroadcast(intent);
        } catch (SecurityException e10) {
            C4148a.g(ExtKt.TAG, "sendBroadcast denied for action=" + intent.getAction(), e10, false, 8, null);
        } catch (Exception e11) {
            C4148a.g(ExtKt.TAG, "sendBroadcast failed for action=" + intent.getAction(), e11, false, 8, null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l(Context context) {
        this(context, null);
        p.i(context, "context");
    }
}
