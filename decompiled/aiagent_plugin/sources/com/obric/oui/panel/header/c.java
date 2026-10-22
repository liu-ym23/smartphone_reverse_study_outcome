package com.obric.oui.panel.header;

import android.content.Context;
import android.view.View;
import androidx.appcompat.view.ContextThemeWrapper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: BasicPanelHeader.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f35918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f35919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f35920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f35921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f35922e;

    public /* synthetic */ c(Context r2, boolean r3, int r4, h r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, r4);
    }

    public abstract View a();

    private c(Context r3, boolean r4, int r5) {
        this.f35918a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f35919b = r4;
        this.f35920c = r5;
        this.f35922e = true;
    }

    public /* synthetic */ c(Context r2, boolean r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r3, r4, null);
    }

    public final Context getContext() {
        return this.f35918a;
    }

    public final boolean b() {
        return this.f35922e;
    }

    public final Context c() {
        Context r0 = this.f35921d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a(this, this.f35918a, false, 2, null), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ Context a(c r2, Context r3, boolean r4, int r5, Object r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L8;
        r4 = r2.f35919b;
    L8:
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.a(r7, r4), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateThemedContext");
    }

    public final Context a(Context r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r7, "baseContext");
        if (this.f35920c == 0) goto L6;
        return (Context) ZeusTransformUtils.preCheckCast(new ContextThemeWrapper(r7, this.f35920c), Context.class, "com.obric.aiagent.plugin");
    L6:
        if (r6 == false) goto L8;
        ContextThemeWrapper r8 = new ContextThemeWrapper(r7, ZeusTransformUtils.mapRes(R.style.OBasicPanelDayNightSwitch, "style", "OBasicPanelDayNightSwitch"));
    L9:
        this.f35921d = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(r8, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        return (Context) ZeusTransformUtils.preCheckCast(r8, Context.class, "com.obric.aiagent.plugin");
    L8:
        r8 = new ContextThemeWrapper(r7, ZeusTransformUtils.mapRes(R.style.OBasicPanelConstLight, "style", "OBasicPanelConstLight"));
        goto L9
    }
}
