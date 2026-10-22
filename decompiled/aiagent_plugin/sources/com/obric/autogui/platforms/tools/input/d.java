package com.obric.autogui.platforms.tools.input;

import android.app.TaskInfo;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.hardware.input.InputManager;
import android.util.EventsUtils;
import android.view.KeyEvent;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.annotation.CallingPlatform;
import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.obric.autogui.common.api.platform.input.IAutoActionInputApi;
import com.obric.autogui.common.api.platform.input.InputTextResult;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.DisplayOperatingSpace;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.h.b.h;
import d.o;
import java.util.List;
import kotlinx.coroutines.ax;

/* JADX INFO: compiled from: StandardTextTyper.kt */
/* JADX INFO: loaded from: classes3.dex */
@CallingPlatform
public final class d {
    private static final String TAG = "StandardTextTyper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30260a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f30261b = null;

    /* JADX INFO: compiled from: StandardTextTyper.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: StandardTextTyper.kt */
    @f(b = "StandardTextTyper.kt", c = {89, EventsUtils.FEAT_TYPE_NFC_EVENT, 92, 93}, d = "inputText", e = "com.obric.autogui.platforms.tools.input.StandardTextTyper")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f30263b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f30264c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f30265d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f30266e;
        int f;

        b(d r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30266e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30265d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f30266e.a(null, null, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public d() {
    }

    static {
        f30260a = new a(null);
        f30261b = p.b(new String[]{"com.bytedance.ee.bear.document.DocExpandActivity", "com.bytedance.ee.bear.wikiv2.WikiExpandActivity"});
    }

    private final InputManager a() {
        return c.f30257a.a();
    }

    public Object a(CharSequence r17, AOOperatingSpace r18, boolean r19, d.c.d<? super InputTextResult> r20) {
        d r0 = this;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r17, CharSequence.class, "com.obric.aiagent.plugin");
        AOOperatingSpace r4 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r18, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r20, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, b.class) == false) goto L7;
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if ((r6.f & Integer.MIN_VALUE) == 0) goto L7;
        r6.f -= Integer.MIN_VALUE;
    L8:
        Object r7 = r6.f30265d;
        Object r8 = d.c.a.b.a();
        int r9 = r6.f;
        boolean r15 = true;
        if (r9 == 0) goto L29;
        if (r9 == 1) goto L26;
        if (r9 == 2) goto L23;
        if (r9 == 3) goto L20;
        if (r9 != 4) goto L19;
        o.a(r7);     // Catch: Throwable -> L16
    L64:
        return InputTextResult.Companion.getOK();
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        AOOperatingSpace r1 = (AOOperatingSpace) ZeusTransformUtils.preCheckCast(r6.f30264c, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.f30263b, CharSequence.class, "com.obric.aiagent.plugin");
        d r3 = (d) ZeusTransformUtils.preCheckCast(r6.f30262a, d.class, "com.obric.aiagent.plugin");
        o.a(r7);     // Catch: Throwable -> L16
    L60:
        r6.f30262a = null;     // Catch: Throwable -> L16
        r6.f30263b = null;     // Catch: Throwable -> L16
        r6.f30264c = null;     // Catch: Throwable -> L16
        r6.f = 4;     // Catch: Throwable -> L16
        if (r3.a(r2, r1, false, r6) != r8) goto L64;
        return r8;
    L23:
        r1 = (AOOperatingSpace) ZeusTransformUtils.preCheckCast(r6.f30264c, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.f30263b, CharSequence.class, "com.obric.aiagent.plugin");
        r3 = (d) ZeusTransformUtils.preCheckCast(r6.f30262a, d.class, "com.obric.aiagent.plugin");
        o.a(r7);     // Catch: Throwable -> L16
    L57:
        r3.a(((DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r1, DisplayOperatingSpace.class, "com.obric.aiagent.plugin")).getDisplayAccessor());     // Catch: Throwable -> L16
        r6.f30262a = r3;     // Catch: Throwable -> L16
        r6.f30263b = r2;     // Catch: Throwable -> L16
        r6.f30264c = r1;     // Catch: Throwable -> L16
        r6.f = 3;     // Catch: Throwable -> L16
        if (ax.a(100, r6) != r8) goto L60;
        return r8;
    L26:
        r4 = (AOOperatingSpace) ZeusTransformUtils.preCheckCast(r6.f30264c, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.f30263b, CharSequence.class, "com.obric.aiagent.plugin");
        r0 = (d) ZeusTransformUtils.preCheckCast(r6.f30262a, d.class, "com.obric.aiagent.plugin");
        o.a(r7);     // Catch: Throwable -> L16
    L53:
        r6.f30262a = r0;     // Catch: Throwable -> L16
        r6.f30263b = r2;     // Catch: Throwable -> L16
        r6.f30264c = r4;     // Catch: Throwable -> L16
        r6.f = 2;     // Catch: Throwable -> L16
        if (ax.a(100, r6) != r8) goto L56;
        return r8;
    L56:
        r3 = r0;
        r1 = r4;
        goto L57
    L29:
        o.a(r7);
        if (a() != null) goto L34;
        Loog.INSTANCE.e(TAG, "[InputText] no InputManager is available. do you have enough permission?");
        return new InputTextResult(InputTextResult.Status.NotSupported);
    L34:
        if (ZeusTransformUtils.instanceOf(r4, DisplayOperatingSpace.class) == true) goto L37;
        Loog.INSTANCE.e(TAG, "[InputText] space is not DisplayOperatingSpace.");
        return new InputTextResult(InputTextResult.Status.NotSupported);
    L37:
        int r10 = ((DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r4, DisplayOperatingSpace.class, "com.obric.aiagent.plugin")).getDisplayId();
        if (r19 == false) goto L65;
        List<TaskInfo> r11 = com.obric.autogui.platforms.tools.internal.a.b.f30316a.a(1, false, false, r10);     // Catch: Throwable -> L16
        if (r11.isEmpty() == false) goto L42;
        Loog.INSTANCE.i(TAG, "the inject activity is null or empty");     // Catch: Throwable -> L16
        goto L65
    L42:
        ActivityInfo r12 = com.obric.autogui.platforms.tools.internal.a.e.f30325a.c((TaskInfo) ZeusTransformUtils.preCheckCast(r11.get(0), TaskInfo.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
        if (r12 == null) goto L47;
        ComponentName r13 = com.obric.autogui.platforms.tools.internal.a.f.f30329a.a((ComponentInfo) ZeusTransformUtils.preCheckCast(r12, ComponentInfo.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
        if (r13 == null) goto L47;
        String r14 = r13.getClassName();     // Catch: Throwable -> L16
    L48:
        Loog.INSTANCE.i(TAG, "the inject activity is " + r14);     // Catch: Throwable -> L16
        if (p.a((Iterable) ZeusTransformUtils.preCheckCast(f30261b, Iterable.class, "com.obric.aiagent.plugin"), r14) == false) goto L65;
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast("/", CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        r6.f30262a = r0;     // Catch: Throwable -> L16
        r6.f30263b = r2;     // Catch: Throwable -> L16
        r6.f30264c = r4;     // Catch: Throwable -> L16
        r6.f = 1;     // Catch: Throwable -> L16
        if (r0.a(r16, r4, false, r6) != r8) goto L53;
        return r8;
    L47:
        r14 = null;
    L65:
        com.obric.autogui.platforms.tools.internal.a.g r21 = com.obric.autogui.platforms.tools.internal.a.g.f30334a;     // Catch: Throwable -> L16
        if (r19 == false) goto L68;
        boolean r22 = true;
    L69:
        boolean r23 = r21.a(r2, r22);     // Catch: Throwable -> L16
        Loog r24 = Loog.INSTANCE;     // Catch: Throwable -> L16
        StringBuilder r25 = new StringBuilder().append("InputManager result: ");     // Catch: Throwable -> L16
        if (r23 == true) goto L73;
        r15 = false;
    L73:
        r24.d(TAG, r25.append(r15).toString());     // Catch: Throwable -> L16
        if (r23 == false) goto L77;
        return InputTextResult.Companion.getOK();
    L77:
        return new InputTextResult(InputTextResult.Status.ApiFailed);
    L68:
        r22 = false;
    L16:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "InputMethodManagerEx Throwable: " + th, th);
        return new InputTextResult(InputTextResult.Status.ApiFailed);
    L7:
        r6 = new b(r0, r5);
        goto L8
    }

    private final void a(DisplayAccessor r18) {
        DisplayAccessor r0 = (DisplayAccessor) ZeusTransformUtils.wrapperContextForParams(r18, DisplayAccessor.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(TAG, " special activity, try to select all first");
        KeyEvent r1 = new KeyEvent(System.currentTimeMillis(), System.currentTimeMillis(), 0, 29, 0, 4096, -1, 0, 72, 257);
        AOPlatformTools.INSTANCE.input().key(r0, r1);
        KeyEvent r3 = KeyEvent.changeAction(r1, 1);
        IAutoActionInputApi r4 = AOPlatformTools.INSTANCE.input();
        d.h.b.o.a(r3);
        r4.key(r0, r3);
        com.obric.autogui.platforms.tools.internal.a.f.f30329a.a(r1);
        com.obric.autogui.platforms.tools.internal.a.f.f30329a.a(r3);
        Loog.INSTANCE.i(TAG, " special activity, select all end and recycle");
    }
}
