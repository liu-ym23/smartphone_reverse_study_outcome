package com.obric.autogui.effects;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Process;
import com.obric.autoaction.vdplayer.components.cursor.d;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.h.b.h;
import d.h.b.o;
import d.n;
import java.util.List;

/* JADX INFO: compiled from: VDPlayerEffectProviderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class VDPlayerEffectProviderImpl extends PluginContentProvider {
    public static final String AUTHORITY = "com.obric.assistantaiagent.provider.VDPlayerEffect";
    private static final String BROWSER_PACKAGE_NAME = "com.obric.browser";
    private static final int CLICK_COORDINATE_COUNT = 2;
    public static final a Companion = null;
    public static final String KEY_CLICKED_POS = "clicked_pos";
    public static final String KEY_SWIPE_POS = "swipe_pos";
    public static final String KEY_THOUGHT = "thought";
    public static final String METHOD_SHOW = "show";
    private static final float MIN_POSITION_PX = 0.0f;
    private static final int SWIPE_COORDINATE_COUNT = 4;
    private static final String TAG = "VDPlayerEffectProvider";

    /* JADX INFO: compiled from: VDPlayerEffectProviderImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ String lambda$RLv3hTa0OEzcDfpQkYduaTYwy5s(List r0) {
        return call$lambda$3(r0);
    }

    public static /* synthetic */ String lambda$XbM5DyZu6MkSKVmYQBDOKrOCVhQ(List r0, List r1, String r2) {
        return call$lambda$2(r0, r1, r2);
    }

    public int delete(Uri r1, String r2, String[] r3) {
        o.e(r1, "uri");
        return 0;
    }

    public String getType(Uri r1) {
        o.e(r1, "uri");
        return null;
    }

    public Uri insert(Uri r1, ContentValues r2) {
        o.e(r1, "uri");
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        o.e(r1, "uri");
        return null;
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        o.e(r1, "uri");
        return 0;
    }

    public VDPlayerEffectProviderImpl() {
    }

    public Bundle call(String r7, String r8, Bundle r9) {
        o.e(r7, "method");
        if (o.a(r7, METHOD_SHOW) == true) goto L7;
        Loog.INSTANCE.w(TAG, "ignore unsupported method=" + r7);
        Bundle r6 = Bundle.EMPTY;
        o.c(r6, "EMPTY");
        return r6;
    L7:
        if (isTrustedCaller() == true) goto L10;
        Loog.INSTANCE.w(TAG, "ignore untrusted caller uid=" + Binder.getCallingUid());
        Bundle r10 = Bundle.EMPTY;
        o.c(r10, "EMPTY");
        return r10;
    L10:
        final List<Float> r11 = readCoordinates(r9, "clicked_pos", 2);
        final List<Float> r0 = readCoordinates(r9, KEY_SWIPE_POS, 4);
        boolean r3 = false;
        if (r11 != null) goto L13;
        boolean r5 = true;
    L14:
        if (r0 != null) goto L16;
        r3 = true;
    L16:
        if (r5 != r3) goto L19;
        Loog.INSTANCE.w(TAG, "ignore invalid effect: exactly one of clicked_pos/swipe_pos is required");
        Bundle r12 = Bundle.EMPTY;
        o.c(r12, "EMPTY");
        return r12;
    L19:
        final String r4 = null;
        n.a r13 = n.f38560a;     // Catch: Throwable -> L26
        VDPlayerEffectProviderImpl r14 = (VDPlayerEffectProviderImpl) ZeusTransformUtils.preCheckCast(this, VDPlayerEffectProviderImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (r9 == null) goto L23;
        String r15 = r9.getString(KEY_THOUGHT);     // Catch: Throwable -> L26
    L24:
        Object r16 = n.f(r15);     // Catch: Throwable -> L26
    L29:
        if (n.b(r16) == false) goto L31;
        r16 = null;
    L31:
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.aiagent.plugin");
        if (r17 != null) goto L34;
    L36:
        Loog.INSTANCE.ip(TAG, new $$Lambda$VDPlayerEffectProviderImpl$XbM5DyZu6MkSKVmYQBDOKrOCVhQ(r11, r0, r4), new $$Lambda$VDPlayerEffectProviderImpl$RLv3hTa0OEzcDfpQkYduaTYwy5s(r11));
        d.f25391a.a(r4, r11, r0);
        Bundle r18 = Bundle.EMPTY;
        o.c(r18, "EMPTY");
        return r18;
    L34:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L36;
        r4 = r17;
        goto L36
    L23:
        r15 = null;
    L26:
        th = move-exception;
        n.a r19 = n.f38560a;
        r16 = n.f(d.o.a(th));
        goto L29
    L13:
        r5 = false;
        goto L14
    }

    private static final String call$lambda$2(List r2, List r3, String r4) {
        return "show clickPos=" + ((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin")) + " swipePos=" + ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin")) + " thought=" + r4;
    }

    private static final String call$lambda$3(List r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        StringBuilder r0 = new StringBuilder().append("show type=");
        if (r3 == null) goto L5;
        String r4 = "click";
    L7:
        return r0.append(r4).toString();
    L5:
        r4 = "swipe";
        goto L7
    }

    private final boolean isTrustedCaller() {
        int r0 = Binder.getCallingUid();
        if (r0 != Process.myUid()) goto L5;
        return true;
    L5:
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L15;
        PackageManager r5 = r4.getPackageManager();
        if (r5 == null) goto L15;
        String[] r6 = r5.getPackagesForUid(r0);
        if (r6 == null) goto L15;
        if (i.b(r6, BROWSER_PACKAGE_NAME) != true) goto L15;
        return true;
    L15:
        return false;
    }

    private final List<Float> readCoordinates(Bundle r5, String r6, int r7) {
        n.a r0 = n.f38560a;     // Catch: Throwable -> L9
        if (r5 == null) goto L6;
        float[] r8 = r5.getFloatArray(r6);     // Catch: Throwable -> L9
    L7:
        Object r9 = n.f(r8);     // Catch: Throwable -> L9
    L12:
        if (n.b(r9) == false) goto L14;
        r9 = null;
    L14:
        float[] r10 = (float[]) ZeusTransformUtils.preCheckCast(r9, float[].class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L17;
        return null;
    L17:
        boolean r1 = true;
        if (r10.length != r7) goto L38;
        int r11 = r10.length;
        int r12 = 0;
    L20:
        if (r12 >= r11) goto L35;
        float r2 = r10[r12];
        if (Float.isInfinite(r2) == false) goto L24;
    L26:
        boolean r3 = false;
    L27:
        if (r3 == true) goto L29;
    L31:
        boolean r4 = false;
    L32:
        if (r4 == false) goto L33;
        r12 = r12 + 1;
        goto L20
    L33:
        boolean r13 = false;
    L36:
        if (r13 == false) goto L38;
    L39:
        if (r1 == true) goto L42;
        r10 = null;
    L42:
        if (r10 != null) goto L44;
        return null;
    L44:
        return i.d(r10);
    L29:
        if (r2 < 0.0f) goto L31;
        r4 = true;
        goto L32
    L24:
        if (Float.isNaN(r2) == true) goto L26;
        r3 = true;
        goto L27
    L35:
        r13 = true;
    L38:
        r1 = false;
        goto L39
    L6:
        r8 = null;
    L9:
        th = move-exception;
        n.a r14 = n.f38560a;
        r9 = n.f(d.o.a(th));
        goto L12
    }
}
