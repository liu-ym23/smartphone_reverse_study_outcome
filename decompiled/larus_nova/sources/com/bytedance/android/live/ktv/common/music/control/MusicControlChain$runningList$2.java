package com.bytedance.android.live.ktv.common.music.control;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/android/live/ktv/common/music/control/IMusicControlNode;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class MusicControlChain$runningList$2 extends FunctionReferenceImpl implements Function0<CopyOnWriteArrayList<IMusicControlNode>> {
    public static final MusicControlChain$runningList$2 INSTANCE = null;

    static {
        INSTANCE = new MusicControlChain$runningList$2();
    }

    public MusicControlChain$runningList$2() {
        super(0, CopyOnWriteArrayList.class, "<init>", "<init>()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CopyOnWriteArrayList<IMusicControlNode> invoke2() {
        return new CopyOnWriteArrayList();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ CopyOnWriteArrayList<IMusicControlNode> invoke() {
        return invoke2();
    }
}
