package s0;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.money.Monetary;
import l0.e;
import o0.C0888a;
import org.javamoney.moneta.Money;
import p0.t;
import q0.C0946I;
import q0.U;
import q0.e0;

/* renamed from: s0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1046a implements U, t {

    /* renamed from: a, reason: collision with root package name */
    public static final C1046a f20228a = new C1046a();

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) {
        Money money = (Money) obj;
        if (money == null) {
            c0946i.I();
            return;
        }
        e0 e0Var = c0946i.f19676k;
        e0Var.O('{', "numberStripped", money.getNumberStripped());
        e0Var.N(',', "currency", money.getCurrency().getCurrencyCode());
        e0Var.write(125);
    }

    @Override // p0.t
    public int d() {
        return 0;
    }

    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        e eVarN0 = c0888a.n0();
        Object obj2 = eVarN0.get("currency");
        String strR = obj2 instanceof e ? ((e) obj2).R("currencyCode") : obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = eVarN0.get("numberStripped");
        if ((obj3 instanceof BigDecimal) || (obj3 instanceof Integer) || (obj3 instanceof BigInteger)) {
            return (T) Money.of((Number) obj3, Monetary.getCurrency(strR, new String[0]));
        }
        throw new UnsupportedOperationException();
    }
}
