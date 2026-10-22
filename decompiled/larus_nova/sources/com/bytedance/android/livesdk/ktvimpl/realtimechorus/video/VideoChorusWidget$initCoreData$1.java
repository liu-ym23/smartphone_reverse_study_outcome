package com.bytedance.android.livesdk.ktvimpl.realtimechorus.video;

import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/livesdk/ktvimpl/base/datacontext/KtvRoomContext;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class VideoChorusWidget$initCoreData$1 extends FunctionReferenceImpl implements Function0<KtvRoomContext> {
    public static final VideoChorusWidget$initCoreData$1 INSTANCE = null;

    static {
        INSTANCE = new VideoChorusWidget$initCoreData$1();
    }

    public VideoChorusWidget$initCoreData$1() {
        super(0, KtvRoomContext.class, "<init>", "<init>()V", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final KtvRoomContext invoke() {
        return new KtvRoomContext();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ KtvRoomContext invoke() {
        return invoke();
    }
}
