package com.bytedance.android.gamecp.hybrid_impl.lynx;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\tR'\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/lynx/GameCpBehaviorProvider;", "", "", "Lcom/lynx/tasm/behavior/a;", "behaviorList$delegate", "Lkotlin/Lazy;", "getBehaviorList", "()Ljava/util/List;", "getBehaviorList$annotations", "()V", "behaviorList", "<init>", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameCpBehaviorProvider {
    public static final GameCpBehaviorProvider INSTANCE = null;
    private static final Lazy behaviorList$delegate = null;

    private GameCpBehaviorProvider() {
    }

    public static final List<com.lynx.tasm.behavior.a> getBehaviorList() {
        return (List) behaviorList$delegate.getValue();
    }

    @JvmStatic
    public static /* synthetic */ void getBehaviorList$annotations() {
    }

    static {
        INSTANCE = new GameCpBehaviorProvider();
        behaviorList$delegate = LazyKt.lazy(GameCpBehaviorProvider$behaviorList$2.INSTANCE);
    }
}
