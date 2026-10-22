package r0;

import La.H;
import Z8.C1172u;
import Z8.F;
import Z8.X;
import Z8.Y;
import androidx.core.backported.fixes.Status;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.InvocationTargetException;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0016\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0013R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\f¨\u0006\u0017"}, d2 = {"Lr0/j;", "Lr0/h;", "<init>", "()V", "Lr0/c;", "ki", "Landroidx/core/backported/fixes/Status;", Const.INTENT_KEY_APIKEY, "(Lr0/c;)Landroidx/core/backported/fixes/Status;", "", "", "f", "()Ljava/util/Set;", "", "s", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)[J", Const.INTENT_KEY_UMID, "()Ljava/lang/String;", "LY8/h;", "e", "aliases", "core-backported-fixes"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class j implements h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Y8.h aliases = C4848b.b(new InterfaceC5063a() { // from class: r0.i
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return j.c(this.f38738a);
        }
    });

    public static final Set c(j jVar) {
        return jVar.f();
    }

    @Override // r0.h
    public Status a(c ki) {
        p.i(ki, "ki");
        return ki.getAlias() == null ? Status.Unknown : e().contains(ki.getAlias()) ? Status.Fixed : Status.NotFixed;
    }

    public final String d() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object objInvoke = cls.getMethod("get", String.class, String.class).invoke(cls, "ro.build.backported_fixes.alias_bitset.long_list", "");
            p.g(objInvoke, "null cannot be cast to non-null type kotlin.String");
            return (String) objInvoke;
        } catch (Exception unused) {
            return "";
        }
    }

    public final Set<Integer> e() {
        return (Set) this.aliases.getValue();
    }

    public final Set<Integer> f() {
        BitSet bitSetValueOf = BitSet.valueOf(g(d()));
        int size = bitSetValueOf.size();
        if (size == 0) {
            return Y.e();
        }
        Set setC = X.c(size);
        for (int iNextSetBit = 0; iNextSetBit >= 0; iNextSetBit = bitSetValueOf.nextSetBit(iNextSetBit + 1)) {
            if (bitSetValueOf.get(iNextSetBit)) {
                setC.add(Integer.valueOf(iNextSetBit));
            }
            if (iNextSetBit == Integer.MAX_VALUE) {
                break;
            }
        }
        return X.a(setC);
    }

    public final long[] g(String s10) {
        List listC = C1172u.c();
        Iterator it = H.a1(s10, new char[]{','}, false, 0, 6, null).iterator();
        while (it.hasNext()) {
            try {
                listC.add(Long.valueOf(Long.parseLong((String) it.next())));
            } catch (NumberFormatException unused) {
            }
        }
        return F.n1(C1172u.a(listC));
    }
}
