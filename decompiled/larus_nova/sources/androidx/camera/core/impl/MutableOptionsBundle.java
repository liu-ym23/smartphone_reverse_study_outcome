package androidx.camera.core.impl;

import android.util.ArrayMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public final class MutableOptionsBundle extends OptionsBundle implements MutableConfig {
    private static final Config.OptionPriority DEFAULT_PRIORITY = null;

    static {
        DEFAULT_PRIORITY = Config.OptionPriority.OPTIONAL;
    }

    public static MutableOptionsBundle create() {
        return new MutableOptionsBundle(new TreeMap(OptionsBundle.ID_COMPARE));
    }

    private MutableOptionsBundle(TreeMap<Config.Option<?>, Map<Config.OptionPriority, Object>> r100) {
        super(r100);
    }

    public static MutableOptionsBundle from(Config r100) {
        TreeMap r101 = new TreeMap(OptionsBundle.ID_COMPARE);
        Iterator<Config.Option<?>> r102 = r100.listOptions().iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        Config.Option<?> r103 = r102.next();
        Set<Config.OptionPriority> r104 = r100.getPriorities(r103);
        ArrayMap r105 = new ArrayMap();
        Iterator<Config.OptionPriority> r106 = r104.iterator();
    L7:
        if (r106.hasNext() == false) goto L9;
        Config.OptionPriority r107 = r106.next();
        r105.put(r107, r100.retrieveOptionWithPriority(r103, r107));
        goto L7
    L9:
        r101.put(r103, r105);
        goto L4
    L11:
        return new MutableOptionsBundle(r101);
    }

    @Override // androidx.camera.core.impl.MutableConfig
    public <ValueT> ValueT removeOption(Config.Option<ValueT> r100) {
        return (ValueT) this.mOptions.remove(r100);
    }

    @Override // androidx.camera.core.impl.MutableConfig
    public <ValueT> void insertOption(Config.Option<ValueT> r100, ValueT r101) {
        insertOption(r100, DEFAULT_PRIORITY, r101);
    }

    @Override // androidx.camera.core.impl.MutableConfig
    public <ValueT> void insertOption(Config.Option<ValueT> r100, Config.OptionPriority r101, ValueT r102) {
        Map<Config.OptionPriority, Object> r103 = this.mOptions.get(r100);
        if (r103 != null) goto L6;
        ArrayMap r104 = new ArrayMap();
        this.mOptions.put(r100, r104);
        r104.put(r101, r102);
        return;
    L6:
        Config.OptionPriority r105 = (Config.OptionPriority) Collections.min(r103.keySet());
        if (Objects.equals(r103.get(r105), r102) == false) goto L9;
    L13:
        r103.put(r101, r102);
        return;
    L9:
        if (Config.CC.hasConflict(r105, r101) == false) goto L13;
        throw new IllegalArgumentException("Option values conflicts: " + r100.getId() + ", existing value (" + r105 + ")=" + r103.get(r105) + ", conflicting (" + r101 + ")=" + r102);
    }
}
