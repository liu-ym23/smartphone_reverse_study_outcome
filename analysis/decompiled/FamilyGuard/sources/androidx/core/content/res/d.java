package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final Shader f9601a;

    /* renamed from: b, reason: collision with root package name */
    private final ColorStateList f9602b;

    /* renamed from: c, reason: collision with root package name */
    private int f9603c;

    private d(Shader shader, ColorStateList colorStateList, int i5) {
        this.f9601a = shader;
        this.f9602b = colorStateList;
        this.f9603c = i5;
    }

    private static d a(Resources resources, int i5, Resources.Theme theme) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int next;
        XmlResourceParser xml = resources.getXml(i5);
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        name.getClass();
        if (name.equals("gradient")) {
            return d(f.b(resources, xml, attributeSetAsAttributeSet, theme));
        }
        if (name.equals("selector")) {
            return c(c.b(resources, xml, attributeSetAsAttributeSet, theme));
        }
        throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
    }

    static d b(int i5) {
        return new d(null, null, i5);
    }

    static d c(ColorStateList colorStateList) {
        return new d(null, colorStateList, colorStateList.getDefaultColor());
    }

    static d d(Shader shader) {
        return new d(shader, null, 0);
    }

    public static d g(Resources resources, int i5, Resources.Theme theme) {
        try {
            return a(resources, i5, theme);
        } catch (Exception e6) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e6);
            return null;
        }
    }

    public int e() {
        return this.f9603c;
    }

    public Shader f() {
        return this.f9601a;
    }

    public boolean h() {
        return this.f9601a != null;
    }

    public boolean i() {
        ColorStateList colorStateList;
        return this.f9601a == null && (colorStateList = this.f9602b) != null && colorStateList.isStateful();
    }

    public boolean j(int[] iArr) {
        if (!i()) {
            return false;
        }
        ColorStateList colorStateList = this.f9602b;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (colorForState == this.f9603c) {
            return false;
        }
        this.f9603c = colorForState;
        return true;
    }

    public void k(int i5) {
        this.f9603c = i5;
    }

    public boolean l() {
        return h() || this.f9603c != 0;
    }
}
