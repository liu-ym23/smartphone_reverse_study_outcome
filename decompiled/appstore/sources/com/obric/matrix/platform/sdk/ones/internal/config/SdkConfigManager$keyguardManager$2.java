package com.obric.matrix.platform.sdk.ones.internal.config;

import ac.a;
import android.app.KeyguardManager;
import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/app/KeyguardManager;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class SdkConfigManager$keyguardManager$2 extends Lambda implements Function0<KeyguardManager> {
    public static final SdkConfigManager$keyguardManager$2 INSTANCE = null;

    static {
        INSTANCE = new SdkConfigManager$keyguardManager$2();
    }

    public SdkConfigManager$keyguardManager$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ KeyguardManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final KeyguardManager invoke() {
        Context r10 = a.f80a.c();
        if (r10 == null) goto L5;
        Object r11 = r10.getSystemService("keyguard");
    L7:
        if ((r11 instanceof KeyguardManager) == true) goto L9;
        return null;
    L9:
        return (KeyguardManager) r11;
    L5:
        r11 = null;
        goto L7
    }
}
