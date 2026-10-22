package com.bytedance.android.annie.service.business.latch;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.lynx.tasm.LynxView;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes43.dex */
public interface IAnnieBusinessLatchService extends com.bytedance.android.annie.service.a {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/annie/service/business/latch/IAnnieBusinessLatchService$PrefetchStrategy;", "", "Latch", "Nothing", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final enum PrefetchStrategy extends Enum<PrefetchStrategy> {
        public static final PrefetchStrategy Latch = null;
        public static final PrefetchStrategy Nothing = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PrefetchStrategy[] f39844a = null;

        public static PrefetchStrategy valueOf(String r100) {
            return (PrefetchStrategy) r27.a.a(PrefetchStrategy.class, r100);
        }

        public static PrefetchStrategy[] values() {
            return (PrefetchStrategy[]) f39844a.clone();
        }

        static {
            PrefetchStrategy r100 = new PrefetchStrategy("Latch", 0);
            Latch = r100;
            PrefetchStrategy r101 = new PrefetchStrategy("Nothing", 1);
            Nothing = r101;
            f39844a = new PrefetchStrategy[]{r100, r101};
        }

        public PrefetchStrategy(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f39845a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f39846b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f39847c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f39848d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f39849e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f39850f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Map<String, String> f39851g;

        public a() {
            this.f39845a = "";
            this.f39847c = "fullscreen";
            this.f39848d = "";
            this.f39850f = "";
            this.f39851g = new LinkedHashMap();
        }
    }

    public interface b extends Disposable {
        void X0(IHybridComponent r100);

        void Y0(LynxView r100);
    }

    b C0(Context r100, String r101, String r102, Uri r103, long r104, a r105, boolean r106);

    void P0(Uri r100);

    void d(String r100, boolean r101);

    a e(long r100, String r101, String r102, String r103);

    String i(Uri r100);

    Pair<PrefetchStrategy, String> k(Uri r100, String r101);

    int w1(Context r100, String r101, Uri r102, a r103);
}
