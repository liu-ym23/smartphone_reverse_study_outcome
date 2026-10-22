package be9;

import com.larus.im.internal.database.entity.ConversationEntity;
import com.larus.im.internal.jni.bean.OmniConversationType;
import java.util.List;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
public interface b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f18784b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f18785a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final vt7.a<String, vt7.b<String>> f18786b = null;

        public a() {
        }

        static {
            f18785a = new a();
            f18786b = new vt7.a();
        }

        public static void a(List r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            String r101 = com.larus.im.internal.delegate.b.f348193b.getUserId();
            vt7.a<String, vt7.b<String>> r102 = f18786b;
            vt7.b<String> r103 = r102.get(r101);
            if (r103 != null) goto L7;
            r103 = new vt7.b();
        L7:
            r103.addAll(r100);
            r102.put(r101, r103);
        }
    }

    /* JADX INFO: renamed from: be9.b$b, reason: collision with other inner class name */
    public static final class C0295b {
        public static /* synthetic */ Object a(b r100, String r101, int r102, Continuation r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r102 = OmniConversationType.CONVERSATION_TYPE_UNKNOWN.value;
        L6:
            return r100.u(r101, r102, false, r103);
        }
    }

    static {
        f18784b = a.f18785a;
    }

    Object E(int r100, long r101, int r102, Continuation<? super List<ConversationEntity>> r103);

    Object F(int r100, long r101, Continuation<? super List<ConversationEntity>> r102);

    Object G(int r100, long r101, Continuation<? super List<ConversationEntity>> r102);

    Object e(ConversationEntity r100, Continuation<? super Long> r101);

    Object k(Continuation<? super List<ConversationEntity>> r100);

    Object l(String r100, int r101, Continuation<? super List<ConversationEntity>> r102);

    Object m(int r100, Continuation<? super List<String>> r101);

    Object n(String r100, long r101, Continuation<? super Integer> r102);

    Object p(int r100, long r101, int r102, Continuation<? super List<ConversationEntity>> r103);

    Object q(List<String> r100, Continuation<? super Integer> r101);

    Object s(List<String> r100, Continuation<? super List<ConversationEntity>> r101);

    Object t(int r100, Continuation<? super List<ConversationEntity>> r101);

    Object u(String r100, int r101, boolean r102, Continuation<? super ConversationEntity> r103);

    Object v(int r100, int r101, Continuation<? super List<ConversationEntity>> r102);
}
