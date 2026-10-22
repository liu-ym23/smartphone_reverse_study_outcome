package com.amap.location.signal.impl.manu;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public class XiaomiDimLocator {

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f18054b;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f18057e;

    /* renamed from: f, reason: collision with root package name */
    public static IMessenger f18058f;

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f18053a = Uri.parse("content://com.lbe.security.miui.autostartmgr");

    /* renamed from: c, reason: collision with root package name */
    public static boolean f18055c = false;

    /* renamed from: d, reason: collision with root package name */
    public static double f18056d = 10000.0d;

    public interface IMessenger extends IInterface {

        public static abstract class Stub extends Binder implements IMessenger {
            public Stub() {
                attachInterface(this, "com.android.internal.app.IMessenger");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this;
            }

            @Override // android.os.Binder
            public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
                if (i10 == 1) {
                    parcel.enforceInterface("com.android.internal.app.IMessenger");
                    a(parcel.readInt() != 0 ? (Message) Message.CREATOR.createFromParcel(parcel) : null);
                    return true;
                }
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString("com.android.internal.app.IMessenger");
                return true;
            }
        }

        void a(Message message) throws RemoteException;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    static {
        /*
            java.lang.String r0 = "content://com.lbe.security.miui.autostartmgr"
            android.net.Uri r0 = android.net.Uri.parse(r0)
            com.amap.location.signal.impl.manu.XiaomiDimLocator.f18053a = r0
            r0 = 0
            com.amap.location.signal.impl.manu.XiaomiDimLocator.f18055c = r0
            r1 = 4666723172467343360(0x40c3880000000000, double:10000.0)
            com.amap.location.signal.impl.manu.XiaomiDimLocator.f18056d = r1
            r1 = 1
            com.amap.location.signal.impl.manu.XiaomiDimLocator.f18057e = r1
            java.lang.String r2 = "android.os.SystemProperties"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Exception -> L54
            java.lang.String r3 = "getInt"
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L54
            java.lang.Class[] r4 = new java.lang.Class[]{r4, r5}     // Catch: java.lang.Exception -> L54
            java.lang.reflect.Method r3 = r2.getDeclaredMethod(r3, r4)     // Catch: java.lang.Exception -> L54
            java.lang.String r4 = "ro.miui.ui.version.code"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Exception -> L54
            java.lang.Object[] r4 = new java.lang.Object[]{r4, r5}     // Catch: java.lang.Exception -> L54
            java.lang.Object r2 = r3.invoke(r2, r4)     // Catch: java.lang.Exception -> L54
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Exception -> L54
            int r2 = r2.intValue()     // Catch: java.lang.Exception -> L54
            P1.a r3 = P1.a.c()     // Catch: java.lang.Exception -> L52
            java.lang.String r4 = "dim"
            r5 = 15
            int r3 = r3.b(r4, r5)     // Catch: java.lang.Exception -> L52
            r3 = r3 & r1
            if (r3 != r1) goto L4e
            r3 = r1
            goto L4f
        L4e:
            r3 = r0
        L4f:
            com.amap.location.signal.impl.manu.XiaomiDimLocator.f18057e = r3     // Catch: java.lang.Exception -> L52
            goto L59
        L52:
            r3 = move-exception
            goto L56
        L54:
            r3 = move-exception
            r2 = r0
        L56:
            S1.a.b(r3)
        L59:
            r3 = 11
            if (r2 < r3) goto L5e
            r0 = r1
        L5e:
            com.amap.location.signal.impl.manu.XiaomiDimLocator.f18054b = r0
            com.amap.location.signal.impl.manu.XiaomiDimLocator$1 r0 = new com.amap.location.signal.impl.manu.XiaomiDimLocator$1
            r0.<init>()
            com.amap.location.signal.impl.manu.XiaomiDimLocator.f18058f = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.location.signal.impl.manu.XiaomiDimLocator.<clinit>():void");
    }
}
