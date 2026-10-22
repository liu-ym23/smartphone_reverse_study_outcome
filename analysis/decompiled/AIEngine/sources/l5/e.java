package l5;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class e {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends e {

        /* renamed from: a, reason: collision with root package name */
        public final CharSequence f10258a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10259b;

        public a(CharSequence charSequence, int i10) {
            this.f10258a = charSequence;
            this.f10259b = i10;
        }

        public final int a(int i10) {
            CharSequence charSequence = this.f10258a;
            return j.a((i10 <= 0 || i10 > charSequence.length()) ? -1 : Character.codePointBefore(charSequence, i10), i10 < charSequence.length() ? Character.codePointAt(charSequence, i10) : -1);
        }

        public final int b(int i10) {
            if (i10 >= this.f10259b) {
                return -8;
            }
            int iCodePointAt = Character.codePointAt(this.f10258a, i10);
            return Character.charCount(iCodePointAt) | (iCodePointAt << 3);
        }
    }
}
