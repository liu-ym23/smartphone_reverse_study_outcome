package kotlin;

import La.H;
import Y8.t;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import o9.C5013a;
import p9.InterfaceC5063a;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\u00020\u00072\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0000¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u0007*\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0011¨\u0006\u0013"}, d2 = {"Lk8/d;", "", "<init>", "()V", "Lkotlin/Function0;", "LY8/t;", "func", "", Const.INTENT_KEY_APIKEY, "(Lp9/a;)Ljava/lang/String;", "Lw9/d;", "clazz", Const.INTENT_KEY_PKGNAME, "(Lw9/d;)Ljava/lang/String;", "c", "(Ljava/lang/String;)Ljava/lang/String;", "", "Ljava/util/List;", "classNameEndings", "kotlin-logging_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: k8.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C4819d {

    /* renamed from: a, reason: collision with root package name */
    public static final C4819d f34639a = new C4819d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final List<String> classNameEndings = C1173v.p("Kt$", "$");

    public final String a(InterfaceC5063a<t> func) {
        p.i(func, "func");
        return b(kotlin.jvm.internal.t.b(func.getClass()));
    }

    public final String b(InterfaceC5745d<?> clazz) {
        p.i(clazz, "clazz");
        String name = C5013a.b(clazz).getName();
        p.h(name, "getName(...)");
        return c(name);
    }

    public final String c(String str) {
        Iterator<T> it = classNameEndings.iterator();
        while (it.hasNext()) {
            String str2 = str;
            int iU0 = H.u0(str2, (String) it.next(), 0, false, 6, null);
            if (iU0 != -1) {
                String strSubstring = str2.substring(0, iU0);
                p.h(strSubstring, "substring(...)");
                return strSubstring;
            }
            str = str2;
        }
        return str;
    }
}
