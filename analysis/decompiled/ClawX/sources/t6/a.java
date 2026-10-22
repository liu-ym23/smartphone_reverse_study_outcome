package t6;

import androidx.fragment.app.l;
import c7.h;
import c7.p;
import com.stepos.stepclaw.SecurePrefs;
import k4.v;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import n6.k;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5583a;

    /* renamed from: b, reason: collision with root package name */
    public long f5584b;

    /* renamed from: c, reason: collision with root package name */
    public Object f5585c;

    public a(p source) {
        this.f5583a = 0;
        kotlin.jvm.internal.p.e(source, "source");
        this.f5585c = source;
        this.f5584b = 262144L;
    }

    public void a(int i8) {
        if (i8 < 64) {
            this.f5584b &= ~(1 << i8);
            return;
        }
        a aVar = (a) this.f5585c;
        if (aVar != null) {
            aVar.a(i8 - 64);
        }
    }

    public int b(int i8) {
        a aVar = (a) this.f5585c;
        if (aVar == null) {
            if (i8 >= 64) {
                return Long.bitCount(this.f5584b);
            }
            return Long.bitCount(((1 << i8) - 1) & this.f5584b);
        }
        if (i8 < 64) {
            return Long.bitCount(((1 << i8) - 1) & this.f5584b);
        }
        return Long.bitCount(this.f5584b) + aVar.b(i8 - 64);
    }

    public void c() {
        if (((a) this.f5585c) == null) {
            this.f5585c = new a();
        }
    }

    public boolean d(int i8) {
        if (i8 < 64) {
            return ((1 << i8) & this.f5584b) != 0;
        }
        c();
        return ((a) this.f5585c).d(i8 - 64);
    }

    public void e(int i8, boolean z) {
        if (i8 >= 64) {
            c();
            ((a) this.f5585c).e(i8 - 64, z);
            return;
        }
        long j4 = this.f5584b;
        boolean z2 = (Long.MIN_VALUE & j4) != 0;
        long j8 = (1 << i8) - 1;
        this.f5584b = ((j4 & (~j8)) << 1) | (j4 & j8);
        if (z) {
            i(i8);
        } else {
            a(i8);
        }
        if (z2 || ((a) this.f5585c) != null) {
            c();
            ((a) this.f5585c).e(0, z2);
        }
    }

    public k f() {
        l lVar = new l(1);
        while (true) {
            String strW = ((h) this.f5585c).w(this.f5584b);
            this.f5584b -= strW.length();
            if (strW.length() == 0) {
                return lVar.a();
            }
            int iQ1 = n.q1(strW, AbstractJsonLexerKt.COLON, 1, 4);
            if (iQ1 != -1) {
                String strSubstring = strW.substring(0, iQ1);
                kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
                String strSubstring2 = strW.substring(iQ1 + 1);
                kotlin.jvm.internal.p.d(strSubstring2, "substring(...)");
                v.p(lVar, strSubstring, strSubstring2);
            } else if (strW.charAt(0) == ':') {
                String strSubstring3 = strW.substring(1);
                kotlin.jvm.internal.p.d(strSubstring3, "substring(...)");
                v.p(lVar, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, strSubstring3);
            } else {
                v.p(lVar, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, strW);
            }
        }
    }

    public boolean g(int i8) {
        if (i8 >= 64) {
            c();
            return ((a) this.f5585c).g(i8 - 64);
        }
        long j4 = 1 << i8;
        long j8 = this.f5584b;
        boolean z = (j8 & j4) != 0;
        long j9 = j8 & (~j4);
        this.f5584b = j9;
        long j10 = j4 - 1;
        this.f5584b = (j9 & j10) | Long.rotateRight((~j10) & j9, 1);
        a aVar = (a) this.f5585c;
        if (aVar != null) {
            if (aVar.d(0)) {
                i(63);
            }
            ((a) this.f5585c).g(0);
        }
        return z;
    }

    public void h() {
        this.f5584b = 0L;
        a aVar = (a) this.f5585c;
        if (aVar != null) {
            aVar.h();
        }
    }

    public void i(int i8) {
        if (i8 < 64) {
            this.f5584b |= 1 << i8;
        } else {
            c();
            ((a) this.f5585c).i(i8 - 64);
        }
    }

    public String toString() {
        switch (this.f5583a) {
            case 1:
                if (((a) this.f5585c) == null) {
                    return Long.toBinaryString(this.f5584b);
                }
                return ((a) this.f5585c).toString() + "xx" + Long.toBinaryString(this.f5584b);
            default:
                return super.toString();
        }
    }

    public a() {
        this.f5583a = 1;
        this.f5584b = 0L;
    }
}
