package com.bytedance.android.live.liveinteract.plantform.camera;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/live/liveinteract/plantform/camera/SwitchCameraContext;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class SwitchCameraManager$start$pair$1 extends FunctionReferenceImpl implements Function0<SwitchCameraContext> {
    public static final SwitchCameraManager$start$pair$1 INSTANCE = null;

    static {
        INSTANCE = new SwitchCameraManager$start$pair$1();
    }

    public SwitchCameraManager$start$pair$1() {
        super(0, SwitchCameraContext.class, "<init>", "<init>()V", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SwitchCameraContext invoke() {
        return new SwitchCameraContext();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ SwitchCameraContext invoke() {
        return invoke();
    }
}
