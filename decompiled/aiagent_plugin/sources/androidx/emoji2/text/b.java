package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: DefaultEmojiCompatConfig.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: compiled from: DefaultEmojiCompatConfig.java */
    public static class a {
        private static final String TAG = "emoji2.text.DefaultEmojiConfig";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final C0050b f1614a;

        public a(C0050b r1) {
            if (r1 != null) goto L6;
            r1 = a();
        L6:
            this.f1614a = r1;
        }

        public androidx.emoji2.text.d.c a(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            return a(r4, b(r4));
        }

        private androidx.emoji2.text.d.c a(Context r2, androidx.core.provider.c r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            if (r3 != null) goto L7;
            return null;
        L7:
            return new g(r1, r3);
        }

        androidx.core.provider.c b(Context r3) {
            PackageManager r4 = ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getPackageManager();
            androidx.core.util.g.a(r4, "Package manager required to locate emoji font provider");
            ProviderInfo r0 = a(r4);
            if (r0 != null) goto L10;
            return null;
        L10:
            return a(r0, r4);
        L7:
            e = move-exception;
            a(TAG, e);
            return null;
        }

        private ProviderInfo a(PackageManager r4) {
            Iterator<ResolveInfo> r5 = this.f1614a.a(r4, new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
        L4:
            if (r5.hasNext() == false) goto L8;
            ResolveInfo r0 = (ResolveInfo) ZeusTransformUtils.preCheckCast(r5.next(), ResolveInfo.class, "com.obric.aiagent.plugin");
            ProviderInfo r1 = this.f1614a.a(r0);
            if (a(r1) == false) goto L4;
            return r1;
        L8:
            return null;
        }

        private boolean a(ProviderInfo r2) {
            if (r2 != null) goto L5;
        L9:
            return false;
        L5:
            if (r2.applicationInfo == null) goto L9;
            if ((r2.applicationInfo.flags & 1) != 1) goto L9;
            return true;
        }

        private androidx.core.provider.c a(ProviderInfo r3, PackageManager r4) {
            String r0 = r3.authority;
            String r5 = r3.packageName;
            return new androidx.core.provider.c(r0, r5, "emojicompat-emoji-font", a(this.f1614a.a(r4, r5)));
        }

        private List<List<byte[]>> a(Signature[] r4) {
            ArrayList r3 = new ArrayList();
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L6;
            r3.add(r4[r1].toByteArray());
            r1 = r1 + 1;
            goto L3
        L6:
            return Collections.singletonList(r3);
        }

        private static C0050b a() {
            if (Build.VERSION.SDK_INT < 28) goto L7;
            return new d();
        L7:
            if (Build.VERSION.SDK_INT < 19) goto L11;
            return new c();
        L11:
            return new C0050b();
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, Throwable r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.wtf(r1, r2);
        }
    }

    /* JADX INFO: renamed from: androidx.emoji2.text.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DefaultEmojiCompatConfig.java */
    public static class C0050b {
        public C0050b() {
        }

        public Signature[] a(PackageManager r1, String r2) {
            return r1.getPackageInfo(r2, 64).signatures;
        }

        public List<ResolveInfo> a(PackageManager r1, Intent r2, int r3) {
            return Collections.emptyList();
        }

        public ProviderInfo a(ResolveInfo r1) {
            throw new IllegalStateException("Unable to get provider info prior to API 19");
        }
    }

    /* JADX INFO: compiled from: DefaultEmojiCompatConfig.java */
    public static class c extends C0050b {
        public c() {
        }

        @Override // androidx.emoji2.text.b.C0050b
        public List<ResolveInfo> a(PackageManager r1, Intent r2, int r3) {
            return r1.queryIntentContentProviders(r2, r3);
        }

        @Override // androidx.emoji2.text.b.C0050b
        public ProviderInfo a(ResolveInfo r1) {
            return r1.providerInfo;
        }
    }

    /* JADX INFO: compiled from: DefaultEmojiCompatConfig.java */
    public static class d extends c {
        public d() {
        }

        @Override // androidx.emoji2.text.b.C0050b
        public Signature[] a(PackageManager r1, String r2) {
            return r1.getPackageInfo(r2, 64).signatures;
        }
    }

    public static g a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        return (g) ZeusTransformUtils.preCheckCast(new a(null).a(r4), g.class, "com.obric.aiagent.plugin");
    }
}
