package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SharingStarted.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f38981a = null;

    /* JADX INFO: compiled from: SharingStarted.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f38982a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final ah f38983b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final ah f38984c = null;

        private a() {
        }

        static {
            f38982a = new a();
            f38983b = (ah) ZeusTransformUtils.preCheckCast(new ai(), ah.class, "com.obric.aiagent.plugin");
            f38984c = (ah) ZeusTransformUtils.preCheckCast(new aj(), ah.class, "com.obric.aiagent.plugin");
        }

        public final ah a() {
            return f38983b;
        }

        public final ah b() {
            return f38984c;
        }
    }

    static {
        f38981a = a.f38982a;
    }

    h<af> a(ak<Integer> r1);
}
