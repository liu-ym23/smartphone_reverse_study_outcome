package okhttp3.internal.e;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import e.aa;
import e.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.ad;
import okhttp3.ae;
import okhttp3.m;
import okhttp3.n;
import okhttp3.w;
import okhttp3.x;

/* JADX INFO: compiled from: BridgeInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n f39914a;

    public a(n r3) {
        n r4 = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.aiagent.plugin");
        o.e(r4, "cookieJar");
        this.f39914a = r4;
    }

    @Override // okhttp3.w
    public ad intercept(w.a r14) {
        w.a r15 = (w.a) ZeusTransformUtils.wrapperContextForParams(r14, w.a.class, "com.obric.aiagent.plugin");
        o.e(r15, "chain");
        ab r0 = r15.a();
        ab.a r2 = r0.h();
        ac r3 = r0.d();
        if (r3 == null) goto L11;
        x r8 = r3.a();
        if (r8 == null) goto L7;
        r2.a(DownloadHelper.CONTENT_TYPE, r8.toString());
    L7:
        long r9 = r3.b();
        if (r9 == (-1)) goto L10;
        r2.a(DownloadUtils.CONTENT_LENGTH, String.valueOf(r9));
        r2.b(DownloadHelper.TRANSFER_ENCODING);
        goto L11
    L10:
        r2.a(DownloadHelper.TRANSFER_ENCODING, DownloadHelper.VALUE_CHUNKED);
        r2.b(DownloadUtils.CONTENT_LENGTH);
    L11:
        boolean r10 = false;
        if (r0.a(DownloadConstants.HOST) != null) goto L15;
        r2.a(DownloadConstants.HOST, okhttp3.internal.c.a(r0.a(), false, 1, null));
    L15:
        if (r0.a("Connection") != null) goto L18;
        r2.a("Connection", "Keep-Alive");
    L18:
        if (r0.a(DownloadHelper.ACCEPT_ENCODING) == null) goto L20;
    L22:
        List<m> r4 = this.f39914a.a(r0.a());
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L26;
        r2.a("Cookie", a(r4));
    L26:
        if (r0.a(DownloadConstants.USER_AGENT) != null) goto L28;
        r2.a(DownloadConstants.USER_AGENT, "okhttp/4.12.0");
    L28:
        ad r16 = r15.a(r2.b());
        e.a(this.f39914a, r0.a(), r16.f());
        ad.a r13 = r16.o().a(r0);
        if (r10 == false) goto L38;
        if (d.o.o.a(DownloadHelper.GZIP, ad.a(r16, DownloadHelper.CONTENT_ENCODING, null, 2, null), true) == false) goto L38;
        if (e.a(r16) == false) goto L38;
        ae r5 = r16.g();
        if (r5 == null) goto L38;
        l r11 = new l((aa) ZeusTransformUtils.preCheckCast(r5.d(), aa.class, "com.obric.aiagent.plugin"));
        r13.a(r16.f().d().b(DownloadHelper.CONTENT_ENCODING).b(DownloadUtils.CONTENT_LENGTH).b());
        r13.a((ae) ZeusTransformUtils.preCheckCast(new h(ad.a(r16, DownloadHelper.CONTENT_TYPE, null, 2, null), -1, e.o.a((aa) ZeusTransformUtils.preCheckCast(r11, aa.class, "com.obric.aiagent.plugin"))), ae.class, "com.obric.aiagent.plugin"));
    L38:
        return r13.b();
    L20:
        if (r0.a("Range") != null) goto L22;
        r2.a(DownloadHelper.ACCEPT_ENCODING, DownloadHelper.GZIP);
        r10 = true;
        goto L22
    }

    private final String a(List<m> r6) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        StringBuilder r7 = new StringBuilder();
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r1 = 0;
    L4:
        if (r8.hasNext() == false) goto L12;
        Object r2 = r8.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        p.c();
    L8:
        m r4 = (m) ZeusTransformUtils.preCheckCast(r2, m.class, "com.obric.aiagent.plugin");
        if (r1 <= 0) goto L11;
        r7.append("; ");
    L11:
        r7.append(r4.a()).append('=').append(r4.b());
        r1 = r3;
        goto L4
    L12:
        String r9 = r7.toString();
        o.c(r9, "StringBuilder().apply(builderAction).toString()");
        return r9;
    }
}
