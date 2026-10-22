package androidx.activity;

import androidx.fragment.app.Q;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
public final class r extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2408a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ A f2409b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(A a4, int i4) {
        super(1);
        this.f2408a = i4;
        this.f2409b = a4;
    }

    public final void a(C0174b backEvent) {
        int i4 = this.f2408a;
        Object obj = null;
        A a4 = this.f2409b;
        switch (i4) {
            case 0:
                Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                ArrayDeque arrayDeque = a4.f2373b;
                ListIterator<E> listIterator = arrayDeque.listIterator(arrayDeque.size());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        Object objPrevious = listIterator.previous();
                        if (((Q) objPrevious).f3637a) {
                            obj = objPrevious;
                        }
                    }
                }
                Q q4 = (Q) obj;
                a4.f2374c = q4;
                if (q4 != null) {
                    Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                    break;
                }
                break;
            default:
                Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                ArrayDeque arrayDeque2 = a4.f2373b;
                ListIterator<E> listIterator2 = arrayDeque2.listIterator(arrayDeque2.size());
                while (true) {
                    if (listIterator2.hasPrevious()) {
                        Object objPrevious2 = listIterator2.previous();
                        if (((Q) objPrevious2).f3637a) {
                            obj = objPrevious2;
                        }
                    }
                }
                if (((Q) obj) != null) {
                    Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                    break;
                }
                break;
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        switch (this.f2408a) {
            case 0:
                a((C0174b) obj);
                break;
            default:
                a((C0174b) obj);
                break;
        }
        return Unit.INSTANCE;
    }
}
