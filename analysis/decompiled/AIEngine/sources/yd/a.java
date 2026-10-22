package yd;

import ad.t;
import androidx.appcompat.widget.l;
import com.google.gson.reflect.TypeToken;
import d5.i;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import xd.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends f.a {

    /* renamed from: a, reason: collision with root package name */
    public final i f14209a;

    public a(i iVar) {
        this.f14209a = iVar;
    }

    @Override // xd.f.a
    public final f a(Type type) {
        TypeToken<?> typeToken = TypeToken.get(type);
        i iVar = this.f14209a;
        return new b(iVar, iVar.e(typeToken));
    }

    @Override // xd.f.a
    public final f<t, ?> b(Type type, Annotation[] annotationArr, xd.t tVar) {
        TypeToken<?> typeToken = TypeToken.get(type);
        i iVar = this.f14209a;
        return new l(iVar, iVar.e(typeToken));
    }
}
