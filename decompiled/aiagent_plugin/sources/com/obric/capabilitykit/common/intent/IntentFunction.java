package com.obric.capabilitykit.common.intent;

import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.o;
import d.l;

/* JADX INFO: compiled from: IntentFunction.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IntentFunction<P extends Parcelable, R> {

    /* JADX INFO: compiled from: IntentFunction.kt */
    public static final class a {
        public static <P extends Parcelable, R> Boolean a(IntentFunction<P, R> r2, DispatchContext r3) {
            IntentFunction r4 = (IntentFunction) ZeusTransformUtils.wrapperContextForParams(r2, IntentFunction.class, "com.obric.aiagent.plugin");
            o.e(r3, "dispatchContext");
            return null;
        }

        public static <P extends Parcelable, R> boolean a(IntentFunction<P, R> r2) {
            IntentFunction r3 = (IntentFunction) ZeusTransformUtils.wrapperContextForParams(r2, IntentFunction.class, "com.obric.aiagent.plugin");
            return false;
        }

        public static <P extends Parcelable, R> boolean a(IntentFunction<P, R> r2, String r3) {
            IntentFunction r4 = (IntentFunction) ZeusTransformUtils.wrapperContextForParams(r2, IntentFunction.class, "com.obric.aiagent.plugin");
            o.e(r3, "reason");
            return false;
        }

        public static <P extends Parcelable, R> Object a(IntentFunction<P, R> r1, P r2, DispatchContext r3, d<? super IntentResult<R>> r4) {
            IntentFunction r5 = (IntentFunction) ZeusTransformUtils.wrapperContextForParams(r1, IntentFunction.class, "com.obric.aiagent.plugin");
            Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r2, Parcelable.class, "com.obric.aiagent.plugin");
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            throw new l(null, 1, null);
        }
    }

    boolean cancelTask(String r1);

    Object doAction(P r1, DispatchContext r2, d<? super IntentResult<R>> r3);

    String getName();

    boolean isBlock();

    Boolean isTaskOnGoing(DispatchContext r1);
}
