package b7;

import android.util.Log;
import com.stepos.core.model.manifest.ModelManifest;
import com.stepos.core.ota.crypto.AtRestSealer;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.collections.EmptyList;
import kotlin.io.FileWalkDirection;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final Set<String> f3105a = mb.l.s0(new String[]{AtRestSealer.MODEL_MANIFEST, "model_perf.json", AtRestSealer.DEK_WRAP, "bundle_config.json"});

    /* renamed from: b, reason: collision with root package name */
    public static final List<String> f3106b = mb.m.b0(".json", ".zip", ".log", ".txt", ".model");

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t8, T t10) {
            return ob.b.a(((File) t8).getName(), ((File) t10).getName());
        }
    }

    public static final File a(k kVar, String name) {
        kotlin.jvm.internal.g.f(kVar, "<this>");
        kotlin.jvm.internal.g.f(name, "name");
        File file = new File(f(kVar, b(kVar), "config", "configs"), name);
        if (file.isFile()) {
            return file;
        }
        return null;
    }

    public static final JSONObject b(k kVar) {
        Object objA;
        File parentFile;
        kotlin.jvm.internal.g.f(kVar, "<this>");
        File file = new File(kVar.f3091b);
        if (!file.isDirectory() && (parentFile = file.getParentFile()) != null) {
            file = parentFile;
        }
        File file2 = new File(file, AtRestSealer.MODEL_MANIFEST);
        if (!file2.isFile()) {
            return null;
        }
        try {
            objA = new JSONObject(wb.d.Z(file2, gc.a.f9106b));
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            a0.a.w("manifest parse failed: ", file2.getAbsolutePath(), ": ", thB.getMessage(), "ModelConfigPaths");
            return null;
        }
        JSONObject jSONObject = (JSONObject) objA;
        String strOptString = jSONObject.optString("schemaVersion", "");
        kotlin.jvm.internal.g.c(strOptString);
        Integer numC0 = gc.n.c0(gc.q.J0(strOptString, '.'));
        if (numC0 == null || numC0.intValue() <= 2) {
            return jSONObject;
        }
        String str = kVar.f3090a;
        String absolutePath = file2.getAbsolutePath();
        StringBuilder sbS = ai.onnxruntime.a.s("model_manifest.json schemaVersion=", strOptString, " 不受支持（本端最高支持 2.x），modelId=", str, " path=");
        sbS.append(absolutePath);
        throw new IllegalStateException(sbS.toString());
    }

    public static final List<File> c(File file) {
        kotlin.jvm.internal.g.f(file, "<this>");
        Set setS0 = mb.l.s0(new String[]{"gguf", ModelManifest.BACKEND_MNN, "bin", "onnx", "dlc", "tflite", "pt", "pth", "safetensors", "weights"});
        wb.c cVarB0 = wb.d.b0(file);
        return fc.p.A(new fc.f(new wb.c(cVarB0.f13655a, FileWalkDirection.f10069a, new b6.i(1)), new l(setS0, 0)));
    }

    public static final File d(k kVar) {
        kotlin.jvm.internal.g.f(kVar, "<this>");
        return f(kVar, b(kVar), ModelManifest.TYPE_MODEL, "models");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.io.File e(b7.k r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.g.f(r10, r0)
            java.lang.String r0 = r10.f3090a
            java.io.File r1 = d(r10)
            java.util.List r2 = h(r1)
            int r3 = r2.size()
            r4 = 1
            if (r3 != r4) goto L47
            java.lang.Object r2 = kotlin.collections.a.t0(r2)
            java.io.File r2 = (java.io.File) r2
            java.lang.String r3 = r2.getAbsolutePath()
            java.lang.String r1 = r1.getName()
            org.json.JSONObject r10 = b(r10)
            if (r10 == 0) goto L2d
            java.lang.String r10 = "有"
            goto L2f
        L2d:
            java.lang.String r10 = "无→退化包根"
        L2f:
            java.lang.String r4 = " -> "
            java.lang.String r5 = " (modelsDir="
            java.lang.String r6 = "soleModelFile: "
            java.lang.StringBuilder r0 = ai.onnxruntime.a.s(r6, r0, r4, r3, r5)
            java.lang.String r3 = ", manifest="
            java.lang.String r4 = ")"
            java.lang.String r10 = com.stepos.core.ota.d.j(r0, r1, r3, r10, r4)
            java.lang.String r0 = "ModelConfigPaths"
            android.util.Log.i(r0, r10)
            return r2
        L47:
            java.io.File[] r10 = r1.listFiles()
            if (r10 == 0) goto L69
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = r10.length
            r3.<init>(r4)
            int r4 = r10.length
            r5 = 0
        L55:
            if (r5 >= r4) goto L63
            r6 = r10[r5]
            java.lang.String r6 = r6.getName()
            r3.add(r6)
            int r5 = r5 + 1
            goto L55
        L63:
            java.util.List r10 = kotlin.collections.a.H0(r3)
            if (r10 != 0) goto L6b
        L69:
            kotlin.collections.EmptyList r10 = kotlin.collections.EmptyList.f10001a
        L6b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r1 = r1.getAbsolutePath()
            int r9 = r2.size()
            b6.i r6 = new b6.i
            r3 = 2
            r6.<init>(r3)
            r7 = 31
            r3 = 0
            r4 = 0
            r5 = 0
            java.lang.String r2 = kotlin.collections.a.z0(r2, r3, r4, r5, r6, r7)
            java.lang.String r3 = " 下恰好 1 个权重文件，实得 "
            java.lang.String r4 = " 个（"
            java.lang.String r5 = "期望 "
            java.lang.StringBuilder r1 = h0.e.f(r5, r1, r3, r9, r4)
            r1.append(r2)
            java.lang.String r2 = "）；该目录实有："
            r1.append(r2)
            r1.append(r10)
            java.lang.String r10 = "；modelId="
            r1.append(r10)
            r1.append(r0)
            java.lang.String r10 = r1.toString()
            r8.<init>(r10)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: b7.m.e(b7.k):java.io.File");
    }

    public static final File f(k kVar, JSONObject jSONObject, String str, String str2) {
        File parentFile;
        kotlin.jvm.internal.g.f(kVar, "<this>");
        File file = new File(kVar.f3091b);
        if (!file.isDirectory() && (parentFile = file.getParentFile()) != null) {
            file = parentFile;
        }
        if (jSONObject == null) {
            return file;
        }
        String strOptString = jSONObject.optString(str, "");
        kotlin.jvm.internal.g.e(strOptString, "optString(...)");
        String strM0 = gc.q.M0(gc.q.L0(strOptString).toString(), '/');
        if (strM0.length() != 0) {
            str2 = strM0;
        }
        return new File(file, str2);
    }

    public static final File g(k kVar, String str, String str2) {
        kotlin.jvm.internal.g.f(kVar, "<this>");
        String str3 = kVar.f3090a;
        List<File> listH = h(d(kVar));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listH) {
            String name = ((File) obj).getName();
            kotlin.jvm.internal.g.e(name, "getName(...)");
            if (gc.q.l0(name, str, true)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            if (arrayList.size() > 1) {
                ArrayList arrayList2 = new ArrayList(mb.m.Z(arrayList, 10));
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj2 = arrayList.get(i10);
                    i10++;
                    arrayList2.add(((File) obj2).getName());
                }
                StringBuilder sbS = ai.onnxruntime.a.s("weightContaining: ", str3, " 的 ", str2, "（\"");
                sbS.append(str);
                sbS.append("\"）命中多个 ");
                sbS.append(arrayList2);
                sbS.append("，取第一个；打包侧应保证一个角色一个文件");
                Log.w("ModelConfigPaths", sbS.toString());
            }
            return (File) kotlin.collections.a.t0(arrayList);
        }
        String absolutePath = d(kVar).getAbsolutePath();
        ArrayList arrayList3 = new ArrayList(mb.m.Z(listH, 10));
        Iterator<T> it = listH.iterator();
        while (it.hasNext()) {
            arrayList3.add(((File) it.next()).getName());
        }
        String str4 = b(kVar) != null ? "有" : "无→退化包根";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str3);
        sb2.append(": 找不到 ");
        sb2.append(str2);
        sb2.append(" 权重（需含 \"");
        sb2.append(str);
        sb2.append("\"）；");
        sb2.append(absolutePath);
        sb2.append(" 实有：");
        sb2.append(arrayList3);
        throw new IllegalStateException(ai.onnxruntime.a.p(sb2, "（manifest=", str4, "）"));
    }

    public static final List<File> h(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return EmptyList.f10001a;
        }
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (File file2 : fileArrListFiles) {
            if (file2.isFile()) {
                arrayList.add(file2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            String name = ((File) obj).getName();
            kotlin.jvm.internal.g.e(name, "getName(...)");
            if (!gc.o.k0(name, ".", false)) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        int size2 = arrayList2.size();
        int i12 = 0;
        while (i12 < size2) {
            Object obj2 = arrayList2.get(i12);
            i12++;
            if (!f3105a.contains(((File) obj2).getName())) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        int size3 = arrayList3.size();
        while (i10 < size3) {
            Object obj3 = arrayList3.get(i10);
            i10++;
            File file3 = (File) obj3;
            List<String> list = f3106b;
            if (list == null || !list.isEmpty()) {
                for (String str : list) {
                    String name2 = file3.getName();
                    kotlin.jvm.internal.g.e(name2, "getName(...)");
                    if (gc.o.e0(name2, str, true)) {
                        break;
                    }
                }
            }
            arrayList4.add(obj3);
        }
        return kotlin.collections.a.I0(arrayList4, new a());
    }
}
