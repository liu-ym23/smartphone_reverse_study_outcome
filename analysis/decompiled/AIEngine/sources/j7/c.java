package j7;

import com.stepos.core.model.task.AITaskSupervisor;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface c {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static volatile AITaskSupervisor f9709a;
    }

    AutoCloseable acquireAllOrNull(long j10);

    boolean isIdle();
}
