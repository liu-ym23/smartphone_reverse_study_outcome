package com.bytedance.android.livesdk.dynamicstrategy.api;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import iu1.b;
import java.util.List;
import ju1.n;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes8.dex */
public interface IDynamicStrategyContext {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/api/IDynamicStrategyContext$Scope;", "", "GLOBAL", "LIVE_ROOM", "dynamicstrategy-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Scope extends Enum<Scope> {
        public static final Scope GLOBAL = null;
        public static final Scope LIVE_ROOM = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Scope[] f123025a = null;

        static {
            Scope r100 = new Scope("GLOBAL", 0);
            GLOBAL = r100;
            Scope r101 = new Scope("LIVE_ROOM", 1);
            LIVE_ROOM = r101;
            f123025a = new Scope[]{r100, r101};
        }

        public static Scope valueOf(String r100) {
            return (Scope) a.a(Scope.class, r100);
        }

        public static Scope[] values() {
            return (Scope[]) f123025a.clone();
        }

        public Scope(String r100, int r101) {
            super(r100, r101);
        }
    }

    PropertyOwner<n> getStrategy(String r100);

    void upsertFactors(List<? extends DynamicFactor<? extends Object>> r100);

    void upsertStrategy(List<? extends b> r100);
}
