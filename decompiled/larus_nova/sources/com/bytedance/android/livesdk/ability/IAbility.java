package com.bytedance.android.livesdk.ability;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ability/IAbility;", "", "onAbilityClear", "", "room-flow_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAbility {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ability.IAbility$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onAbilityClear(IAbility r100) {
        }

        public static /* synthetic */ void access$onAbilityClear$jd(IAbility r100) {
            $default$onAbilityClear(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void onAbilityClear(IAbility r100) {
            CC.access$onAbilityClear$jd(r100);
        }
    }

    void onAbilityClear();
}
