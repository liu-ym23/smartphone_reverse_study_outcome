package androidx.core.app;

import android.app.RemoteInput;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    private final String f9574a;

    /* renamed from: b, reason: collision with root package name */
    private final CharSequence f9575b;

    /* renamed from: c, reason: collision with root package name */
    private final CharSequence[] f9576c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f9577d;

    /* renamed from: e, reason: collision with root package name */
    private final int f9578e;

    /* renamed from: f, reason: collision with root package name */
    private final Bundle f9579f;

    /* renamed from: g, reason: collision with root package name */
    private final Set<String> f9580g;

    static class a {
        static void a(Object obj, Intent intent, Bundle bundle) {
            RemoteInput.addResultsToIntent((RemoteInput[]) obj, intent, bundle);
        }

        public static RemoteInput b(r rVar) {
            RemoteInput.Builder builderAddExtras = new RemoteInput.Builder(rVar.i()).setLabel(rVar.h()).setChoices(rVar.e()).setAllowFreeFormInput(rVar.c()).addExtras(rVar.g());
            Set<String> setD = rVar.d();
            if (setD != null) {
                Iterator<String> it = setD.iterator();
                while (it.hasNext()) {
                    b.d(builderAddExtras, it.next(), true);
                }
            }
            c.b(builderAddExtras, rVar.f());
            return builderAddExtras.build();
        }

        static Bundle c(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }

    static class b {
        static void a(r rVar, Intent intent, Map<String, Uri> map) {
            RemoteInput.addDataResultToIntent(r.a(rVar), intent, map);
        }

        static Set<String> b(Object obj) {
            return ((RemoteInput) obj).getAllowedDataTypes();
        }

        static Map<String, Uri> c(Intent intent, String str) {
            return RemoteInput.getDataResultsFromIntent(intent, str);
        }

        static RemoteInput.Builder d(RemoteInput.Builder builder, String str, boolean z5) {
            return builder.setAllowDataType(str, z5);
        }
    }

    static class c {
        static int a(Object obj) {
            return ((RemoteInput) obj).getEditChoicesBeforeSending();
        }

        static RemoteInput.Builder b(RemoteInput.Builder builder, int i5) {
            return builder.setEditChoicesBeforeSending(i5);
        }
    }

    static RemoteInput a(r rVar) {
        return a.b(rVar);
    }

    static RemoteInput[] b(r[] rVarArr) {
        if (rVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[rVarArr.length];
        for (int i5 = 0; i5 < rVarArr.length; i5++) {
            remoteInputArr[i5] = a(rVarArr[i5]);
        }
        return remoteInputArr;
    }

    public boolean c() {
        return this.f9577d;
    }

    public Set<String> d() {
        return this.f9580g;
    }

    public CharSequence[] e() {
        return this.f9576c;
    }

    public int f() {
        return this.f9578e;
    }

    public Bundle g() {
        return this.f9579f;
    }

    public CharSequence h() {
        return this.f9575b;
    }

    public String i() {
        return this.f9574a;
    }

    public boolean j() {
        if (c()) {
            return false;
        }
        return ((e() != null && e().length != 0) || d() == null || d().isEmpty()) ? false : true;
    }
}
