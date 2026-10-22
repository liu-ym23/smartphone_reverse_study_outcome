package p6;

import com.stepos.base.model.ModelReleaseReason;
import kotlin.Result;
import kotlinx.coroutines.flow.Flow;
import lb.n;
import v6.c;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface d<AbilityInput extends v6.c, AbilityOutput extends v6.d> {
    Object acquire(qb.b<? super Boolean> bVar);

    boolean cancel();

    void completeInput(String str);

    Object execute(String str, Object obj);

    a getAbilityConfig();

    String getId();

    boolean getSupportsFeedInput();

    Object infer(AbilityInput abilityinput, Object obj, qb.b<? super Flow<? extends Result<? extends AbilityOutput>>> bVar);

    boolean isModelHeld();

    String loadError();

    Throwable loadFailure();

    void onFeedInput(String str, Object obj);

    Object planExecution(AbilityInput abilityinput, Object obj, long j10, qb.b<? super h7.c> bVar);

    Object release(ModelReleaseReason modelReleaseReason, qb.b<? super n> bVar);

    boolean supportsStreaming();
}
