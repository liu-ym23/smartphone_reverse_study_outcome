package co.nstant.in.cbor.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Array extends ChunkableDataItem {
    private final ArrayList<DataItem> objects;

    @Override // co.nstant.in.cbor.model.ChunkableDataItem
    public /* bridge */ /* synthetic */ boolean isChunked() {
        return super.isChunked();
    }

    @Override // co.nstant.in.cbor.model.ChunkableDataItem
    public /* bridge */ /* synthetic */ ChunkableDataItem setChunked(boolean r1) {
        return super.setChunked(r1);
    }

    public Array() {
        super(MajorType.ARRAY);
        this.objects = new ArrayList();
    }

    public Array add(DataItem object) {
        this.objects.add(object);
        return this;
    }

    public List<DataItem> getDataItems() {
        return this.objects;
    }

    @Override // co.nstant.in.cbor.model.ChunkableDataItem, co.nstant.in.cbor.model.DataItem
    public boolean equals(Object object) {
        if ((object instanceof Array) == false) goto L10;
        Array other = (Array) object;
        if (super.equals(object) == true) goto L7;
        return false;
    L7:
        if (this.objects.equals(other.objects) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // co.nstant.in.cbor.model.ChunkableDataItem, co.nstant.in.cbor.model.DataItem
    public int hashCode() {
        return super.hashCode() ^ this.objects.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        if (isChunked() == false) goto L5;
        stringBuilder.append("_ ");
    L5:
        stringBuilder.append(Arrays.toString(this.objects.toArray()).substring(1));
        return stringBuilder.toString();
    }
}
