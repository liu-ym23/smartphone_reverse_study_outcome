package com.obric.autogui.platforms.tools.c;

import android.content.Context;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.platform.screen.capture.OScreenEvent;
import com.obric.autogui.common.api.platform.screen.capture.OTouchInfo;
import com.obric.memorydata.sdk.screencapture.event.AppStateEvent;
import com.obric.memorydata.sdk.screencapture.event.InputMethodEvent;
import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import com.obric.memorydata.sdk.screencapture.event.ScreenTouchEvent;
import com.obric.memorydata.sdk.screencapture.event.TouchInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.k;

/* JADX INFO: compiled from: Ext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Ext.kt */
    public /* synthetic */ class C0800a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30134a = null;

        static {
            int[] r0 = new int[ScreenTouchEvent.b.values().length];
            r0[ScreenTouchEvent.b.f33872a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[ScreenTouchEvent.b.f33873b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[ScreenTouchEvent.b.f33874c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[ScreenTouchEvent.b.f33875d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[ScreenTouchEvent.b.f33876e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[ScreenTouchEvent.b.f.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f30134a = r0;
        }
    }

    public static final OScreenEvent a(ScreenEvent r10) {
        o.e(r10, "<this>");
        OTouchInfo r1 = null;
        if (ZeusTransformUtils.instanceOf(r10, AppStateEvent.class) == false) goto L10;
        if (((AppStateEvent) ZeusTransformUtils.preCheckCast(r10, AppStateEvent.class, "com.obric.aiagent.plugin")).getState() != AppStateEvent.a.f33857a) goto L7;
        OScreenEvent.OAppStateEvent.AppState r2 = OScreenEvent.OAppStateEvent.AppState.OPEN;
    L8:
        OScreenEvent.OAppStateEvent r0 = new OScreenEvent.OAppStateEvent(r2);
        a((OScreenEvent) ZeusTransformUtils.preCheckCast(r0, OScreenEvent.class, "com.obric.aiagent.plugin"), r10);
        return (OScreenEvent) ZeusTransformUtils.preCheckCast(r0, OScreenEvent.class, "com.obric.aiagent.plugin");
    L7:
        r2 = OScreenEvent.OAppStateEvent.AppState.CLOSE;
        goto L8
    L10:
        if (ZeusTransformUtils.instanceOf(r10, InputMethodEvent.class) == false) goto L13;
        OScreenEvent.OInputMethodEvent r3 = new OScreenEvent.OInputMethodEvent(((InputMethodEvent) ZeusTransformUtils.preCheckCast(r10, InputMethodEvent.class, "com.obric.aiagent.plugin")).getVisible());
        a((OScreenEvent) ZeusTransformUtils.preCheckCast(r3, OScreenEvent.class, "com.obric.aiagent.plugin"), r10);
        return (OScreenEvent) ZeusTransformUtils.preCheckCast(r3, OScreenEvent.class, "com.obric.aiagent.plugin");
    L13:
        if (ZeusTransformUtils.instanceOf(r10, ScreenTouchEvent.class) == false) goto L21;
        OScreenEvent.OScreenTouchEvent.OTouchAction r4 = a(((ScreenTouchEvent) ZeusTransformUtils.preCheckCast(r10, ScreenTouchEvent.class, "com.obric.aiagent.plugin")).getAction());
        OTouchInfo r5 = a(((ScreenTouchEvent) ZeusTransformUtils.preCheckCast(r10, ScreenTouchEvent.class, "com.obric.aiagent.plugin")).getTouchInfo());
        TouchInfo r6 = ((ScreenTouchEvent) ZeusTransformUtils.preCheckCast(r10, ScreenTouchEvent.class, "com.obric.aiagent.plugin")).getEndTouchInfo();
        if (r6 == null) goto L17;
        r1 = a(r6);
    L17:
        OScreenEvent.OScreenTouchEvent r7 = new OScreenEvent.OScreenTouchEvent(r4, r5, r1, null, 8, null);
        a((OScreenEvent) ZeusTransformUtils.preCheckCast(r7, OScreenEvent.class, "com.obric.aiagent.plugin"), r10);
        return (OScreenEvent) ZeusTransformUtils.preCheckCast(r7, OScreenEvent.class, "com.obric.aiagent.plugin");
    L21:
        return null;
    }

    public static final OScreenEvent.OScreenTouchEvent.OTouchAction a(ScreenTouchEvent.b r1) {
        o.e(r1, "<this>");
        switch(C0800a.f30134a[r1.ordinal()]) {
            case 1: goto L12;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            default: goto L5;
        };
    L5:
        throw new k();
    L13:
        return OScreenEvent.OScreenTouchEvent.OTouchAction.BACK_KEY;
    L14:
        return OScreenEvent.OScreenTouchEvent.OTouchAction.SCROLLED;
    L15:
        return OScreenEvent.OScreenTouchEvent.OTouchAction.SCROLL_START;
    L16:
        return OScreenEvent.OScreenTouchEvent.OTouchAction.LONG_PRESS;
    L17:
        return OScreenEvent.OScreenTouchEvent.OTouchAction.DOUBLE_TAP;
    L12:
        return OScreenEvent.OScreenTouchEvent.OTouchAction.TAP;
    }

    public static final OTouchInfo a(TouchInfo r2) {
        o.e(r2, "<this>");
        return new OTouchInfo(r2.getX(), r2.getY());
    }

    private static final void a(OScreenEvent r2, ScreenEvent r3) {
        r2.setAppName(r3.getAppName());
        r2.setPackageName(r3.getPackageName());
        r2.setEventTime(r3.getEventTime());
        r2.setScreenOrientation(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getConfiguration().orientation);
    }

    private static final Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }
}
