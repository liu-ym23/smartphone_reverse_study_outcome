package androidx.compose.ui.text.font;

import S7.k;

/* loaded from: classes2.dex */
public final /* synthetic */ class a implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1901a;
    public final /* synthetic */ FontFamilyResolverImpl b;

    public /* synthetic */ a(FontFamilyResolverImpl fontFamilyResolverImpl, int i) {
        this.f1901a = i;
        this.b = fontFamilyResolverImpl;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        int i = this.f1901a;
        FontFamilyResolverImpl fontFamilyResolverImpl = this.b;
        TypefaceRequest typefaceRequest = (TypefaceRequest) obj;
        switch (i) {
            case 0:
                return FontFamilyResolverImpl.createDefaultTypeface$lambda$0(fontFamilyResolverImpl, typefaceRequest);
            default:
                return FontFamilyResolverImpl.preload$lambda$4(fontFamilyResolverImpl, typefaceRequest);
        }
    }
}
