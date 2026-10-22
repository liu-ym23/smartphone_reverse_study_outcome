package com.bytedance.android.livehostapi.platform.depend;

import com.bytedance.android.live.base.IService;
import java.util.Set;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
public interface IPropertyCache extends IService {

    public interface IProperty {
        Object defValue();

        String key();

        boolean supportPersist();

        PropertyType type();
    }

    public static final enum PropertyType extends Enum<PropertyType> {
        private static final /* synthetic */ PropertyType[] $VALUES = null;
        public static final PropertyType Boolean = null;
        public static final PropertyType Float = null;
        public static final PropertyType Integer = null;
        public static final PropertyType Long = null;
        public static final PropertyType StrSet = null;
        public static final PropertyType String = null;

        static {
            PropertyType r100 = new PropertyType("Boolean", 0);
            Boolean = r100;
            PropertyType r101 = new PropertyType("Integer", 1);
            Integer = r101;
            PropertyType r102 = new PropertyType("Long", 2);
            Long = r102;
            PropertyType r103 = new PropertyType("Float", 3);
            Float = r103;
            PropertyType r104 = new PropertyType("String", 4);
            String = r104;
            PropertyType r105 = new PropertyType("StrSet", 5);
            StrSet = r105;
            $VALUES = new PropertyType[]{r100, r101, r102, r103, r104, r105};
        }

        public static PropertyType[] values() {
            return (PropertyType[]) $VALUES.clone();
        }

        public static PropertyType valueOf(String r100) {
            return (PropertyType) a.a(PropertyType.class, r100);
        }

        private PropertyType(String r100, int r101) {
            super(r100, r101);
        }
    }

    boolean getBoolean(IProperty r100);

    float getFloat(IProperty r100);

    int getInt(IProperty r100);

    long getLong(IProperty r100);

    Set<String> getStrSet(IProperty r100);

    String getString(IProperty r100);

    void removeProperty(IProperty r100);

    void setBoolean(IProperty r100, boolean r101);

    void setFloat(IProperty r100, float r101);

    void setInt(IProperty r100, int r101);

    void setLong(IProperty r100, long r101);

    void setStrSet(IProperty r100, Set<String> r101);

    void setString(IProperty r100, String r101);
}
