package v0;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Locale;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final e f13253a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements b {

        /* renamed from: a, reason: collision with root package name */
        public final ContentInfo.Builder f13254a;

        public a(ClipData clipData, int i10) {
            this.f13254a = new ContentInfo.Builder(clipData, i10);
        }

        @Override // v0.c.b
        public final void a(Uri uri) {
            this.f13254a.setLinkUri(uri);
        }

        @Override // v0.c.b
        public final void b(int i10) {
            this.f13254a.setFlags(i10);
        }

        @Override // v0.c.b
        public final c build() {
            return new c(new d(this.f13254a.build()));
        }

        @Override // v0.c.b
        public final void setExtras(Bundle bundle) {
            this.f13254a.setExtras(bundle);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface b {
        void a(Uri uri);

        void b(int i10);

        c build();

        void setExtras(Bundle bundle);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: v0.c$c, reason: collision with other inner class name */
    public static final class C0152c implements b {

        /* renamed from: a, reason: collision with root package name */
        public ClipData f13255a;

        /* renamed from: b, reason: collision with root package name */
        public int f13256b;

        /* renamed from: c, reason: collision with root package name */
        public int f13257c;

        /* renamed from: d, reason: collision with root package name */
        public Uri f13258d;

        /* renamed from: e, reason: collision with root package name */
        public Bundle f13259e;

        @Override // v0.c.b
        public final void a(Uri uri) {
            this.f13258d = uri;
        }

        @Override // v0.c.b
        public final void b(int i10) {
            this.f13257c = i10;
        }

        @Override // v0.c.b
        public final c build() {
            return new c(new f(this));
        }

        @Override // v0.c.b
        public final void setExtras(Bundle bundle) {
            this.f13259e = bundle;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class d implements e {

        /* renamed from: a, reason: collision with root package name */
        public final ContentInfo f13260a;

        public d(ContentInfo contentInfo) {
            contentInfo.getClass();
            this.f13260a = contentInfo;
        }

        @Override // v0.c.e
        public final ContentInfo a() {
            return this.f13260a;
        }

        @Override // v0.c.e
        public final int b() {
            return this.f13260a.getSource();
        }

        @Override // v0.c.e
        public final ClipData c() {
            return this.f13260a.getClip();
        }

        @Override // v0.c.e
        public final int d() {
            return this.f13260a.getFlags();
        }

        public final String toString() {
            return "ContentInfoCompat{" + this.f13260a + "}";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface e {
        ContentInfo a();

        int b();

        ClipData c();

        int d();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class f implements e {

        /* renamed from: a, reason: collision with root package name */
        public final ClipData f13261a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13262b;

        /* renamed from: c, reason: collision with root package name */
        public final int f13263c;

        /* renamed from: d, reason: collision with root package name */
        public final Uri f13264d;

        /* renamed from: e, reason: collision with root package name */
        public final Bundle f13265e;

        public f(C0152c c0152c) {
            ClipData clipData = c0152c.f13255a;
            clipData.getClass();
            this.f13261a = clipData;
            int i10 = c0152c.f13256b;
            if (i10 < 0) {
                Locale locale = Locale.US;
                throw new IllegalArgumentException("source is out of range of [0, 5] (too low)");
            }
            if (i10 > 5) {
                Locale locale2 = Locale.US;
                throw new IllegalArgumentException("source is out of range of [0, 5] (too high)");
            }
            this.f13262b = i10;
            int i11 = c0152c.f13257c;
            if ((i11 & 1) == i11) {
                this.f13263c = i11;
                this.f13264d = c0152c.f13258d;
                this.f13265e = c0152c.f13259e;
            } else {
                throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i11) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
            }
        }

        @Override // v0.c.e
        public final ContentInfo a() {
            return null;
        }

        @Override // v0.c.e
        public final int b() {
            return this.f13262b;
        }

        @Override // v0.c.e
        public final ClipData c() {
            return this.f13261a;
        }

        @Override // v0.c.e
        public final int d() {
            return this.f13263c;
        }

        public final String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder("ContentInfoCompat{clip=");
            sb2.append(this.f13261a.getDescription());
            sb2.append(", source=");
            int i10 = this.f13262b;
            sb2.append(i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? String.valueOf(i10) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP");
            sb2.append(", flags=");
            int i11 = this.f13263c;
            sb2.append((i11 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i11));
            Uri uri = this.f13264d;
            if (uri == null) {
                str = "";
            } else {
                str = ", hasLinkUri(" + uri.toString().length() + ")";
            }
            sb2.append(str);
            return ai.onnxruntime.a.o(sb2, this.f13265e != null ? ", hasExtras" : "", "}");
        }
    }

    public c(e eVar) {
        this.f13253a = eVar;
    }

    public final String toString() {
        return this.f13253a.toString();
    }
}
