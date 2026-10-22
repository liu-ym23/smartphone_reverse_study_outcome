package ce8;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class o implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f23483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorCoroutineDispatcher f23484b;

    public o() {
        ExecutorService r100 = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("l/UtilAbility"));
        this.f23483a = r100;
        this.f23484b = ExecutorsKt.from(r100);
    }

    @Override // ce8.d
    public final ExecutorCoroutineDispatcher fi() {
        return this.f23484b;
    }
}
