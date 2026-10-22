package co.nstant.in.cbor.builder;

import co.nstant.in.cbor.builder.AbstractBuilder;
import co.nstant.in.cbor.model.Array;
import co.nstant.in.cbor.model.DataItem;
import co.nstant.in.cbor.model.Map;
import co.nstant.in.cbor.model.Special;

/* JADX INFO: loaded from: classes.dex */
public class ArrayBuilder<T extends AbstractBuilder<?>> extends AbstractBuilder<T> {
    private final Array array;

    public ArrayBuilder(T parent, Array array) {
        super(parent);
        this.array = array;
    }

    public ArrayBuilder<T> add(DataItem dataItem) {
        this.array.add(dataItem);
        return this;
    }

    public ArrayBuilder<T> add(long value) {
        add(convert(value));
        return this;
    }

    public ArrayBuilder<T> add(boolean value) {
        add(convert(value));
        return this;
    }

    public ArrayBuilder<T> add(float value) {
        add(convert(value));
        return this;
    }

    public ArrayBuilder<T> add(double value) {
        add(convert(value));
        return this;
    }

    public ArrayBuilder<T> add(byte[] bytes) {
        add(convert(bytes));
        return this;
    }

    public ArrayBuilder<T> add(String string) {
        add(convert(string));
        return this;
    }

    public ArrayBuilder<ArrayBuilder<T>> addArray() {
        Array nestedArray = new Array();
        add(nestedArray);
        return new ArrayBuilder(this, nestedArray);
    }

    public ArrayBuilder<ArrayBuilder<T>> startArray() {
        Array nestedArray = new Array();
        nestedArray.setChunked(true);
        add(nestedArray);
        return new ArrayBuilder(this, nestedArray);
    }

    public MapBuilder<ArrayBuilder<T>> addMap() {
        Map nestedMap = new Map();
        add(nestedMap);
        return new MapBuilder(this, nestedMap);
    }

    public MapBuilder<ArrayBuilder<T>> startMap() {
        Map nestedMap = new Map();
        nestedMap.setChunked(true);
        add(nestedMap);
        return new MapBuilder(this, nestedMap);
    }

    public T end() {
        if (this.array.isChunked() == false) goto L6;
        add(Special.BREAK);
    L6:
        return getParent();
    }
}
