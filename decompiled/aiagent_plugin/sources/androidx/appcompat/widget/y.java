package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TintTypedArray.java */
/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TypedArray f498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TypedValue f499c;

    /* JADX INFO: compiled from: TintTypedArray.java */
    static class a {
        static int getType(TypedArray r0, int r1) {
            return r0.getType(r1);
        }

        static int a(TypedArray r0) {
            return r0.getChangingConfigurations();
        }
    }

    public static y a(Context r2, AttributeSet r3, int[] r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return new y(r5, r5.obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"), r4));
    }

    public static y a(Context r2, AttributeSet r3, int[] r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return new y(r7, r7.obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"), r4, r5, r6));
    }

    public static y a(Context r2, int r3, int[] r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return new y(r5, r5.obtainStyledAttributes(r3, r4));
    }

    private y(Context r3, TypedArray r4) {
        this.f497a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f498b = r4;
    }

    public TypedArray a() {
        return this.f498b;
    }

    public Drawable a(int r3) {
        if (this.f498b.hasValue(r3) == false) goto L9;
        int r0 = this.f498b.getResourceId(r3, 0);
        if (r0 == 0) goto L9;
        return androidx.appcompat.a.a.a.b(this.f497a, r0);
    L9:
        return this.f498b.getDrawable(r3);
    }

    public Drawable b(int r3) {
        if (this.f498b.hasValue(r3) == false) goto L8;
        int r4 = this.f498b.getResourceId(r3, 0);
        if (r4 != 0) goto L7;
        return null;
    L7:
        return d.b().a(this.f497a, r4, true);
    L8:
        return null;
    }

    public Typeface a(int r3, int r4, androidx.core.content.b.h.f r5) {
        int r6 = this.f498b.getResourceId(r3, 0);
        if (r6 != 0) goto L7;
        return null;
    L7:
        if (this.f499c != null) goto L10;
        this.f499c = new TypedValue();
    L10:
        return androidx.core.content.b.h.a(this.f497a, r6, this.f499c, r4, r5);
    }

    public Resources getResources() {
        return ZeusTransformUtils.getResources(this.f498b, "com.obric.aiagent.plugin");
    }

    public CharSequence c(int r1) {
        return this.f498b.getText(r1);
    }

    public String d(int r1) {
        return this.f498b.getString(r1);
    }

    public boolean a(int r1, boolean r2) {
        return this.f498b.getBoolean(r1, r2);
    }

    public int a(int r1, int r2) {
        return this.f498b.getInt(r1, r2);
    }

    public float a(int r1, float r2) {
        return this.f498b.getFloat(r1, r2);
    }

    public int b(int r1, int r2) {
        return this.f498b.getColor(r1, r2);
    }

    public ColorStateList e(int r3) {
        if (this.f498b.hasValue(r3) == false) goto L10;
        int r0 = this.f498b.getResourceId(r3, 0);
        if (r0 == 0) goto L10;
        ColorStateList r1 = androidx.appcompat.a.a.a.a(this.f497a, r0);
        if (r1 == null) goto L10;
        return r1;
    L10:
        return this.f498b.getColorStateList(r3);
    }

    public int c(int r1, int r2) {
        return this.f498b.getInteger(r1, r2);
    }

    public float b(int r1, float r2) {
        return this.f498b.getDimension(r1, r2);
    }

    public int d(int r1, int r2) {
        return this.f498b.getDimensionPixelOffset(r1, r2);
    }

    public int e(int r1, int r2) {
        return this.f498b.getDimensionPixelSize(r1, r2);
    }

    public int f(int r1, int r2) {
        return this.f498b.getLayoutDimension(r1, r2);
    }

    public int g(int r1, int r2) {
        return this.f498b.getResourceId(r1, r2);
    }

    public CharSequence[] f(int r1) {
        return this.f498b.getTextArray(r1);
    }

    public int getType(int r3) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return a.getType(this.f498b, r3);
    L7:
        if (this.f499c != null) goto L9;
        this.f499c = new TypedValue();
    L9:
        this.f498b.getValue(r3, this.f499c);
        return this.f499c.type;
    }

    public boolean g(int r1) {
        return this.f498b.hasValue(r1);
    }

    public void b() {
        this.f498b.recycle();
    }
}
