package androidx.compose.ui.text;

import S7.o;
import androidx.compose.ui.text.intl.LocaleList;

/* loaded from: classes2.dex */
public final /* synthetic */ class a implements o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1896a;
    public final /* synthetic */ LocaleList b;

    public /* synthetic */ a(int i, LocaleList localeList) {
        this.f1896a = i;
        this.b = localeList;
    }

    @Override // S7.o
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i = this.f1896a;
        String str = (String) obj;
        int iIntValue = ((Integer) obj2).intValue();
        int iIntValue2 = ((Integer) obj3).intValue();
        LocaleList localeList = this.b;
        switch (i) {
            case 0:
                return AnnotatedStringKt.decapitalize$lambda$15(localeList, str, iIntValue, iIntValue2);
            case 1:
                return AnnotatedStringKt.capitalize$lambda$14(localeList, str, iIntValue, iIntValue2);
            case 2:
                return AnnotatedStringKt.toUpperCase$lambda$12(localeList, str, iIntValue, iIntValue2);
            default:
                return AnnotatedStringKt.toLowerCase$lambda$13(localeList, str, iIntValue, iIntValue2);
        }
    }
}
