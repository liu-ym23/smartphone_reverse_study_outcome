package stepai.aios.accessibility;

import J7.c;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "stepai.aios.accessibility.AccessibilityActionExecutor", f = "AccessibilityActionExecutor.kt", l = {TypedValues.CycleType.TYPE_EASING, 426, 448}, m = "performTextInputWithRetry", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class AccessibilityActionExecutor$performTextInputWithRetry$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public AccessibilityNodeInfo f6013a;
    public boolean b;
    public boolean c;
    public boolean d;
    public /* synthetic */ Object e;
    public final /* synthetic */ a f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccessibilityActionExecutor$performTextInputWithRetry$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return this.f.d(null, null, false, false, this);
    }
}
