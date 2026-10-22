package ad9;

import com.larus.im.bean.message.block.MusicCreationContent;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: classes29.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3035a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f3036a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final HashMap<String, MusicCreationContent> f3037b = null;

        public a() {
        }

        static {
            f3036a = new a();
            f3037b = new HashMap();
        }
    }

    /* JADX INFO: renamed from: ad9.b$b, reason: collision with other inner class name */
    public static final class C0057b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MusicCreationContent f3039b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C0057b) == true) goto L8;
            return false;
        L8:
            C0057b r101 = (C0057b) r100;
            if (this.f3038a == r101.f3038a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3039b, r101.f3039b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f3038a * 31) + this.f3039b.hashCode();
        }

        public final String toString() {
            return "MusicShuffleAction(direction=" + this.f3038a + ", nextContent=" + this.f3039b + ')';
        }

        public C0057b(int r100, MusicCreationContent r101) {
            Intrinsics.checkNotNullParameter(r101, "nextContent");
            this.f3038a = r100;
            this.f3039b = r101;
        }
    }

    static {
        f3035a = a.f3036a;
    }

    String a();

    MutableSharedFlow<C0057b> b();

    boolean c();

    MusicCreationContent d();

    boolean getHasNext();

    boolean getHasPrevious();

    String getItemId();

    MusicCreationContent getNext();

    String getVid();
}
