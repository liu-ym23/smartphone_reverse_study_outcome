package androidx.camera.core.internal;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ReadableConfig;

/* JADX INFO: loaded from: classes2.dex */
public interface TargetConfig<T> extends ReadableConfig {
    public static final Config.Option<Class<?>> OPTION_TARGET_CLASS = null;
    public static final Config.Option<String> OPTION_TARGET_NAME = null;

    /* JADX INFO: renamed from: androidx.camera.core.internal.TargetConfig$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<T> {
        public static Class $default$getTargetClass(TargetConfig r100) {
            return (Class) r100.retrieveOption(TargetConfig.OPTION_TARGET_CLASS);
        }

        public static String $default$getTargetName(TargetConfig r100) {
            return (String) r100.retrieveOption(TargetConfig.OPTION_TARGET_NAME);
        }

        public static Class $default$getTargetClass(TargetConfig r100, Class r101) {
            return (Class) r100.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, r101);
        }

        public static String $default$getTargetName(TargetConfig r100, String r101) {
            return (String) r100.retrieveOption(TargetConfig.OPTION_TARGET_NAME, r101);
        }
    }

    public interface Builder<T, B> {
        B setTargetClass(Class<T> r100);

        B setTargetName(String r100);
    }

    Class<T> getTargetClass();

    Class<T> getTargetClass(Class<T> r100);

    String getTargetName();

    String getTargetName(String r100);

    static {
        OPTION_TARGET_NAME = Config.Option.create("camerax.core.target.name", String.class);
        OPTION_TARGET_CLASS = Config.Option.create("camerax.core.target.class", Class.class);
    }
}
