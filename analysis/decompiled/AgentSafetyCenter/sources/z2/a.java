package z2;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.TypedValue;
import android.util.Xml;
import java.util.HashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f16177a = false;

    /* renamed from: b, reason: collision with root package name */
    public int f16178b;

    /* renamed from: c, reason: collision with root package name */
    public int f16179c;

    /* renamed from: d, reason: collision with root package name */
    public float f16180d;

    /* renamed from: e, reason: collision with root package name */
    public String f16181e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f16182f;

    /* renamed from: g, reason: collision with root package name */
    public int f16183g;

    public a(a aVar, Object obj) {
        aVar.getClass();
        this.f16178b = aVar.f16178b;
        b(obj);
    }

    public static void a(Context context, XmlResourceParser xmlResourceParser, HashMap map) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), q.f16335d);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        String string = null;
        int i = 0;
        boolean z10 = false;
        Object objValueOf = null;
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i3);
            int i10 = 1;
            if (index == 0) {
                string = typedArrayObtainStyledAttributes.getString(index);
                if (string != null && string.length() > 0) {
                    string = Character.toUpperCase(string.charAt(0)) + string.substring(1);
                }
            } else if (index == 10) {
                string = typedArrayObtainStyledAttributes.getString(index);
                z10 = true;
            } else if (index == 1) {
                objValueOf = Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(index, false));
                i = 6;
            } else {
                int i11 = 3;
                if (index == 3) {
                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                } else {
                    i11 = 4;
                    if (index == 2) {
                        objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                    } else {
                        if (index == 7) {
                            objValueOf = Float.valueOf(TypedValue.applyDimension(1, typedArrayObtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                        } else if (index == 4) {
                            objValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                        } else {
                            i11 = 5;
                            if (index == 5) {
                                objValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, Float.NaN));
                                i = 2;
                            } else {
                                if (index == 6) {
                                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getInteger(index, -1));
                                } else if (index == 9) {
                                    objValueOf = typedArrayObtainStyledAttributes.getString(index);
                                } else {
                                    i10 = 8;
                                    if (index == 8) {
                                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                        if (resourceId == -1) {
                                            resourceId = typedArrayObtainStyledAttributes.getInt(index, -1);
                                        }
                                        objValueOf = Integer.valueOf(resourceId);
                                    }
                                }
                                i = i10;
                            }
                        }
                        i = 7;
                    }
                }
                i = i11;
            }
        }
        if (string != null && objValueOf != null) {
            a aVar = new a();
            aVar.f16178b = i;
            aVar.f16177a = z10;
            aVar.b(objValueOf);
            map.put(string, aVar);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void b(Object obj) {
        switch (s.f.c(this.f16178b)) {
            case 0:
            case 7:
                this.f16179c = ((Integer) obj).intValue();
                break;
            case 1:
                this.f16180d = ((Float) obj).floatValue();
                break;
            case 2:
            case 3:
                this.f16183g = ((Integer) obj).intValue();
                break;
            case 4:
                this.f16181e = (String) obj;
                break;
            case 5:
                this.f16182f = ((Boolean) obj).booleanValue();
                break;
            case 6:
                this.f16180d = ((Float) obj).floatValue();
                break;
        }
    }
}
