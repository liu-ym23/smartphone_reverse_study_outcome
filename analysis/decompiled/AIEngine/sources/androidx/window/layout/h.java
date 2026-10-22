package androidx.window.layout;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import androidx.window.core.SpecificationComputer;
import androidx.window.layout.f;
import androidx.window.layout.g;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.EmptyList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f2742b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final SpecificationComputer.VerificationMode f2743a = SpecificationComputer.VerificationMode.f2680a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        @SuppressLint({"BanUncheckedReflection"})
        public static int a(SidecarDeviceState sidecarDeviceState) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            kotlin.jvm.internal.g.f(sidecarDeviceState, "sidecarDeviceState");
            try {
                try {
                    return sidecarDeviceState.posture;
                } catch (NoSuchFieldError unused) {
                    Object objInvoke = SidecarDeviceState.class.getMethod("getPosture", null).invoke(sidecarDeviceState, null);
                    if (objInvoke != null) {
                        return ((Integer) objInvoke).intValue();
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return 0;
            }
        }

        public static int b(SidecarDeviceState sidecarDeviceState) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            kotlin.jvm.internal.g.f(sidecarDeviceState, "sidecarDeviceState");
            int iA = a(sidecarDeviceState);
            if (iA < 0 || iA > 4) {
                return 0;
            }
            return iA;
        }

        @SuppressLint({"BanUncheckedReflection"})
        public static List c(SidecarWindowLayoutInfo info) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            kotlin.jvm.internal.g.f(info, "info");
            try {
                try {
                    List list = info.displayFeatures;
                    return list == null ? EmptyList.f10001a : list;
                } catch (NoSuchFieldError unused) {
                    Object objInvoke = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", null).invoke(info, null);
                    if (objInvoke != null) {
                        return (List) objInvoke;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return EmptyList.f10001a;
            }
        }

        @SuppressLint({"BanUncheckedReflection"})
        public static void d(SidecarDeviceState sidecarDeviceState, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                try {
                    sidecarDeviceState.posture = i10;
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                }
            } catch (NoSuchFieldError unused2) {
                SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, Integer.valueOf(i10));
            }
        }
    }

    public h(int i10) {
    }

    public static boolean a(SidecarDisplayFeature sidecarDisplayFeature, SidecarDisplayFeature sidecarDisplayFeature2) {
        if (kotlin.jvm.internal.g.b(sidecarDisplayFeature, sidecarDisplayFeature2)) {
            return true;
        }
        if (sidecarDisplayFeature == null || sidecarDisplayFeature2 == null || sidecarDisplayFeature.getType() != sidecarDisplayFeature2.getType()) {
            return false;
        }
        return kotlin.jvm.internal.g.b(sidecarDisplayFeature.getRect(), sidecarDisplayFeature2.getRect());
    }

    public static boolean b(List list, List list2) {
        if (list == list2) {
            return true;
        }
        if (list != null && list2 != null && list.size() == list2.size()) {
            int size = list.size();
            int i10 = 0;
            while (i10 < size) {
                int i11 = i10 + 1;
                if (a((SidecarDisplayFeature) list.get(i10), (SidecarDisplayFeature) list2.get(i10))) {
                    i10 = i11;
                }
            }
            return true;
        }
        return false;
    }

    public final m c(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarDeviceState sidecarDeviceState) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (sidecarWindowLayoutInfo == null) {
            return new m(EmptyList.f10001a);
        }
        SidecarDeviceState sidecarDeviceState2 = new SidecarDeviceState();
        a.d(sidecarDeviceState2, a.b(sidecarDeviceState));
        return new m(d(a.c(sidecarWindowLayoutInfo), sidecarDeviceState2));
    }

    public final ArrayList d(List sidecarDisplayFeatures, SidecarDeviceState sidecarDeviceState) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        kotlin.jvm.internal.g.f(sidecarDisplayFeatures, "sidecarDisplayFeatures");
        ArrayList arrayList = new ArrayList();
        Iterator it = sidecarDisplayFeatures.iterator();
        while (it.hasNext()) {
            g gVarE = e((SidecarDisplayFeature) it.next(), sidecarDeviceState);
            if (gVarE != null) {
                arrayList.add(gVarE);
            }
        }
        return arrayList;
    }

    public final g e(SidecarDisplayFeature feature, SidecarDeviceState sidecarDeviceState) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        g.a aVar;
        f.b bVar;
        kotlin.jvm.internal.g.f(feature, "feature");
        SpecificationComputer.VerificationMode verificationMode = this.f2743a;
        kotlin.jvm.internal.g.f(verificationMode, "verificationMode");
        SidecarDisplayFeature sidecarDisplayFeature = (SidecarDisplayFeature) new g2.d(feature, verificationMode, g2.a.f8950a).c("Type must be either TYPE_FOLD or TYPE_HINGE", new zb.l<SidecarDisplayFeature, Boolean>() { // from class: androidx.window.layout.SidecarAdapter$translate$checkedFeature$1
            @Override // zb.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(SidecarDisplayFeature require) {
                kotlin.jvm.internal.g.f(require, "$this$require");
                boolean z = true;
                if (require.getType() != 1 && require.getType() != 2) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }).c("Feature bounds must not be 0", new zb.l<SidecarDisplayFeature, Boolean>() { // from class: androidx.window.layout.SidecarAdapter$translate$checkedFeature$2
            @Override // zb.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(SidecarDisplayFeature require) {
                kotlin.jvm.internal.g.f(require, "$this$require");
                return Boolean.valueOf((require.getRect().width() == 0 && require.getRect().height() == 0) ? false : true);
            }
        }).c("TYPE_FOLD must have 0 area", new zb.l<SidecarDisplayFeature, Boolean>() { // from class: androidx.window.layout.SidecarAdapter$translate$checkedFeature$3
            @Override // zb.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(SidecarDisplayFeature require) {
                kotlin.jvm.internal.g.f(require, "$this$require");
                boolean z = true;
                if (require.getType() == 1 && require.getRect().width() != 0 && require.getRect().height() != 0) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }).c("Feature be pinned to either left or top", new zb.l<SidecarDisplayFeature, Boolean>() { // from class: androidx.window.layout.SidecarAdapter$translate$checkedFeature$4
            @Override // zb.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(SidecarDisplayFeature require) {
                kotlin.jvm.internal.g.f(require, "$this$require");
                return Boolean.valueOf(require.getRect().left == 0 || require.getRect().top == 0);
            }
        }).a();
        if (sidecarDisplayFeature == null) {
            return null;
        }
        int type = sidecarDisplayFeature.getType();
        if (type == 1) {
            aVar = g.a.f2739b;
        } else {
            if (type != 2) {
                return null;
            }
            aVar = g.a.f2740c;
        }
        int iB = a.b(sidecarDeviceState);
        if (iB == 0 || iB == 1) {
            return null;
        }
        if (iB != 2) {
            bVar = f.b.f2733b;
            if (iB != 3 && iB == 4) {
                return null;
            }
        } else {
            bVar = f.b.f2734c;
        }
        Rect rect = feature.getRect();
        kotlin.jvm.internal.g.e(rect, "feature.rect");
        return new g(new g2.b(rect), aVar, bVar);
    }
}
