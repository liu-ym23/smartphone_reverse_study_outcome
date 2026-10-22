package za;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.IAppInfo;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements IAppInfo {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AppInfo f26309a;

        public a(AppInfo r10) {
            q.g(r10, "appInfo");
            super(null);
            this.f26309a = r10;
        }

        @Override // za.b, com.bytedanceos.common.model.IAppInfo
        public AppInfo getAppInfo() {
            return this.f26309a;
        }
    }

    /* JADX INFO: renamed from: za.b$b, reason: collision with other inner class name */
    public static final class C0421b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f26310a;

        public C0421b(String r10) {
            q.g(r10, "kwd");
            super(null);
            this.f26310a = r10;
        }

        public final String a() {
            return this.f26310a;
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f26311a = null;

        static {
            f26311a = new c();
        }

        public c() {
            super(null);
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker r10) {
        this();
    }

    @Override // com.bytedanceos.common.model.IAppInfo
    public AppInfo getAppInfo() {
        return IAppInfo.DefaultImpls.getAppInfo(this);
    }

    public b() {
    }
}
