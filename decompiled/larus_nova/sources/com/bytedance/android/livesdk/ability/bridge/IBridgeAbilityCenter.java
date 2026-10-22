package com.bytedance.android.livesdk.ability.bridge;

import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ability/bridge/IBridgeAbilityCenter;", "Lcom/bytedance/android/livesdk/ability/IAbility;", "getParentAbility", "Lcom/bytedance/android/livesdk/ability/IAbilityCenter;", "room-flow_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IBridgeAbilityCenter extends IAbility {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ability.bridge.IBridgeAbilityCenter$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void access$onAbilityClear$jd(IBridgeAbilityCenter r100) {
            IAbility.CC.$default$onAbilityClear(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void onAbilityClear(IBridgeAbilityCenter r100) {
            CC.access$onAbilityClear$jd(r100);
        }
    }

    IAbilityCenter getParentAbility();
}
