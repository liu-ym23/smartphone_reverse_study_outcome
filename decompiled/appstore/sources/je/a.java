package je;

import com.smt.obric.appstore.domain.downloader.d;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20999a = null;

    static {
        f20999a = new a();
    }

    public a() {
    }

    public final boolean a(Long r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        if (((int) r10.longValue()) != (-1)) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean b(Long r10, Long r11, Long r12) {
        if (d.b(r10) == true) goto L5;
        return false;
    L5:
        if (r11 == null) goto L7;
        Integer r13 = Integer.valueOf((int) r11.longValue());
    L8:
        if (r13 != null) goto L11;
    L12:
        if (r13 != null) goto L15;
        return false;
    L15:
        if (r13.intValue() != (-1)) goto L18;
    L16:
        return true;
    L18:
        return false;
    L11:
        if (r13.intValue() == (-2)) goto L16;
    L7:
        r13 = null;
        goto L8
    }
}
