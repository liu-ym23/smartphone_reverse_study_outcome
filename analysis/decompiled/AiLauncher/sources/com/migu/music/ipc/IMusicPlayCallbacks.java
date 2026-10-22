package com.migu.music.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface IMusicPlayCallbacks extends IInterface {

    public static class Default implements IMusicPlayCallbacks {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.migu.music.ipc.IMusicPlayCallbacks
        public void onBuffering(boolean z10, int i10, MgSong mgSong) throws RemoteException {
        }

        @Override // com.migu.music.ipc.IMusicPlayCallbacks
        public void onPlayFailed(int i10, String str, MgSong mgSong) throws RemoteException {
        }

        @Override // com.migu.music.ipc.IMusicPlayCallbacks
        public void onPlayStateChanged(boolean z10, MgSong mgSong) throws RemoteException {
        }

        @Override // com.migu.music.ipc.IMusicPlayCallbacks
        public void onPrepared(MgSong mgSong) throws RemoteException {
        }

        @Override // com.migu.music.ipc.IMusicPlayCallbacks
        public void onProgress(long j10, long j11, int i10, MgSong mgSong) throws RemoteException {
        }

        @Override // com.migu.music.ipc.IMusicPlayCallbacks
        public void onSeekComplete(MgSong mgSong) throws RemoteException {
        }

        @Override // com.migu.music.ipc.IMusicPlayCallbacks
        public void onSongChanged(MgSong mgSong) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IMusicPlayCallbacks {
        private static final String DESCRIPTOR = "com.migu.music.ipc.IMusicPlayCallbacks";
        static final int TRANSACTION_onBuffering = 7;
        static final int TRANSACTION_onPlayFailed = 2;
        static final int TRANSACTION_onPlayStateChanged = 3;
        static final int TRANSACTION_onPrepared = 6;
        static final int TRANSACTION_onProgress = 1;
        static final int TRANSACTION_onSeekComplete = 4;
        static final int TRANSACTION_onSongChanged = 5;

        public static class Proxy implements IMusicPlayCallbacks {
            public static IMusicPlayCallbacks sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.migu.music.ipc.IMusicPlayCallbacks
            public void onBuffering(boolean z10, int i10, MgSong mgSong) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeInt(i10);
                    if (mgSong != null) {
                        parcelObtain.writeInt(1);
                        mgSong.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onBuffering(z10, i10, mgSong);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.migu.music.ipc.IMusicPlayCallbacks
            public void onPlayFailed(int i10, String str, MgSong mgSong) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str);
                    if (mgSong != null) {
                        parcelObtain.writeInt(1);
                        mgSong.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onPlayFailed(i10, str, mgSong);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.migu.music.ipc.IMusicPlayCallbacks
            public void onPlayStateChanged(boolean z10, MgSong mgSong) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    if (mgSong != null) {
                        parcelObtain.writeInt(1);
                        mgSong.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onPlayStateChanged(z10, mgSong);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.migu.music.ipc.IMusicPlayCallbacks
            public void onPrepared(MgSong mgSong) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (mgSong != null) {
                        parcelObtain.writeInt(1);
                        mgSong.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onPrepared(mgSong);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.migu.music.ipc.IMusicPlayCallbacks
            public void onProgress(long j10, long j11, int i10, MgSong mgSong) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeLong(j10);
                    parcelObtain.writeLong(j11);
                    parcelObtain.writeInt(i10);
                    if (mgSong != null) {
                        parcelObtain.writeInt(1);
                        mgSong.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onProgress(j10, j11, i10, mgSong);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.migu.music.ipc.IMusicPlayCallbacks
            public void onSeekComplete(MgSong mgSong) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (mgSong != null) {
                        parcelObtain.writeInt(1);
                        mgSong.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onSeekComplete(mgSong);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.migu.music.ipc.IMusicPlayCallbacks
            public void onSongChanged(MgSong mgSong) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (mgSong != null) {
                        parcelObtain.writeInt(1);
                        mgSong.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onSongChanged(mgSong);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMusicPlayCallbacks asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMusicPlayCallbacks)) ? new Proxy(iBinder) : (IMusicPlayCallbacks) iInterfaceQueryLocalInterface;
        }

        public static IMusicPlayCallbacks getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMusicPlayCallbacks iMusicPlayCallbacks) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iMusicPlayCallbacks == null) {
                return false;
            }
            Proxy.sDefaultImpl = iMusicPlayCallbacks;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    onProgress(parcel.readLong(), parcel.readLong(), parcel.readInt(), parcel.readInt() != 0 ? MgSong.CREATOR.createFromParcel(parcel) : null);
                    break;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPlayFailed(parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? MgSong.CREATOR.createFromParcel(parcel) : null);
                    break;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPlayStateChanged(parcel.readInt() != 0, parcel.readInt() != 0 ? MgSong.CREATOR.createFromParcel(parcel) : null);
                    break;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    onSeekComplete(parcel.readInt() != 0 ? MgSong.CREATOR.createFromParcel(parcel) : null);
                    break;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    onSongChanged(parcel.readInt() != 0 ? MgSong.CREATOR.createFromParcel(parcel) : null);
                    break;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPrepared(parcel.readInt() != 0 ? MgSong.CREATOR.createFromParcel(parcel) : null);
                    break;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    onBuffering(parcel.readInt() != 0, parcel.readInt(), parcel.readInt() != 0 ? MgSong.CREATOR.createFromParcel(parcel) : null);
                    break;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onBuffering(boolean z10, int i10, MgSong mgSong) throws RemoteException;

    void onPlayFailed(int i10, String str, MgSong mgSong) throws RemoteException;

    void onPlayStateChanged(boolean z10, MgSong mgSong) throws RemoteException;

    void onPrepared(MgSong mgSong) throws RemoteException;

    void onProgress(long j10, long j11, int i10, MgSong mgSong) throws RemoteException;

    void onSeekComplete(MgSong mgSong) throws RemoteException;

    void onSongChanged(MgSong mgSong) throws RemoteException;
}
