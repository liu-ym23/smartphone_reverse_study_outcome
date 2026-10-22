package com.migu.music.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.migu.music.ipc.IMusicIpcInitCallback;
import com.migu.music.ipc.IMusicPlayCallbacks;
import com.migu.music.ipc.IQuerySongListInfoCallback;
import java.util.List;

/* loaded from: classes2.dex */
public interface IMusicPlayService extends IInterface {

    public static class Default implements IMusicPlayService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.migu.music.ipc.IMusicPlayService
        public int getPlayMode() throws RemoteException {
            return 0;
        }

        @Override // com.migu.music.ipc.IMusicPlayService
        public boolean isBridgeReady() throws RemoteException {
            return false;
        }

        @Override // com.migu.music.ipc.IMusicPlayService
        public boolean isLoginSuccess() throws RemoteException {
            return false;
        }

        @Override // com.migu.music.ipc.IMusicPlayService
        public void pause() throws RemoteException {
        }

        @Override // com.migu.music.ipc.IMusicPlayService
        public void playNext() throws RemoteException {
        }

        @Override // com.migu.music.ipc.IMusicPlayService
        public void playPrevious() throws RemoteException {
        }

        @Override // com.migu.music.ipc.IMusicPlayService
        public void playSongByIds(List<String> list, int i10) throws RemoteException {
        }

        @Override // com.migu.music.ipc.IMusicPlayService
        public void querySongListInfo(List<String> list, IQuerySongListInfoCallback iQuerySongListInfoCallback) throws RemoteException {
        }

        @Override // com.migu.music.ipc.IMusicPlayService
        public void registerCallbacks(IMusicPlayCallbacks iMusicPlayCallbacks) throws RemoteException {
        }

        @Override // com.migu.music.ipc.IMusicPlayService
        public void registerMusicIpcInitCallback(IMusicIpcInitCallback iMusicIpcInitCallback) throws RemoteException {
        }

        @Override // com.migu.music.ipc.IMusicPlayService
        public void resume() throws RemoteException {
        }

        @Override // com.migu.music.ipc.IMusicPlayService
        public void seekToPlay(int i10) throws RemoteException {
        }

        @Override // com.migu.music.ipc.IMusicPlayService
        public void setPlayMode(int i10) throws RemoteException {
        }

        @Override // com.migu.music.ipc.IMusicPlayService
        public void unregisterCallbacks(IMusicPlayCallbacks iMusicPlayCallbacks) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IMusicPlayService {
        private static final String DESCRIPTOR = "com.migu.music.ipc.IMusicPlayService";
        static final int TRANSACTION_getPlayMode = 10;
        static final int TRANSACTION_isBridgeReady = 1;
        static final int TRANSACTION_isLoginSuccess = 3;
        static final int TRANSACTION_pause = 7;
        static final int TRANSACTION_playNext = 5;
        static final int TRANSACTION_playPrevious = 6;
        static final int TRANSACTION_playSongByIds = 4;
        static final int TRANSACTION_querySongListInfo = 14;
        static final int TRANSACTION_registerCallbacks = 12;
        static final int TRANSACTION_registerMusicIpcInitCallback = 2;
        static final int TRANSACTION_resume = 8;
        static final int TRANSACTION_seekToPlay = 9;
        static final int TRANSACTION_setPlayMode = 11;
        static final int TRANSACTION_unregisterCallbacks = 13;

        public static class Proxy implements IMusicPlayService {
            public static IMusicPlayService sDefaultImpl;
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

            @Override // com.migu.music.ipc.IMusicPlayService
            public int getPlayMode() throws RemoteException {
                int playMode;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(10, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        playMode = parcelObtain2.readInt();
                    } else {
                        playMode = Stub.getDefaultImpl().getPlayMode();
                    }
                    return playMode;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.migu.music.ipc.IMusicPlayService
            public boolean isBridgeReady() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isBridgeReady();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.migu.music.ipc.IMusicPlayService
            public boolean isLoginSuccess() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isLoginSuccess();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.migu.music.ipc.IMusicPlayService
            public void pause() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().pause();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.migu.music.ipc.IMusicPlayService
            public void playNext() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().playNext();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.migu.music.ipc.IMusicPlayService
            public void playPrevious() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().playPrevious();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.migu.music.ipc.IMusicPlayService
            public void playSongByIds(List<String> list, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStringList(list);
                    parcelObtain.writeInt(i10);
                    if (this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().playSongByIds(list, i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.migu.music.ipc.IMusicPlayService
            public void querySongListInfo(List<String> list, IQuerySongListInfoCallback iQuerySongListInfoCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStringList(list);
                    parcelObtain.writeStrongBinder(iQuerySongListInfoCallback != null ? iQuerySongListInfoCallback.asBinder() : null);
                    if (this.mRemote.transact(14, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().querySongListInfo(list, iQuerySongListInfoCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.migu.music.ipc.IMusicPlayService
            public void registerCallbacks(IMusicPlayCallbacks iMusicPlayCallbacks) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMusicPlayCallbacks != null ? iMusicPlayCallbacks.asBinder() : null);
                    if (this.mRemote.transact(12, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().registerCallbacks(iMusicPlayCallbacks);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.migu.music.ipc.IMusicPlayService
            public void registerMusicIpcInitCallback(IMusicIpcInitCallback iMusicIpcInitCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMusicIpcInitCallback != null ? iMusicIpcInitCallback.asBinder() : null);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().registerMusicIpcInitCallback(iMusicIpcInitCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.migu.music.ipc.IMusicPlayService
            public void resume() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(8, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().resume();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.migu.music.ipc.IMusicPlayService
            public void seekToPlay(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    if (this.mRemote.transact(9, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().seekToPlay(i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.migu.music.ipc.IMusicPlayService
            public void setPlayMode(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    if (this.mRemote.transact(11, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setPlayMode(i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.migu.music.ipc.IMusicPlayService
            public void unregisterCallbacks(IMusicPlayCallbacks iMusicPlayCallbacks) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMusicPlayCallbacks != null ? iMusicPlayCallbacks.asBinder() : null);
                    if (this.mRemote.transact(13, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().unregisterCallbacks(iMusicPlayCallbacks);
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

        public static IMusicPlayService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMusicPlayService)) ? new Proxy(iBinder) : (IMusicPlayService) iInterfaceQueryLocalInterface;
        }

        public static IMusicPlayService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMusicPlayService iMusicPlayService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iMusicPlayService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iMusicPlayService;
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
                    boolean zIsBridgeReady = isBridgeReady();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsBridgeReady ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerMusicIpcInitCallback(IMusicIpcInitCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zIsLoginSuccess = isLoginSuccess();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsLoginSuccess ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    playSongByIds(parcel.createStringArrayList(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    playNext();
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    playPrevious();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    pause();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    resume();
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    seekToPlay(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    int playMode = getPlayMode();
                    parcel2.writeNoException();
                    parcel2.writeInt(playMode);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    setPlayMode(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerCallbacks(IMusicPlayCallbacks.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterCallbacks(IMusicPlayCallbacks.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    querySongListInfo(parcel.createStringArrayList(), IQuerySongListInfoCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    int getPlayMode() throws RemoteException;

    boolean isBridgeReady() throws RemoteException;

    boolean isLoginSuccess() throws RemoteException;

    void pause() throws RemoteException;

    void playNext() throws RemoteException;

    void playPrevious() throws RemoteException;

    void playSongByIds(List<String> list, int i10) throws RemoteException;

    void querySongListInfo(List<String> list, IQuerySongListInfoCallback iQuerySongListInfoCallback) throws RemoteException;

    void registerCallbacks(IMusicPlayCallbacks iMusicPlayCallbacks) throws RemoteException;

    void registerMusicIpcInitCallback(IMusicIpcInitCallback iMusicIpcInitCallback) throws RemoteException;

    void resume() throws RemoteException;

    void seekToPlay(int i10) throws RemoteException;

    void setPlayMode(int i10) throws RemoteException;

    void unregisterCallbacks(IMusicPlayCallbacks iMusicPlayCallbacks) throws RemoteException;
}
