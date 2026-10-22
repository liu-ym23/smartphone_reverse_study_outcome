package androidx.core.app;

import android.app.RemoteInput;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: RemoteInput.java */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence f1136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CharSequence[] f1137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f1138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f1139e;
    private final Bundle f;
    private final Set<String> g;

    /* JADX INFO: compiled from: RemoteInput.java */
    static class a {
        static Bundle a(Intent r0) {
            return RemoteInput.getResultsFromIntent(r0);
        }

        static void a(Object r2, Intent r3, Bundle r4) {
            RemoteInput.addResultsToIntent((RemoteInput[]) ZeusTransformUtils.preCheckCast(r2, RemoteInput[].class, "com.obric.aiagent.plugin"), r3, r4);
        }

        public static RemoteInput a(p r5) {
            RemoteInput.Builder r0 = new RemoteInput.Builder(r5.a()).setLabel(r5.b()).setChoices(r5.c()).setAllowFreeFormInput(r5.f()).addExtras(r5.h());
            if (Build.VERSION.SDK_INT < 26) goto L11;
            Set<String> r1 = r5.d();
            if (r1 == null) goto L11;
            Iterator<String> r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L11;
            b.a(r0, (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin"), true);
        L11:
            if (Build.VERSION.SDK_INT < 29) goto L14;
            c.a(r0, r5.g());
        L14:
            return r0.build();
        }
    }

    /* JADX INFO: compiled from: RemoteInput.java */
    static class b {
        static Map<String, Uri> a(Intent r0, String r1) {
            return RemoteInput.getDataResultsFromIntent(r0, r1);
        }

        static Set<String> a(Object r2) {
            return ((RemoteInput) ZeusTransformUtils.preCheckCast(r2, RemoteInput.class, "com.obric.aiagent.plugin")).getAllowedDataTypes();
        }

        static void a(p r2, Intent r3, Map<String, Uri> r4) {
            Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            RemoteInput.addDataResultToIntent(p.a(r2), r3, r5);
        }

        static RemoteInput.Builder a(RemoteInput.Builder r0, String r1, boolean r2) {
            return r0.setAllowDataType(r1, r2);
        }
    }

    /* JADX INFO: compiled from: RemoteInput.java */
    static class c {
        static int a(Object r2) {
            return ((RemoteInput) ZeusTransformUtils.preCheckCast(r2, RemoteInput.class, "com.obric.aiagent.plugin")).getEditChoicesBeforeSending();
        }

        static RemoteInput.Builder a(RemoteInput.Builder r0, int r1) {
            return r0.setEditChoicesBeforeSending(r1);
        }
    }

    public String a() {
        return this.f1135a;
    }

    public CharSequence b() {
        return this.f1136b;
    }

    public CharSequence[] c() {
        return this.f1137c;
    }

    public Set<String> d() {
        return this.g;
    }

    public boolean e() {
        if (f() == false) goto L5;
    L13:
        return false;
    L5:
        if (c() == null) goto L9;
        if (c().length != 0) goto L13;
    L9:
        if (d() == null) goto L13;
        if (d().isEmpty() == true) goto L13;
        return true;
    }

    public boolean f() {
        return this.f1138d;
    }

    public int g() {
        return this.f1139e;
    }

    public Bundle h() {
        return this.f;
    }

    static RemoteInput[] a(p[] r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        RemoteInput[] r0 = new RemoteInput[r3.length];
        int r1 = 0;
    L7:
        if (r1 >= r3.length) goto L9;
        r0[r1] = a(r3[r1]);
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    }

    static RemoteInput a(p r0) {
        return a.a(r0);
    }
}
