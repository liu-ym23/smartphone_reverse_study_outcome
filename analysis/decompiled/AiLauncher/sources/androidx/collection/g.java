package androidx.collection;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import kotlin.Metadata;
import v9.C5680i;
import v9.C5685n;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005JA\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001b\u001a\u00020\u00178\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b\r\u0010\u0018\u0012\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001f\u001a\u00020\u00028\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u0012\u0004\b\u001e\u0010\u001a\u0082\u0001\u0001 ¨\u0006!"}, d2 = {"Landroidx/collection/g;", "", "", "initialCapacity", "<init>", "(I)V", "", "separator", "prefix", "postfix", "limit", "truncated", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;)Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "toString", "()Ljava/lang/String;", "", "[J", "getContent$annotations", "()V", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, Const.INTENT_KEY_PKGNAME, "I", "get_size$annotations", "_size", "Landroidx/collection/m;", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public long[] content;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int _size;

    public /* synthetic */ g(int i10, kotlin.jvm.internal.i iVar) {
        this(i10);
    }

    public static /* synthetic */ String b(g gVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i11 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i11 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        CharSequence charSequence6 = charSequence3;
        return gVar.a(charSequence, charSequence2, charSequence6, i10, charSequence5);
    }

    public final String a(CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated) {
        kotlin.jvm.internal.p.i(separator, "separator");
        kotlin.jvm.internal.p.i(prefix, "prefix");
        kotlin.jvm.internal.p.i(postfix, "postfix");
        kotlin.jvm.internal.p.i(truncated, "truncated");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(prefix);
        long[] jArr = this.content;
        int i10 = this._size;
        int i11 = 0;
        while (true) {
            if (i11 >= i10) {
                sb2.append(postfix);
                break;
            }
            long j10 = jArr[i11];
            if (i11 == limit) {
                sb2.append(truncated);
                break;
            }
            if (i11 != 0) {
                sb2.append(separator);
            }
            sb2.append(j10);
            i11++;
        }
        String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return string;
    }

    public boolean equals(Object other) {
        if (other instanceof g) {
            g gVar = (g) other;
            int i10 = gVar._size;
            int i11 = this._size;
            if (i10 == i11) {
                long[] jArr = this.content;
                long[] jArr2 = gVar.content;
                C5680i c5680iS = C5685n.s(0, i11);
                int first = c5680iS.getFirst();
                int last = c5680iS.getLast();
                if (first > last) {
                    return true;
                }
                while (jArr[first] == jArr2[first]) {
                    if (first == last) {
                        return true;
                    }
                    first++;
                }
                return false;
            }
        }
        return false;
    }

    public int hashCode() {
        long[] jArr = this.content;
        int i10 = this._size;
        int iHashCode = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            iHashCode += Long.hashCode(jArr[i11]) * 31;
        }
        return iHashCode;
    }

    public String toString() {
        return b(this, null, "[", "]", 0, null, 25, null);
    }

    public g(int i10) {
        this.content = i10 == 0 ? i.a() : new long[i10];
    }
}
