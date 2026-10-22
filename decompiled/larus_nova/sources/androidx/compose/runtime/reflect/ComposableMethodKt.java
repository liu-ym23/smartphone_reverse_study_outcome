package androidx.compose.runtime.reflect;

import androidx.camera.video.AudioStats;
import androidx.compose.runtime.Composer;
import androidx.exifinterface.media.ExifInterface;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0018\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0002\u001a\u0012\u0010\t\u001a\u0004\u0018\u00010\n*\u0006\u0012\u0002\b\u00030\u000bH\u0002\u001a\f\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\b\u001a(\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000f\"\u0006\b\u0000\u0010\u0010\u0018\u0001*\u0002H\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0082\b¢\u0006\u0002\u0010\u0012\u001a7\u0010\u0013\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u001a\u0010\u0016\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000b0\u000f\"\u0006\u0012\u0002\b\u00030\u000b¢\u0006\u0002\u0010\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"BITS_PER_INT", "", "changedParamCount", "realValueParams", "thisParams", "defaultParamCount", "getComposableInfo", "Landroidx/compose/runtime/reflect/ComposableInfo;", "Ljava/lang/reflect/Method;", "getDefaultValue", "", "Ljava/lang/Class;", "asComposableMethod", "Landroidx/compose/runtime/reflect/ComposableMethod;", "dup", "", ExifInterface.GPS_DIRECTION_TRUE, "count", "(Ljava/lang/Object;I)[Ljava/lang/Object;", "getDeclaredComposableMethod", "methodName", "", "args", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Landroidx/compose/runtime/reflect/ComposableMethod;", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ComposableMethodKt {
    private static final int BITS_PER_INT = 31;

    public static final /* synthetic */ Object access$getDefaultValue(Class r100) {
        return getDefaultValue(r100);
    }

    public static final ComposableMethod asComposableMethod(Method r100) {
        ComposableInfo r101 = getComposableInfo(r100);
        if (r101.isComposable() == true) goto L5;
        return null;
    L5:
        return new ComposableMethod(r100, r101);
    }

    private static final int defaultParamCount(int r100) {
        return (int) Math.ceil(((double) r100) / 31.0d);
    }

    private static final ComposableInfo getComposableInfo(Method r100) {
        Class<?>[] r101 = r100.getParameterTypes();
        int r102 = r101.length - 1;
        if (r102 < 0) goto L10;
    L4:
        int r103 = r102 - 1;
        if (Intrinsics.areEqual(r101[r102], Composer.class) == true) goto L11;
        if (r103 < 0) goto L10;
        r102 = r103;
    L11:
        boolean r104 = false;
        if (r102 == (-1)) goto L14;
        int r105 = changedParamCount(r102, !Modifier.isStatic(r100.getModifiers()) ? 1 : 0);
        int r106 = (r102 + 1) + r105;
        int r107 = r100.getParameterTypes().length;
        if (r107 == r106) goto L18;
        boolean r108 = true;
    L19:
        if (r108 == false) goto L21;
        int r109 = defaultParamCount(r102);
    L23:
        if ((r106 + r109) != r107) goto L26;
        r104 = true;
    L26:
        return new ComposableInfo(r104, r102, r105, r109);
    L21:
        r109 = 0;
        goto L23
    L18:
        r108 = false;
        goto L19
    L14:
        return new ComposableInfo(false, r100.getParameterTypes().length, 0, 0);
    L10:
        r102 = -1;
        goto L11
    }

    private static final Object getDefaultValue(Class<?> r100) {
        String r101 = r100.getName();
        switch(r101.hashCode()) {
            case -1325958191: goto L34;
            case 104431: goto L30;
            case 3039496: goto L26;
            case 3052374: goto L22;
            case 3327612: goto L18;
            case 64711720: goto L14;
            case 97526364: goto L10;
            case 109413500: goto L6;
            default: goto L37;
        };
    L37:
        return null;
    L6:
        if (r101.equals("short") == false) goto L37;
        return (short) 0;
    L10:
        if (r101.equals("float") == false) goto L37;
        return Float.valueOf(0.0f);
    L14:
        if (r101.equals("boolean") == false) goto L37;
        return Boolean.FALSE;
    L18:
        if (r101.equals("long") == false) goto L37;
        return 0L;
    L22:
        if (r101.equals("char") == false) goto L37;
        return (char) 0;
    L26:
        if (r101.equals("byte") == false) goto L37;
        return (byte) 0;
    L30:
        if (r101.equals("int") == false) goto L37;
        return 0;
    L34:
        if (r101.equals(ItemStyle.ITEM_STYLE_DOUBLE) == false) goto L37;
        return Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    private static final int changedParamCount(int r100, int r101) {
        if (r100 != 0) goto L6;
        return 1;
    L6:
        return (int) Math.ceil(((double) (r100 + r101)) / 10.0d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final /* synthetic */ <T> T[] dup(T r100, int r101) {
        IntRange r102 = RangesKt.until(0, r101);
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<Integer> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((IntIterator) r104).nextInt();
        r103.add(r100);
        goto L4
    L6:
        Intrinsics.reifiedOperationMarker(0, "T?");
        return (T[]) r103.toArray(new Object[0]);
    }

    public static final ComposableMethod getDeclaredComposableMethod(Class<?> r100, String r101, Class<?>... r110) throws NoSuchMethodException {
        int r102 = changedParamCount(r110.length, 0);
        SpreadBuilder r103 = new SpreadBuilder(3);     // Catch: ReflectiveOperationException -> L9
        r103.addSpread(r110);     // Catch: ReflectiveOperationException -> L9
        r103.add(Composer.class);     // Catch: ReflectiveOperationException -> L9
        Class r104 = Integer.TYPE;     // Catch: ReflectiveOperationException -> L9
        IntRange r105 = RangesKt.until(0, r102);     // Catch: ReflectiveOperationException -> L9
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));     // Catch: ReflectiveOperationException -> L9
        Iterator<Integer> r107 = r105.iterator();     // Catch: ReflectiveOperationException -> L9
    L5:
        if (r107.hasNext() == false) goto L7;
        ((IntIterator) r107).nextInt();     // Catch: ReflectiveOperationException -> L9
        r106.add(r104);     // Catch: ReflectiveOperationException -> L9
        goto L5
    L7:
        r103.addSpread(r106.toArray(new Class[0]));     // Catch: ReflectiveOperationException -> L9
        Method r111 = r100.getDeclaredMethod(r101, (Class[]) r103.toArray(new Class[r103.size()]));     // Catch: ReflectiveOperationException -> L9
    L21:
        if (r111 == null) goto L25;
        ComposableMethod r108 = asComposableMethod(r111);
        Intrinsics.checkNotNull(r108);
        return r108;
    L25:
        throw new NoSuchMethodException(r100.getName() + '.' + r101);
    L9:
        int r109 = defaultParamCount(r110.length);
        SpreadBuilder r112 = new SpreadBuilder(4);     // Catch: ReflectiveOperationException -> L20
        r112.addSpread(r110);     // Catch: ReflectiveOperationException -> L20
        r112.add(Composer.class);     // Catch: ReflectiveOperationException -> L20
        Class r113 = Integer.TYPE;     // Catch: ReflectiveOperationException -> L20
        IntRange r114 = RangesKt.until(0, r102);     // Catch: ReflectiveOperationException -> L20
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));     // Catch: ReflectiveOperationException -> L20
        Iterator<Integer> r116 = r114.iterator();     // Catch: ReflectiveOperationException -> L20
    L12:
        if (r116.hasNext() == false) goto L14;
        ((IntIterator) r116).nextInt();     // Catch: ReflectiveOperationException -> L20
        r115.add(r113);     // Catch: ReflectiveOperationException -> L20
        goto L12
    L14:
        r112.addSpread(r115.toArray(new Class[0]));     // Catch: ReflectiveOperationException -> L20
        Class r117 = Integer.TYPE;     // Catch: ReflectiveOperationException -> L20
        IntRange r118 = RangesKt.until(0, r109);     // Catch: ReflectiveOperationException -> L20
        ArrayList r119 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r118, 10));     // Catch: ReflectiveOperationException -> L20
        Iterator<Integer> r120 = r118.iterator();     // Catch: ReflectiveOperationException -> L20
    L16:
        if (r120.hasNext() == false) goto L18;
        ((IntIterator) r120).nextInt();     // Catch: ReflectiveOperationException -> L20
        r119.add(r117);     // Catch: ReflectiveOperationException -> L20
        goto L16
    L18:
        r112.addSpread(r119.toArray(new Class[0]));     // Catch: ReflectiveOperationException -> L20
        r111 = r100.getDeclaredMethod(r101, (Class[]) r112.toArray(new Class[r112.size()]));     // Catch: ReflectiveOperationException -> L20
    L20:
        r111 = null;
        goto L21
    }
}
