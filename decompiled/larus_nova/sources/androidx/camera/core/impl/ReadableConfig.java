package androidx.camera.core.impl;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface ReadableConfig extends Config {

    /* JADX INFO: renamed from: androidx.camera.core.impl.ReadableConfig$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Set $default$listOptions(ReadableConfig r100) {
            return r100.getConfig().listOptions();
        }

        public static boolean $default$containsOption(ReadableConfig r100, Config.Option r101) {
            return r100.getConfig().containsOption(r101);
        }

        public static Config.OptionPriority $default$getOptionPriority(ReadableConfig r100, Config.Option r101) {
            return r100.getConfig().getOptionPriority(r101);
        }

        public static Set $default$getPriorities(ReadableConfig r100, Config.Option r101) {
            return r100.getConfig().getPriorities(r101);
        }

        public static Object $default$retrieveOption(ReadableConfig r100, Config.Option r101) {
            return r100.getConfig().retrieveOption(r101);
        }

        public static void $default$findOptions(ReadableConfig r100, String r101, Config.OptionMatcher r102) {
            r100.getConfig().findOptions(r101, r102);
        }

        public static Object $default$retrieveOption(ReadableConfig r100, Config.Option r101, Object r102) {
            return r100.getConfig().retrieveOption(r101, r102);
        }

        public static Object $default$retrieveOptionWithPriority(ReadableConfig r100, Config.Option r101, Config.OptionPriority r102) {
            return r100.getConfig().retrieveOptionWithPriority(r101, r102);
        }
    }

    @Override // androidx.camera.core.impl.Config
    boolean containsOption(Config.Option<?> r100);

    @Override // androidx.camera.core.impl.Config
    void findOptions(String r100, Config.OptionMatcher r101);

    Config getConfig();

    @Override // androidx.camera.core.impl.Config
    Config.OptionPriority getOptionPriority(Config.Option<?> r100);

    @Override // androidx.camera.core.impl.Config
    Set<Config.OptionPriority> getPriorities(Config.Option<?> r100);

    @Override // androidx.camera.core.impl.Config
    Set<Config.Option<?>> listOptions();

    @Override // androidx.camera.core.impl.Config
    <ValueT> ValueT retrieveOption(Config.Option<ValueT> r100);

    @Override // androidx.camera.core.impl.Config
    <ValueT> ValueT retrieveOption(Config.Option<ValueT> r100, ValueT r101);

    @Override // androidx.camera.core.impl.Config
    <ValueT> ValueT retrieveOptionWithPriority(Config.Option<ValueT> r100, Config.OptionPriority r101);
}
