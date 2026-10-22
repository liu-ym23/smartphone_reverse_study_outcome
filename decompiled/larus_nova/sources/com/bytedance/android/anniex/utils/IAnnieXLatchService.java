package com.bytedance.android.anniex.utils;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/anniex/utils/IAnnieXLatchService;", "Lcom/bytedance/android/anniex/base/service/e;", "PrefetchStrategy", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex_release"}, k = 1, mv = {1, 4, 3})
public interface IAnnieXLatchService extends com.bytedance.android.anniex.base.service.e {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/anniex/utils/IAnnieXLatchService$PrefetchStrategy;", "", "Latch", "Nothing", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum PrefetchStrategy extends Enum<PrefetchStrategy> {
        public static final PrefetchStrategy Latch = null;
        public static final PrefetchStrategy Nothing = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PrefetchStrategy[] f41397a = null;

        public static PrefetchStrategy valueOf(String r100) {
            return (PrefetchStrategy) r27.a.a(PrefetchStrategy.class, r100);
        }

        public static PrefetchStrategy[] values() {
            return (PrefetchStrategy[]) f41397a.clone();
        }

        static {
            PrefetchStrategy r100 = new PrefetchStrategy("Latch", 0);
            Latch = r100;
            PrefetchStrategy r101 = new PrefetchStrategy("Nothing", 1);
            Nothing = r101;
            f41397a = new PrefetchStrategy[]{r100, r101};
        }

        public PrefetchStrategy(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a extends Disposable {
    }

    a Y();

    void r0();
}
