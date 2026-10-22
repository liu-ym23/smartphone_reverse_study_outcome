package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        private static class Proxy implements IMediaSession {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(String r4, Bundle r5, MediaSessionCompat.ResultReceiverWrapper r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r4);     // Catch: Throwable -> L13
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L7:
                if (r6 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L10:
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L13
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L13
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                boolean r2 = true;
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L7:
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L13
                r1.readException();     // Catch: Throwable -> L13
                if (r1.readInt() != 0) goto L11;
                r2 = false;
            L11:
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback r4) {
                IMediaControllerCallback r5 = (IMediaControllerCallback) ZeusTransformUtils.wrapperContextForParams(r4, IMediaControllerCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                IBinder r6 = r5.asBinder();     // Catch: Throwable -> L10
            L7:
                r0.writeStrongBinder(r6);     // Catch: Throwable -> L10
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r6 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback r4) {
                IMediaControllerCallback r5 = (IMediaControllerCallback) ZeusTransformUtils.wrapperContextForParams(r4, IMediaControllerCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                IBinder r6 = r5.asBinder();     // Catch: Throwable -> L10
            L7:
                r0.writeStrongBinder(r6);     // Catch: Throwable -> L10
                this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r6 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r3 = false;
                this.mRemote.transact(5, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r3 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r3;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getPackageName() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(6, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                String r4 = r1.readString();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getTag() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(7, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                String r4 = r1.readString();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                this.mRemote.transact(8, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L7;
                PendingIntent r4 = (PendingIntent) ZeusTransformUtils.preCheckCast(PendingIntent.CREATOR.createFromParcel(r1), PendingIntent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L7:
                r4 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long getFlags() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(9, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                long r2 = r1.readLong();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                this.mRemote.transact(10, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L7;
                ParcelableVolumeInfo r4 = (ParcelableVolumeInfo) ZeusTransformUtils.preCheckCast(ParcelableVolumeInfo.CREATOR.createFromParcel(r1), ParcelableVolumeInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L7:
                r4 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int r4, int r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                this.mRemote.transact(11, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int r4, int r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                this.mRemote.transact(12, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                this.mRemote.transact(27, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L7;
                MediaMetadataCompat r4 = (MediaMetadataCompat) ZeusTransformUtils.preCheckCast(MediaMetadataCompat.CREATOR.createFromParcel(r1), MediaMetadataCompat.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L7:
                r4 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                this.mRemote.transact(28, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L7;
                PlaybackStateCompat r4 = (PlaybackStateCompat) ZeusTransformUtils.preCheckCast(PlaybackStateCompat.CREATOR.createFromParcel(r1), PlaybackStateCompat.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L7:
                r4 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public List<MediaSessionCompat.QueueItem> getQueue() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(29, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                ArrayList r4 = r1.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public CharSequence getQueueTitle() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                this.mRemote.transact(30, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L7;
                CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r1), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L7:
                r4 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                this.mRemote.transact(31, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L7;
                Bundle r4 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r1), Bundle.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L7:
                r4 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRatingType() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(32, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r4 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r3 = false;
                this.mRemote.transact(45, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r3 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r3;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(37, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r4 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r3 = false;
                this.mRemote.transact(38, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r3 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r3;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(47, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r4 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.mRemote.transact(41, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat r5, int r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                r0.writeInt(r6);     // Catch: Throwable -> L10
                this.mRemote.transact(42, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.mRemote.transact(43, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(44, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(33, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String r4, Bundle r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r0.writeString(r4);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.mRemote.transact(34, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String r4, Bundle r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r0.writeString(r4);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.mRemote.transact(35, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri r5, Bundle r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L7:
                if (r6 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L10:
                this.mRemote.transact(36, r0, r1, 0);     // Catch: Throwable -> L13
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L13
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void play() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(13, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String r4, Bundle r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r0.writeString(r4);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.mRemote.transact(14, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String r4, Bundle r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r0.writeString(r4);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.mRemote.transact(15, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri r5, Bundle r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L7:
                if (r6 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L10:
                this.mRemote.transact(16, r0, r1, 0);     // Catch: Throwable -> L13
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L13
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeLong(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(17, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(18, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(19, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(20, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(21, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void fastForward() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(22, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(23, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeLong(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(24, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.mRemote.transact(25, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat r5, Bundle r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L7:
                if (r6 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L10:
                this.mRemote.transact(51, r0, r1, 0);     // Catch: Throwable -> L13
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L13
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r4 == false) goto L6;
                int r5 = 1;
            L7:
                r0.writeInt(r5);     // Catch: Throwable -> L10
                this.mRemote.transact(46, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r5 = 0;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(39, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r4 == false) goto L6;
                int r5 = 1;
            L7:
                r0.writeInt(r5);     // Catch: Throwable -> L10
                this.mRemote.transact(40, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r5 = 0;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(48, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String r4, Bundle r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r0.writeString(r4);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.mRemote.transact(26, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMediaSession asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IMediaSession.class) == false) goto L13;
            return (IMediaSession) ZeusTransformUtils.preCheckCast(r0, IMediaSession.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r6, Parcel r7, Parcel r8, int r9) {
            Bundle r2 = null;
            MediaDescriptionCompat r3 = null;
            MediaDescriptionCompat r4 = null;
            MediaDescriptionCompat r5 = null;
            Bundle r10 = null;
            Bundle r11 = null;
            Bundle r12 = null;
            Bundle r13 = null;
            RatingCompat r14 = null;
            Bundle r15 = null;
            Bundle r16 = null;
            Bundle r17 = null;
            KeyEvent r18 = null;
            MediaSessionCompat.ResultReceiverWrapper r19 = null;
            if (r6 != 51) goto L5;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L186;
            RatingCompat r20 = (RatingCompat) ZeusTransformUtils.preCheckCast(RatingCompat.CREATOR.createFromParcel(r7), RatingCompat.class, "com.obric.aiagent.plugin");
        L188:
            if (r7.readInt() == 0) goto L190;
            r2 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.aiagent.plugin");
        L190:
            rateWithExtras(r20, r2);
            r8.writeNoException();
            return true;
        L186:
            r20 = null;
            goto L188
        L5:
            if (r6 == 1598968902) goto L181;
            boolean r0 = false;
            switch(r6) {
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
            r7.enforceInterface(DESCRIPTOR);
            setShuffleMode(r7.readInt());
            r8.writeNoException();
            return true;
        L12:
            r7.enforceInterface(DESCRIPTOR);
            int r21 = getShuffleMode();
            r8.writeNoException();
            r8.writeInt(r21);
            return true;
        L14:
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L17;
            r0 = true;
        L17:
            setCaptioningEnabled(r0);
            r8.writeNoException();
            return true;
        L19:
            r7.enforceInterface(DESCRIPTOR);
            boolean r22 = isCaptioningEnabled();
            r8.writeNoException();
            r8.writeInt(r22 ? 1 : 0);
            return true;
        L21:
            r7.enforceInterface(DESCRIPTOR);
            removeQueueItemAt(r7.readInt());
            r8.writeNoException();
            return true;
        L23:
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L26;
            r3 = (MediaDescriptionCompat) ZeusTransformUtils.preCheckCast(MediaDescriptionCompat.CREATOR.createFromParcel(r7), MediaDescriptionCompat.class, "com.obric.aiagent.plugin");
        L26:
            removeQueueItem(r3);
            r8.writeNoException();
            return true;
        L28:
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L31;
            r4 = (MediaDescriptionCompat) ZeusTransformUtils.preCheckCast(MediaDescriptionCompat.CREATOR.createFromParcel(r7), MediaDescriptionCompat.class, "com.obric.aiagent.plugin");
        L31:
            addQueueItemAt(r4, r7.readInt());
            r8.writeNoException();
            return true;
        L33:
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L36;
            r5 = (MediaDescriptionCompat) ZeusTransformUtils.preCheckCast(MediaDescriptionCompat.CREATOR.createFromParcel(r7), MediaDescriptionCompat.class, "com.obric.aiagent.plugin");
        L36:
            addQueueItem(r5);
            r8.writeNoException();
            return true;
        L38:
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L41;
            r0 = true;
        L41:
            setShuffleModeEnabledRemoved(r0);
            r8.writeNoException();
            return true;
        L43:
            r7.enforceInterface(DESCRIPTOR);
            setRepeatMode(r7.readInt());
            r8.writeNoException();
            return true;
        L45:
            r7.enforceInterface(DESCRIPTOR);
            boolean r23 = isShuffleModeEnabledRemoved();
            r8.writeNoException();
            r8.writeInt(r23 ? 1 : 0);
            return true;
        L47:
            r7.enforceInterface(DESCRIPTOR);
            int r24 = getRepeatMode();
            r8.writeNoException();
            r8.writeInt(r24);
            return true;
        L49:
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L52;
            Uri r25 = (Uri) ZeusTransformUtils.preCheckCast(Uri.CREATOR.createFromParcel(r7), Uri.class, "com.obric.aiagent.plugin");
        L54:
            if (r7.readInt() == 0) goto L56;
            r10 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.aiagent.plugin");
        L56:
            prepareFromUri(r25, r10);
            r8.writeNoException();
            return true;
        L52:
            r25 = null;
            goto L54
        L58:
            r7.enforceInterface(DESCRIPTOR);
            String r26 = r7.readString();
            if (r7.readInt() == 0) goto L61;
            r11 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.aiagent.plugin");
        L61:
            prepareFromSearch(r26, r11);
            r8.writeNoException();
            return true;
        L63:
            r7.enforceInterface(DESCRIPTOR);
            String r27 = r7.readString();
            if (r7.readInt() == 0) goto L66;
            r12 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.aiagent.plugin");
        L66:
            prepareFromMediaId(r27, r12);
            r8.writeNoException();
            return true;
        L68:
            r7.enforceInterface(DESCRIPTOR);
            prepare();
            r8.writeNoException();
            return true;
        L70:
            r7.enforceInterface(DESCRIPTOR);
            int r28 = getRatingType();
            r8.writeNoException();
            r8.writeInt(r28);
            return true;
        L72:
            r7.enforceInterface(DESCRIPTOR);
            Bundle r29 = getExtras();
            r8.writeNoException();
            if (r29 == null) goto L75;
            r8.writeInt(1);
            r29.writeToParcel(r8, 1);
        L76:
            return true;
        L75:
            r8.writeInt(0);
            goto L76
        L77:
            r7.enforceInterface(DESCRIPTOR);
            CharSequence r30 = getQueueTitle();
            r8.writeNoException();
            if (r30 == null) goto L80;
            r8.writeInt(1);
            TextUtils.writeToParcel(r30, r8, 1);
        L81:
            return true;
        L80:
            r8.writeInt(0);
            goto L81
        L82:
            r7.enforceInterface(DESCRIPTOR);
            List<MediaSessionCompat.QueueItem> r31 = getQueue();
            r8.writeNoException();
            r8.writeTypedList(r31);
            return true;
        L84:
            r7.enforceInterface(DESCRIPTOR);
            PlaybackStateCompat r32 = getPlaybackState();
            r8.writeNoException();
            if (r32 == null) goto L87;
            r8.writeInt(1);
            r32.writeToParcel(r8, 1);
        L88:
            return true;
        L87:
            r8.writeInt(0);
            goto L88
        L89:
            r7.enforceInterface(DESCRIPTOR);
            MediaMetadataCompat r33 = getMetadata();
            r8.writeNoException();
            if (r33 == null) goto L92;
            r8.writeInt(1);
            r33.writeToParcel(r8, 1);
        L93:
            return true;
        L92:
            r8.writeInt(0);
            goto L93
        L94:
            r7.enforceInterface(DESCRIPTOR);
            String r34 = r7.readString();
            if (r7.readInt() == 0) goto L97;
            r13 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.aiagent.plugin");
        L97:
            sendCustomAction(r34, r13);
            r8.writeNoException();
            return true;
        L99:
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L102;
            r14 = (RatingCompat) ZeusTransformUtils.preCheckCast(RatingCompat.CREATOR.createFromParcel(r7), RatingCompat.class, "com.obric.aiagent.plugin");
        L102:
            rate(r14);
            r8.writeNoException();
            return true;
        L104:
            r7.enforceInterface(DESCRIPTOR);
            seekTo(r7.readLong());
            r8.writeNoException();
            return true;
        L106:
            r7.enforceInterface(DESCRIPTOR);
            rewind();
            r8.writeNoException();
            return true;
        L108:
            r7.enforceInterface(DESCRIPTOR);
            fastForward();
            r8.writeNoException();
            return true;
        L110:
            r7.enforceInterface(DESCRIPTOR);
            previous();
            r8.writeNoException();
            return true;
        L112:
            r7.enforceInterface(DESCRIPTOR);
            next();
            r8.writeNoException();
            return true;
        L114:
            r7.enforceInterface(DESCRIPTOR);
            stop();
            r8.writeNoException();
            return true;
        L116:
            r7.enforceInterface(DESCRIPTOR);
            pause();
            r8.writeNoException();
            return true;
        L118:
            r7.enforceInterface(DESCRIPTOR);
            skipToQueueItem(r7.readLong());
            r8.writeNoException();
            return true;
        L120:
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L123;
            Uri r35 = (Uri) ZeusTransformUtils.preCheckCast(Uri.CREATOR.createFromParcel(r7), Uri.class, "com.obric.aiagent.plugin");
        L125:
            if (r7.readInt() == 0) goto L127;
            r15 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.aiagent.plugin");
        L127:
            playFromUri(r35, r15);
            r8.writeNoException();
            return true;
        L123:
            r35 = null;
            goto L125
        L129:
            r7.enforceInterface(DESCRIPTOR);
            String r36 = r7.readString();
            if (r7.readInt() == 0) goto L132;
            r16 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.aiagent.plugin");
        L132:
            playFromSearch(r36, r16);
            r8.writeNoException();
            return true;
        L134:
            r7.enforceInterface(DESCRIPTOR);
            String r37 = r7.readString();
            if (r7.readInt() == 0) goto L137;
            r17 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.aiagent.plugin");
        L137:
            playFromMediaId(r37, r17);
            r8.writeNoException();
            return true;
        L139:
            r7.enforceInterface(DESCRIPTOR);
            play();
            r8.writeNoException();
            return true;
        L141:
            r7.enforceInterface(DESCRIPTOR);
            setVolumeTo(r7.readInt(), r7.readInt(), r7.readString());
            r8.writeNoException();
            return true;
        L143:
            r7.enforceInterface(DESCRIPTOR);
            adjustVolume(r7.readInt(), r7.readInt(), r7.readString());
            r8.writeNoException();
            return true;
        L145:
            r7.enforceInterface(DESCRIPTOR);
            ParcelableVolumeInfo r38 = getVolumeAttributes();
            r8.writeNoException();
            if (r38 == null) goto L148;
            r8.writeInt(1);
            r38.writeToParcel(r8, 1);
        L149:
            return true;
        L148:
            r8.writeInt(0);
            goto L149
        L150:
            r7.enforceInterface(DESCRIPTOR);
            long r39 = getFlags();
            r8.writeNoException();
            r8.writeLong(r39);
            return true;
        L152:
            r7.enforceInterface(DESCRIPTOR);
            PendingIntent r40 = getLaunchPendingIntent();
            r8.writeNoException();
            if (r40 == null) goto L155;
            r8.writeInt(1);
            r40.writeToParcel(r8, 1);
        L156:
            return true;
        L155:
            r8.writeInt(0);
            goto L156
        L157:
            r7.enforceInterface(DESCRIPTOR);
            String r41 = getTag();
            r8.writeNoException();
            r8.writeString(r41);
            return true;
        L159:
            r7.enforceInterface(DESCRIPTOR);
            String r42 = getPackageName();
            r8.writeNoException();
            r8.writeString(r42);
            return true;
        L161:
            r7.enforceInterface(DESCRIPTOR);
            boolean r43 = isTransportControlEnabled();
            r8.writeNoException();
            r8.writeInt(r43 ? 1 : 0);
            return true;
        L163:
            r7.enforceInterface(DESCRIPTOR);
            unregisterCallbackListener(IMediaControllerCallback.Stub.asInterface(r7.readStrongBinder()));
            r8.writeNoException();
            return true;
        L165:
            r7.enforceInterface(DESCRIPTOR);
            registerCallbackListener(IMediaControllerCallback.Stub.asInterface(r7.readStrongBinder()));
            r8.writeNoException();
            return true;
        L167:
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L170;
            r18 = (KeyEvent) ZeusTransformUtils.preCheckCast(KeyEvent.CREATOR.createFromParcel(r7), KeyEvent.class, "com.obric.aiagent.plugin");
        L170:
            boolean r44 = sendMediaButton(r18);
            r8.writeNoException();
            r8.writeInt(r44 ? 1 : 0);
            return true;
        L172:
            r7.enforceInterface(DESCRIPTOR);
            String r45 = r7.readString();
            if (r7.readInt() == 0) goto L175;
            Bundle r46 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.aiagent.plugin");
        L177:
            if (r7.readInt() == 0) goto L179;
            r19 = (MediaSessionCompat.ResultReceiverWrapper) ZeusTransformUtils.preCheckCast(MediaSessionCompat.ResultReceiverWrapper.CREATOR.createFromParcel(r7), MediaSessionCompat.ResultReceiverWrapper.class, "com.obric.aiagent.plugin");
        L179:
            sendCommand(r45, r46, r19);
            r8.writeNoException();
            return true;
        L175:
            r46 = null;
            goto L177
        L9:
            return super.onTransact(r6, r7, r8, r9);
        L181:
            r8.writeString(DESCRIPTOR);
            return true;
        }
    }

    void addQueueItem(MediaDescriptionCompat r1);

    void addQueueItemAt(MediaDescriptionCompat r1, int r2);

    void adjustVolume(int r1, int r2, String r3);

    void fastForward();

    Bundle getExtras();

    long getFlags();

    PendingIntent getLaunchPendingIntent();

    MediaMetadataCompat getMetadata();

    String getPackageName();

    PlaybackStateCompat getPlaybackState();

    List<MediaSessionCompat.QueueItem> getQueue();

    CharSequence getQueueTitle();

    int getRatingType();

    int getRepeatMode();

    int getShuffleMode();

    String getTag();

    ParcelableVolumeInfo getVolumeAttributes();

    boolean isCaptioningEnabled();

    boolean isShuffleModeEnabledRemoved();

    boolean isTransportControlEnabled();

    void next();

    void pause();

    void play();

    void playFromMediaId(String r1, Bundle r2);

    void playFromSearch(String r1, Bundle r2);

    void playFromUri(Uri r1, Bundle r2);

    void prepare();

    void prepareFromMediaId(String r1, Bundle r2);

    void prepareFromSearch(String r1, Bundle r2);

    void prepareFromUri(Uri r1, Bundle r2);

    void previous();

    void rate(RatingCompat r1);

    void rateWithExtras(RatingCompat r1, Bundle r2);

    void registerCallbackListener(IMediaControllerCallback r1);

    void removeQueueItem(MediaDescriptionCompat r1);

    void removeQueueItemAt(int r1);

    void rewind();

    void seekTo(long r1);

    void sendCommand(String r1, Bundle r2, MediaSessionCompat.ResultReceiverWrapper r3);

    void sendCustomAction(String r1, Bundle r2);

    boolean sendMediaButton(KeyEvent r1);

    void setCaptioningEnabled(boolean r1);

    void setRepeatMode(int r1);

    void setShuffleMode(int r1);

    void setShuffleModeEnabledRemoved(boolean r1);

    void setVolumeTo(int r1, int r2, String r3);

    void skipToQueueItem(long r1);

    void stop();

    void unregisterCallbackListener(IMediaControllerCallback r1);
}
