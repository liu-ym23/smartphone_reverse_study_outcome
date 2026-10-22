package com.stepos.alphame.engine;

import android.text.TextUtils;
import android.util.Log;
import com.stepos.common.alphame.Args;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class EngineFuncMap {
    protected static final boolean DEBUG = false;
    protected static final String TAG = "EngineFuncMap";
    protected HashMap<String, ArrayList<EngineFunc>> mMap = new HashMap<>();

    public boolean add(EngineFunc engineFunc) {
        synchronized (this) {
            try {
                if (engineFunc == null) {
                    return false;
                }
                if (TextUtils.isEmpty(engineFunc.name)) {
                    Log.e(TAG, "Func's name can't be empty");
                    return false;
                }
                if (engineFunc.annotation == null) {
                    Log.e(TAG, "Func's annotation can't be null");
                    return false;
                }
                byte[] bArr = engineFunc.argsType;
                if (bArr == null) {
                    Log.e(TAG, "Func's argsType can't be null");
                    return false;
                }
                String[] strArr = engineFunc.argsName;
                if (strArr == null) {
                    Log.e(TAG, "Func's argsName can't be null");
                    return false;
                }
                if (strArr.length != bArr.length) {
                    Log.e(TAG, "Func's argsName.length must equal argsType.length");
                    return false;
                }
                engineFunc.initMethod();
                if (engineFunc.method == null) {
                    Log.e(TAG, "Func's method can't be null");
                    return false;
                }
                ArrayList<EngineFunc> arrayList = this.mMap.get(engineFunc.name);
                if (arrayList == null) {
                    ArrayList<EngineFunc> arrayList2 = new ArrayList<>();
                    this.mMap.put(engineFunc.name, arrayList2);
                    arrayList2.add(engineFunc);
                    return true;
                }
                Iterator<EngineFunc> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (Args.g(it.next().argsType, engineFunc.argsType)) {
                        Log.e(TAG, engineFunc.getFullName() + " is already added");
                        return false;
                    }
                }
                arrayList.add(engineFunc);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public EngineFunc get(String str, Args args) {
        synchronized (this) {
            try {
                ArrayList<EngineFunc> arrayList = this.mMap.get(str);
                if (arrayList == null) {
                    return null;
                }
                Iterator<EngineFunc> it = arrayList.iterator();
                while (it.hasNext()) {
                    EngineFunc next = it.next();
                    if (Args.g(next.argsType, args.f11221b)) {
                        return next;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Collection<ArrayList<EngineFunc>> getAll() {
        return this.mMap.values();
    }

    public boolean remove(EngineFunc engineFunc) {
        synchronized (this) {
            try {
                ArrayList<EngineFunc> arrayList = this.mMap.get(engineFunc.name);
                if (arrayList == null) {
                    return false;
                }
                Iterator<EngineFunc> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() == engineFunc) {
                        it.remove();
                    }
                }
                if (arrayList.isEmpty()) {
                    this.mMap.remove(engineFunc.name);
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public EngineFunc get(String str) {
        synchronized (this) {
            try {
                ArrayList<EngineFunc> arrayList = this.mMap.get(str);
                if (arrayList == null) {
                    return null;
                }
                return arrayList.get(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean remove(EngineBase engineBase) {
        boolean z4;
        synchronized (this) {
            try {
                ArrayList arrayList = new ArrayList();
                z4 = false;
                for (String str : this.mMap.keySet()) {
                    ArrayList<EngineFunc> arrayList2 = this.mMap.get(str);
                    Iterator<EngineFunc> it = arrayList2.iterator();
                    while (it.hasNext()) {
                        if (it.next().owner == engineBase) {
                            it.remove();
                            z4 = true;
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        arrayList.add(str);
                    }
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    this.mMap.remove((String) it2.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z4;
    }
}
