package androidx.window.layout;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0003\u0011\u0012\u0013R\u0014\u0010\u0003\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Landroidx/window/layout/FoldingFeature;", "Landroidx/window/layout/DisplayFeature;", "", "isSeparating", "()Z", "Landroidx/window/layout/FoldingFeature$a;", "getOcclusionType", "()Landroidx/window/layout/FoldingFeature$a;", "occlusionType", "Landroidx/window/layout/FoldingFeature$b;", "getOrientation", "()Landroidx/window/layout/FoldingFeature$b;", "orientation", "Landroidx/window/layout/FoldingFeature$c;", "getState", "()Landroidx/window/layout/FoldingFeature$c;", WsConstants.KEY_CONNECTION_STATE, "a", "b", "c", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FoldingFeature extends DisplayFeature {

    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0054a f5251b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f5252c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f5253d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5254a;

        /* JADX INFO: renamed from: androidx.window.layout.FoldingFeature$a$a, reason: collision with other inner class name */
        public static final class C0054a {
            public /* synthetic */ C0054a(DefaultConstructorMarker r10) {
                this();
            }

            public C0054a() {
            }
        }

        static {
            f5251b = new C0054a(null);
            f5252c = new a("NONE");
            f5253d = new a("FULL");
        }

        public a(String r10) {
            this.f5254a = r10;
        }

        public String toString() {
            return this.f5254a;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f5255b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f5256c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f5257d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5258a;

        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker r10) {
                this();
            }

            public a() {
            }
        }

        static {
            f5255b = new a(null);
            f5256c = new b("VERTICAL");
            f5257d = new b("HORIZONTAL");
        }

        public b(String r10) {
            this.f5258a = r10;
        }

        public String toString() {
            return this.f5258a;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f5259b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f5260c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f5261d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5262a;

        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker r10) {
                this();
            }

            public a() {
            }
        }

        static {
            f5259b = new a(null);
            f5260c = new c("FLAT");
            f5261d = new c("HALF_OPENED");
        }

        public c(String r10) {
            this.f5262a = r10;
        }

        public String toString() {
            return this.f5262a;
        }
    }

    @NotNull
    a getOcclusionType();

    @NotNull
    b getOrientation();

    @NotNull
    c getState();

    boolean isSeparating();
}
