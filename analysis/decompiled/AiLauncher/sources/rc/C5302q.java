package rc;

import com.autonavi.aps.amapapi.config.Const;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/* renamed from: rc.q, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5302q extends AbstractC5276d implements H0 {

    /* renamed from: g, reason: collision with root package name */
    public static Map<String, Cc.c> f39376g = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final Cc.c f39377d;

    /* renamed from: e, reason: collision with root package name */
    public final Cc.c f39378e;

    /* renamed from: f, reason: collision with root package name */
    public final I0 f39379f;

    static {
        k();
    }

    public C5302q(AbstractC5276d abstractC5276d, Cc.c cVar, Cc.c cVar2) {
        this.f39379f = new I0(abstractC5276d);
        this.f39377d = cVar;
        this.f39378e = cVar2;
    }

    public static Cc.c i(float f10, float f11, float f12, float f13) {
        float f14 = 1.0f - f13;
        return new Cc.c((1.0f - f10) * f14, (1.0f - f11) * f14, f14 * (1.0f - f12));
    }

    public static Cc.c j(String str) {
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.length() >= 1) {
                if (strTrim.charAt(0) == '#') {
                    return Cc.c.a(strTrim);
                }
                if (strTrim.indexOf(44) != -1 || strTrim.indexOf(59) != -1) {
                    StringTokenizer stringTokenizer = new StringTokenizer(strTrim, ";,");
                    int iCountTokens = stringTokenizer.countTokens();
                    if (iCountTokens == 3) {
                        try {
                            String strTrim2 = stringTokenizer.nextToken().trim();
                            String strTrim3 = stringTokenizer.nextToken().trim();
                            String strTrim4 = stringTokenizer.nextToken().trim();
                            float f10 = Float.parseFloat(strTrim2);
                            float f11 = Float.parseFloat(strTrim3);
                            float f12 = Float.parseFloat(strTrim4);
                            return (f10 == ((float) ((int) f10)) && f11 == ((float) ((int) f11)) && f12 == ((float) ((int) f12)) && strTrim2.indexOf(46) == -1 && strTrim3.indexOf(46) == -1 && strTrim4.indexOf(46) == -1) ? new Cc.c((int) Math.min(255.0f, Math.max(0.0f, f10)), (int) Math.min(255.0f, Math.max(0.0f, f11)), (int) Math.min(255.0f, Math.max(0.0f, f12))) : new Cc.c(Math.min(1.0f, Math.max(0.0f, f10)), Math.min(1.0f, Math.max(0.0f, f11)), Math.min(1.0f, Math.max(0.0f, f12)));
                        } catch (NumberFormatException unused) {
                            return Cc.c.f1967b;
                        }
                    }
                    if (iCountTokens == 4) {
                        try {
                            return i(Math.min(1.0f, Math.max(0.0f, Float.parseFloat(stringTokenizer.nextToken().trim()))), Math.min(1.0f, Math.max(0.0f, Float.parseFloat(stringTokenizer.nextToken().trim()))), Math.min(1.0f, Math.max(0.0f, Float.parseFloat(stringTokenizer.nextToken().trim()))), Math.min(1.0f, Math.max(0.0f, Float.parseFloat(stringTokenizer.nextToken().trim()))));
                        } catch (NumberFormatException unused2) {
                            return Cc.c.f1967b;
                        }
                    }
                }
                Cc.c cVar = f39376g.get(strTrim.toLowerCase());
                if (cVar != null) {
                    return cVar;
                }
                if (strTrim.indexOf(46) != -1) {
                    try {
                        float fMin = Math.min(1.0f, Math.max(Float.parseFloat(strTrim), 0.0f));
                        return new Cc.c(fMin, fMin, fMin);
                    } catch (NumberFormatException unused3) {
                    }
                }
                return Cc.c.a(Const.STR_MART_WELL + strTrim);
            }
        }
        return Cc.c.f1967b;
    }

    public static void k() {
        f39376g.put("black", Cc.c.f1967b);
        f39376g.put("white", Cc.c.f1968c);
        f39376g.put("red", Cc.c.f1969d);
        f39376g.put("green", Cc.c.f1970e);
        f39376g.put("blue", Cc.c.f1971f);
        f39376g.put("cyan", Cc.c.f1972g);
        f39376g.put("magenta", Cc.c.f1973h);
        f39376g.put("yellow", Cc.c.f1974i);
        f39376g.put("greenyellow", i(0.15f, 0.0f, 0.69f, 0.0f));
        f39376g.put("goldenrod", i(0.0f, 0.1f, 0.84f, 0.0f));
        f39376g.put("dandelion", i(0.0f, 0.29f, 0.84f, 0.0f));
        f39376g.put("apricot", i(0.0f, 0.32f, 0.52f, 0.0f));
        f39376g.put("peach", i(0.0f, 0.5f, 0.7f, 0.0f));
        f39376g.put("melon", i(0.0f, 0.46f, 0.5f, 0.0f));
        f39376g.put("yelloworange", i(0.0f, 0.42f, 1.0f, 0.0f));
        f39376g.put("orange", i(0.0f, 0.61f, 0.87f, 0.0f));
        f39376g.put("burntorange", i(0.0f, 0.51f, 1.0f, 0.0f));
        f39376g.put("bittersweet", i(0.0f, 0.75f, 1.0f, 0.24f));
        f39376g.put("redorange", i(0.0f, 0.77f, 0.87f, 0.0f));
        f39376g.put("mahogany", i(0.0f, 0.85f, 0.87f, 0.35f));
        f39376g.put("maroon", i(0.0f, 0.87f, 0.68f, 0.32f));
        f39376g.put("brickred", i(0.0f, 0.89f, 0.94f, 0.28f));
        f39376g.put("orangered", i(0.0f, 1.0f, 0.5f, 0.0f));
        f39376g.put("rubinered", i(0.0f, 1.0f, 0.13f, 0.0f));
        f39376g.put("wildstrawberry", i(0.0f, 0.96f, 0.39f, 0.0f));
        f39376g.put("salmon", i(0.0f, 0.53f, 0.38f, 0.0f));
        f39376g.put("carnationpink", i(0.0f, 0.63f, 0.0f, 0.0f));
        f39376g.put("magenta", i(0.0f, 1.0f, 0.0f, 0.0f));
        f39376g.put("violetred", i(0.0f, 0.81f, 0.0f, 0.0f));
        f39376g.put("rhodamine", i(0.0f, 0.82f, 0.0f, 0.0f));
        f39376g.put("mulberry", i(0.34f, 0.9f, 0.0f, 0.02f));
        f39376g.put("redviolet", i(0.07f, 0.9f, 0.0f, 0.34f));
        f39376g.put("fuchsia", i(0.47f, 0.91f, 0.0f, 0.08f));
        f39376g.put("lavender", i(0.0f, 0.48f, 0.0f, 0.0f));
        f39376g.put("thistle", i(0.12f, 0.59f, 0.0f, 0.0f));
        f39376g.put("orchid", i(0.32f, 0.64f, 0.0f, 0.0f));
        f39376g.put("darkorchid", i(0.4f, 0.8f, 0.2f, 0.0f));
        f39376g.put("purple", i(0.45f, 0.86f, 0.0f, 0.0f));
        f39376g.put("plum", i(0.5f, 1.0f, 0.0f, 0.0f));
        f39376g.put("violet", i(0.79f, 0.88f, 0.0f, 0.0f));
        f39376g.put("royalpurple", i(0.75f, 0.9f, 0.0f, 0.0f));
        f39376g.put("blueviolet", i(0.86f, 0.91f, 0.0f, 0.04f));
        f39376g.put("periwinkle", i(0.57f, 0.55f, 0.0f, 0.0f));
        f39376g.put("cadetblue", i(0.62f, 0.57f, 0.23f, 0.0f));
        f39376g.put("cornflowerblue", i(0.65f, 0.13f, 0.0f, 0.0f));
        f39376g.put("midnightblue", i(0.98f, 0.13f, 0.0f, 0.43f));
        f39376g.put("navyblue", i(0.94f, 0.54f, 0.0f, 0.0f));
        f39376g.put("royalblue", i(1.0f, 0.5f, 0.0f, 0.0f));
        f39376g.put("cerulean", i(0.94f, 0.11f, 0.0f, 0.0f));
        f39376g.put("processblue", i(0.96f, 0.0f, 0.0f, 0.0f));
        f39376g.put("skyblue", i(0.62f, 0.0f, 0.12f, 0.0f));
        f39376g.put("turquoise", i(0.85f, 0.0f, 0.2f, 0.0f));
        f39376g.put("tealblue", i(0.86f, 0.0f, 0.34f, 0.02f));
        f39376g.put("aquamarine", i(0.82f, 0.0f, 0.3f, 0.0f));
        f39376g.put("bluegreen", i(0.85f, 0.0f, 0.33f, 0.0f));
        f39376g.put("emerald", i(1.0f, 0.0f, 0.5f, 0.0f));
        f39376g.put("junglegreen", i(0.99f, 0.0f, 0.52f, 0.0f));
        f39376g.put("seagreen", i(0.69f, 0.0f, 0.5f, 0.0f));
        f39376g.put("forestgreen", i(0.91f, 0.0f, 0.88f, 0.12f));
        f39376g.put("pinegreen", i(0.92f, 0.0f, 0.59f, 0.25f));
        f39376g.put("limegreen", i(0.5f, 0.0f, 1.0f, 0.0f));
        f39376g.put("yellowgreen", i(0.44f, 0.0f, 0.74f, 0.0f));
        f39376g.put("springgreen", i(0.26f, 0.0f, 0.76f, 0.0f));
        f39376g.put("olivegreen", i(0.64f, 0.0f, 0.95f, 0.4f));
        f39376g.put("rawsienna", i(0.0f, 0.72f, 1.0f, 0.45f));
        f39376g.put("sepia", i(0.0f, 0.83f, 1.0f, 0.7f));
        f39376g.put("brown", i(0.0f, 0.81f, 1.0f, 0.6f));
        f39376g.put("tan", i(0.14f, 0.42f, 0.56f, 0.0f));
        f39376g.put("gray", i(0.0f, 0.0f, 0.0f, 0.5f));
    }

    @Override // rc.H0
    public void a(C5315x c5315x) {
        this.f39379f.a(c5315x);
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        y02.f39193l = true;
        Y0 y0A = y02.a();
        Cc.c cVar = this.f39377d;
        if (cVar != null) {
            y0A.t(cVar);
        }
        Cc.c cVar2 = this.f39378e;
        if (cVar2 != null) {
            y0A.u(cVar2);
        }
        return this.f39379f.f(y0A);
    }

    @Override // rc.AbstractC5276d
    public int g() {
        return this.f39379f.g();
    }

    @Override // rc.AbstractC5276d
    public int h() {
        return this.f39379f.h();
    }
}
