package a8;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class j extends w {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f449e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(Member member, Type type, Class cls, Type[] typeArr, int i2) {
        super(member, type, cls, typeArr);
        this.f449e = i2;
    }

    @Override // a8.h
    public final Object h(Object[] objArr) {
        switch (this.f449e) {
            case 0:
                q7.k.e(objArr, "args");
                g.checkArguments(this, objArr);
                Constructor constructor = (Constructor) this.f459a;
                ab.m mVar = new ab.m(2);
                mVar.c(objArr);
                mVar.a(null);
                ArrayList arrayList = mVar.f577f;
                return constructor.newInstance(arrayList.toArray(new Object[arrayList.size()]));
            default:
                q7.k.e(objArr, "args");
                g.checkArguments(this, objArr);
                return ((Constructor) this.f459a).newInstance(Arrays.copyOf(objArr, objArr.length));
        }
    }
}
