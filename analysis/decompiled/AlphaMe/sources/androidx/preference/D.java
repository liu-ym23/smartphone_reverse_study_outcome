package androidx.preference;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class D {

    /* renamed from: e, reason: collision with root package name */
    public static final Class[] f4006e = {Context.class, AttributeSet.class};

    /* renamed from: f, reason: collision with root package name */
    public static final HashMap f4007f = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final Context f4008a;

    /* renamed from: c, reason: collision with root package name */
    public final H f4010c;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f4009b = new Object[2];

    /* renamed from: d, reason: collision with root package name */
    public final String[] f4011d = {Preference.class.getPackage().getName() + ".", SwitchPreference.class.getPackage().getName() + "."};

    public D(Context context, H h4) {
        this.f4008a = context;
        this.f4010c = h4;
    }

    public final Preference a(String str, String[] strArr, AttributeSet attributeSet) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Class<?> cls;
        HashMap map = f4007f;
        Constructor<?> constructor = (Constructor) map.get(str);
        if (constructor == null) {
            try {
                try {
                    ClassLoader classLoader = this.f4008a.getClassLoader();
                    if (strArr == null || strArr.length == 0) {
                        cls = Class.forName(str, false, classLoader);
                    } else {
                        cls = null;
                        ClassNotFoundException e4 = null;
                        for (String str2 : strArr) {
                            try {
                                cls = Class.forName(str2 + str, false, classLoader);
                                break;
                            } catch (ClassNotFoundException e5) {
                                e4 = e5;
                            }
                        }
                        if (cls == null) {
                            if (e4 != null) {
                                throw e4;
                            }
                            throw new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                        }
                    }
                    constructor = cls.getConstructor(f4006e);
                    constructor.setAccessible(true);
                    map.put(str, constructor);
                } catch (Exception e6) {
                    InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                    inflateException.initCause(e6);
                    throw inflateException;
                }
            } catch (ClassNotFoundException e7) {
                throw e7;
            }
        }
        Object[] objArr = this.f4009b;
        objArr[1] = attributeSet;
        return (Preference) constructor.newInstance(objArr);
    }

    public final Preference b(String str, AttributeSet attributeSet) {
        try {
            return -1 == str.indexOf(46) ? a(str, this.f4011d, attributeSet) : a(str, null, attributeSet);
        } catch (InflateException e4) {
            throw e4;
        } catch (ClassNotFoundException e5) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class (not found)" + str);
            inflateException.initCause(e5);
            throw inflateException;
        } catch (Exception e6) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e6);
            throw inflateException2;
        }
    }

    public final PreferenceGroup c(XmlResourceParser xmlResourceParser, PreferenceGroup preferenceGroup) {
        int next;
        synchronized (this.f4009b) {
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlResourceParser);
            this.f4009b[0] = this.f4008a;
            do {
                try {
                    try {
                        try {
                            next = xmlResourceParser.next();
                            if (next == 2) {
                                break;
                            }
                        } catch (IOException e4) {
                            InflateException inflateException = new InflateException(xmlResourceParser.getPositionDescription() + ": " + e4.getMessage());
                            inflateException.initCause(e4);
                            throw inflateException;
                        }
                    } catch (InflateException e5) {
                        throw e5;
                    }
                } catch (XmlPullParserException e6) {
                    InflateException inflateException2 = new InflateException(e6.getMessage());
                    inflateException2.initCause(e6);
                    throw inflateException2;
                }
            } while (next != 1);
            if (next != 2) {
                throw new InflateException(xmlResourceParser.getPositionDescription() + ": No start tag found!");
            }
            PreferenceGroup preferenceGroup2 = (PreferenceGroup) b(xmlResourceParser.getName(), attributeSetAsAttributeSet);
            if (preferenceGroup == null) {
                preferenceGroup2.k(this.f4010c);
                preferenceGroup = preferenceGroup2;
            }
            d(xmlResourceParser, preferenceGroup, attributeSetAsAttributeSet);
        }
        return preferenceGroup;
    }

    public final void d(XmlResourceParser xmlResourceParser, Preference preference, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        long jLongValue;
        int depth = xmlResourceParser.getDepth();
        while (true) {
            int next = xmlResourceParser.next();
            if ((next == 3 && xmlResourceParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                String name = xmlResourceParser.getName();
                if ("intent".equals(name)) {
                    try {
                        preference.f4089m = Intent.parseIntent(this.f4008a.getResources(), xmlResourceParser, attributeSet);
                    } catch (IOException e4) {
                        XmlPullParserException xmlPullParserException = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException.initCause(e4);
                        throw xmlPullParserException;
                    }
                } else if ("extra".equals(name)) {
                    Resources resources = this.f4008a.getResources();
                    if (preference.f4091o == null) {
                        preference.f4091o = new Bundle();
                    }
                    resources.parseBundleExtra("extra", attributeSet, preference.f4091o);
                    try {
                        int depth2 = xmlResourceParser.getDepth();
                        while (true) {
                            int next2 = xmlResourceParser.next();
                            if (next2 == 1 || (next2 == 3 && xmlResourceParser.getDepth() <= depth2)) {
                                break;
                            }
                        }
                    } catch (IOException e5) {
                        XmlPullParserException xmlPullParserException2 = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException2.initCause(e5);
                        throw xmlPullParserException2;
                    }
                } else {
                    Preference preferenceB = b(name, attributeSet);
                    PreferenceGroup preferenceGroup = (PreferenceGroup) preference;
                    if (!preferenceGroup.f4104O.contains(preferenceB)) {
                        if (preferenceB.f4088l != null) {
                            PreferenceGroup preferenceGroup2 = preferenceGroup;
                            while (true) {
                                PreferenceGroup preferenceGroup3 = preferenceGroup2.f4072I;
                                if (preferenceGroup3 == null) {
                                    break;
                                } else {
                                    preferenceGroup2 = preferenceGroup3;
                                }
                            }
                            String str = preferenceB.f4088l;
                            if (preferenceGroup2.z(str) != null) {
                                Log.e("PreferenceGroup", "Found duplicated key: \"" + str + "\". This can cause unintended behaviour, please use unique keys for every preference.");
                            }
                        }
                        int i4 = preferenceB.f4083g;
                        if (i4 == Integer.MAX_VALUE) {
                            if (preferenceGroup.f4105P) {
                                int i5 = preferenceGroup.f4106Q;
                                preferenceGroup.f4106Q = i5 + 1;
                                if (i5 != i4) {
                                    preferenceB.f4083g = i5;
                                    InterfaceC0343o interfaceC0343o = preferenceB.f4070G;
                                    if (interfaceC0343o != null) {
                                        interfaceC0343o.onPreferenceHierarchyChange(preferenceB);
                                    }
                                }
                            }
                            if (preferenceB instanceof PreferenceGroup) {
                                ((PreferenceGroup) preferenceB).f4105P = preferenceGroup.f4105P;
                            }
                        }
                        int iBinarySearch = Collections.binarySearch(preferenceGroup.f4104O, preferenceB);
                        if (iBinarySearch < 0) {
                            iBinarySearch = (iBinarySearch * (-1)) - 1;
                        }
                        boolean zW = preferenceGroup.w();
                        if (preferenceB.f4098v == zW) {
                            preferenceB.f4098v = !zW;
                            preferenceB.i(preferenceB.w());
                            preferenceB.h();
                        }
                        synchronized (preferenceGroup) {
                            preferenceGroup.f4104O.add(iBinarySearch, preferenceB);
                        }
                        H h4 = preferenceGroup.f4078b;
                        String str2 = preferenceB.f4088l;
                        if (str2 == null || !preferenceGroup.f4103N.containsKey(str2)) {
                            synchronized (h4) {
                                jLongValue = h4.f4023b;
                                h4.f4023b = 1 + jLongValue;
                            }
                        } else {
                            jLongValue = ((Long) preferenceGroup.f4103N.get(str2)).longValue();
                            preferenceGroup.f4103N.remove(str2);
                        }
                        preferenceB.f4079c = jLongValue;
                        preferenceB.f4080d = true;
                        try {
                            preferenceB.k(h4);
                            preferenceB.f4080d = false;
                            if (preferenceB.f4072I != null) {
                                throw new IllegalStateException("This preference already has a parent. You must remove the existing parent before assigning a new one.");
                            }
                            preferenceB.f4072I = preferenceGroup;
                            if (preferenceGroup.f4107R) {
                                preferenceB.j();
                            }
                            InterfaceC0343o interfaceC0343o2 = preferenceGroup.f4070G;
                            if (interfaceC0343o2 != null) {
                                interfaceC0343o2.onPreferenceHierarchyChange(preferenceGroup);
                            }
                        } catch (Throwable th) {
                            preferenceB.f4080d = false;
                            throw th;
                        }
                    }
                    d(xmlResourceParser, preferenceB, attributeSet);
                }
            }
        }
    }
}
