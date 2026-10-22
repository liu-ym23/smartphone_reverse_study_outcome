package com.obric.aiagent.utils.b;

import android.graphics.Bitmap;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: LocalMediaMetadataExtractor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22318a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final c f22319e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bitmap.CompressFormat f22320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f22321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f22322d;

    /* JADX INFO: compiled from: LocalMediaMetadataExtractor.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final c a() {
            return c.d();
        }
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (this.f22320b == r6.f22320b) goto L12;
        return false;
    L12:
        if (o.a(this.f22321c, r6.f22321c) == true) goto L15;
        return false;
    L15:
        if (this.f22322d == r6.f22322d) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f22320b.hashCode() * 31) + this.f22321c.hashCode()) * 31) + Integer.hashCode(this.f22322d);
    }

    public String toString() {
        return "LocalVideoCoverFormat(compressFormat=" + this.f22320b + ", extensionName=" + this.f22321c + ", quality=" + this.f22322d + ')';
    }

    public c(Bitmap.CompressFormat r2, String r3, int r4) {
        o.e(r2, "compressFormat");
        o.e(r3, "extensionName");
        this.f22320b = r2;
        this.f22321c = r3;
        this.f22322d = r4;
    }

    public static final /* synthetic */ c d() {
        return f22319e;
    }

    public final Bitmap.CompressFormat a() {
        return this.f22320b;
    }

    public final String b() {
        return this.f22321c;
    }

    public final int c() {
        return this.f22322d;
    }

    static {
        f22318a = new a(null);
        f22319e = new c(Bitmap.CompressFormat.JPEG, "jpeg", 100);
    }
}
