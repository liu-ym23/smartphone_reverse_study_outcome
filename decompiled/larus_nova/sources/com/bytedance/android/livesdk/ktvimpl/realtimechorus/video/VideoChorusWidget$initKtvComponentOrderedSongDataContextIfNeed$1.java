package com.bytedance.android.livesdk.ktvimpl.realtimechorus.video;

import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/KtvComponentOrderedSongDataContext;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class VideoChorusWidget$initKtvComponentOrderedSongDataContextIfNeed$1 extends FunctionReferenceImpl implements Function0<KtvComponentOrderedSongDataContext> {
    public static final VideoChorusWidget$initKtvComponentOrderedSongDataContextIfNeed$1 INSTANCE = null;

    static {
        INSTANCE = new VideoChorusWidget$initKtvComponentOrderedSongDataContextIfNeed$1();
    }

    public VideoChorusWidget$initKtvComponentOrderedSongDataContextIfNeed$1() {
        super(0, KtvComponentOrderedSongDataContext.class, "<init>", "<init>()V", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final KtvComponentOrderedSongDataContext invoke() {
        return new KtvComponentOrderedSongDataContext();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ KtvComponentOrderedSongDataContext invoke() {
        return invoke();
    }
}
