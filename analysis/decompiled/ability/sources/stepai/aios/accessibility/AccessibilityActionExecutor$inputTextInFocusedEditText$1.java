package stepai.aios.accessibility;

import J7.c;
import android.view.accessibility.AccessibilityNodeInfo;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "stepai.aios.accessibility.AccessibilityActionExecutor", f = "AccessibilityActionExecutor.kt", l = {252}, m = "inputTextInFocusedEditText", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class AccessibilityActionExecutor$inputTextInFocusedEditText$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public AccessibilityNodeInfo f6012a;
    public /* synthetic */ Object b;
    public final /* synthetic */ a c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccessibilityActionExecutor$inputTextInFocusedEditText$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.c = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.c(null, null, false, false, 0, this);
    }
}
