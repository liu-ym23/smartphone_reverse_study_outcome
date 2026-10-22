package e0;

import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8514a = 0;

    /* renamed from: b, reason: collision with root package name */
    public Object f8515b;

    /* renamed from: c, reason: collision with root package name */
    public Object f8516c;

    /* renamed from: d, reason: collision with root package name */
    public Object f8517d;

    public /* synthetic */ a() {
    }

    public String toString() {
        switch (this.f8514a) {
            case 1:
                StringBuilder sb2 = new StringBuilder("[ClassStack (self-refs: ");
                ArrayList arrayList = (ArrayList) this.f8517d;
                sb2.append(arrayList == null ? "0" : String.valueOf(arrayList.size()));
                sb2.append(')');
                while (this != null) {
                    sb2.append(' ');
                    sb2.append(((Class) this.f8516c).getName());
                    this = (a) this.f8515b;
                }
                sb2.append(']');
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    public a(a aVar, Class cls) {
        this.f8515b = aVar;
        this.f8516c = cls;
    }
}
