package com.stepos.core.ota;

import com.stepos.core.ota.domain.PauseReason;
import com.stepos.core.ota.domain.TriggerSource;
import java.util.Set;
import kotlin.collections.EmptySet;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface OtaDispatcher {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DefaultImpls {
        public static boolean download$default(OtaDispatcher otaDispatcher, String str, TriggerSource triggerSource, String str2, Set set, boolean z, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: download");
            }
            if ((i10 & 4) != 0) {
                str2 = null;
            }
            String str3 = str2;
            if ((i10 & 8) != 0) {
                set = EmptySet.f10003a;
            }
            Set set2 = set;
            if ((i10 & 16) != 0) {
                z = false;
            }
            return otaDispatcher.download(str, triggerSource, str3, set2, z);
        }

        public static /* synthetic */ boolean pause$default(OtaDispatcher otaDispatcher, String str, PauseReason pauseReason, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pause");
            }
            if ((i10 & 2) != 0) {
                pauseReason = PauseReason.USER;
            }
            return otaDispatcher.pause(str, pauseReason);
        }

        public static /* synthetic */ boolean resume$default(OtaDispatcher otaDispatcher, String str, TriggerSource triggerSource, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resume");
            }
            if ((i10 & 2) != 0) {
                triggerSource = TriggerSource.USER;
            }
            return otaDispatcher.resume(str, triggerSource);
        }
    }

    boolean attach(String str, TriggerSource triggerSource);

    boolean cancel(String str);

    boolean checkUpdate(String str, TriggerSource triggerSource);

    boolean detach(String str, String str2);

    boolean download(String str, TriggerSource triggerSource, String str2, Set<String> set, boolean z);

    boolean pause(String str, PauseReason pauseReason);

    boolean resume(String str, TriggerSource triggerSource);
}
