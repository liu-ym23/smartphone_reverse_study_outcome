package ab2;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import com.bytedance.android.livehostapi.business.IMiddleWareHostEmoji;
import com.bytedance.android.livesdk.y5;
import fb2.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import jc1.k;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f2470c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cb2.a f2471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bb2.a f2472b;

    public static b a() {
        if (f2470c != null) goto L6;
        f2470c = new b();
    L6:
        return f2470c;
    }

    public b() {
        this.f2471a = new cb2.a();
        this.f2472b = new bb2.a();
    }

    public final void b(SpannableString r110, int r111) {
        this.f2472b.getClass();
        Iterator r100 = ((ArrayList) bb2.a.c(r110)).iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        db2.a r101 = (db2.a) r100.next();
        Drawable r102 = r101.f467796a;
        if (r102 == null) goto L4;
        bb2.a.a(r110, r102, r101.f467797b, r101.f467798c, (int) (c.b(r111, r102, false) + 0.5f), r111, null);
        goto L4
    }

    public final SpannableString c(CharSequence r110, float r111) {
        this.f2472b.getClass();
        if (r110 != null) goto L5;
        return null;
    L5:
        e90.a[] r100 = new e90.a[0];
        if ((r110 instanceof Spannable) == false) goto L15;
        Spannable r101 = (Spannable) r110;
        eb2.a[] r102 = (eb2.a[]) r101.getSpans(0, r110.length(), eb2.a.class);
        if (r102 != null) goto L10;
    L14:
        r100 = (e90.a[]) r101.getSpans(0, r110.length(), e90.a.class);
        goto L15
    L10:
        if (r102.length <= 0) goto L14;
        int r103 = r102.length;
        int r104 = 0;
    L12:
        if (r104 >= r103) goto L14;
        r101.removeSpan(r102[r104]);
        r104 = r104 + 1;
    L15:
        SpannableString r105 = SpannableString.valueOf(r110);
        Matcher r112 = bb2.a.f18529b.matcher(r110);     // Catch: Exception -> L37
    L18:
        if (r112.find() == false) goto L36;
        String r106 = r112.group();
        int r107 = r112.start();
        int r108 = r112.end();
        if (y5.f162549a.getValue().booleanValue() == false) goto L32;
        int r109 = r100.length;
        int r113 = 0;
    L22:
        if (r113 >= r109) goto L29;
        e90.a r114 = r100[r113];
        int r115 = r105.getSpanStart(r114);
        int r116 = r105.getSpanEnd(r114);
        if (r114.b() == false) goto L28;
        if (r107 < r115) goto L28;
        if (r108 > r116) goto L28;
        boolean r117 = true;
    L30:
        if (r117 == false) goto L32;
    L28:
        r113 = r113 + 1;
        goto L22
    L29:
        r117 = false;
    L32:
        Drawable r118 = ((IMiddleWareHostEmoji) k.f(IMiddleWareHostEmoji.class)).getRealDrawable(r106);
        if (r118 == null) goto L18;
        bb2.a.a(r105, r118, r107, r108, (int) (c.b(r111, r118, false) + 0.5f), (int) (0.5f + r111), String.valueOf(r110.subSequence(r107, r108)));
    L36:
        return r105;
    }
}
