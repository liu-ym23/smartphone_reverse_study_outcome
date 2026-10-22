package b0;

import androidx.fragment.app.D;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: b0.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0364j extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final D f4366a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0364j(D fragment, String str) {
        super(str);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.f4366a = fragment;
    }
}
