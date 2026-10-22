package a8;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f239a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ String f240b;

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f239a;
        String str = this.f240b;
        switch (i) {
            case 0:
                try {
                    return ((ResourceBundle) obj).getString(str);
                } catch (MissingResourceException unused) {
                    return null;
                }
            default:
                try {
                    return ResourceBundle.getBundle(str, (Locale) obj);
                } catch (MissingResourceException unused2) {
                    return null;
                }
        }
    }
}
