package co0;

import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.core.cache.LruCache;
import io.reactivex.functions.Consumer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes46.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24602a = null;

    static {
        f24602a = new a();
    }

    public a() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        UserEvent r101 = (UserEvent) r100;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        LruCache r103 = c.f24604a;     // Catch: Throwable -> L8
        if (r103 == null) goto L6;
        r103.clear();     // Catch: Throwable -> L8
    L6:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
