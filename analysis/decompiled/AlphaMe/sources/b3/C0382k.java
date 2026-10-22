package b3;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: b3.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0382k extends Lambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public static final C0382k f4414a = new C0382k(2);

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return Boolean.valueOf(Intrinsics.areEqual(obj, obj2));
    }
}
