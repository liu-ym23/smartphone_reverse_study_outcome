package jd;

import android.content.ComponentName;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.datastore.preferences.protobuf.b1;
import androidx.lifecycle.q0;
import com.github.houbb.heaven.response.exception.CommonRuntimeException;
import com.stepos.ability.bean.GuiAgentConfig;
import com.stepos.ability.bean.OriginalTaskConfig;
import com.stepos.ability.bean.TaskConfig;
import com.stepos.ability.bean.TaskUiInfo;
import com.stepos.core.ability.speech.AsrCloudConfig;
import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.ability.speech.VadRuntimeConfig;
import com.stepos.core.common.cloud.FileStorageUploader;
import com.stepos.core.ota.d;
import com.stepos.deepbinder.annotation.type.SameProcess;
import com.stepos.deepbinder.annotation.type.ServiceName;
import com.stepos.deepbinder.annotation.type.ValidityCheck;
import com.stepos.deepbinder.core.exception.IPCException;
import gc.o;
import gc.q;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import kotlin.Pair;
import kotlin.c;
import kotlin.collections.EmptyList;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import l5.i;
import lb.n;
import mb.m;
import mb.y;
import org.slf4j.ILoggerFactory;
import org.slf4j.helpers.NOPLogger;
import r3.a;
import sd.c0;
import sd.d0;
import sd.e;
import sd.f0;
import sd.v;
import tc.x0;
import uc.f;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class b implements ILoggerFactory {

    /* renamed from: a, reason: collision with root package name */
    public static volatile d f9768a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile FileStorageUploader f9769b;

    public static boolean A(Context context) {
        try {
            String strV = y.v("persist.stepos.usagestats.debug", "");
            if (strV == null) {
                return false;
            }
            if (strV.equals("all")) {
                return true;
            }
            return strV.equals(context.getPackageName());
        } catch (Exception e10) {
            Log.e("CommonUtils", "isDebugMode error " + e10.getMessage());
            return false;
        }
    }

    public static final boolean B(e eVar) {
        e eVar2;
        int i10;
        g.f(eVar, "<this>");
        try {
            eVar2 = new e();
            long j10 = eVar.f11926b;
            long j11 = 64;
            if (j10 <= 64) {
                j11 = j10;
            }
            eVar.P(eVar2, 0L, j11);
        } catch (EOFException unused) {
        }
        for (i10 = 0; i10 < 16; i10++) {
            if (eVar2.f0()) {
                return true;
            }
            int iK0 = eVar2.K0();
            if (Character.isISOControl(iK0) && !Character.isWhitespace(iK0)) {
                return false;
            }
        }
        return true;
    }

    public static int C(float f8, int i10, int i11) {
        return n0.a.b(n0.a.d(i11, Math.round(Color.alpha(i11) * f8)), i10);
    }

    public static final int D(int i10, String str) {
        char cCharAt = str.charAt(i10);
        return (cCharAt << 7) + str.charAt(i10 + 1);
    }

    public static final byte[] E(InputStream inputStream) throws IOException {
        g.f(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(PcmDumpBudget.HARD_MAX_DIR_MB, inputStream.available()));
        n(inputStream, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        g.e(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public static final String F(Reader reader) throws IOException {
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[PcmDumpBudget.HARD_MAX_DIR_MB];
        int i10 = reader.read(cArr);
        while (i10 >= 0) {
            stringWriter.write(cArr, 0, i10);
            i10 = reader.read(cArr);
        }
        String string = stringWriter.toString();
        g.e(string, "toString(...)");
        return string;
    }

    public static int G(int i10) {
        char c9;
        char[] cArr = i.f10272a;
        if (i10 < cArr.length && (c9 = cArr[i10]) != 0) {
            return c9;
        }
        int lowerCase = Character.toLowerCase(i10);
        return lowerCase != i10 ? lowerCase : Character.toUpperCase(i10);
    }

    public static Object H(Class cls) throws IllegalAccessException, InstantiationException {
        r3.a aVar = a.C0130a.f11727a;
        aVar.getClass();
        ConcurrentHashMap concurrentHashMap = aVar.f11726a;
        String name = cls.getName();
        Object obj = concurrentHashMap.get(name);
        if (obj != null) {
            return obj;
        }
        try {
            Object objNewInstance = cls.newInstance();
            concurrentHashMap.put(name, objNewInstance);
            return objNewInstance;
        } catch (IllegalAccessException | InstantiationException e10) {
            throw new CommonRuntimeException(e10);
        }
    }

    public static final sd.c I(Socket socket) throws IOException {
        Logger logger = v.f11978a;
        d0 d0Var = new d0(socket);
        OutputStream outputStream = socket.getOutputStream();
        g.e(outputStream, "getOutputStream(...)");
        return new sd.c(d0Var, new sd.c(outputStream, d0Var));
    }

    public static final sd.d J(InputStream inputStream) {
        Logger logger = v.f11978a;
        return new sd.d(inputStream, new f0());
    }

    public static final sd.d K(Socket socket) throws IOException {
        Logger logger = v.f11978a;
        d0 d0Var = new d0(socket);
        InputStream inputStream = socket.getInputStream();
        g.e(inputStream, "getInputStream(...)");
        return new sd.d(d0Var, new sd.d(inputStream, d0Var));
    }

    public static final wb.b L(File file) {
        int length;
        List list;
        int iQ0;
        g.f(file, "<this>");
        String path = file.getPath();
        g.c(path);
        char c9 = File.separatorChar;
        int iQ02 = q.q0(path, c9, 0, 4);
        if (iQ02 != 0) {
            length = (iQ02 <= 0 || path.charAt(iQ02 + (-1)) != ':') ? (iQ02 == -1 && path.length() > 0 && b1.E(path.charAt(q.n0(path)), ':', false)) ? path.length() : 0 : iQ02 + 1;
        } else if (path.length() <= 1 || path.charAt(1) != c9 || (iQ0 = q.q0(path, c9, 2, 4)) < 0) {
            length = 1;
        } else {
            int iQ03 = q.q0(path, c9, iQ0 + 1, 4);
            length = iQ03 >= 0 ? iQ03 + 1 : path.length();
        }
        String strSubstring = path.substring(0, length);
        g.e(strSubstring, "substring(...)");
        String strSubstring2 = path.substring(length);
        g.e(strSubstring2, "substring(...)");
        if (strSubstring2.length() == 0) {
            list = EmptyList.f10001a;
        } else {
            List listE0 = q.E0(strSubstring2, new char[]{c9});
            ArrayList arrayList = new ArrayList(m.Z(listE0, 10));
            Iterator it = listE0.iterator();
            while (it.hasNext()) {
                arrayList.add(new File((String) it.next()));
            }
            list = arrayList;
        }
        return new wb.b(new File(strSubstring), list);
    }

    public static final String M(String str) {
        g.f(str, "<this>");
        if (o.k0(str, "/", false)) {
            return str;
        }
        Context context = l7.a.f10344a;
        if (context == null) {
            throw new IllegalStateException("ContextHolder must be initialized before use!");
        }
        String absolutePath = new File(context.getFilesDir(), "models/".concat(str)).getAbsolutePath();
        g.e(absolutePath, "getAbsolutePath(...)");
        return absolutePath;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final com.stepos.ability.bean.Task N(com.stepos.ability.bean.OriginalTaskConfig r29) {
        /*
            java.lang.String r1 = r29.getTaskId()
            java.lang.String r11 = r29.getParentTaskId()
            java.lang.String r3 = r29.getName()
            java.lang.String r0 = r29.getStatus()
            int r2 = r0.hashCode()
            switch(r2) {
                case -1402931637: goto L48;
                case -1367724422: goto L3c;
                case -1281977283: goto L30;
                case -682587753: goto L24;
                case 1550783935: goto L18;
                default: goto L17;
            }
        L17:
            goto L50
        L18:
            java.lang.String r2 = "running"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L21
            goto L50
        L21:
            com.stepos.ability.common.TaskStatus r0 = com.stepos.ability.common.TaskStatus.f5559c
            goto L55
        L24:
            java.lang.String r2 = "pending"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L2d
            goto L50
        L2d:
            com.stepos.ability.common.TaskStatus r0 = com.stepos.ability.common.TaskStatus.f5558b
            goto L55
        L30:
            java.lang.String r2 = "failed"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L39
            goto L50
        L39:
            com.stepos.ability.common.TaskStatus r0 = com.stepos.ability.common.TaskStatus.f5561e
            goto L55
        L3c:
            java.lang.String r2 = "cancel"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L45
            goto L50
        L45:
            com.stepos.ability.common.TaskStatus r0 = com.stepos.ability.common.TaskStatus.h
            goto L55
        L48:
            java.lang.String r2 = "completed"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L53
        L50:
            com.stepos.ability.common.TaskStatus r0 = com.stepos.ability.common.TaskStatus.f5559c
            goto L55
        L53:
            com.stepos.ability.common.TaskStatus r0 = com.stepos.ability.common.TaskStatus.f5560d
        L55:
            int r9 = r0.f5564a
            java.lang.String r4 = r29.getCoverUrl()
            java.lang.String r5 = r29.getDescription()
            com.stepos.ability.bean.AppUI r18 = new com.stepos.ability.bean.AppUI
            java.lang.String r21 = r29.getResultType()
            java.lang.String r22 = r29.getResultSrc()
            java.lang.String r23 = r29.getResultContent()
            r27 = 14591(0x38ff, float:2.0446E-41)
            r28 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r12 = r18
            r18 = 0
            r19 = 0
            r20 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            com.stepos.ability.bean.Task r0 = new com.stepos.ability.bean.Task
            r23 = 506466(0x7ba62, float:7.0971E-40)
            r2 = 0
            r6 = 0
            r7 = 0
            r8 = -1
            r10 = 0
            r18 = r12
            r12 = 0
            r14 = 0
            r16 = 0
            r21 = 0
            r22 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r16, r18, r19, r20, r21, r22, r23, r24)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jd.b.N(com.stepos.ability.bean.OriginalTaskConfig):com.stepos.ability.bean.Task");
    }

    public static final TaskConfig O(OriginalTaskConfig originalTaskConfig, Context context, Bundle bundle) {
        g.f(context, "context");
        String taskId = originalTaskConfig.getTaskId();
        String taskId2 = originalTaskConfig.getTaskId();
        String parentTaskId = originalTaskConfig.getParentTaskId();
        boolean zB = g.b(originalTaskConfig.getToolName(), "gui_agent");
        String toolName = originalTaskConfig.getToolName();
        String toolParams = originalTaskConfig.getToolParams();
        String name = originalTaskConfig.getName();
        String description = originalTaskConfig.getDescription();
        int i10 = 2;
        String str = null;
        Long l10 = null;
        GuiAgentConfig guiAgentConfig = null;
        int i11 = 0;
        return new TaskConfig(taskId, taskId2, parentTaskId, zB ? 1 : 0, i10, str, l10, toolName, new TaskUiInfo(name, originalTaskConfig.getCoverUrl(), description), guiAgentConfig, toolParams, bundle, context.getPackageName(), i11, 8768, null);
    }

    public static String P(Class serviceInterface, String str) {
        g.f(serviceInterface, "serviceInterface");
        if (!serviceInterface.isInterface()) {
            throw new IPCException(20, a0.a.k("The parameter ", serviceInterface.getName(), " is not an interface, only interfaces can be passed as parameters, please check."));
        }
        if (serviceInterface.getAnnotation(ValidityCheck.class) == null && serviceInterface.getAnnotation(SameProcess.class) == null) {
            throw new IPCException(20, a0.a.k("The interface: ", serviceInterface.getName(), " must have @ValidityCheck annotation during cross-process calls."));
        }
        if (!TextUtils.isEmpty(str)) {
            g.c(str);
            return str;
        }
        ServiceName serviceName = (ServiceName) serviceInterface.getAnnotation(ServiceName.class);
        if (serviceName == null || TextUtils.isEmpty(serviceName.value())) {
            throw new IPCException(20, "The interface must have @ServiceName annotation.");
        }
        return serviceName.value();
    }

    public static void Q(ComponentName componentName) {
        if (componentName == null || TextUtils.isEmpty(componentName.getClassName()) || TextUtils.isEmpty(componentName.getPackageName())) {
            throw new IPCException(27, "The component name or its contained info is null, please check!");
        }
    }

    public static Object R(p pVar, Object obj, qb.b completion) {
        g.f(pVar, "<this>");
        g.f(completion, "completion");
        kotlin.coroutines.d context = completion.getContext();
        rb.b intrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1 = context == EmptyCoroutineContext.f10057a ? new IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1(completion) : new IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2(completion, context);
        k.c(2, pVar);
        return pVar.invoke(obj, intrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1);
    }

    public static final void b(sc.e eVar) {
        g.f(eVar, "<this>");
        if ((eVar instanceof uc.k ? (uc.k) eVar : null) != null) {
            return;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got " + kotlin.jvm.internal.i.a(eVar.getClass()));
    }

    public static void c(Throwable th, Throwable exception) {
        g.f(th, "<this>");
        g.f(exception, "exception");
        if (th != exception) {
            tb.b.f12958a.a(th, exception);
        }
    }

    public static final f d(sc.d dVar) {
        g.f(dVar, "<this>");
        f fVar = dVar instanceof f ? (f) dVar : null;
        if (fVar != null) {
            return fVar;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got " + kotlin.jvm.internal.i.a(dVar.getClass()));
    }

    public static String e(String name) {
        g.f(name, "name");
        switch (name.hashCode()) {
            case -2056817302:
                return name.equals("java.lang.Integer") ? "int" : name;
            case -527879800:
                return !name.equals("java.lang.Float") ? name : "float";
            case -515992664:
                return !name.equals("java.lang.Short") ? name : "short";
            case 155276373:
                return !name.equals("java.lang.Character") ? name : "char";
            case 344809556:
                return !name.equals("java.lang.Boolean") ? name : VadRuntimeConfig.LEGAL_BOOL;
            case 398507100:
                return !name.equals("java.lang.Byte") ? name : "byte";
            case 398795216:
                return !name.equals("java.lang.Long") ? name : "long";
            case 761287205:
                return !name.equals("java.lang.Double") ? name : "double";
            default:
                return name;
        }
    }

    public static final Boolean f(boolean z) {
        return Boolean.valueOf(z);
    }

    public static final Integer g(int i10) {
        return new Integer(i10);
    }

    public static final Long h(long j10) {
        return new Long(j10);
    }

    public static final sd.y i(c0 c0Var) {
        g.f(c0Var, "<this>");
        return new sd.y(c0Var);
    }

    public static final void j(int i10, int i11) {
        if (i10 < 0 || i10 >= i11) {
            throw new IndexOutOfBoundsException(a0.a.f("index: ", i10, i11, ", size: "));
        }
    }

    public static final void k(int i10, int i11) {
        if (i10 < 0 || i10 > i11) {
            throw new IndexOutOfBoundsException(a0.a.f("index: ", i10, i11, ", size: "));
        }
    }

    public static final void l(int i10, int i11, int i12) {
        if (i10 < 0 || i11 > i12) {
            StringBuilder sbD = h0.e.d(i10, "fromIndex: ", i11, ", toIndex: ", ", size: ");
            sbD.append(i12);
            throw new IndexOutOfBoundsException(sbD.toString());
        }
        if (i10 > i11) {
            throw new IllegalArgumentException(a0.a.f("fromIndex: ", i10, i11, " > toIndex: "));
        }
    }

    public static void m(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                Log.e("CommonUtils", "closeQuietly error " + e10.getMessage());
            }
        }
    }

    public static final long n(InputStream inputStream, OutputStream outputStream) throws IOException {
        g.f(inputStream, "<this>");
        byte[] bArr = new byte[PcmDumpBudget.HARD_MAX_DIR_MB];
        int i10 = inputStream.read(bArr);
        long j10 = 0;
        while (i10 >= 0) {
            outputStream.write(bArr, 0, i10);
            j10 += i10;
            i10 = inputStream.read(bArr);
        }
        return j10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static qb.b o(final p pVar, final Object obj, final qb.b completion) {
        g.f(pVar, "<this>");
        g.f(completion, "completion");
        if (pVar instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) pVar).create(obj, completion);
        }
        final kotlin.coroutines.d context = completion.getContext();
        return context == EmptyCoroutineContext.f10057a ? new RestrictedContinuationImpl(obj, completion) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3

            /* renamed from: a, reason: collision with root package name */
            public int f10061a;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Object f10063c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(completion);
                g.d(completion, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj2) {
                int i10 = this.f10061a;
                if (i10 != 0) {
                    if (i10 != 1) {
                        throw new IllegalStateException("This coroutine had already completed");
                    }
                    this.f10061a = 2;
                    c.b(obj2);
                    return obj2;
                }
                this.f10061a = 1;
                c.b(obj2);
                p pVar2 = this.f10062b;
                g.d(pVar2, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                k.c(2, pVar2);
                return pVar2.invoke(this.f10063c, this);
            }
        } : new ContinuationImpl(completion, context, pVar, obj) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4

            /* renamed from: a, reason: collision with root package name */
            public int f10064a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ p f10065b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Object f10066c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(completion, context);
                this.f10065b = pVar;
                this.f10066c = obj;
                g.d(completion, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj2) {
                int i10 = this.f10064a;
                if (i10 != 0) {
                    if (i10 != 1) {
                        throw new IllegalStateException("This coroutine had already completed");
                    }
                    this.f10064a = 2;
                    c.b(obj2);
                    return obj2;
                }
                this.f10064a = 1;
                c.b(obj2);
                p pVar2 = this.f10065b;
                g.d(pVar2, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                k.c(2, pVar2);
                return pVar2.invoke(this.f10066c, this);
            }
        };
    }

    public static q0 p(Class cls) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(null);
            if (!Modifier.isPublic(declaredConstructor.getModifiers())) {
                throw new RuntimeException("Cannot create an instance of " + cls);
            }
            try {
                Object objNewInstance = declaredConstructor.newInstance(null);
                g.c(objNewInstance);
                return (q0) objNewInstance;
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("Cannot create an instance of " + cls, e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("Cannot create an instance of " + cls, e11);
            }
        } catch (NoSuchMethodException e12) {
            throw new RuntimeException("Cannot create an instance of " + cls, e12);
        }
    }

    public static final pc.c q(tc.b bVar, vc.k kVar, Object value) {
        g.f(bVar, "<this>");
        g.f(value, "value");
        bVar.getClass();
        g.f(value, "value");
        kVar.s().e(null, value);
        throw null;
    }

    public static final ec.c r(rc.e eVar) {
        g.f(eVar, "<this>");
        if (eVar instanceof rc.b) {
            return null;
        }
        if (eVar instanceof x0) {
            return r(((x0) eVar).f13065a);
        }
        return null;
    }

    public static int s(int i10, View view) {
        Context context = view.getContext();
        TypedValue typedValueC = w4.b.c(view.getContext(), view.getClass().getCanonicalName(), i10);
        int i11 = typedValueC.resourceId;
        return i11 != 0 ? context.getColor(i11) : typedValueC.data;
    }

    public static Integer t(int i10, Context context) {
        TypedValue typedValueA = w4.b.a(i10, context);
        if (typedValueA == null) {
            return null;
        }
        int i11 = typedValueA.resourceId;
        return Integer.valueOf(i11 != 0 ? context.getColor(i11) : typedValueA.data);
    }

    public static final Pair u(Context context, String uriOrPath) throws IOException {
        g.f(context, "context");
        g.f(uriOrPath, "uriOrPath");
        String strF = d.f(System.currentTimeMillis(), "file_");
        try {
            Uri uri = Uri.parse(uriOrPath);
            Log.i("FineNameUtil", "getFileNameAndSuffixFromUri. uriOrPath=".concat(uriOrPath));
            String scheme = uri.getScheme();
            if (scheme != null) {
                int iHashCode = scheme.hashCode();
                if (iHashCode != 3143036) {
                    if (iHashCode == 951530617 && scheme.equals("content")) {
                        Log.i("FineNameUtil", "By content");
                        Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
                        if (cursorQuery != null) {
                            try {
                                if (cursorQuery.moveToFirst()) {
                                    String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                                    if (string == null) {
                                        string = strF;
                                    }
                                    Pair pair = new Pair(string, q.l0(string, ".", false) ? q.I0(string) : "dat");
                                    cursorQuery.close();
                                    return pair;
                                }
                                n nVar = n.f10413a;
                                cursorQuery.close();
                            } finally {
                            }
                        }
                    }
                } else if (scheme.equals(AsrCloudConfig.SCENE_MODE_FILE)) {
                    Log.i("FineNameUtil", "By file");
                    String path = uri.getPath();
                    if (path != null) {
                        String name = new File(path).getName();
                        g.c(name);
                        return new Pair(name, q.l0(name, ".", false) ? q.I0(name) : "dat");
                    }
                }
            } else {
                Log.i("FineNameUtil", "By File");
                File file = new File(uriOrPath);
                if (file.exists()) {
                    String name2 = file.getName();
                    g.c(name2);
                    return new Pair(name2, q.l0(name2, ".", false) ? q.I0(name2) : "dat");
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return new Pair(strF, "dat");
    }

    public static final int v(int i10, int i11) {
        return (i10 >> i11) & 31;
    }

    public static qb.b w(qb.b bVar) {
        qb.b<Object> bVarIntercepted;
        g.f(bVar, "<this>");
        ContinuationImpl continuationImpl = bVar instanceof ContinuationImpl ? (ContinuationImpl) bVar : null;
        return (continuationImpl == null || (bVarIntercepted = continuationImpl.intercepted()) == null) ? bVar : bVarIntercepted;
    }

    public static boolean x(int[][] iArr, int i10) {
        if (i10 <= 255) {
            int length = iArr.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                int[] iArr2 = iArr[i11];
                if (i10 > iArr2[1]) {
                    i11++;
                } else {
                    int i12 = iArr2[0];
                    if (i10 >= i12 && (i10 - i12) % iArr2[2] == 0) {
                        return true;
                    }
                }
            }
            return false;
        }
        if (iArr.length > 0 && i10 >= iArr[0][0]) {
            int length2 = iArr.length;
            int i13 = 0;
            while (true) {
                if (i13 >= length2) {
                    break;
                }
                int i14 = ((length2 - i13) / 2) + i13;
                int[] iArr3 = iArr[i14];
                int i15 = iArr3[0];
                if (i15 > i10 || i10 > iArr3[1]) {
                    if (i10 < i15) {
                        length2 = i14;
                    } else {
                        i13 = i14 + 1;
                    }
                } else if ((i10 - i15) % iArr3[2] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean y(AssertionError assertionError) {
        Logger logger = v.f11978a;
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null ? q.l0(message, "getsockname failed", false) : false) {
                return true;
            }
        }
        return false;
    }

    public static boolean z(int i10) {
        if (i10 == 0) {
            return false;
        }
        ThreadLocal<double[]> threadLocal = n0.a.f10586a;
        double[] dArr = threadLocal.get();
        if (dArr == null) {
            dArr = new double[3];
            threadLocal.set(dArr);
        }
        int iRed = Color.red(i10);
        int iGreen = Color.green(i10);
        int iBlue = Color.blue(i10);
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d8 = iRed / 255.0d;
        double dPow = d8 < 0.04045d ? d8 / 12.92d : Math.pow((d8 + 0.055d) / 1.055d, 2.4d);
        double d10 = iGreen / 255.0d;
        double dPow2 = d10 < 0.04045d ? d10 / 12.92d : Math.pow((d10 + 0.055d) / 1.055d, 2.4d);
        double d11 = iBlue / 255.0d;
        double dPow3 = d11 < 0.04045d ? d11 / 12.92d : Math.pow((d11 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.1805d * dPow3) + (0.3576d * dPow2) + (0.4124d * dPow)) * 100.0d;
        double d12 = ((0.0722d * dPow3) + (0.7152d * dPow2) + (0.2126d * dPow)) * 100.0d;
        dArr[1] = d12;
        dArr[2] = ((dPow3 * 0.9505d) + (dPow2 * 0.1192d) + (dPow * 0.0193d)) * 100.0d;
        return d12 / 100.0d > 0.5d;
    }

    @Override // org.slf4j.ILoggerFactory
    public ud.a a(String str) {
        return NOPLogger.f11340a;
    }
}
