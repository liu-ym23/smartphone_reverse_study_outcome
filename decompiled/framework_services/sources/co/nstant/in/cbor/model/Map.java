package co.nstant.in.cbor.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Map extends ChunkableDataItem {
    private final List<DataItem> keys;
    private final HashMap<DataItem, DataItem> map;

    @Override // co.nstant.in.cbor.model.ChunkableDataItem
    public /* bridge */ /* synthetic */ boolean isChunked() {
        return super.isChunked();
    }

    @Override // co.nstant.in.cbor.model.ChunkableDataItem
    public /* bridge */ /* synthetic */ ChunkableDataItem setChunked(boolean r1) {
        return super.setChunked(r1);
    }

    public Map() {
        super(MajorType.MAP);
        this.keys = new LinkedList();
        this.map = new HashMap();
    }

    public Map(int initialCapacity) {
        super(MajorType.MAP);
        this.keys = new LinkedList();
        this.map = new HashMap(initialCapacity);
    }

    public Map put(DataItem key, DataItem value) {
        if (this.map.put(key, value) != null) goto L5;
        this.keys.add(key);
    L5:
        return this;
    }

    public DataItem get(DataItem key) {
        return this.map.get(key);
    }

    public DataItem remove(DataItem key) {
        this.keys.remove(key);
        return this.map.remove(key);
    }

    public Collection<DataItem> getKeys() {
        return this.keys;
    }

    public Collection<DataItem> getValues() {
        return this.map.values();
    }

    @Override // co.nstant.in.cbor.model.ChunkableDataItem, co.nstant.in.cbor.model.DataItem
    public boolean equals(Object object) {
        if ((object instanceof Map) == false) goto L10;
        Map other = (Map) object;
        if (super.equals(object) == true) goto L7;
        return false;
    L7:
        if (this.map.equals(other.map) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // co.nstant.in.cbor.model.ChunkableDataItem, co.nstant.in.cbor.model.DataItem
    public int hashCode() {
        return super.hashCode() ^ this.map.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (isChunked() == false) goto L5;
        stringBuilder.append("{_ ");
    L6:
        Iterator<DataItem> r1 = this.keys.iterator();
    L8:
        if (r1.hasNext() == false) goto L11;
        DataItem key = r1.next();
        stringBuilder.append(key);
        stringBuilder.append(": ");
        stringBuilder.append(this.map.get(key));
        stringBuilder.append(", ");
        goto L8
    L11:
        if (stringBuilder.toString().endsWith(", ") == false) goto L13;
        stringBuilder.setLength(stringBuilder.length() - 2);
    L13:
        stringBuilder.append(" }");
        return stringBuilder.toString();
    L5:
        stringBuilder.append("{ ");
        goto L6
    }
}
