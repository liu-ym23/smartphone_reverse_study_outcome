package com.android.server.wallpaper;

import android.app.ILocalWallpaperColorConsumer;
import android.graphics.RectF;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public class LocalColorRepository {
    RemoteCallbackList<ILocalWallpaperColorConsumer> mCallbacks;
    ArrayMap<IBinder, SparseArray<ArraySet<RectF>>> mLocalColorAreas;

    public static /* synthetic */ void $r8$lambda$AifFM4p1rGROuQ3ZQLLNam00J0k(LocalColorRepository r0, ILocalWallpaperColorConsumer r1) {
        r0.lambda$addAreas$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$HRohTAOnvdb7gIUdV8HXRzVaRyw(LocalColorRepository r0, int r1, RectF r2, Consumer r3, ILocalWallpaperColorConsumer r4) {
        r0.lambda$forEachCallback$1(r1, r2, r3, r4);
    }

    public LocalColorRepository() {
        this.mLocalColorAreas = new ArrayMap();
        this.mCallbacks = new RemoteCallbackList();
    }

    public void addAreas(final ILocalWallpaperColorConsumer consumer, List<RectF> areas, int displayId) {
        IBinder binder = consumer.asBinder();
        SparseArray<ArraySet<RectF>> displays = this.mLocalColorAreas.get(binder);
        ArraySet<RectF> displayAreas = null;
        if (displays == null) goto L18;
        ArraySet<RectF> displayAreas2 = displays.get(displayId);
        displayAreas = displayAreas2;
    L10:
        if (displayAreas != null) goto L12;
        displayAreas = new ArraySet(areas);
        displays.put(displayId, displayAreas);
    L12:
        int i = 0;
    L14:
        if (i >= areas.size()) goto L16;
        displayAreas.add(areas.get(i));
        i = i + 1;
        goto L14
    L16:
        this.mCallbacks.register(consumer);
        return;
    L18:
        consumer.asBinder().linkToDeath(new LocalColorRepository$$ExternalSyntheticLambda1(this, consumer), 0);     // Catch: RemoteException -> L6
    L8:
        displays = new SparseArray();
        this.mLocalColorAreas.put(binder, displays);
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    private /* synthetic */ void lambda$addAreas$0(ILocalWallpaperColorConsumer consumer) {
        this.mLocalColorAreas.remove(consumer.asBinder());
    }

    public List<RectF> removeAreas(ILocalWallpaperColorConsumer consumer, List<RectF> areas, int displayId) {
        IBinder binder = consumer.asBinder();
        SparseArray<ArraySet<RectF>> displays = this.mLocalColorAreas.get(binder);
        if (displays == null) goto L17;
        ArraySet<RectF> registeredAreas = displays.get(displayId);
        if (registeredAreas != null) goto L7;
        this.mCallbacks.unregister(consumer);
    L15:
        if (displays.size() != 0) goto L18;
        this.mLocalColorAreas.remove(binder);
        this.mCallbacks.unregister(consumer);
    L18:
        ArraySet<RectF> purged = new ArraySet(areas);
        int i = 0;
    L20:
        if (i >= this.mLocalColorAreas.size()) goto L31;
        int j = 0;
    L23:
        if (j >= this.mLocalColorAreas.valueAt(i).size()) goto L29;
        int k = 0;
    L26:
        if (k >= this.mLocalColorAreas.valueAt(i).valueAt(j).size()) goto L28;
        purged.remove(this.mLocalColorAreas.valueAt(i).valueAt(j).valueAt(k));
        k = k + 1;
        goto L26
    L28:
        j = j + 1;
        goto L23
    L29:
        i = i + 1;
        goto L20
    L31:
        return new ArrayList(purged);
    L7:
        int i2 = 0;
    L9:
        if (i2 >= areas.size()) goto L11;
        registeredAreas.remove(areas.get(i2));
        i2 = i2 + 1;
        goto L9
    L11:
        int i3 = registeredAreas.size();
        if (i3 != 0) goto L15;
        displays.remove(displayId);
        goto L15
    L17:
        this.mCallbacks.unregister(consumer);
        goto L18
    }

    public List<RectF> getAreasByDisplayId(int displayId) {
        ArrayList<RectF> areas = new ArrayList();
        int i = 0;
    L4:
        if (i >= this.mLocalColorAreas.size()) goto L17;
        SparseArray<ArraySet<RectF>> displays = this.mLocalColorAreas.valueAt(i);
        if (displays == null) goto L15;
        ArraySet<RectF> displayAreas = displays.get(displayId);
        if (displayAreas == null) goto L15;
        int j = 0;
    L13:
        if (j >= displayAreas.size()) goto L15;
        areas.add(displayAreas.valueAt(j));
        j = j + 1;
    L15:
        i = i + 1;
        goto L4
    L17:
        return areas;
    }

    public void forEachCallback(final Consumer<ILocalWallpaperColorConsumer> callback, final RectF area, final int displayId) {
        this.mCallbacks.broadcast(new LocalColorRepository$$ExternalSyntheticLambda0(this, displayId, area, callback));
    }

    private /* synthetic */ void lambda$forEachCallback$1(int displayId, RectF area, Consumer callback, ILocalWallpaperColorConsumer cb) {
        IBinder binder = cb.asBinder();
        SparseArray<ArraySet<RectF>> displays = this.mLocalColorAreas.get(binder);
        if (displays != null) goto L5;
        return;
    L5:
        ArraySet<RectF> displayAreas = displays.get(displayId);
        if (displayAreas != null) goto L8;
        return;
    L8:
        if (displayAreas.contains(area) == false) goto L12;
        callback.accept(cb);
        return;
    }

    protected boolean isCallbackAvailable(ILocalWallpaperColorConsumer callback) {
        if (this.mLocalColorAreas.get(callback.asBinder()) == null) goto L5;
        return true;
    L5:
        return false;
    }
}
