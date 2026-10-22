package okhttp3.internal.publicsuffix;

import La.C0953c;
import La.H;
import Z8.C1172u;
import Z8.C1173v;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import java.net.IDN;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.sequences.SequencesKt___SequencesKt;
import okio.ByteString;
import ub.n;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0010B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "Lokhttp3/internal/publicsuffix/a;", "publicSuffixList", "<init>", "(Lokhttp3/internal/publicsuffix/a;)V", "", "domain", "c", "(Ljava/lang/String;)Ljava/lang/String;", "", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Ljava/util/List;", "domainLabels", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;)Ljava/util/List;", Const.INTENT_KEY_APIKEY, "Lokhttp3/internal/publicsuffix/a;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PublicSuffixDatabase {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final ByteString f37744c = ByteString.INSTANCE.e(42);

    /* renamed from: d, reason: collision with root package name */
    public static final List<String> f37745d = C1172u.e("*");

    /* renamed from: e, reason: collision with root package name */
    public static PublicSuffixDatabase f37746e = new PublicSuffixDatabase(b.a(a.INSTANCE));

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final a publicSuffixList;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\r\u001a\u0004\u0018\u00010\f*\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase$a;", "", "<init>", "()V", "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "c", "()Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "Lokio/ByteString;", "", "labels", "", "labelIndex", "", Const.INTENT_KEY_PKGNAME, "(Lokio/ByteString;[Lokio/ByteString;I)Ljava/lang/String;", "WILDCARD_LABEL", "Lokio/ByteString;", "", "PREVAILING_RULE", "Ljava/util/List;", "", "EXCEPTION_MARKER", "C", "instance", "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: okhttp3.internal.publicsuffix.PublicSuffixDatabase$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final String b(ByteString byteString, ByteString[] byteStringArr, int i10) {
            int i11;
            int iB;
            boolean z10;
            int iB2;
            int iK = byteString.K();
            int i12 = 0;
            while (i12 < iK) {
                int i13 = (i12 + iK) / 2;
                while (i13 > -1 && byteString.l(i13) != 10) {
                    i13--;
                }
                int i14 = i13 + 1;
                int i15 = 1;
                while (true) {
                    i11 = i14 + i15;
                    if (byteString.l(i11) == 10) {
                        break;
                    }
                    i15++;
                }
                int i16 = i11 - i14;
                int i17 = i10;
                boolean z11 = false;
                int i18 = 0;
                int i19 = 0;
                while (true) {
                    if (z11) {
                        iB = 46;
                        z10 = false;
                    } else {
                        boolean z12 = z11;
                        iB = n.b(byteStringArr[i17].l(i18), 255);
                        z10 = z12;
                    }
                    iB2 = iB - n.b(byteString.l(i14 + i19), 255);
                    if (iB2 != 0) {
                        break;
                    }
                    i19++;
                    i18++;
                    if (i19 == i16) {
                        break;
                    }
                    if (byteStringArr[i17].K() != i18) {
                        z11 = z10;
                    } else {
                        if (i17 == byteStringArr.length - 1) {
                            break;
                        }
                        i17++;
                        z11 = true;
                        i18 = -1;
                    }
                }
                if (iB2 >= 0) {
                    if (iB2 <= 0) {
                        int i20 = i16 - i19;
                        int iK2 = byteStringArr[i17].K() - i18;
                        int length = byteStringArr.length;
                        for (int i21 = i17 + 1; i21 < length; i21++) {
                            iK2 += byteStringArr[i21].K();
                        }
                        if (iK2 >= i20) {
                            if (iK2 <= i20) {
                                return byteString.N(i14, i16 + i14).M(C0953c.UTF_8);
                            }
                        }
                    }
                    i12 = i11 + 1;
                }
                iK = i13;
            }
            return null;
        }

        public final PublicSuffixDatabase c() {
            return PublicSuffixDatabase.f37746e;
        }

        public Companion() {
        }
    }

    public PublicSuffixDatabase(a publicSuffixList) {
        p.i(publicSuffixList, "publicSuffixList");
        this.publicSuffixList = publicSuffixList;
    }

    public final List<String> b(List<String> domainLabels) {
        String str;
        String strB;
        String str2;
        List<String> listM;
        List<String> listM2;
        this.publicSuffixList.b();
        int size = domainLabels.size();
        ByteString[] byteStringArr = new ByteString[size];
        for (int i10 = 0; i10 < size; i10++) {
            byteStringArr[i10] = ByteString.INSTANCE.d(domainLabels.get(i10));
        }
        int i11 = 0;
        while (true) {
            str = null;
            if (i11 >= size) {
                strB = null;
                break;
            }
            strB = INSTANCE.b(this.publicSuffixList.a(), byteStringArr, i11);
            if (strB != null) {
                break;
            }
            i11++;
        }
        if (size > 1) {
            ByteString[] byteStringArr2 = (ByteString[]) byteStringArr.clone();
            int length = byteStringArr2.length - 1;
            for (int i12 = 0; i12 < length; i12++) {
                byteStringArr2[i12] = f37744c;
                String strB2 = INSTANCE.b(this.publicSuffixList.a(), byteStringArr2, i12);
                if (strB2 != null) {
                    str2 = strB2;
                    break;
                }
            }
            str2 = null;
        } else {
            str2 = null;
        }
        if (str2 != null) {
            int i13 = size - 1;
            int i14 = 0;
            while (true) {
                if (i14 >= i13) {
                    break;
                }
                String strB3 = INSTANCE.b(this.publicSuffixList.c(), byteStringArr, i14);
                if (strB3 != null) {
                    str = strB3;
                    break;
                }
                i14++;
            }
        }
        if (str != null) {
            return H.a1('!' + str, new char[]{'.'}, false, 0, 6, null);
        }
        if (strB == null && str2 == null) {
            return f37745d;
        }
        if (strB == null || (listM = H.a1(strB, new char[]{'.'}, false, 0, 6, null)) == null) {
            listM = C1173v.m();
        }
        if (str2 == null || (listM2 = H.a1(str2, new char[]{'.'}, false, 0, 6, null)) == null) {
            listM2 = C1173v.m();
        }
        return listM.size() > listM2.size() ? listM : listM2;
    }

    public final String c(String domain) {
        int size;
        int size2;
        p.i(domain, "domain");
        String unicode = IDN.toUnicode(domain);
        p.f(unicode);
        List<String> listD = d(unicode);
        List<String> listB = b(listD);
        if (listD.size() == listB.size() && listB.get(0).charAt(0) != '!') {
            return null;
        }
        if (listB.get(0).charAt(0) == '!') {
            size = listD.size();
            size2 = listB.size();
        } else {
            size = listD.size();
            size2 = listB.size() + 1;
        }
        return SequencesKt___SequencesKt.O(SequencesKt___SequencesKt.E(F.d0(d(domain)), size - size2), ".", null, null, 0, null, null, 62, null);
    }

    public final List<String> d(String domain) {
        List<String> listA1 = H.a1(domain, new char[]{'.'}, false, 0, 6, null);
        return p.d(F.C0(listA1), "") ? F.i0(listA1, 1) : listA1;
    }
}
