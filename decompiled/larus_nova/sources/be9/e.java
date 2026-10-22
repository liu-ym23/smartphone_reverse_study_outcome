package be9;

import com.larus.im.internal.database.entity.ParticipantEntity;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes29.dex */
public interface e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f18791d = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f18792a = null;

        static {
            f18792a = new a();
        }

        public a() {
        }
    }

    static {
        f18791d = a.f18792a;
    }

    Object B(String r100, String r101, Continuation<? super ParticipantEntity> r102);

    Object c(String r100, Continuation<? super List<ParticipantEntity>> r101);

    Object f(List<ParticipantEntity> r100, Continuation<? super Unit> r101);

    Object w(List<String> r100, Continuation<? super Integer> r101);

    Object y(String r100, Continuation<? super Integer> r101);
}
