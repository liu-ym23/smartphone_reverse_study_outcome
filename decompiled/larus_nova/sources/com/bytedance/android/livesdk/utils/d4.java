package com.bytedance.android.livesdk.utils;

import com.bytedance.android.livesdk.config.b10;
import com.bytedance.android.livesdk.config.d20;
import com.bytedance.android.livesdk.config.hv0;
import com.bytedance.android.livesdk.config.iz0;
import com.bytedance.android.livesdk.config.jz0;
import com.bytedance.android.livesdk.config.l80;
import com.bytedance.android.livesdk.config.p80;
import com.bytedance.android.livesdk.config.qp0;
import com.bytedance.android.livesdk.config.ro0;
import com.bytedance.android.livesdk.config.s80;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f158930a = 0;

    @JvmStatic
    public static final boolean d() {
        return d20.f119996a.getValue().booleanValue();
    }

    @JvmStatic
    public static final boolean e() {
        return jz0.f120563a.getValue().booleanValue();
    }

    @JvmStatic
    public static final vs1.c g() {
        return b10.f119836a.getValue();
    }

    @JvmStatic
    public static final int i() {
        return hv0.f120407a.getValue().intValue();
    }

    @JvmStatic
    public static final long k() {
        return p80.f120958a.getValue().longValue();
    }

    @JvmStatic
    public static final long l() {
        return s80.f121189a.getValue().longValue();
    }

    @JvmStatic
    public static final List<String> m() {
        List<String> r100 = (List) qp0.f121074a.getValue();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return CollectionsKt.emptyList();
    }

    @JvmStatic
    public static final boolean o() {
        if (iz0.f120490a.getValue().booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (ro0.f121147a.getValue().booleanValue() == true) goto L7;
        return true;
    }

    static {
    }

    @JvmStatic
    public static final byte[] c(tlc.f r100) {
        if (r100 == null) goto L4;
        byte[] r101 = r100.f546764e;
        if (Intrinsics.areEqual(f(r100), DownloadHelper.GZIP) == false) goto L14;
        ByteArrayInputStream r102 = new ByteArrayInputStream(r101);
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();
        GZIPInputStream r104 = new GZIPInputStream(r102);
        byte[] r105 = new byte[4096];
    L8:
        int r106 = r104.read(r105, 0, 4096);
        if (r106 == (-1)) goto L11;
        r103.write(r105, 0, r106);
        goto L8
    L11:
        r104.close();
        byte[] r107 = r103.toByteArray();
        r103.flush();
        r103.close();
        r102.close();
        return r107;
    L14:
        return r101;
    L4:
        return new byte[1];
    }

    @JvmStatic
    public static final String f(tlc.f r100) {
        if (r100 == null) goto L20;
        List<com.ss.ugc.live.sdk.msg.network.d> r101 = r100.f546765f;
        if (r101 == null) goto L21;
        Iterator<T> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((com.ss.ugc.live.sdk.msg.network.d) r103).f458296a, "compress_type") == false) goto L8;
    L13:
        com.ss.ugc.live.sdk.msg.network.d r104 = (com.ss.ugc.live.sdk.msg.network.d) r103;
        if (r104 != null) goto L16;
        return null;
    L16:
        return r104.f458297b;
    L12:
        r103 = null;
        goto L13
    L21:
        return null;
    L20:
        return null;
    }

    @JvmStatic
    public static final void n(vlc.d r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof vlc.a) == false) goto L8;
        ((vlc.a) r100).b(l80.f120659a.getValue().booleanValue());
        return;
    }

    @JvmStatic
    public static final void j(vlc.d r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "messageManager");
        Intrinsics.checkNotNullParameter(r101, "customParams");
        if ((r100 instanceof vlc.e) == false) goto L11;
        amc.e r102 = ((vlc.e) r100).q();
        if ((r102 instanceof hm2.h) == true) goto L7;
        r102 = null;
    L7:
        hm2.h r103 = (hm2.h) r102;
        if (r103 == null) goto L12;
        Intrinsics.checkNotNullParameter(r101, "customParams");
        r103.f485767d.putAll(r101);
        return;
    L12:
        return;
    }

    @JvmStatic
    public static final void a(vlc.d r100, int r101, vlc.l r102) {
        if ((r100 instanceof xlc.a) == true) goto L5;
        r100 = null;
    L5:
        xlc.a r103 = (xlc.a) r100;
        if (r103 == null) goto L9;
        r103.y(r101, r102);
        return;
    }

    @JvmStatic
    public static final void b(vlc.d r100, String r101, vlc.l r102) {
        Intrinsics.checkNotNullParameter(r101, "messageMethod");
        if ((r100 instanceof xlc.a) == true) goto L5;
        r100 = null;
    L5:
        xlc.a r103 = (xlc.a) r100;
        if (r103 == null) goto L9;
        r103.g(r101, r102);
        return;
    }

    @JvmStatic
    public static final <T extends tlc.d> T h(vlc.d r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$getLatestWRDSMessage");
        Intrinsics.checkNotNullParameter(r101, "messageMethod");
        if ((r100 instanceof xlc.a) == true) goto L5;
        r100 = null;
    L5:
        xlc.a r103 = (xlc.a) r100;
        if (r103 == null) goto L8;
        tlc.d r104 = r103.e(r101, r102);
    L10:
        if ((r104 instanceof tlc.d) == true) goto L13;
        return null;
    L13:
        return (T) r104;
    L8:
        r104 = null;
        goto L10
    }

    @JvmStatic
    public static final void p(vlc.d r100, ylc.e r101, long r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "messageManager");
        Intrinsics.checkNotNullParameter(r101, "wrdsManager");
        if ((r100 instanceof vlc.e) == false) goto L18;
        amc.e r105 = ((vlc.e) r100).q();
        if ((r105 instanceof hm2.h) == true) goto L7;
        r105 = null;
    L7:
        hm2.h r106 = (hm2.h) r105;
        if (r106 == null) goto L16;
        r106.f485788y = r102;
        r106.A = r103;
        r106.f485770g = r104;
        List<vlc.b> r107 = r106.C;
        if (r107 == null) goto L16;
        List r108 = CollectionsKt.filterIsInstance(r107, com.bytedance.android.livesdk.message.interceptor.d.class);
        if (r108 == null) goto L16;
        com.bytedance.android.livesdk.message.interceptor.d r109 = (com.bytedance.android.livesdk.message.interceptor.d) CollectionsKt.firstOrNull(r108);
        if (r109 == null) goto L16;
        r109.f153532a = r102;
    L16:
        r101.f568360f = r102;
        bc2.c.b("update room params, roomId: " + r102 + ", roomTag: " + r103 + ", isBlockWelcomeMessage: " + r104);
        return;
    }
}
