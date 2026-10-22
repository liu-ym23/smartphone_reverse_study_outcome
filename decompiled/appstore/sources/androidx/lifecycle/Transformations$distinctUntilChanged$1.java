package androidx.lifecycle;

import com.bytedance.apm.constant.CommonKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "X", CommonKey.KEY_VALUE, "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class Transformations$distinctUntilChanged$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ Ref$BooleanRef $firstTime;
    final /* synthetic */ u $outputLiveData;

    public Transformations$distinctUntilChanged$1(u r10, Ref$BooleanRef r11) {
        this.$outputLiveData = r10;
        this.$firstTime = r11;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object r10) {
        invoke2(r10);
        return Unit.f21064a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object r10) {
        Object r11 = this.$outputLiveData.e();
        if (this.$firstTime.element == true) goto L9;
        if (r11 != null) goto L6;
        if (r10 != null) goto L9;
    L6:
        if (r11 != null) goto L8;
        return;
    L8:
        if (kotlin.jvm.internal.q.b(r11, r10) == false) goto L9;
        return;
    L9:
        this.$firstTime.element = false;
        this.$outputLiveData.p(r10);
    }
}
