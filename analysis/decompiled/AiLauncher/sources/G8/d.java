package G8;

import Yb.o;
import android.text.TextUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import u8.r;
import u8.u;

/* loaded from: classes4.dex */
public class d extends h {

    /* renamed from: a, reason: collision with root package name */
    public final a f2864a;

    public interface a {
        io.noties.markwon.image.h a(Map<String, String> map);
    }

    public d(a aVar) {
        this.f2864a = aVar;
    }

    public static d e() {
        return new d(new e(C8.b.a()));
    }

    @Override // C8.m
    public Collection<String> b() {
        return Collections.singleton("img");
    }

    @Override // G8.h
    public Object d(u8.g gVar, r rVar, C8.f fVar) {
        u uVar;
        String str = fVar.d().get("src");
        if (TextUtils.isEmpty(str) || (uVar = gVar.e().get(o.class)) == null) {
            return null;
        }
        String strB = gVar.b().b(str);
        io.noties.markwon.image.h hVarA = this.f2864a.a(fVar.d());
        io.noties.markwon.image.g.f34287a.e(rVar, strB);
        io.noties.markwon.image.g.f34289c.e(rVar, hVarA);
        io.noties.markwon.image.g.f34288b.e(rVar, Boolean.FALSE);
        return uVar.a(gVar, rVar);
    }
}
