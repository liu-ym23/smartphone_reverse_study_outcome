package com.stepos.alphame.data;

import T1.a;
import android.database.Cursor;
import android.util.Log;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.utils.ThreadPool;
import com.stepos.common.alphame.Args;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class DataSource {
    protected static final byte[] NULL_BYTES = null;
    protected static final String TAG = "AlphaMe";
    protected static final int THRESHOLD = 10;
    private Cache<DataItem> mItemCache;
    private Method mMethodFill;
    protected Storable mStorable;
    protected String mTag;
    protected final Object mSyncObject = new Object();
    protected ArrayList<DataItem> mHistory = new ArrayList<>();

    public class StorableJob implements ThreadPool.Job<Boolean> {
        ArrayList<DataItem> mList;

        public /* synthetic */ StorableJob(DataSource dataSource, ArrayList arrayList, int i4) {
            this(arrayList);
        }

        private StorableJob(ArrayList<DataItem> arrayList) {
            this.mList = arrayList;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.stepos.alphame.utils.ThreadPool.Job
        public Boolean run() {
            ArrayList<DataItem> arrayList = this.mList;
            if (arrayList == null || arrayList.size() == 0) {
                return Boolean.TRUE;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            DataSource.this.mStorable.writeItem(this.mList);
            if (a.f1854a.get()) {
                Log.i(DataSource.TAG, String.format("Write item %s cost time %d", DataSource.this.mTag, Integer.valueOf((int) (System.currentTimeMillis() - jCurrentTimeMillis))));
            }
            DataSource.this.itemCache().put(this.mList);
            this.mList.clear();
            return Boolean.TRUE;
        }
    }

    public DataSource(String str) {
        this.mTag = str;
        try {
            Class<? extends DataItem> dataItemClass = getDataItemClass();
            this.mItemCache = new Cache<>(dataItemClass, 15);
            this.mMethodFill = dataItemClass.getMethod("fill", Args.c(getFillArgsType()));
            this.mStorable = createStorable();
        } catch (Exception e4) {
            Log.w("DataSource " + str + " ：", e4);
        }
    }

    public abstract Storable createStorable();

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        synchronized (this.mSyncObject) {
            try {
                Storable storable = this.mStorable;
                if (storable != null) {
                    Cursor cursor = storable.getCursor();
                    if (cursor == null) {
                        return;
                    }
                    printWriter.println(this.mStorable.getTableName() + " size = " + cursor.getCount());
                    DataItem dataItemCurrentItem = null;
                    while (cursor.moveToNext()) {
                        try {
                            if (dataItemCurrentItem == null) {
                                dataItemCurrentItem = this.mStorable.currentItem(cursor);
                            } else {
                                this.mStorable.fillItem(cursor, dataItemCurrentItem);
                            }
                            printWriter.println(dataItemCurrentItem.toString());
                        } catch (Throwable th) {
                            cursor.close();
                            throw th;
                        }
                    }
                    cursor.close();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public abstract Class<? extends DataItem> getDataItemClass();

    public abstract byte[] getFillArgsType();

    public byte[] getMoreFillArgsType(byte[] bArr) {
        return NULL_BYTES;
    }

    public Storable getStorable() {
        return this.mStorable;
    }

    public String getTag() {
        return this.mTag;
    }

    public int getThreshold() {
        return 10;
    }

    public DataItem instanceDataItem(Args args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        DataItem dataItemPop;
        try {
            dataItemPop = itemCache().pop();
            if (dataItemPop != null) {
                try {
                    this.mMethodFill.invoke(dataItemPop, args.f11220a);
                } catch (Exception e4) {
                    e = e4;
                    itemCache().put((Cache<DataItem>) dataItemPop);
                    Log.e(TAG, "fill " + this.mTag + AwarenessDataItem.PERMISSION_SPLITTER + args.toString() + " e:" + e);
                    return null;
                }
            }
            return dataItemPop;
        } catch (Exception e5) {
            e = e5;
            dataItemPop = null;
        }
    }

    public Cache<DataItem> itemCache() {
        return this.mItemCache;
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void process(DataItem dataItem) {
        synchronized (this.mSyncObject) {
            try {
                if (this.mStorable == null) {
                    itemCache().put((Cache<DataItem>) dataItem);
                } else {
                    this.mHistory.add(dataItem);
                    if (this.mHistory.size() >= getThreshold()) {
                        store();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void store() {
        store(false);
    }

    public void trimMemory() {
        if (itemCache() != null) {
            itemCache().clear();
        }
    }

    public void store(boolean z4) {
        ArrayList<DataItem> arrayList;
        synchronized (this.mSyncObject) {
            try {
                if (this.mStorable == null) {
                    this.mHistory.clear();
                }
                arrayList = new ArrayList<>(this.mHistory);
                if (!this.mHistory.isEmpty()) {
                    if (z4) {
                        itemCache().put(this.mHistory);
                        this.mHistory.clear();
                    } else {
                        this.mHistory.clear();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        if (z4) {
            this.mStorable.writeItem(arrayList);
        } else {
            ThreadPool.getInstance().submit(new StorableJob(this, arrayList, 0));
        }
    }
}
