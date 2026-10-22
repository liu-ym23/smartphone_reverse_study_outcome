package b66;

import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends com.bytedance.ies.xbridge.model.params.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f17850d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f17851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f17852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public XReadableMap f17853c;

    /* JADX INFO: renamed from: b66.a$a, reason: collision with other inner class name */
    public static final class C0270a {

        /* JADX INFO: renamed from: b66.a$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0271a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f17854a = null;

            static {
                int[] r100 = new int[XReadableType.values().length];
                r100[XReadableType.Number.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[XReadableType.Int.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f17854a = r100;
            }
        }
    }

    static {
    }

    @Override // com.bytedance.ies.xbridge.model.params.a
    public final List<String> provideParamList() {
        return CollectionsKt.listOf(new String[]{"eventName", "timestamp", "params"});
    }

    public a() {
    }
}
