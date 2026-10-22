package com.stepos.core.ota.domain;

import com.stepos.core.ota.domain.OtaState;
import java.util.Collection;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TriggerSourcePolicy {
    public static final TriggerSourcePolicy INSTANCE = new TriggerSourcePolicy();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TriggerSource.values().length];
            try {
                iArr[TriggerSource.USER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TriggerSource.PUSH_FORCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TriggerSource.PUSH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TriggerSource.AUTO_DAILY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TriggerSource.RETRY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TriggerSource.DEPENDENCY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TriggerSource.SILENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[TriggerSource.PREINSTALL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TriggerSourcePolicy() {
    }

    public static /* synthetic */ boolean allowCellular$default(TriggerSourcePolicy triggerSourcePolicy, TriggerSource triggerSource, boolean z, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z = false;
        }
        return triggerSourcePolicy.allowCellular(triggerSource, z);
    }

    public final boolean allowCellular(TriggerSource triggerSource, boolean z) {
        int i10 = triggerSource == null ? -1 : WhenMappings.$EnumSwitchMapping$0[triggerSource.ordinal()];
        return i10 != 1 ? i10 == 3 || i10 == 5 : z;
    }

    public final boolean isSilent(Collection<? extends TriggerSource> sources) {
        g.f(sources, "sources");
        return !shouldShowNotification(sources);
    }

    public final boolean isUserHeld(Collection<? extends TriggerSource> sources, OtaState state) {
        g.f(sources, "sources");
        g.f(state, "state");
        if (sources.contains(TriggerSource.USER)) {
            return state.isActive() || (state instanceof OtaState.Paused) || (state instanceof OtaState.Failed);
        }
        return false;
    }

    public final TriggerSource primary(Collection<? extends TriggerSource> sources) {
        Object obj;
        g.f(sources, "sources");
        Iterator<T> it = sources.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                int iPriority = INSTANCE.priority((TriggerSource) next);
                do {
                    Object next2 = it.next();
                    int iPriority2 = INSTANCE.priority((TriggerSource) next2);
                    if (iPriority < iPriority2) {
                        next = next2;
                        iPriority = iPriority2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (TriggerSource) obj;
    }

    public final int priority(TriggerSource source) {
        g.f(source, "source");
        switch (WhenMappings.$EnumSwitchMapping$0[source.ordinal()]) {
            case 1:
                return 100;
            case 2:
                return 90;
            case 3:
                return 80;
            case 4:
                return 60;
            case 5:
                return 50;
            case 6:
                return 40;
            case 7:
                return 20;
            case 8:
                return 10;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean shouldPreempt(TriggerSource triggerSource, TriggerSource incoming) {
        g.f(incoming, "incoming");
        return triggerSource != null && priority(incoming) > priority(triggerSource);
    }

    public final boolean shouldShowNotification(Collection<? extends TriggerSource> sources) {
        g.f(sources, "sources");
        if (sources.isEmpty()) {
            return true;
        }
        Collection<? extends TriggerSource> collection = sources;
        if (collection.isEmpty()) {
            return false;
        }
        for (TriggerSource triggerSource : collection) {
            if (triggerSource == TriggerSource.USER || triggerSource == TriggerSource.PUSH || triggerSource == TriggerSource.RETRY || triggerSource == TriggerSource.AUTO_DAILY || triggerSource == TriggerSource.DEPENDENCY) {
                return true;
            }
        }
        return false;
    }
}
