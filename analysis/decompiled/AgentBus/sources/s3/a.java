package s3;

import com.stepos.cloud.securedata.http.SecureDataHttpClient;
import g7.d;
import i7.c;

/* loaded from: classes.dex */
public final class a extends c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f9475f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ SecureDataHttpClient f9476g;

    /* renamed from: h, reason: collision with root package name */
    public int f9477h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(SecureDataHttpClient secureDataHttpClient, d dVar) {
        super(dVar);
        this.f9476g = secureDataHttpClient;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f9475f = obj;
        this.f9477h |= Integer.MIN_VALUE;
        return this.f9476g.a((String) null, (String) null, this);
    }
}
