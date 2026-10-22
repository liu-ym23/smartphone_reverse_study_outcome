package com.bytedance.ai.widget;

import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f38052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f38053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f38054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f38055d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f38056e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f38052a, r101.f38052a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f38053b, r101.f38053b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f38054c, r101.f38054c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f38055d, r101.f38055d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f38056e, r101.f38056e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f38052a.hashCode() * 31) + this.f38053b.hashCode()) * 31;
        String r101 = this.f38054c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((r100 + r102) * 31) + this.f38055d.hashCode()) * 31) + this.f38056e.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "WidgetMonitorInfo(messageId=" + this.f38052a + ", cardId=" + this.f38053b + ", replyId=" + this.f38054c + ", appletId=" + this.f38055d + ", widgetId=" + this.f38056e + ')';
    }

    public m(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "cardId");
        Intrinsics.checkNotNullParameter(r103, IFlowAppIntentIDL.PARAM_APPLET_ID);
        Intrinsics.checkNotNullParameter(r104, "widgetId");
        this.f38052a = r100;
        this.f38053b = r101;
        this.f38054c = r102;
        this.f38055d = r103;
        this.f38056e = r104;
    }
}
