package cc2;

/* JADX INFO: loaded from: classes9.dex */
public abstract class j extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23193a;

    public static final class a extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f23194b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f23195c = null;

        static {
            f23195c = new a();
            f23194b = "ChatChannelEvent";
        }

        public a() {
        }

        @Override // cc2.o
        public final String b() {
            return f23194b;
        }
    }

    public static final class b extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f23196b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f23197c = null;

        static {
            f23197c = new b();
            f23196b = "IMEmojiShow";
        }

        public b() {
        }

        @Override // cc2.o
        public final String b() {
            return f23196b;
        }
    }

    public j() {
        this.f23193a = "imemoji_entrance";
    }

    @Override // cc2.o
    public final String a() {
        return this.f23193a;
    }
}
