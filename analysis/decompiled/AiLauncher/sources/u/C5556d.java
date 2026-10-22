package u;

import D.B;
import D.C0761b0;
import Z8.F;
import Z8.r;
import android.hardware.camera2.CameraCharacteristics;
import android.util.Log;
import androidx.camera.core.impl.z;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p.C5027i;
import t.C5473b;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0017\u0018\u00002\u00020\u0001:\u00019B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJK\u0010\u0012\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0010\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\u0004\b\u0012\u0010\u0013JU\u0010\u001b\u001a\u00020\u00112\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u00142\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJK\u0010!\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001d\u001a\u00020\u00112\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u00142\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J-\u0010'\u001a\u00020&2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u00192\u0006\u0010#\u001a\u00020\u00112\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b'\u0010(J5\u0010-\u001a\u0004\u0018\u00010\u00112\u0006\u0010)\u001a\u00020\u00112\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00110*2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0011H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0011H\u0002¢\u0006\u0004\b2\u00101J-\u00105\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u00112\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014H\u0002¢\u0006\u0004\b5\u00106J\u001f\u00109\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u0011H\u0002¢\u0006\u0004\b9\u0010:R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b9\u0010;\u001a\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010>R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010@¨\u0006A"}, d2 = {"Lu/d;", "", "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "<init>", "(Landroidx/camera/camera2/pipe/g;)V", "", Const.INTENT_KEY_UMID, "()Z", "", "Landroidx/camera/core/impl/b;", "existingSurfaces", "Landroidx/camera/core/impl/z;", "newUseCaseConfigs", "", "useCasePriorityOrder", "", "LD/B;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)Ljava/util/Map;", "", "supportedDynamicRanges", "orderedExistingDynamicRanges", "orderedNewDynamicRanges", "config", "", "outCombinedConstraints", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Landroidx/camera/core/impl/z;Ljava/util/Set;)LD/B;", "requestedDynamicRange", "combinedConstraints", "", "rangeOwnerLabel", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(LD/B;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/lang/String;)LD/B;", "newDynamicRange", "Lp/i;", "dynamicRangesInfo", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/util/Set;LD/B;Lp/i;)V", "rangeToMatch", "", "fullySpecifiedCandidateRanges", "constraints", "c", "(LD/B;Ljava/util/Collection;Ljava/util/Set;)LD/B;", "dynamicRange", "e", "(LD/B;)Z", "f", "rangeToResolve", "candidateRange", Const.INTENT_KEY_PKGNAME, "(LD/B;LD/B;Ljava/util/Set;)Z", "testRange", "fullySpecifiedRange", Const.INTENT_KEY_APIKEY, "(LD/B;LD/B;)Z", "Landroidx/camera/camera2/pipe/g;", "getCameraMetadata", "()Landroidx/camera/camera2/pipe/g;", "Z", "is10BitSupported", "Lp/i;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: u.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5556d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.g cameraMetadata;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean is10BitSupported;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final C5027i dynamicRangesInfo;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lu/d$a;", "", "<init>", "()V", "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "LD/B;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/g;)LD/B;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: u.d$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f42368a = new a();

        public final B a(androidx.camera.camera2.pipe.g cameraMetadata) {
            p.i(cameraMetadata, "cameraMetadata");
            CameraCharacteristics.Key REQUEST_RECOMMENDED_TEN_BIT_DYNAMIC_RANGE_PROFILE = CameraCharacteristics.REQUEST_RECOMMENDED_TEN_BIT_DYNAMIC_RANGE_PROFILE;
            p.h(REQUEST_RECOMMENDED_TEN_BIT_DYNAMIC_RANGE_PROFILE, "REQUEST_RECOMMENDED_TEN_BIT_DYNAMIC_RANGE_PROFILE");
            Long l10 = (Long) cameraMetadata.e0(REQUEST_RECOMMENDED_TEN_BIT_DYNAMIC_RANGE_PROFILE);
            if (l10 != null) {
                return C5555c.f42362a.b(l10.longValue());
            }
            return null;
        }
    }

    public C5556d(androidx.camera.camera2.pipe.g cameraMetadata) {
        p.i(cameraMetadata, "cameraMetadata");
        this.cameraMetadata = cameraMetadata;
        CameraCharacteristics.Key REQUEST_AVAILABLE_CAPABILITIES = CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES;
        p.h(REQUEST_AVAILABLE_CAPABILITIES, "REQUEST_AVAILABLE_CAPABILITIES");
        int[] iArr = (int[]) cameraMetadata.e0(REQUEST_AVAILABLE_CAPABILITIES);
        this.is10BitSupported = iArr != null ? r.P(iArr, 18) : false;
        this.dynamicRangesInfo = C5027i.INSTANCE.a(cameraMetadata);
    }

    public final boolean a(B testRange, B fullySpecifiedRange) {
        if (!fullySpecifiedRange.e()) {
            throw new IllegalStateException(("Fully specified range " + fullySpecifiedRange + " not actually fully specified.").toString());
        }
        if (testRange.b() == 2 && fullySpecifiedRange.b() == 1) {
            return false;
        }
        if (testRange.b() == 2 || testRange.b() == 0 || testRange.b() == fullySpecifiedRange.b()) {
            return testRange.a() == 0 || testRange.a() == fullySpecifiedRange.a();
        }
        return false;
    }

    public final boolean b(B rangeToResolve, B candidateRange, Set<B> constraints) {
        if (constraints.contains(candidateRange)) {
            return a(rangeToResolve, candidateRange);
        }
        C5473b c5473b = C5473b.f41865a;
        if (!C0761b0.f("CXCP")) {
            return false;
        }
        Log.d(C5473b.TRUNCATED_TAG, "DynamicRangeResolver: Candidate Dynamic range is not within constraints.\nDynamic range to resolve:\n  " + rangeToResolve + "\nCandidate dynamic range:\n  " + candidateRange);
        return false;
    }

    public final B c(B rangeToMatch, Collection<B> fullySpecifiedCandidateRanges, Set<B> constraints) {
        if (rangeToMatch.b() == 1) {
            return null;
        }
        for (B b10 : fullySpecifiedCandidateRanges) {
            int iB = b10.b();
            if (!b10.e()) {
                throw new IllegalStateException("Fully specified DynamicRange must have fully defined encoding.");
            }
            if (iB != 1 && b(rangeToMatch, b10, constraints)) {
                return b10;
            }
        }
        return null;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIs10BitSupported() {
        return this.is10BitSupported;
    }

    public final boolean e(B dynamicRange) {
        return p.d(dynamicRange, B.f1997c);
    }

    public final boolean f(B dynamicRange) {
        if (dynamicRange.b() == 2) {
            return true;
        }
        if (dynamicRange.b() == 0 || dynamicRange.a() != 0) {
            return dynamicRange.b() == 0 && dynamicRange.a() != 0;
        }
        return true;
    }

    public final Map<z<?>, B> g(List<? extends androidx.camera.core.impl.b> existingSurfaces, List<? extends z<?>> newUseCaseConfigs, List<Integer> useCasePriorityOrder) {
        p.i(existingSurfaces, "existingSurfaces");
        p.i(newUseCaseConfigs, "newUseCaseConfigs");
        p.i(useCasePriorityOrder, "useCasePriorityOrder");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<? extends androidx.camera.core.impl.b> it = existingSurfaces.iterator();
        while (it.hasNext()) {
            B bD = it.next().d();
            p.h(bD, "getDynamicRange(...)");
            linkedHashSet.add(bD);
        }
        Set<B> setB = this.dynamicRangesInfo.b();
        Set<B> setQ1 = F.q1(setB);
        Iterator<B> it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            j(setQ1, it2.next(), this.dynamicRangesInfo);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<Integer> it3 = useCasePriorityOrder.iterator();
        while (it3.hasNext()) {
            z<?> zVar = newUseCaseConfigs.get(it3.next().intValue());
            B bK = zVar.K();
            p.h(bK, "getDynamicRange(...)");
            if (e(bK)) {
                arrayList3.add(zVar);
            } else if (f(bK)) {
                arrayList2.add(zVar);
            } else {
                arrayList.add(zVar);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        ArrayList<z<?>> arrayList4 = new ArrayList();
        arrayList4.addAll(arrayList);
        arrayList4.addAll(arrayList2);
        arrayList4.addAll(arrayList3);
        for (z<?> zVar2 : arrayList4) {
            C5556d c5556d = this;
            B bI = c5556d.i(setB, linkedHashSet, linkedHashSet2, zVar2, setQ1);
            linkedHashMap.put(zVar2, bI);
            if (!linkedHashSet.contains(bI)) {
                linkedHashSet2.add(bI);
            }
            this = c5556d;
        }
        return linkedHashMap;
    }

    public final B h(B requestedDynamicRange, Set<B> combinedConstraints, Set<B> orderedExistingDynamicRanges, Set<B> orderedNewDynamicRanges, String rangeOwnerLabel) {
        if (requestedDynamicRange.e()) {
            if (combinedConstraints.contains(requestedDynamicRange)) {
                return requestedDynamicRange;
            }
            return null;
        }
        int iB = requestedDynamicRange.b();
        int iA = requestedDynamicRange.a();
        if (iB == 1 && iA == 0) {
            B b10 = B.f1998d;
            if (combinedConstraints.contains(b10)) {
                return b10;
            }
            return null;
        }
        B bC = c(requestedDynamicRange, orderedExistingDynamicRanges, combinedConstraints);
        if (bC != null) {
            C5473b c5473b = C5473b.f41865a;
            if (C0761b0.f("CXCP")) {
                Log.d(C5473b.TRUNCATED_TAG, "DynamicRangeResolver: Resolved dynamic range for use case " + rangeOwnerLabel + " from existing attached surface.\n" + requestedDynamicRange + "\n->\n" + bC);
            }
            return bC;
        }
        B bC2 = c(requestedDynamicRange, orderedNewDynamicRanges, combinedConstraints);
        if (bC2 != null) {
            C5473b c5473b2 = C5473b.f41865a;
            if (C0761b0.f("CXCP")) {
                Log.d(C5473b.TRUNCATED_TAG, "DynamicRangeResolver: Resolved dynamic range for use case " + rangeOwnerLabel + " from concurrently bound use case.\n" + requestedDynamicRange + "\n->\n" + bC2);
            }
            return bC2;
        }
        B SDR = B.f1998d;
        p.h(SDR, "SDR");
        if (b(requestedDynamicRange, SDR, combinedConstraints)) {
            C5473b c5473b3 = C5473b.f41865a;
            if (C0761b0.f("CXCP")) {
                Log.d(C5473b.TRUNCATED_TAG, "DynamicRangeResolver: Resolved dynamic range for use case " + rangeOwnerLabel + " to no compatible HDR dynamic ranges.\n" + requestedDynamicRange + "\n->\n" + SDR);
            }
            return SDR;
        }
        if (iB == 2 && (iA == 10 || iA == 0)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            B bA = a.f42368a.a(this.cameraMetadata);
            if (bA != null) {
                linkedHashSet.add(bA);
            }
            B HLG_10_BIT = B.f2000f;
            p.h(HLG_10_BIT, "HLG_10_BIT");
            linkedHashSet.add(HLG_10_BIT);
            B bC3 = c(requestedDynamicRange, linkedHashSet, combinedConstraints);
            if (bC3 != null) {
                C5473b c5473b4 = C5473b.f41865a;
                if (C0761b0.f("CXCP")) {
                    String str = C5473b.TRUNCATED_TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("DynamicRangeResolver: Resolved dynamic range for use case ");
                    sb2.append(rangeOwnerLabel);
                    sb2.append("from ");
                    sb2.append(p.d(bC3, bA) ? "recommended" : "required");
                    sb2.append(" 10-bit supported dynamic range.\n");
                    sb2.append(requestedDynamicRange);
                    sb2.append("\n->\n");
                    sb2.append(bC3);
                    Log.d(str, sb2.toString());
                }
                return bC3;
            }
        }
        for (B b11 : combinedConstraints) {
            if (!b11.e()) {
                throw new IllegalStateException("Candidate dynamic range must be fully specified.");
            }
            if (!p.d(b11, B.f1998d) && a(requestedDynamicRange, b11)) {
                C5473b c5473b5 = C5473b.f41865a;
                if (C0761b0.f("CXCP")) {
                    Log.d(C5473b.TRUNCATED_TAG, "DynamicRangeResolver: Resolved dynamic range for use case " + rangeOwnerLabel + " from validated dynamic range constraints or supported HDR dynamic ranges.\n" + requestedDynamicRange + "\n->\n" + b11);
                }
                return b11;
            }
        }
        return null;
    }

    public final B i(Set<B> supportedDynamicRanges, Set<B> orderedExistingDynamicRanges, Set<B> orderedNewDynamicRanges, z<?> config, Set<B> outCombinedConstraints) {
        B bK = config.K();
        p.h(bK, "getDynamicRange(...)");
        String strZ = config.Z();
        p.h(strZ, "getTargetName(...)");
        B bH = h(bK, outCombinedConstraints, orderedExistingDynamicRanges, orderedNewDynamicRanges, strZ);
        if (bH != null) {
            j(outCombinedConstraints, bH, this.dynamicRangesInfo);
            return bH;
        }
        throw new IllegalArgumentException("Unable to resolve supported dynamic range. The dynamic range may not be supported on the device or may not be allowed concurrently with other attached use cases.\nUse case:\n  " + config.Z() + "\nRequested dynamic range:\n  " + bK + "\nSupported dynamic ranges:\n  " + supportedDynamicRanges + "\nConstrained set of concurrent dynamic ranges:\n  " + outCombinedConstraints);
    }

    public final void j(Set<B> combinedConstraints, B newDynamicRange, C5027i dynamicRangesInfo) {
        B0.h.i(!combinedConstraints.isEmpty(), "Cannot update already-empty constraints.");
        Set<B> setA = dynamicRangesInfo.a(newDynamicRange);
        Set<B> set = setA;
        if (set.isEmpty()) {
            return;
        }
        Set setR1 = F.r1(combinedConstraints);
        combinedConstraints.retainAll(set);
        if (combinedConstraints.isEmpty()) {
            throw new IllegalArgumentException(("Constraints of dynamic range cannot be combined with existing constraints.\nDynamic range:\n  " + newDynamicRange + "\nConstraints:\n  " + setA + "\nExisting constraints:\n  " + setR1).toString());
        }
    }
}
