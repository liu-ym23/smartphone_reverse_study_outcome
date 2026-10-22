package be9;

import com.larus.im.internal.database.entity.BotEntity;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0294a f18782a = null;

    /* JADX INFO: renamed from: be9.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes29.dex */
    public static final class C0294a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C0294a f18783a = null;

        static {
            f18783a = new C0294a();
        }

        public C0294a() {
        }
    }

    static {
        f18782a = C0294a.f18783a;
    }

    Object d(BotEntity r100, Continuation<? super Unit> r101);

    Object g(List<String> r100, Continuation<? super List<BotEntity>> r101);

    Object j(String r100, Continuation<? super BotEntity> r101);
}
