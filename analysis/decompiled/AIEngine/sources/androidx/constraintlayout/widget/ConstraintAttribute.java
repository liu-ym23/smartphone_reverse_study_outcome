package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.TypedValue;
import android.util.Xml;
import java.util.HashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ConstraintAttribute {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1252a = false;

    /* renamed from: b, reason: collision with root package name */
    public String f1253b;

    /* renamed from: c, reason: collision with root package name */
    public AttributeType f1254c;

    /* renamed from: d, reason: collision with root package name */
    public int f1255d;

    /* renamed from: e, reason: collision with root package name */
    public float f1256e;

    /* renamed from: f, reason: collision with root package name */
    public String f1257f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1258g;
    public int h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class AttributeType {

        /* renamed from: a, reason: collision with root package name */
        public static final AttributeType f1259a;

        /* renamed from: b, reason: collision with root package name */
        public static final AttributeType f1260b;

        /* renamed from: c, reason: collision with root package name */
        public static final AttributeType f1261c;

        /* renamed from: d, reason: collision with root package name */
        public static final AttributeType f1262d;

        /* renamed from: e, reason: collision with root package name */
        public static final AttributeType f1263e;
        public static final AttributeType h;

        /* renamed from: j, reason: collision with root package name */
        public static final AttributeType f1264j;

        /* renamed from: k, reason: collision with root package name */
        public static final AttributeType f1265k;

        /* renamed from: l, reason: collision with root package name */
        public static final /* synthetic */ AttributeType[] f1266l;

        static {
            AttributeType attributeType = new AttributeType("INT_TYPE", 0);
            f1259a = attributeType;
            AttributeType attributeType2 = new AttributeType("FLOAT_TYPE", 1);
            f1260b = attributeType2;
            AttributeType attributeType3 = new AttributeType("COLOR_TYPE", 2);
            f1261c = attributeType3;
            AttributeType attributeType4 = new AttributeType("COLOR_DRAWABLE_TYPE", 3);
            f1262d = attributeType4;
            AttributeType attributeType5 = new AttributeType("STRING_TYPE", 4);
            f1263e = attributeType5;
            AttributeType attributeType6 = new AttributeType("BOOLEAN_TYPE", 5);
            h = attributeType6;
            AttributeType attributeType7 = new AttributeType("DIMENSION_TYPE", 6);
            f1264j = attributeType7;
            AttributeType attributeType8 = new AttributeType("REFERENCE_TYPE", 7);
            f1265k = attributeType8;
            f1266l = new AttributeType[]{attributeType, attributeType2, attributeType3, attributeType4, attributeType5, attributeType6, attributeType7, attributeType8};
        }

        public AttributeType() {
            throw null;
        }

        public static AttributeType valueOf(String str) {
            return (AttributeType) Enum.valueOf(AttributeType.class, str);
        }

        public static AttributeType[] values() {
            return (AttributeType[]) f1266l.clone();
        }
    }

    public ConstraintAttribute(ConstraintAttribute constraintAttribute, Object obj) {
        this.f1253b = constraintAttribute.f1253b;
        this.f1254c = constraintAttribute.f1254c;
        b(obj);
    }

    public static void a(Context context, XmlResourceParser xmlResourceParser, HashMap map) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), j0.d.f9643e);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        String string = null;
        Object objValueOf = null;
        AttributeType attributeType = null;
        boolean z = false;
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i10);
            if (index == 0) {
                string = typedArrayObtainStyledAttributes.getString(index);
                if (string != null && string.length() > 0) {
                    string = Character.toUpperCase(string.charAt(0)) + string.substring(1);
                }
            } else if (index == 10) {
                string = typedArrayObtainStyledAttributes.getString(index);
                z = true;
            } else if (index == 1) {
                objValueOf = Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(index, false));
                attributeType = AttributeType.h;
            } else if (index == 3) {
                objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                attributeType = AttributeType.f1261c;
            } else if (index == 2) {
                objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                attributeType = AttributeType.f1262d;
            } else {
                AttributeType attributeType2 = AttributeType.f1264j;
                if (index == 7) {
                    objValueOf = Float.valueOf(TypedValue.applyDimension(1, typedArrayObtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == 4) {
                    objValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == 5) {
                    objValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, Float.NaN));
                    attributeType = AttributeType.f1260b;
                } else if (index == 6) {
                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getInteger(index, -1));
                    attributeType = AttributeType.f1259a;
                } else if (index == 9) {
                    objValueOf = typedArrayObtainStyledAttributes.getString(index);
                    attributeType = AttributeType.f1263e;
                } else if (index == 8) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                    if (resourceId == -1) {
                        resourceId = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    objValueOf = Integer.valueOf(resourceId);
                    attributeType = AttributeType.f1265k;
                }
                attributeType = attributeType2;
            }
        }
        if (string != null && objValueOf != null) {
            ConstraintAttribute constraintAttribute = new ConstraintAttribute();
            constraintAttribute.f1253b = string;
            constraintAttribute.f1254c = attributeType;
            constraintAttribute.f1252a = z;
            constraintAttribute.b(objValueOf);
            map.put(string, constraintAttribute);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void b(Object obj) {
        switch (this.f1254c.ordinal()) {
            case 0:
            case 7:
                this.f1255d = ((Integer) obj).intValue();
                break;
            case 1:
                this.f1256e = ((Float) obj).floatValue();
                break;
            case 2:
            case 3:
                this.h = ((Integer) obj).intValue();
                break;
            case 4:
                this.f1257f = (String) obj;
                break;
            case 5:
                this.f1258g = ((Boolean) obj).booleanValue();
                break;
            case 6:
                this.f1256e = ((Float) obj).floatValue();
                break;
        }
    }
}
