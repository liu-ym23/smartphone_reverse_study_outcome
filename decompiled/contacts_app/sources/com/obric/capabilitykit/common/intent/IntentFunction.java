package com.obric.capabilitykit.common.intent;

import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IntentFunction.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J'\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\r2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\nH\u0016J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0014R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/obric/capabilitykit/common/intent/IntentFunction;", "P", "Landroid/os/Parcelable;", "R", "", "name", "", "getName", "()Ljava/lang/String;", "cancelTask", "", "reason", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "params", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Landroid/os/Parcelable;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isBlock", "isTaskOnGoing", "(Lcom/obric/capabilitykit/common/DispatchContext;)Ljava/lang/Boolean;", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IntentFunction<P extends Parcelable, R> {

    /* JADX INFO: compiled from: IntentFunction.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static <P extends Parcelable, R> boolean cancelTask(IntentFunction<P, R> r0, String r1) {
            Intrinsics.checkNotNullParameter(r1, "reason");
            return false;
        }

        public static <P extends Parcelable, R> boolean isBlock(IntentFunction<P, R> r0) {
            return false;
        }

        public static <P extends Parcelable, R> Boolean isTaskOnGoing(IntentFunction<P, R> r0, DispatchContext r1) {
            Intrinsics.checkNotNullParameter(r1, "dispatchContext");
            return null;
        }

        public static <P extends Parcelable, R> Object doAction(IntentFunction<P, R> r0, P r1, DispatchContext r2, Continuation<? super IntentResult<R>> r3) {
            throw new NotImplementedError(null, 1, null);
        }
    }

    boolean cancelTask(String r1);

    Object doAction(P r1, DispatchContext r2, Continuation<? super IntentResult<R>> r3);

    String getName();

    boolean isBlock();

    Boolean isTaskOnGoing(DispatchContext r1);
}
