package io.noties.markwon.image;

/* loaded from: classes4.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final a f34290a;

    /* renamed from: b, reason: collision with root package name */
    public final a f34291b;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final float f34292a;

        /* renamed from: b, reason: collision with root package name */
        public final String f34293b;

        public a(float f10, String str) {
            this.f34292a = f10;
            this.f34293b = str;
        }

        public String toString() {
            return "Dimension{value=" + this.f34292a + ", unit='" + this.f34293b + "'}";
        }
    }

    public h(a aVar, a aVar2) {
        this.f34290a = aVar;
        this.f34291b = aVar2;
    }

    public String toString() {
        return "ImageSize{width=" + this.f34290a + ", height=" + this.f34291b + '}';
    }
}
