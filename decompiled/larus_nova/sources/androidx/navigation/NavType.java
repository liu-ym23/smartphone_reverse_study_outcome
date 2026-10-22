package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u0000 \u0019*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0006\u0019\u001a\u001b\u001c\u001d\u001eB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH¦\u0002¢\u0006\u0002\u0010\u000fJ%\u0010\u0010\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0012J\u0015\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\bH&¢\u0006\u0002\u0010\u0014J%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001f"}, d2 = {"Landroidx/navigation/NavType;", ExifInterface.GPS_DIRECTION_TRUE, "", "isNullableAllowed", "", "(Z)V", "()Z", "name", "", "getName", "()Ljava/lang/String;", MonitorConstants.CONNECT_TYPE_GET, "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Object;", "parseAndPut", "value", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "parseValue", "(Ljava/lang/String;)Ljava/lang/Object;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)V", "toString", "Companion", "EnumType", "ParcelableArrayType", "ParcelableType", "SerializableArrayType", "SerializableType", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class NavType<T> {
    public static final NavType<boolean[]> BoolArrayType = null;
    public static final NavType<Boolean> BoolType = null;
    public static final Companion Companion = null;
    public static final NavType<float[]> FloatArrayType = null;
    public static final NavType<Float> FloatType = null;
    public static final NavType<int[]> IntArrayType = null;
    public static final NavType<Integer> IntType = null;
    public static final NavType<long[]> LongArrayType = null;
    public static final NavType<Long> LongType = null;
    public static final NavType<Integer> ReferenceType = null;
    public static final NavType<String[]> StringArrayType = null;
    public static final NavType<String> StringType = null;
    private final boolean isNullableAllowed;
    private final String name;

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017H\u0017J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u0017H\u0007J\u0018\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0007R\u0018\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00160\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/navigation/NavType$Companion;", "", "()V", "BoolArrayType", "Landroidx/navigation/NavType;", "", "BoolType", "", "FloatArrayType", "", "FloatType", "", "IntArrayType", "", "IntType", "", "LongArrayType", "", "LongType", "", "ReferenceType", "StringArrayType", "", "", "StringType", "fromArgType", "type", "packageName", "inferFromValue", "value", "inferFromValueType", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_androidx_navigation_NavType$Companion_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class r103 = access$000(r100);     // Catch: Throwable -> L8
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r103;
        L8:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class r104 = access$000(r100);     // Catch: Throwable -> L17
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r104;
        L17:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r100);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r100);
        }

        @JvmStatic
        public final NavType<Object> inferFromValue(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            NavType<Integer> r101 = NavType.IntType;     // Catch: IllegalArgumentException -> L5
            r101.parseValue(r100);     // Catch: IllegalArgumentException -> L5
            return r101;
        L5:
            NavType<Long> r102 = NavType.LongType;     // Catch: IllegalArgumentException -> L7
            r102.parseValue(r100);     // Catch: IllegalArgumentException -> L7
            return r102;
        L7:
            NavType<Float> r103 = NavType.FloatType;     // Catch: IllegalArgumentException -> L9
            r103.parseValue(r100);     // Catch: IllegalArgumentException -> L9
            return r103;
        L9:
            NavType<Boolean> r104 = NavType.BoolType;     // Catch: IllegalArgumentException -> L11
            r104.parseValue(r100);     // Catch: IllegalArgumentException -> L11
            return r104;
        L12:
            return NavType.StringType;
        }

        @JvmStatic
        public final NavType<Object> inferFromValueType(Object r100) {
            if ((r100 instanceof Integer) == false) goto L6;
            return NavType.IntType;
        L6:
            if ((r100 instanceof int[]) == false) goto L9;
            return NavType.IntArrayType;
        L9:
            if ((r100 instanceof Long) == false) goto L12;
            return NavType.LongType;
        L12:
            if ((r100 instanceof long[]) == false) goto L15;
            return NavType.LongArrayType;
        L15:
            if ((r100 instanceof Float) == false) goto L18;
            return NavType.FloatType;
        L18:
            if ((r100 instanceof float[]) == false) goto L21;
            return NavType.FloatArrayType;
        L21:
            if ((r100 instanceof Boolean) == false) goto L24;
            return NavType.BoolType;
        L24:
            if ((r100 instanceof boolean[]) == false) goto L27;
            return NavType.BoolArrayType;
        L27:
            if ((r100 instanceof String) == true) goto L66;
            if (r100 == null) goto L66;
            if ((r100 instanceof Object[]) == false) goto L36;
            if ((((Object[]) r100) instanceof String[]) == false) goto L36;
            return NavType.StringArrayType;
        L36:
            if (r100.getClass().isArray() == false) goto L45;
            Class<?> r101 = r100.getClass().getComponentType();
            Intrinsics.checkNotNull(r101);
            if (Parcelable.class.isAssignableFrom(r101) == false) goto L45;
            Class<?> r102 = r100.getClass().getComponentType();
            if (r102 == null) goto L43;
            NavType<Object> r103 = new ParcelableArrayType(r102);
        L76:
            return r103;
        L43:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<android.os.Parcelable>");
        L45:
            if (r100.getClass().isArray() == false) goto L54;
            Class<?> r104 = r100.getClass().getComponentType();
            Intrinsics.checkNotNull(r104);
            if (Serializable.class.isAssignableFrom(r104) == false) goto L54;
            Class<?> r105 = r100.getClass().getComponentType();
            if (r105 == null) goto L52;
            r103 = new SerializableArrayType(r105);
            goto L76
        L52:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");
        L54:
            if ((r100 instanceof Parcelable) == false) goto L58;
            r103 = new ParcelableType(r100.getClass());
            goto L76
        L58:
            if ((r100 instanceof Enum) == false) goto L61;
            r103 = new EnumType(r100.getClass());
            goto L76
        L61:
            if ((r100 instanceof Serializable) == false) goto L64;
            r103 = new SerializableType(r100.getClass());
            goto L76
        L64:
            throw new IllegalArgumentException("Object of type " + r100.getClass().getName() + " is not supported for navigation arguments.");
        L66:
            return NavType.StringType;
        }

        @JvmStatic
        public NavType<?> fromArgType(String r100, String r101) {
            NavType<Integer> r102 = NavType.IntType;
            if (Intrinsics.areEqual(r102.getName(), r100) == false) goto L5;
            return r102;
        L5:
            NavType r103 = NavType.IntArrayType;
            if (Intrinsics.areEqual(r103.getName(), r100) == false) goto L8;
            return r103;
        L8:
            NavType<Long> r104 = NavType.LongType;
            if (Intrinsics.areEqual(r104.getName(), r100) == false) goto L11;
            return r104;
        L11:
            NavType r105 = NavType.LongArrayType;
            if (Intrinsics.areEqual(r105.getName(), r100) == false) goto L14;
            return r105;
        L14:
            NavType<Boolean> r106 = NavType.BoolType;
            if (Intrinsics.areEqual(r106.getName(), r100) == false) goto L17;
            return r106;
        L17:
            NavType r107 = NavType.BoolArrayType;
            if (Intrinsics.areEqual(r107.getName(), r100) == false) goto L20;
            return r107;
        L20:
            NavType<String> r108 = NavType.StringType;
            if (Intrinsics.areEqual(r108.getName(), r100) == false) goto L23;
            return r108;
        L23:
            NavType r109 = NavType.StringArrayType;
            if (Intrinsics.areEqual(r109.getName(), r100) == false) goto L26;
            return r109;
        L26:
            NavType<Float> r110 = NavType.FloatType;
            if (Intrinsics.areEqual(r110.getName(), r100) == false) goto L29;
            return r110;
        L29:
            NavType r111 = NavType.FloatArrayType;
            if (Intrinsics.areEqual(r111.getName(), r100) == false) goto L32;
            return r111;
        L32:
            NavType<Integer> r112 = NavType.ReferenceType;
            if (Intrinsics.areEqual(r112.getName(), r100) == false) goto L36;
            return r112;
        L36:
            if (r100 != null) goto L38;
        L41:
            boolean r113 = true;
        L42:
            if (r113 == false) goto L97;
            return r108;
        L97:
        L93:
            e = move-exception;
            throw new RuntimeException(e);
        L44:
            if (StringsKt.startsWith$default(r100, ".", false, 2, null) == false) goto L47;
            if (r101 == null) goto L47;
            String r114 = Intrinsics.stringPlus(r101, r100);     // Catch: ClassNotFoundException -> L93
        L50:
            if (StringsKt.endsWith$default(r100, "[]", false, 2, null) == false) goto L67;
            r114 = r114.substring(0, r114.length() - 2);     // Catch: ClassNotFoundException -> L93
            Class r115 = INVOKESTATIC_androidx_navigation_NavType$Companion_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r114);     // Catch: ClassNotFoundException -> L93
            if (Parcelable.class.isAssignableFrom(r115) == false) goto L60;
            if (r115 == null) goto L58;
            return new ParcelableArrayType(r115);
        L58:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<android.os.Parcelable>");     // Catch: ClassNotFoundException -> L93
        L60:
            if (Serializable.class.isAssignableFrom(r115) == false) goto L92;
            if (r115 == null) goto L66;
            return new SerializableArrayType(r115);
        L66:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");     // Catch: ClassNotFoundException -> L93
        L92:
            throw new IllegalArgumentException(Intrinsics.stringPlus(r114, " is not Serializable or Parcelable."));     // Catch: ClassNotFoundException -> L93
        L67:
            Class r116 = INVOKESTATIC_androidx_navigation_NavType$Companion_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r114);     // Catch: ClassNotFoundException -> L93
            if (Parcelable.class.isAssignableFrom(r116) == false) goto L76;
            if (r116 == null) goto L74;
            return new ParcelableType(r116);
        L74:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<kotlin.Any?>");     // Catch: ClassNotFoundException -> L93
        L76:
            if (Enum.class.isAssignableFrom(r116) == false) goto L84;
            if (r116 == null) goto L82;
            return new EnumType(r116);
        L82:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<kotlin.Enum<*>>");     // Catch: ClassNotFoundException -> L93
        L84:
            if (Serializable.class.isAssignableFrom(r116) == false) goto L92;
            if (r116 == null) goto L90;
            return new SerializableType(r116);
        L90:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");     // Catch: ClassNotFoundException -> L93
        L47:
            r114 = r100;
            goto L50
        L38:
            if (r100.length() == 0) goto L41;
            r113 = false;
            goto L42
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000*\f\b\u0001\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u000b\u001a\u00028\u00012\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\rR\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/navigation/NavType$EnumType;", "D", "", "Landroidx/navigation/NavType$SerializableType;", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "name", "", "getName", "()Ljava/lang/String;", "parseValue", "value", "(Ljava/lang/String;)Ljava/lang/Enum;", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class EnumType<D extends Enum<?>> extends SerializableType<D> {
        private final Class<D> type;

        @Override // androidx.navigation.NavType.SerializableType, androidx.navigation.NavType
        public String getName() {
            return this.type.getName();
        }

        public EnumType(Class<D> r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            super(false, r100);
            if (r100.isEnum() == false) goto L7;
            this.type = r100;
            return;
        L7:
            throw new IllegalArgumentException((r100 + " is not an Enum type.").toString());
        }

        @Override // androidx.navigation.NavType.SerializableType, androidx.navigation.NavType
        public D parseValue(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            D[] r101 = this.type.getEnumConstants();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L7;
            D r104 = r101[r103];
            r103 = r103 + 1;
            if (StringsKt.equals(r104.name(), r100, true) == false) goto L3;
        L8:
            D r105 = r104;
            if (r105 == null) goto L12;
            return r105;
        L12:
            throw new IllegalArgumentException("Enum value " + r100 + " not found for type " + this.type.getName() + '.');
        L7:
            r104 = null;
            goto L8
        }

        @Override // androidx.navigation.NavType.SerializableType, androidx.navigation.NavType
        public /* bridge */ /* synthetic */ Serializable parseValue(String r100) {
            return parseValue(r100);
        }

        @Override // androidx.navigation.NavType.SerializableType, androidx.navigation.NavType
        public /* bridge */ /* synthetic */ Object parseValue(String r100) {
            return parseValue(r100);
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00040\u0003B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J&\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0096\u0002¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0019\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u001aJ-\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\u001dR\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Landroidx/navigation/NavType$ParcelableArrayType;", "D", "Landroid/os/Parcelable;", "Landroidx/navigation/NavType;", "", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "arrayType", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", MonitorConstants.CONNECT_TYPE_GET, "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)[Landroid/os/Parcelable;", "hashCode", "", "parseValue", "value", "(Ljava/lang/String;)[Landroid/os/Parcelable;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;[Landroid/os/Parcelable;)V", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ParcelableArrayType<D extends Parcelable> extends NavType<D[]> {
        private final Class<D[]> arrayType;

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        @Override // androidx.navigation.NavType
        public String getName() {
            return this.arrayType.getName();
        }

        public int hashCode() {
            return this.arrayType.hashCode();
        }

        public ParcelableArrayType(Class<D> r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            super(true);
            if (Parcelable.class.isAssignableFrom(r100) == false) goto L14;
            Class<D[]> r101 = INVOKESTATIC_androidx_navigation_NavType$ParcelableArrayType_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("[L" + r100.getName() + ';');     // Catch: ClassNotFoundException -> L10
            if (r101 == null) goto L9;
            this.arrayType = r101;
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<kotlin.Array<D of androidx.navigation.NavType.ParcelableArrayType>>");     // Catch: ClassNotFoundException -> L10
        L10:
            e = move-exception;
            throw new RuntimeException(e);
        L14:
            throw new IllegalArgumentException((r100 + " does not implement Parcelable.").toString());
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_androidx_navigation_NavType$ParcelableArrayType_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class r103 = access$000(r100);     // Catch: Throwable -> L8
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r103;
        L8:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class r104 = access$000(r100);     // Catch: Throwable -> L17
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r104;
        L17:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r100);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L5;
            return true;
        L5:
            if (r100 != null) goto L7;
            return false;
        L7:
            if (Intrinsics.areEqual(ParcelableArrayType.class, r100.getClass()) == true) goto L10;
            return false;
        L10:
            return Intrinsics.areEqual(this.arrayType, ((ParcelableArrayType) r100).arrayType);
        }

        @Override // androidx.navigation.NavType
        public D[] parseValue(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ Object parseValue(String r100) {
            return parseValue(r100);
        }

        @Override // androidx.navigation.NavType
        public D[] get(Bundle r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "bundle");
            Intrinsics.checkNotNullParameter(r101, "key");
            return (D[]) ((Parcelable[]) r100.get(r101));
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ Object get(Bundle r100, String r101) {
            return get(r100, r101);
        }

        public void put(Bundle r100, String r101, D[] r102) {
            Intrinsics.checkNotNullParameter(r100, "bundle");
            Intrinsics.checkNotNullParameter(r101, "key");
            this.arrayType.cast(r102);
            r100.putParcelableArray(r101, r102);
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ void put(Bundle r100, String r101, Object r102) {
            put(r100, r101, (Parcelable[]) r102);
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J \u0010\u000e\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0015\u0010\u0015\u001a\u00028\u00012\u0006\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0017J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/navigation/NavType$ParcelableType;", "D", "Landroidx/navigation/NavType;", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", MonitorConstants.CONNECT_TYPE_GET, "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Object;", "hashCode", "", "parseValue", "value", "(Ljava/lang/String;)Ljava/lang/Object;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)V", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ParcelableType<D> extends NavType<D> {
        private final Class<D> type;

        @Override // androidx.navigation.NavType
        public String getName() {
            return this.type.getName();
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        public ParcelableType(Class<D> r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            boolean r101 = true;
            super(true);
            if (Parcelable.class.isAssignableFrom(r100) == false) goto L5;
        L8:
            if (r101 == false) goto L12;
            this.type = r100;
            return;
        L12:
            throw new IllegalArgumentException((r100 + " does not implement Parcelable or Serializable.").toString());
        L5:
            if (Serializable.class.isAssignableFrom(r100) == true) goto L8;
            r101 = false;
            goto L8
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L5;
            return true;
        L5:
            if (r100 != null) goto L7;
            return false;
        L7:
            if (Intrinsics.areEqual(ParcelableType.class, r100.getClass()) == true) goto L10;
            return false;
        L10:
            return Intrinsics.areEqual(this.type, ((ParcelableType) r100).type);
        }

        @Override // androidx.navigation.NavType
        public D parseValue(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public D get(Bundle r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "bundle");
            Intrinsics.checkNotNullParameter(r101, "key");
            return (D) r100.get(r101);
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle r100, String r101, D r102) {
            Intrinsics.checkNotNullParameter(r100, "bundle");
            Intrinsics.checkNotNullParameter(r101, "key");
            this.type.cast(r102);
            if (r102 != null) goto L5;
        L10:
            r100.putParcelable(r101, (Parcelable) r102);
            return;
        L5:
            if ((r102 instanceof Parcelable) == true) goto L10;
            if ((r102 instanceof Serializable) == false) goto L12;
            r100.putSerializable(r101, (Serializable) r102);
            return;
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00040\u0003B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J&\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0096\u0002¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0019\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u001aJ-\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\u001dR\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Landroidx/navigation/NavType$SerializableArrayType;", "D", "Ljava/io/Serializable;", "Landroidx/navigation/NavType;", "", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "arrayType", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", MonitorConstants.CONNECT_TYPE_GET, "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)[Ljava/io/Serializable;", "hashCode", "", "parseValue", "value", "(Ljava/lang/String;)[Ljava/io/Serializable;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;[Ljava/io/Serializable;)V", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SerializableArrayType<D extends Serializable> extends NavType<D[]> {
        private final Class<D[]> arrayType;

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        @Override // androidx.navigation.NavType
        public String getName() {
            return this.arrayType.getName();
        }

        public int hashCode() {
            return this.arrayType.hashCode();
        }

        public SerializableArrayType(Class<D> r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            super(true);
            if (Serializable.class.isAssignableFrom(r100) == false) goto L14;
            Class<D[]> r101 = INVOKESTATIC_androidx_navigation_NavType$SerializableArrayType_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("[L" + r100.getName() + ';');     // Catch: ClassNotFoundException -> L10
            if (r101 == null) goto L9;
            this.arrayType = r101;
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<kotlin.Array<D of androidx.navigation.NavType.SerializableArrayType>>");     // Catch: ClassNotFoundException -> L10
        L10:
            e = move-exception;
            throw new RuntimeException(e);
        L14:
            throw new IllegalArgumentException((r100 + " does not implement Serializable.").toString());
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_androidx_navigation_NavType$SerializableArrayType_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class r103 = access$000(r100);     // Catch: Throwable -> L8
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r103;
        L8:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class r104 = access$000(r100);     // Catch: Throwable -> L17
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r104;
        L17:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r100);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L5;
            return true;
        L5:
            if (r100 != null) goto L7;
            return false;
        L7:
            if (Intrinsics.areEqual(SerializableArrayType.class, r100.getClass()) == true) goto L10;
            return false;
        L10:
            return Intrinsics.areEqual(this.arrayType, ((SerializableArrayType) r100).arrayType);
        }

        @Override // androidx.navigation.NavType
        public D[] parseValue(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ Object parseValue(String r100) {
            return parseValue(r100);
        }

        @Override // androidx.navigation.NavType
        public D[] get(Bundle r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "bundle");
            Intrinsics.checkNotNullParameter(r101, "key");
            return (D[]) ((Serializable[]) r100.get(r101));
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ Object get(Bundle r100, String r101) {
            return get(r100, r101);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void put(Bundle r100, String r101, D[] r102) {
            Intrinsics.checkNotNullParameter(r100, "bundle");
            Intrinsics.checkNotNullParameter(r101, "key");
            this.arrayType.cast(r102);
            r100.putSerializable(r101, r102);
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ void put(Bundle r100, String r101, Object r102) {
            put(r100, r101, (Serializable[]) r102);
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006B\u001d\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\tJ\u0013\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J \u0010\u0011\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0015\u0010\u0018\u001a\u00028\u00012\u0006\u0010\u0019\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\u001aJ%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001dR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/navigation/NavType$SerializableType;", "D", "Ljava/io/Serializable;", "Landroidx/navigation/NavType;", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "nullableAllowed", "", "(ZLjava/lang/Class;)V", "name", "", "getName", "()Ljava/lang/String;", "equals", "other", "", MonitorConstants.CONNECT_TYPE_GET, "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/io/Serializable;", "hashCode", "", "parseValue", "value", "(Ljava/lang/String;)Ljava/io/Serializable;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/io/Serializable;)V", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static class SerializableType<D extends Serializable> extends NavType<D> {
        private final Class<D> type;

        @Override // androidx.navigation.NavType
        public String getName() {
            return this.type.getName();
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        public SerializableType(Class<D> r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            super(true);
            if (Serializable.class.isAssignableFrom(r100) == false) goto L11;
            if ((true ^ r100.isEnum()) == false) goto L9;
            this.type = r100;
            return;
        L9:
            throw new IllegalArgumentException((r100 + " is an Enum. You should use EnumType instead.").toString());
        L11:
            throw new IllegalArgumentException((r100 + " does not implement Serializable.").toString());
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof SerializableType) == true) goto L10;
            return false;
        L10:
            return Intrinsics.areEqual(this.type, ((SerializableType) r100).type);
        }

        @Override // androidx.navigation.NavType
        public D parseValue(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ Object parseValue(String r100) {
            return parseValue(r100);
        }

        public SerializableType(boolean r100, Class<D> r101) {
            Intrinsics.checkNotNullParameter(r101, "type");
            super(r100);
            if (Serializable.class.isAssignableFrom(r101) == false) goto L7;
            this.type = r101;
            return;
        L7:
            throw new IllegalArgumentException((r101 + " does not implement Serializable.").toString());
        }

        @Override // androidx.navigation.NavType
        public D get(Bundle r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "bundle");
            Intrinsics.checkNotNullParameter(r101, "key");
            return (D) r100.get(r101);
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ Object get(Bundle r100, String r101) {
            return get(r100, r101);
        }

        public void put(Bundle r100, String r101, D r102) {
            Intrinsics.checkNotNullParameter(r100, "bundle");
            Intrinsics.checkNotNullParameter(r101, "key");
            Intrinsics.checkNotNullParameter(r102, "value");
            this.type.cast(r102);
            r100.putSerializable(r101, r102);
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ void put(Bundle r100, String r101, Object r102) {
            put(r100, r101, (Serializable) r102);
        }
    }

    @JvmStatic
    public static NavType<?> fromArgType(String r100, String r101) {
        return Companion.fromArgType(r100, r101);
    }

    @JvmStatic
    public static final NavType<Object> inferFromValue(String r100) {
        return Companion.inferFromValue(r100);
    }

    @JvmStatic
    public static final NavType<Object> inferFromValueType(Object r100) {
        return Companion.inferFromValueType(r100);
    }

    public abstract T get(Bundle r100, String r101);

    public abstract T parseValue(String r100);

    public abstract void put(Bundle r100, String r101, T r102);

    static {
        Companion = new Companion(null);
        IntType = new NavType$Companion$IntType$1();
        ReferenceType = new NavType$Companion$ReferenceType$1();
        IntArrayType = new NavType$Companion$IntArrayType$1();
        LongType = new NavType$Companion$LongType$1();
        LongArrayType = new NavType$Companion$LongArrayType$1();
        FloatType = new NavType$Companion$FloatType$1();
        FloatArrayType = new NavType$Companion$FloatArrayType$1();
        BoolType = new NavType$Companion$BoolType$1();
        BoolArrayType = new NavType$Companion$BoolArrayType$1();
        StringType = new NavType$Companion$StringType$1();
        StringArrayType = new NavType$Companion$StringArrayType$1();
    }

    public String toString() {
        return getName();
    }

    public String getName() {
        return this.name;
    }

    public boolean isNullableAllowed() {
        return this.isNullableAllowed;
    }

    public NavType(boolean r100) {
        this.isNullableAllowed = r100;
        this.name = "nav_type";
    }

    public final T parseAndPut(Bundle r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        T r103 = parseValue(r102);
        put(r100, r101, r103);
        return r103;
    }
}
