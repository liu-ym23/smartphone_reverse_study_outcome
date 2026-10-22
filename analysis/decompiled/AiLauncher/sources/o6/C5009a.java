package o6;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.tencent.mmkv.MMKV;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import q6.c;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0018\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010 \u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b \u0010!J%\u0010\"\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0010¢\u0006\u0004\b\"\u0010#J'\u0010$\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u0010¢\u0006\u0004\b$\u0010#J%\u0010&\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020%¢\u0006\u0004\b&\u0010'J'\u0010(\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020%¢\u0006\u0004\b(\u0010)J'\u0010*\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b*\u0010#J'\u0010+\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020%2\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b+\u0010,J'\u0010.\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020-2\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b.\u0010/J'\u00100\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b0\u00101J)\u00102\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b2\u00103J)\u00104\u001a\u00020%2\u0006\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020%2\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b4\u00105J)\u00106\u001a\u00020-2\u0006\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020-2\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b6\u00107J)\u00108\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b8\u00101J\u001f\u00109\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b9\u0010:J\u001f\u0010;\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b;\u0010<R\"\u0010=\u001a\u00020\r8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010\u000f\"\u0004\b@\u0010AR\u0018\u0010B\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006E"}, d2 = {"Lo6/a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "w", "(Landroid/content/Context;)Ljava/lang/String;", "e", "LY8/t;", Const.INTENT_KEY_UMID, "(Landroid/content/Context;)V", "Lcom/tencent/mmkv/MMKV;", "r", "()Lcom/tencent/mmkv/MMKV;", "", "secure", "p", "(Z)Lcom/tencent/mmkv/MMKV;", "mmapID", "q", "(Ljava/lang/String;)Lcom/tencent/mmkv/MMKV;", "key", UxipConstants.f30680s, "H", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "default", "u", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "J", "(Ljava/lang/String;Ljava/lang/String;)V", "c", "(Ljava/lang/String;Ljava/lang/String;)Z", "z", "(Ljava/lang/String;Ljava/lang/String;Z)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "", "C", "(Ljava/lang/String;Ljava/lang/String;I)Z", "l", "(Ljava/lang/String;Ljava/lang/String;I)I", "F", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;IZ)Z", "", "D", "(Ljava/lang/String;JZ)Z", "x", "(Ljava/lang/String;ZZ)Z", "s", "(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;IZ)I", "n", "(Ljava/lang/String;JZ)J", "f", "I", "(Ljava/lang/String;Z)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Z)Z", "defaultMMKV", "Lcom/tencent/mmkv/MMKV;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "K", "(Lcom/tencent/mmkv/MMKV;)V", "secureMMKV", "rootDir", "Ljava/lang/String;", "storage_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: o6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5009a {
    public static final C5009a INSTANCE = new C5009a();
    public static MMKV defaultMMKV;
    private static volatile String rootDir;
    private static MMKV secureMMKV;

    public static /* synthetic */ boolean B(C5009a c5009a, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return c5009a.A(str, i10, z10);
    }

    public static /* synthetic */ boolean E(C5009a c5009a, String str, long j10, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return c5009a.D(str, j10, z10);
    }

    public static /* synthetic */ boolean G(C5009a c5009a, String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return c5009a.F(str, str2, z10);
    }

    public static /* synthetic */ boolean b(C5009a c5009a, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return c5009a.a(str, z10);
    }

    public static /* synthetic */ boolean g(C5009a c5009a, String str, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            z11 = false;
        }
        return c5009a.f(str, z10, z11);
    }

    public static /* synthetic */ int k(C5009a c5009a, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return c5009a.j(str, i10, z10);
    }

    public static /* synthetic */ int m(C5009a c5009a, String str, String str2, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return c5009a.l(str, str2, i10);
    }

    public static /* synthetic */ long o(C5009a c5009a, String str, long j10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return c5009a.n(str, j10, z10);
    }

    public static /* synthetic */ String t(C5009a c5009a, String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return c5009a.s(str, str2, z10);
    }

    public static /* synthetic */ String v(C5009a c5009a, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = "";
        }
        return c5009a.u(str, str2, str3);
    }

    public static /* synthetic */ boolean y(C5009a c5009a, String str, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z11 = false;
        }
        return c5009a.x(str, z10, z11);
    }

    public final boolean A(String key, int value, boolean secure) {
        p.i(key, "key");
        return p(secure).p(key, value);
    }

    public final boolean C(String mmapID, String key, int value) {
        p.i(mmapID, "mmapID");
        p.i(key, "key");
        return q(mmapID).p(key, value);
    }

    public final boolean D(String key, long value, boolean secure) {
        p.i(key, "key");
        return p(secure).q(key, value);
    }

    public final boolean F(String key, String value, boolean secure) {
        p.i(key, "key");
        p.i(value, "value");
        return p(secure).r(key, value);
    }

    public final boolean H(String mmapID, String key, String value) {
        p.i(mmapID, "mmapID");
        p.i(key, "key");
        p.i(value, "value");
        return q(mmapID).r(key, value);
    }

    public final void I(String key, boolean secure) {
        p.i(key, "key");
        p(secure).D(key);
    }

    public final void J(String mmapID, String key) {
        p.i(mmapID, "mmapID");
        p.i(key, "key");
        q(mmapID).D(key);
    }

    public final void K(MMKV mmkv) {
        p.i(mmkv, "<set-?>");
        defaultMMKV = mmkv;
    }

    public final boolean a(String key, boolean secure) {
        p.i(key, "key");
        return p(secure).b(key);
    }

    public final boolean c(String mmapID, String key) {
        p.i(mmapID, "mmapID");
        p.i(key, "key");
        return q(mmapID).b(key);
    }

    public final synchronized void d(Context context) {
        p.i(context, "context");
        e(context);
        if (defaultMMKV == null) {
            MMKV mmkvK = MMKV.k();
            p.h(mmkvK, "defaultMMKV(...)");
            K(mmkvK);
        }
    }

    public final synchronized String e(Context context) {
        String strV;
        p.i(context, "context");
        strV = rootDir;
        if (strV == null) {
            strV = MMKV.v(context.getApplicationContext());
            rootDir = strV;
            p.h(strV, "also(...)");
        }
        return strV;
    }

    public final boolean f(String key, boolean z10, boolean secure) {
        p.i(key, "key");
        return p(secure).c(key, z10);
    }

    public final boolean h(String mmapID, String key, boolean z10) {
        p.i(mmapID, "mmapID");
        p.i(key, "key");
        return q(mmapID).c(key, z10);
    }

    public final MMKV i() {
        MMKV mmkv = defaultMMKV;
        if (mmkv != null) {
            return mmkv;
        }
        p.A("defaultMMKV");
        return null;
    }

    public final int j(String key, int i10, boolean secure) {
        p.i(key, "key");
        return p(secure).f(key, i10);
    }

    public final int l(String mmapID, String key, int i10) {
        p.i(mmapID, "mmapID");
        p.i(key, "key");
        return q(mmapID).f(key, i10);
    }

    public final long n(String key, long j10, boolean secure) {
        p.i(key, "key");
        return p(secure).g(key, j10);
    }

    public final MMKV p(boolean secure) {
        return secure ? r() : i();
    }

    public final MMKV q(String mmapID) throws RuntimeException {
        p.i(mmapID, "mmapID");
        MMKV mmkvA = MMKV.A(mmapID);
        p.h(mmkvA, "mmkvWithID(...)");
        return mmkvA;
    }

    public final MMKV r() {
        MMKV mmkv = secureMMKV;
        if (mmkv != null) {
            return mmkv;
        }
        MMKV mmkvH = c.INSTANCE.h();
        secureMMKV = mmkvH;
        return mmkvH;
    }

    public final String s(String key, String str, boolean secure) {
        p.i(key, "key");
        p.i(str, "default");
        String strH = p(secure).h(key, str);
        return strH == null ? str : strH;
    }

    public final String u(String mmapID, String key, String str) {
        p.i(mmapID, "mmapID");
        p.i(key, "key");
        p.i(str, "default");
        String strH = q(mmapID).h(key, str);
        return strH == null ? str : strH;
    }

    public final String w(Context context) throws RuntimeException {
        p.i(context, "context");
        String strE = e(context);
        MMKV mmkvK = MMKV.k();
        p.h(mmkvK, "defaultMMKV(...)");
        K(mmkvK);
        return strE;
    }

    public final boolean x(String key, boolean value, boolean secure) {
        p.i(key, "key");
        return p(secure).t(key, value);
    }

    public final boolean z(String mmapID, String key, boolean value) {
        p.i(mmapID, "mmapID");
        p.i(key, "key");
        return q(mmapID).t(key, value);
    }
}
