package h3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.tls.CertificateChainCleaner;

/* renamed from: h3.m, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0604m extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0605n f12934a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f12935b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f12936c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0604m(C0605n c0605n, List list, String str) {
        super(0);
        this.f12934a = c0605n;
        this.f12935b = list;
        this.f12936c = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        CertificateChainCleaner certificateChainCleaner = this.f12934a.f12939b;
        List<Certificate> list = this.f12935b;
        List<Certificate> listClean = certificateChainCleaner == null ? null : certificateChainCleaner.clean(list, this.f12936c);
        if (listClean != null) {
            list = listClean;
        }
        List<Certificate> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.e(list2));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add((X509Certificate) ((Certificate) it.next()));
        }
        return arrayList;
    }
}
