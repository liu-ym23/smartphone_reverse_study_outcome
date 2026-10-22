package androidx.compose.ui.graphics.vector.compat;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.compose.ui.graphics.vector.PathParser;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0081\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J,\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0018\u00010\u0018R\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ(\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005J(\u0010#\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020$J(\u0010%\u001a\u00020&2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020&J\u001e\u0010'\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020$J\u001e\u0010)\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005J\u0018\u0010*\u001a\u0004\u0018\u00010 2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u0005J\u001e\u0010+\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u00052\u0006\u0010,\u001a\u00020$J8\u0010-\u001a\u00020.2\u0006\u0010\u001e\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0018\u00010\u0018R\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010!\u001a\u00020\u00052\b\b\u0001\u0010\"\u001a\u00020\u0005J0\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010\u001e\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0018\u00010\u0018R\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010!\u001a\u00020\u0005J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\u001d\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u00104\u001a\u00020&2\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u0005HÖ\u0001J\t\u00107\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u00020\u000f8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Landroidx/compose/ui/graphics/vector/compat/AndroidVectorParser;", "", "xmlParser", "Lorg/xmlpull/v1/XmlPullParser;", "config", "", "<init>", "(Lorg/xmlpull/v1/XmlPullParser;I)V", "getXmlParser", "()Lorg/xmlpull/v1/XmlPullParser;", "getConfig", "()I", "setConfig", "(I)V", "pathParser", "Landroidx/compose/ui/graphics/vector/PathParser;", "updateConfig", "", "resConfig", "obtainAttributes", "Landroid/content/res/TypedArray;", "res", "Landroid/content/res/Resources;", "theme", "Landroid/content/res/Resources$Theme;", "set", "Landroid/util/AttributeSet;", "attrs", "", "getNamedInt", "typedArray", "attrName", "", "resId", "defaultValue", "getNamedFloat", "", "getNamedBoolean", "", "getFloat", "index", "getInt", "getString", "getDimension", "defValue", "getNamedComplexColor", "Landroidx/core/content/res/ComplexColorCompat;", "getNamedColorStateList", "Landroid/content/res/ColorStateList;", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidVectorParser {
    public static final int $stable = 8;
    private int config;
    public final PathParser pathParser;
    private final XmlPullParser xmlParser;

    public static /* synthetic */ AndroidVectorParser copy$default(AndroidVectorParser r100, XmlPullParser r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.xmlParser;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.config;
    L9:
        return r100.copy(r101, r102);
    }

    public final XmlPullParser component1() {
        return this.xmlParser;
    }

    public final int component2() {
        return this.config;
    }

    public final AndroidVectorParser copy(XmlPullParser r100, int r101) {
        return new AndroidVectorParser(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AndroidVectorParser) == true) goto L8;
        return false;
    L8:
        AndroidVectorParser r101 = (AndroidVectorParser) r100;
        if (Intrinsics.areEqual(this.xmlParser, r101.xmlParser) == true) goto L12;
        return false;
    L12:
        if (this.config == r101.config) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.xmlParser.hashCode() * 31) + this.config;
    }

    public String toString() {
        return "AndroidVectorParser(xmlParser=" + this.xmlParser + ", config=" + this.config + ')';
    }

    public final int getConfig() {
        return this.config;
    }

    public final XmlPullParser getXmlParser() {
        return this.xmlParser;
    }

    private final void updateConfig(int r100) {
        this.config = r100 | this.config;
    }

    public final void setConfig(int r100) {
        this.config = r100;
    }

    public AndroidVectorParser(XmlPullParser r100, int r101) {
        this.xmlParser = r100;
        this.config = r101;
        this.pathParser = new PathParser();
    }

    public final String getString(TypedArray r100, int r101) {
        String r102 = r100.getString(r101);
        updateConfig(r100.getChangingConfigurations());
        return r102;
    }

    public final float getDimension(TypedArray r100, int r101, float r102) {
        float r103 = r100.getDimension(r101, r102);
        updateConfig(r100.getChangingConfigurations());
        return r103;
    }

    public final float getFloat(TypedArray r100, int r101, float r102) {
        float r103 = r100.getFloat(r101, r102);
        updateConfig(r100.getChangingConfigurations());
        return r103;
    }

    public final int getInt(TypedArray r100, int r101, int r102) {
        int r103 = r100.getInt(r101, r102);
        updateConfig(r100.getChangingConfigurations());
        return r103;
    }

    public /* synthetic */ AndroidVectorParser(XmlPullParser r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = 0;
    L5:
        this(r100, r101);
    }

    public final boolean getNamedBoolean(TypedArray r100, String r101, int r102, boolean r103) {
        boolean r104 = TypedArrayUtils.getNamedBoolean(r100, this.xmlParser, r101, r102, r103);
        updateConfig(r100.getChangingConfigurations());
        return r104;
    }

    public final ColorStateList getNamedColorStateList(TypedArray r100, Resources.Theme r101, String r102, int r103) {
        ColorStateList r104 = TypedArrayUtils.getNamedColorStateList(r100, this.xmlParser, r101, r102, r103);
        updateConfig(r100.getChangingConfigurations());
        return r104;
    }

    public final float getNamedFloat(TypedArray r100, String r101, int r102, float r103) {
        float r104 = TypedArrayUtils.getNamedFloat(r100, this.xmlParser, r101, r102, r103);
        updateConfig(r100.getChangingConfigurations());
        return r104;
    }

    public final int getNamedInt(TypedArray r100, String r101, int r102, int r103) {
        int r104 = TypedArrayUtils.getNamedInt(r100, this.xmlParser, r101, r102, r103);
        updateConfig(r100.getChangingConfigurations());
        return r104;
    }

    public final TypedArray obtainAttributes(Resources r100, Resources.Theme r101, AttributeSet r102, int[] r103) {
        TypedArray r104 = TypedArrayUtils.obtainAttributes(r100, r101, r102, r103);
        updateConfig(r104.getChangingConfigurations());
        return r104;
    }

    public final ComplexColorCompat getNamedComplexColor(TypedArray r100, Resources.Theme r101, String r102, int r110, int r111) {
        ComplexColorCompat r103 = TypedArrayUtils.getNamedComplexColor(r100, this.xmlParser, r101, r102, r110, r111);
        updateConfig(r100.getChangingConfigurations());
        return r103;
    }
}
