package com.bytedance.android.annie.bridge;

import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 4, 3}, xi = 48)
public final class JSBridgeManager$jsbMethodCallbackAB$2 extends Lambda implements Function0<Boolean> {
    public static final JSBridgeManager$jsbMethodCallbackAB$2 INSTANCE = null;

    static {
        INSTANCE = new JSBridgeManager$jsbMethodCallbackAB$2();
    }

    public JSBridgeManager$jsbMethodCallbackAB$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        return AnnieConfigSettingKeys.ENABLE_JSB_METHOD_CALLBACK.a();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
