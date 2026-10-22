package androidx.compose.runtime;

import D7.w;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u00006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u000f\u0010\t\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\n\u001a%\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\f0\u000bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a!\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\f0\u000bH\u0007¢\u0006\u0004\b\u0013\u0010\u0011\u001a\u000f\u0010\u0014\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0014\u0010\n¨\u0006\u0015"}, d2 = {"", "context", "LC7/r;", "simulateHotReload", "(Ljava/lang/Object;)V", "", "key", "invalidateGroupsWithKey", "(I)V", "disableHotReloadMode", "()V", "", "Lkotlin/Pair;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "currentCompositionErrors", "()Ljava/util/List;", "", "getCurrentCompositionErrors", "clearCompositionErrors", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HotReloaderKt {
    public static final void clearCompositionErrors() {
        HotReloader.INSTANCE.clearErrors();
    }

    @C7.c
    public static final List<Pair<Exception, Boolean>> currentCompositionErrors() {
        List<Pair<Throwable, Boolean>> currentCompositionErrors = getCurrentCompositionErrors();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = currentCompositionErrors.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            Throwable th = (Throwable) pair.f4886a;
            Boolean bool = (Boolean) pair.b;
            bool.booleanValue();
            Exception exc = th instanceof Exception ? (Exception) th : null;
            Pair pair2 = exc != null ? new Pair(exc, bool) : null;
            if (pair2 != null) {
                arrayList.add(pair2);
            }
        }
        return arrayList;
    }

    public static final void disableHotReloadMode() {
        Recomposer.INSTANCE.setHotReloadEnabled$runtime(false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final List<Pair<Throwable, Boolean>> getCurrentCompositionErrors() {
        List<RecomposerErrorInfo> currentErrors = HotReloader.INSTANCE.getCurrentErrors();
        ArrayList arrayList = new ArrayList(w.c0(currentErrors, 10));
        for (RecomposerErrorInfo recomposerErrorInfo : currentErrors) {
            arrayList.add(new Pair(recomposerErrorInfo.getCause(), Boolean.valueOf(recomposerErrorInfo.getRecoverable())));
        }
        return arrayList;
    }

    public static final void invalidateGroupsWithKey(int i) {
        HotReloader.INSTANCE.invalidateGroupsWithKey(i);
    }

    public static final void simulateHotReload(Object obj) {
        HotReloader.INSTANCE.simulateHotReload$runtime(obj);
    }
}
