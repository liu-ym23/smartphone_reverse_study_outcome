package androidx.room.util;

import C7.c;
import D7.v;
import androidx.annotation.RestrictTo;
import j9.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\u001a\u0013\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a!\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000e\u001a\u001f\u0010\u000f\u001a\u0004\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010\"\"\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "newStringBuilder", "()Ljava/lang/StringBuilder;", "builder", "", "count", "LC7/r;", "appendPlaceholders", "(Ljava/lang/StringBuilder;I)V", "", "input", "", "splitToIntList", "(Ljava/lang/String;)Ljava/util/List;", "joinIntoString", "(Ljava/util/List;)Ljava/lang/String;", "", "EMPTY_STRING_ARRAY", "[Ljava/lang/String;", "getEMPTY_STRING_ARRAY$annotations", "()V", "room-runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes2.dex */
public final class StringUtil {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    public static final void appendPlaceholders(StringBuilder builder, int i) {
        k.f(builder, "builder");
        for (int i6 = 0; i6 < i; i6++) {
            builder.append("?");
            if (i6 < i - 1) {
                builder.append(",");
            }
        }
    }

    @c
    public static /* synthetic */ void getEMPTY_STRING_ARRAY$annotations() {
    }

    public static final String joinIntoString(List<Integer> list) {
        if (list != null) {
            return v.I0(list, ",", null, null, null, 62);
        }
        return null;
    }

    @c
    public static final StringBuilder newStringBuilder() {
        return new StringBuilder();
    }

    public static final List<Integer> splitToIntList(String str) {
        Integer numValueOf;
        if (str == null) {
            return null;
        }
        List listE0 = m.E0(str, new char[]{','});
        ArrayList arrayList = new ArrayList();
        Iterator it = listE0.iterator();
        while (it.hasNext()) {
            try {
                numValueOf = Integer.valueOf(Integer.parseInt((String) it.next()));
            } catch (NumberFormatException unused) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                arrayList.add(numValueOf);
            }
        }
        return arrayList;
    }
}
