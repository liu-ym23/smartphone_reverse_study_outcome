package d9;

import D7.AbstractC0210b;

/* renamed from: d9.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1381b extends AbstractC0210b {
    public int c = -1;
    public final /* synthetic */ C1382c d;

    public C1381b(C1382c c1382c) {
        this.d = c1382c;
    }

    @Override // D7.AbstractC0210b
    public final void a() {
        int i;
        Object[] objArr;
        do {
            i = this.c + 1;
            this.c = i;
            objArr = this.d.f4304a;
            if (i >= objArr.length) {
                break;
            }
        } while (objArr[i] == null);
        if (i >= objArr.length) {
            this.f400a = 2;
            return;
        }
        Object obj = objArr[i];
        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type T of org.jetbrains.kotlin.util.ArrayMapImpl");
        this.b = obj;
        this.f400a = 1;
    }
}
