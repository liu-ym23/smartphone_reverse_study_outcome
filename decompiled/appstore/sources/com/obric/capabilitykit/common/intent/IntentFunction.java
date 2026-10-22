package com.obric.capabilitykit.common.intent;

import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import com.ss.android.ugc.aweme.framework.services.annotation.SPI;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@SPI
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J'\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\r2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\nH\u0016J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0014R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/obric/capabilitykit/common/intent/IntentFunction;", "P", "Landroid/os/Parcelable;", "R", "", "name", "", "getName", "()Ljava/lang/String;", "cancelTask", "", "reason", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "params", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Landroid/os/Parcelable;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isBlock", "isTaskOnGoing", "(Lcom/obric/capabilitykit/common/DispatchContext;)Ljava/lang/Boolean;", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IntentFunction<P extends Parcelable, R> {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static <P extends Parcelable, R> boolean cancelTask(@NotNull IntentFunction<P, R> r10, @NotNull String r11) {
            q.g(r11, "reason");
            return false;
        }

        @Nullable
        public static <P extends Parcelable, R> Object doAction(@NotNull IntentFunction<P, R> r10, @NotNull P r11, @NotNull DispatchContext r12, @NotNull Continuation<? super IntentResult<R>> r13) {
            throw new NotImplementedError(null, 1, null);
        }

        public static <P extends Parcelable, R> boolean isBlock(@NotNull IntentFunction<P, R> r10) {
            return false;
        }

        @Nullable
        public static <P extends Parcelable, R> Boolean isTaskOnGoing(@NotNull IntentFunction<P, R> r10, @NotNull DispatchContext r11) {
            q.g(r11, "dispatchContext");
            return null;
        }
    }

    boolean cancelTask(@NotNull String r10);

    @Nullable
    Object doAction(@NotNull P r10, @NotNull DispatchContext r11, @NotNull Continuation<? super IntentResult<R>> r12);

    @NotNull
    String getName();

    boolean isBlock();

    @Nullable
    Boolean isTaskOnGoing(@NotNull DispatchContext r10);
}
