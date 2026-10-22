package f6;

import com.bytedance.retrofit2.Endpoint;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    public static class a implements Endpoint {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f19495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f19496b;

        public a(String r10, String r11) {
            this.f19495a = r10;
            this.f19496b = r11;
        }

        @Override // com.bytedance.retrofit2.Endpoint
        public String getName() {
            return this.f19496b;
        }

        @Override // com.bytedance.retrofit2.Endpoint
        public String getUrl() {
            return this.f19495a;
        }
    }

    public static Endpoint a(String r10) {
        return new a(r10, "default");
    }
}
