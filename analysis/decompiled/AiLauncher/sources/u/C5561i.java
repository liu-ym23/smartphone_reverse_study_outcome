package u;

import D.C0761b0;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.Q;
import Z8.r;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.impl.z;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import p.q;
import p9.InterfaceC5063a;
import r.y;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000b2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J?\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\"\u0004\b\u0000\u0010\u00062\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\b2\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\b¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0017\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0016\u0018\u00010\u00152\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0006*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\bH\u0002¢\u0006\u0004\b\u0019\u0010\u0013J#\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00160\b2\u0006\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001d\u0010'\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010&R\u001b\u0010,\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010 \u001a\u0004\b*\u0010+R!\u00100\u001a\b\u0012\u0004\u0012\u00020\t0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010 \u001a\u0004\b.\u0010/¨\u00061"}, d2 = {"Lu/i;", "", "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "<init>", "(Landroidx/camera/camera2/pipe/g;)V", ExifInterface.GPS_DIRECTION_TRUE, "", "", "Landroid/util/Size;", "sizesMap", "f", "(Ljava/util/Map;)Ljava/util/Map;", ContentDisposition.Parameters.Size, "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/util/Size;)I", "sizesList", "l", "(Ljava/util/List;)Ljava/util/List;", "surfaceSizes", "", "Landroid/util/Range;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/util/List;)[Landroid/util/Range;", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/util/Size;)Ljava/util/List;", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/g;", "", Const.INTENT_KEY_PKGNAME, "LY8/h;", "o", "()Z", "isHighSpeedSupported", "c", "k", "()Landroid/util/Size;", "maxSize", "Lp/q;", Const.INTENT_KEY_UMID, "m", "()Lp/q;", "streamConfigurationMapCompat", "e", "n", "()Ljava/util/List;", "supportedSizes", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: u.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5561i {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: g, reason: collision with root package name */
    public static final Range<Integer> f42374g = new Range<>(120, 120);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.g cameraMetadata;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Y8.h isHighSpeedSupported;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Y8.h maxSize;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Y8.h streamConfigurationMapCompat;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Y8.h supportedSizes;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\n\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0010\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lu/i$a;", "", "<init>", "()V", "", "Landroidx/camera/core/impl/b;", "attachedSurfaces", "Landroidx/camera/core/impl/z;", "newUseCaseConfigs", "", Const.INTENT_KEY_PKGNAME, "(Ljava/util/Collection;Ljava/util/Collection;)Z", "Landroid/util/Range;", "", "DEFAULT_FPS", "Landroid/util/Range;", Const.INTENT_KEY_APIKEY, "()Landroid/util/Range;", "", "TAG", "Ljava/lang/String;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: u.i$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final Range<Integer> a() {
            return C5561i.f42374g;
        }

        public final boolean b(Collection<? extends androidx.camera.core.impl.b> attachedSurfaces, Collection<? extends z<?>> newUseCaseConfigs) {
            boolean z10;
            p.i(attachedSurfaces, "attachedSurfaces");
            p.i(newUseCaseConfigs, "newUseCaseConfigs");
            Collection<? extends androidx.camera.core.impl.b> collection = attachedSurfaces;
            ArrayList arrayList = new ArrayList(C1174w.x(collection, 10));
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((androidx.camera.core.impl.b) it.next()).g()));
            }
            Collection<? extends z<?>> collection2 = newUseCaseConfigs;
            ArrayList arrayList2 = new ArrayList(C1174w.x(collection2, 10));
            Iterator<T> it2 = collection2.iterator();
            while (true) {
                z10 = false;
                if (!it2.hasNext()) {
                    break;
                }
                arrayList2.add(Integer.valueOf(((z) it2.next()).n(0)));
            }
            List listS0 = F.S0(arrayList, arrayList2);
            boolean z11 = listS0 instanceof Collection;
            if (!z11 || !listS0.isEmpty()) {
                Iterator it3 = listS0.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    if (((Number) it3.next()).intValue() == 1) {
                        z10 = true;
                        break;
                    }
                }
            }
            if (!z10 || (z11 && listS0.isEmpty())) {
                return z10;
            }
            Iterator it4 = listS0.iterator();
            while (it4.hasNext()) {
                if (((Number) it4.next()).intValue() != 1) {
                    throw new IllegalArgumentException("All sessionTypes should be high-speed when any of them is high-speed");
                }
            }
            return z10;
        }

        public Companion() {
        }
    }

    public C5561i(androidx.camera.camera2.pipe.g cameraMetadata) {
        p.i(cameraMetadata, "cameraMetadata");
        this.cameraMetadata = cameraMetadata;
        this.isHighSpeedSupported = C4848b.b(new InterfaceC5063a() { // from class: u.e
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(C5561i.p(this.f42369a));
            }
        });
        this.maxSize = C4848b.b(new InterfaceC5063a() { // from class: u.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C5561i.q(this.f42370a);
            }
        });
        this.streamConfigurationMapCompat = C4848b.b(new InterfaceC5063a() { // from class: u.g
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C5561i.r(this.f42371a);
            }
        });
        this.supportedSizes = C4848b.b(new InterfaceC5063a() { // from class: u.h
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C5561i.s(this.f42372a);
            }
        });
    }

    public static final boolean p(C5561i c5561i) {
        androidx.camera.camera2.pipe.g gVar = c5561i.cameraMetadata;
        CameraCharacteristics.Key REQUEST_AVAILABLE_CAPABILITIES = CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES;
        p.h(REQUEST_AVAILABLE_CAPABILITIES, "REQUEST_AVAILABLE_CAPABILITIES");
        int[] iArr = (int[]) gVar.e0(REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr != null) {
            for (int i10 : iArr) {
                if (i10 == 9) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final Size q(C5561i c5561i) {
        List<Size> listN = c5561i.n();
        if (listN.isEmpty()) {
            listN = null;
        }
        if (listN == null) {
            return null;
        }
        Iterator<T> it = listN.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            int iB = T.c.b((Size) next);
            do {
                Object next2 = it.next();
                int iB2 = T.c.b((Size) next2);
                if (iB < iB2) {
                    next = next2;
                    iB = iB2;
                }
            } while (it.hasNext());
        }
        return (Size) next;
    }

    public static final q r(C5561i c5561i) {
        androidx.camera.camera2.pipe.g gVar = c5561i.cameraMetadata;
        CameraCharacteristics.Key SCALER_STREAM_CONFIGURATION_MAP = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP;
        p.h(SCALER_STREAM_CONFIGURATION_MAP, "SCALER_STREAM_CONFIGURATION_MAP");
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) gVar.e0(SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap != null) {
            return new q(streamConfigurationMap, new y(c5561i.cameraMetadata, streamConfigurationMap));
        }
        throw new IllegalArgumentException("Cannot retrieve SCALER_STREAM_CONFIGURATION_MAP");
    }

    public static final List s(C5561i c5561i) {
        List listT0;
        Size[] sizeArrC = c5561i.m().c();
        return (sizeArrC == null || (listT0 = r.T0(sizeArrC)) == null) ? C1173v.m() : listT0;
    }

    public final <T> Map<T, List<Size>> f(Map<T, ? extends List<Size>> sizesMap) {
        p.i(sizesMap, "sizesMap");
        List<T> listG = g(F.m1(sizesMap.values()));
        ArrayList arrayList = new ArrayList();
        for (T t10 : listG) {
            if (n().contains((Size) t10)) {
                arrayList.add(t10);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(Q.e(sizesMap.size()));
        Iterator<T> it = sizesMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            List list = (List) entry.getValue();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                if (arrayList.contains((Size) obj)) {
                    arrayList2.add(obj);
                }
            }
            linkedHashMap.put(key, arrayList2);
        }
        return linkedHashMap;
    }

    public final <T> List<T> g(List<? extends List<? extends T>> list) {
        if (list.isEmpty()) {
            return C1173v.m();
        }
        List<T> listP1 = F.p1((Collection) F.q0(list));
        Iterator<T> it = F.h0(list, 1).iterator();
        while (it.hasNext()) {
            listP1.retainAll((List) it.next());
        }
        return listP1;
    }

    public final Range<Integer>[] h(List<Size> surfaceSizes) {
        p.i(surfaceSizes, "surfaceSizes");
        int size = surfaceSizes.size();
        if (1 > size || size >= 3 || F.g0(surfaceSizes).size() != 1) {
            return null;
        }
        List<Range<Integer>> listI = i(surfaceSizes.get(0));
        if (listI.isEmpty()) {
            listI = null;
        }
        if (listI == null) {
            return null;
        }
        if (surfaceSizes.size() == 2) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : listI) {
                Range range = (Range) obj;
                if (p.d(range.getLower(), range.getUpper())) {
                    arrayList.add(obj);
                }
            }
            listI = arrayList;
        }
        return (Range[]) listI.toArray(new Range[0]);
    }

    public final List<Range<Integer>> i(Size size) {
        Object objB;
        List listV;
        List<Range<Integer>> listM1;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(m().b(size));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        Range[] rangeArr = (Range[]) objB;
        return (rangeArr == null || (listV = r.V(rangeArr)) == null || (listM1 = F.m1(listV)) == null) ? C1173v.m() : listM1;
    }

    public final int j(Size size) {
        p.i(size, "size");
        List<Range<Integer>> listI = i(size);
        if (listI.isEmpty()) {
            listI = null;
        }
        if (listI == null) {
            C0761b0.o("HighSpeedResolver", "No supported high speed  fps for " + size);
            return 0;
        }
        Iterator<T> it = listI.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Integer num = (Integer) ((Range) it.next()).getUpper();
        while (it.hasNext()) {
            Integer num2 = (Integer) ((Range) it.next()).getUpper();
            if (num.compareTo(num2) < 0) {
                num = num2;
            }
        }
        p.h(num, "maxOf(...)");
        return num.intValue();
    }

    public final Size k() {
        return (Size) this.maxSize.getValue();
    }

    public final List<List<Size>> l(List<? extends List<Size>> sizesList) {
        p.i(sizesList, "sizesList");
        if (sizesList.isEmpty()) {
            return C1173v.m();
        }
        List<Size> listG = g(sizesList);
        ArrayList arrayList = new ArrayList(C1174w.x(listG, 10));
        for (Size size : listG) {
            int size2 = sizesList.size();
            ArrayList arrayList2 = new ArrayList(size2);
            for (int i10 = 0; i10 < size2; i10++) {
                arrayList2.add(size);
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    public final q m() {
        return (q) this.streamConfigurationMapCompat.getValue();
    }

    public final List<Size> n() {
        return (List) this.supportedSizes.getValue();
    }

    public final boolean o() {
        return ((Boolean) this.isHighSpeedSupported.getValue()).booleanValue();
    }
}
