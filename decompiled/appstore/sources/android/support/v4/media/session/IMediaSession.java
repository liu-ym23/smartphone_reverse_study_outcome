package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IMediaSession extends IInterface {

    public static abstract class Stub extends Binder implements IMediaSession {
        private static final String DESCRIPTOR = "android.support.v4.media.session.IMediaSession";
        static final int TRANSACTION_addQueueItem = 41;
        static final int TRANSACTION_addQueueItemAt = 42;
        static final int TRANSACTION_adjustVolume = 11;
        static final int TRANSACTION_fastForward = 22;
        static final int TRANSACTION_getExtras = 31;
        static final int TRANSACTION_getFlags = 9;
        static final int TRANSACTION_getLaunchPendingIntent = 8;
        static final int TRANSACTION_getMetadata = 27;
        static final int TRANSACTION_getPackageName = 6;
        static final int TRANSACTION_getPlaybackState = 28;
        static final int TRANSACTION_getQueue = 29;
        static final int TRANSACTION_getQueueTitle = 30;
        static final int TRANSACTION_getRatingType = 32;
        static final int TRANSACTION_getRepeatMode = 37;
        static final int TRANSACTION_getShuffleMode = 47;
        static final int TRANSACTION_getTag = 7;
        static final int TRANSACTION_getVolumeAttributes = 10;
        static final int TRANSACTION_isCaptioningEnabled = 45;
        static final int TRANSACTION_isShuffleModeEnabledRemoved = 38;
        static final int TRANSACTION_isTransportControlEnabled = 5;
        static final int TRANSACTION_next = 20;
        static final int TRANSACTION_pause = 18;
        static final int TRANSACTION_play = 13;
        static final int TRANSACTION_playFromMediaId = 14;
        static final int TRANSACTION_playFromSearch = 15;
        static final int TRANSACTION_playFromUri = 16;
        static final int TRANSACTION_prepare = 33;
        static final int TRANSACTION_prepareFromMediaId = 34;
        static final int TRANSACTION_prepareFromSearch = 35;
        static final int TRANSACTION_prepareFromUri = 36;
        static final int TRANSACTION_previous = 21;
        static final int TRANSACTION_rate = 25;
        static final int TRANSACTION_rateWithExtras = 51;
        static final int TRANSACTION_registerCallbackListener = 3;
        static final int TRANSACTION_removeQueueItem = 43;
        static final int TRANSACTION_removeQueueItemAt = 44;
        static final int TRANSACTION_rewind = 23;
        static final int TRANSACTION_seekTo = 24;
        static final int TRANSACTION_sendCommand = 1;
        static final int TRANSACTION_sendCustomAction = 26;
        static final int TRANSACTION_sendMediaButton = 2;
        static final int TRANSACTION_setCaptioningEnabled = 46;
        static final int TRANSACTION_setRepeatMode = 39;
        static final int TRANSACTION_setShuffleMode = 48;
        static final int TRANSACTION_setShuffleModeEnabledRemoved = 40;
        static final int TRANSACTION_setVolumeTo = 12;
        static final int TRANSACTION_skipToQueueItem = 17;
        static final int TRANSACTION_stop = 19;
        static final int TRANSACTION_unregisterCallbackListener = 4;

        public static class Proxy implements IMediaSession {
            private IBinder mRemote;

            public Proxy(IBinder r10) {
                this.mRemote = r10;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                r11.writeInt(1);     // Catch: Throwable -> L6
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(41, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L8:
                r11.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat r10, int r11) throws RemoteException {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                r12.writeInt(1);     // Catch: Throwable -> L6
                r10.writeToParcel(r12, 0);     // Catch: Throwable -> L6
            L9:
                r12.writeInt(r11);     // Catch: Throwable -> L6
                this.mRemote.transact(42, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L8:
                r12.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int r10, int r11, String r12) throws RemoteException {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r13.writeInt(r10);     // Catch: Throwable -> L6
                r13.writeInt(r11);     // Catch: Throwable -> L6
                r13.writeString(r12);     // Catch: Throwable -> L6
                this.mRemote.transact(11, r13, r14, 0);     // Catch: Throwable -> L6
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void fastForward() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(22, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L7
                this.mRemote.transact(31, r10, r11, 0);     // Catch: Throwable -> L7
                r11.readException();     // Catch: Throwable -> L7
                if (r11.readInt() == 0) goto L9;
                Bundle r12 = (Bundle) Bundle.CREATOR.createFromParcel(r11);     // Catch: Throwable -> L7
            L10:
                r11.recycle();
                r10.recycle();
                return r12;
            L9:
                r12 = null;
            L7:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long getFlags() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(9, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                long r12 = r11.readLong();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L7
                this.mRemote.transact(8, r10, r11, 0);     // Catch: Throwable -> L7
                r11.readException();     // Catch: Throwable -> L7
                if (r11.readInt() == 0) goto L9;
                PendingIntent r12 = (PendingIntent) PendingIntent.CREATOR.createFromParcel(r11);     // Catch: Throwable -> L7
            L10:
                r11.recycle();
                r10.recycle();
                return r12;
            L9:
                r12 = null;
            L7:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L7
                this.mRemote.transact(27, r10, r11, 0);     // Catch: Throwable -> L7
                r11.readException();     // Catch: Throwable -> L7
                if (r11.readInt() == 0) goto L9;
                MediaMetadataCompat r12 = MediaMetadataCompat.CREATOR.createFromParcel(r11);     // Catch: Throwable -> L7
            L10:
                r11.recycle();
                r10.recycle();
                return r12;
            L9:
                r12 = null;
            L7:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getPackageName() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(6, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                String r12 = r11.readString();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L7
                this.mRemote.transact(28, r10, r11, 0);     // Catch: Throwable -> L7
                r11.readException();     // Catch: Throwable -> L7
                if (r11.readInt() == 0) goto L9;
                PlaybackStateCompat r12 = PlaybackStateCompat.CREATOR.createFromParcel(r11);     // Catch: Throwable -> L7
            L10:
                r11.recycle();
                r10.recycle();
                return r12;
            L9:
                r12 = null;
            L7:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public List<MediaSessionCompat.QueueItem> getQueue() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(29, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                ArrayList r12 = r11.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR);     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public CharSequence getQueueTitle() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L7
                this.mRemote.transact(30, r10, r11, 0);     // Catch: Throwable -> L7
                r11.readException();     // Catch: Throwable -> L7
                if (r11.readInt() == 0) goto L9;
                CharSequence r12 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r11);     // Catch: Throwable -> L7
            L10:
                r11.recycle();
                r10.recycle();
                return r12;
            L9:
                r12 = null;
            L7:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRatingType() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(32, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                int r12 = r11.readInt();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(37, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                int r12 = r11.readInt();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(47, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                int r12 = r11.readInt();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getTag() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(7, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                String r12 = r11.readString();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L7
                this.mRemote.transact(10, r10, r11, 0);     // Catch: Throwable -> L7
                r11.readException();     // Catch: Throwable -> L7
                if (r11.readInt() == 0) goto L9;
                ParcelableVolumeInfo r12 = ParcelableVolumeInfo.CREATOR.createFromParcel(r11);     // Catch: Throwable -> L7
            L10:
                r11.recycle();
                r10.recycle();
                return r12;
            L9:
                r12 = null;
            L7:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r12 = false;
                this.mRemote.transact(45, r10, r11, 0);     // Catch: Throwable -> L8
                r11.readException();     // Catch: Throwable -> L8
                if (r11.readInt() == 0) goto L6;
                r12 = true;
            L6:
                r11.recycle();
                r10.recycle();
                return r12;
            L8:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r12 = false;
                this.mRemote.transact(38, r10, r11, 0);     // Catch: Throwable -> L8
                r11.readException();     // Catch: Throwable -> L8
                if (r11.readInt() == 0) goto L6;
                r12 = true;
            L6:
                r11.recycle();
                r10.recycle();
                return r12;
            L8:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r12 = false;
                this.mRemote.transact(5, r10, r11, 0);     // Catch: Throwable -> L8
                r11.readException();     // Catch: Throwable -> L8
                if (r11.readInt() == 0) goto L6;
                r12 = true;
            L6:
                r11.recycle();
                r10.recycle();
                return r12;
            L8:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(20, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(18, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void play() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(13, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String r10, Bundle r11) throws RemoteException {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeString(r10);     // Catch: Throwable -> L6
                if (r11 == null) goto L8;
                r12.writeInt(1);     // Catch: Throwable -> L6
                r11.writeToParcel(r12, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(14, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L8:
                r12.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String r10, Bundle r11) throws RemoteException {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeString(r10);     // Catch: Throwable -> L6
                if (r11 == null) goto L8;
                r12.writeInt(1);     // Catch: Throwable -> L6
                r11.writeToParcel(r12, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(15, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L8:
                r12.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri r10, Bundle r11) throws RemoteException {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                r12.writeInt(1);     // Catch: Throwable -> L6
                r10.writeToParcel(r12, 0);     // Catch: Throwable -> L6
            L9:
                if (r11 == null) goto L11;
                r12.writeInt(1);     // Catch: Throwable -> L6
                r11.writeToParcel(r12, 0);     // Catch: Throwable -> L6
            L12:
                this.mRemote.transact(16, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L11:
                r12.writeInt(0);     // Catch: Throwable -> L6
                goto L12
            L8:
                r12.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(33, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String r10, Bundle r11) throws RemoteException {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeString(r10);     // Catch: Throwable -> L6
                if (r11 == null) goto L8;
                r12.writeInt(1);     // Catch: Throwable -> L6
                r11.writeToParcel(r12, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(34, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L8:
                r12.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String r10, Bundle r11) throws RemoteException {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeString(r10);     // Catch: Throwable -> L6
                if (r11 == null) goto L8;
                r12.writeInt(1);     // Catch: Throwable -> L6
                r11.writeToParcel(r12, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(35, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L8:
                r12.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri r10, Bundle r11) throws RemoteException {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                r12.writeInt(1);     // Catch: Throwable -> L6
                r10.writeToParcel(r12, 0);     // Catch: Throwable -> L6
            L9:
                if (r11 == null) goto L11;
                r12.writeInt(1);     // Catch: Throwable -> L6
                r11.writeToParcel(r12, 0);     // Catch: Throwable -> L6
            L12:
                this.mRemote.transact(36, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L11:
                r12.writeInt(0);     // Catch: Throwable -> L6
                goto L12
            L8:
                r12.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(21, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                r11.writeInt(1);     // Catch: Throwable -> L6
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(25, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L8:
                r11.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat r10, Bundle r11) throws RemoteException {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                r12.writeInt(1);     // Catch: Throwable -> L6
                r10.writeToParcel(r12, 0);     // Catch: Throwable -> L6
            L9:
                if (r11 == null) goto L11;
                r12.writeInt(1);     // Catch: Throwable -> L6
                r11.writeToParcel(r12, 0);     // Catch: Throwable -> L6
            L12:
                this.mRemote.transact(51, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L11:
                r12.writeInt(0);     // Catch: Throwable -> L6
                goto L12
            L8:
                r12.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                IBinder r13 = r10.asBinder();     // Catch: Throwable -> L6
            L9:
                r11.writeStrongBinder(r13);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L8:
                r13 = null;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                r11.writeInt(1);     // Catch: Throwable -> L6
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(43, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L8:
                r11.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(44, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(23, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeLong(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(24, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(String r10, Bundle r11, MediaSessionCompat.ResultReceiverWrapper r12) throws RemoteException {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r13.writeString(r10);     // Catch: Throwable -> L6
                if (r11 == null) goto L8;
                r13.writeInt(1);     // Catch: Throwable -> L6
                r11.writeToParcel(r13, 0);     // Catch: Throwable -> L6
            L9:
                if (r12 == null) goto L11;
                r13.writeInt(1);     // Catch: Throwable -> L6
                r12.writeToParcel(r13, 0);     // Catch: Throwable -> L6
            L12:
                this.mRemote.transact(1, r13, r14, 0);     // Catch: Throwable -> L6
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L11:
                r13.writeInt(0);     // Catch: Throwable -> L6
                goto L12
            L8:
                r13.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String r10, Bundle r11) throws RemoteException {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeString(r10);     // Catch: Throwable -> L6
                if (r11 == null) goto L8;
                r12.writeInt(1);     // Catch: Throwable -> L6
                r11.writeToParcel(r12, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(26, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L8:
                r12.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                boolean r13 = true;
                if (r10 == null) goto L8;
                r11.writeInt(1);     // Catch: Throwable -> L6
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(2, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                if (r12.readInt() != 0) goto L13;
                r13 = false;
            L13:
                r12.recycle();
                r11.recycle();
                return r13;
            L8:
                r11.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r10 ? 1 : 0);     // Catch: Throwable -> L6
                this.mRemote.transact(46, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(39, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(48, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r10 ? 1 : 0);     // Catch: Throwable -> L6
                this.mRemote.transact(40, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int r10, int r11, String r12) throws RemoteException {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r13.writeInt(r10);     // Catch: Throwable -> L6
                r13.writeInt(r11);     // Catch: Throwable -> L6
                r13.writeString(r12);     // Catch: Throwable -> L6
                this.mRemote.transact(12, r13, r14, 0);     // Catch: Throwable -> L6
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeLong(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(17, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(19, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                IBinder r13 = r10.asBinder();     // Catch: Throwable -> L6
            L9:
                r11.writeStrongBinder(r13);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L8:
                r13 = null;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMediaSession asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof IMediaSession) == false) goto L12;
            return (IMediaSession) r11;
        L12:
            return new Proxy(r10);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) throws RemoteException {
            Bundle r14 = null;
            MediaDescriptionCompat r15 = null;
            MediaDescriptionCompat r16 = null;
            MediaDescriptionCompat r17 = null;
            Bundle r18 = null;
            Bundle r19 = null;
            Bundle r20 = null;
            Bundle r21 = null;
            RatingCompat r22 = null;
            Bundle r23 = null;
            Bundle r24 = null;
            Bundle r25 = null;
            KeyEvent r26 = null;
            MediaSessionCompat.ResultReceiverWrapper r27 = null;
            if (r10 != 51) goto L5;
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L186;
            RatingCompat r28 = RatingCompat.CREATOR.createFromParcel(r11);
        L188:
            if (r11.readInt() == 0) goto L190;
            r14 = (Bundle) Bundle.CREATOR.createFromParcel(r11);
        L190:
            rateWithExtras(r28, r14);
            r12.writeNoException();
            return true;
        L186:
            r28 = null;
            goto L188
        L5:
            if (r10 == 1598968902) goto L181;
            boolean r29 = false;
            switch(r10) {
                case 1: goto L172;
                case 2: goto L167;
                case 3: goto L165;
                case 4: goto L163;
                case 5: goto L161;
                case 6: goto L159;
                case 7: goto L157;
                case 8: goto L152;
                case 9: goto L150;
                case 10: goto L145;
                case 11: goto L143;
                case 12: goto L141;
                case 13: goto L139;
                case 14: goto L134;
                case 15: goto L129;
                case 16: goto L120;
                case 17: goto L118;
                case 18: goto L116;
                case 19: goto L114;
                case 20: goto L112;
                case 21: goto L110;
                case 22: goto L108;
                case 23: goto L106;
                case 24: goto L104;
                case 25: goto L99;
                case 26: goto L94;
                case 27: goto L89;
                case 28: goto L84;
                case 29: goto L82;
                case 30: goto L77;
                case 31: goto L72;
                case 32: goto L70;
                case 33: goto L68;
                case 34: goto L63;
                case 35: goto L58;
                case 36: goto L49;
                case 37: goto L47;
                case 38: goto L45;
                case 39: goto L43;
                case 40: goto L38;
                case 41: goto L33;
                case 42: goto L28;
                case 43: goto L23;
                case 44: goto L21;
                case 45: goto L19;
                case 46: goto L14;
                case 47: goto L12;
                case 48: goto L10;
                default: goto L9;
            };
        L10:
            r11.enforceInterface(DESCRIPTOR);
            setShuffleMode(r11.readInt());
            r12.writeNoException();
            return true;
        L12:
            r11.enforceInterface(DESCRIPTOR);
            int r30 = getShuffleMode();
            r12.writeNoException();
            r12.writeInt(r30);
            return true;
        L14:
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L17;
            r29 = true;
        L17:
            setCaptioningEnabled(r29);
            r12.writeNoException();
            return true;
        L19:
            r11.enforceInterface(DESCRIPTOR);
            boolean r31 = isCaptioningEnabled();
            r12.writeNoException();
            r12.writeInt(r31 ? 1 : 0);
            return true;
        L21:
            r11.enforceInterface(DESCRIPTOR);
            removeQueueItemAt(r11.readInt());
            r12.writeNoException();
            return true;
        L23:
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L26;
            r15 = MediaDescriptionCompat.CREATOR.createFromParcel(r11);
        L26:
            removeQueueItem(r15);
            r12.writeNoException();
            return true;
        L28:
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L31;
            r16 = MediaDescriptionCompat.CREATOR.createFromParcel(r11);
        L31:
            addQueueItemAt(r16, r11.readInt());
            r12.writeNoException();
            return true;
        L33:
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L36;
            r17 = MediaDescriptionCompat.CREATOR.createFromParcel(r11);
        L36:
            addQueueItem(r17);
            r12.writeNoException();
            return true;
        L38:
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L41;
            r29 = true;
        L41:
            setShuffleModeEnabledRemoved(r29);
            r12.writeNoException();
            return true;
        L43:
            r11.enforceInterface(DESCRIPTOR);
            setRepeatMode(r11.readInt());
            r12.writeNoException();
            return true;
        L45:
            r11.enforceInterface(DESCRIPTOR);
            boolean r32 = isShuffleModeEnabledRemoved();
            r12.writeNoException();
            r12.writeInt(r32 ? 1 : 0);
            return true;
        L47:
            r11.enforceInterface(DESCRIPTOR);
            int r33 = getRepeatMode();
            r12.writeNoException();
            r12.writeInt(r33);
            return true;
        L49:
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L52;
            Uri r34 = (Uri) Uri.CREATOR.createFromParcel(r11);
        L54:
            if (r11.readInt() == 0) goto L56;
            r18 = (Bundle) Bundle.CREATOR.createFromParcel(r11);
        L56:
            prepareFromUri(r34, r18);
            r12.writeNoException();
            return true;
        L52:
            r34 = null;
            goto L54
        L58:
            r11.enforceInterface(DESCRIPTOR);
            String r35 = r11.readString();
            if (r11.readInt() == 0) goto L61;
            r19 = (Bundle) Bundle.CREATOR.createFromParcel(r11);
        L61:
            prepareFromSearch(r35, r19);
            r12.writeNoException();
            return true;
        L63:
            r11.enforceInterface(DESCRIPTOR);
            String r36 = r11.readString();
            if (r11.readInt() == 0) goto L66;
            r20 = (Bundle) Bundle.CREATOR.createFromParcel(r11);
        L66:
            prepareFromMediaId(r36, r20);
            r12.writeNoException();
            return true;
        L68:
            r11.enforceInterface(DESCRIPTOR);
            prepare();
            r12.writeNoException();
            return true;
        L70:
            r11.enforceInterface(DESCRIPTOR);
            int r37 = getRatingType();
            r12.writeNoException();
            r12.writeInt(r37);
            return true;
        L72:
            r11.enforceInterface(DESCRIPTOR);
            Bundle r38 = getExtras();
            r12.writeNoException();
            if (r38 == null) goto L75;
            r12.writeInt(1);
            r38.writeToParcel(r12, 1);
        L76:
            return true;
        L75:
            r12.writeInt(0);
            goto L76
        L77:
            r11.enforceInterface(DESCRIPTOR);
            CharSequence r39 = getQueueTitle();
            r12.writeNoException();
            if (r39 == null) goto L80;
            r12.writeInt(1);
            TextUtils.writeToParcel(r39, r12, 1);
        L81:
            return true;
        L80:
            r12.writeInt(0);
            goto L81
        L82:
            r11.enforceInterface(DESCRIPTOR);
            List<MediaSessionCompat.QueueItem> r40 = getQueue();
            r12.writeNoException();
            r12.writeTypedList(r40);
            return true;
        L84:
            r11.enforceInterface(DESCRIPTOR);
            PlaybackStateCompat r41 = getPlaybackState();
            r12.writeNoException();
            if (r41 == null) goto L87;
            r12.writeInt(1);
            r41.writeToParcel(r12, 1);
        L88:
            return true;
        L87:
            r12.writeInt(0);
            goto L88
        L89:
            r11.enforceInterface(DESCRIPTOR);
            MediaMetadataCompat r42 = getMetadata();
            r12.writeNoException();
            if (r42 == null) goto L92;
            r12.writeInt(1);
            r42.writeToParcel(r12, 1);
        L93:
            return true;
        L92:
            r12.writeInt(0);
            goto L93
        L94:
            r11.enforceInterface(DESCRIPTOR);
            String r43 = r11.readString();
            if (r11.readInt() == 0) goto L97;
            r21 = (Bundle) Bundle.CREATOR.createFromParcel(r11);
        L97:
            sendCustomAction(r43, r21);
            r12.writeNoException();
            return true;
        L99:
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L102;
            r22 = RatingCompat.CREATOR.createFromParcel(r11);
        L102:
            rate(r22);
            r12.writeNoException();
            return true;
        L104:
            r11.enforceInterface(DESCRIPTOR);
            seekTo(r11.readLong());
            r12.writeNoException();
            return true;
        L106:
            r11.enforceInterface(DESCRIPTOR);
            rewind();
            r12.writeNoException();
            return true;
        L108:
            r11.enforceInterface(DESCRIPTOR);
            fastForward();
            r12.writeNoException();
            return true;
        L110:
            r11.enforceInterface(DESCRIPTOR);
            previous();
            r12.writeNoException();
            return true;
        L112:
            r11.enforceInterface(DESCRIPTOR);
            next();
            r12.writeNoException();
            return true;
        L114:
            r11.enforceInterface(DESCRIPTOR);
            stop();
            r12.writeNoException();
            return true;
        L116:
            r11.enforceInterface(DESCRIPTOR);
            pause();
            r12.writeNoException();
            return true;
        L118:
            r11.enforceInterface(DESCRIPTOR);
            skipToQueueItem(r11.readLong());
            r12.writeNoException();
            return true;
        L120:
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L123;
            Uri r44 = (Uri) Uri.CREATOR.createFromParcel(r11);
        L125:
            if (r11.readInt() == 0) goto L127;
            r23 = (Bundle) Bundle.CREATOR.createFromParcel(r11);
        L127:
            playFromUri(r44, r23);
            r12.writeNoException();
            return true;
        L123:
            r44 = null;
            goto L125
        L129:
            r11.enforceInterface(DESCRIPTOR);
            String r45 = r11.readString();
            if (r11.readInt() == 0) goto L132;
            r24 = (Bundle) Bundle.CREATOR.createFromParcel(r11);
        L132:
            playFromSearch(r45, r24);
            r12.writeNoException();
            return true;
        L134:
            r11.enforceInterface(DESCRIPTOR);
            String r46 = r11.readString();
            if (r11.readInt() == 0) goto L137;
            r25 = (Bundle) Bundle.CREATOR.createFromParcel(r11);
        L137:
            playFromMediaId(r46, r25);
            r12.writeNoException();
            return true;
        L139:
            r11.enforceInterface(DESCRIPTOR);
            play();
            r12.writeNoException();
            return true;
        L141:
            r11.enforceInterface(DESCRIPTOR);
            setVolumeTo(r11.readInt(), r11.readInt(), r11.readString());
            r12.writeNoException();
            return true;
        L143:
            r11.enforceInterface(DESCRIPTOR);
            adjustVolume(r11.readInt(), r11.readInt(), r11.readString());
            r12.writeNoException();
            return true;
        L145:
            r11.enforceInterface(DESCRIPTOR);
            ParcelableVolumeInfo r47 = getVolumeAttributes();
            r12.writeNoException();
            if (r47 == null) goto L148;
            r12.writeInt(1);
            r47.writeToParcel(r12, 1);
        L149:
            return true;
        L148:
            r12.writeInt(0);
            goto L149
        L150:
            r11.enforceInterface(DESCRIPTOR);
            long r48 = getFlags();
            r12.writeNoException();
            r12.writeLong(r48);
            return true;
        L152:
            r11.enforceInterface(DESCRIPTOR);
            PendingIntent r49 = getLaunchPendingIntent();
            r12.writeNoException();
            if (r49 == null) goto L155;
            r12.writeInt(1);
            r49.writeToParcel(r12, 1);
        L156:
            return true;
        L155:
            r12.writeInt(0);
            goto L156
        L157:
            r11.enforceInterface(DESCRIPTOR);
            String r50 = getTag();
            r12.writeNoException();
            r12.writeString(r50);
            return true;
        L159:
            r11.enforceInterface(DESCRIPTOR);
            String r51 = getPackageName();
            r12.writeNoException();
            r12.writeString(r51);
            return true;
        L161:
            r11.enforceInterface(DESCRIPTOR);
            boolean r52 = isTransportControlEnabled();
            r12.writeNoException();
            r12.writeInt(r52 ? 1 : 0);
            return true;
        L163:
            r11.enforceInterface(DESCRIPTOR);
            unregisterCallbackListener(IMediaControllerCallback.Stub.asInterface(r11.readStrongBinder()));
            r12.writeNoException();
            return true;
        L165:
            r11.enforceInterface(DESCRIPTOR);
            registerCallbackListener(IMediaControllerCallback.Stub.asInterface(r11.readStrongBinder()));
            r12.writeNoException();
            return true;
        L167:
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L170;
            r26 = (KeyEvent) KeyEvent.CREATOR.createFromParcel(r11);
        L170:
            boolean r53 = sendMediaButton(r26);
            r12.writeNoException();
            r12.writeInt(r53 ? 1 : 0);
            return true;
        L172:
            r11.enforceInterface(DESCRIPTOR);
            String r54 = r11.readString();
            if (r11.readInt() == 0) goto L175;
            Bundle r55 = (Bundle) Bundle.CREATOR.createFromParcel(r11);
        L177:
            if (r11.readInt() == 0) goto L179;
            r27 = MediaSessionCompat.ResultReceiverWrapper.CREATOR.createFromParcel(r11);
        L179:
            sendCommand(r54, r55, r27);
            r12.writeNoException();
            return true;
        L175:
            r55 = null;
            goto L177
        L9:
            return super.onTransact(r10, r11, r12, r13);
        L181:
            r12.writeString(DESCRIPTOR);
            return true;
        }
    }

    void addQueueItem(MediaDescriptionCompat r10) throws RemoteException;

    void addQueueItemAt(MediaDescriptionCompat r10, int r11) throws RemoteException;

    void adjustVolume(int r10, int r11, String r12) throws RemoteException;

    void fastForward() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    long getFlags() throws RemoteException;

    PendingIntent getLaunchPendingIntent() throws RemoteException;

    MediaMetadataCompat getMetadata() throws RemoteException;

    String getPackageName() throws RemoteException;

    PlaybackStateCompat getPlaybackState() throws RemoteException;

    List<MediaSessionCompat.QueueItem> getQueue() throws RemoteException;

    CharSequence getQueueTitle() throws RemoteException;

    int getRatingType() throws RemoteException;

    int getRepeatMode() throws RemoteException;

    int getShuffleMode() throws RemoteException;

    String getTag() throws RemoteException;

    ParcelableVolumeInfo getVolumeAttributes() throws RemoteException;

    boolean isCaptioningEnabled() throws RemoteException;

    boolean isShuffleModeEnabledRemoved() throws RemoteException;

    boolean isTransportControlEnabled() throws RemoteException;

    void next() throws RemoteException;

    void pause() throws RemoteException;

    void play() throws RemoteException;

    void playFromMediaId(String r10, Bundle r11) throws RemoteException;

    void playFromSearch(String r10, Bundle r11) throws RemoteException;

    void playFromUri(Uri r10, Bundle r11) throws RemoteException;

    void prepare() throws RemoteException;

    void prepareFromMediaId(String r10, Bundle r11) throws RemoteException;

    void prepareFromSearch(String r10, Bundle r11) throws RemoteException;

    void prepareFromUri(Uri r10, Bundle r11) throws RemoteException;

    void previous() throws RemoteException;

    void rate(RatingCompat r10) throws RemoteException;

    void rateWithExtras(RatingCompat r10, Bundle r11) throws RemoteException;

    void registerCallbackListener(IMediaControllerCallback r10) throws RemoteException;

    void removeQueueItem(MediaDescriptionCompat r10) throws RemoteException;

    void removeQueueItemAt(int r10) throws RemoteException;

    void rewind() throws RemoteException;

    void seekTo(long r10) throws RemoteException;

    void sendCommand(String r10, Bundle r11, MediaSessionCompat.ResultReceiverWrapper r12) throws RemoteException;

    void sendCustomAction(String r10, Bundle r11) throws RemoteException;

    boolean sendMediaButton(KeyEvent r10) throws RemoteException;

    void setCaptioningEnabled(boolean r10) throws RemoteException;

    void setRepeatMode(int r10) throws RemoteException;

    void setShuffleMode(int r10) throws RemoteException;

    void setShuffleModeEnabledRemoved(boolean r10) throws RemoteException;

    void setVolumeTo(int r10, int r11, String r12) throws RemoteException;

    void skipToQueueItem(long r10) throws RemoteException;

    void stop() throws RemoteException;

    void unregisterCallbackListener(IMediaControllerCallback r10) throws RemoteException;
}
