package bz7;

import androidx.lifecycle.Lifecycle;
import com.larksuite.component.card.cardcontainer.CardImpl;
import com.larksuite.component.card.protocol.CardConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Lifecycle f21880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CardConfig f21881b;

    public b() {
    }

    public final CardImpl a() {
        Lifecycle r100 = this.f21880a;
        CardConfig r101 = this.f21881b;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("cardConfig");
        r101 = null;
    L6:
        return new CardImpl(r100, r101);
    }
}
