package Z2;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Process;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import androidx.appcompat.widget.N0;
import androidx.lifecycle.C0311h;
import androidx.room.AbstractC0351g;
import d3.AbstractC0542d;
import java.io.EOFException;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import k3.C0694i;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes2.dex */
public abstract class I {

    /* renamed from: a, reason: collision with root package name */
    public static long f2168a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f2169b;

    /* renamed from: d, reason: collision with root package name */
    public static final X.r f2171d;

    /* renamed from: e, reason: collision with root package name */
    public static final X.r f2172e;

    /* renamed from: f, reason: collision with root package name */
    public static final X.r f2173f;

    /* renamed from: g, reason: collision with root package name */
    public static final X.r f2174g;

    /* renamed from: h, reason: collision with root package name */
    public static final X.r f2175h;

    /* renamed from: i, reason: collision with root package name */
    public static final X.r f2176i;

    /* renamed from: j, reason: collision with root package name */
    public static final X.r f2177j;

    /* renamed from: c, reason: collision with root package name */
    public static final X.r f2170c = new X.r("RESUME_TOKEN", 4);

    /* renamed from: k, reason: collision with root package name */
    public static final U f2178k = new U(false);

    /* renamed from: l, reason: collision with root package name */
    public static final U f2179l = new U(true);

    static {
        int i4 = 4;
        f2171d = new X.r("REMOVED_TASK", i4);
        f2172e = new X.r("CLOSED_EMPTY", i4);
        int i5 = 4;
        f2173f = new X.r("COMPLETING_ALREADY", i5);
        f2174g = new X.r("COMPLETING_WAITING_CHILDREN", i5);
        f2175h = new X.r("COMPLETING_RETRY", i5);
        f2176i = new X.r("TOO_LATE_TO_CANCEL", i5);
        f2177j = new X.r("SEALED", i5);
    }

    public static final Object A(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj instanceof ArrayList) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ((ArrayList) obj).add(obj2);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return arrayList;
    }

    public static final int B(k3.y yVar, int i4) {
        int i5;
        Intrinsics.checkNotNullParameter(yVar, "<this>");
        int[] iArr = yVar.f13396f;
        int i6 = i4 + 1;
        int length = yVar.f13395e.length;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int i7 = length - 1;
        int i8 = 0;
        while (true) {
            if (i8 <= i7) {
                i5 = (i8 + i7) >>> 1;
                int i9 = iArr[i5];
                if (i9 >= i6) {
                    if (i9 <= i6) {
                        break;
                    }
                    i7 = i5 - 1;
                } else {
                    i8 = i5 + 1;
                }
            } else {
                i5 = (-i8) - 1;
                break;
            }
        }
        return i5 >= 0 ? i5 : ~i5;
    }

    public static void C(ArrayList arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != 1) {
            throw new w3.b(arrayList);
        }
        Throwable th = (Throwable) arrayList.get(0);
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (!(th instanceof Error)) {
            throw new RuntimeException(th);
        }
        throw ((Error) th);
    }

    public static void D(Throwable th) {
        if (th instanceof w3.e) {
            throw ((w3.e) th);
        }
        if (th instanceof w3.d) {
            throw ((w3.d) th);
        }
        if (th instanceof w3.c) {
            throw ((w3.c) th);
        }
        if (th instanceof StackOverflowError) {
            throw ((StackOverflowError) th);
        }
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }

    public static void E(Throwable th, t3.g gVar, Object obj) {
        D(th);
        w3.h.a(obj, th);
        gVar.f(th);
    }

    public static final String F(Continuation continuation) {
        Object objM22constructorimpl;
        if (continuation instanceof d3.i) {
            return continuation.toString();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objM22constructorimpl = Result.m22constructorimpl(continuation + '@' + p(continuation));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22constructorimpl = Result.m22constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m25exceptionOrNullimpl(objM22constructorimpl) != null) {
            objM22constructorimpl = continuation.getClass().getName() + '@' + p(continuation);
        }
        return (String) objM22constructorimpl;
    }

    public static final Object G(Object obj) {
        InterfaceC0131i0 interfaceC0131i0;
        C0133j0 c0133j0 = obj instanceof C0133j0 ? (C0133j0) obj : null;
        return (c0133j0 == null || (interfaceC0131i0 = c0133j0.f2224a) == null) ? obj : interfaceC0131i0;
    }

    public static r0 a() {
        return new r0(null);
    }

    public static E0 b() {
        return new E0(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final o3.c c(java.lang.String r9, java.lang.Object[] r10) {
        /*
            r0 = 0
            if (r10 == 0) goto L13
            int r1 = r10.length
            if (r1 != 0) goto L7
            goto L13
        L7:
            int r1 = r10.length
            int r1 = r1 + (-1)
            r1 = r10[r1]
            boolean r2 = r1 instanceof java.lang.Throwable
            if (r2 == 0) goto L13
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            goto L14
        L13:
            r1 = r0
        L14:
            if (r9 != 0) goto L1c
            o3.c r9 = new o3.c
            r9.<init>(r1, r0, r10)
            return r9
        L1c:
            if (r10 != 0) goto L24
            o3.c r10 = new o3.c
            r10.<init>(r0, r9, r0)
            return r10
        L24:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r3 = r9.length()
            int r3 = r3 + 50
            r2.<init>(r3)
            r3 = 0
            r4 = r3
        L31:
            int r5 = r10.length
            if (r3 >= r5) goto Lad
            java.lang.String r5 = "{}"
            int r5 = r9.indexOf(r5, r4)
            r6 = -1
            if (r5 != r6) goto L5a
            if (r4 != 0) goto L45
            o3.c r0 = new o3.c
            r0.<init>(r1, r9, r10)
            return r0
        L45:
            int r0 = r9.length()
            java.lang.String r9 = r9.substring(r4, r0)
            r2.append(r9)
            o3.c r9 = new o3.c
            java.lang.String r0 = r2.toString()
            r9.<init>(r1, r0, r10)
            return r9
        L5a:
            if (r5 != 0) goto L5d
            goto L98
        L5d:
            int r6 = r5 + (-1)
            char r7 = r9.charAt(r6)
            r8 = 92
            if (r7 != r8) goto L98
            r7 = 2
            if (r5 < r7) goto L87
            int r7 = r5 + (-2)
            char r7 = r9.charAt(r7)
            if (r7 != r8) goto L87
            java.lang.String r4 = r9.substring(r4, r6)
            r2.append(r4)
            r4 = r10[r3]
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            g(r2, r4, r6)
        L83:
            int r5 = r5 + 2
        L85:
            r4 = r5
            goto Laa
        L87:
            int r3 = r3 + (-1)
            java.lang.String r4 = r9.substring(r4, r6)
            r2.append(r4)
            r4 = 123(0x7b, float:1.72E-43)
            r2.append(r4)
            int r5 = r5 + 1
            goto L85
        L98:
            java.lang.String r4 = r9.substring(r4, r5)
            r2.append(r4)
            r4 = r10[r3]
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            g(r2, r4, r6)
            goto L83
        Laa:
            int r3 = r3 + 1
            goto L31
        Lad:
            int r5 = r9.length()
            java.lang.String r9 = r9.substring(r4, r5)
            r2.append(r9)
            int r9 = r10.length
            int r9 = r9 + (-1)
            if (r3 >= r9) goto Lc7
            o3.c r9 = new o3.c
            java.lang.String r0 = r2.toString()
            r9.<init>(r1, r0, r10)
            return r9
        Lc7:
            o3.c r9 = new o3.c
            java.lang.String r1 = r2.toString()
            r9.<init>(r0, r1, r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: Z2.I.c(java.lang.String, java.lang.Object[]):o3.c");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(kotlin.coroutines.Continuation r4, b3.InterfaceC0379h r5, b3.InterfaceC0380i r6) throws java.lang.Throwable {
        /*
            boolean r0 = r4 instanceof b3.p
            if (r0 == 0) goto L13
            r0 = r4
            b3.p r0 = (b3.p) r0
            int r1 = r0.f4427c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4427c = r1
            goto L18
        L13:
            b3.p r0 = new b3.p
            r0.<init>(r4)
        L18:
            java.lang.Object r4 = r0.f4426b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f4427c
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            kotlin.jvm.internal.Ref$ObjectRef r5 = r0.f4425a
            kotlin.ResultKt.throwOnFailure(r4)     // Catch: java.lang.Throwable -> L2b
            goto L4e
        L2b:
            r4 = move-exception
            r1 = r4
            goto L53
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r4)
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            b3.r r2 = new b3.r     // Catch: java.lang.Throwable -> L50
            r2.<init>(r6, r4)     // Catch: java.lang.Throwable -> L50
            r0.f4425a = r4     // Catch: java.lang.Throwable -> L50
            r0.f4427c = r3     // Catch: java.lang.Throwable -> L50
            java.lang.Object r4 = r5.collect(r2, r0)     // Catch: java.lang.Throwable -> L50
            if (r4 != r1) goto L4e
            goto L84
        L4e:
            r1 = 0
            goto L84
        L50:
            r5 = move-exception
            r1 = r5
            r5 = r4
        L53:
            T r4 = r5.element
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            if (r4 == 0) goto L5f
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r1)
            if (r5 != 0) goto L81
        L5f:
            kotlin.coroutines.CoroutineContext r5 = r0.get$context()
            Z2.n0 r6 = Z2.n0.f2230a
            kotlin.coroutines.CoroutineContext$Element r5 = r5.get(r6)
            Z2.o0 r5 = (Z2.o0) r5
            if (r5 == 0) goto L82
            Z2.x0 r5 = (Z2.x0) r5
            boolean r6 = r5.L()
            if (r6 != 0) goto L76
            goto L82
        L76:
            java.util.concurrent.CancellationException r5 = r5.C()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r1)
            if (r5 != 0) goto L81
            goto L82
        L81:
            throw r1
        L82:
            if (r4 != 0) goto L85
        L84:
            return r1
        L85:
            boolean r5 = r1 instanceof java.util.concurrent.CancellationException
            if (r5 == 0) goto L8d
            kotlin.ExceptionsKt.addSuppressed(r4, r1)
            throw r4
        L8d:
            kotlin.ExceptionsKt.addSuppressed(r1, r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: Z2.I.d(kotlin.coroutines.Continuation, b3.h, b3.i):java.lang.Object");
    }

    public static final void e(int i4) {
        if (i4 < 1) {
            throw new IllegalArgumentException(AbstractC0351g.m("Expected positive parallelism level, but got ", i4).toString());
        }
    }

    public static int f(Context context, String str, int i4, int i5, String str2) {
        int iC;
        if (context.checkPermission(str, i4, i5) == -1) {
            return -1;
        }
        String strD = androidx.core.app.h.d(str);
        if (strD == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i5);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        int iMyUid = Process.myUid();
        String packageName = context.getPackageName();
        if (iMyUid == i5 && Objects.equals(packageName, str2)) {
            AppOpsManager appOpsManagerC = androidx.core.app.i.c(context);
            iC = androidx.core.app.i.a(appOpsManagerC, strD, Binder.getCallingUid(), str2);
            if (iC == 0) {
                iC = androidx.core.app.i.a(appOpsManagerC, strD, i5, androidx.core.app.i.b(context));
            }
        } else {
            iC = androidx.core.app.h.c((AppOpsManager) androidx.core.app.h.a(context, AppOpsManager.class), strD, str2);
        }
        return iC == 0 ? 0 : -2;
    }

    public static void g(StringBuilder sb, Object obj, HashMap map) {
        if (obj == null) {
            sb.append("null");
            return;
        }
        if (!obj.getClass().isArray()) {
            try {
                sb.append(obj.toString());
                return;
            } catch (Throwable th) {
                System.err.println("SLF4J: Failed toString() invocation on an object of type [" + obj.getClass().getName() + "]");
                th.printStackTrace();
                sb.append("[FAILED toString()]");
                return;
            }
        }
        int i4 = 0;
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            sb.append('[');
            int length = zArr.length;
            while (i4 < length) {
                sb.append(zArr[i4]);
                if (i4 != length - 1) {
                    sb.append(", ");
                }
                i4++;
            }
            sb.append(']');
            return;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            sb.append('[');
            int length2 = bArr.length;
            while (i4 < length2) {
                sb.append((int) bArr[i4]);
                if (i4 != length2 - 1) {
                    sb.append(", ");
                }
                i4++;
            }
            sb.append(']');
            return;
        }
        if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            sb.append('[');
            int length3 = cArr.length;
            while (i4 < length3) {
                sb.append(cArr[i4]);
                if (i4 != length3 - 1) {
                    sb.append(", ");
                }
                i4++;
            }
            sb.append(']');
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            sb.append('[');
            int length4 = sArr.length;
            while (i4 < length4) {
                sb.append((int) sArr[i4]);
                if (i4 != length4 - 1) {
                    sb.append(", ");
                }
                i4++;
            }
            sb.append(']');
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            sb.append('[');
            int length5 = iArr.length;
            while (i4 < length5) {
                sb.append(iArr[i4]);
                if (i4 != length5 - 1) {
                    sb.append(", ");
                }
                i4++;
            }
            sb.append(']');
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            sb.append('[');
            int length6 = jArr.length;
            while (i4 < length6) {
                sb.append(jArr[i4]);
                if (i4 != length6 - 1) {
                    sb.append(", ");
                }
                i4++;
            }
            sb.append(']');
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            sb.append('[');
            int length7 = fArr.length;
            while (i4 < length7) {
                sb.append(fArr[i4]);
                if (i4 != length7 - 1) {
                    sb.append(", ");
                }
                i4++;
            }
            sb.append(']');
            return;
        }
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            sb.append('[');
            int length8 = dArr.length;
            while (i4 < length8) {
                sb.append(dArr[i4]);
                if (i4 != length8 - 1) {
                    sb.append(", ");
                }
                i4++;
            }
            sb.append(']');
            return;
        }
        Object[] objArr = (Object[]) obj;
        sb.append('[');
        if (map.containsKey(objArr)) {
            sb.append("...");
        } else {
            map.put(objArr, null);
            int length9 = objArr.length;
            while (i4 < length9) {
                g(sb, objArr[i4], map);
                if (i4 != length9 - 1) {
                    sb.append(", ");
                }
                i4++;
            }
            map.remove(objArr);
        }
        sb.append(']');
    }

    public static boolean h(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z4 = true;
        for (File file2 : fileArrListFiles) {
            z4 = h(file2) && z4;
        }
        return z4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0074 A[Catch: all -> 0x0037, TryCatch #0 {all -> 0x0037, blocks: (B:13:0x0031, B:24:0x0057, B:28:0x006c, B:30:0x0074, B:32:0x007a, B:34:0x0080, B:37:0x0091, B:38:0x0099, B:39:0x009a, B:40:0x00a5, B:20:0x004a, B:23:0x0051), top: B:55:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r9v4, types: [a3.v] */
    /* JADX WARN: Type inference failed for: r9v6, types: [a3.v] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x008e -> B:14:0x0034). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object i(b3.InterfaceC0380i r8, a3.s r9, boolean r10, kotlin.coroutines.Continuation r11) {
        /*
            Method dump skipped, instructions count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Z2.I.i(b3.i, a3.s, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final void j(CoroutineContext coroutineContext) {
        o0 o0Var = (o0) coroutineContext.get(n0.f2230a);
        if (o0Var != null && !o0Var.a()) {
            throw ((x0) o0Var).C();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r3v0, types: [T, X.r] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object k(b3.InterfaceC0379h r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof b3.x
            if (r0 == 0) goto L13
            r0 = r6
            b3.x r0 = (b3.x) r0
            int r1 = r0.f4453d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4453d = r1
            goto L18
        L13:
            b3.x r0 = new b3.x
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f4452c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f4453d
            X.r r3 = c3.m.f4505a
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 != r4) goto L31
            b3.u r5 = r0.f4451b
            kotlin.jvm.internal.Ref$ObjectRef r0 = r0.f4450a
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: c3.C0394a -> L2f
            goto L5f
        L2f:
            r6 = move-exception
            goto L5b
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            r6.element = r3
            b3.u r2 = new b3.u
            r2.<init>(r6)
            r0.f4450a = r6     // Catch: c3.C0394a -> L57
            r0.f4451b = r2     // Catch: c3.C0394a -> L57
            r0.f4453d = r4     // Catch: c3.C0394a -> L57
            java.lang.Object r5 = r5.collect(r2, r0)     // Catch: c3.C0394a -> L57
            if (r5 != r1) goto L55
            goto L63
        L55:
            r0 = r6
            goto L5f
        L57:
            r5 = move-exception
            r0 = r6
            r6 = r5
            r5 = r2
        L5b:
            b3.i r1 = r6.f4470a
            if (r1 != r5) goto L6c
        L5f:
            T r1 = r0.element
            if (r1 == r3) goto L64
        L63:
            return r1
        L64:
            java.util.NoSuchElementException r5 = new java.util.NoSuchElementException
            java.lang.String r6 = "Expected at least one element"
            r5.<init>(r6)
            throw r5
        L6c:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: Z2.I.k(b3.h, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r3v0, types: [T, X.r] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object l(b3.InterfaceC0379h r5, kotlin.jvm.functions.Function2 r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof b3.y
            if (r0 == 0) goto L13
            r0 = r7
            b3.y r0 = (b3.y) r0
            int r1 = r0.f4458e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4458e = r1
            goto L18
        L13:
            b3.y r0 = new b3.y
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f4457d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f4458e
            X.r r3 = c3.m.f4505a
            r4 = 1
            if (r2 == 0) goto L3b
            if (r2 != r4) goto L33
            b3.w r5 = r0.f4456c
            kotlin.jvm.internal.Ref$ObjectRef r6 = r0.f4455b
            kotlin.jvm.functions.Function2 r0 = r0.f4454a
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: c3.C0394a -> L31
            goto L65
        L31:
            r7 = move-exception
            goto L61
        L33:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3b:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            r7.element = r3
            b3.w r2 = new b3.w
            r2.<init>(r6, r7)
            r0.f4454a = r6     // Catch: c3.C0394a -> L5c
            r0.f4455b = r7     // Catch: c3.C0394a -> L5c
            r0.f4456c = r2     // Catch: c3.C0394a -> L5c
            r0.f4458e = r4     // Catch: c3.C0394a -> L5c
            java.lang.Object r5 = r5.collect(r2, r0)     // Catch: c3.C0394a -> L5c
            if (r5 != r1) goto L59
            goto L69
        L59:
            r0 = r6
            r6 = r7
            goto L65
        L5c:
            r5 = move-exception
            r0 = r6
            r6 = r7
            r7 = r5
            r5 = r2
        L61:
            b3.i r1 = r7.f4470a
            if (r1 != r5) goto L7e
        L65:
            T r1 = r6.element
            if (r1 == r3) goto L6a
        L69:
            return r1
        L6a:
            java.util.NoSuchElementException r5 = new java.util.NoSuchElementException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Expected at least one element matching the predicate "
            r6.<init>(r7)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L7e:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: Z2.I.l(b3.h, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static int m(Context context, int i4, int i5) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i4, typedValue, true);
        return typedValue.resourceId != 0 ? i4 : i5;
    }

    public static final int n(Cursor c4, String name) {
        String strJoinToString$default;
        Intrinsics.checkNotNullParameter(c4, "c");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(c4, "c");
        Intrinsics.checkNotNullParameter(name, "name");
        int columnIndex = c4.getColumnIndex(name);
        if (columnIndex < 0) {
            columnIndex = c4.getColumnIndex("`" + name + '`');
            if (columnIndex < 0) {
                columnIndex = -1;
            }
        }
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            String[] columnNames = c4.getColumnNames();
            Intrinsics.checkNotNullExpressionValue(columnNames, "c.columnNames");
            strJoinToString$default = ArraysKt___ArraysKt.joinToString$default(columnNames, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
        } catch (Exception e4) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e4);
            strJoinToString$default = "unknown";
        }
        throw new IllegalArgumentException("column '" + name + "' does not exist. Available columns: " + strJoinToString$default);
    }

    public static Drawable o(Context context, int i4) {
        return N0.c().e(context, i4);
    }

    public static final String p(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static C.d q(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i4) {
        C.d dVarA;
        if (u(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i4, typedValue);
            int i5 = typedValue.type;
            if (i5 >= 28 && i5 <= 31) {
                return new C.d(null, null, typedValue.data);
            }
            try {
                dVarA = C.d.a(typedArray.getResources(), typedArray.getResourceId(i4, 0), theme);
            } catch (Exception e4) {
                Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e4);
                dVarA = null;
            }
            if (dVarA != null) {
                return dVarA;
            }
        }
        return new C.d(null, null, 0);
    }

    public static final d3.v r(Object obj) {
        if (obj == AbstractC0542d.f12448a) {
            throw new IllegalStateException("Does not contain segment".toString());
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (d3.v) obj;
    }

    public static String s(TypedArray typedArray, int i4, int i5) {
        String string = typedArray.getString(i4);
        return string == null ? typedArray.getString(i5) : string;
    }

    public static final F t(androidx.lifecycle.n0 n0Var) {
        F f4 = (F) n0Var.getTag("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY");
        if (f4 != null) {
            return f4;
        }
        E0 e0B = b();
        f3.d dVar = Q.f2189a;
        return (F) n0Var.setTagIfAbsent("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY", new C0311h(CoroutineContext.Element.DefaultImpls.plus(e0B, d3.q.f12477a.getImmediate())));
    }

    public static boolean u(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static boolean v() {
        try {
            return Class.forName("android.os.Looper").getDeclaredMethod("getMainLooper", new Class[0]).invoke(null, new Object[0]) != null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    public static final boolean w(Object obj) {
        return obj == AbstractC0542d.f12448a;
    }

    public static boolean x() {
        try {
            if (f2169b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        try {
            if (f2169b == null) {
                f2168a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f2169b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f2169b.invoke(null, Long.valueOf(f2168a))).booleanValue();
        } catch (Exception e4) {
            if (!(e4 instanceof InvocationTargetException)) {
                Log.v("Trace", "Unable to call isTagEnabled via reflection", e4);
                return false;
            }
            Throwable cause = e4.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
    }

    public static final boolean y(C0694i c0694i) {
        Intrinsics.checkNotNullParameter(c0694i, "<this>");
        try {
            C0694i c0694i2 = new C0694i();
            c0694i.e(0L, c0694i2, RangesKt.coerceAtMost(c0694i.f13357b, 64L));
            int i4 = 0;
            while (i4 < 16) {
                i4++;
                if (c0694i2.s()) {
                    return true;
                }
                int iP = c0694i2.P();
                if (Character.isISOControl(iP) && !Character.isWhitespace(iP)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static TypedArray z(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
