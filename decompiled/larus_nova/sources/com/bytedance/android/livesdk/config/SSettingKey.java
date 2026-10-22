package com.bytedance.android.livesdk.config;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.live.strategy.api.StrategyMutableLiveData;
import com.bytedance.android.livesdkapi.strategy.StrategyConvertHelper;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes8.dex */
public class SSettingKey<T> extends SettingKey<T> {
    static StrategyMutableLiveData<Object> NOT_SET;
    static Boolean enable;
    static volatile IStrategyService strategyService;

    @Override // com.bytedance.android.live.core.setting.SettingKey
    public T getValue() {
        return getValue(true, true);
    }

    static {
        NOT_SET = new StrategyMutableLiveData();
    }

    public SSettingKey(String r100, Class<T> r101) {
        super(r100, r101);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public T getValue(boolean r100, boolean r101) {
        T r102 = (T) super.getValue();
        if (isSticky() == false) goto L6;
        return r102;
    L6:
        if (enable != null) goto L9;
        enable = com.bytedance.android.livesdk.t7.f158510a.getValue();
    L9:
        if (enable.booleanValue() == true) goto L12;
        return r102;
    L12:
        if (jc1.k.h(IStrategyService.class) == true) goto L15;
        return r102;
    L15:
        if (strategyService != null) goto L18;
        strategyService = (IStrategyService) jc1.k.f(IStrategyService.class);
    L18:
        if (enable.booleanValue() == true) goto L20;
    L46:
        return r102;
    L20:
        if (strategyService == null) goto L46;
        if (strategyService.isStrategyFactor(getName()) == true) goto L24;
        return r102;
    L24:
        Class<?> r103 = r102.getClass();
        if (r103.isPrimitive() == false) goto L27;
    L38:
        LiveData<T> r104 = strategyService.getFactor(getName(), r102, r100, r101);
        if (r104 == null) goto L41;
        T r105 = r104.getValue();
    L42:
        if (r105 == null) goto L46;
        if (r105 == NOT_SET.getValue()) goto L46;
        return r105;
    L41:
        r105 = null;
        goto L42
    L27:
        if (r103 == Boolean.class) goto L38;
        if (r103 == Integer.class) goto L38;
        if (r103 == String.class) goto L38;
        if (r103 == Float.class) goto L38;
        if (r103 == Double.class) goto L38;
        r105 = (T) StrategyConvertHelper.getObjectStrategyValue(getName(), r102, r100, r101);
        goto L42
    }

    public SSettingKey(String r100, T r101) {
        super(r100, r101);
    }

    public SSettingKey(String r100, Class<T> r101, String r102) {
        super(r100, r101, r102);
    }

    public SSettingKey(String r100, T r101, String r102) {
        super(r100, r101, r102);
    }

    public SSettingKey(String r100, Type r101, T r102) {
        super(r100, r101, r102);
    }

    public SSettingKey(String r100, Class<T> r101, String r102, boolean r103) {
        super(r100, r101, r102, r103);
    }

    public SSettingKey(String r100, T r101, String r102, String... r103) {
        super(r100, r101, r102, r103);
    }

    public SSettingKey(String r100, String r101, T r102, T r103) {
        super(r100, r101, r102, r103);
    }

    public SSettingKey(String r100, Class<T> r101, String r102, T r103, T r104) {
        super(r100, r101, r102, r103, r104);
    }

    public SSettingKey(String r100, String r101, T r102, T r103, boolean r104) {
        super(r100, r101, r102, r103, r104);
    }

    public SSettingKey(String r100, String r101, T r102, T r103, String... r104) {
        super(r100, r101, r102, r103, r104);
    }

    public SSettingKey(String r100, String r101, T r102, T r110, T r111, boolean r112) {
        super(r100, r101, r110, r111, r112);
    }

    public SSettingKey(String r100, Class<T> r101, String r102, T r103, T r104, boolean r105) {
        super(r100, r101, r102, r103, r104, r105);
    }

    public SSettingKey(String r100, String r101, T r102, T r103, boolean r104, String... r105) {
        super(r100, r101, r102, r103, r104, r105);
    }

    public SSettingKey(String r100, String r101, T r102, Type r103, boolean r104, boolean r105) {
        super(r100, r101, r102, r103, r104, r105);
    }

    public SSettingKey(String r100, String r101, T r102, Type r103, boolean r104, boolean r105, boolean r106) {
        super(r100, r101, r102, r103, r104, r105, r106);
    }
}
