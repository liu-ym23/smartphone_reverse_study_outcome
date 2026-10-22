package net.sqlcipher;

import java.util.ArrayList;

/* loaded from: classes5.dex */
public class MatrixCursor extends AbstractCursor {
    private final int columnCount;
    private final String[] columnNames;
    private Object[] data;
    private int rowCount;

    public class RowBuilder {
        private final int endIndex;
        private int index;

        public RowBuilder(int i10, int i11) {
            this.index = i10;
            this.endIndex = i11;
        }

        public RowBuilder add(Object obj) {
            if (this.index == this.endIndex) {
                throw new CursorIndexOutOfBoundsException("No more columns left.");
            }
            Object[] objArr = MatrixCursor.this.data;
            int i10 = this.index;
            this.index = i10 + 1;
            objArr[i10] = obj;
            return this;
        }
    }

    public MatrixCursor(String[] strArr, int i10) {
        this.rowCount = 0;
        this.columnNames = strArr;
        int length = strArr.length;
        this.columnCount = length;
        this.data = new Object[length * (i10 < 1 ? 1 : i10)];
    }

    private void ensureCapacity(int i10) {
        Object[] objArr = this.data;
        if (i10 > objArr.length) {
            int length = objArr.length * 2;
            if (length >= i10) {
                i10 = length;
            }
            Object[] objArr2 = new Object[i10];
            this.data = objArr2;
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        }
    }

    private Object get(int i10) {
        int i11;
        if (i10 < 0 || i10 >= (i11 = this.columnCount)) {
            throw new CursorIndexOutOfBoundsException("Requested column: " + i10 + ", # of columns: " + this.columnCount);
        }
        int i12 = this.mPos;
        if (i12 < 0) {
            throw new CursorIndexOutOfBoundsException("Before first row.");
        }
        if (i12 < this.rowCount) {
            return this.data[(i12 * i11) + i10];
        }
        throw new CursorIndexOutOfBoundsException("After last row.");
    }

    public void addRow(Object[] objArr) {
        int length = objArr.length;
        int i10 = this.columnCount;
        if (length == i10) {
            int i11 = this.rowCount;
            this.rowCount = i11 + 1;
            int i12 = i11 * i10;
            ensureCapacity(i10 + i12);
            System.arraycopy(objArr, 0, this.data, i12, this.columnCount);
            return;
        }
        throw new IllegalArgumentException("columnNames.length = " + this.columnCount + ", columnValues.length = " + objArr.length);
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        return this.columnNames;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getCount() {
        return this.rowCount;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public double getDouble(int i10) {
        Object obj = get(i10);
        if (obj == null) {
            return 0.0d;
        }
        return obj instanceof Number ? ((Number) obj).doubleValue() : Double.parseDouble(obj.toString());
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public float getFloat(int i10) {
        Object obj = get(i10);
        if (obj == null) {
            return 0.0f;
        }
        return obj instanceof Number ? ((Number) obj).floatValue() : Float.parseFloat(obj.toString());
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getInt(int i10) {
        Object obj = get(i10);
        if (obj == null) {
            return 0;
        }
        return obj instanceof Number ? ((Number) obj).intValue() : Integer.parseInt(obj.toString());
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public long getLong(int i10) {
        Object obj = get(i10);
        if (obj == null) {
            return 0L;
        }
        return obj instanceof Number ? ((Number) obj).longValue() : Long.parseLong(obj.toString());
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public short getShort(int i10) {
        Object obj = get(i10);
        if (obj == null) {
            return (short) 0;
        }
        return obj instanceof Number ? ((Number) obj).shortValue() : Short.parseShort(obj.toString());
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public String getString(int i10) {
        Object obj = get(i10);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor, net.sqlcipher.Cursor
    public int getType(int i10) {
        return DatabaseUtils.getTypeOfObject(get(i10));
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public boolean isNull(int i10) {
        return get(i10) == null;
    }

    public RowBuilder newRow() {
        int i10 = this.rowCount + 1;
        this.rowCount = i10;
        int i11 = i10 * this.columnCount;
        ensureCapacity(i11);
        return new RowBuilder(i11 - this.columnCount, i11);
    }

    public MatrixCursor(String[] strArr) {
        this(strArr, 16);
    }

    public void addRow(Iterable<?> iterable) {
        int i10 = this.rowCount;
        int i11 = this.columnCount;
        int i12 = i10 * i11;
        int i13 = i11 + i12;
        ensureCapacity(i13);
        if (iterable instanceof ArrayList) {
            addRow((ArrayList) iterable, i12);
            return;
        }
        Object[] objArr = this.data;
        for (Object obj : iterable) {
            if (i12 != i13) {
                objArr[i12] = obj;
                i12++;
            } else {
                throw new IllegalArgumentException("columnValues.size() > columnNames.length");
            }
        }
        if (i12 == i13) {
            this.rowCount++;
            return;
        }
        throw new IllegalArgumentException("columnValues.size() < columnNames.length");
    }

    private void addRow(ArrayList<?> arrayList, int i10) {
        int size = arrayList.size();
        if (size == this.columnCount) {
            this.rowCount++;
            Object[] objArr = this.data;
            for (int i11 = 0; i11 < size; i11++) {
                objArr[i10 + i11] = arrayList.get(i11);
            }
            return;
        }
        throw new IllegalArgumentException("columnNames.length = " + this.columnCount + ", columnValues.size() = " + size);
    }
}
