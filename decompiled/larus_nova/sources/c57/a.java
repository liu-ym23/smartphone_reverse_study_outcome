package c57;

import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m47.h;
import m47.i;
import m47.o;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements PiaMethod.a<c, d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PiaMethod<c, d> f22484a = null;

    /* JADX INFO: renamed from: c57.a$a, reason: collision with other inner class name */
    public static final class C0406a<T> implements l47.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0406a<T> f22485a = null;

        static {
            f22485a = new C0406a();
        }

        public C0406a() {
        }

        @Override // l47.b
        public final Object create() {
            return new a();
        }

        @Override // l47.b
        public final Object create(Object r100) {
            return create();
        }
    }

    public static final class b {
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0004\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lc57/a$c;", "", "Lcom/google/gson/JsonObject;", "query", "Lcom/google/gson/JsonObject;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/google/gson/JsonObject;", "", "url", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "", "sdk", "Ljava/lang/Number;", "b", "()Ljava/lang/Number;", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("query")
        private final JsonObject query;

        @SerializedName("sdk")
        private final Number sdk;

        @SerializedName("url")
        private final String url;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.query, r101.query) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.url, r101.url) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.sdk, r101.sdk) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            JsonObject r100 = this.query;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.url;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Number r107 = this.sdk;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Params(query=" + this.query + ", url=" + this.url + ", sdk=" + this.sdk + ')';
        }

        public final JsonObject a() {
            return this.query;
        }

        public final Number b() {
            return this.sdk;
        }

        public final String c() {
            return this.url;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lc57/a$d;", "", "", "delete", "Z", "getDelete", "()Z", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        @SerializedName("delete")
        private final boolean delete;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.delete == ((d) r100).delete) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.delete == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "Result(delete=" + this.delete + ')';
        }

        public d(boolean r100) {
            this.delete = r100;
        }
    }

    public a() {
    }

    static {
        f22484a = new PiaMethod("pia.removeSnapshot", PiaMethod.Scope.Render, C0406a.f22485a);
    }

    @Override // com.bytedance.pia.core.api.bridge.PiaMethod.a
    public final void a(o r100, Object r101, h r102, i r103) {
        c r104 = (c) r101;
        Intrinsics.checkNotNullParameter(r100, "bridge");
        Intrinsics.checkNotNullParameter(r104, "params");
        Intrinsics.checkNotNullParameter(r102, JSEventListener.ACTION_RESOLVE);
        Intrinsics.checkNotNullParameter(r103, "reject");
        ThreadUtil.c(new c57.b(r104, r103, r102));
    }
}
