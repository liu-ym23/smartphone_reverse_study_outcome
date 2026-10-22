package b29;

import com.larus.common_ui.widget.input.audiowave.AudioWaveGroup;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<AudioWaveGroup> f17099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f17100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f17102d;

    public static final class a {

        /* JADX INFO: renamed from: b29.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: classes27.dex */
        public static final class C0254a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f17103a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f17104b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final int[] f17105c;

            public C0254a(long r100, int[] r101) {
                Intrinsics.checkNotNullParameter(r101, "targetWaveBarHeights");
                this.f17103a = r100;
                this.f17104b = 400;
                this.f17105c = r101;
            }
        }
    }

    static {
    }

    public c(int r100) {
        List r101 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r101, "audioWaveGroups");
        this.f17099a = CollectionsKt.toList(r101);
        this.f17100b = LazyKt.lazy(new b());
        this.f17101c = r101.size() / 2;
        this.f17102d = -1;
    }
}
