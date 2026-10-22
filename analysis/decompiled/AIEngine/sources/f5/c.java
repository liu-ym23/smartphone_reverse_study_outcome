package f5;

import com.google.gson.JsonIOException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c implements g<Object> {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f8740g;

    public c(String str) {
        this.f8740g = str;
    }

    @Override // f5.g
    public final Object c() {
        throw new JsonIOException(this.f8740g);
    }
}
