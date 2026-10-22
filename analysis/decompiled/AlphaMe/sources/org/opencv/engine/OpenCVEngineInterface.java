package org.opencv.engine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface OpenCVEngineInterface extends IInterface {
    public static final String DESCRIPTOR = "org.opencv.engine.OpenCVEngineInterface";

    public static class Default implements OpenCVEngineInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // org.opencv.engine.OpenCVEngineInterface
        public int getEngineVersion() throws RemoteException {
            return 0;
        }

        @Override // org.opencv.engine.OpenCVEngineInterface
        public String getLibPathByVersion(String str) throws RemoteException {
            return null;
        }

        @Override // org.opencv.engine.OpenCVEngineInterface
        public String getLibraryList(String str) throws RemoteException {
            return null;
        }

        @Override // org.opencv.engine.OpenCVEngineInterface
        public boolean installVersion(String str) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements OpenCVEngineInterface {
        static final int TRANSACTION_getEngineVersion = 1;
        static final int TRANSACTION_getLibPathByVersion = 2;
        static final int TRANSACTION_getLibraryList = 4;
        static final int TRANSACTION_installVersion = 3;

        public static class Proxy implements OpenCVEngineInterface {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // org.opencv.engine.OpenCVEngineInterface
            public int getEngineVersion() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(OpenCVEngineInterface.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return OpenCVEngineInterface.DESCRIPTOR;
            }

            @Override // org.opencv.engine.OpenCVEngineInterface
            public String getLibPathByVersion(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(OpenCVEngineInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // org.opencv.engine.OpenCVEngineInterface
            public String getLibraryList(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(OpenCVEngineInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // org.opencv.engine.OpenCVEngineInterface
            public boolean installVersion(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(OpenCVEngineInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, OpenCVEngineInterface.DESCRIPTOR);
        }

        public static OpenCVEngineInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(OpenCVEngineInterface.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof OpenCVEngineInterface)) ? new Proxy(iBinder) : (OpenCVEngineInterface) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i4 >= 1 && i4 <= 16777215) {
                parcel.enforceInterface(OpenCVEngineInterface.DESCRIPTOR);
            }
            if (i4 == 1598968902) {
                parcel2.writeString(OpenCVEngineInterface.DESCRIPTOR);
                return true;
            }
            if (i4 == 1) {
                int engineVersion = getEngineVersion();
                parcel2.writeNoException();
                parcel2.writeInt(engineVersion);
            } else if (i4 == 2) {
                String libPathByVersion = getLibPathByVersion(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(libPathByVersion);
            } else if (i4 == 3) {
                boolean zInstallVersion = installVersion(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zInstallVersion ? 1 : 0);
            } else {
                if (i4 != 4) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                String libraryList = getLibraryList(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(libraryList);
            }
            return true;
        }
    }

    int getEngineVersion() throws RemoteException;

    String getLibPathByVersion(String str) throws RemoteException;

    String getLibraryList(String str) throws RemoteException;

    boolean installVersion(String str) throws RemoteException;
}
