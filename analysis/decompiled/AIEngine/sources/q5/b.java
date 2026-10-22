package q5;

import com.scp.moderation.keyword.model.MatchMode;
import com.scp.moderation.keyword.model.MatchType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f11622a;

    /* renamed from: b, reason: collision with root package name */
    public final MatchMode f11623b;

    /* renamed from: c, reason: collision with root package name */
    public final List<String> f11624c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11625d;

    /* renamed from: e, reason: collision with root package name */
    public final long f11626e;

    /* renamed from: f, reason: collision with root package name */
    public final Set<MatchType> f11627f;

    public b(String str, MatchMode matchMode, ArrayList arrayList, String str2, long j10, String str3) {
        MatchType matchType;
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("word content must not be blank");
        }
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("word tagIds must not be empty");
        }
        if (new HashSet(arrayList).size() != arrayList.size()) {
            throw new IllegalArgumentException("word tagIds must not contain duplicates");
        }
        if (str2 == null || str2.trim().isEmpty()) {
            throw new IllegalArgumentException("wordId must not be blank");
        }
        if (j10 <= 0) {
            throw new IllegalArgumentException("tableId must be greater than zero");
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i10 = 0;
        for (String str4 : str3.split(",", -1)) {
            String strTrim = str4.trim();
            if (!strTrim.isEmpty()) {
                linkedHashSet.add(strTrim);
                i10++;
            }
        }
        if (linkedHashSet.isEmpty()) {
            throw new IllegalArgumentException("matchType must contain at least one code");
        }
        if (linkedHashSet.size() != i10) {
            throw new IllegalArgumentException("matchType must not contain duplicate codes");
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            String str5 = (String) it.next();
            MatchType[] matchTypeArrValues = MatchType.values();
            int length = matchTypeArrValues.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    matchType = null;
                    break;
                }
                matchType = matchTypeArrValues[i11];
                if (matchType.f5556a.equals(str5)) {
                    break;
                } else {
                    i11++;
                }
            }
            if (matchType == null) {
                throw new IllegalArgumentException(ai.onnxruntime.a.k("unsupported matchType code: ", str5));
            }
            linkedHashSet2.add(matchType);
        }
        if (matchMode == MatchMode.f5551c && (linkedHashSet2.size() != 1 || !linkedHashSet2.contains(MatchType.SIMPLE))) {
            throw new IllegalArgumentException("REGEX only supports SIMPLE matchType");
        }
        this.f11622a = str;
        this.f11623b = matchMode;
        this.f11624c = Collections.unmodifiableList(new ArrayList(arrayList));
        this.f11625d = str2;
        this.f11626e = j10;
        this.f11627f = Collections.unmodifiableSet(linkedHashSet2);
    }
}
