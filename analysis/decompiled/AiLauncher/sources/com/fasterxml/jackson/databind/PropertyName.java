package com.fasterxml.jackson.databind;

import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.util.InternCache;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes2.dex */
public class PropertyName implements Serializable {
    private static final String _NO_NAME = "";
    private static final String _USE_DEFAULT = "";
    private static final long serialVersionUID = 1;
    protected SerializableString _encodedSimple;
    protected final String _namespace;
    protected final String _simpleName;
    public static final PropertyName USE_DEFAULT = new PropertyName("", null);
    public static final PropertyName NO_NAME = new PropertyName(new String(""), null);

    public PropertyName(String str) {
        this(str, null);
    }

    private static String _nonEmpty(String str, String str2) {
        return str == null ? str2 : (str2 != null && str.isEmpty()) ? str2 : str;
    }

    public static PropertyName construct(String str) {
        return (str == null || str.isEmpty()) ? USE_DEFAULT : new PropertyName(InternCache.instance.intern(str), null);
    }

    public static PropertyName merge(PropertyName propertyName, PropertyName propertyName2) {
        if (propertyName == null) {
            return propertyName2;
        }
        if (propertyName2 != null && propertyName != NO_NAME) {
            String str_nonEmpty = _nonEmpty(propertyName._namespace, propertyName2._namespace);
            String str_nonEmpty2 = _nonEmpty(propertyName._simpleName, propertyName2._simpleName);
            if (str_nonEmpty != propertyName._namespace || str_nonEmpty2 != propertyName._simpleName) {
                return (str_nonEmpty == propertyName2._namespace && str_nonEmpty2 == propertyName2._simpleName) ? propertyName2 : construct(str_nonEmpty2, str_nonEmpty);
            }
        }
        return propertyName;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        PropertyName propertyName = (PropertyName) obj;
        String str = this._simpleName;
        if (str == null) {
            if (propertyName._simpleName != null) {
                return false;
            }
        } else if (!str.equals(propertyName._simpleName)) {
            return false;
        }
        String str2 = this._namespace;
        return str2 == null ? propertyName._namespace == null : str2.equals(propertyName._namespace);
    }

    public String getNamespace() {
        return this._namespace;
    }

    public String getSimpleName() {
        return this._simpleName;
    }

    public boolean hasNamespace() {
        return this._namespace != null;
    }

    public boolean hasSimpleName() {
        return !this._simpleName.isEmpty();
    }

    public int hashCode() {
        return (Objects.hashCode(this._simpleName) * 31) + Objects.hashCode(this._namespace);
    }

    public PropertyName internSimpleName() {
        String strIntern;
        return (this._simpleName.isEmpty() || (strIntern = InternCache.instance.intern(this._simpleName)) == this._simpleName) ? this : new PropertyName(strIntern, this._namespace);
    }

    public boolean isEmpty() {
        return this._namespace == null && this._simpleName.isEmpty();
    }

    public Object readResolve() {
        if (this._namespace != null) {
            return this;
        }
        String str = this._simpleName;
        return (str == null || "".equals(str)) ? USE_DEFAULT : this;
    }

    public SerializableString simpleAsEncoded(MapperConfig<?> mapperConfig) {
        SerializableString serializableString = this._encodedSimple;
        if (serializableString != null) {
            return serializableString;
        }
        SerializableString serializedString = mapperConfig == null ? new SerializedString(this._simpleName) : mapperConfig.compileString(this._simpleName);
        this._encodedSimple = serializedString;
        return serializedString;
    }

    public String toString() {
        if (this._namespace == null) {
            return this._simpleName;
        }
        return Const.STR_MART_JSON_BEGIN + this._namespace + "}" + this._simpleName;
    }

    public PropertyName withNamespace(String str) {
        return (str != null ? !str.equals(this._namespace) : this._namespace != null) ? new PropertyName(this._simpleName, str) : this;
    }

    public PropertyName withSimpleName(String str) {
        if (str == null) {
            str = "";
        }
        return str.equals(this._simpleName) ? this : new PropertyName(str, this._namespace);
    }

    public PropertyName(String str, String str2) {
        this._simpleName = ClassUtil.nonNullString(str);
        this._namespace = str2;
    }

    public boolean hasSimpleName(String str) {
        return this._simpleName.equals(str);
    }

    public static PropertyName construct(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null && str.isEmpty()) {
            return USE_DEFAULT;
        }
        return new PropertyName(InternCache.instance.intern(str), str2);
    }
}
