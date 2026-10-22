package com.stepos.aicgroup.internal.strategy;

import android.util.Log;
import com.stepos.core.ota.d;
import gc.q;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class FileSystemCGroupStrategy implements CGroupStrategy {
    public static final Companion Companion = new Companion(null);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public Companion() {
        }
    }

    public final boolean a(String str, int i10, String str2, String str3) {
        String strI;
        if (str2.length() == 0) {
            strI = d.i(str, "/", str3);
        } else {
            strI = str + "/" + str2 + "/" + str3;
        }
        try {
            File file = new File(strI);
            if (!file.exists() || !file.canWrite()) {
                Log.d("FileSystemCGroupStrategy", "[" + getName() + "] 文件不可写: " + strI);
                return false;
            }
            wb.d.e0(file, String.valueOf(i10));
            Log.d("FileSystemCGroupStrategy", "[" + getName() + "] 成功写入 " + strI);
            return true;
        } catch (Exception e10) {
            String name = getName();
            String message = e10.getMessage();
            StringBuilder sbS = ai.onnxruntime.a.s("[", name, "] 写入 ", strI, " 失败: ");
            sbS.append(message);
            Log.d("FileSystemCGroupStrategy", sbS.toString());
            return false;
        }
    }

    @Override // com.stepos.aicgroup.internal.strategy.CGroupStrategy
    public Map<String, String> getAllCGroups(int i10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            File file = new File("/proc/" + i10 + "/cgroup");
            if (!file.exists()) {
                Log.w("FileSystemCGroupStrategy", "[" + getName() + "] /proc/" + i10 + "/cgroup 不存在");
                return linkedHashMap;
            }
            ArrayList arrayListY = wb.d.Y(file);
            int size = arrayListY.size();
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayListY.get(i11);
                i11++;
                List listD0 = q.D0((String) obj, new String[]{":"}, 6);
                if (listD0.size() >= 3) {
                    List<String> listD02 = q.D0((CharSequence) listD0.get(1), new String[]{","}, 6);
                    String str = (String) listD0.get(2);
                    for (String str2 : listD02) {
                        if (str2.length() > 0) {
                            linkedHashMap.put(str2, str);
                        }
                    }
                }
            }
            Log.d("FileSystemCGroupStrategy", "[" + getName() + "] 获取进程 " + i10 + " 的所有 CGroup: " + linkedHashMap);
            return linkedHashMap;
        } catch (Exception e10) {
            Log.e("FileSystemCGroupStrategy", ai.onnxruntime.a.i("[", i10, getName(), "] 读取进程 ", " 的 CGroup 信息失败"), e10);
            return linkedHashMap;
        }
    }

    @Override // com.stepos.aicgroup.internal.strategy.CGroupStrategy
    public String getCGroup(int i10, String controller) {
        g.f(controller, "controller");
        try {
            File file = new File("/proc/" + i10 + "/cgroup");
            if (!file.exists()) {
                Log.w("FileSystemCGroupStrategy", "[" + getName() + "] /proc/" + i10 + "/cgroup 不存在");
                return null;
            }
            ArrayList arrayListY = wb.d.Y(file);
            int size = arrayListY.size();
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayListY.get(i11);
                i11++;
                List listD0 = q.D0((String) obj, new String[]{":"}, 6);
                if (listD0.size() >= 3) {
                    String str = (String) listD0.get(1);
                    String str2 = (String) listD0.get(2);
                    if (q.l0(str, controller, false)) {
                        Log.d("FileSystemCGroupStrategy", "[" + getName() + "] 获取进程 " + i10 + " 的 " + controller + " CGroup: " + str2);
                        return str2;
                    }
                }
            }
            Log.d("FileSystemCGroupStrategy", "[" + getName() + "] 未找到进程 " + i10 + " 的 " + controller + " CGroup");
            return null;
        } catch (Exception e10) {
            Log.e("FileSystemCGroupStrategy", "[" + getName() + "] 读取 CGroup 失败", e10);
            return null;
        }
    }

    @Override // com.stepos.aicgroup.internal.strategy.CGroupStrategy
    public String getName() {
        return "FileSystem";
    }

    @Override // com.stepos.aicgroup.internal.strategy.CGroupStrategy
    public boolean isAvailable() {
        return new File("/proc/self/cgroup").canRead();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005f  */
    @Override // com.stepos.aicgroup.internal.strategy.CGroupStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean setCGroup(int r10, java.lang.String r11, java.lang.String r12) {
        /*
            r9 = this;
            java.lang.String r0 = "controller"
            kotlin.jvm.internal.g.f(r11, r0)
            java.lang.String r0 = "cgroupPath"
            kotlin.jvm.internal.g.f(r12, r0)
            int r0 = r11.hashCode()
            r1 = -1353647686(0xffffffffaf50f9ba, float:-1.900621E-10)
            if (r0 == r1) goto L4a
            r1 = -1077756671(0xffffffffbfc2bd01, float:-1.521393)
            if (r0 == r1) goto L34
            r1 = 98728(0x181a8, float:1.38347E-40)
            if (r0 == r1) goto L1e
            goto L5f
        L1e:
            java.lang.String r0 = "cpu"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L27
            goto L5f
        L27:
            java.lang.String r0 = "/dev/cpuctl"
            java.lang.String r1 = "/sys/fs/cgroup/cpu"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1}
            java.util.List r0 = mb.m.b0(r0)
            goto L6f
        L34:
            java.lang.String r0 = "memory"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L3d
            goto L5f
        L3d:
            java.lang.String r0 = "/dev/memcg"
            java.lang.String r1 = "/sys/fs/cgroup/memory"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1}
            java.util.List r0 = mb.m.b0(r0)
            goto L6f
        L4a:
            java.lang.String r0 = "cpuset"
            boolean r0 = r11.equals(r0)
            if (r0 == 0) goto L5f
            java.lang.String r0 = "/dev/cpuset"
            java.lang.String r1 = "/sys/fs/cgroup/cpuset"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1}
            java.util.List r0 = mb.m.b0(r0)
            goto L6f
        L5f:
            java.lang.String r0 = "/sys/fs/cgroup/"
            java.lang.String r0 = r0.concat(r11)
            java.lang.String r1 = "/sys/fs/cgroup"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1}
            java.util.List r0 = mb.m.b0(r0)
        L6f:
            java.lang.String r1 = "/"
            java.lang.String r1 = gc.q.z0(r12, r1)
            java.util.Iterator r0 = r0.iterator()
        L79:
            boolean r2 = r0.hasNext()
            java.lang.String r3 = " CGroup: "
            java.lang.String r4 = " 到 "
            java.lang.String r5 = "["
            java.lang.String r6 = "FileSystemCGroupStrategy"
            if (r2 == 0) goto Ld4
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r7 = "tasks"
            boolean r7 = r9.a(r2, r10, r1, r7)
            r8 = 1
            if (r7 == 0) goto Lb1
            java.lang.String r9 = r9.getName()
            java.lang.String r0 = "] 成功设置进程 "
            java.lang.StringBuilder r9 = h0.e.f(r5, r9, r0, r10, r4)
            r9.append(r11)
            r9.append(r3)
            r9.append(r12)
            java.lang.String r9 = r9.toString()
            android.util.Log.d(r6, r9)
            return r8
        Lb1:
            java.lang.String r7 = "cgroup.procs"
            boolean r2 = r9.a(r2, r10, r1, r7)
            if (r2 == 0) goto L79
            java.lang.String r9 = r9.getName()
            java.lang.String r0 = "] 成功通过 cgroup.procs 设置进程 "
            java.lang.StringBuilder r9 = h0.e.f(r5, r9, r0, r10, r4)
            r9.append(r11)
            r9.append(r3)
            r9.append(r12)
            java.lang.String r9 = r9.toString()
            android.util.Log.d(r6, r9)
            return r8
        Ld4:
            java.lang.String r9 = r9.getName()
            java.lang.String r0 = "] 无法设置进程 "
            java.lang.StringBuilder r9 = h0.e.f(r5, r9, r0, r10, r4)
            r9.append(r11)
            r9.append(r3)
            r9.append(r12)
            java.lang.String r9 = r9.toString()
            android.util.Log.w(r6, r9)
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.aicgroup.internal.strategy.FileSystemCGroupStrategy.setCGroup(int, java.lang.String, java.lang.String):boolean");
    }

    @Override // com.stepos.aicgroup.internal.strategy.CGroupStrategy
    public boolean setProcessProfiles(int i10, int i11, List<String> profiles) {
        g.f(profiles, "profiles");
        ai.onnxruntime.a.x("[", getName(), "] 不支持设置进程配置文件", "FileSystemCGroupStrategy");
        return false;
    }

    @Override // com.stepos.aicgroup.internal.strategy.CGroupStrategy
    public boolean setTaskProfiles(int i10, List<String> profiles) {
        g.f(profiles, "profiles");
        ai.onnxruntime.a.x("[", getName(), "] 不支持设置任务配置文件", "FileSystemCGroupStrategy");
        return false;
    }
}
