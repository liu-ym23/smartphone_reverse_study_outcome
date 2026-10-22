package com.bytedance.android.live.soloktv.karaokestation;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/live/soloktv/karaokestation/SoloKtvOrderSongDataContext;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class SoloKtvOrderSongDataContext$Companion$getDataContext$1 extends FunctionReferenceImpl implements Function0<SoloKtvOrderSongDataContext> {
    public static final SoloKtvOrderSongDataContext$Companion$getDataContext$1 INSTANCE = null;

    static {
        INSTANCE = new SoloKtvOrderSongDataContext$Companion$getDataContext$1();
    }

    public SoloKtvOrderSongDataContext$Companion$getDataContext$1() {
        super(0, SoloKtvOrderSongDataContext.class, "<init>", "<init>()V", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SoloKtvOrderSongDataContext invoke() {
        return new SoloKtvOrderSongDataContext();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ SoloKtvOrderSongDataContext invoke() {
        return invoke();
    }
}
