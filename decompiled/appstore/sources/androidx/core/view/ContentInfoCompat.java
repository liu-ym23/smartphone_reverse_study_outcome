package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ContentInfoCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Compat f2659a;

    public interface BuilderCompat {
        @NonNull
        ContentInfoCompat build();

        void setClip(@NonNull ClipData r10);

        void setExtras(@Nullable Bundle r10);

        void setFlags(int r10);

        void setLinkUri(@Nullable Uri r10);

        void setSource(int r10);
    }

    public interface Compat {
        @NonNull
        ClipData getClip();

        @Nullable
        Bundle getExtras();

        int getFlags();

        @Nullable
        Uri getLinkUri();

        int getSource();

        @Nullable
        ContentInfo getWrapped();
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Flags {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Source {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BuilderCompat f2660a;

        public a(ClipData r10, int r11) {
            if (Build.VERSION.SDK_INT < 31) goto L5;
            this.f2660a = new b(r10, r11);
            return;
        L5:
            this.f2660a = new c(r10, r11);
        }

        public ContentInfoCompat a() {
            return this.f2660a.build();
        }

        public a b(Bundle r10) {
            this.f2660a.setExtras(r10);
            return this;
        }

        public a c(int r10) {
            this.f2660a.setFlags(r10);
            return this;
        }

        public a d(Uri r10) {
            this.f2660a.setLinkUri(r10);
            return this;
        }
    }

    public static final class b implements BuilderCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentInfo.Builder f2661a;

        public b(ClipData r10, int r11) {
            this.f2661a = new ContentInfo.Builder(r10, r11);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new d(this.f2661a.build()));
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setClip(ClipData r10) {
            this.f2661a.setClip(r10);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setExtras(Bundle r10) {
            this.f2661a.setExtras(r10);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setFlags(int r10) {
            this.f2661a.setFlags(r10);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setLinkUri(Uri r10) {
            this.f2661a.setLinkUri(r10);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setSource(int r10) {
            this.f2661a.setSource(r10);
        }
    }

    public static final class c implements BuilderCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ClipData f2662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2663b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2664c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Uri f2665d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Bundle f2666e;

        public c(ClipData r10, int r11) {
            this.f2662a = r10;
            this.f2663b = r11;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new e(this));
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setClip(ClipData r10) {
            this.f2662a = r10;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setExtras(Bundle r10) {
            this.f2666e = r10;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setFlags(int r10) {
            this.f2664c = r10;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setLinkUri(Uri r10) {
            this.f2665d = r10;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setSource(int r10) {
            this.f2663b = r10;
        }
    }

    public static final class d implements Compat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentInfo f2667a;

        public d(ContentInfo r10) {
            this.f2667a = (ContentInfo) androidx.core.util.e.g(r10);
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ClipData getClip() {
            return this.f2667a.getClip();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public Bundle getExtras() {
            return this.f2667a.getExtras();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getFlags() {
            return this.f2667a.getFlags();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public Uri getLinkUri() {
            return this.f2667a.getLinkUri();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getSource() {
            return this.f2667a.getSource();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ContentInfo getWrapped() {
            return this.f2667a;
        }

        public String toString() {
            return "ContentInfoCompat{" + this.f2667a + "}";
        }
    }

    public static final class e implements Compat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ClipData f2668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2669b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f2670c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Uri f2671d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Bundle f2672e;

        public e(c r10) {
            this.f2668a = (ClipData) androidx.core.util.e.g(r10.f2662a);
            this.f2669b = androidx.core.util.e.c(r10.f2663b, 0, 5, "source");
            this.f2670c = androidx.core.util.e.f(r10.f2664c, 1);
            this.f2671d = r10.f2665d;
            this.f2672e = r10.f2666e;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ClipData getClip() {
            return this.f2668a;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public Bundle getExtras() {
            return this.f2672e;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getFlags() {
            return this.f2670c;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public Uri getLinkUri() {
            return this.f2671d;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getSource() {
            return this.f2669b;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ContentInfo getWrapped() {
            return null;
        }

        public String toString() {
            StringBuilder r10 = new StringBuilder();
            r10.append("ContentInfoCompat{clip=");
            r10.append(this.f2668a.getDescription());
            r10.append(", source=");
            r10.append(ContentInfoCompat.e(this.f2669b));
            r10.append(", flags=");
            r10.append(ContentInfoCompat.a(this.f2670c));
            String r11 = "";
            if (this.f2671d != null) goto L5;
            String r12 = "";
        L6:
            r10.append(r12);
            if (this.f2672e == null) goto L10;
            r11 = ", hasExtras";
        L10:
            r10.append(r11);
            r10.append("}");
            return r10.toString();
        L5:
            r12 = ", hasLinkUri(" + this.f2671d.toString().length() + ")";
            goto L6
        }
    }

    public ContentInfoCompat(Compat r10) {
        this.f2659a = r10;
    }

    public static String a(int r10) {
        if ((r10 & 1) == 0) goto L7;
        return "FLAG_CONVERT_TO_PLAIN_TEXT";
    L7:
        return String.valueOf(r10);
    }

    public static String e(int r10) {
        if (r10 != 0) goto L4;
        return "SOURCE_APP";
    L4:
        if (r10 != 1) goto L6;
        return "SOURCE_CLIPBOARD";
    L6:
        if (r10 != 2) goto L8;
        return "SOURCE_INPUT_METHOD";
    L8:
        if (r10 != 3) goto L10;
        return "SOURCE_DRAG_AND_DROP";
    L10:
        if (r10 != 4) goto L12;
        return "SOURCE_AUTOFILL";
    L12:
        if (r10 != 5) goto L14;
        return "SOURCE_PROCESS_TEXT";
    L14:
        return String.valueOf(r10);
    }

    public static ContentInfoCompat g(ContentInfo r10) {
        return new ContentInfoCompat(new d(r10));
    }

    public ClipData b() {
        return this.f2659a.getClip();
    }

    public int c() {
        return this.f2659a.getFlags();
    }

    public int d() {
        return this.f2659a.getSource();
    }

    public ContentInfo f() {
        ContentInfo r10 = this.f2659a.getWrapped();
        Objects.requireNonNull(r10);
        return r10;
    }

    public String toString() {
        return this.f2659a.toString();
    }
}
