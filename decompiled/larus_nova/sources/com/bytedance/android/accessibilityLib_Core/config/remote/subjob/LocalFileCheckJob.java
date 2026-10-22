package com.bytedance.android.accessibilityLib_Core.config.remote.subjob;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class LocalFileCheckJob {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f38228e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f38229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f38230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f38231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f38232d;

    public static final class a {
    }

    static {
    }

    public LocalFileCheckJob(b r100) {
        this.f38232d = r100;
        this.f38229a = LazyKt.lazy(new LocalFileCheckJob$kevaRepo$2(this));
        this.f38230b = "r_accessibility.txt_identify";
        this.f38231c = "r_accessibility.txt_path";
    }

    public final void a(final String r110, final Function1<? super List<String>, Unit> r111) {
    L47:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L52;
        Context r100 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L52:
        if (("getLocalFileIfValid error = " + e.getMessage()) == null) goto L54;
        Context r112 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L54:
        r111.invoke(null);
        Unit r113 = Unit.INSTANCE;
        return;
    L4:
        if (("getLocalFileIfValid url = " + r110) == null) goto L6;
        Context r101 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L47
    L6:
        boolean r102 = false;
        if (r110 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L16;
        r111.invoke(null);     // Catch: Exception -> L47
        return;
    L16:
        final String r104 = StringsKt.substringAfterLast$default(r110, HTTP.URL_DEFAULT, null, 2, null);     // Catch: Exception -> L47
        if (("keyIdentifyValue = " + r104) == null) goto L19;
        Context r105 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L47
    L19:
        String r106 = ((Keva) this.f38229a.getValue()).getString(this.f38230b, "");     // Catch: Exception -> L47
        if (("localIdentify = " + r106) == null) goto L23;
        Context r107 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L47
    L23:
        if (Intrinsics.areEqual(r106, r104) == false) goto L38;
        Context r108 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L47
        String r109 = ((Keva) this.f38229a.getValue()).getString(this.f38231c, "");     // Catch: Exception -> L47
        String r114 = "localFilePath = " + r109;     // Catch: Exception -> L47
        if (r109 != null) goto L27;
    L28:
        r102 = true;
    L29:
        if (r102 == true) goto L38;
        PolarisFileWrapper r115 = new PolarisFileWrapper(r109);     // Catch: Exception -> L47
        if (r115.exists() == false) goto L38;
        Reader r116 = new InputStreamReader(new PolarisFileInputStreamWrapper(r115), Charsets.UTF_8);     // Catch: Exception -> L47
        if ((r116 instanceof BufferedReader) == false) goto L35;
        BufferedReader r117 = (BufferedReader) r116;     // Catch: Exception -> L47
    L36:
        List<String> r118 = TextStreamsKt.readLines(r117);     // Catch: Exception -> L47
        String r119 = "rTxtLines.size = " + r118.size();     // Catch: Exception -> L47
        r111.invoke(r118);     // Catch: Exception -> L47
        return;
    L35:
        r117 = new BufferedReader(r116, 8192);     // Catch: Exception -> L47
        goto L36
    L27:
        if (r109.length() != 0) goto L29;
    L38:
        Context r120 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L47
        PolarisFileWrapper r121 = new PolarisFileWrapper(com.bytedance.android.accessibilityLib_Core.helper.a.a().getExternalFilesDir(null), "r_accessibility");     // Catch: Exception -> L47
        if (r121.exists() == true) goto L41;
        r121.mkdirs();     // Catch: Exception -> L47
    L41:
        com.bytedance.android.accessibilityLib_Core.config.remote.subjob.a r122 = new com.bytedance.android.accessibilityLib_Core.config.remote.subjob.a(r110, r121.getAbsolutePath());     // Catch: Exception -> L47
        b r123 = this.f38232d;     // Catch: Exception -> L47
        if (r123 == null) goto L44;
        r123.a(r122, new LocalFileCheckJob$getLocalFileIfValid$$inlined$Try$lambda$1(r104, this, r110, r111));     // Catch: Exception -> L47
    L45:
        Unit r124 = Unit.INSTANCE;     // Catch: Exception -> L47
        return;
    L44:
        r111.invoke(null);     // Catch: Exception -> L47
        goto L45
    L9:
        if (r110.length() == 0) goto L12;
        r103 = false;
        goto L13
    }
}
