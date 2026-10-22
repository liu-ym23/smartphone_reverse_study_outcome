package a82;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.g;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends g<b, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c82.a f2139a;

    /* JADX INFO: renamed from: a82.a$a, reason: collision with other inner class name */
    public static final class C0024a {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"La82/a$b;", "", "La82/a$b$a;", "args", "La82/a$b$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()La82/a$b$a;", "setArgs", "(La82/a$b$a;)V", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("args")
        private C0025a args;

        /* JADX INFO: renamed from: a82.a$b$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"La82/a$b$a;", "", "", "width", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "setWidth", "(Ljava/lang/Integer;)V", "height", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setHeight", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class C0025a {

            @SerializedName("height")
            private Integer height;

            @SerializedName("width")
            private Integer width;

            public final String toString() {
                return "Args(width=" + this.width + ", height=" + this.height + ')';
            }

            public C0025a() {
                this.width = 0;
                this.height = 0;
            }

            public final Integer a() {
                return this.height;
            }

            public final Integer b() {
                return this.width;
            }
        }

        public b() {
        }

        public final String toString() {
            return "Params(args=" + this.args + ')';
        }

        public final C0025a a() {
            return this.args;
        }
    }

    static {
    }

    public a(c82.a r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        this.f2139a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(b r100, CallContext r101) {
        b r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        b.C0025a r103 = r102.a();
        if (r103 != null) goto L5;
        int r104 = b82.a.f18011a;
        b82.a.a("JSB_ERROR,  null args: " + r102, null);
    L12:
        return null;
    L5:
        Integer r105 = r103.b();
        Integer r106 = r103.a();
        if (r105 == null) goto L11;
        if (r106 == null) goto L11;
        c82.a r107 = this.f2139a;
        int r108 = r105.intValue();
        int r109 = r106.intValue();
        Function2<Integer, Integer, Unit> r110 = r107.f22705c;
        if (r110 == null) goto L12;
        Unit r111 = r110.invoke(Integer.valueOf(r108), Integer.valueOf(r109));
    L11:
        int r112 = b82.a.f18011a;
        b82.a.a("JSB_ERROR, null args : " + r103, null);
        goto L12
    }
}
