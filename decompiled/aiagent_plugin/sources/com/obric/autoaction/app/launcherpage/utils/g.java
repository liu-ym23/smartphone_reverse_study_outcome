package com.obric.autoaction.app.launcherpage.utils;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PinShortCutUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    private static final String TAG = "PinShortCutUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f24481a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, d.h.a.b<Boolean, x>> f24482b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final b f24483c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f24484d;

    /* JADX INFO: compiled from: PinShortCutUtils.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f24485a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f24486b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f24487c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ a[] f24488d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f24489e = null;

        private static final /* synthetic */ a[] a() {
            return new a[]{f24485a, f24486b, f24487c};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f24485a = new a("Requested", 0);
            f24486b = new a("NotSupported", 1);
            f24487c = new a("Failed", 2);
            a[] r0 = a();
            f24488d = r0;
            f24489e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f24488d.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: PinShortCutUtils.kt */
    public static final class b extends PluginBroadcastReceiver {
        b() {
        }

        public void onReceive(Context r3, Intent r4) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L11;
            String r5 = r4.getStringExtra("extra_shortcut_id");
            if (r5 == null) goto L13;
            boolean r6 = r4.getBooleanExtra("extra_result", false);
            d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.preCheckCast(g.b().remove(r5), d.h.a.b.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L12;
            r7.invoke(Boolean.valueOf(r6));
            return;
        L12:
            return;
        L13:
            return;
        }
    }

    public static /* synthetic */ x lambda$U24e5xQC4f8QpuNiv6dZqiJ7H88(String r0, o r1) {
        return a(r0, r1);
    }

    private g() {
    }

    public static final /* synthetic */ Map b() {
        return f24482b;
    }

    static {
        f24481a = new g();
        f24482b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        f24483c = new b();
    }

    public final void a(String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        Map<String, d.h.a.b<Boolean, x>> r1 = f24482b;
        if (r1.containsKey(r2) == false) goto L8;
        r1.remove(r2);
        return;
    }

    private final void b(Context r4) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (f24484d == true) goto L6;
        IntentFilter r5 = new IntentFilter("com.obric.autoaction.action.PIN_SHORTCUT_RESULT");
        androidx.core.content.a.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(f24483c, PluginBroadcastReceiver.class, "com.obric.aiagent.plugin"), r5, 4);
        f24484d = true;
        return;
    }

    public final boolean a(Context r4, String r5) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        if (r5 != null) goto L5;
        return false;
    L5:
        ShortcutManager r6 = (ShortcutManager) ZeusTransformUtils.preCheckCast(r3.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L16;
        List<ShortcutInfo> r7 = r6.getPinnedShortcuts();
        if (r7 == null) goto L16;
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L11:
        if (r8.hasNext() == false) goto L16;
        if (TextUtils.equals((CharSequence) ZeusTransformUtils.preCheckCast(((ShortcutInfo) ZeusTransformUtils.preCheckCast(r8.next(), ShortcutInfo.class, "com.obric.aiagent.plugin")).getId(), CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L11;
        return true;
    L16:
        return false;
    }

    public final void b(Context r5, String r6) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        if (r6 != null) goto L5;
        return;
    L5:
        ShortcutManager r7 = (ShortcutManager) ZeusTransformUtils.preCheckCast(r4.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L9;
        r7.disableShortcuts(d.a.p.a(r6), (CharSequence) ZeusTransformUtils.preCheckCast(r4.getString(ZeusTransformUtils.mapRes(R.string.main_event_task_delete_tip_for_pin_shortcut, WsChannelMultiProcessSharedProvider.STRING_TYPE, "main_event_task_delete_tip_for_pin_shortcut")), CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    }

    public final String a() {
        IFlowAppIntentIDL r0 = com.obric.aiagent.assistant.idl.r.a(aa.b(IFlowAppIntentIDL.class));
        if (r0 == null) goto L5;
        String r1 = r0.getUserId();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final List<ShortcutInfo> a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "context");
        if (Build.VERSION.SDK_INT < 25) goto L5;
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L14
        g r3 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        ShortcutManager r6 = (ShortcutManager) ZeusTransformUtils.preCheckCast(r5.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r6 == null) goto L9;
        List<ShortcutInfo> r7 = r6.getPinnedShortcuts();     // Catch: Throwable -> L14
    L10:
        if (r7 != null) goto L12;
        r7 = d.a.p.b();     // Catch: Throwable -> L14
    L12:
        Object r8 = d.n.f(r7);     // Catch: Throwable -> L14
    L16:
        Throwable r9 = d.n.c(r8);
        if (r9 == null) goto L21;
        Loog.INSTANCE.e(TAG, "getPinnedShortcuts failed", r9);
        r8 = d.a.p.b();
    L21:
        return (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
    L9:
        r7 = null;
    L14:
        th = move-exception;
        d.n.a r10 = d.n.f38560a;
        r8 = d.n.f(d.o.a(th));
        goto L16
    L5:
        return d.a.p.b();
    }

    public final String a(ShortcutInfo r1) {
        d.h.b.o.e(r1, DBDefinition.SEGMENT_INFO);
        PersistableBundle r0 = r1.getExtras();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("extra_shortcut_uid");
    }

    public final void a(Context r4, List<String> r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "context");
        d.h.b.o.e(r7, "shortcutIds");
        if (r7.isEmpty() == false) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 25) goto L23;
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L13
        g r3 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        ShortcutManager r8 = (ShortcutManager) ZeusTransformUtils.preCheckCast(r6.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        if (r8 == null) goto L10;
        r8.enableShortcuts(r7);     // Catch: Throwable -> L13
        x r9 = x.f38692a;     // Catch: Throwable -> L13
    L11:
        Object r10 = d.n.f(r9);     // Catch: Throwable -> L13
    L15:
        Throwable r11 = d.n.c(r10);
        if (r11 == null) goto L22;
        Loog.INSTANCE.e(TAG, "enablePinShortcuts failed", r11);
        return;
    L22:
        return;
    L10:
        r9 = null;
    L13:
        th = move-exception;
        d.n.a r12 = d.n.f38560a;
        r10 = d.n.f(d.o.a(th));
        goto L15
    }

    public final void b(Context r5, List<String> r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "context");
        d.h.b.o.e(r8, "shortcutIds");
        if (r8.isEmpty() == false) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 25) goto L23;
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L13
        g r4 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        ShortcutManager r9 = (ShortcutManager) ZeusTransformUtils.preCheckCast(r7.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        if (r9 == null) goto L10;
        r9.disableShortcuts(r8, (CharSequence) ZeusTransformUtils.preCheckCast(r7.getString(ZeusTransformUtils.mapRes(R.string.main_event_task_delete_tip_for_pin_shortcut, WsChannelMultiProcessSharedProvider.STRING_TYPE, "main_event_task_delete_tip_for_pin_shortcut")), CharSequence.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L13
        x r10 = x.f38692a;     // Catch: Throwable -> L13
    L11:
        Object r11 = d.n.f(r10);     // Catch: Throwable -> L13
    L15:
        Throwable r12 = d.n.c(r11);
        if (r12 == null) goto L22;
        Loog.INSTANCE.e(TAG, "disablePinShortcuts failed", r12);
        return;
    L22:
        return;
    L10:
        r10 = null;
    L13:
        th = move-exception;
        d.n.a r13 = d.n.f38560a;
        r11 = d.n.f(d.o.a(th));
        goto L15
    }

    public final void a(Context r5, List<String> r6, String r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "context");
        d.h.b.o.e(r9, "shortcutIds");
        d.h.b.o.e(r7, "uid");
        if (r9.isEmpty() == false) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 25) goto L28;
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L17
        g r4 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r10, 10)), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        Iterator r12 = r10.iterator();     // Catch: Throwable -> L17
    L9:
        if (r12.hasNext() == false) goto L11;
        ShortcutInfo.Builder r2 = new ShortcutInfo.Builder(r8, (String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L17
        PersistableBundle r1 = new PersistableBundle();     // Catch: Throwable -> L17
        r1.putString("extra_shortcut_uid", r7);     // Catch: Throwable -> L17
        r11.add(r2.setExtras(r1).build());     // Catch: Throwable -> L17
        goto L9
    L11:
        List<ShortcutInfo> r13 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        ShortcutManager r14 = (ShortcutManager) ZeusTransformUtils.preCheckCast(r8.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        if (r14 == null) goto L14;
        Boolean r15 = Boolean.valueOf(r14.updateShortcuts(r13));     // Catch: Throwable -> L17
    L15:
        Object r16 = d.n.f(r15);     // Catch: Throwable -> L17
    L19:
        Throwable r17 = d.n.c(r16);
        if (r17 == null) goto L27;
        Loog.INSTANCE.e(TAG, "updateShortcutsUid failed", r17);
        return;
    L27:
        return;
    L14:
        r15 = null;
    L17:
        th = move-exception;
        d.n.a r18 = d.n.f38560a;
        r16 = d.n.f(d.o.a(th));
        goto L19
    }

    public static /* synthetic */ void a(g r9, Context r10, String r11, String r12, Intent r13, Icon r14, d.h.a.b r15, int r16, Object r17) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super Boolean, x> r0 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r15, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r16 & 16) == 0) goto L5;
        Icon r7 = null;
    L7:
        if ((r16 & 32) == 0) goto L9;
        d.h.a.b<? super Boolean, x> r8 = null;
    L10:
        r9.a(r3, r11, r12, r13, r7, r8);
        return;
    L9:
        r8 = r0;
        goto L10
    L5:
        r7 = r14;
        goto L7
    }

    public final void a(Context r4, String r5, final String r6, Intent r7, Icon r8, d.h.a.b<? super Boolean, x> r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.h.a.b<Boolean, x> r11 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "context");
        d.h.b.o.e(r5, "shortcutId");
        d.h.b.o.e(r6, "shortCutName");
        d.h.b.o.e(r7, MemorySourceLinkType.INTENT);
        if (r8 != null) goto L5;
        r8 = Icon.createWithBitmap(o.f24527a.a(r10, new $$Lambda$g$U24e5xQC4f8QpuNiv6dZqiJ7H88(r6)).j());
        d.h.b.o.c(r8, "createWithBitmap(...)");
    L5:
        ShortcutInfo.Builder r12 = new ShortcutInfo.Builder(r10, r5).setShortLabel((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).setIcon(r8).setIntent(r7);
        PersistableBundle r13 = new PersistableBundle();
        r13.putString("extra_shortcut_uid", f24481a.a());
        ShortcutInfo r14 = r12.setExtras(r13).build();
        d.h.b.o.c(r14, "build(...)");
        ShortcutManager r15 = (ShortcutManager) ZeusTransformUtils.preCheckCast(r10.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.aiagent.plugin");
        IntentSender r0 = null;
        if (r11 != null) goto L23;
        PendingIntent r3 = null;
    L15:
        if (r3 == null) goto L17;
        r0 = r3.getIntentSender();     // Catch: Exception -> L12
    L17:
        r15.requestPinShortcut(r14, r0);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "addShortCut failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        Toast.makeText(r10, (CharSequence) ZeusTransformUtils.preCheckCast(r10.getString(ZeusTransformUtils.mapRes(R.string.add_pin_short_cut_fail, WsChannelMultiProcessSharedProvider.STRING_TYPE, "add_pin_short_cut_fail")), CharSequence.class, "com.obric.aiagent.plugin"), 1).show();
        d.h.a.b r16 = (d.h.a.b) ZeusTransformUtils.preCheckCast(f24482b.remove(r5), d.h.a.b.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L25;
        r16.invoke(false);
        return;
    L25:
        return;
    L23:
        b(r10);     // Catch: Exception -> L12
        f24482b.put(r5, r11);     // Catch: Exception -> L12
        Intent r17 = new Intent("com.obric.autoaction.action.PIN_SHORTCUT_RESULT");     // Catch: Exception -> L12
        r17.setPackage(r10.getPackageName());     // Catch: Exception -> L12
        r17.putExtra("extra_shortcut_id", r5);     // Catch: Exception -> L12
        r17.putExtra("extra_result", true);     // Catch: Exception -> L12
        if (Build.VERSION.SDK_INT < 31) goto L10;
        int r18 = 201326592;
    L11:
        r3 = PendingIntent.getBroadcast(r10, r5.hashCode(), r17, r18);     // Catch: Exception -> L12
        goto L15
    L10:
        r18 = 134217728;
        goto L11
    }

    private static final x a(String r2, o r3) {
        d.h.b.o.e(r3, "$this$build");
        r3.a(r2);
        r3.a(-1);
        r3.b(ZeusTransformUtils.mapRes(R.drawable.ic_pin_short_cut_background, "drawable", "ic_pin_short_cut_background"));
        return x.f38692a;
    }

    public final a a(Context r3, ShortcutInfo r4, PendingIntent r5) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "context");
        d.h.b.o.e(r4, "shortcutInfo");
        if (Build.VERSION.SDK_INT < 26) goto L5;
        ShortcutManager r6 = (ShortcutManager) ZeusTransformUtils.preCheckCast(r2.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L11;
        return a.f24486b;
    L11:
        if (r6.isRequestPinShortcutSupported() == false) goto L13;
        if (r5 != null) goto L27;
        IntentSender r7 = null;
    L19:
        if (r6.requestPinShortcut(r4, r7) == true) goto L24;
        return a.f24486b;
    L24:
        return a.f24485a;
    L16:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "changeLauncherStateViaShortcut request failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return a.f24487c;
    L27:
        r7 = r5.getIntentSender();     // Catch: Exception -> L16
        goto L19
    L13:
        return a.f24486b;
    L5:
        return a.f24486b;
    }
}
