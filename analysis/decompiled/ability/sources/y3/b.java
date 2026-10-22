package y3;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import u1.d;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6894a;
    public final /* synthetic */ d b;
    public final /* synthetic */ Locale c;

    public /* synthetic */ b(d dVar, Locale locale, int i) {
        this.f6894a = i;
        this.b = dVar;
        this.c = locale;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        final String str = (String) obj;
        switch (this.f6894a) {
            case 0:
                d dVar = this.b;
                final int i = 0;
                return (String) ((List) dVar.e).stream().map(new b(dVar, this.c, 1)).filter(new S6.c(15)).map(new Function() { // from class: y3.c
                    @Override // java.util.function.Function
                    public final Object apply(Object obj2) {
                        int i6 = i;
                        String str2 = str;
                        switch (i6) {
                            case 0:
                                try {
                                    return ((ResourceBundle) obj2).getString(str2);
                                } catch (MissingResourceException unused) {
                                    return null;
                                }
                            default:
                                try {
                                    return ResourceBundle.getBundle(str2, (Locale) obj2);
                                } catch (MissingResourceException unused2) {
                                    return null;
                                }
                        }
                    }
                }).filter(new S6.c(16)).findFirst().orElse("");
            default:
                final int i6 = 1;
                return (ResourceBundle) ((Map) ((ConcurrentHashMap) this.b.b).computeIfAbsent(str, new reactor.util.retry.a(6))).computeIfAbsent(this.c, new Function() { // from class: y3.c
                    @Override // java.util.function.Function
                    public final Object apply(Object obj2) {
                        int i62 = i6;
                        String str2 = str;
                        switch (i62) {
                            case 0:
                                try {
                                    return ((ResourceBundle) obj2).getString(str2);
                                } catch (MissingResourceException unused) {
                                    return null;
                                }
                            default:
                                try {
                                    return ResourceBundle.getBundle(str2, (Locale) obj2);
                                } catch (MissingResourceException unused2) {
                                    return null;
                                }
                        }
                    }
                });
        }
    }
}
