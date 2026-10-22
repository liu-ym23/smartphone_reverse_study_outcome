package androidx.core.content.b;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.obric.aiagent.apm.impl.BuildConfig;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ComplexColorCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Shader f1161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ColorStateList f1162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1163c;

    private d(Shader r1, ColorStateList r2, int r3) {
        this.f1161a = r1;
        this.f1162b = r2;
        this.f1163c = r3;
    }

    static d a(Shader r3) {
        return new d(r3, null, 0);
    }

    static d a(ColorStateList r3) {
        return new d(null, r3, r3.getDefaultColor());
    }

    static d a(int r2) {
        return new d(null, null, r2);
    }

    public Shader a() {
        return this.f1161a;
    }

    public int b() {
        return this.f1163c;
    }

    public void b(int r1) {
        this.f1163c = r1;
    }

    public boolean c() {
        if (this.f1161a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean d() {
        if (this.f1161a != null) goto L9;
        ColorStateList r1 = this.f1162b;
        if (r1 == null) goto L9;
        if (r1.isStateful() == false) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean a(int[] r3) {
        if (d() == false) goto L7;
        ColorStateList r0 = this.f1162b;
        int r4 = r0.getColorForState(r3, r0.getDefaultColor());
        if (r4 == this.f1163c) goto L7;
        this.f1163c = r4;
        return true;
    L7:
        return false;
    }

    public boolean e() {
        if (c() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f1163c != 0) goto L8;
        return false;
    }

    public static d a(Resources r0, int r1, Resources.Theme r2) {
        return b(r0, r1, r2);
    L4:
        e = move-exception;
        a("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
        return null;
    }

    private static d b(Resources r4, int r5, Resources.Theme r6) {
        XmlResourceParser r7 = r4.getXml(r5);
        AttributeSet r0 = Xml.asAttributeSet(r7);
    L3:
        int r1 = r7.next();
        if (r1 == 2) goto L8;
        if (r1 != 1) goto L3;
    L8:
        if (r1 != 2) goto L20;
        String r2 = r7.getName();
        r2.hashCode();
        if (r2.equals("gradient") == true) goto L18;
        if (r2.equals("selector") == false) goto L16;
        return a(c.a(r4, r7, r0, r6));
    L16:
        throw new XmlPullParserException(r7.getPositionDescription() + ": unsupported complex color tag " + r2);
    L18:
        return a(f.a(r4, r7, r0, r6));
    L20:
        throw new XmlPullParserException("No start tag found");
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
