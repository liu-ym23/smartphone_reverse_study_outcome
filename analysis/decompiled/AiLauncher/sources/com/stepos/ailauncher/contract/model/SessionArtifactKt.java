package com.stepos.ailauncher.contract.model;

import La.H;
import Z8.C1174w;
import Z8.F;
import b9.b;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.contract.model.SessionArtifactKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u001a\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\t*\b\u0012\u0004\u0012\u00020\u00020\t\u001a\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t*\b\u0012\u0004\u0012\u00020\u00020\t\u001a\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\t*\b\u0012\u0004\u0012\u00020\u00020\t\u001a \u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t*\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\r\u001a\u00020\u0001\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\u000e"}, d2 = {"productKey", "", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "getProductKey", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;)Ljava/lang/String;", "isImageArtifact", "", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;)Z", "groupByProduct", "", "latestProducts", "latestFileProducts", "versionGroupOf", "fileId", "contract_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SessionArtifactKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String _get_isImageArtifact_$lambda$1(String it) {
        p.i(it, "it");
        return H.w1(H.w1(it, '?', null, 2, null), '#', null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _get_isImageArtifact_$lambda$2(String it) {
        p.i(it, "it");
        String lowerCase = H.q1(it, '.', "").toLowerCase(Locale.ROOT);
        p.h(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public static final String getProductKey(SessionArtifact sessionArtifact) {
        p.i(sessionArtifact, "<this>");
        String cloudPath = sessionArtifact.getCloudPath();
        if (cloudPath != null || (cloudPath = sessionArtifact.getFileName()) != null) {
            return cloudPath;
        }
        String fileId = sessionArtifact.getFileId();
        return fileId == null ? "" : fileId;
    }

    public static final List<List<SessionArtifact>> groupByProduct(List<SessionArtifact> list) {
        p.i(list, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            String productKey = getProductKey((SessionArtifact) obj);
            Object arrayList = linkedHashMap.get(productKey);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(productKey, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        Collection collectionValues = linkedHashMap.values();
        ArrayList arrayList2 = new ArrayList(C1174w.x(collectionValues, 10));
        Iterator it = collectionValues.iterator();
        while (it.hasNext()) {
            arrayList2.add(F.c1((List) it.next(), new Comparator() { // from class: com.stepos.ailauncher.contract.model.SessionArtifactKt$groupByProduct$lambda$1$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t10, T t11) {
                    return b.d(Long.valueOf(((SessionArtifact) t10).getCreatedAt()), Long.valueOf(((SessionArtifact) t11).getCreatedAt()));
                }
            }));
        }
        return F.c1(arrayList2, new Comparator() { // from class: com.stepos.ailauncher.contract.model.SessionArtifactKt$groupByProduct$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                return b.d(Long.valueOf(((SessionArtifact) F.C0((List) t11)).getCreatedAt()), Long.valueOf(((SessionArtifact) F.C0((List) t10)).getCreatedAt()));
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean isImageArtifact(com.stepos.ailauncher.contract.model.SessionArtifact r13) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.p.i(r13, r0)
            java.lang.String r0 = r13.getMimeType()
            r1 = 2
            r2 = 0
            if (r0 == 0) goto L34
            r3 = 59
            java.lang.String r0 = La.H.w1(r0, r3, r2, r1, r2)
            if (r0 == 0) goto L34
            java.lang.CharSequence r0 = La.H.D1(r0)
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L34
            java.util.Locale r3 = java.util.Locale.ROOT
            java.lang.String r0 = r0.toLowerCase(r3)
            java.lang.String r3 = "toLowerCase(...)"
            kotlin.jvm.internal.p.h(r0, r3)
            if (r0 == 0) goto L34
            int r3 = r0.length()
            if (r3 <= 0) goto L34
            goto L35
        L34:
            r0 = r2
        L35:
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L42
            java.lang.String r5 = "image/"
            boolean r0 = La.D.X(r0, r5, r3, r1, r2)
            if (r0 != r4) goto L42
            return r4
        L42:
            java.lang.String r11 = "svg"
            java.lang.String r12 = "heic"
            java.lang.String r5 = "png"
            java.lang.String r6 = "jpg"
            java.lang.String r7 = "jpeg"
            java.lang.String r8 = "gif"
            java.lang.String r9 = "webp"
            java.lang.String r10 = "bmp"
            java.lang.String[] r0 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11, r12}
            java.util.Set r0 = Z8.Y.j(r0)
            java.lang.String r1 = r13.getFileName()
            java.lang.String r2 = r13.getTitle()
            java.lang.String r13 = r13.getName()
            java.lang.String[] r13 = new java.lang.String[]{r1, r2, r13}
            Ka.j r13 = Ka.t.w(r13)
            Ka.j r13 = kotlin.sequences.SequencesKt___SequencesKt.H(r13)
            G5.a r1 = new G5.a
            r1.<init>()
            Ka.j r13 = kotlin.sequences.SequencesKt___SequencesKt.R(r13, r1)
            G5.b r1 = new G5.b
            r1.<init>()
            Ka.j r13 = kotlin.sequences.SequencesKt___SequencesKt.R(r13, r1)
            java.util.Iterator r13 = r13.iterator()
        L8b:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L9e
            java.lang.Object r1 = r13.next()
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto L8b
            return r4
        L9e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.contract.model.SessionArtifactKt.isImageArtifact(com.stepos.ailauncher.contract.model.SessionArtifact):boolean");
    }

    public static final List<SessionArtifact> latestFileProducts(List<SessionArtifact> list) {
        p.i(list, "<this>");
        return latestProducts(SequencesKt___SequencesKt.d0(SequencesKt___SequencesKt.G(F.d0(list), new InterfaceC5074l() { // from class: G5.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SessionArtifactKt.latestFileProducts$lambda$0((SessionArtifact) obj));
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean latestFileProducts$lambda$0(SessionArtifact it) {
        p.i(it, "it");
        return isImageArtifact(it);
    }

    public static final List<SessionArtifact> latestProducts(List<SessionArtifact> list) {
        p.i(list, "<this>");
        List<List<SessionArtifact>> listGroupByProduct = groupByProduct(list);
        ArrayList arrayList = new ArrayList(C1174w.x(listGroupByProduct, 10));
        Iterator<T> it = listGroupByProduct.iterator();
        while (it.hasNext()) {
            arrayList.add((SessionArtifact) F.C0((List) it.next()));
        }
        return arrayList;
    }

    public static final List<SessionArtifact> versionGroupOf(List<SessionArtifact> list, String fileId) {
        Object next;
        p.i(list, "<this>");
        p.i(fileId, "fileId");
        Iterator<T> it = groupByProduct(list).iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            List list2 = (List) next;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (p.d(((SessionArtifact) it2.next()).getFileId(), fileId)) {
                        break loop0;
                    }
                }
            }
        }
        return (List) next;
    }
}
