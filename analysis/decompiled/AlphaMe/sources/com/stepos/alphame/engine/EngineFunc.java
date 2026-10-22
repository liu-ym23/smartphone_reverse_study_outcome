package com.stepos.alphame.engine;

import android.util.Log;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.common.alphame.Args;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class EngineFunc {
    protected static final String TAG = "AlphaMe";
    public String[] annotation;
    public Method method;
    public String name;
    public EngineBase owner;
    public byte returnType;
    private static final byte[] ARGSTYPE = {0};
    private static final String[] ARGSNAME = {""};
    public byte[] argsType = ARGSTYPE;
    public String[] argsName = ARGSNAME;
    public boolean isPublic = false;
    public boolean local = false;

    public EngineFunc(EngineBase engineBase) {
        this.owner = engineBase;
    }

    public String args() {
        StringBuilder sb = new StringBuilder(16);
        sb.append("(");
        byte[] bArr = this.argsType;
        if (bArr != null) {
            if (bArr[0] != 0) {
                for (int i4 = 0; i4 < this.argsType.length; i4++) {
                    if (i4 != 0) {
                        sb.append(", ");
                    }
                    sb.append(Args.k(this.argsType[i4]));
                    sb.append(AwarenessDataItem.PERMISSION_SPLITTER);
                    sb.append(this.argsName[i4]);
                }
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void dump(PrintWriter printWriter) {
        if (this.annotation != null) {
            printWriter.println("\t/**");
            for (String str : this.annotation) {
                printWriter.println("\t * " + str);
            }
            printWriter.println("\t * /");
        }
        printWriter.println("\t " + getFullName());
    }

    public String getFullName() {
        return Args.k(this.returnType) + AwarenessDataItem.PERMISSION_SPLITTER + this.name + args();
    }

    public void initMethod() {
        synchronized (this) {
            if (this.method != null) {
                return;
            }
            try {
                this.method = this.owner.getClass().getMethod(this.name, Args.c(this.argsType));
            } catch (NoSuchMethodException e4) {
                Log.e(TAG, e4.toString());
            }
        }
    }

    public Object invoke(Args args) {
        initMethod();
        Method method = this.method;
        if (method == null) {
            Log.e(TAG, "Can't find method = " + this.method);
            return null;
        }
        try {
            return method.invoke(this.owner, args.f11220a);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e4) {
            Log.e(TAG, "Call " + this.name + args.toString() + " : " + e4.getMessage());
            return null;
        }
    }

    public Object invoke(Object[] objArr) throws ReflectiveOperationException {
        initMethod();
        Method method = this.method;
        if (method == null) {
            Log.e(TAG, "Can't find method = " + this.method);
            return null;
        }
        return method.invoke(this.owner, objArr);
    }
}
