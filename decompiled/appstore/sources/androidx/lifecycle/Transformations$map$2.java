package androidx.lifecycle;

import androidx.arch.core.util.Function;
import com.tmall.wireless.tangram.structure.card.FixCard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "X", "Y", FixCard.FixStyle.KEY_X, "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class Transformations$map$2 extends Lambda implements Function1 {
    final /* synthetic */ Function $mapFunction;
    final /* synthetic */ u $result;

    public Transformations$map$2(u r10, Function r11) {
        this.$result = r10;
        this.$mapFunction = r11;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r10) {
        m1invoke(r10);
        return Unit.f21064a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1invoke(Object r10) {
        this.$result.p(this.$mapFunction.apply(r10));
    }
}
