package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IMediaControllerCallback extends IInterface {

    public static abstract class Stub extends Binder implements IMediaControllerCallback {
        private static final String DESCRIPTOR = "android.support.v4.media.session.IMediaControllerCallback";
        static final int TRANSACTION_onCaptioningEnabledChanged = 11;
        static final int TRANSACTION_onEvent = 1;
        static final int TRANSACTION_onExtrasChanged = 7;
        static final int TRANSACTION_onMetadataChanged = 4;
        static final int TRANSACTION_onPlaybackStateChanged = 3;
        static final int TRANSACTION_onQueueChanged = 5;
        static final int TRANSACTION_onQueueTitleChanged = 6;
        static final int TRANSACTION_onRepeatModeChanged = 9;
        static final int TRANSACTION_onSessionDestroyed = 2;
        static final int TRANSACTION_onSessionReady = 13;
        static final int TRANSACTION_onShuffleModeChanged = 12;
        static final int TRANSACTION_onShuffleModeChangedRemoved = 10;
        static final int TRANSACTION_onVolumeInfoChanged = 8;

        public static class Proxy implements IMediaControllerCallback {
            private IBinder mRemote;

            public Proxy(IBinder r10) {
                this.mRemote = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onCaptioningEnabledChanged(boolean r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r10 ? 1 : 0);     // Catch: Throwable -> L6
                this.mRemote.transact(11, r11, null, 1);     // Catch: Throwable -> L6
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onEvent(String r10, Bundle r11) throws RemoteException {
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeString(r10);     // Catch: Throwable -> L6
                if (r11 == null) goto L8;
                r12.writeInt(1);     // Catch: Throwable -> L6
                r11.writeToParcel(r12, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(1, r12, null, 1);     // Catch: Throwable -> L6
                r12.recycle();
                return;
            L8:
                r12.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r12.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                r11.writeInt(1);     // Catch: Throwable -> L6
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(7, r11, null, 1);     // Catch: Throwable -> L6
                r11.recycle();
                return;
            L8:
                r11.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r11.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                r11.writeInt(1);     // Catch: Throwable -> L6
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(4, r11, null, 1);     // Catch: Throwable -> L6
                r11.recycle();
                return;
            L8:
                r11.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r11.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onPlaybackStateChanged(PlaybackStateCompat r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                r11.writeInt(1);     // Catch: Throwable -> L6
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(3, r11, null, 1);     // Catch: Throwable -> L6
                r11.recycle();
                return;
            L8:
                r11.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r11.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List<MediaSessionCompat.QueueItem> r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeTypedList(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r11, null, 1);     // Catch: Throwable -> L6
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                r11.writeInt(1);     // Catch: Throwable -> L6
                TextUtils.writeToParcel(r10, r11, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(6, r11, null, 1);     // Catch: Throwable -> L6
                r11.recycle();
                return;
            L8:
                r11.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r11.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onRepeatModeChanged(int r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(9, r11, null, 1);     // Catch: Throwable -> L6
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r10, null, 1);     // Catch: Throwable -> L6
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r10.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionReady() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(13, r10, null, 1);     // Catch: Throwable -> L6
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r10.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChanged(int r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(12, r11, null, 1);     // Catch: Throwable -> L6
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChangedRemoved(boolean r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r10 ? 1 : 0);     // Catch: Throwable -> L6
                this.mRemote.transact(10, r11, null, 1);     // Catch: Throwable -> L6
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                r11.writeInt(1);     // Catch: Throwable -> L6
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(8, r11, null, 1);     // Catch: Throwable -> L6
                r11.recycle();
                return;
            L8:
                r11.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r11.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMediaControllerCallback asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof IMediaControllerCallback) == false) goto L12;
            return (IMediaControllerCallback) r11;
        L12:
            return new Proxy(r10);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) throws RemoteException {
            if (r10 == 1598968902) goto L58;
            boolean r14 = false;
            Bundle r15 = null;
            ParcelableVolumeInfo r16 = null;
            Bundle r17 = null;
            CharSequence r18 = null;
            MediaMetadataCompat r19 = null;
            PlaybackStateCompat r20 = null;
            switch(r10) {
                case 1: goto L53;
                case 2: goto L51;
                case 3: goto L46;
                case 4: goto L41;
                case 5: goto L39;
                case 6: goto L34;
                case 7: goto L29;
                case 8: goto L24;
                case 9: goto L22;
                case 10: goto L17;
                case 11: goto L12;
                case 12: goto L10;
                case 13: goto L8;
                default: goto L7;
            };
        L8:
            r11.enforceInterface(DESCRIPTOR);
            onSessionReady();
            return true;
        L10:
            r11.enforceInterface(DESCRIPTOR);
            onShuffleModeChanged(r11.readInt());
            return true;
        L12:
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L15;
            r14 = true;
        L15:
            onCaptioningEnabledChanged(r14);
            return true;
        L17:
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L20;
            r14 = true;
        L20:
            onShuffleModeChangedRemoved(r14);
            return true;
        L22:
            r11.enforceInterface(DESCRIPTOR);
            onRepeatModeChanged(r11.readInt());
            return true;
        L24:
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L27;
            r16 = ParcelableVolumeInfo.CREATOR.createFromParcel(r11);
        L27:
            onVolumeInfoChanged(r16);
            return true;
        L29:
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L32;
            r17 = (Bundle) Bundle.CREATOR.createFromParcel(r11);
        L32:
            onExtrasChanged(r17);
            return true;
        L34:
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L37;
            r18 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r11);
        L37:
            onQueueTitleChanged(r18);
            return true;
        L39:
            r11.enforceInterface(DESCRIPTOR);
            onQueueChanged(r11.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
            return true;
        L41:
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L44;
            r19 = MediaMetadataCompat.CREATOR.createFromParcel(r11);
        L44:
            onMetadataChanged(r19);
            return true;
        L46:
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L49;
            r20 = PlaybackStateCompat.CREATOR.createFromParcel(r11);
        L49:
            onPlaybackStateChanged(r20);
            return true;
        L51:
            r11.enforceInterface(DESCRIPTOR);
            onSessionDestroyed();
            return true;
        L53:
            r11.enforceInterface(DESCRIPTOR);
            String r21 = r11.readString();
            if (r11.readInt() == 0) goto L56;
            r15 = (Bundle) Bundle.CREATOR.createFromParcel(r11);
        L56:
            onEvent(r21, r15);
            return true;
        L7:
            return super.onTransact(r10, r11, r12, r13);
        L58:
            r12.writeString(DESCRIPTOR);
            return true;
        }
    }

    void onCaptioningEnabledChanged(boolean r10) throws RemoteException;

    void onEvent(String r10, Bundle r11) throws RemoteException;

    void onExtrasChanged(Bundle r10) throws RemoteException;

    void onMetadataChanged(MediaMetadataCompat r10) throws RemoteException;

    void onPlaybackStateChanged(PlaybackStateCompat r10) throws RemoteException;

    void onQueueChanged(List<MediaSessionCompat.QueueItem> r10) throws RemoteException;

    void onQueueTitleChanged(CharSequence r10) throws RemoteException;

    void onRepeatModeChanged(int r10) throws RemoteException;

    void onSessionDestroyed() throws RemoteException;

    void onSessionReady() throws RemoteException;

    void onShuffleModeChanged(int r10) throws RemoteException;

    void onShuffleModeChangedRemoved(boolean r10) throws RemoteException;

    void onVolumeInfoChanged(ParcelableVolumeInfo r10) throws RemoteException;
}
