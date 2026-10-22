package com.stepos.agentframework.chatui.appui;

import Y8.t;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.JsonSyntaxException;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.agentframework.chatcore.utils.ExtKt;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0018\u001a\u00020\f2\u000e\u0010\u0016\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00152\u0006\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001a\u001a\u00020\f2\u000e\u0010\u0016\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00152\u0006\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u001b2\u000e\u0010\u0016\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0015H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\u0010J\u000f\u0010\u001f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001f\u0010\u0010R,\u0010\u0016\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/stepos/agentframework/chatui/appui/LocalAppUIHostView;", "Lcom/stepos/agentframework/chatui/appui/BaseAppUIHostView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "flag", "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "appUIData", "LY8/t;", "e", "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;)V", Const.INTENT_KEY_APIKEY, "()V", "", "insetPx", "setContentStartInset", "(I)V", "Lcom/stepos/agentframework/chatui/appui/a;", "bridge", "data", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/agentframework/chatui/appui/a;Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;)V", "k", "Landroid/view/View;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/agentframework/chatui/appui/a;)Landroid/view/View;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Lcom/stepos/agentframework/chatui/appui/a;", "getBridge", "()Lcom/stepos/agentframework/chatui/appui/a;", "setBridge", "(Lcom/stepos/agentframework/chatui/appui/a;)V", "bridgeViewName", "Ljava/lang/String;", "contentInsetStartPx", "I", "", "hiddenByCard", "Z", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalAppUIHostView extends BaseAppUIHostView {
    private a<?, ?> bridge;
    private String bridgeViewName;
    private int contentInsetStartPx;
    private boolean hiddenByCard;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalAppUIHostView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.i(context, "context");
        this.bridgeViewName = "";
    }

    @Override // com.stepos.agentframework.chatui.appui.BaseAppUIHostView
    public void a() {
        setHostDestroyed(true);
        j();
    }

    @Override // com.stepos.agentframework.chatui.appui.BaseAppUIHostView
    public void e(String flag, AppUIData appUIData) {
        Object objB;
        p.i(flag, "flag");
        p.i(appUIData, "appUIData");
        f();
        String flag2 = getFlag();
        setFlag(flag);
        setAppUIData(appUIData);
        String appUIName = appUIData.getAppUIName();
        if (appUIName == null) {
            appUIName = "";
        }
        if (this.bridge == null || !p.d(flag2, flag) || !p.d(this.bridgeViewName, appUIName)) {
            j();
            this.bridge = f.INSTANCE.a(appUIName);
            this.bridgeViewName = appUIName;
        }
        ExtKt.C(this);
        a<?, ?> aVar = this.bridge;
        if (aVar == null) {
            C4148a.h("AppUIHostView", "bridge is null", false, 4, null);
            getAppUIContainer().removeAllViews();
            ConstraintLayout appUIContainer = getAppUIContainer();
            Context context = getContext();
            p.h(context, "getContext(...)");
            h hVar = new h(context);
            hVar.setText("bridge is null, 先注册bridge");
            appUIContainer.addView(hVar);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            p.f(aVar);
            i(aVar, appUIData);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.h("AppUIHostView", "loadData failed viewName=" + appUIName + ": " + thE.getMessage(), false, 4, null);
            j();
            c cVarA = c.INSTANCE.a();
            Context context2 = getContext();
            p.h(context2, "getContext(...)");
            cVarA.k(context2, flag);
        }
        Result.a(objB);
    }

    public final View g(a<?, ?> bridge) {
        Context context = getContext();
        p.h(context, "getContext(...)");
        return bridge.a(context, getAppUIHost());
    }

    public final a<?, ?> getBridge() {
        return this.bridge;
    }

    public final void h() {
        a<?, ?> aVar = this.bridge;
        Object objC = aVar != null ? aVar.c() : null;
        d dVar = objC instanceof d ? (d) objC : null;
        if (dVar != null) {
            dVar.setContentStartInset(this.contentInsetStartPx);
        }
    }

    public final void i(a<?, ?> bridge, AppUIData data) throws JsonSyntaxException {
        bridge.e(data.getStructuredContent() != null ? com.stepos.agentframework.adapter.netcore.j.b(data.getStructuredContent()) : "");
        if (bridge.c() == null) {
            View viewG = g(bridge);
            getAppUIContainer().removeAllViews();
            getAppUIContainer().addView(viewG);
        }
        k(bridge, data);
        h();
    }

    public final void j() {
        a<?, ?> aVar = this.bridge;
        if (aVar != null) {
            aVar.h();
        }
        this.bridge = null;
        this.bridgeViewName = "";
        this.hiddenByCard = false;
        getAppUIContainer().removeAllViews();
    }

    public final void k(a<?, ?> bridge, AppUIData data) {
        View viewC;
        if (data.isFixed() || (viewC = bridge.c()) == null) {
            return;
        }
        if (viewC.getVisibility() != 8) {
            if (this.hiddenByCard) {
                this.hiddenByCard = false;
                ExtKt.C(this);
                return;
            }
            return;
        }
        if (getVisibility() != 8) {
            this.hiddenByCard = true;
            setVisibility(8);
        }
    }

    public final void setBridge(a<?, ?> aVar) {
        this.bridge = aVar;
    }

    public final void setContentStartInset(int insetPx) {
        this.contentInsetStartPx = C5685n.f(insetPx, 0);
        h();
    }
}
