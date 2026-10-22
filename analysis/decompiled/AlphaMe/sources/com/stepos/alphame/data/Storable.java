package com.stepos.alphame.data;

import android.database.Cursor;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class Storable {
    public DataItem currentItem(Cursor cursor) {
        return fillItem(cursor, null);
    }

    public abstract DataItem fillItem(Cursor cursor, DataItem dataItem);

    public abstract Cursor getCursor();

    public abstract String getTableName();

    public abstract void writeItem(ArrayList<DataItem> arrayList);
}
