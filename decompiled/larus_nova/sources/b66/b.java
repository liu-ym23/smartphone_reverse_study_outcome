package b66;

import com.bytedance.ies.xbridge.XReadableType;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends com.bytedance.ies.xbridge.model.params.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f17855c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f17856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f17857b;

    public static final class a {

        /* JADX INFO: renamed from: b66.b$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0272a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f17858a = null;

            static {
                int[] r100 = new int[XReadableType.values().length];
                r100[XReadableType.Number.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[XReadableType.Int.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f17858a = r100;
            }
        }
    }

    static {
    }

    @Override // com.bytedance.ies.xbridge.model.params.a
    public final List<String> provideParamList() {
        return CollectionsKt.listOf(new String[]{"eventName", "timestamp"});
    }

    public b() {
    }
}
