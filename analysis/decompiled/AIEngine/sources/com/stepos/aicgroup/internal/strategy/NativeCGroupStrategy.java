package com.stepos.aicgroup.internal.strategy;

import android.util.Log;
import com.stepos.aicgroup.internal.ConstantKt;
import gc.q;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import wb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class NativeCGroupStrategy implements CGroupStrategy {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f5746a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public Companion() {
        }
    }

    public NativeCGroupStrategy() {
        try {
            System.loadLibrary(ConstantKt.LIBRARY_NAME_AICGROUP);
            this.f5746a = true;
            Log.i("NativeCGroupStrategy", "Native library loaded successfully");
        } catch (UnsatisfiedLinkError e10) {
            this.f5746a = false;
            a0.a.A("Failed to load native library: ", e10.getMessage(), "NativeCGroupStrategy");
        }
    }

    private final native String nativeGetCGroup(int i10, String str);

    private final native int nativeGetOomScoreAdj(int i10);

    private final native boolean nativeIsPltHookInitialized();

    private final native boolean nativeSetCGroup(int i10, String str, String str2);

    private final native boolean nativeSetProcessProfiles(int i10, int i11, String[] strArr);

    private final native boolean nativeSetTaskProfiles(int i10, String[] strArr);

    @Override // com.stepos.aicgroup.internal.strategy.CGroupStrategy
    public Map<String, String> getAllCGroups(int i10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            File file = new File("/proc/" + i10 + "/cgroup");
            if (file.exists()) {
                ArrayList arrayListY = d.Y(file);
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
            }
            return linkedHashMap;
        } catch (Exception e10) {
            Log.e("NativeCGroupStrategy", ai.onnxruntime.a.i("[", i10, getName(), "] 读取 /proc/", "/cgroup 失败"), e10);
            return linkedHashMap;
        }
    }

    @Override // com.stepos.aicgroup.internal.strategy.CGroupStrategy
    public String getCGroup(int i10, String controller) {
        g.f(controller, "controller");
        if (!this.f5746a) {
            return null;
        }
        try {
            String strNativeGetCGroup = nativeGetCGroup(i10, controller);
            if (strNativeGetCGroup == null) {
                return strNativeGetCGroup;
            }
            Log.d("NativeCGroupStrategy", "[" + getName() + "] 获取进程 " + i10 + " 的 " + controller + " CGroup: " + strNativeGetCGroup);
            return strNativeGetCGroup;
        } catch (Exception e10) {
            Log.e("NativeCGroupStrategy", "[" + getName() + "] 获取 CGroup 失败", e10);
            return null;
        }
    }

    @Override // com.stepos.aicgroup.internal.strategy.CGroupStrategy
    public String getName() {
        return "Native";
    }

    public final Integer getOomScoreAdj(int i10) {
        if (!this.f5746a) {
            return null;
        }
        try {
            int iNativeGetOomScoreAdj = nativeGetOomScoreAdj(i10);
            if (iNativeGetOomScoreAdj == Integer.MIN_VALUE) {
                Log.w("NativeCGroupStrategy", "[" + getName() + "] 读取进程 " + i10 + " 的 oom_score_adj 失败");
                return null;
            }
            Log.d("NativeCGroupStrategy", "[" + getName() + "] 进程 " + i10 + " 的 oom_score_adj: " + iNativeGetOomScoreAdj);
            return Integer.valueOf(iNativeGetOomScoreAdj);
        } catch (Exception e10) {
            Log.e("NativeCGroupStrategy", "[" + getName() + "] 获取 oom_score_adj 异常", e10);
            return null;
        }
    }

    @Override // com.stepos.aicgroup.internal.strategy.CGroupStrategy
    public boolean isAvailable() {
        if (!this.f5746a) {
            return false;
        }
        try {
            return nativeIsPltHookInitialized();
        } catch (Throwable th) {
            Log.w("NativeCGroupStrategy", "[" + this.getName() + "] nativeIsPltHookInitialized threw, treat as unavailable", th);
            return false;
        }
    }

    @Override // com.stepos.aicgroup.internal.strategy.CGroupStrategy
    public boolean setCGroup(int i10, String controller, String cgroupPath) {
        g.f(controller, "controller");
        g.f(cgroupPath, "cgroupPath");
        if (!this.f5746a) {
            return false;
        }
        try {
            boolean zNativeSetCGroup = nativeSetCGroup(i10, controller, cgroupPath);
            if (zNativeSetCGroup) {
                Log.d("NativeCGroupStrategy", "[" + getName() + "] 成功设置进程 " + i10 + " 到 " + controller + " CGroup: " + cgroupPath);
                return zNativeSetCGroup;
            }
            Log.w("NativeCGroupStrategy", "[" + getName() + "] 设置进程 " + i10 + " 到 " + controller + " CGroup 失败: " + cgroupPath);
            return zNativeSetCGroup;
        } catch (Exception e10) {
            Log.e("NativeCGroupStrategy", "[" + getName() + "] 设置 CGroup 异常", e10);
            return false;
        }
    }

    @Override // com.stepos.aicgroup.internal.strategy.CGroupStrategy
    public boolean setProcessProfiles(int i10, int i11, List<String> profiles) {
        g.f(profiles, "profiles");
        if (!this.f5746a) {
            return false;
        }
        if (profiles.isEmpty()) {
            ai.onnxruntime.a.x("[", getName(), "] 配置文件列表为空", "NativeCGroupStrategy");
            return false;
        }
        try {
            boolean zNativeSetProcessProfiles = nativeSetProcessProfiles(i10, i11, (String[]) profiles.toArray(new String[0]));
            if (zNativeSetProcessProfiles) {
                Log.d("NativeCGroupStrategy", "[" + getName() + "] 成功为进程 " + i11 + " (UID " + i10 + ") 设置配置文件: " + profiles);
                return zNativeSetProcessProfiles;
            }
            Log.w("NativeCGroupStrategy", "[" + getName() + "] 为进程 " + i11 + " (UID " + i10 + ") 设置配置文件失败: " + profiles);
            return zNativeSetProcessProfiles;
        } catch (Exception e10) {
            Log.e("NativeCGroupStrategy", "[" + getName() + "] 设置进程配置文件异常", e10);
            return false;
        }
    }

    @Override // com.stepos.aicgroup.internal.strategy.CGroupStrategy
    public boolean setTaskProfiles(int i10, List<String> profiles) {
        g.f(profiles, "profiles");
        if (!this.f5746a) {
            return false;
        }
        if (profiles.isEmpty()) {
            ai.onnxruntime.a.x("[", getName(), "] 配置文件列表为空", "NativeCGroupStrategy");
            return false;
        }
        try {
            boolean zNativeSetTaskProfiles = nativeSetTaskProfiles(i10, (String[]) profiles.toArray(new String[0]));
            if (zNativeSetTaskProfiles) {
                Log.d("NativeCGroupStrategy", "[" + getName() + "] 成功为线程 " + i10 + " 设置配置文件: " + profiles);
                return zNativeSetTaskProfiles;
            }
            Log.w("NativeCGroupStrategy", "[" + getName() + "] 为线程 " + i10 + " 设置配置文件失败: " + profiles);
            return zNativeSetTaskProfiles;
        } catch (Exception e10) {
            Log.e("NativeCGroupStrategy", "[" + getName() + "] 设置任务配置文件异常", e10);
            return false;
        }
    }
}
