package androidx.camera.core.impl;

import android.util.ArrayMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public class OptionsBundle implements Config {
    private static final OptionsBundle EMPTY_BUNDLE = null;
    protected static final Comparator<Config.Option<?>> ID_COMPARE = null;
    protected final TreeMap<Config.Option<?>, Map<Config.OptionPriority, Object>> mOptions;

    public static /* synthetic */ int a(Config.Option r100, Config.Option r101) {
        return lambda$static$0(r100, r101);
    }

    static {
        Comparator<Config.Option<?>> r100 = new t();
        ID_COMPARE = r100;
        EMPTY_BUNDLE = new OptionsBundle(new TreeMap(r100));
    }

    @Override // androidx.camera.core.impl.Config
    public Set<Config.Option<?>> listOptions() {
        return Collections.unmodifiableSet(this.mOptions.keySet());
    }

    public static OptionsBundle emptyBundle() {
        return EMPTY_BUNDLE;
    }

    public OptionsBundle(TreeMap<Config.Option<?>, Map<Config.OptionPriority, Object>> r100) {
        this.mOptions = r100;
    }

    public static OptionsBundle from(Config r100) {
        if (OptionsBundle.class.equals(r100.getClass()) == true) goto L5;
        TreeMap r101 = new TreeMap(ID_COMPARE);
        Iterator<Config.Option<?>> r102 = r100.listOptions().iterator();
    L8:
        if (r102.hasNext() == false) goto L15;
        Config.Option<?> r103 = r102.next();
        Set<Config.OptionPriority> r104 = r100.getPriorities(r103);
        ArrayMap r105 = new ArrayMap();
        Iterator<Config.OptionPriority> r106 = r104.iterator();
    L11:
        if (r106.hasNext() == false) goto L13;
        Config.OptionPriority r107 = r106.next();
        r105.put(r107, r100.retrieveOptionWithPriority(r103, r107));
        goto L11
    L13:
        r101.put(r103, r105);
        goto L8
    L15:
        return new OptionsBundle(r101);
    L5:
        return (OptionsBundle) r100;
    }

    @Override // androidx.camera.core.impl.Config
    public boolean containsOption(Config.Option<?> r100) {
        return this.mOptions.containsKey(r100);
    }

    @Override // androidx.camera.core.impl.Config
    public Config.OptionPriority getOptionPriority(Config.Option<?> r100) {
        Map<Config.OptionPriority, Object> r101 = this.mOptions.get(r100);
        if (r101 == null) goto L7;
        return (Config.OptionPriority) Collections.min(r101.keySet());
    L7:
        throw new IllegalArgumentException("Option does not exist: " + r100);
    }

    @Override // androidx.camera.core.impl.Config
    public Set<Config.OptionPriority> getPriorities(Config.Option<?> r100) {
        Map<Config.OptionPriority, Object> r101 = this.mOptions.get(r100);
        if (r101 != null) goto L7;
        return Collections.emptySet();
    L7:
        return Collections.unmodifiableSet(r101.keySet());
    }

    @Override // androidx.camera.core.impl.Config
    public <ValueT> ValueT retrieveOption(Config.Option<ValueT> r100) {
        Map<Config.OptionPriority, Object> r101 = this.mOptions.get(r100);
        if (r101 == null) goto L7;
        return (ValueT) r101.get((Config.OptionPriority) Collections.min(r101.keySet()));
    L7:
        throw new IllegalArgumentException("Option does not exist: " + r100);
    }

    private static /* synthetic */ int lambda$static$0(Config.Option r100, Config.Option r101) {
        return r100.getId().compareTo(r101.getId());
    }

    @Override // androidx.camera.core.impl.Config
    public void findOptions(String r100, Config.OptionMatcher r101) {
        Config.Option<?> r102 = Config.Option.create(r100, Void.class);
        Iterator<Map.Entry<Config.Option<?>, Map<Config.OptionPriority, Object>>> r103 = this.mOptions.tailMap(r102).entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        Map.Entry<Config.Option<?>, Map<Config.OptionPriority, Object>> r104 = r103.next();
        if (r104.getKey().getId().startsWith(r100) == false) goto L15;
        if (r101.onOptionMatched(r104.getKey()) == true) goto L4;
        return;
    L15:
        return;
    }

    @Override // androidx.camera.core.impl.Config
    public <ValueT> ValueT retrieveOption(Config.Option<ValueT> r100, ValueT r101) {
        return (ValueT) retrieveOption(r100);
    L4:
        return r101;
    }

    @Override // androidx.camera.core.impl.Config
    public <ValueT> ValueT retrieveOptionWithPriority(Config.Option<ValueT> r100, Config.OptionPriority r101) {
        Map<Config.OptionPriority, Object> r102 = this.mOptions.get(r100);
        if (r102 == null) goto L11;
        if (r102.containsKey(r101) == false) goto L9;
        return (ValueT) r102.get(r101);
    L9:
        throw new IllegalArgumentException("Option does not exist: " + r100 + " with priority=" + r101);
    L11:
        throw new IllegalArgumentException("Option does not exist: " + r100);
    }
}
