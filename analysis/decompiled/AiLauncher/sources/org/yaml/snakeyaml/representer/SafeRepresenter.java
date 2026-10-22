package org.yaml.snakeyaml.representer;

import O6.l;
import androidx.exifinterface.media.ExifInterface;
import io.ktor.sse.ServerSentEventKt;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.reader.StreamReader;

/* loaded from: classes5.dex */
class SafeRepresenter extends BaseRepresenter {
    private static final Pattern MULTILINE_PATTERN = Pattern.compile("\n|\u0085|\u2028|\u2029");
    protected Map<Class<? extends Object>, Tag> classTags;
    protected DumperOptions.NonPrintableStyle nonPrintableStyle;
    protected TimeZone timeZone = null;

    public static class IteratorWrapper implements Iterable<Object> {
        private final Iterator<Object> iter;

        public IteratorWrapper(Iterator<Object> it) {
            this.iter = it;
        }

        @Override // java.lang.Iterable
        public Iterator<Object> iterator() {
            return this.iter;
        }
    }

    public class RepresentArray implements Represent {
        public RepresentArray() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            return SafeRepresenter.this.representSequence(Tag.SEQ, Arrays.asList((Object[]) obj), DumperOptions.FlowStyle.AUTO);
        }
    }

    public class RepresentBoolean implements Represent {
        public RepresentBoolean() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            return SafeRepresenter.this.representScalar(Tag.BOOL, Boolean.TRUE.equals(obj) ? "true" : "false");
        }
    }

    public class RepresentByteArray implements Represent {
        public RepresentByteArray() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            return SafeRepresenter.this.representScalar(Tag.BINARY, String.valueOf(Base64.getEncoder().encodeToString((byte[]) obj)), DumperOptions.ScalarStyle.LITERAL);
        }
    }

    public class RepresentDate implements Represent {
        public RepresentDate() {
        }

        public Tag getDefaultTag() {
            return Tag.TIMESTAMP;
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            Calendar calendar;
            if (obj instanceof Calendar) {
                calendar = (Calendar) obj;
            } else {
                calendar = Calendar.getInstance(SafeRepresenter.this.getTimeZone() == null ? TimeZone.getTimeZone("UTC") : SafeRepresenter.this.timeZone);
                calendar.setTime((Date) obj);
            }
            int i10 = calendar.get(1);
            int i11 = calendar.get(2) + 1;
            int i12 = calendar.get(5);
            int i13 = calendar.get(11);
            int i14 = calendar.get(12);
            int i15 = calendar.get(13);
            int i16 = calendar.get(14);
            StringBuilder sb2 = new StringBuilder(String.valueOf(i10));
            while (sb2.length() < 4) {
                sb2.insert(0, "0");
            }
            sb2.append(l.DATE_SEPARATOR);
            if (i11 < 10) {
                sb2.append("0");
            }
            sb2.append(i11);
            sb2.append(l.DATE_SEPARATOR);
            if (i12 < 10) {
                sb2.append("0");
            }
            sb2.append(i12);
            sb2.append(ExifInterface.GPS_DIRECTION_TRUE);
            if (i13 < 10) {
                sb2.append("0");
            }
            sb2.append(i13);
            sb2.append(ServerSentEventKt.COLON);
            if (i14 < 10) {
                sb2.append("0");
            }
            sb2.append(i14);
            sb2.append(ServerSentEventKt.COLON);
            if (i15 < 10) {
                sb2.append("0");
            }
            sb2.append(i15);
            if (i16 > 0) {
                if (i16 < 10) {
                    sb2.append(".00");
                } else if (i16 < 100) {
                    sb2.append(".0");
                } else {
                    sb2.append(".");
                }
                sb2.append(i16);
            }
            int offset = calendar.getTimeZone().getOffset(calendar.getTime().getTime());
            if (offset == 0) {
                sb2.append('Z');
            } else {
                if (offset < 0) {
                    sb2.append('-');
                    offset *= -1;
                } else {
                    sb2.append('+');
                }
                int i17 = offset / 60000;
                int i18 = i17 / 60;
                int i19 = i17 % 60;
                if (i18 < 10) {
                    sb2.append('0');
                }
                sb2.append(i18);
                sb2.append(':');
                if (i19 < 10) {
                    sb2.append('0');
                }
                sb2.append(i19);
            }
            SafeRepresenter safeRepresenter = SafeRepresenter.this;
            return safeRepresenter.representScalar(safeRepresenter.getTag(obj.getClass(), getDefaultTag()), sb2.toString());
        }
    }

    public class RepresentEnum implements Represent {
        public RepresentEnum() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            Tag tag = new Tag((Class<? extends Object>) obj.getClass());
            SafeRepresenter safeRepresenter = SafeRepresenter.this;
            return safeRepresenter.representScalar(safeRepresenter.getTag(obj.getClass(), tag), ((Enum) obj).name());
        }
    }

    public class RepresentIterator implements Represent {
        public RepresentIterator() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            Iterator it = (Iterator) obj;
            SafeRepresenter safeRepresenter = SafeRepresenter.this;
            return safeRepresenter.representSequence(safeRepresenter.getTag(obj.getClass(), Tag.SEQ), new IteratorWrapper(it), DumperOptions.FlowStyle.AUTO);
        }
    }

    public class RepresentList implements Represent {
        public RepresentList() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            SafeRepresenter safeRepresenter = SafeRepresenter.this;
            return safeRepresenter.representSequence(safeRepresenter.getTag(obj.getClass(), Tag.SEQ), (List) obj, DumperOptions.FlowStyle.AUTO);
        }
    }

    public class RepresentMap implements Represent {
        public RepresentMap() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            SafeRepresenter safeRepresenter = SafeRepresenter.this;
            return safeRepresenter.representMapping(safeRepresenter.getTag(obj.getClass(), Tag.MAP), (Map) obj, DumperOptions.FlowStyle.AUTO);
        }
    }

    public class RepresentNull implements Represent {
        public RepresentNull() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            return SafeRepresenter.this.representScalar(Tag.NULL, "null");
        }
    }

    public class RepresentNumber implements Represent {
        public RepresentNumber() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            Tag tag;
            String string;
            if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof BigInteger)) {
                tag = Tag.INT;
                string = obj.toString();
            } else {
                Number number = (Number) obj;
                tag = Tag.FLOAT;
                string = number.equals(Double.valueOf(Double.NaN)) ? ".NaN" : number.equals(Double.valueOf(Double.POSITIVE_INFINITY)) ? ".inf" : number.equals(Double.valueOf(Double.NEGATIVE_INFINITY)) ? "-.inf" : number.toString();
            }
            SafeRepresenter safeRepresenter = SafeRepresenter.this;
            return safeRepresenter.representScalar(safeRepresenter.getTag(obj.getClass(), tag), string);
        }
    }

    public class RepresentPrimitiveArray implements Represent {
        public RepresentPrimitiveArray() {
        }

        private List<Boolean> asBooleanList(Object obj) {
            boolean[] zArr = (boolean[]) obj;
            ArrayList arrayList = new ArrayList(zArr.length);
            for (boolean z10 : zArr) {
                arrayList.add(Boolean.valueOf(z10));
            }
            return arrayList;
        }

        private List<Byte> asByteList(Object obj) {
            byte[] bArr = (byte[]) obj;
            ArrayList arrayList = new ArrayList(bArr.length);
            for (byte b10 : bArr) {
                arrayList.add(Byte.valueOf(b10));
            }
            return arrayList;
        }

        private List<Character> asCharList(Object obj) {
            char[] cArr = (char[]) obj;
            ArrayList arrayList = new ArrayList(cArr.length);
            for (char c10 : cArr) {
                arrayList.add(Character.valueOf(c10));
            }
            return arrayList;
        }

        private List<Double> asDoubleList(Object obj) {
            double[] dArr = (double[]) obj;
            ArrayList arrayList = new ArrayList(dArr.length);
            for (double d10 : dArr) {
                arrayList.add(Double.valueOf(d10));
            }
            return arrayList;
        }

        private List<Float> asFloatList(Object obj) {
            float[] fArr = (float[]) obj;
            ArrayList arrayList = new ArrayList(fArr.length);
            for (float f10 : fArr) {
                arrayList.add(Float.valueOf(f10));
            }
            return arrayList;
        }

        private List<Integer> asIntList(Object obj) {
            int[] iArr = (int[]) obj;
            ArrayList arrayList = new ArrayList(iArr.length);
            for (int i10 : iArr) {
                arrayList.add(Integer.valueOf(i10));
            }
            return arrayList;
        }

        private List<Long> asLongList(Object obj) {
            long[] jArr = (long[]) obj;
            ArrayList arrayList = new ArrayList(jArr.length);
            for (long j10 : jArr) {
                arrayList.add(Long.valueOf(j10));
            }
            return arrayList;
        }

        private List<Short> asShortList(Object obj) {
            short[] sArr = (short[]) obj;
            ArrayList arrayList = new ArrayList(sArr.length);
            for (short s10 : sArr) {
                arrayList.add(Short.valueOf(s10));
            }
            return arrayList;
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (Byte.TYPE == componentType) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, asByteList(obj), DumperOptions.FlowStyle.AUTO);
            }
            if (Short.TYPE == componentType) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, asShortList(obj), DumperOptions.FlowStyle.AUTO);
            }
            if (Integer.TYPE == componentType) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, asIntList(obj), DumperOptions.FlowStyle.AUTO);
            }
            if (Long.TYPE == componentType) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, asLongList(obj), DumperOptions.FlowStyle.AUTO);
            }
            if (Float.TYPE == componentType) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, asFloatList(obj), DumperOptions.FlowStyle.AUTO);
            }
            if (Double.TYPE == componentType) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, asDoubleList(obj), DumperOptions.FlowStyle.AUTO);
            }
            if (Character.TYPE == componentType) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, asCharList(obj), DumperOptions.FlowStyle.AUTO);
            }
            if (Boolean.TYPE == componentType) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, asBooleanList(obj), DumperOptions.FlowStyle.AUTO);
            }
            throw new YAMLException("Unexpected primitive '" + componentType.getCanonicalName() + "'");
        }
    }

    public class RepresentSet implements Represent {
        public RepresentSet() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = ((Set) obj).iterator();
            while (it.hasNext()) {
                linkedHashMap.put(it.next(), null);
            }
            SafeRepresenter safeRepresenter = SafeRepresenter.this;
            return safeRepresenter.representMapping(safeRepresenter.getTag(obj.getClass(), Tag.SET), linkedHashMap, DumperOptions.FlowStyle.AUTO);
        }
    }

    public class RepresentString implements Represent {
        public RepresentString() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            Tag tag = Tag.STR;
            DumperOptions.ScalarStyle scalarStyle = SafeRepresenter.this.defaultScalarStyle;
            String string = obj.toString();
            if (SafeRepresenter.this.nonPrintableStyle == DumperOptions.NonPrintableStyle.BINARY && !StreamReader.isPrintable(string)) {
                tag = Tag.BINARY;
                Charset charset = StandardCharsets.UTF_8;
                byte[] bytes = string.getBytes(charset);
                if (!new String(bytes, charset).equals(string)) {
                    throw new YAMLException("invalid string value has occurred");
                }
                string = Base64.getEncoder().encodeToString(bytes);
                scalarStyle = DumperOptions.ScalarStyle.LITERAL;
            }
            if (SafeRepresenter.this.defaultScalarStyle == DumperOptions.ScalarStyle.PLAIN && SafeRepresenter.MULTILINE_PATTERN.matcher(string).find()) {
                scalarStyle = DumperOptions.ScalarStyle.LITERAL;
            }
            return SafeRepresenter.this.representScalar(tag, string, scalarStyle);
        }
    }

    public class RepresentUuid implements Represent {
        public RepresentUuid() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            SafeRepresenter safeRepresenter = SafeRepresenter.this;
            return safeRepresenter.representScalar(safeRepresenter.getTag(obj.getClass(), new Tag((Class<? extends Object>) UUID.class)), obj.toString());
        }
    }

    public SafeRepresenter(DumperOptions dumperOptions) {
        if (dumperOptions == null) {
            throw new NullPointerException("DumperOptions must be provided.");
        }
        this.nullRepresenter = new RepresentNull();
        this.representers.put(String.class, new RepresentString());
        this.representers.put(Boolean.class, new RepresentBoolean());
        this.representers.put(Character.class, new RepresentString());
        this.representers.put(UUID.class, new RepresentUuid());
        this.representers.put(byte[].class, new RepresentByteArray());
        RepresentPrimitiveArray representPrimitiveArray = new RepresentPrimitiveArray();
        this.representers.put(short[].class, representPrimitiveArray);
        this.representers.put(int[].class, representPrimitiveArray);
        this.representers.put(long[].class, representPrimitiveArray);
        this.representers.put(float[].class, representPrimitiveArray);
        this.representers.put(double[].class, representPrimitiveArray);
        this.representers.put(char[].class, representPrimitiveArray);
        this.representers.put(boolean[].class, representPrimitiveArray);
        this.multiRepresenters.put(Number.class, new RepresentNumber());
        this.multiRepresenters.put(List.class, new RepresentList());
        this.multiRepresenters.put(Map.class, new RepresentMap());
        this.multiRepresenters.put(Set.class, new RepresentSet());
        this.multiRepresenters.put(Iterator.class, new RepresentIterator());
        this.multiRepresenters.put(new Object[0].getClass(), new RepresentArray());
        this.multiRepresenters.put(Date.class, new RepresentDate());
        this.multiRepresenters.put(Enum.class, new RepresentEnum());
        this.multiRepresenters.put(Calendar.class, new RepresentDate());
        this.classTags = new HashMap();
        this.nonPrintableStyle = dumperOptions.getNonPrintableStyle();
        setDefaultScalarStyle(dumperOptions.getDefaultScalarStyle());
        setDefaultFlowStyle(dumperOptions.getDefaultFlowStyle());
    }

    public Tag addClassTag(Class<? extends Object> cls, Tag tag) {
        if (tag != null) {
            return this.classTags.put(cls, tag);
        }
        throw new NullPointerException("Tag must be provided.");
    }

    public Tag getTag(Class<?> cls, Tag tag) {
        return this.classTags.containsKey(cls) ? this.classTags.get(cls) : tag;
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }
}
