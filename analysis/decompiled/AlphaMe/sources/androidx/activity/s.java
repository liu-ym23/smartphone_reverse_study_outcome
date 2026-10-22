package androidx.activity;

import androidx.fragment.app.Q;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
public final class s extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2439a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ A f2440b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s(A a4, int i4) {
        super(0);
        this.f2439a = i4;
        this.f2440b = a4;
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Object invoke() {
        switch (this.f2439a) {
            case 0:
                m0invoke();
                break;
            case 1:
                m0invoke();
                break;
            default:
                m0invoke();
                break;
        }
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m0invoke() {
        Object objPrevious;
        int i4 = this.f2439a;
        A a4 = this.f2440b;
        switch (i4) {
            case 0:
                a4.a();
                break;
            case 1:
                ArrayDeque arrayDeque = a4.f2373b;
                ListIterator<E> listIterator = arrayDeque.listIterator(arrayDeque.size());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        objPrevious = listIterator.previous();
                        if (((Q) objPrevious).f3637a) {
                        }
                    } else {
                        objPrevious = null;
                    }
                }
                a4.f2374c = null;
                break;
            default:
                a4.a();
                break;
        }
    }
}
