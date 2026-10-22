package be9;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes29.dex */
public interface c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18787a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f18788a = null;

        static {
            f18788a = new a();
        }

        public a() {
        }
    }

    static {
        f18787a = a.f18788a;
    }

    Object a(String r100, String r101, List<String> r102, Continuation<? super Boolean> r103);

    Object b(String r100, Continuation<? super Boolean> r101);

    Object c(String r100, String r101, String r102, Continuation<? super Boolean> r103);

    Object d(String r100, Continuation<? super List<String>> r101);

    Object e(String r100, ContinuationImpl r101);
}
