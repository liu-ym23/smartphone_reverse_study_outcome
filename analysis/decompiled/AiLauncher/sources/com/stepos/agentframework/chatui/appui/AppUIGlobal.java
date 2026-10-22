package com.stepos.agentframework.chatui.appui;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001dB1\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\u0015R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0018\u0010\n\"\u0004\b\u0019\u0010\u0015R$\u0010\u0006\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/stepos/agentframework/chatui/appui/e;", "", "", "theme", "locale", "displayMode", "toolOutput", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTheme", "setTheme", "(Ljava/lang/String;)V", "getLocale", "setLocale", "getDisplayMode", "setDisplayMode", "Ljava/lang/Object;", "getToolOutput", "()Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Object;)V", "Companion", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatui.appui.e, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class AppUIGlobal {
    public static final String EXTRA_CUSTOM_DATA = "EXTRA_CUSTOM_DATA";
    public static final String EXTRA_TASK_STATUS = "EXTRA_TASK_STATUS";
    public static final String EXTRA_WIDGET_ID = "EXTRA_WIDGET_ID";
    public static final String MODE_FULLSCREEN = "fullscreen";
    public static final String MODE_INLINE = "inline";
    public static final String MODE_PIP = "pip";
    public static final String TASK_STATUS_CANCELED = "canceled";
    private String displayMode;
    private String locale;
    private String theme;
    private Object toolOutput;

    public AppUIGlobal() {
        this(null, null, null, null, 15, null);
    }

    public final void a(Object obj) {
        this.toolOutput = obj;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppUIGlobal)) {
            return false;
        }
        AppUIGlobal appUIGlobal = (AppUIGlobal) other;
        return p.d(this.theme, appUIGlobal.theme) && p.d(this.locale, appUIGlobal.locale) && p.d(this.displayMode, appUIGlobal.displayMode) && p.d(this.toolOutput, appUIGlobal.toolOutput);
    }

    public int hashCode() {
        int iHashCode = ((((this.theme.hashCode() * 31) + this.locale.hashCode()) * 31) + this.displayMode.hashCode()) * 31;
        Object obj = this.toolOutput;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "AppUIGlobal(theme=" + this.theme + ", locale=" + this.locale + ", displayMode=" + this.displayMode + ", toolOutput=" + this.toolOutput + ")";
    }

    public AppUIGlobal(String theme, String locale, String displayMode, Object obj) {
        p.i(theme, "theme");
        p.i(locale, "locale");
        p.i(displayMode, "displayMode");
        this.theme = theme;
        this.locale = locale;
        this.displayMode = displayMode;
        this.toolOutput = obj;
    }

    public /* synthetic */ AppUIGlobal(String str, String str2, String str3, Object obj, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? "light" : str, (i10 & 2) != 0 ? "en" : str2, (i10 & 4) != 0 ? "inline" : str3, (i10 & 8) != 0 ? null : obj);
    }
}
