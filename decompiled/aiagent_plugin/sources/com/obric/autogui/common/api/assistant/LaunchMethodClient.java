package com.obric.autogui.common.api.assistant;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.n;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: LaunchMethodClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LaunchMethodClient {
    private static final List<Uri> CONTENT_URIS = null;
    public static final LaunchMethodClient INSTANCE = null;
    private static final String INTENT_EXTRA_LAUNCH_METHOD = "obric_launch_method";
    public static final String LAUNCH_METHOD_CLICK_PINNED_DESKTOP_ICON = "click_pinned_desktop_icon";
    public static final String LAUNCH_METHOD_DYNAMIC_ISLAND = "dynamic_island";
    public static final String LAUNCH_METHOD_NOTIFICATION_CENTER = "notification_center";
    private static final String METHOD_SET_LAUNCH_METHOD = "set_launch_method";
    private static final String TAG = "LaunchMethodClient";

    private LaunchMethodClient() {
    }

    static {
        INSTANCE = new LaunchMethodClient();
        CONTENT_URIS = p.b(new Uri[]{Uri.parse("content://com.obric.assistant.provider.LaunchMethodProvider"), Uri.parse("content://com.larus.nova.assistant.provider.LaunchMethodProvider")});
    }

    public final void setLaunchMethod(Context r10, String r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        o.e(r12, "context");
        o.e(r11, "launchMethod");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return;
    L5:
        Iterator<Uri> r0 = CONTENT_URIS.iterator();
    L7:
        if (r0.hasNext() == false) goto L21;
        Uri r2 = (Uri) ZeusTransformUtils.preCheckCast(r0.next(), Uri.class, "com.obric.aiagent.plugin");
        n.a r3 = n.f38560a;     // Catch: Throwable -> L11
        LaunchMethodClient r4 = (LaunchMethodClient) ZeusTransformUtils.preCheckCast(this, LaunchMethodClient.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        ZeusProviderTransform.call(r12.getContentResolver(), r2, METHOD_SET_LAUNCH_METHOD, r11, null, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        Object r5 = n.f(true);     // Catch: Throwable -> L11
    L13:
        Throwable r6 = n.c(r5);
        if (r6 == null) goto L17;
        ILogDepend.Companion.w(TAG, "setLaunchMethod failed, uri=" + r2 + ", launchMethod=" + r11, r6);
    L17:
        if (n.b(r5) == false) goto L20;
        r5 = false;
    L20:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L7;
        return;
    L11:
        th = move-exception;
        n.a r7 = n.f38560a;
        r5 = n.f(d.o.a(th));
        goto L13
    }

    public final Intent attachLaunchMethod(Intent r1, String r2) {
        o.e(r1, MemorySourceLinkType.INTENT);
        o.e(r2, "launchMethod");
        r1.putExtra(INTENT_EXTRA_LAUNCH_METHOD, r2);
        return r1;
    }

    public final void consumeLaunchMethod(Context r5, Intent r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        if (r6 == null) goto L13;
        String r2 = r6.getStringExtra(INTENT_EXTRA_LAUNCH_METHOD);
        if (r2 != null) goto L7;
        return;
    L7:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L15;
        r6.removeExtra(INTENT_EXTRA_LAUNCH_METHOD);
        setLaunchMethod(r7, r2);
        return;
    L15:
        return;
    }
}
