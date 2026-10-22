package com.typesafe.config.impl;

import com.typesafe.config.ConfigValueType;
import com.typesafe.config.impl.ConfigString;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public final class y {

    public static class a implements Comparator<Map.Entry<Integer, AbstractConfigValue>> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<Integer, AbstractConfigValue> entry, Map.Entry<Integer, AbstractConfigValue> entry2) {
            return Integer.compare(entry.getKey().intValue(), entry2.getKey().intValue());
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31905a;

        static {
            int[] iArr = new int[ConfigValueType.values().length];
            f31905a = iArr;
            try {
                iArr[ConfigValueType.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31905a[ConfigValueType.NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31905a[ConfigValueType.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31905a[ConfigValueType.LIST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31905a[ConfigValueType.OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f31905a[ConfigValueType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static AbstractConfigValue a(AbstractConfigValue abstractConfigValue, ConfigValueType configValueType) {
        ConfigValueType configValueTypeC = abstractConfigValue.c();
        ConfigValueType configValueType2 = ConfigValueType.STRING;
        if (configValueTypeC == configValueType2) {
            String str = (String) abstractConfigValue.a();
            int i10 = b.f31905a[configValueType.ordinal()];
            if (i10 == 1) {
                try {
                    try {
                        return new ConfigLong(abstractConfigValue.e(), Long.parseLong(str), str);
                    } catch (NumberFormatException unused) {
                        return new ConfigDouble(abstractConfigValue.e(), Double.parseDouble(str), str);
                    }
                } catch (NumberFormatException unused2) {
                }
            } else if (i10 != 2) {
                if (i10 == 3) {
                    if (str.equals("true") || str.equals("yes") || str.equals(W4.a.ENABLE_ON)) {
                        return new ConfigBoolean(abstractConfigValue.e(), true);
                    }
                    if (str.equals("false") || str.equals("no") || str.equals(W4.a.ENABLE_OFF)) {
                        return new ConfigBoolean(abstractConfigValue.e(), false);
                    }
                }
            } else if (str.equals("null")) {
                return new ConfigNull(abstractConfigValue.e());
            }
        } else if (configValueType == configValueType2) {
            int i11 = b.f31905a[abstractConfigValue.c().ordinal()];
            if (i11 == 1 || i11 == 3) {
                return new ConfigString.Quoted(abstractConfigValue.e(), abstractConfigValue.m0());
            }
        } else if (configValueType == ConfigValueType.LIST && abstractConfigValue.c() == ConfigValueType.OBJECT) {
            AbstractC3897c abstractC3897c = (AbstractC3897c) abstractConfigValue;
            HashMap map = new HashMap();
            for (String str2 : abstractC3897c.keySet()) {
                try {
                    int i12 = Integer.parseInt(str2, 10);
                    if (i12 >= 0) {
                        map.put(Integer.valueOf(i12), abstractC3897c.get(str2));
                    }
                } catch (NumberFormatException unused3) {
                }
            }
            if (!map.isEmpty()) {
                ArrayList arrayList = new ArrayList(map.entrySet());
                Collections.sort(arrayList, new a());
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((Map.Entry) it.next()).getValue());
                }
                return new SimpleConfigList(abstractConfigValue.e(), arrayList2);
            }
        }
        return abstractConfigValue;
    }
}
