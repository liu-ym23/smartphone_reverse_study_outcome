package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
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

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r100, null, 1);     // Catch: Throwable -> L6
                r100.recycle();
                return;
            L6:
                th = move-exception;
                r100.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionReady() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r100, null, 1);     // Catch: Throwable -> L6
                r100.recycle();
                return;
            L6:
                th = move-exception;
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

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onCaptioningEnabledChanged(boolean r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r100 == false) goto L6;
                int r102 = 1;
            L7:
                r101.writeInt(r102);     // Catch: Throwable -> L10
                INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r101, null, 1);     // Catch: Throwable -> L10
                r101.recycle();
                return;
            L6:
                r102 = 0;
            L10:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L10
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r101, null, 1);     // Catch: Throwable -> L10
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L10
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, null, 1);     // Catch: Throwable -> L10
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onPlaybackStateChanged(PlaybackStateCompat r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L10
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, null, 1);     // Catch: Throwable -> L10
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List<MediaSessionCompat.QueueItem> r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r101.writeTypedList(r100);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, null, 1);     // Catch: Throwable -> L6
                r101.recycle();
                return;
            L6:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L10
                TextUtils.writeToParcel(r100, r101, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r101, null, 1);     // Catch: Throwable -> L10
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onRepeatModeChanged(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r101.writeInt(r100);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r101, null, 1);     // Catch: Throwable -> L6
                r101.recycle();
                return;
            L6:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChanged(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r101.writeInt(r100);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r101, null, 1);     // Catch: Throwable -> L6
                r101.recycle();
                return;
            L6:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChangedRemoved(boolean r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r100 == false) goto L6;
                int r102 = 1;
            L7:
                r101.writeInt(r102);     // Catch: Throwable -> L10
                INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r101, null, 1);     // Catch: Throwable -> L10
                r101.recycle();
                return;
            L6:
                r102 = 0;
            L10:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L10
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r101, null, 1);     // Catch: Throwable -> L10
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onEvent(String r100, Bundle r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r102.writeString(r100);     // Catch: Throwable -> L10
                if (r101 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L10
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, null, 1);     // Catch: Throwable -> L10
                r102.recycle();
                return;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IMediaControllerCallback asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IMediaControllerCallback) == false) goto L12;
            return (IMediaControllerCallback) r101;
        L12:
            return new Proxy(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 == 1598968902) goto L58;
            boolean r104 = false;
            Bundle r105 = null;
            ParcelableVolumeInfo r106 = null;
            Bundle r107 = null;
            CharSequence r108 = null;
            MediaMetadataCompat r109 = null;
            PlaybackStateCompat r110 = null;
            switch(r100) {
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
            r101.enforceInterface(DESCRIPTOR);
            onSessionReady();
            return true;
        L10:
            r101.enforceInterface(DESCRIPTOR);
            onShuffleModeChanged(r101.readInt());
            return true;
        L12:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L15;
            r104 = true;
        L15:
            onCaptioningEnabledChanged(r104);
            return true;
        L17:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L20;
            r104 = true;
        L20:
            onShuffleModeChangedRemoved(r104);
            return true;
        L22:
            r101.enforceInterface(DESCRIPTOR);
            onRepeatModeChanged(r101.readInt());
            return true;
        L24:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L27;
            r106 = ParcelableVolumeInfo.CREATOR.createFromParcel(r101);
        L27:
            onVolumeInfoChanged(r106);
            return true;
        L29:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L32;
            r107 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L32:
            onExtrasChanged(r107);
            return true;
        L34:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L37;
            r108 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r101);
        L37:
            onQueueTitleChanged(r108);
            return true;
        L39:
            r101.enforceInterface(DESCRIPTOR);
            onQueueChanged(r101.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
            return true;
        L41:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L44;
            r109 = MediaMetadataCompat.CREATOR.createFromParcel(r101);
        L44:
            onMetadataChanged(r109);
            return true;
        L46:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L49;
            r110 = PlaybackStateCompat.CREATOR.createFromParcel(r101);
        L49:
            onPlaybackStateChanged(r110);
            return true;
        L51:
            r101.enforceInterface(DESCRIPTOR);
            onSessionDestroyed();
            return true;
        L53:
            r101.enforceInterface(DESCRIPTOR);
            String r111 = r101.readString();
            if (r101.readInt() == 0) goto L56;
            r105 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L56:
            onEvent(r111, r105);
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        L58:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    void onCaptioningEnabledChanged(boolean r100) throws RemoteException;

    void onEvent(String r100, Bundle r101) throws RemoteException;

    void onExtrasChanged(Bundle r100) throws RemoteException;

    void onMetadataChanged(MediaMetadataCompat r100) throws RemoteException;

    void onPlaybackStateChanged(PlaybackStateCompat r100) throws RemoteException;

    void onQueueChanged(List<MediaSessionCompat.QueueItem> r100) throws RemoteException;

    void onQueueTitleChanged(CharSequence r100) throws RemoteException;

    void onRepeatModeChanged(int r100) throws RemoteException;

    void onSessionDestroyed() throws RemoteException;

    void onSessionReady() throws RemoteException;

    void onShuffleModeChanged(int r100) throws RemoteException;

    void onShuffleModeChangedRemoved(boolean r100) throws RemoteException;

    void onVolumeInfoChanged(ParcelableVolumeInfo r100) throws RemoteException;
}
