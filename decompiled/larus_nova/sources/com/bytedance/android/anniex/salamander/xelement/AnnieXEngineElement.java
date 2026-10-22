package com.bytedance.android.anniex.salamander.xelement;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.salamander.anniex.AnnieXBaseViewModel;
import com.bytedance.salamander.anniex.e2;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u001c\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007J\u001c\u0010\f\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007J\u001c\u0010\r\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/anniex/salamander/xelement/AnnieXEngineElement;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Landroid/widget/FrameLayout;", "", "annieXContainerId", "", "setAnnieXContainerId", "Lcom/lynx/react/bridge/ReadableMap;", "params", "Lcom/lynx/react/bridge/Callback;", "callback", "onTouchesDown", "onTouchesMove", "onEnd", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class AnnieXEngineElement extends UIGroup<FrameLayout> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f41074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f41075b;

    public static final class a extends FrameLayout {
        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
        }

        @Override // android.view.ViewGroup
        public final boolean onInterceptTouchEvent(MotionEvent r100) {
            HybridLogger r101 = HybridLogger.f246343a;
            StringBuilder r102 = new StringBuilder("event: ");
            if (r100 == null) goto L5;
            Float r103 = Float.valueOf(r100.getY());
        L6:
            r102.append(r103);
            HybridLogger.m("huqijun", r102.toString(), null, null, 12);
            return super.onInterceptTouchEvent(r100);
        L5:
            r103 = null;
            goto L6
        }

        @Override // android.view.View
        public final boolean onTouchEvent(MotionEvent r100) {
            HybridLogger r101 = HybridLogger.f246343a;
            StringBuilder r102 = new StringBuilder("event: ");
            if (r100 == null) goto L5;
            Float r103 = Float.valueOf(r100.getY());
        L6:
            r102.append(r103);
            HybridLogger.m("huqijun", r102.toString(), null, null, 12);
            return super.onTouchEvent(r100);
        L5:
            r103 = null;
            goto L6
        }
    }

    @LynxUIMethod
    public final void onEnd(ReadableMap r100, Callback r101) {
    }

    @LynxUIMethod
    public final void onTouchesDown(ReadableMap r100, Callback r101) {
    }

    @LynxUIMethod
    public final void onTouchesMove(ReadableMap r100, Callback r101) {
    }

    public AnnieXEngineElement(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @LynxProp(name = "anniexContainerId")
    public final void setAnnieXContainerId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "annieXContainerId");
        if (Intrinsics.areEqual(this.f41075b, r100) == false) goto L5;
        return;
    L5:
        this.f41075b = r100;
        e2 r101 = e2.f268044b;
        AnnieXBaseViewModel r102 = e2.a.a().a(r100);
        if (r102 == null) goto L13;
        View r103 = r102.a().b();
        if (r103 == null) goto L14;
        a r104 = this.f41074a;
        if (r104 == null) goto L15;
        r104.addView(r103, -1, -1);
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100, Object r101) {
        if (r100 == null) goto L4;
        a r102 = new a(r100);
        this.f41074a = r102;
        r102.requestDisallowInterceptTouchEvent(false);
        return r102;
    L4:
        return null;
    }
}
