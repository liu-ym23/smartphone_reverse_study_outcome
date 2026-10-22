package az0;

import com.bytedance.ies.web.jsbridge2.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import wy0.f;
import wy0.h;

/* JADX INFO: loaded from: classes47.dex */
public final class b extends y6.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f16784b;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map.Entry f16785a;

        public a(Map.Entry r100) {
            this.f16785a = r100;
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return ((h) this.f16785a.getValue()).a();
        }
    }

    public b(f r100) {
        Intrinsics.checkNotNullParameter(r100, "originalFactory");
        this.f16784b = r100;
    }

    @Override // y6.a
    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> k(y6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        LinkedHashMap r101 = new LinkedHashMap();
        r101.putAll(this.f16784b.a(r100));
        Map<String, h<Object, ?>> r102 = this.f16784b.c(r100);
        ArrayList r103 = new ArrayList(r102.size());
        Iterator<Map.Entry<String, h<Object, ?>>> r104 = r102.entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        Map.Entry<String, h<Object, ?>> r105 = r104.next();
        r103.add(TuplesKt.to(r105.getKey(), new a(r105)));
        goto L4
    L6:
        MapsKt.putAll(r101, r103);
        return r101;
    }

    @Override // y6.a
    public final Map<String, g<?, ?>> n(y6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        LinkedHashMap r101 = new LinkedHashMap();
        r101.putAll(this.f16784b.d(r100));
        r101.putAll(this.f16784b.f(r100));
        return r101;
    }
}
