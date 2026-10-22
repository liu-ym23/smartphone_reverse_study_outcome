package androidx.camera.core.impl;

import androidx.camera.core.impl.utils.ResolutionSelectorUtil;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface Config {

    /* JADX INFO: renamed from: androidx.camera.core.impl.Config$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean hasConflict(OptionPriority r100, OptionPriority r101) {
            OptionPriority r102 = OptionPriority.REQUIRED;
            if (r100 != r102) goto L6;
            if (r101 != r102) goto L6;
            return true;
        L6:
            return false;
        }

        public static Config mergeConfigs(Config r100, Config r101) {
            if (r100 != null) goto L6;
            if (r101 != null) goto L6;
            return OptionsBundle.emptyBundle();
        L6:
            if (r101 == null) goto L8;
            MutableOptionsBundle r102 = MutableOptionsBundle.from(r101);
        L9:
            if (r100 == null) goto L15;
            Iterator<Option<?>> r103 = r100.listOptions().iterator();
        L12:
            if (r103.hasNext() == false) goto L15;
            mergeOptionValue(r102, r101, r100, r103.next());
        L15:
            return OptionsBundle.from(r102);
        L8:
            r102 = MutableOptionsBundle.create();
            goto L9
        }

        public static void mergeOptionValue(MutableOptionsBundle r100, Config r101, Config r102, Option<?> r103) {
            if (Objects.equals(r103, ImageOutputConfig.OPTION_RESOLUTION_SELECTOR) == false) goto L5;
            ResolutionSelector r104 = (ResolutionSelector) r102.retrieveOption(r103, null);
            ResolutionSelector r105 = (ResolutionSelector) r101.retrieveOption(r103, null);
            r100.insertOption(r103, r102.getOptionPriority(r103), ResolutionSelectorUtil.overrideResolutionSelectors(r105, r104));
            return;
        L5:
            r100.insertOption(r103, r102.getOptionPriority(r103), r102.retrieveOption(r103));
        }
    }

    public static abstract class Option<T> {
        public abstract String getId();

        public abstract Object getToken();

        public abstract Class<T> getValueClass();

        public Option() {
        }

        public static <T> Option<T> create(String r100, Class<?> r101) {
            return create(r100, r101, null);
        }

        public static <T> Option<T> create(String r100, Class<?> r101, Object r102) {
            return new AutoValue_Config_Option(r100, r101, r102);
        }
    }

    public interface OptionMatcher {
        boolean onOptionMatched(Option<?> r100);
    }

    public static final enum OptionPriority extends Enum<OptionPriority> {
        private static final /* synthetic */ OptionPriority[] $VALUES = null;
        public static final OptionPriority ALWAYS_OVERRIDE = null;
        public static final OptionPriority HIGH_PRIORITY_REQUIRED = null;
        public static final OptionPriority OPTIONAL = null;
        public static final OptionPriority REQUIRED = null;

        private static /* synthetic */ OptionPriority[] $values() {
            return new OptionPriority[]{ALWAYS_OVERRIDE, HIGH_PRIORITY_REQUIRED, REQUIRED, OPTIONAL};
        }

        static {
            ALWAYS_OVERRIDE = new OptionPriority("ALWAYS_OVERRIDE", 0);
            HIGH_PRIORITY_REQUIRED = new OptionPriority("HIGH_PRIORITY_REQUIRED", 1);
            REQUIRED = new OptionPriority("REQUIRED", 2);
            OPTIONAL = new OptionPriority("OPTIONAL", 3);
            $VALUES = $values();
        }

        public static OptionPriority[] values() {
            return (OptionPriority[]) $VALUES.clone();
        }

        public static OptionPriority valueOf(String r100) {
            return (OptionPriority) r27.a.a(OptionPriority.class, r100);
        }

        private OptionPriority(String r100, int r101) {
            super(r100, r101);
        }
    }

    boolean containsOption(Option<?> r100);

    void findOptions(String r100, OptionMatcher r101);

    OptionPriority getOptionPriority(Option<?> r100);

    Set<OptionPriority> getPriorities(Option<?> r100);

    Set<Option<?>> listOptions();

    <ValueT> ValueT retrieveOption(Option<ValueT> r100);

    <ValueT> ValueT retrieveOption(Option<ValueT> r100, ValueT r101);

    <ValueT> ValueT retrieveOptionWithPriority(Option<ValueT> r100, OptionPriority r101);
}
