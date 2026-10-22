package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f3056a;

        public a(b r10) {
            if (r10 != null) goto L6;
            r10 = e();
        L6:
            this.f3056a = r10;
        }

        public static b e() {
            return new d();
        }

        public final EmojiCompat.c a(Context r10, q.c r11) {
            if (r11 != null) goto L6;
            return null;
        L6:
            return new h(r10, r11);
        }

        public final List b(Signature[] r10) {
            ArrayList r11 = new ArrayList();
            int r12 = r10.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L6;
            r11.add(r10[r13].toByteArray());
            r13 = r13 + 1;
            goto L3
        L6:
            return Collections.singletonList(r11);
        }

        public EmojiCompat.c c(Context r10) {
            return a(r10, h(r10));
        }

        public final q.c d(ProviderInfo r10, PackageManager r11) {
            String r12 = r10.authority;
            String r13 = r10.packageName;
            return new q.c(r12, r13, "emojicompat-emoji-font", b(this.f3056a.b(r11, r13)));
        }

        public final boolean f(ProviderInfo r10) {
            if (r10 == null) goto L8;
            ApplicationInfo r11 = r10.applicationInfo;
            if (r11 == null) goto L8;
            if ((r11.flags & 1) != 1) goto L8;
            return true;
        L8:
            return false;
        }

        public final ProviderInfo g(PackageManager r10) {
            Iterator r11 = this.f3056a.c(r10, new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
        L4:
            if (r11.hasNext() == false) goto L8;
            ResolveInfo r12 = (ResolveInfo) r11.next();
            ProviderInfo r13 = this.f3056a.a(r12);
            if (f(r13) == false) goto L4;
            return r13;
        L8:
            return null;
        }

        public q.c h(Context r10) {
            PackageManager r11 = r10.getPackageManager();
            androidx.core.util.e.h(r11, "Package manager required to locate emoji font provider");
            ProviderInfo r12 = g(r11);
            if (r12 != null) goto L10;
            return null;
        L10:
            return d(r12, r11);
        L7:
            e = move-exception;
            Log.wtf("emoji2.text.DefaultEmojiConfig", e);
            return null;
        }
    }

    public static class b {
        public b() {
        }

        public abstract ProviderInfo a(ResolveInfo r10);

        public abstract Signature[] b(PackageManager r10, String r11);

        public abstract List c(PackageManager r10, Intent r11, int r12);
    }

    /* JADX INFO: renamed from: androidx.emoji2.text.c$c, reason: collision with other inner class name */
    public static class C0028c extends b {
        public C0028c() {
        }

        @Override // androidx.emoji2.text.c.b
        public ProviderInfo a(ResolveInfo r10) {
            return r10.providerInfo;
        }

        @Override // androidx.emoji2.text.c.b
        public List c(PackageManager r10, Intent r11, int r12) {
            return r10.queryIntentContentProviders(r11, r12);
        }
    }

    public static class d extends C0028c {
        public d() {
        }

        @Override // androidx.emoji2.text.c.b
        public Signature[] b(PackageManager r10, String r11) {
            return r10.getPackageInfo(r11, 64).signatures;
        }
    }

    public static h a(Context r10) {
        return (h) new a(null).c(r10);
    }
}
