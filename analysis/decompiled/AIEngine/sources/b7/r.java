package b7;

import com.stepos.base.model.ReleasePriority;
import com.stepos.base.model.ReleaseReason;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface r {
    long getLastUsedAtMonoNs();

    String getModelId();

    ReleasePriority getPriority();

    boolean isInUse();

    void release(ReleaseReason releaseReason);
}
