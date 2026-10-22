package com.stepos.core.common.log;

import com.stepos.core.common.telemetry.FailStage;
import com.stepos.core.common.telemetry.ModelCallSessionTrackerKt;
import gc.o;
import gc.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LogModule {
    private static final /* synthetic */ sb.a $ENTRIES;
    private static final /* synthetic */ LogModule[] $VALUES;
    public static final Companion Companion;
    private static final String LOG_TAG_PREFIX = "AIEngine_";
    private final String description;
    private final String moduleTag;
    private final int nativeId;
    public static final LogModule SERVICE = new LogModule("SERVICE", 0, "Service", "服务层日志", 0);
    public static final LogModule ABILITY = new LogModule("ABILITY", 1, "Ability", "能力层日志", 1);
    public static final LogModule MODEL = new LogModule("MODEL", 2, "Model", "模型管理日志", 2);
    public static final LogModule INFERENCE = new LogModule(FailStage.INFERENCE, 3, "Inference", "推理引擎日志", 3);
    public static final LogModule IPC = new LogModule("IPC", 4, "IPC", "进程通信日志", 4);
    public static final LogModule NATIVE = new LogModule(ModelCallSessionTrackerKt.MODEL_CALL_TRANSPORT_NATIVE, 5, "Native", "Native层日志", 5);
    public static final LogModule PERFORMANCE = new LogModule("PERFORMANCE", 6, "Perf", "性能监控日志", 6);
    public static final LogModule SYSTEM = new LogModule("SYSTEM", 7, "System", "系统级日志", 7);
    public static final LogModule OTA = new LogModule("OTA", 8, "OTA", "OTA 更新与下载", 8);
    public static final LogModule CLOUDCONFIG = new LogModule("CLOUDCONFIG", 9, "CloudConfig", "云配下发", 9);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ String getFullTag$default(Companion companion, LogModule logModule, String str, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                str = null;
            }
            return companion.getFullTag(logModule, str);
        }

        public final LogModule fromName(String name) {
            g.f(name, "name");
            try {
                String upperCase = name.toUpperCase(Locale.ROOT);
                g.e(upperCase, "toUpperCase(...)");
                return LogModule.valueOf(upperCase);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final LogModule fromNativeId(int i10) {
            LogModule next;
            Iterator<LogModule> it = LogModule.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.getNativeId() == i10) {
                    break;
                }
            }
            return next;
        }

        public final LogModule fromTag(String tag) {
            LogModule next;
            g.f(tag, "tag");
            Iterator<LogModule> it = LogModule.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (o.f0(next.getModuleTag(), tag)) {
                    break;
                }
            }
            return next;
        }

        public final String getFullTag(LogModule module, String str) {
            g.f(module, "module");
            return (str == null || q.t0(str)) ? ai.onnxruntime.a.k(LogModule.LOG_TAG_PREFIX, module.getModuleTag()) : ai.onnxruntime.a.l(LogModule.LOG_TAG_PREFIX, module.getModuleTag(), "_", str);
        }

        public final List<LogModule> parseModules(String modulesStr) {
            g.f(modulesStr, "modulesStr");
            List listD0 = q.D0(modulesStr, new String[]{","}, 6);
            ArrayList arrayList = new ArrayList();
            Iterator it = listD0.iterator();
            while (it.hasNext()) {
                LogModule logModuleFromName = LogModule.Companion.fromName(q.L0((String) it.next()).toString());
                if (logModuleFromName != null) {
                    arrayList.add(logModuleFromName);
                }
            }
            return arrayList;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ LogModule[] $values() {
        return new LogModule[]{SERVICE, ABILITY, MODEL, INFERENCE, IPC, NATIVE, PERFORMANCE, SYSTEM, OTA, CLOUDCONFIG};
    }

    static {
        LogModule[] logModuleArr$values = $values();
        $VALUES = logModuleArr$values;
        $ENTRIES = kotlin.enums.a.a(logModuleArr$values);
        Companion = new Companion(null);
    }

    private LogModule(String str, int i10, String str2, String str3, int i11) {
        this.moduleTag = str2;
        this.description = str3;
        this.nativeId = i11;
    }

    public static final LogModule fromName(String str) {
        return Companion.fromName(str);
    }

    public static final LogModule fromNativeId(int i10) {
        return Companion.fromNativeId(i10);
    }

    public static final LogModule fromTag(String str) {
        return Companion.fromTag(str);
    }

    public static sb.a<LogModule> getEntries() {
        return $ENTRIES;
    }

    public static final String getFullTag(LogModule logModule, String str) {
        return Companion.getFullTag(logModule, str);
    }

    public static final List<LogModule> parseModules(String str) {
        return Companion.parseModules(str);
    }

    public static LogModule valueOf(String str) {
        return (LogModule) Enum.valueOf(LogModule.class, str);
    }

    public static LogModule[] values() {
        return (LogModule[]) $VALUES.clone();
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getModuleTag() {
        return this.moduleTag;
    }

    public final int getNativeId() {
        return this.nativeId;
    }
}
