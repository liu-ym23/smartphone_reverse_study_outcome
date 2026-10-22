package u;

import D.B;
import Z8.C1172u;
import Z8.C1173v;
import android.hardware.camera2.params.DynamicRangeProfiles;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000fR(\u0010\u0013\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00110\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000f¨\u0006\u0014"}, d2 = {"Lu/c;", "", "<init>", "()V", "", "profile", "LD/B;", Const.INTENT_KEY_PKGNAME, "(J)LD/B;", "dynamicRange", "Landroid/hardware/camera2/params/DynamicRangeProfiles;", "dynamicRangeProfiles", Const.INTENT_KEY_APIKEY, "(LD/B;Landroid/hardware/camera2/params/DynamicRangeProfiles;)Ljava/lang/Long;", "", "Ljava/util/Map;", "PROFILE_TO_DR_MAP", "", "c", "DR_TO_PROFILE_MAP", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: u.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5555c {

    /* renamed from: a, reason: collision with root package name */
    public static final C5555c f42362a = new C5555c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Map<Long, B> PROFILE_TO_DR_MAP;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Map<B, List<Long>> DR_TO_PROFILE_MAP;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        PROFILE_TO_DR_MAP = linkedHashMap;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        DR_TO_PROFILE_MAP = linkedHashMap2;
        B b10 = B.f1998d;
        linkedHashMap.put(1L, b10);
        linkedHashMap2.put(b10, C1172u.e(1L));
        linkedHashMap.put(2L, B.f2000f);
        linkedHashMap2.put(linkedHashMap.get(2L), C1172u.e(2L));
        B b11 = B.f2001g;
        linkedHashMap.put(4L, b11);
        linkedHashMap2.put(b11, C1172u.e(4L));
        B b12 = B.f2002h;
        linkedHashMap.put(8L, b12);
        linkedHashMap2.put(b12, C1172u.e(8L));
        List<Long> listP = C1173v.p(64L, 128L, 16L, 32L);
        Iterator<Long> it = listP.iterator();
        while (it.hasNext()) {
            PROFILE_TO_DR_MAP.put(Long.valueOf(it.next().longValue()), B.f2003i);
        }
        DR_TO_PROFILE_MAP.put(B.f2003i, listP);
        List<Long> listP2 = C1173v.p(1024L, 2048L, 256L, 512L);
        Iterator<Long> it2 = listP2.iterator();
        while (it2.hasNext()) {
            PROFILE_TO_DR_MAP.put(Long.valueOf(it2.next().longValue()), B.f2004j);
        }
        DR_TO_PROFILE_MAP.put(B.f2004j, listP2);
    }

    public final Long a(B dynamicRange, DynamicRangeProfiles dynamicRangeProfiles) {
        p.i(dynamicRange, "dynamicRange");
        p.i(dynamicRangeProfiles, "dynamicRangeProfiles");
        List<Long> list = DR_TO_PROFILE_MAP.get(dynamicRange);
        if (list == null) {
            return null;
        }
        Set<Long> supportedProfiles = dynamicRangeProfiles.getSupportedProfiles();
        p.h(supportedProfiles, "getSupportedProfiles(...)");
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            if (supportedProfiles.contains(Long.valueOf(jLongValue))) {
                return Long.valueOf(jLongValue);
            }
        }
        return null;
    }

    public final B b(long profile) {
        return PROFILE_TO_DR_MAP.get(Long.valueOf(profile));
    }
}
