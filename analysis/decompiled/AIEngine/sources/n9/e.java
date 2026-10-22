package n9;

import android.text.TextUtils;
import android.util.LruCache;
import com.stepos.deepbinder.core.entity.internal.InternalMethod;
import com.stepos.deepbinder.core.entity.wrapper.BaseWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.exception.IPCException;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.g;
import x9.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: e, reason: collision with root package name */
    public static final a f10682e = new a();

    /* renamed from: f, reason: collision with root package name */
    public static volatile e f10683f;

    /* renamed from: a, reason: collision with root package name */
    public final MethodHandles.Lookup f10684a = MethodHandles.lookup();

    /* renamed from: b, reason: collision with root package name */
    public final LruCache<String, Class<?>> f10685b = new LruCache<>(500);

    /* renamed from: c, reason: collision with root package name */
    public final LruCache<String, Constructor<?>> f10686c = new LruCache<>(500);

    /* renamed from: d, reason: collision with root package name */
    public final LruCache<String, InternalMethod> f10687d = new LruCache<>(1000);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public final e a() {
            e eVar;
            e eVar2 = e.f10683f;
            if (eVar2 != null) {
                return eVar2;
            }
            synchronized (this) {
                eVar = e.f10683f;
                if (eVar == null) {
                    eVar = new e();
                    e.f10683f = eVar;
                }
            }
            return eVar;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Constructor<?> f10688a;

        /* renamed from: b, reason: collision with root package name */
        public final h.a f10689b;

        public b(Constructor<?> constructor, h.a matchResult) {
            g.f(matchResult, "matchResult");
            this.f10688a = constructor;
            this.f10689b = matchResult;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return g.b(this.f10688a, bVar.f10688a) && g.b(this.f10689b, bVar.f10689b);
        }

        public final int hashCode() {
            return this.f10689b.hashCode() + (this.f10688a.hashCode() * 31);
        }

        public final String toString() {
            return "ConstructorMatchResult(constructor=" + this.f10688a + ", matchResult=" + this.f10689b + ")";
        }
    }

    public final Class<?> a(BaseWrapper wrapper) {
        g.f(wrapper, "wrapper");
        String name = wrapper.getName();
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        return b(name);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Class<?> b(java.lang.String r2) throws java.lang.ClassNotFoundException {
        /*
            r1 = this;
            java.lang.String r0 = "typeName"
            kotlin.jvm.internal.g.f(r2, r0)
            android.util.LruCache<java.lang.String, java.lang.Class<?>> r1 = r1.f10685b
            java.lang.Object r0 = r1.get(r2)
            java.lang.Class r0 = (java.lang.Class) r0
            if (r0 == 0) goto L10
            return r0
        L10:
            int r0 = r2.hashCode()
            switch(r0) {
                case -1325958191: goto L7c;
                case 104431: goto L70;
                case 3039496: goto L64;
                case 3052374: goto L58;
                case 3327612: goto L4c;
                case 3625364: goto L40;
                case 64711720: goto L34;
                case 97526364: goto L27;
                case 109413500: goto L19;
                default: goto L17;
            }
        L17:
            goto L84
        L19:
            java.lang.String r0 = "short"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L23
            goto L84
        L23:
            java.lang.Class r0 = java.lang.Short.TYPE
            goto L94
        L27:
            java.lang.String r0 = "float"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L30
            goto L84
        L30:
            java.lang.Class r0 = java.lang.Float.TYPE
            goto L94
        L34:
            java.lang.String r0 = "boolean"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L3d
            goto L84
        L3d:
            java.lang.Class r0 = java.lang.Boolean.TYPE
            goto L94
        L40:
            java.lang.String r0 = "void"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L49
            goto L84
        L49:
            java.lang.Class r0 = java.lang.Void.TYPE
            goto L94
        L4c:
            java.lang.String r0 = "long"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L55
            goto L84
        L55:
            java.lang.Class r0 = java.lang.Long.TYPE
            goto L94
        L58:
            java.lang.String r0 = "char"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L61
            goto L84
        L61:
            java.lang.Class r0 = java.lang.Character.TYPE
            goto L94
        L64:
            java.lang.String r0 = "byte"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L6d
            goto L84
        L6d:
            java.lang.Class r0 = java.lang.Byte.TYPE
            goto L94
        L70:
            java.lang.String r0 = "int"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L79
            goto L84
        L79:
            java.lang.Class r0 = java.lang.Integer.TYPE
            goto L94
        L7c:
            java.lang.String r0 = "double"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L92
        L84:
            java.lang.Class r0 = java.lang.Class.forName(r2)     // Catch: java.lang.ClassNotFoundException -> L89
            goto L94
        L89:
            r1 = move-exception
            com.stepos.deepbinder.core.exception.IPCException r2 = new com.stepos.deepbinder.core.exception.IPCException
            r0 = 21
            r2.<init>(r0, r1)
            throw r2
        L92:
            java.lang.Class r0 = java.lang.Double.TYPE
        L94:
            r1.put(r2, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n9.e.b(java.lang.String):java.lang.Class");
    }

    public final Class<?>[] c(ParameterWrapper[] parameterWrapperArr) {
        if (parameterWrapperArr == null) {
            return new Class[0];
        }
        int length = parameterWrapperArr.length;
        Class<?>[] clsArr = new Class[length];
        for (int i10 = 0; i10 < length; i10++) {
            ParameterWrapper parameterWrapper = parameterWrapperArr[i10];
            Class<?> clsA = a(parameterWrapper);
            if (clsA == null) {
                String name = parameterWrapper.getName();
                Object data = parameterWrapper.getData();
                String name2 = data != null ? data.getClass().getName() : null;
                StringBuilder sbE = h0.e.e("Failed to get class type for parameter at index ", i10, ": name='", name, "', data=");
                sbE.append(name2);
                throw new IPCException(21, sbE.toString());
            }
            clsArr[i10] = clsA;
        }
        return clsArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.deepbinder.core.entity.internal.InternalMethod d(java.lang.Class<?> r18, java.lang.String r19, com.stepos.deepbinder.core.entity.wrapper.MethodWrapper r20, com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper[] r21) throws java.lang.ClassNotFoundException, java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 439
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n9.e.d(java.lang.Class, java.lang.String, com.stepos.deepbinder.core.entity.wrapper.MethodWrapper, com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper[]):com.stepos.deepbinder.core.entity.internal.InternalMethod");
    }
}
