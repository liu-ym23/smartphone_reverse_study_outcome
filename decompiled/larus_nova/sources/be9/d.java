package be9;

import com.larus.im.internal.database.entity.MessageEntity;
import java.util.List;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
public interface d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f18789c = null;

    /* JADX INFO: loaded from: classes29.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f18790a = null;

        static {
            f18790a = new a();
        }

        public a() {
        }
    }

    static {
        f18789c = a.f18790a;
    }

    Object A(String r100, Continuation<? super MessageEntity> r101);

    Object C(String r100, Continuation<? super MessageEntity> r101);

    Object D(String r100, int r101, Continuation<? super Integer> r102);

    Object H(String r100, Continuation<? super Integer> r101);

    Object a(String r100, Continuation<? super MessageEntity> r101);

    Object b(List<String> r100, Continuation<? super List<MessageEntity>> r101);

    Object h(List<String> r100, Continuation<? super List<MessageEntity>> r101);

    Object i(String r100, String r101, Continuation<? super List<MessageEntity>> r102);

    Object o(List<String> r100, Continuation<? super Integer> r101);

    Object r(String r100, int r101, Continuation<? super Integer> r102);

    Object x(String r100, boolean r101, Continuation<? super Integer> r102);

    Object z(int r100, Continuation<? super List<MessageEntity>> r101);
}
