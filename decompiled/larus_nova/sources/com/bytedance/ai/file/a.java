package com.bytedance.ai.file;

import android.net.Uri;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f36590b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f36591a;

    /* JADX INFO: renamed from: com.bytedance.ai.file.a$a, reason: collision with other inner class name */
    public static final class C0704a {
        public static a a(String r100) {
            Intrinsics.checkNotNullParameter(r100, TemplateNodeType.RAW);
            if (r100.length() != 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == true) goto L13;
            int r102 = e.f36595a;     // Catch: Throwable -> L10
            Intrinsics.checkNotNullParameter(r100, TemplateNodeType.RAW);     // Catch: Throwable -> L10
            return new a(UriProtector.parse(r100));
        L11:
            throw AppletFileError.InvalidUri.INSTANCE;
        L13:
            throw AppletFileError.InvalidUri.INSTANCE;
        L5:
            r101 = false;
            goto L6
        }
    }

    static {
    }

    public final String a() {
        return this.f36591a.toString();
    }

    public final boolean b() {
        int r100 = e.f36595a;
        Uri r101 = this.f36591a;
        Intrinsics.checkNotNullParameter(r101, "uri");
        if (Intrinsics.areEqual("appletfile", r101.getScheme()) == false) goto L7;
        Uri r102 = this.f36591a;
        Intrinsics.checkNotNullParameter(r102, "uri");
        if (Intrinsics.areEqual("temp", r102.getEncodedAuthority()) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final boolean c() {
        int r100 = e.f36595a;
        Uri r101 = this.f36591a;
        Intrinsics.checkNotNullParameter(r101, "uri");
        if (Intrinsics.areEqual("appletfile", r101.getScheme()) == false) goto L7;
        Uri r102 = this.f36591a;
        Intrinsics.checkNotNullParameter(r102, "uri");
        if (Intrinsics.areEqual("user", r102.getEncodedAuthority()) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final int hashCode() {
        return this.f36591a.hashCode();
    }

    public final String toString() {
        return a();
    }

    public a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        this.f36591a = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
    L9:
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
    L8:
        return false;
    L6:
        if (Intrinsics.areEqual(((a) r100).f36591a, this.f36591a) == false) goto L8;
        goto L8
    }
}
