package androidx.core.content;

import android.content.ComponentName;
import android.net.Uri;
import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;

/* loaded from: classes2.dex */
public final /* synthetic */ class b implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1915a;
    public final /* synthetic */ String b;

    public /* synthetic */ b(String str, int i) {
        this.f1915a = i;
        this.b = str;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        int i = this.f1915a;
        String str = this.b;
        switch (i) {
            case 0:
                return IntentSanitizer.Builder.lambda$allowExtraOutput$16(str, (Uri) obj);
            case 1:
                return str.equals((String) obj);
            case 2:
                return IntentSanitizer.Builder.lambda$allowComponentWithPackage$9(str, (ComponentName) obj);
            case 3:
                return IntentSanitizer.Builder.lambda$allowDataWithAuthority$8(str, (Uri) obj);
            case 4:
                return IntentSanitizer.Builder.lambda$allowClipDataUriWithAuthority$11(str, (Uri) obj);
            default:
                return IntentSanitizer.Builder.lambda$allowExtraStreamUriWithAuthority$15(str, (Uri) obj);
        }
    }
}
