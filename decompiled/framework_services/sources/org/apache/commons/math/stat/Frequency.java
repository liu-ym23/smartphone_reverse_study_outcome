package org.apache.commons.math.stat;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public class Frequency implements Serializable {
    private static final long serialVersionUID = -3845586908418844111L;
    private final TreeMap<Comparable<?>, Long> freqTable;

    /* JADX INFO: renamed from: org.apache.commons.math.stat.Frequency$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class NaturalComparator<T extends Comparable<T>> implements Comparator<Comparable<T>>, Serializable {
        private static final long serialVersionUID = -3852193713161395148L;

        private NaturalComparator() {
        }

        /* synthetic */ NaturalComparator(AnonymousClass1 x0) {
            this();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r1, Object r2) {
            return compare((Comparable) r1, (Comparable) r2);
        }

        public int compare(Comparable<T> o1, Comparable<T> o2) {
            return o1.compareTo(o2);
        }
    }

    public Frequency() {
        this.freqTable = new TreeMap();
    }

    public Frequency(Comparator<?> comparator) {
        this.freqTable = new TreeMap(comparator);
    }

    public String toString() {
        NumberFormat nf = NumberFormat.getPercentInstance();
        StringBuilder outBuffer = new StringBuilder();
        outBuffer.append("Value \t Freq. \t Pct. \t Cum Pct. \n");
        Iterator<Comparable<?>> iter = this.freqTable.keySet().iterator();
    L4:
        if (iter.hasNext() == false) goto L7;
        Comparable<?> value = iter.next();
        outBuffer.append(value);
        outBuffer.append('\t');
        outBuffer.append(getCount(value));
        outBuffer.append('\t');
        outBuffer.append(nf.format(getPct(value)));
        outBuffer.append('\t');
        outBuffer.append(nf.format(getCumPct(value)));
        outBuffer.append('\n');
        goto L4
    L7:
        return outBuffer.toString();
    }

    @Deprecated
    public void addValue(Object v) {
        if ((v instanceof Comparable) == false) goto L7;
        addValue((Comparable) v);
        return;
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.CLASS_DOESNT_IMPLEMENT_COMPARABLE, new Object[]{v.getClass().getName()});
    }

    public void addValue(Comparable<?> v) {
        Comparable<?> obj = v;
        if ((v instanceof Integer) == false) goto L15;
        obj = Long.valueOf(((Integer) v).longValue());
    L15:
        Long count = this.freqTable.get(obj);     // Catch: ClassCastException -> L8
        if (count != null) goto L10;
        this.freqTable.put(obj, 1L);     // Catch: ClassCastException -> L8
        return;
    L10:
        this.freqTable.put(obj, Long.valueOf(count.longValue() + 1));     // Catch: ClassCastException -> L8
        return;
    L14:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INSTANCES_NOT_COMPARABLE_TO_EXISTING_VALUES, new Object[]{v.getClass().getName()});
    }

    public void addValue(int v) {
        addValue(Long.valueOf(v));
    }

    @Deprecated
    public void addValue(Integer v) {
        addValue(Long.valueOf(v.longValue()));
    }

    public void addValue(long v) {
        addValue(Long.valueOf(v));
    }

    public void addValue(char v) {
        addValue(Character.valueOf(v));
    }

    public void clear() {
        this.freqTable.clear();
    }

    public Iterator<Comparable<?>> valuesIterator() {
        return this.freqTable.keySet().iterator();
    }

    public long getSumFreq() {
        long result = 0;
        Iterator<Long> iterator = this.freqTable.values().iterator();
    L4:
        if (iterator.hasNext() == false) goto L6;
        result = result + iterator.next().longValue();
        goto L4
    L6:
        return result;
    }

    @Deprecated
    public long getCount(Object v) {
        return getCount((Comparable) v);
    }

    public long getCount(Comparable<?> v) {
        if ((v instanceof Integer) == false) goto L15;
        return getCount(((Integer) v).longValue());
    L15:
        Long count = this.freqTable.get(v);     // Catch: ClassCastException -> L11
        if (count == null) goto L17;
        long result = count.longValue();     // Catch: ClassCastException -> L11
        return result;
    L17:
        return 0;
    L14:
        return 0;
    }

    public long getCount(int v) {
        return getCount(Long.valueOf(v));
    }

    public long getCount(long v) {
        return getCount(Long.valueOf(v));
    }

    public long getCount(char v) {
        return getCount(Character.valueOf(v));
    }

    public int getUniqueCount() {
        return this.freqTable.keySet().size();
    }

    @Deprecated
    public double getPct(Object v) {
        return getPct((Comparable) v);
    }

    public double getPct(Comparable<?> v) {
        long sumFreq = getSumFreq();
        if (sumFreq != 0) goto L7;
        return Double.NaN;
    L7:
        return getCount(v) / sumFreq;
    }

    public double getPct(int v) {
        return getPct(Long.valueOf(v));
    }

    public double getPct(long v) {
        return getPct(Long.valueOf(v));
    }

    public double getPct(char v) {
        return getPct(Character.valueOf(v));
    }

    @Deprecated
    public long getCumFreq(Object v) {
        return getCumFreq((Comparable) v);
    }

    public long getCumFreq(Comparable<?> v) {
        if (getSumFreq() != 0) goto L6;
        return 0;
    L6:
        if ((v instanceof Integer) == true) goto L8;
        Comparator<? super Comparable<?>> r0 = this.freqTable.comparator();
        if (r0 != null) goto L12;
        r0 = new NaturalComparator(null);
    L12:
        long result = 0;
        Long value = this.freqTable.get(v);     // Catch: ClassCastException -> L17
        if (value == null) goto L20;
        result = value.longValue();     // Catch: ClassCastException -> L17
    L20:
        if (r0.compare(v, this.freqTable.firstKey()) >= 0) goto L23;
        return 0;
    L23:
        if (r0.compare(v, this.freqTable.lastKey()) >= 0) goto L25;
        Iterator<Comparable<?>> values = valuesIterator();
    L28:
        if (values.hasNext() == false) goto L33;
        Comparable<?> nextValue = values.next();
        if (r0.compare(v, nextValue) <= 0) goto L32;
        result = result + getCount(nextValue);
        goto L28
    L32:
        return result;
    L33:
        return result;
    L25:
        return getSumFreq();
    L35:
        return 0;
    L8:
        return getCumFreq(((Integer) v).longValue());
    }

    public long getCumFreq(int v) {
        return getCumFreq(Long.valueOf(v));
    }

    public long getCumFreq(long v) {
        return getCumFreq(Long.valueOf(v));
    }

    public long getCumFreq(char v) {
        return getCumFreq(Character.valueOf(v));
    }

    @Deprecated
    public double getCumPct(Object v) {
        return getCumPct((Comparable) v);
    }

    public double getCumPct(Comparable<?> v) {
        long sumFreq = getSumFreq();
        if (sumFreq != 0) goto L7;
        return Double.NaN;
    L7:
        return getCumFreq(v) / sumFreq;
    }

    public double getCumPct(int v) {
        return getCumPct(Long.valueOf(v));
    }

    public double getCumPct(long v) {
        return getCumPct(Long.valueOf(v));
    }

    public double getCumPct(char v) {
        return getCumPct(Character.valueOf(v));
    }

    public int hashCode() {
        int r2 = 1 * 31;
        if (this.freqTable != null) goto L5;
        int r3 = 0;
    L6:
        int result = r2 + r3;
        return result;
    L5:
        r3 = this.freqTable.hashCode();
        goto L6
    }

    public boolean equals(Object obj) {
        if (this != obj) goto L6;
        return true;
    L6:
        if ((obj instanceof Frequency) == true) goto L8;
        return false;
    L8:
        Frequency other = (Frequency) obj;
        if (this.freqTable != null) goto L14;
        if (other.freqTable == null) goto L16;
        return false;
    L16:
        return true;
    L14:
        if (this.freqTable.equals(other.freqTable) == true) goto L16;
        return false;
    }
}
