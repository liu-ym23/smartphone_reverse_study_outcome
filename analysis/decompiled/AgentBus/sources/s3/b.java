package s3;

import com.stepos.cloud.securedata.http.SecureDataHttpClient;
import g7.d;
import i7.c;

/* loaded from: classes.dex */
public final class b extends c {

    /* renamed from: f, reason: collision with root package name */
    public SecureDataHttpClient f9478f;

    /* renamed from: g, reason: collision with root package name */
    public String f9479g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f9480h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ SecureDataHttpClient f9481i;

    /* renamed from: j, reason: collision with root package name */
    public int f9482j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(SecureDataHttpClient secureDataHttpClient, d dVar) {
        super(dVar);
        this.f9481i = secureDataHttpClient;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f9480h = obj;
        this.f9482j |= Integer.MIN_VALUE;
        return this.f9481i.post(null, null, this);
    }
}
