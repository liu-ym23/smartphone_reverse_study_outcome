package com.obric.autogui.platforms.tools.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import com.obric.aiagent.product.platform.api.app.ObricAutoVirtualDisplayRecordSetListener;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.obric.autogui.common.api.platform.display.IAutoActionDisplayApi;
import com.obric.autogui.common.api.platform.display.vd.VDConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Collection;

/* JADX INFO: compiled from: StandardDisplayApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements IAutoActionDisplayApi {
    private static final String TAG = "Std/DispApi";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30154a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DisplayAccessor f30155b;

    /* JADX INFO: compiled from: StandardDisplayApi.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f30154a = new a(null);
    }

    @Override // com.obric.autogui.common.api.platform.display.IAutoActionDisplayApi
    public void clearGloballyDisabledPackages(Context r2) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
    }

    @Override // com.obric.autogui.common.api.platform.display.IAutoActionDisplayApi
    public int getMainDisplayId() {
        return 0;
    }

    public b() {
    }

    @Override // com.obric.autogui.common.api.platform.display.IAutoActionDisplayApi
    public boolean supportsVirtualDisplayRecordSet() {
        return com.obric.autogui.platforms.tools.internal.a.C0812a.f30315a.b();
    }

    @Override // com.obric.autogui.common.api.platform.display.IAutoActionDisplayApi
    public long beginVirtualDisplayRecordSet(int r1, int r2, ObricAutoVirtualDisplayRecordSetListener r3) {
        o.e(r3, "listener");
        return com.obric.autogui.platforms.tools.internal.a.C0812a.f30315a.a(r1, r2, r3);
    }

    @Override // com.obric.autogui.common.api.platform.display.IAutoActionDisplayApi
    public boolean addVirtualDisplayRecordPackages(long r3, Collection<String> r5) {
        Collection r2 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.aiagent.plugin");
        o.e(r2, "packageNames");
        return com.obric.autogui.platforms.tools.internal.a.C0812a.f30315a.a(r3, (String[]) ZeusTransformUtils.preCheckCast(r2.toArray(new String[0]), String[].class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.platform.display.IAutoActionDisplayApi
    public void endVirtualDisplayRecordSet(long r1) {
        com.obric.autogui.platforms.tools.internal.a.C0812a.f30315a.a(r1);
    }

    @Override // com.obric.autogui.common.api.platform.display.IAutoActionDisplayApi
    public void setGloballyDisabledPackages(Context r2, Collection<String> r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r4, "disabledApps");
        com.obric.autogui.platforms.tools.internal.a.C0812a.f30315a.a((String[]) ZeusTransformUtils.preCheckCast(r4.toArray(new String[0]), String[].class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "setGloballyDisabledPackages: failed", th);
    }

    @Override // com.obric.autogui.common.api.platform.display.IAutoActionDisplayApi
    public Object createVD(Context r2, VDConfig r3, d.c.d<? super DisplayAccessor> r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        if (r3.getType() == VDConfig.Type.DefaultOperatingSpace) goto L5;
        Loog.INSTANCE.w(TAG, "createVD: not support VDType " + r3.getType());
        return null;
    L5:
        return new com.obric.autogui.platforms.tools.display.a.a(r1).b(r3);
    }

    @Override // com.obric.autogui.common.api.platform.display.IAutoActionDisplayApi
    public DisplayAccessor getMDAccess(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        DisplayAccessor r0 = this.f30155b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Object r1 = r5.getSystemService("display");
        o.a(r1, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        Display r2 = ((DisplayManager) ZeusTransformUtils.preCheckCast(r1, DisplayManager.class, "com.obric.aiagent.plugin")).getDisplay(getMainDisplayId());
        o.a(r2);
        d r3 = new d(r5, r2);
        this.f30155b = (DisplayAccessor) ZeusTransformUtils.preCheckCast(r3, DisplayAccessor.class, "com.obric.aiagent.plugin");
        return (DisplayAccessor) ZeusTransformUtils.preCheckCast(r3, DisplayAccessor.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.display.IAutoActionDisplayApi
    public boolean bringTaskToFront(Context r2, int r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        return com.obric.autogui.platforms.tools.internal.a.C0812a.f30315a.a(r1, r3);
    }
}
