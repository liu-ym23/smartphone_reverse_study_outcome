package androidx.core.view;

import android.content.ClipData;
import android.view.ContentInfo;
import java.util.Objects;

/* renamed from: androidx.core.view.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1315c {

    /* renamed from: a, reason: collision with root package name */
    public final b f13188a;

    /* renamed from: androidx.core.view.c$a */
    public static final class a implements b {

        /* renamed from: a, reason: collision with root package name */
        public final ContentInfo f13189a;

        public a(ContentInfo contentInfo) {
            this.f13189a = (ContentInfo) B0.h.f(contentInfo);
        }

        @Override // androidx.core.view.C1315c.b
        public ContentInfo a() {
            return this.f13189a;
        }

        @Override // androidx.core.view.C1315c.b
        public ClipData b() {
            return this.f13189a.getClip();
        }

        @Override // androidx.core.view.C1315c.b
        public int c() {
            return this.f13189a.getFlags();
        }

        @Override // androidx.core.view.C1315c.b
        public int e() {
            return this.f13189a.getSource();
        }

        public String toString() {
            return "ContentInfoCompat{" + this.f13189a + "}";
        }
    }

    /* renamed from: androidx.core.view.c$b */
    public interface b {
        ContentInfo a();

        ClipData b();

        int c();

        int e();
    }

    public C1315c(b bVar) {
        this.f13188a = bVar;
    }

    public static C1315c e(ContentInfo contentInfo) {
        return new C1315c(new a(contentInfo));
    }

    public ClipData a() {
        return this.f13188a.b();
    }

    public int b() {
        return this.f13188a.c();
    }

    public int c() {
        return this.f13188a.e();
    }

    public ContentInfo d() {
        ContentInfo contentInfoA = this.f13188a.a();
        Objects.requireNonNull(contentInfoA);
        return contentInfoA;
    }

    public String toString() {
        return this.f13188a.toString();
    }
}
