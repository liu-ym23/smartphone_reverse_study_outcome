package ak2;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class k implements vlc.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f3987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ td.a f3988b;

    public k(l r100, com.bytedance.android.livesdk.livecommerce.messagev2.a r101) {
        this.f3987a = r100;
        this.f3988b = r101;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        this.f3987a.getClass();
        StringBuilder r101 = new StringBuilder("message received: Class: ");
        if (r100 == null) goto L5;
        String r102 = r100.getClass().getSimpleName();
    L6:
        r101.append(r102);
        r101.append(", msgId: ");
        if (r100 == null) goto L9;
        Long r103 = Long.valueOf(r100.getMessageId());
    L10:
        r101.append(r103);
        r101.append(", method: ");
        if (r100 == null) goto L13;
        String r104 = r100.getMessageMethod();
    L14:
        r101.append(r104);
        r101.append(", contentType=");
        boolean r105 = r100 instanceof fe.a;
        if (r105 == true) goto L17;
        tlc.d r106 = null;
    L18:
        fe.a r107 = (fe.a) r106;
        if (r107 == null) goto L21;
        String r108 = r107.getContentType();
    L22:
        r101.append(r108);
        Map r109 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("detail", r101.toString())});
        xh.b r110 = new xh.b();
        r110.c(null);
        r110.b("VirtualMsgChannel");
        r110.a(r109);
        xh.c.a("Live").f(3, r110);
        if (r105 == true) goto L25;
        return;
    L25:
        if ((r100 instanceof ee.a) == false) goto L29;
        this.f3988b.f((ee.a) r100, true);
        return;
    L29:
        return;
    L21:
        r108 = null;
        goto L22
    L17:
        r106 = r100;
        goto L18
    L13:
        r104 = null;
        goto L14
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }
}
