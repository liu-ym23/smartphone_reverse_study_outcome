package com.bytedance.android.btm.impl.monitor;

import android.os.MessageQueue;
import android.util.Log;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.bytedance.android.btm.impl.setting.i;
import com.bytedance.android.btm.impl.setting.k;
import com.bytedance.android.btm.impl.thread.ThreadUtils;
import com.obric.sva.sdk.data.ISmModel;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class BtmMonitor implements com.bytedance.android.btm.api.inner.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f42159a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f42160b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BtmMonitor f42161c = null;

    public BtmMonitor() {
    }

    static {
        f42161c = new BtmMonitor();
        f42159a = LazyKt.lazy(BtmMonitor$btmFormatRegex$2.INSTANCE);
        f42160b = LazyKt.lazy(BtmMonitor$FERegisterBtmFormatRegex$2.INSTANCE);
    }

    public static final String e() {
        JSONObject r100 = new JSONObject();
        Iterator r101 = CollectionsKt.asReversedMutable(com.bytedance.android.btm.impl.page.b.f42255a).iterator();
        int r102 = 10;
    L4:
        if (r101.hasNext() == false) goto L15;
        com.bytedance.android.btm.impl.util.f r103 = (com.bytedance.android.btm.impl.util.f) r101.next();
        if (r102 <= 0) goto L24;
        T r104 = r103.get();
        if (r104 == 0) goto L12;
        String r105 = r104.getClass().getCanonicalName();
        if (r105 == null) goto L12;
        String r106 = BtmPageRecorder.f42212a;     // Catch: Throwable -> L16
        r100.put(r105, BtmPageRecorder.k(r104));     // Catch: Throwable -> L16
    L12:
        r102 = r102 - 1;
        goto L4
    L24:
        return r100.toString();
    L15:
        return r100.toString();
    }

    public static final k d(i r100, JSONObject r101) {
        Iterator<k> r102 = r100.a().iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        k r103 = r102.next();
        if (r103.c().isEmpty() == true) goto L16;
        if (r103.c().contains(r101.optString(r103.b())) == false) goto L4;
        return r103;
    L16:
        return r103;
    L11:
        return new k();
    }

    @Override // com.bytedance.android.btm.api.inner.g
    public final void b(boolean r100, Function0<? extends Object> r101) {
        if (r100 == true) goto L5;
        r101.invoke().toString();
        BtmHostDependManager.F.c();
        return;
    }

    public static final void f(Throwable r100, JSONObject r101, JSONObject r102) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (ThreadUtils.b() == true) goto L34;
        String r103 = Log.getStackTraceString(r100);
        int r104 = Math.min(r103.length(), 1000);
        boolean r105 = false;
        String r106 = r103.substring(0, r104);
        if (r104 <= 0) goto L31;
        r102.put("stack_trace", r106);
        com.bytedance.android.btm.impl.util.d r107 = com.bytedance.android.btm.impl.util.d.f42499a;
        byte[] r108 = MessageDigest.getInstance("MD5").digest(r106.getBytes(Charsets.UTF_8));     // Catch: NoSuchAlgorithmException -> L18
        StringBuffer r109 = new StringBuffer();     // Catch: NoSuchAlgorithmException -> L18
        int r110 = r108.length;     // Catch: NoSuchAlgorithmException -> L18
        int r111 = 0;
    L11:
        if (r111 >= r110) goto L16;
        String r112 = Integer.toHexString(r108[r111] & UByte.MAX_VALUE);     // Catch: NoSuchAlgorithmException -> L18
        if (r112.length() >= 2) goto L15;
        r112 = '0' + r112;     // Catch: NoSuchAlgorithmException -> L18
    L15:
        r109.append(r112);     // Catch: NoSuchAlgorithmException -> L18
        r111 = r111 + 1;     // Catch: NoSuchAlgorithmException -> L18
        goto L11
    L16:
        String r113 = r109.toString();     // Catch: NoSuchAlgorithmException -> L18
    L21:
        if (r113.length() <= 0) goto L23;
        r105 = true;
    L23:
        if (r105 == false) goto L32;
        r101.put(BindCardPayConfirmConstants.Key.TRACE_ID, r113);
        return;
    L32:
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
        r113 = "";
        goto L21
    L31:
        return;
    }

    public static void g(com.bytedance.android.btm.api.model.c r100, final String r101, final Object r102, final PageInfo r110) {
        final Boolean r103 = null;
        final String r104 = r100.f42011a;
        final boolean r105 = r100.a();
        MessageQueue r106 = com.bytedance.android.btm.impl.util.b.f42496a;
        com.bytedance.android.btm.impl.util.b.a(new BtmMonitor$checkBtm$1(r104, r105, r101, r102, r110, r103));
    }

    @Override // com.bytedance.android.btm.api.inner.g
    public final void a(int r110, String r111, Object r112, Throwable r113, boolean r114) {
        String r100 = BtmPageRecorder.f42212a;
        k(this, r110, r111, r112, BtmPageRecorder.j(r112), false, false, r113, r114, null, null, ISmModel.VERSION_0300);
    }

    @Override // com.bytedance.android.btm.api.inner.g
    public final void c(int r110, String r111, Object r112, Throwable r113, boolean r114, Function1<? super JSONObject, Unit> r115) {
        String r100 = BtmPageRecorder.f42212a;
        k(this, r110, r111, r112, BtmPageRecorder.j(r112), false, false, r113, r114, null, r115, 256);
    }

    public final void h(String r110, final boolean r111, final String r112, Object r113, PageInfo r114, final Boolean r210) {
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L12;
        if (r111 == false) goto L9;
        int r101 = 2000;
    L10:
        k(this, r101, null, r113, r114, false, false, null, false, null, new BtmMonitor$checkBtmInner$1(r112, r111, r210), TTVideoEngineInterface.PLAYER_OPTION_LAZY_SEEK);
        return;
    L9:
        r101 = DataLoaderHelper.DATALOADER_KEY_INT_UPDATE_FILE_INTERNAL;
        goto L10
    L12:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final void i(final String r110, final String r111, final Object r112, Throwable r113, final boolean r114, final Function1 r115) {
        String r100 = BtmPageRecorder.f42212a;
        final PageInfo r101 = BtmPageRecorder.j(r112);
        final boolean r102 = false;
        final BtmMonitor$monitor$1 r103 = BtmMonitor$monitor$1.INSTANCE;
        if (r113 == null) goto L5;
        final Throwable r104 = r113;
    L6:
        Runnable r105 = new BtmMonitor$monitor$$inlined$monitor$btm_impl_cnRelease$1(r114, r101, r112, r115, r111, r103, r102, r104, r110);
        if (r114 == false) goto L9;
        r105.run();
        return;
    L9:
        com.bytedance.android.btm.impl.thread.b.f42488e.a(r105, true);
        return;
    L5:
        r104 = null;
        goto L6
    }

    public static void j(final int r100, PageInfo r110, String r111, Function0 r112, Function1 r113, Function2 r114, int r115) {
        if ((r115 & 2) == 0) goto L5;
        r110 = null;
    L5:
        final PageInfo r101 = r110;
        if ((r115 & 4) == 0) goto L8;
        r111 = "null";
    L8:
        final String r102 = r111;
        if ((r115 & 8) == 0) goto L11;
        r112 = BtmMonitor$monitor$4.INSTANCE;
    L11:
        final Function0 r103 = r112;
        final Throwable r104 = null;
        final boolean r105 = false;
        if ((r115 & 64) == 0) goto L14;
        r113 = BtmMonitor$monitor$5.INSTANCE;
    L14:
        final Function1 r106 = r113;
        if ((r115 & 128) == 0) goto L17;
        r114 = BtmMonitor$monitor$6.INSTANCE;
    L17:
        final Function2 r107 = r114;
        Runnable r116 = new BtmMonitor$monitor$$inlined$monitor$btm_impl_cnRelease$2(r105, r100, r101, r102, r106, r103, r107, r104);
        com.bytedance.android.btm.impl.thread.b.f42488e.a(r116, true);
    }

    public static void k(BtmMonitor r110, final int r111, String r112, Object r113, PageInfo r114, boolean r115, boolean r116, Throwable r117, boolean r118, Function0 r119, Function1 r210, int r211) {
        if ((r211 & 2) == 0) goto L5;
        String r100 = "";
    L6:
        Throwable r101 = null;
        if ((r211 & 4) == 0) goto L9;
        Object r102 = null;
    L11:
        if ((r211 & 8) == 0) goto L13;
        PageInfo r103 = null;
    L14:
        boolean r104 = false;
        if ((r211 & 16) == 0) goto L17;
        boolean r105 = false;
    L19:
        if ((r211 & 32) == 0) goto L21;
        boolean r106 = false;
    L23:
        if ((r211 & 64) == 0) goto L25;
        Throwable r107 = null;
    L27:
        if ((r211 & 128) != 0) goto L31;
        r104 = r118;
    L31:
        if ((r211 & 256) == 0) goto L33;
        Function0 r108 = BtmMonitor$monitor$8.INSTANCE;
    L35:
        if ((r211 & 512) == 0) goto L37;
        Function1 r109 = BtmMonitor$monitor$9.INSTANCE;
    L38:
        r110.getClass();
        if (r107 == null) goto L41;
        r101 = r107;
    L43:
        final boolean r120 = r104;
        final PageInfo r121 = r103;
        final Object r122 = r102;
        final Function1 r123 = r109;
        final String r124 = r100;
        final Function0 r125 = r108;
        final boolean r212 = r105;
        final Throwable r213 = r101;
        Runnable r126 = new BtmMonitor$monitor$$inlined$monitor$btm_impl_cnRelease$3(r120, r121, r122, r111, r123, r124, r125, r212, r213);
        if (r104 == false) goto L46;
        r126.run();
        return;
    L46:
        com.bytedance.android.btm.impl.thread.b.f42488e.a(r126, true);
        return;
    L41:
        if (r106 == false) goto L43;
        r101 = new Throwable();
        goto L43
    L37:
        r109 = r210;
        goto L38
    L33:
        r108 = r119;
        goto L35
    L25:
        r107 = r117;
        goto L27
    L21:
        r106 = r116;
        goto L23
    L17:
        r105 = r115;
        goto L19
    L13:
        r103 = r114;
        goto L14
    L9:
        r102 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L6
    }
}
