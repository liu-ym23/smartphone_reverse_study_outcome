package stepai.aios.accessibility;

import J7.c;
import android.view.accessibility.AccessibilityNodeInfo;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "stepai.aios.accessibility.AccessibilityActionExecutor", f = "AccessibilityActionExecutor.kt", l = {373, 397}, m = "performTextInputWithRetry$performCompleteInputFlow", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class AccessibilityActionExecutor$performTextInputWithRetry$performCompleteInputFlow$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public AccessibilityNodeInfo f6014a;
    public String b;
    public a c;
    public boolean d;
    public boolean e;
    public /* synthetic */ Object f;
    public int g;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f = obj;
        this.g |= Integer.MIN_VALUE;
        return a.e(null, null, false, null, this);
    }
}
