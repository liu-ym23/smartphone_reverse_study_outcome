package y;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.TypedValue;
import android.util.Xml;
import com.stepos.alphame.utils.Property;
import java.util.HashMap;

/* renamed from: y.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0983b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f15938a = false;

    /* renamed from: b, reason: collision with root package name */
    public int f15939b;

    /* renamed from: c, reason: collision with root package name */
    public int f15940c;

    /* renamed from: d, reason: collision with root package name */
    public float f15941d;

    /* renamed from: e, reason: collision with root package name */
    public String f15942e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15943f;

    /* renamed from: g, reason: collision with root package name */
    public int f15944g;

    public C0983b(C0983b c0983b, Object obj) {
        c0983b.getClass();
        this.f15939b = c0983b.f15939b;
        b(obj);
    }

    public static void a(Context context, XmlResourceParser xmlResourceParser, HashMap map) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), r.f16154d);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        String string = null;
        int i4 = 0;
        boolean z4 = false;
        Object objValueOf = null;
        for (int i5 = 0; i5 < indexCount; i5++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i5);
            int i6 = 1;
            if (index == 0) {
                string = typedArrayObtainStyledAttributes.getString(index);
                if (string != null && string.length() > 0) {
                    string = Character.toUpperCase(string.charAt(0)) + string.substring(1);
                }
            } else if (index == 10) {
                string = typedArrayObtainStyledAttributes.getString(index);
                z4 = true;
            } else if (index == 1) {
                objValueOf = Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(index, false));
                i4 = 6;
            } else {
                int i7 = 3;
                if (index == 3) {
                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                } else {
                    i7 = 4;
                    if (index == 2) {
                        objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                    } else {
                        if (index == 7) {
                            objValueOf = Float.valueOf(TypedValue.applyDimension(1, typedArrayObtainStyledAttributes.getDimension(index, Property.DEFAULT_FLOAT_VALUE), context.getResources().getDisplayMetrics()));
                        } else if (index == 4) {
                            objValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getDimension(index, Property.DEFAULT_FLOAT_VALUE));
                        } else {
                            i7 = 5;
                            if (index == 5) {
                                objValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, Float.NaN));
                                i4 = 2;
                            } else {
                                if (index == 6) {
                                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getInteger(index, -1));
                                } else if (index == 9) {
                                    objValueOf = typedArrayObtainStyledAttributes.getString(index);
                                } else {
                                    i6 = 8;
                                    if (index == 8) {
                                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                        if (resourceId == -1) {
                                            resourceId = typedArrayObtainStyledAttributes.getInt(index, -1);
                                        }
                                        objValueOf = Integer.valueOf(resourceId);
                                    }
                                }
                                i4 = i6;
                            }
                        }
                        i4 = 7;
                    }
                }
                i4 = i7;
            }
        }
        if (string != null && objValueOf != null) {
            C0983b c0983b = new C0983b();
            c0983b.f15939b = i4;
            c0983b.f15938a = z4;
            c0983b.b(objValueOf);
            map.put(string, c0983b);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void b(Object obj) {
        switch (t.h.a(this.f15939b)) {
            case 0:
            case 7:
                this.f15940c = ((Integer) obj).intValue();
                break;
            case 1:
                this.f15941d = ((Float) obj).floatValue();
                break;
            case 2:
            case 3:
                this.f15944g = ((Integer) obj).intValue();
                break;
            case 4:
                this.f15942e = (String) obj;
                break;
            case 5:
                this.f15943f = ((Boolean) obj).booleanValue();
                break;
            case 6:
                this.f15941d = ((Float) obj).floatValue();
                break;
        }
    }
}
