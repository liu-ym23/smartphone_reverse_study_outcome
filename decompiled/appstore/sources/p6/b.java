package p6;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;

/* JADX INFO: loaded from: classes.dex */
public class b extends BaseHttpRequestInfo {
    public boolean M;
    public int N;

    public static class a implements BaseHttpRequestInfo.ICreate {
        public a() {
        }

        @Override // com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo.ICreate
        public BaseHttpRequestInfo create() {
            return new b();
        }
    }

    public b() {
        this.M = false;
        this.N = -1;
    }

    public static void d() {
        BaseHttpRequestInfo.c(new a());
    }
}
