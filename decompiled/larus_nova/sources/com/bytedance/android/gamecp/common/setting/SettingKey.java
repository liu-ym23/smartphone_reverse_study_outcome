package com.bytedance.android.gamecp.common.setting;

import android.os.Build;
import com.bytedance.android.gamecp.common.setting.config.a1;
import com.bytedance.android.gamecp.common.setting.config.w0;
import com.bytedance.android.gamecp.common.setting.config.x0;
import com.bytedance.android.gamecp.common.utils.e1;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import gu.c;
import gu.d;
import gu.e;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import wu.t1;
import wu.x4;
import yr.b;

/* JADX INFO: loaded from: classes44.dex */
public class SettingKey<T> {
    private final T debugValue;
    private final T defaultValue;
    private final String description;
    private final String name;
    private final String[] option;
    private final boolean sticky;
    private final Type type;
    private T value;

    public T getSpValue() {
        Gson r100 = x4.f561418a;
        if (isBasicType(this.type) == false) goto L5;
        this.value = (T) com.bytedance.android.gamecp.host_api.a.b().getLiveService().A(this.name, this.type, this.defaultValue, Boolean.valueOf(this.sticky));
    L11:
        if (this.value != null) goto L14;
        this.value = this.defaultValue;
    L14:
        return this.value;
    L5:
        String r101 = (String) com.bytedance.android.gamecp.host_api.a.b().getLiveService().A(this.name, String.class, "", Boolean.valueOf(this.sticky));
        T r102 = (T) GsonProtectorUtils.fromJson(x4.f561418a, r101, this.type);
        if (r102 != null) goto L9;
        r102 = this.defaultValue;
    L9:
        this.value = r102;
        goto L11
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
    public T getValue() {
        Gson r100 = x4.f561418a;
        String r101 = this.name;
        d r102 = e.f482737a;
        SettingKey<Boolean> r103 = LiveInfraSettingKeys.LIVE_ENABLE_KEVA_OPT;
        boolean r104 = false;
        if (r103.getSpValue().booleanValue() == false) goto L25;
        List<gu.a> r105 = c.f482734a;
        if ((!Intrinsics.areEqual(LiveInfraSettingKeys.KEVA_REMOTE_CONFIG_SETTING_KEY.getName(), r101)) == true) goto L7;
    L22:
        boolean r106 = false;
    L23:
        if (r106 == false) goto L25;
        boolean r107 = true;
    L26:
        if (r107 == false) goto L88;
        String r108 = this.name;
        T r109 = this.defaultValue;
        Type r110 = this.type;
        if (LiveInfraSettingKeys.LIVE_ENABLE_KEVA_OPT.getSpValue().booleanValue() == false) goto L48;
        List r111 = c.b();
        if ((r111 instanceof Collection) == true) goto L32;
    L34:
        Iterator<T> r112 = r111.iterator();
    L36:
        if (r112.hasNext() == false) goto L45;
        gu.a r113 = (gu.a) r112.next();
        if (Intrinsics.areEqual(r113.f482732a, r108) == true) goto L40;
    L42:
        boolean r114 = false;
    L43:
        if (r114 == false) goto L36;
        boolean r115 = true;
    L46:
        if (r115 == false) goto L48;
        r104 = true;
        goto L48
    L40:
        if (Intrinsics.areEqual(r113.f482733b, Boolean.TRUE) == false) goto L42;
        r114 = true;
    L45:
        r115 = false;
        goto L46
    L32:
        if (r111.isEmpty() == false) goto L34;
    L48:
        String r116 = null;
        if (r104 == false) goto L76;
        d r117 = e.f482737a;
        String r118 = r117.f482736b;
        if (r117.f482735a != null) goto L54;
        r117.f482735a = Keva.getRepo(r118);
    L54:
        if ((r109 instanceof Boolean) == false) goto L56;
    L75:
        T r119 = (T) r117.a(r108, r109, r110);
    L78:
        if (Build.VERSION.SDK_INT < 28) goto L86;
        if (r119 == null) goto L81;
        String r120 = r119.toString();
    L82:
        StringBuilder r121 = new StringBuilder("isLargeKey=");
        r121.append(r104);
        r121.append(", type=");
        if (r110 == null) goto L85;
        r116 = r110.getTypeName();
    L85:
        r121.append(r116);
        b.b(4, "LiveStorageHelper", "action:getLocalValue, key=" + r108 + ", value=" + r120 + ", extra：" + r121.toString());
        goto L86
    L81:
        r120 = null;
    L86:
        this.value = r119;
        b.b(4, "LiveStorageHelper", "current key uses keva, key=" + this.name + "value =" + this.value);
    L96:
        if (this.value != null) goto L99;
        this.value = this.defaultValue;
    L99:
        return this.value;
    L56:
        if ((r109 instanceof Integer) == true) goto L75;
        if ((r109 instanceof Long) == true) goto L75;
        if ((r109 instanceof Float) == true) goto L75;
        if ((r109 instanceof Double) == true) goto L75;
        if ((r109 instanceof String) == false) goto L70;
        String r122 = (String) r109;
        Keva r123 = r117.f482735a;
        if (r123 == null) goto L69;
        r119 = (T) r123.getStringJustDisk(r108, r122);
        goto L78
    L69:
        r119 = null;
        goto L78
    L70:
        Gson r124 = new Gson();
        String r125 = GsonProtectorUtils.toJson(new Gson(), r109);
        Keva r126 = r117.f482735a;
        if (r126 == null) goto L73;
        String r127 = r126.getString(r108, r125);
    L74:
        r119 = (T) GsonProtectorUtils.fromJson(r124, r127, r110);
        goto L78
    L73:
        r127 = null;
        goto L74
    L76:
        r119 = (T) e.f482737a.a(r108, r109, r110);
        goto L78
    L88:
        if (isBasicType(this.type) == false) goto L90;
        this.value = (T) com.bytedance.android.gamecp.host_api.a.b().getLiveService().A(this.name, this.type, this.defaultValue, Boolean.valueOf(this.sticky));
        goto L96
    L90:
        T r128 = (T) GsonProtectorUtils.fromJson(x4.f561418a, (String) com.bytedance.android.gamecp.host_api.a.b().getLiveService().A(this.name, String.class, "", Boolean.valueOf(this.sticky)), this.type);
        if (r128 != null) goto L94;
        r128 = this.defaultValue;
    L94:
        this.value = r128;
        goto L96
    L7:
        if ((!Intrinsics.areEqual(r103.getName(), r101)) == false) goto L22;
        List r129 = c.b();
        if ((r129 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r130 = r129.iterator();
    L15:
        if (r130.hasNext() == false) goto L19;
        if (Intrinsics.areEqual(((gu.a) r130.next()).f482732a, r101) == false) goto L15;
        boolean r131 = true;
    L20:
        if (r131 == false) goto L22;
        r106 = true;
    L19:
        r131 = false;
        goto L20
    L11:
        if (r129.isEmpty() == false) goto L13;
    L25:
        r107 = false;
        goto L26
    }

    public T getDebugValue() {
        return this.debugValue;
    }

    public T getDefaultValue() {
        return this.defaultValue;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public String[] getOption() {
        return this.option;
    }

    public Type getType() {
        return this.type;
    }

    private boolean isBasicType(Type r100) {
        if (r100 != Boolean.class) goto L5;
    L18:
        return true;
    L5:
        if (r100 == Integer.class) goto L18;
        if (r100 == Short.class) goto L18;
        if (r100 == Float.class) goto L18;
        if (r100 == Long.class) goto L18;
        if (r100 == Double.class) goto L18;
        if (r100 == String.class) goto L18;
        return false;
    }

    public T getValue(a.InterfaceC0913a r110) {
        int r100 = a.f56734a;
        Intrinsics.checkNotNullParameter(this, "settingKey");
        if (r110 == null) goto L5;
        Map<String, String> r101 = r110.get();
    L6:
        boolean r102 = true;
        if (r101 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        T r111 = getValue();
    L138:
        this.value = r111;
        return r111;
    L15:
        a1 r104 = t1.f561391a.getValue();
        if (r104 == null) goto L18;
        Map<String, w0> r105 = r104.a();
    L19:
        if (r105 != null) goto L21;
    L24:
        boolean r106 = true;
    L25:
        if (r106 == true) goto L137;
        if (r104 == null) goto L28;
        Map<String, x0> r107 = r104.b();
    L29:
        if (r107 != null) goto L31;
    L34:
        boolean r108 = true;
    L35:
        if (r108 == true) goto L137;
        if (r104 == null) goto L136;
        Map<String, w0> r109 = r104.a();
        if (r109 == null) goto L136;
        w0 r112 = r109.get(getName());
        if (r112 == null) goto L136;
        List<List<String>> r113 = r112.b();
        if (r113 != null) goto L45;
    L48:
        boolean r114 = true;
    L49:
        if (r114 == false) goto L51;
        r111 = getValue();
        goto L138
    L51:
        Iterator<T> r115 = r112.b().iterator();
    L53:
        if (r115.hasNext() == false) goto L136;
        List r116 = (List) r115.next();
        boolean r117 = r116 instanceof Collection;
        if (r117 == true) goto L57;
    L59:
        Iterator<T> r118 = r116.iterator();
    L61:
        if (r118.hasNext() == false) goto L79;
        String r119 = (String) r118.next();
        if (r110 == null) goto L76;
        Map<String, String> r120 = r110.get();
        if (r120 == null) goto L76;
        Map<String, x0> r121 = r104.b();
        if (r121 == null) goto L72;
        x0 r122 = r121.get(r119);
        if (r122 == null) goto L72;
        String r123 = r122.a();
        if (r123 == null) goto L72;
    L74:
        if (r120.containsKey(r123) == true) goto L76;
        boolean r124 = true;
    L77:
        if (r124 == false) goto L61;
        boolean r125 = false;
    L80:
        if (r125 == false) goto L53;
        if (r117 == true) goto L83;
    L85:
        Iterator<T> r126 = r116.iterator();
    L87:
        if (r126.hasNext() == false) goto L110;
        String r127 = (String) r126.next();
        Map<String, x0> r128 = r104.b();
        if (r128 == null) goto L91;
        x0 r129 = r128.get(r127);
    L92:
        if (r129 == null) goto L107;
        List<String> r130 = r129.b();
        if (r130 == null) goto L107;
        List<String> r131 = r130;
        if (r110 == null) goto L103;
        Map<String, String> r132 = r110.get();
        if (r132 == null) goto L103;
        String r133 = r129.a();
        if (r133 != null) goto L102;
        r133 = "";
    L102:
        String r134 = r132.get(r133);
    L105:
        if (CollectionsKt.contains(r131, r134) == true) goto L107;
        boolean r135 = true;
    L108:
        if (r135 == false) goto L87;
        boolean r136 = false;
    L111:
        if (r136 == false) goto L53;
        if (r112.a() != null) goto L140;
        r111 = getDefaultValue();
        goto L138
    L140:
        Type r137 = getType();     // Catch: Exception -> L134
        if (r137 != Boolean.TYPE) goto L117;
    L130:
        if (r102 == false) goto L132;
        r111 = (T) r112.a();
        goto L138
    L132:
        r111 = (T) x4.f561418a.fromJson(e1.a(r112.a()), getType());
        goto L138
    L117:
        if (r137 == Integer.TYPE) goto L130;
        if (r137 == Short.TYPE) goto L130;
        if (r137 == Float.TYPE) goto L130;
        if (r137 == Long.TYPE) goto L130;
        if (r137 == Double.TYPE) goto L130;
        if (r137 == String.class) goto L130;
        r102 = false;
    L134:
        r111 = getDefaultValue();
    L103:
        r134 = null;
    L107:
        r135 = false;
        goto L108
    L91:
        r129 = null;
    L110:
        r136 = true;
        goto L111
    L83:
        if (r116.isEmpty() == false) goto L85;
    L72:
        r123 = "";
    L76:
        r124 = false;
    L79:
        r125 = true;
        goto L80
    L57:
        if (r116.isEmpty() == false) goto L59;
    L45:
        if (r113.isEmpty() == true) goto L48;
        r114 = false;
    L136:
        r111 = getValue();
        goto L138
    L31:
        if (r107.isEmpty() == true) goto L34;
        r108 = false;
        goto L35
    L28:
        r107 = null;
    L137:
        r111 = getValue();
        goto L138
    L21:
        if (r105.isEmpty() == true) goto L24;
        r106 = false;
        goto L25
    L18:
        r105 = null;
        goto L19
    L9:
        if (r101.isEmpty() == true) goto L12;
        r103 = false;
        goto L13
    L5:
        r101 = null;
        goto L6
    }

    public SettingKey(String r100, Class<T> r101) {
        this(r100, r101, "");
    }

    public SettingKey(String r100, T r101) {
        this(r100, "", r101);
    }

    public SettingKey(String r100, Type r101, T r102) {
        this.name = r100;
        this.defaultValue = r102;
        this.debugValue = r102;
        this.type = r101;
        this.description = null;
        this.option = null;
        this.sticky = false;
    }

    public SettingKey(String r100, String r110, T r111) {
        this(r100, r111.getClass(), r110, r111, r111, false, null);
    }

    public SettingKey(String r100, Class<T> r101, String r102) {
        this(r100, r101, r102, null, null);
    }

    public SettingKey(String r100, String r110, T r111, T r112) {
        this(r100, r111.getClass(), r110, r111, r112, false, null);
    }

    public SettingKey(String r100, String r110, T r111, T r112, boolean r113) {
        this(r100, r111.getClass(), r110, r111, r112, r113, null);
    }

    public SettingKey(String r100, String r110, T r111, T r112, String... r113) {
        this(r100, r111.getClass(), r110, r111, r112, false, r113);
    }

    public SettingKey(String r100, Class<T> r110, String r111, T r112, T r113) {
        this(r100, r110, r111, r112, r113, false, null);
    }

    public SettingKey(String r100, String r110, T r111, T r112, boolean r113, String... r114) {
        this(r100, r111.getClass(), r110, r111, r112, r113, r114);
    }

    public SettingKey(String r100, Class<T> r110, String r111, T r112, T r113, boolean r114) {
        this(r100, r110, r111, r112, r113, r114, null);
    }

    private SettingKey(String r100, Class<T> r101, String r102, T r103, T r104, boolean r105, String[] r106) {
        this.name = r100;
        this.description = r102;
        this.defaultValue = r103;
        this.debugValue = r104;
        this.type = r101;
        this.option = r106;
        this.sticky = r105;
    }
}
