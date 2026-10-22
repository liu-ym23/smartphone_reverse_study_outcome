package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
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

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void fastForward() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 22, r100, r101, 0);     // Catch: Throwable -> L6
                r101.readException();     // Catch: Throwable -> L6
                r101.recycle();
                r100.recycle();
                return;
            L6:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 31, r100, r101, 0);     // Catch: Throwable -> L10
                r101.readException();     // Catch: Throwable -> L10
                if (r101.readInt() == 0) goto L7;
                Bundle r102 = (Bundle) Bundle.CREATOR.createFromParcel(r101);     // Catch: Throwable -> L10
            L8:
                r101.recycle();
                r100.recycle();
                return r102;
            L7:
                r102 = null;
            L10:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long getFlags() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r100, r101, 0);     // Catch: Throwable -> L6
                r101.readException();     // Catch: Throwable -> L6
                long r102 = r101.readLong();     // Catch: Throwable -> L6
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r100, r101, 0);     // Catch: Throwable -> L10
                r101.readException();     // Catch: Throwable -> L10
                if (r101.readInt() == 0) goto L7;
                PendingIntent r102 = (PendingIntent) PendingIntent.CREATOR.createFromParcel(r101);     // Catch: Throwable -> L10
            L8:
                r101.recycle();
                r100.recycle();
                return r102;
            L7:
                r102 = null;
            L10:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 27, r100, r101, 0);     // Catch: Throwable -> L10
                r101.readException();     // Catch: Throwable -> L10
                if (r101.readInt() == 0) goto L7;
                MediaMetadataCompat r102 = MediaMetadataCompat.CREATOR.createFromParcel(r101);     // Catch: Throwable -> L10
            L8:
                r101.recycle();
                r100.recycle();
                return r102;
            L7:
                r102 = null;
            L10:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getPackageName() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r100, r101, 0);     // Catch: Throwable -> L6
                r101.readException();     // Catch: Throwable -> L6
                String r102 = r101.readString();     // Catch: Throwable -> L6
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 28, r100, r101, 0);     // Catch: Throwable -> L10
                r101.readException();     // Catch: Throwable -> L10
                if (r101.readInt() == 0) goto L7;
                PlaybackStateCompat r102 = PlaybackStateCompat.CREATOR.createFromParcel(r101);     // Catch: Throwable -> L10
            L8:
                r101.recycle();
                r100.recycle();
                return r102;
            L7:
                r102 = null;
            L10:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public List<MediaSessionCompat.QueueItem> getQueue() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 29, r100, r101, 0);     // Catch: Throwable -> L6
                r101.readException();     // Catch: Throwable -> L6
                ArrayList r102 = r101.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR);     // Catch: Throwable -> L6
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public CharSequence getQueueTitle() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 30, r100, r101, 0);     // Catch: Throwable -> L10
                r101.readException();     // Catch: Throwable -> L10
                if (r101.readInt() == 0) goto L7;
                CharSequence r102 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r101);     // Catch: Throwable -> L10
            L8:
                r101.recycle();
                r100.recycle();
                return r102;
            L7:
                r102 = null;
            L10:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRatingType() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 32, r100, r101, 0);     // Catch: Throwable -> L6
                r101.readException();     // Catch: Throwable -> L6
                int r102 = r101.readInt();     // Catch: Throwable -> L6
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 37, r100, r101, 0);     // Catch: Throwable -> L6
                r101.readException();     // Catch: Throwable -> L6
                int r102 = r101.readInt();     // Catch: Throwable -> L6
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 47, r100, r101, 0);     // Catch: Throwable -> L6
                r101.readException();     // Catch: Throwable -> L6
                int r102 = r101.readInt();     // Catch: Throwable -> L6
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getTag() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r100, r101, 0);     // Catch: Throwable -> L6
                r101.readException();     // Catch: Throwable -> L6
                String r102 = r101.readString();     // Catch: Throwable -> L6
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r100, r101, 0);     // Catch: Throwable -> L10
                r101.readException();     // Catch: Throwable -> L10
                if (r101.readInt() == 0) goto L7;
                ParcelableVolumeInfo r102 = ParcelableVolumeInfo.CREATOR.createFromParcel(r101);     // Catch: Throwable -> L10
            L8:
                r101.recycle();
                r100.recycle();
                return r102;
            L7:
                r102 = null;
            L10:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r102 = false;
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 45, r100, r101, 0);     // Catch: Throwable -> L8
                r101.readException();     // Catch: Throwable -> L8
                if (r101.readInt() == 0) goto L6;
                r102 = true;
            L6:
                r101.recycle();
                r100.recycle();
                return r102;
            L8:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r102 = false;
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 38, r100, r101, 0);     // Catch: Throwable -> L8
                r101.readException();     // Catch: Throwable -> L8
                if (r101.readInt() == 0) goto L6;
                r102 = true;
            L6:
                r101.recycle();
                r100.recycle();
                return r102;
            L8:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r102 = false;
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r100, r101, 0);     // Catch: Throwable -> L8
                r101.readException();     // Catch: Throwable -> L8
                if (r101.readInt() == 0) goto L6;
                r102 = true;
            L6:
                r101.recycle();
                r100.recycle();
                return r102;
            L8:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 20, r100, r101, 0);     // Catch: Throwable -> L6
                r101.readException();     // Catch: Throwable -> L6
                r101.recycle();
                r100.recycle();
                return;
            L6:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 18, r100, r101, 0);     // Catch: Throwable -> L6
                r101.readException();     // Catch: Throwable -> L6
                r101.recycle();
                r100.recycle();
                return;
            L6:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void play() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r100, r101, 0);     // Catch: Throwable -> L6
                r101.readException();     // Catch: Throwable -> L6
                r101.recycle();
                r100.recycle();
                return;
            L6:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 33, r100, r101, 0);     // Catch: Throwable -> L6
                r101.readException();     // Catch: Throwable -> L6
                r101.recycle();
                r100.recycle();
                return;
            L6:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 21, r100, r101, 0);     // Catch: Throwable -> L6
                r101.readException();     // Catch: Throwable -> L6
                r101.recycle();
                r100.recycle();
                return;
            L6:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 23, r100, r101, 0);     // Catch: Throwable -> L6
                r101.readException();     // Catch: Throwable -> L6
                r101.recycle();
                r100.recycle();
                return;
            L6:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 19, r100, r101, 0);     // Catch: Throwable -> L6
                r101.readException();     // Catch: Throwable -> L6
                r101.recycle();
                r100.recycle();
                return;
            L6:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L10
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 41, r101, r102, 0);     // Catch: Throwable -> L10
                r102.readException();     // Catch: Throwable -> L10
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L10
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 25, r101, r102, 0);     // Catch: Throwable -> L10
                r102.readException();     // Catch: Throwable -> L10
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L10
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L10
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, r102, 0);     // Catch: Throwable -> L10
                r102.readException();     // Catch: Throwable -> L10
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = null;
            L10:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L10
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 43, r101, r102, 0);     // Catch: Throwable -> L10
                r102.readException();     // Catch: Throwable -> L10
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r101.writeInt(r100);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 44, r101, r102, 0);     // Catch: Throwable -> L6
                r102.readException();     // Catch: Throwable -> L6
                r102.recycle();
                r101.recycle();
                return;
            L6:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r101.writeLong(r100);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 24, r101, r102, 0);     // Catch: Throwable -> L6
                r102.readException();     // Catch: Throwable -> L6
                r102.recycle();
                r101.recycle();
                return;
            L6:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                boolean r103 = true;
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L13
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L13
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0);     // Catch: Throwable -> L13
                r102.readException();     // Catch: Throwable -> L13
                if (r102.readInt() != 0) goto L11;
                r103 = false;
            L11:
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r100 == false) goto L6;
                int r103 = 1;
            L7:
                r101.writeInt(r103);     // Catch: Throwable -> L10
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 46, r101, r102, 0);     // Catch: Throwable -> L10
                r102.readException();     // Catch: Throwable -> L10
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = 0;
            L10:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r101.writeInt(r100);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 39, r101, r102, 0);     // Catch: Throwable -> L6
                r102.readException();     // Catch: Throwable -> L6
                r102.recycle();
                r101.recycle();
                return;
            L6:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r101.writeInt(r100);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 48, r101, r102, 0);     // Catch: Throwable -> L6
                r102.readException();     // Catch: Throwable -> L6
                r102.recycle();
                r101.recycle();
                return;
            L6:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r100 == false) goto L6;
                int r103 = 1;
            L7:
                r101.writeInt(r103);     // Catch: Throwable -> L10
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 40, r101, r102, 0);     // Catch: Throwable -> L10
                r102.readException();     // Catch: Throwable -> L10
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = 0;
            L10:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r101.writeLong(r100);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 17, r101, r102, 0);     // Catch: Throwable -> L6
                r102.readException();     // Catch: Throwable -> L6
                r102.recycle();
                r101.recycle();
                return;
            L6:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L10
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L10
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, r102, 0);     // Catch: Throwable -> L10
                r102.readException();     // Catch: Throwable -> L10
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = null;
            L10:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat r100, int r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L10
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L10
            L7:
                r102.writeInt(r101);     // Catch: Throwable -> L10
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 42, r102, r103, 0);     // Catch: Throwable -> L10
                r103.readException();     // Catch: Throwable -> L10
                r103.recycle();
                r102.recycle();
                return;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String r100, Bundle r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r102.writeString(r100);     // Catch: Throwable -> L10
                if (r101 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L10
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r102, r103, 0);     // Catch: Throwable -> L10
                r103.readException();     // Catch: Throwable -> L10
                r103.recycle();
                r102.recycle();
                return;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String r100, Bundle r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r102.writeString(r100);     // Catch: Throwable -> L10
                if (r101 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L10
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r102, r103, 0);     // Catch: Throwable -> L10
                r103.readException();     // Catch: Throwable -> L10
                r103.recycle();
                r102.recycle();
                return;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri r100, Bundle r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L13
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L13
            L7:
                if (r101 == null) goto L9;
                r102.writeInt(1);     // Catch: Throwable -> L13
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L13
            L10:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r102, r103, 0);     // Catch: Throwable -> L13
                r103.readException();     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return;
            L9:
                r102.writeInt(0);     // Catch: Throwable -> L13
                goto L10
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String r100, Bundle r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r102.writeString(r100);     // Catch: Throwable -> L10
                if (r101 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L10
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 34, r102, r103, 0);     // Catch: Throwable -> L10
                r103.readException();     // Catch: Throwable -> L10
                r103.recycle();
                r102.recycle();
                return;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String r100, Bundle r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r102.writeString(r100);     // Catch: Throwable -> L10
                if (r101 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L10
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 35, r102, r103, 0);     // Catch: Throwable -> L10
                r103.readException();     // Catch: Throwable -> L10
                r103.recycle();
                r102.recycle();
                return;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri r100, Bundle r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L13
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L13
            L7:
                if (r101 == null) goto L9;
                r102.writeInt(1);     // Catch: Throwable -> L13
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L13
            L10:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 36, r102, r103, 0);     // Catch: Throwable -> L13
                r103.readException();     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return;
            L9:
                r102.writeInt(0);     // Catch: Throwable -> L13
                goto L10
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat r100, Bundle r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L13
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L13
            L7:
                if (r101 == null) goto L9;
                r102.writeInt(1);     // Catch: Throwable -> L13
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L13
            L10:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 51, r102, r103, 0);     // Catch: Throwable -> L13
                r103.readException();     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return;
            L9:
                r102.writeInt(0);     // Catch: Throwable -> L13
                goto L10
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String r100, Bundle r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r102.writeString(r100);     // Catch: Throwable -> L10
                if (r101 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L10
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 26, r102, r103, 0);     // Catch: Throwable -> L10
                r103.readException();     // Catch: Throwable -> L10
                r103.recycle();
                r102.recycle();
                return;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int r100, int r101, String r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r103.writeInt(r100);     // Catch: Throwable -> L6
                r103.writeInt(r101);     // Catch: Throwable -> L6
                r103.writeString(r102);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r103, r104, 0);     // Catch: Throwable -> L6
                r104.readException();     // Catch: Throwable -> L6
                r104.recycle();
                r103.recycle();
                return;
            L6:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(String r100, Bundle r101, MediaSessionCompat.ResultReceiverWrapper r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r103.writeString(r100);     // Catch: Throwable -> L13
                if (r101 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L13
                r101.writeToParcel(r103, 0);     // Catch: Throwable -> L13
            L7:
                if (r102 == null) goto L9;
                r103.writeInt(1);     // Catch: Throwable -> L13
                r102.writeToParcel(r103, 0);     // Catch: Throwable -> L13
            L10:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r103, r104, 0);     // Catch: Throwable -> L13
                r104.readException();     // Catch: Throwable -> L13
                r104.recycle();
                r103.recycle();
                return;
            L9:
                r103.writeInt(0);     // Catch: Throwable -> L13
                goto L10
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int r100, int r101, String r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r103.writeInt(r100);     // Catch: Throwable -> L6
                r103.writeInt(r101);     // Catch: Throwable -> L6
                r103.writeString(r102);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r103, r104, 0);     // Catch: Throwable -> L6
                r104.readException();     // Catch: Throwable -> L6
                r104.recycle();
                r103.recycle();
                return;
            L6:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
                if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
                long r100 = SystemClock.uptimeMillis();
                boolean r101 = r110.transact(r111, r112, r113, r114);     // Catch: Throwable -> L12
                long r102 = SystemClock.uptimeMillis() - r100;
                if (r102 < 100) goto L11;
                BinderPerformanceReporter.report(r102, r110.getClass().getName(), r111, r114, new Throwable("Slow main-thread Binder transaction"));
            L11:
                return r101;
            L12:
                th = move-exception;
                long r103 = SystemClock.uptimeMillis() - r100;
                if (r103 < 100) goto L22;
                if (r110 != null) goto L17;
                String r104 = "";
            L18:
                BinderPerformanceReporter.report(r103, r104, r111, r114, new Throwable("Slow main-thread Binder transaction"));
                throw th;
            L17:
                r104 = r110.getClass().getName();
                goto L18
            L22:
                throw th;
            L5:
                return r110.transact(r111, r112, r113, r114);
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMediaSession asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IMediaSession) == false) goto L12;
            return (IMediaSession) r101;
        L12:
            return new Proxy(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            Bundle r104 = null;
            MediaDescriptionCompat r105 = null;
            MediaDescriptionCompat r106 = null;
            MediaDescriptionCompat r107 = null;
            Bundle r108 = null;
            Bundle r109 = null;
            Bundle r110 = null;
            Bundle r111 = null;
            RatingCompat r112 = null;
            Bundle r113 = null;
            Bundle r114 = null;
            Bundle r115 = null;
            KeyEvent r116 = null;
            MediaSessionCompat.ResultReceiverWrapper r117 = null;
            if (r100 != 51) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L186;
            RatingCompat r118 = RatingCompat.CREATOR.createFromParcel(r101);
        L188:
            if (r101.readInt() == 0) goto L190;
            r104 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L190:
            rateWithExtras(r118, r104);
            r102.writeNoException();
            return true;
        L186:
            r118 = null;
            goto L188
        L5:
            if (r100 == 1598968902) goto L181;
            boolean r119 = false;
            switch(r100) {
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
            r101.enforceInterface(DESCRIPTOR);
            setShuffleMode(r101.readInt());
            r102.writeNoException();
            return true;
        L12:
            r101.enforceInterface(DESCRIPTOR);
            int r120 = getShuffleMode();
            r102.writeNoException();
            r102.writeInt(r120);
            return true;
        L14:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L17;
            r119 = true;
        L17:
            setCaptioningEnabled(r119);
            r102.writeNoException();
            return true;
        L19:
            r101.enforceInterface(DESCRIPTOR);
            boolean r121 = isCaptioningEnabled();
            r102.writeNoException();
            r102.writeInt(r121 ? 1 : 0);
            return true;
        L21:
            r101.enforceInterface(DESCRIPTOR);
            removeQueueItemAt(r101.readInt());
            r102.writeNoException();
            return true;
        L23:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L26;
            r105 = MediaDescriptionCompat.CREATOR.createFromParcel(r101);
        L26:
            removeQueueItem(r105);
            r102.writeNoException();
            return true;
        L28:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L31;
            r106 = MediaDescriptionCompat.CREATOR.createFromParcel(r101);
        L31:
            addQueueItemAt(r106, r101.readInt());
            r102.writeNoException();
            return true;
        L33:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L36;
            r107 = MediaDescriptionCompat.CREATOR.createFromParcel(r101);
        L36:
            addQueueItem(r107);
            r102.writeNoException();
            return true;
        L38:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L41;
            r119 = true;
        L41:
            setShuffleModeEnabledRemoved(r119);
            r102.writeNoException();
            return true;
        L43:
            r101.enforceInterface(DESCRIPTOR);
            setRepeatMode(r101.readInt());
            r102.writeNoException();
            return true;
        L45:
            r101.enforceInterface(DESCRIPTOR);
            boolean r122 = isShuffleModeEnabledRemoved();
            r102.writeNoException();
            r102.writeInt(r122 ? 1 : 0);
            return true;
        L47:
            r101.enforceInterface(DESCRIPTOR);
            int r123 = getRepeatMode();
            r102.writeNoException();
            r102.writeInt(r123);
            return true;
        L49:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L52;
            Uri r124 = (Uri) Uri.CREATOR.createFromParcel(r101);
        L54:
            if (r101.readInt() == 0) goto L56;
            r108 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L56:
            prepareFromUri(r124, r108);
            r102.writeNoException();
            return true;
        L52:
            r124 = null;
            goto L54
        L58:
            r101.enforceInterface(DESCRIPTOR);
            String r125 = r101.readString();
            if (r101.readInt() == 0) goto L61;
            r109 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L61:
            prepareFromSearch(r125, r109);
            r102.writeNoException();
            return true;
        L63:
            r101.enforceInterface(DESCRIPTOR);
            String r126 = r101.readString();
            if (r101.readInt() == 0) goto L66;
            r110 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L66:
            prepareFromMediaId(r126, r110);
            r102.writeNoException();
            return true;
        L68:
            r101.enforceInterface(DESCRIPTOR);
            prepare();
            r102.writeNoException();
            return true;
        L70:
            r101.enforceInterface(DESCRIPTOR);
            int r127 = getRatingType();
            r102.writeNoException();
            r102.writeInt(r127);
            return true;
        L72:
            r101.enforceInterface(DESCRIPTOR);
            Bundle r128 = getExtras();
            r102.writeNoException();
            if (r128 == null) goto L75;
            r102.writeInt(1);
            r128.writeToParcel(r102, 1);
        L76:
            return true;
        L75:
            r102.writeInt(0);
            goto L76
        L77:
            r101.enforceInterface(DESCRIPTOR);
            CharSequence r129 = getQueueTitle();
            r102.writeNoException();
            if (r129 == null) goto L80;
            r102.writeInt(1);
            TextUtils.writeToParcel(r129, r102, 1);
        L81:
            return true;
        L80:
            r102.writeInt(0);
            goto L81
        L82:
            r101.enforceInterface(DESCRIPTOR);
            List<MediaSessionCompat.QueueItem> r130 = getQueue();
            r102.writeNoException();
            r102.writeTypedList(r130);
            return true;
        L84:
            r101.enforceInterface(DESCRIPTOR);
            PlaybackStateCompat r131 = getPlaybackState();
            r102.writeNoException();
            if (r131 == null) goto L87;
            r102.writeInt(1);
            r131.writeToParcel(r102, 1);
        L88:
            return true;
        L87:
            r102.writeInt(0);
            goto L88
        L89:
            r101.enforceInterface(DESCRIPTOR);
            MediaMetadataCompat r132 = getMetadata();
            r102.writeNoException();
            if (r132 == null) goto L92;
            r102.writeInt(1);
            r132.writeToParcel(r102, 1);
        L93:
            return true;
        L92:
            r102.writeInt(0);
            goto L93
        L94:
            r101.enforceInterface(DESCRIPTOR);
            String r133 = r101.readString();
            if (r101.readInt() == 0) goto L97;
            r111 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L97:
            sendCustomAction(r133, r111);
            r102.writeNoException();
            return true;
        L99:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L102;
            r112 = RatingCompat.CREATOR.createFromParcel(r101);
        L102:
            rate(r112);
            r102.writeNoException();
            return true;
        L104:
            r101.enforceInterface(DESCRIPTOR);
            seekTo(r101.readLong());
            r102.writeNoException();
            return true;
        L106:
            r101.enforceInterface(DESCRIPTOR);
            rewind();
            r102.writeNoException();
            return true;
        L108:
            r101.enforceInterface(DESCRIPTOR);
            fastForward();
            r102.writeNoException();
            return true;
        L110:
            r101.enforceInterface(DESCRIPTOR);
            previous();
            r102.writeNoException();
            return true;
        L112:
            r101.enforceInterface(DESCRIPTOR);
            next();
            r102.writeNoException();
            return true;
        L114:
            r101.enforceInterface(DESCRIPTOR);
            stop();
            r102.writeNoException();
            return true;
        L116:
            r101.enforceInterface(DESCRIPTOR);
            pause();
            r102.writeNoException();
            return true;
        L118:
            r101.enforceInterface(DESCRIPTOR);
            skipToQueueItem(r101.readLong());
            r102.writeNoException();
            return true;
        L120:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L123;
            Uri r134 = (Uri) Uri.CREATOR.createFromParcel(r101);
        L125:
            if (r101.readInt() == 0) goto L127;
            r113 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L127:
            playFromUri(r134, r113);
            r102.writeNoException();
            return true;
        L123:
            r134 = null;
            goto L125
        L129:
            r101.enforceInterface(DESCRIPTOR);
            String r135 = r101.readString();
            if (r101.readInt() == 0) goto L132;
            r114 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L132:
            playFromSearch(r135, r114);
            r102.writeNoException();
            return true;
        L134:
            r101.enforceInterface(DESCRIPTOR);
            String r136 = r101.readString();
            if (r101.readInt() == 0) goto L137;
            r115 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L137:
            playFromMediaId(r136, r115);
            r102.writeNoException();
            return true;
        L139:
            r101.enforceInterface(DESCRIPTOR);
            play();
            r102.writeNoException();
            return true;
        L141:
            r101.enforceInterface(DESCRIPTOR);
            setVolumeTo(r101.readInt(), r101.readInt(), r101.readString());
            r102.writeNoException();
            return true;
        L143:
            r101.enforceInterface(DESCRIPTOR);
            adjustVolume(r101.readInt(), r101.readInt(), r101.readString());
            r102.writeNoException();
            return true;
        L145:
            r101.enforceInterface(DESCRIPTOR);
            ParcelableVolumeInfo r137 = getVolumeAttributes();
            r102.writeNoException();
            if (r137 == null) goto L148;
            r102.writeInt(1);
            r137.writeToParcel(r102, 1);
        L149:
            return true;
        L148:
            r102.writeInt(0);
            goto L149
        L150:
            r101.enforceInterface(DESCRIPTOR);
            long r138 = getFlags();
            r102.writeNoException();
            r102.writeLong(r138);
            return true;
        L152:
            r101.enforceInterface(DESCRIPTOR);
            PendingIntent r139 = getLaunchPendingIntent();
            r102.writeNoException();
            if (r139 == null) goto L155;
            r102.writeInt(1);
            r139.writeToParcel(r102, 1);
        L156:
            return true;
        L155:
            r102.writeInt(0);
            goto L156
        L157:
            r101.enforceInterface(DESCRIPTOR);
            String r140 = getTag();
            r102.writeNoException();
            r102.writeString(r140);
            return true;
        L159:
            r101.enforceInterface(DESCRIPTOR);
            String r141 = getPackageName();
            r102.writeNoException();
            r102.writeString(r141);
            return true;
        L161:
            r101.enforceInterface(DESCRIPTOR);
            boolean r142 = isTransportControlEnabled();
            r102.writeNoException();
            r102.writeInt(r142 ? 1 : 0);
            return true;
        L163:
            r101.enforceInterface(DESCRIPTOR);
            unregisterCallbackListener(IMediaControllerCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L165:
            r101.enforceInterface(DESCRIPTOR);
            registerCallbackListener(IMediaControllerCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L167:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L170;
            r116 = (KeyEvent) KeyEvent.CREATOR.createFromParcel(r101);
        L170:
            boolean r143 = sendMediaButton(r116);
            r102.writeNoException();
            r102.writeInt(r143 ? 1 : 0);
            return true;
        L172:
            r101.enforceInterface(DESCRIPTOR);
            String r144 = r101.readString();
            if (r101.readInt() == 0) goto L175;
            Bundle r145 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L177:
            if (r101.readInt() == 0) goto L179;
            r117 = MediaSessionCompat.ResultReceiverWrapper.CREATOR.createFromParcel(r101);
        L179:
            sendCommand(r144, r145, r117);
            r102.writeNoException();
            return true;
        L175:
            r145 = null;
            goto L177
        L9:
            return super.onTransact(r100, r101, r102, r103);
        L181:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    void addQueueItem(MediaDescriptionCompat r100) throws RemoteException;

    void addQueueItemAt(MediaDescriptionCompat r100, int r101) throws RemoteException;

    void adjustVolume(int r100, int r101, String r102) throws RemoteException;

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

    void playFromMediaId(String r100, Bundle r101) throws RemoteException;

    void playFromSearch(String r100, Bundle r101) throws RemoteException;

    void playFromUri(Uri r100, Bundle r101) throws RemoteException;

    void prepare() throws RemoteException;

    void prepareFromMediaId(String r100, Bundle r101) throws RemoteException;

    void prepareFromSearch(String r100, Bundle r101) throws RemoteException;

    void prepareFromUri(Uri r100, Bundle r101) throws RemoteException;

    void previous() throws RemoteException;

    void rate(RatingCompat r100) throws RemoteException;

    void rateWithExtras(RatingCompat r100, Bundle r101) throws RemoteException;

    void registerCallbackListener(IMediaControllerCallback r100) throws RemoteException;

    void removeQueueItem(MediaDescriptionCompat r100) throws RemoteException;

    void removeQueueItemAt(int r100) throws RemoteException;

    void rewind() throws RemoteException;

    void seekTo(long r100) throws RemoteException;

    void sendCommand(String r100, Bundle r101, MediaSessionCompat.ResultReceiverWrapper r102) throws RemoteException;

    void sendCustomAction(String r100, Bundle r101) throws RemoteException;

    boolean sendMediaButton(KeyEvent r100) throws RemoteException;

    void setCaptioningEnabled(boolean r100) throws RemoteException;

    void setRepeatMode(int r100) throws RemoteException;

    void setShuffleMode(int r100) throws RemoteException;

    void setShuffleModeEnabledRemoved(boolean r100) throws RemoteException;

    void setVolumeTo(int r100, int r101, String r102) throws RemoteException;

    void skipToQueueItem(long r100) throws RemoteException;

    void stop() throws RemoteException;

    void unregisterCallbackListener(IMediaControllerCallback r100) throws RemoteException;
}
